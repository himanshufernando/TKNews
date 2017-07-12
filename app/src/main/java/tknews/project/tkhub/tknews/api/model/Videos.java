package tknews.project.tkhub.tknews.api.model;

/**
 * Created by Himanshu on 6/12/2017.
 */

public class Videos {

   String videosNewsID,videosUrl;

    public Videos() {
    }

    public Videos(String videosUrl) {
        this.videosUrl = videosUrl;
    }

    public Videos(String videosNewsID, String videosUrl) {
        this.videosNewsID = videosNewsID;
        this.videosUrl = videosUrl;
    }

    public String getVideosNewsID() {
        return videosNewsID;
    }

    public void setVideosNewsID(String videosNewsID) {
        this.videosNewsID = videosNewsID;
    }

    public String getVideosUrl() {
        return videosUrl;
    }

    public void setVideosUrl(String videosUrl) {
        this.videosUrl = videosUrl;
    }
}
