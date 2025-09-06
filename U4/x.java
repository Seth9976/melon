package U4;

import B3.d;
import D4.o;
import D4.r;
import De.l;
import M.c;
import a1.U;
import android.database.sqlite.SQLiteDatabase;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.t;
import r0.n;
import r0.q;

public abstract class x {
    public static String A(int v) {
        switch(v) {
            case 1: {
                return "NOT_REQUIRED";
            }
            case 2: {
                return "CONNECTED";
            }
            case 3: {
                return "UNMETERED";
            }
            case 4: {
                return "NOT_ROAMING";
            }
            case 5: {
                return "METERED";
            }
            case 6: {
                return "TEMPORARILY_UNMETERED";
            }
            default: {
                return "null";
            }
        }
    }

    public static String B(int v) [...] // 潜在的解密器

    public static String C(int v) {
        switch(v) {
            case 1: {
                return "AZTEC";
            }
            case 2: {
                return "CODABAR";
            }
            case 3: {
                return "CODE_39";
            }
            case 4: {
                return "CODE_93";
            }
            case 5: {
                return "CODE_128";
            }
            case 6: {
                return "DATA_MATRIX";
            }
            case 7: {
                return "EAN_8";
            }
            case 8: {
                return "EAN_13";
            }
            case 9: {
                return "ITF";
            }
            case 10: {
                return "MAXICODE";
            }
            case 11: {
                return "PDF_417";
            }
            case 12: {
                return "QR_CODE";
            }
            case 13: {
                return "RSS_14";
            }
            case 14: {
                return "RSS_EXPANDED";
            }
            case 15: {
                return "UPC_A";
            }
            case 16: {
                return "UPC_E";
            }
            case 17: {
                return "UPC_EAN_EXTENSION";
            }
            default: {
                return "null";
            }
        }
    }

    public static int a(int v, int v1, U u0) {
        return (u0.hashCode() + v) * v1;
    }

    public static int b(int v, int v1, String s) {
        return (s.hashCode() + v) * v1;
    }

    public static l c(Class class0, String s, String s1, int v, J j0) {
        return j0.e(new t(class0, s, s1, v));
    }

    public static b0 d(int v, p p0) {
        b0 b00 = w.s(v);
        p0.l0(b00);
        return b00;
    }

    public static String e(int v, String s) [...] // Inlined contents

    public static String f(int v, String s, String s1) [...] // Inlined contents

    public static String g(int v, String s, StringBuilder stringBuilder0) {
        stringBuilder0.append(v);
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public static String h(long v, String s, StringBuilder stringBuilder0) {
        stringBuilder0.append(v);
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public static String i(String s, d d0, String s1) [...] // Inlined contents

    public static String j(String s, r r0, String s1, r r1) [...] // Inlined contents

    public static String k(String s, String s1, String s2) [...] // Inlined contents

    public static String l(String s, String s1, String s2, String s3, String s4) [...] // Inlined contents

    public static String m(StringBuilder stringBuilder0, String s, String s1) [...] // 潜在的解密器

    public static StringBuilder n(int v, String s, String s1) {
        StringBuilder stringBuilder0 = new StringBuilder(s);
        stringBuilder0.append(v);
        stringBuilder0.append(s1);
        return stringBuilder0;
    }

    public static StringBuilder o(int v, String s, String s1, String s2, String s3) {
        StringBuilder stringBuilder0 = new StringBuilder(s);
        stringBuilder0.append(v);
        stringBuilder0.append(s1);
        stringBuilder0.append(s2);
        stringBuilder0.append(s3);
        return stringBuilder0;
    }

    public static StringBuilder p(String s, String s1) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(s);
        stringBuilder0.append(s1);
        return stringBuilder0;
    }

    public static HashSet q(HashMap hashMap0, String s, o o0, int v) {
        hashMap0.put(s, o0);
        return new HashSet(v);
    }

    public static q r(float f, q q0, boolean z) {
        return q0.then(new LayoutWeightElement(f, z));
    }

    public static q s(n n0, float f, p p0, n n1, float f1) {
        c.d(p0, androidx.compose.foundation.layout.d.h(n0, f));
        return androidx.compose.foundation.layout.d.f(n1, f1);
    }

    public static void t(int v, SpannableStringBuilder spannableStringBuilder0, int v1, int v2, int v3) {
        spannableStringBuilder0.setSpan(new StyleSpan(v), v1, v2, v3);
    }

    public static void u(int v, String s, String s1) {
        Log.w(s1, s + v);
    }

    public static void v(SQLiteDatabase sQLiteDatabase0, String s, String s1, String s2, String s3) {
        sQLiteDatabase0.execSQL(s);
        sQLiteDatabase0.execSQL(s1);
        sQLiteDatabase0.execSQL(s2);
        sQLiteDatabase0.execSQL(s3);
    }

    public static void w(String s, String s1, String s2) {
        Log.d(s2, s + s1);
    }

    public static void x(StringBuilder stringBuilder0, int v, String s, int v1, String s1) {
        stringBuilder0.append(v);
        stringBuilder0.append(s);
        stringBuilder0.append(v1);
        stringBuilder0.append(s1);
    }

    public static void y(StringBuilder stringBuilder0, boolean z, String s, boolean z1, String s1) {
        stringBuilder0.append(z);
        stringBuilder0.append(s);
        stringBuilder0.append(z1);
        stringBuilder0.append(s1);
    }

    public static void z(n n0, float f, p p0, boolean z) {
        c.d(p0, androidx.compose.foundation.layout.d.q(n0, f));
        p0.p(z);
    }
}

