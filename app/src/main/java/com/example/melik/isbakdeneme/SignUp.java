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

public class SignUp extends Activity {

    Button kayitOl;
    EditText kullaniciAdi, kullaniciSoyadi, kullaniciMail, kullaniciSifre, kullaniciSifreTekrar,kullaniciTel;
    String kadi,ksoyadi,kmail,ksifre,ktel;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        super.onCreate(savedInstanceState);
        kayitOl = (Button)findViewById(R.id.signUp) ;
        kullaniciAdi=(EditText)findViewById(R.id.userName);
        kullaniciSoyadi=(EditText)findViewById(R.id.userSurname);
        kullaniciMail=(EditText)findViewById(R.id.userMail);
        kullaniciSifre=(EditText)findViewById(R.id.userPass);
        kullaniciSifreTekrar=(EditText)findViewById(R.id.userPass2);
        kullaniciTel=(EditText)findViewById(R.id.userPhone);

        kayitOl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                kadi=kullaniciAdi.getText().toString().trim();
                ksoyadi=kullaniciSoyadi.getText().toString().trim();
                ksifre=kullaniciSifre.getText().toString().trim();
                kmail=kullaniciMail.getText().toString().trim();
                ktel=kullaniciTel.getText().toString().trim();

                if(kmail.matches("") || kadi.matches("") ||ksoyadi.matches("") || ksifre.matches("") || ktel.matches("")   ){
                    if(kmail.matches("")){
                        Toast.makeText(SignUp.this, "Email Boş Lütfen Doldorunuz", Toast.LENGTH_SHORT).show();
                    }
                    if(kadi.matches("")){
                        Toast.makeText(SignUp.this, "Adiniz Boş Lütfen Doldorunuz", Toast.LENGTH_SHORT).show();
                    }
                    if(ksoyadi.matches("")){
                        Toast.makeText(SignUp.this, "Soyadiniz Boş Lütfen Doldorunuz", Toast.LENGTH_SHORT).show();
                    }
                    if(ksifre.matches("")){
                        Toast.makeText(SignUp.this, "Şifreniz Boş Lütfen Doldorunuz", Toast.LENGTH_SHORT).show();
                    }
                    if(ktel.matches("")){
                        Toast.makeText(SignUp.this, "Telefon Boş Lütfen Doldorunuz", Toast.LENGTH_SHORT).show();
                    }

                    Toast.makeText(SignUp.this, "Lütfen Alanları Doldurunuz", Toast.LENGTH_SHORT).show();
                }
                else{
                    //  Toast.makeText(Register.this, "Girdi", Toast.LENGTH_SHORT).show();
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest sr = new StringRequest(Request.Method.POST,"http://eticaret.merkezyazilim.com/service/kayit", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            int durum,tip;
                            String mesaj;

                            try {

                                JSONObject obj = new JSONObject(response);
                                durum = obj.getInt("durum");
                                tip=obj.getInt("type");
                                mesaj=obj.getString("mesaj");
                                if(durum==0){

                                    if(tip==1){
                                        Toast.makeText(SignUp.this, "Veriler Gönderilemedi Lütfen Daha Sonra Tekrar Deneyin", Toast.LENGTH_SHORT).show();
                                    }else if(tip==2){
                                        Toast.makeText(SignUp.this, mesaj, Toast.LENGTH_SHORT).show();
                                    }else if(tip==3){
                                        Toast.makeText(SignUp.this, "Sunucuya Erişilemedi", Toast.LENGTH_SHORT).show();
                                    }
                                    else if(tip==4){
                                        Toast.makeText(SignUp.this, "Kullanıcı Adı ve Şifre Hatalı", Toast.LENGTH_SHORT).show();
                                    }else if(tip==5){
                                        Toast.makeText(SignUp.this, mesaj, Toast.LENGTH_SHORT).show();
                                    }

                                }else if(durum==1){

                                    if(tip==0){

                                        // alertMesaj("Giriş Başarılı Bro");

                                        Intent RegisterdenAnasayfaya = new Intent(getApplicationContext(), UserSignIn.class);
                                        startActivity(RegisterdenAnasayfaya);
                                    }

                                }


                                Log.d("My App", obj.toString());

                            } catch (Throwable t) {
                                Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");
                                Toast.makeText(SignUp.this, "Bir problemle karşılaştık, Hatayı bize bildirin", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(SignUp.this, "SQLite ile hata durumları eklenecek", Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String,String> getParams(){
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("adi",kadi);
                            params.put("soyadi",ksoyadi);
                            params.put("kadi",kmail);
                            params.put("sifre",ksifre);
                            params.put("email",kmail);
                            params.put("tel",ktel);

                            return params;
                        }

                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("Content-Type","application/x-www-form-urlencoded");
                            return params;
                        }
                    };
                    queue.add(sr);
                }
            }

        });



    }
}
