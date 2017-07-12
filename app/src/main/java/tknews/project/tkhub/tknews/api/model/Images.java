package tknews.project.tkhub.tknews.api.model;

/**
 * Created by Himanshu on 6/12/2017.
 */

public class Images {

   String imageNewsID,imgUrl;

    public Images() {
    }

    public Images(String imageNewsID, String imgUrl) {
        this.imageNewsID = imageNewsID;
        this.imgUrl = imgUrl;
    }


    public String getImageNewsID() {
        return imageNewsID;
    }

    public void setImageNewsID(String imageNewsID) {
        this.imageNewsID = imageNewsID;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
