package udemy.animacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = (RecyclerView)findViewById(R.id.rc_equipos);
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo("Bayer Munich","Allianz Arena",R.drawable.bayer,R.drawable.bayer_estadio,"#F44336","#FFFFFF"));
        equipos.add(new Equipo("Borussia Dortmund","Signal Iduna Park",R.drawable.dormunt,R.drawable.dormunt_estadio,"#FFFF00","#000000"));
        equipos.add(new Equipo("París Saint-Germain","Parque de los Príncipes",R.drawable.psg,R.drawable.psg_estadio,"#3F51B5","#FFFFFF"));
        equipos.add(new Equipo("Manchester City","Ciudad de Mánchester",R.drawable.machestercity,R.drawable.mancity_estadio,"#2196F3","#FFFFFF"));
        equipos.add(new Equipo("Arsenal","Emirates Stadium",R.drawable.arsenal,R.drawable.arsenal_estadio,"#827717","#FFFFFF"));
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listado.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        listado.setHasFixedSize(true);
        EquiposAdapter adapter = new EquiposAdapter(this,equipos);
        listado.setAdapter(adapter);


    }

}
