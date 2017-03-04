package udemy.grillacardviewdinamica;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    LinearLayout uno,dos,tres,cuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uno = (LinearLayout)findViewById(R.id.capa_uno);
        dos = (LinearLayout)findViewById(R.id.capa_dos);
        tres = (LinearLayout)findViewById(R.id.capa_tres);
        cuatro = (LinearLayout)findViewById(R.id.capa_cuatro);

        crear_grid_small(Color.BLACK,uno);
        crear_grid_small(Color.BLACK,dos);
        crear_grid_small(Color.BLACK,tres);
        crear_grid_small(Color.BLACK,cuatro);




    }

    public void crear_grid_small(int color,LinearLayout layout){
        for(int i = 0 ; i <= 3 ; i++){
            CardView capa = new CardView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 25;
            params.setMargins(30,60,30,60);
            capa.setLayoutParams(params);
            capa.setBackgroundColor(color);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                capa.setElevation(4);
            }
            layout.addView(capa);
        }
    }

    public void crear_grid_medium(int color,LinearLayout layout){
        for(int i = 0 ; i <= 2; i++){
            CardView capa = new CardView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 33.3f;
            params.setMargins(30,70,30,70);
            capa.setLayoutParams(params);
            capa.setBackgroundColor(color);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                capa.setElevation(4);
            }
            layout.addView(capa);
        }
    }

    public void crear_grid_large(int color,LinearLayout layout){
        for(int i = 0 ; i <= 1; i++){
            CardView capa = new CardView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 50f;
            params.setMargins(30,80,30,80);
            capa.setLayoutParams(params);
            capa.setBackgroundColor(color);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                capa.setElevation(4);
            }
            layout.addView(capa);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_grilla_large:
                cleanViews();
                tres.setVisibility(View.GONE);
                cuatro.setVisibility(View.GONE);
                uno.setLayoutParams(layoutParamsLarge());
                dos.setLayoutParams(layoutParamsLarge());
                crear_grid_large(Color.RED,uno);
                crear_grid_large(Color.RED,dos);
                break;
            case R.id.item_grilla_medium:
                cleanViews();
                cuatro.setVisibility(View.GONE);
                tres.setVisibility(View.VISIBLE);
                uno.setLayoutParams(layoutParamsMedium());
                dos.setLayoutParams(layoutParamsMedium());
                tres.setLayoutParams(layoutParamsMedium());
                crear_grid_medium(Color.BLUE,uno);
                crear_grid_medium(Color.BLUE,dos);
                crear_grid_medium(Color.BLUE,tres);
                break;
            case R.id.item_grilla_small:
                cleanViews();
                uno.setLayoutParams(layoutParamsSmall());
                dos.setLayoutParams(layoutParamsSmall());
                tres.setLayoutParams(layoutParamsSmall());
                cuatro.setLayoutParams(layoutParamsSmall());
                cuatro.setVisibility(View.VISIBLE);
                tres.setVisibility(View.VISIBLE);
                crear_grid_small(Color.BLACK,uno);
                crear_grid_small(Color.BLACK,dos);
                crear_grid_small(Color.BLACK,tres);
                crear_grid_small(Color.BLACK,cuatro);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cleanViews(){
        uno.removeAllViews();
        dos.removeAllViews();
        tres.removeAllViews();
        cuatro.removeAllViews();
    }

    public LinearLayout.LayoutParams layoutParamsSmall(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 25f;
        return params;
    }

    public LinearLayout.LayoutParams layoutParamsMedium(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 33.3f;
        return params;
    }
    public LinearLayout.LayoutParams layoutParamsLarge(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 50f;
        return params;
    }
}
