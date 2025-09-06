package androidx.appcompat.app;

import N1.G;
import N1.H;
import N1.e;
import P1.c;
import R1.a;
import Y1.f;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.E0;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.x;
import androidx.fragment.app.FragmentActivity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import jeb.synthetic.FIN;

public class AppCompatActivity extends FragmentActivity implements G, i {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private n mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        this.initDelegate();
    }

    public AppCompatActivity(int v) {
        super(v);
        this.initDelegate();
    }

    @Override  // androidx.activity.ComponentActivity
    public void addContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initializeViewTreeOwners();
        D d0 = (D)this.getDelegate();
        d0.x();
        ((ViewGroup)d0.V.findViewById(0x1020002)).addView(view0, viewGroup$LayoutParams0);
        d0.m.a(d0.l.getCallback());
    }

    @Override  // android.app.Activity
    public void attachBaseContext(Context context0) {
        Configuration configuration5;
        D d0 = (D)this.getDelegate();
        d0.k0 = true;
        int v = d0.D(context0, (d0.o0 == -100 ? n.b : d0.o0));
        if(n.d(context0) && n.d(context0)) {
            if(Build.VERSION.SDK_INT < 33) {
                Object object0 = n.i;
                __monitor_enter(object0);
                int v1 = FIN.finallyOpen$NT();
                f f0 = n.c;
                if(f0 == null) {
                    if(n.d == null) {
                        n.d = f.a(e.e(context0));
                    }
                    if(n.d.a.a.isEmpty()) {
                        FIN.finallyExec$NT(v1);
                    }
                    else {
                        n.c = n.d;
                        goto label_24;
                    }
                }
                else {
                    if(!f0.equals(n.d)) {
                        n.d = n.c;
                        e.d(context0, n.c.a.a.toLanguageTags());
                    }
                label_24:
                    FIN.finallyCodeBegin$NT(v1);
                    __monitor_exit(object0);
                    FIN.finallyCodeEnd$NT(v1);
                }
            }
            else if(!n.f) {
                j j0 = new j(context0, 0);
                n.a.execute(j0);
            }
        }
        f f1 = D.q(context0);
        if(context0 instanceof ContextThemeWrapper) {
            Configuration configuration0 = D.u(context0, v, f1, null, false);
            try {
                ((ContextThemeWrapper)context0).applyOverrideConfiguration(configuration0);
                goto label_143;
            }
            catch(IllegalStateException unused_ex) {
            }
            goto label_32;
        }
        else {
        label_32:
            if(context0 instanceof androidx.appcompat.view.ContextThemeWrapper) {
                Configuration configuration1 = D.u(context0, v, f1, null, false);
                try {
                    ((androidx.appcompat.view.ContextThemeWrapper)context0).a(configuration1);
                    goto label_143;
                }
                catch(IllegalStateException unused_ex) {
                }
                goto label_36;
            }
            else {
            label_36:
                if(D.F0) {
                    Configuration configuration2 = new Configuration();
                    configuration2.uiMode = -1;
                    configuration2.fontScale = 0.0f;
                    Configuration configuration3 = context0.createConfigurationContext(configuration2).getResources().getConfiguration();
                    Configuration configuration4 = context0.getResources().getConfiguration();
                    configuration3.uiMode = configuration4.uiMode;
                    if(configuration3.equals(configuration4)) {
                        configuration5 = null;
                    }
                    else {
                        configuration5 = new Configuration();
                        configuration5.fontScale = 0.0f;
                        if(configuration3.diff(configuration4) != 0) {
                            float f2 = configuration4.fontScale;
                            if(configuration3.fontScale != f2) {
                                configuration5.fontScale = f2;
                            }
                            int v2 = configuration4.mcc;
                            if(configuration3.mcc != v2) {
                                configuration5.mcc = v2;
                            }
                            int v3 = configuration4.mnc;
                            if(configuration3.mnc != v3) {
                                configuration5.mnc = v3;
                            }
                            u.a(configuration3, configuration4, configuration5);
                            int v4 = configuration4.touchscreen;
                            if(configuration3.touchscreen != v4) {
                                configuration5.touchscreen = v4;
                            }
                            int v5 = configuration4.keyboard;
                            if(configuration3.keyboard != v5) {
                                configuration5.keyboard = v5;
                            }
                            int v6 = configuration4.keyboardHidden;
                            if(configuration3.keyboardHidden != v6) {
                                configuration5.keyboardHidden = v6;
                            }
                            int v7 = configuration4.navigation;
                            if(configuration3.navigation != v7) {
                                configuration5.navigation = v7;
                            }
                            int v8 = configuration4.navigationHidden;
                            if(configuration3.navigationHidden != v8) {
                                configuration5.navigationHidden = v8;
                            }
                            int v9 = configuration4.orientation;
                            if(configuration3.orientation != v9) {
                                configuration5.orientation = v9;
                            }
                            int v10 = configuration4.screenLayout & 15;
                            if((configuration3.screenLayout & 15) != v10) {
                                configuration5.screenLayout |= v10;
                            }
                            int v11 = configuration4.screenLayout & 0xC0;
                            if((configuration3.screenLayout & 0xC0) != v11) {
                                configuration5.screenLayout |= v11;
                            }
                            int v12 = configuration4.screenLayout & 0x30;
                            if((configuration3.screenLayout & 0x30) != v12) {
                                configuration5.screenLayout |= v12;
                            }
                            int v13 = configuration4.screenLayout & 0x300;
                            if((configuration3.screenLayout & 0x300) != v13) {
                                configuration5.screenLayout |= v13;
                            }
                            int v14 = configuration4.colorMode & 3;
                            if((configuration3.colorMode & 3) != v14) {
                                configuration5.colorMode |= v14;
                            }
                            int v15 = configuration4.colorMode & 12;
                            if((configuration3.colorMode & 12) != v15) {
                                configuration5.colorMode |= v15;
                            }
                            int v16 = configuration4.uiMode & 15;
                            if((configuration3.uiMode & 15) != v16) {
                                configuration5.uiMode |= v16;
                            }
                            int v17 = configuration4.uiMode & 0x30;
                            if((configuration3.uiMode & 0x30) != v17) {
                                configuration5.uiMode |= v17;
                            }
                            int v18 = configuration4.screenWidthDp;
                            if(configuration3.screenWidthDp != v18) {
                                configuration5.screenWidthDp = v18;
                            }
                            int v19 = configuration4.screenHeightDp;
                            if(configuration3.screenHeightDp != v19) {
                                configuration5.screenHeightDp = v19;
                            }
                            int v20 = configuration4.smallestScreenWidthDp;
                            if(configuration3.smallestScreenWidthDp != v20) {
                                configuration5.smallestScreenWidthDp = v20;
                            }
                            int v21 = configuration4.densityDpi;
                            if(configuration3.densityDpi != v21) {
                                configuration5.densityDpi = v21;
                            }
                        }
                    }
                    Configuration configuration6 = D.u(context0, v, f1, configuration5, true);
                    androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper0 = new androidx.appcompat.view.ContextThemeWrapper(context0, 0x7F14029C);  // style:Theme.AppCompat.Empty
                    contextThemeWrapper0.a(configuration6);
                    try {
                        if(context0.getTheme() != null) {
                            goto label_117;
                        }
                    }
                    catch(NullPointerException unused_ex) {
                    }
                    goto label_142;
                label_117:
                    Resources.Theme resources$Theme0 = contextThemeWrapper0.getTheme();
                    if(Build.VERSION.SDK_INT >= 29) {
                        R1.i.a(resources$Theme0);
                    }
                    else {
                        synchronized(a.e) {
                            if(!a.g) {
                                try {
                                    Method method0 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    a.f = method0;
                                    method0.setAccessible(true);
                                }
                                catch(NoSuchMethodException noSuchMethodException0) {
                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", noSuchMethodException0);
                                }
                                a.g = true;
                            }
                            Method method1 = a.f;
                            if(method1 != null) {
                                try {
                                    method1.invoke(resources$Theme0, null);
                                }
                                catch(IllegalAccessException | InvocationTargetException illegalAccessException0) {
                                    Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", illegalAccessException0);
                                    a.f = null;
                                }
                            }
                        }
                    }
                label_142:
                    context0 = contextThemeWrapper0;
                }
            }
        }
    label_143:
        super.attachBaseContext(context0);
    }

    @Override  // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a a0 = this.getSupportActionBar();
        if(this.getWindow().hasFeature(0) && (a0 == null || !a0.a())) {
            super.closeOptionsMenu();
        }
    }

    @Override  // androidx.core.app.ComponentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        int v = keyEvent0.getKeyCode();
        androidx.appcompat.app.a a0 = this.getSupportActionBar();
        return v != 82 || a0 == null || !a0.k(keyEvent0) ? super.dispatchKeyEvent(keyEvent0) : true;
    }

    @Override  // android.app.Activity
    public View findViewById(int v) {
        D d0 = (D)this.getDelegate();
        d0.x();
        return d0.l.findViewById(v);
    }

    public n getDelegate() {
        if(this.mDelegate == null) {
            this.mDelegate = new D(this, null, this, this);
        }
        return this.mDelegate;
    }

    public b getDrawerToggleDelegate() {
        ((D)this.getDelegate()).getClass();
        return new s();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // android.app.Activity
    public MenuInflater getMenuInflater() {
        D d0 = (D)this.getDelegate();
        if(d0.r == null) {
            d0.B();
            d0.r = new SupportMenuInflater((d0.o == null ? d0.k : d0.o.e()));
        }
        return d0.r;
    }

    @Override  // android.view.ContextThemeWrapper
    public Resources getResources() {
        return this.mResources == null ? super.getResources() : this.mResources;
    }

    public androidx.appcompat.app.a getSupportActionBar() {
        D d0 = (D)this.getDelegate();
        d0.B();
        return d0.o;
    }

    @Override  // N1.G
    public Intent getSupportParentActivityIntent() {
        return e.b(this);
    }

    private void initDelegate() {
        this.getSavedStateRegistry().c("androidx:appcompat", new E4.a(this));
        this.addOnContextAvailableListener(new h(this, 0));
    }

    @Override  // android.app.Activity
    public void invalidateOptionsMenu() {
        this.getDelegate().b();
    }

    @Override  // androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        D d0 = (D)this.getDelegate();
        if(d0.b0 && d0.T) {
            d0.B();
            androidx.appcompat.app.a a0 = d0.o;
            if(a0 != null) {
                a0.h();
            }
        }
        x x0 = x.a();
        synchronized(x0) {
            E0 e00 = x0.a;
            synchronized(e00) {
                androidx.collection.s s0 = (androidx.collection.s)e00.b.get(d0.k);
                if(s0 != null) {
                    s0.a();
                }
            }
        }
        d0.n0 = new Configuration(d0.k.getResources().getConfiguration());
        d0.o(false, false);
        if(this.mResources != null) {
            Configuration configuration1 = super.getResources().getConfiguration();
            DisplayMetrics displayMetrics0 = super.getResources().getDisplayMetrics();
            this.mResources.updateConfiguration(configuration1, displayMetrics0);
        }
    }

    @Override  // android.app.Activity
    public void onContentChanged() {
    }

    public void onCreateSupportNavigateUpTaskStack(H h0) {
        h0.getClass();
        ArrayList arrayList0 = h0.a;
        AppCompatActivity appCompatActivity0 = h0.b;
        Intent intent0 = this.getSupportParentActivityIntent();
        if(intent0 == null) {
            intent0 = e.b(this);
        }
        if(intent0 != null) {
            ComponentName componentName0 = intent0.getComponent();
            if(componentName0 == null) {
                componentName0 = intent0.resolveActivity(appCompatActivity0.getPackageManager());
            }
            int v = arrayList0.size();
            try {
                for(Intent intent1 = e.a(appCompatActivity0, componentName0); intent1 != null; intent1 = e.a(appCompatActivity0, intent1.getComponent())) {
                    arrayList0.add(v, intent1);
                }
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(packageManager$NameNotFoundException0);
            }
            arrayList0.add(intent0);
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.getDelegate().f();
    }

    @Override  // android.app.Activity
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        return super.onKeyDown(v, keyEvent0);
    }

    public void onLocalesChanged(f f0) {
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public final boolean onMenuItemSelected(int v, MenuItem menuItem0) {
        if(super.onMenuItemSelected(v, menuItem0)) {
            return true;
        }
        androidx.appcompat.app.a a0 = this.getSupportActionBar();
        return menuItem0.getItemId() != 0x102002C || a0 == null || (a0.d() & 4) == 0 ? false : this.onSupportNavigateUp();
    }

    @Override  // android.app.Activity
    public boolean onMenuOpened(int v, Menu menu0) {
        return super.onMenuOpened(v, menu0);
    }

    public void onNightModeChanged(int v) {
    }

    @Override  // androidx.activity.ComponentActivity
    public void onPanelClosed(int v, Menu menu0) {
        super.onPanelClosed(v, menu0);
    }

    @Override  // android.app.Activity
    public void onPostCreate(Bundle bundle0) {
        super.onPostCreate(bundle0);
        ((D)this.getDelegate()).x();
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        D d0 = (D)this.getDelegate();
        d0.B();
        androidx.appcompat.app.a a0 = d0.o;
        if(a0 != null) {
            a0.p(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(H h0) {
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        ((D)this.getDelegate()).o(true, false);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        D d0 = (D)this.getDelegate();
        d0.B();
        androidx.appcompat.app.a a0 = d0.o;
        if(a0 != null) {
            a0.p(false);
        }
    }

    @Override  // androidx.appcompat.app.i
    public void onSupportActionModeFinished(j.b b0) {
    }

    @Override  // androidx.appcompat.app.i
    public void onSupportActionModeStarted(j.b b0) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent intent0 = this.getSupportParentActivityIntent();
        if(intent0 != null) {
            if(this.supportShouldUpRecreateTask(intent0)) {
                H h0 = new H(this);
                this.onCreateSupportNavigateUpTaskStack(h0);
                ArrayList arrayList0 = h0.a;
                if(arrayList0.isEmpty()) {
                    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
                }
                Intent[] arr_intent = (Intent[])arrayList0.toArray(new Intent[0]);
                arr_intent[0] = new Intent(arr_intent[0]).addFlags(0x1000C000);
                AppCompatActivity appCompatActivity0 = h0.b;
                if(!c.startActivities(appCompatActivity0, arr_intent, null)) {
                    Intent intent1 = new Intent(arr_intent[arr_intent.length - 1]);
                    intent1.addFlags(0x10000000);
                    appCompatActivity0.startActivity(intent1);
                }
                try {
                    this.finishAffinity();
                }
                catch(IllegalStateException unused_ex) {
                    this.finish();
                }
                return true;
            }
            this.supportNavigateUpTo(intent0);
            return true;
        }
        return false;
    }

    @Override  // android.app.Activity
    public void onTitleChanged(CharSequence charSequence0, int v) {
        super.onTitleChanged(charSequence0, v);
        this.getDelegate().m(charSequence0);
    }

    @Override  // androidx.appcompat.app.i
    public j.b onWindowStartingSupportActionMode(j.a a0) {
        return null;
    }

    @Override  // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a a0 = this.getSupportActionBar();
        if(this.getWindow().hasFeature(0) && (a0 == null || !a0.l())) {
            super.openOptionsMenu();
        }
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent0) [...] // Inlined contents

    @Override  // androidx.activity.ComponentActivity
    public void setContentView(int v) {
        this.initializeViewTreeOwners();
        this.getDelegate().i(v);
    }

    @Override  // androidx.activity.ComponentActivity
    public void setContentView(View view0) {
        this.initializeViewTreeOwners();
        this.getDelegate().k(view0);
    }

    @Override  // androidx.activity.ComponentActivity
    public void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initializeViewTreeOwners();
        this.getDelegate().l(view0, viewGroup$LayoutParams0);
    }

    public void setSupportActionBar(Toolbar toolbar0) {
        D d0 = (D)this.getDelegate();
        if(!(d0.j instanceof Activity)) {
            return;
        }
        d0.B();
        androidx.appcompat.app.a a0 = d0.o;
        if(a0 instanceof P) {
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
        d0.r = null;
        if(a0 != null) {
            a0.i();
        }
        d0.o = null;
        if(toolbar0 == null) {
            d0.m.b = null;
        }
        else {
            K k0 = new K(toolbar0, (d0.j instanceof Activity ? ((Activity)d0.j).getTitle() : d0.w), d0.m);
            d0.o = k0;
            d0.m.b = k0.c;
            toolbar0.setBackInvokedCallbackEnabled(true);
        }
        d0.b();
    }

    @Deprecated
    public void setSupportProgress(int v) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override  // android.app.Activity
    public void setTheme(int v) {
        super.setTheme(v);
        ((D)this.getDelegate()).p0 = v;
    }

    public j.b startSupportActionMode(j.a a0) {
        return this.getDelegate().n(a0);
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        this.getDelegate().b();
    }

    public void supportNavigateUpTo(Intent intent0) {
        this.navigateUpTo(intent0);
    }

    public boolean supportRequestWindowFeature(int v) {
        return this.getDelegate().h(v);
    }

    public boolean supportShouldUpRecreateTask(Intent intent0) {
        return this.shouldUpRecreateTask(intent0);
    }
}

