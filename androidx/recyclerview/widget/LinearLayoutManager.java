package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import d2.c;
import d2.d;
import java.util.List;

public class LinearLayoutManager extends w0 implements I0, N {
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public int b;
        public boolean c;

        static {
            SavedState.CREATOR = new X();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b);
            parcel0.writeInt(((int)this.c));
        }
    }

    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = 0x80000000;
    private static final float MAX_SCROLL_FACTOR = 0.333333f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final U mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final V mLayoutChunkResult;
    private W mLayoutState;
    int mOrientation;
    d0 mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public LinearLayoutManager(int v, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = 0x80000000;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new U();
        this.mLayoutChunkResult = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        this.setOrientation(v);
        this.setReverseLayout(z);
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context0) {
        this(1, false);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context0, AttributeSet attributeSet0, int v, int v1) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = 0x80000000;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new U();
        this.mLayoutChunkResult = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        v0 v00 = w0.getProperties(context0, attributeSet0, v, v1);
        this.setOrientation(v00.a);
        this.setReverseLayout(v00.c);
        this.setStackFromEnd(v00.d);
    }

    public final void A() {
        if(this.mOrientation != 1 && this.isLayoutRTL()) {
            this.mShouldReverseLayout = !this.mReverseLayout;
            return;
        }
        this.mShouldReverseLayout = this.mReverseLayout;
    }

    public final void B(int v, int v1, boolean z, K0 k00) {
        int v7;
        W w0 = this.mLayoutState;
        w0.l = this.resolveIsInfinite();
        this.mLayoutState.f = v;
        int[] arr_v = this.mReusableIntPair;
        boolean z1 = false;
        arr_v[0] = 0;
        int v2 = 1;
        arr_v[1] = 0;
        this.calculateExtraLayoutSpace(k00, arr_v);
        int v3 = Math.max(0, this.mReusableIntPair[0]);
        int v4 = Math.max(0, this.mReusableIntPair[1]);
        if(v == 1) {
            z1 = true;
        }
        W w1 = this.mLayoutState;
        int v5 = z1 ? v4 : v3;
        w1.h = v5;
        if(!z1) {
            v3 = v4;
        }
        w1.i = v3;
        if(z1) {
            w1.h = this.mOrientationHelper.h() + v5;
            View view0 = this.v();
            W w2 = this.mLayoutState;
            if(this.mShouldReverseLayout) {
                v2 = -1;
            }
            w2.e = v2;
            int v6 = this.getPosition(view0);
            W w3 = this.mLayoutState;
            w2.d = v6 + w3.e;
            w3.b = this.mOrientationHelper.b(view0);
            v7 = this.mOrientationHelper.b(view0) - this.mOrientationHelper.g();
        }
        else {
            View view1 = this.w();
            W w4 = this.mLayoutState;
            int v8 = w4.h;
            w4.h = this.mOrientationHelper.k() + v8;
            W w5 = this.mLayoutState;
            if(!this.mShouldReverseLayout) {
                v2 = -1;
            }
            w5.e = v2;
            int v9 = this.getPosition(view1);
            W w6 = this.mLayoutState;
            w5.d = v9 + w6.e;
            w6.b = this.mOrientationHelper.e(view1);
            v7 = -this.mOrientationHelper.e(view1) + this.mOrientationHelper.k();
        }
        W w7 = this.mLayoutState;
        w7.c = v1;
        if(z) {
            w7.c = v1 - v7;
        }
        w7.g = v7;
    }

    public final void C(int v, int v1) {
        W w0 = this.mLayoutState;
        w0.c = this.mOrientationHelper.g() - v1;
        this.mLayoutState.e = this.mShouldReverseLayout ? -1 : 1;
        this.mLayoutState.d = v;
        this.mLayoutState.f = 1;
        this.mLayoutState.b = v1;
        this.mLayoutState.g = 0x80000000;
    }

    public final void D(int v, int v1) {
        W w0 = this.mLayoutState;
        w0.c = v1 - this.mOrientationHelper.k();
        this.mLayoutState.d = v;
        this.mLayoutState.e = this.mShouldReverseLayout ? 1 : -1;
        this.mLayoutState.f = -1;
        this.mLayoutState.b = v1;
        this.mLayoutState.g = 0x80000000;
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String s) {
        if(this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(s);
        }
    }

    public void calculateExtraLayoutSpace(K0 k00, int[] arr_v) {
        int v1;
        int v = this.getExtraLayoutSpace(k00);
        if(this.mLayoutState.f == -1) {
            v1 = 0;
        }
        else {
            v1 = v;
            v = 0;
        }
        arr_v[0] = v;
        arr_v[1] = v1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override  // androidx.recyclerview.widget.w0
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int v, int v1, K0 k00, u0 u00) {
        if(this.mOrientation != 0) {
            v = v1;
        }
        if(this.getChildCount() != 0 && v != 0) {
            this.ensureLayoutState();
            this.B((v <= 0 ? -1 : 1), Math.abs(v), true, k00);
            this.collectPrefetchPositionsForLayoutState(k00, this.mLayoutState, u00);
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int v, u0 u00) {
        boolean z;
        int v2;
        SavedState linearLayoutManager$SavedState0 = this.mPendingSavedState;
        int v1 = -1;
        if(linearLayoutManager$SavedState0 == null) {
        label_7:
            this.A();
            z = this.mShouldReverseLayout;
            v2 = this.mPendingScrollPosition;
            if(v2 == -1) {
                v2 = z ? v - 1 : 0;
            }
        }
        else {
            v2 = linearLayoutManager$SavedState0.a;
            if(v2 >= 0) {
                z = linearLayoutManager$SavedState0.c;
                goto label_12;
            }
            goto label_7;
        }
    label_12:
        if(!z) {
            v1 = 1;
        }
        for(int v3 = 0; v3 < this.mInitialPrefetchItemCount && v2 >= 0 && v2 < v; ++v3) {
            ((D)u00).a(v2, 0);
            v2 += v1;
        }
    }

    public void collectPrefetchPositionsForLayoutState(K0 k00, W w0, u0 u00) {
        int v = w0.d;
        if(v >= 0 && v < k00.b()) {
            ((D)u00).a(v, Math.max(0, w0.g));
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(K0 k00) {
        return this.q(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(K0 k00) {
        return this.r(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(K0 k00) {
        return this.s(k00);
    }

    @Override  // androidx.recyclerview.widget.I0
    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int v) {
        if(this.getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int v1 = 1;
        if(v < this.getPosition(this.getChildAt(0))) {
            z = true;
        }
        if(z != this.mShouldReverseLayout) {
            v1 = -1;
        }
        return this.mOrientation == 0 ? new PointF(((float)v1), 0.0f) : new PointF(0.0f, ((float)v1));
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(K0 k00) {
        return this.q(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(K0 k00) {
        return this.r(k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(K0 k00) {
        return this.s(k00);
    }

    public int convertFocusDirectionToLayoutDirection(int v) {
        switch(v) {
            case 1: {
                if(this.mOrientation == 1) {
                    return -1;
                }
                return this.isLayoutRTL() ? 1 : -1;
            }
            case 2: {
                if(this.mOrientation == 1) {
                    return 1;
                }
                return this.isLayoutRTL() ? -1 : 1;
            }
            case 17: {
                return this.mOrientation == 0 ? -1 : 0x80000000;
            }
            case 33: {
                return this.mOrientation == 1 ? -1 : 0x80000000;
            }
            case 66: {
                return this.mOrientation == 0 ? 1 : 0x80000000;
            }
            case 130: {
                return this.mOrientation == 1 ? 1 : 0x80000000;
            }
            default: {
                return 0x80000000;
            }
        }
    }

    public W createLayoutState() {
        W w0 = new W();  // 初始化器: Ljava/lang/Object;-><init>()V
        w0.a = true;
        w0.h = 0;
        w0.i = 0;
        w0.k = null;
        return w0;
    }

    public void ensureLayoutState() {
        if(this.mLayoutState == null) {
            this.mLayoutState = this.createLayoutState();
        }
    }

    public int fill(D0 d00, W w0, K0 k00, boolean z) {
        int v = w0.c;
        int v1 = w0.g;
        if(v1 != 0x80000000) {
            if(v < 0) {
                w0.g = v1 + v;
            }
            this.y(d00, w0);
        }
        int v2 = w0.c + w0.h;
        V v3 = this.mLayoutChunkResult;
        while((w0.l || v2 > 0) && (w0.d >= 0 && w0.d < k00.b())) {
            v3.a = 0;
            v3.b = false;
            v3.c = false;
            v3.d = false;
            this.layoutChunk(d00, k00, w0, v3);
            if(v3.b) {
                break;
            }
            int v4 = v3.a;
            w0.b = w0.f * v4 + w0.b;
            if(!v3.c || w0.k != null || !k00.g) {
                w0.c -= v4;
                v2 -= v4;
            }
            int v5 = w0.g;
            if(v5 != 0x80000000) {
                int v6 = v5 + v4;
                w0.g = v6;
                int v7 = w0.c;
                if(v7 < 0) {
                    w0.g = v6 + v7;
                }
                this.y(d00, w0);
            }
            if(z && v3.d) {
                break;
            }
        }
        return v - w0.c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View view0 = this.findOneVisibleChild(0, this.getChildCount(), true, false);
        return view0 == null ? -1 : this.getPosition(view0);
    }

    // 去混淆评级： 低(20)
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z1) {
        return this.mShouldReverseLayout ? this.findOneVisibleChild(0, this.getChildCount(), z, z1) : this.findOneVisibleChild(this.getChildCount() - 1, -1, z, z1);
    }

    // 去混淆评级： 低(20)
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z1) {
        return this.mShouldReverseLayout ? this.findOneVisibleChild(this.getChildCount() - 1, -1, z, z1) : this.findOneVisibleChild(0, this.getChildCount(), z, z1);
    }

    public int findFirstVisibleItemPosition() {
        View view0 = this.findOneVisibleChild(0, this.getChildCount(), false, true);
        return view0 == null ? -1 : this.getPosition(view0);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View view0 = this.findOneVisibleChild(this.getChildCount() - 1, -1, true, false);
        return view0 == null ? -1 : this.getPosition(view0);
    }

    public int findLastVisibleItemPosition() {
        View view0 = this.findOneVisibleChild(this.getChildCount() - 1, -1, false, true);
        return view0 == null ? -1 : this.getPosition(view0);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int v, int v1) {
        this.ensureLayoutState();
        if(v1 > v || v1 < v) {
            if(this.mOrientationHelper.e(this.getChildAt(v)) < this.mOrientationHelper.k()) {
                return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(v, v1, 0x4104, 0x4004) : this.mVerticalBoundCheck.a(v, v1, 0x4104, 0x4004);
            }
            return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(v, v1, 0x1041, 0x1001) : this.mVerticalBoundCheck.a(v, v1, 0x1041, 0x1001);
        }
        return this.getChildAt(v);
    }

    public View findOneVisibleChild(int v, int v1, boolean z, boolean z1) {
        this.ensureLayoutState();
        int v2 = 320;
        int v3 = z ? 0x6003 : 320;
        if(!z1) {
            v2 = 0;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(v, v1, v3, v2) : this.mVerticalBoundCheck.a(v, v1, v3, v2);
    }

    public View findReferenceChild(D0 d00, K0 k00, boolean z, boolean z1) {
        int v3;
        int v2;
        int v1;
        this.ensureLayoutState();
        int v = this.getChildCount();
        if(z1) {
            v1 = this.getChildCount() - 1;
            v2 = -1;
            v3 = -1;
        }
        else {
            v2 = v;
            v1 = 0;
            v3 = 1;
        }
        int v4 = k00.b();
        int v5 = this.mOrientationHelper.k();
        int v6 = this.mOrientationHelper.g();
        View view0 = null;
        View view1 = null;
        View view2 = null;
        while(v1 != v2) {
            View view3 = this.getChildAt(v1);
            int v7 = this.getPosition(view3);
            int v8 = this.mOrientationHelper.e(view3);
            int v9 = this.mOrientationHelper.b(view3);
            if(v7 >= 0 && v7 < v4) {
                if(!((LayoutParams)view3.getLayoutParams()).a.isRemoved()) {
                    boolean z2 = v9 <= v5 && v8 < v5;
                    boolean z3 = v8 >= v6 && v9 > v6;
                    if(!z2 && !z3) {
                        return view3;
                    }
                    if(!z) {
                        if(z2) {
                            view1 = view3;
                        }
                        else if(view0 == null) {
                            view0 = view3;
                        }
                    }
                    else if(z3) {
                        view1 = view3;
                    }
                    else if(view0 == null) {
                        view0 = view3;
                    }
                }
                else if(view2 == null) {
                    view2 = view3;
                }
            }
            v1 += v3;
        }
        if(view0 != null) {
            return view0;
        }
        return view1 == null ? view2 : view1;
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int v) {
        int v1 = this.getChildCount();
        if(v1 == 0) {
            return null;
        }
        int v2 = v - this.getPosition(this.getChildAt(0));
        if(v2 >= 0 && v2 < v1) {
            View view0 = this.getChildAt(v2);
            return this.getPosition(view0) == v ? view0 : super.findViewByPosition(v);
        }
        return super.findViewByPosition(v);
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(K0 k00) {
        return k00.a == -1 ? 0 : this.mOrientationHelper.l();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override  // androidx.recyclerview.widget.w0
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return this.getLayoutDirection() == 1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public boolean isLayoutReversed() {
        return this.mReverseLayout;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(D0 d00, K0 k00, W w0, V v0) {
        int v8;
        int v7;
        int v6;
        int v5;
        int v4;
        int v3;
        int v2;
        int v1;
        View view0 = w0.b(d00);
        if(view0 == null) {
            v0.b = true;
            return;
        }
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        if(w0.k != null) {
            if(this.mShouldReverseLayout == (w0.f == -1)) {
                this.addDisappearingView(view0);
            }
            else {
                this.addDisappearingView(view0, 0);
            }
        }
        else if(this.mShouldReverseLayout == (w0.f == -1)) {
            this.addView(view0);
        }
        else {
            this.addView(view0, 0);
        }
        this.measureChildWithMargins(view0, 0, 0);
        v0.a = this.mOrientationHelper.c(view0);
        if(this.mOrientation == 1) {
            if(this.isLayoutRTL()) {
                v1 = this.getWidth() - this.getPaddingRight();
                v2 = v1 - this.mOrientationHelper.d(view0);
            }
            else {
                v2 = this.getPaddingLeft();
                v1 = this.mOrientationHelper.d(view0) + v2;
            }
            if(w0.f == -1) {
                v3 = w0.b;
                v4 = v3 - v0.a;
            }
            else {
                v4 = w0.b;
                v3 = v0.a + v4;
            }
            v5 = v4;
            v6 = v2;
            v7 = v3;
            v8 = v1;
        }
        else {
            int v9 = this.getPaddingTop();
            int v10 = this.mOrientationHelper.d(view0) + v9;
            if(w0.f == -1) {
                v6 = w0.b - v0.a;
                v8 = w0.b;
                v7 = v10;
            }
            else {
                v8 = v0.a + w0.b;
                v7 = v10;
                v6 = w0.b;
            }
            v5 = v9;
        }
        this.layoutDecoratedWithMargins(view0, v6, v5, v8, v7);
        if(recyclerView$LayoutParams0.a.isRemoved() || recyclerView$LayoutParams0.a.isUpdated()) {
            v0.c = true;
        }
        v0.d = view0.hasFocusable();
    }

    public void onAnchorReady(D0 d00, K0 k00, U u0, int v) {
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView0, D0 d00) {
        if(this.mRecycleChildrenOnDetach) {
            this.removeAndRecycleAllViews(d00);
            d00.a.clear();
            d00.f();
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view0, int v, D0 d00, K0 k00) {
        View view1;
        this.A();
        if(this.getChildCount() != 0) {
            int v1 = this.convertFocusDirectionToLayoutDirection(v);
            if(v1 != 0x80000000) {
                this.ensureLayoutState();
                this.B(v1, ((int)(((float)this.mOrientationHelper.l()) * 0.333333f)), false, k00);
                this.mLayoutState.g = 0x80000000;
                this.mLayoutState.a = false;
                this.fill(d00, this.mLayoutState, k00, true);
                if(v1 != -1) {
                    view1 = this.mShouldReverseLayout ? this.findOnePartiallyOrCompletelyInvisibleChild(0, this.getChildCount()) : this.findOnePartiallyOrCompletelyInvisibleChild(this.getChildCount() - 1, -1);
                }
                else if(this.mShouldReverseLayout) {
                    view1 = this.findOnePartiallyOrCompletelyInvisibleChild(this.getChildCount() - 1, -1);
                }
                else {
                    view1 = this.findOnePartiallyOrCompletelyInvisibleChild(0, this.getChildCount());
                }
                View view2 = v1 == -1 ? this.w() : this.v();
                if(view2.hasFocusable()) {
                    return view1 == null ? null : view2;
                }
                return view1;
            }
        }
        return null;
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        if(this.getChildCount() > 0) {
            accessibilityEvent0.setFromIndex(this.findFirstVisibleItemPosition());
            accessibilityEvent0.setToIndex(this.findLastVisibleItemPosition());
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    public void onInitializeAccessibilityNodeInfo(D0 d00, K0 k00, d d0) {
        super.onInitializeAccessibilityNodeInfo(d00, k00, d0);
        j0 j00 = this.mRecyclerView.m;
        if(j00 != null && j00.getItemCount() > 0) {
            d0.b(c.o);
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(D0 d00, K0 k00) {
        int v32;
        int v31;
        int v30;
        int v23;
        int v20;
        int v18;
        int v17;
        int v6;
        int v = -1;
        if((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && k00.b() == 0) {
            this.removeAndRecycleAllViews(d00);
            return;
        }
        SavedState linearLayoutManager$SavedState0 = this.mPendingSavedState;
        if(linearLayoutManager$SavedState0 != null) {
            int v1 = linearLayoutManager$SavedState0.a;
            if(v1 >= 0) {
                this.mPendingScrollPosition = v1;
            }
        }
        this.ensureLayoutState();
        this.mLayoutState.a = false;
        this.A();
        View view0 = this.getFocusedChild();
        U u0 = this.mAnchorInfo;
        if(!u0.e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            u0.d();
            U u1 = this.mAnchorInfo;
            u1.d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            if(k00.g) {
            label_70:
                if(this.getChildCount() == 0) {
                    u1.a();
                    u1.b = this.mStackFromEnd ? k00.b() - 1 : 0;
                }
                else {
                    View view2 = this.getFocusedChild();
                    if(view2 == null) {
                    label_77:
                        boolean z = this.mStackFromEnd;
                        if(this.mLastStackFromEnd == z) {
                            View view3 = this.findReferenceChild(d00, k00, u1.d, z);
                            if(view3 == null) {
                                u1.a();
                                u1.b = this.mStackFromEnd ? k00.b() - 1 : 0;
                            }
                            else {
                                u1.b(view3, this.getPosition(view3));
                                if(!k00.g && this.supportsPredictiveItemAnimations()) {
                                    int v8 = this.mOrientationHelper.e(view3);
                                    int v9 = this.mOrientationHelper.b(view3);
                                    int v10 = this.mOrientationHelper.k();
                                    int v11 = this.mOrientationHelper.g();
                                    if(v9 <= v10 && v8 < v10 || v8 >= v11 && v9 > v11) {
                                        if(u1.d) {
                                            v10 = v11;
                                        }
                                        u1.c = v10;
                                    }
                                }
                            }
                        }
                        else {
                            u1.a();
                            u1.b = this.mStackFromEnd ? k00.b() - 1 : 0;
                        }
                    }
                    else {
                        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view2.getLayoutParams();
                        if(!recyclerView$LayoutParams0.a.isRemoved() && recyclerView$LayoutParams0.a.getLayoutPosition() >= 0 && recyclerView$LayoutParams0.a.getLayoutPosition() < k00.b()) {
                            u1.c(view2, this.getPosition(view2));
                            goto label_100;
                        }
                        goto label_77;
                    }
                }
            }
            else {
                int v3 = this.mPendingScrollPosition;
                if(v3 == -1) {
                    goto label_70;
                }
                else if(v3 >= 0 && v3 < k00.b()) {
                    int v4 = this.mPendingScrollPosition;
                    u1.b = v4;
                    SavedState linearLayoutManager$SavedState1 = this.mPendingSavedState;
                    if(linearLayoutManager$SavedState1 != null && linearLayoutManager$SavedState1.a >= 0) {
                        u1.d = linearLayoutManager$SavedState1.c;
                        u1.c = linearLayoutManager$SavedState1.c ? this.mOrientationHelper.g() - this.mPendingSavedState.b : this.mOrientationHelper.k() + this.mPendingSavedState.b;
                    }
                    else if(this.mPendingScrollPositionOffset == 0x80000000) {
                        View view1 = this.findViewByPosition(v4);
                        if(view1 == null) {
                            if(this.getChildCount() > 0) {
                                int v7 = this.getPosition(this.getChildAt(0));
                                u1.d = this.mPendingScrollPosition < v7 == this.mShouldReverseLayout;
                            }
                            u1.a();
                        }
                        else if(this.mOrientationHelper.c(view1) > this.mOrientationHelper.l()) {
                            u1.a();
                        }
                        else if(this.mOrientationHelper.e(view1) - this.mOrientationHelper.k() < 0) {
                            u1.c = this.mOrientationHelper.k();
                            u1.d = false;
                        }
                        else if(this.mOrientationHelper.g() - this.mOrientationHelper.b(view1) < 0) {
                            u1.c = this.mOrientationHelper.g();
                            u1.d = true;
                        }
                        else {
                            if(u1.d) {
                                int v5 = this.mOrientationHelper.b(view1);
                                v6 = this.mOrientationHelper.m() + v5;
                            }
                            else {
                                v6 = this.mOrientationHelper.e(view1);
                            }
                            u1.c = v6;
                        }
                    }
                    else {
                        u1.d = this.mShouldReverseLayout;
                        u1.c = this.mShouldReverseLayout ? this.mOrientationHelper.g() - this.mPendingScrollPositionOffset : this.mOrientationHelper.k() + this.mPendingScrollPositionOffset;
                    }
                }
                else {
                    this.mPendingScrollPosition = -1;
                    this.mPendingScrollPositionOffset = 0x80000000;
                    goto label_70;
                }
            }
        label_100:
            this.mAnchorInfo.e = true;
        }
        else if(view0 != null && (this.mOrientationHelper.e(view0) >= this.mOrientationHelper.g() || this.mOrientationHelper.b(view0) <= this.mOrientationHelper.k())) {
            int v2 = this.getPosition(view0);
            this.mAnchorInfo.c(view0, v2);
        }
        this.mLayoutState.f = this.mLayoutState.j < 0 ? -1 : 1;
        int[] arr_v = this.mReusableIntPair;
        arr_v[0] = 0;
        arr_v[1] = 0;
        this.calculateExtraLayoutSpace(k00, arr_v);
        int v12 = Math.max(0, this.mReusableIntPair[0]);
        int v13 = this.mOrientationHelper.k() + v12;
        int v14 = Math.max(0, this.mReusableIntPair[1]);
        int v15 = this.mOrientationHelper.h() + v14;
        if(k00.g) {
            int v16 = this.mPendingScrollPosition;
            if(v16 != -1 && this.mPendingScrollPositionOffset != 0x80000000) {
                View view4 = this.findViewByPosition(v16);
                if(view4 != null) {
                    if(this.mShouldReverseLayout) {
                        v17 = this.mOrientationHelper.g() - this.mOrientationHelper.b(view4);
                        v18 = this.mPendingScrollPositionOffset;
                    }
                    else {
                        v18 = this.mOrientationHelper.e(view4) - this.mOrientationHelper.k();
                        v17 = this.mPendingScrollPositionOffset;
                    }
                    int v19 = v17 - v18;
                    if(v19 > 0) {
                        v13 += v19;
                    }
                    else {
                        v15 -= v19;
                    }
                }
            }
        }
        U u2 = this.mAnchorInfo;
        if(!u2.d) {
            if(!this.mShouldReverseLayout) {
                v = 1;
            }
        }
        else if(this.mShouldReverseLayout) {
            v = 1;
        }
        this.onAnchorReady(d00, k00, u2, v);
        this.detachAndScrapAttachedViews(d00);
        W w0 = this.mLayoutState;
        w0.l = this.resolveIsInfinite();
        this.mLayoutState.getClass();
        this.mLayoutState.i = 0;
        U u3 = this.mAnchorInfo;
        if(u3.d) {
            this.D(u3.b, u3.c);
            this.mLayoutState.h = v13;
            this.fill(d00, this.mLayoutState, k00, false);
            v20 = this.mLayoutState.b;
            int v21 = this.mLayoutState.d;
            int v22 = this.mLayoutState.c;
            if(v22 > 0) {
                v15 += v22;
            }
            this.C(this.mAnchorInfo.b, this.mAnchorInfo.c);
            this.mLayoutState.h = v15;
            this.mLayoutState.d += this.mLayoutState.e;
            this.fill(d00, this.mLayoutState, k00, false);
            v23 = this.mLayoutState.b;
            int v24 = this.mLayoutState.c;
            if(v24 > 0) {
                this.D(v21, v20);
                this.mLayoutState.h = v24;
                this.fill(d00, this.mLayoutState, k00, false);
                v20 = this.mLayoutState.b;
            }
        }
        else {
            this.C(u3.b, u3.c);
            this.mLayoutState.h = v15;
            this.fill(d00, this.mLayoutState, k00, false);
            v23 = this.mLayoutState.b;
            int v25 = this.mLayoutState.d;
            int v26 = this.mLayoutState.c;
            if(v26 > 0) {
                v13 += v26;
            }
            this.D(this.mAnchorInfo.b, this.mAnchorInfo.c);
            this.mLayoutState.h = v13;
            this.mLayoutState.d += this.mLayoutState.e;
            this.fill(d00, this.mLayoutState, k00, false);
            int v27 = this.mLayoutState.b;
            int v28 = this.mLayoutState.c;
            if(v28 > 0) {
                this.C(v25, v23);
                this.mLayoutState.h = v28;
                this.fill(d00, this.mLayoutState, k00, false);
                v23 = this.mLayoutState.b;
            }
            v20 = v27;
        }
        if(this.getChildCount() > 0) {
            if((this.mShouldReverseLayout ^ this.mStackFromEnd) == 0) {
                int v33 = this.u(v20, d00, k00, true);
                v30 = v20 + v33;
                v31 = v23 + v33;
                v32 = this.t(v31, d00, k00, false);
            }
            else {
                int v29 = this.t(v23, d00, k00, true);
                v30 = v20 + v29;
                v31 = v23 + v29;
                v32 = this.u(v30, d00, k00, false);
            }
            v20 = v30 + v32;
            v23 = v31 + v32;
        }
        if(k00.k && this.getChildCount() != 0 && !k00.g && this.supportsPredictiveItemAnimations()) {
            List list0 = d00.d;
            int v34 = list0.size();
            int v35 = this.getPosition(this.getChildAt(0));
            int v37 = 0;
            int v38 = 0;
            for(int v36 = 0; v36 < v34; ++v36) {
                O0 o00 = (O0)list0.get(v36);
                if(!o00.isRemoved()) {
                    if(o00.getLayoutPosition() < v35 == this.mShouldReverseLayout) {
                        v38 += this.mOrientationHelper.c(o00.itemView);
                    }
                    else {
                        v37 += this.mOrientationHelper.c(o00.itemView);
                    }
                }
            }
            this.mLayoutState.k = list0;
            if(v37 > 0) {
                this.D(this.getPosition(this.w()), v20);
                this.mLayoutState.h = v37;
                this.mLayoutState.c = 0;
                this.mLayoutState.a(null);
                this.fill(d00, this.mLayoutState, k00, false);
            }
            if(v38 > 0) {
                this.C(this.getPosition(this.v()), v23);
                this.mLayoutState.h = v38;
                this.mLayoutState.c = 0;
                this.mLayoutState.a(null);
                this.fill(d00, this.mLayoutState, k00, false);
            }
            this.mLayoutState.k = null;
        }
        if(k00.g) {
            this.mAnchorInfo.d();
        }
        else {
            d0 d01 = this.mOrientationHelper;
            d01.b = d01.l();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(K0 k00) {
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = 0x80000000;
        this.mAnchorInfo.d();
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable0) {
        if(parcelable0 instanceof SavedState) {
            this.mPendingSavedState = (SavedState)parcelable0;
            if(this.mPendingScrollPosition != -1) {
                ((SavedState)parcelable0).a = -1;
            }
            this.requestLayout();
        }
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        SavedState linearLayoutManager$SavedState0 = this.mPendingSavedState;
        if(linearLayoutManager$SavedState0 != null) {
            Parcelable parcelable0 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
            parcelable0.a = linearLayoutManager$SavedState0.a;
            parcelable0.b = linearLayoutManager$SavedState0.b;
            parcelable0.c = linearLayoutManager$SavedState0.c;
            return parcelable0;
        }
        Parcelable parcelable1 = new SavedState();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(this.getChildCount() > 0) {
            this.ensureLayoutState();
            int v = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            parcelable1.c = v;
            if(v != 0) {
                View view0 = this.v();
                parcelable1.b = this.mOrientationHelper.g() - this.mOrientationHelper.b(view0);
                parcelable1.a = this.getPosition(view0);
                return parcelable1;
            }
            View view1 = this.w();
            parcelable1.a = this.getPosition(view1);
            parcelable1.b = this.mOrientationHelper.e(view1) - this.mOrientationHelper.k();
            return parcelable1;
        }
        parcelable1.a = -1;
        return parcelable1;
    }

    @Override  // androidx.recyclerview.widget.w0
    public boolean performAccessibilityAction(int v, Bundle bundle0) {
        int v2;
        if(super.performAccessibilityAction(v, bundle0)) {
            return true;
        }
        if(v == 0x1020037 && bundle0 != null) {
            if(this.mOrientation == 1) {
                int v1 = bundle0.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
                if(v1 < 0) {
                    return false;
                }
                v2 = Math.min(v1, this.getRowCountForAccessibility(this.mRecyclerView.c, this.mRecyclerView.D0) - 1);
            }
            else {
                int v3 = bundle0.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
                if(v3 < 0) {
                    return false;
                }
                v2 = Math.min(v3, this.getColumnCountForAccessibility(this.mRecyclerView.c, this.mRecyclerView.D0) - 1);
            }
            if(v2 >= 0) {
                this.scrollToPositionWithOffset(v2, 0);
                return true;
            }
        }
        return false;
    }

    @Override  // androidx.recyclerview.widget.N
    public void prepareForDrop(View view0, View view1, int v, int v1) {
        this.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        this.ensureLayoutState();
        this.A();
        int v2 = this.getPosition(view0);
        int v3 = this.getPosition(view1);
        int v4 = v2 >= v3 ? -1 : 1;
        if(this.mShouldReverseLayout) {
            if(v4 == 1) {
                int v5 = this.mOrientationHelper.g();
                int v6 = this.mOrientationHelper.e(view1);
                this.scrollToPositionWithOffset(v3, v5 - (this.mOrientationHelper.c(view0) + v6));
                return;
            }
            this.scrollToPositionWithOffset(v3, this.mOrientationHelper.g() - this.mOrientationHelper.b(view1));
            return;
        }
        if(v4 == -1) {
            this.scrollToPositionWithOffset(v3, this.mOrientationHelper.e(view1));
            return;
        }
        this.scrollToPositionWithOffset(v3, this.mOrientationHelper.b(view1) - this.mOrientationHelper.c(view0));
    }

    public final int q(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return androidx.recyclerview.widget.d.b(k00, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), this.findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public final int r(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return androidx.recyclerview.widget.d.c(k00, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), this.findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.i() == 0 && this.mOrientationHelper.f() == 0;
    }

    public final int s(K0 k00) {
        if(this.getChildCount() == 0) {
            return 0;
        }
        this.ensureLayoutState();
        return androidx.recyclerview.widget.d.d(k00, this.mOrientationHelper, this.findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), this.findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public int scrollBy(int v, D0 d00, K0 k00) {
        if(this.getChildCount() != 0 && v != 0) {
            this.ensureLayoutState();
            this.mLayoutState.a = true;
            int v1 = v <= 0 ? -1 : 1;
            int v2 = Math.abs(v);
            this.B(v1, v2, true, k00);
            int v3 = this.mLayoutState.g;
            int v4 = this.fill(d00, this.mLayoutState, k00, false) + v3;
            if(v4 < 0) {
                return 0;
            }
            if(v2 > v4) {
                v = v1 * v4;
            }
            this.mOrientationHelper.p(-v);
            this.mLayoutState.j = v;
            return v;
        }
        return 0;
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int v, D0 d00, K0 k00) {
        return this.mOrientation == 1 ? 0 : this.scrollBy(v, d00, k00);
    }

    @Override  // androidx.recyclerview.widget.w0
    public void scrollToPosition(int v) {
        this.mPendingScrollPosition = v;
        this.mPendingScrollPositionOffset = 0x80000000;
        SavedState linearLayoutManager$SavedState0 = this.mPendingSavedState;
        if(linearLayoutManager$SavedState0 != null) {
            linearLayoutManager$SavedState0.a = -1;
        }
        this.requestLayout();
    }

    public void scrollToPositionWithOffset(int v, int v1) {
        this.mPendingScrollPosition = v;
        this.mPendingScrollPositionOffset = v1;
        SavedState linearLayoutManager$SavedState0 = this.mPendingSavedState;
        if(linearLayoutManager$SavedState0 != null) {
            linearLayoutManager$SavedState0.a = -1;
        }
        this.requestLayout();
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int v, D0 d00, K0 k00) {
        return this.mOrientation == 0 ? 0 : this.scrollBy(v, d00, k00);
    }

    public void setInitialPrefetchItemCount(int v) {
        this.mInitialPrefetchItemCount = v;
    }

    public void setOrientation(int v) {
        if(v != 0 && v != 1) {
            throw new IllegalArgumentException("invalid orientation:" + v);
        }
        this.assertNotInLayoutOrScroll(null);
        if(v == this.mOrientation && this.mOrientationHelper != null) {
            return;
        }
        d0 d00 = d0.a(this, v);
        this.mOrientationHelper = d00;
        this.mAnchorInfo.a = d00;
        this.mOrientation = v;
        this.requestLayout();
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        this.assertNotInLayoutOrScroll(null);
        if(z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        this.requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        this.assertNotInLayoutOrScroll(null);
        if(this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        this.requestLayout();
    }

    @Override  // androidx.recyclerview.widget.w0
    public boolean shouldMeasureTwice() {
        return this.getHeightMode() != 0x40000000 && this.getWidthMode() != 0x40000000 && this.hasFlexibleChildInBothOrientations();
    }

    @Override  // androidx.recyclerview.widget.w0
    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView0, K0 k00, int v) {
        LinearSmoothScroller linearSmoothScroller0 = new LinearSmoothScroller(recyclerView0.getContext());
        linearSmoothScroller0.setTargetPosition(v);
        this.startSmoothScroll(linearSmoothScroller0);
    }

    @Override  // androidx.recyclerview.widget.w0
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public final int t(int v, D0 d00, K0 k00, boolean z) {
        int v1 = this.mOrientationHelper.g() - v;
        if(v1 > 0) {
            int v2 = this.scrollBy(-v1, d00, k00);
            if(z) {
                int v3 = this.mOrientationHelper.g() - (v - v2);
                if(v3 > 0) {
                    this.mOrientationHelper.p(v3);
                    return v3 - v2;
                }
            }
            return -v2;
        }
        return 0;
    }

    public final int u(int v, D0 d00, K0 k00, boolean z) {
        int v1 = v - this.mOrientationHelper.k();
        if(v1 > 0) {
            int v2 = -this.scrollBy(v1, d00, k00);
            if(z) {
                int v3 = v + v2 - this.mOrientationHelper.k();
                if(v3 > 0) {
                    this.mOrientationHelper.p(-v3);
                    return v2 - v3;
                }
            }
            return v2;
        }
        return 0;
    }

    // 去混淆评级： 低(20)
    public final View v() {
        return this.mShouldReverseLayout ? this.getChildAt(0) : this.getChildAt(this.getChildCount() - 1);
    }

    public void validateChildOrder() {
        Log.d("LinearLayoutManager", "validating child count " + this.getChildCount());
        boolean z = true;
        if(this.getChildCount() >= 1) {
            int v = this.getPosition(this.getChildAt(0));
            int v1 = this.mOrientationHelper.e(this.getChildAt(0));
            if(this.mShouldReverseLayout) {
                int v2 = 1;
                while(v2 < this.getChildCount()) {
                    View view0 = this.getChildAt(v2);
                    int v3 = this.getPosition(view0);
                    int v4 = this.mOrientationHelper.e(view0);
                    if(v3 < v) {
                        this.x();
                        StringBuilder stringBuilder0 = new StringBuilder("detected invalid position. loc invalid? ");
                        if(v4 >= v1) {
                            z = false;
                        }
                        stringBuilder0.append(z);
                        throw new RuntimeException(stringBuilder0.toString());
                    }
                    if(v4 <= v1) {
                        ++v2;
                        continue;
                    }
                    this.x();
                    throw new RuntimeException("detected invalid location");
                }
            }
            else {
                int v5 = 1;
                while(v5 < this.getChildCount()) {
                    View view1 = this.getChildAt(v5);
                    int v6 = this.getPosition(view1);
                    int v7 = this.mOrientationHelper.e(view1);
                    if(v6 < v) {
                        this.x();
                        StringBuilder stringBuilder1 = new StringBuilder("detected invalid position. loc invalid? ");
                        if(v7 >= v1) {
                            z = false;
                        }
                        stringBuilder1.append(z);
                        throw new RuntimeException(stringBuilder1.toString());
                    }
                    if(v7 >= v1) {
                        ++v5;
                        continue;
                    }
                    this.x();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    public final View w() {
        return this.mShouldReverseLayout ? this.getChildAt(this.getChildCount() - 1) : this.getChildAt(0);
    }

    public final void x() {
        Log.d("LinearLayoutManager", "internal representation of views on the screen");
        for(int v = 0; v < this.getChildCount(); ++v) {
            View view0 = this.getChildAt(v);
            Log.d("LinearLayoutManager", "item " + this.getPosition(view0) + ", coord:" + this.mOrientationHelper.e(view0));
        }
        Log.d("LinearLayoutManager", "==============");
    }

    public final void y(D0 d00, W w0) {
        if(w0.a && !w0.l) {
            int v = w0.g;
            int v1 = w0.i;
            if(w0.f == -1) {
                int v2 = this.getChildCount();
                if(v >= 0) {
                    int v3 = this.mOrientationHelper.f() - v + v1;
                    if(this.mShouldReverseLayout) {
                        int v4 = 0;
                        while(v4 < v2) {
                            View view0 = this.getChildAt(v4);
                            if(this.mOrientationHelper.e(view0) >= v3 && this.mOrientationHelper.o(view0) >= v3) {
                                ++v4;
                                continue;
                            }
                            this.z(d00, 0, v4);
                            return;
                        }
                    }
                    else {
                        int v5 = v2 - 1;
                        while(v5 >= 0) {
                            View view1 = this.getChildAt(v5);
                            if(this.mOrientationHelper.e(view1) >= v3 && this.mOrientationHelper.o(view1) >= v3) {
                                --v5;
                                continue;
                            }
                            this.z(d00, v2 - 1, v5);
                            return;
                        }
                    }
                }
            }
            else if(v >= 0) {
                int v6 = v - v1;
                int v7 = this.getChildCount();
                if(this.mShouldReverseLayout) {
                    int v8 = v7 - 1;
                    while(v8 >= 0) {
                        View view2 = this.getChildAt(v8);
                        if(this.mOrientationHelper.b(view2) <= v6 && this.mOrientationHelper.n(view2) <= v6) {
                            --v8;
                            continue;
                        }
                        this.z(d00, v7 - 1, v8);
                        return;
                    }
                }
                else {
                    int v9 = 0;
                    while(v9 < v7) {
                        View view3 = this.getChildAt(v9);
                        if(this.mOrientationHelper.b(view3) <= v6 && this.mOrientationHelper.n(view3) <= v6) {
                            ++v9;
                        }
                        else {
                            this.z(d00, 0, v9);
                            if(true) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void z(D0 d00, int v, int v1) {
        if(v != v1) {
            if(v1 > v) {
                for(int v2 = v1 - 1; v2 >= v; --v2) {
                    this.removeAndRecycleViewAt(v2, d00);
                }
                return;
            }
            while(v > v1) {
                this.removeAndRecycleViewAt(v, d00);
                --v;
            }
        }
    }
}

