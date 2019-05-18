package com.example.UTSZHAFIR.model;

public class DailyActivityModel {
    private int[] image;
    private String time;
    private String text;
    private String location;
    private String type;
    private int like = 0;
    private int comment = 0;

    public DailyActivityModel(int[] image, String time, String text, String location, String type) {
        this.image = image;
        this.time = time;
        this.text = text;
        this.location = location;
        this.type = type;
    }

    public DailyActivityModel(int[] image, String time, String text, String location, String type, int like, int comment) {
        this.image = image;
        this.time = time;
        this.text = text;
        this.type = type;
        this.location = location;
        this.like = like;
        this.comment = comment;
    }

    public int[] getImage() {
        return image;
    }

    public void setImage(int[] image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

