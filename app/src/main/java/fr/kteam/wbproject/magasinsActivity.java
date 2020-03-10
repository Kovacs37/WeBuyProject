package fr.kteam.wbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.kteam.wbproject.ui.magasins.MagasinsFragment;

public class magasinsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magasins_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MagasinsFragment.newInstance())
                    .commitNow();
        }
    }
}
