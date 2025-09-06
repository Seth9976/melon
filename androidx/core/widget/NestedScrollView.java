package androidx.core.widget;

import U4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import c2.A;
import c2.W;
import c2.q;
import c2.r;
import c2.t;
import c2.u;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements q, t {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public int a;

        static {
            SavedState.CREATOR = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("HorizontalScrollView.SavedState{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder0.append(" scrollPosition=");
            return x.g(this.a, "}", stringBuilder0);
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.a);
        }
    }

    public final int B;
    public int D;
    public final int[] E;
    public final int[] G;
    public int I;
    public int M;
    public SavedState N;
    public final u S;
    public final r T;
    public float V;
    public h W;
    public final float a;
    public long b;
    public final c2.h b0;
    public final Rect c;
    public static final float c0;
    public final OverScroller d;
    public static final f d0;
    public final EdgeEffect e;
    public static final int[] e0;
    public final EdgeEffect f;
    public A g;
    public int h;
    public boolean i;
    public boolean j;
    public View k;
    public boolean l;
    public VelocityTracker m;
    public boolean n;
    public boolean o;
    public final int r;
    public final int w;

    static {
        NestedScrollView.c0 = 2.358202f;
        NestedScrollView.d0 = new f(0);
        NestedScrollView.e0 = new int[]{0x101017A};
    }

    public NestedScrollView(Context context0) {
        this(context0, null);
    }

    public NestedScrollView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040486);  // attr:nestedScrollViewStyle
    }

    public NestedScrollView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.c = new Rect();
        this.i = true;
        this.j = false;
        this.k = null;
        this.l = false;
        this.o = true;
        this.D = -1;
        this.E = new int[2];
        this.G = new int[2];
        Ua.h h0 = new Ua.h(this);
        this.b0 = new c2.h(this.getContext(), h0);
        int v1 = Build.VERSION.SDK_INT;
        this.e = v1 < 0x1F ? new EdgeEffect(context0) : d.a(context0, attributeSet0);
        this.f = v1 < 0x1F ? new EdgeEffect(context0) : d.a(context0, attributeSet0);
        this.a = context0.getResources().getDisplayMetrics().density * 51890.199219f;
        this.d = new OverScroller(this.getContext());
        this.setFocusable(true);
        this.setDescendantFocusability(0x40000);
        this.setWillNotDraw(false);
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(this.getContext());
        this.r = viewConfiguration0.getScaledTouchSlop();
        this.w = viewConfiguration0.getScaledMinimumFlingVelocity();
        this.B = viewConfiguration0.getScaledMaximumFlingVelocity();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, NestedScrollView.e0, v, 0);
        this.setFillViewport(typedArray0.getBoolean(0, false));
        typedArray0.recycle();
        this.S = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.T = new r(this);
        this.setNestedScrollingEnabled(true);
        W.o(this, NestedScrollView.d0);
    }

    public final boolean a(int v) {
        View view0 = this.findFocus();
        if(view0 == this) {
            view0 = null;
        }
        View view1 = FocusFinder.getInstance().findNextFocus(this, view0, v);
        int v1 = this.getMaxScrollAmount();
        if(view1 == null || !this.h(view1, v1, this.getHeight())) {
            if(v == 33 && this.getScrollY() < v1) {
                v1 = this.getScrollY();
            }
            else if(v == 130 && this.getChildCount() > 0) {
                View view2 = this.getChildAt(0);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view2.getLayoutParams();
                int v2 = view2.getBottom() + frameLayout$LayoutParams0.bottomMargin;
                int v3 = this.getScrollY();
                v1 = Math.min(v2 - (this.getHeight() + v3 - this.getPaddingBottom()), v1);
            }
            if(v1 == 0) {
                return false;
            }
            if(v != 130) {
                v1 = -v1;
            }
            this.n(v1, -1, null, 0, 1, true);
        }
        else {
            view1.getDrawingRect(this.c);
            this.offsetDescendantRectToMyCoords(view1, this.c);
            this.n(this.b(this.c), -1, null, 0, 1, true);
            view1.requestFocus(v);
        }
        if(view0 != null && view0.isFocused() && !this.h(view0, 0, this.getHeight())) {
            int v4 = this.getDescendantFocusability();
            this.setDescendantFocusability(0x20000);
            this.requestFocus();
            this.setDescendantFocusability(v4);
        }
        return true;
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0, v);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view0, viewGroup$LayoutParams0);
    }

    public final int b(Rect rect0) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        int v = this.getHeight();
        int v1 = this.getScrollY();
        int v2 = v1 + v;
        int v3 = this.getVerticalFadingEdgeLength();
        if(rect0.top > 0) {
            v1 += v3;
        }
        View view0 = this.getChildAt(0);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        int v4 = rect0.bottom >= view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin ? v2 : v2 - v3;
        int v5 = rect0.bottom;
        if(v5 > v4 && rect0.top > v1) {
            return rect0.height() <= v ? Math.min(rect0.bottom - v4, view0.getBottom() + frameLayout$LayoutParams0.bottomMargin - v2) : Math.min(rect0.top - v1, view0.getBottom() + frameLayout$LayoutParams0.bottomMargin - v2);
        }
        if(rect0.top < v1 && v5 < v4) {
            return rect0.height() <= v ? Math.max(-(v1 - rect0.top), -this.getScrollY()) : Math.max(-(v4 - rect0.bottom), -this.getScrollY());
        }
        return 0;
    }

    public final boolean c(int v, int v1, int[] arr_v, int[] arr_v1, int v2) {
        return this.T.c(v, v1, arr_v, null, v2);
    }

    @Override  // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override  // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override  // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override  // android.view.View
    public final void computeScroll() {
        int v3;
        if(this.d.isFinished()) {
            return;
        }
        this.d.computeScrollOffset();
        int v = this.d.getCurrY();
        int v1 = v - this.M;
        int v2 = this.getHeight();
        EdgeEffect edgeEffect0 = this.e;
        EdgeEffect edgeEffect1 = this.f;
        if(v1 > 0 && EdgeEffectCompat.a(edgeEffect0) != 0.0f) {
            v3 = Math.round(EdgeEffectCompat.b(edgeEffect0, ((float)(-v1)) * 4.0f / ((float)v2), 0.5f) * (((float)(-v2)) / 4.0f));
            if(v3 != v1) {
                edgeEffect0.finish();
            }
            v1 -= v3;
        }
        else if(v1 < 0 && EdgeEffectCompat.a(edgeEffect1) != 0.0f) {
            v3 = Math.round(EdgeEffectCompat.b(edgeEffect1, ((float)v1) * 4.0f / ((float)v2), 0.5f) * (((float)v2) / 4.0f));
            if(v3 != v1) {
                edgeEffect1.finish();
            }
            v1 -= v3;
        }
        this.M = v;
        int[] arr_v = this.G;
        arr_v[1] = 0;
        this.c(0, v1, arr_v, null, 1);
        int v4 = v1 - arr_v[1];
        int v5 = this.getScrollRange();
        if(Build.VERSION.SDK_INT >= 35) {
            g.a(this, Math.abs(this.d.getCurrVelocity()));
        }
        if(v4 != 0) {
            int v6 = this.getScrollY();
            this.k(v4, this.getScrollX(), v6, v5);
            int v7 = this.getScrollY() - v6;
            int v8 = v4 - v7;
            arr_v[1] = 0;
            this.T.d(0, v7, 0, v8, this.E, 1, arr_v);
            v4 = v8 - arr_v[1];
        }
        if(v4 != 0) {
            int v9 = this.getOverScrollMode();
            if(v9 == 0 || v9 == 1 && v5 > 0) {
                if(v4 >= 0) {
                    if(edgeEffect1.isFinished()) {
                        edgeEffect1.onAbsorb(((int)this.d.getCurrVelocity()));
                    }
                }
                else if(edgeEffect0.isFinished()) {
                    edgeEffect0.onAbsorb(((int)this.d.getCurrVelocity()));
                }
            }
            this.d.abortAnimation();
            this.r(1);
        }
        if(!this.d.isFinished()) {
            this.postInvalidateOnAnimation();
            return;
        }
        this.r(1);
    }

    @Override  // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override  // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override  // android.view.View
    public final int computeVerticalScrollRange() {
        int v = this.getChildCount();
        int v1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
        if(v == 0) {
            return v1;
        }
        View view0 = this.getChildAt(0);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        int v2 = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin;
        int v3 = this.getScrollY();
        int v4 = Math.max(0, v2 - v1);
        if(v3 < 0) {
            return v2 - v3;
        }
        return v3 <= v4 ? v2 : v3 - v4 + v2;
    }

    public final boolean d(KeyEvent keyEvent0) {
        this.c.setEmpty();
        int v = 130;
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            if(view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin <= this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()) {
                goto label_21;
            }
            else if(keyEvent0.getAction() == 0) {
                switch(keyEvent0.getKeyCode()) {
                    case 19: {
                        return keyEvent0.isAltPressed() ? this.f(33) : this.a(33);
                    }
                    case 20: {
                        return keyEvent0.isAltPressed() ? this.f(130) : this.a(130);
                    }
                    case 62: {
                        if(keyEvent0.isShiftPressed()) {
                            v = 33;
                        }
                        this.l(v);
                        return false;
                    }
                    case 92: {
                        return this.f(33);
                    }
                    case 93: {
                        return this.f(130);
                    }
                    case 0x7A: {
                        this.l(33);
                        return false;
                    }
                    case 0x7B: {
                        this.l(130);
                        return false;
                    }
                    default: {
                        return false;
                    }
                }
            }
        }
        else {
        label_21:
            if(this.isFocused() && keyEvent0.getKeyCode() != 4) {
                View view1 = this.findFocus();
                if(view1 == this) {
                    view1 = null;
                }
                View view2 = FocusFinder.getInstance().findNextFocus(this, view1, 130);
                return view2 != null && view2 != this && view2.requestFocus(130);
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        return super.dispatchKeyEvent(keyEvent0) || this.d(keyEvent0);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedFling(float f, float f1, boolean z) {
        return this.T.a(f, f1, z);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f1) {
        return this.T.b(f, f1);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedPreScroll(int v, int v1, int[] arr_v, int[] arr_v1) {
        return this.T.c(v, v1, arr_v, arr_v1, 0);
    }

    @Override  // android.view.View
    public final boolean dispatchNestedScroll(int v, int v1, int v2, int v3, int[] arr_v) {
        return this.T.d(v, v1, v2, v3, arr_v, 0, null);
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        int v7;
        super.draw(canvas0);
        int v = this.getScrollY();
        EdgeEffect edgeEffect0 = this.e;
        int v1 = 0;
        if(!edgeEffect0.isFinished()) {
            int v2 = canvas0.save();
            int v3 = this.getWidth();
            int v4 = this.getHeight();
            int v5 = Math.min(0, v);
            if(this.getClipToPadding()) {
                int v6 = this.getPaddingLeft();
                v3 -= this.getPaddingRight() + v6;
                v7 = this.getPaddingLeft();
            }
            else {
                v7 = 0;
            }
            if(this.getClipToPadding()) {
                int v8 = this.getPaddingTop();
                v4 -= this.getPaddingBottom() + v8;
                v5 += this.getPaddingTop();
            }
            canvas0.translate(((float)v7), ((float)v5));
            edgeEffect0.setSize(v3, v4);
            if(edgeEffect0.draw(canvas0)) {
                this.postInvalidateOnAnimation();
            }
            canvas0.restoreToCount(v2);
        }
        EdgeEffect edgeEffect1 = this.f;
        if(!edgeEffect1.isFinished()) {
            int v9 = canvas0.save();
            int v10 = this.getWidth();
            int v11 = this.getHeight();
            int v12 = Math.max(this.getScrollRange(), v) + v11;
            if(this.getClipToPadding()) {
                int v13 = this.getPaddingLeft();
                v10 -= this.getPaddingRight() + v13;
                v1 = this.getPaddingLeft();
            }
            if(this.getClipToPadding()) {
                int v14 = this.getPaddingTop();
                v11 -= this.getPaddingBottom() + v14;
                v12 -= this.getPaddingBottom();
            }
            canvas0.translate(((float)(v1 - v10)), ((float)v12));
            canvas0.rotate(180.0f, ((float)v10), 0.0f);
            edgeEffect1.setSize(v10, v11);
            if(edgeEffect1.draw(canvas0)) {
                this.postInvalidateOnAnimation();
            }
            canvas0.restoreToCount(v9);
        }
    }

    public final void e(int v) {
        if(this.getChildCount() > 0) {
            int v1 = this.getScrollX();
            int v2 = this.getScrollY();
            this.d.fling(v1, v2, 0, v, 0, 0, 0x80000000, 0x7FFFFFFF, 0, 0);
            this.T.h(2, 1);
            this.M = this.getScrollY();
            this.postInvalidateOnAnimation();
            if(Build.VERSION.SDK_INT >= 35) {
                g.a(this, Math.abs(this.d.getCurrVelocity()));
            }
        }
    }

    public final boolean f(int v) {
        int v1 = this.getHeight();
        Rect rect0 = this.c;
        rect0.top = 0;
        rect0.bottom = v1;
        if(v == 130) {
            int v2 = this.getChildCount();
            if(v2 > 0) {
                View view0 = this.getChildAt(v2 - 1);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
                int v3 = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin;
                int v4 = this.getPaddingBottom() + v3;
                rect0.bottom = v4;
                rect0.top = v4 - v1;
            }
        }
        return this.m(v, rect0.top, rect0.bottom);
    }

    public static boolean g(View view0, NestedScrollView nestedScrollView0) {
        if(view0 != nestedScrollView0) {
            ViewParent viewParent0 = view0.getParent();
            return viewParent0 instanceof ViewGroup && NestedScrollView.g(((View)viewParent0), nestedScrollView0);
        }
        return true;
    }

    @Override  // android.view.View
    public float getBottomFadingEdgeStrength() {
        if(this.getChildCount() == 0) {
            return 0.0f;
        }
        View view0 = this.getChildAt(0);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
        int v = this.getVerticalFadingEdgeLength();
        int v1 = this.getHeight();
        int v2 = this.getPaddingBottom();
        int v3 = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin - this.getScrollY() - (v1 - v2);
        return v3 >= v ? 1.0f : ((float)v3) / ((float)v);
    }

    public int getMaxScrollAmount() {
        return (int)(((float)this.getHeight()) * 0.5f);
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.S.a();
    }

    private A getScrollFeedbackProvider() {
        if(this.g == null) {
            this.g = new A(this);
        }
        return this.g;
    }

    public int getScrollRange() {
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            return Math.max(0, view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin - (this.getHeight() - this.getPaddingTop() - this.getPaddingBottom()));
        }
        return 0;
    }

    @Override  // android.view.View
    public float getTopFadingEdgeStrength() {
        if(this.getChildCount() == 0) {
            return 0.0f;
        }
        int v = this.getVerticalFadingEdgeLength();
        int v1 = this.getScrollY();
        return v1 >= v ? 1.0f : ((float)v1) / ((float)v);
    }

    public float getVerticalScrollFactorCompat() {
        if(this.V == 0.0f) {
            TypedValue typedValue0 = new TypedValue();
            Context context0 = this.getContext();
            if(!context0.getTheme().resolveAttribute(0x101004D, typedValue0, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.V = typedValue0.getDimension(context0.getResources().getDisplayMetrics());
            return this.V;
        }
        return this.V;
    }

    public final boolean h(View view0, int v, int v1) {
        view0.getDrawingRect(this.c);
        this.offsetDescendantRectToMyCoords(view0, this.c);
        return this.c.bottom + v >= this.getScrollY() && this.c.top - v <= this.getScrollY() + v1;
    }

    @Override  // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.T.f(0);
    }

    public final void i(int v, int v1, int[] arr_v) {
        int v2 = this.getScrollY();
        this.scrollBy(0, v);
        int v3 = this.getScrollY() - v2;
        if(arr_v != null) {
            arr_v[1] += v3;
        }
        this.T.d(0, v3, 0, v - v3, null, v1, arr_v);
    }

    @Override  // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.T.d;
    }

    public final void j(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionIndex();
        if(motionEvent0.getPointerId(v) == this.D) {
            int v1 = v == 0 ? 1 : 0;
            this.h = (int)motionEvent0.getY(v1);
            this.D = motionEvent0.getPointerId(v1);
            VelocityTracker velocityTracker0 = this.m;
            if(velocityTracker0 != null) {
                velocityTracker0.clear();
            }
        }
    }

    public final boolean k(int v, int v1, int v2, int v3) {
        boolean z1;
        int v6;
        boolean z;
        int v5;
        this.getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        this.computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int v4 = v2 + v;
        if(v1 > 0) {
            v5 = 0;
            z = true;
        }
        else if(v1 >= 0) {
            v5 = v1;
            z = false;
        }
        else {
            v5 = 0;
            z = true;
        }
        if(v4 > v3) {
            v6 = v3;
            z1 = true;
        }
        else if(v4 < 0) {
            v6 = 0;
            z1 = true;
        }
        else {
            v6 = v4;
            z1 = false;
        }
        if(z1 && !this.T.f(1)) {
            int v7 = this.getScrollRange();
            this.d.springBack(v5, v6, 0, 0, 0, v7);
        }
        super.scrollTo(v5, v6);
        return z || z1;
    }

    public final void l(int v) {
        int v1 = this.getHeight();
        Rect rect0 = this.c;
        if(v == 130) {
            rect0.top = this.getScrollY() + v1;
            int v2 = this.getChildCount();
            if(v2 > 0) {
                View view0 = this.getChildAt(v2 - 1);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
                int v3 = view0.getBottom() + frameLayout$LayoutParams0.bottomMargin;
                int v4 = this.getPaddingBottom() + v3;
                if(rect0.top + v1 > v4) {
                    rect0.top = v4 - v1;
                }
            }
        }
        else {
            int v5 = this.getScrollY() - v1;
            rect0.top = v5;
            if(v5 < 0) {
                rect0.top = 0;
            }
        }
        int v6 = v1 + rect0.top;
        rect0.bottom = v6;
        this.m(v, rect0.top, v6);
    }

    public final boolean m(int v, int v1, int v2) {
        boolean z1;
        int v3 = this.getHeight();
        int v4 = this.getScrollY();
        int v5 = v3 + v4;
        ArrayList arrayList0 = this.getFocusables(2);
        int v6 = arrayList0.size();
        NestedScrollView nestedScrollView0 = null;
        int v8 = 0;
        for(int v7 = 0; v7 < v6; ++v7) {
            View view0 = (View)arrayList0.get(v7);
            int v9 = view0.getTop();
            int v10 = view0.getBottom();
            if(v1 < v10 && v9 < v2) {
                int v11 = v1 >= v9 || v10 >= v2 ? 0 : 1;
                if(nestedScrollView0 == null) {
                    nestedScrollView0 = view0;
                    v8 = v11;
                }
                else {
                    boolean z = v == 33 && v9 < nestedScrollView0.getTop() || v != 33 && v10 > nestedScrollView0.getBottom();
                    if(v8 == 0) {
                        if(v11 != 0) {
                            nestedScrollView0 = view0;
                            v8 = 1;
                        }
                        else if(z) {
                            nestedScrollView0 = view0;
                        }
                    }
                    else if(v11 != 0 && z) {
                        nestedScrollView0 = view0;
                    }
                }
            }
        }
        NestedScrollView nestedScrollView1 = nestedScrollView0 == null ? this : nestedScrollView0;
        if(v1 < v4 || v2 > v5) {
            this.n((v == 33 ? v2 - v5 : v1 - v4), -1, null, 0, 1, true);
            z1 = true;
        }
        else {
            z1 = false;
        }
        if(nestedScrollView1 != this.findFocus()) {
            nestedScrollView1.requestFocus(v);
        }
        return z1;
    }

    @Override  // android.view.ViewGroup
    public final void measureChild(View view0, int v, int v1) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        int v2 = this.getPaddingLeft();
        view0.measure(ViewGroup.getChildMeasureSpec(v, this.getPaddingRight() + v2, viewGroup$LayoutParams0.width), 0);
    }

    @Override  // android.view.ViewGroup
    public final void measureChildWithMargins(View view0, int v, int v1, int v2, int v3) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v4 = this.getPaddingLeft();
        view0.measure(ViewGroup.getChildMeasureSpec(v, this.getPaddingRight() + v4 + viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin + v1, viewGroup$MarginLayoutParams0.width), View.MeasureSpec.makeMeasureSpec(viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin, 0));
    }

    public final int n(int v, int v1, MotionEvent motionEvent0, int v2, int v3, boolean z) {
        int v20;
        int v5;
        int v4;
        r r0 = this.T;
        if(v3 == 1) {
            r0.h(2, 1);
        }
        boolean z1 = this.T.c(0, v, this.G, this.E, v3);
        int[] arr_v = this.E;
        int[] arr_v1 = this.G;
        if(z1) {
            v4 = v - arr_v1[1];
            v5 = arr_v[1];
        }
        else {
            v4 = v;
            v5 = 0;
        }
        int v6 = this.getScrollY();
        int v7 = this.getScrollRange();
        int v8 = this.getOverScrollMode();
        boolean z2 = (v8 == 0 || v8 == 1 && this.getScrollRange() > 0) && !z;
        int v9 = !this.k(v4, 0, v6, v7) || r0.f(v3) ? 0 : 1;
        int v10 = this.getScrollY() - v6;
        if(motionEvent0 != null && v10 != 0) {
            A a0 = this.getScrollFeedbackProvider();
            int v11 = motionEvent0.getDeviceId();
            int v12 = motionEvent0.getSource();
            a0.a.onScrollProgress(v11, v12, v1, v10);
        }
        arr_v1[1] = 0;
        this.T.d(0, v10, 0, v4 - v10, this.E, v3, arr_v1);
        int v13 = v5 + arr_v[1];
        int v14 = v4 - arr_v1[1];
        int v15 = v6 + v14;
        EdgeEffect edgeEffect0 = this.f;
        EdgeEffect edgeEffect1 = this.e;
        if(v15 >= 0) {
            if(v15 > v7 && z2) {
                EdgeEffectCompat.b(edgeEffect0, ((float)v14) / ((float)this.getHeight()), 1.0f - ((float)v2) / ((float)this.getWidth()));
                if(motionEvent0 != null) {
                    A a2 = this.getScrollFeedbackProvider();
                    int v18 = motionEvent0.getDeviceId();
                    int v19 = motionEvent0.getSource();
                    a2.a.onScrollLimit(v18, v19, v1, false);
                }
                if(!edgeEffect1.isFinished()) {
                    edgeEffect1.onRelease();
                }
            }
        }
        else if(z2) {
            EdgeEffectCompat.b(edgeEffect1, ((float)(-v14)) / ((float)this.getHeight()), ((float)v2) / ((float)this.getWidth()));
            if(motionEvent0 != null) {
                A a1 = this.getScrollFeedbackProvider();
                int v16 = motionEvent0.getDeviceId();
                int v17 = motionEvent0.getSource();
                a1.a.onScrollLimit(v16, v17, v1, true);
            }
            if(!edgeEffect0.isFinished()) {
                edgeEffect0.onRelease();
            }
        }
        if(!edgeEffect1.isFinished() || !edgeEffect0.isFinished()) {
            this.postInvalidateOnAnimation();
            v20 = 0;
        }
        else {
            v20 = v9;
        }
        if(v20 != 0 && v3 == 0) {
            VelocityTracker velocityTracker0 = this.m;
            if(velocityTracker0 != null) {
                velocityTracker0.clear();
            }
        }
        if(v3 == 1) {
            this.r(1);
            edgeEffect1.onRelease();
            edgeEffect0.onRelease();
        }
        return v13;
    }

    public final boolean o(EdgeEffect edgeEffect0, int v) {
        if(v > 0) {
            return true;
        }
        float f = EdgeEffectCompat.a(edgeEffect0) * ((float)this.getHeight());
        return ((float)(Math.exp(((double)NestedScrollView.c0) / (((double)NestedScrollView.c0) - 1.0) * Math.log(((float)Math.abs(-v)) * 0.35f / (this.a * 0.015f))) * ((double)(this.a * 0.015f)))) < f;
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = false;
    }

    @Override  // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent0) {
        int v1;
        int v;
        float f;
        if(motionEvent0.getAction() == 8 && !this.l) {
            if(E9.h.Q(motionEvent0, 2)) {
                f = motionEvent0.getAxisValue(9);
                v = 9;
                v1 = (int)motionEvent0.getX();
            }
            else if(E9.h.Q(motionEvent0, 0x400000)) {
                float f1 = motionEvent0.getAxisValue(26);
                v1 = this.getWidth() / 2;
                v = 26;
                f = f1;
            }
            else {
                v = 0;
                v1 = 0;
                f = 0.0f;
            }
            if(f != 0.0f) {
                this.n(-((int)(this.getVerticalScrollFactorCompat() * f)), v, motionEvent0, v1, 1, E9.h.Q(motionEvent0, 0x2002));
                if(v != 0) {
                    this.b0.a(motionEvent0, v);
                }
                return true;
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        boolean z = true;
        if(v == 2 && this.l) {
            return true;
        }
        if((v & 0xFF) == 0) {
            int v7 = (int)motionEvent0.getY();
            int v8 = (int)motionEvent0.getX();
            if(this.getChildCount() > 0) {
                int v9 = this.getScrollY();
                View view0 = this.getChildAt(0);
                if(v7 >= view0.getTop() - v9 && v7 < view0.getBottom() - v9 && v8 >= view0.getLeft() && v8 < view0.getRight()) {
                    this.h = v7;
                    this.D = motionEvent0.getPointerId(0);
                    VelocityTracker velocityTracker1 = this.m;
                    if(velocityTracker1 == null) {
                        this.m = VelocityTracker.obtain();
                    }
                    else {
                        velocityTracker1.clear();
                    }
                    this.m.addMovement(motionEvent0);
                    this.d.computeScrollOffset();
                    if(!this.q(motionEvent0) && this.d.isFinished()) {
                        z = false;
                    }
                    this.l = z;
                    this.T.h(2, 0);
                    return this.l;
                }
            }
            if(!this.q(motionEvent0) && this.d.isFinished()) {
                z = false;
            }
            this.l = z;
            VelocityTracker velocityTracker2 = this.m;
            if(velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.m = null;
            }
        }
        else {
            switch(v & 0xFF) {
                case 1: {
                    goto label_8;
                }
                case 2: {
                    goto label_23;
                }
            }
            switch(v & 0xFF) {
                case 3: {
                label_8:
                    this.l = false;
                    this.D = -1;
                    VelocityTracker velocityTracker0 = this.m;
                    if(velocityTracker0 != null) {
                        velocityTracker0.recycle();
                        this.m = null;
                    }
                    int v1 = this.getScrollX();
                    int v2 = this.getScrollY();
                    int v3 = this.getScrollRange();
                    if(this.d.springBack(v1, v2, 0, 0, 0, v3)) {
                        this.postInvalidateOnAnimation();
                    }
                    this.r(0);
                    return this.l;
                }
                case 6: {
                    this.j(motionEvent0);
                    return this.l;
                }
                default: {
                    return this.l;
                }
            }
        label_23:
            int v4 = this.D;
            if(v4 != -1) {
                int v5 = motionEvent0.findPointerIndex(v4);
                if(v5 == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + v4 + " in onInterceptTouchEvent");
                    return this.l;
                }
                int v6 = (int)motionEvent0.getY(v5);
                if(Math.abs(v6 - this.h) > this.r && (2 & this.getNestedScrollAxes()) == 0) {
                    this.l = true;
                    this.h = v6;
                    if(this.m == null) {
                        this.m = VelocityTracker.obtain();
                    }
                    this.m.addMovement(motionEvent0);
                    this.I = 0;
                    ViewParent viewParent0 = this.getParent();
                    if(viewParent0 != null) {
                        viewParent0.requestDisallowInterceptTouchEvent(true);
                        return this.l;
                    }
                }
            }
        }
        return this.l;
    }

    @Override  // android.widget.FrameLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v6;
        super.onLayout(z, v, v1, v2, v3);
        int v4 = 0;
        this.i = false;
        if(this.k != null && NestedScrollView.g(this.k, this)) {
            View view0 = this.k;
            view0.getDrawingRect(this.c);
            this.offsetDescendantRectToMyCoords(view0, this.c);
            int v5 = this.b(this.c);
            if(v5 != 0) {
                this.scrollBy(0, v5);
            }
        }
        this.k = null;
        if(!this.j) {
            if(this.N != null) {
                this.scrollTo(this.getScrollX(), this.N.a);
                this.N = null;
            }
            if(this.getChildCount() > 0) {
                View view1 = this.getChildAt(0);
                FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view1.getLayoutParams();
                v6 = view1.getMeasuredHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin;
            }
            else {
                v6 = 0;
            }
            int v7 = v3 - v1 - this.getPaddingTop() - this.getPaddingBottom();
            int v8 = this.getScrollY();
            if(v7 < v6 && v8 >= 0) {
                v4 = v7 + v8 <= v6 ? v8 : v6 - v7;
            }
            if(v4 != v8) {
                this.scrollTo(this.getScrollX(), v4);
            }
        }
        this.scrollTo(this.getScrollX(), this.getScrollY());
        this.j = true;
    }

    @Override  // android.widget.FrameLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.n && View.MeasureSpec.getMode(v1) != 0 && this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            int v2 = view0.getMeasuredHeight();
            int v3 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom() - frameLayout$LayoutParams0.topMargin - frameLayout$LayoutParams0.bottomMargin;
            if(v2 < v3) {
                int v4 = this.getPaddingLeft();
                view0.measure(ViewGroup.getChildMeasureSpec(v, this.getPaddingRight() + v4 + frameLayout$LayoutParams0.leftMargin + frameLayout$LayoutParams0.rightMargin, frameLayout$LayoutParams0.width), View.MeasureSpec.makeMeasureSpec(v3, 0x40000000));
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedFling(View view0, float f, float f1, boolean z) {
        if(!z) {
            this.dispatchNestedFling(0.0f, f1, true);
            this.e(((int)f1));
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final boolean onNestedPreFling(View view0, float f, float f1) {
        return this.T.b(f, f1);
    }

    @Override  // android.view.ViewGroup
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v) {
        this.c(v, v1, arr_v, null, 0);
    }

    @Override  // c2.s
    public final void onNestedPreScroll(View view0, int v, int v1, int[] arr_v, int v2) {
        this.c(v, v1, arr_v, null, v2);
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3) {
        this.i(v3, 0, null);
    }

    @Override  // c2.s
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4) {
        this.i(v3, v4, null);
    }

    @Override  // c2.t
    public final void onNestedScroll(View view0, int v, int v1, int v2, int v3, int v4, int[] arr_v) {
        this.i(v3, v4, arr_v);
    }

    @Override  // android.view.ViewGroup
    public final void onNestedScrollAccepted(View view0, View view1, int v) {
        this.onNestedScrollAccepted(view0, view1, v, 0);
    }

    @Override  // c2.s
    public final void onNestedScrollAccepted(View view0, View view1, int v, int v1) {
        u u0 = this.S;
        if(v1 == 1) {
            u0.b = v;
        }
        else {
            u0.a = v;
        }
        this.T.h(2, v1);
    }

    @Override  // android.view.View
    public final void onOverScrolled(int v, int v1, boolean z, boolean z1) {
        super.scrollTo(v, v1);
    }

    @Override  // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int v, Rect rect0) {
        switch(v) {
            case 1: {
                v = 33;
                break;
            }
            case 2: {
                v = 130;
            }
        }
        View view0 = rect0 == null ? FocusFinder.getInstance().findNextFocus(this, null, v) : FocusFinder.getInstance().findNextFocusFromRect(this, rect0, v);
        return view0 != null && this.h(view0, 0, this.getHeight()) ? view0.requestFocus(v, rect0) : false;
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.N = (SavedState)parcelable0;
        this.requestLayout();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.getScrollY();
        return parcelable0;
    }

    @Override  // android.view.View
    public void onScrollChanged(int v, int v1, int v2, int v3) {
        super.onScrollChanged(v, v1, v2, v3);
        h h0 = this.W;
        if(h0 != null) {
            h0.j(this, v, v1, v2, v3);
        }
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        View view0 = this.findFocus();
        if(view0 != null && this != view0 && this.h(view0, 0, v3)) {
            view0.getDrawingRect(this.c);
            this.offsetDescendantRectToMyCoords(view0, this.c);
            int v4 = this.b(this.c);
            if(v4 != 0) {
                if(this.o) {
                    this.p(0, v4, false);
                    return;
                }
                this.scrollBy(0, v4);
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean onStartNestedScroll(View view0, View view1, int v) {
        return this.onStartNestedScroll(view0, view1, v, 0);
    }

    @Override  // c2.s
    public final boolean onStartNestedScroll(View view0, View view1, int v, int v1) {
        return (v & 2) != 0;
    }

    @Override  // android.view.ViewGroup
    public final void onStopNestedScroll(View view0) {
        this.onStopNestedScroll(view0, 0);
    }

    @Override  // c2.s
    public final void onStopNestedScroll(View view0, int v) {
        u u0 = this.S;
        if(v == 1) {
            u0.b = 0;
        }
        else {
            u0.a = 0;
        }
        this.r(v);
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        float f3;
        if(this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        int v = motionEvent0.getActionMasked();
        if(v == 0) {
            this.I = 0;
        }
        MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
        float f = 0.0f;
        motionEvent1.offsetLocation(0.0f, ((float)this.I));
        r r0 = this.T;
        if(v == 0) {
            if(this.getChildCount() == 0) {
                return false;
            }
            if(this.l) {
                ViewParent viewParent1 = this.getParent();
                if(viewParent1 != null) {
                    viewParent1.requestDisallowInterceptTouchEvent(true);
                }
            }
            if(!this.d.isFinished()) {
                this.d.abortAnimation();
                this.r(1);
            }
            int v15 = (int)motionEvent0.getY();
            int v16 = motionEvent0.getPointerId(0);
            this.h = v15;
            this.D = v16;
            r0.h(2, 0);
        }
        else {
            EdgeEffect edgeEffect0 = this.e;
            EdgeEffect edgeEffect1 = this.f;
            switch(v) {
                case 1: {
                    VelocityTracker velocityTracker0 = this.m;
                    velocityTracker0.computeCurrentVelocity(1000, ((float)this.B));
                    int v1 = (int)velocityTracker0.getYVelocity(this.D);
                    if(Math.abs(v1) < this.w) {
                        int v2 = this.getScrollX();
                        int v3 = this.getScrollY();
                        int v4 = this.getScrollRange();
                        if(this.d.springBack(v2, v3, 0, 0, 0, v4)) {
                            this.postInvalidateOnAnimation();
                        }
                    }
                    else if(EdgeEffectCompat.a(edgeEffect0) == 0.0f) {
                        if(EdgeEffectCompat.a(edgeEffect1) == 0.0f) {
                            if(!r0.b(0.0f, ((float)(-v1)))) {
                                this.dispatchNestedFling(0.0f, ((float)(-v1)), true);
                                this.e(-v1);
                            }
                        }
                        else if(this.o(edgeEffect1, -v1)) {
                            edgeEffect1.onAbsorb(-v1);
                        }
                        else {
                            this.e(-v1);
                        }
                    }
                    else if(this.o(edgeEffect0, v1)) {
                        edgeEffect0.onAbsorb(v1);
                    }
                    else {
                        this.e(-v1);
                    }
                    this.D = -1;
                    this.l = false;
                    VelocityTracker velocityTracker1 = this.m;
                    if(velocityTracker1 != null) {
                        velocityTracker1.recycle();
                        this.m = null;
                    }
                    this.r(0);
                    this.e.onRelease();
                    this.f.onRelease();
                    break;
                }
                case 2: {
                    int v5 = motionEvent0.findPointerIndex(this.D);
                    if(v5 == -1) {
                        Log.e("NestedScrollView", "Invalid pointerId=" + this.D + " in onTouchEvent");
                    }
                    else {
                        int v6 = (int)motionEvent0.getY(v5);
                        int v7 = this.h - v6;
                        float f1 = motionEvent0.getX(v5) / ((float)this.getWidth());
                        float f2 = ((float)v7) / ((float)this.getHeight());
                        if(EdgeEffectCompat.a(edgeEffect0) != 0.0f) {
                            f3 = -EdgeEffectCompat.b(edgeEffect0, -f2, f1);
                            if(EdgeEffectCompat.a(edgeEffect0) == 0.0f) {
                                edgeEffect0.onRelease();
                            }
                            f = f3;
                        }
                        else if(EdgeEffectCompat.a(edgeEffect1) != 0.0f) {
                            f3 = EdgeEffectCompat.b(edgeEffect1, f2, 1.0f - f1);
                            if(EdgeEffectCompat.a(edgeEffect1) == 0.0f) {
                                edgeEffect1.onRelease();
                            }
                            f = f3;
                        }
                        int v8 = Math.round(f * ((float)this.getHeight()));
                        if(v8 != 0) {
                            this.invalidate();
                        }
                        int v9 = v7 - v8;
                        if(!this.l && Math.abs(v9) > this.r) {
                            ViewParent viewParent0 = this.getParent();
                            if(viewParent0 != null) {
                                viewParent0.requestDisallowInterceptTouchEvent(true);
                            }
                            this.l = true;
                            v9 = v9 <= 0 ? v9 + this.r : v9 - this.r;
                        }
                        if(this.l) {
                            int v10 = this.n(v9, 1, motionEvent0, ((int)motionEvent0.getX(v5)), 0, false);
                            this.h = v6 - v10;
                            this.I += v10;
                        }
                    }
                    break;
                }
                case 3: {
                    if(this.l && this.getChildCount() > 0) {
                        int v11 = this.getScrollX();
                        int v12 = this.getScrollY();
                        int v13 = this.getScrollRange();
                        if(this.d.springBack(v11, v12, 0, 0, 0, v13)) {
                            this.postInvalidateOnAnimation();
                        }
                    }
                    this.D = -1;
                    this.l = false;
                    VelocityTracker velocityTracker2 = this.m;
                    if(velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.m = null;
                    }
                    this.r(0);
                    this.e.onRelease();
                    this.f.onRelease();
                    break;
                }
                case 5: {
                    int v14 = motionEvent0.getActionIndex();
                    this.h = (int)motionEvent0.getY(v14);
                    this.D = motionEvent0.getPointerId(v14);
                    break;
                }
                case 6: {
                    this.j(motionEvent0);
                    this.h = (int)motionEvent0.getY(motionEvent0.findPointerIndex(this.D));
                }
            }
        }
        VelocityTracker velocityTracker3 = this.m;
        if(velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent1);
        }
        motionEvent1.recycle();
        return true;
    }

    public final void p(int v, int v1, boolean z) {
        if(this.getChildCount() == 0) {
            return;
        }
        if(Long.compare(AnimationUtils.currentAnimationTimeMillis() - this.b, 0xFAL) > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            int v2 = view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin;
            int v3 = this.getHeight();
            int v4 = this.getPaddingTop();
            int v5 = this.getPaddingBottom();
            int v6 = this.getScrollY();
            int v7 = this.getScrollX();
            this.d.startScroll(v7, v6, 0, Math.max(0, Math.min(v1 + v6, Math.max(0, v2 - (v3 - v4 - v5)))) - v6, 0xFA);
            if(z) {
                this.T.h(2, 1);
            }
            else {
                this.r(1);
            }
            this.M = this.getScrollY();
            this.postInvalidateOnAnimation();
        }
        else {
            if(!this.d.isFinished()) {
                this.d.abortAnimation();
                this.r(1);
            }
            this.scrollBy(v, v1);
        }
        this.b = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean q(MotionEvent motionEvent0) {
        boolean z;
        EdgeEffect edgeEffect0 = this.e;
        if(Float.compare(EdgeEffectCompat.a(edgeEffect0), 0.0f) == 0) {
            z = false;
        }
        else {
            EdgeEffectCompat.b(edgeEffect0, 0.0f, motionEvent0.getX() / ((float)this.getWidth()));
            z = true;
        }
        EdgeEffect edgeEffect1 = this.f;
        if(EdgeEffectCompat.a(edgeEffect1) != 0.0f) {
            EdgeEffectCompat.b(edgeEffect1, 0.0f, 1.0f - motionEvent0.getX() / ((float)this.getWidth()));
            return true;
        }
        return z;
    }

    public final void r(int v) {
        this.T.i(v);
    }

    @Override  // android.view.ViewGroup
    public final void requestChildFocus(View view0, View view1) {
        if(this.i) {
            this.k = view1;
        }
        else {
            view1.getDrawingRect(this.c);
            this.offsetDescendantRectToMyCoords(view1, this.c);
            int v = this.b(this.c);
            if(v != 0) {
                this.scrollBy(0, v);
            }
        }
        super.requestChildFocus(view0, view1);
    }

    @Override  // android.view.ViewGroup
    public final boolean requestChildRectangleOnScreen(View view0, Rect rect0, boolean z) {
        rect0.offset(view0.getLeft() - view0.getScrollX(), view0.getTop() - view0.getScrollY());
        int v = this.b(rect0);
        if(v != 0) {
            if(z) {
                this.scrollBy(0, v);
                return true;
            }
            this.p(0, v, false);
        }
        return v != 0;
    }

    @Override  // android.view.ViewGroup
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        if(z) {
            VelocityTracker velocityTracker0 = this.m;
            if(velocityTracker0 != null) {
                velocityTracker0.recycle();
                this.m = null;
            }
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override  // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.i = true;
        super.requestLayout();
    }

    @Override  // android.view.View
    public final void scrollTo(int v, int v1) {
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)view0.getLayoutParams();
            int v2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v3 = view0.getWidth() + frameLayout$LayoutParams0.leftMargin + frameLayout$LayoutParams0.rightMargin;
            int v4 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            int v5 = view0.getHeight() + frameLayout$LayoutParams0.topMargin + frameLayout$LayoutParams0.bottomMargin;
            if(v2 >= v3 || v < 0) {
                v = 0;
            }
            else if(v2 + v > v3) {
                v = v3 - v2;
            }
            if(v4 >= v5 || v1 < 0) {
                v1 = 0;
            }
            else if(v4 + v1 > v5) {
                v1 = v5 - v4;
            }
            if(v != this.getScrollX() || v1 != this.getScrollY()) {
                super.scrollTo(v, v1);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if(z != this.n) {
            this.n = z;
            this.requestLayout();
        }
    }

    @Override  // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.T.g(z);
    }

    public void setOnScrollChangeListener(h h0) {
        this.W = h0;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.o = z;
    }

    @Override  // android.widget.FrameLayout
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override  // android.view.View
    public final boolean startNestedScroll(int v) {
        return this.T.h(v, 0);
    }

    @Override  // android.view.View
    public final void stopNestedScroll() {
        this.r(0);
    }
}

