package myrecyclerview.simpleapp.com.myrecyclerviewproject.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import myrecyclerview.simpleapp.com.myrecyclerviewproject.imageslist.ImageData;

public class MyPageAdapter extends FragmentPagerAdapter {

    private static final ArrayList<String> titles = new ArrayList<>();
    private static ArrayList<ImageData> imageDataArrayList = new ArrayList<>();

//    public void addFragment(Fragment fragment, String title) {
//        titles.add(title);
//        fragments.add(fragment);
//    }

    public MyPageAdapter(FragmentManager fm, ArrayList<ImageData> _imageDataArrayList) {
        super(fm);
        imageDataArrayList = _imageDataArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentMain.newInstance(imageDataArrayList.get(position).webformatURL);
    }

    @Override
    public int getCount() {
        return imageDataArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}


