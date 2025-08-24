package com.example.bmicalc;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity file is now connected with java file

        // to get id of the view group which is pressed....

        EditText txt_height_ft= findViewById(R.id.height_ft);   // to get id of height view
        EditText txt_height_in= findViewById(R.id.height_inc);   // to get id of height view
        EditText txt_weight=findViewById(R.id.weight);    // to get id of weight view
        Button Calc_button=findViewById(R.id.SubmitButton); // to get id of calculate button
        TextView Result=findViewById(R.id.Result);        // to get id of result button.

        Calc_button.setOnClickListener(new View.OnClickListener() {          // as soon as the button is clicked it will send the info that the button is clicked..
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                // to check whether all values are entered or not.....

                if (txt_height_ft.getText().toString().trim().isEmpty() ||
                        txt_height_in.getText().toString().trim().isEmpty() ||
                        txt_weight.getText().toString().trim().isEmpty()) {

                    Result.setText("Please enter all fields!");
                    return; // Stop further calculation
                }


                // now we have to get the values from the EditView group for that we will use getvalue() of that viewgroup by using it's reference id...

                // since we have used input-type as int in the editview that's why we need to convert it into integer otherwise we'll do it accordingly...
                float height_ft = Float.parseFloat(txt_height_ft.getText().toString()); // .getText() will give the editable value which needed to be converted to string and then to integer for conversion..
                float height_in = Float.parseFloat(txt_height_in.getText().toString());
                float weight=Float.parseFloat(txt_weight.getText().toString());

                // conversion of height ...
                double total_height_inches=height_ft*12+height_in;
                double total_height_cms= total_height_inches*2.53;
                double total_height=total_height_cms/100;

                // calculation of BMI
                double bmi= (float) weight /(total_height*total_height);

                // checking Whether Overweight, UnderWeight, Healthy....
                if(bmi>25){
                    Result.setText("You are OverWeight.");
                }
                else if (bmi<18){
                    Result.setText("You are UnderWeight.");
                }
                else {
                    Result.setText("You are Healthy.");
                }
            }
        });
    }
}
