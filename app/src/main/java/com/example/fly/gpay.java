package com.example.fly;




import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class gpay extends AppCompatActivity {

    EditText  name, upivirtualid,note;
    TextView amount;
    Button send;
    String TAG ="main";
    String price="";
    final int UPI_PAYMENT = 0;
      FirebaseFirestore db;
      static int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpay);

           db=FirebaseFirestore.getInstance();
        upivirtualid = findViewById(R.id.upi_id);
        name = findViewById(R.id.naam);
        amount = findViewById(R.id.amount);
        note = findViewById(R.id.note);

      send=findViewById(R.id.send);


    amount.setText(getIntent().getStringExtra("price"));

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting the values from the EditTexts

                if (TextUtils.isEmpty(name.getText().toString().trim())){
                    Toast.makeText(gpay.this," Name is invalid", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(upivirtualid.getText().toString().trim())){
                    Toast.makeText(gpay.this," UPI ID is invalid", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(note.getText().toString().trim())) {
                    Toast.makeText(gpay.this, " Note is invalid", Toast.LENGTH_SHORT).show();
                }
                else  {
                    payUsingUpi(name.getText().toString(), upivirtualid.getText().toString(),
                            note.getText().toString(), amount.getText().toString());
                }

            }
        });
    }

    void payUsingUpi(  String name,String upiId, String note, String amount) {
        //    Log.e("main ", "name "+name +"--up--"+upiId+"--"+ note+"--"+amount);
        Uri uri = Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa", upiId)
                .appendQueryParameter("pn", name)

                .appendQueryParameter("tn", note)
                .appendQueryParameter("am", amount)
                .appendQueryParameter("cu", "INR")
                //.appendQueryParameter("refUrl", "blueapp")
                .build();



        Intent upiPayIntent = new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);

        // will always show a dialog to user to choose an app
        Intent chooser = Intent.createChooser(upiPayIntent, "Pay with");

        // check if intent resolves
        if(null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(gpay.this,"No UPI app found, please install one to continue",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == UPI_PAYMENT) {
            if ((RESULT_OK == resultCode) || (resultCode == 11)) {
                if (data != null) {
                    String trxt = data.getStringExtra("response");

                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add(trxt);
                    upiPaymentDataOperation(dataList);
                } else {
                    ArrayList<String> dataList = new ArrayList<>();
                    dataList.add("nothing");
                    upiPaymentDataOperation(dataList);
                }
            } else {

                ArrayList<String> dataList = new ArrayList<>();
                dataList.add("nothing");
                upiPaymentDataOperation(dataList);
            }
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(gpay.this)) {
            String str = data.get(0);

            String paymentCancel = "";
            if(str == null) str = "discard";
            String status = "";
            String approvalRefNo = "";
            String[] response = str.split("&");
            for (String s : response) {
                String[] equalStr = s.split("=");
                if (equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    } else if (equalStr[0].toLowerCase().equals("ApprovalRefNo".toLowerCase()) || equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalRefNo = equalStr[1];
                    }
                } else
                    paymentCancel = "Payment cancelled by user.";
            }

            if (status.equals("success")) {
                //Code to handle successful transaction here.
                Toast.makeText(gpay.this, "Transaction successful.", Toast.LENGTH_SHORT).show();
                Map<String, Object> book1 = new HashMap<>();

                book1.put("status","yes");

                db.collection("confirmation").document("paymentconfirm" + i++).set(book1);


            }
            else if(paymentCancel.equals("Payment cancelled by user.")) {
                Toast.makeText(gpay.this, "Payment cancelled by user.", Toast.LENGTH_SHORT).show();
                //      Log.e("UPI", "Cancelled by user: "+approvalRefNo);

            }
            else {
                Toast.makeText(gpay.this, "Transaction failed.Please try again", Toast.LENGTH_SHORT).show();
                //    Log.e("UPI", "failed payment: "+approvalRefNo);

            }
        } else {
            // Log.e("UPI", "Internet issue: ");

            Toast.makeText(gpay.this, "Internet connection is not available. Please check and try again", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable();
        }
        return false;
    }

}

