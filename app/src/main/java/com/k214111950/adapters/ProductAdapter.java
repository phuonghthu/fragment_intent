package com.k214111950.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k214111950.fragment_test3.R;
import com.k214111950.model.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    // Context và giao diện , nguồn dữ liệu

    Context context;
    int item_layout;
    List<Product> products;

    // Constructor
    public ProductAdapter(Context context, int item_layout, List<Product> products) {
        this.context = context;
        this.item_layout = item_layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Viewholder holder;
        if(view == null){
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            //Binding views
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            holder.imvThumb = view.findViewById(R.id.imvThumb);

            view.setTag(holder);
        }else{
            holder = (Viewholder) view.getTag();
        }

        //Binding data
        Product p = products.get(position);
        holder.txtName.setText(p.getProductName());
        holder.txtPrice.setText(String.format("%.0f đ", p.getProductPrice()));
        holder.imvThumb.setImageResource(p.getProductThumb());

        return view;
    }

    public  static class Viewholder{
        ImageView imvThumb;
        TextView txtName, txtPrice;
    }
}
