package com.castelao.aplicacion.repaso.tools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private static MyUncaughtExceptionHandler _unCaughtExceptionHandler;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        if(_unCaughtExceptionHandler == null)
            _unCaughtExceptionHandler = new MyUncaughtExceptionHandler(this);
        else
            _unCaughtExceptionHandler.setActivity(this);

        if(Thread.getDefaultUncaughtExceptionHandler() != _unCaughtExceptionHandler)
            Thread.setDefaultUncaughtExceptionHandler(_unCaughtExceptionHandler);
    }
}
