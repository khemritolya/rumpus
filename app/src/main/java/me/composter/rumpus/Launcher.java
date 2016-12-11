package me.composter.rumpus;

import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import me.composter.rumpus.fragments.InputFragment;
import me.composter.rumpus.fragments.StoryFragment;
import org.nope.example.rumpus.R;

import java.util.Locale;

public class Launcher extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public TextToSpeech tts;
    public MadLibs m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                tts.setLanguage(Locale.US);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Class<? extends Fragment> fragmentClass = Fragment.class;
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_stories:
                fragmentClass = StoryFragment.class;
                break;
            case R.id.nav_help:
                fragmentClass = StoryFragment.class;
                break;
        }
        switchFragment(fragmentClass, null);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void switchFragment(Class<? extends Fragment> fragmentClass, Bundle bundle) {
        try {
            Fragment fragment = fragmentClass.newInstance();
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void handleInput(MadLibs m) {
        this.m = m;
        Bundle bundle = new Bundle();
        bundle.putString("wordType", m.thingsToAskFor[0]);
        bundle.putInt("position", 0);
        switchFragment(InputFragment.class, bundle);
    }
}
