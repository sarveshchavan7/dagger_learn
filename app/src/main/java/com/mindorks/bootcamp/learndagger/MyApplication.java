package com.mindorks.bootcamp.learndagger;

import android.app.Application;

import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.component.ApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.component.DaggerApplicationComponent;
import com.mindorks.bootcamp.learndagger.di.module.ApplicationModule;

import javax.inject.Inject;

public class MyApplication extends Application {

    public ApplicationComponent applicationComponent;

    /* DatabaseService & NetworkService creation are expensive so marked as singleton
     * Bcoz they take large size on heap
     */

    /*  After the inject called on "applicationComponent"
     *  This field will get populated
     */
    @Inject
    NetworkService networkService;

    /*  Now if you see in the module There is no DatabaseService we can either provide that
     *  or can make constructor injection for DatabaseService class with fields in constructor
     *  provided in module
     */
    @Inject
    DatabaseService databaseService;

    @Override
    public void onCreate() {
        super.onCreate();
        getDependencies();
    }

    public void getDependencies() {

        /* DaggerApplicationComponent generated due to annotation processing
         * during build time
         */

        /* We have also provided module below */

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

        /*  After inject it will scan the class
         *  And will check for injection and will
         *  Use module to provide it.
         */
    }
}