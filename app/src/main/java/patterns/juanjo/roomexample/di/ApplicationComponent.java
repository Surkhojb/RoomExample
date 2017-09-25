package patterns.juanjo.roomexample.di;

import android.support.v4.app.ListFragment;
import dagger.Component;
import javax.inject.Singleton;
import patterns.juanjo.roomexample.features.create.CreateFragment;
import patterns.juanjo.roomexample.features.detail.DetailFragment;

/**
 * Created by juanj on 25/09/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class,RoomModule.class})
public interface ApplicationComponent {
  void inject(ListFragment listFragment);
  void inject(CreateFragment createFragment);
  void inject(DetailFragment detailFragment);
}
