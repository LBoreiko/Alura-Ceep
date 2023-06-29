package br.com.alura.ceep.ui.recyclerview.adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.alura.ceep.R;
import br.com.alura.ceep.model.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter<ListaNotasAdapter.NotaViewHolder> {

    private final List<Nota> notas;
    private final Context context;

    private int quantidadeViewHolder = 0;

    public ListaNotasAdapter(Context context, List<Nota> notas) {
        this.context = context;
        this.notas = notas;
    }

    @Override // cria uma View
    public ListaNotasAdapter.NotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        quantidadeViewHolder++;
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_nota, parent, false);
        Log.i("recyclerView adapter","quantidade View Holder: " +quantidadeViewHolder);
        return new NotaViewHolder(viewCriada);
    }

    @Override // preenche a view
    public void onBindViewHolder(ListaNotasAdapter.NotaViewHolder holder, int position) {
        Nota nota = notas.get(position);
        holder.vincula(nota);

    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder {

        private final TextView titulo;
        private final TextView descricao;

        public NotaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.item_nota_titulo);
            descricao = itemView.findViewById(R.id.item_nota_descricao);
        }

        public void vincula(Nota nota) {
            preencheCampos(nota);
        }

        private void preencheCampos(Nota nota) {
            titulo.setText(nota.getTitulo());
            descricao.setText(nota.getDescricao());
        }
    }

    public void adiciona(Nota nota){
        notas.add(nota);
        notifyDataSetChanged();
    }
}
