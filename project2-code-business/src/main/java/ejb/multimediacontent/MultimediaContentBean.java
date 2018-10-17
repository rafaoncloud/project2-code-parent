package ejb.multimediacontent;

import data.EMultimediaContentCategory;
import data.MultimediaContent;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class MultimediaContentBean implements IMultimediaContentRemote, IMultimediaContentLocal {

    public MultimediaContentBean(){ }

    @Override
    public void addMultimediaContent(String token, data.MultimediaContent multimediaContent) {

    }

    @Override
    public MultimediaContent getMultimediaContent(String token, long id) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContent(String token) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContent(String token, EMultimediaContentCategory category) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContent(String token, String directorName) throws Exception {
        return null;
    }

    @Override
    public List<MultimediaContent> getMultimediaContent(String token, int minYear, int maxYear) throws Exception {
        return null;
    }

    @Override
    public void updateMultimediaContent(String token, data.MultimediaContent multimediaContent) throws Exception {

    }

    @Override
    public void deleteMultimediaContent(String token, long id) throws Exception {

    }
}
