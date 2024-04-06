package com.example.taxi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.taxi.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private static final String TAG = "MyLogs";

    ActivityResultLauncher<Intent> startThirdActivityForResult = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode() == Activity.RESULT_OK) {
                                Intent intent = result.getData();
                                if (intent != null) {
                                    String pointFrom = intent.getStringExtra("PointFrom");
                                    String pointTo = intent.getStringExtra("PointTo");
                                    String path = "Taxi will arrive at " + pointFrom + " in 5 minutes and take you in " + pointTo + ". If you're agree click Call Taxi.";
                                    binding.textViewPath.setText(path);
                                    binding.buttonCallTaxi.setEnabled(true);
                                }
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        binding.textViewNameSurname.setText(intent.getStringExtra("SurnameName"));
        binding.textViewPhone.setText(intent.getStringExtra("Phone"));
        binding.buttonCallTaxi.setEnabled(false);
        binding.buttonSetPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent("android.intent.action.ThirdActivity");
                startThirdActivityForResult.launch(secondIntent);
            }
        });
        binding.buttonCallTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(SecondActivity.this, "Wait for taxi. Good luck!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        Log.d(TAG, "SecondActivity: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SecondActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SecondActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SecondActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SecondActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SecondActivity: onDestroy");
    }
}