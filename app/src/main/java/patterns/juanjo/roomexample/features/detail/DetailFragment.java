package patterns.juanjo.roomexample.features.detail;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import javax.inject.Inject;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.RoomApp;
import patterns.juanjo.roomexample.data.entity.Message;
import patterns.juanjo.roomexample.viewmodel.MessageViewModel;

public class DetailFragment extends LifecycleFragment {
  private static final String DETAIL_ITEM_ID = "DETAIL_ITEM_ID";

  @BindView(R.id.tv_date) TextView mDate;
  @BindView(R.id.tv_title) TextView mTitle;
  @BindView(R.id.tv_description) TextView mDescription;

  @Inject ViewModelProvider.Factory viewModelFactory;
  MessageViewModel messageViewModel;

  String itemId;

  public DetailFragment() {
    // Required empty public constructor
  }

  public static DetailFragment newInstance(String itemId) {
    DetailFragment fragment = new DetailFragment();
    Bundle args = new Bundle();
    args.putString(DETAIL_ITEM_ID, itemId);
    fragment.setArguments(args);

    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    this.itemId = args.getString(DETAIL_ITEM_ID);

    ((RoomApp) getActivity().getApplication())
        .getAppComponent()
        .inject(this);

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_detail, container, false);
    ButterKnife.bind(this,view);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    messageViewModel = ViewModelProviders.of(this,viewModelFactory).get(MessageViewModel.class);
    messageViewModel.getMessages(itemId).observe(this, new Observer<Message>() {
      @Override public void onChanged(@Nullable Message message) {
        if(message != null) {
          mTitle.setText(message.getTitle());
          mDate.setText(message.getTimeOfDay());
          mDescription.setText(message.getMessage());
        }
        else Toast.makeText(getContext(),"Error loading description",Toast.LENGTH_SHORT).show();
      }
    });

  }
}
