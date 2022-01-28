package com.example.menuproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class Exercise3 extends AppCompatActivity {

    ImageView golden, pink, platano, conference, limonera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        golden = (ImageView) findViewById(R.id.imgManzanaGolden);
        pink = (ImageView) findViewById(R.id.imgManzanaPink);
        platano = (ImageView) findViewById(R.id.imgPlatano);
        conference = (ImageView) findViewById(R.id.imgPearConference);
        limonera = (ImageView) findViewById(R.id.imgPearLimonera);

        golden.setVisibility(View.GONE);
        pink.setVisibility(View.GONE);
        platano.setVisibility(View.GONE);
        conference.setVisibility(View.GONE);
        limonera.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        SubMenu subMenu = menu.addSubMenu(Menu.NONE, 1, Menu.NONE, "Manzana");
        subMenu.add(Menu.NONE, 11, Menu.NONE, "Golden");
        subMenu.add(Menu.NONE, 12, Menu.NONE, "Pink Lady");
        menu.add(Menu.NONE, 2, Menu.NONE, "Platano");

        SubMenu subMenuII = menu.addSubMenu(Menu.NONE, 3, Menu.NONE, "Peras");
        subMenuII.add(Menu.NONE, 31, Menu.NONE, "Conferencia");
        subMenuII.add(Menu.NONE, 32, Menu.NONE, "Limonera");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case 11:
                golden.setVisibility(View.VISIBLE);
                pink.setVisibility(View.GONE);
                platano.setVisibility(View.GONE);
                conference.setVisibility(View.GONE);
                limonera.setVisibility(View.GONE);
                return true;
            case 12:
                golden.setVisibility(View.GONE);
                pink.setVisibility(View.VISIBLE);
                platano.setVisibility(View.GONE);
                conference.setVisibility(View.GONE);
                limonera.setVisibility(View.GONE);
                return true;
            case 2:
                golden.setVisibility(View.GONE);
                pink.setVisibility(View.GONE);
                platano.setVisibility(View.VISIBLE);
                conference.setVisibility(View.GONE);
                limonera.setVisibility(View.GONE);
                return true;
            case 31:
                golden.setVisibility(View.GONE);
                pink.setVisibility(View.GONE);
                platano.setVisibility(View.GONE);
                conference.setVisibility(View.VISIBLE);
                limonera.setVisibility(View.GONE);
                return true;
            case 32:
                golden.setVisibility(View.GONE);
                pink.setVisibility(View.GONE);
                platano.setVisibility(View.GONE);
                conference.setVisibility(View.GONE);
                limonera.setVisibility(View.VISIBLE);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }

    }
}