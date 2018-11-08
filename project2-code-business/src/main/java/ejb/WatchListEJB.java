package ejb;

import data.MultimediaContent;
import dto.GenericUser;
import dto.User;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class WatchListEJB {

    @PersistenceContext
    private EntityManager em;

    @Inject
    GenericUserEJB genericUserEJB;

    public void addContentToWatchList(String token, long multimediaContentId, long userId) throws Exception {
        try {
            if (!genericUserEJB.isTokenValid(token))
                throw new Exception("Authentication Fail.");

            data.MultimediaContent content = em.find(data.MultimediaContent.class, multimediaContentId);
            data.User user = em.find(data.User.class, userId);
            if (content == null || user == null)
                throw new Exception("Content or User is null.");

            addToWatchListCRUD(token, content, user);
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public List<dto.MultimediaContent> getWatchList(String token, long userId) throws Exception {
        try {
            if (!genericUserEJB.isTokenValid(token))
                throw new Exception("Authentication Fail.");

            data.User userEntity = em.find(data.User.class, userId);

            List<dto.MultimediaContent> multimediaContents = new ArrayList<>();

            for (data.MultimediaContent content : userEntity.getWatchList()) {
                dto.MultimediaContent aux = new dto.MultimediaContent();
                Utils.getDozerBeanMapper().map(content, aux);
                multimediaContents.add(aux);
            }

            return multimediaContents;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    public void removeContentFromWatchList(String token, long multimediaContentId, long userId) throws Exception {
        try {
            if (!genericUserEJB.isTokenValid(token))
                throw new Exception("Authentication Fail.");

            data.MultimediaContent content = em.find(data.MultimediaContent.class, multimediaContentId);
            data.User user = em.find(data.User.class, userId);
            if (content == null || user == null)
                throw new Exception("Content or User is null.");

            removeFromWatchListCRUD(token,content,user);

        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private void addToWatchListCRUD(String token, data.MultimediaContent content, data.User user) throws Exception {
        try {

            if (user.addContentToWatchList(content))
                return;
            else
                throw new Exception("Multimedia Content ID " + content.getId() + " already in the Watch List.");

        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }

    private void removeFromWatchListCRUD(String token, data.MultimediaContent content, data.User user) throws Exception {
        try {

            if (user.removeMultimediaContentFromUserWatchList(content.getId()))
                return;
            else
                throw new Exception("Multimedia Content ID " + content.getId() + " not in the Watch List");

        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
}
