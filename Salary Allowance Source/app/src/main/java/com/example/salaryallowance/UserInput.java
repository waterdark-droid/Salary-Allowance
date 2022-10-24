package com.example.salaryallowance;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

public class UserInput extends AppCompatActivity {
    EditText basicSalaryInput, caInput, daInput, hraInput, licInput, pfInput, otherInput;
//    Animation animScale;
//    ImageView progressBar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        View decor = UserInput.this.getWindow().getDecorView();
        if(decor.getSystemUiVisibility() != View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR){
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        else{
            decor.setSystemUiVisibility(0);
        }

//        progressBar = (ImageView) findViewById(R.id.progress);
//        animScale = AnimationUtils.loadAnimation(this, R.anim.translate_up);
//        progressBar.startAnimation(animScale);



//        basicSalaryInput.setOnFocusChangeListener((v, hasFocus) -> {
//                if(!hasFocus){
//                    System.out.println("Not Focussed");
////                    progressBar.startAnimation(animScale);
////                    Toast.makeText(UserInput.this, "focused", Toast.LENGTH_LONG).show();
//                }
//                else{
//                    System.out.println("Focussed");
////                    Toast.makeText(UserInput.this, "focus loosed", Toast.LENGTH_LONG).show();
//                }
//
//        });


    }

    public void calcButtonAction(View view){
        basicSalaryInput = (EditText) findViewById(R.id.basicSalInp);
        caInput = (EditText) findViewById(R.id.caInp);
        daInput = (EditText) findViewById(R.id.daInp);
        hraInput = (EditText) findViewById(R.id.hraInp);
        licInput = (EditText) findViewById(R.id.licInp);
        pfInput = (EditText) findViewById(R.id.pfInp);
        otherInput = (EditText) findViewById(R.id.otherInp);

        String basicSal,ca,da,hra,lic,pf,other;

        basicSal = basicSalaryInput.getText().toString();


        ca = caInput.getText().toString();
        da = daInput.getText().toString();
        hra = hraInput.getText().toString();
        lic = licInput.getText().toString();
        pf = pfInput.getText().toString();
        other = otherInput.getText().toString();

        if(basicSal.length() == 0){
            basicSalaryInput.setError("Salary Needed");
        }
        else if(ca.length() == 0){
            caInput.setError("CA Needed");
        }
        else if(da.length() == 0){
            daInput.setError("DA Needed");
        }
        else if(hra.length() == 0){
            hraInput.setError("HRA Needed");
        }
        else if(lic.length() == 0){
            licInput.setError("LIC Needed");
        }
        else if(pf.length() == 0){
            pfInput.setError("PF Needed");
        }
        else if(other.length() == 0){
            otherInput.setError("Other Allowance Needed");
        }
        else if(Integer.parseInt(lic) + Integer.parseInt(pf) > Integer.parseInt(basicSal) + Integer.parseInt(ca) + Integer.parseInt(da) + Integer.parseInt(hra) + Integer.parseInt(other)){
            Toast.makeText(this, "LIC and PF not greater than allowance", Toast.LENGTH_SHORT).show();
        }
        else{

            Intent intent = new Intent(getApplicationContext(), ResultScreen.class);

            intent.putExtra("BasicSalary" ,basicSal);
            intent.putExtra("ConveyanceAllowance", ca);
            intent.putExtra("DearnessAllowance", da);
            intent.putExtra("HouseRentAllowance", hra);
            intent.putExtra("LifeInsuranceCorporation", lic);
            intent.putExtra("ProvidentFund", pf);
            intent.putExtra("OtherAllowance", other);
            startActivity(intent);
        }



    }

}