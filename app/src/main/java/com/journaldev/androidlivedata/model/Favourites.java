package com.journaldev.androidlivedata.model;

public class Favourites {

    public long mId;
    public String mUrl;
    public long mDate;

    public Favourites(long id, String name, long date) {
        mId = id;
        mUrl = name;
        mDate = date;
    }

    public Favourites(Favourites favourites) {
        mId = favourites.mId;
        mUrl = favourites.mUrl;
        mDate = favourites.mDate;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public long getmDate() {
        return mDate;
    }

    public void setmDate(long mDate) {
        this.mDate = mDate;
    }
}