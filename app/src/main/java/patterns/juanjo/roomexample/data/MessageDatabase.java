package patterns.juanjo.roomexample.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import patterns.juanjo.roomexample.data.entity.Message;
import patterns.juanjo.roomexample.data.entity.MessageDao;

/**
 * Created by juanj on 25/09/2017.
 */

@Database(entities = { Message.class }, version = 1)
public abstract class MessageDatabase extends RoomDatabase{

  public abstract MessageDao messageDao();
}
