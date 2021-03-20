package com.example.mariana.softwork20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import classesDominio.Aplicacao;

public class AplicacaoHistoricoAdapter extends RecyclerView.Adapter<AplicacaoHistoricoAdapter.MyViewHolder> {
    private List<Aplicacao> listaAplicacoesHistorico;
    private AplicacaoHistoricoOnClickListener aplicacaoHistoricoOnClickListener;

    public AplicacaoHistoricoAdapter(List<Aplicacao> listaAplicacoesHistorico, AplicacaoHistoricoOnClickListener aplicacaoHistoricoOnClickListener){
        this.listaAplicacoesHistorico = listaAplicacoesHistorico;
        this.aplicacaoHistoricoOnClickListener = aplicacaoHistoricoOnClickListener;
    }

    @Override
    public AplicacaoHistoricoAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aplicacao_historico_list_row, parent, false);

        return new MyViewHolder (itemView);
    }

    @Override
    public void onBindViewHolder (final AplicacaoHistoricoAdapter.MyViewHolder holder, final int position) {
        Aplicacao minhaApp = listaAplicacoesHistorico.get(position);
        holder.tvAplicacaoHistoricoNome.setText(minhaApp.getVaga().getNome());
        String status = "";
        if(minhaApp.isMovimentada()){
            if(minhaApp.isAceita()){
                status = "Aceita";
            } else {
                status = "Recusada";
            }
        } else {
            status = "Em espera";
        }
        holder.tvAplicacaoHistoricoStatus.setText(status);

        if (aplicacaoHistoricoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aplicacaoHistoricoOnClickListener.onClickAplicacaoHistorico(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaAplicacoesHistorico.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvAplicacaoHistoricoNome, tvAplicacaoHistoricoStatus;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvAplicacaoHistoricoNome = (TextView) itemView.findViewById(R.id.tvAplicacaoHistoricoNome);
            tvAplicacaoHistoricoStatus = (TextView) itemView.findViewById(R.id.tvAplicacaoHistoricoStatus);
        }
    }

    public interface AplicacaoHistoricoOnClickListener {
        public void onClickAplicacaoHistorico (View view, int position);
    }
}
