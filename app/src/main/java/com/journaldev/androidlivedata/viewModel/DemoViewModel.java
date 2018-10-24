package com.journaldev.androidlivedata.viewModel;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.journaldev.androidlivedata.model.DemoData;

public class DemoViewModel extends ViewModel {

    private  final LiveData<DemoData> demoLiveData;


//    public ObservableField<DemoData>demos=new ObservableField<>();


    public DemoViewModel() {
        // a differnt source can be passed, here i am passing techcrunch
        demoLiveData = getDemoData();
    }



    public LiveData<DemoData> getDemoData() {
        final MutableLiveData<DemoData> data = new MutableLiveData<>();
        for (int i = 0; i < 50; i++) {
            DemoData   dataModel = new DemoData();
            dataModel.setTitle(String.valueOf(i));
            data.setValue(dataModel);
        }
        return data;
    }

    public LiveData<DemoData> getObservableProject() {
        return demoLiveData;
    }

}

