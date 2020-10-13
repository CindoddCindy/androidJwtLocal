package ac.i.pemesanan;

import ac.i.pemesanan.fragment.Home;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText edemail , edpassword;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edemail=findViewById(R.id.emailuser);
        edpassword=findViewById(R.id.Passworduser);
        btn_login=findViewById(R.id.button);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edemail.getText().toString();
                String password = edpassword.getText().toString();

                Toast.makeText(Login.this, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this, Beranda.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();

            }
        });
    }
}
