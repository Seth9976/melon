package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import c2.W;
import g.a;

public class ButtonBarLayout extends LinearLayout {
    public boolean a;
    public boolean b;
    public int c;

    public ButtonBarLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.c = -1;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.l);
        W.n(this, context0, a.l, attributeSet0, typedArray0, 0);
        this.a = typedArray0.getBoolean(0, true);
        typedArray0.recycle();
        if(this.getOrientation() == 1) {
            this.setStacked(this.a);
        }
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        int v7;
        boolean z;
        int v4;
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = 0;
        if(this.a) {
            if(v2 > this.c && this.b) {
                this.setStacked(false);
            }
            this.c = v2;
        }
        if(this.b || View.MeasureSpec.getMode(v) != 0x40000000) {
            v4 = v;
            z = false;
        }
        else {
            v4 = View.MeasureSpec.makeMeasureSpec(v2, 0x80000000);
            z = true;
        }
        super.onMeasure(v4, v1);
        if(this.a && !this.b && (this.getMeasuredWidthAndState() & 0xFF000000) == 0x1000000) {
            this.setStacked(true);
            z = true;
        }
        if(z) {
            super.onMeasure(v, v1);
        }
        int v5 = this.getChildCount();
        int v6;
        for(v6 = 0; true; ++v6) {
            v7 = -1;
            if(v6 >= v5) {
                v6 = -1;
                break;
            }
            if(this.getChildAt(v6).getVisibility() == 0) {
                break;
            }
        }
        if(v6 >= 0) {
            View view0 = this.getChildAt(v6);
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)view0.getLayoutParams();
            int v8 = this.getPaddingTop();
            int v9 = view0.getMeasuredHeight() + v8 + linearLayout$LayoutParams0.topMargin + linearLayout$LayoutParams0.bottomMargin;
            if(this.b) {
                int v10 = v6 + 1;
                int v11 = this.getChildCount();
                while(v10 < v11) {
                    if(this.getChildAt(v10).getVisibility() == 0) {
                        v7 = v10;
                        break;
                    }
                    ++v10;
                }
                v3 = v7 >= 0 ? this.getChildAt(v7).getPaddingTop() + ((int)(this.getResources().getDisplayMetrics().density * 16.0f)) + v9 : v9;
            }
            else {
                v3 = this.getPaddingBottom() + v9;
            }
        }
        if(this.getMinimumHeight() != v3) {
            this.setMinimumHeight(v3);
            if(v1 == 0) {
                super.onMeasure(v, 0);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        if(this.a != z) {
            this.a = z;
            if(!z && this.b) {
                this.setStacked(false);
            }
            this.requestLayout();
        }
    }

    private void setStacked(boolean z) {
        if(this.b != z && (!z || this.a)) {
            this.b = z;
            this.setOrientation(((int)z));
            this.setGravity((z ? 0x800005 : 80));
            View view0 = this.findViewById(0x7F0A0AC6);  // id:spacer
            if(view0 != null) {
                view0.setVisibility((z ? 8 : 4));
            }
            for(int v = this.getChildCount() - 2; v >= 0; --v) {
                this.bringChildToFront(this.getChildAt(v));
            }
        }
    }
}

