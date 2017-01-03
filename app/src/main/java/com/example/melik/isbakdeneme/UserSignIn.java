package com.example.melik.isbakdeneme;

import android.app.Activity;
import android.content.Intent;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by melik on 22.12.2016.
 */

public class UserSignIn extends Activity {
    EditText userSignInPassEdt, userSignInMailEdt;
    Button userSignInPageBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_sign_in);


        userSignInMailEdt = (EditText)findViewById(R.id.userSignInMail);
        userSignInPassEdt = (EditText)findViewById(R.id.userSignInPass);
        userSignInPageBtn = (Button)findViewById(R.id.userSignInPageBtn);

        userSignInPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userMenuIntent = new Intent(UserSignIn.this, UserMenu.class);
                startActivity(userMenuIntent);

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest sr = new StringRequest(Request.Method.POST, "http://eticaret.merkezyazilim.com/service/giris", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int durum,tip;
                        String mesaj;

                        try {

                            JSONObject obj = new JSONObject(response);
                            durum = obj.getInt("durum");
                            tip = obj.getInt("type");
                            mesaj = obj.getString("mesaj");
                            if (durum == 0) {

                                if (tip == 1) {
                                    Toast.makeText(UserSignIn.this, "Veriler Gönderilemedi Lütfen Daha Sonra Tekrar Deneyin", Toast.LENGTH_SHORT).show();

                                } else if (tip == 2) {

                                    Toast.makeText(UserSignIn.this,mesaj,Toast.LENGTH_SHORT).show();

                                } else if (tip == 3) {

                                    Toast.makeText(UserSignIn.this,"Sunucuya Erişilemedi",Toast.LENGTH_SHORT).show();

                                } else if (tip == 4) {
                                    Toast.makeText(UserSignIn.this,"Kullanıcı Adı ve Şifre Hatalı",Toast.LENGTH_SHORT).show();

                                } else if (tip == 5) {

                                    Toast.makeText(UserSignIn.this,mesaj,Toast.LENGTH_SHORT).show();                                }

                            } else if (durum == 1) {

                                if (tip == 0) {

                                    // alertMesaj("Giriş Başarılı Bro");

                                    Intent RegisterdenAnasayfaya = new Intent(getApplicationContext(), UserMenu.class);
                                    startActivity(RegisterdenAnasayfaya);

                                }

                            }


                            Log.d("My App", obj.toString());

                        } catch (Throwable t) {
                            Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");
                            Toast.makeText(UserSignIn.this,"Bir problemle karşılaştık, Hatayı bize bildirin",Toast.LENGTH_SHORT).show();

                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserSignIn.this,"SQLite ile hata durumları eklenecek",Toast.LENGTH_SHORT).show();

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("kadi", userSignInMailEdt.getText().toString());
                        params.put("sifre", userSignInPassEdt.getText().toString());

                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Content-Type", "application/x-www-form-urlencoded");
                        return params;
                    }
                };
                queue.add(sr);


            }
        });

    }
}
