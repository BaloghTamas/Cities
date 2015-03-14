package hu.bute.daai.amorg.nested.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import hu.bute.daai.amorg.nested.MainActivity;
import hu.bute.daai.amorg.nested.R;

public class NavDrawerListFragment extends Fragment
{

    public NavDrawerListFragment()
    {
        // Required empty public constructor
    }

    public static NavDrawerListFragment newInstance()
    {
        NavDrawerListFragment fragment = new NavDrawerListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {

        ListView navDrawerList = (ListView) inflater.inflate(
                R.layout.fragment_nav_drawer_list, container, false);
        navDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ((MainActivity) getActivity()).selectItem(position);
            }
        });
        navDrawerList.setAdapter(new ArrayAdapter<String>(
                getActivity().getApplicationContext(),
                R.layout.li_drawer,
                R.id.text,
                new String[]{
                        getString(R.string.title_london),
                        getString(R.string.title_paris),
                        getString(R.string.title_copenhagen),
                        getString(R.string.title_dual),
                }));
        navDrawerList.setItemChecked(0, true);

        return navDrawerList;
    }

}
