package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import g.a;

public class ActionBar.LayoutParams extends ViewGroup.MarginLayoutParams {
    public int a;

    public ActionBar.LayoutParams(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 0;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.b);
        this.a = typedArray0.getInt(0, 0);
        typedArray0.recycle();
    }

    public ActionBar.LayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super(viewGroup$LayoutParams0);
        this.a = 0;
    }

    public ActionBar.LayoutParams(ActionBar.LayoutParams actionBar$LayoutParams0) {
        super(actionBar$LayoutParams0);
        this.a = actionBar$LayoutParams0.a;
    }
}

