package patterns.juanjo.roomexample.features.list;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.RoomApp;
import patterns.juanjo.roomexample.data.entity.Message;
import patterns.juanjo.roomexample.features.create.CreateActivity;
import patterns.juanjo.roomexample.viewmodel.MessagesViewModel;

public class ListFragment extends LifecycleFragment {

  @BindView(R.id.rec_list_messages) RecyclerView mRecycler;
  @BindView(R.id.fab_create_message) FloatingActionButton mFab;
  @BindView(R.id.toolbar)Toolbar mToolbar;

  @Inject ViewModelProvider.Factory viewModelFactory;
  MessagesViewModel messagesViewModel;
  MessageListAdapter mAdapter;

   public ListFragment() {
    // Required empty public constructor
  }

  public static ListFragment newInstance() {
    ListFragment fragment = new ListFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((RoomApp)getActivity().getApplication()).getAppComponent().inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_list, container, false);
    ButterKnife.bind(this,view);
    mToolbar.setTitle(R.string.app_name);
    mToolbar.setTitleTextColor(Color.WHITE);
    initializeRecycler();
    handleFab();
    return view;
  }


  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    messagesViewModel = ViewModelProviders.of(this,viewModelFactory).get(MessagesViewModel.class);
    messagesViewModel.getMessages().observe(this, new Observer<List<Message>>() {
      @Override public void onChanged(@Nullable List<Message> messages) {
          if(messages.size() != 0)
           mAdapter.setMessages(messages);
          else
           showEmptyView();
      }
    });
  }

   void initializeRecycler(){
    mRecycler.setHasFixedSize(true);
    mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    mAdapter = new MessageListAdapter();
    mRecycler.setAdapter(mAdapter);
  }

 private void handleFab() {
    mFab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(getActivity(), CreateActivity.class));
      }
    });
  }

  private void showEmptyView() {
  }

}
