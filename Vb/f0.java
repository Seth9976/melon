package Vb;

import Nb.z0;
import Sb.a;
import Tf.v;
import U4.F;
import ac.q;
import ac.z;
import android.app.Service;
import b3.E;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.melon.playback.melon.model.PlaybackErrorReport;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import com.melon.playback.melon.streaming.tracker.RequestInfo;
import d5.e;
import dc.g;
import ie.H;
import ie.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.m;
import je.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class f0 extends i implements n {
    public final E B;
    public final z0 D;
    public final o0 r;
    public final a w;

    public f0(o0 o00, a a0, E e0, z0 z00, Continuation continuation0) {
        this.r = o00;
        this.w = a0;
        this.B = e0;
        this.D = z00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f0(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((f0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        RequestInfo requestInfo0;
        Object object1;
        d5.n.D(object0);
        Service service0 = this.r.j;
        E e0 = this.B;
        z z0 = ((q)this.r.J.get()).d;
        z0 z00 = this.D;
        a a0 = this.w;
        PlaybackErrorReport.Companion.getClass();
        kotlin.jvm.internal.q.g(service0, "context");
        kotlin.jvm.internal.q.g(e0, "mediaItem");
        kotlin.jvm.internal.q.g(z0, "streamingAnalytics");
        kotlin.jvm.internal.q.g(z00, "playerType");
        kotlin.jvm.internal.q.g(a0, "exception");
        kotlin.jvm.internal.q.f(e0.a, "mediaId");
        String s = F.Y(e0.a).c;
        CharSequence charSequence0 = (CharSequence)z0.b.invoke();
        if(charSequence0.length() == 0) {
            charSequence0 = "NONE";
        }
        boolean z1 = SystemSettingUtils.isPowerSaveMode(service0);
        boolean z2 = SystemSettingUtils.isIgnoringBatteryOptimizations(service0);
        boolean z3 = SystemSettingUtils.isBackgroundRestricted(service0);
        boolean z4 = SystemSettingUtils.isAvailableBackgroundData(service0);
        boolean z5 = SystemSettingUtils.areNotificationsEnabled(service0);
        String s1 = z00.a();
        String s2 = F.E(e0).toString();
        kotlin.jvm.internal.q.f(s2, "toString(...)");
        g.a.getClass();
        g.c.getClass();
        synchronized(((m)g.c.b)) {
            list0 = p.P0(((m)g.c.b));
        }
        Iterator iterator0 = list0.iterator();
    alab1:
        while(true) {
            do {
                do {
                label_35:
                    object1 = null;
                    if(!iterator0.hasNext()) {
                        goto label_48;
                    }
                    object1 = iterator0.next();
                    requestInfo0 = ((NetworkEvents)object1).getRequest();
                }
                while(requestInfo0 == null);
                Map map0 = requestInfo0.getParams();
            }
            while(map0 == null || map0.isEmpty());
            for(Object object2: map0.entrySet()) {
                if(v.j0(((String)((Map.Entry)object2).getKey()), "cId", true) && kotlin.jvm.internal.q.b(((String)((Map.Entry)object2).getValue()), s)) {
                    break alab1;
                }
            }
            goto label_35;
        label_48:
            break;
        }
        PlaybackErrorReport playbackErrorReport0 = new PlaybackErrorReport(z1, z2, z3, z4, z5, s, s1, s2, "Wifi", ((String)charSequence0), (((NetworkEvents)object1) == null ? new NetworkEvents(null, null, null, null, null, 0x1F, null) : ((NetworkEvents)object1)), a0.a());
        Object object3 = ((r)new e(8).c).getValue();
        kotlin.jvm.internal.q.f(object3, "getValue(...)");
        String s3 = ((com.google.gson.n)object3).l(playbackErrorReport0, PlaybackErrorReport.class);
        kotlin.jvm.internal.q.f(s3, "toJson(...)");
        LogU.error$default(this.r.e1(), "sendToRedash() " + s3, null, false, 6, null);
        Reporter reportService$Reporter0 = Reporter.createReporter(Type.PLAYER, LogLevel.ERROR);
        reportService$Reporter0.setMessage(s3);
        reportService$Reporter0.report();
        return H.a;
    }
}

