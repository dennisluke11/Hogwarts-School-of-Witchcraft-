package com.example.hogwarts.model;

/**
 * Created by Dennis Luke Owuor.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentDBResponse implements Parcelable
{

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalMovies;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private List<Student> Students = null;
    public final static Parcelable.Creator<StudentDBResponse> CREATOR = new Creator<StudentDBResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public StudentDBResponse createFromParcel(Parcel in) {
            return new StudentDBResponse(in);
        }

        public StudentDBResponse[] newArray(int size) {
            return (new StudentDBResponse[size]);
        }

    }
            ;

    protected StudentDBResponse(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalMovies = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.Students, (com.example.hogwarts.model.Student.class.getClassLoader()));
    }

    public StudentDBResponse() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalMovies() {
        return totalMovies;
    }

    public void setTotalMovies(Integer totalMovies) {
        this.totalMovies = totalMovies;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Student> getStudents() {
        return Students;
    }

    public void setMovies(List<Student> Students) {
        this.Students = Students;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(totalMovies);
        dest.writeValue(totalPages);
        dest.writeList(Students);
    }

    public int describeContents() {
        return 0;
    }

}