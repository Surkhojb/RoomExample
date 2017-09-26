package patterns.juanjo.roomexample.features.create;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.util.BaseActivity;

public class CreateActivity extends BaseActivity {
  private static final String TAG_CREATE_FRAGMENT = "CREATE_FRAGMENT";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create);

    FragmentManager fManager = getSupportFragmentManager();

    CreateFragment createFragment = (CreateFragment) fManager.findFragmentByTag(TAG_CREATE_FRAGMENT);
    if(createFragment == null){
      createFragment = createFragment.newInstance();
    }

    addFragmentToActivity(fManager,createFragment,R.id.create_container,TAG_CREATE_FRAGMENT);
  }
}
