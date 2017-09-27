package patterns.juanjo.roomexample.features.detail;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.features.create.CreateFragment;
import patterns.juanjo.roomexample.util.BaseActivity;

public class DetailActivity extends BaseActivity {

  private static final String TAG_DETAIL_FRAGMENT = "DETAIL_FRAGMENT";
  private static final String DETAIL_ITEM_ID = "DETAIL_ITEM_ID";


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    Intent i = getIntent();

    if (i.hasExtra(DETAIL_ITEM_ID)){
      String itemId = i.getStringExtra(DETAIL_ITEM_ID);

      FragmentManager fManager = getSupportFragmentManager();

      DetailFragment detailFragment = (DetailFragment) fManager.findFragmentByTag(DETAIL_ITEM_ID);

      if (detailFragment == null) {
        detailFragment = DetailFragment.newInstance(itemId);
      }

      addFragmentToActivity(fManager,detailFragment,R.id.detail_container,TAG_DETAIL_FRAGMENT);

    } else {
      Toast.makeText(this, R.string.error_no_extra_found, Toast.LENGTH_LONG).show();
    }

  }
}
