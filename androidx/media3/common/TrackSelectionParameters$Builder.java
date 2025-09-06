package androidx.media3.common;

import I6.Q;
import I6.V;
import I6.p0;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.text.TextUtils;
import android.view.Display.Mode;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import b3.r0;
import b3.t0;
import b3.u0;
import e3.b;
import e3.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class TrackSelectionParameters.Builder {
    public HashMap A;
    public HashSet B;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public V l;
    public int m;
    public V n;
    public int o;
    public int p;
    public int q;
    public V r;
    public t0 s;
    public V t;
    public int u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public TrackSelectionParameters.Builder() {
        this.a = 0x7FFFFFFF;
        this.b = 0x7FFFFFFF;
        this.c = 0x7FFFFFFF;
        this.d = 0x7FFFFFFF;
        this.i = 0x7FFFFFFF;
        this.j = 0x7FFFFFFF;
        this.k = true;
        this.l = p0.e;
        this.m = 0;
        this.n = p0.e;
        this.o = 0;
        this.p = 0x7FFFFFFF;
        this.q = 0x7FFFFFFF;
        this.r = p0.e;
        this.s = t0.d;
        this.t = p0.e;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = new HashMap();
        this.B = new HashSet();
    }

    public TrackSelectionParameters.Builder(Context context0) {
        this.f(context0);
        this.h(context0);
    }

    public void a(r0 r00) {
        this.A.put(r00.a, r00);
    }

    public u0 b() {
        return new u0(this);
    }

    public TrackSelectionParameters.Builder c() {
        this.A.clear();
        return this;
    }

    public final void d(u0 u00) {
        this.a = u00.a;
        this.b = u00.b;
        this.c = u00.c;
        this.d = u00.d;
        this.e = u00.e;
        this.f = u00.f;
        this.g = u00.g;
        this.h = u00.h;
        this.i = u00.i;
        this.j = u00.j;
        this.k = u00.k;
        this.l = u00.l;
        this.m = u00.m;
        this.n = u00.n;
        this.o = u00.o;
        this.p = u00.p;
        this.q = u00.q;
        this.r = u00.r;
        this.s = u00.s;
        this.t = u00.t;
        this.u = u00.u;
        this.v = u00.v;
        this.w = u00.w;
        this.x = u00.x;
        this.y = u00.y;
        this.z = u00.z;
        this.B = new HashSet(u00.B);
        this.A = new HashMap(u00.A);
    }

    public static p0 e(String[] arr_s) {
        Q q0 = V.o();
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            s.getClass();
            q0.a(x.N(s));
        }
        return q0.g();
    }

    public void f(Context context0) {
        CaptioningManager captioningManager0 = (CaptioningManager)context0.getSystemService("captioning");
        if(captioningManager0 != null && captioningManager0.isEnabled()) {
            this.u = 0x440;
            Locale locale0 = captioningManager0.getLocale();
            if(locale0 != null) {
                this.t = V.t(locale0.toLanguageTag());
            }
        }
    }

    public TrackSelectionParameters.Builder g(int v, int v1) {
        this.i = v;
        this.j = v1;
        this.k = true;
        return this;
    }

    public void h(Context context0) {
        Point point0;
        Point point1;
        DisplayManager displayManager0 = (DisplayManager)context0.getSystemService("display");
        Display display0 = displayManager0 == null ? null : displayManager0.getDisplay(0);
        if(display0 == null) {
            WindowManager windowManager0 = (WindowManager)context0.getSystemService("window");
            windowManager0.getClass();
            display0 = windowManager0.getDefaultDisplay();
        }
        if(display0.getDisplayId() != 0 || !x.K(context0)) {
        label_20:
            point1 = new Point();
            Display.Mode display$Mode0 = display0.getMode();
            point1.x = display$Mode0.getPhysicalWidth();
            point1.y = display$Mode0.getPhysicalHeight();
            point0 = point1;
        }
        else {
            String s = x.C("vendor.display-size");
            if(TextUtils.isEmpty(s)) {
            label_17:
                if("Sony".equals(x.c) && x.d.startsWith("BRAVIA") && context0.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                    point1 = new Point(0xF00, 0x870);
                    point0 = point1;
                    this.g(point0.x, point0.y);
                    return;
                }
                goto label_20;
            }
            else {
                try {
                    String[] arr_s = s.trim().split("x", -1);
                    if(arr_s.length == 2) {
                        int v = Integer.parseInt(arr_s[0]);
                        int v1 = Integer.parseInt(arr_s[1]);
                        if(v > 0 && v1 > 0) {
                            point0 = new Point(v, v1);
                            goto label_25;
                        }
                    }
                }
                catch(NumberFormatException unused_ex) {
                }
                b.p("Util", "Invalid display size: " + s);
                goto label_17;
            }
        }
    label_25:
        this.g(point0.x, point0.y);
    }
}

