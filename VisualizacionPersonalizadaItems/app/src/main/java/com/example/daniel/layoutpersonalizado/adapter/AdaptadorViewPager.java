package com.example.daniel.layoutpersonalizado.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.layoutpersonalizado.R;
import com.example.daniel.layoutpersonalizado.entities.Producto;

import java.util.List;

public class AdaptadorViewPager extends PagerAdapter {

    private Context context;
    private List<Producto> productos;

    public AdaptadorViewPager(Context context , List<Producto> productos){
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
            Producto p = productos.get(position);
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item_view_pager_layout, container, false);
            TextView textView = (TextView)view.findViewById(R.id.textView2);
            ImageView imageView = (ImageView)view.findViewById(R.id.imageView2);
            textView.setText(p.getNombre());
            imageView.setImageResource(p.getImagen());
            container.addView(view);
            return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
    }
}
