package patterns.juanjo.roomexample.features.detail;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import patterns.juanjo.roomexample.R;

public class DetailFragment extends LifecycleFragment {

  public DetailFragment() {
    // Required empty public constructor
  }


  public static DetailFragment newInstance() {
    DetailFragment fragment = new DetailFragment();

    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_detail, container, false);
  }
}
