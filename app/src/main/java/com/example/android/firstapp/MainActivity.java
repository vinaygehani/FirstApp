package com.example.android.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity=1;

    String priceString = "Total Price";
    String qtyString="Quantity";
    String thankString="Thank You!! Order placed for ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        TextView thanksTextView = (TextView) findViewById(R.id.thanks);
        thanksTextView.setText(thankString + NumberFormat.getCurrencyInstance().format(quantity*5));
    }

    public void increaseQuantity(View view) {
        quantity++;
        display(quantity);

    }

    public void decreaseQuantity(View view) {
        if(quantity>1)
            quantity--;
        display(quantity);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.qty_value);
        quantityTextView.setText("" + number);

        displayPrice(number*5);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_value);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
