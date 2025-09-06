package androidx.fragment.app;

import A2.a;
import A2.d;
import U4.x;
import android.content.res.Resources.NotFoundException;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import c2.K;
import e0.b;
import java.util.ArrayList;
import k8.Y;

public final class t0 {
    public final N a;
    public final v0 b;
    public final I c;
    public boolean d;
    public int e;

    public t0(N n0, v0 v00, I i0) {
        this.d = false;
        this.e = -1;
        this.a = n0;
        this.b = v00;
        this.c = i0;
    }

    public t0(N n0, v0 v00, I i0, Bundle bundle0) {
        this.d = false;
        this.e = -1;
        this.a = n0;
        this.b = v00;
        this.c = i0;
        i0.mSavedViewState = null;
        i0.mSavedViewRegistryState = null;
        i0.mBackStackNesting = 0;
        i0.mInLayout = false;
        i0.mAdded = false;
        i0.mTargetWho = i0.mTarget == null ? null : i0.mTarget.mWho;
        i0.mTarget = null;
        i0.mSavedFragmentState = bundle0;
        i0.mArguments = bundle0.getBundle("arguments");
    }

    public t0(N n0, v0 v00, ClassLoader classLoader0, b0 b00, Bundle bundle0) {
        this.d = false;
        this.e = -1;
        this.a = n0;
        this.b = v00;
        FragmentState fragmentState0 = (FragmentState)bundle0.getParcelable("state");
        I i0 = I.instantiate(b00.a.x.b, fragmentState0.a, null);
        i0.mWho = fragmentState0.b;
        i0.mFromLayout = fragmentState0.c;
        i0.mInDynamicContainer = fragmentState0.d;
        i0.mRestored = true;
        i0.mFragmentId = fragmentState0.e;
        i0.mContainerId = fragmentState0.f;
        i0.mTag = fragmentState0.g;
        i0.mRetainInstance = fragmentState0.h;
        i0.mRemoving = fragmentState0.i;
        i0.mDetached = fragmentState0.j;
        i0.mHidden = fragmentState0.k;
        s[] arr_s = s.values();
        i0.mMaxState = arr_s[fragmentState0.l];
        i0.mTargetWho = fragmentState0.m;
        i0.mTargetRequestCode = fragmentState0.n;
        i0.mUserVisibleHint = fragmentState0.o;
        this.c = i0;
        i0.mSavedFragmentState = bundle0;
        Bundle bundle1 = bundle0.getBundle("arguments");
        if(bundle1 != null) {
            bundle1.setClassLoader(classLoader0);
        }
        i0.setArguments(bundle1);
        if(l0.P(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + i0);
        }
    }

    public final void a() {
        boolean z = l0.P(3);
        I i0 = this.c;
        if(z) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + i0);
        }
        i0.performActivityCreated((i0.mSavedFragmentState == null ? null : i0.mSavedFragmentState.getBundle("savedInstanceState")));
        this.a.a(i0, false);
    }

    public final void b() {
        I i0 = this.c;
        I i1 = l0.F(i0.mContainer);
        if(i1 != null && !i1.equals(i0.getParentFragment())) {
            int v = i0.mContainerId;
            StringBuilder stringBuilder0 = new StringBuilder("Attempting to nest fragment ");
            stringBuilder0.append(i0);
            stringBuilder0.append(" within the view of parent fragment ");
            stringBuilder0.append(i1);
            stringBuilder0.append(" via container with ID ");
            d.b(new a(i0, x.g(v, " without using parent\'s childFragmentManager", stringBuilder0)));  // 初始化器: LA2/h;-><init>(Landroidx/fragment/app/I;Ljava/lang/String;)V
            d.a(i0).getClass();
        }
        ArrayList arrayList0 = this.b.a;
        ViewGroup viewGroup0 = i0.mContainer;
        int v1 = -1;
        if(viewGroup0 != null) {
            int v2 = arrayList0.indexOf(i0);
            int v3 = v2 - 1;
        alab1:
            while(true) {
                if(v3 >= 0) {
                    I i2 = (I)arrayList0.get(v3);
                    if(i2.mContainer == viewGroup0) {
                        View view0 = i2.mView;
                        if(view0 != null) {
                            v1 = viewGroup0.indexOfChild(view0) + 1;
                            break;
                        }
                    }
                    --v3;
                }
                else {
                    while(true) {
                        while(true) {
                            ++v2;
                            if(v2 >= arrayList0.size()) {
                                break alab1;
                            }
                            I i3 = (I)arrayList0.get(v2);
                            if(i3.mContainer != viewGroup0) {
                                break;
                            }
                            View view1 = i3.mView;
                            if(view1 == null) {
                                break;
                            }
                            v1 = viewGroup0.indexOfChild(view1);
                            break alab1;
                        }
                    }
                }
            }
        }
        i0.mContainer.addView(i0.mView, v1);
    }

    public final void c() {
        boolean z = l0.P(3);
        I i0 = this.c;
        if(z) {
            Log.d("FragmentManager", "moveto ATTACHED: " + i0);
        }
        I i1 = i0.mTarget;
        t0 t00 = null;
        v0 v00 = this.b;
        if(i1 == null) {
            String s = i0.mTargetWho;
            if(s != null) {
                t00 = (t0)v00.b.get(s);
                if(t00 == null) {
                    StringBuilder stringBuilder0 = new StringBuilder("Fragment ");
                    stringBuilder0.append(i0);
                    stringBuilder0.append(" declared target fragment ");
                    throw new IllegalStateException(x.m(stringBuilder0, i0.mTargetWho, " that does not belong to this FragmentManager!"));
                }
            }
        }
        else {
            t0 t01 = (t0)v00.b.get(i1.mWho);
            if(t01 == null) {
                throw new IllegalStateException("Fragment " + i0 + " declared target fragment " + i0.mTarget + " that does not belong to this FragmentManager!");
            }
            i0.mTargetWho = i0.mTarget.mWho;
            i0.mTarget = null;
            t00 = t01;
        }
        if(t00 != null) {
            t00.k();
        }
        i0.mHost = i0.mFragmentManager.x;
        i0.mParentFragment = i0.mFragmentManager.z;
        this.a.g(i0, false);
        i0.performAttach();
        this.a.b(i0, false);
    }

    public final int d() {
        I i0 = this.c;
        if(i0.mFragmentManager == null) {
            return i0.mState;
        }
        int v = this.e;
        int v1 = 0;
        switch(i0.mMaxState.ordinal()) {
            case 1: {
                v = Math.min(v, 0);
                break;
            }
            case 2: {
                v = Math.min(v, 1);
                break;
            }
            case 3: {
                v = Math.min(v, 5);
                break;
            }
            case 4: {
                break;
            }
            default: {
                v = Math.min(v, -1);
            }
        }
        if(i0.mFromLayout) {
            if(i0.mInLayout) {
                v = Math.max(this.e, 2);
                if(i0.mView != null && i0.mView.getParent() == null) {
                    v = Math.min(v, 2);
                }
            }
            else {
                v = this.e >= 4 ? Math.min(v, 1) : Math.min(v, i0.mState);
            }
        }
        if(i0.mInDynamicContainer && i0.mContainer == null) {
            v = Math.min(v, 4);
        }
        if(!i0.mAdded) {
            v = Math.min(v, 1);
        }
        ViewGroup viewGroup0 = i0.mContainer;
        if(viewGroup0 != null) {
            q q0 = q.j(viewGroup0, i0.getParentFragmentManager());
            q0.getClass();
            L0 l00 = q0.g(i0);
            int v2 = l00 == null ? 0 : l00.b;
            L0 l01 = q0.h(i0);
            if(l01 != null) {
                v1 = l01.b;
            }
            int v3 = v2 == 0 ? -1 : M0.a[b.b(v2)];
            if(v3 != -1 && v3 != 1) {
                v1 = v2;
            }
        }
        if(v1 == 2) {
            v = Math.min(v, 6);
        }
        else if(v1 == 3) {
            v = Math.max(v, 3);
        }
        else if(i0.mRemoving) {
            v = i0.isInBackStack() ? Math.min(v, 1) : Math.min(v, -1);
        }
        if(i0.mDeferStart && i0.mState < 5) {
            v = Math.min(v, 4);
        }
        if(i0.mTransitioning) {
            v = Math.max(v, 3);
        }
        if(l0.P(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + v + " for " + i0);
        }
        return v;
    }

    public final void e() {
        boolean z = l0.P(3);
        I i0 = this.c;
        if(z) {
            Log.d("FragmentManager", "moveto CREATED: " + i0);
        }
        Bundle bundle0 = i0.mSavedFragmentState == null ? null : i0.mSavedFragmentState.getBundle("savedInstanceState");
        if(!i0.mIsCreated) {
            this.a.h(i0, false);
            i0.performCreate(bundle0);
            this.a.c(i0, false);
            return;
        }
        i0.mState = 1;
        i0.restoreChildFragmentState();
    }

    public final void f() {
        String s;
        I i0 = this.c;
        if(i0.mFromLayout) {
            return;
        }
        if(l0.P(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + i0);
        }
        ViewGroup viewGroup0 = null;
        Bundle bundle0 = i0.mSavedFragmentState == null ? null : i0.mSavedFragmentState.getBundle("savedInstanceState");
        LayoutInflater layoutInflater0 = i0.performGetLayoutInflater(bundle0);
        ViewGroup viewGroup1 = i0.mContainer;
        if(viewGroup1 == null) {
            int v = i0.mContainerId;
            switch(v) {
                case -1: {
                    throw new IllegalArgumentException("Cannot create fragment " + i0 + " for a container view with no id");
                label_16:
                    viewGroup0 = (ViewGroup)i0.mFragmentManager.y.b(v);
                    if(viewGroup0 == null) {
                        if(!i0.mRestored && !i0.mInDynamicContainer) {
                            try {
                                s = "unknown";
                                s = i0.getResources().getResourceName(i0.mContainerId);
                            }
                            catch(Resources.NotFoundException unused_ex) {
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(i0.mContainerId) + " (" + s + ") for fragment " + i0);
                        }
                    }
                    else if(!(viewGroup0 instanceof FragmentContainerView)) {
                        d.b(new a(i0, "Attempting to add fragment " + i0 + " to container " + viewGroup0 + " which is not a FragmentContainerView"));  // 初始化器: LA2/h;-><init>(Landroidx/fragment/app/I;Ljava/lang/String;)V
                        d.a(i0).getClass();
                    }
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    goto label_16;
                }
            }
        }
        else {
            viewGroup0 = viewGroup1;
        }
        i0.mContainer = viewGroup0;
        i0.performCreateView(layoutInflater0, viewGroup0, bundle0);
        if(i0.mView != null) {
            if(l0.P(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + i0);
            }
            i0.mView.setSaveFromParentEnabled(false);
            i0.mView.setTag(0x7F0A04DE, i0);  // id:fragment_container_view_tag
            if(viewGroup0 != null) {
                this.b();
            }
            if(i0.mHidden) {
                i0.mView.setVisibility(8);
            }
            if(i0.mView.isAttachedToWindow()) {
                K.c(i0.mView);
            }
            else {
                i0.mView.addOnAttachStateChangeListener(new s0(i0.mView));
            }
            i0.performViewCreated();
            this.a.m(i0, i0.mView, bundle0, false);
            int v1 = i0.mView.getVisibility();
            i0.setPostOnViewCreatedAlpha(i0.mView.getAlpha());
            if(i0.mContainer != null && v1 == 0) {
                View view0 = i0.mView.findFocus();
                if(view0 != null) {
                    i0.setFocusedView(view0);
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + view0 + " for Fragment " + i0);
                    }
                }
                i0.mView.setAlpha(0.0f);
            }
        }
        i0.mState = 2;
    }

    public final void g() {
        boolean z = l0.P(3);
        I i0 = this.c;
        if(z) {
            Log.d("FragmentManager", "movefrom CREATED: " + i0);
        }
        boolean z1 = true;
        boolean z2 = i0.mRemoving && !i0.isInBackStack();
        v0 v00 = this.b;
        if(z2 && !i0.mBeingSaved) {
            v00.i(null, i0.mWho);
        }
        if(!z2) {
            o0 o00 = v00.d;
            if(!(!o00.a.containsKey(i0.mWho) || !o00.d ? true : o00.e)) {
                String s = i0.mTargetWho;
                if(s != null) {
                    I i1 = v00.b(s);
                    if(i1 != null && i1.mRetainInstance) {
                        i0.mTarget = i1;
                    }
                }
                i0.mState = 0;
                return;
            }
        }
        S s1 = i0.mHost;
        if(s1 instanceof r0) {
            z1 = v00.d.e;
        }
        else {
            FragmentActivity fragmentActivity0 = s1.b;
            if(fragmentActivity0 != null) {
                z1 = true ^ fragmentActivity0.isChangingConfigurations();
            }
        }
        if(z2 && !i0.mBeingSaved || z1) {
            v00.d.c(i0, false);
        }
        i0.performDestroy();
        this.a.d(i0, false);
        for(Object object0: v00.d()) {
            t0 t00 = (t0)object0;
            if(t00 != null) {
                I i2 = t00.c;
                if(i0.mWho.equals(i2.mTargetWho)) {
                    i2.mTarget = i0;
                    i2.mTargetWho = null;
                }
            }
        }
        String s2 = i0.mTargetWho;
        if(s2 != null) {
            i0.mTarget = v00.b(s2);
        }
        v00.h(this);
    }

    public final void h() {
        boolean z = l0.P(3);
        I i0 = this.c;
        if(z) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + i0);
        }
        ViewGroup viewGroup0 = i0.mContainer;
        if(viewGroup0 != null) {
            View view0 = i0.mView;
            if(view0 != null) {
                viewGroup0.removeView(view0);
            }
        }
        i0.performDestroyView();
        this.a.n(i0, false);
        i0.mContainer = null;
        i0.mView = null;
        i0.mViewLifecycleOwner = null;
        i0.mViewLifecycleOwnerLiveData.setValue(null);
        i0.mInLayout = false;
    }

    public final void i() {
        boolean z = l0.P(3);
        I i0 = this.c;
        if(z) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + i0);
        }
        i0.performDetach();
        this.a.e(i0, false);
        i0.mState = -1;
        i0.mHost = null;
        i0.mParentFragment = null;
        i0.mFragmentManager = null;
        if(i0.mRemoving && !i0.isInBackStack()) {
        label_13:
            if(l0.P(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + i0);
            }
            i0.initState();
        }
        else {
            o0 o00 = this.b.d;
            if((!o00.a.containsKey(i0.mWho) || !o00.d ? true : o00.e)) {
                goto label_13;
            }
        }
    }

    public final void j() {
        I i0 = this.c;
        if(i0.mFromLayout && i0.mInLayout && !i0.mPerformedCreateView) {
            if(l0.P(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + i0);
            }
            Bundle bundle0 = i0.mSavedFragmentState == null ? null : i0.mSavedFragmentState.getBundle("savedInstanceState");
            i0.performCreateView(i0.performGetLayoutInflater(bundle0), null, bundle0);
            View view0 = i0.mView;
            if(view0 != null) {
                view0.setSaveFromParentEnabled(false);
                i0.mView.setTag(0x7F0A04DE, i0);  // id:fragment_container_view_tag
                if(i0.mHidden) {
                    i0.mView.setVisibility(8);
                }
                i0.performViewCreated();
                this.a.m(i0, i0.mView, bundle0, false);
                i0.mState = 2;
            }
        }
    }

    public final void k() {
        v0 v00;
        I i0 = this.c;
        if(this.d) {
            if(l0.P(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + i0);
            }
            return;
        }
        try {
            this.d = true;
            boolean z;
            for(z = false; true; z = true) {
                int v1 = this.d();
                int v2 = i0.mState;
                v00 = this.b;
                int v3 = 3;
                if(v1 == v2) {
                    break;
                }
                N n0 = this.a;
                if(v1 > v2) {
                    switch(v2 + 1) {
                        case 0: {
                            this.c();
                            break;
                        }
                        case 1: {
                            this.e();
                            break;
                        }
                        case 2: {
                            this.j();
                            this.f();
                            break;
                        }
                        case 3: {
                            this.a();
                            break;
                        }
                        case 4: {
                            if(i0.mView != null) {
                                ViewGroup viewGroup0 = i0.mContainer;
                                if(viewGroup0 != null) {
                                    q q0 = q.j(viewGroup0, i0.getParentFragmentManager());
                                    int v4 = i0.mView.getVisibility();
                                    switch(v4) {
                                        case 0: {
                                            v3 = 2;
                                            break;
                                        }
                                        case 4: {
                                            v3 = 4;
                                            break;
                                        }
                                        default: {
                                            if(v4 != 8) {
                                                throw new IllegalArgumentException("Unknown visibility " + v4);
                                            }
                                        }
                                    }
                                    q0.getClass();
                                    Y.r(v3, "finalState");
                                    if(l0.P(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + i0);
                                    }
                                    q0.d(v3, 2, this);
                                }
                            }
                            i0.mState = 4;
                            break;
                        }
                        case 5: {
                            if(l0.P(3)) {
                                Log.d("FragmentManager", "moveto STARTED: " + i0);
                            }
                            i0.performStart();
                            n0.k(i0, false);
                            break;
                        }
                        case 6: {
                            i0.mState = 6;
                            break;
                        }
                        case 7: {
                            this.m();
                        }
                    }
                }
                else {
                    switch(v2 - 1) {
                        case -1: {
                            this.i();
                            break;
                        }
                        case 0: {
                            if(i0.mBeingSaved && ((Bundle)v00.c.get(i0.mWho)) == null) {
                                String s = i0.mWho;
                                v00.i(this.n(), s);
                            }
                            this.g();
                            break;
                        }
                        case 1: {
                            this.h();
                            i0.mState = 1;
                            break;
                        }
                        case 2: {
                            i0.mInLayout = false;
                            i0.mState = 2;
                            break;
                        }
                        case 3: {
                            if(l0.P(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + i0);
                            }
                            if(i0.mBeingSaved) {
                                String s1 = i0.mWho;
                                v00.i(this.n(), s1);
                            }
                            else if(i0.mView != null && i0.mSavedViewState == null) {
                                this.o();
                            }
                            if(i0.mView != null) {
                                ViewGroup viewGroup1 = i0.mContainer;
                                if(viewGroup1 != null) {
                                    q q1 = q.j(viewGroup1, i0.getParentFragmentManager());
                                    q1.getClass();
                                    if(l0.P(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + i0);
                                    }
                                    q1.d(1, 3, this);
                                }
                            }
                            i0.mState = 3;
                            break;
                        }
                        case 4: {
                            if(l0.P(3)) {
                                Log.d("FragmentManager", "movefrom STARTED: " + i0);
                            }
                            i0.performStop();
                            n0.l(i0, false);
                            break;
                        }
                        case 5: {
                            i0.mState = 5;
                            break;
                        }
                        case 6: {
                            if(l0.P(3)) {
                                Log.d("FragmentManager", "movefrom RESUMED: " + i0);
                            }
                            i0.performPause();
                            n0.f(i0, false);
                        }
                    }
                }
            }
            if(!z && v2 == -1 && i0.mRemoving && !i0.isInBackStack() && !i0.mBeingSaved) {
                if(l0.P(3)) {
                    Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + i0);
                }
                v00.d.c(i0, true);
                v00.h(this);
                if(l0.P(3)) {
                    Log.d("FragmentManager", "initState called for fragment: " + i0);
                }
                i0.initState();
            }
            if(i0.mHiddenChanged) {
                if(i0.mView != null) {
                    ViewGroup viewGroup2 = i0.mContainer;
                    if(viewGroup2 != null) {
                        q q2 = q.j(viewGroup2, i0.getParentFragmentManager());
                        if(i0.mHidden) {
                            q2.getClass();
                            if(l0.P(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + i0);
                            }
                            q2.d(3, 1, this);
                        }
                        else {
                            q2.getClass();
                            if(l0.P(2)) {
                                Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + i0);
                            }
                            q2.d(2, 1, this);
                        }
                    }
                }
                l0 l00 = i0.mFragmentManager;
                if(l00 != null && i0.mAdded && l0.Q(i0)) {
                    l00.H = true;
                }
                i0.mHiddenChanged = false;
                i0.mChildFragmentManager.o();
            }
        }
        finally {
            this.d = false;
        }
    }

    public final void l(ClassLoader classLoader0) {
        I i0 = this.c;
        Bundle bundle0 = i0.mSavedFragmentState;
        if(bundle0 != null) {
            bundle0.setClassLoader(classLoader0);
            if(i0.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                i0.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
            }
            try {
                i0.mSavedViewState = i0.mSavedFragmentState.getSparseParcelableArray("viewState");
            }
            catch(BadParcelableException badParcelableException0) {
                throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + i0, badParcelableException0);
            }
            i0.mSavedViewRegistryState = i0.mSavedFragmentState.getBundle("viewRegistryState");
            FragmentState fragmentState0 = (FragmentState)i0.mSavedFragmentState.getParcelable("state");
            if(fragmentState0 != null) {
                i0.mTargetWho = fragmentState0.m;
                i0.mTargetRequestCode = fragmentState0.n;
                Boolean boolean0 = i0.mSavedUserVisibleHint;
                if(boolean0 == null) {
                    i0.mUserVisibleHint = fragmentState0.o;
                }
                else {
                    i0.mUserVisibleHint = boolean0.booleanValue();
                    i0.mSavedUserVisibleHint = null;
                }
            }
            if(!i0.mUserVisibleHint) {
                i0.mDeferStart = true;
            }
        }
    }

    public final void m() {
        boolean z = l0.P(3);
        I i0 = this.c;
        if(z) {
            Log.d("FragmentManager", "moveto RESUMED: " + i0);
        }
        View view0 = i0.getFocusedView();
        if(view0 != null) {
            if(view0 != i0.mView) {
                ViewParent viewParent0 = view0.getParent();
                while(viewParent0 != null) {
                    if(viewParent0 == i0.mView) {
                        goto label_13;
                    }
                    viewParent0 = viewParent0.getParent();
                }
                goto label_16;
            }
        label_13:
            boolean z1 = view0.requestFocus();
            if(l0.P(2)) {
                Log.v("FragmentManager", "requestFocus: Restoring focused view " + view0 + " " + (z1 ? "succeeded" : "failed") + " on Fragment " + i0 + " resulting in focused view " + i0.mView.findFocus());
            }
        }
    label_16:
        i0.setFocusedView(null);
        i0.performResume();
        this.a.i(i0, false);
        this.b.i(null, i0.mWho);
        i0.mSavedFragmentState = null;
        i0.mSavedViewState = null;
        i0.mSavedViewRegistryState = null;
    }

    public final Bundle n() {
        Bundle bundle0 = new Bundle();
        I i0 = this.c;
        if(i0.mState == -1) {
            Bundle bundle1 = i0.mSavedFragmentState;
            if(bundle1 != null) {
                bundle0.putAll(bundle1);
            }
        }
        bundle0.putParcelable("state", new FragmentState(i0));
        if(i0.mState > 0) {
            Bundle bundle2 = new Bundle();
            i0.performSaveInstanceState(bundle2);
            if(!bundle2.isEmpty()) {
                bundle0.putBundle("savedInstanceState", bundle2);
            }
            this.a.j(i0, bundle2, false);
            Bundle bundle3 = new Bundle();
            i0.mSavedStateRegistryController.b(bundle3);
            if(!bundle3.isEmpty()) {
                bundle0.putBundle("registryState", bundle3);
            }
            Bundle bundle4 = i0.mChildFragmentManager.e0();
            if(!bundle4.isEmpty()) {
                bundle0.putBundle("childFragmentManager", bundle4);
            }
            if(i0.mView != null) {
                this.o();
            }
            SparseArray sparseArray0 = i0.mSavedViewState;
            if(sparseArray0 != null) {
                bundle0.putSparseParcelableArray("viewState", sparseArray0);
            }
            Bundle bundle5 = i0.mSavedViewRegistryState;
            if(bundle5 != null) {
                bundle0.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = i0.mArguments;
        if(bundle6 != null) {
            bundle0.putBundle("arguments", bundle6);
        }
        return bundle0;
    }

    public final void o() {
        I i0 = this.c;
        if(i0.mView != null) {
            if(l0.P(2)) {
                Log.v("FragmentManager", "Saving view state for fragment " + i0 + " with view " + i0.mView);
            }
            SparseArray sparseArray0 = new SparseArray();
            i0.mView.saveHierarchyState(sparseArray0);
            if(sparseArray0.size() > 0) {
                i0.mSavedViewState = sparseArray0;
            }
            Bundle bundle0 = new Bundle();
            i0.mViewLifecycleOwner.f.b(bundle0);
            if(!bundle0.isEmpty()) {
                i0.mSavedViewRegistryState = bundle0;
            }
        }
    }
}

