package E9;

import Ac.X3;
import B9.g;
import I7.n;
import I7.o;
import M6.u;
import X2.p;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.K;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.o0;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.widget.e;
import androidx.drawerlayout.widget.DrawerLayout.LayoutParams;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.session.legacy.z;
import androidx.viewpager.widget.ViewPager;
import com.gaa.sdk.iap.d;
import com.gaa.sdk.iap.i;
import com.gaa.sdk.iap.j;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.iloen.melon.custom.NumberPicker;
import com.iloen.melon.custom.RepeatingImageButton;
import com.inisoft.media.b;
import e3.m;
import h9.f;
import i.n.i.b.a.s.e.hb;
import i.n.i.b.a.s.e.u8;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import kotlin.jvm.internal.r;
import l4.F;
import we.a;
import z7.c;

public final class t implements Runnable {
    public final int a;
    public final Object b;

    public t(j j0, X3 x30) {
        this.a = 12;
        super();
        this.b = x30;
    }

    public t(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    public t(a a0) {
        this.a = 24;
        super();
        this.b = (r)a0;
    }

    @Override
    public final void run() {
        Object object0;
        int v11;
        View view0;
        int v = 3;
        int v1 = 0;
        switch(this.a) {
            case 0: {
                ((b)this.b).a.removeCallbacks(((b)this.b).b);
                return;
            }
            case 1: {
                ((Carousel)this.b).r.setProgress(0.0f);
                ((Carousel)this.b).getClass();
                ((Carousel)this.b).getClass();
                throw null;
            }
            case 2: {
                n n0 = (n)this.b;
                synchronized(n0) {
                    boolean z = n0.a();
                    if(z) {
                        __monitor_enter(n0);
                        goto label_20;
                    }
                    goto label_22;
                }
            label_20:
                n0.b = true;
                __monitor_exit(n0);
            label_22:
                __monitor_exit(n0);
                if(z) {
                    o o0 = n0.q.c();
                    if(new Date(n0.p.currentTimeMillis()).before(o0.b)) {
                        n0.h();
                        return;
                    }
                    Task task0 = ((c)n0.k).d();
                    Task task1 = ((c)n0.k).c();
                    Task task2 = Tasks.whenAllComplete(new Task[]{task0, task1});
                    H7.c c0 = new H7.c(n0, task0, task1, 1);
                    Task task3 = task2.continueWithTask(n0.h, c0);
                    Task task4 = Tasks.whenAllComplete(new Task[]{task3});
                    g g0 = new g(9, n0, task3);
                    task4.continueWith(n0.h, g0);
                }
                return;
            }
            case 3: {
                try {
                    while(true) {
                        Socket socket0 = ((K8.b)this.b).a.accept();
                        new u(((K8.b)this.b), socket0);
                    }
                }
                catch(IOException unused_ex) {
                    return;
                }
            }
            case 4: {
                ((Q0.u)this.b).removeCallbacks(this);
                MotionEvent motionEvent0 = ((Q0.u)this.b).N0;
                if(motionEvent0 != null) {
                    if(motionEvent0.getToolType(0) == 3) {
                        v1 = 1;
                    }
                    int v2 = motionEvent0.getActionMasked();
                    if(v1 != 0) {
                        if(v2 != 1 && v2 != 10) {
                            ((Q0.u)this.b).J(motionEvent0, (v2 == 7 || v2 == 9 ? 7 : 2), ((Q0.u)this.b).O0, false);
                            return;
                        }
                    }
                    else if(v2 != 1) {
                        ((Q0.u)this.b).J(motionEvent0, (v2 == 7 || v2 == 9 ? 7 : 2), ((Q0.u)this.b).O0, false);
                    }
                }
                return;
            }
            case 5: {
                IBinder iBinder0 = ((p)((X2.a)this.b).d).a.getBinder();
                ((X2.a)this.b).f.e.remove(iBinder0);
                return;
            }
            case 6: {
                Window.Callback window$Callback0 = ((K)this.b).b;
                Menu menu0 = ((K)this.b).u();
                MenuBuilder menuBuilder0 = menu0 instanceof MenuBuilder ? ((MenuBuilder)menu0) : null;
                if(menuBuilder0 != null) {
                    menuBuilder0.y();
                }
                try {
                    menu0.clear();
                    if(!window$Callback0.onCreatePanelMenu(0, menu0) || !window$Callback0.onPreparePanel(0, null, menu0)) {
                        menu0.clear();
                    }
                }
                finally {
                    if(menuBuilder0 != null) {
                        menuBuilder0.x();
                    }
                }
                return;
            }
            case 7: {
                e e0 = (e)this.b;
                o0 o00 = e0.c;
                androidx.core.widget.a a0 = e0.a;
                if(e0.o) {
                    if(e0.m) {
                        e0.m = false;
                        long v4 = AnimationUtils.currentAnimationTimeMillis();
                        a0.e = v4;
                        a0.g = -1L;
                        a0.f = v4;
                        a0.h = 0.5f;
                    }
                    if(a0.g > 0L && AnimationUtils.currentAnimationTimeMillis() > a0.g + ((long)a0.i) || !e0.e()) {
                        e0.o = false;
                        return;
                    }
                    if(e0.n) {
                        e0.n = false;
                        long v5 = SystemClock.uptimeMillis();
                        MotionEvent motionEvent1 = MotionEvent.obtain(v5, v5, 3, 0.0f, 0.0f, 0);
                        o00.onTouchEvent(motionEvent1);
                        motionEvent1.recycle();
                    }
                    if(a0.f == 0L) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long v6 = AnimationUtils.currentAnimationTimeMillis();
                    float f = a0.a(v6);
                    long v7 = v6 - a0.f;
                    a0.f = v6;
                    e0.w.scrollListBy(((int)(((float)v7) * (f * 4.0f + -4.0f * f * f) * a0.d)));
                    o00.postOnAnimation(this);
                    return;
                }
                return;
            }
            case 8: {
                synchronized(((androidx.lifecycle.K)this.b).a) {
                    object0 = ((androidx.lifecycle.K)this.b).f;
                    ((androidx.lifecycle.K)this.b).f = androidx.lifecycle.K.k;
                }
                ((androidx.lifecycle.K)this.b).setValue(object0);
                return;
            }
            case 9: {
                ((androidx.media3.session.legacy.n)this.b).e.getClass();
                IBinder iBinder1 = ((z)((androidx.media3.session.legacy.n)this.b).e).a.getBinder();
                ((androidx.media3.session.legacy.n)this.b).g.e.remove(iBinder1);
                return;
            }
            case 10: {
                ((ViewPager)this.b).setScrollState(0);
                ((ViewPager)this.b).populate();
                return;
            }
            case 11: {
                ((com.gaa.sdk.auth.c)this.b).c.a = 0;
                ((com.gaa.sdk.auth.c)this.b).c.c = null;
                return;
            }
            case 12: {
                d d0 = B.a.Z(1009);
                ((X3)this.b).e(d0, null);
                return;
            }
            case 13: {
                ((i)this.b).d.a = 0;
                ((i)this.b).d.f = null;
                d d1 = B.a.Z(1009);
                ((i)this.b).a(d1);
                return;
            }
            case 14: {
                CheckableImageButton checkableImageButton0 = ((TextInputLayout)this.b).c.g;
                checkableImageButton0.performClick();
                checkableImageButton0.jumpDrawablesToCurrentState();
                return;
            }
            case 15: {
                ((NumberPicker)this.b).performLongClick();
                return;
            }
            case 16: {
                RepeatingImageButton repeatingImageButton0 = (RepeatingImageButton)this.b;
                repeatingImageButton0.a(false);
                if(repeatingImageButton0.h && repeatingImageButton0.isPressed()) {
                    repeatingImageButton0.postDelayed(this, repeatingImageButton0.g);
                }
                return;
            }
            case 17: {
                f9.i i0 = (f9.i)this.b;
                try {
                    i0.d.f(i0.e, i0.f, true, i0.b);
                    i0.c = false;
                }
                catch(Exception exception0) {
                    f.b("CacheServerBackendHandler", "channelInactive() - exception : " + exception0);
                    exception0.printStackTrace();
                }
                return;
            }
            case 18: {
                u8 u80 = (u8)this.b;
                if(!u8.b(u80)) {
                    Handler handler0 = u80.k;
                    handler0.getClass();
                    handler0.postDelayed(u80.n, 100L);
                }
                return;
            }
            case 19: {
                ((hb)this.b).n();
                return;
            }
            case 20: {
                A6.i i1 = (A6.i)this.b;
                i1.b = false;
                BottomSheetBehavior bottomSheetBehavior0 = (BottomSheetBehavior)i1.e;
                if(bottomSheetBehavior0.i0 != null && bottomSheetBehavior0.i0.h()) {
                    i1.a(i1.c);
                    return;
                }
                if(bottomSheetBehavior0.h0 == 2) {
                    bottomSheetBehavior0.N(i1.c);
                }
                return;
            }
            case 21: {
                ((j2.c)this.b).r(0);
                return;
            }
            case 22: {
                ((F)this.b).h();
                return;
            }
            case 23: {
                ((m)this.b).f();
                return;
            }
            case 24: {
                ((a)(((r)this.b))).invoke();
                return;
            }
            case 25: {
                androidx.drawerlayout.widget.b b0 = (androidx.drawerlayout.widget.b)this.b;
                DrawerLayout drawerLayout0 = b0.i;
                int v9 = b0.g.o;
                int v10 = b0.f;
                if(v10 == 3) {
                    view0 = drawerLayout0.d(3);
                    v11 = (view0 == null ? 0 : -view0.getWidth()) + v9;
                }
                else {
                    view0 = drawerLayout0.d(5);
                    v11 = drawerLayout0.getWidth() - v9;
                }
                if(view0 != null && (v10 == 3 && view0.getLeft() < v11 || v10 != 3 && view0.getLeft() > v11) && drawerLayout0.f(view0) == 0) {
                    LayoutParams drawerLayout$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    b0.g.u(view0, v11, view0.getTop());
                    drawerLayout$LayoutParams0.c = true;
                    drawerLayout0.invalidate();
                    if(v10 == 3) {
                        v = 5;
                    }
                    View view1 = drawerLayout0.d(v);
                    if(view1 != null) {
                        drawerLayout0.b(view1, true);
                    }
                    if(!drawerLayout0.B) {
                        long v12 = SystemClock.uptimeMillis();
                        MotionEvent motionEvent2 = MotionEvent.obtain(v12, v12, 3, 0.0f, 0.0f, 0);
                        int v13 = drawerLayout0.getChildCount();
                        while(v1 < v13) {
                            drawerLayout0.getChildAt(v1).dispatchTouchEvent(motionEvent2);
                            ++v1;
                        }
                        motionEvent2.recycle();
                        drawerLayout0.B = true;
                    }
                }
                return;
            }
            default: {
                ((w3.i)this.b).onLoaderReleased();
            }
        }
    }
}

