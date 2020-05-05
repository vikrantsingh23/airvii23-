package com.example.fly;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class boardingpass extends AppCompatActivity {
      FirebaseFirestore db;

    Button screen;
    TextView name,origin,destination,date,boardingtime,seat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardingpass);
        db = FirebaseFirestore.getInstance();
        screen = findViewById(R.id.screen);
        name = findViewById(R.id.name);
        origin = findViewById(R.id.origin);
        destination = findViewById(R.id.destination);
        date = findViewById(R.id.date);
        boardingtime = findViewById(R.id.boardingtime);
        seat = findViewById(R.id.seat);
        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(boardingpass.this, menu.class));
                finish();

            }
        });

        DocumentReference documentReference = db.collection("flight").document("booking");
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                String origin1 = documentSnapshot.getString("origin");
                origin.setText(origin1);
                String destination1 = documentSnapshot.getString("destination");
                destination.setText(destination1);
                String date1 = documentSnapshot.getString("day");
                date.setText(date1);
                String time1 = documentSnapshot.getString("time");
                boardingtime.setText(time1);
                String seat1 = documentSnapshot.getString("seat");
                seat.setText(seat1);


            }

        });

        DocumentReference documentReference1 = db.collection("flight").document("registration");
        documentReference1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                String name1 = documentSnapshot.getString("name");
                name.setText(name1);


            }

        });

   /* public void takeScreenshot(View v) {

        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + "  ";

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            openScreenshot(imageFile);
        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }

    private void openScreenshot(File imageFile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(imageFile);
        intent.setDataAndType(uri, "image/*");
        startActivity(intent);
*/
    }
}
