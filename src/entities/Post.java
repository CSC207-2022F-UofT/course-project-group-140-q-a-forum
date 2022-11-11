package src.entities;

import java.awt.*;

public class Post {
    private String Topic;
    private String Texts;
    private Image[] Images;

    public Post(){

    }

    /**
     * @param topic
     * @param texts
     */

    public Post(String topic, String texts){
        this.Topic = topic;
        this.Texts = texts;
        this.Images = null;
    }

    /**
     * @param topic
     * @param texts
     * @param images
     */

    public Post(String topic, String texts, Image[] images){
        this.Topic = topic;
        this.Texts = texts;
        this.Images = images;
    }



}