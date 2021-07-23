package com.hirumi.visualnovelstrider.model.dbstats;

import android.content.ClipData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {
    @SerializedName("more")
    @Expose
    private Boolean more;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("items")
    @Expose
    private ArrayList<Item> items = null;

    public Boolean getMore() {
        return more;
    }

    public void setMore(Boolean more) {
        this.more = more;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Result(ArrayList<Item> items) {
        this.items = items;
    }

    public Result() {
    }
}


