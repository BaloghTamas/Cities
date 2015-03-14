package hu.bute.daai.amorg.nested;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import hu.bute.daai.amorg.nested.fragments.CopenhagenFragment;
import hu.bute.daai.amorg.nested.fragments.DualFragment;
import hu.bute.daai.amorg.nested.fragments.LondonFragment;
import hu.bute.daai.amorg.nested.fragments.NavDrawerListFragment;
import hu.bute.daai.amorg.nested.fragments.ParisFragment;

public class MainActivity extends ActionBarActivity
{

    private View fragmentContainerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavDrawerListFragment drawerListFragment;
    private DrawerLayout drawerLayout;

    private Fragment whiteFragment;
    private Fragment greenFragment;
    private Fragment redFragment;
    private Fragment dualFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerListFragment = (NavDrawerListFragment)
                fragmentManager.findFragmentById(R.id.navigation_drawer);

        fragmentContainerView = findViewById(R.id.container);

        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Nested");

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                    /* host Activity */
                drawerLayout,                    /* DrawerLayout object */
                R.drawable.ic_drawer,             /* nav drawer image to replace 'Up' caret */
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        )
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
        };

        // Defer code dependent on restoration of previous instance state.
        drawerLayout.post(new Runnable()
        {
            @Override
            public void run()
            {
                mDrawerToggle.syncState();
            }
        });

        drawerLayout.setDrawerListener(mDrawerToggle);

        whiteFragment = LondonFragment.newInstance();
        greenFragment = ParisFragment.newInstance();
        redFragment = CopenhagenFragment.newInstance();
        dualFragment = DualFragment.newInstance();

        loadFragment(LondonFragment.newInstance());

    }

    public void selectItem(int position)
    {

        Fragment selectedFragment;
        switch (position)
        {
            case 0:
            {
                selectedFragment = whiteFragment;
                break;
            }
            case 1:
            {
                selectedFragment = greenFragment;
                break;
            }
            case 2:
            {
                selectedFragment = redFragment;
                break;
            }
            case 3:
            {
                selectedFragment = dualFragment;
                break;
            }
            default:
            {
                selectedFragment = whiteFragment;
            }
        }

        loadFragment(selectedFragment);

    }

    private void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public boolean isDrawerOpen()
    {
        return drawerLayout != null && drawerLayout.isDrawerOpen(fragmentContainerView);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

}
