package com.example.hogwarts.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Housess implements Serializable {


    @Expose
    @SerializedName("_id")
       String _id;

    @Expose
    @SerializedName("name")
        String name;

    @Expose
    @SerializedName("mascot")
       String mascot;

    @Expose
    @SerializedName("headOfHouse")
        String headOfHouse;

    @Expose
    @SerializedName("houseGhost")
       String houseGhost;


    @Expose
    @SerializedName("founder")
        String founder;


    @Expose
    @SerializedName("__v")
        int __v;

    @Expose
    @SerializedName("school")
         String school;

    @Expose
    @SerializedName("members")
        List<String> members;

    @Expose
    @SerializedName("values")
        List<String> values;


    @Expose
    @SerializedName("colors")
        List<String> colors;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(String headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    public String getHouseGhost() {
        return houseGhost;
    }

    public void setHouseGhost(String houseGhost) {
        this.houseGhost = houseGhost;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }
}
