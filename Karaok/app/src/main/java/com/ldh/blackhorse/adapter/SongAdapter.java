package com.ldh.blackhorse.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ldh.blackhorse.karaok.R;
import com.ldh.blackhorse.model.Song;

import java.util.List;

public class SongAdapter extends ArrayAdapter<Song> {
    // màn hình đang thể hiện
    Activity context;
    // layout của dòng dữ liệu
    int resource;
    // nguồn dữ liệu cho listview thể hiện
    List<Song> objects;

    // tương tự như constructor cho SongAdapter
    public SongAdapter(Activity context, int resource, List<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        // chuyển từ layout về code java để có thể xử lý, cái chuyển là cái resource truyền vào khi khởi tạo SongAdapter
        LayoutInflater inflater = this.context.getLayoutInflater();
        final View line = inflater.inflate(this.resource, null);

        TextView txt_id = (TextView)line.findViewById(R.id.txt_id);
        TextView txt_songName = (TextView)line.findViewById(R.id.txt_songName);
        TextView txt_singer = (TextView)line.findViewById(R.id.txt_singer);

        final ImageButton imgBtn_like = (ImageButton)line.findViewById(R.id.imgBtn_like);


        final Song song = this.objects.get(position);
        txt_id.setText(song.getId());
        txt_singer.setText(song.getSinger());
        txt_songName.setText(song.getSongName());

        if(song.isLike()) {
            imgBtn_like.setImageResource(R.drawable.like);
        }
        else
        {
            imgBtn_like.setImageResource(R.drawable.dislike);
        }

        imgBtn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(song.isLike())
                {
                    song.setLike(false);
                    imgBtn_like.setImageResource(R.drawable.dislike);
                }
                else
                {
                    song.setLike(true);
                    imgBtn_like.setImageResource(R.drawable.like);
                }
            }
        });
        return line;
    }

}
