package i.n.i.b.a.s.e;

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
import android.util.Log;
import com.iloen.melon.utils.a;
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

public abstract class we {
    public static final Pattern a;
    public static final Pattern b;
    public static final Map c;
    public static final Map d;

    static {
        we.a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        we.b = Pattern.compile("(\\S+?):(\\S+)");
        HashMap hashMap0 = new HashMap();
        a.q(0xFF, 0xFF, 0xFF, hashMap0, "white");
        a.q(0, 0xFF, 0, hashMap0, "lime");
        a.q(0, 0xFF, 0xFF, hashMap0, "cyan");
        a.q(0xFF, 0, 0, hashMap0, "red");
        a.q(0xFF, 0xFF, 0, hashMap0, "yellow");
        a.q(0xFF, 0, 0xFF, hashMap0, "magenta");
        a.q(0, 0, 0xFF, hashMap0, "blue");
        a.q(0, 0, 0, hashMap0, "black");
        we.c = Collections.unmodifiableMap(hashMap0);
        HashMap hashMap1 = new HashMap();
        a.q(0xFF, 0xFF, 0xFF, hashMap1, "bg_white");
        a.q(0, 0xFF, 0, hashMap1, "bg_lime");
        a.q(0, 0xFF, 0xFF, hashMap1, "bg_cyan");
        a.q(0xFF, 0, 0, hashMap1, "bg_red");
        a.q(0xFF, 0xFF, 0, hashMap1, "bg_yellow");
        a.q(0xFF, 0, 0xFF, hashMap1, "bg_magenta");
        a.q(0, 0, 0xFF, hashMap1, "bg_blue");
        a.q(0, 0, 0, hashMap1, "bg_black");
        we.d = Collections.unmodifiableMap(hashMap1);
    }

    // This method was un-flattened
    public static SpannedString a(String s, String s1, List list0) {
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
                                Log.w("WebvttCueParser", "ignoring unsupported entity: \'&" + s3 + ";\'");
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
                            M7.u(!s5.isEmpty());
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
                                            te te0 = (te)arrayDeque0.pop();
                                            we.d(s, te0, arrayList0, spannableStringBuilder0, list0);
                                            if(arrayDeque0.isEmpty()) {
                                                arrayList0.clear();
                                            }
                                            else {
                                                arrayList0.add(new se(te0, spannableStringBuilder0.length()));
                                            }
                                            if(te0.a.equals(s6)) {
                                                break;
                                            }
                                        }
                                    }
                                    else if(!z1) {
                                        int v7 = spannableStringBuilder0.length();
                                        String s7 = s4.trim();
                                        M7.u(!s7.isEmpty());
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
                                        arrayDeque0.push(new te(s8, v7, s2, hashSet0));
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
            we.d(s, ((te)arrayDeque0.pop()), arrayList0, spannableStringBuilder0, list0);
        }
        we.d(s, new te("", 0, "", Collections.EMPTY_SET), Collections.EMPTY_LIST, spannableStringBuilder0, list0);
        return SpannedString.valueOf(spannableStringBuilder0);
    }

    public static Yd b(String s, Matcher matcher0, wb wb0, ArrayList arrayList0) {
        ve ve0 = new ve();
        String s1 = null;
        try {
            String s2 = matcher0.group(1);
            s2.getClass();
            ve0.a = f0.b(s2);
            String s3 = matcher0.group(2);
            s3.getClass();
            ve0.b = f0.b(s3);
        }
        catch(NumberFormatException unused_ex) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher0.group());
            return null;
        }
        String s4 = matcher0.group(3);
        s4.getClass();
        we.e(s4, ve0);
        String s5 = matcher0.group(3);
        s5.getClass();
        String s6 = s5.trim();
        if(!s6.isEmpty()) {
            s1 = s6;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        for(String s7 = wb0.q(); !TextUtils.isEmpty(s7); s7 = wb0.q()) {
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append("\n");
            }
            stringBuilder0.append(s7.trim());
        }
        ve0.c = we.a(s, stringBuilder0.toString(), arrayList0);
        ve0.l = s1;
        return new Yd(ve0.a().a(), ve0.a, ve0.b);
    }

    public static ArrayList c(List list0, String s, te te0) {
        int v1;
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            Dd dd0 = (Dd)list0.get(v);
            String s1 = te0.a;
            Set set0 = te0.d;
            String s2 = te0.c;
            if(!dd0.a.isEmpty() || !dd0.b.isEmpty() || !dd0.c.isEmpty() || !dd0.d.isEmpty()) {
                int v2 = Dd.a(Dd.a(Dd.a(0, 0x40000000, dd0.a, s), 2, dd0.b, s1), 4, dd0.d, s2);
                v1 = v2 == -1 || !set0.containsAll(dd0.c) ? 0 : v2 + dd0.c.size() * 4;
            }
            else {
                v1 = TextUtils.isEmpty(s1);
            }
            if(v1 > 0) {
                arrayList0.add(new ue(v1, dd0));
            }
        }
        Collections.sort(arrayList0);
        return arrayList0;
    }

    public static void d(String s, te te0, List list0, SpannableStringBuilder spannableStringBuilder0, List list1) {
        int v = te0.b;
        int v1 = spannableStringBuilder0.length();
        te0.a.getClass();
    alab1:
        switch(te0.a) {
            case "": {
                break;
            }
            case "b": {
                x.t(1, spannableStringBuilder0, v, v1, 33);
                break;
            }
            case "c": {
                for(Object object0: te0.d) {
                    String s1 = (String)object0;
                    Map map0 = we.c;
                    if(map0.containsKey(s1)) {
                        spannableStringBuilder0.setSpan(new ForegroundColorSpan(((int)(((Integer)map0.get(s1))))), v, v1, 33);
                    }
                    else {
                        Map map1 = we.d;
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
                we.g(list1, s, te0);
                ArrayList arrayList0 = new ArrayList(list0.size());
                arrayList0.addAll(list0);
                Collections.sort(arrayList0, se.c);
                int v2 = te0.b;
                int v4 = 0;
                for(int v3 = 0; true; ++v3) {
                    if(v3 >= arrayList0.size()) {
                        break alab1;
                    }
                    if("rt".equals(((se)arrayList0.get(v3)).a.a)) {
                        se se0 = (se)arrayList0.get(v3);
                        we.g(list1, s, se0.a);
                        int v5 = se0.a.b - v4;
                        int v6 = se0.b - v4;
                        CharSequence charSequence0 = spannableStringBuilder0.subSequence(v5, v6);
                        spannableStringBuilder0.delete(v5, v6);
                        charSequence0.toString();
                        spannableStringBuilder0.setSpan(new E4(6), v2, v5, 33);
                        v4 = charSequence0.length() + v4;
                        v2 = v5;
                    }
                }
            }
            case "u": {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
                break;
            }
            case "v": {
                break;
            }
            default: {
                return;
            }
        }
        ArrayList arrayList1 = we.c(list1, s, te0);
        for(int v7 = 0; v7 < arrayList1.size(); ++v7) {
            Dd dd0 = ((ue)arrayList1.get(v7)).b;
            if((dd0.l != -1 || dd0.m != -1 ? (dd0.l == 1 ? 1 : 0) | (dd0.m == 1 ? 2 : 0) : -1) != -1) {
                Ja.z(spannableStringBuilder0, new StyleSpan((dd0.l != -1 || dd0.m != -1 ? (dd0.l == 1 ? 1 : 0) | (dd0.m == 1 ? 2 : 0) : -1)), v, v1);
            }
            if(dd0.j == 1) {
                spannableStringBuilder0.setSpan(new StrikethroughSpan(), v, v1, 33);
            }
            if(dd0.k == 1) {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
            }
            if(dd0.g) {
                Ja.z(spannableStringBuilder0, new ForegroundColorSpan(dd0.f), v, v1);
            }
            if(dd0.i) {
                Ja.z(spannableStringBuilder0, new BackgroundColorSpan(dd0.h), v, v1);
            }
            if(dd0.e != null) {
                Ja.z(spannableStringBuilder0, new TypefaceSpan(dd0.e), v, v1);
            }
            int v8 = dd0.n;
            switch(v8) {
                case 1: {
                    Ja.z(spannableStringBuilder0, new AbsoluteSizeSpan(0, true), v, v1);
                    break;
                }
                case 2: {
                    Ja.z(spannableStringBuilder0, new RelativeSizeSpan(0.0f), v, v1);
                    break;
                }
                default: {
                    if(v8 == 3) {
                        Ja.z(spannableStringBuilder0, new RelativeSizeSpan(0.0f), v, v1);
                    }
                }
            }
            if(dd0.p) {
                spannableStringBuilder0.setSpan(new E4(4), v, v1, 33);
            }
        }
    }

    public static void e(String s, ve ve0) {
        Matcher matcher0 = we.b.matcher(s);
        while(matcher0.find()) {
            int v = -1;
            int v1 = 1;
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
                                v1 = 2;
                                break;
                            }
                            case "end": {
                                v1 = 3;
                                break;
                            }
                            case "left": {
                                v1 = 4;
                                break;
                            }
                            case "right": {
                                v1 = 5;
                                break;
                            }
                            case "start": {
                                break;
                            }
                            default: {
                                Log.w("WebvttCueParser", "Invalid alignment value: " + s2);
                                v1 = 2;
                                break;
                            }
                        }
                        ve0.d = v1;
                    }
                    else if("position".equals(s1)) {
                        int v2 = s2.indexOf(44);
                        if(v2 != -1) {
                            String s3 = s2.substring(v2 + 1);
                            s3.getClass();
                            switch(s3) {
                                case "center": {
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
                                    break;
                                }
                                case "start": {
                                    v1 = 0;
                                    break;
                                }
                                default: {
                                    Log.w("WebvttCueParser", "Invalid anchor value: " + s3);
                                    v1 = 0x80000000;
                                }
                            }
                            ve0.i = v1;
                            s2 = s2.substring(0, v2);
                        }
                        ve0.h = f0.a(s2);
                    }
                    else if("size".equals(s1)) {
                        ve0.j = f0.a(s2);
                    }
                    else if("vertical".equals(s1)) {
                        switch(s2) {
                            case "lr": {
                                v = 1;
                                break;
                            }
                            case "rl": {
                                v = 0;
                            }
                        }
                        if(v != 0) {
                            if(v == 1) {
                                v1 = 2;
                            }
                            else {
                                Log.w("WebvttCueParser", "Invalid \'vertical\' value: " + s2);
                                v1 = 0x80000000;
                            }
                        }
                        ve0.k = v1;
                    }
                    else {
                        Log.w("WebvttCueParser", "Unknown cue setting " + s1 + ":" + s2);
                    }
                    continue;
                }
                we.f(s2, ve0);
            }
            catch(NumberFormatException unused_ex) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher0.group());
            }
        }
    }

    public static void f(String s, ve ve0) {
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
                    Log.w("WebvttCueParser", "Invalid anchor value: " + s1);
                    v1 = 0x80000000;
                }
            }
            ve0.g = v1;
            s = s.substring(0, v);
        }
        if(s.endsWith("%")) {
            ve0.e = f0.a(s);
            ve0.f = 0;
            return;
        }
        ve0.e = (float)Integer.parseInt(s);
        ve0.f = 1;
    }

    public static void g(List list0, String s, te te0) {
        ArrayList arrayList0 = we.c(list0, s, te0);
        for(int v = 0; v < arrayList0.size() && ((ue)arrayList0.get(v)).b.o == -1; ++v) {
        }
    }
}

