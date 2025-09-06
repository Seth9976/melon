package androidx.mediarouter.app;

import De.I;
import E9.h;
import P1.b;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.View.MeasureSpec;
import android.view.View;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.l1;
import androidx.core.widget.l;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import c2.W;
import d5.w;
import l4.G;
import l4.O;
import l4.Q;
import l4.T;

public class MediaRouteButton extends View {
    public static final int[] B;
    public final Q a;
    public final D b;
    public G c;
    public s d;
    public boolean e;
    public boolean f;
    public a g;
    public Drawable h;
    public int i;
    public int j;
    public int k;
    public final ColorStateList l;
    public final int m;
    public final int n;
    public boolean o;
    public static final SparseArray r;
    public static final int[] w;

    static {
        MediaRouteButton.r = new SparseArray(2);
        MediaRouteButton.w = new int[]{0x10100A0};
        MediaRouteButton.B = new int[]{0x101009F};
    }

    public MediaRouteButton(Context context0) {
        this(context0, null);
    }

    public MediaRouteButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04042E);  // attr:mediaRouteButtonStyle
    }

    public MediaRouteButton(Context context0, AttributeSet attributeSet0, int v) {
        ContextThemeWrapper contextThemeWrapper0 = new ContextThemeWrapper(context0, I.J(context0));
        int v1 = I.L(contextThemeWrapper0, 0x7F04043A);  // attr:mediaRouteTheme
        if(v1 != 0) {
            contextThemeWrapper0 = new ContextThemeWrapper(contextThemeWrapper0, v1);
        }
        super(contextThemeWrapper0, attributeSet0, v);
        this.c = G.c;
        this.d = s.a;
        Context context1 = this.getContext();
        TypedArray typedArray0 = context1.obtainStyledAttributes(attributeSet0, k4.a.a, v, 0);
        W.n(this, context1, k4.a.a, attributeSet0, typedArray0, v);
        if(this.isInEditMode()) {
            this.a = null;
            this.b = null;
            this.h = w.B(context1, typedArray0.getResourceId(3, 0));
            return;
        }
        this.a = Q.d(context1);
        this.b = new D(this, 1);
        O o0 = Q.g();
        int v2 = o0.d() ? 0 : o0.i;
        this.k = v2;
        this.j = v2;
        this.l = typedArray0.getColorStateList(4);
        this.m = typedArray0.getDimensionPixelSize(0, 0);
        this.n = typedArray0.getDimensionPixelSize(1, 0);
        int v3 = typedArray0.getResourceId(3, 0);
        this.i = typedArray0.getResourceId(2, 0);
        typedArray0.recycle();
        int v4 = this.i;
        SparseArray sparseArray0 = MediaRouteButton.r;
        if(v4 != 0) {
            Drawable.ConstantState drawable$ConstantState0 = (Drawable.ConstantState)sparseArray0.get(v4);
            if(drawable$ConstantState0 != null) {
                this.setRemoteIndicatorDrawable(drawable$ConstantState0.newDrawable());
            }
        }
        if(this.h == null) {
            if(v3 == 0) {
                this.a();
            }
            else {
                Drawable.ConstantState drawable$ConstantState1 = (Drawable.ConstantState)sparseArray0.get(v3);
                if(drawable$ConstantState1 == null) {
                    a a0 = new a(this, v3, this.getContext());
                    this.g = a0;
                    a0.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
                else {
                    this.setRemoteIndicatorDrawableInternal(drawable$ConstantState1.newDrawable());
                }
            }
        }
        this.e();
        this.setClickable(true);
    }

    public final void a() {
        if(this.i > 0) {
            a a0 = this.g;
            if(a0 != null) {
                a0.cancel(false);
            }
            a a1 = new a(this, this.i, this.getContext());
            this.g = a1;
            this.i = 0;
            a1.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public final void b() {
        this.a.getClass();
        O o0 = Q.g();
        int v = o0.d() ? 0 : o0.i;
        if(this.k != v) {
            this.k = v;
            this.e();
            this.refreshDrawableState();
        }
        if(v == 1) {
            this.a();
        }
    }

    public final boolean c() {
        boolean z;
        if(!this.e) {
            return false;
        }
        this.a.getClass();
        Q.b();
        T t0 = Q.c().v;
        if(t0 != null && t0.b && (Q.c == null ? false : Q.c().h())) {
            Context context0 = this.getContext();
            int v = Build.VERSION.SDK_INT;
            if(v >= 34) {
                z = l.p(b.f(context0));
            }
            else if(v >= 0x1F) {
                Intent intent0 = new Intent().setAction("com.android.systemui.action.LAUNCH_MEDIA_OUTPUT_DIALOG").setPackage("com.android.systemui").putExtra("package_name", "com.iloen.melon");
                for(Object object0: context0.getPackageManager().queryBroadcastReceivers(intent0, 0)) {
                    ActivityInfo activityInfo0 = ((ResolveInfo)object0).activityInfo;
                    if(activityInfo0 == null || (activityInfo0.applicationInfo == null || (activityInfo0.applicationInfo.flags & 0x81) == 0)) {
                        continue;
                    }
                    context0.sendBroadcast(intent0);
                    z = true;
                    goto label_27;
                }
                z = h.V(context0);
            }
            else {
                z = v == 30 ? h.V(context0) : false;
            }
        label_27:
            if(z) {
                return true;
            }
            if(context0.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                int v1 = 0;
                Intent intent1 = new Intent("android.settings.BLUETOOTH_SETTINGS").addFlags(0x10008000).putExtra("EXTRA_CONNECTION_ONLY", true).putExtra("android.bluetooth.devicepicker.extra.FILTER_TYPE", 1);
                AudioDeviceInfo[] arr_audioDeviceInfo = ((AudioManager)context0.getSystemService(AudioManager.class)).getDevices(2);
                for(int v2 = 0; v2 < arr_audioDeviceInfo.length; ++v2) {
                    int v3 = arr_audioDeviceInfo[v2].getType();
                    if(v3 == 3 || v3 == 4 || v3 == 5 || v3 == 6 || v3 == 8 || (v3 == 11 || v3 == 30) || (v3 == 22 || v3 == 23 || v3 == 26 || v3 == 27)) {
                        v1 = 1;
                        break;
                    }
                }
                Intent intent2 = intent1.putExtra("EXTRA_CLOSE_ON_CONNECT", ((boolean)(v1 ^ 1)));
                for(Object object1: context0.getPackageManager().queryIntentActivities(intent2, 0)) {
                    ActivityInfo activityInfo1 = ((ResolveInfo)object1).activityInfo;
                    if(activityInfo1 != null) {
                        ApplicationInfo applicationInfo0 = activityInfo1.applicationInfo;
                        if(applicationInfo0 != null && (applicationInfo0.flags & 0x81) != 0) {
                            intent2.setPackage(applicationInfo0.packageName);
                            context0.startActivity(intent2);
                            return true;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                return this.d();
            }
            return this.d();
        }
        return this.d();
    }

    public final boolean d() {
        l0 l00 = this.getFragmentManager();
        if(l00 == null) {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        this.a.getClass();
        if(Q.g().d()) {
            if(l00.E("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                return false;
            }
            this.d.getClass();
            d d0 = new d();
            G g0 = this.c;
            if(g0 == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            d0.m();
            if(!d0.c.equals(g0)) {
                d0.c = g0;
                Bundle bundle0 = d0.getArguments() == null ? new Bundle() : d0.getArguments();
                bundle0.putBundle("selector", g0.a);
                d0.setArguments(bundle0);
                AppCompatDialog appCompatDialog0 = d0.b;
                if(appCompatDialog0 != null) {
                    if(d0.a) {
                        ((MediaRouteDynamicChooserDialog)appCompatDialog0).e(g0);
                    }
                    else {
                        ((MediaRouteChooserDialog)appCompatDialog0).f(g0);
                    }
                }
            }
            androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
            a0.e(0, d0, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment", 1);
            a0.l(true, true);
            return true;
        }
        if(l00.E("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
            Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
            return false;
        }
        this.d.getClass();
        r r0 = new r();
        G g1 = this.c;
        if(g1 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if(r0.c == null) {
            Bundle bundle1 = r0.getArguments();
            if(bundle1 != null) {
                r0.c = G.b(bundle1.getBundle("selector"));
            }
            if(r0.c == null) {
                r0.c = G.c;
            }
        }
        if(!r0.c.equals(g1)) {
            r0.c = g1;
            Bundle bundle2 = r0.getArguments() == null ? new Bundle() : r0.getArguments();
            bundle2.putBundle("selector", g1.a);
            r0.setArguments(bundle2);
            AppCompatDialog appCompatDialog1 = r0.b;
            if(appCompatDialog1 != null && r0.a) {
                ((MediaRouteDynamicControllerDialog)appCompatDialog1).g(g1);
            }
        }
        androidx.fragment.app.a a1 = new androidx.fragment.app.a(l00);
        a1.e(0, r0, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment", 1);
        a1.l(true, true);
        return true;
    }

    @Override  // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        if(this.h != null) {
            int[] arr_v = this.getDrawableState();
            this.h.setState(arr_v);
            if(this.h.getCurrent() instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable0 = (AnimationDrawable)this.h.getCurrent();
                int v = this.k;
                if(v == 1 || this.j != v) {
                    if(!animationDrawable0.isRunning()) {
                        animationDrawable0.start();
                    }
                }
                else if(v == 2 && !animationDrawable0.isRunning()) {
                    animationDrawable0.selectDrawable(animationDrawable0.getNumberOfFrames() - 1);
                }
            }
            this.invalidate();
        }
        this.j = this.k;
    }

    public final void e() {
        int v;
        switch(this.k) {
            case 1: {
                v = 0x7F1306B2;  // string:mr_cast_button_connecting "Cast. Connecting"
                break;
            }
            case 2: {
                v = 0x7F1306B1;  // string:mr_cast_button_connected "Cast. Connected"
                break;
            }
            default: {
                v = 0x7F1306B3;  // string:mr_cast_button_disconnected "Cast. Disconnected"
            }
        }
        String s = this.getContext().getString(v);
        this.setContentDescription(s);
        if(!this.o || TextUtils.isEmpty(s)) {
            s = null;
        }
        l1.a(this, s);
    }

    private Activity getActivity() {
        for(Context context0 = this.getContext(); context0 instanceof ContextWrapper; context0 = ((ContextWrapper)context0).getBaseContext()) {
            if(context0 instanceof Activity) {
                return (Activity)context0;
            }
        }
        return null;
    }

    public s getDialogFactory() {
        return this.d;
    }

    private l0 getFragmentManager() {
        Activity activity0 = this.getActivity();
        return activity0 instanceof FragmentActivity ? ((FragmentActivity)activity0).getSupportFragmentManager() : null;
    }

    public G getRouteSelector() {
        return this.c;
    }

    @Override  // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable0 = this.h;
        if(drawable0 != null) {
            drawable0.jumpToCurrentState();
        }
    }

    @Override  // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.isInEditMode()) {
            return;
        }
        this.e = true;
        if(!this.c.d()) {
            this.a.a(this.c, this.b, 0);
        }
        this.b();
    }

    @Override  // android.view.View
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 1);
        if(this.a != null && !this.f) {
            switch(this.k) {
                case 1: {
                    View.mergeDrawableStates(arr_v, MediaRouteButton.B);
                    return arr_v;
                }
                case 2: {
                    View.mergeDrawableStates(arr_v, MediaRouteButton.w);
                    return arr_v;
                }
                default: {
                    return arr_v;
                }
            }
        }
        return arr_v;
    }

    @Override  // android.view.View
    public final void onDetachedFromWindow() {
        if(!this.isInEditMode()) {
            this.e = false;
            if(!this.c.d()) {
                this.a.j(this.b);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        if(this.h != null) {
            int v = this.getPaddingLeft();
            int v1 = this.getWidth();
            int v2 = this.getPaddingRight();
            int v3 = this.getPaddingTop();
            int v4 = this.getHeight();
            int v5 = this.getPaddingBottom();
            int v6 = this.h.getIntrinsicWidth();
            int v7 = this.h.getIntrinsicHeight();
            int v8 = (v1 - v2 - v - v6) / 2 + v;
            int v9 = (v4 - v5 - v3 - v7) / 2 + v3;
            this.h.setBounds(v8, v9, v6 + v8, v7 + v9);
            this.h.draw(canvas0);
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v9;
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = View.MeasureSpec.getSize(v1);
        int v4 = View.MeasureSpec.getMode(v);
        int v5 = View.MeasureSpec.getMode(v1);
        Drawable drawable0 = this.h;
        int v6 = 0;
        if(drawable0 == null) {
            v9 = 0;
        }
        else {
            int v7 = drawable0.getIntrinsicWidth();
            int v8 = this.getPaddingLeft();
            v9 = this.getPaddingRight() + (v8 + v7);
        }
        int v10 = Math.max(this.m, v9);
        Drawable drawable1 = this.h;
        if(drawable1 != null) {
            int v11 = drawable1.getIntrinsicHeight();
            int v12 = this.getPaddingTop();
            v6 = this.getPaddingBottom() + (v12 + v11);
        }
        int v13 = Math.max(this.n, v6);
        if(v4 == 0x80000000) {
            v2 = Math.min(v2, v10);
        }
        else if(v4 != 0x40000000) {
            v2 = v10;
        }
        if(v5 == 0x80000000) {
            v3 = Math.min(v3, v13);
        }
        else if(v5 != 0x40000000) {
            v3 = v13;
        }
        this.setMeasuredDimension(v2, v3);
    }

    @Override  // android.view.View
    public final boolean performClick() {
        boolean z = super.performClick();
        if(!z) {
            this.playSoundEffect(0);
        }
        this.a();
        return this.c() || z;
    }

    @Deprecated
    public void setAlwaysVisible(boolean z) {
    }

    public void setCheatSheetEnabled(boolean z) {
        if(z != this.o) {
            this.o = z;
            this.e();
        }
    }

    public void setDialogFactory(s s0) {
        if(s0 == null) {
            throw new IllegalArgumentException("factory must not be null");
        }
        this.d = s0;
    }

    public void setRemoteIndicatorDrawable(Drawable drawable0) {
        this.i = 0;
        this.setRemoteIndicatorDrawableInternal(drawable0);
    }

    public void setRemoteIndicatorDrawableInternal(Drawable drawable0) {
        a a0 = this.g;
        if(a0 != null) {
            a0.cancel(false);
        }
        Drawable drawable1 = this.h;
        if(drawable1 != null) {
            drawable1.setCallback(null);
            this.unscheduleDrawable(this.h);
        }
        if(drawable0 != null) {
            ColorStateList colorStateList0 = this.l;
            if(colorStateList0 != null) {
                drawable0 = drawable0.mutate();
                drawable0.setTintList(colorStateList0);
            }
            drawable0.setCallback(this);
            drawable0.setState(this.getDrawableState());
            drawable0.setVisible(this.getVisibility() == 0, false);
        }
        this.h = drawable0;
        this.refreshDrawableState();
    }

    public void setRouteSelector(G g0) {
        if(g0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if(!this.c.equals(g0)) {
            if(this.e) {
                boolean z = this.c.d();
                D d0 = this.b;
                Q q0 = this.a;
                if(!z) {
                    q0.j(d0);
                }
                if(!g0.d()) {
                    q0.a(g0, d0, 0);
                }
            }
            this.c = g0;
            this.b();
        }
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        Drawable drawable0 = this.h;
        if(drawable0 != null) {
            drawable0.setVisible(v == 0, false);
        }
    }

    @Override  // android.view.View
    public final boolean verifyDrawable(Drawable drawable0) {
        return super.verifyDrawable(drawable0) || drawable0 == this.h;
    }
}

