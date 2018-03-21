package in.creativelizard.creativelizard.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.creativelizard.creativelizard.R;
import in.creativelizard.creativelizard.beans.ProductItem;
import in.creativelizard.creativelizard.beans.ProductListOutput;

/**
 * Created by siddhartha on 13/3/18.
 */

 public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewAdapter.ViewHolder> {

    private ArrayList<ProductItem> productItems;
    private int itemLayout;

    public ProductViewAdapter(ArrayList<ProductItem> productItems, int itemLayout) {
        this.productItems = productItems;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // holder.imgApp
        holder.my_image_view.setImageURI(Uri.parse(productItems.get(position).getImg()));
        holder.tvName.setText(productItems.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView my_image_view;
        private TextView tvName;
         ViewHolder(View itemView) {
            super(itemView);
             my_image_view = itemView.findViewById(R.id.my_image_view);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
