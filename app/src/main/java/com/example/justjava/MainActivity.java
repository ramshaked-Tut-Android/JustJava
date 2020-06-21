// Original AS generated code:
//
//package com.example.justjava;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}


/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int _qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = 5;
        //        display(R.id.quantity_text_view,"" + count);
        // updateQtyView(_qty);
        EditText nameView = (EditText) findViewById(R.id.name_edit_text_view);
        Editable name = nameView.getText();
        int totalPrice = this._qty * price;
        String summaryStr = "Hi " + name + "\nPrice: " + NumberFormat.getCurrencyInstance().format(totalPrice) + "\nThank you!";
        display(R.id.summary_text_view, summaryStr);
        //displayMessage
        //showMap(Uri.parse("geo:47.6, -122.3"));
        String[] addresses = {"ramsha7@gmail.com"};
        composeEmail(addresses, "Hi from the coffee maker app", summaryStr);

    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        // or use setData(Uri.parse(“geo:47.6, -122.3”))
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeEmail(String[] addresses, String subject, String msg) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);// SENDTO - indicates no attachments.
        intent.setData(Uri.parse("mailto:"));            // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void updateQtyView(int qty) {
        display(R.id.quantity_text_view, "" + qty);
    }

    public void incQty(View view) {
        updateQtyView(++this._qty);
    }

    public void decQty(View view) {
        if (this._qty > 0)
            updateQtyView(--this._qty);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int targetTextViewID, String str) {
        TextView textView = (TextView) findViewById(targetTextViewID);
        textView.setText(str);
    }
    //    private void display(int number) {
    //        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
    //        quantityTextView.setText("" + number);
    //    }

    /**
     * This method displays the given price on the screen.
     */
    //    private void displayPrice(int number) {
    //        TextView priceTextView = (TextView) findViewById(R.id.summary_text_view);
    //        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    //    }
}