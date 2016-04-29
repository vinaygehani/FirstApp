package com.example.android.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 1;

//    String priceString = "Total Price";
//    String qtyString = "Quantity";
//    String thankString = "Thank You!! Order placed for ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(1);
        displayPrice(quantity * 5);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        TextView thanksTextView = (TextView) findViewById(R.id.thanks_text);
//        thanksTextView.setText(thankString + NumberFormat.getCurrencyInstance().format(quantity * 5));

        EditText nameField = (EditText) findViewById(R.id.nameField);
        String nameValue=nameField.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");

        String coffee = getResources().getString(R.string.coffee);

        intent.putExtra(Intent.EXTRA_SUBJECT, coffee + nameValue);
        intent.putExtra(Intent.EXTRA_TEXT, "Thank You " + nameValue + "!\nOrder Value is " + quantity*5 + " for the order of " + quantity+ " coffees.");
        intent.setData(Uri.parse("mailto:"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void increaseQuantity(View view) {
        quantity++;
        display(quantity);

    }

    public void decreaseQuantity(View view) {
        if (quantity > 1)
            quantity--;
        display(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.qty_value);
        quantityTextView.setText("" + number);

        displayPrice(number * 5);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_value);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
