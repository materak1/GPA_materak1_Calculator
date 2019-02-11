package com.example.gpa_materak1_calculator;

import android.app.Notification;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "GPA_Compute";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText class_1_edit = findViewById(R.id.class_1_input);
        final EditText class_2_edit = findViewById(R.id.class_2_input);
        final EditText class_3_edit = findViewById(R.id.class_3_input);
        final EditText class_4_edit = findViewById(R.id.class_4_input);
        final EditText class_5_edit = findViewById(R.id.class_5_input);
        final TextView result_txt = findViewById(R.id.result_value);
        final Button compute_btn = findViewById(R.id.submit);
        final View root = findViewById(R.id.root);

        class_1_edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                compute_btn.setText("Compute GPA");
                return false;
            }
        });

        class_2_edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                compute_btn.setText("Compute GPA");
                return false;
            }
        });

        class_3_edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                compute_btn.setText("Compute GPA");
                return false;
            }
        });

        class_4_edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                compute_btn.setText("Compute GPA");
                return false;
            }
        });

        class_5_edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                compute_btn.setText("Compute GPA");
                return false;
            }
        });
        compute_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (compute_btn.getText().toString().equals("Compute GPA")) {
                    if (checkInput(class_1_edit) && checkInput(class_2_edit) && checkInput(class_3_edit) && checkInput(class_4_edit) && checkInput(class_5_edit)) {
                        Integer val_1 = Integer.valueOf(class_1_edit.getText().toString());
                        Integer val_2 = Integer.valueOf(class_2_edit.getText().toString());
                        Integer val_3 = Integer.valueOf(class_3_edit.getText().toString());
                        Integer val_4 = Integer.valueOf(class_4_edit.getText().toString());
                        Integer val_5 = Integer.valueOf(class_5_edit.getText().toString());
                        int result = (val_1 + val_2 + val_3 + val_4 + val_5) / 5;
                        if (result < 60) {
                            root.setBackgroundColor(Color.parseColor("#FF0000"));
                        } else if (result < 80) {
                            root.setBackgroundColor(Color.parseColor("#FFFF00"));
                        } else {
                            root.setBackgroundColor(Color.parseColor("#008000"));
                        }
                        result_txt.setText(String.valueOf(result));
                        compute_btn.setText("Clear");
                    } else {
                        Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                    }
                } else {
                    class_1_edit.setText("");
                    class_2_edit.setText("");
                    class_3_edit.setText("");
                    class_4_edit.setText("");
                    class_5_edit.setText("");
                    result_txt.setText("");
                    root.setBackgroundColor(Color.TRANSPARENT);
                    compute_btn.setText("Compute GPA");
                }
            }
        });
    }

    public static Boolean checkInput(EditText x) {
        Boolean result = !TextUtils.isEmpty(x.getText().toString()) && TextUtils.isDigitsOnly(x.getText());
        if (!result) {
            x.setBackgroundColor(Color.parseColor("#FF0000"));
        } else {
            x.setBackgroundColor(Color.TRANSPARENT);
        }
        return result;
    }
}
