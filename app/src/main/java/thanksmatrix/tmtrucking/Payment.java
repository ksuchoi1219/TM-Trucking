package thanksmatrix.tmtrucking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by KangSu on 2/2/2017.
 */

public class Payment extends AppCompatActivity {

    private TextView userDistance, userPrice, userTax, userTotal;
    private String distance, userOption, strPrice, strTax, strTotal;
    private float price, tax, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        userDistance = (TextView) findViewById(R.id.textDistance);
        userPrice = (TextView) findViewById(R.id.textPrice);
        userTax = (TextView) findViewById(R.id.tax);
        userTotal = (TextView) findViewById(R.id.total);

        Intent intent = getIntent();
        distance = intent.getStringExtra("dist");
        userOption = intent.getStringExtra("option");

        //PRICE CALCULATION
        price = (float) (Float.parseFloat(distance) * 1.25);
        tax = price / 10;
        if (userOption.equals("Envelop")) {
            price *= 2;
        } else if (userOption.equals("Small")) {
            price *= 3;
        } else if (userOption.equals("Medium")) {
            price *= 4;
        } else if (userOption.equals("Large")){
            price *= 5;
        }
        total = price + tax;

        strPrice = String.format("%.2f", price);
        strTax = String.format("%.2f", tax);
        strTotal = String.format("%.2f", total);

        userDistance.setText("Distance: " + distance + " miles");
        userPrice.setText("Price: $" + strPrice);
        userTax.setText("Tax: $" + strTax);
        userTotal.setText("YOUR TOTAL: $" + strTotal);
    }

}
