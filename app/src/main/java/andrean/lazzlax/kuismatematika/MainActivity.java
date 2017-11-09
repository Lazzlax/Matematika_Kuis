package andrean.lazzlax.kuismatematika;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText soal1, soal2, operasi, jawabanInput;
    TextView Benar, Salah, Hasil;
    Button Cek;
    int value1, value2, value3, jawabBenar, jawabSalah;
    String getJawab, getOpr;


    SharedPref classShardPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classShardPref = new SharedPref (MainActivity.this.getApplicationContext());

        soal1 = (EditText) findViewById(R.id.soal1);
        soal2 = (EditText) findViewById(R.id.soal2);
        operasi = (EditText) findViewById(R.id.operasi);
        jawabanInput = (EditText) findViewById(R.id.jawabanInput);
        Benar = (TextView) findViewById(R.id.Benar);
        Salah = (TextView) findViewById(R.id.Salah);
        Hasil = (TextView) findViewById(R.id.Hasil);
        Cek = (Button) findViewById(R.id.Cek);

        this.generateSoal(findViewById(R.id.soalBaru));

        //GetFromPreferences
        jawabBenar = classShardPref.getNilaiBenar();
        jawabSalah = classShardPref.getNilaiSalah();
        Benar.setText(String.valueOf(classShardPref.getNilaiBenar()) + " Jawaban Benar");
        Salah.setText(String.valueOf(classShardPref.getNilaiSalah()) + " Jawaban Salah");

    }



    public void generateSoal(View view) {
        Cek.setEnabled(true);
        jawabanInput.setText("");
        value1 = (int)(Math.random()*100 + 1);
        value2 = (int)(Math.random()*100 + 1);
        value3 = (int)(Math.random()*4 + 1);
        if(value3==1){
            operasi.setText(String.valueOf("+"));
        }
        else if(value3==2){
            operasi.setText(String.valueOf("-"));
        }
        else if(value3==3){
            operasi.setText(String.valueOf("x"));
        }
        else if(value3==4){
            operasi.setText(String.valueOf("/"));
        }

        soal1.setText(String.valueOf(value1));
        soal2.setText(String.valueOf(value2));
    }

    public void cekJawaban(View view) {
        Cek.setEnabled(false);
        getOpr = operasi.getText().toString();
        int hasil = 0;
        if(getOpr.equals("+")){
            hasil = value1 + value2;
        }
        else if(getOpr.equals("-")){
            hasil = value1 - value2;
        }
        else if(getOpr.equals("x")){
            hasil = value1 * value2;
        }
        else if(getOpr.equals("/")){
            hasil = value1 / value2;
        }
        getJawab = jawabanInput.getText().toString();
        if (getJawab.equals(String.valueOf(hasil))) {

            jawabBenar = jawabBenar + 1;
            Benar.setText(String.valueOf(jawabBenar) + " Jawaban Benar");
            Hasil.setText("Jawaban: "+String.valueOf(hasil)+"\nJawaban Anda Benar Cuuuyy");

            classShardPref.setNilaiBenar(jawabBenar);
        } else {
            jawabSalah = jawabSalah + 1;

            Salah.setText(String.valueOf(jawabSalah) + " Jawaban Salah");
            Hasil.setText("Jawaban: "+String.valueOf(hasil)+"\nKok Salah Sih Jawabannya, Coba Lagi");

            classShardPref.setNilaiSalah(jawabSalah);

        }
    }
}
