package com.abundis.cinepolis_conteo_fisico;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Almacen extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almacen1);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootview = null;

            switch (getArguments().getInt(ARG_SECTION_NUMBER)){

                case 1:
                    rootview = inflater.inflate(R.layout.fragment_almacen1,container,false);
                    break;

                case 2:
                    rootview = inflater.inflate(R.layout.fragment_almacen2,container,false);
                    break;

                case 3:
                    rootview = inflater.inflate(R.layout.fragment_almacen3,container,false);
                    break;

                case 4:
                    rootview = inflater.inflate(R.layout.fragment_almacen4,container,false);
                    break;

                case 5:
                    rootview = inflater.inflate(R.layout.fragment_almacen5,container,false);
                    break;

                case 6:
                    rootview = inflater.inflate(R.layout.fragment_almacen6,container,false);
                    break;

                case 7:
                    rootview = inflater.inflate(R.layout.fragment_almacen7,container,false);
                    break;

                case 8:
                    rootview = inflater.inflate(R.layout.fragment_almacen8,container,false);
                    break;

                case 9:
                    rootview = inflater.inflate(R.layout.fragment_almacen9,container,false);
                    break;

                case 10:
                    rootview = inflater.inflate(R.layout.fragment_almacen10,container,false);
                    break;

                case 11:
                    rootview = inflater.inflate(R.layout.fragment_almacen11,container,false);
                    break;

                case 12:
                    rootview = inflater.inflate(R.layout.fragment_almacen12,container,false);
                    break;

                case 13:
                    rootview = inflater.inflate(R.layout.fragment_almacen13,container,false);
                    break;

                case 14:
                    rootview = inflater.inflate(R.layout.fragment_almacen14,container,false);
                    break;

            }

            return rootview;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 14 total pages.
            return 14;
        }
    }


}
