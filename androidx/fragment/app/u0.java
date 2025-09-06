package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import androidx.lifecycle.s;
import androidx.viewpager.widget.a;
import java.util.ArrayList;

public abstract class u0 extends a {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private final int mBehavior;
    private y0 mCurTransaction;
    private I mCurrentPrimaryItem;
    private boolean mExecutingFinishUpdate;
    private final l0 mFragmentManager;
    private ArrayList mFragments;
    private ArrayList mSavedState;

    public u0(l0 l00) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = l00;
        this.mBehavior = 1;
    }

    @Override  // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup0, int v, Object object0) {
        if(this.mCurTransaction == null) {
            this.mCurTransaction = o.f(this.mFragmentManager, this.mFragmentManager);
        }
        while(this.mSavedState.size() <= v) {
            this.mSavedState.add(null);
        }
        this.mSavedState.set(v, (((I)object0).isAdded() ? this.mFragmentManager.f0(((I)object0)) : null));
        this.mFragments.set(v, null);
        this.mCurTransaction.f(((I)object0));
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

    @Override  // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup0, int v) {
        if(this.mFragments.size() > v) {
            I i0 = (I)this.mFragments.get(v);
            if(i0 != null) {
                return i0;
            }
        }
        if(this.mCurTransaction == null) {
            this.mCurTransaction = o.f(this.mFragmentManager, this.mFragmentManager);
        }
        I i1 = this.getItem(v);
        if(this.mSavedState.size() > v) {
            Fragment.SavedState fragment$SavedState0 = (Fragment.SavedState)this.mSavedState.get(v);
            if(fragment$SavedState0 != null) {
                i1.setInitialSavedState(fragment$SavedState0);
            }
        }
        while(this.mFragments.size() <= v) {
            this.mFragments.add(null);
        }
        i1.setMenuVisibility(false);
        if(this.mBehavior == 0) {
            i1.setUserVisibleHint(false);
        }
        this.mFragments.set(v, i1);
        this.mCurTransaction.e(viewGroup0.getId(), i1, null, 1);
        if(this.mBehavior == 1) {
            this.mCurTransaction.h(i1, s.d);
        }
        return i1;
    }

    @Override  // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view0, Object object0) {
        return ((I)object0).getView() == view0;
    }

    @Override  // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable0, ClassLoader classLoader0) {
        if(parcelable0 != null) {
            ((Bundle)parcelable0).setClassLoader(classLoader0);
            Parcelable[] arr_parcelable = ((Bundle)parcelable0).getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if(arr_parcelable != null) {
                for(int v = 0; v < arr_parcelable.length; ++v) {
                    this.mSavedState.add(((Fragment.SavedState)arr_parcelable[v]));
                }
            }
            for(Object object0: ((Bundle)parcelable0).keySet()) {
                String s = (String)object0;
                if(s.startsWith("f")) {
                    int v1 = Integer.parseInt(s.substring(1));
                    I i0 = this.mFragmentManager.K(((Bundle)parcelable0), s);
                    if(i0 == null) {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + s);
                    }
                    else {
                        while(this.mFragments.size() <= v1) {
                            this.mFragments.add(null);
                        }
                        i0.setMenuVisibility(false);
                        this.mFragments.set(v1, i0);
                    }
                }
            }
        }
    }

    @Override  // androidx.viewpager.widget.a
    public Parcelable saveState() {
        Parcelable parcelable0;
        if(this.mSavedState.size() > 0) {
            parcelable0 = new Bundle();
            Fragment.SavedState[] arr_fragment$SavedState = new Fragment.SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(arr_fragment$SavedState);
            ((Bundle)parcelable0).putParcelableArray("states", arr_fragment$SavedState);
        }
        else {
            parcelable0 = null;
        }
        for(int v = 0; v < this.mFragments.size(); ++v) {
            I i0 = (I)this.mFragments.get(v);
            if(i0 != null && i0.isAdded()) {
                if(parcelable0 == null) {
                    parcelable0 = new Bundle();
                }
                this.mFragmentManager.a0(((Bundle)parcelable0), "f" + v, i0);
            }
        }
        return parcelable0;
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

