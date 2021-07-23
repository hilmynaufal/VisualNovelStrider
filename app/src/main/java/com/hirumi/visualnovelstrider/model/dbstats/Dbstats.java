package com.hirumi.visualnovelstrider.model.dbstats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dbstats {
    @SerializedName("users")
    @Expose
    private Integer users;
    @SerializedName("traits")
    @Expose
    private Integer traits;
    @SerializedName("releases")
    @Expose
    private Integer releases;
    @SerializedName("vn")
    @Expose
    private Integer vn;
    @SerializedName("staff")
    @Expose
    private Integer staff;
    @SerializedName("producers")
    @Expose
    private Integer producers;
    @SerializedName("threads")
    @Expose
    private Integer threads;
    @SerializedName("chars")
    @Expose
    private Integer chars;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("tags")
    @Expose
    private Integer tags;

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getTraits() {
        return traits;
    }

    public void setTraits(Integer traits) {
        this.traits = traits;
    }

    public Integer getReleases() {
        return releases;
    }

    public void setReleases(Integer releases) {
        this.releases = releases;
    }

    public Integer getVn() {
        return vn;
    }

    public void setVn(Integer vn) {
        this.vn = vn;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public Integer getProducers() {
        return producers;
    }

    public void setProducers(Integer producers) {
        this.producers = producers;
    }

    public Integer getThreads() {
        return threads;
    }

    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    public Integer getChars() {
        return chars;
    }

    public void setChars(Integer chars) {
        this.chars = chars;
    }

    public Integer getPosts() {
        return posts;
    }

    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    public Integer getTags() {
        return tags;
    }

    public void setTags(Integer tags) {
        this.tags = tags;
    }
}
