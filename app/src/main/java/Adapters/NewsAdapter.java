package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yasmeensiam.midadproject.R;
import com.squareup.picasso.Picasso;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Model.ItemDrawer;
import Model.News;

/**
 * Created by Yasmeen Siam on 26/06/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolders> {

    private List<News> newsList;
    Context context;

    public NewsAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);

        return new ViewHolders(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolders holder, int position) {
        News item = newsList.get(position);
        holder.newsTitel.setText(item.getNewsTitel());
        holder.newsDepartment.setText(item.getNewsDepartment());
        Picasso.with(context)
                .load(item.getImageNews())
                .into(holder.newsImage);

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(item.getNewsDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PrettyTime p = new PrettyTime(new Locale("ar"));
        holder.newsDate.setText(p.format(date));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsTitel;
        TextView newsDate;
        TextView newsDepartment;

        public ViewHolders(View itemView) {
            super(itemView);
            newsImage = (ImageView) itemView.findViewById(R.id.imageNews);
            newsTitel = (TextView) itemView.findViewById(R.id.titel);
            newsDate = (TextView) itemView.findViewById(R.id.newsDate);
            newsDepartment = (TextView) itemView.findViewById(R.id.newsDepartment);

        }
    }
}
