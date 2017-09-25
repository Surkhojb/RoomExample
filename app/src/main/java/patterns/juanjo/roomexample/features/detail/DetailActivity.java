package patterns.juanjo.roomexample.features.detail;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.features.create.CreateFragment;
import patterns.juanjo.roomexample.util.BaseActivity;

public class DetailActivity extends BaseActivity {

  private static final String TAG_DETAIL_FRAGMENT = "DETAIL_FRAGMENT";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    FragmentManager fManager = getSupportFragmentManager();

    DetailFragment detailFragment = (DetailFragment) fManager.findFragmentByTag(TAG_DETAIL_FRAGMENT);
    if(detailFragment == null){
      detailFragment = detailFragment.newInstance();
    }

    addFragmentToActivity(fManager,detailFragment,R.id.createContainer,TAG_DETAIL_FRAGMENT);
  }
}
