package id.co.taajeer.sinaudatabase;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Didit on 5/5/2017.
 */

public interface API_Service {
    @GET("getBerita.php")
    Call<NewsListModel> getMyJson();
}
