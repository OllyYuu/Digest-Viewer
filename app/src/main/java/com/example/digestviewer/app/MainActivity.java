package com.example.digestviewer.app;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import com.example.digestviewer.app.fragments.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            pushFragment(FragmentId.FRAGMENT_MAIN);
        }
    }

    public void pushFragment(FragmentId fragmentId){
        pushFragment(fragmentId, null);
    }

    public void pushFragment(FragmentId fragmentId, @Nullable Bundle args) {
        BaseFragment fragment = null;
        switch (fragmentId) {
            case FRAGMENT_MAIN:
                fragment = new MainFragment();
                break;
            case FRAGMENT_LIST:
                fragment = new ListFragment();
                break;
            case FRAGMENT_ARTICLE:
                fragment = new ArticleFragment();
                break;
        }
        if (args != null) {
            fragment.setArguments(args);
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(fragment.getFragmentId().toString())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
