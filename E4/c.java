package e4;

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
import android.util.Pair;
import d3.a;
import d3.g;
import d3.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public final class c {
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    public final f f;
    public final String[] g;
    public final String h;
    public final String i;
    public final c j;
    public final HashMap k;
    public final HashMap l;
    public ArrayList m;

    public c(String s, String s1, long v, long v1, f f0, String[] arr_s, String s2, String s3, c c0) {
        this.a = s;
        this.b = s1;
        this.i = s3;
        this.f = f0;
        this.g = arr_s;
        this.c = s1 != null;
        this.d = v;
        this.e = v1;
        s2.getClass();
        this.h = s2;
        this.j = c0;
        this.k = new HashMap();
        this.l = new HashMap();
    }

    public static c a(String s) {
        return new c(null, s.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), 0x8000000000000001L, 0x8000000000000001L, null, null, "", null, null);
    }

    public final c b(int v) {
        ArrayList arrayList0 = this.m;
        if(arrayList0 == null) {
            throw new IndexOutOfBoundsException();
        }
        return (c)arrayList0.get(v);
    }

    public final int c() {
        return this.m == null ? 0 : this.m.size();
    }

    public final void d(TreeSet treeSet0, boolean z) {
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
                ((c)this.m.get(v2)).d(treeSet0, z || z1);
            }
        }
    }

    public static SpannableStringBuilder e(String s, TreeMap treeMap0) {
        if(!treeMap0.containsKey(s)) {
            a a0 = new a();
            a0.a = new SpannableStringBuilder();
            treeMap0.put(s, a0);
        }
        CharSequence charSequence0 = ((a)treeMap0.get(s)).a;
        charSequence0.getClass();
        return (SpannableStringBuilder)charSequence0;
    }

    // 去混淆评级： 低(40)
    public final boolean f(long v) {
        return Long.compare(this.d, 0x8000000000000001L) == 0 && this.e == 0x8000000000000001L || this.d <= v && this.e == 0x8000000000000001L || this.d == 0x8000000000000001L && v < this.e || this.d <= v && v < this.e;
    }

    public final void g(long v, String s, ArrayList arrayList0) {
        String s1 = this.h;
        if(!"".equals(s1)) {
            s = s1;
        }
        if(this.f(v) && "div".equals(this.a)) {
            String s2 = this.i;
            if(s2 != null) {
                arrayList0.add(new Pair(s, s2));
                return;
            }
        }
        for(int v1 = 0; v1 < this.c(); ++v1) {
            this.b(v1).g(v, s, arrayList0);
        }
    }

    public final void h(long v, Map map0, HashMap hashMap0, String s, TreeMap treeMap0) {
        Iterator iterator1;
        int v10;
        c c1;
        int v5;
        if(this.f(v)) {
            String s1 = "".equals(this.h) ? s : this.h;
            Iterator iterator0 = this.l.entrySet().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                String s2 = (String)((Map.Entry)object0).getKey();
                int v1 = this.k.containsKey(s2) ? ((int)(((Integer)this.k.get(s2)))) : 0;
                int v2 = (int)(((Integer)((Map.Entry)object0).getValue()));
                if(v1 == v2) {
                    iterator1 = iterator0;
                }
                else {
                    a a0 = (a)treeMap0.get(s2);
                    a0.getClass();
                    e e0 = (e)hashMap0.get(s1);
                    e0.getClass();
                    int v3 = e0.j;
                    f f0 = g.W(this.f, this.g, map0);
                    SpannableStringBuilder spannableStringBuilder0 = (SpannableStringBuilder)a0.a;
                    if(spannableStringBuilder0 == null) {
                        spannableStringBuilder0 = new SpannableStringBuilder();
                        a0.a = spannableStringBuilder0;
                    }
                    if(f0 == null) {
                        iterator1 = iterator0;
                    }
                    else {
                        if((f0.h != -1 || f0.i != -1 ? (f0.h == 1 ? 1 : 0) | (f0.i == 1 ? 2 : 0) : -1) != -1) {
                            spannableStringBuilder0.setSpan(new StyleSpan((f0.h != -1 || f0.i != -1 ? (f0.h == 1 ? 1 : 0) | (f0.i == 1 ? 2 : 0) : -1)), v1, v2, 33);
                        }
                        if(f0.f == 1) {
                            spannableStringBuilder0.setSpan(new StrikethroughSpan(), v1, v2, 33);
                        }
                        if(f0.g == 1) {
                            spannableStringBuilder0.setSpan(new UnderlineSpan(), v1, v2, 33);
                        }
                        if(f0.c) {
                            g.F(spannableStringBuilder0, new ForegroundColorSpan(f0.b), v1, v2);
                        }
                        if(f0.e) {
                            g.F(spannableStringBuilder0, new BackgroundColorSpan(f0.d), v1, v2);
                        }
                        if(f0.a != null) {
                            g.F(spannableStringBuilder0, new TypefaceSpan(f0.a), v1, v2);
                        }
                        b b0 = f0.r;
                        if(b0 != null) {
                            int v4 = b0.a;
                            if(v4 == -1) {
                                v4 = v3 == 1 || v3 == 2 ? 3 : 1;
                                v5 = 1;
                            }
                            else {
                                v5 = b0.b;
                            }
                            g.F(spannableStringBuilder0, new h(v4, v5, (b0.c == -2 ? 1 : b0.c)), v1, v2);
                        }
                        int v6 = f0.m;
                        switch(v6) {
                            case 2: {
                                c c0 = this.j;
                                while(true) {
                                    if(c0 != null) {
                                        f f1 = g.W(c0.f, c0.g, map0);
                                        if(f1 != null && f1.m == 1) {
                                            break;
                                        }
                                        else {
                                            c0 = c0.j;
                                            continue;
                                        }
                                    }
                                    c0 = null;
                                    break;
                                }
                                if(c0 != null) {
                                    ArrayDeque arrayDeque0 = new ArrayDeque();
                                    arrayDeque0.push(c0);
                                    while(true) {
                                        c1 = null;
                                        if(!arrayDeque0.isEmpty()) {
                                            c c2 = (c)arrayDeque0.pop();
                                            f f2 = g.W(c2.f, c2.g, map0);
                                            if(f2 == null || f2.m != 3) {
                                                for(int v7 = c2.c() - 1; v7 >= 0; --v7) {
                                                    arrayDeque0.push(c2.b(v7));
                                                }
                                                continue;
                                            }
                                            else {
                                                c1 = c2;
                                            }
                                        }
                                        break;
                                    }
                                    if(c1 != null) {
                                        if(c1.c() != 1 || c1.b(0).b == null) {
                                            e3.b.u("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                        }
                                        else {
                                            String s3 = c1.b(0).b;
                                            f f3 = g.W(c1.f, c1.g, map0);
                                            int v8 = f3 == null ? -1 : f3.n;
                                            if(v8 == -1) {
                                                f f4 = g.W(c0.f, c0.g, map0);
                                                if(f4 != null) {
                                                    v8 = f4.n;
                                                }
                                            }
                                            spannableStringBuilder0.setSpan(new d3.f(s3, v8), v1, v2, 33);
                                        }
                                    }
                                }
                                break;
                            }
                            case 3: {
                                spannableStringBuilder0.setSpan(new e4.a(), v1, v2, 33);  // 初始化器: Ljava/lang/Object;-><init>()V
                                break;
                            }
                            default: {
                                if(v6 == 4) {
                                    spannableStringBuilder0.setSpan(new e4.a(), v1, v2, 33);  // 初始化器: Ljava/lang/Object;-><init>()V
                                }
                            }
                        }
                        if(f0.q == 1) {
                            g.F(spannableStringBuilder0, new d3.e(), v1, v2);  // 初始化器: Ljava/lang/Object;-><init>()V
                        }
                        switch(f0.j) {
                            case 1: {
                                iterator1 = iterator0;
                                g.F(spannableStringBuilder0, new AbsoluteSizeSpan(((int)f0.k), true), v1, v2);
                                break;
                            }
                            case 2: {
                                iterator1 = iterator0;
                                g.F(spannableStringBuilder0, new RelativeSizeSpan(f0.k), v1, v2);
                                break;
                            }
                            case 3: {
                                float f5 = f0.k / 100.0f;
                                RelativeSizeSpan[] arr_relativeSizeSpan = (RelativeSizeSpan[])spannableStringBuilder0.getSpans(v1, v2, RelativeSizeSpan.class);
                                float f6 = f5;
                                for(int v9 = 0; v9 < arr_relativeSizeSpan.length; v9 = v10 + 1) {
                                    RelativeSizeSpan relativeSizeSpan0 = arr_relativeSizeSpan[v9];
                                    if(spannableStringBuilder0.getSpanStart(relativeSizeSpan0) <= v1 && spannableStringBuilder0.getSpanEnd(relativeSizeSpan0) >= v2) {
                                        f6 *= relativeSizeSpan0.getSizeChange();
                                    }
                                    if(spannableStringBuilder0.getSpanStart(relativeSizeSpan0) != v1 || spannableStringBuilder0.getSpanEnd(relativeSizeSpan0) != v2) {
                                        v10 = v9;
                                    }
                                    else {
                                        v10 = v9;
                                        if(spannableStringBuilder0.getSpanFlags(relativeSizeSpan0) == 33) {
                                            spannableStringBuilder0.removeSpan(relativeSizeSpan0);
                                        }
                                    }
                                }
                                iterator1 = iterator0;
                                spannableStringBuilder0.setSpan(new RelativeSizeSpan(f6), v1, v2, 33);
                                break;
                            }
                            default: {
                                iterator1 = iterator0;
                            }
                        }
                        if("p".equals(this.a)) {
                            float f7 = f0.s;
                            if(f7 != 3.402823E+38f) {
                                a0.q = f7 * -90.0f / 100.0f;
                            }
                            Layout.Alignment layout$Alignment0 = f0.o;
                            if(layout$Alignment0 != null) {
                                a0.c = layout$Alignment0;
                            }
                            Layout.Alignment layout$Alignment1 = f0.p;
                            if(layout$Alignment1 != null) {
                                a0.d = layout$Alignment1;
                            }
                        }
                    }
                }
                iterator0 = iterator1;
            }
            for(int v11 = 0; v11 < this.c(); ++v11) {
                this.b(v11).h(v, map0, hashMap0, s1, treeMap0);
            }
        }
    }

    public final void i(long v, boolean z, String s, TreeMap treeMap0) {
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
                SpannableStringBuilder spannableStringBuilder0 = c.e(s2, treeMap0);
                this.b.getClass();
                spannableStringBuilder0.append(this.b);
                return;
            }
            if("br".equals(s1) && z) {
                c.e(s2, treeMap0).append('\n');
                return;
            }
            if(this.f(v)) {
                for(Object object0: treeMap0.entrySet()) {
                    String s3 = (String)((Map.Entry)object0).getKey();
                    CharSequence charSequence0 = ((a)((Map.Entry)object0).getValue()).a;
                    charSequence0.getClass();
                    hashMap0.put(s3, charSequence0.length());
                }
                boolean z1 = "p".equals(s1);
                for(int v1 = 0; v1 < this.c(); ++v1) {
                    c c0 = this.b(v1);
                    z2 = z || z1;
                    v2 = v;
                    c0.i(v2, z2, s2, treeMap0);
                }
                if(z1) {
                    SpannableStringBuilder spannableStringBuilder1 = c.e(s2, treeMap0);
                    int v3;
                    for(v3 = spannableStringBuilder1.length() - 1; v3 >= 0 && spannableStringBuilder1.charAt(v3) == 0x20; --v3) {
                    }
                    if(v3 >= 0 && spannableStringBuilder1.charAt(v3) != 10) {
                        spannableStringBuilder1.append('\n');
                    }
                }
                for(Object object1: treeMap0.entrySet()) {
                    String s4 = (String)((Map.Entry)object1).getKey();
                    CharSequence charSequence1 = ((a)((Map.Entry)object1).getValue()).a;
                    charSequence1.getClass();
                    hashMap1.put(s4, charSequence1.length());
                }
            }
        }
    }
}

