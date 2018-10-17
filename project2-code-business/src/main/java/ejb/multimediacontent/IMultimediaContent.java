package ejb.multimediacontent;

import data.EMultimediaContentCategory;
import data.MultimediaContent;

import java.util.List;

public interface IMultimediaContent {

    // Create
    void addMultimediaContent(String token, data.MultimediaContent multimediaContent);
    // Retrieve
    MultimediaContent getMultimediaContent(String token, long id) throws Exception;
    List<MultimediaContent> getMultimediaContent(String token) throws Exception;
    List<MultimediaContent> getMultimediaContent(String token, EMultimediaContentCategory category) throws Exception;
    List<MultimediaContent> getMultimediaContent(String token, String directorName) throws Exception;
    List<MultimediaContent> getMultimediaContent(String token, int minYear, int maxYear) throws Exception;
    // Update
    void updateMultimediaContent(String token, data.MultimediaContent multimediaContent) throws Exception;
    // Delete
    void deleteMultimediaContent(String token, long id) throws Exception;
}
