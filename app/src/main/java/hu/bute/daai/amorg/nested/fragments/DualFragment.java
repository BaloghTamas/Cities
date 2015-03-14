package hu.bute.daai.amorg.nested.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.bute.daai.amorg.nested.R;
import hu.bute.daai.amorg.nested.adapters.DualFragmentPagerAdapter;
import hu.bute.daai.amorg.nested.magic.ParallaxPageTransformer;

public class DualFragment extends Fragment
{

    public DualFragment()
    {
        // Required empty public constructor
    }

    public static DualFragment newInstance()
    {
        DualFragment fragment = new DualFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_dual, container, false);
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);

        // Magic trick, ez nem kell az egészhez, csak cool
        pager.setPageTransformer(false, new ParallaxPageTransformer());

        // Na itt van a kutya elásva #1
        // Itt nem az activity fragmentmanagerjét adjuk át,
        // hanem a DualFragment saját fragment managerjét, amir a getChildFragmentManagerel érünk al
        setRetainInstance(true);
        DualFragmentPagerAdapter pagerAdapter = new DualFragmentPagerAdapter(getChildFragmentManager());
        pager.setAdapter(pagerAdapter);

        return view;
    }

}