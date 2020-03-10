package fr.kteam.wbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.kteam.wbproject.ui.promotions.PromotionsFragment;

public class promotions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotions_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PromotionsFragment.newInstance())
                    .commitNow();
        }
    }
}
