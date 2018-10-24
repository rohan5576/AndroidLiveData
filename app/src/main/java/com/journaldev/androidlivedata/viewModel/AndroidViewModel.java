package com.journaldev.androidlivedata.viewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

public class AndroidViewModel extends ViewModel {

        @SuppressLint("StaticFieldLeak")
        private Application mApplication;

        public AndroidViewModel(@NonNull Application application) {
            mApplication = application;
        }

    }
