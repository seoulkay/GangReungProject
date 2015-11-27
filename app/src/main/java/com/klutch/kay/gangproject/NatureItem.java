package com.klutch.kay.gangproject;

/**
 * Created by DB400S3A on 2015-11-26.
 */
public class NatureItem {
    private String mName;
    private String mDes;
    private String mKor;
    private int mThumbnail;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDes() {
        return mDes;
    }

    public void setDes(String des) {
        this.mDes = des;
    }

    public String getKor() {
        return mKor;
    }

    public void setKor(String kor) {
        this.mKor = kor;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }

}
