package patterns.juanjo.roomexample.features.create;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import patterns.juanjo.roomexample.R;

public class CreateFragment extends LifecycleFragment {
  public CreateFragment() {
    // Required empty public constructor
  }
  public static CreateFragment newInstance() {
    CreateFragment fragment = new CreateFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_create, container, false);
  }
}
