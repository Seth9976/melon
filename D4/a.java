package d4;

import I6.V;
import Y3.k;
import Y3.l;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import d3.b;
import e3.e;
import e3.p;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a implements l {
    public final StringBuilder a;
    public final ArrayList b;
    public final p c;
    public static final Pattern d;
    public static final Pattern e;

    static {
        a.d = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
        a.e = Pattern.compile("\\{\\\\.*?\\}");
    }

    public a() {
        this.a = new StringBuilder();
        this.b = new ArrayList();
        this.c = new p();
    }

    public static b a(Spanned spanned0, String s) {
        float f;
        int v1;
        int v;
        if(s == null) {
            return new b(spanned0, null, null, null, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f);
        }
        switch(s) {
            case "{\an1}": {
                v = 0;
                break;
            }
            case "{\an2}": {
                v = 1;
                break;
            }
            case "{\an3}": {
                v = 2;
                break;
            }
            case "{\an4}": {
                v = 0;
                break;
            }
            case "{\an5}": {
                v = 1;
                break;
            }
            case "{\an6}": {
                v = 2;
                break;
            }
            case "{\an7}": {
                v = 0;
                break;
            }
            case "{\an8}": {
                v = 1;
                break;
            }
            case "{\an9}": {
                v = 2;
                break;
            }
            default: {
                v = 1;
            }
        }
        switch(s) {
            case "{\an1}": {
                v1 = 2;
                break;
            }
            case "{\an2}": {
                v1 = 2;
                break;
            }
            case "{\an3}": {
                v1 = 2;
                break;
            }
            case "{\an4}": 
            case "{\an5}": 
            case "{\an6}": {
                v1 = 1;
                break;
            }
            case "{\an7}": 
            case "{\an8}": 
            case "{\an9}": {
                v1 = 0;
                break;
            }
            default: {
                v1 = 1;
            }
        }
        switch(v) {
            case 0: {
                f = 0.08f;
                break;
            }
            case 1: {
                f = 0.5f;
                break;
            }
            case 2: {
                f = 0.92f;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        switch(v1) {
            case 0: {
                return new b(spanned0, null, null, null, 0.08f, 0, 0, f, v, 0x80000000, -3.402823E+38f, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f);
            }
            case 1: {
                return new b(spanned0, null, null, null, 0.5f, 0, 1, f, v, 0x80000000, -3.402823E+38f, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f);
            }
            case 2: {
                return new b(spanned0, null, null, null, 0.92f, 0, 2, f, v, 0x80000000, -3.402823E+38f, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f);
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    public static long b(Matcher matcher0, int v) {
        String s = matcher0.group(v + 1);
        long v1 = s == null ? 0L : Long.parseLong(s) * 3600000L;
        String s1 = matcher0.group(v + 2);
        s1.getClass();
        long v2 = Long.parseLong(s1);
        String s2 = matcher0.group(v + 3);
        s2.getClass();
        long v3 = Long.parseLong(s2) * 1000L + (v2 * 60000L + v1);
        String s3 = matcher0.group(v + 4);
        if(s3 != null) {
            v3 += Long.parseLong(s3);
        }
        return v3 * 1000L;
    }

    @Override  // Y3.l
    public final void g(byte[] arr_b, int v, int v1, k k0, e e0) {
        String s5;
        long v2 = k0.a;
        p p0 = this.c;
        p0.E(arr_b, v + v1);
        p0.G(v);
        Charset charset0 = p0.C();
        if(charset0 == null) {
            charset0 = StandardCharsets.UTF_8;
        }
        ArrayList arrayList0 = v2 == 0x8000000000000001L || !k0.b ? null : new ArrayList();
        String s;
        while((s = p0.h(charset0)) != null) {
            if(s.length() != 0) {
                try {
                    Integer.parseInt(s);
                }
                catch(NumberFormatException unused_ex) {
                    e3.b.D("SubripParser", "Skipping invalid index: " + s);
                    continue;
                }
                String s1 = p0.h(charset0);
                if(s1 == null) {
                    e3.b.D("SubripParser", "Unexpected end");
                    break;
                }
                Matcher matcher0 = a.d.matcher(s1);
                if(matcher0.matches()) {
                    long v3 = a.b(matcher0, 1);
                    long v4 = a.b(matcher0, 6);
                    StringBuilder stringBuilder0 = this.a;
                    stringBuilder0.setLength(0);
                    ArrayList arrayList1 = this.b;
                    arrayList1.clear();
                    for(String s2 = p0.h(charset0); !TextUtils.isEmpty(s2); s2 = p0.h(charset0)) {
                        if(stringBuilder0.length() > 0) {
                            stringBuilder0.append("<br>");
                        }
                        String s3 = s2.trim();
                        StringBuilder stringBuilder1 = new StringBuilder(s3);
                        Matcher matcher1 = a.e.matcher(s3);
                        for(int v5 = 0; matcher1.find(); v5 += v7) {
                            String s4 = matcher1.group();
                            arrayList1.add(s4);
                            int v6 = matcher1.start();
                            int v7 = s4.length();
                            stringBuilder1.replace(v6 - v5, v6 - v5 + v7, "");
                        }
                        stringBuilder0.append(stringBuilder1.toString());
                    }
                    Spanned spanned0 = Html.fromHtml(stringBuilder0.toString());
                    int v8 = 0;
                    while(true) {
                        s5 = null;
                        if(v8 < arrayList1.size()) {
                            String s6 = (String)arrayList1.get(v8);
                            if(s6.matches("\\{\\\\an[1-9]\\}")) {
                                s5 = s6;
                            }
                            else {
                                ++v8;
                                continue;
                            }
                        }
                        break;
                    }
                    if(v2 == 0x8000000000000001L || v3 >= v2) {
                        e0.accept(new Y3.a(V.t(a.a(spanned0, s5)), v3, v4 - v3));
                    }
                    else {
                        if(arrayList0 == null) {
                            continue;
                        }
                        arrayList0.add(new Y3.a(V.t(a.a(spanned0, s5)), v3, v4 - v3));
                    }
                }
                else {
                    e3.b.D("SubripParser", "Skipping invalid timing: " + s1);
                }
            }
        }
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                e0.accept(((Y3.a)object0));
            }
        }
    }

    @Override  // Y3.l
    public final int j() {
        return 1;
    }
}

