package androidx.viewpager2.adapter;

import H0.b;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.g;
import androidx.collection.s;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.I;
import androidx.fragment.app.W;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class h extends j0 {
    private static final long GRACE_WINDOW_TIME_MS = 10000L;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    c mFragmentEventDispatcher;
    final l0 mFragmentManager;
    private f mFragmentMaxLifecycleEnforcer;
    final s mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final s mItemIdToViewHolder;
    final t mLifecycle;
    private final s mSavedStates;

    public h(I i0) {
        l0 l00 = i0.getChildFragmentManager();
        super();
        this.mFragments = new s(null);
        this.mSavedStates = new s(null);
        this.mItemIdToViewHolder = new s(null);
        c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c0.a = new CopyOnWriteArrayList();
        this.mFragmentEventDispatcher = c0;
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = l00;
        this.mLifecycle = i0.getLifecycle();
        super.setHasStableIds(true);
    }

    public final Long a(int v) {
        Long long0 = null;
        for(int v1 = 0; v1 < this.mItemIdToViewHolder.h(); ++v1) {
            if(((int)(((Integer)this.mItemIdToViewHolder.i(v1)))) == v) {
                if(long0 != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                long0 = this.mItemIdToViewHolder.e(v1);
                continue;
            }
        }
        return long0;
    }

    public void addViewToContainer(View view0, FrameLayout frameLayout0) {
        if(frameLayout0.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if(view0.getParent() == frameLayout0) {
            return;
        }
        if(frameLayout0.getChildCount() > 0) {
            frameLayout0.removeAllViews();
        }
        if(view0.getParent() != null) {
            ((ViewGroup)view0.getParent()).removeView(view0);
        }
        frameLayout0.addView(view0);
    }

    public final void b(long v) {
        I i0 = (I)this.mFragments.b(v);
        if(i0 == null) {
            return;
        }
        if(i0.getView() != null) {
            ViewParent viewParent0 = i0.getView().getParent();
            if(viewParent0 != null) {
                ((FrameLayout)viewParent0).removeAllViews();
            }
        }
        if(!this.containsItem(v)) {
            this.mSavedStates.g(v);
        }
        if(!i0.isAdded()) {
            this.mFragments.g(v);
            return;
        }
        if(this.shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if(i0.isAdded() && this.containsItem(v)) {
            c c0 = this.mFragmentEventDispatcher;
            c0.getClass();
            ArrayList arrayList0 = new ArrayList();
            Iterator iterator0 = c0.a.iterator();
            if(iterator0.hasNext()) {
                throw b.b(iterator0);
            }
            Fragment.SavedState fragment$SavedState0 = this.mFragmentManager.f0(i0);
            this.mFragmentEventDispatcher.getClass();
            c.a(arrayList0);
            this.mSavedStates.f(v, fragment$SavedState0);
        }
        c c1 = this.mFragmentEventDispatcher;
        c1.getClass();
        ArrayList arrayList1 = new ArrayList();
        Iterator iterator1 = c1.a.iterator();
        if(iterator1.hasNext()) {
            throw b.b(iterator1);
        }
        try {
            this.mFragmentManager.getClass();
            a a0 = new a(this.mFragmentManager);
            a0.f(i0);
            a0.m();
            this.mFragments.g(v);
        }
        finally {
            this.mFragmentEventDispatcher.getClass();
            c.a(arrayList1);
        }
    }

    public boolean containsItem(long v) {
        return v >= 0L && v < ((long)this.getItemCount());
    }

    public abstract I createFragment(int arg1);

    public void gcFragments() {
        if(this.mHasStaleFragments && !this.shouldDelayFragmentTransactions()) {
            g g0 = new g(0);
            for(int v1 = 0; v1 < this.mFragments.h(); ++v1) {
                long v2 = this.mFragments.e(v1);
                if(!this.containsItem(v2)) {
                    g0.add(v2);
                    this.mItemIdToViewHolder.g(v2);
                }
            }
            if(!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for(int v = 0; v < this.mFragments.h(); ++v) {
                    long v3 = this.mFragments.e(v);
                    if(this.mItemIdToViewHolder.c(v3) < 0) {
                        I i0 = (I)this.mFragments.b(v3);
                        if(i0 == null) {
                            g0.add(v3);
                        }
                        else {
                            View view0 = i0.getView();
                            if(view0 == null || view0.getParent() == null) {
                                g0.add(v3);
                            }
                        }
                    }
                }
            }
            androidx.collection.b b0 = new androidx.collection.b(g0);
            while(b0.hasNext()) {
                this.b(((long)(((Long)b0.next()))));
            }
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public long getItemId(int v) [...] // Inlined contents

    @Override  // androidx.recyclerview.widget.j0
    public void onAttachedToRecyclerView(RecyclerView recyclerView0) {
        if(this.mFragmentMaxLifecycleEnforcer != null) {
            throw new IllegalArgumentException();
        }
        f f0 = new f(this);
        this.mFragmentMaxLifecycleEnforcer = f0;
        ViewPager2 viewPager20 = f.a(recyclerView0);
        f0.d = viewPager20;
        Mc.b b0 = new Mc.b(f0, 1);
        f0.a = b0;
        ((ArrayList)viewPager20.c.b).add(b0);
        d d0 = new d(f0, 0);
        f0.b = d0;
        this.registerAdapterDataObserver(d0);
        e e0 = new e(f0);
        f0.c = e0;
        this.mLifecycle.a(e0);
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v) {
        this.onBindViewHolder(((i)o00), v);
    }

    public final void onBindViewHolder(i i0, int v) {
        long v1 = i0.getItemId();
        int v2 = ((FrameLayout)i0.itemView).getId();
        Long long0 = this.a(v2);
        if(long0 != null && ((long)long0) != v1) {
            this.b(((long)long0));
            this.mItemIdToViewHolder.g(((long)long0));
        }
        this.mItemIdToViewHolder.f(v1, v2);
        if(this.mFragments.c(((long)v)) < 0) {
            I i1 = this.createFragment(v);
            i1.setInitialSavedState(((Fragment.SavedState)this.mSavedStates.b(((long)v))));
            this.mFragments.f(((long)v), i1);
        }
        if(((FrameLayout)i0.itemView).isAttachedToWindow()) {
            this.placeFragmentInViewHolder(i0);
        }
        this.gcFragments();
    }

    @Override  // androidx.recyclerview.widget.j0
    public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        return this.onCreateViewHolder(viewGroup0, v);
    }

    public final i onCreateViewHolder(ViewGroup viewGroup0, int v) {
        FrameLayout frameLayout0 = new FrameLayout(viewGroup0.getContext());
        frameLayout0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout0.setId(View.generateViewId());
        frameLayout0.setSaveEnabled(false);
        return new i(frameLayout0);  // 初始化器: Landroidx/recyclerview/widget/O0;-><init>(Landroid/view/View;)V
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onDetachedFromRecyclerView(RecyclerView recyclerView0) {
        f f0 = this.mFragmentMaxLifecycleEnforcer;
        f0.getClass();
        ((ArrayList)f.a(recyclerView0).c.b).remove(f0.a);
        f0.f.unregisterAdapterDataObserver(f0.b);
        f0.f.mLifecycle.c(f0.c);
        f0.d = null;
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override  // androidx.recyclerview.widget.j0
    public boolean onFailedToRecycleView(O0 o00) {
        return this.onFailedToRecycleView(((i)o00));
    }

    public final boolean onFailedToRecycleView(i i0) {
        return true;
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onViewAttachedToWindow(O0 o00) {
        this.onViewAttachedToWindow(((i)o00));
    }

    public final void onViewAttachedToWindow(i i0) {
        this.placeFragmentInViewHolder(i0);
        this.gcFragments();
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onViewRecycled(O0 o00) {
        this.onViewRecycled(((i)o00));
    }

    public final void onViewRecycled(i i0) {
        Long long0 = this.a(((FrameLayout)i0.itemView).getId());
        if(long0 != null) {
            this.b(((long)long0));
            this.mItemIdToViewHolder.g(((long)long0));
        }
    }

    public void placeFragmentInViewHolder(i i0) {
        I i1 = (I)this.mFragments.b(i0.getItemId());
        if(i1 == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayout0 = (FrameLayout)i0.itemView;
        View view0 = i1.getView();
        if(!i1.isAdded() && view0 != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if(i1.isAdded() && view0 == null) {
            androidx.viewpager2.adapter.a a0 = new androidx.viewpager2.adapter.a(this, i1, frameLayout0);
            this.mFragmentManager.p.getClass();
            W w0 = new W(a0);
            ((CopyOnWriteArrayList)this.mFragmentManager.p.b).add(w0);
            return;
        }
        if(i1.isAdded() && view0.getParent() != null) {
            if(view0.getParent() == frameLayout0) {
                return;
            }
            this.addViewToContainer(view0, frameLayout0);
            return;
        }
        if(i1.isAdded()) {
            this.addViewToContainer(view0, frameLayout0);
            return;
        }
        if(!this.shouldDelayFragmentTransactions()) {
            androidx.viewpager2.adapter.a a1 = new androidx.viewpager2.adapter.a(this, i1, frameLayout0);
            this.mFragmentManager.p.getClass();
            W w1 = new W(a1);
            ((CopyOnWriteArrayList)this.mFragmentManager.p.b).add(w1);
            c c0 = this.mFragmentEventDispatcher;
            c0.getClass();
            ArrayList arrayList0 = new ArrayList();
            Iterator iterator0 = c0.a.iterator();
            if(iterator0.hasNext()) {
                throw b.b(iterator0);
            }
            try {
                i1.setMenuVisibility(false);
                this.mFragmentManager.getClass();
                a a2 = new a(this.mFragmentManager);
                a2.e(0, i1, "f" + i0.getItemId(), 1);
                a2.h(i1, androidx.lifecycle.s.d);
                a2.m();
                this.mFragmentMaxLifecycleEnforcer.b(false);
            }
            finally {
                this.mFragmentEventDispatcher.getClass();
                c.a(arrayList0);
            }
            return;
        }
        if(this.mFragmentManager.K) {
            return;
        }
        androidx.lifecycle.h h0 = new androidx.lifecycle.h(this, i0);
        this.mLifecycle.a(h0);
    }

    public void registerFragmentTransactionCallback(androidx.viewpager2.adapter.g g0) {
        this.mFragmentEventDispatcher.a.add(g0);
    }

    public final void restoreState(Parcelable parcelable0) {
        if(!this.mSavedStates.d() || !this.mFragments.d()) {
            throw new IllegalStateException("Expected the adapter to be \'fresh\' while restoring state.");
        }
        if(((Bundle)parcelable0).getClassLoader() == null) {
            ((Bundle)parcelable0).setClassLoader(this.getClass().getClassLoader());
        }
        for(Object object0: ((Bundle)parcelable0).keySet()) {
            String s = (String)object0;
            if(s.startsWith("f#") && s.length() > 2) {
                long v = Long.parseLong(s.substring(2));
                I i0 = this.mFragmentManager.K(((Bundle)parcelable0), s);
                this.mFragments.f(v, i0);
            }
            else {
                if(!s.startsWith("s#") || s.length() <= 2) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + s);
                }
                long v1 = Long.parseLong(s.substring(2));
                Fragment.SavedState fragment$SavedState0 = (Fragment.SavedState)((Bundle)parcelable0).getParcelable(s);
                if(this.containsItem(v1)) {
                    this.mSavedStates.f(v1, fragment$SavedState0);
                }
            }
        }
        if(!this.mFragments.d()) {
            this.mHasStaleFragments = true;
            this.mIsInGracePeriod = true;
            this.gcFragments();
            Handler handler0 = new Handler(Looper.getMainLooper());
            androidx.viewpager2.adapter.b b0 = new androidx.viewpager2.adapter.b(this);
            androidx.lifecycle.h h0 = new androidx.lifecycle.h(4, handler0, b0);
            this.mLifecycle.a(h0);
            handler0.postDelayed(b0, 10000L);
        }
    }

    public final Parcelable saveState() {
        int v = this.mFragments.h();
        Parcelable parcelable0 = new Bundle(this.mSavedStates.h() + v);
        for(int v2 = 0; v2 < this.mFragments.h(); ++v2) {
            long v3 = this.mFragments.e(v2);
            I i0 = (I)this.mFragments.b(v3);
            if(i0 != null && i0.isAdded()) {
                this.mFragmentManager.a0(((Bundle)parcelable0), va.e.a(v3, "f#"), i0);
            }
        }
        for(int v1 = 0; v1 < this.mSavedStates.h(); ++v1) {
            long v4 = this.mSavedStates.e(v1);
            if(this.containsItem(v4)) {
                ((Bundle)parcelable0).putParcelable(va.e.a(v4, "s#"), ((Parcelable)this.mSavedStates.b(v4)));
            }
        }
        return parcelable0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.T();
    }

    public void unregisterFragmentTransactionCallback(androidx.viewpager2.adapter.g g0) {
        this.mFragmentEventDispatcher.a.remove(g0);
    }
}

