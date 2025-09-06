package com.iloen.melon.appwidget;

import D2.f;
import U4.u;
import android.content.Context;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.iloen.melon.MelonAppBase;
import d5.n;
import java.io.Serializable;
import java.util.Iterator;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import w8.c;
import w8.d;
import w8.e;
import w8.k0;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/appwidget/CoverWidgetMessageUpdateWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CoverWidgetMessageUpdateWorker extends CoroutineWorker {
    public CoverWidgetMessageUpdateWorker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0) {
        q.g(context0, "context");
        q.g(workerParameters0, "workerParams");
        super(context0, workerParameters0);
    }

    @Override  // androidx.work.CoroutineWorker
    public final Object c(Continuation continuation0) {
        f f0;
        int v2;
        int v1;
        Context context1;
        Iterator iterator0;
        Context context0;
        c c0;
        if(continuation0 instanceof c) {
            c0 = (c)continuation0;
            int v = c0.M;
            if((v & 0x80000000) == 0) {
                c0 = new c(this, ((oe.c)continuation0));
            }
            else {
                c0.M = v ^ 0x80000000;
            }
        }
        else {
            c0 = new c(this, ((oe.c)continuation0));
        }
        Serializable serializable0 = c0.G;
        a a0 = a.a;
    alab1:
        switch(c0.M) {
            case 0: {
                n.D(serializable0);
                context0 = Y.a(MelonAppBase.Companion);
                GlanceAppWidgetManager glanceAppWidgetManager0 = new GlanceAppWidgetManager(context0);
                c0.r = context0;
                c0.M = 1;
                serializable0 = glanceAppWidgetManager0.a(k0.class, c0);
                if(serializable0 != a0) {
                    iterator0 = ((Iterable)serializable0).iterator();
                    context1 = context0;
                    v1 = 0;
                    goto label_62;
                }
                break;
            }
            case 1: {
                context0 = c0.r;
                n.D(serializable0);
                iterator0 = ((Iterable)serializable0).iterator();
                context1 = context0;
                v1 = 0;
                goto label_62;
            }
            case 2: {
                v2 = c0.E;
                v1 = c0.D;
                f0 = c0.B;
                iterator0 = c0.w;
                context1 = c0.r;
                n.D(serializable0);
                goto label_74;
            }
            case 3: {
                v2 = c0.E;
                v1 = c0.D;
                f0 = c0.B;
                iterator0 = c0.w;
                context1 = c0.r;
                n.D(serializable0);
                goto label_82;
            }
            case 4: {
                v2 = c0.E;
                v1 = c0.D;
                f0 = c0.B;
                iterator0 = c0.w;
                context1 = c0.r;
                n.D(serializable0);
                goto label_89;
            }
            case 5: {
                v2 = c0.E;
                v1 = c0.D;
                f0 = c0.B;
                iterator0 = c0.w;
                context1 = c0.r;
                n.D(serializable0);
                goto label_98;
            }
            case 6: {
                int v3 = c0.D;
                Iterator iterator1 = c0.w;
                Context context2 = c0.r;
                n.D(serializable0);
                while(true) {
                    iterator0 = iterator1;
                    context1 = context2;
                    v1 = v3;
                label_62:
                    if(!iterator0.hasNext()) {
                        return u.a();
                    }
                    Object object0 = iterator0.next();
                    d d0 = new d(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    c0.r = context1;
                    c0.w = iterator0;
                    c0.B = (f)object0;
                    c0.D = v1;
                    c0.E = 0;
                    c0.M = 2;
                    if(d5.f.Y(context1, ((f)object0), d0, c0) == a0) {
                        break alab1;
                    }
                    f0 = (f)object0;
                    v2 = 0;
                label_74:
                    k0 k00 = new k0();
                    c0.r = context1;
                    c0.w = iterator0;
                    c0.B = f0;
                    c0.D = v1;
                    c0.E = v2;
                    c0.M = 3;
                    if(k00.g(context1, f0, c0) == a0) {
                        break alab1;
                    }
                label_82:
                    c0.r = context1;
                    c0.w = iterator0;
                    c0.B = f0;
                    c0.D = v1;
                    c0.E = v2;
                    c0.M = 4;
                    if(DelayKt.delay(5000L, c0) == a0) {
                        break alab1;
                    }
                label_89:
                    e e0 = new e(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    c0.r = context1;
                    c0.w = iterator0;
                    c0.B = f0;
                    c0.D = v1;
                    c0.E = v2;
                    c0.M = 5;
                    if(d5.f.Y(context1, f0, e0, c0) == a0) {
                        return a0;
                    }
                label_98:
                    v3 = v1;
                    iterator1 = iterator0;
                    context2 = context1;
                    k0 k01 = new k0();
                    c0.r = context2;
                    c0.w = iterator1;
                    c0.B = null;
                    c0.D = v3;
                    c0.E = v2;
                    c0.M = 6;
                    if(k01.g(context2, f0, c0) != a0) {
                        continue;
                    }
                    break alab1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

