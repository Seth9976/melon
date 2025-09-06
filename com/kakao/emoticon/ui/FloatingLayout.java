package com.kakao.emoticon.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.kakao.emoticon.R.styleable;

public class FloatingLayout extends ViewGroup {
    private int childrenHeightSum;
    private int floorCount;
    private int gravity;
    private boolean justify;

    public FloatingLayout(Context context0) {
        super(context0);
        this.gravity = 0x800033;
    }

    public FloatingLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.gravity = 0x800033;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, styleable.FloatingLayout);
        this.gravity = typedArray0.getInt(styleable.FloatingLayout_android_gravity, this.gravity);
        typedArray0.recycle();
    }

    public FloatingLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.gravity = 0x800033;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, styleable.FloatingLayout, v, 0);
        this.gravity = typedArray0.getInt(styleable.FloatingLayout_android_gravity, this.gravity);
        typedArray0.recycle();
    }

    @Override  // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof FrameLayout.LayoutParams;
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.generateLayoutParams(attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.generateLayoutParams(viewGroup$LayoutParams0);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new FrameLayout.LayoutParams(this.getContext(), attributeSet0);
    }

    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new FrameLayout.LayoutParams(viewGroup$LayoutParams0);
    }

    private void layoutFloor(int v, int v1, int v2) {
        int v13;
        int v8;
        int v3 = 0;
        int v4 = v;
        int v5 = 0;
        int v6 = 0;
        while(v4 < v1) {
            View view0 = this.getChildAt(v4);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            v5 += view0.getMeasuredWidth() + frameLayout$LayoutParams0.leftMargin + frameLayout$LayoutParams0.rightMargin;
            v6 = Math.max(view0.getMeasuredHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin, v6);
            ++v4;
        }
        int v7 = 2;
        switch(this.gravity & 7) {
            case 1: {
                v8 = this.getPaddingLeft() + (this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight() - v5) / 2;
                break;
            }
            case 5: {
                v8 = this.getMeasuredWidth() - this.getPaddingRight() - v5;
                break;
            }
            case 3: 
            case 7: {
                v8 = this.getPaddingLeft();
                break;
            }
            default: {
                v8 = this.getPaddingLeft();
            }
        }
        if((this.gravity & 7) == 7) {
            int v9 = v1 - v;
            if(v9 > 1) {
                int v10 = this.getMeasuredWidth();
                int v11 = this.getPaddingLeft();
                int v12 = this.getPaddingRight();
                if(!this.justify) {
                    v7 = 0;
                }
                v13 = (v10 - v11 - v12 - v5) / (v9 - 1 + v7);
            }
            else {
                v13 = 0;
            }
        }
        else {
            v13 = 0;
        }
        if(this.justify) {
            v3 = v13;
        }
        while(v < v1) {
            View view1 = this.getChildAt(v);
            FrameLayout.LayoutParams frameLayout$LayoutParams1 = (FrameLayout.LayoutParams)view1.getLayoutParams();
            int v14 = v8 + v3 + frameLayout$LayoutParams1.leftMargin;
            view1.layout(v14, v2, view1.getMeasuredWidth() + v14, view1.getMeasuredHeight() + v2);
            v3 += view1.getMeasuredWidth() + frameLayout$LayoutParams1.leftMargin + frameLayout$LayoutParams1.rightMargin + v13;
            ++v;
        }
    }

    @Override  // android.view.ViewGroup
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v11;
        int v10;
        int v4 = this.getPaddingLeft();
        int v5 = this.getPaddingRight();
        int v6 = this.getPaddingTop();
        int v7 = this.getPaddingBottom();
        int v8 = this.getMeasuredWidth();
        int v9 = this.getMeasuredHeight() - v6 - v7;
        switch(this.gravity & 0x70) {
            case 16: {
                v10 = (v9 - this.childrenHeightSum) / 2;
                break;
            }
            case 80: {
                v10 = this.getMeasuredHeight() - v7 - this.childrenHeightSum;
                break;
            }
            default: {
                v10 = 0;
            }
        }
        if((this.gravity & 0x70) == 0x70) {
            v10 = (v9 - this.childrenHeightSum) / (this.floorCount + 1);
            v11 = v10;
        }
        else {
            v11 = 0;
        }
        int v12 = this.getChildCount();
        int v14 = 0;
        int v15 = 0;
        for(int v13 = 0; v13 < v12; ++v13) {
            View view0 = this.getChildAt(v13);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            int v16 = view0.getMeasuredWidth() + frameLayout$LayoutParams0.leftMargin + frameLayout$LayoutParams0.rightMargin;
            if(v15 + v16 > v8 - v4 - v5) {
                this.layoutFloor(v14, v13, v10);
                v10 = view0.getMeasuredHeight() + v11 + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin + v10;
                v15 = 0;
                v14 = v13;
            }
            v15 += v16;
        }
        this.layoutFloor(v14, v12, v10);
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getSize(v) - this.getPaddingLeft() - this.getPaddingRight();
        int v3 = View.MeasureSpec.getSize(v1);
        int v4 = this.getPaddingTop();
        int v5 = this.getPaddingBottom();
        int v6 = 1;
        int v7 = 0;
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        for(int v8 = 0; v8 < this.getChildCount(); ++v8) {
            View view0 = this.getChildAt(v8);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            this.measureChildWithMargins(view0, View.MeasureSpec.makeMeasureSpec(v2, 0x80000000), 0, View.MeasureSpec.makeMeasureSpec(v3 - v4 - v5, 0x80000000), v7);
            int v12 = view0.getMeasuredWidth() + ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).leftMargin + ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).rightMargin;
            if(v11 + v12 > v2) {
                v7 += v9;
                ++v6;
                v9 = 0;
                v11 = 0;
            }
            v11 += v12;
            v10 = Math.max(v11, v10);
            v9 = Math.max(view0.getMeasuredHeight() + ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).topMargin + ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin, v9);
        }
        int v13 = v7 + v9;
        this.floorCount = v6;
        this.childrenHeightSum = v13;
        int v14 = this.getSuggestedMinimumWidth();
        int v15 = this.getPaddingLeft();
        int v16 = Math.max(v14, this.getPaddingRight() + (v15 + v10));
        int v17 = this.getSuggestedMinimumHeight();
        int v18 = this.getPaddingTop();
        int v19 = Math.max(v17, this.getPaddingBottom() + (v18 + v13));
        if(View.MeasureSpec.getMode(v) == 0x40000000) {
            v16 = View.MeasureSpec.getSize(v);
        }
        if(View.MeasureSpec.getMode(v1) == 0x40000000) {
            v19 = View.MeasureSpec.getSize(v1);
        }
        this.setMeasuredDimension(v16, v19);
    }

    public void setJustify(boolean z) {
        this.justify = z;
    }
}

