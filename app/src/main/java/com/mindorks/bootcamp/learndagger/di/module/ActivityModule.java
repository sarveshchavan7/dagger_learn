package com.mindorks.bootcamp.learndagger.di.module;

import android.app.Activity;
import android.content.Context;

import com.mindorks.bootcamp.learndagger.di.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /* We are using Qualifier here to distinguish between
     * Activity Context and Application context
     * Bcoz ApplicationModule also has Context.
     * */
    @ActivityContext
    @Provides
    Context provideContext() {
        return activity;
    }
}
