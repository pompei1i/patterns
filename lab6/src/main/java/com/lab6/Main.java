package com.lab6;

import com.lab6.app.Application;
import com.lab6.di.AppComponent;
import com.lab6.di.DaggerAppComponent;

public class Main {

    public static void main(String[] args) {
        AppComponent component = DaggerAppComponent.create();
        Application app = component.application();
        app.run();
    }
}
