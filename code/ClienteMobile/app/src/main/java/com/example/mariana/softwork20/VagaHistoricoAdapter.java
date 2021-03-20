package com.example.mariana.softwork20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import classesDominio.Vaga;

public class VagaHistoricoAdapter extends RecyclerView.Adapter<VagaHistoricoAdapter.MyViewHolder> {
    private List<Vaga> listaVagas;
    private VagaHistoricoOnClickListener vagaHistoricoOnClickListener;

    public VagaHistoricoAdapter(List<Vaga> listaVagas, VagaHistoricoOnClickListener vagaHistoricoOnClickListener) {
        this.listaVagas = listaVagas;
        this.vagaHistoricoOnClickListener = vagaHistoricoOnClickListener;
    }

    @Override
    public VagaHistoricoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaga_historico_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VagaHistoricoAdapter.MyViewHolder holder, final int position) {
        Vaga minhaVaga = listaVagas.get(position);
        holder.tvVagaNome.setText(minhaVaga.getNome());
        String status = "";
        if (listaVagas.get(position).isPreenchida()) {
            status = "Preenchida";
        } else {
            status = "Aberta";
        }
        holder.tvStatusVaga.setText(status);

        if (vagaHistoricoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vagaHistoricoOnClickListener.onClickVaga(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaVagas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvVagaNome, tvStatusVaga;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvVagaNome = (TextView) itemView.findViewById(R.id.tvVagaNome);
            tvStatusVaga = (TextView) itemView.findViewById(R.id.tvStatusVaga);
        }
    }

    public interface VagaHistoricoOnClickListener {
        public void onClickVaga(View view, int position);
    }
}
