package patterns.juanjo.roomexample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import java.util.List;
import patterns.juanjo.roomexample.data.MessageRepository;
import patterns.juanjo.roomexample.data.entity.Message;

/**
 * Created by juanj on 25/09/2017.
 */

public class MessageViewModel extends ViewModel {
  private MessageRepository repository;

  public MessageViewModel(MessageRepository repo){
    this.repository = repo;
  }

  public LiveData<Message> getMessages(String id){
    return  repository.getMessage(id);
  }
}
