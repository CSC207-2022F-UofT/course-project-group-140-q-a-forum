package entities;

import java.awt.*;
import java.util.ArrayList;

public class PostInfo{
    private String topic;
    private String texts;
    private User postedBy;
    private ArrayList<Image> images;

    public PostInfo(){

    }

    /**
     * @param topic
     * @param texts
     */

    public PostInfo(String topic, String texts, User user){
        this.topic = topic;
        this.texts = texts;
        this.images = null;
        this.postedBy = user;
    }

    /**
     * @param topic
     * @param texts
     * @param images
     */

    public PostInfo(String topic, String texts, ArrayList<Image> images, User user){
        this.topic = topic;
        this.texts = texts;
        this.images = images;
        this.postedBy = user;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public String getTexts() {
        return texts;
    }

    public String getTopic() {
        return topic;
    }

    public ArrayList<Image> getImages() {
        return images;
    }
}