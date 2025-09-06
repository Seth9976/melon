package androidx.constraintlayout.motion.widget;

import A1.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.q;
import java.util.HashMap;
import java.util.HashSet;

public final class g extends c {
    public int e;
    public int f;
    public String g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;

    public g() {
        this.e = 0;
        this.f = -1;
        this.g = null;
        this.h = NaNf;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = NaNf;
        this.l = -1;
        this.m = NaNf;
        this.n = NaNf;
        this.o = NaNf;
        this.p = NaNf;
        this.q = NaNf;
        this.r = NaNf;
        this.s = NaNf;
        this.t = NaNf;
        this.u = NaNf;
        this.v = NaNf;
        this.w = NaNf;
        this.d = new HashMap();
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void a(HashMap hashMap0) {
        throw null;
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final c b() {
        c c0 = new g();
        c0.super.c(this);
        c0.e = this.e;
        c0.f = this.f;
        c0.g = this.g;
        c0.h = this.h;
        c0.i = this.i;
        c0.j = this.j;
        c0.k = this.k;
        c0.l = this.l;
        c0.m = this.m;
        c0.n = this.n;
        c0.o = this.o;
        c0.p = this.p;
        c0.q = this.q;
        c0.r = this.r;
        c0.s = this.s;
        c0.t = this.t;
        c0.u = this.u;
        c0.v = this.v;
        c0.w = this.w;
        return c0;
    }

    @Override
    public final Object clone() {
        return this.b();
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void d(HashSet hashSet0) {
        if(!Float.isNaN(this.m)) {
            hashSet0.add("alpha");
        }
        if(!Float.isNaN(this.n)) {
            hashSet0.add("elevation");
        }
        if(!Float.isNaN(this.o)) {
            hashSet0.add("rotation");
        }
        if(!Float.isNaN(this.q)) {
            hashSet0.add("rotationX");
        }
        if(!Float.isNaN(this.r)) {
            hashSet0.add("rotationY");
        }
        if(!Float.isNaN(this.s)) {
            hashSet0.add("scaleX");
        }
        if(!Float.isNaN(this.t)) {
            hashSet0.add("scaleY");
        }
        if(!Float.isNaN(this.p)) {
            hashSet0.add("transitionPathRotate");
        }
        if(!Float.isNaN(this.u)) {
            hashSet0.add("translationX");
        }
        if(!Float.isNaN(this.v)) {
            hashSet0.add("translationY");
        }
        if(!Float.isNaN(this.w)) {
            hashSet0.add("translationZ");
        }
        if(this.d.size() > 0) {
            for(Object object0: this.d.keySet()) {
                hashSet0.add("CUSTOM," + ((String)object0));
            }
        }
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void e(Context context0, AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.l);
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            SparseIntArray sparseIntArray0 = f.a;
            switch(sparseIntArray0.get(v2)) {
                case 1: {
                    if(MotionLayout.IS_IN_EDIT_MODE) {
                        int v3 = typedArray0.getResourceId(v2, this.b);
                        this.b = v3;
                        if(v3 == -1) {
                            this.c = typedArray0.getString(v2);
                        }
                    }
                    else if(typedArray0.peekValue(v2).type == 3) {
                        this.c = typedArray0.getString(v2);
                    }
                    else {
                        this.b = typedArray0.getResourceId(v2, this.b);
                    }
                    break;
                }
                case 2: {
                    this.a = typedArray0.getInt(v2, this.a);
                    break;
                }
                case 3: {
                    typedArray0.getString(v2);
                    break;
                }
                case 4: {
                    this.e = typedArray0.getInteger(v2, this.e);
                    break;
                }
                case 5: {
                    if(typedArray0.peekValue(v2).type == 3) {
                        this.g = typedArray0.getString(v2);
                        this.f = 7;
                    }
                    else {
                        this.f = typedArray0.getInt(v2, this.f);
                    }
                    break;
                }
                case 6: {
                    this.h = typedArray0.getFloat(v2, this.h);
                    break;
                }
                case 7: {
                    this.i = typedArray0.peekValue(v2).type == 5 ? typedArray0.getDimension(v2, this.i) : typedArray0.getFloat(v2, this.i);
                    break;
                }
                case 8: {
                    this.l = typedArray0.getInt(v2, this.l);
                    break;
                }
                case 9: {
                    this.m = typedArray0.getFloat(v2, this.m);
                    break;
                }
                case 10: {
                    this.n = typedArray0.getDimension(v2, this.n);
                    break;
                }
                case 11: {
                    this.o = typedArray0.getFloat(v2, this.o);
                    break;
                }
                case 12: {
                    this.q = typedArray0.getFloat(v2, this.q);
                    break;
                }
                case 13: {
                    this.r = typedArray0.getFloat(v2, this.r);
                    break;
                }
                case 14: {
                    this.p = typedArray0.getFloat(v2, this.p);
                    break;
                }
                case 15: {
                    this.s = typedArray0.getFloat(v2, this.s);
                    break;
                }
                case 16: {
                    this.t = typedArray0.getFloat(v2, this.t);
                    break;
                }
                case 17: {
                    this.u = typedArray0.getDimension(v2, this.u);
                    break;
                }
                case 18: {
                    this.v = typedArray0.getDimension(v2, this.v);
                    break;
                }
                case 19: {
                    this.w = typedArray0.getDimension(v2, this.w);
                    break;
                }
                case 20: {
                    this.k = typedArray0.getFloat(v2, this.k);
                    break;
                }
                case 21: {
                    this.j = typedArray0.getFloat(v2, this.j) / 360.0f;
                    break;
                }
                default: {
                    Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                }
            }
        }
    }

    public final void h(HashMap hashMap0) {
        float f1;
        for(Object object0: hashMap0.keySet()) {
            String s = (String)object0;
            if(s.startsWith("CUSTOM")) {
                a a0 = (a)this.d.get(s.substring(7));
                if(a0 == null || a0.c != 2) {
                    continue;
                }
                I1.f f0 = (I1.f)hashMap0.get(s);
                if(f0 == null) {
                    continue;
                }
                int v = this.a;
                int v1 = this.f;
                String s1 = this.g;
                int v2 = this.l;
                h h0 = new h(this.h, this.i, this.j, a0.a(), v);
                f0.f.add(h0);
                if(v2 != -1) {
                    f0.e = v2;
                }
                f0.c = v1;
                f0.d(a0);
                f0.d = s1;
            }
            else {
                switch(s) {
                    case "alpha": {
                        f1 = this.m;
                        break;
                    }
                    case "elevation": {
                        f1 = this.n;
                        break;
                    }
                    case "progress": {
                        f1 = this.k;
                        break;
                    }
                    case "rotation": {
                        f1 = this.o;
                        break;
                    }
                    case "rotationX": {
                        f1 = this.q;
                        break;
                    }
                    case "rotationY": {
                        f1 = this.r;
                        break;
                    }
                    case "scaleX": {
                        f1 = this.s;
                        break;
                    }
                    case "scaleY": {
                        f1 = this.t;
                        break;
                    }
                    case "transitionPathRotate": {
                        f1 = this.p;
                        break;
                    }
                    case "translationX": {
                        f1 = this.u;
                        break;
                    }
                    case "translationY": {
                        f1 = this.v;
                        break;
                    }
                    case "translationZ": {
                        f1 = this.w;
                        break;
                    }
                    case "waveOffset": {
                        f1 = this.i;
                        break;
                    }
                    case "wavePhase": {
                        f1 = this.j;
                        break;
                    }
                    default: {
                        if(!s.startsWith("CUSTOM")) {
                            Log.v("WARNING! KeyCycle", "  UNKNOWN  " + s);
                        }
                        f1 = NaNf;
                    }
                }
                if(!Float.isNaN(f1)) {
                    I1.f f2 = (I1.f)hashMap0.get(s);
                    if(f2 != null) {
                        int v3 = this.f;
                        String s2 = this.g;
                        int v4 = this.l;
                        h h1 = new h(this.h, this.i, this.j, f1, this.a);
                        f2.f.add(h1);
                        if(v4 != -1) {
                            f2.e = v4;
                        }
                        f2.c = v3;
                        f2.d = s2;
                    }
                }
            }
        }
    }
}

