package com.google.android.material.datepicker;

import P0.d0;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.widget.f;
import b2.b;
import c2.W;
import com.google.android.material.internal.B;
import java.util.Calendar;

final class MaterialCalendarGridView extends GridView {
    public final Calendar a;
    public final boolean b;

    public MaterialCalendarGridView(Context context0) {
        this(context0, null);
    }

    public MaterialCalendarGridView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public MaterialCalendarGridView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = E.g(null);
        if(s.o(this.getContext(), 0x101020D)) {
            this.setNextFocusLeftId(0x7F0A01F5);  // id:cancel_button
            this.setNextFocusRightId(0x7F0A0311);  // id:confirm_button
        }
        this.b = s.o(this.getContext(), 0x7F040487);  // attr:nestedScrollable
        W.o(this, new f(3));
    }

    public final v a() {
        return (v)super.getAdapter();
    }

    public final View b(int v) {
        return this.getChildAt(v - this.getFirstVisiblePosition());
    }

    @Override  // android.widget.GridView
    public final Adapter getAdapter() {
        return (v)super.getAdapter();
    }

    @Override  // android.widget.GridView
    public final ListAdapter getAdapter() {
        return (v)super.getAdapter();
    }

    @Override  // android.widget.AbsListView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((v)super.getAdapter()).notifyDataSetChanged();
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        int v21;
        int v20;
        int v11;
        int v10;
        int v7;
        int v6;
        int v5;
        super.onDraw(canvas0);
        v v0 = (v)super.getAdapter();
        Month month0 = v0.a;
        d0 d00 = v0.d;
        int v1 = Math.max(v0.a(), this.getFirstVisiblePosition());
        int v2 = Math.min(v0.c(), this.getLastVisiblePosition());
        Long long0 = v0.b(v1);
        Long long1 = v0.b(v2);
        for(Object object0: v0.b.G()) {
            Object object1 = ((b)object0).a;
            Object object2 = ((b)object0).b;
            if(object1 != null && object2 != null) {
                long v3 = (long)(((Long)object1));
                long v4 = (long)(((Long)object2));
                if(long0 != null && long1 != null && ((long)(((Long)object1))) <= ((long)long1) && ((long)(((Long)object2))) >= ((long)long0)) {
                    boolean z = B.l(this);
                    Calendar calendar0 = this.a;
                    if(Long.compare(v3, ((long)long0)) < 0) {
                        if(v1 % month0.d == 0) {
                            v5 = 0;
                        }
                        else {
                            v5 = z ? this.b(v1 - 1).getLeft() : this.b(v1 - 1).getRight();
                        }
                        v6 = v5;
                        v7 = v1;
                    }
                    else {
                        calendar0.setTimeInMillis(v3);
                        int v8 = calendar0.get(5);
                        v7 = v0.a() + (v8 - 1);
                        View view0 = this.b(v7);
                        int v9 = view0.getLeft();
                        v6 = view0.getWidth() / 2 + v9;
                    }
                    if(v4 > ((long)long1)) {
                        if((v2 + 1) % month0.d == 0) {
                            v10 = this.getWidth();
                        }
                        else {
                            v10 = z ? this.b(v2).getLeft() : this.b(v2).getRight();
                        }
                        v11 = v2;
                    }
                    else {
                        calendar0.setTimeInMillis(v4);
                        int v12 = calendar0.get(5);
                        v11 = v0.a() + (v12 - 1);
                        View view1 = this.b(v11);
                        int v13 = view1.getLeft();
                        v10 = view1.getWidth() / 2 + v13;
                    }
                    int v14 = (int)v0.getItemId(v7);
                    int v15 = (int)v0.getItemId(v11);
                    while(v14 <= v15) {
                        int v16 = this.getNumColumns() * v14;
                        int v17 = this.getNumColumns() + v16 - 1;
                        View view2 = this.b(v16);
                        int v18 = view2.getTop() + ((Rect)((androidx.recyclerview.widget.b)d00.b).b).top;
                        int v19 = view2.getBottom() - ((Rect)((androidx.recyclerview.widget.b)d00.b).b).bottom;
                        if(z) {
                            v20 = v11 <= v17 ? v10 : 0;
                            v21 = v16 <= v7 ? v6 : this.getWidth();
                        }
                        else {
                            v20 = v16 <= v7 ? v6 : 0;
                            v21 = v11 > v17 ? this.getWidth() : v10;
                        }
                        canvas0.drawRect(((float)v20), ((float)v18), ((float)v21), ((float)v19), ((Paint)d00.i));
                        ++v14;
                    }
                }
            }
        }
    }

    @Override  // android.widget.GridView
    public final void onFocusChanged(boolean z, int v, Rect rect0) {
        if(z) {
            switch(v) {
                case 33: {
                    this.setSelection(((v)super.getAdapter()).c());
                    return;
                }
                case 130: {
                    this.setSelection(((v)super.getAdapter()).a());
                    return;
                }
                default: {
                    super.onFocusChanged(true, v, rect0);
                    return;
                }
            }
        }
        super.onFocusChanged(false, v, rect0);
    }

    @Override  // android.widget.GridView
    public final boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(!super.onKeyDown(v, keyEvent0)) {
            return false;
        }
        if(this.getSelectedItemPosition() != -1 && this.getSelectedItemPosition() < ((v)super.getAdapter()).a()) {
            if(19 == v) {
                this.setSelection(((v)super.getAdapter()).a());
                return true;
            }
            return false;
        }
        return true;
    }

    @Override  // android.widget.GridView
    public final void onMeasure(int v, int v1) {
        if(this.b) {
            super.onMeasure(v, View.MeasureSpec.makeMeasureSpec(0xFFFFFF, 0x80000000));
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
            viewGroup$LayoutParams0.height = this.getMeasuredHeight();
            return;
        }
        super.onMeasure(v, v1);
    }

    @Override  // android.widget.GridView
    public final void setAdapter(Adapter adapter0) {
        this.setAdapter(((ListAdapter)adapter0));
    }

    @Override  // android.widget.GridView
    public final void setAdapter(ListAdapter listAdapter0) {
        if(!(listAdapter0 instanceof v)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), v.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter0);
    }

    @Override  // android.widget.GridView
    public final void setSelection(int v) {
        if(v < ((v)super.getAdapter()).a()) {
            super.setSelection(((v)super.getAdapter()).a());
            return;
        }
        super.setSelection(v);
    }
}

