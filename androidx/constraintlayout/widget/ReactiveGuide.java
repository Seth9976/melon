package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;

public class ReactiveGuide extends View implements r {
    public int a;
    public boolean b;
    public int c;
    public boolean d;

    public ReactiveGuide(Context context0) {
        super(context0);
        this.a = -1;
        this.b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        this.a(null);
    }

    public ReactiveGuide(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = -1;
        this.b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        this.a(attributeSet0);
    }

    public ReactiveGuide(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = -1;
        this.b = false;
        this.c = 0;
        this.d = true;
        super.setVisibility(8);
        this.a(attributeSet0);
    }

    public final void a(AttributeSet attributeSet0) {
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.d);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 3) {
                    this.a = typedArray0.getResourceId(3, this.a);
                }
                else if(v2 == 0) {
                    this.b = typedArray0.getBoolean(0, this.b);
                }
                else {
                    switch(v2) {
                        case 1: {
                            this.d = typedArray0.getBoolean(1, this.d);
                            break;
                        }
                        case 2: {
                            this.c = typedArray0.getResourceId(2, this.c);
                        }
                    }
                }
            }
            typedArray0.recycle();
        }
        if(this.a != -1) {
            ConstraintLayout.getSharedValues().a(this.a, this);
        }
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
    }

    public int getApplyToConstraintSetId() {
        return this.c;
    }

    public int getAttributeId() {
        return this.a;
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        this.setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z) {
        this.b = z;
    }

    public void setApplyToConstraintSetId(int v) {
        this.c = v;
    }

    public void setAttributeId(int v) {
        s s0 = ConstraintLayout.getSharedValues();
        int v1 = this.a;
        if(v1 != -1) {
            HashSet hashSet0 = (HashSet)s0.a.get(v1);
            if(hashSet0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: hashSet0) {
                    WeakReference weakReference0 = (WeakReference)object0;
                    r r0 = (r)weakReference0.get();
                    if(r0 == null || r0 == this) {
                        arrayList0.add(weakReference0);
                    }
                }
                hashSet0.removeAll(arrayList0);
            }
        }
        this.a = v;
        if(v != -1) {
            s0.a(v, this);
        }
    }

    public void setGuidelineBegin(int v) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
        constraintLayout$LayoutParams0.a = v;
        this.setLayoutParams(constraintLayout$LayoutParams0);
    }

    public void setGuidelineEnd(int v) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
        constraintLayout$LayoutParams0.b = v;
        this.setLayoutParams(constraintLayout$LayoutParams0);
    }

    public void setGuidelinePercent(float f) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
        constraintLayout$LayoutParams0.c = f;
        this.setLayoutParams(constraintLayout$LayoutParams0);
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
    }
}

