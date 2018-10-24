package com.journaldev.androidlivedata.model;

import android.app.Application;
import android.support.annotation.Nullable;

public class DemoData {
    private String title;


    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }
}
