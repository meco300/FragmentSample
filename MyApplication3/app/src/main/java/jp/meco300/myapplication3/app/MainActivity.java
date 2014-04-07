package jp.meco300.myapplication3.app;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends FragmentActivity implements FragmentMain.OnFragmentInteractionListener, SubFlagment.OnFragmentInteractionListener{

    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentMain fundamentalFragment = new FragmentMain();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fundamentalFragment);
        transaction.replace(R.id.container, fundamentalFragment);
        transaction.commit();

        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }

    public void onClickNext(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment nextFragment = new SubFlagment();
//        Fragment prevFragment = new FragmentMain();

//        transaction.add(R.id.container, nextFragment);
        transaction.replace(R.id.container, nextFragment);
//        transaction.remove(manager.findFragmentById(R.id.container));
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
