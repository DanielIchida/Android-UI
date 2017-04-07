package com.example.daniel.layoutpersonalizado.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.layoutpersonalizado.R;
import com.example.daniel.layoutpersonalizado.entities.Producto;

import java.util.List;



public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ProductosViewHolder>{

    private Context context;
    private List<Producto> productos;
    private int layout;

    public AdaptadorProductos(Context context , List<Producto> productos , int layout){
        this.context = context;
        this.productos = productos;
        this.layout = layout;
    }

    public static class ProductosViewHolder extends RecyclerView.ViewHolder{

        private TextView txtProducto;
        private ImageView imgProducto;

        public ProductosViewHolder(View itemView) {
            super(itemView);
            txtProducto = (TextView)itemView.findViewById(R.id.textView);
            imgProducto = (ImageView)itemView.findViewById(R.id.imageView);
        }

        public void bindProducto(Producto p) {
            txtProducto.setText(p.getNombre());
            imgProducto.setImageResource(p.getImagen());
        }
    }

    @Override
    public ProductosViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(layout,parent, false);
        ProductosViewHolder productosViewHolder = new ProductosViewHolder(itemView);
        return productosViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductosViewHolder holder, int position) {
        Producto p = productos.get(position);
        holder.bindProducto(p);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

}
