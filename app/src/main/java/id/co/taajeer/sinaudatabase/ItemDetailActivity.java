package id.co.taajeer.sinaudatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ItemDetailActivity extends AppCompatActivity {
    @InjectView(R.id.ivDetailGambar)
    ImageView ivDetailGambar;
    @InjectView(R.id.tvDeskripsiBerita)
    TextView tvDeskripsiBerita;


    // Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        ButterKnife.inject(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("TEST:", "ss");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action2", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                ;
            }
        });

        Log.d("TEST:", "D2");
        Intent hasil = getIntent();
        String detail_dataJudul = hasil.getStringExtra("DATA_JUDUL");
        Log.d("TEST:", detail_dataJudul);
        String detail_dataGambar = hasil.getStringExtra("DATA_GAMBAR");
        String detail_dataDeskripsi = hasil.getStringExtra("DATA_DESKRIPSI");
        Log.d("TEST:", "http://192.168.95.134/berita/foto_berita/" + detail_dataGambar);

        getSupportActionBar().setTitle(detail_dataJudul);

        //toolbar.setTitle(detail_dataJudul);
        Glide.with(this)
                //.load(myNewsList.get(position).getGambar())
                .load("http://192.168.95.134/berita/foto_berita/" + detail_dataGambar)
                .into(ivDetailGambar);


        tvDeskripsiBerita.setText(detail_dataDeskripsi);

        Log.d("TEST2:", "http://192.168.95.134/berita/foto_berita/" + detail_dataGambar);
    }
}
