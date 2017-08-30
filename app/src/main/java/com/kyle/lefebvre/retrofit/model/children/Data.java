package com.kyle.lefebvre.retrofit.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kyle on 8/29/2017.
 */

public class Data {

    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Data{" +
                "url='" + url + '\'' +
                ", contest_mode='" + contest_mode + '\'' +
                ", title='" + title + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("contest_mode")
    @Expose
    private String contest_mode;

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("subreddit")
    @Expose
    private String subreddit;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @SerializedName("author")
    @Expose
    private String author;

    public String getContest_mode() {
        return contest_mode;
    }

    public void setContest_mode(String contest_mode) {
        this.contest_mode = contest_mode;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
