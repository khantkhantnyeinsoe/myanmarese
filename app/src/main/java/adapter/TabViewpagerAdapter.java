package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.DateFragment;
import fragment.TimeFragment;

/**
 * Created by khant on 4/15/17.
 */

public class TabViewpagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Time", "Day"};

    public TabViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TimeFragment();
            case 1:
                return new DateFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
