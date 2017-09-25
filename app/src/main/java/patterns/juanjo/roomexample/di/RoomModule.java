package patterns.juanjo.roomexample.di;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import patterns.juanjo.roomexample.RoomApp;
import patterns.juanjo.roomexample.data.MessageDatabase;
import patterns.juanjo.roomexample.data.MessageRepository;
import patterns.juanjo.roomexample.data.entity.MessageDao;
import patterns.juanjo.roomexample.viewmodel.GenericViewModelFactory;

/**
 * Created by juanj on 25/09/2017.
 */

@Module
public class RoomModule {
  private final MessageDatabase database;
  private static final String DATABASE_NAME = "message_room.db";

  public RoomModule(RoomApp app) {
    this.database = Room.databaseBuilder(app,MessageDatabase.class,DATABASE_NAME).build();
  }

  @Provides
  @Singleton MessageRepository provideMessageRepository(MessageDao messageDao){
    return new MessageRepository(messageDao);
  }

  @Provides
  @Singleton
  MessageDao provideMessageDao(MessageDatabase database){
    return database.messageDao();
  }

  @Provides
  @Singleton
  MessageDatabase provideMessageDatabase(){
    return database;
  }

  @Provides
  @Singleton
  ViewModelProvider.Factory provideViewModelFactory(MessageRepository repository){
    return new GenericViewModelFactory(repository);
  }
}
