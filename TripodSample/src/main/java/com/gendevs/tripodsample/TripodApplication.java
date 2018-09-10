package com.gendevs.tripodsample;

import android.app.Application;

import com.gendevs.tripod.Tripod;


public class TripodApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Tripod tripod = new Tripod("02b3ea3e78c0565");
        tripod.setup(this,true);

    }
}
