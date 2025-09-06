package R8;

import Ba.j;
import H0.b;
import Hc.k;
import P0.d0;
import R6.c;
import android.content.Context;
import android.text.TextUtils;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.drm.MelonFile;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.OffPlayLoggingReq.ParamInfo;
import com.iloen.melon.net.v4x.request.OffPlayLoggingReq;
import com.iloen.melon.net.v4x.response.DcfExtensionBaseInfoRes;
import com.iloen.melon.net.v4x.response.DcfExtensionLoggingRes;
import com.iloen.melon.net.v4x.response.DcfExtensionPlayLoggingRes;
import com.iloen.melon.net.v4x.response.OffPlayLoggingRes;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.melon.data.database.entity.LocalPlaybackLogEntity;
import com.melon.data.database.entity.PremiumOffPlayLogEntity;
import d3.g;
import d5.n;
import e1.u;
import ie.H;
import ie.r;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import je.p;
import k8.Y;
import k8.o;
import k8.t;
import kotlin.jvm.internal.q;
import ne.a;
import rb.i;
import tg.Q;
import va.e0;
import z9.F;

public final class l {
    public final r a;
    public final r b;
    public final Context c;
    public CollectionRulesDcf d;
    public CollectionRulesDcf e;
    public static final c f;
    public static final r g;

    static {
        l.f = new c(2);
        l.g = g.Q(new k(21));
    }

    public l() {
        this.a = g.Q(new k(22));
        this.b = g.Q(new k(23));
        this.c = Y.a(MelonAppBase.Companion);
    }

    public final CollectionRulesDcf a(CType cType0) {
        q.g(cType0, "ctype");
        LogU.Companion.d("CollectionRulesManager", "getCollectionRulesDcf() cType: " + cType0);
        return q.b(CType.SONG, cType0) ? this.d : this.e;
    }

    public final Object b(oe.c c0) {
        int v3;
        int v2;
        int v1;
        List list0;
        Q q0;
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.I;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.I = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Object object0 = e0.E;
        a a0 = a.a;
        r r0 = this.a;
        H h0 = H.a;
    alab1:
        switch(e0.I) {
            case 0: {
                n.D(object0);
                LogU.Companion.d("CollectionRulesManager", "processBunchOfDbPlaybackLogs() ");
                cb.g g0 = (cb.g)r0.getValue();
                e0.I = 1;
                object0 = g0.c(50, e0);
                if(object0 != a0) {
                    goto label_23;
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_23:
                if(((List)object0).isEmpty()) {
                    LogU.Companion.d("CollectionRulesManager", "processBunchOfDbPlaybackLogs() entityList is empty");
                    return h0;
                }
                ArrayList arrayList0 = new ArrayList();
                StringBuilder stringBuilder0 = new StringBuilder();
                StringBuilder stringBuilder1 = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                StringBuilder stringBuilder3 = new StringBuilder();
                StringBuilder stringBuilder4 = new StringBuilder();
                SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyyMMDDHHmmss");
                for(Object object1: ((List)object0)) {
                    arrayList0.add(new Integer(((LocalPlaybackLogEntity)object1).getUid()));
                    stringBuilder0.append("");
                    stringBuilder1.append("");
                    stringBuilder2.append("");
                    stringBuilder3.append(simpleDateFormat0.format(new Date(((LocalPlaybackLogEntity)object1).getTimestamp())));
                    switch(FilenameUtils.getFileType("")) {
                        case 0x102: {
                            stringBuilder4.append("MP3");
                            break;
                        }
                        case 0x202: {
                            stringBuilder4.append("FLAC");
                            break;
                        }
                        case 0x402: {
                            stringBuilder4.append("DCF");
                            break;
                        }
                        default: {
                            b.w("processBunchOfDbPlaybackLogs() invalid fileType : ", "", LogU.Companion, "CollectionRulesManager");
                            continue;
                        }
                    }
                    stringBuilder0.append(",");
                    stringBuilder1.append(",");
                    stringBuilder2.append(",");
                    stringBuilder3.append(",");
                    stringBuilder4.append(",");
                }
                stringBuilder0.setLength((stringBuilder0.length() <= 0 ? 0 : stringBuilder0.length() - 1));
                stringBuilder1.setLength((stringBuilder1.length() <= 0 ? 0 : stringBuilder1.length() - 1));
                stringBuilder2.setLength((stringBuilder2.length() <= 0 ? 0 : stringBuilder2.length() - 1));
                stringBuilder3.setLength((stringBuilder3.length() <= 0 ? 0 : stringBuilder3.length() - 1));
                stringBuilder4.setLength((stringBuilder4.length() <= 0 ? 0 : stringBuilder4.length() - 1));
                MelonAppBase.Companion.getClass();
                j j0 = (j)((o)(((Ma.l)com.google.firebase.b.B(t.a().getContext(), Ma.l.class)))).K.get();
                DcfExtensionPlayLoggingRes dcfExtensionPlayLoggingRes0 = null;
                try {
                    String s = stringBuilder1.toString();
                    q.f(s, "toString(...)");
                    String s1 = stringBuilder0.toString();
                    q.f(s1, "toString(...)");
                    String s2 = stringBuilder2.toString();
                    q.f(s2, "toString(...)");
                    String s3 = stringBuilder3.toString();
                    q.f(s3, "toString(...)");
                    String s4 = stringBuilder4.toString();
                    q.f(s4, "toString(...)");
                    q0 = j0.a(s, s1, s2, s3, s4, u.v(((e0)va.o.a()).j())).execute();
                }
                catch(Exception exception0) {
                    exception0.printStackTrace();
                    q0 = null;
                }
                if(q0 != null) {
                    dcfExtensionPlayLoggingRes0 = (DcfExtensionPlayLoggingRes)q0.b;
                }
                if(dcfExtensionPlayLoggingRes0 == null) {
                    throw new Exception(MelonError.SERVER_RESPONSE_ERROR);
                }
                list0 = p.Q0(arrayList0);
                v1 = 0;
                v2 = 500;
                v3 = 0;
                goto label_93;
            }
            case 2: {
                v3 = e0.D;
                v1 = e0.B;
                v2 = e0.w;
                list0 = e0.r;
                n.D(object0);
                while(true) {
                    Y.t("processBunchOfDbPlaybackLogs() countAfterDeletion : ", ((Number)object0).intValue(), LogU.Companion, "CollectionRulesManager");
                label_93:
                    if(list0.isEmpty()) {
                        return h0;
                    }
                    List list1 = p.K0(Math.min(v2, list0.size()), list0);
                    list0.removeAll(list1);
                    cb.g g1 = (cb.g)r0.getValue();
                    e0.r = list0;
                    e0.w = v2;
                    e0.B = v1;
                    e0.D = v3;
                    e0.I = 2;
                    object0 = g1.b(list1, e0);
                    if(object0 != a0) {
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

    public final Object c(String s, oe.c c0) {
        int v1;
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.D;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.D = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.w;
        a a0 = a.a;
        r r0 = this.b;
        H h0 = H.a;
        switch(f0.D) {
            case 0: {
                n.D(object0);
                LogU.Companion.d("CollectionRulesManager", "processBunchOfDbPremiumOffPlayLogs() ");
                i i0 = (i)r0.getValue();
                f0.r = s;
                f0.D = 1;
                object0 = i0.c(500, s, f0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                s = f0.r;
                n.D(object0);
            label_25:
                if(((List)object0).isEmpty()) {
                    LogU.Companion.d("CollectionRulesManager", "processBunchOfDbPremiumOffPlayLogs() entityList is empty");
                    return h0;
                }
                ArrayList arrayList0 = new ArrayList();
                StringBuilder stringBuilder0 = new StringBuilder();
                StringBuilder stringBuilder1 = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                StringBuilder stringBuilder3 = new StringBuilder();
                StringBuilder stringBuilder4 = new StringBuilder();
                StringBuilder stringBuilder5 = new StringBuilder();
                StringBuilder stringBuilder6 = new StringBuilder();
                Iterator iterator0 = ((List)object0).iterator();
                while(true) {
                    v1 = 0;
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object1 = iterator0.next();
                    arrayList0.add(new Integer(((PremiumOffPlayLogEntity)object1).getUid()));
                    stringBuilder0.append("");
                    stringBuilder1.append("");
                    stringBuilder2.append("");
                    stringBuilder3.append("");
                    stringBuilder4.append("");
                    stringBuilder5.append("");
                    stringBuilder6.append("N");
                    stringBuilder0.append(",");
                    stringBuilder1.append(",");
                    stringBuilder2.append(",");
                    stringBuilder3.append(",");
                    stringBuilder4.append(",");
                    stringBuilder5.append(",");
                    stringBuilder6.append(",");
                }
                stringBuilder0.setLength((stringBuilder0.length() <= 0 ? 0 : stringBuilder0.length() - 1));
                stringBuilder1.setLength((stringBuilder1.length() <= 0 ? 0 : stringBuilder1.length() - 1));
                stringBuilder2.setLength((stringBuilder2.length() <= 0 ? 0 : stringBuilder2.length() - 1));
                stringBuilder3.setLength((stringBuilder3.length() <= 0 ? 0 : stringBuilder3.length() - 1));
                stringBuilder4.setLength((stringBuilder4.length() <= 0 ? 0 : stringBuilder4.length() - 1));
                stringBuilder5.setLength((stringBuilder5.length() <= 0 ? 0 : stringBuilder5.length() - 1));
                if(stringBuilder6.length() > 0) {
                    v1 = stringBuilder6.length() - 1;
                }
                stringBuilder6.setLength(v1);
                ParamInfo offPlayLoggingReq$ParamInfo0 = new ParamInfo();
                offPlayLoggingReq$ParamInfo0.cId = stringBuilder0.toString();
                offPlayLoggingReq$ParamInfo0.cType = stringBuilder1.toString();
                offPlayLoggingReq$ParamInfo0.pstime = stringBuilder2.toString();
                offPlayLoggingReq$ParamInfo0.metaType = stringBuilder3.toString();
                offPlayLoggingReq$ParamInfo0.bitrate = stringBuilder4.toString();
                offPlayLoggingReq$ParamInfo0.bInfo = stringBuilder5.toString();
                offPlayLoggingReq$ParamInfo0.freeYn = stringBuilder6.toString();
                new Date(System.currentTimeMillis());
                offPlayLoggingReq$ParamInfo0.sendTime = "20250906112327541";
                MelonAppBase.Companion.getClass();
                offPlayLoggingReq$ParamInfo0.hwkey = DeviceIdentifier.id(t.a().getDeviceData().a);
                offPlayLoggingReq$ParamInfo0.memberKey = s;
                OffPlayLoggingReq offPlayLoggingReq0 = new OffPlayLoggingReq(this.c, offPlayLoggingReq$ParamInfo0, ((List)object0).size());
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(offPlayLoggingReq0).tag("CollectionRulesManager").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.OffPlayLoggingRes");
                if(!((OffPlayLoggingRes)httpResponse0).isSuccessful()) {
                    throw new Exception(MelonError.SERVER_RESPONSE_ERROR);
                }
                i i1 = (i)r0.getValue();
                f0.r = null;
                f0.D = 2;
                object0 = i1.b(arrayList0, f0);
                if(object0 == a0) {
                    return a0;
                }
                Y.t("processBunchOfDbPremiumOffPlayLogs() countAfterDeletion : ", ((Number)object0).intValue(), LogU.Companion, "CollectionRulesManager");
                return h0;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(object0);
        Y.t("processBunchOfDbPremiumOffPlayLogs() countAfterDeletion : ", ((Number)object0).intValue(), LogU.Companion, "CollectionRulesManager");
        return h0;
    }

    public static int d() {
        int v3;
        Q q0;
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("CollectionRulesManager", "processPendingDcfExtendLog() ");
        String s = u.w(((e0)va.o.a()).j());
        if(s != null && s.length() != 0) {
            w9.c c0 = F.i();
            int v = 0;
            do {
                int v1 = c0.a(s);
                Companion logU$Companion1 = LogU.Companion;
                Y.t("processPendingDcfExtendLog() totalDcfExtensionLogCount : ", v1, logU$Companion1, "CollectionRulesManager");
                if(v1 <= 0) {
                    break;
                }
                logU$Companion1.d("CollectionRulesManager", "processBunchOfPendingDcfExtendLog()");
                String s1 = u.w(((e0)va.o.a()).j());
                if(s1 == null || s1.length() == 0) {
                    logU$Companion1.d("CollectionRulesManager", "processBunchOfPendingDcfExtendLog() invalid memberKey");
                }
                else {
                    w9.c c1 = F.i();
                    List list0 = c1.b(s1);
                    if(!list0.isEmpty()) {
                        logU$Companion1.d("CollectionRulesManager", "processBunchOfPendingDcfExtendLog() size : " + list0.size());
                        ArrayList arrayList0 = new ArrayList();
                        StringBuilder stringBuilder0 = new StringBuilder();
                        StringBuilder stringBuilder1 = new StringBuilder();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        for(Object object0: list0) {
                            int v2 = ((y9.a)object0).a;
                            String s2 = ((y9.a)object0).b;
                            String s3 = ((y9.a)object0).c;
                            String s4 = ((y9.a)object0).e;
                            arrayList0.add(String.valueOf(v2));
                            stringBuilder0.append(s2);
                            stringBuilder1.append(s3);
                            stringBuilder2.append(s4);
                            stringBuilder0.append(",");
                            stringBuilder1.append(",");
                            stringBuilder2.append(",");
                        }
                        stringBuilder0.setLength((stringBuilder0.length() <= 0 ? 0 : stringBuilder0.length() - 1));
                        stringBuilder1.setLength((stringBuilder1.length() <= 0 ? 0 : stringBuilder1.length() - 1));
                        stringBuilder2.setLength((stringBuilder2.length() <= 0 ? 0 : stringBuilder2.length() - 1));
                        String s5 = stringBuilder0.toString();
                        q.f(s5, "toString(...)");
                        String s6 = stringBuilder1.toString();
                        q.f(s6, "toString(...)");
                        String s7 = stringBuilder2.toString();
                        q.f(s7, "toString(...)");
                        LogU.Companion.d("CollectionRulesManager", "processBunchOfPendingDcfExtendLog() cTypes : " + s5);
                        LogU.Companion.d("CollectionRulesManager", "processBunchOfPendingDcfExtendLog() cIds : " + s6);
                        LogU.Companion.d("CollectionRulesManager", "processBunchOfPendingDcfExtendLog() lCodes : " + s7);
                        MelonAppBase.Companion.getClass();
                        j j0 = (j)((o)(((Ma.l)com.google.firebase.b.B(t.a().getContext(), Ma.l.class)))).K.get();
                        DcfExtensionLoggingRes dcfExtensionLoggingRes0 = null;
                        try {
                            q0 = j0.b(s5, s6, s7, u.v(((e0)va.o.a()).j())).execute();
                        }
                        catch(IOException iOException0) {
                            iOException0.printStackTrace();
                            q0 = null;
                        }
                        if(q0 != null) {
                            dcfExtensionLoggingRes0 = (DcfExtensionLoggingRes)q0.b;
                        }
                        if(dcfExtensionLoggingRes0 != null) {
                            v3 = c1.g(s1, arrayList0);
                            Y.t("processBunchOfPendingDcfExtendLog() deletedCount : ", v3, LogU.Companion, "CollectionRulesManager");
                            goto label_64;
                        }
                    }
                }
                v3 = 0;
            label_64:
                v += v3;
            }
            while(v > 0);
            Y.t("processPendingDcfExtendLog() countOfDeduct : ", v, LogU.Companion, "CollectionRulesManager");
            return v;
        }
        logU$Companion0.d("CollectionRulesManager", "processPendingDcfExtendLog() invalid memberKey");
        return 0;
    }

    public static int e(ArrayList arrayList0) {
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("CollectionRulesManager", "processPendingDcfExtendLog() : " + arrayList0);
        String s = u.w(((e0)va.o.a()).j());
        if(s != null && s.length() != 0) {
            w9.c c0 = F.i();
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                for(Object object0: arrayList0) {
                    DcfExtendResult dcfExtendResult0 = (DcfExtendResult)object0;
                    if(dcfExtendResult0.b != null && dcfExtendResult0.b.a == 0) {
                        DcfFile dcfFile0 = dcfExtendResult0.a;
                        if(dcfFile0 != null && dcfFile0.i != -2020L) {
                            y9.a a0 = new y9.a();
                            a0.g = s;
                            String s1 = dcfFile0.c.toString();
                            q.f(s1, "toString(...)");
                            a0.b = s1;
                            String s2 = dcfFile0.b;
                            q.f(s2, "getCid(...)");
                            a0.c = s2;
                            a0.d = "";
                            String s3 = dcfFile0.a;
                            q.f(s3, "getLcode(...)");
                            a0.e = s3;
                            a0.f = System.currentTimeMillis();
                            c0.j(a0);
                        }
                    }
                }
            }
            return l.d();
        }
        logU$Companion0.d("CollectionRulesManager", "processPendingDcfExtendLog() invalid memberKey");
        return 0;
    }

    public final Object f(MelonFile melonFile0, long v, oe.c c0) {
        R8.g g0;
        if(c0 instanceof R8.g) {
            g0 = (R8.g)c0;
            int v1 = g0.D;
            if((v1 & 0x80000000) == 0) {
                g0 = new R8.g(this, c0);
            }
            else {
                g0.D = v1 ^ 0x80000000;
            }
        }
        else {
            g0 = new R8.g(this, c0);
        }
        Object object0 = g0.w;
        a a0 = a.a;
        H h0 = H.a;
        switch(g0.D) {
            case 0: {
                n.D(object0);
                if(melonFile0 != null && !TextUtils.isEmpty(melonFile0.a) && !TextUtils.isEmpty(melonFile0.b) && !TextUtils.isEmpty(melonFile0.c.getValue())) {
                    LogU.Companion.d("CollectionRulesManager", "processPendingPlaybackLog() file : " + melonFile0 + ", playTime : " + v);
                    cb.g g1 = (cb.g)this.a.getValue();
                    LocalPlaybackLogEntity localPlaybackLogEntity0 = new LocalPlaybackLogEntity();
                    String s = melonFile0.b();
                    String s1 = "";
                    if(s == null) {
                        s = "";
                    }
                    localPlaybackLogEntity0.setData(s);
                    localPlaybackLogEntity0.setCId((melonFile0.b == null ? "" : melonFile0.b));
                    String s2 = melonFile0.c == null ? null : melonFile0.c.getValue();
                    if(s2 == null) {
                        s2 = "";
                    }
                    localPlaybackLogEntity0.setCType(s2);
                    String s3 = melonFile0.a;
                    if(s3 != null) {
                        s1 = s3;
                    }
                    localPlaybackLogEntity0.setLCode(s1);
                    localPlaybackLogEntity0.setTimestamp(v);
                    g0.r = v;
                    g0.D = 1;
                    if(g1.f(localPlaybackLogEntity0, g0) == a0) {
                        return a0;
                    }
                    break;
                }
                LogU.Companion.w("CollectionRulesManager", "processPendingPlaybackLog() invalid file");
                return h0;
            }
            case 1: {
                v = g0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        g0.r = v;
        g0.D = 2;
        return this.g(g0) == a0 ? a0 : h0;
    }

    public final Object g(oe.c c0) {
        a a0;
        Object object0;
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        try {
            object0 = h0.r;
            a0 = a.a;
            switch(h0.B) {
                case 0: {
                    goto label_13;
                }
                case 1: {
                    goto label_20;
                }
                case 2: {
                    goto label_22;
                }
            }
        }
        catch(Exception exception0) {
            com.iloen.melon.utils.a.v("processPendingPlaybackLog() : ", exception0.getMessage(), LogU.Companion, "CollectionRulesManager");
            throw exception0;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_13:
        n.D(object0);
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("CollectionRulesManager", "processPendingPlaybackLog()");
        String s = u.w(((e0)va.o.a()).j());
        if(s != null && s.length() != 0) {
            goto label_23;
        }
        else {
            logU$Companion0.w("CollectionRulesManager", "processPendingPlaybackLog() invalid memberKey");
            return H.a;
            try {
            label_20:
                n.D(object0);
                goto label_27;
            label_22:
                n.D(object0);
                do {
                label_23:
                    cb.g g0 = (cb.g)this.a.getValue();
                    h0.B = 1;
                    object0 = g0.e(h0);
                    if(object0 == a0) {
                        break;
                    }
                label_27:
                    if(((Number)object0).intValue() <= 0) {
                        return H.a;
                    }
                    h0.B = 2;
                }
                while(this.b(h0) != a0);
                return a0;
            }
            catch(Exception exception0) {
            }
        }
        com.iloen.melon.utils.a.v("processPendingPlaybackLog() : ", exception0.getMessage(), LogU.Companion, "CollectionRulesManager");
        throw exception0;
    }

    public final Object h(d0 d00, long v, oe.c c0) {
        R8.i i0;
        if(c0 instanceof R8.i) {
            i0 = (R8.i)c0;
            int v1 = i0.D;
            if((v1 & 0x80000000) == 0) {
                i0 = new R8.i(this, c0);
            }
            else {
                i0.D = v1 ^ 0x80000000;
            }
        }
        else {
            i0 = new R8.i(this, c0);
        }
        Object object0 = i0.w;
        a a0 = a.a;
        H h0 = H.a;
        switch(i0.D) {
            case 0: {
                n.D(object0);
                if(d00 == null) {
                    LogU.Companion.w("CollectionRulesManager", "processPendingPremiumOffPlayLog() invalid info");
                    return h0;
                }
                LogU.Companion.d("CollectionRulesManager", "processPendingPremiumOffPlayLog() playInfo : " + d00 + ", playTime : " + v);
                i i1 = (i)this.b.getValue();
                PremiumOffPlayLogEntity premiumOffPlayLogEntity0 = new PremiumOffPlayLogEntity();
                String s = (String)d00.b;
                String s1 = "";
                if(s == null) {
                    s = "";
                }
                premiumOffPlayLogEntity0.setCId(s);
                String s2 = (String)d00.c;
                if(s2 == null) {
                    s2 = "";
                }
                premiumOffPlayLogEntity0.setCType(s2);
                String s3 = (String)d00.d;
                if(s3 == null) {
                    s3 = "";
                }
                premiumOffPlayLogEntity0.setPsTime(s3);
                String s4 = (String)d00.e;
                if(s4 == null) {
                    s4 = "";
                }
                premiumOffPlayLogEntity0.setMetaType(s4);
                String s5 = (String)d00.f;
                if(s5 == null) {
                    s5 = "";
                }
                premiumOffPlayLogEntity0.setBitrate(s5);
                String s6 = (String)d00.g;
                if(s6 == null) {
                    s6 = "";
                }
                premiumOffPlayLogEntity0.setBInfo(s6);
                String s7 = (String)d00.h;
                if(s7 == null) {
                    s7 = "N";
                }
                premiumOffPlayLogEntity0.setFreeYn(s7);
                String s8 = (String)d00.i;
                if(s8 != null) {
                    s1 = s8;
                }
                premiumOffPlayLogEntity0.setMemberKey(s1);
                premiumOffPlayLogEntity0.setTimestamp(v);
                i0.r = v;
                i0.D = 1;
                if(i1.h(premiumOffPlayLogEntity0, i0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = i0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        i0.r = v;
        i0.D = 2;
        return this.j(i0) == a0 ? a0 : h0;
    }

    public final Object i(String s, oe.c c0) {
        a a0;
        Object object0;
        R8.k k0;
        if(c0 instanceof R8.k) {
            k0 = (R8.k)c0;
            int v = k0.D;
            if((v & 0x80000000) == 0) {
                k0 = new R8.k(this, c0);
            }
            else {
                k0.D = v ^ 0x80000000;
            }
        }
        else {
            k0 = new R8.k(this, c0);
        }
        try {
            object0 = k0.w;
            a0 = a.a;
            switch(k0.D) {
                case 0: {
                    goto label_13;
                }
                case 1: {
                    goto label_19;
                }
                case 2: {
                    goto label_22;
                }
            }
        }
        catch(Exception exception0) {
            com.iloen.melon.utils.a.v("processPendingPremiumOffPlayLog() - ", exception0.getMessage(), LogU.Companion, "CollectionRulesManager");
            throw exception0;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_13:
        n.D(object0);
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("CollectionRulesManager", "processPendingPremiumOffPlayLog()");
        if(u.o(s)) {
            goto label_24;
        }
        else {
            logU$Companion0.w("CollectionRulesManager", "processPendingPremiumOffPlayLog() invalid memberKey");
            return H.a;
            try {
            label_19:
                s = k0.r;
                n.D(object0);
                goto label_29;
            label_22:
                s = k0.r;
                n.D(object0);
                do {
                label_24:
                    i i0 = (i)this.b.getValue();
                    k0.r = s;
                    k0.D = 1;
                    object0 = i0.g(s, k0);
                    if(object0 == a0) {
                        break;
                    }
                label_29:
                    if(((Number)object0).intValue() <= 0) {
                        return H.a;
                    }
                    k0.r = s;
                    k0.D = 2;
                }
                while(this.c(s, k0) != a0);
                return a0;
            }
            catch(Exception exception0) {
            }
        }
        com.iloen.melon.utils.a.v("processPendingPremiumOffPlayLog() - ", exception0.getMessage(), LogU.Companion, "CollectionRulesManager");
        throw exception0;
    }

    public final Object j(oe.c c0) {
        Iterator iterator0;
        R8.j j0;
        if(c0 instanceof R8.j) {
            j0 = (R8.j)c0;
            int v = j0.D;
            if((v & 0x80000000) == 0) {
                j0 = new R8.j(this, c0);
            }
            else {
                j0.D = v ^ 0x80000000;
            }
        }
        else {
            j0 = new R8.j(this, c0);
        }
        Object object0 = j0.w;
        a a0 = a.a;
    alab1:
        switch(j0.D) {
            case 0: {
                n.D(object0);
                LogU.Companion.d("CollectionRulesManager", "processPendingPremiumOffPlayLog()");
                i i0 = (i)this.b.getValue();
                j0.D = 1;
                object0 = i0.d(j0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_21;
            }
            case 1: {
                n.D(object0);
            label_21:
                if(!((List)object0).isEmpty()) {
                    iterator0 = ((List)object0).iterator();
                    goto label_26;
                }
                break;
            }
            case 2: {
                iterator0 = j0.r;
                n.D(object0);
                while(true) {
                label_26:
                    if(!iterator0.hasNext()) {
                        break alab1;
                    }
                    Object object1 = iterator0.next();
                    j0.r = iterator0;
                    j0.D = 2;
                    if(this.i(((String)object1), j0) != a0) {
                        continue;
                    }
                    return a0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public final void k(String s, CType[] arr_cType) {
        Q q0;
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("CollectionRulesManager", "requestDcfExtendInfoSync() reason: " + s);
        CType cType0 = arr_cType[0];
        CType cType1 = arr_cType.length > 1 ? arr_cType[1] : "-";
        logU$Companion0.d("CollectionRulesManager", "requestDcfExtendInfoSync() cType: " + cType0 + " / " + cType1);
        MelonAppBase.Companion.getClass();
        j j0 = (j)((o)(((Ma.l)com.google.firebase.b.B(t.a().getContext(), Ma.l.class)))).K.get();
        DcfExtensionBaseInfoRes dcfExtensionBaseInfoRes0 = null;
        try {
            q0 = j0.d(u.v(((e0)va.o.a()).j())).execute();
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
            q0 = null;
        }
        if(q0 != null) {
            dcfExtensionBaseInfoRes0 = (DcfExtensionBaseInfoRes)q0.b;
        }
        if(dcfExtensionBaseInfoRes0 != null) {
            Object object0 = q0.b;
            q.d(object0);
            if(!((DcfExtensionBaseInfoRes)object0).isSuccessful()) {
                throw new R8.n(MelonError.from(((DcfExtensionBaseInfoRes)object0)).getMessage());
            }
            for(int v = 0; v < arr_cType.length; ++v) {
                CType cType2 = arr_cType[v];
                CType cType3 = CType.SONG;
                boolean z = q.b(cType3, cType2);
                Context context0 = this.c;
                if(z) {
                    this.d = new CollectionRulesDcf(context0, cType3, ((DcfExtensionBaseInfoRes)object0));
                }
                else {
                    CType cType4 = CType.EDU;
                    if(q.b(cType4, cType2)) {
                        this.e = new CollectionRulesDcf(context0, cType4, ((DcfExtensionBaseInfoRes)object0));
                    }
                }
            }
            return;
        }
        LogU.Companion.d("CollectionRulesManager", "requestDcfExtendInfoSync() response is null or response.body() is null");
        throw new R8.n(MelonError.from(MelonError.SERVER_RESPONSE_ERROR).getMessage());
    }
}

