
package com.morty.rick.rickmorty.data.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Entity(tableName = "character")
public class Character {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    @ColumnInfo(name = "character_id")
    private Integer id;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("status")
    @Expose
    @ColumnInfo(name = "status")
    private String status;

    @SerializedName("species")
    @Expose
    @ColumnInfo(name = "species")
    private String species;

    @SerializedName("type")
    @Expose
    @ColumnInfo(name = "type")
    private String type;

    @SerializedName("gender")
    @Expose
    @ColumnInfo(name = "gender")
    private String gender;

    @SerializedName("origin")
    @Expose
    @Embedded
    private Origin origin;

    @SerializedName("location")
    @Expose
    @Embedded
    private Location location;

    @SerializedName("image")
    @Expose
    @ColumnInfo(name = "image")
    private String image;

//    @SerializedName("episode")
//    @Expose
//    private List<String> episode = null;

    @SerializedName("url")
    @Expose
    @ColumnInfo(name = "url")
    private String url;

    @SerializedName("created")
    @Expose
    @ColumnInfo(name = "created")
    private String created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl)
                .into(imageView);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public List<String> getEpisode() {
//        return episode;
//    }
//
//    public void setEpisode(List<String> episode) {
//        this.episode = episode;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

}
