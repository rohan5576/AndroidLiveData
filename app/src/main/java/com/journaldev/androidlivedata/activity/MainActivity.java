package com.journaldev.androidlivedata.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;

import com.journaldev.androidlivedata.R;
import com.journaldev.androidlivedata.adapter.FavAdapter;
import com.journaldev.androidlivedata.databinding.ActivityMainBinding;
import com.journaldev.androidlivedata.model.Favourites;
import com.journaldev.androidlivedata.viewModel.FavouritesViewModel;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FavAdapter mFavAdapter;
    private FavouritesViewModel mFavViewModel;
    private List<Favourites> mFav;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding activityMainBinding =DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFavAdapter=new FavAdapter();
        activityMainBinding.recyclerView.setAdapter(mFavAdapter);

        mFavViewModel = ViewModelProviders.of(this).get(FavouritesViewModel.class);
        observeViewModel(mFavViewModel);


        activityMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText inUrl = new EditText(MainActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("New favourite")
                        .setMessage("Add a url link below")
                        .setView(inUrl)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String url = String.valueOf(inUrl.getText());
                                long date = (new Date()).getTime();
                                // VM AND VIEW
                                mFavViewModel.addFav(url, date);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });

    }

    private void observeViewModel(final FavouritesViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getFavs().observe(this, new Observer<List<Favourites>>(){
            @Override
            public void onChanged(@Nullable List<Favourites> favourites) {
                if (favourites != null) {
                    mFavAdapter.setProjectList(favourites);
                }
            }

        });
    }


}
