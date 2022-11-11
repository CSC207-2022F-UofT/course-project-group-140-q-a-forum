package entities;

import java.awt.*;

public class PostInfo{
    private String topic;
    private String texts;
    private User postedBy;
    private Image[] images;

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

    public PostInfo(String topic, String texts, Image[] images, User user){
        this.topic = topic;
        this.texts = texts;
        this.images = images;
        this.postedBy = user;
    }



}