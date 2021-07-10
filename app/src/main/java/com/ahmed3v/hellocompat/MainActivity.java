package com.ahmed3v.hellocompat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView helloTextView;
    private Button helloButton;

    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            helloTextView.setTextColor(savedInstanceState.getInt("color"));
        }

        helloTextView = findViewById(R.id.hello_text_view);
        helloButton = findViewById(R.id.hello_btn);

        helloButton.setOnClickListener(v -> {

            //Create a Random class object to generate simple random numbers.
            Random random = new Random();

            //Use the random instance to pick a random color from the mColorArray array.
            String colorName = mColorArray[random.nextInt(20)];

            // Get the color identifier that matches the color name.
            int colorResourceName = getResources().getIdentifier(colorName,
                    "color", getApplicationContext().getPackageName());

            // Get the color ID from the resources.
            int colorRes = ContextCompat.getColor(this, colorResourceName);

            //Set the color of the helloTextView to the color resource ID
            helloTextView.setTextColor(colorRes);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // save the current text color
        outState.putInt("color", helloTextView.getCurrentTextColor());
    }
}