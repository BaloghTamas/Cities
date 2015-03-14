package hu.bute.daai.amorg.nested.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.bute.daai.amorg.nested.R;

public class ParisFragment extends Fragment
{
    public ParisFragment()
    {
        // Required empty public constructor
    }

    public static ParisFragment newInstance()
    {
        ParisFragment fragment = new ParisFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_paris, container, false);
        return view;
    }

}
