package androidx.fragment.app;

import N1.a;
import U2.b;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.F;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements a {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final F mFragmentLifecycleRegistry;
    final Q mFragments;
    boolean mResumed;
    boolean mStopped;

    public FragmentActivity() {
        this.mFragments = new Q(new M(this));
        this.mFragmentLifecycleRegistry = new F(this);
        this.mStopped = true;
        this.init();
    }

    public FragmentActivity(int v) {
        super(v);
        this.mFragments = new Q(new M(this));
        this.mFragmentLifecycleRegistry = new F(this);
        this.mStopped = true;
        this.init();
    }

    public final View dispatchFragmentsOnCreateView(View view0, String s, Context context0, AttributeSet attributeSet0) {
        return this.mFragments.a.d.f.onCreateView(view0, s, context0, attributeSet0);
    }

    @Override  // android.app.Activity
    public void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.dump(s, fileDescriptor0, printWriter0, arr_s);
        if(!this.shouldDumpInternalState(arr_s)) {
            return;
        }
        printWriter0.print(s);
        printWriter0.print("Local FragmentActivity ");
        printWriter0.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter0.println(" State:");
        printWriter0.print(s + "  ");
        printWriter0.print("mCreated=");
        printWriter0.print(this.mCreated);
        printWriter0.print(" mResumed=");
        printWriter0.print(this.mResumed);
        printWriter0.print(" mStopped=");
        printWriter0.print(this.mStopped);
        if(this.getApplication() != null) {
            b.a(this).b(s + "  ", fileDescriptor0, printWriter0, arr_s);
        }
        this.mFragments.a.d.v(s, fileDescriptor0, printWriter0, arr_s);
    }

    public l0 getSupportFragmentManager() {
        return this.mFragments.a.d;
    }

    @Deprecated
    public b getSupportLoaderManager() {
        return b.a(this);
    }

    private void init() {
        this.getSavedStateRegistry().c("android:support:lifecycle", new J(this, 0));
        this.addOnConfigurationChangedListener(new K(this, 0));
        this.addOnNewIntentListener(new K(this, 1));
        this.addOnContextAvailableListener((Context context0) -> {
            M m0 = this.mFragments.a;
            m0.d.b(m0, m0, null);
        });
    }

    private Bundle lambda$init$0() {
        this.markFragmentsCreated();
        this.mFragmentLifecycleRegistry.f(r.ON_STOP);
        return new Bundle();
    }

    private void lambda$init$1(Configuration configuration0) {
        this.mFragments.a();
    }

    private void lambda$init$2(Intent intent0) {
        this.mFragments.a();
    }

    // 检测为 Lambda 实现
    private void lambda$init$3(Context context0) [...]

    public void markFragmentsCreated() {
        while(FragmentActivity.markState(this.getSupportFragmentManager(), s.c)) {
        }
    }

    private static boolean markState(l0 l00, s s0) {
        boolean z = false;
        for(Object object0: l00.c.f()) {
            I i0 = (I)object0;
            if(i0 != null) {
                if(i0.getHost() != null) {
                    z |= FragmentActivity.markState(i0.getChildFragmentManager(), s0);
                }
                H0 h00 = i0.mViewLifecycleOwner;
                if(h00 != null) {
                    h00.b();
                    if(h00.e.d.a(s.d)) {
                        i0.mViewLifecycleOwner.e.h(s0);
                        z = true;
                    }
                }
                if(i0.mLifecycleRegistry.d.a(s.d)) {
                    i0.mLifecycleRegistry.h(s0);
                    z = true;
                }
            }
        }
        return z;
    }

    @Override  // androidx.activity.ComponentActivity
    public void onActivityResult(int v, int v1, Intent intent0) {
        this.mFragments.a();
        super.onActivityResult(v, v1, intent0);
    }

    @Deprecated
    public void onAttachFragment(I i0) {
    }

    @Override  // androidx.activity.ComponentActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.mFragmentLifecycleRegistry.f(r.ON_CREATE);
        this.mFragments.a.d.I = false;
        this.mFragments.a.d.J = false;
        this.mFragments.a.d.P.f = false;
        this.mFragments.a.d.u(1);
    }

    @Override  // android.app.Activity
    public View onCreateView(View view0, String s, Context context0, AttributeSet attributeSet0) {
        View view1 = this.dispatchFragmentsOnCreateView(view0, s, context0, attributeSet0);
        return view1 == null ? super.onCreateView(view0, s, context0, attributeSet0) : view1;
    }

    @Override  // android.app.Activity
    public View onCreateView(String s, Context context0, AttributeSet attributeSet0) {
        View view0 = this.dispatchFragmentsOnCreateView(null, s, context0, attributeSet0);
        return view0 == null ? super.onCreateView(s, context0, attributeSet0) : view0;
    }

    @Override  // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.a.d.l();
        this.mFragmentLifecycleRegistry.f(r.ON_DESTROY);
    }

    @Override  // androidx.activity.ComponentActivity
    public boolean onMenuItemSelected(int v, MenuItem menuItem0) {
        if(super.onMenuItemSelected(v, menuItem0)) {
            return true;
        }
        return v == 6 ? this.mFragments.a.d.j(menuItem0) : false;
    }

    @Override  // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.a.d.u(5);
        this.mFragmentLifecycleRegistry.f(r.ON_PAUSE);
    }

    @Override  // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.onResumeFragments();
    }

    @Override  // androidx.activity.ComponentActivity
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        this.mFragments.a();
        super.onRequestPermissionsResult(v, arr_s, arr_v);
    }

    @Override  // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.a.d.z(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.f(r.ON_RESUME);
        this.mFragments.a.d.I = false;
        this.mFragments.a.d.J = false;
        this.mFragments.a.d.P.f = false;
        this.mFragments.a.d.u(7);
    }

    @Override  // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if(!this.mCreated) {
            this.mCreated = true;
            this.mFragments.a.d.I = false;
            this.mFragments.a.d.J = false;
            this.mFragments.a.d.P.f = false;
            this.mFragments.a.d.u(4);
        }
        this.mFragments.a.d.z(true);
        this.mFragmentLifecycleRegistry.f(r.ON_START);
        this.mFragments.a.d.I = false;
        this.mFragments.a.d.J = false;
        this.mFragments.a.d.P.f = false;
        this.mFragments.a.d.u(5);
    }

    @Override  // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override  // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        this.markFragmentsCreated();
        this.mFragments.a.d.J = true;
        this.mFragments.a.d.P.f = true;
        this.mFragments.a.d.u(4);
        this.mFragmentLifecycleRegistry.f(r.ON_STOP);
    }

    public void setEnterSharedElementCallback(N1.F f0) {
        this.setEnterSharedElementCallback(null);
    }

    public void setExitSharedElementCallback(N1.F f0) {
        this.setExitSharedElementCallback(null);
    }

    public void startActivityFromFragment(I i0, Intent intent0, int v) {
        this.startActivityFromFragment(i0, intent0, v, null);
    }

    public void startActivityFromFragment(I i0, Intent intent0, int v, Bundle bundle0) {
        if(v == -1) {
            this.startActivityForResult(intent0, -1, bundle0);
            return;
        }
        i0.startActivityForResult(intent0, v, bundle0);
    }

    @Deprecated
    public void startIntentSenderFromFragment(I i0, IntentSender intentSender0, int v, Intent intent0, int v1, int v2, int v3, Bundle bundle0) {
        if(v == -1) {
            this.startIntentSenderForResult(intentSender0, -1, intent0, v1, v2, v3, bundle0);
            return;
        }
        i0.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3, bundle0);
    }

    public void supportFinishAfterTransition() {
        this.finishAfterTransition();
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        this.invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        this.postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        this.startPostponedEnterTransition();
    }

    @Override  // N1.a
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int v) {
    }
}

