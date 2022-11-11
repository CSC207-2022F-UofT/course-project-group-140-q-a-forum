package entities;

import java.awt.*;

public class Post {
    private String topic;
    private String texts;
    private Image[] images;

    public Post(){

    }

    /**
     * @param topic
     * @param texts
     */

    public Post(String topic, String texts){
        this.topic = topic;
        this.texts = texts;
        this.images = null;
    }

    /**
     * @param topic
     * @param texts
     * @param images
     */

    public Post(String topic, String texts, Image[] images){
        this.topic = topic;
        this.texts = texts;
        this.images = images;
    }



}