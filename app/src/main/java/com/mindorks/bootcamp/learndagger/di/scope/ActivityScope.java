package com.mindorks.bootcamp.learndagger.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/*  This is how we create scope in dagger
 *
 * */
@Scope
@Retention(RetentionPolicy.SOURCE)
public @interface ActivityScope {
}