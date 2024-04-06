package com.example.taxi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.taxi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private static final String TAG = "MyLogs";

    SharedPreferences sPref;
    final String keyName = "name";
    final String keySurname = "surname";
    final String keyPhone = "phone";

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(keyName, binding.editTextName.getText().toString());
        editor.putString(keySurname, binding.editTextSurname.getText().toString());
        editor.putString(keyPhone, binding.editTextPhone.getText().toString());
        editor.apply();
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedName = sPref.getString(keyName, "");
        String savedSurname = sPref.getString(keySurname, "");
        String savedPhone = sPref.getString(keyPhone, "");
        binding.editTextName.setText(savedName);
        binding.editTextSurname.setText(savedSurname);
        binding.editTextPhone.setText(savedPhone);
        if (!(savedName.isEmpty() && savedSurname.isEmpty() && savedPhone.isEmpty())) {
            binding.buttonRegistration.setText("Log in");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("SurnameName", binding.editTextName.getText().toString() + ' ' + binding.editTextSurname.getText().toString());
                intent.putExtra("Phone", binding.editTextPhone.getText().toString());
                startActivity(intent);
            }
        });
        loadText();
        Log.d(TAG, "MainActivity: onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy");
        saveText();
    }
}