package com.hirumi.visualnovelstrider.model.dbstats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item {
    @SerializedName("image_flagging")
    @Expose
    public ImageFlagging imageFlagging;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("original")
    @Expose
    public Object original;
    @SerializedName("orig_lang")
    @Expose
    public ArrayList<String> origLang = null;
    @SerializedName("image_nsfw")
    @Expose
    public Boolean imageNsfw;
    @SerializedName("length")
    @Expose
    public Integer length;
    @SerializedName("released")
    @Expose
    public String released;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("languages")
    @Expose
    public ArrayList<String> languages = null;
    @SerializedName("platforms")
    @Expose
    public ArrayList<String> platforms = null;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("aliases")
    @Expose
    public String aliases;

    public ImageFlagging getImageFlagging() {
        return imageFlagging;
    }

    public void setImageFlagging(ImageFlagging imageFlagging) {
        this.imageFlagging = imageFlagging;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Object getOriginal() {
        return original;
    }

    public void setOriginal(Object original) {
        this.original = original;
    }

    public ArrayList<String> getOrigLang() {
        return origLang;
    }

    public void setOrigLang(ArrayList<String> origLang) {
        this.origLang = origLang;
    }

    public Boolean getImageNsfw() {
        return imageNsfw;
    }

    public void setImageNsfw(Boolean imageNsfw) {
        this.imageNsfw = imageNsfw;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public ArrayList<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<String> platforms) {
        this.platforms = platforms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }
}
