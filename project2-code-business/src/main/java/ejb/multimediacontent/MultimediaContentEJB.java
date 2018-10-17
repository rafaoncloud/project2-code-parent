package ejb.multimediacontent;

import data.EMultimediaContentCategory;
import dto.MultimediaContent;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MultimediaContentEJB implements IMultimediaContentRemote, IMultimediaContentLocal {

    public MultimediaContentEJB(){ }

    @Override
    public void addMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception {

    }

    @Override
    public MultimediaContent getMultimediaContent(String token, long id) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContent(String token, boolean ascend) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContentFromCategory(String token, dto.EMultimediaContentCategory category, boolean ascend) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContentFromDirector(String token, String directorName, boolean ascend) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContentBetweenYearsRange(String token, int minYear, int maxYear, boolean ascend) throws Exception {
        return null;
    }

    @Override
    public void updateMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception {

    }

    @Override
    public void deleteMultimediaContent(String token, long id) throws Exception {

    }
}
