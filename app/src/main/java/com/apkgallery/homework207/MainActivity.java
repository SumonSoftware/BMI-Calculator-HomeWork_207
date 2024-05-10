package com.apkgallery.homework207;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText tvFeet,tvInches,tvWeight;
    Button tvCalculation;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFeet = findViewById(R.id.tvFeet);
        tvInches = findViewById(R.id.tvInches);
        tvWeight = findViewById(R.id.tvWeight);
        tvCalculation = findViewById(R.id.tvCalculation);
        tvDisplay = findViewById(R.id.tvDisplay);

        //========================================

        // tvCalculation set  ClickListener short code ==
        tvCalculation.setOnClickListener(v -> {

            // method Call
            BMI_method();

        }); // tvCalculation End Here ====================




    }// onCreate End Here =============

    private void BMI_method() {

        String feet= tvFeet.getText().toString();
        String inches= tvInches.getText().toString();
        String weight= tvWeight.getText().toString();

        if (feet.length()==0){
            tvFeet.setError("Enter Your Feet");
        } else if (inches.length()==0) {
            tvInches.setError("Enter Your Inches");
        } else if (weight.length()==0) {
            tvWeight.setError("Enter Your Weight");

        }else {

            int Feet = Integer.parseInt(feet);
            int Inches = Integer.parseInt(inches);
            Float Weight = Float.parseFloat(weight);


            // Calculate BMI
            float mSum = (float) ((Feet * 0.3048) + (Inches * 0.0254));
            float result = Weight / (mSum * mSum);


            // Determine BMI category and display
            String bmiCategory;
            if (result < 18.5) {
                bmiCategory= "Underweight";
            } else if (result < 25) {
                bmiCategory= "Normal";
            } else if (result < 30) {
                bmiCategory= "Overweight";
            } else {
                bmiCategory= "Obese";
            }

            // Display the result
            tvDisplay.setVisibility(View.VISIBLE);
            tvDisplay.setText(bmiCategory + " Your BMI: " + result);

        }


    }// BMI_method End Here ============


}// public class Homework End Here =========