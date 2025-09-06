package e4;

import H8.i;
import I6.A0;
import I6.E0;
import I6.b0;
import I6.v0;
import I6.w;
import I6.z0;
import U4.x;
import Y3.k;
import Y3.l;
import android.text.Layout.Alignment;
import android.text.TextUtils;
import androidx.recyclerview.widget.p0;
import e3.b;
import h7.u0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import y5.a;

public final class d implements l {
    public final XmlPullParserFactory a;
    public static final Pattern b;
    public static final Pattern c;
    public static final Pattern d;
    public static final Pattern e;
    public static final Pattern f;
    public static final Pattern g;
    public static final Pattern h;
    public static final androidx.viewpager2.widget.d i;

    static {
        d.b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        d.c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        d.d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        d.e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
        d.f = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
        d.g = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
        d.h = Pattern.compile("^(\\d+) (\\d+)$");
        d.i = new androidx.viewpager2.widget.d(30.0f, 1, 1);
    }

    public d() {
        try {
            XmlPullParserFactory xmlPullParserFactory0 = XmlPullParserFactory.newInstance();
            this.a = xmlPullParserFactory0;
            xmlPullParserFactory0.setNamespaceAware(true);
        }
        catch(XmlPullParserException xmlPullParserException0) {
            throw new RuntimeException("Couldn\'t create XmlPullParserFactory instance", xmlPullParserException0);
        }
    }

    public static f a(f f0) {
        return f0 == null ? new f() : f0;
    }

    // 去混淆评级： 中等(150)
    public static boolean b(String s) {
        return s.equals("tt") || s.equals("head") || s.equals("body") || s.equals("div") || s.equals("p") || s.equals("span") || s.equals("br") || s.equals("style") || s.equals("styling") || s.equals("layout") || s.equals("region") || s.equals("metadata") || s.equals("image") || s.equals("data") || s.equals("information");
    }

    public static int c(XmlPullParser xmlPullParser0) {
        String s = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if(s == null) {
            return 15;
        }
        Matcher matcher0 = d.h.matcher(s);
        if(!matcher0.matches()) {
            b.D("TtmlParser", "Ignoring malformed cell resolution: " + s);
            return 15;
        }
        try {
            boolean z = true;
            String s1 = matcher0.group(1);
            s1.getClass();
            int v = Integer.parseInt(s1);
            String s2 = matcher0.group(2);
            s2.getClass();
            int v1 = Integer.parseInt(s2);
            if(v == 0 || v1 == 0) {
                z = false;
            }
            b.d(z, "Invalid cell resolution " + v + " " + v1);
            return v1;
        }
        catch(NumberFormatException unused_ex) {
            b.D("TtmlParser", "Ignoring malformed cell resolution: " + s);
            return 15;
        }
    }

    public static void d(String s, f f0) {
        Matcher matcher0;
        String[] arr_s = s.split("\\s+", -1);
        Pattern pattern0 = d.d;
        boolean z = false;
        if(arr_s.length == 1) {
            z = true;
            matcher0 = pattern0.matcher(s);
        }
        else if(arr_s.length == 2) {
            z = true;
            matcher0 = pattern0.matcher(arr_s[1]);
            b.D("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if(z) {
            if(!matcher0.matches()) {
                throw new Y3.f("Invalid expression for fontSize: \'" + s + "\'.");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
            }
            String s1 = matcher0.group(3);
            s1.getClass();
            switch(s1) {
                case "%": {
                    f0.j = 3;
                    break;
                }
                case "em": {
                    f0.j = 2;
                    break;
                }
                case "px": {
                    f0.j = 1;
                    break;
                }
                default: {
                    throw new Y3.f("Invalid unit for fontSize: \'" + s1 + "\'.");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                }
            }
            String s2 = matcher0.group(1);
            s2.getClass();
            f0.k = Float.parseFloat(s2);
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Invalid number of entries for fontSize: ");
        throw new Y3.f(x.g(arr_s.length, ".", stringBuilder0));  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    }

    public static androidx.viewpager2.widget.d e(XmlPullParser xmlPullParser0) {
        float f;
        String s = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int v = s == null ? 30 : Integer.parseInt(s);
        String s1 = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if(s1 == null) {
            f = 1.0f;
        }
        else {
            String[] arr_s = s1.split(" ", -1);
            b.d(arr_s.length == 2, "frameRateMultiplier doesn\'t have 2 parts");
            f = ((float)Integer.parseInt(arr_s[0])) / ((float)Integer.parseInt(arr_s[1]));
        }
        androidx.viewpager2.widget.d d0 = d.i;
        int v1 = d0.b;
        String s2 = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if(s2 != null) {
            v1 = Integer.parseInt(s2);
        }
        int v2 = d0.c;
        String s3 = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if(s3 != null) {
            v2 = Integer.parseInt(s3);
        }
        return new androidx.viewpager2.widget.d(((float)v) * f, v1, v2);
    }

    // This method was un-flattened
    public static void f(XmlPullParser xmlPullParser0, HashMap hashMap0, int v, p0 p00, HashMap hashMap1, HashMap hashMap2) {
        e e0;
        int v8;
        int v7;
        float f9;
        float f8;
        float f7;
        float f6;
        float f5;
        float f4;
        float f3;
        float f2;
        float f1;
        do {
            xmlPullParser0.next();
            if(b.w(xmlPullParser0, "style")) {
                String s = b.s(xmlPullParser0, "style");
                f f0 = d.k(xmlPullParser0, new f());
                if(s != null) {
                    String s1 = s.trim();
                    String[] arr_s = s1.isEmpty() ? new String[0] : s1.split("\\s+", -1);
                    for(int v1 = 0; v1 < arr_s.length; ++v1) {
                        f0.a(((f)hashMap0.get(arr_s[v1])));
                    }
                }
                String s2 = f0.l;
                if(s2 != null) {
                    hashMap0.put(s2, f0);
                }
            }
            else if(b.w(xmlPullParser0, "region")) {
                String s3 = b.s(xmlPullParser0, "id");
                if(s3 != null) {
                    String s4 = b.s(xmlPullParser0, "origin");
                    if(s4 == null) {
                    label_119:
                        b.D("TtmlParser", "Ignoring region without an origin");
                    }
                    else {
                        Pattern pattern0 = d.f;
                        Matcher matcher0 = pattern0.matcher(s4);
                        Pattern pattern1 = d.g;
                        Matcher matcher1 = pattern1.matcher(s4);
                        int v2 = 2;
                        if(matcher0.matches()) {
                            try {
                                String s5 = matcher0.group(1);
                                s5.getClass();
                                f1 = Float.parseFloat(s5) / 100.0f;
                                String s6 = matcher0.group(2);
                                s6.getClass();
                                f2 = Float.parseFloat(s6) / 100.0f;
                                goto label_53;
                            }
                            catch(NumberFormatException unused_ex) {
                                b.D("TtmlParser", "Ignoring region with malformed origin: " + s4);
                                goto label_120;
                            }
                        }
                        else if(matcher1.matches()) {
                            if(p00 == null) {
                                b.D("TtmlParser", "Ignoring region with missing tts:extent: " + s4);
                                goto label_120;
                            }
                            else {
                                try {
                                    String s7 = matcher1.group(1);
                                    s7.getClass();
                                    int v3 = Integer.parseInt(s7);
                                    String s8 = matcher1.group(2);
                                    s8.getClass();
                                    int v4 = Integer.parseInt(s8);
                                    f3 = ((float)v3) / ((float)p00.a);
                                    f4 = (float)v4;
                                }
                                catch(NumberFormatException unused_ex) {
                                    b.D("TtmlParser", "Ignoring region with malformed origin: " + s4);
                                    goto label_120;
                                }
                                f2 = f4 / ((float)p00.b);
                                f1 = f3;
                            }
                        label_53:
                            String s9 = b.s(xmlPullParser0, "extent");
                            if(s9 != null) {
                                Matcher matcher2 = pattern0.matcher(s9);
                                Matcher matcher3 = pattern1.matcher(s9);
                                if(matcher2.matches()) {
                                    try {
                                        String s10 = matcher2.group(1);
                                        s10.getClass();
                                        f5 = Float.parseFloat(s10) / 100.0f;
                                        String s11 = matcher2.group(2);
                                        s11.getClass();
                                        f6 = Float.parseFloat(s11) / 100.0f;
                                        goto label_83;
                                    }
                                    catch(NumberFormatException unused_ex) {
                                        b.D("TtmlParser", "Ignoring region with malformed extent: " + s4);
                                        goto label_120;
                                    }
                                }
                                else if(matcher3.matches()) {
                                    if(p00 == null) {
                                        b.D("TtmlParser", "Ignoring region with missing tts:extent: " + s4);
                                        goto label_120;
                                    }
                                    else {
                                        try {
                                            String s12 = matcher3.group(1);
                                            s12.getClass();
                                            int v5 = Integer.parseInt(s12);
                                            String s13 = matcher3.group(2);
                                            s13.getClass();
                                            int v6 = Integer.parseInt(s13);
                                            f5 = ((float)v5) / ((float)p00.a);
                                            f7 = (float)v6;
                                        }
                                        catch(NumberFormatException unused_ex) {
                                            b.D("TtmlParser", "Ignoring region with malformed extent: " + s4);
                                            goto label_120;
                                        }
                                        f6 = f7 / ((float)p00.b);
                                    }
                                label_83:
                                    String s14 = b.s(xmlPullParser0, "displayAlign");
                                    if(s14 == null) {
                                        f8 = f2;
                                        f9 = f1;
                                        v7 = 0;
                                    }
                                    else {
                                        String s15 = u0.U(s14);
                                        s15.getClass();
                                        if(s15.equals("center")) {
                                            f8 = f2 + f6 / 2.0f;
                                            f9 = f1;
                                            v7 = 1;
                                        }
                                        else if(s15.equals("after")) {
                                            f8 = f2 + f6;
                                            f9 = f1;
                                            v7 = 2;
                                        }
                                    }
                                    String s16 = b.s(xmlPullParser0, "writingMode");
                                    if(s16 == null) {
                                        v2 = 0x80000000;
                                    }
                                    else {
                                        String s17 = u0.U(s16);
                                        s17.getClass();
                                        switch(s17) {
                                            case "tb": 
                                            case "tblr": {
                                                break;
                                            }
                                            case "tbrl": {
                                                v8 = 1;
                                                e0 = new e(s3, f9, f8, 0, v7, f5, f6, 1, 1.0f / ((float)v), v8);
                                                goto label_121;
                                            }
                                            default: {
                                                v2 = 0x80000000;
                                            }
                                        }
                                    }
                                    v8 = v2;
                                    e0 = new e(s3, f9, f8, 0, v7, f5, f6, 1, 1.0f / ((float)v), v8);
                                    goto label_121;
                                }
                                else {
                                    b.D("TtmlParser", "Ignoring region with unsupported extent: " + s4);
                                    goto label_120;
                                }
                            }
                            b.D("TtmlParser", "Ignoring region without an extent");
                            goto label_120;
                        }
                        else {
                            b.D("TtmlParser", "Ignoring region with unsupported origin: " + s4);
                            goto label_120;
                        }
                        goto label_119;
                    }
                }
            label_120:
                e0 = null;
            label_121:
                if(e0 != null) {
                    hashMap1.put(e0.a, e0);
                }
            }
            else if(b.w(xmlPullParser0, "metadata")) {
                while(true) {
                    xmlPullParser0.next();
                    if(b.w(xmlPullParser0, "image")) {
                        String s18 = b.s(xmlPullParser0, "id");
                        if(s18 != null) {
                            hashMap2.put(s18, xmlPullParser0.nextText());
                        }
                    }
                    if(b.v(xmlPullParser0, "metadata")) {
                        break;
                    }
                }
            }
        }
        while(!b.v(xmlPullParser0, "head"));
    }

    @Override  // Y3.l
    public final void g(byte[] arr_b, int v, int v1, k k0, e3.e e0) {
        a.T(this.i(arr_b, v, v1), k0, e0);
    }

    // This method was un-flattened
    public static c h(XmlPullParser xmlPullParser0, c c0, HashMap hashMap0, androidx.viewpager2.widget.d d0) {
        int v = xmlPullParser0.getAttributeCount();
        String[] arr_s = null;
        f f0 = d.k(xmlPullParser0, null);
        String s = null;
        String s1 = "";
        long v2 = 0x8000000000000001L;
        long v3 = 0x8000000000000001L;
        long v4 = 0x8000000000000001L;
        for(int v1 = 0; v1 < v; ++v1) {
            String s2 = xmlPullParser0.getAttributeName(v1);
            String s3 = xmlPullParser0.getAttributeValue(v1);
            s2.getClass();
            switch(s2) {
                case "backgroundImage": {
                    if(s3.startsWith("#")) {
                        s = s3.substring(1);
                    }
                    break;
                }
                case "begin": {
                    v2 = d.l(s3, d0);
                    break;
                }
                case "dur": {
                    v4 = d.l(s3, d0);
                    break;
                }
                case "end": {
                    v3 = d.l(s3, d0);
                    break;
                }
                case "region": {
                    if(hashMap0.containsKey(s3)) {
                        s1 = s3;
                    }
                    break;
                }
                case "style": {
                    String s4 = s3.trim();
                    String[] arr_s1 = s4.isEmpty() ? new String[0] : s4.split("\\s+", -1);
                    if(arr_s1.length > 0) {
                        arr_s = arr_s1;
                    }
                }
            }
        }
        if(c0 != null) {
            long v5 = c0.d;
            if(v5 != 0x8000000000000001L) {
                if(v2 != 0x8000000000000001L) {
                    v2 += v5;
                }
                if(v3 != 0x8000000000000001L) {
                    v3 += v5;
                }
            }
        }
        if(v3 == 0x8000000000000001L) {
            if(v4 != 0x8000000000000001L) {
                return new c(xmlPullParser0.getName(), null, v2, v2 + v4, f0, arr_s, s1, s, c0);
            }
            if(c0 != null) {
                return c0.e == 0x8000000000000001L ? new c(xmlPullParser0.getName(), null, v2, 0x8000000000000001L, f0, arr_s, s1, s, c0) : new c(xmlPullParser0.getName(), null, v2, c0.e, f0, arr_s, s1, s, c0);
            }
        }
        return new c(xmlPullParser0.getName(), null, v2, v3, f0, arr_s, s1, s, c0);
    }

    @Override  // Y3.l
    public final Y3.d i(byte[] arr_b, int v, int v1) {
        try {
            XmlPullParser xmlPullParser0 = this.a.newPullParser();
            HashMap hashMap0 = new HashMap();
            HashMap hashMap1 = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap1.put("", new e("", -3.402823E+38f, -3.402823E+38f, 0x80000000, 0x80000000, -3.402823E+38f, -3.402823E+38f, 0x80000000, -3.402823E+38f, 0x80000000));
            p0 p00 = null;
            xmlPullParser0.setInput(new ByteArrayInputStream(arr_b, v, v1), null);
            ArrayDeque arrayDeque0 = new ArrayDeque();
            int v2 = xmlPullParser0.getEventType();
            androidx.viewpager2.widget.d d0 = d.i;
            int v3 = 0;
            int v4 = 15;
            Y3.d d1 = null;
            while(true) {
                if(v2 == 1) {
                    d1.getClass();
                    return d1;
                }
                c c0 = (c)arrayDeque0.peek();
                if(v3 == 0) {
                    String s = xmlPullParser0.getName();
                    if(v2 == 2) {
                        if("tt".equals(s)) {
                            d0 = d.e(xmlPullParser0);
                            v4 = d.c(xmlPullParser0);
                            p00 = d.m(xmlPullParser0);
                        }
                        if(!d.b(s)) {
                            b.u("TtmlParser", "Ignoring unsupported tag: " + xmlPullParser0.getName());
                            goto label_45;
                        }
                        else if("head".equals(s)) {
                            d.f(xmlPullParser0, hashMap0, v4, p00, hashMap1, hashMap2);
                        }
                        else {
                            try {
                                c c1 = d.h(xmlPullParser0, c0, hashMap1, d0);
                                arrayDeque0.push(c1);
                                if(c0 != null) {
                                    if(c0.m == null) {
                                        c0.m = new ArrayList();
                                    }
                                    c0.m.add(c1);
                                }
                                goto label_62;
                            }
                            catch(Y3.f f0) {
                                b.E("TtmlParser", "Suppressing parser error", f0);
                            }
                        label_45:
                            v3 = 1;
                        }
                    }
                    else {
                        switch(v2) {
                            case 3: {
                                if(xmlPullParser0.getName().equals("tt")) {
                                    c c2 = (c)arrayDeque0.peek();
                                    c2.getClass();
                                    d1 = new i(c2, hashMap0, hashMap1, hashMap2);
                                }
                                arrayDeque0.pop();
                                break;
                            }
                            case 4: {
                                c0.getClass();
                                c c3 = c.a(xmlPullParser0.getText());
                                if(c0.m == null) {
                                    c0.m = new ArrayList();
                                }
                                c0.m.add(c3);
                            }
                        }
                    }
                }
                else {
                    switch(v2) {
                        case 2: {
                            ++v3;
                            break;
                        }
                        case 3: {
                            --v3;
                        }
                    }
                }
            label_62:
                xmlPullParser0.next();
                v2 = xmlPullParser0.getEventType();
            }
            throw new IllegalStateException("Unexpected error when reading input.", iOException0);
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        catch(IOException iOException0) {
            throw new IllegalStateException("Unexpected error when reading input.", iOException0);
        }
        throw new IllegalStateException("Unable to decode source", xmlPullParserException0);
    }

    @Override  // Y3.l
    public final int j() {
        return 1;
    }

    // This method was un-flattened
    public static f k(XmlPullParser xmlPullParser0, f f0) {
        e4.b b0;
        int v4;
        int v2;
        b0 b00;
        Layout.Alignment layout$Alignment0;
        int v = xmlPullParser0.getAttributeCount();
        f f1 = f0;
        for(int v1 = 0; v1 < v; ++v1) {
            String s = xmlPullParser0.getAttributeValue(v1);
            String s1 = xmlPullParser0.getAttributeName(v1);
            s1.getClass();
            switch(s1) {
                case "backgroundColor": {
                    f1 = d.a(f1);
                    try {
                        f1.d = e3.d.a(s, false);
                        f1.e = true;
                    }
                    catch(IllegalArgumentException unused_ex) {
                        com.iloen.melon.utils.a.w("Failed parsing background value: ", s, "TtmlParser");
                    }
                    break;
                }
                case "color": {
                    f1 = d.a(f1);
                    try {
                        f1.b = e3.d.a(s, false);
                        f1.c = true;
                    }
                    catch(IllegalArgumentException unused_ex) {
                        com.iloen.melon.utils.a.w("Failed parsing color value: ", s, "TtmlParser");
                    }
                    break;
                }
                case "fontFamily": {
                    f1 = d.a(f1);
                    f1.a = s;
                    break;
                }
                case "fontSize": {
                    try {
                        f1 = d.a(f1);
                        d.d(s, f1);
                    }
                    catch(Y3.f unused_ex) {
                        com.iloen.melon.utils.a.w("Failed parsing fontSize value: ", s, "TtmlParser");
                    }
                    break;
                }
                case "fontStyle": {
                    f1 = d.a(f1);
                    f1.i = "italic".equalsIgnoreCase(s);
                    break;
                }
                case "fontWeight": {
                    f1 = d.a(f1);
                    f1.h = "bold".equalsIgnoreCase(s);
                    break;
                }
                case "id": {
                    if("style".equals(xmlPullParser0.getName())) {
                        f1 = d.a(f1);
                        f1.l = s;
                    }
                    break;
                }
                case "multiRowAlign": {
                    layout$Alignment0 = null;
                    f1 = d.a(f1);
                    String s13 = u0.U(s);
                    s13.getClass();
                    switch(s13) {
                        case "center": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_CENTER;
                            break;
                        }
                        case "end": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        }
                        case "left": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                            break;
                        }
                        case "right": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        }
                        case "start": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                        }
                    }
                    f1.p = layout$Alignment0;
                    break;
                }
                case "ruby": {
                    String s4 = u0.U(s);
                    s4.getClass();
                    switch(s4) {
                        case "base": {
                            f1 = d.a(f1);
                            f1.m = 2;
                            break;
                        }
                        case "baseContainer": {
                            f1 = d.a(f1);
                            f1.m = 2;
                            break;
                        }
                        case "container": {
                            f1 = d.a(f1);
                            f1.m = 1;
                            break;
                        }
                        case "delimiter": {
                            f1 = d.a(f1);
                            f1.m = 4;
                            break;
                        }
                        case "text": {
                            f1 = d.a(f1);
                            f1.m = 3;
                            break;
                        }
                        case "textContainer": {
                            f1 = d.a(f1);
                            f1.m = 3;
                        }
                    }
                    break;
                }
                case "rubyPosition": {
                    String s12 = u0.U(s);
                    s12.getClass();
                    if(s12.equals("before")) {
                        f1 = d.a(f1);
                        f1.n = 1;
                    }
                    else if(s12.equals("after")) {
                        f1 = d.a(f1);
                        f1.n = 2;
                    }
                    break;
                }
                case "shear": {
                    f f2 = d.a(f1);
                    Matcher matcher0 = d.e.matcher(s);
                    float f3 = 3.402823E+38f;
                    if(matcher0.matches()) {
                        try {
                            String s5 = matcher0.group(1);
                            s5.getClass();
                            f3 = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(s5)));
                        }
                        catch(NumberFormatException numberFormatException0) {
                            b.E("TtmlParser", "Failed to parse shear: " + s, numberFormatException0);
                        }
                    }
                    else {
                        com.iloen.melon.utils.a.w("Invalid value for shear: ", s, "TtmlParser");
                    }
                    f2.s = f3;
                    f1 = f2;
                    break;
                }
                case "textAlign": {
                    layout$Alignment0 = null;
                    f1 = d.a(f1);
                    String s2 = u0.U(s);
                    s2.getClass();
                    switch(s2) {
                        case "center": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_CENTER;
                            break;
                        }
                        case "end": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        }
                        case "left": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                            break;
                        }
                        case "right": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        }
                        case "start": {
                            layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                        }
                    }
                    f1.o = layout$Alignment0;
                    break;
                }
                case "textCombine": {
                    String s6 = u0.U(s);
                    s6.getClass();
                    if(s6.equals("all")) {
                        f1 = d.a(f1);
                        f1.q = 1;
                    }
                    else if(s6.equals("none")) {
                        f1 = d.a(f1);
                        f1.q = 0;
                    }
                    break;
                }
                case "textDecoration": {
                    String s3 = u0.U(s);
                    s3.getClass();
                    switch(s3) {
                        case "linethrough": {
                            f1 = d.a(f1);
                            f1.f = 1;
                            break;
                        }
                        case "nolinethrough": {
                            f1 = d.a(f1);
                            f1.f = 0;
                            break;
                        }
                        case "nounderline": {
                            f1 = d.a(f1);
                            f1.g = 0;
                            break;
                        }
                        case "underline": {
                            f1 = d.a(f1);
                            f1.g = 1;
                        }
                    }
                    break;
                }
                case "textEmphasis": {
                    f1 = d.a(f1);
                    if(s == null) {
                        b0 = null;
                    }
                    else {
                        String s7 = u0.U(s.trim());
                        if(!s7.isEmpty()) {
                            String[] arr_s = TextUtils.split(s7, e4.b.d);
                            switch(arr_s.length) {
                                case 0: {
                                    b00 = v0.j;
                                    break;
                                }
                                case 1: {
                                    b00 = new E0(arr_s[0]);
                                    break;
                                }
                                default: {
                                    Object[] arr_object = (Object[])arr_s.clone();
                                    b00 = b0.o(arr_s.length, arr_object);
                                }
                            }
                            I6.a a0 = (I6.a)w.l(e4.b.h, b00).b();
                            String s8 = a0.hasNext() ? a0.next() : "outside";
                            switch(s8) {
                                case "after": {
                                    v2 = 2;
                                    break;
                                }
                                case "outside": {
                                    v2 = -2;
                                    break;
                                }
                                default: {
                                    v2 = 1;
                                }
                            }
                            z0 z00 = w.l(e4.b.e, b00);
                            if(z00.isEmpty()) {
                                z0 z01 = w.l(e4.b.g, b00);
                                z0 z02 = w.l(e4.b.f, b00);
                                if(!z01.isEmpty() || !z02.isEmpty()) {
                                    I6.a a1 = (I6.a)z01.b();
                                    String s10 = a1.hasNext() ? a1.next() : "filled";
                                    int v3 = s10.hashCode() != 0x34264A || !s10.equals("open") ? 1 : 2;
                                    I6.a a2 = (I6.a)z02.b();
                                    String s11 = a2.hasNext() ? a2.next() : "circle";
                                    switch(s11) {
                                        case "dot": {
                                            v4 = 2;
                                            break;
                                        }
                                        case "sesame": {
                                            v4 = 3;
                                            break;
                                        }
                                        default: {
                                            v4 = 1;
                                        }
                                    }
                                    b0 = new e4.b(v4, v3, v2);
                                }
                                else {
                                    b0 = new e4.b(-1, 0, v2);
                                }
                            }
                            else {
                                String s9 = (String)new A0(z00.c, z00.d).next();
                                b0 = new e4.b((s9.hashCode() != 0x33AF38 || !s9.equals("none") ? -1 : 0), 0, v2);
                            }
                        }
                    }
                    f1.r = b0;
                }
            }
        }
        return f1;
    }

    public static long l(String s, androidx.viewpager2.widget.d d0) {
        Matcher matcher0 = d.b.matcher(s);
        if(matcher0.matches()) {
            String s1 = matcher0.group(1);
            s1.getClass();
            long v = Long.parseLong(s1);
            String s2 = matcher0.group(2);
            s2.getClass();
            long v1 = Long.parseLong(s2);
            String s3 = matcher0.group(3);
            s3.getClass();
            double f = ((double)(v * 3600L)) + ((double)(v1 * 60L)) + ((double)Long.parseLong(s3));
            String s4 = matcher0.group(4);
            double f1 = 0.0;
            double f2 = s4 == null ? 0.0 : Double.parseDouble(s4);
            String s5 = matcher0.group(5);
            double f3 = s5 == null ? 0.0 : ((double)(((float)Long.parseLong(s5)) / d0.a));
            String s6 = matcher0.group(6);
            if(s6 != null) {
                f1 = ((double)Long.parseLong(s6)) / ((double)d0.b) / ((double)d0.a);
            }
            return (long)((f + f2 + f3 + f1) * 1000000.0);
        }
        Matcher matcher1 = d.c.matcher(s);
        if(matcher1.matches()) {
            String s7 = matcher1.group(1);
            s7.getClass();
            double f4 = Double.parseDouble(s7);
            String s8 = matcher1.group(2);
            s8.getClass();
            switch(s8) {
                case "f": {
                    return (long)(f4 / ((double)d0.a) * 1000000.0);
                }
                case "h": {
                    return (long)(f4 * 3600000000.0);
                }
                case "m": {
                    return (long)(f4 * 60000000.0);
                }
                case "ms": {
                    return (long)(f4 / 1000.0 * 1000000.0);
                }
                case "t": {
                    return (long)(f4 / ((double)d0.c) * 1000000.0);
                }
                default: {
                    return (long)(f4 * 1000000.0);
                }
            }
        }
        throw new Y3.f("Malformed time expression: " + s);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    }

    public static p0 m(XmlPullParser xmlPullParser0) {
        String s = b.s(xmlPullParser0, "extent");
        if(s == null) {
            return null;
        }
        Matcher matcher0 = d.g.matcher(s);
        if(!matcher0.matches()) {
            b.D("TtmlParser", "Ignoring non-pixel tts extent: " + s);
            return null;
        }
        try {
            String s1 = matcher0.group(1);
            s1.getClass();
            int v = Integer.parseInt(s1);
            String s2 = matcher0.group(2);
            s2.getClass();
            return new p0(v, Integer.parseInt(s2));
        }
        catch(NumberFormatException unused_ex) {
            b.D("TtmlParser", "Ignoring malformed tts extent: " + s);
            return null;
        }
    }
}

