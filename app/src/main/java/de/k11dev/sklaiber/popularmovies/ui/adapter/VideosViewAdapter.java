package de.k11dev.sklaiber.popularmovies.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.k11dev.sklaiber.popularmovies.Config;
import de.k11dev.sklaiber.popularmovies.R;
import de.k11dev.sklaiber.popularmovies.model.VideoResult;

/**
 * Created by sklaiber on 30.08.15.
 */
public class VideosViewAdapter extends RecyclerView.Adapter<VideosViewAdapter.ViewHolder> {

    private ArrayList<VideoResult> mVideoResults = new ArrayList<>();
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public VideosViewAdapter(Context context, ArrayList<VideoResult> videoResults) {
        this.mContext = context;
        this.mVideoResults = videoResults;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.textView.setText(mVideoResults.get(position).getName());
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Config.YOUTUBE_URL + mVideoResults.get(position).getKey())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVideoResults.size();
    }
}
