package patterns.juanjo.roomexample.data;

import android.arch.lifecycle.LiveData;
import java.util.List;
import javax.inject.Inject;
import patterns.juanjo.roomexample.data.entity.Message;
import patterns.juanjo.roomexample.data.entity.MessageDao;

/**
 * Created by juanj on 25/09/2017.
 */

public class MessageRepository implements Repository {
  private final MessageDao messageDao;

  @Inject public MessageRepository(MessageDao msgDao) {
    this.messageDao = msgDao;
  }

  @Override public LiveData<List<Message>> getMessages() {
    return messageDao.getMessages();
  }

  @Override public LiveData<Message> getMessage(String id) {
    return messageDao.getMessage(id);
  }

  @Override public Long insertMessage(Message msg) {
    return messageDao.insertMessage(msg);
  }

  @Override public void deleteMessage(Message msg) {
      messageDao.deleteMessage(msg);
  }
}
