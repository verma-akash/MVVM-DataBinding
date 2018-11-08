
package com.morty.rick.rickmorty.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "characters")
public class Characters {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("info")
    @Expose
    @Embedded
    private Info info;

    @SerializedName("results")
    @Expose
    @ColumnInfo(name = "listCharacters")
    @TypeConverters(DataTypeConverter.class)
    private List<Character> results = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

}
