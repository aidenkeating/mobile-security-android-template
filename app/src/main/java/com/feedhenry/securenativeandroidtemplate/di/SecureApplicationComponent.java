package com.feedhenry.securenativeandroidtemplate.di;

import android.app.Application;
import android.content.Context;

import com.feedhenry.securenativeandroidtemplate.SecureApplication;
import com.feedhenry.securenativeandroidtemplate.domain.crypto.AesCrypto;
import com.feedhenry.securenativeandroidtemplate.domain.repositories.NoteRepository;
import com.feedhenry.securenativeandroidtemplate.domain.services.NoteCrudlService;
import com.feedhenry.securenativeandroidtemplate.features.authentication.providers.OpenIDAuthenticationProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Define the dependencies of the app. Used by Dagger2 to build dependency graph.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, SecureApplicationModule.class, MainActivityModule.class })
public interface SecureApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);

        SecureApplicationComponent build();
    }

    void inject(SecureApplication app);

    Context context();
    AesCrypto provideAesCrypto();

    NoteRepository noteRepository();
    OpenIDAuthenticationProvider authProvider();

    NoteCrudlService provideNoteCrudleService();
}
