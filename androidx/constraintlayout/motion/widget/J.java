package androidx.constraintlayout.motion.widget;

import A1.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.q;
import java.util.HashMap;
import java.util.HashSet;

public final class j extends c {
    public int e;
    public String f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public int m;

    public j() {
        this.e = -1;
        this.f = null;
        this.g = -1;
        this.h = 0;
        this.i = NaNf;
        this.j = NaNf;
        this.k = NaNf;
        this.l = NaNf;
        this.m = 0;
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void a(HashMap hashMap0) {
        throw null;
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final c b() {
        c c0 = new j();
        c0.super.c(this);
        c0.f = this.f;
        c0.g = this.g;
        c0.h = this.h;
        c0.i = this.i;
        c0.j = NaNf;
        c0.k = this.k;
        c0.l = this.l;
        return c0;
    }

    @Override
    public final Object clone() {
        return this.b();
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void d(HashSet hashSet0) {
    }

    @Override  // androidx.constraintlayout.motion.widget.c
    public final void e(Context context0, AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.m);
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            SparseIntArray sparseIntArray0 = i.a;
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
                    this.f = typedArray0.peekValue(v2).type == 3 ? typedArray0.getString(v2) : e.d[typedArray0.getInteger(v2, 0)];
                    break;
                }
                case 4: {
                    this.e = typedArray0.getInteger(v2, this.e);
                    break;
                }
                case 5: {
                    this.h = typedArray0.getInt(v2, this.h);
                    break;
                }
                case 6: {
                    this.k = typedArray0.getFloat(v2, this.k);
                    break;
                }
                case 7: {
                    this.l = typedArray0.getFloat(v2, this.l);
                    break;
                }
                case 8: {
                    float f = typedArray0.getFloat(v2, this.j);
                    this.i = f;
                    this.j = f;
                    break;
                }
                case 9: {
                    this.m = typedArray0.getInt(v2, this.m);
                    break;
                }
                case 10: {
                    this.g = typedArray0.getInt(v2, this.g);
                    break;
                }
                case 11: {
                    this.i = typedArray0.getFloat(v2, this.i);
                    break;
                }
                case 12: {
                    this.j = typedArray0.getFloat(v2, this.j);
                    break;
                }
                default: {
                    Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(v2) + "   " + sparseIntArray0.get(v2));
                }
            }
        }
        if(this.a == -1) {
            Log.e("KeyPosition", "no frame position");
        }
    }

    public final void h(Object object0, String s) {
        switch(s) {
            case "drawPath": {
                this.h = ((Number)object0) instanceof Integer ? ((int)(((Integer)(((Number)object0))))) : Integer.parseInt(((Number)object0).toString());
                return;
            }
            case "percentHeight": {
                this.j = c.g(((Number)object0));
                return;
            }
            case "percentWidth": {
                this.i = c.g(((Number)object0));
                return;
            }
            case "percentX": {
                this.k = c.g(((Number)object0));
                return;
            }
            case "percentY": {
                this.l = c.g(((Number)object0));
                return;
            }
            case "sizePercent": {
                float f = c.g(((Number)object0));
                this.i = f;
                this.j = f;
                return;
            }
            case "transitionEasing": {
                this.f = object0.toString();
            }
        }
    }
}

