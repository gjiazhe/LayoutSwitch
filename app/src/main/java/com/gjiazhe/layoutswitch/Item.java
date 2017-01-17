package com.gjiazhe.layoutswitch;

/**
 * Created by gjz on 18/01/2017.
 */

public class Item {
    private int imgResId;
    private String title;
    private int likes;
    private int comments;

    public Item(int imgResId, String title, int likes, int comments) {
        this.imgResId = imgResId;
        this.title = title;
        this.likes = likes;
        this.comments = comments;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }
}
