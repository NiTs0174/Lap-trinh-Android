package com.example.demoproduct.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.demoproduct.R;
import com.example.demoproduct.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> listProduct;
    public ProductAdapter(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewProduct = LayoutInflater.from( parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(viewProduct);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = listProduct.get(position);
        holder.txtName.setText(p.getTitle());
        holder.txtUrl.setText(String.valueOf(p.getUrl()));
        if(p.getImage().startsWith("https://"))
        {
            Glide.with(holder.imgView.getContext()).load(p.getImage()).into(holder.imgView);
        }
    }
    @Override
    public int getItemCount() {
        return listProduct.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtName, txtUrl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgProduct);
            txtName = (TextView)   itemView.findViewById(R.id.txtName);
            txtUrl = (TextView)   itemView.findViewById(R.id.txtUrl);
        }
    }
}
