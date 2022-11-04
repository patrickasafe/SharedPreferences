package descomplica.desenvolvimentomobile.aula15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private void setPrefsView() {
        TextView fNameTextView = findViewById(R.id.firstNameTextView);
        TextView lNameTextView = findViewById(R.id.lastNameTextView);
        TextView ageTextView = findViewById(R.id.ageTextView);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String f_name_pref = sharedPreferences.getString("f_name", "").toString(); // getting String
        String l_name_pref = sharedPreferences.getString("l_name", "").toString(); // getting String
        int age_pref = sharedPreferences.getInt("age", 0); // getting Integer

        fNameTextView.setText(f_name_pref);
        lNameTextView.setText(l_name_pref);
        ageTextView.setText(String.valueOf(age_pref));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPrefsView();

        Button settingsButton = findViewById(R.id.SettingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//              MainActivity.setContentView(R.layout.settings_activity);

                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();

        setPrefsView();

    }

}