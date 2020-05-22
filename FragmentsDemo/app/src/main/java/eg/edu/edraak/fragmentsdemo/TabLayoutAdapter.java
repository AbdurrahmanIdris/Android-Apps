package eg.edu.edraak.fragmentsdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> myFragmentList = new ArrayList<>();
    private final List<String> myFragmentTitlesList = new ArrayList<>();

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }//end TabLayoutAdapter constructor

    public void addFragment (Fragment fragment, String title){
        myFragmentList.add(fragment);
        myFragmentTitlesList.add(title);
    }//end addFragment


    @Override
    public Fragment getItem(int position) {
        return myFragmentList.get(position);
    }//end getItem

    @Override
    public int getCount() {
        return myFragmentList.size();
    }//end getCount

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) myFragmentList.get(position);
    }//end getPageTitle
}//end class
