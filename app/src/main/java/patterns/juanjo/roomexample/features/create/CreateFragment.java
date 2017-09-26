package patterns.juanjo.roomexample.features.create;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.inject.Inject;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.RoomApp;
import patterns.juanjo.roomexample.data.entity.Message;
import patterns.juanjo.roomexample.features.list.ListActivity;
import patterns.juanjo.roomexample.viewmodel.NewMessageViewModel;

public class CreateFragment extends LifecycleFragment {
  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.ed_title) EditText mTitle;
  @BindView(R.id.ed_description) EditText mDescription;
  int color = Color.RED;

  @Inject
  ViewModelProvider.Factory viewModelFactory;
  NewMessageViewModel newMessageViewModel;

  public CreateFragment() {
    // Required empty public constructor
  }
  public static CreateFragment newInstance() {
    CreateFragment fragment = new CreateFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ((RoomApp)getActivity().getApplication()).getAppComponent().inject(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_create, container, false);
    ButterKnife.bind(this,view);
    mToolbar.setTitle(R.string.app_name);
    mToolbar.setTitleTextColor(Color.WHITE);
    return view;
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    newMessageViewModel = ViewModelProviders.of(this,viewModelFactory).get(NewMessageViewModel.class);
  }

  @OnClick(R.id.btn_save)
  public void onSaveMessage(View v){
    if(!mTitle.getText().toString().isEmpty() || !mDescription.getText().toString().isEmpty()) {
      Message message = new Message(mTitle.getText().toString(), mDescription.getText().toString()
          ,getDate(),color);
      newMessageViewModel.addNewItemToDatabase(message);

      backToListActivity();
    }
    else
      Toast.makeText(getContext(),"Message's fields can't be empty",Toast.LENGTH_SHORT).show();
    }

  @OnClick(R.id.btn_cancel)
  public void onCancelCreation(View v){
    backToListActivity();
  }

  @OnClick({R.id.rd_red,R.id.rd_blue,R.id.rd_green})
  public void onRadioButtonGroup(RadioButton rd){
      boolean checked = rd.isChecked();
      switch (rd.getId()){
        case R.id.rd_red:
            if(checked)color = Color.RED;
          break;
        case R.id.rd_blue:
            if(checked)color = Color.BLUE;
          break;
        case R.id.rd_green:
            if(checked)color = Color.GREEN;
          break;
      }
  }

  private void backToListActivity() {
    startActivity(new Intent(getActivity(), ListActivity.class));
  }

  public String getDate() {
    return new SimpleDateFormat("dd/MM/yyyy/hh:mm").format(Calendar.getInstance().getTime());
  }
}
