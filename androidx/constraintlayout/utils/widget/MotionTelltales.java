package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.q;

public class MotionTelltales extends MockView {
    public float B;
    public final Paint l;
    public MotionLayout m;
    public final float[] n;
    public final Matrix o;
    public int r;
    public int w;

    public MotionTelltales(Context context0) {
        super(context0);
        this.l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.r = 0;
        this.w = 0xFFFF00FF;
        this.B = 0.25f;
        this.b(context0, null);
    }

    public MotionTelltales(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.r = 0;
        this.w = 0xFFFF00FF;
        this.B = 0.25f;
        this.b(context0, attributeSet0);
    }

    public MotionTelltales(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.r = 0;
        this.w = 0xFFFF00FF;
        this.B = 0.25f;
        this.b(context0, attributeSet0);
    }

    public final void b(Context context0, AttributeSet attributeSet0) {
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.x);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 0) {
                    this.w = typedArray0.getColor(0, this.w);
                }
                else {
                    switch(v2) {
                        case 1: {
                            this.B = typedArray0.getFloat(1, this.B);
                            break;
                        }
                        case 2: {
                            this.r = typedArray0.getInt(2, this.r);
                        }
                    }
                }
            }
            typedArray0.recycle();
        }
        this.l.setColor(this.w);
        this.l.setStrokeWidth(5.0f);
    }

    @Override  // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override  // androidx.constraintlayout.utils.widget.MockView
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        Matrix matrix0 = this.getMatrix();
        Matrix matrix1 = this.o;
        matrix0.invert(matrix1);
        if(this.m == null) {
            ViewParent viewParent0 = this.getParent();
            if(viewParent0 instanceof MotionLayout) {
                this.m = (MotionLayout)viewParent0;
            }
        }
        else {
            int v = this.getWidth();
            int v1 = this.getHeight();
            float[] arr_f = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
            for(int v2 = 0; v2 < 5; ++v2) {
                float f = arr_f[v2];
                for(int v3 = 0; v3 < 5; ++v3) {
                    float f1 = arr_f[v3];
                    this.m.getViewVelocity(this, f1, f, this.n, this.r);
                    matrix1.mapVectors(this.n);
                    float f2 = ((float)v) * f1;
                    float f3 = ((float)v1) * f;
                    float f4 = this.B;
                    float f5 = f2 - this.n[0] * f4;
                    float f6 = f3 - this.n[1] * f4;
                    matrix1.mapVectors(this.n);
                    canvas0.drawLine(f2, f3, f5, f6, this.l);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.postInvalidate();
    }

    public void setText(CharSequence charSequence0) {
        this.f = charSequence0.toString();
        this.requestLayout();
    }
}

