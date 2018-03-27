package com.example.tnv.myappclc.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tnv.myappclc.R;
import com.example.tnv.myappclc.unltil.Service;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "abc";
    EditText editTextUser,editTextPass;
    Button buttonLogin,buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginApp(Service.URL_GETLOGIN);
                Log.e(TAG, "User: "+editTextUser.getText().toString() );
                Log.e(TAG, "Pass: "+editTextPass.getText().toString() );
            }
        });
    }

    private void LoginApp(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")){
                    Log.e(TAG, "Success: "+response );
                    Intent intent = new Intent(MainActivity.this,MainActivityApp.class);
                    startActivity(intent);
                }else{
                    showDialog("Tài khoản và mật khẩu không hợp lệ");
                    editTextUser.setText("");
                    editTextPass.setText("");
                    editTextUser.requestFocus();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Loi : "+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("USERNAME",editTextUser.getText().toString().trim());
                map.put("PASSWORD",editTextPass.getText().toString().trim());
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void InitWidget() {
        editTextPass = findViewById(R.id.tvPass);
        editTextUser= findViewById(R.id.tvUser);
        buttonLogin = findViewById(R.id.btnLogin);
        buttonCancel= findViewById(R.id.btnCancel);
    }

    private void showDialog(String message){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
