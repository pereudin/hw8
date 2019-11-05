package ru.pereudin.hw8.presenter;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.pereudin.hw8.app.App;
import ru.pereudin.hw8.model.RetrofitApi;
import ru.pereudin.hw8.model.User;
import ru.pereudin.hw8.view.RetrofitView;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    private static final String TAG = "RetrofitPresenter";

    private String imageURL;

    @Inject
    RetrofitApi retrofitApi;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        App.getAppComponent().inject(this);
    }

    public void getString() {
        Disposable disposable = getUserObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            Log.d(TAG, "onNext: " + user.login);
            Log.d(TAG, "onNext: " + user.company);
            Log.d(TAG, "onNext: " + user.avatar);
            imageURL = user.avatar;
            getViewState().showName(user.login);
        }, throwable -> {
            Log.e(TAG, "onError: ", throwable);
        });
    }

    public Observable<User> getUserObservable() {
        return retrofitApi.requestServer();
    }

    public String getImageURL() {
        return imageURL;
    }
}
