package com.example.daniel.androidmodal;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout capa;
    private Button bt_main;
    private ImageView imagen;
    private EditText campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        capa = (ConstraintLayout)findViewById(R.id.model);
        bt_main = (Button)findViewById(R.id.bt_main);
        imagen = (ImageView)findViewById(R.id.imageView);
        campo = (EditText)findViewById(R.id.editText);

        capa.setVisibility(View.GONE);
        bt_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hola "+campo.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarCapa();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_modal:
                mostrarCapa();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void mostrarCapa(){
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.mostrar);
        capa.startAnimation(animation);
        capa.setVisibility(View.VISIBLE);
        bt_main.setClickable(false);
        campo.setInputType(InputType.TYPE_NULL);
    }

    public void ocultarCapa(){
        Animation animation=AnimationUtils.loadAnimation(this, R.anim.ocultar);
        capa.startAnimation(animation);
        capa.setVisibility(View.GONE);
        bt_main.setClickable(true);
        campo.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
    }


}
