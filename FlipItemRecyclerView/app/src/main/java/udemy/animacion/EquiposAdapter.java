package udemy.animacion;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by daniel on 10/03/2017.
 */

public class EquiposAdapter extends RecyclerView.Adapter<EquiposAdapter.EquiposViewHolder>{

    private List<Equipo> equipos;
    private Context context;

    public EquiposAdapter(Context context , List<Equipo> equipos){
        this.equipos = equipos;
        this.context = context;
    }


    public class EquiposViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tx_equipo , tx_estadio;
        ImageView img_equipo ,img_estadio;
        RelativeLayout capa_equipo , capa_estadio;
        int click = 1;

        public EquiposViewHolder(View itemView) {
            super(itemView);
            tx_equipo = (TextView)itemView.findViewById(R.id.item_tx__equipo);
            tx_estadio = (TextView)itemView.findViewById(R.id.item_tx_estadio);
            img_equipo = (ImageView)itemView.findViewById(R.id.item_img_equipo);
            img_estadio = (ImageView)itemView.findViewById(R.id.item_img_estadio);
            capa_estadio = (RelativeLayout)itemView.findViewById(R.id.capa_estadio);
            capa_equipo = (RelativeLayout)itemView.findViewById(R.id.capa_equipo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            click++;
            if(click % 2 == 0){
                FlipAnimator.flipView(context,capa_estadio,capa_equipo,true);
            }else {
                FlipAnimator.flipView(context,capa_estadio,capa_equipo,false);
            }
        }
    }


    @Override
    public EquiposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_equipo, parent, false);
        return new EquiposViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EquiposViewHolder holder, int position) {
            Equipo equipo = equipos.get(position);
            holder.tx_equipo.setText(equipo.getNombre());
            holder.tx_estadio.setText(equipo.getNom_estadio());
            holder.tx_estadio.setTextColor(Color.parseColor(equipo.getTx_color()));
            holder.capa_estadio.setBackgroundColor(Color.parseColor(equipo.getBg_color()));
            holder.img_equipo.setImageResource(equipo.getLogo());
            holder.img_estadio.setImageResource(equipo.getImg_estadio());

    }

    @Override
    public int getItemCount() {
        return equipos.size();
    }


}
