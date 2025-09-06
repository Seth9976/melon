package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;

public abstract class J0 {
    private w0 mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final H0 mRecyclingAction;
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition;
    private View mTargetView;

    public J0() {
        this.mTargetPosition = -1;
        H0 h00 = new H0();  // 初始化器: Ljava/lang/Object;-><init>()V
        h00.d = -1;
        h00.f = false;
        h00.g = 0;
        h00.a = 0;
        h00.b = 0;
        h00.c = 0x80000000;
        h00.e = null;
        this.mRecyclingAction = h00;
    }

    public PointF computeScrollVectorForPosition(int v) {
        w0 w00 = this.getLayoutManager();
        if(w00 instanceof I0) {
            return ((I0)w00).computeScrollVectorForPosition(v);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + I0.class.getCanonicalName());
        return null;
    }

    public View findViewByPosition(int v) {
        return this.mRecyclerView.n.findViewByPosition(v);
    }

    public int getChildCount() {
        return this.mRecyclerView.n.getChildCount();
    }

    public int getChildPosition(View view0) {
        return this.mRecyclerView.getChildLayoutPosition(view0);
    }

    public w0 getLayoutManager() {
        return this.mLayoutManager;
    }

    public int getTargetPosition() {
        return this.mTargetPosition;
    }

    @Deprecated
    public void instantScrollToPosition(int v) {
        this.mRecyclerView.scrollToPosition(v);
    }

    public boolean isPendingInitialRun() {
        return this.mPendingInitialRun;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public void normalize(PointF pointF0) {
        float f = (float)Math.sqrt(pointF0.y * pointF0.y + pointF0.x * pointF0.x);
        pointF0.x /= f;
        pointF0.y /= f;
    }

    public void onAnimation(int v, int v1) {
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(this.mTargetPosition == -1 || recyclerView0 == null) {
            this.stop();
        }
        if(this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null) {
            PointF pointF0 = this.computeScrollVectorForPosition(this.mTargetPosition);
            if(pointF0 != null) {
                float f = pointF0.x;
                if(f != 0.0f || pointF0.y != 0.0f) {
                    recyclerView0.a0(((int)Math.signum(f)), ((int)Math.signum(pointF0.y)), null);
                }
            }
        }
        boolean z = false;
        this.mPendingInitialRun = false;
        View view0 = this.mTargetView;
        if(view0 != null) {
            if(this.getChildPosition(view0) == this.mTargetPosition) {
                this.onTargetFound(this.mTargetView, recyclerView0.D0, this.mRecyclingAction);
                this.mRecyclingAction.a(recyclerView0);
                this.stop();
            }
            else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.mTargetView = null;
            }
        }
        if(this.mRunning) {
            this.onSeekTargetStep(v, v1, recyclerView0.D0, this.mRecyclingAction);
            H0 h00 = this.mRecyclingAction;
            if(h00.d >= 0) {
                z = true;
            }
            h00.a(recyclerView0);
            if(z && this.mRunning) {
                this.mPendingInitialRun = true;
                recyclerView0.A0.b();
            }
        }
    }

    public void onChildAttachedToWindow(View view0) {
        if(this.getChildPosition(view0) == this.getTargetPosition()) {
            this.mTargetView = view0;
            if(RecyclerView.Z0) {
                Log.d("RecyclerView", "smooth scroll target view has been attached");
            }
        }
    }

    public abstract void onSeekTargetStep(int arg1, int arg2, K0 arg3, H0 arg4);

    public abstract void onStart();

    public abstract void onStop();

    public abstract void onTargetFound(View arg1, K0 arg2, H0 arg3);

    public void setTargetPosition(int v) {
        this.mTargetPosition = v;
    }

    public void start(RecyclerView recyclerView0, w0 w00) {
        recyclerView0.A0.g.removeCallbacks(recyclerView0.A0);
        recyclerView0.A0.c.abortAnimation();
        if(this.mStarted) {
            Log.w("RecyclerView", "An instance of " + this.getClass().getSimpleName() + " was started more than once. Each instance of" + this.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        this.mRecyclerView = recyclerView0;
        this.mLayoutManager = w00;
        int v = this.mTargetPosition;
        if(v == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView0.D0.a = v;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = this.findViewByPosition(this.getTargetPosition());
        this.onStart();
        this.mRecyclerView.A0.b();
        this.mStarted = true;
    }

    public final void stop() {
        if(!this.mRunning) {
            return;
        }
        this.mRunning = false;
        this.onStop();
        this.mRecyclerView.D0.a = -1;
        this.mTargetView = null;
        this.mTargetPosition = -1;
        this.mPendingInitialRun = false;
        this.mLayoutManager.onSmoothScrollerStopped(this);
        this.mLayoutManager = null;
        this.mRecyclerView = null;
    }
}

