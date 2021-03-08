package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("swziuFiIhaPD8Q5ijdxdDQrWijYDWW1GjBuTNApv")
                .clientKey("xNQubZURfTXSWpSeapNrEL7KU5TGnuJYLLhotZxv")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
