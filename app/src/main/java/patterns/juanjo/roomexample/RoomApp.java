package patterns.juanjo.roomexample;

import android.app.Application;
import patterns.juanjo.roomexample.di.ApplicationComponent;
import patterns.juanjo.roomexample.di.ApplicationModule;
import patterns.juanjo.roomexample.di.DaggerApplicationComponent;
import patterns.juanjo.roomexample.di.RoomModule;

/**
 * Created by juanj on 25/09/2017.
 */

public class RoomApp extends Application {
  private ApplicationComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    appComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .roomModule(new RoomModule(this))
        .build();
  }

  public ApplicationComponent getAppComponent(){
    return appComponent;
  }
}
