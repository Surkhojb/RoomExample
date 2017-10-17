package patterns.juanjo.roomexample.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by juanj on 25/09/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
  public static void addFragmentToActivity(FragmentManager fragmentManager,Fragment fragment,
      int container,String tag){
    if(fragment.isAdded()) return;

    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.add(container,fragment,tag);
    transaction.commit();
  }
}
