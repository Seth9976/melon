package com.google.android.gms.auth.api.signin.internal;

import U2.b;
import U2.c;
import U2.d;
import U2.f;
import U2.g;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.collection.W;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.D;
import androidx.loader.content.Loader;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.reflect.Modifier;

@KeepName
public class SignInHubActivity extends FragmentActivity {
    private static boolean zba = false;
    private boolean zbb;
    private SignInConfiguration zbc;
    private boolean zbd;
    private int zbe;
    private Intent zbf;

    public SignInHubActivity() {
        this.zbb = false;
    }

    @Override  // android.app.Activity
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        return true;
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public final void onActivityResult(int v, int v1, Intent intent0) {
        if(!this.zbb) {
            this.setResult(0);
            if(v == 0xA002) {
                if(intent0 != null) {
                    SignInAccount signInAccount0 = (SignInAccount)intent0.getParcelableExtra("signInAccount");
                    if(signInAccount0 != null && signInAccount0.zba() != null) {
                        GoogleSignInAccount googleSignInAccount0 = signInAccount0.zba();
                        if(googleSignInAccount0 == null) {
                            Log.e("AuthSignInClient", "Google account is null");
                            this.zbd(12500);
                            return;
                        }
                        zbn.zbc(this).zbe(this.zbc.zba(), googleSignInAccount0);
                        intent0.removeExtra("signInAccount");
                        intent0.putExtra("googleSignInAccount", googleSignInAccount0);
                        this.zbd = true;
                        this.zbe = v1;
                        this.zbf = intent0;
                        this.zbc();
                        return;
                    }
                    if(intent0.hasExtra("errorCode")) {
                        int v2 = intent0.getIntExtra("errorCode", 8);
                        if(v2 == 13) {
                            v2 = 0x30D5;
                        }
                        this.zbd(v2);
                        return;
                    }
                }
                this.zbd(8);
            }
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Intent intent0 = this.getIntent();
        String s = intent0.getAction();
        if(s == null) {
            Log.e("AuthSignInClient", "Null action");
            this.zbd(12500);
            return;
        }
        if(s.equals("com.google.android.gms.auth.NO_IMPL")) {
            Log.e("AuthSignInClient", "Action not implemented");
            this.zbd(12500);
            return;
        }
        if(!s.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !s.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Log.e("AuthSignInClient", "Unknown action: " + intent0.getAction());
            this.finish();
            return;
        }
        Bundle bundle1 = intent0.getBundleExtra("config");
        if(bundle1 == null) {
            Log.e("AuthSignInClient", "Activity started with no configuration.");
            this.setResult(0);
            this.finish();
            return;
        }
        SignInConfiguration signInConfiguration0 = (SignInConfiguration)bundle1.getParcelable("config");
        if(signInConfiguration0 == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            this.setResult(0);
            this.finish();
            return;
        }
        this.zbc = signInConfiguration0;
        if(bundle0 == null) {
            if(SignInHubActivity.zba) {
                this.setResult(0);
                this.zbd(0x30D6);
                return;
            }
            SignInHubActivity.zba = true;
            this.zbe(s);
            return;
        }
        boolean z = bundle0.getBoolean("signingInGoogleApiClients");
        this.zbd = z;
        if(z) {
            this.zbe = bundle0.getInt("signInResultCode");
            Intent intent1 = (Intent)bundle0.getParcelable("signInResultData");
            if(intent1 == null) {
                Log.e("AuthSignInClient", "Sign in result data cannot be null");
                this.setResult(0);
                this.finish();
                return;
            }
            this.zbf = intent1;
            this.zbc();
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public final void onDestroy() {
        super.onDestroy();
        SignInHubActivity.zba = false;
    }

    @Override  // androidx.activity.ComponentActivity
    public final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean("signingInGoogleApiClients", this.zbd);
        if(this.zbd) {
            bundle0.putInt("signInResultCode", this.zbe);
            bundle0.putParcelable("signInResultData", this.zbf);
        }
    }

    private final void zbc() {
        b b0 = this.getSupportLoaderManager();
        zbv zbv0 = new zbv(this, null);
        Object object0 = ((g)b0).a;
        f f0 = ((g)b0).b;
        W w0 = f0.a;
        if(f0.b) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if(Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        c c0 = (c)w0.c(0);
        if(c0 == null) {
            try {
                f0.b = true;
                Loader loader0 = zbv0.onCreateLoader(0, null);
                if(loader0 != null) {
                    if(loader0.getClass().isMemberClass() && !Modifier.isStatic(loader0.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + loader0);
                    }
                    c c1 = new c(loader0);
                    w0.d(0, c1);
                    d d0 = new d(c1.l, zbv0);
                    c1.observe(((D)object0), d0);
                    d d1 = c1.n;
                    if(d1 != null) {
                        c1.removeObserver(d1);
                    }
                    c1.m = object0;
                    c1.n = d0;
                    SignInHubActivity.zba = false;
                    return;
                }
            }
            finally {
                f0.b = false;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        }
        else {
            d d2 = new d(c0.l, zbv0);
            c0.observe(((D)object0), d2);
            d d3 = c0.n;
            if(d3 != null) {
                c0.removeObserver(d3);
            }
            c0.m = object0;
            c0.n = d2;
        }
        SignInHubActivity.zba = false;
    }

    private final void zbd(int v) {
        Status status0 = new Status(v);
        Intent intent0 = new Intent();
        intent0.putExtra("googleSignInStatus", status0);
        this.setResult(0, intent0);
        this.finish();
        SignInHubActivity.zba = false;
    }

    private final void zbe(String s) {
        Intent intent0 = new Intent(s);
        if(s.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent0.setPackage("com.google.android.gms");
        }
        else {
            intent0.setPackage("com.iloen.melon");
        }
        intent0.putExtra("config", this.zbc);
        try {
            this.startActivityForResult(intent0, 0xA002);
        }
        catch(ActivityNotFoundException unused_ex) {
            this.zbb = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            this.zbd(17);
        }
    }
}

