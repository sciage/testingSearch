/***
 * Copyright (c) 2017 Oscar Salguero www.oscarsalguero.com
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.voiceme.app.voiceme;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/**
 * Main activity
 * Created by RacZo on 2/19/17.
 */
public class MainActivity extends AppCompatActivity
        implements
        AutocompleteDemoFragment.OnFragmentInteractionListener{

    private static final String TAG = MainActivity.class.getName();


    private static final String FRAGMENT_DEMO = "FRAGMENT_DEMO";

    private Fragment fragment;
    private String fragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentTag = FRAGMENT_DEMO;
        fragment = AutocompleteDemoFragment
                .newInstance("FRAGMENT 1 PARAM 1");
        switchFragment(fragment, fragmentTag);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d(TAG, "Fragment Uri: " + uri);
    }

    private void switchFragment(Fragment fragment, String fragmentTag) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_main, fragment, fragmentTag);
            transaction.addToBackStack(null);
            transaction.commit();
        } catch (Exception e) {
            Log.e(TAG, "Error occurred replacing fragment", e);
        }
    }

}
