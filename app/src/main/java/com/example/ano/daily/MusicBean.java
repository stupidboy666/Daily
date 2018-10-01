package com.example.ano.daily;

import org.litepal.crud.LitePalSupport;

public class MusicBean extends LitePalSupport {
    private String author;
    private String zhubo;
    private String music;
    private String imId;

    public String getAuthor() {
        return author;
    }

    public String getImId() {
        return imId;
    }

    public String getMusic() {
        return music;
    }

    public String getZhubo() {
        return zhubo;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public void setZhubo(String zhubo) {
        this.zhubo = zhubo;
    }
}
