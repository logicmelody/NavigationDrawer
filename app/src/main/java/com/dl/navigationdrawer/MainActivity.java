package com.dl.navigationdrawer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private FragmentManager mFragmentManager;

    private DrawerMenuFragment mDrawerMenuFragment;
    private ButtonFragment mButtonFragment;
    private TextViewFragment mTextViewFragment;

    private static class FragmentTag {
        public static final String TAG_DRAWER_MENU_GRAGMENT = "tag_drawer_menu_fragment";
        public static final String TAG_BUTTON_GRAGMENT = "tag_button_fragment";
        public static final String TAG_TEXTVIEW_GRAGMENT = "tag_textview_fragment";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        mFragmentManager = getFragmentManager();
        initFragments();
    }

    private void initFragments() {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        mDrawerMenuFragment = (DrawerMenuFragment) mFragmentManager.findFragmentByTag(FragmentTag.TAG_DRAWER_MENU_GRAGMENT);
        if (mDrawerMenuFragment == null) {
            mDrawerMenuFragment = new DrawerMenuFragment();
        }
        fragmentTransaction.add(R.id.drawer_menu_container, mDrawerMenuFragment);

        mButtonFragment = (ButtonFragment) mFragmentManager.findFragmentByTag(FragmentTag.TAG_BUTTON_GRAGMENT);
        if (mButtonFragment == null) {
            mButtonFragment = new ButtonFragment();
        }
        fragmentTransaction.add(R.id.content_container, mButtonFragment);

        mTextViewFragment = (TextViewFragment) mFragmentManager.findFragmentByTag(FragmentTag.TAG_TEXTVIEW_GRAGMENT);
        if (mTextViewFragment == null) {
            mTextViewFragment = new TextViewFragment();
        }

        fragmentTransaction.commit();
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
