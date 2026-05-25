package com.lab6.di;

import com.lab6.app.Application;
import dagger.Component;

@Component
public interface AppComponent {
    Application application();
}
