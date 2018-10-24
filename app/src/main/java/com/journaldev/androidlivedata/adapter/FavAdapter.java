package com.journaldev.androidlivedata.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.journaldev.androidlivedata.model.Favourites;
import com.journaldev.androidlivedata.R;
import com.journaldev.androidlivedata.databinding.ItemRowBinding;


import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {

    List<Favourites>mFav;


    public void setProjectList(final List<Favourites>mFav) {

        if (mFav == null) {
            this.mFav = mFav;
            notifyItemRangeInserted(0, mFav.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {
                    return mFav.size();
                }

                @Override
                public int getNewListSize() {
                    return mFav.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mFav.get(oldItemPosition).mId ==
                    mFav.get(newItemPosition).mId;
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    Favourites oldFav = mFav.get(oldItemPosition);
                    Favourites newFav = mFav.get(newItemPosition);
                    return oldFav.equals(newFav);
                }
            });
            this.mFav = mFav;
            result.dispatchUpdatesTo(this);
        }
        }



    @Override
    public FavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemRowBinding listItemRowBinding=DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),R.layout.item_row,parent,false);
        return new FavViewHolder(listItemRowBinding);
    }

    @Override
    public void onBindViewHolder(FavViewHolder holder, int position) {

        holder.listItemRowBinding.setFav(mFav.get(position));
        holder.listItemRowBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mFav.size();
    }

    class FavViewHolder extends RecyclerView.ViewHolder {

        ItemRowBinding listItemRowBinding;

        FavViewHolder(ItemRowBinding itemView) {
            super(itemView.getRoot());
            this.listItemRowBinding=itemView;

//            mTxtUrl = itemView.findViewById(R.id.tvUrl);
//            mTxtDate = itemView.findViewById(R.id.tvDate);
//            ImageButton btnDelete = itemView.findViewById(R.id.btnDelete);
//            listItemRowBinding.btnDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int pos = getAdapterPosition();
//                    Favourites favourites = mFav.get(pos);
//                    mFavViewModel.removeFav(favourites.mId);
//                }
//            });
        }
    }
}

