package udemy.layoutsdinamicos;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //TODO Variables de nuestros botones y nuestros layout
    private Button b1,b2,b3,b4;
    private RelativeLayout r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Declaraciones de nuestros botones y nuestros layout
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        r1 = (RelativeLayout)findViewById(R.id.capa_uno);
        r2 = (RelativeLayout)findViewById(R.id.capa_dos);
        r3 = (RelativeLayout)findViewById(R.id.capa_tres);
        r4 = (RelativeLayout)findViewById(R.id.capa_cuatro);

        //TODO Definir el color a cada layout
        r1.setBackgroundColor(Color.parseColor("#F44336"));
        r2.setBackgroundColor(Color.parseColor("#3F51B5"));
        r3.setBackgroundColor(Color.parseColor("#009688"));
        r4.setBackgroundColor(Color.parseColor("#FFC107"));


        //TODO Que muestre por defecto una columna
        LinearLayout.LayoutParams completo = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        r1.setLayoutParams(completo);


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    //TODO Evento para que cambie el numero de columnas
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //TODO Una columna
            case R.id.button1:
                clean();
                LinearLayout.LayoutParams completo = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                r1.setLayoutParams(completo);
                break;
            //TODO Dos columnas
            case R.id.button2:
                clean();
                LinearLayout.LayoutParams doscol = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
                doscol.weight = 5;
                doscol.setMargins(5,5,5,5);
                r1.setLayoutParams(doscol);
                r2.setLayoutParams(doscol);
                break;
            //TODO tres columnas
            case R.id.button3:
                clean();
                LinearLayout.LayoutParams trescol = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
                trescol.weight = 33.3f;
                trescol.setMargins(5,5,5,5);
                r1.setLayoutParams(trescol);
                r2.setLayoutParams(trescol);
                r3.setLayoutParams(trescol);
                break;
            //TODO Cuatro columnas
            case R.id.button4:
                clean();
                LinearLayout.LayoutParams cuatrocol = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
                cuatrocol.weight = 2.5f;
                cuatrocol.setMargins(5,5,5,5);
                r1.setLayoutParams(cuatrocol);
                r2.setLayoutParams(cuatrocol);
                r3.setLayoutParams(cuatrocol);
                r4.setLayoutParams(cuatrocol);
                break;
        }

    }

    //TODO Reiniciar el valor de la propiedad weight a 0
    public void clean(){
        LinearLayout.LayoutParams clean = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        clean.weight = 0;
        r1.setLayoutParams(clean);
        r2.setLayoutParams(clean);
        r3.setLayoutParams(clean);
        r4.setLayoutParams(clean);
    }

}
