package androidx.viewpager.widget;

import A1.f;
import E9.t;
import P1.c;
import U4.x;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import c2.M;
import c2.W;
import ea.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean a;
        public final int b;
        public float c;
        public boolean d;
        public int e;
        public int f;

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.c = 0.0f;
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, ViewPager.LAYOUT_ATTRS);
            this.b = typedArray0.getInteger(0, 0x30);
            typedArray0.recycle();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public int c;
        public Parcelable d;
        public final ClassLoader e;

        static {
            SavedState.CREATOR = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            if(classLoader0 == null) {
                classLoader0 = this.getClass().getClassLoader();
            }
            this.c = parcel0.readInt();
            this.d = parcel0.readParcelable(classLoader0);
            this.e = classLoader0;
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("FragmentPager.SavedState{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder0.append(" position=");
            return x.g(this.c, "}", stringBuilder0);
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.c);
            parcel0.writeParcelable(this.d, v);
        }
    }

    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator COMPARATOR = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = null;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    a mAdapter;
    private List mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private j mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private l mObserver;
    private int mOffscreenPageLimit;
    private j mOnPageChangeListener;
    private List mOnPageChangeListeners;
    private int mPageMargin;
    private k mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final g mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final Interpolator sInterpolator;
    private static final n sPositionComparator;

    static {
        ViewPager.LAYOUT_ATTRS = new int[]{0x10100B3};
        ViewPager.COMPARATOR = new f(9);
        ViewPager.sInterpolator = new e(0);
        ViewPager.sPositionComparator = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public ViewPager(Context context0) {
        super(context0);
        this.mItems = new ArrayList();
        this.mTempItem = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.402823E+38f;
        this.mLastOffset = 3.402823E+38f;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new t(this, 10);
        this.mScrollState = 0;
        this.initViewPager();
    }

    public ViewPager(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mItems = new ArrayList();
        this.mTempItem = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.402823E+38f;
        this.mLastOffset = 3.402823E+38f;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new t(this, 10);
        this.mScrollState = 0;
        this.initViewPager();
    }

    public final void a(boolean z) {
        boolean z1 = this.mScrollState == 2;
        if(z1) {
            this.setScrollingCacheEnabled(false);
            if(!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int v = this.getScrollX();
                int v1 = this.getScrollY();
                int v2 = this.mScroller.getCurrX();
                int v3 = this.mScroller.getCurrY();
                if(v != v2 || v1 != v3) {
                    this.scrollTo(v2, v3);
                    if(v2 != v) {
                        this.g(v2);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for(int v4 = 0; v4 < this.mItems.size(); ++v4) {
            g g0 = (g)this.mItems.get(v4);
            if(g0.c) {
                g0.c = false;
                z1 = true;
            }
        }
        if(z1) {
            if(z) {
                this.postOnAnimation(this.mEndScrollRunnable);
                return;
            }
            this.mEndScrollRunnable.run();
        }
    }

    @Override  // android.view.ViewGroup
    public void addFocusables(ArrayList arrayList0, int v, int v1) {
        int v2 = arrayList0.size();
        int v3 = this.getDescendantFocusability();
        if(v3 != 0x60000) {
            for(int v4 = 0; v4 < this.getChildCount(); ++v4) {
                View view0 = this.getChildAt(v4);
                if(view0.getVisibility() == 0) {
                    g g0 = this.infoForChild(view0);
                    if(g0 != null && g0.b == this.mCurItem) {
                        view0.addFocusables(arrayList0, v, v1);
                    }
                }
            }
        }
        if(v3 == 0x40000 && v2 != arrayList0.size() || !this.isFocusable() || (v1 & 1) == 1 && this.isInTouchMode() && !this.isFocusableInTouchMode()) {
            return;
        }
        arrayList0.add(this);
    }

    public g addNewItem(int v, int v1) {
        g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.b = v;
        g0.a = this.mAdapter.instantiateItem(this, v);
        g0.d = 1.0f;
        if(v1 >= 0 && v1 < this.mItems.size()) {
            this.mItems.add(v1, g0);
            return g0;
        }
        this.mItems.add(g0);
        return g0;
    }

    public void addOnAdapterChangeListener(i i0) {
        if(this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(i0);
    }

    public void addOnPageChangeListener(j j0) {
        if(this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(j0);
    }

    @Override  // android.view.ViewGroup
    public void addTouchables(ArrayList arrayList0) {
        for(int v = 0; v < this.getChildCount(); ++v) {
            View view0 = this.getChildAt(v);
            if(view0.getVisibility() == 0) {
                g g0 = this.infoForChild(view0);
                if(g0 != null && g0.b == this.mCurItem) {
                    view0.addTouchables(arrayList0);
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(!this.checkLayoutParams(viewGroup$LayoutParams0)) {
            viewGroup$LayoutParams0 = this.generateLayoutParams(viewGroup$LayoutParams0);
        }
        int v1 = ((LayoutParams)viewGroup$LayoutParams0).a | view0.getClass().getAnnotation(androidx.viewpager.widget.f.class) != null;
        ((LayoutParams)viewGroup$LayoutParams0).a = v1;
        if(this.mInLayout) {
            if(v1 != 0) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            ((LayoutParams)viewGroup$LayoutParams0).d = true;
            this.addViewInLayout(view0, v, viewGroup$LayoutParams0);
            return;
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    public boolean arrowScroll(int v) {
        boolean z;
        View view0 = this.findFocus();
        if(view0 == this) {
            view0 = null;
        }
        else if(view0 != null) {
            ViewParent viewParent0 = view0.getParent();
            while(viewParent0 instanceof ViewGroup) {
                if(viewParent0 == this) {
                    goto label_20;
                }
                viewParent0 = viewParent0.getParent();
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(view0.getClass().getSimpleName());
            for(ViewParent viewParent1 = view0.getParent(); viewParent1 instanceof ViewGroup; viewParent1 = viewParent1.getParent()) {
                stringBuilder0.append(" => ");
                stringBuilder0.append(viewParent1.getClass().getSimpleName());
            }
            Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder0.toString());
            view0 = null;
        }
    label_20:
        View view1 = FocusFinder.getInstance().findNextFocus(this, view0, v);
        if(view1 == null || view1 == view0) {
            switch(v) {
                case 1: 
                case 17: {
                    z = this.pageLeft();
                    break;
                }
                case 2: 
                case 66: {
                    z = this.pageRight();
                    break;
                }
                default: {
                    z = false;
                }
            }
        }
        else if(v != 17) {
            if(v != 66) {
                z = false;
            }
            else if(view0 != null && this.d(view1, this.mTempRect).left <= this.d(view0, this.mTempRect).left) {
                z = this.pageRight();
            }
            else {
                z = view1.requestFocus();
            }
        }
        else if(view0 != null && this.d(view1, this.mTempRect).left >= this.d(view0, this.mTempRect).left) {
            z = this.pageLeft();
        }
        else {
            z = view1.requestFocus();
        }
        if(z) {
            this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(v));
        }
        return z;
    }

    public final int b(int v, float f, int v1, int v2) {
        if(Math.abs(v2) <= this.mFlingDistance || Math.abs(v1) <= this.mMinimumVelocity) {
            v += (int)(f + (v < this.mCurItem ? 0.6f : 0.4f));
        }
        else if(v1 <= 0) {
            ++v;
        }
        if(this.mItems.size() > 0) {
            g g0 = (g)this.mItems.get(0);
            int v3 = Math.min(v, ((g)com.iloen.melon.utils.a.i(1, this.mItems)).b);
            return Math.max(g0.b, v3);
        }
        return v;
    }

    public boolean beginFakeDrag() {
        if(this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        this.setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker0 = this.mVelocityTracker;
        if(velocityTracker0 == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        else {
            velocityTracker0.clear();
        }
        long v = SystemClock.uptimeMillis();
        MotionEvent motionEvent0 = MotionEvent.obtain(v, v, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEvent0);
        motionEvent0.recycle();
        this.mFakeDragBeginTime = v;
        return true;
    }

    public final void c(int v) {
        j j0 = this.mOnPageChangeListener;
        if(j0 != null) {
            j0.onPageSelected(v);
        }
        List list0 = this.mOnPageChangeListeners;
        if(list0 != null) {
            int v1 = list0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                j j1 = (j)this.mOnPageChangeListeners.get(v2);
                if(j1 != null) {
                    j1.onPageSelected(v);
                }
            }
        }
        j j2 = this.mInternalPageChangeListener;
        if(j2 != null) {
            j2.onPageSelected(v);
        }
    }

    public boolean canScroll(View view0, boolean z, int v, int v1, int v2) {
        if(view0 instanceof ViewGroup) {
            int v3 = view0.getScrollX();
            int v4 = view0.getScrollY();
            for(int v5 = ((ViewGroup)view0).getChildCount() - 1; v5 >= 0; --v5) {
                View view1 = ((ViewGroup)view0).getChildAt(v5);
                int v6 = v1 + v3;
                if(v6 >= view1.getLeft() && v6 < view1.getRight()) {
                    int v7 = v2 + v4;
                    if(v7 >= view1.getTop() && v7 < view1.getBottom() && this.canScroll(view1, true, v, v6 - view1.getLeft(), v7 - view1.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && view0.canScrollHorizontally(-v);
    }

    @Override  // android.view.View
    public boolean canScrollHorizontally(int v) {
        if(this.mAdapter == null) {
            return false;
        }
        int v1 = this.getClientWidth();
        int v2 = this.getScrollX();
        return v >= 0 ? v > 0 && v2 < ((int)(((float)v1) * this.mLastOffset)) : v2 > ((int)(((float)v1) * this.mFirstOffset));
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams && super.checkLayoutParams(viewGroup$LayoutParams0);
    }

    public void clearOnPageChangeListeners() {
        List list0 = this.mOnPageChangeListeners;
        if(list0 != null) {
            list0.clear();
        }
    }

    @Override  // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if(!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int v = this.getScrollX();
            int v1 = this.getScrollY();
            int v2 = this.mScroller.getCurrX();
            int v3 = this.mScroller.getCurrY();
            if(v != v2 || v1 != v3) {
                this.scrollTo(v2, v3);
                if(!this.g(v2)) {
                    this.mScroller.abortAnimation();
                    this.scrollTo(0, v3);
                }
            }
            this.postInvalidateOnAnimation();
            return;
        }
        this.a(true);
    }

    public final Rect d(View view0, Rect rect0) {
        if(rect0 == null) {
            rect0 = new Rect();
        }
        if(view0 == null) {
            rect0.set(0, 0, 0, 0);
            return rect0;
        }
        rect0.left = view0.getLeft();
        rect0.right = view0.getRight();
        rect0.top = view0.getTop();
        rect0.bottom = view0.getBottom();
        for(ViewParent viewParent0 = view0.getParent(); viewParent0 instanceof ViewGroup && viewParent0 != this; viewParent0 = ((ViewGroup)viewParent0).getParent()) {
            int v = rect0.left;
            rect0.left = ((ViewGroup)viewParent0).getLeft() + v;
            int v1 = rect0.right;
            rect0.right = ((ViewGroup)viewParent0).getRight() + v1;
            int v2 = rect0.top;
            rect0.top = ((ViewGroup)viewParent0).getTop() + v2;
            int v3 = rect0.bottom;
            rect0.bottom = ((ViewGroup)viewParent0).getBottom() + v3;
        }
        return rect0;
    }

    public void dataSetChanged() {
        int v = this.mAdapter.getCount();
        this.mExpectedAdapterCount = v;
        boolean z = this.mItems.size() < this.mOffscreenPageLimit * 2 + 1 && this.mItems.size() < v;
        int v1 = this.mCurItem;
        boolean z1 = false;
        for(int v2 = 0; v2 < this.mItems.size(); ++v2) {
            g g0 = (g)this.mItems.get(v2);
            int v3 = this.mAdapter.getItemPosition(g0.a);
            if(v3 != -1) {
                if(v3 == -2) {
                    this.mItems.remove(v2);
                    --v2;
                    if(!z1) {
                        this.mAdapter.startUpdate(this);
                        z1 = true;
                    }
                    this.mAdapter.destroyItem(this, g0.b, g0.a);
                    int v4 = this.mCurItem;
                    if(v4 == g0.b) {
                        v1 = Math.max(0, Math.min(v4, v - 1));
                    }
                    z = true;
                }
                else {
                    int v5 = g0.b;
                    if(v5 != v3) {
                        if(v5 == this.mCurItem) {
                            v1 = v3;
                        }
                        g0.b = v3;
                        z = true;
                    }
                }
            }
        }
        if(z1) {
            this.mAdapter.finishUpdate(this);
        }
        Collections.sort(this.mItems, ViewPager.COMPARATOR);
        if(z) {
            int v6 = this.getChildCount();
            for(int v7 = 0; v7 < v6; ++v7) {
                LayoutParams viewPager$LayoutParams0 = (LayoutParams)this.getChildAt(v7).getLayoutParams();
                if(!viewPager$LayoutParams0.a) {
                    viewPager$LayoutParams0.c = 0.0f;
                }
            }
            this.setCurrentItemInternal(v1, false, true);
            this.requestLayout();
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        return super.dispatchKeyEvent(keyEvent0) || this.executeKeyEvent(keyEvent0);
    }

    @Override  // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        if(accessibilityEvent0.getEventType() == 0x1000) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent0);
        }
        int v = this.getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            if(view0.getVisibility() == 0) {
                g g0 = this.infoForChild(view0);
                if(g0 != null && g0.b == this.mCurItem && view0.dispatchPopulateAccessibilityEvent(accessibilityEvent0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public float distanceInfluenceForSnapDuration(float f) {
        return (float)Math.sin((f - 0.5f) * 0.471239f);
    }

    @Override  // android.view.View
    public void draw(Canvas canvas0) {
        super.draw(canvas0);
        int v = this.getOverScrollMode();
        boolean z = false;
        if(v == 0 || v == 1 && (this.mAdapter != null && this.mAdapter.getCount() > 1)) {
            if(!this.mLeftEdge.isFinished()) {
                int v1 = canvas0.save();
                int v2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
                int v3 = this.getWidth();
                canvas0.rotate(270.0f);
                canvas0.translate(((float)(this.getPaddingTop() - v2)), this.mFirstOffset * ((float)v3));
                this.mLeftEdge.setSize(v2, v3);
                z = this.mLeftEdge.draw(canvas0);
                canvas0.restoreToCount(v1);
            }
            if(!this.mRightEdge.isFinished()) {
                int v4 = canvas0.save();
                int v5 = this.getWidth();
                int v6 = this.getHeight();
                int v7 = this.getPaddingTop();
                int v8 = this.getPaddingBottom();
                canvas0.rotate(90.0f);
                canvas0.translate(((float)(-this.getPaddingTop())), -(this.mLastOffset + 1.0f) * ((float)v5));
                this.mRightEdge.setSize(v6 - v7 - v8, v5);
                z |= this.mRightEdge.draw(canvas0);
                canvas0.restoreToCount(v4);
            }
        }
        else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if(z) {
            this.postInvalidateOnAnimation();
        }
    }

    @Override  // android.view.ViewGroup
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable0 = this.mMarginDrawable;
        if(drawable0 != null && drawable0.isStateful()) {
            drawable0.setState(this.getDrawableState());
        }
    }

    public final g e() {
        int v = this.getClientWidth();
        float f = 0.0f;
        float f1 = v <= 0 ? 0.0f : ((float)this.getScrollX()) / ((float)v);
        float f2 = v <= 0 ? 0.0f : ((float)this.mPageMargin) / ((float)v);
        int v1 = 0;
        boolean z = true;
        g g0 = null;
        int v2 = -1;
        float f3 = 0.0f;
        while(v1 < this.mItems.size()) {
            g g1 = (g)this.mItems.get(v1);
            if(!z && g1.b != v2 + 1) {
                g1 = this.mTempItem;
                g1.e = f + f3 + f2;
                g1.b = v2 + 1;
                g1.d = 1.0f;
                --v1;
            }
            f = g1.e;
            float f4 = g1.d + f + f2;
            if(!z && f1 < f) {
                break;
            }
            if(f1 >= f4 && v1 != this.mItems.size() - 1) {
                ++v1;
                v2 = g1.b;
                f3 = g1.d;
                g0 = g1;
                z = false;
                continue;
            }
            return g1;
        }
        return g0;
    }

    public void endFakeDrag() {
        if(!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if(this.mAdapter != null) {
            VelocityTracker velocityTracker0 = this.mVelocityTracker;
            velocityTracker0.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
            int v = (int)velocityTracker0.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int v1 = this.getClientWidth();
            int v2 = this.getScrollX();
            g g0 = this.e();
            this.setCurrentItemInternal(this.b(g0.b, (((float)v2) / ((float)v1) - g0.e) / g0.d, v, ((int)(this.mLastMotionX - this.mInitialMotionX))), true, true, v);
        }
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker1 = this.mVelocityTracker;
        if(velocityTracker1 != null) {
            velocityTracker1.recycle();
            this.mVelocityTracker = null;
        }
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent0) {
        if(keyEvent0.getAction() == 0) {
            switch(keyEvent0.getKeyCode()) {
                case 21: {
                    return keyEvent0.hasModifiers(2) ? this.pageLeft() : this.arrowScroll(17);
                }
                case 22: {
                    return keyEvent0.hasModifiers(2) ? this.pageRight() : this.arrowScroll(66);
                }
                case 61: {
                    if(keyEvent0.hasNoModifiers()) {
                        return this.arrowScroll(2);
                    }
                    return keyEvent0.hasModifiers(1) ? this.arrowScroll(1) : false;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    public final void f(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionIndex();
        if(motionEvent0.getPointerId(v) == this.mActivePointerId) {
            int v1 = v == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent0.getX(v1);
            this.mActivePointerId = motionEvent0.getPointerId(v1);
            VelocityTracker velocityTracker0 = this.mVelocityTracker;
            if(velocityTracker0 != null) {
                velocityTracker0.clear();
            }
        }
    }

    public void fakeDragBy(float f) {
        if(!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if(this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f;
        float f1 = ((float)this.getScrollX()) - f;
        float f2 = (float)this.getClientWidth();
        float f3 = this.mFirstOffset * f2;
        float f4 = this.mLastOffset * f2;
        g g0 = (g)this.mItems.get(0);
        g g1 = (g)com.iloen.melon.utils.a.i(1, this.mItems);
        if(g0.b != 0) {
            f3 = g0.e * f2;
        }
        if(g1.b != this.mAdapter.getCount() - 1) {
            f4 = g1.e * f2;
        }
        if(f1 < f3) {
            f1 = f3;
        }
        else if(f1 > f4) {
            f1 = f4;
        }
        this.mLastMotionX = f1 - ((float)(((int)f1))) + this.mLastMotionX;
        this.scrollTo(((int)f1), this.getScrollY());
        this.g(((int)f1));
        long v = SystemClock.uptimeMillis();
        MotionEvent motionEvent0 = MotionEvent.obtain(this.mFakeDragBeginTime, v, 2, this.mLastMotionX, 0.0f, 0);
        this.mVelocityTracker.addMovement(motionEvent0);
        motionEvent0.recycle();
    }

    public final boolean g(int v) {
        if(this.mItems.size() == 0) {
            if(this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            this.onPageScrolled(0, 0.0f, 0);
            if(!this.mCalledSuper) {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            return false;
        }
        g g0 = this.e();
        int v1 = this.getClientWidth();
        int v2 = v1 + this.mPageMargin;
        int v3 = g0.b;
        float f = (((float)v) / ((float)v1) - g0.e) / (g0.d + ((float)this.mPageMargin) / ((float)v1));
        this.mCalledSuper = false;
        this.onPageScrolled(v3, f, ((int)(((float)v2) * f)));
        if(!this.mCalledSuper) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = new LayoutParams(-1, -1);  // 初始化器: Landroid/view/ViewGroup$LayoutParams;-><init>(II)V
        viewGroup$LayoutParams0.c = 0.0f;
        return viewGroup$LayoutParams0;
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    @Override  // android.view.ViewGroup
    public int getChildDrawingOrder(int v, int v1) {
        if(this.mDrawingOrder == 2) {
            v1 = v - 1 - v1;
        }
        return ((LayoutParams)((View)this.mDrawingOrderedChildren.get(v1)).getLayoutParams()).f;
    }

    private int getClientWidth() {
        return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public final boolean h(float f) {
        boolean z2;
        boolean z1;
        float f1 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float f2 = ((float)this.getScrollX()) + f1;
        float f3 = (float)this.getClientWidth();
        float f4 = this.mFirstOffset * f3;
        float f5 = this.mLastOffset * f3;
        boolean z = false;
        g g0 = (g)this.mItems.get(0);
        g g1 = (g)com.iloen.melon.utils.a.i(1, this.mItems);
        if(g0.b == 0) {
            z1 = true;
        }
        else {
            f4 = g0.e * f3;
            z1 = false;
        }
        if(g1.b == this.mAdapter.getCount() - 1) {
            z2 = true;
        }
        else {
            f5 = g1.e * f3;
            z2 = false;
        }
        if(f2 < f4) {
            if(z1) {
                this.mLeftEdge.onPull(Math.abs(f4 - f2) / f3);
                z = true;
            }
            f2 = f4;
        }
        else if(f2 > f5) {
            if(z2) {
                this.mRightEdge.onPull(Math.abs(f2 - f5) / f3);
                z = true;
            }
            f2 = f5;
        }
        this.mLastMotionX = f2 - ((float)(((int)f2))) + this.mLastMotionX;
        this.scrollTo(((int)f2), this.getScrollY());
        this.g(((int)f2));
        return z;
    }

    public final void i(int v, int v1, int v2, int v3) {
        if(v1 > 0 && !this.mItems.isEmpty()) {
            if(!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(this.getCurrentItem() * this.getClientWidth());
                return;
            }
            int v4 = this.getPaddingLeft();
            int v5 = this.getPaddingRight();
            int v6 = this.getPaddingLeft();
            int v7 = this.getPaddingRight();
            this.scrollTo(((int)(((float)this.getScrollX()) / ((float)(v1 - v6 - v7 + v3)) * ((float)(v - v4 - v5 + v2)))), this.getScrollY());
            return;
        }
        g g0 = this.infoForPosition(this.mCurItem);
        int v8 = (int)((g0 == null ? 0.0f : Math.min(g0.e, this.mLastOffset)) * ((float)(v - this.getPaddingLeft() - this.getPaddingRight())));
        if(v8 != this.getScrollX()) {
            this.a(false);
            this.scrollTo(v8, this.getScrollY());
        }
    }

    public g infoForAnyChild(View view0) {
        ViewParent viewParent0;
        while((viewParent0 = view0.getParent()) != this) {
            if(viewParent0 != null && viewParent0 instanceof View) {
                view0 = (View)viewParent0;
                continue;
            }
            return null;
        }
        return this.infoForChild(view0);
    }

    public g infoForChild(View view0) {
        for(int v = 0; v < this.mItems.size(); ++v) {
            g g0 = (g)this.mItems.get(v);
            if(this.mAdapter.isViewFromObject(view0, g0.a)) {
                return g0;
            }
        }
        return null;
    }

    public g infoForPosition(int v) {
        for(int v1 = 0; v1 < this.mItems.size(); ++v1) {
            g g0 = (g)this.mItems.get(v1);
            if(g0.b == v) {
                return g0;
            }
        }
        return null;
    }

    public void initViewPager() {
        this.setWillNotDraw(false);
        this.setDescendantFocusability(0x40000);
        this.setFocusable(true);
        Context context0 = this.getContext();
        this.mScroller = new Scroller(context0, ViewPager.sInterpolator);
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
        float f = context0.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration0.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int)(400.0f * f);
        this.mMaximumVelocity = viewConfiguration0.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context0);
        this.mRightEdge = new EdgeEffect(context0);
        this.mFlingDistance = (int)(25.0f * f);
        this.mCloseEnough = (int)(2.0f * f);
        this.mDefaultGutterSize = (int)(f * 16.0f);
        W.o(this, new h(this));
        if(this.getImportantForAccessibility() == 0) {
            this.setImportantForAccessibility(1);
        }
        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.b = this;
        b0.a = new Rect();
        M.n(this, b0);
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public final boolean j() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker0 = this.mVelocityTracker;
        if(velocityTracker0 != null) {
            velocityTracker0.recycle();
            this.mVelocityTracker = null;
        }
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    public final void k(int v, int v1, boolean z, boolean z1) {
        int v2;
        g g0 = this.infoForPosition(v);
        if(g0 == null) {
            v2 = 0;
        }
        else {
            float f = (float)this.getClientWidth();
            v2 = (int)(Math.max(this.mFirstOffset, Math.min(g0.e, this.mLastOffset)) * f);
        }
        if(z) {
            this.smoothScrollTo(v2, 0, v1);
            if(z1) {
                this.c(v);
            }
            return;
        }
        if(z1) {
            this.c(v);
        }
        this.a(false);
        this.scrollTo(v2, 0);
        this.g(v2);
    }

    public final void l() {
        if(this.mDrawingOrder != 0) {
            ArrayList arrayList0 = this.mDrawingOrderedChildren;
            if(arrayList0 == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            }
            else {
                arrayList0.clear();
            }
            int v = this.getChildCount();
            for(int v1 = 0; v1 < v; ++v1) {
                View view0 = this.getChildAt(v1);
                this.mDrawingOrderedChildren.add(view0);
            }
            Collections.sort(this.mDrawingOrderedChildren, ViewPager.sPositionComparator);
        }
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        this.removeCallbacks(this.mEndScrollRunnable);
        if(this.mScroller != null && !this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public void onDraw(Canvas canvas0) {
        int v7;
        float f2;
        super.onDraw(canvas0);
        if(this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int v = this.getScrollX();
            int v1 = this.getWidth();
            float f = ((float)this.mPageMargin) / ((float)v1);
            int v2 = 0;
            g g0 = (g)this.mItems.get(0);
            float f1 = g0.e;
            int v3 = this.mItems.size();
            int v4 = g0.b;
            int v5 = ((g)this.mItems.get(v3 - 1)).b;
            while(v4 < v5) {
                while(true) {
                    int v6 = g0.b;
                    if(v4 <= v6 || v2 >= v3) {
                        break;
                    }
                    ++v2;
                    g0 = (g)this.mItems.get(v2);
                }
                if(v4 == v6) {
                    f2 = (g0.e + g0.d) * ((float)v1);
                    f1 = g0.e + g0.d + f;
                }
                else {
                    f2 = (f1 + 1.0f) * ((float)v1);
                    f1 = f + 1.0f + f1;
                }
                if(((float)this.mPageMargin) + f2 > ((float)v)) {
                    v7 = v;
                    this.mMarginDrawable.setBounds(Math.round(f2), this.mTopPageBounds, Math.round(((float)this.mPageMargin) + f2), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas0);
                }
                else {
                    v7 = v;
                }
                if(f2 > ((float)(v7 + v1))) {
                    break;
                }
                ++v4;
                v = v7;
            }
        }
    }

    @Override  // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        switch(v & 0xFF) {
            case 0: {
                break;
            }
            case 1: 
            case 3: {
                this.j();
                return false;
            label_5:
                if(this.mIsBeingDragged) {
                    return true;
                }
                if(this.mIsUnableToDrag) {
                    return false;
                }
                break;
            }
            default: {
                goto label_5;
            }
        }
        switch(v & 0xFF) {
            case 0: {
                float f = motionEvent0.getX();
                this.mInitialMotionX = f;
                this.mLastMotionX = f;
                float f1 = motionEvent0.getY();
                this.mInitialMotionY = f1;
                this.mLastMotionY = f1;
                this.mActivePointerId = motionEvent0.getPointerId(0);
                this.mIsUnableToDrag = false;
                this.mIsScrollStarted = true;
                this.mScroller.computeScrollOffset();
                if(this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                    this.a(false);
                    this.mIsBeingDragged = false;
                }
                else {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    this.populate();
                    this.mIsBeingDragged = true;
                    ViewParent viewParent0 = this.getParent();
                    if(viewParent0 != null) {
                        viewParent0.requestDisallowInterceptTouchEvent(true);
                    }
                    this.setScrollState(1);
                }
                break;
            }
            case 2: {
                int v1 = this.mActivePointerId;
                if(v1 != -1) {
                    int v2 = motionEvent0.findPointerIndex(v1);
                    float f2 = motionEvent0.getX(v2);
                    float f3 = f2 - this.mLastMotionX;
                    float f4 = Math.abs(f3);
                    float f5 = motionEvent0.getY(v2);
                    float f6 = Math.abs(f5 - this.mInitialMotionY);
                    int v3 = Float.compare(f3, 0.0f);
                    if(v3 != 0 && ((this.mLastMotionX >= ((float)this.mGutterSize) || v3 <= 0) && (this.mLastMotionX <= ((float)(this.getWidth() - this.mGutterSize)) || f3 >= 0.0f) && this.canScroll(this, false, ((int)f3), ((int)f2), ((int)f5)))) {
                        this.mLastMotionX = f2;
                        this.mLastMotionY = f5;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                    float f7 = (float)this.mTouchSlop;
                    if(f4 > f7 && f4 * 0.5f > f6) {
                        this.mIsBeingDragged = true;
                        ViewParent viewParent1 = this.getParent();
                        if(viewParent1 != null) {
                            viewParent1.requestDisallowInterceptTouchEvent(true);
                        }
                        this.setScrollState(1);
                        float f8 = (float)this.mTouchSlop;
                        this.mLastMotionX = v3 <= 0 ? this.mInitialMotionX - f8 : this.mInitialMotionX + f8;
                        this.mLastMotionY = f5;
                        this.setScrollingCacheEnabled(true);
                    }
                    else if(f6 > f7) {
                        this.mIsUnableToDrag = true;
                    }
                    if(this.mIsBeingDragged && this.h(f2)) {
                        this.postInvalidateOnAnimation();
                    }
                }
                break;
            }
            default: {
                if((v & 0xFF) == 6) {
                    this.f(motionEvent0);
                }
            }
        }
        if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent0);
        return this.mIsBeingDragged;
    }

    @Override  // android.view.ViewGroup
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v17;
        int v15;
        int v4 = this.getChildCount();
        int v5 = v2 - v;
        int v6 = v3 - v1;
        int v7 = this.getPaddingLeft();
        int v8 = this.getPaddingTop();
        int v9 = this.getPaddingRight();
        int v10 = this.getPaddingBottom();
        int v11 = this.getScrollX();
        int v13 = 0;
        for(int v12 = 0; v12 < v4; ++v12) {
            View view0 = this.getChildAt(v12);
            if(view0.getVisibility() != 8) {
                LayoutParams viewPager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(viewPager$LayoutParams0.a) {
                    int v14 = viewPager$LayoutParams0.b & 0x70;
                    switch(viewPager$LayoutParams0.b & 7) {
                        case 1: {
                            v15 = v7;
                            v7 = Math.max((v5 - view0.getMeasuredWidth()) / 2, v7);
                            break;
                        }
                        case 3: {
                            v15 = view0.getMeasuredWidth() + v7;
                            break;
                        }
                        case 5: {
                            int v16 = v5 - v9 - view0.getMeasuredWidth();
                            v9 += view0.getMeasuredWidth();
                            v15 = v7;
                            v7 = v16;
                            break;
                        }
                        default: {
                            v15 = v7;
                        }
                    }
                    switch(v14) {
                        case 16: {
                            v17 = v8;
                            v8 = Math.max((v6 - view0.getMeasuredHeight()) / 2, v8);
                            break;
                        }
                        case 0x30: {
                            v17 = view0.getMeasuredHeight() + v8;
                            break;
                        }
                        case 80: {
                            int v18 = v6 - v10 - view0.getMeasuredHeight();
                            v10 += view0.getMeasuredHeight();
                            v17 = v8;
                            v8 = v18;
                            break;
                        }
                        default: {
                            v17 = v8;
                        }
                    }
                    view0.layout(v7 + v11, v8, view0.getMeasuredWidth() + (v7 + v11), view0.getMeasuredHeight() + v8);
                    ++v13;
                    v8 = v17;
                    v7 = v15;
                }
            }
        }
        for(int v19 = 0; v19 < v4; ++v19) {
            View view1 = this.getChildAt(v19);
            if(view1.getVisibility() != 8) {
                LayoutParams viewPager$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                if(!viewPager$LayoutParams1.a) {
                    g g0 = this.infoForChild(view1);
                    if(g0 != null) {
                        float f = (float)(v5 - v7 - v9);
                        int v20 = ((int)(g0.e * f)) + v7;
                        if(viewPager$LayoutParams1.d) {
                            viewPager$LayoutParams1.d = false;
                            view1.measure(View.MeasureSpec.makeMeasureSpec(((int)(f * viewPager$LayoutParams1.c)), 0x40000000), View.MeasureSpec.makeMeasureSpec(v6 - v8 - v10, 0x40000000));
                        }
                        view1.layout(v20, v8, view1.getMeasuredWidth() + v20, view1.getMeasuredHeight() + v8);
                    }
                }
            }
        }
        this.mTopPageBounds = v8;
        this.mBottomPageBounds = v6 - v10;
        this.mDecorChildCount = v13;
        if(this.mFirstLayout) {
            this.k(this.mCurItem, 0, false, false);
        }
        this.mFirstLayout = false;
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        int v11;
        this.setMeasuredDimension(View.getDefaultSize(0, v), View.getDefaultSize(0, v1));
        int v3 = this.getMeasuredWidth();
        this.mGutterSize = Math.min(v3 / 10, this.mDefaultGutterSize);
        int v4 = v3 - this.getPaddingLeft() - this.getPaddingRight();
        int v5 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
        int v6 = this.getChildCount();
        for(int v7 = 0; true; ++v7) {
            boolean z = true;
            int v8 = 0x40000000;
            if(v7 >= v6) {
                break;
            }
            View view0 = this.getChildAt(v7);
            if(view0.getVisibility() != 8) {
                LayoutParams viewPager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(viewPager$LayoutParams0 != null && viewPager$LayoutParams0.a) {
                    int v9 = viewPager$LayoutParams0.b & 7;
                    boolean z1 = (viewPager$LayoutParams0.b & 0x70) == 0x30 || (viewPager$LayoutParams0.b & 0x70) == 80;
                    if(v9 != 3 && v9 != 5) {
                        z = false;
                    }
                    int v10 = 0x80000000;
                    if(z1) {
                        v11 = 0x80000000;
                        v10 = 0x40000000;
                    }
                    else {
                        v11 = z ? 0x40000000 : 0x80000000;
                    }
                    int v12 = viewPager$LayoutParams0.width;
                    switch(v12) {
                        case -2: {
                            v12 = v4;
                            break;
                        }
                        case -1: {
                            v12 = v4;
                            v10 = 0x40000000;
                            break;
                        }
                        default: {
                            v10 = 0x40000000;
                        }
                    }
                    int v13 = viewPager$LayoutParams0.height;
                    switch(v13) {
                        case -2: {
                            v13 = v5;
                            v8 = v11;
                            break;
                        }
                        case -1: {
                            v13 = v5;
                        }
                    }
                    view0.measure(View.MeasureSpec.makeMeasureSpec(v12, v10), View.MeasureSpec.makeMeasureSpec(v13, v8));
                    if(z1) {
                        v5 -= view0.getMeasuredHeight();
                    }
                    else if(z) {
                        v4 -= view0.getMeasuredWidth();
                    }
                }
            }
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(v4, 0x40000000);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(v5, 0x40000000);
        this.mInLayout = true;
        this.populate();
        this.mInLayout = false;
        int v14 = this.getChildCount();
        for(int v2 = 0; v2 < v14; ++v2) {
            View view1 = this.getChildAt(v2);
            if(view1.getVisibility() != 8) {
                LayoutParams viewPager$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                if(viewPager$LayoutParams1 == null || !viewPager$LayoutParams1.a) {
                    view1.measure(View.MeasureSpec.makeMeasureSpec(((int)(((float)v4) * viewPager$LayoutParams1.c)), 0x40000000), this.mChildHeightMeasureSpec);
                }
            }
        }
    }

    public void onPageScrolled(int v, float f, int v1) {
        int v9;
        if(this.mDecorChildCount > 0) {
            int v3 = this.getScrollX();
            int v4 = this.getPaddingLeft();
            int v5 = this.getPaddingRight();
            int v6 = this.getWidth();
            int v7 = this.getChildCount();
            for(int v8 = 0; v8 < v7; ++v8) {
                View view0 = this.getChildAt(v8);
                LayoutParams viewPager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(viewPager$LayoutParams0.a) {
                    switch(viewPager$LayoutParams0.b & 7) {
                        case 1: {
                            v9 = v4;
                            v4 = Math.max((v6 - view0.getMeasuredWidth()) / 2, v4);
                            break;
                        }
                        case 3: {
                            v9 = view0.getWidth() + v4;
                            break;
                        }
                        case 5: {
                            int v10 = v6 - v5 - view0.getMeasuredWidth();
                            v5 += view0.getMeasuredWidth();
                            v9 = v4;
                            v4 = v10;
                            break;
                        }
                        default: {
                            v9 = v4;
                        }
                    }
                    int v11 = v4 + v3 - view0.getLeft();
                    if(v11 != 0) {
                        view0.offsetLeftAndRight(v11);
                    }
                    v4 = v9;
                }
            }
        }
        j j0 = this.mOnPageChangeListener;
        if(j0 != null) {
            j0.onPageScrolled(v, f, v1);
        }
        List list0 = this.mOnPageChangeListeners;
        if(list0 != null) {
            int v12 = list0.size();
            for(int v13 = 0; v13 < v12; ++v13) {
                j j1 = (j)this.mOnPageChangeListeners.get(v13);
                if(j1 != null) {
                    j1.onPageScrolled(v, f, v1);
                }
            }
        }
        j j2 = this.mInternalPageChangeListener;
        if(j2 != null) {
            j2.onPageScrolled(v, f, v1);
        }
        if(this.mPageTransformer != null) {
            int v14 = this.getScrollX();
            int v15 = this.getChildCount();
            for(int v2 = 0; v2 < v15; ++v2) {
                View view1 = this.getChildAt(v2);
                if(!((LayoutParams)view1.getLayoutParams()).a) {
                    float f1 = ((float)(view1.getLeft() - v14)) / ((float)this.getClientWidth());
                    this.mPageTransformer.transformPage(view1, f1);
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override  // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int v, Rect rect0) {
        int v4;
        int v3;
        int v2;
        int v1 = this.getChildCount();
        if((v & 2) == 0) {
            v3 = v1 - 1;
            v2 = -1;
            v4 = -1;
        }
        else {
            v2 = v1;
            v3 = 0;
            v4 = 1;
        }
        while(v3 != v2) {
            View view0 = this.getChildAt(v3);
            if(view0.getVisibility() == 0) {
                g g0 = this.infoForChild(view0);
                if(g0 != null && g0.b == this.mCurItem && view0.requestFocus(v, rect0)) {
                    return true;
                }
            }
            v3 += v4;
        }
        return false;
    }

    @Override  // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        ClassLoader classLoader0 = ((SavedState)parcelable0).e;
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        a a0 = this.mAdapter;
        if(a0 != null) {
            a0.restoreState(((SavedState)parcelable0).d, classLoader0);
            this.setCurrentItemInternal(((SavedState)parcelable0).c, false, true);
            return;
        }
        this.mRestoredCurItem = ((SavedState)parcelable0).c;
        this.mRestoredAdapterState = ((SavedState)parcelable0).d;
        this.mRestoredClassLoader = classLoader0;
    }

    @Override  // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.c = this.mCurItem;
        a a0 = this.mAdapter;
        if(a0 != null) {
            parcelable0.d = a0.saveState();
        }
        return parcelable0;
    }

    @Override  // android.view.View
    public void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        if(v != v2) {
            this.i(v, v2, this.mPageMargin, this.mPageMargin);
        }
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        boolean z = false;
        if(!this.mFakeDragging) {
            if(motionEvent0.getAction() == 0 && motionEvent0.getEdgeFlags() != 0 || (this.mAdapter == null || this.mAdapter.getCount() == 0)) {
                return false;
            }
            if(this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent0);
            int v = motionEvent0.getAction();
            switch(v & 0xFF) {
                case 0: {
                    this.mScroller.abortAnimation();
                    this.mPopulatePending = false;
                    this.populate();
                    float f3 = motionEvent0.getX();
                    this.mInitialMotionX = f3;
                    this.mLastMotionX = f3;
                    float f4 = motionEvent0.getY();
                    this.mInitialMotionY = f4;
                    this.mLastMotionY = f4;
                    this.mActivePointerId = motionEvent0.getPointerId(0);
                    break;
                }
                case 1: {
                    if(this.mIsBeingDragged) {
                        VelocityTracker velocityTracker0 = this.mVelocityTracker;
                        velocityTracker0.computeCurrentVelocity(1000, ((float)this.mMaximumVelocity));
                        int v3 = (int)velocityTracker0.getXVelocity(this.mActivePointerId);
                        this.mPopulatePending = true;
                        int v4 = this.getClientWidth();
                        int v5 = this.getScrollX();
                        g g0 = this.e();
                        this.setCurrentItemInternal(this.b(g0.b, (((float)v5) / ((float)v4) - g0.e) / (g0.d + ((float)this.mPageMargin) / ((float)v4)), v3, ((int)(motionEvent0.getX(motionEvent0.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX))), true, true, v3);
                        z = this.j();
                    }
                    break;
                }
                default: {
                    switch(v & 0xFF) {
                        case 2: {
                            if(this.mIsBeingDragged) {
                            label_30:
                                if(this.mIsBeingDragged) {
                                    z = this.h(motionEvent0.getX(motionEvent0.findPointerIndex(this.mActivePointerId)));
                                }
                            }
                            else {
                                int v1 = motionEvent0.findPointerIndex(this.mActivePointerId);
                                if(v1 == -1) {
                                    z = this.j();
                                }
                                else {
                                    float f = motionEvent0.getX(v1);
                                    float f1 = Math.abs(f - this.mLastMotionX);
                                    float f2 = motionEvent0.getY(v1);
                                    if(f1 > ((float)this.mTouchSlop) && f1 > Math.abs(f2 - this.mLastMotionY)) {
                                        this.mIsBeingDragged = true;
                                        ViewParent viewParent0 = this.getParent();
                                        if(viewParent0 != null) {
                                            viewParent0.requestDisallowInterceptTouchEvent(true);
                                        }
                                        this.mLastMotionX = f - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + ((float)this.mTouchSlop) : this.mInitialMotionX - ((float)this.mTouchSlop);
                                        this.mLastMotionY = f2;
                                        this.setScrollState(1);
                                        this.setScrollingCacheEnabled(true);
                                        ViewParent viewParent1 = this.getParent();
                                        if(viewParent1 != null) {
                                            viewParent1.requestDisallowInterceptTouchEvent(true);
                                        }
                                    }
                                    goto label_30;
                                }
                            }
                            break;
                        }
                        case 3: {
                            if(this.mIsBeingDragged) {
                                this.k(this.mCurItem, 0, true, false);
                                z = this.j();
                            }
                            break;
                        }
                        case 5: {
                            int v2 = motionEvent0.getActionIndex();
                            this.mLastMotionX = motionEvent0.getX(v2);
                            this.mActivePointerId = motionEvent0.getPointerId(v2);
                            break;
                        }
                        case 6: {
                            this.f(motionEvent0);
                            this.mLastMotionX = motionEvent0.getX(motionEvent0.findPointerIndex(this.mActivePointerId));
                        }
                    }
                }
            }
            if(z) {
                this.postInvalidateOnAnimation();
                return true;
            }
        }
        return true;
    }

    public boolean pageLeft() {
        int v = this.mCurItem;
        if(v > 0) {
            this.setCurrentItem(v - 1, true);
            return true;
        }
        return false;
    }

    public boolean pageRight() {
        if(this.mAdapter != null && this.mCurItem < this.mAdapter.getCount() - 1) {
            this.setCurrentItem(this.mCurItem + 1, true);
            return true;
        }
        return false;
    }

    public void populate() {
        this.populate(this.mCurItem);
    }

    public void populate(int v) {
        String s;
        g g3;
        float f;
        g g1;
        g g0;
        int v1 = this.mCurItem;
        if(v1 == v) {
            g0 = null;
        }
        else {
            g0 = this.infoForPosition(v1);
            this.mCurItem = v;
        }
        if(this.mAdapter == null) {
            this.l();
            return;
        }
        if(this.mPopulatePending) {
            this.l();
            return;
        }
        if(this.getWindowToken() != null) {
            this.mAdapter.startUpdate(this);
            int v2 = this.mOffscreenPageLimit;
            int v4 = Math.max(0, this.mCurItem - v2);
            int v5 = this.mAdapter.getCount();
            int v6 = Math.min(v5 - 1, this.mCurItem + v2);
            if(v5 != this.mExpectedAdapterCount) {
                goto label_214;
            }
            int v7 = 0;
            while(true) {
                if(v7 < this.mItems.size()) {
                    g1 = (g)this.mItems.get(v7);
                    int v8 = g1.b;
                    int v9 = this.mCurItem;
                    if(v8 < v9) {
                        ++v7;
                        continue;
                    }
                    else if(v8 == v9) {
                        break;
                    }
                }
                g1 = null;
                break;
            }
            if(g1 == null && v5 > 0) {
                g1 = this.addNewItem(this.mCurItem, v7);
            }
            if(g1 != null) {
                int v10 = v7 - 1;
                g g2 = v10 < 0 ? null : ((g)this.mItems.get(v10));
                int v11 = this.getClientWidth();
                if(v11 <= 0) {
                    f = 0.0f;
                }
                else {
                    float f1 = 2.0f - g1.d;
                    f = ((float)this.getPaddingLeft()) / ((float)v11) + f1;
                }
                int v12 = this.mCurItem - 1;
                float f2 = 0.0f;
                while(v12 >= 0) {
                    if(f2 < f || v12 >= v4) {
                        if(g2 == null || v12 != g2.b) {
                            f2 += this.addNewItem(v12, v10 + 1).d;
                            ++v7;
                            if(v10 >= 0) {
                                g3 = (g)this.mItems.get(v10);
                                goto label_70;
                            }
                        }
                        else {
                            f2 += g2.d;
                            --v10;
                            if(v10 >= 0) {
                                g3 = (g)this.mItems.get(v10);
                                goto label_70;
                            }
                        }
                        g3 = null;
                    label_70:
                        g2 = g3;
                    }
                    else {
                        if(g2 == null) {
                            break;
                        }
                        if(v12 == g2.b && !g2.c) {
                            this.mItems.remove(v10);
                            this.mAdapter.destroyItem(this, v12, g2.a);
                            --v10;
                            --v7;
                            g2 = v10 >= 0 ? ((g)this.mItems.get(v10)) : null;
                        }
                    }
                    --v12;
                }
                float f3 = g1.d;
                int v13 = v7 + 1;
                if(f3 < 2.0f) {
                    g g4 = v13 >= this.mItems.size() ? null : ((g)this.mItems.get(v13));
                    float f4 = v11 > 0 ? ((float)this.getPaddingRight()) / ((float)v11) + 2.0f : 0.0f;
                    int v14 = this.mCurItem + 1;
                    int v15 = v13;
                    while(v14 < v5) {
                        if(f3 < f4 || v14 <= v6) {
                        label_92:
                            if(g4 == null || v14 != g4.b) {
                                g g5 = this.addNewItem(v14, v15);
                                ++v15;
                                f3 += g5.d;
                                if(v15 < this.mItems.size()) {
                                    g4 = (g)this.mItems.get(v15);
                                    goto label_105;
                                }
                            }
                            else {
                                f3 += g4.d;
                                ++v15;
                                if(v15 < this.mItems.size()) {
                                    g4 = (g)this.mItems.get(v15);
                                    goto label_105;
                                }
                            }
                            g4 = null;
                        }
                        else {
                            if(g4 == null) {
                                break;
                            }
                            if(v14 == g4.b && !g4.c) {
                                this.mItems.remove(v15);
                                this.mAdapter.destroyItem(this, v14, g4.a);
                                if(v15 < this.mItems.size()) {
                                    g4 = (g)this.mItems.get(v15);
                                    goto label_105;
                                }
                                else {
                                    g4 = null;
                                    ++v14;
                                    continue;
                                }
                                goto label_92;
                            }
                        }
                    label_105:
                        ++v14;
                    }
                }
                int v16 = this.mAdapter.getCount();
                int v17 = this.getClientWidth();
                float f5 = v17 <= 0 ? 0.0f : ((float)this.mPageMargin) / ((float)v17);
                if(g0 != null) {
                    int v18 = g0.b;
                    int v19 = g1.b;
                    if(v18 < v19) {
                        float f6 = g0.e + g0.d + f5;
                        int v20 = v18 + 1;
                        int v21 = 0;
                        while(v20 <= g1.b && v21 < this.mItems.size()) {
                            g g6;
                            for(g6 = (g)this.mItems.get(v21); v20 > g6.b && v21 < this.mItems.size() - 1; g6 = (g)this.mItems.get(v21)) {
                                ++v21;
                            }
                            while(v20 < g6.b) {
                                f6 += f5 + 1.0f;
                                ++v20;
                            }
                            g6.e = f6;
                            f6 += g6.d + f5;
                            ++v20;
                        }
                    }
                    else if(v18 > v19) {
                        int v22 = this.mItems.size() - 1;
                        float f7 = g0.e;
                        for(int v23 = v18 - 1; v23 >= g1.b && v22 >= 0; --v23) {
                            g g7;
                            for(g7 = (g)this.mItems.get(v22); v23 < g7.b && v22 > 0; g7 = (g)this.mItems.get(v22)) {
                                --v22;
                            }
                            while(v23 > g7.b) {
                                f7 -= f5 + 1.0f;
                                --v23;
                            }
                            f7 -= g7.d + f5;
                            g7.e = f7;
                        }
                    }
                }
                int v24 = this.mItems.size();
                float f8 = g1.e;
                int v25 = g1.b - 1;
                this.mFirstOffset = g1.b == 0 ? f8 : -3.402823E+38f;
                this.mLastOffset = g1.b == v16 - 1 ? g1.d + f8 - 1.0f : 3.402823E+38f;
                int v26 = v7 - 1;
                while(v26 >= 0) {
                    g g8 = (g)this.mItems.get(v26);
                    while(true) {
                        int v27 = g8.b;
                        if(v25 <= v27) {
                            break;
                        }
                        f8 -= f5 + 1.0f;
                        --v25;
                    }
                    f8 -= g8.d + f5;
                    g8.e = f8;
                    if(v27 == 0) {
                        this.mFirstOffset = f8;
                    }
                    --v26;
                    --v25;
                }
                float f9 = g1.e + g1.d + f5;
                int v28 = g1.b;
                while(true) {
                    ++v28;
                    if(v13 >= v24) {
                        break;
                    }
                    g g9 = (g)this.mItems.get(v13);
                    while(true) {
                        int v29 = g9.b;
                        if(v28 >= v29) {
                            break;
                        }
                        f9 += f5 + 1.0f;
                        ++v28;
                    }
                    if(v29 == v16 - 1) {
                        this.mLastOffset = g9.d + f9 - 1.0f;
                    }
                    g9.e = f9;
                    f9 += g9.d + f5;
                    ++v13;
                }
                this.mNeedCalculatePageOffsets = false;
                this.mAdapter.setPrimaryItem(this, this.mCurItem, g1.a);
            }
            this.mAdapter.finishUpdate(this);
            int v30 = this.getChildCount();
            for(int v31 = 0; v31 < v30; ++v31) {
                View view0 = this.getChildAt(v31);
                LayoutParams viewPager$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                viewPager$LayoutParams0.f = v31;
                if(!viewPager$LayoutParams0.a && viewPager$LayoutParams0.c == 0.0f) {
                    g g10 = this.infoForChild(view0);
                    if(g10 != null) {
                        viewPager$LayoutParams0.c = g10.d;
                        viewPager$LayoutParams0.e = g10.b;
                    }
                }
            }
            this.l();
            if(this.hasFocus()) {
                View view1 = this.findFocus();
                g g11 = view1 == null ? null : this.infoForAnyChild(view1);
                if(g11 == null || g11.b != this.mCurItem) {
                    for(int v3 = 0; v3 < this.getChildCount(); ++v3) {
                        View view2 = this.getChildAt(v3);
                        g g12 = this.infoForChild(view2);
                        if(g12 != null && g12.b == this.mCurItem && view2.requestFocus(2)) {
                            return;
                        }
                    }
                    return;
                    try {
                    label_214:
                        s = this.getResources().getResourceName(this.getId());
                    }
                    catch(Resources.NotFoundException unused_ex) {
                        s = Integer.toHexString(this.getId());
                    }
                    StringBuilder stringBuilder0 = new StringBuilder("The application\'s PagerAdapter changed the adapter\'s contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
                    x.x(stringBuilder0, this.mExpectedAdapterCount, ", found: ", v5, " Pager id: ");
                    stringBuilder0.append(s);
                    stringBuilder0.append(" Pager class: ");
                    stringBuilder0.append(this.getClass());
                    stringBuilder0.append(" Problematic adapter: ");
                    stringBuilder0.append(this.mAdapter.getClass());
                    throw new IllegalStateException(stringBuilder0.toString());
                }
            }
        }
    }

    public void removeOnAdapterChangeListener(i i0) {
        List list0 = this.mAdapterChangeListeners;
        if(list0 != null) {
            list0.remove(i0);
        }
    }

    public void removeOnPageChangeListener(j j0) {
        List list0 = this.mOnPageChangeListeners;
        if(list0 != null) {
            list0.remove(j0);
        }
    }

    @Override  // android.view.ViewGroup
    public void removeView(View view0) {
        if(this.mInLayout) {
            this.removeViewInLayout(view0);
            return;
        }
        super.removeView(view0);
    }

    public void setAdapter(a a0) {
        a a1 = this.mAdapter;
        if(a1 != null) {
            a1.setViewPagerObserver(null);
            this.mAdapter.startUpdate(this);
            for(int v1 = 0; v1 < this.mItems.size(); ++v1) {
                g g0 = (g)this.mItems.get(v1);
                this.mAdapter.destroyItem(this, g0.b, g0.a);
            }
            this.mAdapter.finishUpdate(this);
            this.mItems.clear();
            for(int v2 = 0; v2 < this.getChildCount(); ++v2) {
                if(!((LayoutParams)this.getChildAt(v2).getLayoutParams()).a) {
                    this.removeViewAt(v2);
                    --v2;
                }
            }
            this.mCurItem = 0;
            this.scrollTo(0, 0);
        }
        a a2 = this.mAdapter;
        this.mAdapter = a0;
        this.mExpectedAdapterCount = 0;
        if(a0 != null) {
            if(this.mObserver == null) {
                this.mObserver = new l(this);
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if(this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                this.setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            }
            else if(z) {
                this.requestLayout();
            }
            else {
                this.populate();
            }
        }
        if(this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
            int v3 = this.mAdapterChangeListeners.size();
            for(int v = 0; v < v3; ++v) {
                ((i)this.mAdapterChangeListeners.get(v)).a(this, a2, a0);
            }
        }
    }

    public void setCurrentItem(int v) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(v, !this.mFirstLayout, false);
    }

    public void setCurrentItem(int v, boolean z) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(v, z, false);
    }

    public void setCurrentItemInternal(int v, boolean z, boolean z1) {
        this.setCurrentItemInternal(v, z, z1, 0);
    }

    public void setCurrentItemInternal(int v, boolean z, boolean z1, int v1) {
        boolean z2 = false;
        if(this.mAdapter != null && this.mAdapter.getCount() > 0) {
            if(!z1 && this.mCurItem == v && this.mItems.size() != 0) {
                this.setScrollingCacheEnabled(false);
                return;
            }
            if(v < 0) {
                v = 0;
            }
            else if(v >= this.mAdapter.getCount()) {
                v = this.mAdapter.getCount() - 1;
            }
            if(v > this.mCurItem + this.mOffscreenPageLimit || v < this.mCurItem - this.mOffscreenPageLimit) {
                for(int v2 = 0; v2 < this.mItems.size(); ++v2) {
                    ((g)this.mItems.get(v2)).c = true;
                }
            }
            if(this.mCurItem != v) {
                z2 = true;
            }
            if(this.mFirstLayout) {
                this.mCurItem = v;
                if(z2) {
                    this.c(v);
                }
                this.requestLayout();
                return;
            }
            this.populate(v);
            this.k(v, v1, z, z2);
            return;
        }
        this.setScrollingCacheEnabled(false);
    }

    public j setInternalPageChangeListener(j j0) {
        j j1 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = j0;
        return j1;
    }

    public void setOffscreenPageLimit(int v) {
        if(v < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + v + " too small; defaulting to 1");
            v = 1;
        }
        if(v != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = v;
            this.populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j j0) {
        this.mOnPageChangeListener = j0;
    }

    public void setPageMargin(int v) {
        int v1 = this.mPageMargin;
        this.mPageMargin = v;
        int v2 = this.getWidth();
        this.i(v2, v2, v, v1);
        this.requestLayout();
    }

    public void setPageMarginDrawable(int v) {
        this.setPageMarginDrawable(c.getDrawable(this.getContext(), v));
    }

    public void setPageMarginDrawable(Drawable drawable0) {
        this.mMarginDrawable = drawable0;
        if(drawable0 != null) {
            this.refreshDrawableState();
        }
        this.setWillNotDraw(drawable0 == null);
        this.invalidate();
    }

    public void setPageTransformer(boolean z, k k0) {
        this.setPageTransformer(z, k0, 2);
    }

    public void setPageTransformer(boolean z, k k0, int v) {
        int v1 = 1;
        boolean z1 = k0 != null != (this.mPageTransformer != null);
        this.mPageTransformer = k0;
        this.setChildrenDrawingOrderEnabled(k0 != null);
        if(k0 == null) {
            this.mDrawingOrder = 0;
        }
        else {
            if(z) {
                v1 = 2;
            }
            this.mDrawingOrder = v1;
            this.mPageTransformerLayerType = v;
        }
        if(z1) {
            this.populate();
        }
    }

    public void setScrollState(int v) {
        if(this.mScrollState != v) {
            this.mScrollState = v;
            if(this.mPageTransformer != null) {
                int v2 = this.getChildCount();
                for(int v3 = 0; v3 < v2; ++v3) {
                    int v4 = v == 0 ? this.mPageTransformerLayerType : 0;
                    this.getChildAt(v3).setLayerType(v4, null);
                }
            }
            j j0 = this.mOnPageChangeListener;
            if(j0 != null) {
                j0.onPageScrollStateChanged(v);
            }
            List list0 = this.mOnPageChangeListeners;
            if(list0 != null) {
                int v5 = list0.size();
                for(int v1 = 0; v1 < v5; ++v1) {
                    j j1 = (j)this.mOnPageChangeListeners.get(v1);
                    if(j1 != null) {
                        j1.onPageScrollStateChanged(v);
                    }
                }
            }
            j j2 = this.mInternalPageChangeListener;
            if(j2 != null) {
                j2.onPageScrollStateChanged(v);
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if(this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public void smoothScrollTo(int v, int v1) {
        this.smoothScrollTo(v, v1, 0);
    }

    public void smoothScrollTo(int v, int v1, int v2) {
        int v3;
        if(this.getChildCount() == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        if(this.mScroller == null || this.mScroller.isFinished()) {
            v3 = this.getScrollX();
        }
        else {
            v3 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            this.setScrollingCacheEnabled(false);
        }
        int v4 = this.getScrollY();
        int v5 = v - v3;
        int v6 = v1 - v4;
        if(v5 == 0 && v6 == 0) {
            this.a(false);
            this.populate();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(true);
        this.setScrollState(2);
        int v7 = this.getClientWidth();
        int v8 = Math.abs(v2);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(v3, v4, v5, v6, Math.min((v8 <= 0 ? ((int)((((float)Math.abs(v5)) / (1.0f * ((float)v7) + ((float)this.mPageMargin)) + 1.0f) * 100.0f)) : Math.round(Math.abs((this.distanceInfluenceForSnapDuration(Math.min(1.0f, ((float)Math.abs(v5)) * 1.0f / ((float)v7))) * ((float)(v7 / 2)) + ((float)(v7 / 2))) / ((float)v8)) * 1000.0f) * 4), 600));
        this.postInvalidateOnAnimation();
    }

    @Override  // android.view.View
    public boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.mMarginDrawable;
    }
}

