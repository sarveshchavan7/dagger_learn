package com.mindorks.bootcamp.learndagger.di.component;

import android.content.Context;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.data.local.DatabaseService;
import com.mindorks.bootcamp.learndagger.data.remote.NetworkService;
import com.mindorks.bootcamp.learndagger.di.module.ApplicationModule;
import com.mindorks.bootcamp.learndagger.di.qualifier.ApplicationContext;
import com.mindorks.bootcamp.learndagger.utils.NetworkHelper;

import javax.inject.Singleton;

import dagger.Component;

/* We have annotated as Singleton
 * bcoz we are saying that we will hold
 * all instance as singleton
 */

/* If we remove singleton from here
 * and just keep on method in module it wont work
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    /*  In order to use access anything which is hold by ApplicationComponent
     *  we need to create method like this
     */

    /* We are saying that we will me sharing the below instance with other components */

    /* Since MainViewModel is scoped to activity and it's (Constructor)dependencies are in application
     *  component therefore ActivityComponent has ApplicationComponent as dependencies
     *  and here we are saying that below instances are accessible to other components
     */

    NetworkService getNetworkService();


    DatabaseService getDatabaseService();

    NetworkHelper getNetworkHelperService();

    @ApplicationContext
    Context getContext();

}
