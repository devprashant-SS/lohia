package com.example.lohia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;


public class UserDataActivity extends AppCompatActivity {
    //    Spinner userspinner;

    TextView type,time, sum, gst;
    Button submit, show;
    private final FirebaseFirestore db= FirebaseFirestore.getInstance();
    private final DocumentReference dataref = db.collection("users").document("BLTJ4NBLhB5HHPzqSM7a");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        submit = findViewById(R.id.ud_submit);
        show = findViewById(R.id.ud_show);

        type=findViewById(R.id.userdata_text_field_type);
        time=findViewById(R.id.userdata_text_field_time);
        sum=findViewById(R.id.userdata_text_field_sum);
        gst=findViewById(R.id.userdata_text_field_pre_gst);



        submit.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PaymentSuccessActivity.class)));

        show.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Policy_Form_Activity.class)));

//        dataref.get().addOnSuccessListener(documentSnapshot -> {
//            if (documentSnapshot.exists()){
//                String typef =documentSnapshot.getString("type");
//                String timef =documentSnapshot.getString("mode");
//                String gstf =documentSnapshot.getString("premium");
//                String saf =documentSnapshot.getString("sa");
//
//                Log.d("Data", typef);
//                            type.setText(typef);
//                            time.setText(timef);
//                            sum.setText(saf);
//                            gst.setText(gstf);
//
//
//            }else {
//                Toast.makeText(UserDataActivity.this, "Not Have Data", Toast.LENGTH_SHORT).show();
//            }
//
//        }).addOnFailureListener(e -> {
//            Toast.makeText(UserDataActivity.this, "Error", Toast.LENGTH_SHORT).show();
//            Log.d("Tag", e +"hello");
//        });


        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> data = document.getData();

                                // Access specific fields
                                String type_d = (String) data.get("type");
                                String mode_d = (String) data.get("mode");
                                String premium_d = (String) data.get("premium");
                                String sa_d = (String) data.get("sa");


                                // Log the retrieved data
                                type.setText(type_d);
                            time.setText(mode_d);
                            sum.setText(sa_d);
                            gst.setText(premium_d);
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });

    }

}