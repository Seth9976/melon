package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.q;
import java.util.Arrays;
import java.util.HashMap;

public class CircularFlow extends VirtualLayout {
    public String B;
    public String D;
    public Float E;
    public Integer G;
    public static int I;
    public static float M;
    public ConstraintLayout l;
    public int m;
    public float[] n;
    public int[] o;
    public int r;
    public int w;

    public CircularFlow(Context context0) {
        super(context0);
    }

    public CircularFlow(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public CircularFlow(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.n, this.w);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.o, this.r);
    }

    @Override  // androidx.constraintlayout.widget.VirtualLayout
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.c);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                switch(typedArray0.getIndex(v1)) {
                    case 29: {
                        String s = typedArray0.getString(29);
                        this.B = s;
                        this.setAngles(s);
                        break;
                    }
                    case 30: {
                        Float float0 = typedArray0.getFloat(30, CircularFlow.M);
                        this.E = float0;
                        this.setDefaultAngle(((float)float0));
                        break;
                    }
                    case 0x1F: {
                        Integer integer0 = typedArray0.getDimensionPixelSize(0x1F, CircularFlow.I);
                        this.G = integer0;
                        this.setDefaultRadius(((int)integer0));
                        break;
                    }
                    case 0x20: {
                        String s1 = typedArray0.getString(0x20);
                        this.D = s1;
                        this.setRadius(s1);
                        break;
                    }
                    case 33: {
                        this.m = typedArray0.getResourceId(33, 0);
                    }
                }
            }
            typedArray0.recycle();
        }
    }

    @Override  // androidx.constraintlayout.widget.VirtualLayout
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String s = this.B;
        if(s != null) {
            this.n = new float[1];
            this.setAngles(s);
        }
        String s1 = this.D;
        if(s1 != null) {
            this.o = new int[1];
            this.setRadius(s1);
        }
        Float float0 = this.E;
        if(float0 != null) {
            this.setDefaultAngle(((float)float0));
        }
        Integer integer0 = this.G;
        if(integer0 != null) {
            this.setDefaultRadius(((int)integer0));
        }
        this.l = (ConstraintLayout)this.getParent();
        for(int v = 0; v < this.b; ++v) {
            View view0 = this.l.getViewById(this.a[v]);
            if(view0 != null) {
                int v1 = CircularFlow.I;
                float f = CircularFlow.M;
                int[] arr_v = this.o;
                HashMap hashMap0 = this.i;
                if(arr_v != null && v < arr_v.length) {
                    v1 = arr_v[v];
                }
                else if(this.G == null || ((int)this.G) == -1) {
                    Log.e("CircularFlow", "Added radius to view with id: " + ((String)hashMap0.get(view0.getId())));
                }
                else {
                    ++this.r;
                    if(this.o == null) {
                        this.o = new int[1];
                    }
                    int[] arr_v1 = this.getRadius();
                    this.o = arr_v1;
                    arr_v1[this.r - 1] = v1;
                }
                float[] arr_f = this.n;
                if(arr_f != null && v < arr_f.length) {
                    f = arr_f[v];
                }
                else if(this.E == null || ((float)this.E) == -1.0f) {
                    Log.e("CircularFlow", "Added angle to view with id: " + ((String)hashMap0.get(view0.getId())));
                }
                else {
                    ++this.w;
                    if(this.n == null) {
                        this.n = new float[1];
                    }
                    float[] arr_f1 = this.getAngles();
                    this.n = arr_f1;
                    arr_f1[this.w - 1] = f;
                }
                LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                constraintLayout$LayoutParams0.r = f;
                constraintLayout$LayoutParams0.p = this.m;
                constraintLayout$LayoutParams0.q = v1;
                view0.setLayoutParams(constraintLayout$LayoutParams0);
            }
        }
        this.d();
    }

    public final void r(String s) {
        if(s != null && s.length() != 0 && this.c != null) {
            float[] arr_f = this.n;
            if(arr_f != null) {
                if(this.w + 1 > arr_f.length) {
                    this.n = Arrays.copyOf(arr_f, arr_f.length + 1);
                }
                float[] arr_f1 = this.n;
                int v = this.w;
                arr_f1[v] = (float)Integer.parseInt(s);
                ++this.w;
            }
        }
    }

    public final void s(String s) {
        if(s != null && s.length() != 0) {
            Context context0 = this.c;
            if(context0 != null) {
                int[] arr_v = this.o;
                if(arr_v != null) {
                    if(this.r + 1 > arr_v.length) {
                        this.o = Arrays.copyOf(arr_v, arr_v.length + 1);
                    }
                    int[] arr_v1 = this.o;
                    int v = this.r;
                    arr_v1[v] = (int)(((float)Integer.parseInt(s)) * context0.getResources().getDisplayMetrics().density);
                    ++this.r;
                }
            }
        }
    }

    private void setAngles(String s) {
        if(s == null) {
            return;
        }
        int v = 0;
        this.w = 0;
        int v1;
        while((v1 = s.indexOf(44, v)) != -1) {
            this.r(s.substring(v, v1).trim());
            v = v1 + 1;
        }
        this.r(s.substring(v).trim());
    }

    public void setDefaultAngle(float f) {
        CircularFlow.M = f;
    }

    public void setDefaultRadius(int v) {
        CircularFlow.I = v;
    }

    private void setRadius(String s) {
        if(s == null) {
            return;
        }
        int v = 0;
        this.r = 0;
        int v1;
        while((v1 = s.indexOf(44, v)) != -1) {
            this.s(s.substring(v, v1).trim());
            v = v1 + 1;
        }
        this.s(s.substring(v).trim());
    }
}

