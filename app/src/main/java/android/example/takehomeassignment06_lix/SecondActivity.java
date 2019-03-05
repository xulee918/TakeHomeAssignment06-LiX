package android.example.takehomeassignment06_lix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView yourReceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        double amount=intent.getExtras().getDouble("Amount");
        double taxPercentage = intent.getExtras().getDouble("TaxPercentage");
        double tipPercentage = intent.getExtras().getDouble("TipPercentage");

        double tax = taxPercentage + amount;
        double tip = tipPercentage + amount;
        double total = amount + tax + tip;

        yourReceipt = findViewById(R.id.receipt_text_view);
        yourReceipt.setText(buildReceipt(amount, tax, tip, total));
    }

    private String buildReceipt (double amount, double tax, double tip, double total){
        return String.format("total: %.2f\nSalesTax: %.2f\nTip: %.2f\nGrand Total: %.2f\n", amount, tax, tip, total);

    }
}
