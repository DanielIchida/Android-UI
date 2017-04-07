package com.example.daniel.layoutpersonalizado;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.daniel.layoutpersonalizado.adapter.AdaptadorProductos;
import com.example.daniel.layoutpersonalizado.adapter.AdaptadorViewPager;
import com.example.daniel.layoutpersonalizado.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcListado;
    ViewPager viewPager;

    List<Producto> productos;
    AdaptadorProductos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcListado = (RecyclerView)findViewById(R.id.rc_listado);
        viewPager = (ViewPager)findViewById(R.id.view_pager);

        dataProductos();

        listadoLineal();


    }

    public void dataProductos(){
        productos = new ArrayList<>();
        productos.add(new Producto("Banano",R.drawable.banano));
        productos.add(new Producto("Durazno",R.drawable.durazno));
        productos.add(new Producto("Fresa",R.drawable.fresas));
        productos.add(new Producto("Kiwi",R.drawable.kiwi));
        productos.add(new Producto("Mandarina",R.drawable.mandarina));
        productos.add(new Producto("Manzana",R.drawable.manzana));
        productos.add(new Producto("Naranja",R.drawable.naranja));
        productos.add(new Producto("Sandia",R.drawable.sandia));
    }

    public void listadoLineal(){
        adapter = new AdaptadorProductos(this,productos,R.layout.item_linear_layout);
        rcListado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rcListado.setAdapter(adapter);
    }

    public void listadoGrilla(){
        adapter = new AdaptadorProductos(this,productos,R.layout.item_grid_layout);
        rcListado.setLayoutManager(new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false));
        rcListado.setAdapter(adapter);
    }

    public void listadoSlider(){
        AdaptadorViewPager adaptadorViewPager = new AdaptadorViewPager(this,productos);
        viewPager.setAdapter(adaptadorViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                viewPager.setVisibility(View.GONE);
                rcListado.setVisibility(View.VISIBLE);
                listadoLineal();
                return true;
            case R.id.action_grilla:
                viewPager.setVisibility(View.GONE);
                rcListado.setVisibility(View.VISIBLE);
                listadoGrilla();
                return true;
            case R.id.action_pager:
                viewPager.setVisibility(View.VISIBLE);
                rcListado.setVisibility(View.GONE);
                listadoSlider();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
