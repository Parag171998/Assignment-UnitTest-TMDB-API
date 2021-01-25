package com.example.assignmenttmdbapiunittest.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Movie {
    private Integer page;
    private List<Result> results = new ArrayList<>();
    @SerializedName(value = "total_results")
    private Integer totalResults;
    @SerializedName(value = "total_pages")
    private Integer totalPages;


    public Integer getPage() {
        return page;
    }


    public void setPage(Integer page) {
        this.page = page;
    }


    public List<Result> getResults() {
        return results;
    }


    public void setResults(List<Result> results) {
        this.results = results;
    }


    public Integer getTotalResults() {
        return totalResults;
    }


    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }


    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
