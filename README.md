<p align="center">
  <a href="https://github.com/SumonSoftware">
    <img src="https://avatars.githubusercontent.com/u/168503949?s=400&u=0b6844ac4b6e0cba4ee7011daa2a1226deb0faff&v=4" alt="Logo" width="100" height="100">
  </a> 
   
<h1 align='center'>BMI Calculator</h1>

<!-- 
<h3 align='center'>
    <a href="https://www.youtube.com/watch?v=Sgkp46GS6rk">Watch Video</a> for Runtime Storage Permissions.  
</h3> -->
</p>

## Step 1: activity_main.xml code <br>
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@color/white"
    tools:context=".MainActivity">


    <TextView
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:text="BMI  Calculator"
        android:textSize="20dp"
        android:textColor="@color/white"
        android:background="#00838F"
        android:gravity="center_vertical"
        android:textStyle="bold"
        android:paddingLeft="10dp"
        />
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:weightSum="2"
        android:layout_marginTop="15dp"
        >

        <EditText
            android:id="@+id/tvFeet"
            android:layout_weight="1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:hint="Height ( feet )"
            android:textColor="#00838F"
            android:textColorHint="#00838F"
            android:textSize="20sp"
            android:textStyle="bold"
            android:padding="10dp"
            android:inputType="numberDecimal"
            android:background="@drawable/edtext_background_border"
            />
        <EditText
            android:id="@+id/tvInches"
            android:layout_weight="1"
            android:inputType="numberDecimal"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:hint="Height ( inches )"
            android:textColor="#00838F"
            android:textColorHint="#00838F"
            android:textSize="20sp"
            android:textStyle="bold"
            android:padding="10dp"
            android:background="@drawable/edtext_background_border"
            />
    </LinearLayout>

    <EditText
        android:id="@+id/tvWeight"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:hint="Weight ( K.G.)"
        android:textColor="#00838F"
        android:textColorHint="#00838F"
        android:inputType="numberDecimal"
        android:textSize="20sp"
        android:textStyle="bold"
        android:padding="10dp"
        android:background="@drawable/edtext_background_border"
        />

    <Button
        android:id="@+id/tvCalculation"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#00838F"
        android:textColor="@color/white"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:layout_marginTop="10dp"
        android:text="BMI Calculation" />

    <TextView
        android:id="@+id/tvDisplay"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text=""
        android:textSize="20sp"
        android:visibility="gone"
        android:layout_margin="10dp"
        android:textColor="#00838F"/>


</LinearLayout>

```


## Step 2: edtext_background_border code ( drawable )  <br>
````
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">


    <stroke android:color="#00838F" android:width="2dp"/>
    <solid android:color="@color/white"/>
    <corners android:radius="7dp"/>


</shape>

`````

## Step 3: MainActivity.java code <br>

```
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



```










## License

Distributed under the Apache License 2.0. See <a href="https://github.com/SumonSoftware/mone-tag/blob/main/LICENSE">LICENSE</a> for more information.


## Authors

**Sumon Islam** - *Android Software Developer* - <a href="https://github.com/SumonSoftware">Sumon Islam</a> - *Learn with Ease*

<h1 align="center">Thank You ❤️</h1>
