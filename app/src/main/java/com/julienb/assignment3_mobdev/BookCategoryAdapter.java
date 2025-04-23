package com.julienb.assignment3_mobdev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookCategoryAdapter extends RecyclerView.Adapter<BookCategoryAdapter.ViewHolder> {

    public interface OnCategoryClickListener {
        void onCategoryClick(String category);
    }

    private List<String> categories;
    private List<Integer> categoryImg;
    private OnCategoryClickListener listener;

    public BookCategoryAdapter(List<String> categories, List<Integer> categoryImg, OnCategoryClickListener listener) {
        this.categories = categories;
        this.categoryImg = categoryImg;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String category = categories.get(position);
        Integer categoryI = categoryImg.get(position);
        holder.categoryName.setText(category);
        holder.categoryImage.setImageResource(categoryI);
        holder.itemView.setOnClickListener(v -> listener.onCategoryClick(category));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageButton categoryImage;
        ViewHolder(View view) {
            super(view);
            categoryName = view.findViewById(R.id.category_name);
            categoryImage = view.findViewById(R.id.category_img);
        }
    }
}

