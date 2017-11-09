package andrean.lazzlax.kuismatematika;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lazzlax on 11/9/2017.
 */

class SharedPref {

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Context context;
    int private_mode = 0;
    private static final String PREF_NAME = "penyimpanannilai";

    public SharedPref(Context context) {
        this.context = context;
        sp = context.getSharedPreferences(PREF_NAME, private_mode);
        editor = sp.edit();
    }

    public void setNilaiBenar(int nilai) {
        editor.putInt("nilBenar", nilai);
        editor.commit();
    }

    public void setNilaiSalah(int nilai) {
        editor.putInt("nilSalah", nilai);
        editor.commit();
    }

    public int getNilaiBenar() {
        return sp.getInt("nilBenar", 0);

    }

    public int getNilaiSalah() {
        return sp.getInt("nilSalah", 0);
    }

}
