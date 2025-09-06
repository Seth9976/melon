package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import com.iloen.melon.utils.log.LogU;
import k8.t1;

public class MaxHeightListView extends ListView {
    public int a;

    public MaxHeightListView(Context context0) {
        super(context0);
        this.a = -1;
    }

    public MaxHeightListView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = -1;
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, t1.o, 0, 0);
        try {
            this.setMaxHeight(typedArray0.getDimensionPixelSize(0, 0));
        }
        finally {
            typedArray0.recycle();
        }
    }

    public MaxHeightListView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = -1;
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, t1.o, 0, 0);
        try {
            this.setMaxHeight(typedArray0.getDimensionPixelSize(0, 0));
        }
        finally {
            typedArray0.recycle();
        }
    }

    @Override  // android.widget.ListView
    public final void onMeasure(int v, int v1) {
        try {
            int v3 = View.MeasureSpec.getSize(v1);
            int v4 = this.a;
            if(v4 != -1 && v3 > v4) {
                if(v4 < 0) {
                    v4 = 0;
                }
                else if(v4 > 0x3FFFFFFF) {
                    v4 = 0x3FFFFFFF;
                }
                v1 = View.MeasureSpec.makeMeasureSpec(v4, 0x80000000);
                this.getLayoutParams().height = v4;
            }
        }
        catch(Exception exception0) {
            LogU.e("onMesure", "Error forcing height", exception0);
        }
        finally {
            super.onMeasure(v, v1);
        }
    }

    public void setMaxHeight(int v) {
        this.a = v;
    }
}

