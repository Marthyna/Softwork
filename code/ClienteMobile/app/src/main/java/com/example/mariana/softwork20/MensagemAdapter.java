package com.example.mariana.softwork20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import classesDominio.Mensagem;
import classesDominio.Vaga;

public class MensagemAdapter extends RecyclerView.Adapter<MensagemAdapter.MyViewHolder> {
    private List<Mensagem> listaMensagens;
    private MensagemOnClickListener mensagemOnClickListener;

    public MensagemAdapter(List<Mensagem> listaMensagens, MensagemOnClickListener mensagemOnClickListener){
        this.listaMensagens = listaMensagens;
        this.mensagemOnClickListener = mensagemOnClickListener;
    }

    @Override
    public MensagemAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mensagem_list_row, parent, false);

        return new MyViewHolder (itemView);
    }

    @Override
    public void onBindViewHolder (final MensagemAdapter.MyViewHolder holder, final int position) {
        Mensagem minhaMsg = listaMensagens.get(position);
        holder.tvMensagemAssunto.setText(minhaMsg.getAssunto());
        holder.tvMensagemNomeAluno.setText(minhaMsg.getAluno().getNomeCompleto());

        if (mensagemOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mensagemOnClickListener.onClickMensagem(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaMensagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMensagemAssunto, tvMensagemNomeAluno;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvMensagemAssunto = (TextView) itemView.findViewById(R.id.tvMensagemAssunto);
            tvMensagemNomeAluno = (TextView) itemView.findViewById(R.id.tvMensagemNomeAluno);
        }
    }

    public interface MensagemOnClickListener {
        public void onClickMensagem (View view, int position);
    }
}
