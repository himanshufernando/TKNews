package tknews.project.tkhub.tknews.api.model;

import java.io.Serializable;

/**
 * Created by Himanshu on 5/23/2017.
 */

public class News implements Serializable {

    public String newsID,newsTitelEnglish,newsTitelSinhala,newsContentEnglish,newsContentSinhala,newsResourceID,newsDate,newsLikeCount,newsCoverImage;
    public int languageStatus,newsStatus;
    public News() {
    }

    public News(String newsID, String newsTitelEnglish, String newsTitelSinhala, String newsContentEnglish, String newsContentSinhala, String newsResourceID, String newsDate, String newsLikeCount, String newsCoverImage,int languageStatus,int newsStatus) {
        this.newsID = newsID;
        this.newsTitelEnglish = newsTitelEnglish;
        this.newsTitelSinhala = newsTitelSinhala;
        this.newsContentEnglish = newsContentEnglish;
        this.newsContentSinhala = newsContentSinhala;
        this.newsResourceID = newsResourceID;
        this.newsDate = newsDate;
        this.newsLikeCount = newsLikeCount;
        this.newsCoverImage = newsCoverImage;
        this.languageStatus = languageStatus;
        this.newsStatus =newsStatus;
    }

    public int getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(int newsStatus) {
        this.newsStatus = newsStatus;
    }

    public int getLanguageStatus() {
        return languageStatus;
    }

    public void setLanguageStatus(int languageStatus) {
        this.languageStatus = languageStatus;
    }

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitelEnglish() {
        return newsTitelEnglish;
    }

    public void setNewsTitelEnglish(String newsTitelEnglish) {
        this.newsTitelEnglish = newsTitelEnglish;
    }

    public String getNewsTitelSinhala() {
        return newsTitelSinhala;
    }

    public void setNewsTitelSinhala(String newsTitelSinhala) {
        this.newsTitelSinhala = newsTitelSinhala;
    }

    public String getNewsContentEnglish() {
        return newsContentEnglish;
    }

    public void setNewsContentEnglish(String newsContentEnglish) {
        this.newsContentEnglish = newsContentEnglish;
    }

    public String getNewsContentSinhala() {
        return newsContentSinhala;
    }

    public void setNewsContentSinhala(String newsContentSinhala) {
        this.newsContentSinhala = newsContentSinhala;
    }

    public String getNewsResourceID() {
        return newsResourceID;
    }

    public void setNewsResourceID(String newsResourceID) {
        this.newsResourceID = newsResourceID;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsLikeCount() {
        return newsLikeCount;
    }

    public void setNewsLikeCount(String newsLikeCount) {
        this.newsLikeCount = newsLikeCount;
    }

    public String getNewsCoverImage() {
        return newsCoverImage;
    }

    public void setNewsCoverImage(String newsCoverImage) {
        this.newsCoverImage = newsCoverImage;
    }
}
