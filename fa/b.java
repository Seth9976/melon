package fa;

import Ba.k;
import Nb.I0;
import Nb.J0;
import Nb.K0;
import Nb.L0;
import Nb.M0;
import Va.a;
import ac.B;
import ac.j;
import ac.x;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.GetPathInfo;
import com.melon.net.res.StreamingPathRes;
import d5.n;
import ie.o;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.q;
import oe.c;

public final class b {
    public final k a;
    public final LogU b;

    public b(k k0) {
        this.a = k0;
        this.b = Companion.create$default(LogU.Companion, "DeliveryRepository", false, Category.Playback, 2, null);
    }

    public final Object a(a a0, Va.b b0, c c0) {
        Long long0;
        L0 l00;
        fa.a a1;
        if(c0 instanceof fa.a) {
            a1 = (fa.a)c0;
            int v = a1.E;
            if((v & 0x80000000) == 0) {
                a1 = new fa.a(this, c0);
            }
            else {
                a1.E = v ^ 0x80000000;
            }
        }
        else {
            a1 = new fa.a(this, c0);
        }
        Object object0 = a1.B;
        ne.a a2 = ne.a.a;
        switch(a1.E) {
            case 0: {
                n.D(object0);
                String s = a0.a;
                q.g(b0, "<this>");
                String s1 = b0.p;
                String s2 = b0.o;
                String s3 = b0.m;
                String s4 = b0.k;
                String s5 = b0.j;
                String s6 = b0.i;
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                linkedHashMap0.put("cpId", b0.a);
                linkedHashMap0.put("cpKey", b0.b);
                linkedHashMap0.put("cId", b0.c);
                linkedHashMap0.put("cType", b0.d);
                linkedHashMap0.put("metaType", b0.e);
                linkedHashMap0.put("sessionId", b0.f);
                String s7 = b0.g;
                if(s7.equals("Y")) {
                    linkedHashMap0.put("changeSt", s7);
                }
                linkedHashMap0.put("bitrate", b0.h);
                if(s6.length() > 0) {
                    linkedHashMap0.put("flacMetaType", s6);
                }
                if(s5.length() > 0) {
                    linkedHashMap0.put("modelName", s5);
                }
                if(s4.length() > 0) {
                    linkedHashMap0.put("deviceVersion", s4);
                }
                int v1 = b0.l;
                if(v1 > 0) {
                    linkedHashMap0.put("rt", String.valueOf(v1));
                }
                if(s3.equals("Y")) {
                    linkedHashMap0.put("hlsYn", s3);
                }
                linkedHashMap0.put("networkType", b0.n);
                if(s2.length() > 0) {
                    linkedHashMap0.put("spatialMetaType", s2);
                }
                if(s1.length() > 0) {
                    linkedHashMap0.put("mwYn", s1);
                }
                a1.r = a0;
                a1.w = b0;
                a1.E = 1;
                object0 = this.a.a(s, "Y", linkedHashMap0, a1);
                if(object0 == a2) {
                    return a2;
                }
                break;
            }
            case 1: {
                Va.b b1 = a1.w;
                a a3 = a1.r;
                n.D(object0);
                b0 = b1;
                a0 = a3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        com.iloen.melon.player.playlist.mixup.composables.c c1 = new com.iloen.melon.player.playlist.mixup.composables.c(a0, b0, ((StreamingPathRes)object0), 7);
        LogConstantsKt.buildDebug(this.b, true, c1);
        GetPathInfo getPathInfo0 = ((StreamingPathRes)object0).getResponse().getPathInfo();
        List list0 = ((StreamingPathRes)object0).getResponse().getContentsInfoList();
        Notification httpResponse$Notification0 = ((StreamingPathRes)object0).notification;
        q.g("", "name");
        if("PREMIUM".equals("")) {
            l00 = L0.b;
        }
        else if("MCACHE".equals("")) {
            l00 = K0.b;
        }
        else if("HTTP".equals("")) {
            l00 = J0.b;
        }
        else if("HLS".equals("")) {
            l00 = I0.b;
        }
        else {
            l00 = M0.b;
        }
        ac.k k0 = new ac.k("", "");
        j j0 = new j(b0.c, b0.d, (getPathInfo0.solTypeCode == null ? "" : getPathInfo0.solTypeCode), (getPathInfo0.solFileUpdtDate == null ? "" : getPathInfo0.solFileUpdtDate), (getPathInfo0.sol == null ? "" : getPathInfo0.sol));
        q.g("", "playTime");
        try {
            long0 = (long)(1000L * Long.parseLong(""));
        }
        catch(Throwable throwable0) {
            long0 = n.t(throwable0);
        }
        if(long0 instanceof o) {
            long0 = -1L;
        }
        return new B(httpResponse$Notification0, "", "", l00, k0, j0, "", "", long0.longValue(), "", "", getPathInfo0.isHttps(), ((StreamingPathRes)object0).getResponse().isFlacStok(), getPathInfo0.getPollingInterval(), "", list0, new x("", "", ""));
    }
}

