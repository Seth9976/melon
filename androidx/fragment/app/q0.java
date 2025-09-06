package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import androidx.lifecycle.s;
import androidx.viewpager.widget.a;

public abstract class q0 extends a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private y0 mCurTransaction;
    private I mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final l0 mFragmentManager;

    public q0(l0 l00) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = l00;
        this.mBehavior = 0;
    }

    @Override  // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup0, int v, Object object0) {
        if(this.mCurTransaction == null) {
            this.mCurTransaction = o.f(this.mFragmentManager, this.mFragmentManager);
        }
        this.mCurTransaction.d(((I)object0));
        if(((I)object0).equals(this.mCurrentPrimaryItem)) {
            this.mCurrentPrimaryItem = null;
        }
    }

    @Override  // androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup0) {
        y0 y00 = this.mCurTransaction;
        if(y00 != null) {
            if(!this.mExecutingFinishUpdate) {
                try {
                    this.mExecutingFinishUpdate = true;
                    if(((androidx.fragment.app.a)y00).g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    ((androidx.fragment.app.a)y00).h = false;
                    ((androidx.fragment.app.a)y00).r.A(((androidx.fragment.app.a)y00), true);
                    this.mExecutingFinishUpdate = false;
                }
                catch(Throwable throwable0) {
                    this.mExecutingFinishUpdate = false;
                    throw throwable0;
                }
            }
            this.mCurTransaction = null;
        }
    }

    public abstract I getItem(int arg1);

    public long getItemId(int v) [...] // Inlined contents

    @Override  // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup0, int v) {
        if(this.mCurTransaction == null) {
            this.mCurTransaction = o.f(this.mFragmentManager, this.mFragmentManager);
        }
        int v1 = viewGroup0.getId();
        I i0 = this.mFragmentManager.E("android:switcher:" + v1 + ":" + ((long)v));
        if(i0 == null) {
            i0 = this.getItem(v);
            this.mCurTransaction.e(viewGroup0.getId(), i0, "android:switcher:" + viewGroup0.getId() + ":" + ((long)v), 1);
        }
        else {
            y0 y00 = this.mCurTransaction;
            y00.getClass();
            y00.b(new x0(i0, 7));
        }
        if(i0 != this.mCurrentPrimaryItem) {
            i0.setMenuVisibility(false);
            if(this.mBehavior == 1) {
                this.mCurTransaction.h(i0, s.d);
                return i0;
            }
            i0.setUserVisibleHint(false);
        }
        return i0;
    }

    @Override  // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view0, Object object0) {
        return ((I)object0).getView() == view0;
    }

    @Override  // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable0, ClassLoader classLoader0) {
    }

    @Override  // androidx.viewpager.widget.a
    public Parcelable saveState() {
        return null;
    }

    @Override  // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup0, int v, Object object0) {
        I i0 = this.mCurrentPrimaryItem;
        if(((I)object0) != i0) {
            if(i0 != null) {
                i0.setMenuVisibility(false);
                if(this.mBehavior == 1) {
                    if(this.mCurTransaction == null) {
                        this.mCurTransaction = o.f(this.mFragmentManager, this.mFragmentManager);
                    }
                    this.mCurTransaction.h(this.mCurrentPrimaryItem, s.d);
                }
                else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            ((I)object0).setMenuVisibility(true);
            if(this.mBehavior == 1) {
                if(this.mCurTransaction == null) {
                    this.mCurTransaction = o.f(this.mFragmentManager, this.mFragmentManager);
                }
                this.mCurTransaction.h(((I)object0), s.e);
            }
            else {
                ((I)object0).setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = (I)object0;
        }
    }

    @Override  // androidx.viewpager.widget.a
    public void startUpdate(ViewGroup viewGroup0) {
        if(viewGroup0.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}

