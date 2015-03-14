package hu.bute.daai.amorg.nested.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.bute.daai.amorg.nested.R;

public class BudapestLeftFragment extends Fragment
{
    public BudapestLeftFragment()
    {
        // Required empty public constructor
    }

    public static BudapestLeftFragment newInstance()
    {
        BudapestLeftFragment fragment = new BudapestLeftFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_budapest_left, container, false);
        return view;
    }

}
