package com.example.mariana.softwork20;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import classesDominio.Mensagem;
import classesDominio.Vaga;

public class MensagemAlunoAdapter extends RecyclerView.Adapter<MensagemAlunoAdapter.MyViewHolder> {
    private List<Mensagem> listaMensagensAluno;
    private MensagemAlunoOnClickListener mensagemAlunoOnClickListener;

    public MensagemAlunoAdapter(List<Mensagem> listaMensagensAluno, MensagemAlunoOnClickListener mensagemAlunoOnClickListener){
        this.listaMensagensAluno = listaMensagensAluno;
        this.mensagemAlunoOnClickListener = mensagemAlunoOnClickListener;
    }

    @Override
    public MensagemAlunoAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mensagem_aluno_list_row, parent, false);

        return new MyViewHolder (itemView);
    }

    @Override
    public void onBindViewHolder (final MensagemAlunoAdapter.MyViewHolder holder, final int position) {
        Mensagem minhaMsg = listaMensagensAluno.get(position);
        holder.tvMensagemAlunoAssunto.setText(minhaMsg.getAssunto());
        holder.tvMensagemAlunoNomeEmpresa.setText(minhaMsg.getEmpresa().getNomeFantasia());

        if (mensagemAlunoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mensagemAlunoOnClickListener.onClickMensagemAluno(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaMensagensAluno.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMensagemAlunoAssunto, tvMensagemAlunoNomeEmpresa;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvMensagemAlunoAssunto = (TextView) itemView.findViewById(R.id.tvMensagemAlunoAssunto);
            tvMensagemAlunoNomeEmpresa = (TextView) itemView.findViewById(R.id.tvMensagemAlunoNomeEmpresa);
        }
    }

    public interface MensagemAlunoOnClickListener {
        public void onClickMensagemAluno (View view, int position);
    }
}
