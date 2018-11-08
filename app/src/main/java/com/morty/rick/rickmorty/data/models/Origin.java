
package com.morty.rick.rickmorty.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "origin")
public class Origin {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "origin_id")
    private int originId;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "origin_name")
    private String name;

    @SerializedName("url")
    @Expose
    @ColumnInfo(name = "origin_url")
    private String url;

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
