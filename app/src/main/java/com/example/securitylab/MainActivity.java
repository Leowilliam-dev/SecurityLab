package com.example.securitylab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private boolean premiumUnlocked = false;
    private boolean biometricVerified = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView status = new TextView(this);
        status.setText(
                "Security Lab\n\n" +
                "Premium: LOCKED\n" +
                "Biometric: NOT VERIFIED\n\n" +
                "This is a training application."
        );
        status.setTextSize(20);

        Button purchase = new Button(this);
        purchase.setText("Mock Purchase");

        purchase.setOnClickListener(v -> {
            premiumUnlocked = true;
            status.setText(
                    "Security Lab\n\n" +
                    "Premium: " + (premiumUnlocked ? "UNLOCKED" : "LOCKED") +
                    "\nBiometric: " + (biometricVerified ? "VERIFIED" : "NOT VERIFIED")
            );
        });

        Button biometric = new Button(this);
        biometric.setText("Mock Biometric");

        biometric.setOnClickListener(v -> {
            biometricVerified = true;
            status.setText(
                    "Security Lab\n\n" +
                    "Premium: " + (premiumUnlocked ? "UNLOCKED" : "LOCKED") +
                    "\nBiometric: " + (biometricVerified ? "VERIFIED" : "NOT VERIFIED")
            );
        });

        android.widget.LinearLayout layout = new android.widget.LinearLayout(this);
        layout.setOrientation(android.widget.LinearLayout.VERTICAL);
        layout.addView(status);
        layout.addView(purchase);
        layout.addView(biometric);

        setContentView(layout);
    }
}
