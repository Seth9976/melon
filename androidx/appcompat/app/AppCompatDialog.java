package androidx.appcompat.app;

import De.I;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import j.b;

public class AppCompatDialog extends ComponentDialog implements i {
    public D d;
    public final E e;

    public AppCompatDialog(Context context0) {
        this(context0, 0);
    }

    public AppCompatDialog(Context context0, int v) {
        int v1;
        if(v == 0) {
            TypedValue typedValue0 = new TypedValue();
            context0.getTheme().resolveAttribute(0x7F040203, typedValue0, true);  // attr:dialogTheme
            v1 = typedValue0.resourceId;
        }
        else {
            v1 = v;
        }
        super(context0, v1);
        this.e = (KeyEvent keyEvent0) -> super.dispatchKeyEvent(keyEvent0);
        n n0 = this.b();
        if(v == 0) {
            TypedValue typedValue1 = new TypedValue();
            context0.getTheme().resolveAttribute(0x7F040203, typedValue1, true);  // attr:dialogTheme
            v = typedValue1.resourceId;
        }
        ((D)n0).p0 = v;
        n0.e();
    }

    @Override  // androidx.activity.ComponentDialog
    public final void addContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initializeViewTreeOwners();
        D d0 = (D)this.b();
        d0.x();
        ((ViewGroup)d0.V.findViewById(0x1020002)).addView(view0, viewGroup$LayoutParams0);
        d0.m.a(d0.l.getCallback());
    }

    public final n b() {
        if(this.d == null) {
            this.d = new D(this.getContext(), this.getWindow(), this, this);
        }
        return this.d;
    }

    // 检测为 Lambda 实现
    public final boolean c(KeyEvent keyEvent0) [...]

    @Override  // android.app.Dialog
    public void dismiss() {
        super.dismiss();
        this.b().f();
    }

    @Override  // android.app.Dialog
    public final boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        View view0 = this.getWindow().getDecorView();
        return I.B(this.e, view0, this, keyEvent0);
    }

    @Override  // android.app.Dialog
    public final View findViewById(int v) {
        D d0 = (D)this.b();
        d0.x();
        return d0.l.findViewById(v);
    }

    @Override  // android.app.Dialog
    public final void invalidateOptionsMenu() {
        this.b().b();
    }

    @Override  // androidx.activity.ComponentDialog
    public void onCreate(Bundle bundle0) {
        this.b().a();
        super.onCreate(bundle0);
        this.b().e();
    }

    @Override  // androidx.activity.ComponentDialog
    public final void onStop() {
        super.onStop();
        D d0 = (D)this.b();
        d0.B();
        a a0 = d0.o;
        if(a0 != null) {
            a0.p(false);
        }
    }

    @Override  // androidx.appcompat.app.i
    public final void onSupportActionModeFinished(b b0) {
    }

    @Override  // androidx.appcompat.app.i
    public final void onSupportActionModeStarted(b b0) {
    }

    @Override  // androidx.appcompat.app.i
    public final b onWindowStartingSupportActionMode(j.a a0) {
        return null;
    }

    @Override  // androidx.activity.ComponentDialog
    public void setContentView(int v) {
        this.initializeViewTreeOwners();
        this.b().i(v);
    }

    @Override  // androidx.activity.ComponentDialog
    public void setContentView(View view0) {
        this.initializeViewTreeOwners();
        this.b().k(view0);
    }

    @Override  // androidx.activity.ComponentDialog
    public void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initializeViewTreeOwners();
        this.b().l(view0, viewGroup$LayoutParams0);
    }

    @Override  // android.app.Dialog
    public void setTitle(int v) {
        super.setTitle(v);
        this.b().m(this.getContext().getString(v));
    }

    @Override  // android.app.Dialog
    public void setTitle(CharSequence charSequence0) {
        super.setTitle(charSequence0);
        this.b().m(charSequence0);
    }
}

