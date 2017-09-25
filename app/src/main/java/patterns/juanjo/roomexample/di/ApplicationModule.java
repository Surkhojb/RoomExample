package patterns.juanjo.roomexample.di;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import patterns.juanjo.roomexample.RoomApp;

/**
 * Created by juanj on 25/09/2017.
 */
@Module
public class ApplicationModule {

  private final RoomApp application;
  public ApplicationModule(RoomApp application) {
    this.application = application;
  }

  @Provides
  RoomApp provideRoomDemoApplication(){
    return application;
  }
}
