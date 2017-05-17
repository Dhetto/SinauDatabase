package id.co.taajeer.sinaudatabase;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Didit on 5/5/2017.
 */

public class NewsListModel {
    @SerializedName("berita")
    @Expose
    private ArrayList<NewsModel> NewsData = new ArrayList<>();

    public ArrayList<NewsModel> getNewsData() {
        return NewsData;
    }

    public void setNewsData(ArrayList<NewsModel> newsData) {
        NewsData = newsData;
    }

    //generate > setter and getter
}
