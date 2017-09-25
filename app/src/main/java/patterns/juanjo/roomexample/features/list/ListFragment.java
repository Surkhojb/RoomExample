package patterns.juanjo.roomexample.features.list;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import patterns.juanjo.roomexample.R;

public class ListFragment extends LifecycleFragment {

   public ListFragment() {
    // Required empty public constructor
  }

  public static ListFragment newInstance() {
    ListFragment fragment = new ListFragment();
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_list, container, false);
  }
}
