package com.iloen.melon.appwidget;

import Ma.m;
import U4.u;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import d5.n;
import k8.Y;
import k8.o;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import w8.f;
import w8.k0;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/appwidget/CoverWidgetProgressBarWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CoverWidgetProgressBarWorker extends CoroutineWorker {
    public CoverWidgetProgressBarWorker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0) {
        q.g(context0, "context");
        q.g(workerParameters0, "workerParams");
        super(context0, workerParameters0);
    }

    @Override  // androidx.work.CoroutineWorker
    public final Object c(Continuation continuation0) {
        Context context1;
        Ub.q q0;
        f f0;
        if(continuation0 instanceof f) {
            f0 = (f)continuation0;
            int v = f0.E;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, ((c)continuation0));
            }
            else {
                f0.E = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, ((c)continuation0));
        }
        Object object0 = f0.B;
        a a0 = a.a;
        switch(f0.E) {
            case 0: {
                n.D(object0);
                MelonAppBase.Companion.getClass();
                Context context0 = t.a().getContext();
                q.g(context0, "context");
                q0 = (Ub.q)((o)(((m)Y.e(context0, m.class)))).u.get();
                context1 = context0;
                break;
            }
            case 1: {
                q0 = f0.w;
                context1 = f0.r;
                n.D(object0);
                goto label_46;
            }
            case 2: {
                q0 = f0.w;
                context1 = f0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(q0.a().b) {
            DisplayManager displayManager0 = (DisplayManager)context1.getSystemService("display");
            if(displayManager0 != null) {
                Display[] arr_display = displayManager0.getDisplays("com.samsung.android.hardware.display.category.BUILTIN");
                q.d(arr_display);
                for(int v1 = 0; v1 < arr_display.length; ++v1) {
                    Display display0 = arr_display[v1];
                    if(display0 != null && display0.getDisplayId() == 1) {
                        if(display0.getState() == 2) {
                            k0 k00 = new k0();
                            Context context2 = Y.a(MelonAppBase.Companion);
                            f0.r = context1;
                            f0.w = q0;
                            f0.E = 1;
                            if(b.P(k00, context2, f0) != a0) {
                                break;
                            }
                            return a0;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        label_46:
            f0.r = context1;
            f0.w = q0;
            f0.E = 2;
            if(DelayKt.delay(10000L, f0) != a0) {
                continue;
            }
            return a0;
        }
        return u.a();
    }
}

