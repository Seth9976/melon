package d3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;

public final class b {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public final CharSequence a;
    public final Layout.Alignment b;
    public final Layout.Alignment c;
    public final Bitmap d;
    public final float e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;
    public final float j;
    public final float k;
    public final boolean l;
    public final int m;
    public final int n;
    public final float o;
    public final int p;
    public final float q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;

    static {
        new b("", null, null, null, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f);
        b.r = "0";
        b.s = "h";
        b.t = "1";
        b.u = "2";
        b.v = "3";
        b.w = "i";
        b.x = "4";
        b.y = "5";
        b.z = "6";
        b.A = "7";
        b.B = "8";
        b.C = "9";
        b.D = "a";
        b.E = "b";
        b.F = "c";
        b.G = "d";
        b.H = "e";
        b.I = "f";
        b.J = "g";
    }

    public b(CharSequence charSequence0, Layout.Alignment layout$Alignment0, Layout.Alignment layout$Alignment1, Bitmap bitmap0, float f, int v, int v1, float f1, int v2, int v3, float f2, float f3, float f4, boolean z, int v4, int v5, float f5) {
        if(charSequence0 == null) {
            bitmap0.getClass();
        }
        else {
            e3.b.c(bitmap0 == null);
        }
        if(charSequence0 instanceof Spanned) {
            this.a = SpannedString.valueOf(charSequence0);
        }
        else if(charSequence0 == null) {
            this.a = null;
        }
        else {
            this.a = charSequence0.toString();
        }
        this.b = layout$Alignment0;
        this.c = layout$Alignment1;
        this.d = bitmap0;
        this.e = f;
        this.f = v;
        this.g = v1;
        this.h = f1;
        this.i = v2;
        this.j = f3;
        this.k = f4;
        this.l = z;
        this.m = v4;
        this.n = v3;
        this.o = f2;
        this.p = v5;
        this.q = f5;
    }

    public static b a(Bundle bundle0) {
        int v9;
        int v8;
        float f3;
        int v5;
        float f1;
        Bitmap bitmap2;
        CharSequence charSequence1;
        CharSequence charSequence0 = bundle0.getCharSequence(b.r);
        boolean z = true;
        Bitmap bitmap0 = null;
        if(charSequence0 == null) {
            charSequence1 = null;
        }
        else {
            ArrayList arrayList0 = bundle0.getParcelableArrayList(b.s);
            if(arrayList0 != null) {
                charSequence0 = SpannableString.valueOf(charSequence0);
                for(Object object0: arrayList0) {
                    int v = ((Bundle)object0).getInt("0");
                    int v1 = ((Bundle)object0).getInt("1");
                    int v2 = ((Bundle)object0).getInt("2");
                    int v3 = ((Bundle)object0).getInt("3", -1);
                    Bundle bundle1 = ((Bundle)object0).getBundle("4");
                    switch(v3) {
                        case 1: {
                            bundle1.getClass();
                            String s = bundle1.getString("0");
                            s.getClass();
                            ((Spannable)charSequence0).setSpan(new f(s, bundle1.getInt("1")), v, v1, v2);
                            break;
                        }
                        case 2: {
                            bundle1.getClass();
                            ((Spannable)charSequence0).setSpan(new h(bundle1.getInt("0"), bundle1.getInt("1"), bundle1.getInt("2")), v, v1, v2);
                            break;
                        }
                        case 3: {
                            ((Spannable)charSequence0).setSpan(new e(), v, v1, v2);  // 初始化器: Ljava/lang/Object;-><init>()V
                            break;
                        }
                        case 4: {
                            bundle1.getClass();
                            String s1 = bundle1.getString("0");
                            s1.getClass();
                            ((Spannable)charSequence0).setSpan(new i(s1), v, v1, v2);
                        }
                    }
                }
            }
            charSequence1 = charSequence0;
        }
        Layout.Alignment layout$Alignment0 = (Layout.Alignment)bundle0.getSerializable(b.t);
        Layout.Alignment layout$Alignment1 = layout$Alignment0 == null ? null : layout$Alignment0;
        Layout.Alignment layout$Alignment2 = (Layout.Alignment)bundle0.getSerializable(b.u);
        Layout.Alignment layout$Alignment3 = layout$Alignment2 == null ? null : layout$Alignment2;
        Bitmap bitmap1 = (Bitmap)bundle0.getParcelable(b.v);
        if(bitmap1 == null) {
            byte[] arr_b = bundle0.getByteArray(b.w);
            if(arr_b != null) {
                bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length);
            }
            bitmap2 = bitmap0;
        }
        else {
            bitmap2 = bitmap1;
        }
        String s2 = b.x;
        float f = -3.402823E+38f;
        int v4 = 0x80000000;
        if(bundle0.containsKey(s2)) {
            String s3 = b.y;
            if(bundle0.containsKey(s3)) {
                f1 = bundle0.getFloat(s2);
                v5 = bundle0.getInt(s3);
            }
            else {
                f1 = -3.402823E+38f;
                v5 = 0x80000000;
            }
        }
        else {
            f1 = -3.402823E+38f;
            v5 = 0x80000000;
        }
        int v6 = bundle0.containsKey(b.z) ? bundle0.getInt(b.z) : 0x80000000;
        float f2 = bundle0.containsKey(b.A) ? bundle0.getFloat(b.A) : -3.402823E+38f;
        int v7 = bundle0.containsKey(b.B) ? bundle0.getInt(b.B) : 0x80000000;
        String s4 = b.D;
        if(bundle0.containsKey(s4)) {
            String s5 = b.C;
            if(bundle0.containsKey(s5)) {
                f3 = bundle0.getFloat(s4);
                v8 = bundle0.getInt(s5);
            }
            else {
                f3 = -3.402823E+38f;
                v8 = 0x80000000;
            }
        }
        else {
            f3 = -3.402823E+38f;
            v8 = 0x80000000;
        }
        float f4 = bundle0.containsKey(b.E) ? bundle0.getFloat(b.E) : -3.402823E+38f;
        String s6 = b.F;
        if(bundle0.containsKey(s6)) {
            f = bundle0.getFloat(s6);
        }
        String s7 = b.G;
        if(bundle0.containsKey(s7)) {
            v9 = bundle0.getInt(s7);
        }
        else {
            v9 = 0xFF000000;
            z = false;
        }
        boolean z1 = bundle0.getBoolean(b.H, false) ? z : false;
        String s8 = b.I;
        if(bundle0.containsKey(s8)) {
            v4 = bundle0.getInt(s8);
        }
        return bundle0.containsKey(b.J) ? new b(charSequence1, layout$Alignment1, layout$Alignment3, bitmap2, f1, v5, v6, f2, v7, v8, f3, f4, f, z1, v9, v4, bundle0.getFloat(b.J)) : new b(charSequence1, layout$Alignment1, layout$Alignment3, bitmap2, f1, v5, v6, f2, v7, v8, f3, f4, f, z1, v9, v4, 0.0f);
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        CharSequence charSequence0 = this.a;
        if(charSequence0 != null) {
            bundle0.putCharSequence(b.r, charSequence0);
            if(charSequence0 instanceof Spanned) {
                ArrayList arrayList0 = new ArrayList();
                f[] arr_f = (f[])((Spanned)charSequence0).getSpans(0, ((Spanned)charSequence0).length(), f.class);
                for(int v1 = 0; v1 < arr_f.length; ++v1) {
                    f f0 = arr_f[v1];
                    f0.getClass();
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("0", f0.a);
                    bundle1.putInt("1", f0.b);
                    arrayList0.add(d.a(((Spanned)charSequence0), f0, 1, bundle1));
                }
                h[] arr_h = (h[])((Spanned)charSequence0).getSpans(0, ((Spanned)charSequence0).length(), h.class);
                for(int v2 = 0; v2 < arr_h.length; ++v2) {
                    h h0 = arr_h[v2];
                    h0.getClass();
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("0", h0.a);
                    bundle2.putInt("1", h0.b);
                    bundle2.putInt("2", h0.c);
                    arrayList0.add(d.a(((Spanned)charSequence0), h0, 2, bundle2));
                }
                e[] arr_e = (e[])((Spanned)charSequence0).getSpans(0, ((Spanned)charSequence0).length(), e.class);
                for(int v3 = 0; v3 < arr_e.length; ++v3) {
                    arrayList0.add(d.a(((Spanned)charSequence0), arr_e[v3], 3, null));
                }
                i[] arr_i = (i[])((Spanned)charSequence0).getSpans(0, ((Spanned)charSequence0).length(), i.class);
                for(int v = 0; v < arr_i.length; ++v) {
                    i i0 = arr_i[v];
                    i0.getClass();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("0", i0.a);
                    arrayList0.add(d.a(((Spanned)charSequence0), i0, 4, bundle3));
                }
                if(!arrayList0.isEmpty()) {
                    bundle0.putParcelableArrayList(b.s, arrayList0);
                }
            }
        }
        bundle0.putSerializable(b.t, this.b);
        bundle0.putSerializable(b.u, this.c);
        bundle0.putFloat(b.x, this.e);
        bundle0.putInt(b.y, this.f);
        bundle0.putInt(b.z, this.g);
        bundle0.putFloat(b.A, this.h);
        bundle0.putInt(b.B, this.i);
        bundle0.putInt(b.C, this.n);
        bundle0.putFloat(b.D, this.o);
        bundle0.putFloat(b.E, this.j);
        bundle0.putFloat(b.F, this.k);
        bundle0.putBoolean(b.H, this.l);
        bundle0.putInt(b.G, this.m);
        bundle0.putInt(b.I, this.p);
        bundle0.putFloat(b.J, this.q);
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(b.class == class0) {
                Bitmap bitmap0 = ((b)object0).d;
                if(TextUtils.equals(this.a, ((b)object0).a) && this.b == ((b)object0).b && this.c == ((b)object0).c) {
                    Bitmap bitmap1 = this.d;
                    if(bitmap1 == null) {
                        return bitmap0 == null ? this.e == ((b)object0).e && this.f == ((b)object0).f && this.g == ((b)object0).g && this.h == ((b)object0).h && this.i == ((b)object0).i && this.j == ((b)object0).j && this.k == ((b)object0).k && this.l == ((b)object0).l && this.m == ((b)object0).m && this.n == ((b)object0).n && this.o == ((b)object0).o && this.p == ((b)object0).p && this.q == ((b)object0).q : false;
                    }
                    return bitmap0 == null || !bitmap1.sameAs(bitmap0) ? false : this.e == ((b)object0).e && this.f == ((b)object0).f && this.g == ((b)object0).g && this.h == ((b)object0).h && this.i == ((b)object0).i && this.j == ((b)object0).j && this.k == ((b)object0).k && this.l == ((b)object0).l && this.m == ((b)object0).m && this.n == ((b)object0).n && this.o == ((b)object0).o && this.p == ((b)object0).p && this.q == ((b)object0).q;
                }
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, Boolean.valueOf(this.l), this.m, this.n, this.o, this.p, this.q});
    }
}

