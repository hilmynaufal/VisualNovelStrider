package com.hirumi.visualnovelstrider.model.dbstats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {
    @SerializedName("wikipedia")
    @Expose
    public String wikipedia;
    @SerializedName("renai")
    @Expose
    public Object renai;
    @SerializedName("wikidata")
    @Expose
    public String wikidata;
    @SerializedName("encubed")
    @Expose
    public Object encubed;

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public Object getRenai() {
        return renai;
    }

    public void setRenai(Object renai) {
        this.renai = renai;
    }

    public String getWikidata() {
        return wikidata;
    }

    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
    }

    public Object getEncubed() {
        return encubed;
    }

    public void setEncubed(Object encubed) {
        this.encubed = encubed;
    }
}
