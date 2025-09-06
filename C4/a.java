package c4;

import Y3.k;
import Y3.l;
import android.graphics.PointF;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.X0;
import e3.b;
import e3.e;
import e3.p;
import e3.x;
import h7.u0;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a implements l {
    public final boolean a;
    public final X0 b;
    public final p c;
    public LinkedHashMap d;
    public float e;
    public float f;
    public static final Pattern g;

    static {
        a.g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    }

    public a(List list0) {
        this.e = -3.402823E+38f;
        this.f = -3.402823E+38f;
        this.c = new p();
        if(list0 != null && !list0.isEmpty()) {
            this.a = true;
            String s = x.m(((byte[])list0.get(0)));
            b.c(s.startsWith("Format:"));
            X0 x00 = X0.c(s);
            x00.getClass();
            this.b = x00;
            this.b(new p(((byte[])list0.get(1))), StandardCharsets.UTF_8);
            return;
        }
        this.a = false;
        this.b = null;
    }

    public static int a(long v, ArrayList arrayList0, ArrayList arrayList1) {
        int v2;
        for(int v1 = arrayList0.size() - 1; true; --v1) {
            v2 = 0;
            if(v1 < 0) {
                break;
            }
            if(((long)(((Long)arrayList0.get(v1)))) == v) {
                return v1;
            }
            if(((long)(((Long)arrayList0.get(v1)))) < v) {
                v2 = v1 + 1;
                break;
            }
        }
        arrayList0.add(v2, v);
        arrayList1.add(v2, (v2 == 0 ? new ArrayList() : new ArrayList(((Collection)arrayList1.get(v2 - 1)))));
        return v2;
    }

    // This method was un-flattened
    public final void b(p p0, Charset charset0) {
        d d0;
        int v11;
        int v10;
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        int v4;
        int v3;
        int v2;
        String[] arr_s1;
        String s3;
        int v;
        c4.b b0;
        String s1;
    alab1:
        while(true) {
            do {
            label_0:
                String s = p0.h(charset0);
                if(s == null) {
                    break alab1;
                }
                if(!"[Script Info]".equalsIgnoreCase(s)) {
                    goto label_15;
                }
            label_3:
                s1 = p0.h(charset0);
            }
            while(s1 == null || p0.a() != 0 && p0.c(charset0) == 91);
            String[] arr_s = s1.split(":");
            if(arr_s.length != 2) {
                goto label_3;
            }
            String s2 = u0.U(arr_s[0].trim());
            s2.getClass();
            if(s2.equals("playresx")) {
            }
            else if(s2.equals("playresy")) {
                this.f = Float.parseFloat(arr_s[1].trim());
                goto label_3;
            }
            else {
                goto label_3;
            }
            this.e = Float.parseFloat(arr_s[1].trim());
            goto label_3;
        label_15:
            if("[V4+ Styles]".equalsIgnoreCase(s)) {
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                do {
                    b0 = null;
                label_18:
                    v = -1;
                    s3 = p0.h(charset0);
                    if(s3 == null || p0.a() != 0 && p0.c(charset0) == 91) {
                        this.d = linkedHashMap0;
                        goto label_0;
                    }
                    if(!s3.startsWith("Format:")) {
                        goto label_63;
                    }
                    arr_s1 = TextUtils.split(s3.substring(7), ",");
                    v2 = -1;
                    v3 = -1;
                    v4 = -1;
                    v5 = -1;
                    v6 = -1;
                    v7 = -1;
                    v8 = -1;
                    v9 = -1;
                    v10 = -1;
                    v11 = -1;
                    for(int v1 = 0; v1 < arr_s1.length; ++v1) {
                        String s4 = u0.U(arr_s1[v1].trim());
                        s4.getClass();
                        switch(s4) {
                            case "alignment": {
                                v3 = v1;
                                break;
                            }
                            case "bold": {
                                v7 = v1;
                                break;
                            }
                            case "borderstyle": {
                                v11 = v1;
                                break;
                            }
                            case "fontsize": {
                                v6 = v1;
                                break;
                            }
                            case "italic": {
                                v8 = v1;
                                break;
                            }
                            case "name": {
                                v2 = v1;
                                break;
                            }
                            case "outlinecolour": {
                                v5 = v1;
                                break;
                            }
                            case "primarycolour": {
                                v4 = v1;
                                break;
                            }
                            case "strikeout": {
                                v10 = v1;
                                break;
                            }
                            case "underline": {
                                v9 = v1;
                            }
                        }
                    }
                }
                while(v2 == -1);
                b0 = new c4.b(v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, arr_s1.length);
                goto label_18;
            label_63:
                if(!s3.startsWith("Style:")) {
                    goto label_18;
                }
                if(b0 == null) {
                    b.D("SsaParser", "Skipping \'Style:\' line before \'Format:\' line: " + s3);
                }
                else {
                    b.c(s3.startsWith("Style:"));
                    String[] arr_s2 = TextUtils.split(s3.substring(6), ",");
                    int v12 = b0.k;
                    if(arr_s2.length == v12) {
                        try {
                            String s5 = arr_s2[b0.a].trim();
                            int v13 = b0.b == -1 ? -1 : d.a(arr_s2[b0.b].trim());
                            Integer integer0 = b0.c == -1 ? null : d.c(arr_s2[b0.c].trim());
                            Integer integer1 = b0.d == -1 ? null : d.c(arr_s2[b0.d].trim());
                            int v14 = b0.e;
                            float f = -3.402823E+38f;
                            if(v14 != -1) {
                                String s6 = arr_s2[v14].trim();
                                try {
                                    f = Float.parseFloat(s6);
                                }
                                catch(NumberFormatException numberFormatException0) {
                                    b.E("SsaStyle", "Failed to parse font size: \'" + s6 + "\'", numberFormatException0);
                                }
                            }
                            boolean z = b0.f != -1 && d.b(arr_s2[b0.f].trim());
                            boolean z1 = b0.g != -1 && d.b(arr_s2[b0.g].trim());
                            boolean z2 = b0.h != -1 && d.b(arr_s2[b0.h].trim());
                            boolean z3 = b0.i != -1 && d.b(arr_s2[b0.i].trim());
                            int v15 = b0.j;
                            if(v15 != -1) {
                                String s7 = arr_s2[v15].trim();
                                try {
                                    int v16 = Integer.parseInt(s7.trim());
                                    if(v16 == 1 || v16 == 3) {
                                        v = v16;
                                        d0 = new d(s5, v13, integer0, integer1, f, z, z1, z2, z3, v);
                                        goto label_105;
                                    }
                                    goto label_99;
                                }
                                catch(NumberFormatException unused_ex) {
                                label_99:
                                    b.D("SsaStyle", "Ignoring unknown BorderStyle: " + s7);
                                }
                            }
                            d0 = new d(s5, v13, integer0, integer1, f, z, z1, z2, z3, v);
                            goto label_105;
                        }
                        catch(RuntimeException runtimeException0) {
                        }
                        b.E("SsaStyle", "Skipping malformed \'Style:\' line: \'" + s3 + "\'", runtimeException0);
                    label_104:
                        d0 = null;
                    }
                    else {
                        StringBuilder stringBuilder0 = o.t(v12, arr_s2.length, "Skipping malformed \'Style:\' line (expected ", " values, found ", "): \'");
                        stringBuilder0.append(s3);
                        stringBuilder0.append("\'");
                        b.D("SsaStyle", stringBuilder0.toString());
                        goto label_104;
                    }
                label_105:
                    if(d0 == null) {
                        goto label_18;
                    }
                    linkedHashMap0.put(d0.a, d0);
                }
                goto label_18;
            }
            if("[V4 Styles]".equalsIgnoreCase(s)) {
                b.u("SsaParser", "[V4 Styles] are not supported");
                goto label_0;
            }
            if(!"[Events]".equalsIgnoreCase(s)) {
                goto label_0;
            }
            break;
        }
    }

    public static long c(String s) {
        Matcher matcher0 = a.g.matcher(s.trim());
        if(!matcher0.matches()) {
            return 0x8000000000000001L;
        }
        long v = Long.parseLong(matcher0.group(1));
        long v1 = Long.parseLong(matcher0.group(2));
        long v2 = Long.parseLong(matcher0.group(3));
        return Long.parseLong(matcher0.group(4)) * 10000L + (v2 * 1000000L + (v1 * 60000000L + v * 3600000000L));
    }

    @Override  // Y3.l
    public final void g(byte[] arr_b, int v, int v1, k k0, e e0) {
        float f9;
        float f8;
        float f11;
        PointF pointF2;
        Layout.Alignment layout$Alignment0;
        int v13;
        float f6;
        int v12;
        int v11;
        int v10;
        float f5;
        int v9;
        float f4;
        float f2;
        boolean z2;
        X0 x01;
        int v8;
        d d0;
        Charset charset1;
        long v2 = k0.a;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        p p0 = this.c;
        p0.E(arr_b, v + v1);
        p0.G(v);
        Charset charset0 = p0.C();
        if(charset0 == null) {
            charset0 = StandardCharsets.UTF_8;
        }
        boolean z = this.a;
        if(!z) {
            this.b(p0, charset0);
        }
        X0 x00 = z ? this.b : null;
        String s;
        while((s = p0.h(charset0)) != null) {
            if(s.startsWith("Format:")) {
                x00 = X0.c(s);
            }
            else {
                if(s.startsWith("Dialogue:")) {
                    if(x00 == null) {
                        b.D("SsaParser", "Skipping dialogue line before complete format: " + s);
                    }
                    else {
                        int v3 = x00.e;
                        b.c(s.startsWith("Dialogue:"));
                        String[] arr_s = s.substring(9).split(",", v3);
                        if(arr_s.length == v3) {
                            long v4 = a.c(arr_s[x00.a]);
                            charset1 = charset0;
                            if(Long.compare(v4, 0x8000000000000001L) == 0) {
                                b.D("SsaParser", "Skipping invalid timing: " + s);
                                goto label_185;
                            }
                            else {
                                long v5 = a.c(arr_s[x00.b]);
                                if(v5 == 0x8000000000000001L) {
                                    b.D("SsaParser", "Skipping invalid timing: " + s);
                                    goto label_185;
                                }
                                else {
                                    LinkedHashMap linkedHashMap0 = this.d;
                                    if(linkedHashMap0 == null) {
                                        d0 = null;
                                    }
                                    else {
                                        int v6 = x00.c;
                                        if(v6 != -1) {
                                            d0 = (d)linkedHashMap0.get(arr_s[v6].trim());
                                        }
                                    }
                                    String s1 = arr_s[x00.d];
                                    Matcher matcher0 = c.a.matcher(s1);
                                    int v7 = -1;
                                    PointF pointF0 = null;
                                    while(matcher0.find()) {
                                        String s2 = matcher0.group(1);
                                        s2.getClass();
                                        try {
                                            PointF pointF1 = c.a(s2);
                                            if(pointF1 != null) {
                                                pointF0 = pointF1;
                                            }
                                        }
                                        catch(RuntimeException unused_ex) {
                                        }
                                        try {
                                            Matcher matcher1 = c.d.matcher(s2);
                                            if(matcher1.find()) {
                                                String s3 = matcher1.group(1);
                                                s3.getClass();
                                                v8 = d.a(s3);
                                            }
                                            else {
                                                v8 = -1;
                                            }
                                            if(v8 != -1) {
                                                v7 = v8;
                                            }
                                        }
                                        catch(RuntimeException unused_ex) {
                                        }
                                    }
                                    x01 = x00;
                                    String s4 = c.a.matcher(s1).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = this.e;
                                    float f1 = this.f;
                                    SpannableString spannableString0 = new SpannableString(s4);
                                    if(d0 == null) {
                                        f2 = f;
                                        v11 = 0;
                                        v12 = v7;
                                        f6 = -3.402823E+38f;
                                        v13 = 0x80000000;
                                    }
                                    else {
                                        boolean z1 = d0.g;
                                        Integer integer0 = d0.d;
                                        Integer integer1 = d0.c;
                                        if(integer1 == null) {
                                            z2 = z1;
                                            f2 = f;
                                        }
                                        else {
                                            z2 = z1;
                                            f2 = f;
                                            spannableString0.setSpan(new ForegroundColorSpan(((int)integer1)), 0, spannableString0.length(), 33);
                                        }
                                        if(d0.j == 3 && integer0 != null) {
                                            spannableString0.setSpan(new BackgroundColorSpan(((int)integer0)), 0, spannableString0.length(), 33);
                                        }
                                        float f3 = d0.e;
                                        if(f3 == -3.402823E+38f || f1 == -3.402823E+38f) {
                                            f4 = -3.402823E+38f;
                                            v9 = 0x80000000;
                                        }
                                        else {
                                            f4 = f3 / f1;
                                            v9 = 1;
                                        }
                                        boolean z3 = d0.f;
                                        if(!z3 || !z2) {
                                            f5 = f4;
                                            v10 = v9;
                                            v11 = 0;
                                            if(z3) {
                                                spannableString0.setSpan(new StyleSpan(1), 0, spannableString0.length(), 33);
                                            }
                                            else if(z2) {
                                                spannableString0.setSpan(new StyleSpan(2), 0, spannableString0.length(), 33);
                                            }
                                        }
                                        else {
                                            f5 = f4;
                                            v10 = v9;
                                            v11 = 0;
                                            spannableString0.setSpan(new StyleSpan(3), 0, spannableString0.length(), 33);
                                        }
                                        if(d0.h) {
                                            spannableString0.setSpan(new UnderlineSpan(), 0, spannableString0.length(), 33);
                                        }
                                        if(d0.i) {
                                            spannableString0.setSpan(new StrikethroughSpan(), 0, spannableString0.length(), 33);
                                        }
                                        v12 = v7;
                                        f6 = f5;
                                        v13 = v10;
                                    }
                                    if(v12 == -1) {
                                        v12 = d0 == null ? -1 : d0.b;
                                    }
                                    switch(v12) {
                                        case -1: {
                                            layout$Alignment0 = null;
                                            break;
                                        }
                                        case 1: 
                                        case 4: 
                                        case 7: {
                                            layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        }
                                        case 2: 
                                        case 5: 
                                        case 8: {
                                            layout$Alignment0 = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        }
                                        case 3: 
                                        case 6: 
                                        case 9: {
                                            layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                        }
                                        default: {
                                            com.iloen.melon.utils.a.r(v12, "Unknown alignment: ", "SsaParser");
                                            layout$Alignment0 = null;
                                        }
                                    }
                                    int v14 = 0x80000000;
                                    switch(v12) {
                                        case -1: {
                                            v11 = 0x80000000;
                                            break;
                                        }
                                        case 1: 
                                        case 4: 
                                        case 7: {
                                            break;
                                        }
                                        case 2: 
                                        case 5: 
                                        case 8: {
                                            v11 = 1;
                                            break;
                                        }
                                        case 3: 
                                        case 6: 
                                        case 9: {
                                            v11 = 2;
                                            break;
                                        }
                                        default: {
                                            com.iloen.melon.utils.a.r(v12, "Unknown alignment: ", "SsaParser");
                                            v11 = 0x80000000;
                                        }
                                    }
                                    switch(v12) {
                                        case -1: {
                                            pointF2 = pointF0;
                                            break;
                                        }
                                        case 1: 
                                        case 2: 
                                        case 3: {
                                            pointF2 = pointF0;
                                            v14 = 2;
                                            break;
                                        }
                                        case 4: 
                                        case 5: 
                                        case 6: {
                                            pointF2 = pointF0;
                                            v14 = 1;
                                            break;
                                        }
                                        case 7: 
                                        case 8: 
                                        case 9: {
                                            pointF2 = pointF0;
                                            v14 = 0;
                                            break;
                                        }
                                        default: {
                                            com.iloen.melon.utils.a.r(v12, "Unknown alignment: ", "SsaParser");
                                            pointF2 = pointF0;
                                        }
                                    }
                                    if(pointF2 == null || f1 == -3.402823E+38f || f2 == -3.402823E+38f) {
                                        float f10 = 0.5f;
                                        switch(v11) {
                                            case 0: {
                                                f11 = 0.05f;
                                                break;
                                            }
                                            case 1: {
                                                f11 = 0.5f;
                                                break;
                                            }
                                            case 2: {
                                                f11 = 0.95f;
                                                break;
                                            }
                                            default: {
                                                f11 = -3.402823E+38f;
                                            }
                                        }
                                        switch(v14) {
                                            case 0: {
                                                f10 = 0.05f;
                                                break;
                                            }
                                            case 1: {
                                                break;
                                            }
                                            case 2: {
                                                f10 = 0.95f;
                                                break;
                                            }
                                            default: {
                                                f10 = -3.402823E+38f;
                                            }
                                        }
                                        f8 = f10;
                                        f9 = f11;
                                    }
                                    else {
                                        float f7 = pointF2.x / f2;
                                        f8 = pointF2.y / f1;
                                        f9 = f7;
                                    }
                                    d3.b b0 = new d3.b(spannableString0, layout$Alignment0, null, null, f8, 0, v14, f9, v11, v13, f6, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f);
                                    int v15 = a.a(v4, arrayList1, arrayList0);
                                    int v16 = a.a(v5, arrayList1, arrayList0);
                                    while(v15 < v16) {
                                        ((List)arrayList0.get(v15)).add(b0);
                                        ++v15;
                                    }
                                    goto label_186;
                                }
                            }
                        }
                        else {
                            b.D("SsaParser", "Skipping dialogue line with fewer columns than format: " + s);
                        }
                    }
                }
                charset1 = charset0;
            label_185:
                x01 = x00;
            label_186:
                charset0 = charset1;
                x00 = x01;
            }
        }
        ArrayList arrayList2 = v2 == 0x8000000000000001L || !k0.b ? null : new ArrayList();
        for(int v17 = 0; v17 < arrayList0.size(); ++v17) {
            List list0 = (List)arrayList0.get(v17);
            if(!list0.isEmpty() || v17 == 0) {
                if(v17 == arrayList0.size() - 1) {
                    throw new IllegalStateException();
                }
                long v18 = (long)(((Long)arrayList1.get(v17)));
                long v19 = ((long)(((Long)arrayList1.get(v17 + 1)))) - ((long)(((Long)arrayList1.get(v17))));
                if(v2 == 0x8000000000000001L || v18 >= v2) {
                    e0.accept(new Y3.a(list0, v18, v19));
                }
                else if(arrayList2 != null) {
                    arrayList2.add(new Y3.a(list0, v18, v19));
                }
            }
        }
        if(arrayList2 != null) {
            for(Object object0: arrayList2) {
                e0.accept(((Y3.a)object0));
            }
        }
    }

    @Override  // Y3.l
    public final int j() {
        return 1;
    }
}

