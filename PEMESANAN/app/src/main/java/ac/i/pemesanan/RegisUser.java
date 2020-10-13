package ac.i.pemesanan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import ac.i.pemesanan.model.ResponRegis;
import ac.i.pemesanan.retrofithandle.RetrofitLinkApi;
import ac.i.pemesanan.retrofithandle.RetrofitMethod;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisUser extends AppCompatActivity {

    private EditText editText_nama, editText_email, editText_phone, editText_password;

    private Button button_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_user);


        editText_nama=findViewById(R.id.et_nama);
        editText_email=findViewById(R.id.et_email);
        editText_password=findViewById(R.id.et_pass);
        editText_phone=findViewById(R.id.et_telp);

        button_regis=findViewById(R.id.btn_regis);

        button_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegis();

            }
        });

    }


    public void userRegis(){

        String nama=editText_nama.getText().toString();
        String email=editText_email.getText().toString();
        String pass=editText_password.getText().toString();
        String phone=editText_phone.getText().toString();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nameOrd", String.valueOf(nama));
        jsonObject.addProperty("username", String.valueOf(email));
        jsonObject.addProperty("email", String.valueOf(pass));
        jsonObject.addProperty("password", String.valueOf(phone));



        RetrofitMethod retrofitMethod =  RetrofitLinkApi.getRetrofitLogin().create(RetrofitMethod.class);
        Call<ResponRegis> call= retrofitMethod.registerUser(jsonObject);
        call.enqueue(new Callback<ResponRegis>() {
            @Override
            public void onResponse(Call<ResponRegis> call, Response<ResponRegis> response) {
                if(response.isSuccessful()){

                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(RegisUser.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(RegisUser.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(RegisUser.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(RegisUser.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponRegis> call, Throwable t) {
                Toast.makeText(RegisUser.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });






    }
}