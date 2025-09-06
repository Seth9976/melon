package androidx.activity;

import A3.l;
import Ac.U;
import E4.e;
import E4.f;
import E4.g;
import F4.a;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.D;
import androidx.lifecycle.F;
import androidx.lifecycle.f0;
import androidx.lifecycle.r;
import b.t;
import b.u;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0005H\u0015¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0015¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\tH\u0015¢\u0006\u0004\b\u000E\u0010\rJ\u0017\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0011\u0010\u0015J!\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0011\u0010\u0018J!\u0010\u0019\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\tH\u0017¢\u0006\u0004\b\u001A\u0010\rR\u001D\u0010!\u001A\u00020\u001B8\u0006¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u0012\u0004\b \u0010\r\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010%\u001A\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0014\u0010)\u001A\u00020&8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(¨\u0006*"}, d2 = {"Landroidx/activity/ComponentDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/D;", "Lb/u;", "LE4/g;", "Landroid/os/Bundle;", "onSaveInstanceState", "()Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "layoutResID", "setContentView", "(I)V", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "addContentView", "initializeViewTreeOwners", "Lb/t;", "c", "Lb/t;", "getOnBackPressedDispatcher", "()Lb/t;", "getOnBackPressedDispatcher$annotations", "onBackPressedDispatcher", "LE4/e;", "getSavedStateRegistry", "()LE4/e;", "savedStateRegistry", "Landroidx/lifecycle/t;", "getLifecycle", "()Landroidx/lifecycle/t;", "lifecycle", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class ComponentDialog extends Dialog implements g, D, u {
    public F a;
    public final f b;
    public final t c;

    public ComponentDialog(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, 0);
    }

    public ComponentDialog(Context context0, int v) {
        q.g(context0, "context");
        super(context0, v);
        this.b = new f(new a(this, new U(this, 14)));
        this.c = new t(new l(this, 27));
    }

    public static void a(ComponentDialog componentDialog0) {
        componentDialog0.super.onBackPressed();
    }

    @Override  // android.app.Dialog
    public void addContentView(@NotNull View view0, @Nullable ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        q.g(view0, "view");
        this.initializeViewTreeOwners();
        super.addContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // androidx.lifecycle.D
    @NotNull
    public androidx.lifecycle.t getLifecycle() {
        F f0 = this.a;
        if(f0 == null) {
            f0 = new F(this);
            this.a = f0;
        }
        return f0;
    }

    @Override  // b.u
    @NotNull
    public final t getOnBackPressedDispatcher() {
        return this.c;
    }

    public static void getOnBackPressedDispatcher$annotations() {
    }

    @Override  // E4.g
    @NotNull
    public e getSavedStateRegistry() {
        return this.b.b;
    }

    public void initializeViewTreeOwners() {
        Window window0 = this.getWindow();
        q.d(window0);
        View view0 = window0.getDecorView();
        q.f(view0, "window!!.decorView");
        f0.k(view0, this);
        Window window1 = this.getWindow();
        q.d(window1);
        View view1 = window1.getDecorView();
        q.f(view1, "window!!.decorView");
        view1.setTag(0x7F0A0DD2, this);  // id:view_tree_on_back_pressed_dispatcher_owner
        Window window2 = this.getWindow();
        q.d(window2);
        View view2 = window2.getDecorView();
        q.f(view2, "window!!.decorView");
        a.a.M(view2, this);
    }

    @Override  // android.app.Dialog
    public void onBackPressed() {
        this.c.c();
    }

    @Override  // android.app.Dialog
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher0 = this.getOnBackInvokedDispatcher();
            q.f(onBackInvokedDispatcher0, "onBackInvokedDispatcher");
            this.c.e = onBackInvokedDispatcher0;
            this.c.d(this.c.g);
        }
        this.b.a(bundle0);
        F f0 = this.a;
        if(f0 == null) {
            f0 = new F(this);
            this.a = f0;
        }
        f0.f(r.ON_CREATE);
    }

    @Override  // android.app.Dialog
    @NotNull
    public Bundle onSaveInstanceState() {
        Bundle bundle0 = super.onSaveInstanceState();
        q.f(bundle0, "super.onSaveInstanceState()");
        this.b.b(bundle0);
        return bundle0;
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
        F f0 = this.a;
        if(f0 == null) {
            f0 = new F(this);
            this.a = f0;
        }
        f0.f(r.ON_RESUME);
    }

    @Override  // android.app.Dialog
    public void onStop() {
        F f0 = this.a;
        if(f0 == null) {
            f0 = new F(this);
            this.a = f0;
        }
        f0.f(r.ON_DESTROY);
        this.a = null;
        super.onStop();
    }

    @Override  // android.app.Dialog
    public void setContentView(int v) {
        this.initializeViewTreeOwners();
        super.setContentView(v);
    }

    @Override  // android.app.Dialog
    public void setContentView(@NotNull View view0) {
        q.g(view0, "view");
        this.initializeViewTreeOwners();
        super.setContentView(view0);
    }

    @Override  // android.app.Dialog
    public void setContentView(@NotNull View view0, @Nullable ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        q.g(view0, "view");
        this.initializeViewTreeOwners();
        super.setContentView(view0, viewGroup$LayoutParams0);
    }
}

