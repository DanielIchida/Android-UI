package udemy.uidaniel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    GridView listado;
    ImageView grande;
    LinearLayout menu, form;
    private String[] datos = new String[100];
    int myLastVisiblePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado=(GridView)findViewById(R.id.gr_listado);
        grande = (ImageView)findViewById(R.id.imagen_grande);
        menu = (LinearLayout)findViewById(R.id.capa_menu);
        form = (LinearLayout)findViewById(R.id.capa_form);

        for(int i=1; i<=100; i++)
            datos[i-1] = "Dato " + i;

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

        listado.setAdapter(adaptador);

        myLastVisiblePos = listado.getFirstVisiblePosition();

        listado.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int currentFirstVisPos = view.getFirstVisiblePosition();
                Log.e("Scroll Estado",""+currentFirstVisPos+" - - "+myLastVisiblePos);
                if(currentFirstVisPos > myLastVisiblePos) {
                    grande.setVisibility(View.GONE);
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)listado.getLayoutParams();
                    params.weight = 15.0f;
                    listado.setLayoutParams(params);
                }
                if(currentFirstVisPos < myLastVisiblePos) {
                    if(currentFirstVisPos == 0){
                        grande.setVisibility(View.VISIBLE);
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)listado.getLayoutParams();
                        params.weight = 7.0f;
                        listado.setLayoutParams(params);
                    }
                }
                myLastVisiblePos = currentFirstVisPos;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.e("Scroll Total",""+totalItemCount);
                Log.e("Scroll visible item",""+visibleItemCount);
            }
        });

    }
}
