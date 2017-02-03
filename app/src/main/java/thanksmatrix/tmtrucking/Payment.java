package thanksmatrix.tmtrucking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by KangSu on 2/2/2017.
 */

public class Payment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        TextView userDistance, userPrice;
        userDistance = (TextView) findViewById(R.id.textDistance);
        userPrice = (TextView) findViewById(R.id.textPrice);
        String userOption;
        String strPrice;
        float price;

        Intent intent = getIntent();
        String distance = intent.getStringExtra("dist");

        userDistance.setText("Distance: " + distance);

        price = (float) (Float.parseFloat(distance) * 1.25);
        userOption = intent.getStringExtra("option");
        if (userOption == "Envelop") {
            price *= 2;
        } else if (userOption == "Small") {
            price *= 3;
        } else if (userOption == "Medium") {
            price *= 4;
        } else {
            price *= 5;
        }
        strPrice = Float.toString(price);
        userPrice.setText("Price: $" + strPrice);
    }

}
