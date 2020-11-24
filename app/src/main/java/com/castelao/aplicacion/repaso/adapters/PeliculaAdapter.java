package com.castelao.aplicacion.repaso.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.castelao.aplicacion.repaso.R;
import com.castelao.aplicacion.repaso.models.Pelicula;
import com.castelao.aplicacion.repaso.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.Holder> {

    private Activity act;
    private List<Pelicula> items = new ArrayList<Pelicula>();

    public PeliculaAdapter(Activity act, List<Pelicula> items) {
        this.act = act;
        this.items = items;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.pelicula_item_adapter, parent, false);
        Log.i("ADAPTER", "onCreateViewHolder");
        return new Holder(itemView);
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView txtTitle, txtYear;
        public ImageButton imgBtn;

        public ConstraintLayout linRoot;

        void initView(View v){
            txtTitle = v.findViewById(R.id.pelicula_adapter_item_name_txt);
            txtYear = v.findViewById(R.id.pelicula_adapter_item_year_txt);
            imgBtn = v.findViewById(R.id.pelicula_item_adapter_imgbtn);
        }

        public Holder(View v) {
            super(v);
            initView(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Pelicula item = items.get(position);

        String texto = item.getTitulo();
        holder.txtTitle.setText(texto);

        String year = item.getLanzamiento();
        holder.txtYear.setText(year);

        //holder.imgBtn.setImageDrawable(item.img);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}