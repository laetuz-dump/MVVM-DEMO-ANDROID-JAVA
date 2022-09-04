package com.neotica.mvvmdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AppViewModel extends ViewModel {
    //4. LiveData
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
    //3. Connect ViewModel with Model(Or Database in most projects).
    private Model getAppFromDatabase(){
        return new Model("MVVM DEMO",233,5);
    }
    //5. Connecting ViewModel with MainActivity
    public void getAppName(){
        String appName = getAppFromDatabase().getAppName();
        mutableLiveData.setValue(appName);
    }
}
