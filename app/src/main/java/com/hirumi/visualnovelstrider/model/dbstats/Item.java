package com.hirumi.visualnovelstrider.model.dbstats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item {
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("image_flagging")
    @Expose
    public ImageFlagging imageFlagging;
    @SerializedName("image_nsfw")
    @Expose
    public Boolean imageNsfw;
    @SerializedName("votecount")
    @Expose
    public Integer votecount;
    @SerializedName("original")
    @Expose
    public Object original;
    @SerializedName("aliases")
    @Expose
    public String aliases;
    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("languages")
    @Expose
    public ArrayList<String> languages = null;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("orig_lang")
    @Expose
    public ArrayList<String> origLang = null;
    @SerializedName("released")
    @Expose
    public String released;
    @SerializedName("rating")
    @Expose
    public Double rating;
    @SerializedName("length")
    @Expose
    public Integer length;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("platforms")
    @Expose
    public ArrayList<String> platforms = null;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("tags")
    @Expose
    public ArrayList<ArrayList<Double>> tags = null;
    @SerializedName("description")
    @Expose
    public String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageFlagging getImageFlagging() {
        return imageFlagging;
    }

    public void setImageFlagging(ImageFlagging imageFlagging) {
        this.imageFlagging = imageFlagging;
    }

    public Boolean getImageNsfw() {
        return imageNsfw;
    }

    public void setImageNsfw(Boolean imageNsfw) {
        this.imageNsfw = imageNsfw;
    }

    public Integer getVotecount() {
        return votecount;
    }

    public void setVotecount(Integer votecount) {
        this.votecount = votecount;
    }

    public Object getOriginal() {
        return original;
    }

    public void setOriginal(Object original) {
        this.original = original;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<String> getOrigLang() {
        return origLang;
    }

    public void setOrigLang(ArrayList<String> origLang) {
        this.origLang = origLang;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<String> platforms) {
        this.platforms = platforms;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public ArrayList<ArrayList<Double>> getTags() {
        return tags;
    }

    public void setTags(ArrayList<ArrayList<Double>> tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
