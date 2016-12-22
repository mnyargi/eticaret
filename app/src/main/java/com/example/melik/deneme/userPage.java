package com.example.melik.deneme;

import android.app.Activity;
import android.preference.EditTextPreference;
import android.app.DownloadManager;
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
 * Created by melik on 20.11.2016.
 */
public class userPage extends Activity {

    EditText userMail,userPass;
    RequestQueue queue;
    Button userBtnGrs;
    Toast to;
    StringRequest sr;
    String mail,sifre;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.kullanicigiris);
        userMail = (EditText)findViewById(R.id.userMailTxt);
        userPass  = (EditText)findViewById(R.id.userPassTxt);
        userBtnGrs = (Button)findViewById(R.id.userBtnGrs);

        userBtnGrs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                StringRequest sr = new StringRequest(Request.Method.POST, "http://eticaret.merkezyazilim.com/service/giris",
                        new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int durum, tip;
                        String mesaj;


                        try {

                            JSONObject obj = new JSONObject(response);
                            durum = obj.getInt("durum");
                            tip = obj.getInt("type");
                            mesaj = obj.getString("mesaj");
                            if (durum == 0) {

                                if (tip == 1) {
                                    Toast.makeText(userPage.this, "Veriler Gönderilemedi Lütfen Daha Sonra Tekrar Deneyin", Toast.LENGTH_SHORT).show();
                                } else if (tip == 2) {
                                    Toast.makeText(userPage.this, mesaj, Toast.LENGTH_SHORT).show();

                                } else if (tip == 3) {
                                    Toast.makeText(userPage.this, "Sunucuya Erişilemedi", Toast.LENGTH_SHORT).show();
                                } else if (tip == 4) {
                                    Toast.makeText(userPage.this, "Kullanıcı Adı ve Şifre Hatalı", Toast.LENGTH_SHORT).show();

                                } else if (tip == 5) {
                                    Toast.makeText(userPage.this, mesaj, Toast.LENGTH_SHORT).show();

                                }

                            } else if (durum == 1) {

                                if (tip == 0) {

                                    Toast.makeText(userPage.this, "Giriş Başarılı Bro", Toast.LENGTH_SHORT).show();

                                    Intent RegisterdenAnasayfaya = new Intent(getApplicationContext(), userIndex.class);
                                    startActivity(RegisterdenAnasayfaya);

                                }

                            }


                            Log.d("My App", obj.toString());

                        } catch (Throwable t) {
                            Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");
                            Toast.makeText(userPage.this, "Bir problemle karşılaştık, Hatayı bize bildirin", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(userPage.this,"SQLite ile hata durumları eklenecek", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("kadi", userMail.getText().toString());
                        params.put("sifre", userPass.getText().toString());

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

    public void myClickHandler(View target) {
        // Do stuff
    }
}
