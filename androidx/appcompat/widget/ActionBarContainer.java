package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    public boolean a;
    public ScrollingTabContainerView b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public final boolean h;
    public boolean i;
    public final int j;

    public ActionBarContainer(Context context0) {
        this(context0, null);
    }

    public ActionBarContainer(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.setBackground(new a(this));
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, g.a.a);
        boolean z = false;
        this.e = typedArray0.getDrawable(0);
        this.f = typedArray0.getDrawable(2);
        this.j = typedArray0.getDimensionPixelSize(13, -1);
        if(this.getId() == 0x7F0A0ACF) {  // id:split_action_bar
            this.h = true;
            this.g = typedArray0.getDrawable(1);
        }
        typedArray0.recycle();
        if(!this.h) {
            if(this.e == null && this.f == null) {
                z = true;
            }
        }
        else if(this.g == null) {
            z = true;
        }
        this.setWillNotDraw(z);
    }

    public static int a(View view0) {
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        return view0.getMeasuredHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin;
    }

    @Override  // android.view.ViewGroup
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.e != null && this.e.isStateful()) {
            this.e.setState(this.getDrawableState());
        }
        if(this.f != null && this.f.isStateful()) {
            this.f.setState(this.getDrawableState());
        }
        if(this.g != null && this.g.isStateful()) {
            this.g.setState(this.getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.b;
    }

    @Override  // android.view.ViewGroup
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable0 = this.e;
        if(drawable0 != null) {
            drawable0.jumpToCurrentState();
        }
        Drawable drawable1 = this.f;
        if(drawable1 != null) {
            drawable1.jumpToCurrentState();
        }
        Drawable drawable2 = this.g;
        if(drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.c = this.findViewById(0x7F0A0053);  // id:action_bar
        this.d = this.findViewById(0x7F0A005C);  // id:action_context_bar
    }

    @Override  // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent0) {
        super.onHoverEvent(motionEvent0);
        return true;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        return this.a || super.onInterceptTouchEvent(motionEvent0);
    }

    @Override  // android.widget.FrameLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        ScrollingTabContainerView scrollingTabContainerView0 = this.b;
        int v4 = 1;
        int v5 = 0;
        boolean z1 = scrollingTabContainerView0 != null && scrollingTabContainerView0.getVisibility() != 8;
        if(scrollingTabContainerView0 != null && scrollingTabContainerView0.getVisibility() != 8) {
            int v6 = this.getMeasuredHeight();
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)scrollingTabContainerView0.getLayoutParams();
            scrollingTabContainerView0.layout(v, v6 - scrollingTabContainerView0.getMeasuredHeight() - frameLayout$LayoutParams0.bottomMargin, v2, v6 - frameLayout$LayoutParams0.bottomMargin);
        }
        if(this.h) {
            Drawable drawable0 = this.g;
            if(drawable0 == null) {
                v4 = 0;
            }
            else {
                drawable0.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            }
        }
        else {
            if(this.e != null) {
                if(this.c.getVisibility() == 0) {
                    this.e.setBounds(this.c.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
                }
                else if(this.d == null || this.d.getVisibility() != 0) {
                    this.e.setBounds(0, 0, 0, 0);
                }
                else {
                    this.e.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
                }
                v5 = 1;
            }
            this.i = z1;
            if(z1) {
                Drawable drawable1 = this.f;
                if(drawable1 == null) {
                    v4 = v5;
                }
                else {
                    drawable1.setBounds(scrollingTabContainerView0.getLeft(), scrollingTabContainerView0.getTop(), scrollingTabContainerView0.getRight(), scrollingTabContainerView0.getBottom());
                }
            }
            else {
                v4 = v5;
            }
        }
        if(v4 != 0) {
            this.invalidate();
        }
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        int v4;
        if(this.c == null && View.MeasureSpec.getMode(v1) == 0x80000000) {
            int v2 = this.j;
            if(v2 >= 0) {
                v1 = View.MeasureSpec.makeMeasureSpec(Math.min(v2, View.MeasureSpec.getSize(v1)), 0x80000000);
            }
        }
        super.onMeasure(v, v1);
        if(this.c != null) {
            int v3 = View.MeasureSpec.getMode(v1);
            if(this.b != null && this.b.getVisibility() != 8 && v3 != 0x40000000) {
                View view0 = this.c;
                if(view0 == null || view0.getVisibility() == 8 || view0.getMeasuredHeight() == 0) {
                    View view1 = this.d;
                    v4 = view1 == null || view1.getVisibility() == 8 || view1.getMeasuredHeight() == 0 ? 0 : ActionBarContainer.a(this.d);
                }
                else {
                    v4 = ActionBarContainer.a(this.c);
                }
                int v5 = v3 == 0x80000000 ? View.MeasureSpec.getSize(v1) : 0x7FFFFFFF;
                this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(ActionBarContainer.a(this.b) + v4, v5));
            }
        }
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        super.onTouchEvent(motionEvent0);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable0) {
        Drawable drawable1 = this.e;
        if(drawable1 != null) {
            drawable1.setCallback(null);
            this.unscheduleDrawable(this.e);
        }
        this.e = drawable0;
        if(drawable0 != null) {
            drawable0.setCallback(this);
            View view0 = this.c;
            if(view0 != null) {
                this.e.setBounds(view0.getLeft(), this.c.getTop(), this.c.getRight(), this.c.getBottom());
            }
        }
        boolean z = false;
        if(!this.h) {
            if(this.e == null && this.f == null) {
                z = true;
            }
        }
        else if(this.g == null) {
            z = true;
        }
        this.setWillNotDraw(z);
        this.invalidate();
        this.invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable0) {
        Drawable drawable1 = this.g;
        if(drawable1 != null) {
            drawable1.setCallback(null);
            this.unscheduleDrawable(this.g);
        }
        this.g = drawable0;
        boolean z = this.h;
        boolean z1 = false;
        if(drawable0 != null) {
            drawable0.setCallback(this);
            if(z) {
                Drawable drawable2 = this.g;
                if(drawable2 != null) {
                    drawable2.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
                }
            }
        }
        if(!z) {
            if(this.e == null && this.f == null) {
                z1 = true;
            }
        }
        else if(this.g == null) {
            z1 = true;
        }
        this.setWillNotDraw(z1);
        this.invalidate();
        this.invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable0) {
        Drawable drawable1 = this.f;
        if(drawable1 != null) {
            drawable1.setCallback(null);
            this.unscheduleDrawable(this.f);
        }
        this.f = drawable0;
        if(drawable0 != null) {
            drawable0.setCallback(this);
            if(this.i) {
                Drawable drawable2 = this.f;
                if(drawable2 != null) {
                    drawable2.setBounds(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
                }
            }
        }
        boolean z = false;
        if(!this.h) {
            if(this.e == null && this.f == null) {
                z = true;
            }
        }
        else if(this.g == null) {
            z = true;
        }
        this.setWillNotDraw(z);
        this.invalidate();
        this.invalidateOutline();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView0) {
        ScrollingTabContainerView scrollingTabContainerView1 = this.b;
        if(scrollingTabContainerView1 != null) {
            this.removeView(scrollingTabContainerView1);
        }
        this.b = scrollingTabContainerView0;
        if(scrollingTabContainerView0 != null) {
            this.addView(scrollingTabContainerView0);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = scrollingTabContainerView0.getLayoutParams();
            viewGroup$LayoutParams0.width = -1;
            viewGroup$LayoutParams0.height = -2;
            scrollingTabContainerView0.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.a = z;
        this.setDescendantFocusability((z ? 0x60000 : 0x40000));
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        Drawable drawable0 = this.e;
        if(drawable0 != null) {
            drawable0.setVisible(v == 0, false);
        }
        Drawable drawable1 = this.f;
        if(drawable1 != null) {
            drawable1.setVisible(v == 0, false);
        }
        Drawable drawable2 = this.g;
        if(drawable2 != null) {
            drawable2.setVisible(v == 0, false);
        }
    }

    @Override  // android.view.ViewGroup
    public final ActionMode startActionModeForChild(View view0, ActionMode.Callback actionMode$Callback0) {
        return null;
    }

    @Override  // android.view.ViewGroup
    public final ActionMode startActionModeForChild(View view0, ActionMode.Callback actionMode$Callback0, int v) {
        return v == 0 ? null : super.startActionModeForChild(view0, actionMode$Callback0, v);
    }

    // 去混淆评级： 中等(70)
    @Override  // android.view.View
    public final boolean verifyDrawable(Drawable drawable0) {
        return drawable0 == this.e && !this.h || drawable0 == this.f && this.i || drawable0 == this.g && this.h || super.verifyDrawable(drawable0);
    }
}

