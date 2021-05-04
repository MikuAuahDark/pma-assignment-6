package id.co.npad93.pm.t6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.menuItem);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment f = null;

        if (id == R.id.menuItem) {
            f = new IdolFragment();
        } else if (id == R.id.menuItem2) {
            // TODO
            return false;
        } else if (id == R.id.menuItem3) {
            f = new AboutFragment();
        }

        if (f != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, f).commit();
        }

        return f != null;
    }
}
