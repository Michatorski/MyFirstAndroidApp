package com.example.exerciseencuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton saveButton;

    RadioGroup rgOS;
    TextView votesWindows, votesLinux, votesIos, votesAndroid;
    Integer totalVoteWin, totalVotesLin, totalVotesIos, totalVotesAndr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (ImageButton) findViewById(R.id.ibSave);



        rgOS = (RadioGroup) findViewById(R.id.rgOS);

        votesLinux = (TextView) findViewById(R.id.tvVotosLinux);
        votesWindows = (TextView) findViewById(R.id.tvVotesWindows);
        votesIos = (TextView) findViewById(R.id.tvVotesIos);
        votesAndroid = (TextView) findViewById(R.id.tvVotesAndroid);

        totalVoteWin = 0;
        totalVotesLin = 0;
        totalVotesIos = 0;
        totalVotesAndr = 0;
    }

    public void saveVote (View v){

        votesLinux.setText("Linux: " + totalVotesLin + " votos");
        votesWindows.setText("Windows: " + totalVoteWin + " votos");
        votesIos.setText("iOS: "+ totalVotesIos + " votos");
        votesAndroid.setText("Android: "+ totalVotesAndr + " votos");

        switch (rgOS.getCheckedRadioButtonId()){

            case R.id.rbLinux:
                    totalVotesLin++;
                break;
            case  R.id.rbWindows:
                    totalVoteWin++;
                break;
            case  R.id.rbIos:
                totalVotesIos++;
                break;
            case  R.id.rbAndroid:
                totalVotesAndr++;
                break;
        }
    }
}