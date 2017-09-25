package patterns.juanjo.roomexample.data.entity;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;
import patterns.juanjo.roomexample.data.entity.Message;

/**
 * Created by juanj on 25/09/2017.
 */

@Dao
public interface MessageDao {

  @Query("SELECT * FROM Message")
  LiveData<List<Message>> getMessages();

  @Query("SELECT * FROM Message WHERE id = :id")
  LiveData<Message> getMessage(String id);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Long insertMessage(Message message);

  @Delete
  void deleteMessage(Message message);

}
