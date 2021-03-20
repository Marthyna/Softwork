package com.example.mariana.softwork20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import classesDominio.Aplicacao;

public class AplicacaoAdapter extends RecyclerView.Adapter<AplicacaoAdapter.MyViewHolder> {
    private List<Aplicacao> listaAplicacoes;
    private AplicacaoOnClickListener aplicacaoOnClickListener;

    public AplicacaoAdapter(List<Aplicacao> listaAplicacoes, AplicacaoOnClickListener aplicacaoOnClickListener){
        this.listaAplicacoes = listaAplicacoes;
        this.aplicacaoOnClickListener = aplicacaoOnClickListener;
    }

    @Override
    public AplicacaoAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aplicacao_list_row, parent, false);

        return new MyViewHolder (itemView);
    }

    @Override
    public void onBindViewHolder (final AplicacaoAdapter.MyViewHolder holder, final int position) {
        Aplicacao minhaApp = listaAplicacoes.get(position);
        holder.tvAplicacaoNome.setText(minhaApp.getAluno().getNomeCompleto());

        if (aplicacaoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aplicacaoOnClickListener.onClickAplicacao(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaAplicacoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvAplicacaoNome;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvAplicacaoNome = (TextView) itemView.findViewById(R.id.tvAplicacaoNome);
        }
    }

    public interface AplicacaoOnClickListener {
        public void onClickAplicacao (View view, int position);
    }
}
