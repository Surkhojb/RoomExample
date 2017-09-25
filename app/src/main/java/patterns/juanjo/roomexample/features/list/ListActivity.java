package patterns.juanjo.roomexample.features.list;

import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.util.BaseActivity;

public class ListActivity extends BaseActivity {
  private static final String TAG_LIST_FRAGMENT = "LIST_FRAGMENT";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);

    FragmentManager fManager = getSupportFragmentManager();

    ListFragment  listFragment = (ListFragment) fManager.findFragmentByTag(TAG_LIST_FRAGMENT);
    if(listFragment == null){
      listFragment = ListFragment.newInstance();
    }

    addFragmentToActivity(fManager,listFragment,R.id.listContainer,TAG_LIST_FRAGMENT);
  }

}
