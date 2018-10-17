package ejb.multimediacontent;


import dto.EMultimediaContentCategory;
import dto.MultimediaContent;

import java.util.List;

public interface IMultimediaContent {

    // Create
    void addMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception;
    // Retrieve
    MultimediaContent getMultimediaContent(String token, long id) throws Exception;
    List<MultimediaContent> getMultimediaContent(String token, boolean ascend) throws Exception;
    List<MultimediaContent> getMultimediaContentFromCategory(String token, EMultimediaContentCategory category, boolean ascend) throws Exception;
    List<MultimediaContent> getMultimediaContentFromDirector(String token, String directorName, boolean ascend) throws Exception;
    List<MultimediaContent> getMultimediaContentBetweenYearsRange(String token, int minYear, int maxYear, boolean ascend) throws Exception;
    // Update
    void updateMultimediaContent(String token, MultimediaContent multimediaContent) throws Exception;
    // Delete
    void deleteMultimediaContent(String token, long id) throws Exception;
}
