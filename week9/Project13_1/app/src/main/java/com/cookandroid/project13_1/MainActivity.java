package com.cookandroid.project13_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvMP3;
    private Button btnPlay, btnPause, btnStop;
    private TextView tvMP3;
    private ProgressBar pbMP3;

    private ArrayList<String> mp3List;
    private String selectedMP3, fileName, extName;
    private String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";
    private MediaPlayer mediaPlayer;

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Mini MP3 Player");
        ActivityCompat.requestPermissions(this,
                new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        mp3List = new ArrayList<String>();

        File[] listFiles = new File(mp3Path).listFiles();
        for (File file : listFiles) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if(extName.equals((String) "mp3")) {
                mp3List.add(fileName);
            }
        }
        init();
        initData();
        initLr();
    }

    public void init(){
        lvMP3 = findViewById(R.id.lvMP3);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnStop = findViewById(R.id.btnStop);
        tvMP3 = findViewById(R.id.tvMP3);
        pbMP3 = findViewById(R.id.pbMP3);
    }

    public void initData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mp3List);
        lvMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvMP3.setAdapter(adapter);
        lvMP3.setItemChecked(0, true);
    }

    public void initLr(){
        lvMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedMP3 = mp3List.get(i);
            }
        });
        selectedMP3 = mp3List.get(0);

        btnPlay.setOnClickListener(v -> {
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(mp3Path + selectedMP3);
                mediaPlayer.prepare();
                mediaPlayer.start();
                btnPlay.setClickable(false);
                btnPause.setClickable(true);
                btnStop.setClickable(true);
                tvMP3.setText("실행중인 음악 : " + selectedMP3);
                pbMP3.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnPause.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                position = mediaPlayer.getCurrentPosition();
                btnPause.setText("이어듣기");
                btnPause.setClickable(true);
                btnStop.setClickable(true);
                pbMP3.setVisibility(View.INVISIBLE);
            } else {
                mediaPlayer.seekTo(position);
                mediaPlayer.start();
                btnPause.setText("일시 정지");
                pbMP3.setVisibility(View.VISIBLE);
            }
        });

        btnStop.setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer.reset();
            btnPlay.setClickable(true);
            btnPause.setClickable(false);
            btnStop.setClickable(false);
            tvMP3.setText("실행중인 음악 : ");
            pbMP3.setVisibility(View.INVISIBLE);
        });

        btnStop.setClickable(false);
    }
}