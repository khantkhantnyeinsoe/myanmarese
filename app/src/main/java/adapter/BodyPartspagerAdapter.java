package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.ArmFragment;
import fragment.DateFragment;
import fragment.FaceFragment;
import fragment.HandAndFingerFragment;
import fragment.InternalPartsFragment;
import fragment.LegAndFootFragment;
import fragment.OtherPartsFragment;
import fragment.TimeFragment;

/**
 * Created by khant on 4/16/17.
 */

public class BodyPartspagerAdapter extends FragmentPagerAdapter {
    /*private String tabTitles[] = new String[] { "Face", "Arm","Hand and Fingers","Leg and Foot","Internal parts of body","Other parts of body"};*/
    private String tabTitles[] = new String[] { "External Parts", "Internal Parts","Other Parts"};
    public BodyPartspagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FaceFragment();
            case 1:
                return new ArmFragment();
            case 2:
                return new HandAndFingerFragment();
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
