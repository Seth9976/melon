package androidx.fragment.app;

import A2.d;
import android.util.Log;
import androidx.lifecycle.s;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import k8.Y;

public final class a extends y0 implements i0 {
    public final l0 r;
    public boolean s;
    public int t;

    public a(l0 l00) {
        l00.M();
        S s0 = l00.x;
        if(s0 != null) {
            s0.b.getClassLoader();
        }
        super();
        this.a = new ArrayList();
        this.h = true;
        this.p = false;
        this.t = -1;
        this.r = l00;
    }

    @Override  // androidx.fragment.app.i0
    public final boolean a(ArrayList arrayList0, ArrayList arrayList1) {
        if(l0.P(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList0.add(this);
        arrayList1.add(Boolean.FALSE);
        if(this.g) {
            this.r.d.add(this);
        }
        return true;
    }

    @Override  // androidx.fragment.app.y0
    public final a d(I i0) {
        if(i0.mFragmentManager != null && i0.mFragmentManager != this.r) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + i0.toString() + " is already attached to a FragmentManager.");
        }
        this.b(new x0(i0, 6));
        return this;
    }

    @Override  // androidx.fragment.app.y0
    public final void e(int v, I i0, String s, int v1) {
        String s1 = i0.mPreviousWho;
        if(s1 != null) {
            d.c(i0, s1);
        }
        Class class0 = i0.getClass();
        int v2 = class0.getModifiers();
        if(class0.isAnonymousClass() || !Modifier.isPublic(v2) || class0.isMemberClass() && !Modifier.isStatic(v2)) {
            throw new IllegalStateException("Fragment " + class0.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if(s != null) {
            if(i0.mTag != null && !s.equals(i0.mTag)) {
                StringBuilder stringBuilder0 = new StringBuilder("Can\'t change tag of fragment ");
                stringBuilder0.append(i0);
                stringBuilder0.append(": was ");
                throw new IllegalStateException(Y.l(stringBuilder0, i0.mTag, " now ", s));
            }
            i0.mTag = s;
        }
        switch(v) {
            case -1: {
                throw new IllegalArgumentException("Can\'t add fragment " + i0 + " with tag " + s + " to container view with no id");
            label_16:
                if(i0.mFragmentId != 0 && i0.mFragmentId != v) {
                    throw new IllegalStateException("Can\'t change container ID of fragment " + i0 + ": was " + i0.mFragmentId + " now " + v);
                }
                i0.mFragmentId = v;
                i0.mContainerId = v;
                break;
            }
            case 0: {
                break;
            }
            default: {
                goto label_16;
            }
        }
        this.b(new x0(i0, v1));
        i0.mFragmentManager = this.r;
    }

    @Override  // androidx.fragment.app.y0
    public final a f(I i0) {
        if(i0.mFragmentManager != null && i0.mFragmentManager != this.r) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + i0.toString() + " is already attached to a FragmentManager.");
        }
        this.b(new x0(i0, 3));
        return this;
    }

    @Override  // androidx.fragment.app.y0
    public final a h(I i0, s s0) {
        l0 l00 = this.r;
        if(i0.mFragmentManager != l00) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + l00);
        }
        if(s0 == s.b && i0.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + s0 + " after the Fragment has been created");
        }
        if(s0 == s.a) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + s0 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        x0 x00 = new x0();  // 初始化器: Ljava/lang/Object;-><init>()V
        x00.a = 10;
        x00.b = i0;
        x00.c = false;
        x00.h = i0.mMaxState;
        x00.i = s0;
        this.b(x00);
        return this;
    }

    public final void i(int v) {
        ArrayList arrayList0 = this.a;
        if(this.g) {
            if(l0.P(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + v);
            }
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                x0 x00 = (x0)arrayList0.get(v2);
                I i0 = x00.b;
                if(i0 != null) {
                    i0.mBackStackNesting += v;
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + x00.b + " to " + x00.b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void j() {
        ArrayList arrayList0 = this.a;
        for(int v = arrayList0.size() - 1; v >= 0; --v) {
            x0 x00 = (x0)arrayList0.get(v);
            if(x00.c) {
                if(x00.a == 8) {
                    x00.c = false;
                    arrayList0.remove(v - 1);
                    --v;
                }
                else {
                    int v1 = x00.b.mContainerId;
                    x00.a = 2;
                    x00.c = false;
                    for(int v2 = v - 1; v2 >= 0; --v2) {
                        x0 x01 = (x0)arrayList0.get(v2);
                        if(x01.c && x01.b.mContainerId == v1) {
                            arrayList0.remove(v2);
                            --v;
                        }
                    }
                }
            }
        }
    }

    public final int k() {
        return this.l(false, true);
    }

    public final int l(boolean z, boolean z1) {
        if(this.s) {
            throw new IllegalStateException("commit already called");
        }
        if(l0.P(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter0 = new PrintWriter(new I0());
            this.n("  ", printWriter0, true);
            printWriter0.close();
        }
        this.s = true;
        l0 l00 = this.r;
        this.t = this.g ? l00.k.getAndIncrement() : -1;
        if(z1) {
            l00.x(this, z);
        }
        return this.t;
    }

    public final void m() {
        if(this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.h = false;
        this.r.A(this, false);
    }

    public final void n(String s, PrintWriter printWriter0, boolean z) {
        String s1;
        ArrayList arrayList0 = this.a;
        if(z) {
            printWriter0.print(s);
            printWriter0.print("mName=");
            printWriter0.print(this.i);
            printWriter0.print(" mIndex=");
            printWriter0.print(this.t);
            printWriter0.print(" mCommitted=");
            printWriter0.println(this.s);
            if(this.f != 0) {
                printWriter0.print(s);
                printWriter0.print("mTransition=#");
                printWriter0.print(Integer.toHexString(this.f));
            }
            if(this.b != 0 || this.c != 0) {
                printWriter0.print(s);
                printWriter0.print("mEnterAnim=#");
                printWriter0.print(Integer.toHexString(this.b));
                printWriter0.print(" mExitAnim=#");
                printWriter0.println(Integer.toHexString(this.c));
            }
            if(this.d != 0 || this.e != 0) {
                printWriter0.print(s);
                printWriter0.print("mPopEnterAnim=#");
                printWriter0.print(Integer.toHexString(this.d));
                printWriter0.print(" mPopExitAnim=#");
                printWriter0.println(Integer.toHexString(this.e));
            }
            if(this.j != 0 || this.k != null) {
                printWriter0.print(s);
                printWriter0.print("mBreadCrumbTitleRes=#");
                printWriter0.print(Integer.toHexString(this.j));
                printWriter0.print(" mBreadCrumbTitleText=");
                printWriter0.println(this.k);
            }
            if(this.l != 0 || this.m != null) {
                printWriter0.print(s);
                printWriter0.print("mBreadCrumbShortTitleRes=#");
                printWriter0.print(Integer.toHexString(this.l));
                printWriter0.print(" mBreadCrumbShortTitleText=");
                printWriter0.println(this.m);
            }
        }
        if(!arrayList0.isEmpty()) {
            printWriter0.print(s);
            printWriter0.println("Operations:");
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                x0 x00 = (x0)arrayList0.get(v1);
                switch(x00.a) {
                    case 0: {
                        s1 = "NULL";
                        break;
                    }
                    case 1: {
                        s1 = "ADD";
                        break;
                    }
                    case 2: {
                        s1 = "REPLACE";
                        break;
                    }
                    case 3: {
                        s1 = "REMOVE";
                        break;
                    }
                    case 4: {
                        s1 = "HIDE";
                        break;
                    }
                    case 5: {
                        s1 = "SHOW";
                        break;
                    }
                    case 6: {
                        s1 = "DETACH";
                        break;
                    }
                    case 7: {
                        s1 = "ATTACH";
                        break;
                    }
                    case 8: {
                        s1 = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 9: {
                        s1 = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 10: {
                        s1 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    }
                    default: {
                        s1 = "cmd=" + x00.a;
                    }
                }
                printWriter0.print(s);
                printWriter0.print("  Op #");
                printWriter0.print(v1);
                printWriter0.print(": ");
                printWriter0.print(s1);
                printWriter0.print(" ");
                printWriter0.println(x00.b);
                if(z) {
                    if(x00.d != 0 || x00.e != 0) {
                        printWriter0.print(s);
                        printWriter0.print("enterAnim=#");
                        printWriter0.print(Integer.toHexString(x00.d));
                        printWriter0.print(" exitAnim=#");
                        printWriter0.println(Integer.toHexString(x00.e));
                    }
                    if(x00.f != 0 || x00.g != 0) {
                        printWriter0.print(s);
                        printWriter0.print("popEnterAnim=#");
                        printWriter0.print(Integer.toHexString(x00.f));
                        printWriter0.print(" popExitAnim=#");
                        printWriter0.println(Integer.toHexString(x00.g));
                    }
                }
            }
        }
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(0x80);
        stringBuilder0.append("BackStackEntry{");
        stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
        if(this.t >= 0) {
            stringBuilder0.append(" #");
            stringBuilder0.append(this.t);
        }
        if(this.i != null) {
            stringBuilder0.append(" ");
            stringBuilder0.append(this.i);
        }
        stringBuilder0.append("}");
        return stringBuilder0.toString();
    }
}

