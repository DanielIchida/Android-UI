package udemy.sqlproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listado;
    private FloatingActionButton botonFlotante;
    private CollapsingToolbarLayout layout;
    private ViewFlipper slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        listado = (RecyclerView)findViewById(R.id.lstLista);
        layout  = (CollapsingToolbarLayout)findViewById(R.id.ctlLayout);
        botonFlotante = (FloatingActionButton)findViewById(R.id.btnFab);
        slider = (ViewFlipper)findViewById(R.id.slider);
        slider.setAutoStart(true);
        slider.setFlipInterval(3000);


        setSupportActionBar(toolbar);

        ArrayList<Animal> animales = new ArrayList<>();
        for (int i = 0 ; i < 100 ; i++)
            animales.add(new Animal("Nombre: "+i,"Ubicacion: "+i));
        AdaptadorAnimales adaptador = new AdaptadorAnimales(animales);
        listado.setAdapter(adaptador);
        listado.setLayoutManager(new GridLayoutManager(this,2));

        botonFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(layout,"CAMARA",Snackbar.LENGTH_LONG).show();
            }
        });


    }
}
