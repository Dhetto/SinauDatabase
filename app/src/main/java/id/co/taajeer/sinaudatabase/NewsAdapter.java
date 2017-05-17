package id.co.taajeer.sinaudatabase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 *  extends RecyclerView.Adapter {NewsAdapter.MyHolder)
 * Created by Didit on 5/5/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder>{

    Context myContext;
    ArrayList<NewsModel> myNewsList;

    public NewsAdapter(Context myContext, ArrayList<NewsModel> myNewsList){
        this.myContext = myContext;
        this.myNewsList = myNewsList;
    }

    @Override
    public NewsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflater=(LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myRowView=myInflater.inflate(R.layout.activity_news,parent, false);

        return new MyHolder(myRowView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        holder.judulberita.setText(myNewsList.get(position).getJudul());
        Glide.with(myContext)       //.load(myNewsList.get(position).getGambar())
                .load("http://192.168.100.4/berita/foto_berita/"+myNewsList.get(position).getGambar())
                .into(holder.gambarberita);

        holder.gambarberita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext, myNewsList.get(position).getJudul(), Toast.LENGTH_SHORT).show();
            }
        });

       holder.view_kartuberita.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent pindah= new Intent(myContext, ItemDetailActivity.class);
               pindah.putExtra("DATA_JUDUL",myNewsList.get(position).getJudul());
               pindah.putExtra("DATA_GAMBAR",myNewsList.get(position).getGambar());
               pindah.putExtra("DATA_DESKRIPSI",myNewsList.get(position).getDeskripsi());
               myContext.startActivity(pindah);
           }
       });
    }


    @Override
    public int getItemCount() {
        return myNewsList.size();
    }

    //public NewsAdapter(Context myContext)

    public class MyHolder extends RecyclerView.ViewHolder {

        public final ImageView gambarberita;
        public final TextView judulberita;
        public final CardView view_kartuberita;

        public MyHolder(View itemView) {
            super(itemView);
            gambarberita = (ImageView) itemView.findViewById(R.id.ivImageVIew);
            judulberita = (TextView) itemView.findViewById(R.id.tvNewsTitle);
            view_kartuberita = (CardView) itemView.findViewById(R.id.cvTheCardView);
            //cardview
        }
    }

}
