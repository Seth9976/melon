package cc;

import Cb.j;
import Sb.b;
import Tf.v;
import U4.F;
import Ub.q;
import ac.A;
import ac.z;
import android.content.Context;
import android.net.Uri;
import b3.E;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationScheme;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.Ga;
import k8.t;
import va.e0;
import va.o;

public final class c {
    public final Context a;
    public final Ga b;
    public final LogU c;

    public c(Context context0, Ga ga0, q q0) {
        kotlin.jvm.internal.q.g(context0, "context");
        kotlin.jvm.internal.q.g(q0, "playbackManager");
        super();
        this.a = context0;
        this.b = ga0;
        this.c = Companion.create$default(LogU.Companion, "LiveStreamingHelper", false, Category.Playback, 2, null);
    }

    public final Object a(String s, String s1, oe.c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = this.b.h(s, s1, a0);
                if(object0 == a1) {
                    return a1;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Notification httpResponse$Notification0 = ((A)object0).a;
        if(httpResponse$Notification0 != null) {
            LogConstantsKt.infoOnlyDebugMode(this.c, "handleNotificationIfNeeded() notification: " + httpResponse$Notification0);
            MelonAppBase.Companion.getClass();
            boolean z = t.a().isAppForeground();
            String s2 = v.p0(httpResponse$Notification0.message, "<br />", "\n");
            if(z) {
                j.b(httpResponse$Notification0, false, 3);
            }
            else {
                LogU.debug$default(this.c, "handleNotificationIfNeeded() actionType: " + httpResponse$Notification0.actionType + ", message: " + s2, null, false, 6, null);
                String s3 = httpResponse$Notification0.getRedirectScheme();
                if(s3 != null && s3.length() != 0) {
                    EventNotificationScheme eventNotificationScheme0 = new EventNotificationScheme();
                    eventNotificationScheme0.scheme = s3;
                    EventBusHelper.post(eventNotificationScheme0);
                }
                ToastManager.show(s2);
            }
            throw new Yb.n(s2);
        }
        if(((A)object0).b.length() != 0) {
            return object0;
        }
        kotlin.jvm.internal.q.f("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.", "getString(...)");
        throw new b("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.", new IllegalStateException("getLiveStreamingInfoWithCheck() Invalid live streaming info"));
    }

    public final Object b(E e0, oe.c c0) {
        cc.b b0;
        if(c0 instanceof cc.b) {
            b0 = (cc.b)c0;
            int v = b0.D;
            if((v & 0x80000000) == 0) {
                b0 = new cc.b(this, c0);
            }
            else {
                b0.D = v ^ 0x80000000;
            }
        }
        else {
            b0 = new cc.b(this, c0);
        }
        Object object0 = b0.w;
        ne.a a0 = ne.a.a;
        switch(b0.D) {
            case 0: {
                n.D(object0);
                String s = u.v(((e0)o.a()).j());
                String s1 = F.E(e0).getQueryParameter("liveSeq");
                if(s1 == null) {
                    s1 = "";
                }
                b0.r = e0;
                b0.D = 1;
                object0 = this.a(s, s1, b0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                e0 = b0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogConstantsKt.debugOnlyDebugMode(this.c, "getMediaItemSource() info: " + ((A)object0));
        Uri uri0 = Uri.parse(((A)object0).b);
        kotlin.jvm.internal.q.f(uri0, "parse(...)");
        b9.a a1 = new b9.a(((A)object0), 3);
        z z0 = new z(((A)object0).c, a1, "", -1);
        return new ac.q(e0, uri0, ac.u.a, z0, 16);
    }
}

