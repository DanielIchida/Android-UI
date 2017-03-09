package udemy.sqlproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daniel on 8/03/2017.
 */

public class AdaptadorAnimales  extends RecyclerView.Adapter<AdaptadorAnimales.AnimalesViewHolder>
                                implements View.OnClickListener{

    private ArrayList<Animal> animales;
    private View.OnClickListener listener;

    public AdaptadorAnimales(ArrayList<Animal> animales){
        this.animales = animales;
    }

    public static class AnimalesViewHolder
            extends RecyclerView.ViewHolder {

        private TextView nombre;
        private TextView ubicacion;

        public AnimalesViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.txNombreAnimal);
            ubicacion = (TextView)itemView.findViewById(R.id.txUbicacionAnimal);
        }

        public void bindAnimal(Animal a) {
            nombre.setText(a.getNombre());
            ubicacion.setText(a.getUbicacion());
        }
    }

    @Override
    public AnimalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal, parent, false);
        itemView.setOnClickListener(this);
        AnimalesViewHolder animalesViewHolder = new AnimalesViewHolder(itemView);
        return animalesViewHolder;
    }

    @Override
    public void onBindViewHolder(AnimalesViewHolder holder, int position) {
        Animal animal = animales.get(position);
        holder.bindAnimal(animal);
    }

    @Override
    public int getItemCount() {
        return animales.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

}
