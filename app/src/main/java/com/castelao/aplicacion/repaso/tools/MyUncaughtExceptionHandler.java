package com.castelao.aplicacion.repaso.tools;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private BaseActivity activity;
    private Thread.UncaughtExceptionHandler defaultUEH;

    public MyUncaughtExceptionHandler(BaseActivity activity) {
        this.activity = activity;
        this.defaultUEH = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void setActivity(BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        //LOGGING CODE
        //........

        defaultUEH.uncaughtException(thread, ex);

    }
}