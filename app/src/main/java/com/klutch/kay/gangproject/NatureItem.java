package com.klutch.kay.gangproject;

/**
 * Created by DB400S3A on 2015-11-26.
 */
public class NatureItem {
    private String mName;
    private String mEng;
    private String mKor;
    private String mSound;
    private int mThumbnail;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getEng() {
        return mEng;
    }

    public void setEng(String eng) {
        this.mEng = eng;
    }

    public String getKor() {
        return mKor;
    }

    public void setKor(String kor) {
        this.mKor = kor;
    }

    public String getSound(){ return mSound;}

    public void setSound(String sound) { this.mSound = sound; }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }

}
