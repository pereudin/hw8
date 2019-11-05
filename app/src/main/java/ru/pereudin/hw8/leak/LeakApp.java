package ru.pereudin.hw8.leak;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class LeakApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}