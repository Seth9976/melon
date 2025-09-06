package androidx.constraintlayout.motion.widget;

import A1.e;
import I1.h;
import I1.k;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.i;
import androidx.constraintlayout.widget.n;
import e0.b;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class o implements Comparable {
    public float a;
    public int b;
    public int c;
    public final LinkedHashMap d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float r;
    public float w;

    public o() {
        this.a = 0.0f;
        this.b = 0;
        this.d = new LinkedHashMap();
        this.e = 1.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 1.0f;
        this.j = 1.0f;
        this.k = NaNf;
        this.l = NaNf;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.r = NaNf;
        this.w = NaNf;
    }

    public final void a(HashMap hashMap0, int v) {
        for(Object object0: hashMap0.keySet()) {
            String s = (String)object0;
            k k0 = (k)hashMap0.get(s);
            if(k0 != null) {
                s.getClass();
                int v1 = -1;
                switch(s) {
                    case "alpha": {
                        v1 = 13;
                        break;
                    }
                    case "elevation": {
                        v1 = 11;
                        break;
                    }
                    case "progress": {
                        v1 = 5;
                        break;
                    }
                    case "rotation": {
                        v1 = 10;
                        break;
                    }
                    case "rotationX": {
                        v1 = 0;
                        break;
                    }
                    case "rotationY": {
                        v1 = 1;
                        break;
                    }
                    case "scaleX": {
                        v1 = 6;
                        break;
                    }
                    case "scaleY": {
                        v1 = 7;
                        break;
                    }
                    case "transformPivotX": {
                        v1 = 8;
                        break;
                    }
                    case "transformPivotY": {
                        v1 = 9;
                        break;
                    }
                    case "transitionPathRotate": {
                        v1 = 12;
                        break;
                    }
                    case "translationX": {
                        v1 = 2;
                        break;
                    }
                    case "translationY": {
                        v1 = 3;
                        break;
                    }
                    case "translationZ": {
                        v1 = 4;
                    }
                }
                float f = 1.0f;
                float f1 = 0.0f;
                switch(v1) {
                    case 0: {
                        if(!Float.isNaN(this.h)) {
                            f1 = this.h;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 1: {
                        if(!Float.isNaN(this.a)) {
                            f1 = this.a;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 2: {
                        if(!Float.isNaN(this.m)) {
                            f1 = this.m;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 3: {
                        if(!Float.isNaN(this.n)) {
                            f1 = this.n;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 4: {
                        if(!Float.isNaN(this.o)) {
                            f1 = this.o;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 5: {
                        if(!Float.isNaN(this.w)) {
                            f1 = this.w;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 6: {
                        if(!Float.isNaN(this.i)) {
                            f = this.i;
                        }
                        k0.b(f, v);
                        continue;
                    }
                    case 7: {
                        if(!Float.isNaN(this.j)) {
                            f = this.j;
                        }
                        k0.b(f, v);
                        continue;
                    }
                    case 8: {
                        if(!Float.isNaN(this.k)) {
                            f1 = this.k;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 9: {
                        if(!Float.isNaN(this.l)) {
                            f1 = this.l;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 10: {
                        if(!Float.isNaN(this.g)) {
                            f1 = this.g;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 11: {
                        if(!Float.isNaN(this.f)) {
                            f1 = this.f;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 12: {
                        if(!Float.isNaN(this.r)) {
                            f1 = this.r;
                        }
                        k0.b(f1, v);
                        continue;
                    }
                    case 13: {
                        if(!Float.isNaN(this.e)) {
                            f = this.e;
                        }
                        break;
                    }
                    default: {
                        if(s.startsWith("CUSTOM")) {
                            String s1 = s.split(",")[1];
                            LinkedHashMap linkedHashMap0 = this.d;
                            if(!linkedHashMap0.containsKey(s1)) {
                                continue;
                            }
                            a a0 = (a)linkedHashMap0.get(s1);
                            if(k0 instanceof h) {
                                ((h)k0).f.append(v, a0);
                            }
                            else {
                                Log.e("MotionPaths", s + " ViewSpline not a CustomSet frame = " + v + ", value" + a0.a() + k0);
                            }
                        }
                        else {
                            Log.e("MotionPaths", "UNKNOWN spline " + s);
                        }
                        continue;
                    }
                }
                k0.b(f, v);
            }
        }
    }

    public final void b(View view0) {
        this.c = view0.getVisibility();
        this.e = view0.getVisibility() == 0 ? view0.getAlpha() : 0.0f;
        this.f = view0.getElevation();
        this.g = view0.getRotation();
        this.h = view0.getRotationX();
        this.a = view0.getRotationY();
        this.i = view0.getScaleX();
        this.j = view0.getScaleY();
        this.k = view0.getPivotX();
        this.l = view0.getPivotY();
        this.m = view0.getTranslationX();
        this.n = view0.getTranslationY();
        this.o = view0.getTranslationZ();
    }

    // 去混淆评级： 低(20)
    public static boolean c(float f, float f1) {
        return Float.isNaN(f) || Float.isNaN(f1) ? Float.isNaN(f) != Float.isNaN(f1) : Math.abs(f - f1) > 0.000001f;
    }

    @Override
    public final int compareTo(Object object0) {
        ((o)object0).getClass();
        return 0;
    }

    public final void d(Rect rect0, n n0, int v, int v1) {
        rect0.width();
        rect0.height();
        i i0 = n0.l(v1);
        int v2 = i0.c.c;
        this.b = v2;
        this.c = i0.c.b;
        this.e = i0.c.b == 0 || v2 != 0 ? i0.c.d : 0.0f;
        this.f = i0.f.n;
        this.g = i0.f.b;
        this.h = i0.f.c;
        this.a = i0.f.d;
        this.i = i0.f.e;
        this.j = i0.f.f;
        this.k = i0.f.g;
        this.l = i0.f.h;
        this.m = i0.f.j;
        this.n = i0.f.k;
        this.o = i0.f.l;
        e.d(i0.d.d);
        this.r = i0.d.h;
        this.w = i0.c.e;
        for(Object object0: i0.g.keySet()) {
            String s = (String)object0;
            a a0 = (a)i0.g.get(s);
            switch(b.b(a0.c)) {
                case 4: 
                case 5: 
                case 7: {
                    continue;
                }
                default: {
                    this.d.put(s, a0);
                }
            }
        }
        switch(v) {
            case 1: 
            case 3: {
                this.g -= 90.0f;
                return;
            }
            case 2: 
            case 4: {
                float f = this.g + 90.0f;
                this.g = f;
                if(f > 180.0f) {
                    this.g = f - 360.0f;
                }
            }
        }
    }
}

