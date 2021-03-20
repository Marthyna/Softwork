package com.example.mariana.softwork20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import classesDominio.Vaga;

public class VagaAdapter extends RecyclerView.Adapter<VagaAdapter.MyViewHolder> {
    private List<Vaga> listaVagas;
    private VagaOnClickListener vagaOnClickListener;

    public VagaAdapter(List<Vaga> listaVagas, VagaOnClickListener vagaOnClickListener){
        this.listaVagas = listaVagas;
        this.vagaOnClickListener = vagaOnClickListener;
    }

    @Override
    public VagaAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vaga_list_row, parent, false);

        return new MyViewHolder (itemView);
    }

    @Override
    public void onBindViewHolder (final VagaAdapter.MyViewHolder holder, final int position) {
        Vaga minhaVaga = listaVagas.get(position);
        holder.tvVagaNome.setText(minhaVaga.getNome());

        if (vagaOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vagaOnClickListener.onClickVaga(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaVagas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvVagaNome;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvVagaNome = (TextView) itemView.findViewById(R.id.tvVagaNome);
        }
    }

    public interface VagaOnClickListener {
        public void onClickVaga (View view, int position);
    }
}
