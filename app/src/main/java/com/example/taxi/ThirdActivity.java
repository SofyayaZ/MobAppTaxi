package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.taxi.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {
    private ActivityThirdBinding binding;
    private static final String TAG = "MyLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String fromStreet = binding.editTextStreet1.getText().toString();
                if (!fromStreet.isEmpty()) {
                    fromStreet += ", ";
                }
                String fromHouse = binding.editTextHouse1.getText().toString();
                if (!fromHouse.isEmpty()) {
                    fromHouse += ", ";
                }
                String fromFlat = binding.editTextFlat1.getText().toString();
                String pointFrom = fromStreet + fromHouse + fromFlat;

                String toStreet = binding.editTextStreet2.getText().toString();
                if (!toStreet.isEmpty()) {
                    toStreet += ", ";
                }
                String toHouse = binding.editTextHouse2.getText().toString();
                if (!toHouse.isEmpty()) {
                    toHouse += ", ";
                }
                String toFlat = binding.editTextFlat2.getText().toString();
                String pointTo = toStreet + toHouse + toFlat;

                intent.putExtra("PointFrom", pointFrom);
                intent.putExtra("PointTo", pointTo);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Log.d(TAG, "ThirdActivity: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ThirdActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ThirdActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ThirdActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ThirdActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ThirdActivity: onDestroy");
    }
}