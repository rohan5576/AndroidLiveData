package com.journaldev.androidlivedata.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.journaldev.androidlivedata.R;
import com.journaldev.androidlivedata.databinding.ItemListBinding;
import com.journaldev.androidlivedata.model.DemoData;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {


    List<DemoData>demoDataList;

    public void setDemoDataList(List<DemoData>demoDataList){
        if (this.demoDataList == null) {
            this.demoDataList = demoDataList;
        }
    }

    @NonNull
    @Override
    public DemoAdapter.DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding itemListBinding=DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list,parent,false);
        return new DemoViewHolder(itemListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoAdapter.DemoViewHolder holder, int position) {
        holder.itemListBinding.setViewModel(demoDataList.get(position));
        holder.itemListBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return demoDataList == null ? 0 : demoDataList.size();
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        ItemListBinding itemListBinding;

        public DemoViewHolder(ItemListBinding itemView) {
            super(itemView.getRoot());
            this.itemListBinding = itemView;

        }
    }
}
