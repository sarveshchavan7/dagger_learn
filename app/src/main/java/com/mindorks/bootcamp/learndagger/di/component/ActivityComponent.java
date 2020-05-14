package com.mindorks.bootcamp.learndagger.di.component;

import com.mindorks.bootcamp.learndagger.di.module.ActivityModule;
import com.mindorks.bootcamp.learndagger.di.scope.ActivityScope;
import com.mindorks.bootcamp.learndagger.ui.HomeFragment;
import com.mindorks.bootcamp.learndagger.ui.MainActivity;

import dagger.Component;

/*  The MainActivity needs MainViewModel
 *  We can directly get that from ActivityModule (In this case not but we can).
 */

/*  MainViewModel depends on NetworkService & DatabaseService
 *  which are singleton and we need them from Application module
 *  hence in here we have provided "dependencies = {ApplicationComponent.class}"
 *  boz ActivityComponent is dependent on ApplicationComponent
 */

/* In this case we have provided MainViewModel using constructor injection
 * And that dependencies are in Application module
 */

/*  To share instances across components we use dependencies= ""..
 */

@ActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);

}
