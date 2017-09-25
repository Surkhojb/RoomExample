package patterns.juanjo.roomexample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import patterns.juanjo.roomexample.data.MessageRepository;
import patterns.juanjo.roomexample.data.entity.Message;

/**
 * Created by juanj on 25/09/2017.
 */

public class NewMessageViewModel extends ViewModel {
  private MessageRepository repository;

  NewMessageViewModel(MessageRepository repo) {
    this.repository = repo;
  }

  /**
   * Attach our LiveData to the Database
   */
  public void addNewItemToDatabase(Message message){
    new AddMessageTask().execute(message);
  }

  private class AddMessageTask extends AsyncTask<Message, Void, Void> {

    @Override
    protected Void doInBackground(Message... item) {
      repository.insertMessage(item[0]);
      return null;
    }
  }
}
