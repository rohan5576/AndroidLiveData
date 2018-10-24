package com.journaldev.androidlivedata.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.journaldev.androidlivedata.R;
import com.journaldev.androidlivedata.adapter.DemoAdapter;
import com.journaldev.androidlivedata.databinding.DemoActivityBinding;
import com.journaldev.androidlivedata.model.DemoData;
import com.journaldev.androidlivedata.viewModel.DemoViewModel;

public class DemoActivity extends AppCompatActivity {

    DemoActivityBinding demoActivityBinding;
    DemoAdapter demoAdapter;
    DemoViewModel demoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity);
        demoActivityBinding=DataBindingUtil.setContentView(this,R.layout.demo_activity);
        demoAdapter=new DemoAdapter();
//        demoActivityBinding.projectList.setAdapter(demoAdapter);


        demoViewModel  = ViewModelProviders.of(this).get(DemoViewModel.class);

        observeViewModel(demoViewModel);

    }

    private void observeViewModel(DemoViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getObservableProject().observe(this, new Observer<DemoData>() {
            @Override
            public void onChanged(@Nullable DemoData demoData) {

                if (demoData != null) {
//                    demoAdapter.setDemoDataList(demoData);
                }
            }
        });
    }
}
