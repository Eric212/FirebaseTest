package com.ericsospedra.firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.Locale;

public class ProductoAdapter extends FirestoreRecyclerAdapter<Producto,ProductoAdapter.ProductoViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProductoAdapter(@NonNull FirestoreRecyclerOptions<Producto> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProductoAdapter.ProductoViewHolder holder, int position, @NonNull Producto model) {
        holder.onBindProducto(model);
    }

    @NonNull
    @Override
    public ProductoAdapter.ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_item,parent,false));
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvCategoria;
        private TextView tvPrecio;
        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCategoria = itemView.findViewById(R.id.tvCategoria);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }

        public void onBindProducto(Producto producto) {
            tvNombre.setText(producto.getNombre());
            tvCategoria.setText(producto.getCategoria().getNombre());
            tvPrecio.setText(String.format(Locale.US,"%.2f",producto.getPrecio()));
        }
    }
}
