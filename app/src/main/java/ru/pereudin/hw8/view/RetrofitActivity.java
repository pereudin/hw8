package ru.pereudin.hw8.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import ru.pereudin.hw8.R;
import ru.pereudin.hw8.presenter.RetrofitPresenter;

public class RetrofitActivity extends MvpAppCompatActivity implements RetrofitView {

    private static final String TAG = "RetrofitActivity";

    @BindView(R.id.image_activity_retrofit)
    ImageView imageView;

    @InjectPresenter
    RetrofitPresenter retrofitPresenter;

    @ProvidePresenter
    public RetrofitPresenter providePresenter() {
        return new RetrofitPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button_activity_retrofit)
    public void onClickButton(View view) {
        Log.d(TAG, "onClickButton: ");
        retrofitPresenter.getString();
        Glide
                .with(this)
                .load(retrofitPresenter.getImageURL())
                .into(imageView);
    }

    @Override
    public void showName(String name) {
        Log.d(TAG, "showName: " + name);
    }
}
