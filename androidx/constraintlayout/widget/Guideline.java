package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class Guideline extends View {
    public boolean a;

    public Guideline(Context context0) {
        super(context0);
        this.a = true;
        super.setVisibility(8);
    }

    public Guideline(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = true;
        super.setVisibility(8);
    }

    public Guideline(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = true;
        super.setVisibility(8);
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        this.setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.a = z;
    }

    public void setGuidelineBegin(int v) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
        if(this.a && constraintLayout$LayoutParams0.a == v) {
            return;
        }
        constraintLayout$LayoutParams0.a = v;
        this.setLayoutParams(constraintLayout$LayoutParams0);
    }

    public void setGuidelineEnd(int v) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
        if(this.a && constraintLayout$LayoutParams0.b == v) {
            return;
        }
        constraintLayout$LayoutParams0.b = v;
        this.setLayoutParams(constraintLayout$LayoutParams0);
    }

    public void setGuidelinePercent(float f) {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
        if(this.a && constraintLayout$LayoutParams0.c == f) {
            return;
        }
        constraintLayout$LayoutParams0.c = f;
        this.setLayoutParams(constraintLayout$LayoutParams0);
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
    }
}

