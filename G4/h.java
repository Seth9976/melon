package g4;

import U4.x;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.iloen.melon.utils.a;
import d3.f;
import d3.g;
import d3.i;
import e3.p;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class h {
    public static final Pattern a;
    public static final Pattern b;
    public static final Map c;
    public static final Map d;

    static {
        h.a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        h.b = Pattern.compile("(\\S+?):(\\S+)");
        HashMap hashMap0 = new HashMap();
        a.q(0xFF, 0xFF, 0xFF, hashMap0, "white");
        a.q(0, 0xFF, 0, hashMap0, "lime");
        a.q(0, 0xFF, 0xFF, hashMap0, "cyan");
        a.q(0xFF, 0, 0, hashMap0, "red");
        a.q(0xFF, 0xFF, 0, hashMap0, "yellow");
        a.q(0xFF, 0, 0xFF, hashMap0, "magenta");
        a.q(0, 0, 0xFF, hashMap0, "blue");
        a.q(0, 0, 0, hashMap0, "black");
        h.c = Collections.unmodifiableMap(hashMap0);
        HashMap hashMap1 = new HashMap();
        a.q(0xFF, 0xFF, 0xFF, hashMap1, "bg_white");
        a.q(0, 0xFF, 0, hashMap1, "bg_lime");
        a.q(0, 0xFF, 0xFF, hashMap1, "bg_cyan");
        a.q(0xFF, 0, 0, hashMap1, "bg_red");
        a.q(0xFF, 0xFF, 0, hashMap1, "bg_yellow");
        a.q(0xFF, 0, 0xFF, hashMap1, "bg_magenta");
        a.q(0, 0, 0xFF, hashMap1, "bg_blue");
        a.q(0, 0, 0, hashMap1, "bg_black");
        h.d = Collections.unmodifiableMap(hashMap1);
    }

    public static void a(String s, e e0, List list0, SpannableStringBuilder spannableStringBuilder0, List list1) {
        int v = e0.b;
        int v1 = spannableStringBuilder0.length();
        e0.a.getClass();
    alab1:
        switch(e0.a) {
            case "": {
                break;
            }
            case "b": {
                x.t(1, spannableStringBuilder0, v, v1, 33);
                break;
            }
            case "c": {
                for(Object object0: e0.d) {
                    String s1 = (String)object0;
                    Map map0 = h.c;
                    if(map0.containsKey(s1)) {
                        spannableStringBuilder0.setSpan(new ForegroundColorSpan(((int)(((Integer)map0.get(s1))))), v, v1, 33);
                    }
                    else {
                        Map map1 = h.d;
                        if(map1.containsKey(s1)) {
                            spannableStringBuilder0.setSpan(new BackgroundColorSpan(((int)(((Integer)map1.get(s1))))), v, v1, 33);
                        }
                    }
                }
                break;
            }
            case "i": {
                x.t(2, spannableStringBuilder0, v, v1, 33);
                break;
            }
            case "lang": {
                break;
            }
            case "ruby": {
                int v2 = h.c(list1, s, e0);
                ArrayList arrayList0 = new ArrayList(list0.size());
                arrayList0.addAll(list0);
                Collections.sort(arrayList0, d.c);
                int v3 = e0.b;
                int v5 = 0;
                for(int v4 = 0; true; ++v4) {
                    if(v4 >= arrayList0.size()) {
                        break alab1;
                    }
                    if("rt".equals(((d)arrayList0.get(v4)).a.a)) {
                        d d0 = (d)arrayList0.get(v4);
                        int v6 = h.c(list1, s, d0.a);
                        if(v6 == -1) {
                            v6 = v2 == -1 ? 1 : v2;
                        }
                        int v7 = d0.a.b - v5;
                        int v8 = d0.b - v5;
                        CharSequence charSequence0 = spannableStringBuilder0.subSequence(v7, v8);
                        spannableStringBuilder0.delete(v7, v8);
                        spannableStringBuilder0.setSpan(new f(charSequence0.toString(), v6), v3, v7, 33);
                        v5 = charSequence0.length() + v5;
                        v3 = v7;
                    }
                }
            }
            case "u": {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
                break;
            }
            case "v": {
                spannableStringBuilder0.setSpan(new i(e0.c), v, v1, 33);
                break;
            }
            default: {
                return;
            }
        }
        ArrayList arrayList1 = h.b(list1, s, e0);
        for(int v9 = 0; v9 < arrayList1.size(); ++v9) {
            b b0 = ((g4.f)arrayList1.get(v9)).b;
            if((b0.l != -1 || b0.m != -1 ? (b0.m == 1 ? 2 : 0) | (b0.l == 1 ? 1 : 0) : -1) != -1) {
                g.F(spannableStringBuilder0, new StyleSpan((b0.l != -1 || b0.m != -1 ? (b0.l == 1 ? 1 : 0) | (b0.m == 1 ? 2 : 0) : -1)), v, v1);
            }
            if(b0.j == 1) {
                spannableStringBuilder0.setSpan(new StrikethroughSpan(), v, v1, 33);
            }
            if(b0.k == 1) {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
            }
            if(b0.g) {
                g.F(spannableStringBuilder0, new ForegroundColorSpan(b0.f), v, v1);
            }
            if(b0.i) {
                g.F(spannableStringBuilder0, new BackgroundColorSpan(b0.h), v, v1);
            }
            if(b0.e != null) {
                g.F(spannableStringBuilder0, new TypefaceSpan(b0.e), v, v1);
            }
            int v10 = b0.n;
            switch(v10) {
                case 1: {
                    g.F(spannableStringBuilder0, new AbsoluteSizeSpan(((int)b0.o), true), v, v1);
                    break;
                }
                case 2: {
                    g.F(spannableStringBuilder0, new RelativeSizeSpan(b0.o), v, v1);
                    break;
                }
                default: {
                    if(v10 == 3) {
                        g.F(spannableStringBuilder0, new RelativeSizeSpan(b0.o / 100.0f), v, v1);
                    }
                }
            }
            if(b0.q) {
                spannableStringBuilder0.setSpan(new d3.e(), v, v1, 33);  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
    }

    public static ArrayList b(List list0, String s, e e0) {
        int v1;
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            b b0 = (b)list0.get(v);
            String s1 = e0.a;
            Set set0 = e0.d;
            String s2 = e0.c;
            if(!b0.a.isEmpty() || !b0.b.isEmpty() || !b0.c.isEmpty() || !b0.d.isEmpty()) {
                int v2 = b.a(b.a(b.a(0, b0.a, s, 0x40000000), b0.b, s1, 2), b0.d, s2, 4);
                v1 = v2 == -1 || !set0.containsAll(b0.c) ? 0 : v2 + b0.c.size() * 4;
            }
            else {
                v1 = TextUtils.isEmpty(s1);
            }
            if(v1 > 0) {
                arrayList0.add(new g4.f(v1, b0));
            }
        }
        Collections.sort(arrayList0);
        return arrayList0;
    }

    public static int c(List list0, String s, e e0) {
        ArrayList arrayList0 = h.b(list0, s, e0);
        for(int v = 0; v < arrayList0.size(); ++v) {
            int v1 = ((g4.f)arrayList0.get(v)).b.p;
            if(v1 != -1) {
                return v1;
            }
        }
        return -1;
    }

    public static c d(String s, Matcher matcher0, p p0, ArrayList arrayList0) {
        g4.g g0 = new g4.g();
        try {
            String s1 = matcher0.group(1);
            s1.getClass();
            g0.a = g4.i.c(s1);
            String s2 = matcher0.group(2);
            s2.getClass();
            g0.b = g4.i.c(s2);
        }
        catch(NumberFormatException unused_ex) {
            e3.b.D("WebvttCueParser", "Skipping cue with bad header: " + matcher0.group());
            return null;
        }
        String s3 = matcher0.group(3);
        s3.getClass();
        h.e(s3, g0);
        StringBuilder stringBuilder0 = new StringBuilder();
        p0.getClass();
        for(String s4 = p0.h(StandardCharsets.UTF_8); !TextUtils.isEmpty(s4); s4 = p0.h(StandardCharsets.UTF_8)) {
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append("\n");
            }
            stringBuilder0.append(s4.trim());
        }
        g0.c = h.f(s, stringBuilder0.toString(), arrayList0);
        return new c(g0.a().a(), g0.a, g0.b);
    }

    public static void e(String s, g4.g g0) {
        int v2;
        int v1;
        int v3;
        Matcher matcher0 = h.b.matcher(s);
        while(matcher0.find()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            String s2 = matcher0.group(2);
            s2.getClass();
            try {
                if(!"line".equals(s1)) {
                    if("align".equals(s1)) {
                        switch(s2) {
                            case "center": 
                            case "middle": {
                                v3 = 2;
                                break;
                            }
                            case "end": {
                                v3 = 3;
                                break;
                            }
                            case "left": {
                                v3 = 4;
                                break;
                            }
                            case "right": {
                                v3 = 5;
                                break;
                            }
                            case "start": {
                                v3 = 1;
                                break;
                            }
                            default: {
                                e3.b.D("WebvttCueParser", "Invalid alignment value: " + s2);
                                v3 = 2;
                                break;
                            }
                        }
                        g0.d = v3;
                    }
                    else if("position".equals(s1)) {
                        int v = s2.indexOf(44);
                        if(v != -1) {
                            String s3 = s2.substring(v + 1);
                            s3.getClass();
                            switch(s3) {
                                case "center": {
                                    v1 = 1;
                                    break;
                                }
                                case "end": {
                                    v1 = 2;
                                    break;
                                }
                                case "line-left": {
                                    v1 = 0;
                                    break;
                                }
                                case "line-right": {
                                    v1 = 2;
                                    break;
                                }
                                case "middle": {
                                    v1 = 1;
                                    break;
                                }
                                case "start": {
                                    v1 = 0;
                                    break;
                                }
                                default: {
                                    e3.b.D("WebvttCueParser", "Invalid anchor value: " + s3);
                                    v1 = 0x80000000;
                                }
                            }
                            g0.i = v1;
                            s2 = s2.substring(0, v);
                        }
                        g0.h = g4.i.b(s2);
                    }
                    else if("size".equals(s1)) {
                        g0.j = g4.i.b(s2);
                    }
                    else if("vertical".equals(s1)) {
                        if(s2.equals("lr")) {
                            v2 = 2;
                        }
                        else if(s2.equals("rl")) {
                            v2 = 1;
                        }
                        else {
                            e3.b.D("WebvttCueParser", "Invalid \'vertical\' value: " + s2);
                            v2 = 0x80000000;
                        }
                        g0.k = v2;
                    }
                    else {
                        e3.b.D("WebvttCueParser", "Unknown cue setting " + s1 + ":" + s2);
                    }
                    continue;
                }
                h.g(s2, g0);
            }
            catch(NumberFormatException unused_ex) {
                e3.b.D("WebvttCueParser", "Skipping bad cue setting: " + matcher0.group());
            }
        }
    }

    // This method was un-flattened
    public static SpannedString f(String s, String s1, List list0) {
        int v4;
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder();
        ArrayDeque arrayDeque0 = new ArrayDeque();
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        while(true) {
            String s2 = "";
            if(v >= s1.length()) {
                break;
            }
            int v1 = s1.charAt(v);
            switch(v1) {
                case 38: {
                    ++v;
                    int v2 = s1.indexOf(59, v);
                    int v3 = s1.indexOf(0x20, v);
                    if(v2 == -1) {
                        v2 = v3;
                    }
                    else if(v3 != -1) {
                        v2 = Math.min(v2, v3);
                    }
                    if(v2 == -1) {
                        spannableStringBuilder0.append('&');
                    }
                    else {
                        String s3 = s1.substring(v, v2);
                        s3.getClass();
                        switch(s3) {
                            case "amp": {
                                spannableStringBuilder0.append('&');
                                break;
                            }
                            case "gt": {
                                spannableStringBuilder0.append('>');
                                break;
                            }
                            case "lt": {
                                spannableStringBuilder0.append('<');
                                break;
                            }
                            case "nbsp": {
                                spannableStringBuilder0.append(' ');
                                break;
                            }
                            default: {
                                e3.b.D("WebvttCueParser", "ignoring unsupported entity: \'&" + s3 + ";\'");
                            }
                        }
                        if(v2 == v3) {
                            spannableStringBuilder0.append(" ");
                        }
                        v = v2 + 1;
                    }
                    continue;
                }
                case 60: {
                    v4 = v + 1;
                    if(v4 < s1.length()) {
                        boolean z = s1.charAt(v4) == 0x2F;
                        int v5 = s1.indexOf(62, v4);
                        v4 = v5 == -1 ? s1.length() : v5 + 1;
                        int v6 = v4 - 2;
                        boolean z1 = s1.charAt(v6) == 0x2F;
                        if(!z1) {
                            v6 = v4 - 1;
                        }
                        String s4 = s1.substring(v + (z ? 2 : 1), v6);
                        if(!s4.trim().isEmpty()) {
                            String s5 = s4.trim();
                            e3.b.c(!s5.isEmpty());
                            String s6 = s5.split("[ \\.]", 2)[0];
                            s6.getClass();
                            switch(s6) {
                                case "b": 
                                case "c": 
                                case "i": 
                                case "lang": 
                                case "rt": 
                                case "ruby": 
                                case "u": 
                                case "v": {
                                    if(z) {
                                        while(true) {
                                            if(arrayDeque0.isEmpty()) {
                                                break;
                                            }
                                            e e0 = (e)arrayDeque0.pop();
                                            h.a(s, e0, arrayList0, spannableStringBuilder0, list0);
                                            if(arrayDeque0.isEmpty()) {
                                                arrayList0.clear();
                                            }
                                            else {
                                                arrayList0.add(new d(e0, spannableStringBuilder0.length()));
                                            }
                                            if(e0.a.equals(s6)) {
                                                break;
                                            }
                                        }
                                    }
                                    else if(!z1) {
                                        int v7 = spannableStringBuilder0.length();
                                        String s7 = s4.trim();
                                        e3.b.c(!s7.isEmpty());
                                        int v8 = s7.indexOf(" ");
                                        if(v8 != -1) {
                                            s2 = s7.substring(v8).trim();
                                            s7 = s7.substring(0, v8);
                                        }
                                        String[] arr_s = s7.split("\\.", -1);
                                        String s8 = arr_s[0];
                                        HashSet hashSet0 = new HashSet();
                                        for(int v9 = 1; v9 < arr_s.length; ++v9) {
                                            hashSet0.add(arr_s[v9]);
                                        }
                                        arrayDeque0.push(new e(s8, v7, s2, hashSet0));
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
                default: {
                    spannableStringBuilder0.append(((char)v1));
                    ++v;
                    continue;
                }
            }
            v = v4;
        }
        while(!arrayDeque0.isEmpty()) {
            h.a(s, ((e)arrayDeque0.pop()), arrayList0, spannableStringBuilder0, list0);
        }
        h.a(s, new e("", 0, "", Collections.EMPTY_SET), Collections.EMPTY_LIST, spannableStringBuilder0, list0);
        return SpannedString.valueOf(spannableStringBuilder0);
    }

    public static void g(String s, g4.g g0) {
        int v = s.indexOf(44);
        if(v != -1) {
            String s1 = s.substring(v + 1);
            s1.getClass();
            int v1 = 2;
            switch(s1) {
                case "center": 
                case "middle": {
                    v1 = 1;
                    break;
                }
                case "end": {
                    break;
                }
                case "start": {
                    v1 = 0;
                    break;
                }
                default: {
                    e3.b.D("WebvttCueParser", "Invalid anchor value: " + s1);
                    v1 = 0x80000000;
                }
            }
            g0.g = v1;
            s = s.substring(0, v);
        }
        if(s.endsWith("%")) {
            g0.e = g4.i.b(s);
            g0.f = 0;
            return;
        }
        g0.e = (float)Integer.parseInt(s);
        g0.f = 1;
    }
}

