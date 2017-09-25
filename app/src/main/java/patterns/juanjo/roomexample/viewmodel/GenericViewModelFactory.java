package patterns.juanjo.roomexample.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import patterns.juanjo.roomexample.data.MessageRepository;

/**
 * Created by juanj on 25/09/2017.
 */

public class GenericViewModelFactory implements ViewModelProvider.Factory {
  private final MessageRepository repository;

  public GenericViewModelFactory(MessageRepository repository) {
    this.repository = repository;
  }

  @Override public <T extends ViewModel> T create(Class<T> modelClass) {
    if(modelClass.isAssignableFrom(MessagesViewModel.class))
      return (T) new MessagesViewModel(repository);
    else if(modelClass.isAssignableFrom(MessageViewModel.class))
      return (T) new MessageViewModel(repository);
    else if(modelClass.isAssignableFrom(NewMessageViewModel.class))
      return (T) new NewMessageViewModel(repository);
    else
      throw new IllegalArgumentException("ViewModel not found");
  }
}
