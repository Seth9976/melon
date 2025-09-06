package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.q;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Grid extends VirtualLayout {
    public String B;
    public String D;
    public String E;
    public String G;
    public float I;
    public float M;
    public int N;
    public int S;
    public boolean[][] T;
    public final HashSet V;
    public int[] W;
    public View[] l;
    public ConstraintLayout m;
    public int n;
    public int o;
    public int r;
    public int w;

    public Grid(Context context0) {
        super(context0);
        this.S = 0;
        this.V = new HashSet();
    }

    public Grid(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.S = 0;
        this.V = new HashSet();
    }

    public Grid(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.S = 0;
        this.V = new HashSet();
    }

    public static int[][] A(String s) {
        String[] arr_s = s.split(",");
        int[][] arr2_v = new int[arr_s.length][3];
        for(int v = 0; v < arr_s.length; ++v) {
            String[] arr_s1 = arr_s[v].trim().split(":");
            String[] arr_s2 = arr_s1[1].split("x");
            int[] arr_v = arr2_v[v];
            arr_v[0] = Integer.parseInt(arr_s1[0]);
            int[] arr_v1 = arr2_v[v];
            arr_v1[1] = Integer.parseInt(arr_s2[0]);
            int[] arr_v2 = arr2_v[v];
            arr_v2[2] = Integer.parseInt(arr_s2[1]);
        }
        return arr2_v;
    }

    public static float[] B(int v, String s) {
        if(s != null && !s.trim().isEmpty()) {
            String[] arr_s = s.split(",");
            if(arr_s.length == v) {
                float[] arr_f = new float[v];
                for(int v1 = 0; v1 < v; ++v1) {
                    arr_f[v1] = Float.parseFloat(arr_s[v1].trim());
                }
                return arr_f;
            }
        }
        return null;
    }

    public final void C() {
        int v = this.o;
        if(v != 0) {
            int v1 = this.w;
            if(v1 != 0) {
                this.n = v;
                this.r = v1;
                return;
            }
        }
        int v2 = this.w;
        if(v2 > 0) {
            this.r = v2;
            this.n = (this.b + v2 - 1) / v2;
            return;
        }
        if(v > 0) {
            this.n = v;
            this.r = (this.b + v - 1) / v;
            return;
        }
        double f = Math.sqrt(this.b);
        this.n = (int)(f + 1.5);
        this.r = (this.b + ((int)(f + 1.5)) - 1) / ((int)(f + 1.5));
    }

    public String getColumnWeights() {
        return this.G;
    }

    public int getColumns() {
        return this.w;
    }

    public float getHorizontalGaps() {
        return this.I;
    }

    private int getNextPosition() {
        int v = 0;
        boolean z = false;
        while(!z) {
            v = this.S;
            if(v >= this.n * this.r) {
                return -1;
            }
            int v1 = this.w(v);
            int v2 = this.v(this.S);
            boolean[] arr_z = this.T[v1];
            if(arr_z[v2]) {
                arr_z[v2] = false;
                z = true;
            }
            ++this.S;
        }
        return v;
    }

    public int getOrientation() {
        return this.N;
    }

    public String getRowWeights() {
        return this.E;
    }

    public int getRows() {
        return this.o;
    }

    public String getSkips() {
        return this.D;
    }

    public String getSpans() {
        return this.B;
    }

    public float getVerticalGaps() {
        return this.M;
    }

    @Override  // androidx.constraintlayout.widget.VirtualLayout
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        this.e = true;
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.i);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                switch(typedArray0.getIndex(v1)) {
                    case 0: {
                        this.G = typedArray0.getString(0);
                        break;
                    }
                    case 1: {
                        this.w = typedArray0.getInteger(1, 0);
                        break;
                    }
                    case 2: {
                        this.I = typedArray0.getDimension(2, 0.0f);
                        break;
                    }
                    case 3: {
                        this.N = typedArray0.getInt(3, 0);
                        break;
                    }
                    case 4: {
                        this.E = typedArray0.getString(4);
                        break;
                    }
                    case 5: {
                        this.o = typedArray0.getInteger(5, 0);
                        break;
                    }
                    case 6: {
                        this.D = typedArray0.getString(6);
                        break;
                    }
                    case 7: {
                        this.B = typedArray0.getString(7);
                        break;
                    }
                    case 8: {
                        typedArray0.getBoolean(8, false);
                        break;
                    }
                    case 9: {
                        typedArray0.getBoolean(9, false);
                        break;
                    }
                    case 10: {
                        this.M = typedArray0.getDimension(10, 0.0f);
                    }
                }
            }
            this.C();
            this.x();
            typedArray0.recycle();
        }
    }

    @Override  // androidx.constraintlayout.widget.VirtualLayout
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = (ConstraintLayout)this.getParent();
        this.u(false);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void onDraw(Canvas canvas0) {
        if(this.isInEditMode()) {
            Paint paint0 = new Paint();
            paint0.setColor(0xFFFF0000);
            paint0.setStyle(Paint.Style.STROKE);
            int v = this.getTop();
            int v1 = this.getLeft();
            int v2 = this.getBottom();
            int v3 = this.getRight();
            View[] arr_view = this.l;
            for(int v4 = 0; v4 < arr_view.length; ++v4) {
                View view0 = arr_view[v4];
                int v5 = view0.getLeft();
                int v6 = view0.getTop();
                int v7 = view0.getRight();
                int v8 = view0.getBottom();
                canvas0.drawRect(((float)(v5 - v1)), 0.0f, ((float)(v7 - v1)), ((float)(v2 - v)), paint0);
                canvas0.drawRect(0.0f, ((float)(v6 - v)), ((float)(v3 - v1)), ((float)(v8 - v)), paint0);
            }
        }
    }

    public static void r(View view0) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        constraintLayout$LayoutParams0.H = -1.0f;
        constraintLayout$LayoutParams0.f = -1;
        constraintLayout$LayoutParams0.e = -1;
        constraintLayout$LayoutParams0.g = -1;
        constraintLayout$LayoutParams0.h = -1;
        constraintLayout$LayoutParams0.leftMargin = -1;
        view0.setLayoutParams(constraintLayout$LayoutParams0);
    }

    public static void s(View view0) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        constraintLayout$LayoutParams0.I = -1.0f;
        constraintLayout$LayoutParams0.j = -1;
        constraintLayout$LayoutParams0.i = -1;
        constraintLayout$LayoutParams0.k = -1;
        constraintLayout$LayoutParams0.l = -1;
        constraintLayout$LayoutParams0.topMargin = -1;
        view0.setLayoutParams(constraintLayout$LayoutParams0);
    }

    public void setColumnWeights(String s) {
        if(this.G != null && this.G.equals(s)) {
            return;
        }
        this.G = s;
        this.u(true);
        this.invalidate();
    }

    public void setColumns(int v) {
        if(v > 50 || this.w == v) {
            return;
        }
        this.w = v;
        this.C();
        this.x();
        this.u(false);
        this.invalidate();
    }

    public void setHorizontalGaps(float f) {
        if(f < 0.0f || this.I == f) {
            return;
        }
        this.I = f;
        this.u(true);
        this.invalidate();
    }

    public void setOrientation(int v) {
        if(v != 0 && v != 1 || this.N == v) {
            return;
        }
        this.N = v;
        this.u(true);
        this.invalidate();
    }

    public void setRowWeights(String s) {
        if(this.E != null && this.E.equals(s)) {
            return;
        }
        this.E = s;
        this.u(true);
        this.invalidate();
    }

    public void setRows(int v) {
        if(v > 50 || this.o == v) {
            return;
        }
        this.o = v;
        this.C();
        this.x();
        this.u(false);
        this.invalidate();
    }

    public void setSkips(String s) {
        if(this.D != null && this.D.equals(s)) {
            return;
        }
        this.D = s;
        this.u(true);
        this.invalidate();
    }

    public void setSpans(CharSequence charSequence0) {
        if(this.B != null && this.B.contentEquals(charSequence0)) {
            return;
        }
        this.B = charSequence0.toString();
        this.u(true);
        this.invalidate();
    }

    public void setVerticalGaps(float f) {
        if(f < 0.0f || this.M == f) {
            return;
        }
        this.M = f;
        this.u(true);
        this.invalidate();
    }

    public final void t(View view0, int v, int v1, int v2, int v3) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int[] arr_v = this.W;
        constraintLayout$LayoutParams0.e = arr_v[v1];
        constraintLayout$LayoutParams0.i = arr_v[v];
        constraintLayout$LayoutParams0.h = arr_v[v1 + v3 - 1];
        constraintLayout$LayoutParams0.l = arr_v[v + v2 - 1];
        view0.setLayoutParams(constraintLayout$LayoutParams0);
    }

    public final void u(boolean z) {
        int v15;
        int v11;
        if(this.m != null && this.n >= 1 && this.r >= 1) {
            HashSet hashSet0 = this.V;
            if(z) {
                for(int v1 = 0; v1 < this.T.length; ++v1) {
                    for(int v2 = 0; true; ++v2) {
                        boolean[][] arr2_z = this.T;
                        if(v2 >= arr2_z[0].length) {
                            break;
                        }
                        arr2_z[v1][v2] = true;
                    }
                }
                hashSet0.clear();
            }
            this.S = 0;
            int v3 = Math.max(this.n, this.r);
            View[] arr_view = this.l;
            if(arr_view == null) {
                this.l = new View[v3];
                for(int v4 = 0; true; ++v4) {
                    View[] arr_view1 = this.l;
                    if(v4 >= arr_view1.length) {
                        break;
                    }
                    arr_view1[v4] = this.z();
                }
            }
            else if(v3 != arr_view.length) {
                View[] arr_view2 = new View[v3];
                for(int v5 = 0; v5 < v3; ++v5) {
                    View[] arr_view3 = this.l;
                    arr_view2[v5] = v5 < arr_view3.length ? arr_view3[v5] : this.z();
                }
                for(int v6 = v3; true; ++v6) {
                    View[] arr_view4 = this.l;
                    if(v6 >= arr_view4.length) {
                        break;
                    }
                    this.m.removeView(arr_view4[v6]);
                }
                this.l = arr_view2;
            }
            this.W = new int[v3];
            for(int v7 = 0; true; ++v7) {
                View[] arr_view5 = this.l;
                if(v7 >= arr_view5.length) {
                    break;
                }
                int[] arr_v = this.W;
                arr_v[v7] = arr_view5[v7].getId();
            }
            int v8 = this.getId();
            int v9 = Math.max(this.n, this.r);
            float[] arr_f = Grid.B(this.n, this.E);
            if(this.n == 1) {
                LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.l[0].getLayoutParams();
                Grid.s(this.l[0]);
                constraintLayout$LayoutParams0.i = v8;
                constraintLayout$LayoutParams0.l = v8;
                this.l[0].setLayoutParams(constraintLayout$LayoutParams0);
            }
            else {
                for(int v10 = 0; true; ++v10) {
                    v11 = this.n;
                    if(v10 >= v11) {
                        break;
                    }
                    LayoutParams constraintLayout$LayoutParams1 = (LayoutParams)this.l[v10].getLayoutParams();
                    Grid.s(this.l[v10]);
                    if(arr_f != null) {
                        constraintLayout$LayoutParams1.I = arr_f[v10];
                    }
                    if(v10 > 0) {
                        constraintLayout$LayoutParams1.j = this.W[v10 - 1];
                    }
                    else {
                        constraintLayout$LayoutParams1.i = v8;
                    }
                    if(v10 < this.n - 1) {
                        constraintLayout$LayoutParams1.k = this.W[v10 + 1];
                    }
                    else {
                        constraintLayout$LayoutParams1.l = v8;
                    }
                    if(v10 > 0) {
                        constraintLayout$LayoutParams1.topMargin = (int)this.I;
                    }
                    this.l[v10].setLayoutParams(constraintLayout$LayoutParams1);
                }
                while(v11 < v9) {
                    LayoutParams constraintLayout$LayoutParams2 = (LayoutParams)this.l[v11].getLayoutParams();
                    Grid.s(this.l[v11]);
                    constraintLayout$LayoutParams2.i = v8;
                    constraintLayout$LayoutParams2.l = v8;
                    this.l[v11].setLayoutParams(constraintLayout$LayoutParams2);
                    ++v11;
                }
            }
            int v12 = this.getId();
            int v13 = Math.max(this.n, this.r);
            float[] arr_f1 = Grid.B(this.r, this.G);
            LayoutParams constraintLayout$LayoutParams3 = (LayoutParams)this.l[0].getLayoutParams();
            if(this.r == 1) {
                Grid.r(this.l[0]);
                constraintLayout$LayoutParams3.e = v12;
                constraintLayout$LayoutParams3.h = v12;
                this.l[0].setLayoutParams(constraintLayout$LayoutParams3);
            }
            else {
                for(int v14 = 0; true; ++v14) {
                    v15 = this.r;
                    if(v14 >= v15) {
                        break;
                    }
                    LayoutParams constraintLayout$LayoutParams4 = (LayoutParams)this.l[v14].getLayoutParams();
                    Grid.r(this.l[v14]);
                    if(arr_f1 != null) {
                        constraintLayout$LayoutParams4.H = arr_f1[v14];
                    }
                    if(v14 > 0) {
                        constraintLayout$LayoutParams4.f = this.W[v14 - 1];
                    }
                    else {
                        constraintLayout$LayoutParams4.e = v12;
                    }
                    if(v14 < this.r - 1) {
                        constraintLayout$LayoutParams4.g = this.W[v14 + 1];
                    }
                    else {
                        constraintLayout$LayoutParams4.h = v12;
                    }
                    if(v14 > 0) {
                        constraintLayout$LayoutParams4.leftMargin = (int)this.I;
                    }
                    this.l[v14].setLayoutParams(constraintLayout$LayoutParams4);
                }
                while(v15 < v13) {
                    LayoutParams constraintLayout$LayoutParams5 = (LayoutParams)this.l[v15].getLayoutParams();
                    Grid.r(this.l[v15]);
                    constraintLayout$LayoutParams5.e = v12;
                    constraintLayout$LayoutParams5.h = v12;
                    this.l[v15].setLayoutParams(constraintLayout$LayoutParams5);
                    ++v15;
                }
            }
            if(this.D != null && !this.D.trim().isEmpty()) {
                int[][] arr2_v = Grid.A(this.D);
                if(arr2_v != null) {
                    for(int v16 = 0; v16 < arr2_v.length; ++v16) {
                        int v17 = this.w(arr2_v[v16][0]);
                        int v18 = this.v(arr2_v[v16][0]);
                        int[] arr_v1 = arr2_v[v16];
                        if(!this.y(v17, v18, arr_v1[1], arr_v1[2])) {
                            break;
                        }
                    }
                }
            }
            if(this.B != null && !this.B.trim().isEmpty()) {
                int[][] arr2_v1 = Grid.A(this.B);
                if(arr2_v1 != null) {
                    int[] arr_v2 = this.a;
                    View[] arr_view6 = this.i(this.m);
                    for(int v19 = 0; v19 < arr2_v1.length; ++v19) {
                        int v20 = this.w(arr2_v1[v19][0]);
                        int v21 = this.v(arr2_v1[v19][0]);
                        int[] arr_v3 = arr2_v1[v19];
                        if(!this.y(v20, v21, arr_v3[1], arr_v3[2])) {
                            break;
                        }
                        View view0 = arr_view6[v19];
                        int[] arr_v4 = arr2_v1[v19];
                        this.t(view0, v20, v21, arr_v4[1], arr_v4[2]);
                        hashSet0.add(((int)arr_v2[v19]));
                    }
                }
            }
            View[] arr_view7 = this.i(this.m);
            for(int v = 0; v < this.b; ++v) {
                if(!hashSet0.contains(((int)this.a[v]))) {
                    int v22 = this.getNextPosition();
                    int v23 = this.w(v22);
                    int v24 = this.v(v22);
                    if(v22 == -1) {
                        break;
                    }
                    this.t(arr_view7[v], v23, v24, 1, 1);
                }
            }
        }
    }

    public final int v(int v) {
        return this.N == 1 ? v / this.n : v % this.r;
    }

    public final int w(int v) {
        return this.N == 1 ? v % this.n : v / this.r;
    }

    public final void x() {
        int[] arr_v = new int[2];
        arr_v[1] = this.r;
        arr_v[0] = this.n;
        boolean[][] arr2_z = (boolean[][])Array.newInstance(Boolean.TYPE, arr_v);
        this.T = arr2_z;
        for(int v = 0; v < arr2_z.length; ++v) {
            Arrays.fill(arr2_z[v], true);
        }
    }

    public final boolean y(int v, int v1, int v2, int v3) {
        int v4 = v;
        while(v4 < v + v2) {
            int v5 = v1;
            while(v5 < v1 + v3) {
                boolean[][] arr2_z = this.T;
                if(v4 < arr2_z.length && v5 < arr2_z[0].length) {
                    boolean[] arr_z = arr2_z[v4];
                    if(!arr_z[v5]) {
                        return false;
                    }
                    arr_z[v5] = false;
                    ++v5;
                    continue;
                }
                return false;
            }
            ++v4;
        }
        return true;
    }

    public final View z() {
        View view0 = new View(this.getContext());
        view0.setId(View.generateViewId());
        view0.setVisibility(4);
        LayoutParams constraintLayout$LayoutParams0 = new LayoutParams(0, 0);
        this.m.addView(view0, constraintLayout$LayoutParams0);
        return view0;
    }
}

