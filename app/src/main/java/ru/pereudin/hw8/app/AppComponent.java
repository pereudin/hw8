package ru.pereudin.hw8.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.pereudin.hw8.presenter.RetrofitPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(RetrofitPresenter retrofitPresenter);

}
