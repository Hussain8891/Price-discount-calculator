package hussainshaikh.com.pricediscountcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button process;
    EditText price;
    EditText discount;
    TextView yourdiscount;
    TextView yourAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price = (EditText) findViewById(R.id.price_tv);
        discount = (EditText) findViewById(R.id.discount_tv);
        process = (Button) findViewById(R.id.btn_process);

        yourdiscount = (TextView) findViewById(R.id.yourDiscount);
        yourAmount = (TextView) findViewById(R.id.pay_this_amount);

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Process", Toast.LENGTH_SHORT).show();
                float percentage = Float.parseFloat(price.getText().toString());
                float dis = percentage / 100;
                float total = dis * Float.parseFloat(discount.getText().toString());

                float amount = percentage - total;

                //discoun Rs
                float discount = total;
                yourdiscount.setText(Float.toString(discount));

                //amount Rs
                yourAmount.setText(Float.toString(amount));


            }
        });

        //code



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you wants to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}