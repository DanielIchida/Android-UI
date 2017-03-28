package com.example.daniel.introapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.introapp.adapter.ViewPageAdapter;
import com.example.daniel.introapp.util.PreferencesManager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private LinearLayout container;

    private TextView[] circulos;

    private int[] ventanas = new int[]{
            R.layout.slide_uno,
            R.layout.slide_dos,
            R.layout.slide_tres,
            R.layout.slide_cuatro};

    private Button siguiente ,saltar;

    private ViewPageAdapter adapter;

    private  PreferencesManager prefManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO aca validamos que solo se muestre la pantalla de intro una vez
        prefManager = new PreferencesManager(this);
        if (!prefManager.isPrimeraEjecucion()) {
            irActivityMenu();
            finish();
        }

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        container = (LinearLayout)findViewById(R.id.layout_container);
        siguiente = (Button)findViewById(R.id.btn_siguiente);
        saltar = (Button)findViewById(R.id.btn_saltar);


        circulosInferiores(0);
        adapter = new ViewPageAdapter(this,ventanas);


        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                circulosInferiores(position);

                if (position == ventanas.length - 1) {
                    siguiente.setText(getString(R.string.iniciar));
                    saltar.setVisibility(View.GONE);
                } else {
                    siguiente.setText(getString(R.string.siguiente));
                    saltar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        saltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irActivityMenu();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < ventanas.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    irActivityMenu();
                }
            }
        });

    }

    //TODO metodo para dibujar los circulos inferiores
    private void circulosInferiores(int pagina){

         circulos = new TextView[ventanas.length];

         container.removeAllViews();

         for(int i = 0 ; i < circulos.length ; i++){
             circulos[i] = new TextView(this);
             circulos[i].setText(Html.fromHtml("&#8226;"));
             circulos[i].setTextSize(35);
             circulos[i].setTextColor(Color.WHITE);
             container.addView(circulos[i]);
         }

        if (circulos.length > 0)
            circulos[pagina].setTextColor(Color.BLACK);

    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void irActivityMenu() {
        prefManager.setPrimeraEjecucion(false);
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
