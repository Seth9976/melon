package androidx.constraintlayout.widget;

import F1.e;
import F1.f;
import F1.i;
import F1.j;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ConstraintLayout extends ViewGroup {
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public final int C;
        public final int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;
        public int a;
        public boolean a0;
        public int b;
        public boolean b0;
        public float c;
        public boolean c0;
        public final boolean d;
        public boolean d0;
        public int e;
        public boolean e0;
        public int f;
        public boolean f0;
        public int g;
        public int g0;
        public int h;
        public int h0;
        public int i;
        public int i0;
        public int j;
        public int j0;
        public int k;
        public int k0;
        public int l;
        public int l0;
        public int m;
        public float m0;
        public int n;
        public int n0;
        public int o;
        public int o0;
        public int p;
        public float p0;
        public int q;
        public e q0;
        public float r;
        public int s;
        public int t;
        public int u;
        public int v;
        public final int w;
        public int x;
        public final int y;
        public int z;

        public LayoutParams(int v, int v1) {
            super(v, v1);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = 0x80000000;
            this.x = 0x80000000;
            this.y = 0x80000000;
            this.z = 0x80000000;
            this.A = 0x80000000;
            this.B = 0x80000000;
            this.C = 0x80000000;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = 0x80000000;
            this.l0 = 0x80000000;
            this.m0 = 0.5f;
            this.q0 = new e();
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = 0x80000000;
            this.x = 0x80000000;
            this.y = 0x80000000;
            this.z = 0x80000000;
            this.A = 0x80000000;
            this.B = 0x80000000;
            this.C = 0x80000000;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = 0x80000000;
            this.l0 = 0x80000000;
            this.m0 = 0.5f;
            this.q0 = new e();
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.c);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                switch(b.a.get(v2)) {
                    case 1: {
                        this.V = typedArray0.getInt(v2, this.V);
                        break;
                    }
                    case 2: {
                        int v3 = typedArray0.getResourceId(v2, this.p);
                        this.p = v3;
                        if(v3 == -1) {
                            this.p = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 3: {
                        this.q = typedArray0.getDimensionPixelSize(v2, this.q);
                        break;
                    }
                    case 4: {
                        float f = typedArray0.getFloat(v2, this.r) % 360.0f;
                        this.r = f;
                        if(f < 0.0f) {
                            this.r = (360.0f - f) % 360.0f;
                        }
                        break;
                    }
                    case 5: {
                        this.a = typedArray0.getDimensionPixelOffset(v2, this.a);
                        break;
                    }
                    case 6: {
                        this.b = typedArray0.getDimensionPixelOffset(v2, this.b);
                        break;
                    }
                    case 7: {
                        this.c = typedArray0.getFloat(v2, this.c);
                        break;
                    }
                    case 8: {
                        int v4 = typedArray0.getResourceId(v2, this.e);
                        this.e = v4;
                        if(v4 == -1) {
                            this.e = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 9: {
                        int v5 = typedArray0.getResourceId(v2, this.f);
                        this.f = v5;
                        if(v5 == -1) {
                            this.f = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 10: {
                        int v6 = typedArray0.getResourceId(v2, this.g);
                        this.g = v6;
                        if(v6 == -1) {
                            this.g = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 11: {
                        int v7 = typedArray0.getResourceId(v2, this.h);
                        this.h = v7;
                        if(v7 == -1) {
                            this.h = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 12: {
                        int v8 = typedArray0.getResourceId(v2, this.i);
                        this.i = v8;
                        if(v8 == -1) {
                            this.i = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 13: {
                        int v9 = typedArray0.getResourceId(v2, this.j);
                        this.j = v9;
                        if(v9 == -1) {
                            this.j = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 14: {
                        int v10 = typedArray0.getResourceId(v2, this.k);
                        this.k = v10;
                        if(v10 == -1) {
                            this.k = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 15: {
                        int v11 = typedArray0.getResourceId(v2, this.l);
                        this.l = v11;
                        if(v11 == -1) {
                            this.l = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 16: {
                        int v12 = typedArray0.getResourceId(v2, this.m);
                        this.m = v12;
                        if(v12 == -1) {
                            this.m = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 17: {
                        int v13 = typedArray0.getResourceId(v2, this.s);
                        this.s = v13;
                        if(v13 == -1) {
                            this.s = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 18: {
                        int v14 = typedArray0.getResourceId(v2, this.t);
                        this.t = v14;
                        if(v14 == -1) {
                            this.t = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 19: {
                        int v15 = typedArray0.getResourceId(v2, this.u);
                        this.u = v15;
                        if(v15 == -1) {
                            this.u = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 20: {
                        int v16 = typedArray0.getResourceId(v2, this.v);
                        this.v = v16;
                        if(v16 == -1) {
                            this.v = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 21: {
                        this.w = typedArray0.getDimensionPixelSize(v2, this.w);
                        break;
                    }
                    case 22: {
                        this.x = typedArray0.getDimensionPixelSize(v2, this.x);
                        break;
                    }
                    case 23: {
                        this.y = typedArray0.getDimensionPixelSize(v2, this.y);
                        break;
                    }
                    case 24: {
                        this.z = typedArray0.getDimensionPixelSize(v2, this.z);
                        break;
                    }
                    case 25: {
                        this.A = typedArray0.getDimensionPixelSize(v2, this.A);
                        break;
                    }
                    case 26: {
                        this.B = typedArray0.getDimensionPixelSize(v2, this.B);
                        break;
                    }
                    case 27: {
                        this.W = typedArray0.getBoolean(v2, this.W);
                        break;
                    }
                    case 28: {
                        this.X = typedArray0.getBoolean(v2, this.X);
                        break;
                    }
                    case 29: {
                        this.E = typedArray0.getFloat(v2, this.E);
                        break;
                    }
                    case 30: {
                        this.F = typedArray0.getFloat(v2, this.F);
                        break;
                    }
                    case 0x1F: {
                        int v17 = typedArray0.getInt(v2, 0);
                        this.L = v17;
                        if(v17 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    }
                    case 0x20: {
                        int v18 = typedArray0.getInt(v2, 0);
                        this.M = v18;
                        if(v18 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    }
                    case 33: {
                        try {
                            this.N = typedArray0.getDimensionPixelSize(v2, this.N);
                        }
                        catch(Exception unused_ex) {
                            if(typedArray0.getInt(v2, this.N) == -2) {
                                this.N = -2;
                            }
                        }
                        break;
                    }
                    case 34: {
                        try {
                            this.P = typedArray0.getDimensionPixelSize(v2, this.P);
                        }
                        catch(Exception unused_ex) {
                            if(typedArray0.getInt(v2, this.P) == -2) {
                                this.P = -2;
                            }
                        }
                        break;
                    }
                    case 35: {
                        this.R = Math.max(0.0f, typedArray0.getFloat(v2, this.R));
                        this.L = 2;
                        break;
                    }
                    case 36: {
                        try {
                            this.O = typedArray0.getDimensionPixelSize(v2, this.O);
                        }
                        catch(Exception unused_ex) {
                            if(typedArray0.getInt(v2, this.O) == -2) {
                                this.O = -2;
                            }
                        }
                        break;
                    }
                    case 37: {
                        try {
                            this.Q = typedArray0.getDimensionPixelSize(v2, this.Q);
                        }
                        catch(Exception unused_ex) {
                            if(typedArray0.getInt(v2, this.Q) == -2) {
                                this.Q = -2;
                            }
                        }
                        break;
                    }
                    case 38: {
                        this.S = Math.max(0.0f, typedArray0.getFloat(v2, this.S));
                        this.M = 2;
                        break;
                    }
                    case 44: {
                        n.r(this, typedArray0.getString(v2));
                        break;
                    }
                    case 45: {
                        this.H = typedArray0.getFloat(v2, this.H);
                        break;
                    }
                    case 46: {
                        this.I = typedArray0.getFloat(v2, this.I);
                        break;
                    }
                    case 0x2F: {
                        this.J = typedArray0.getInt(v2, 0);
                        break;
                    }
                    case 0x30: {
                        this.K = typedArray0.getInt(v2, 0);
                        break;
                    }
                    case 49: {
                        this.T = typedArray0.getDimensionPixelOffset(v2, this.T);
                        break;
                    }
                    case 50: {
                        this.U = typedArray0.getDimensionPixelOffset(v2, this.U);
                        break;
                    }
                    case 51: {
                        this.Y = typedArray0.getString(v2);
                        break;
                    }
                    case 52: {
                        int v19 = typedArray0.getResourceId(v2, this.n);
                        this.n = v19;
                        if(v19 == -1) {
                            this.n = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 53: {
                        int v20 = typedArray0.getResourceId(v2, this.o);
                        this.o = v20;
                        if(v20 == -1) {
                            this.o = typedArray0.getInt(v2, -1);
                        }
                        break;
                    }
                    case 54: {
                        this.D = typedArray0.getDimensionPixelSize(v2, this.D);
                        break;
                    }
                    case 55: {
                        this.C = typedArray0.getDimensionPixelSize(v2, this.C);
                        break;
                    }
                    case 0x40: {
                        n.q(this, typedArray0, v2, 0);
                        break;
                    }
                    case 65: {
                        n.q(this, typedArray0, v2, 1);
                        break;
                    }
                    case 66: {
                        this.Z = typedArray0.getInt(v2, this.Z);
                        break;
                    }
                    case 67: {
                        this.d = typedArray0.getBoolean(v2, this.d);
                    }
                }
            }
            typedArray0.recycle();
            this.a();
        }

        public LayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
            super(viewGroup$LayoutParams0);
            this.a = -1;
            this.b = -1;
            this.c = -1.0f;
            this.d = true;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = 0x80000000;
            this.x = 0x80000000;
            this.y = 0x80000000;
            this.z = 0x80000000;
            this.A = 0x80000000;
            this.B = 0x80000000;
            this.C = 0x80000000;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = 0x80000000;
            this.l0 = 0x80000000;
            this.m0 = 0.5f;
            this.q0 = new e();
            if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                this.leftMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin;
                this.rightMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin;
                this.topMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin;
                this.bottomMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin;
                this.setMarginStart(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).getMarginStart());
                this.setMarginEnd(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).getMarginEnd());
            }
            if(!(viewGroup$LayoutParams0 instanceof LayoutParams)) {
                return;
            }
            LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)viewGroup$LayoutParams0;
            this.a = constraintLayout$LayoutParams0.a;
            this.b = constraintLayout$LayoutParams0.b;
            this.c = constraintLayout$LayoutParams0.c;
            this.d = constraintLayout$LayoutParams0.d;
            this.e = constraintLayout$LayoutParams0.e;
            this.f = constraintLayout$LayoutParams0.f;
            this.g = constraintLayout$LayoutParams0.g;
            this.h = constraintLayout$LayoutParams0.h;
            this.i = constraintLayout$LayoutParams0.i;
            this.j = constraintLayout$LayoutParams0.j;
            this.k = constraintLayout$LayoutParams0.k;
            this.l = constraintLayout$LayoutParams0.l;
            this.m = constraintLayout$LayoutParams0.m;
            this.n = constraintLayout$LayoutParams0.n;
            this.o = constraintLayout$LayoutParams0.o;
            this.p = constraintLayout$LayoutParams0.p;
            this.q = constraintLayout$LayoutParams0.q;
            this.r = constraintLayout$LayoutParams0.r;
            this.s = constraintLayout$LayoutParams0.s;
            this.t = constraintLayout$LayoutParams0.t;
            this.u = constraintLayout$LayoutParams0.u;
            this.v = constraintLayout$LayoutParams0.v;
            this.w = constraintLayout$LayoutParams0.w;
            this.x = constraintLayout$LayoutParams0.x;
            this.y = constraintLayout$LayoutParams0.y;
            this.z = constraintLayout$LayoutParams0.z;
            this.A = constraintLayout$LayoutParams0.A;
            this.B = constraintLayout$LayoutParams0.B;
            this.C = constraintLayout$LayoutParams0.C;
            this.D = constraintLayout$LayoutParams0.D;
            this.E = constraintLayout$LayoutParams0.E;
            this.F = constraintLayout$LayoutParams0.F;
            this.G = constraintLayout$LayoutParams0.G;
            this.H = constraintLayout$LayoutParams0.H;
            this.I = constraintLayout$LayoutParams0.I;
            this.J = constraintLayout$LayoutParams0.J;
            this.K = constraintLayout$LayoutParams0.K;
            this.W = constraintLayout$LayoutParams0.W;
            this.X = constraintLayout$LayoutParams0.X;
            this.L = constraintLayout$LayoutParams0.L;
            this.M = constraintLayout$LayoutParams0.M;
            this.N = constraintLayout$LayoutParams0.N;
            this.P = constraintLayout$LayoutParams0.P;
            this.O = constraintLayout$LayoutParams0.O;
            this.Q = constraintLayout$LayoutParams0.Q;
            this.R = constraintLayout$LayoutParams0.R;
            this.S = constraintLayout$LayoutParams0.S;
            this.T = constraintLayout$LayoutParams0.T;
            this.U = constraintLayout$LayoutParams0.U;
            this.V = constraintLayout$LayoutParams0.V;
            this.a0 = constraintLayout$LayoutParams0.a0;
            this.b0 = constraintLayout$LayoutParams0.b0;
            this.c0 = constraintLayout$LayoutParams0.c0;
            this.d0 = constraintLayout$LayoutParams0.d0;
            this.g0 = constraintLayout$LayoutParams0.g0;
            this.h0 = constraintLayout$LayoutParams0.h0;
            this.i0 = constraintLayout$LayoutParams0.i0;
            this.j0 = constraintLayout$LayoutParams0.j0;
            this.k0 = constraintLayout$LayoutParams0.k0;
            this.l0 = constraintLayout$LayoutParams0.l0;
            this.m0 = constraintLayout$LayoutParams0.m0;
            this.Y = constraintLayout$LayoutParams0.Y;
            this.Z = constraintLayout$LayoutParams0.Z;
            this.q0 = constraintLayout$LayoutParams0.q0;
        }

        public final void a() {
            this.d0 = false;
            this.a0 = true;
            this.b0 = true;
            int v = this.width;
            if(v == -2 && this.W) {
                this.a0 = false;
                if(this.L == 0) {
                    this.L = 1;
                }
            }
            int v1 = this.height;
            if(v1 == -2 && this.X) {
                this.b0 = false;
                if(this.M == 0) {
                    this.M = 1;
                }
            }
            if(v == -1 || v == 0) {
                this.a0 = false;
                if(v == 0 && this.L == 1) {
                    this.width = -2;
                    this.W = true;
                }
            }
            if(v1 == -1 || v1 == 0) {
                this.b0 = false;
                if(v1 == 0 && this.M == 1) {
                    this.height = -2;
                    this.X = true;
                }
            }
            if(this.c == -1.0f && this.a == -1 && this.b == -1) {
                return;
            }
            this.d0 = true;
            this.a0 = true;
            this.b0 = true;
            if(!(this.q0 instanceof i)) {
                this.q0 = new i();
            }
            ((i)this.q0).X(this.V);
        }

        @Override  // android.view.ViewGroup$MarginLayoutParams
        public final void resolveLayoutDirection(int v) {
            int v1 = this.leftMargin;
            int v2 = this.rightMargin;
            super.resolveLayoutDirection(v);
            boolean z = false;
            boolean z1 = 1 == this.getLayoutDirection();
            this.i0 = -1;
            this.j0 = -1;
            this.g0 = -1;
            this.h0 = -1;
            this.k0 = this.w;
            this.l0 = this.y;
            float f = this.E;
            this.m0 = f;
            int v3 = this.a;
            this.n0 = v3;
            int v4 = this.b;
            this.o0 = v4;
            float f1 = this.c;
            this.p0 = f1;
            if(z1) {
                int v5 = this.s;
                if(v5 == -1) {
                    int v6 = this.t;
                    if(v6 != -1) {
                        this.j0 = v6;
                        z = true;
                    }
                }
                else {
                    this.i0 = v5;
                    z = true;
                }
                int v7 = this.u;
                if(v7 != -1) {
                    this.h0 = v7;
                    z = true;
                }
                int v8 = this.v;
                if(v8 != -1) {
                    this.g0 = v8;
                    z = true;
                }
                int v9 = this.A;
                if(v9 != 0x80000000) {
                    this.l0 = v9;
                }
                int v10 = this.B;
                if(v10 != 0x80000000) {
                    this.k0 = v10;
                }
                if(z) {
                    this.m0 = 1.0f - f;
                }
                if(this.d0 && this.V == 1 && this.d) {
                    if(f1 != -1.0f) {
                        this.p0 = 1.0f - f1;
                        this.n0 = -1;
                        this.o0 = -1;
                    }
                    else if(v3 != -1) {
                        this.o0 = v3;
                        this.n0 = -1;
                        this.p0 = -1.0f;
                    }
                    else if(v4 != -1) {
                        this.n0 = v4;
                        this.o0 = -1;
                        this.p0 = -1.0f;
                    }
                }
            }
            else {
                int v11 = this.s;
                if(v11 != -1) {
                    this.h0 = v11;
                }
                int v12 = this.t;
                if(v12 != -1) {
                    this.g0 = v12;
                }
                int v13 = this.u;
                if(v13 != -1) {
                    this.i0 = v13;
                }
                int v14 = this.v;
                if(v14 != -1) {
                    this.j0 = v14;
                }
                int v15 = this.A;
                if(v15 != 0x80000000) {
                    this.k0 = v15;
                }
                int v16 = this.B;
                if(v16 != 0x80000000) {
                    this.l0 = v16;
                }
            }
            if(this.u == -1 && this.v == -1 && this.t == -1 && this.s == -1) {
                int v17 = this.g;
                if(v17 == -1) {
                    int v18 = this.h;
                    if(v18 != -1) {
                        this.j0 = v18;
                        if(this.rightMargin <= 0 && v2 > 0) {
                            this.rightMargin = v2;
                        }
                    }
                }
                else {
                    this.i0 = v17;
                    if(this.rightMargin <= 0 && v2 > 0) {
                        this.rightMargin = v2;
                    }
                }
                int v19 = this.e;
                if(v19 == -1) {
                    int v20 = this.f;
                    if(v20 != -1) {
                        this.h0 = v20;
                        if(this.leftMargin <= 0 && v1 > 0) {
                            this.leftMargin = v1;
                        }
                    }
                }
                else {
                    this.g0 = v19;
                    if(this.leftMargin <= 0 && v1 > 0) {
                        this.leftMargin = v1;
                    }
                }
            }
        }
    }

    public static final int DESIGN_INFO_ID = 0;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";
    public final SparseArray a;
    public final ArrayList b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public n h;
    public int i;
    public HashMap j;
    public final SparseArray k;
    public final c l;
    public ArrayList m;
    protected g mConstraintLayoutSpec;
    protected boolean mDirtyHierarchy;
    protected f mLayoutWidget;
    public static s n;

    public ConstraintLayout(Context context0) {
        super(context0);
        this.a = new SparseArray();
        this.b = new ArrayList(4);
        this.mLayoutWidget = new f();
        this.c = 0;
        this.d = 0;
        this.e = 0x7FFFFFFF;
        this.f = 0x7FFFFFFF;
        this.mDirtyHierarchy = true;
        this.g = 0x101;
        this.h = null;
        this.mConstraintLayoutSpec = null;
        this.i = -1;
        this.j = new HashMap();
        this.k = new SparseArray();
        this.l = new c(this, this);
        this.a(null, 0);
    }

    public ConstraintLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new SparseArray();
        this.b = new ArrayList(4);
        this.mLayoutWidget = new f();
        this.c = 0;
        this.d = 0;
        this.e = 0x7FFFFFFF;
        this.f = 0x7FFFFFFF;
        this.mDirtyHierarchy = true;
        this.g = 0x101;
        this.h = null;
        this.mConstraintLayoutSpec = null;
        this.i = -1;
        this.j = new HashMap();
        this.k = new SparseArray();
        this.l = new c(this, this);
        this.a(attributeSet0, 0);
    }

    public ConstraintLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new SparseArray();
        this.b = new ArrayList(4);
        this.mLayoutWidget = new f();
        this.c = 0;
        this.d = 0;
        this.e = 0x7FFFFFFF;
        this.f = 0x7FFFFFFF;
        this.mDirtyHierarchy = true;
        this.g = 0x101;
        this.h = null;
        this.mConstraintLayoutSpec = null;
        this.i = -1;
        this.j = new HashMap();
        this.k = new SparseArray();
        this.l = new c(this, this);
        this.a(attributeSet0, v);
    }

    public final void a(AttributeSet attributeSet0, int v) {
        this.mLayoutWidget.i0 = this;
        this.mLayoutWidget.z0 = this.l;
        this.mLayoutWidget.x0.g = this.l;
        int v1 = this.getId();
        this.a.put(v1, this);
        this.h = null;
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.c, v, 0);
            int v2 = typedArray0.getIndexCount();
            for(int v3 = 0; v3 < v2; ++v3) {
                switch(typedArray0.getIndex(v3)) {
                    case 14: {
                        this.e = typedArray0.getDimensionPixelOffset(14, this.e);
                        break;
                    }
                    case 15: {
                        this.f = typedArray0.getDimensionPixelOffset(15, this.f);
                        break;
                    }
                    case 16: {
                        this.c = typedArray0.getDimensionPixelOffset(16, this.c);
                        break;
                    }
                    case 17: {
                        this.d = typedArray0.getDimensionPixelOffset(17, this.d);
                        break;
                    }
                    case 34: {
                        int v5 = typedArray0.getResourceId(34, 0);
                        try {
                            n n0 = new n();
                            this.h = n0;
                            n0.n(this.getContext(), v5);
                        }
                        catch(Resources.NotFoundException unused_ex) {
                            this.h = null;
                        }
                        this.i = v5;
                        break;
                    }
                    case 56: {
                        int v4 = typedArray0.getResourceId(56, 0);
                        if(v4 != 0) {
                            try {
                                this.parseLayoutDescription(v4);
                            }
                            catch(Resources.NotFoundException unused_ex) {
                                this.mConstraintLayoutSpec = null;
                            }
                        }
                        break;
                    }
                    case 0x71: {
                        this.g = typedArray0.getInt(0x71, this.g);
                    }
                }
            }
            typedArray0.recycle();
        }
        this.mLayoutWidget.I0 = this.g;
        y1.c.q = this.mLayoutWidget.d0(0x200);
    }

    public void addValueModifier(d d0) {
        if(this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(d0);
    }

    public void applyConstraintsFromLayoutParams(boolean z, View view0, e e0, LayoutParams constraintLayout$LayoutParams0, SparseArray sparseArray0) {
        constraintLayout$LayoutParams0.a();
        e0.j0 = view0.getVisibility();
        if(constraintLayout$LayoutParams0.f0) {
            e0.G = true;
            e0.j0 = 8;
        }
        e0.i0 = view0;
        if(view0 instanceof ConstraintHelper) {
            ((ConstraintHelper)view0).l(e0, this.mLayoutWidget.A0);
        }
        if(constraintLayout$LayoutParams0.d0) {
            int v = constraintLayout$LayoutParams0.n0;
            int v1 = constraintLayout$LayoutParams0.o0;
            float f = constraintLayout$LayoutParams0.p0;
            int v2 = Float.compare(f, -1.0f);
            if(v2 != 0) {
                if(v2 > 0) {
                    ((i)e0).v0 = f;
                    ((i)e0).w0 = -1;
                    ((i)e0).x0 = -1;
                    return;
                }
            }
            else if(v != -1) {
                if(v > -1) {
                    ((i)e0).v0 = -1.0f;
                    ((i)e0).w0 = v;
                    ((i)e0).x0 = -1;
                    return;
                }
            }
            else if(v1 != -1 && v1 > -1) {
                ((i)e0).v0 = -1.0f;
                ((i)e0).w0 = -1;
                ((i)e0).x0 = v1;
            }
            return;
        }
        int v3 = constraintLayout$LayoutParams0.g0;
        int v4 = constraintLayout$LayoutParams0.h0;
        int v5 = constraintLayout$LayoutParams0.i0;
        int v6 = constraintLayout$LayoutParams0.j0;
        int v7 = constraintLayout$LayoutParams0.k0;
        int v8 = constraintLayout$LayoutParams0.l0;
        float f1 = constraintLayout$LayoutParams0.m0;
        int v9 = constraintLayout$LayoutParams0.p;
        if(v9 == -1) {
            if(v3 != -1) {
                Object object1 = sparseArray0.get(v3);
                if(((e)object1) != null) {
                    e0.x(2, 2, constraintLayout$LayoutParams0.leftMargin, v7, ((e)object1));
                }
            }
            else if(v4 != -1) {
                Object object2 = sparseArray0.get(v4);
                if(((e)object2) != null) {
                    e0.x(2, 4, constraintLayout$LayoutParams0.leftMargin, v7, ((e)object2));
                }
            }
            if(v5 != -1) {
                Object object3 = sparseArray0.get(v5);
                if(((e)object3) != null) {
                    e0.x(4, 2, constraintLayout$LayoutParams0.rightMargin, v8, ((e)object3));
                }
            }
            else if(v6 != -1) {
                Object object4 = sparseArray0.get(v6);
                if(((e)object4) != null) {
                    e0.x(4, 4, constraintLayout$LayoutParams0.rightMargin, v8, ((e)object4));
                }
            }
            int v10 = constraintLayout$LayoutParams0.i;
            if(v10 == -1) {
                int v11 = constraintLayout$LayoutParams0.j;
                if(v11 != -1) {
                    Object object6 = sparseArray0.get(v11);
                    if(((e)object6) != null) {
                        e0.x(3, 5, constraintLayout$LayoutParams0.topMargin, constraintLayout$LayoutParams0.x, ((e)object6));
                    }
                }
            }
            else {
                Object object5 = sparseArray0.get(v10);
                if(((e)object5) != null) {
                    e0.x(3, 3, constraintLayout$LayoutParams0.topMargin, constraintLayout$LayoutParams0.x, ((e)object5));
                }
            }
            int v12 = constraintLayout$LayoutParams0.k;
            if(v12 == -1) {
                int v13 = constraintLayout$LayoutParams0.l;
                if(v13 != -1) {
                    Object object8 = sparseArray0.get(v13);
                    if(((e)object8) != null) {
                        e0.x(5, 5, constraintLayout$LayoutParams0.bottomMargin, constraintLayout$LayoutParams0.z, ((e)object8));
                    }
                }
            }
            else {
                Object object7 = sparseArray0.get(v12);
                if(((e)object7) != null) {
                    e0.x(5, 3, constraintLayout$LayoutParams0.bottomMargin, constraintLayout$LayoutParams0.z, ((e)object7));
                }
            }
            int v14 = constraintLayout$LayoutParams0.m;
            if(v14 == -1) {
                int v15 = constraintLayout$LayoutParams0.n;
                if(v15 == -1) {
                    int v16 = constraintLayout$LayoutParams0.o;
                    if(v16 != -1) {
                        this.b(e0, constraintLayout$LayoutParams0, sparseArray0, v16, 5);
                    }
                }
                else {
                    this.b(e0, constraintLayout$LayoutParams0, sparseArray0, v15, 3);
                }
            }
            else {
                this.b(e0, constraintLayout$LayoutParams0, sparseArray0, v14, 6);
            }
            if(f1 >= 0.0f) {
                e0.g0 = f1;
            }
            float f3 = constraintLayout$LayoutParams0.F;
            if(f3 >= 0.0f) {
                e0.h0 = f3;
            }
        }
        else {
            Object object0 = sparseArray0.get(v9);
            if(((e)object0) != null) {
                float f2 = constraintLayout$LayoutParams0.r;
                e0.x(7, 7, constraintLayout$LayoutParams0.q, 0, ((e)object0));
                e0.E = f2;
            }
        }
        if(z) {
            int v17 = constraintLayout$LayoutParams0.T;
            if(v17 != -1 || constraintLayout$LayoutParams0.U != -1) {
                e0.b0 = v17;
                e0.c0 = constraintLayout$LayoutParams0.U;
            }
        }
        F1.d d0 = F1.d.b;
        F1.d d1 = F1.d.a;
        F1.d d2 = F1.d.d;
        F1.d d3 = F1.d.c;
        if(constraintLayout$LayoutParams0.a0) {
            e0.P(d1);
            e0.T(constraintLayout$LayoutParams0.width);
            if(constraintLayout$LayoutParams0.width == -2) {
                e0.P(d0);
            }
        }
        else if(constraintLayout$LayoutParams0.width == -1) {
            if(constraintLayout$LayoutParams0.W) {
                e0.P(d3);
            }
            else {
                e0.P(d2);
            }
            F1.c c0 = e0.k(2);
            c0.g = constraintLayout$LayoutParams0.leftMargin;
            F1.c c1 = e0.k(4);
            c1.g = constraintLayout$LayoutParams0.rightMargin;
        }
        else {
            e0.P(d3);
            e0.T(0);
        }
        if(constraintLayout$LayoutParams0.b0) {
            e0.R(d1);
            e0.O(constraintLayout$LayoutParams0.height);
            if(constraintLayout$LayoutParams0.height == -2) {
                e0.R(d0);
            }
        }
        else if(constraintLayout$LayoutParams0.height == -1) {
            if(constraintLayout$LayoutParams0.X) {
                e0.R(d3);
            }
            else {
                e0.R(d2);
            }
            F1.c c2 = e0.k(3);
            c2.g = constraintLayout$LayoutParams0.topMargin;
            F1.c c3 = e0.k(5);
            c3.g = constraintLayout$LayoutParams0.bottomMargin;
        }
        else {
            e0.R(d3);
            e0.O(0);
        }
        e0.L(constraintLayout$LayoutParams0.G);
        e0.o0[0] = constraintLayout$LayoutParams0.H;
        e0.o0[1] = constraintLayout$LayoutParams0.I;
        e0.m0 = constraintLayout$LayoutParams0.J;
        e0.n0 = constraintLayout$LayoutParams0.K;
        int v18 = constraintLayout$LayoutParams0.Z;
        if(v18 >= 0 && v18 <= 3) {
            e0.r = v18;
        }
        e0.Q(constraintLayout$LayoutParams0.L, constraintLayout$LayoutParams0.R, constraintLayout$LayoutParams0.N, constraintLayout$LayoutParams0.P);
        e0.S(constraintLayout$LayoutParams0.M, constraintLayout$LayoutParams0.S, constraintLayout$LayoutParams0.O, constraintLayout$LayoutParams0.Q);
    }

    public final void b(e e0, LayoutParams constraintLayout$LayoutParams0, SparseArray sparseArray0, int v, int v1) {
        View view0 = (View)this.a.get(v);
        e e1 = (e)sparseArray0.get(v);
        if(e1 != null && view0 != null && view0.getLayoutParams() instanceof LayoutParams) {
            constraintLayout$LayoutParams0.c0 = true;
            if(v1 == 6) {
                LayoutParams constraintLayout$LayoutParams1 = (LayoutParams)view0.getLayoutParams();
                constraintLayout$LayoutParams1.c0 = true;
                constraintLayout$LayoutParams1.q0.F = true;
            }
            e0.k(6).b(e1.k(v1), constraintLayout$LayoutParams0.D, constraintLayout$LayoutParams0.C, true);
            e0.F = true;
            e0.k(3).j();
            e0.k(5).j();
        }
    }

    @Override  // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // android.view.ViewGroup
    public void dispatchDraw(Canvas canvas0) {
        ArrayList arrayList0 = this.b;
        if(arrayList0 != null) {
            int v = arrayList0.size();
            if(v > 0) {
                for(int v1 = 0; v1 < v; ++v1) {
                    ((ConstraintHelper)arrayList0.get(v1)).n(this);
                }
            }
        }
        super.dispatchDraw(canvas0);
        if(this.isInEditMode()) {
            float f = (float)this.getWidth();
            float f1 = (float)this.getHeight();
            int v2 = this.getChildCount();
            for(int v3 = 0; v3 < v2; ++v3) {
                View view0 = this.getChildAt(v3);
                if(view0.getVisibility() != 8) {
                    Object object0 = view0.getTag();
                    if(object0 != null && object0 instanceof String) {
                        String[] arr_s = ((String)object0).split(",");
                        if(arr_s.length == 4) {
                            int v4 = Integer.parseInt(arr_s[0]);
                            int v5 = Integer.parseInt(arr_s[1]);
                            int v6 = Integer.parseInt(arr_s[2]);
                            int v7 = (int)(((float)v4) / 1080.0f * f);
                            int v8 = (int)(((float)v5) / 1920.0f * f1);
                            int v9 = (int)(((float)Integer.parseInt(arr_s[3])) / 1920.0f * f1);
                            Paint paint0 = new Paint();
                            paint0.setColor(0xFFFF0000);
                            float f2 = (float)(v7 + ((int)(((float)v6) / 1080.0f * f)));
                            canvas0.drawLine(((float)v7), ((float)v8), f2, ((float)v8), paint0);
                            float f3 = (float)(v8 + v9);
                            canvas0.drawLine(f2, ((float)v8), f2, f3, paint0);
                            canvas0.drawLine(f2, f3, ((float)v7), f3, paint0);
                            canvas0.drawLine(((float)v7), f3, ((float)v7), ((float)v8), paint0);
                            paint0.setColor(0xFF00FF00);
                            canvas0.drawLine(((float)v7), ((float)v8), f2, f3, paint0);
                            canvas0.drawLine(((float)v7), f3, f2, ((float)v8), paint0);
                        }
                    }
                }
            }
        }
    }

    public boolean dynamicUpdateConstraints(int v, int v1) {
        if(this.m != null) {
            View.MeasureSpec.getSize(v);
            View.MeasureSpec.getSize(v1);
            for(Object object0: this.m) {
                if(object0 != null) {
                    throw new ClassCastException();
                }
                Iterator iterator1 = this.mLayoutWidget.v0.iterator();
                if(!iterator1.hasNext()) {
                    continue;
                }
                Object object1 = iterator1.next();
                View view0 = (View)((e)object1).i0;
                view0.getId();
                LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                throw null;
            }
        }
        return false;
    }

    public void fillMetrics(y1.d d0) {
        this.mLayoutWidget.B0.getClass();
    }

    @Override  // android.view.View
    public void forceLayout() {
        this.mDirtyHierarchy = true;
        super.forceLayout();
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.generateLayoutParams(attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new LayoutParams(viewGroup$LayoutParams0);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    // 去混淆评级： 低(20)
    public Object getDesignInformation(int v, Object object0) {
        return v != 0 || !(object0 instanceof String) || (this.j == null || !this.j.containsKey(((String)object0))) ? null : this.j.get(((String)object0));
    }

    public int getMaxHeight() {
        return this.f;
    }

    public int getMaxWidth() {
        return this.e;
    }

    public int getMinHeight() {
        return this.d;
    }

    public int getMinWidth() {
        return this.c;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.I0;
    }

    private int getPaddingWidth() {
        int v = Math.max(0, this.getPaddingLeft());
        int v1 = Math.max(0, this.getPaddingRight());
        int v2 = Math.max(0, this.getPaddingStart());
        int v3 = Math.max(0, this.getPaddingEnd()) + v2;
        return v3 <= 0 ? v1 + v : v3;
    }

    public String getSceneString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(this.mLayoutWidget.k == null) {
            int v = this.getId();
            this.mLayoutWidget.k = v == -1 ? "parent" : this.getContext().getResources().getResourceEntryName(v);
        }
        f f0 = this.mLayoutWidget;
        if(f0.l0 == null) {
            f0.l0 = f0.k;
            Log.v("ConstraintLayout", " setDebugName " + this.mLayoutWidget.l0);
        }
        for(Object object0: this.mLayoutWidget.v0) {
            e e0 = (e)object0;
            View view0 = (View)e0.i0;
            if(view0 != null) {
                if(e0.k == null) {
                    int v1 = view0.getId();
                    if(v1 != -1) {
                        e0.k = this.getContext().getResources().getResourceEntryName(v1);
                    }
                }
                if(e0.l0 == null) {
                    e0.l0 = e0.k;
                    Log.v("ConstraintLayout", " setDebugName " + e0.l0);
                }
            }
        }
        this.mLayoutWidget.p(stringBuilder0);
        return stringBuilder0.toString();
    }

    public static s getSharedValues() {
        if(ConstraintLayout.n == null) {
            s s0 = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
            new SparseIntArray();
            s0.a = new HashMap();
            ConstraintLayout.n = s0;
        }
        return ConstraintLayout.n;
    }

    public View getViewById(int v) {
        return (View)this.a.get(v);
    }

    public final e getViewWidget(View view0) {
        if(view0 == this) {
            return this.mLayoutWidget;
        }
        if(view0 != null) {
            if(view0.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams)view0.getLayoutParams()).q0;
            }
            view0.setLayoutParams(this.generateLayoutParams(view0.getLayoutParams()));
            return view0.getLayoutParams() instanceof LayoutParams ? ((LayoutParams)view0.getLayoutParams()).q0 : null;
        }
        return null;
    }

    public boolean isRtl() {
        return (this.getContext().getApplicationInfo().flags & 0x400000) != 0 && 1 == this.getLayoutDirection();
    }

    public void loadLayoutDescription(int v) {
        try {
            this.mConstraintLayoutSpec = new g(this.getContext(), this, 0x7F160016);  // xml:video_controller_state
        }
        catch(Resources.NotFoundException unused_ex) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override  // android.view.ViewGroup
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getChildCount();
        boolean z1 = this.isInEditMode();
        for(int v6 = 0; v6 < v4; ++v6) {
            View view0 = this.getChildAt(v6);
            LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            e e0 = constraintLayout$LayoutParams0.q0;
            if((view0.getVisibility() != 8 || constraintLayout$LayoutParams0.d0 || constraintLayout$LayoutParams0.e0 || z1) && !constraintLayout$LayoutParams0.f0) {
                int v7 = e0.t();
                int v8 = e0.u();
                int v9 = e0.s() + v7;
                int v10 = e0.m() + v8;
                view0.layout(v7, v8, v9, v10);
                if(view0 instanceof Placeholder) {
                    View view1 = ((Placeholder)view0).getContent();
                    if(view1 != null) {
                        view1.setVisibility(0);
                        view1.layout(v7, v8, v9, v10);
                    }
                }
            }
        }
        ArrayList arrayList0 = this.b;
        int v11 = arrayList0.size();
        if(v11 > 0) {
            for(int v5 = 0; v5 < v11; ++v5) {
                ((ConstraintHelper)arrayList0.get(v5)).m();
            }
        }
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        e e1;
        int v2 = this.mDirtyHierarchy | this.dynamicUpdateConstraints(v, v1);
        this.mDirtyHierarchy = v2;
        if(v2 == 0) {
            int v3 = this.getChildCount();
            for(int v4 = 0; v4 < v3; ++v4) {
                if(this.getChildAt(v4).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
            }
        }
        f f0 = this.mLayoutWidget;
        f0.A0 = this.isRtl();
        if(this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            int v5 = this.getChildCount();
            for(int v6 = 0; true; ++v6) {
                boolean z = false;
                if(v6 >= v5) {
                    break;
                }
                if(this.getChildAt(v6).isLayoutRequested()) {
                    z = true;
                    break;
                }
            }
            if(z) {
                boolean z1 = this.isInEditMode();
                int v7 = this.getChildCount();
                for(int v8 = 0; v8 < v7; ++v8) {
                    e e0 = this.getViewWidget(this.getChildAt(v8));
                    if(e0 != null) {
                        e0.E();
                    }
                }
                if(z1) {
                    for(int v9 = 0; v9 < v7; ++v9) {
                        View view0 = this.getChildAt(v9);
                        try {
                            String s = this.getResources().getResourceName(view0.getId());
                            this.setDesignInformation(0, s, view0.getId());
                            int v10 = s.indexOf(0x2F);
                            if(v10 != -1) {
                                s = s.substring(v10 + 1);
                            }
                            int v11 = view0.getId();
                            if(v11 == 0) {
                                e1 = this.mLayoutWidget;
                            }
                            else {
                                View view1 = (View)this.a.get(v11);
                                if(view1 == null) {
                                    view1 = this.findViewById(v11);
                                    if(view1 != null && view1 != this && view1.getParent() == this) {
                                        this.onViewAdded(view1);
                                    }
                                }
                                if(view1 == this) {
                                    e1 = this.mLayoutWidget;
                                }
                                else {
                                    e1 = view1 == null ? null : ((LayoutParams)view1.getLayoutParams()).q0;
                                }
                            }
                            e1.l0 = s;
                        }
                        catch(Resources.NotFoundException unused_ex) {
                        }
                    }
                }
                if(this.i != -1) {
                    for(int v12 = 0; v12 < v7; ++v12) {
                        View view2 = this.getChildAt(v12);
                        if(view2.getId() == this.i && view2 instanceof Constraints) {
                            this.h = ((Constraints)view2).getConstraintSet();
                        }
                    }
                }
                n n0 = this.h;
                if(n0 != null) {
                    n0.c(this);
                }
                this.mLayoutWidget.v0.clear();
                ArrayList arrayList0 = this.b;
                int v13 = arrayList0.size();
                if(v13 > 0) {
                    for(int v14 = 0; v14 < v13; ++v14) {
                        ConstraintHelper constraintHelper0 = (ConstraintHelper)arrayList0.get(v14);
                        HashMap hashMap0 = constraintHelper0.i;
                        if(constraintHelper0.isInEditMode()) {
                            constraintHelper0.setIds(constraintHelper0.f);
                        }
                        j j0 = constraintHelper0.d;
                        if(j0 != null) {
                            j0.w0 = 0;
                            Arrays.fill(j0.v0, null);
                            for(int v15 = 0; v15 < constraintHelper0.b; ++v15) {
                                int v16 = constraintHelper0.a[v15];
                                View view3 = this.getViewById(v16);
                                if(view3 == null) {
                                    String s1 = (String)hashMap0.get(v16);
                                    int v17 = constraintHelper0.g(this, s1);
                                    if(v17 != 0) {
                                        constraintHelper0.a[v15] = v17;
                                        hashMap0.put(v17, s1);
                                        view3 = this.getViewById(v17);
                                    }
                                }
                                if(view3 != null) {
                                    constraintHelper0.d.W(this.getViewWidget(view3));
                                }
                            }
                            constraintHelper0.d.Y();
                        }
                    }
                }
                for(int v18 = 0; v18 < v7; ++v18) {
                    View view4 = this.getChildAt(v18);
                    if(view4 instanceof Placeholder) {
                        if(((Placeholder)view4).a == -1 && !((Placeholder)view4).isInEditMode()) {
                            ((Placeholder)view4).setVisibility(((Placeholder)view4).c);
                        }
                        View view5 = this.findViewById(((Placeholder)view4).a);
                        ((Placeholder)view4).b = view5;
                        if(view5 != null) {
                            ((LayoutParams)view5.getLayoutParams()).f0 = true;
                            ((Placeholder)view4).b.setVisibility(0);
                            ((Placeholder)view4).setVisibility(0);
                        }
                    }
                }
                SparseArray sparseArray0 = this.k;
                sparseArray0.clear();
                sparseArray0.put(0, this.mLayoutWidget);
                sparseArray0.put(this.getId(), this.mLayoutWidget);
                for(int v19 = 0; v19 < v7; ++v19) {
                    View view6 = this.getChildAt(v19);
                    e e2 = this.getViewWidget(view6);
                    sparseArray0.put(view6.getId(), e2);
                }
                for(int v20 = 0; v20 < v7; ++v20) {
                    View view7 = this.getChildAt(v20);
                    e e3 = this.getViewWidget(view7);
                    if(e3 != null) {
                        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view7.getLayoutParams();
                        this.mLayoutWidget.W(e3);
                        this.applyConstraintsFromLayoutParams(z1, view7, e3, constraintLayout$LayoutParams0, this.k);
                    }
                }
            }
            if(z) {
                this.mLayoutWidget.w0.F(this.mLayoutWidget);
            }
        }
        this.mLayoutWidget.B0.getClass();
        this.resolveSystem(this.mLayoutWidget, this.g, v, v1);
        this.resolveMeasuredDimension(v, v1, this.mLayoutWidget.s(), this.mLayoutWidget.m(), this.mLayoutWidget.J0, this.mLayoutWidget.K0);
    }

    @Override  // android.view.ViewGroup
    public void onViewAdded(View view0) {
        super.onViewAdded(view0);
        if(view0 instanceof Guideline && !(this.getViewWidget(view0) instanceof i)) {
            LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            i i0 = new i();
            constraintLayout$LayoutParams0.q0 = i0;
            constraintLayout$LayoutParams0.d0 = true;
            i0.X(constraintLayout$LayoutParams0.V);
        }
        if(view0 instanceof ConstraintHelper) {
            ((ConstraintHelper)view0).p();
            ((LayoutParams)view0.getLayoutParams()).e0 = true;
            ArrayList arrayList0 = this.b;
            if(!arrayList0.contains(((ConstraintHelper)view0))) {
                arrayList0.add(((ConstraintHelper)view0));
            }
        }
        int v = view0.getId();
        this.a.put(v, view0);
        this.mDirtyHierarchy = true;
    }

    @Override  // android.view.ViewGroup
    public void onViewRemoved(View view0) {
        super.onViewRemoved(view0);
        int v = view0.getId();
        this.a.remove(v);
        e e0 = this.getViewWidget(view0);
        this.mLayoutWidget.v0.remove(e0);
        e0.E();
        this.b.remove(view0);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int v) {
        this.mConstraintLayoutSpec = new g(this.getContext(), this, v);
    }

    @Override  // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mDirtyHierarchy = true;
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int v, int v1, int v2, int v3, boolean z, boolean z1) {
        int v4 = v3 + this.l.e;
        int v5 = View.resolveSizeAndState(v2 + this.l.d, v, 0);
        int v6 = View.resolveSizeAndState(v4, v1, 0);
        int v7 = Math.min(this.e, v5 & 0xFFFFFF);
        int v8 = Math.min(this.f, v6 & 0xFFFFFF);
        if(z) {
            v7 |= 0x1000000;
        }
        if(z1) {
            v8 |= 0x1000000;
        }
        this.setMeasuredDimension(v7, v8);
    }

    public void resolveSystem(f f0, int v, int v1, int v2) {
        int v3 = View.MeasureSpec.getMode(v1);
        int v4 = View.MeasureSpec.getSize(v1);
        int v5 = View.MeasureSpec.getMode(v2);
        int v6 = View.MeasureSpec.getSize(v2);
        int v7 = Math.max(0, this.getPaddingTop());
        int v8 = Math.max(0, this.getPaddingBottom());
        int v9 = v7 + v8;
        int v10 = this.getPaddingWidth();
        this.l.b = v7;
        this.l.c = v8;
        this.l.d = v10;
        this.l.e = v9;
        this.l.f = v1;
        this.l.g = v2;
        int v11 = Math.max(0, this.getPaddingStart());
        int v12 = Math.max(0, this.getPaddingEnd());
        if(v11 <= 0 && v12 <= 0) {
            v11 = Math.max(0, this.getPaddingLeft());
        }
        else if(this.isRtl()) {
            v11 = v12;
        }
        int v13 = v4 - v10;
        int v14 = v6 - v9;
        this.setSelfDimensionBehaviour(f0, v3, v13, v5, v14);
        f0.b0(v, v3, v13, v5, v14, v11, v7);
    }

    public void setConstraintSet(n n0) {
        this.h = n0;
    }

    public void setDesignInformation(int v, Object object0, Object object1) {
        if(v == 0 && object0 instanceof String && object1 instanceof Integer) {
            if(this.j == null) {
                this.j = new HashMap();
            }
            String s = (String)object0;
            int v1 = s.indexOf("/");
            if(v1 != -1) {
                s = s.substring(v1 + 1);
            }
            ((Integer)object1).intValue();
            this.j.put(s, ((Integer)object1));
        }
    }

    @Override  // android.view.View
    public void setId(int v) {
        int v1 = this.getId();
        this.a.remove(v1);
        super.setId(v);
        int v2 = this.getId();
        this.a.put(v2, this);
    }

    public void setMaxHeight(int v) {
        if(v == this.f) {
            return;
        }
        this.f = v;
        this.requestLayout();
    }

    public void setMaxWidth(int v) {
        if(v == this.e) {
            return;
        }
        this.e = v;
        this.requestLayout();
    }

    public void setMinHeight(int v) {
        if(v == this.d) {
            return;
        }
        this.d = v;
        this.requestLayout();
    }

    public void setMinWidth(int v) {
        if(v == this.c) {
            return;
        }
        this.c = v;
        this.requestLayout();
    }

    public void setOnConstraintsChanged(o o0) {
        g g0 = this.mConstraintLayoutSpec;
        if(g0 != null) {
            g0.getClass();
        }
    }

    public void setOptimizationLevel(int v) {
        this.g = v;
        this.mLayoutWidget.I0 = v;
        y1.c.q = this.mLayoutWidget.d0(0x200);
    }

    public void setSelfDimensionBehaviour(f f0, int v, int v1, int v2, int v3) {
        F1.d d2;
        int v4 = this.l.e;
        int v5 = this.l.d;
        int v6 = this.getChildCount();
        F1.d d0 = F1.d.b;
        F1.d d1 = F1.d.a;
        switch(v) {
            case 0x80000000: {
                if(v6 == 0) {
                    v1 = Math.max(0, this.c);
                }
                d2 = d0;
                break;
            }
            case 0: {
                if(v6 == 0) {
                    v1 = Math.max(0, this.c);
                    d2 = d0;
                }
                else {
                    d2 = d0;
                    v1 = 0;
                }
                break;
            }
            case 0x40000000: {
                v1 = Math.min(this.e - v5, v1);
                d2 = d1;
                break;
            }
            default: {
                d2 = d1;
                v1 = 0;
            }
        }
        switch(v2) {
            case 0x80000000: {
                if(v6 == 0) {
                    v3 = Math.max(0, this.d);
                }
                break;
            }
            case 0: {
                v3 = v6 == 0 ? Math.max(0, this.d) : 0;
                break;
            }
            case 0x40000000: {
                v3 = Math.min(this.f - v4, v3);
                d0 = d1;
                break;
            }
            default: {
                d0 = d1;
                v3 = 0;
            }
        }
        if(v1 != f0.s() || v3 != f0.m()) {
            f0.x0.b = true;
        }
        f0.b0 = 0;
        f0.c0 = 0;
        int[] arr_v = f0.D;
        arr_v[0] = this.e - v5;
        arr_v[1] = this.f - v4;
        f0.e0 = 0;
        f0.f0 = 0;
        f0.P(d2);
        f0.T(v1);
        f0.R(d0);
        f0.O(v3);
        int v7 = this.c - v5;
        f0.e0 = v7 < 0 ? 0 : v7;
        int v8 = this.d - v4;
        if(v8 < 0) {
            f0.f0 = 0;
            return;
        }
        f0.f0 = v8;
    }

    public void setState(int v, int v1, int v2) {
        g g0 = this.mConstraintLayoutSpec;
        if(g0 != null) {
            g0.b(0.0f, 0.0f, v);
        }
    }

    @Override  // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

