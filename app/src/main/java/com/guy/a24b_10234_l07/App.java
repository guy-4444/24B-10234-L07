package com.guy.a24b_10234_l07;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MCT6.initHelper();
    }
}
