package androidx.constraintlayout.utils.widget;

import J1.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.q;

public class MotionButton extends AppCompatButton {
    public float d;
    public float e;
    public Path f;
    public ViewOutlineProvider g;
    public RectF h;

    public MotionButton(Context context0) {
        super(context0);
        this.d = 0.0f;
        this.e = NaNf;
        this.setPadding(0, 0, 0, 0);
    }

    public MotionButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.d = 0.0f;
        this.e = NaNf;
        this.a(context0, attributeSet0);
    }

    public MotionButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.d = 0.0f;
        this.e = NaNf;
        this.a(context0, attributeSet0);
    }

    public final void a(Context context0, AttributeSet attributeSet0) {
        this.setPadding(0, 0, 0, 0);
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.j);
            int v1 = typedArray0.getIndexCount();
            for(int v = 0; v < v1; ++v) {
                int v2 = typedArray0.getIndex(v);
                if(v2 == 10) {
                    this.setRound(typedArray0.getDimension(10, 0.0f));
                }
                else if(v2 == 11) {
                    this.setRoundPercent(typedArray0.getFloat(11, 0.0f));
                }
            }
            typedArray0.recycle();
        }
    }

    public float getRound() {
        return this.e;
    }

    public float getRoundPercent() {
        return this.d;
    }

    public void setRound(float f) {
        if(Float.isNaN(f)) {
            this.e = f;
            float f1 = this.d;
            this.d = -1.0f;
            this.setRoundPercent(f1);
            return;
        }
        boolean z = Float.compare(this.e, f) != 0;
        this.e = f;
        if(f == 0.0f) {
            this.setClipToOutline(false);
        }
        else {
            if(this.f == null) {
                this.f = new Path();
            }
            if(this.h == null) {
                this.h = new RectF();
            }
            if(this.g == null) {
                d d0 = new d(this, 1);
                this.g = d0;
                this.setOutlineProvider(d0);
            }
            this.setClipToOutline(true);
            int v = this.getWidth();
            int v1 = this.getHeight();
            this.h.set(0.0f, 0.0f, ((float)v), ((float)v1));
            this.f.reset();
            this.f.addRoundRect(this.h, this.e, this.e, Path.Direction.CW);
        }
        if(z) {
            this.invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = Float.compare(this.d, f) != 0;
        this.d = f;
        if(f == 0.0f) {
            this.setClipToOutline(false);
        }
        else {
            if(this.f == null) {
                this.f = new Path();
            }
            if(this.h == null) {
                this.h = new RectF();
            }
            if(this.g == null) {
                d d0 = new d(this, 0);
                this.g = d0;
                this.setOutlineProvider(d0);
            }
            this.setClipToOutline(true);
            int v = this.getWidth();
            int v1 = this.getHeight();
            float f1 = ((float)Math.min(v, v1)) * this.d / 2.0f;
            this.h.set(0.0f, 0.0f, ((float)v), ((float)v1));
            this.f.reset();
            this.f.addRoundRect(this.h, f1, f1, Path.Direction.CW);
        }
        if(z) {
            this.invalidateOutline();
        }
    }
}

