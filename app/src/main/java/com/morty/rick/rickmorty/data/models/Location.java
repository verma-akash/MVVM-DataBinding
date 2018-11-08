
package com.morty.rick.rickmorty.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "location")
public class Location {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "location_id")
    private int id;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "location_name")
    private String name;

    @SerializedName("url")
    @Expose
    @ColumnInfo(name = "location_url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
