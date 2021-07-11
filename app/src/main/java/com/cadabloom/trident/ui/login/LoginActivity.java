package com.cadabloom.trident.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cadabloom.trident.MainActivity;
import com.cadabloom.trident.R;
import com.cadabloom.trident.core.bus.RxBus;
import com.cadabloom.trident.core.events.LoggedInEvent;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.disposables.CompositeDisposable;

@AndroidEntryPoint
public class LoginActivity extends AppCompatActivity {

    @Inject
    RxBus rxBus;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        compositeDisposable.add(
                rxBus.listen(LoggedInEvent.class)
                        .subscribe(o -> {
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        })
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}