package id.co.taajeer.sinaudatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ArrayList<NewsModel> myNewsList;
    @InjectView(R.id.myRecyclerView)
    RecyclerView myRecyclerView;

//    NewsAdapter myNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //ButterKnife.bind(this);

//        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        myNewsList = new ArrayList<>();


//        for (int i=0;i<10;i++) {
//
//            NewsModel myNews = new NewsModel();
//            myNews.setJudul("Judul "+ i);
//            myNews.setDeskripsi("Deskripsi "+i);
//            myNews.setId(Integer.toString(i));
//            myNews.setGambar("https://image.freepik.com/free-vector/startup-rocket-with-icons_23-2147504176.jpg");
//
//            myNewsList.add(myNews);
//        }
//
//
//        NewsAdapter myNewsAdapter = new NewsAdapter(MainActivity.this,myNewsList);
//        myRecyclerView.setAdapter(myNewsAdapter);
//        myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Log.d("RETRIEVING BERITA", "xyz1");
        Toast.makeText(this, "RETRIEVING NEWS2...", Toast.LENGTH_SHORT).show();
        getNews();


    }

    private void getNews() {

        API_Service myAPI = RetrofitConfig.getInstanceRetrofit();
        Call<NewsListModel> call = myAPI.getMyJson();
        Log.d("lihat response", "xyz1");
        call.enqueue(new Callback<NewsListModel>() {
            @Override
            public void onResponse(Call<NewsListModel> call, Response<NewsListModel> response) {
                Log.d("lihat response", "xyz2");
                //check if there's response from the server...
                if (response.isSuccessful()) {
                    myNewsList = response.body().getNewsData();
                    Log.d("lihat response xyz3", response.message());
                    Toast.makeText(MainActivity.this, response.body().getNewsData().get(0).getJudul().toString(), Toast.LENGTH_SHORT).show();

                    NewsAdapter myNewsAdapter = new NewsAdapter(MainActivity.this, myNewsList);
                    myRecyclerView.setAdapter(myNewsAdapter);
                    myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                } else {
                    Log.d("gagal response", response.toString());
                }
            }

            @Override
            public void onFailure(Call<NewsListModel> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Failure" + call.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * Created by Didit on 5/5/2017.
     */

    public static class NewsCollectionModel {
    }
}
