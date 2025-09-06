package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.motion.widget.j;
import androidx.constraintlayout.motion.widget.q;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;

public class MotionEffect extends MotionHelper {
    public int B;
    public boolean D;
    public int E;
    public int G;
    public float n;
    public int o;
    public int r;
    public int w;

    public MotionEffect(Context context0) {
        super(context0);
        this.n = 0.1f;
        this.o = 49;
        this.r = 50;
        this.w = 0;
        this.B = 0;
        this.D = true;
        this.E = -1;
        this.G = -1;
    }

    public MotionEffect(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.n = 0.1f;
        this.o = 49;
        this.r = 50;
        this.w = 0;
        this.B = 0;
        this.D = true;
        this.E = -1;
        this.G = -1;
        this.r(context0, attributeSet0);
    }

    public MotionEffect(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.n = 0.1f;
        this.o = 49;
        this.r = 50;
        this.w = 0;
        this.B = 0;
        this.D = true;
        this.E = -1;
        this.G = -1;
        this.r(context0, attributeSet0);
    }

    @Override  // androidx.constraintlayout.motion.widget.MotionHelper
    public final void q(MotionLayout motionLayout0, HashMap hashMap0) {
        int v7;
        int[] arr_v1;
        e e5;
        e e4;
        e e3;
        View[] arr_view = this.i(((ConstraintLayout)this.getParent()));
        if(arr_view == null) {
            Log.v("FadeMove", ".(null:-1) q() views = null");
            return;
        }
        e e0 = new e();
        e e1 = new e();
        e0.h(this.n, "alpha");
        e1.h(this.n, "alpha");
        int v1 = this.o;
        e0.a = v1;
        e1.a = this.r;
        j j0 = new j();
        j0.a = v1;
        j0.m = 0;
        j0.h(0, "percentX");
        j0.h(0, "percentY");
        j j1 = new j();
        j1.a = this.r;
        j1.m = 0;
        j1.h(1, "percentX");
        j1.h(1, "percentY");
        e e2 = null;
        if(this.w > 0) {
            e3 = new e();
            e4 = new e();
            e3.h(this.w, "translationX");
            e3.a = this.r;
            e4.h(0, "translationX");
            e4.a = this.r - 1;
        }
        else {
            e3 = null;
            e4 = null;
        }
        if(this.B > 0) {
            e2 = new e();
            e5 = new e();
            e2.h(this.B, "translationY");
            e2.a = this.r;
            e5.h(0, "translationY");
            e5.a = this.r - 1;
        }
        else {
            e5 = null;
        }
        int v2 = this.G;
        if(v2 == -1) {
            int[] arr_v = new int[4];
            int v3 = 0;
            while(v3 < arr_view.length) {
                q q0 = (q)hashMap0.get(arr_view[v3]);
                if(q0 == null) {
                    arr_v1 = arr_v;
                }
                else {
                    arr_v1 = arr_v;
                    float f = q0.g.e - q0.f.e;
                    float f1 = q0.g.f - q0.f.f;
                    if(f1 < 0.0f) {
                        ++arr_v1[1];
                    }
                    if(f1 > 0.0f) {
                        ++arr_v1[0];
                    }
                    if(f > 0.0f) {
                        ++arr_v1[3];
                    }
                    if(f < 0.0f) {
                        ++arr_v1[2];
                    }
                }
                ++v3;
                arr_v = arr_v1;
            }
            int v4 = arr_v[0];
            v2 = 0;
            for(int v = 1; v < 4; ++v) {
                int v5 = arr_v[v];
                if(v4 < v5) {
                    v2 = v;
                    v4 = v5;
                }
            }
        }
        int v6 = 0;
        while(v6 < arr_view.length) {
            q q1 = (q)hashMap0.get(arr_view[v6]);
            if(q1 == null) {
                v7 = v6;
            }
            else {
                v7 = v6;
                float f2 = q1.g.e - q1.f.e;
                float f3 = q1.g.f - q1.f.f;
                if(v2 == 0) {
                    if(f3 <= 0.0f || this.D && f2 != 0.0f) {
                        goto label_93;
                    }
                    else {
                        goto label_107;
                    }
                    goto label_86;
                }
                else {
                label_86:
                    switch(v2) {
                        case 1: {
                            if(f3 >= 0.0f || this.D && f2 != 0.0f) {
                                goto label_93;
                            }
                            else {
                                break;
                            }
                            goto label_90;
                        }
                        case 2: {
                        label_90:
                            if(f2 >= 0.0f || this.D && f3 != 0.0f) {
                                goto label_93;
                            }
                            break;
                        }
                        case 3: {
                            if(f2 <= 0.0f || this.D && f3 != 0.0f) {
                            label_93:
                                int v8 = this.E;
                                if(v8 == -1) {
                                    q1.a(e0);
                                    q1.a(e1);
                                    q1.a(j0);
                                    q1.a(j1);
                                    if(this.w > 0) {
                                        q1.a(e3);
                                        q1.a(e4);
                                    }
                                    if(this.B > 0) {
                                        q1.a(e2);
                                        q1.a(e5);
                                    }
                                }
                                else {
                                    motionLayout0.applyViewTransition(v8, q1);
                                }
                            }
                            break;
                        }
                        default: {
                            goto label_93;
                        }
                    }
                }
            }
        label_107:
            v6 = v7 + 1;
        }
    }

    public final void r(Context context0, AttributeSet attributeSet0) {
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, androidx.constraintlayout.widget.q.s);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                switch(typedArray0.getIndex(v1)) {
                    case 0: {
                        this.n = typedArray0.getFloat(0, this.n);
                        break;
                    }
                    case 1: {
                        this.r = Math.max(Math.min(typedArray0.getInt(1, this.r), 99), 0);
                        break;
                    }
                    case 2: {
                        this.G = typedArray0.getInt(2, this.G);
                        break;
                    }
                    case 3: {
                        this.o = Math.max(Math.min(typedArray0.getInt(3, this.o), 99), 0);
                        break;
                    }
                    case 4: {
                        this.D = typedArray0.getBoolean(4, this.D);
                        break;
                    }
                    case 5: {
                        this.w = typedArray0.getDimensionPixelOffset(5, this.w);
                        break;
                    }
                    case 6: {
                        this.B = typedArray0.getDimensionPixelOffset(6, this.B);
                        break;
                    }
                    case 7: {
                        this.E = typedArray0.getResourceId(7, this.E);
                    }
                }
            }
            int v2 = this.o;
            int v3 = this.r;
            if(v2 == v3) {
                if(v2 > 0) {
                    this.o = v2 - 1;
                }
                else {
                    this.r = v3 + 1;
                }
            }
            typedArray0.recycle();
        }
    }
}

