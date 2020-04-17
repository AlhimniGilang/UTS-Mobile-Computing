package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    RadioGroup radio;
    RadioButton arabica, robusta, blend;
    EditText namabarang, hargasatuan, jumlahsatuan;
    Button hasil;
    TextView thasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton arabica = (RadioButton) findViewById(R.id.arabica);
        final RadioButton robusta = (RadioButton) findViewById(R.id.robusta);
        final RadioButton blend = (RadioButton) findViewById(R.id.blend);
        final RadioGroup radio = findViewById(R.id.radio);
        final EditText namabarang = (EditText) findViewById(R.id.namabarang);
        final EditText hargasatuan = (EditText) findViewById(R.id.hargasatuan);
        final EditText jumlahsatuan = (EditText) findViewById(R.id.jumlahsatuan);
        Button hasil = (Button) findViewById(R.id.hasil);
        final TextView thasil = (TextView) findViewById(R.id.thasil);

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipeA = arabica.getText().toString().trim();
                String tipeB = robusta.getText().toString().trim();
                String tipeC = blend.getText().toString().trim();
                String namaB = namabarang.getText().toString().trim();
                String hargasat = hargasatuan.getText().toString().trim();
                String jumlahsatsat = jumlahsatuan.getText().toString().trim();

                double prb = radio.getCheckedRadioButtonId();
                if (prb == R.id.arabica){
                    prb = 0.05;
                }else if (prb == R.id.blend){
                    prb= 0.02;
                }else{
                    prb=0;
                }

                int hargas = Integer.parseInt(hargasat);
                int jumlahs = Integer.parseInt(jumlahsatsat);
                double totalpem = jumlahs*hargas;
                double diskon;
                if (totalpem<1000000){
                    diskon=0;
                }else if (totalpem>=100000 && totalpem<=5000000){
                    diskon=0.02;
                }else{
                    diskon=0.04;
                }


                int diskonseluruh = (int) ((prb+diskon)*totalpem);
                int total = (hargas*jumlahs)-diskonseluruh;
                thasil.setText("Nama Barang                         = "+namaB+
                             "\nHarga Satuan                        = "+ hargas+
                             "\nJumlah Satuan                       = "+jumlahs+
                             "\nDiskon                                = "+diskonseluruh+
                             "\nJumlah Total Pembelian          = "+total);
            }
        });

    }

}


