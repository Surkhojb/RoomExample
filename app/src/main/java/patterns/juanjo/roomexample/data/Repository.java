package patterns.juanjo.roomexample.data;

import android.arch.lifecycle.LiveData;
import java.util.List;
import patterns.juanjo.roomexample.data.entity.Message;

/**
 * Created by juanj on 25/09/2017.
 */

interface Repository {
  LiveData<List<Message>> getMessages();

  LiveData<Message> getMessage(String id);

  Long insertMessage(Message msg);

  void deleteMessage(Message msg);

}
