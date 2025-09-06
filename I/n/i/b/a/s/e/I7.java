package i.n.i.b.a.s.e;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public final class i7 {
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    public final Y8 f;
    public final String[] g;
    public final String h;
    public final String i;
    public final i7 j;
    public final HashMap k;
    public final HashMap l;
    public ArrayList m;

    public i7(String s, String s1, long v, long v1, Y8 y80, String[] arr_s, String s2, String s3, i7 i70) {
        this.a = s;
        this.b = s1;
        this.i = s3;
        this.f = y80;
        this.g = arr_s;
        this.c = s1 != null;
        this.d = v;
        this.e = v1;
        s2.getClass();
        this.h = s2;
        this.j = i70;
        this.k = new HashMap();
        this.l = new HashMap();
    }

    public final int a() {
        return this.m == null ? 0 : this.m.size();
    }

    public static SpannableStringBuilder b(String s, TreeMap treeMap0) {
        if(!treeMap0.containsKey(s)) {
            E3 e30 = new E3();
            e30.a = new SpannableStringBuilder();
            treeMap0.put(s, e30);
        }
        CharSequence charSequence0 = ((E3)treeMap0.get(s)).a;
        charSequence0.getClass();
        return (SpannableStringBuilder)charSequence0;
    }

    public final i7 c(int v) {
        ArrayList arrayList0 = this.m;
        if(arrayList0 == null) {
            throw new IndexOutOfBoundsException();
        }
        return (i7)arrayList0.get(v);
    }

    public static i7 d(String s) {
        return new i7(null, s.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), 0x8000000000000001L, 0x8000000000000001L, null, null, "", null, null);
    }

    public final void e(long v, String s, ArrayList arrayList0) {
        String s1 = this.h;
        if(!"".equals(s1)) {
            s = s1;
        }
        if(this.i(v) && "div".equals(this.a)) {
            String s2 = this.i;
            if(s2 != null) {
                arrayList0.add(new Pair(s, s2));
                return;
            }
        }
        for(int v1 = 0; v1 < this.a(); ++v1) {
            this.c(v1).e(v, s, arrayList0);
        }
    }

    public final void f(long v, Map map0, HashMap hashMap0, String s, TreeMap treeMap0) {
        i7 i71;
        if(this.i(v)) {
            String s1 = "".equals(this.h) ? s : this.h;
            for(Object object0: this.l.entrySet()) {
                String s2 = (String)((Map.Entry)object0).getKey();
                int v1 = this.k.containsKey(s2) ? ((int)(((Integer)this.k.get(s2)))) : 0;
                int v2 = (int)(((Integer)((Map.Entry)object0).getValue()));
                if(v1 != v2) {
                    E3 e30 = (E3)treeMap0.get(s2);
                    e30.getClass();
                    ((E7)hashMap0.get(s1)).getClass();
                    Y8 y80 = M7.h(this.f, this.g, map0);
                    SpannableStringBuilder spannableStringBuilder0 = (SpannableStringBuilder)e30.a;
                    if(spannableStringBuilder0 == null) {
                        spannableStringBuilder0 = new SpannableStringBuilder();
                        e30.a = spannableStringBuilder0;
                    }
                    if(y80 != null) {
                        if((y80.h != -1 || y80.i != -1 ? (y80.h == 1 ? 1 : 0) | (y80.i == 1 ? 2 : 0) : -1) != -1) {
                            spannableStringBuilder0.setSpan(new StyleSpan((y80.h != -1 || y80.i != -1 ? (y80.h == 1 ? 1 : 0) | (y80.i == 1 ? 2 : 0) : -1)), v1, v2, 33);
                        }
                        if(y80.f == 1) {
                            spannableStringBuilder0.setSpan(new StrikethroughSpan(), v1, v2, 33);
                        }
                        if(y80.g == 1) {
                            spannableStringBuilder0.setSpan(new UnderlineSpan(), v1, v2, 33);
                        }
                        if(y80.c) {
                            Ja.z(spannableStringBuilder0, new ForegroundColorSpan(y80.b), v1, v2);
                        }
                        if(y80.e) {
                            Ja.z(spannableStringBuilder0, new BackgroundColorSpan(y80.d), v1, v2);
                        }
                        if(y80.a != null) {
                            Ja.z(spannableStringBuilder0, new TypefaceSpan(y80.a), v1, v2);
                        }
                        if(y80.r != null) {
                            Ja.z(spannableStringBuilder0, new E4(7), v1, v2);
                        }
                        switch(y80.m) {
                            case 2: {
                                i7 i70 = this.j;
                                while(true) {
                                    if(i70 != null) {
                                        Y8 y81 = M7.h(i70.f, i70.g, map0);
                                        if(y81 != null && y81.m == 1) {
                                            break;
                                        }
                                        else {
                                            i70 = i70.j;
                                            continue;
                                        }
                                    }
                                    i70 = null;
                                    break;
                                }
                                if(i70 != null) {
                                    ArrayDeque arrayDeque0 = new ArrayDeque();
                                    arrayDeque0.push(i70);
                                    while(true) {
                                        i71 = null;
                                        if(!arrayDeque0.isEmpty()) {
                                            i7 i72 = (i7)arrayDeque0.pop();
                                            Y8 y82 = M7.h(i72.f, i72.g, map0);
                                            if(y82 == null || y82.m != 3) {
                                                for(int v3 = i72.a() - 1; v3 >= 0; --v3) {
                                                    arrayDeque0.push(i72.c(v3));
                                                }
                                                continue;
                                            }
                                            else {
                                                i71 = i72;
                                            }
                                        }
                                        break;
                                    }
                                    if(i71 != null) {
                                        if(i71.a() != 1 || i71.c(0).b == null) {
                                            Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                        }
                                        else {
                                            i71.c(0);
                                            spannableStringBuilder0.setSpan(new E4(6), v1, v2, 33);
                                        }
                                    }
                                }
                                break;
                            }
                            case 3: 
                            case 4: {
                                spannableStringBuilder0.setSpan(new B5(), v1, v2, 33);  // 初始化器: Ljava/lang/Object;-><init>()V
                            }
                        }
                        if(y80.q == 1) {
                            Ja.z(spannableStringBuilder0, new E4(4), v1, v2);
                        }
                        int v4 = y80.j;
                        if(v4 == 1) {
                            Ja.z(spannableStringBuilder0, new AbsoluteSizeSpan(((int)y80.k), true), v1, v2);
                        }
                        else {
                            switch(v4) {
                                case 2: {
                                    Ja.z(spannableStringBuilder0, new RelativeSizeSpan(y80.k), v1, v2);
                                    break;
                                }
                                case 3: {
                                    Ja.z(spannableStringBuilder0, new RelativeSizeSpan(y80.k / 100.0f), v1, v2);
                                }
                            }
                        }
                        if("p".equals(this.a)) {
                            float f = y80.s;
                            if(f != 3.402823E+38f) {
                                e30.q = f * -90.0f / 100.0f;
                            }
                            Layout.Alignment layout$Alignment0 = y80.o;
                            if(layout$Alignment0 != null) {
                                e30.c = layout$Alignment0;
                            }
                            Layout.Alignment layout$Alignment1 = y80.p;
                            if(layout$Alignment1 != null) {
                                e30.d = layout$Alignment1;
                            }
                        }
                    }
                }
            }
            for(int v5 = 0; v5 < this.a(); ++v5) {
                this.c(v5).f(v, map0, hashMap0, s1, treeMap0);
            }
        }
    }

    public final void g(long v, boolean z, String s, TreeMap treeMap0) {
        long v2;
        boolean z2;
        HashMap hashMap0 = this.k;
        hashMap0.clear();
        HashMap hashMap1 = this.l;
        hashMap1.clear();
        String s1 = this.a;
        if(!"metadata".equals(s1)) {
            String s2 = "".equals(this.h) ? s : this.h;
            if(this.c && z) {
                SpannableStringBuilder spannableStringBuilder0 = i7.b(s2, treeMap0);
                this.b.getClass();
                spannableStringBuilder0.append(this.b);
                return;
            }
            if("br".equals(s1) && z) {
                i7.b(s2, treeMap0).append('\n');
                return;
            }
            if(this.i(v)) {
                for(Object object0: treeMap0.entrySet()) {
                    String s3 = (String)((Map.Entry)object0).getKey();
                    CharSequence charSequence0 = ((E3)((Map.Entry)object0).getValue()).a;
                    charSequence0.getClass();
                    hashMap0.put(s3, charSequence0.length());
                }
                boolean z1 = "p".equals(s1);
                for(int v1 = 0; v1 < this.a(); ++v1) {
                    i7 i70 = this.c(v1);
                    z2 = z || z1;
                    v2 = v;
                    i70.g(v2, z2, s2, treeMap0);
                }
                if(z1) {
                    SpannableStringBuilder spannableStringBuilder1 = i7.b(s2, treeMap0);
                    int v3;
                    for(v3 = spannableStringBuilder1.length() - 1; v3 >= 0 && spannableStringBuilder1.charAt(v3) == 0x20; --v3) {
                    }
                    if(v3 >= 0 && spannableStringBuilder1.charAt(v3) != 10) {
                        spannableStringBuilder1.append('\n');
                    }
                }
                for(Object object1: treeMap0.entrySet()) {
                    String s4 = (String)((Map.Entry)object1).getKey();
                    CharSequence charSequence1 = ((E3)((Map.Entry)object1).getValue()).a;
                    charSequence1.getClass();
                    hashMap1.put(s4, charSequence1.length());
                }
            }
        }
    }

    public final void h(TreeSet treeSet0, boolean z) {
        boolean z1 = "p".equals(this.a);
        if(z || z1 || "div".equals(this.a) && this.i != null) {
            long v = this.d;
            if(v != 0x8000000000000001L) {
                treeSet0.add(v);
            }
            long v1 = this.e;
            if(v1 != 0x8000000000000001L) {
                treeSet0.add(v1);
            }
        }
        if(this.m != null) {
            for(int v2 = 0; v2 < this.m.size(); ++v2) {
                ((i7)this.m.get(v2)).h(treeSet0, z || z1);
            }
        }
    }

    // 去混淆评级： 低(40)
    public final boolean i(long v) {
        return Long.compare(this.d, 0x8000000000000001L) == 0 && this.e == 0x8000000000000001L || this.d <= v && this.e == 0x8000000000000001L || this.d == 0x8000000000000001L && v < this.e || this.d <= v && v < this.e;
    }
}

