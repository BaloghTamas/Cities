package hu.bute.daai.amorg.nested.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.bute.daai.amorg.nested.R;

public class LondonFragment extends Fragment
{

    public static String TAG = "London";
    public LondonFragment()
    {
        // Required empty public constructor
    }

    public static LondonFragment newInstance()
    {
        LondonFragment fragment = new LondonFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_london, container, false);
        return view;
    }
}