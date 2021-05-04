package id.co.npad93.pm.t6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new HashMap<Integer, Fragment>();

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.menuItem);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment f = null;

        if (id == R.id.menuItem) {
            f = getFragment(R.id.menuItem, IdolFragment.class);
        } else if (id == R.id.menuItem2) {
            f = getFragment(R.id.menuItem2, CardFragment.class);
        } else if (id == R.id.menuItem3) {
            f = getFragment(R.id.menuItem3, AboutFragment.class);
        }

        if (f != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, f).commit();
        }

        return f != null;
    }

    private <T extends Fragment> T getFragment(int index, Class<T> cls) {
        T f = (T) fragments.get(index);

        if (f == null) {
            try {
                fragments.put(index, f = cls.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                return null;
            }
        }

        return f;
    }

    private HashMap<Integer, Fragment> fragments;
}
