package com.ldh.blackhorse.karaok;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import com.ldh.blackhorse.adapter.SongAdapter;
import com.ldh.blackhorse.model.Song;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_songList;
    SongAdapter songAd_songList;
    ArrayList <Song> arrList_songList;

    ListView lv_songLove;
    SongAdapter songAd_songLove;
    ArrayList<Song>arrList_songLove;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addSong();
        addEvents();
    }

    private void addSong() {
        arrList_songList.add(new Song("1","Kết thúc lâu rồi","lê bảo bình",true));
        arrList_songList.add(new Song("2","Yêu vội vàng","lê bảo bình",false));
        arrList_songList.add(new Song("3","Cuộc vui cô đơn","lê bảo bình",true));
        arrList_songList.add(new Song("4","le duc hoa dep trai","lê bảo bình",false));
        arrList_songList.add(new Song("5","try your best","lê bảo bình",true));
    }

    private void addControls() {
        lv_songList = (ListView)findViewById(R.id.lv_songList);
        arrList_songList = new ArrayList<>();
        songAd_songList = new SongAdapter(MainActivity.this,R.layout.item,arrList_songList);
        lv_songList.setAdapter(songAd_songList);

        lv_songLove = (ListView)findViewById(R.id.lv_songLove);
        arrList_songLove = new ArrayList<>();
        songAd_songLove = new SongAdapter(MainActivity.this, R.layout.item,arrList_songLove);
        lv_songLove.setAdapter(songAd_songLove);



        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab_songList = tabHost.newTabSpec("songList");
        tab_songList.setContent(R.id.tab_songList);
        tab_songList.setIndicator("Bài Hát");
        tabHost.addTab(tab_songList);

        TabHost.TabSpec tab_songLove = tabHost.newTabSpec("songLove");
        tab_songLove.setContent(R.id.tab_songLove);
        tab_songLove.setIndicator("Yêu thích");
        tabHost.addTab(tab_songLove);

    }
    private void addEvents() {

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equalsIgnoreCase("songList")) {
                    showSongList();
                }
                else if(tabId.equalsIgnoreCase("songLove")){
                    showSongLove();
                }
            }
        });
    }

    private void showSongLove() {
        arrList_songLove.clear();
        for(Song song :arrList_songList)
        {
            if(song.isLike())
                arrList_songLove.add(song);
        }
        songAd_songLove.notifyDataSetChanged();
    }

    private void showSongList()
    {
        
    }
}
