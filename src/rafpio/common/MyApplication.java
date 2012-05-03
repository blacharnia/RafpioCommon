package rafpio.common;

import android.app.Application;

//TODO: you need to set the "class" attribute within the <application> tag 
//in the AndroidManifest.xml
public class MyApplication extends Application {

    public static MyApplication getInstance() {
        return instance;
    }

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

}
