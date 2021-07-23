package com.hirumi.visualnovelstrider;

import com.hirumi.visualnovelstrider.network.NetworkModule;
import com.hirumi.visualnovelstrider.viewmodel.SearchViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
