package id.co.npad93.pm.t6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class IdolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idol);
        getSupportActionBar().setHomeButtonEnabled(true);

        idol = getIntent().getParcelableExtra("idol");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO ui
    }

    private Idol idol;
}
