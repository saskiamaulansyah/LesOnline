package id.sch.smktelkom_mlg.tugas01.xirpl4030.lesonline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNamaSiswa;
    EditText etNomor;
    EditText etEmail;
    EditText etNamaOrtu;
    EditText etNomorOrtu;
    EditText etAlamat;
    Button bOk;
    TextView tvHasil;
    RadioButton rbL, rbP;
    CheckBox cbMatematika, cbBiologi, cbFisika, cbKimia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamaSiswa = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etNamaOrtu = (EditText) findViewById(R.id.editTextNamaOrtu);
        etNomorOrtu = (EditText) findViewById(R.id.editTextNomorOrtu);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        cbMatematika = (CheckBox) findViewById(R.id.checkboxMat);
        cbFisika = (CheckBox) findViewById(R.id.checkboxFis);
        cbKimia = (CheckBox) findViewById(R.id.checkboxKim);
        cbBiologi = (CheckBox) findViewById(R.id.checkboxBio);

        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {

        if (isValid()) {
            String jk;
            String mapel;
            String nama = etNamaSiswa.getText().toString();
            String nomor = etNomor.getText().toString();
            String email = etEmail.getText().toString();
            String namaortu = etNamaOrtu.getText().toString();
            String nomorortu = etNomorOrtu.getText().toString();
            String alamat = etAlamat.getText().toString();

            if (rbL.isChecked()) {
                jk = rbL.getText().toString();
            } else {
                jk = rbP.getText().toString();
            }

            if (cbMatematika.isChecked()) {
                mapel = cbMatematika.getText().toString();
            } else if (cbBiologi.isChecked()) {
                mapel = cbBiologi.getText().toString();
            } else if (cbKimia.isChecked()) {
                mapel = cbKimia.getText().toString();
            } else {
                mapel = cbFisika.getText().toString();
            }

            tvHasil.setText("Selamat " + nama + ", Anda telah terdaftar dalam bimbingan belajar kami. Berikut data diri Anda : \n" +
                    "Nama : " + nama + "\nNomor Telepon : " + nomor + "\nEmail : " + email + "\nNama Orang Tua : " + namaortu +
                    "\nNomor Telepon Orangtua : " + nomorortu + "\nAlamat : " + alamat + "\nJenisKelamin : " + jk + "\nMapel Les : "
                    + mapel);


        }
    }

    public boolean isValid() {
        boolean valid = true;

        String nama = etNamaSiswa.getText().toString();
        String nomor = etNomor.getText().toString();
        String email = etEmail.getText().toString();
        String namaortu = etNamaOrtu.getText().toString();
        String nomorortu = etNomorOrtu.getText().toString();
        String alamat = etAlamat.getText().toString();

        if (nama.isEmpty()) {
            etNamaSiswa.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNamaSiswa.setError("Nama Minimal 3 karakter");
            valid = false;
        } else {
            etNamaSiswa.setError(null);
        }

        if (nomor.isEmpty()) {
            etNomor.setError("Nomor Telepon Belum Diisi");
            valid = false;
        } else {
            etNomor.setError(null);
        }

        if (namaortu.isEmpty()) {
            etNamaOrtu.setError("Nama Belum Diisi");
            valid = false;
        } else if (namaortu.length() < 3) {
            etNamaOrtu.setError("Nama Belum Diisi");
            valid = false;
        } else {
            etNamaOrtu.setError(null);
        }

        if (nomorortu.isEmpty()) {
            etNomorOrtu.setError("Nomor Ortu Belum Diisi");
            valid = false;
        } else {
            etNomorOrtu.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Email Belum Diisi");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum Diisi");
            valid = false;
        } else {
            etAlamat.setError(null);
        }


        return valid;
    }
}
