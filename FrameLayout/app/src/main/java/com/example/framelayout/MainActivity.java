package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView topRight, centerLeft, bottonRight;

    ImageView zen1, zen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topRight = (TextView) findViewById(R.id.tv_TR);
        centerLeft = (TextView) findViewById(R.id.tv_LC);
        bottonRight = (TextView) findViewById(R.id.tv_RB);

        zen1 = (ImageView) findViewById(R.id.img_Zen1);
        zen2 = (ImageView) findViewById(R.id.img_Zen2);

        FrameLayout.LayoutParams paramsZen1 = (FrameLayout.LayoutParams) zen1.getLayoutParams();
        paramsZen1.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        zen1.setLayoutParams(paramsZen1);

        FrameLayout.LayoutParams paramsZen2 = (FrameLayout.LayoutParams) zen2.getLayoutParams();
        paramsZen2.gravity = Gravity.TOP | Gravity.RIGHT;
        zen2.setLayoutParams(paramsZen2);

        FrameLayout.LayoutParams paramsTR = (FrameLayout.LayoutParams) topRight.getLayoutParams();
        paramsTR.gravity = Gravity.BOTTOM | Gravity.LEFT;
        topRight.setLayoutParams(paramsTR);

        FrameLayout.LayoutParams paramsCR = (FrameLayout.LayoutParams) centerLeft.getLayoutParams();
        paramsCR.gravity = Gravity.CENTER | Gravity.RIGHT;
        centerLeft.setLayoutParams(paramsCR);

        FrameLayout.LayoutParams paramsBR = (FrameLayout.LayoutParams) bottonRight.getLayoutParams();
        paramsBR.gravity = Gravity.TOP | Gravity.LEFT;
        bottonRight.setLayoutParams(paramsBR);
    }
}