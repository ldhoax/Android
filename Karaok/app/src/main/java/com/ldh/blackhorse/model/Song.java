package com.ldh.blackhorse.model;

import java.io.Serializable;

public class Song implements Serializable {
    private String id;
    private String songName;
    private String singer;
    private boolean like;

    public Song(String id, String songName, String singer, boolean like) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.like = like;
    }

    public Song() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
