package patterns.juanjo.roomexample.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import java.util.List;
import javax.inject.Inject;
import patterns.juanjo.roomexample.data.MessageRepository;
import patterns.juanjo.roomexample.data.entity.Message;

/**
 * Created by juanj on 25/09/2017.
 */

public class MessagesViewModel extends ViewModel {

  private MessageRepository repository;

  public MessagesViewModel(MessageRepository repo){
    this.repository = repo;
  }

  public LiveData<List<Message>> getMessages(){
    return  repository.getMessages();
  }

  public void deleteMessage(Message message){
    new DeleteMessageTask().execute(message);
  }

  private class DeleteMessageTask extends AsyncTask<Message,Void,Void>{

    @Override protected Void doInBackground(Message... messages) {
      repository.deleteMessage(messages[0]);
      return null;
    }
  }
}
