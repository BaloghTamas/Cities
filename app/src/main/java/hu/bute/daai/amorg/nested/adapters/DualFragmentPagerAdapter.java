package hu.bute.daai.amorg.nested.adapters;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import hu.bute.daai.amorg.nested.fragments.BudapestLeftFragment;
import hu.bute.daai.amorg.nested.fragments.BudapestRightFragment;

public class DualFragmentPagerAdapter extends FragmentStatePagerAdapter
{

    public DualFragmentPagerAdapter(FragmentManager manager)
    {
        super(manager);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return BudapestLeftFragment.newInstance();
            case 1:
                return BudapestRightFragment.newInstance();
            default:
                return BudapestRightFragment.newInstance();
        }
    }

    @Override
    public int getCount()
    {
        return 2;
    }

    // Na itt van a kutya elásva #2
    // Valamiért child fragmentek esetén ez a függvény bugos,
    // ezért nem szabad a super.restoreState nek meghívódnia.
    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1)
    {
        //do nothing here! no call to super.restoreState(arg0, arg1);
    }
}
