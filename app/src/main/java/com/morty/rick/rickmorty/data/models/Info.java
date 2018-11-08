
package com.morty.rick.rickmorty.data.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("count")
    @Expose
    @ColumnInfo(name = "count")
    private Integer count;

    @SerializedName("pages")
    @Expose
    @ColumnInfo(name = "pages")
    private Integer pages;

    @SerializedName("next")
    @Expose
    @ColumnInfo(name = "next")
    private String next;

    @SerializedName("prev")
    @Expose
    @ColumnInfo(name = "prev")
    private String prev;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

}
