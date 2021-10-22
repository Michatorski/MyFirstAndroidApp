package com.example.exerciseencuesta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
                Toast.makeText(this, "has votado Linux", Toast.LENGTH_SHORT).show();
                    totalVotesLin++;
                break;
            case  R.id.rbWindows:
                Toast.makeText(this, "has votado Windows", Toast.LENGTH_SHORT).show();
                    totalVoteWin++;
                break;
            case  R.id.rbIos:
                Toast.makeText(this, "has votado iOS", Toast.LENGTH_SHORT).show();
                totalVotesIos++;
                break;
            case  R.id.rbAndroid:
                Toast.makeText(this, "has votado Android", Toast.LENGTH_SHORT).show();
                totalVotesAndr++;
                break;
        }
    }
}