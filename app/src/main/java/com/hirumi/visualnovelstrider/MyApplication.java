package com.hirumi.visualnovelstrider;

import android.app.Application;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
}
