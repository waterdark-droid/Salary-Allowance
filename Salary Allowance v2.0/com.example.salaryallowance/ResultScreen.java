package com.example.salaryallowance;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {

    TextView result, gross, deduDiff, sal, conAll, dearAll, hrAll, lic, pf, otherAll;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        View decor = ResultScreen.this.getWindow().getDecorView();
        if(decor.getSystemUiVisibility() != View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR){
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        else{
            decor.setSystemUiVisibility(0);
        }

        result = findViewById(R.id.resultSum);
        gross = findViewById(R.id.grossSum);
        deduDiff = findViewById(R.id.deductionDiff);
        sal = findViewById(R.id.basicSal);
        conAll = findViewById(R.id.conveyanceAllowance);
        dearAll = findViewById(R.id.dearnessAllowance);
        hrAll = findViewById(R.id.hrAllowance);
        lic = findViewById(R.id.licDeduction);
        pf = findViewById(R.id.providentFund);
        otherAll = findViewById(R.id.otherAllowance);


        Intent intent = getIntent();

        String basicSal = intent.getStringExtra("BasicSalary");
        String ca = intent.getStringExtra("ConveyanceAllowance");
        String da = intent.getStringExtra("DearnessAllowance");
        String hra = intent.getStringExtra("HouseRentAllowance");
        String licDed = intent.getStringExtra("LifeInsuranceCorporation");
        String pfDed = intent.getStringExtra("ProvidentFund");
        String other = intent.getStringExtra("OtherAllowance");

        float caFromSal = Float.parseFloat(ca) * Integer.parseInt(basicSal);
        float daFromSal = Float.parseFloat(da) * Integer.parseInt(basicSal);
        float hraFromSal = Float.parseFloat(hra) * Integer.parseInt(basicSal);
        float licDedFromSal = Float.parseFloat(licDed) * Integer.parseInt(basicSal);
        float pfDedFromSal = Float.parseFloat(pfDed) * Integer.parseInt(basicSal);
        float otherFromSal = Float.parseFloat(other) * Integer.parseInt(basicSal);

        System.out.println("Ca double : " + caFromSal);

        long grossSum = (int) daFromSal + (int) hraFromSal + Integer.parseInt(basicSal) + (int) caFromSal+ (int) otherFromSal;
        long deduction = (int)licDedFromSal + (int) pfDedFromSal;

        long netPaySum = grossSum - deduction;

        result.setText(new StringBuilder().append("₹").append(netPaySum).toString());
        gross.setText(new StringBuilder().append("₹").append(grossSum).toString());
        deduDiff.setText(new StringBuilder().append("₹").append(deduction).toString());
        sal.setText(new StringBuilder().append("₹").append(basicSal));
        conAll.setText(new StringBuilder().append("₹").append((int) caFromSal).toString());
        dearAll.setText(new StringBuilder().append("₹").append((int) daFromSal).toString());
        hrAll.setText(new StringBuilder().append("₹").append((int) hraFromSal).toString());
        lic.setText(new StringBuilder().append("₹").append((int) licDedFromSal).toString());
        pf.setText(new StringBuilder().append("₹").append((int) pfDedFromSal).toString());
        otherAll.setText(new StringBuilder().append("₹").append((int) otherFromSal).toString());

    }
}