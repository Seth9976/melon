package androidx.constraintlayout.motion.widget;

import I1.n;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.q;
import java.util.HashMap;
import java.util.HashSet;
import va.e;

public final class l extends c {
    public int e;
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
    public float p;
    public float q;
    public int r;
    public float s;
    public float t;

    public l() {
        this.e = -1;
        this.f = NaNf;
        this.g = NaNf;
        this.h = NaNf;
        this.i = NaNf;
        this.j = NaNf;
        this.k = NaNf;
        this.l = NaNf;
        this.m = NaNf;
        this.n = NaNf;
        this.o = NaNf;
        this.p = NaNf;
        this.q = NaNf;
        this.r = 0;
        this.s = NaNf;
        this.t = 0.0f;
        this.d = new HashMap();
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void a(HashMap hashMap0) {
        throw null;
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final c b() {
        c c0 = new l();
        c0.super.c(this);
        c0.e = this.e;
        c0.r = this.r;
        c0.s = this.s;
        c0.t = this.t;
        c0.q = this.q;
        c0.f = this.f;
        c0.g = this.g;
        c0.h = this.h;
        c0.k = this.k;
        c0.i = this.i;
        c0.j = this.j;
        c0.l = this.l;
        c0.m = this.m;
        c0.n = this.n;
        c0.o = this.o;
        c0.p = this.p;
        return c0;
    }

    @Override
    public final Object clone() {
        return this.b();
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void d(HashSet hashSet0) {
        if(!Float.isNaN(this.f)) {
            hashSet0.add("alpha");
        }
        if(!Float.isNaN(this.g)) {
            hashSet0.add("elevation");
        }
        if(!Float.isNaN(this.h)) {
            hashSet0.add("rotation");
        }
        if(!Float.isNaN(this.i)) {
            hashSet0.add("rotationX");
        }
        if(!Float.isNaN(this.j)) {
            hashSet0.add("rotationY");
        }
        if(!Float.isNaN(this.n)) {
            hashSet0.add("translationX");
        }
        if(!Float.isNaN(this.o)) {
            hashSet0.add("translationY");
        }
        if(!Float.isNaN(this.p)) {
            hashSet0.add("translationZ");
        }
        if(!Float.isNaN(this.k)) {
            hashSet0.add("transitionPathRotate");
        }
        if(!Float.isNaN(this.l)) {
            hashSet0.add("scaleX");
        }
        if(!Float.isNaN(this.m)) {
            hashSet0.add("scaleY");
        }
        if(!Float.isNaN(this.q)) {
            hashSet0.add("progress");
        }
        if(this.d.size() > 0) {
            for(Object object0: this.d.keySet()) {
                hashSet0.add("CUSTOM," + ((String)object0));
            }
        }
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void e(Context context0, AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.n);
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            SparseIntArray sparseIntArray0 = k.a;
            switch(sparseIntArray0.get(v2)) {
                case 1: {
                    this.f = typedArray0.getFloat(v2, this.f);
                    break;
                }
                case 2: {
                    this.g = typedArray0.getDimension(v2, this.g);
                    break;
                }
                case 4: {
                    this.h = typedArray0.getFloat(v2, this.h);
                    break;
                }
                case 5: {
                    this.i = typedArray0.getFloat(v2, this.i);
                    break;
                }
                case 6: {
                    this.j = typedArray0.getFloat(v2, this.j);
                    break;
                }
                case 7: {
                    this.l = typedArray0.getFloat(v2, this.l);
                    break;
                }
                case 8: {
                    this.k = typedArray0.getFloat(v2, this.k);
                    break;
                }
                case 9: {
                    typedArray0.getString(v2);
                    break;
                }
                case 10: {
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
                case 12: {
                    this.a = typedArray0.getInt(v2, this.a);
                    break;
                }
                case 13: {
                    this.e = typedArray0.getInteger(v2, this.e);
                    break;
                }
                case 14: {
                    this.m = typedArray0.getFloat(v2, this.m);
                    break;
                }
                case 15: {
                    this.n = typedArray0.getDimension(v2, this.n);
                    break;
                }
                case 16: {
                    this.o = typedArray0.getDimension(v2, this.o);
                    break;
                }
                case 17: {
                    this.p = typedArray0.getDimension(v2, this.p);
                    break;
                }
                case 18: {
                    this.q = typedArray0.getFloat(v2, this.q);
                    break;
                }
                case 19: {
                    if(typedArray0.peekValue(v2).type == 3) {
                        typedArray0.getString(v2);
                        this.r = 7;
                    }
                    else {
                        this.r = typedArray0.getInt(v2, this.r);
                    }
                    break;
                }
                case 20: {
                    this.s = typedArray0.getFloat(v2, this.s);
                    break;
                }
                case 21: {
                    this.t = typedArray0.peekValue(v2).type == 5 ? typedArray0.getDimension(v2, this.t) : typedArray0.getFloat(v2, this.t);
                    break;
                }
                default: {
                    Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                }
            }
        }
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void f(HashMap hashMap0) {
        if(this.e != -1) {
            if(!Float.isNaN(this.f)) {
                hashMap0.put("alpha", this.e);
            }
            if(!Float.isNaN(this.g)) {
                hashMap0.put("elevation", this.e);
            }
            if(!Float.isNaN(this.h)) {
                hashMap0.put("rotation", this.e);
            }
            if(!Float.isNaN(this.i)) {
                hashMap0.put("rotationX", this.e);
            }
            if(!Float.isNaN(this.j)) {
                hashMap0.put("rotationY", this.e);
            }
            if(!Float.isNaN(this.n)) {
                hashMap0.put("translationX", this.e);
            }
            if(!Float.isNaN(this.o)) {
                hashMap0.put("translationY", this.e);
            }
            if(!Float.isNaN(this.p)) {
                hashMap0.put("translationZ", this.e);
            }
            if(!Float.isNaN(this.k)) {
                hashMap0.put("transitionPathRotate", this.e);
            }
            if(!Float.isNaN(this.l)) {
                hashMap0.put("scaleX", this.e);
            }
            if(!Float.isNaN(this.l)) {
                hashMap0.put("scaleY", this.e);
            }
            if(!Float.isNaN(this.q)) {
                hashMap0.put("progress", this.e);
            }
            if(this.d.size() > 0) {
                for(Object object0: this.d.keySet()) {
                    hashMap0.put(e.b("CUSTOM,", ((String)object0)), this.e);
                }
            }
        }
    }

    public final void h(HashMap hashMap0) {
        for(Object object0: hashMap0.keySet()) {
            String s = (String)object0;
            I1.q q0 = (I1.q)hashMap0.get(s);
            if(q0 == null) {
            }
            else if(s.startsWith("CUSTOM")) {
                a a0 = (a)this.d.get(s.substring(7));
                if(a0 == null) {
                    continue;
                }
                int v = this.a;
                float f = this.s;
                int v1 = this.r;
                float f1 = this.t;
                ((n)q0).l.append(v, a0);
                ((n)q0).m.append(v, new float[]{f, f1});
                ((n)q0).b = Math.max(((n)q0).b, v1);
            }
            else {
                switch(s) {
                    case "alpha": {
                        if(!Float.isNaN(this.f)) {
                            break;
                        }
                        continue;
                    }
                    case "elevation": {
                        if(Float.isNaN(this.g)) {
                            continue;
                        }
                        q0.c(this.g, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "progress": {
                        if(Float.isNaN(this.q)) {
                            continue;
                        }
                        q0.c(this.q, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "rotation": {
                        if(Float.isNaN(this.h)) {
                            continue;
                        }
                        q0.c(this.h, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "rotationX": {
                        if(Float.isNaN(this.i)) {
                            continue;
                        }
                        q0.c(this.i, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "rotationY": {
                        if(Float.isNaN(this.j)) {
                            continue;
                        }
                        q0.c(this.j, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "scaleX": {
                        if(Float.isNaN(this.l)) {
                            continue;
                        }
                        q0.c(this.l, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "scaleY": {
                        if(Float.isNaN(this.m)) {
                            continue;
                        }
                        q0.c(this.m, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "transitionPathRotate": {
                        if(Float.isNaN(this.k)) {
                            continue;
                        }
                        q0.c(this.k, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "translationX": {
                        if(Float.isNaN(this.n)) {
                            continue;
                        }
                        q0.c(this.n, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "translationY": {
                        if(Float.isNaN(this.o)) {
                            continue;
                        }
                        q0.c(this.o, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    case "translationZ": {
                        if(Float.isNaN(this.p)) {
                            continue;
                        }
                        q0.c(this.p, this.s, this.t, this.a, this.r);
                        continue;
                    }
                    default: {
                        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + s + "\"");
                        continue;
                    }
                }
                q0.c(this.f, this.s, this.t, this.a, this.r);
            }
        }
    }
}

