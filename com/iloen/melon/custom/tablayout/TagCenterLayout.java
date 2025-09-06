package com.iloen.melon.custom.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class TagCenterLayout extends ViewGroup {
    public int a;
    public int b;
    public int c;
    public final ArrayList d;

    public TagCenterLayout(Context context0) {
        super(context0);
        this.a = 1;
        this.b = 0;
        this.c = 0;
        this.d = new ArrayList();
    }

    public TagCenterLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 1;
        this.b = 0;
        this.c = 0;
        this.d = new ArrayList();
    }

    public int getHorizontalSpace() {
        return this.b;
    }

    public int getRowCount() {
        return this.a;
    }

    public int getVerticalSpace() {
        return this.c;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        ArrayList arrayList0;
        int v4 = this.getChildCount();
        int v5 = v2 - v;
        int v6 = this.getPaddingLeft();
        int v7 = this.getPaddingTop();
        if(v4 == 0) {
            this.a = 0;
            return;
        }
        int v9 = v6;
        for(int v10 = 0; true; ++v10) {
            arrayList0 = this.d;
            if(v10 >= v4) {
                break;
            }
            View view0 = this.getChildAt(v10);
            if(view0.getVisibility() != 8) {
                int v11 = view0.getMeasuredWidth();
                if(v6 + v11 > v5) {
                    v6 = this.getPaddingLeft();
                    int v12 = this.getPaddingRight();
                    arrayList0.add(((int)((this.getPaddingLeft() + (v12 + (v5 - v9))) / 2)));
                }
                v9 = this.getHorizontalSpace() + v11 + v6;
                if(v10 == v4 - 1) {
                    int v13 = this.getPaddingRight();
                    arrayList0.add(((int)((this.getPaddingLeft() + (v13 + (v5 - v9))) / 2)));
                }
                v6 = v9;
            }
        }
        int v14 = (int)(((Integer)arrayList0.get(0)));
        int v15 = 0;
        for(int v8 = 0; v8 < v4; ++v8) {
            View view1 = this.getChildAt(v8);
            if(view1.getVisibility() != 8) {
                int v16 = view1.getMeasuredWidth();
                int v17 = view1.getMeasuredHeight();
                if(v14 + v16 > v5) {
                    ++v15;
                    v14 = (int)(((Integer)arrayList0.get(v15)));
                    v7 = v7 + v17 + this.getVerticalSpace();
                    ++this.a;
                }
                view1.layout(v14, v7, v14 + v16, v17 + v7);
                v14 = this.getHorizontalSpace() + v16 + v14;
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = View.MeasureSpec.getSize(v1);
        int v4 = this.getPaddingLeft();
        int v5 = this.getPaddingRight();
        int v6 = v3 - this.getPaddingTop() - this.getPaddingBottom();
        int v7 = this.getChildCount();
        for(int v8 = 0; v8 < v7; ++v8) {
            View view0 = this.getChildAt(v8);
            if(view0.getVisibility() != 8) {
                this.measureChild(view0, v2 - v4 - v5, v6);
            }
        }
        this.setMeasuredDimension(v, v6);
    }

    public void setHorizontalSpace(int v) {
        this.b = v;
    }

    public void setVerticalSpace(int v) {
        this.c = v;
    }
}

