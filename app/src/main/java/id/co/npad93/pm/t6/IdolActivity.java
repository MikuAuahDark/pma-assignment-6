package id.co.npad93.pm.t6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        ApiHelper.loadImageAsync(this, idol.getCharacterImageURL(), findViewById(R.id.imageView4));
        this.<TextView>findViewById(R.id.textView7).setText(idol.getNameLLMFSOrder());
        this.<TextView>findViewById(R.id.textView8).setText(idol.getJapaneseName());
        this.<TextView>findViewById(R.id.textView17).setText(idol.getGroup());
        this.<TextView>findViewById(R.id.textView18).setText(idol.getSubGroup());
        this.<TextView>findViewById(R.id.textView19).setText(Integer.toString(idol.getAge()));
        this.<TextView>findViewById(R.id.textView20).setText(idol.getVAName());
    }

    public void idolMoreInfo(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://schoolido.lu/idol/" + idol.getName().replace(" ", "%20")));
        startActivity(i);
    }

    private Idol idol;
}
