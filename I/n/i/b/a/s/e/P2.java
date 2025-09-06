package i.n.i.b.a.s.e;

import U4.x;
import Ve.b0;
import android.graphics.PointF;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.X0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class p2 extends i4 {
    public final boolean m;
    public final X0 n;
    public LinkedHashMap o;
    public float p;
    public float q;
    public static final Pattern r;

    static {
        p2.r = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    }

    public p2(List list0) {
        this.p = -3.402823E+38f;
        this.q = -3.402823E+38f;
        if(list0 != null && !list0.isEmpty()) {
            this.m = true;
            String s = L7.k(((byte[])list0.get(0)));
            M7.u(s.startsWith("Format:"));
            X0 x00 = X0.a(s);
            x00.getClass();
            this.n = x00;
            this.g(new wb(((byte[])list0.get(1))));
            return;
        }
        this.m = false;
        this.n = null;
    }

    @Override  // i.n.i.b.a.s.e.i4
    public final T4 b(byte[] arr_b, int v, boolean z) {
        float f9;
        float f8;
        float f10;
        int v12;
        Layout.Alignment layout$Alignment0;
        float f6;
        int v9;
        int v8;
        float f5;
        int v7;
        float f4;
        float f2;
        X0 x01;
        boolean z3;
        int v6;
        I3 i30;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        wb wb0 = new wb(arr_b, v);
        boolean z1 = this.m;
        if(!z1) {
            this.g(wb0);
        }
        X0 x00 = z1 ? this.n : null;
        String s;
        while((s = wb0.q()) != null) {
            if(s.startsWith("Format:")) {
                x00 = X0.a(s);
            }
            else {
                if(s.startsWith("Dialogue:")) {
                    if(x00 == null) {
                        Log.w("SsaDecoder", "Skipping dialogue line before complete format: " + s);
                    }
                    else {
                        int v1 = x00.e;
                        M7.u(s.startsWith("Dialogue:"));
                        String[] arr_s = s.substring(9).split(",", v1);
                        if(arr_s.length == v1) {
                            long v2 = p2.f(arr_s[x00.a]);
                            if(Long.compare(v2, 0x8000000000000001L) == 0) {
                                Log.w("SsaDecoder", "Skipping invalid timing: " + s);
                            }
                            else {
                                long v3 = p2.f(arr_s[x00.b]);
                                if(v3 == 0x8000000000000001L) {
                                    Log.w("SsaDecoder", "Skipping invalid timing: " + s);
                                }
                                else {
                                    LinkedHashMap linkedHashMap0 = this.o;
                                    if(linkedHashMap0 == null) {
                                        i30 = null;
                                    }
                                    else {
                                        int v4 = x00.c;
                                        if(v4 != -1) {
                                            i30 = (I3)linkedHashMap0.get(arr_s[v4].trim());
                                        }
                                    }
                                    String s1 = arr_s[x00.d];
                                    Matcher matcher0 = H3.a.matcher(s1);
                                    int v5 = -1;
                                    PointF pointF0 = null;
                                    while(matcher0.find()) {
                                        String s2 = matcher0.group(1);
                                        s2.getClass();
                                        try {
                                            PointF pointF1 = H3.a(s2);
                                            if(pointF1 != null) {
                                                pointF0 = pointF1;
                                            }
                                        }
                                        catch(RuntimeException unused_ex) {
                                        }
                                        try {
                                            Matcher matcher1 = H3.d.matcher(s2);
                                            if(matcher1.find()) {
                                                String s3 = matcher1.group(1);
                                                s3.getClass();
                                                v6 = I3.a(s3);
                                            }
                                            else {
                                                v6 = -1;
                                            }
                                            if(v6 != -1) {
                                                v5 = v6;
                                            }
                                        }
                                        catch(RuntimeException unused_ex) {
                                        }
                                    }
                                    String s4 = H3.a.matcher(s1).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = this.p;
                                    float f1 = this.q;
                                    SpannableString spannableString0 = new SpannableString(s4);
                                    if(i30 == null) {
                                        x01 = x00;
                                        f2 = f;
                                        f6 = -3.402823E+38f;
                                        v9 = 0x80000000;
                                    }
                                    else {
                                        boolean z2 = i30.f;
                                        Integer integer0 = i30.c;
                                        if(integer0 == null) {
                                            z3 = z2;
                                            x01 = x00;
                                            f2 = f;
                                        }
                                        else {
                                            z3 = z2;
                                            x01 = x00;
                                            f2 = f;
                                            spannableString0.setSpan(new ForegroundColorSpan(((int)integer0)), 0, spannableString0.length(), 33);
                                        }
                                        float f3 = i30.d;
                                        if(f3 == -3.402823E+38f || f1 == -3.402823E+38f) {
                                            f4 = -3.402823E+38f;
                                            v7 = 0x80000000;
                                        }
                                        else {
                                            f4 = f3 / f1;
                                            v7 = 1;
                                        }
                                        boolean z4 = i30.e;
                                        if(!z4 || !z3) {
                                            f5 = f4;
                                            v8 = v7;
                                            if(z4) {
                                                spannableString0.setSpan(new StyleSpan(1), 0, spannableString0.length(), 33);
                                            }
                                            else if(z3) {
                                                spannableString0.setSpan(new StyleSpan(2), 0, spannableString0.length(), 33);
                                            }
                                        }
                                        else {
                                            f5 = f4;
                                            v8 = v7;
                                            spannableString0.setSpan(new StyleSpan(3), 0, spannableString0.length(), 33);
                                        }
                                        if(i30.g) {
                                            spannableString0.setSpan(new UnderlineSpan(), 0, spannableString0.length(), 33);
                                        }
                                        if(i30.h) {
                                            spannableString0.setSpan(new StrikethroughSpan(), 0, spannableString0.length(), 33);
                                        }
                                        v9 = v8;
                                        f6 = f5;
                                    }
                                    int v10 = -1;
                                    if(v5 != -1) {
                                        v10 = v5;
                                    }
                                    else if(i30 != null) {
                                        v10 = i30.b;
                                    }
                                    switch(v10) {
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
                                            x.u(v10, "Unknown alignment: ", "SsaDecoder");
                                            layout$Alignment0 = null;
                                        }
                                    }
                                    int v11 = 0x80000000;
                                    switch(v10) {
                                        case -1: {
                                            v12 = 0x80000000;
                                            break;
                                        }
                                        case 1: 
                                        case 4: 
                                        case 7: {
                                            v12 = 0;
                                            break;
                                        }
                                        case 2: 
                                        case 5: 
                                        case 8: {
                                            v12 = 1;
                                            break;
                                        }
                                        case 3: 
                                        case 6: 
                                        case 9: {
                                            v12 = 2;
                                            break;
                                        }
                                        default: {
                                            x.u(v10, "Unknown alignment: ", "SsaDecoder");
                                            v12 = 0x80000000;
                                        }
                                    }
                                    switch(v10) {
                                        case -1: {
                                            break;
                                        }
                                        case 1: 
                                        case 2: 
                                        case 3: {
                                            v11 = 2;
                                            break;
                                        }
                                        case 4: 
                                        case 5: 
                                        case 6: {
                                            v11 = 1;
                                            break;
                                        }
                                        case 7: 
                                        case 8: 
                                        case 9: {
                                            v11 = 0;
                                            break;
                                        }
                                        default: {
                                            x.u(v10, "Unknown alignment: ", "SsaDecoder");
                                        }
                                    }
                                    float f7 = 0.05f;
                                    if(pointF0 == null || f1 == -3.402823E+38f || f2 == -3.402823E+38f) {
                                        if(v12 == 0) {
                                            f10 = 0.05f;
                                        }
                                        else {
                                            switch(v12) {
                                                case 1: {
                                                    f10 = 0.5f;
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
                                        }
                                        switch(v11) {
                                            case 0: {
                                                break;
                                            }
                                            case 1: {
                                                f7 = 0.5f;
                                                break;
                                            }
                                            case 2: {
                                                f7 = 0.95f;
                                                break;
                                            }
                                            default: {
                                                f7 = -3.402823E+38f;
                                            }
                                        }
                                        f9 = f7;
                                        f8 = f10;
                                    }
                                    else {
                                        f8 = pointF0.x / f2;
                                        f9 = pointF0.y / f1;
                                    }
                                    F3 f30 = new F3(spannableString0, layout$Alignment0, null, null, f9, 0, v11, f8, v12, v9, f6, -3.402823E+38f, -3.402823E+38f, false, 0xFF000000, 0x80000000, 0.0f, null, null);
                                    int v13 = p2.e(v2, arrayList1, arrayList0);
                                    int v14 = p2.e(v3, arrayList1, arrayList0);
                                    while(v13 < v14) {
                                        ((List)arrayList0.get(v13)).add(f30);
                                        ++v13;
                                    }
                                    goto label_173;
                                }
                            }
                        }
                        else {
                            Log.w("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + s);
                        }
                    }
                }
                x01 = x00;
            label_173:
                x00 = x01;
            }
        }
        return new b0(arrayList0, arrayList1);
    }

    public static int e(long v, ArrayList arrayList0, ArrayList arrayList1) {
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

    public static long f(String s) {
        Matcher matcher0 = p2.r.matcher(s.trim());
        if(!matcher0.matches()) {
            return 0x8000000000000001L;
        }
        long v = Long.parseLong(matcher0.group(1));
        long v1 = Long.parseLong(matcher0.group(2));
        long v2 = Long.parseLong(matcher0.group(3));
        return Long.parseLong(matcher0.group(4)) * 10000L + (v2 * 1000000L + (v1 * 60000000L + v * 3600000000L));
    }

    // This method was un-flattened
    public final void g(wb wb0) {
        I3 i30;
        float f1;
        float f;
        int v7;
        int v6;
        int v5;
        int v4;
        int v3;
        int v2;
        int v1;
        int v;
        String[] arr_s1;
        String s2;
        G3 g30;
        String s1;
    alab1:
        while(true) {
            do {
            label_0:
                String s = wb0.q();
                if(s == null) {
                    break alab1;
                }
                if(!"[Script Info]".equalsIgnoreCase(s)) {
                    goto label_14;
                }
            label_3:
                s1 = wb0.q();
            }
            while(s1 == null || wb0.d() != 0 && (wb0.a[wb0.b] & 0xFF) == 91);
            String[] arr_s = s1.split(":");
            if(arr_s.length != 2) {
                goto label_3;
            }
            switch(M7.j(arr_s[0].trim())) {
                case "playresx": {
                    try {
                        this.p = Float.parseFloat(arr_s[1].trim());
                        break;
                    }
                    catch(NumberFormatException unused_ex) {
                    }
                    break;
                }
                case "playresy": {
                    this.q = Float.parseFloat(arr_s[1].trim());
                    break;
                }
            }
            goto label_3;
        label_14:
            if("[V4+ Styles]".equalsIgnoreCase(s)) {
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                do {
                    g30 = null;
                label_17:
                    s2 = wb0.q();
                    if(s2 == null || wb0.d() != 0 && (wb0.a[wb0.b] & 0xFF) == 91) {
                        this.o = linkedHashMap0;
                        goto label_0;
                    }
                    if(!s2.startsWith("Format:")) {
                        goto label_55;
                    }
                    arr_s1 = TextUtils.split(s2.substring(7), ",");
                    v = -1;
                    v1 = -1;
                    v2 = -1;
                    v3 = -1;
                    v4 = -1;
                    v5 = -1;
                    v6 = -1;
                    v7 = -1;
                    for(int v8 = 0; v8 < arr_s1.length; ++v8) {
                        String s3 = M7.j(arr_s1[v8].trim());
                        s3.getClass();
                        switch(s3) {
                            case "alignment": {
                                v1 = v8;
                                break;
                            }
                            case "bold": {
                                v4 = v8;
                                break;
                            }
                            case "fontsize": {
                                v3 = v8;
                                break;
                            }
                            case "italic": {
                                v5 = v8;
                                break;
                            }
                            case "name": {
                                v = v8;
                                break;
                            }
                            case "primarycolour": {
                                v2 = v8;
                                break;
                            }
                            case "strikeout": {
                                v7 = v8;
                                break;
                            }
                            case "underline": {
                                v6 = v8;
                            }
                        }
                    }
                }
                while(v == -1);
                g30 = new G3(v, v1, v2, v3, v4, v5, v6, v7, arr_s1.length);
                goto label_17;
            label_55:
                if(!s2.startsWith("Style:")) {
                    goto label_17;
                }
                if(g30 == null) {
                    Log.w("SsaDecoder", "Skipping \'Style:\' line before \'Format:\' line: " + s2);
                }
                else {
                    M7.u(s2.startsWith("Style:"));
                    String[] arr_s2 = TextUtils.split(s2.substring(6), ",");
                    int v9 = g30.i;
                    if(arr_s2.length == v9) {
                        try {
                            String s4 = arr_s2[g30.a].trim();
                            int v10 = g30.b == -1 ? -1 : I3.a(arr_s2[g30.b].trim());
                            Integer integer0 = g30.c == -1 ? null : I3.c(arr_s2[g30.c].trim());
                            int v11 = g30.d;
                            if(v11 == -1) {
                                f = -3.402823E+38f;
                            }
                            else {
                                String s5 = arr_s2[v11].trim();
                                try {
                                    f1 = Float.parseFloat(s5);
                                }
                                catch(NumberFormatException numberFormatException0) {
                                    M7.M(numberFormatException0, "SsaStyle", "Failed to parse font size: \'" + s5 + "\'");
                                    f1 = -3.402823E+38f;
                                }
                                f = f1;
                            }
                            i30 = new I3(s4, v10, integer0, f, (g30.e == -1 ? false : I3.b(arr_s2[g30.e].trim())), (g30.f == -1 ? false : I3.b(arr_s2[g30.f].trim())), (g30.g == -1 ? false : I3.b(arr_s2[g30.g].trim())), (g30.h == -1 ? false : I3.b(arr_s2[g30.h].trim())));
                            goto label_87;
                        }
                        catch(RuntimeException runtimeException0) {
                        }
                        M7.M(runtimeException0, "SsaStyle", "Skipping malformed \'Style:\' line: \'" + s2 + "\'");
                    label_86:
                        i30 = null;
                    }
                    else {
                        StringBuilder stringBuilder0 = o.t(v9, arr_s2.length, "Skipping malformed \'Style:\' line (expected ", " values, found ", "): \'");
                        stringBuilder0.append(s2);
                        stringBuilder0.append("\'");
                        Log.w("SsaStyle", stringBuilder0.toString());
                        goto label_86;
                    }
                label_87:
                    if(i30 == null) {
                        goto label_17;
                    }
                    linkedHashMap0.put(i30.a, i30);
                }
                goto label_17;
            }
            if("[V4 Styles]".equalsIgnoreCase(s)) {
                Log.i("SsaDecoder", "[V4 Styles] are not supported");
                goto label_0;
            }
            if(!"[Events]".equalsIgnoreCase(s)) {
                goto label_0;
            }
            break;
        }
    }
}

