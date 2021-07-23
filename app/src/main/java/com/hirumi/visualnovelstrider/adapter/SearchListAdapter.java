package com.hirumi.visualnovelstrider.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hirumi.visualnovelstrider.R;
import com.hirumi.visualnovelstrider.databinding.ItemListBinding;
import com.hirumi.visualnovelstrider.viewmodel.SearchViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    private ArrayList<SearchViewModel> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public SearchListAdapter(ArrayList<SearchViewModel> test, Context context) {
        this.arrayList = test;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public SearchListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemListBinding itemListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_list, parent, false);
        return new ViewHolder(itemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SearchListAdapter.ViewHolder holder, int position) {
        SearchViewModel searchViewModel = arrayList.get(position);
        holder.bind(searchViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemListBinding itemListBinding;

        public ViewHolder(@NonNull @NotNull ItemListBinding itemListBinding) {
            super(itemListBinding.getRoot());
            this.itemListBinding = itemListBinding;
        }

        public void bind(SearchViewModel viewModel) {
            this.itemListBinding.setViewmodel(viewModel);
            itemListBinding.executePendingBindings();
        }

        public ItemListBinding getItemListBinding() {
            return itemListBinding;
        }
    }
}
