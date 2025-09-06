package com.melon.playback.melon.drm;

import Pd.i;
import R8.r;
import R8.u;
import Yb.h;
import Yb.j;
import Yb.l;
import Yb.m;
import android.content.Context;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.constants.CType;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq;
import com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes.Response;
import com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import d5.n;
import e.k;
import i.n.i.b.a.s.e.M3;
import ie.p;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;

public final class c {
    public final Context a;
    public final i b;
    public final LogU c;
    public final DrmRepositoryImpl d;

    public c(Context context0, i i0) {
        q.g(context0, "context");
        q.g(i0, "visibilityManager");
        super();
        this.a = context0;
        this.b = i0;
        this.c = Companion.create$default(LogU.Companion, "DrmContentsHelper", false, Category.Playback, 2, null);
        this.d = new DrmRepositoryImpl(context0);
    }

    public final Object a(DcfFile dcfFile0, boolean z, oe.c c0) {
        String s3;
        j j0;
        m m0;
        Object object1;
        c c1;
        Throwable throwable1;
        DcfFile dcfFile1;
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.E;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.E = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.B;
        ne.a a1 = ne.a.a;
        switch(a0.E) {
            case 0: {
                n.D(object0);
                LogU.info$default(this.c, "extendDueDate() file: " + dcfFile0 + ", forceExtend: " + z, null, false, 6, null);
                try {
                    a0.r = dcfFile0;
                    a0.w = this;
                    a0.E = 1;
                    object0 = this.b(dcfFile0, z, a0);
                }
                catch(Throwable throwable0) {
                    dcfFile1 = dcfFile0;
                    throwable1 = throwable0;
                    goto label_37;
                }
                if(object0 == a1) {
                    return a1;
                }
                dcfFile1 = dcfFile0;
                c1 = this;
                goto label_32;
            }
            case 1: {
                try {
                    c1 = a0.w;
                    dcfFile1 = a0.r;
                    n.D(object0);
                label_32:
                    LogConstantsKt.debugOnlyDebugMode(c1.c, "extendDueDate() Success: " + ((f)object0));
                    object1 = (f)object0;
                    goto label_38;
                }
                catch(Throwable throwable2) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        throwable1 = throwable2;
    label_37:
        object1 = n.t(throwable1);
    label_38:
        Throwable throwable3 = p.a(object1);
        if(throwable3 != null) {
            String s = "";
            LogU.warn$default(this.c, "extendDueDate() Failed: " + throwable3, null, false, 6, null);
            DcfLog.w("DrmContentsHelper", "extendDueDate() Error: " + throwable3.getMessage());
            if(throwable3 instanceof m) {
                m0 = (m)throwable3;
            }
            else {
                if(throwable3 instanceof R8.n) {
                    String s1 = ((R8.n)throwable3).a;
                    if(s1 != null) {
                        s = s1;
                    }
                    j0 = new j(s);
                }
                else {
                    String s2 = throwable3.getMessage();
                    if(s2 != null) {
                        s = s2;
                    }
                    j0 = new l(s, throwable3);
                }
                m0 = j0;
            }
            object1 = new d(m0);
        }
        if(((f)object1) instanceof e) {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append("Success: updateCount=" + ((e)(((f)object1))).a);
            CollectionRulesDcf collectionRulesDcf0 = ((e)(((f)object1))).b;
            if(collectionRulesDcf0 != null) {
                stringBuilder0.append(", limitDownload=" + collectionRulesDcf0.e);
                stringBuilder0.append(", remainedDownload:" + collectionRulesDcf0.f);
            }
            s3 = stringBuilder0.toString();
        }
        else if(((f)object1) instanceof d) {
            s3 = va.e.b("Failed: ", ((d)(((f)object1))).a.getMessage());
        }
        else {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        r.d(2, dcfFile1.c(), s3);
        return object1;
    }

    public final Object b(DcfFile dcfFile0, boolean z, oe.c c0) {
        m m0;
        CollectionRulesDcf collectionRulesDcf0;
        Boolean boolean1;
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v = b0.E;
            if((v & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.E = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Boolean boolean0 = b0.B;
        ne.a a0 = ne.a.a;
        String s = "";
        switch(b0.E) {
            case 0: {
                n.D(boolean0);
                b0.r = dcfFile0;
                b0.w = z;
                b0.E = 1;
                this.d.getClass();
                try {
                    RequestFuture requestFuture0 = RequestFuture.newFuture();
                    HttpResponse httpResponse0 = RequestBuilder.newInstance(new DeviceInformDeviceCheckReq(this.d.a, CallerType.PDCF)).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                    q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes");
                    if(!((DeviceInformDeviceCheckRes)httpResponse0).isSuccessful()) {
                        goto label_25;
                    }
                    Response deviceInformDeviceCheckRes$Response0 = ((DeviceInformDeviceCheckRes)httpResponse0).response;
                    if(deviceInformDeviceCheckRes$Response0 == null) {
                    label_25:
                        String s1 = MelonError.from(((DeviceInformDeviceCheckRes)httpResponse0)).getMessage();
                        if(s1 == null) {
                            s1 = "";
                        }
                        throw new Yb.i(s1);
                    }
                    boolean z1 = ProtocolUtils.parseBoolean(deviceInformDeviceCheckRes$Response0.deviceYn);
                    ((e0)o.a()).A(z1);
                    boolean1 = Boolean.valueOf(z1);
                }
                catch(Throwable throwable0) {
                    boolean1 = n.t(throwable0);
                }
                Throwable throwable1 = p.a(boolean1);
                if(throwable1 != null && throwable1 instanceof VolleyError) {
                    String s2 = throwable1.getMessage();
                    if(s2 != null) {
                        s = s2;
                    }
                    throw new Yb.i(s);
                }
                if(boolean1 instanceof ie.o) {
                    boolean1 = Boolean.FALSE;
                }
                boolean0 = boolean1;
                if(boolean0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                z = b0.w;
                dcfFile0 = b0.r;
                n.D(boolean0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!boolean0.booleanValue()) {
            if(!((AppVisibilityManagerImpl)this.b).e) {
                ToastManager.show(0x7F1302DC);  // string:dcf_need_register_for_toast "DCF 파일 기간 연장을 위해서 기기등록 후 이용해주세요."
            }
            q.f("DCF 파일 기간 연장을 위해서 기기등록 후 이용해주세요.", "getString(...)");
            return new d(new Yb.i("DCF 파일 기간 연장을 위해서 기기등록 후 이용해주세요."));
        }
        R8.l l0 = R6.c.g();
        if(z) {
            collectionRulesDcf0 = null;
        }
        else {
            try {
                CType cType0 = dcfFile0.c;
                q.f(cType0, "getCtype(...)");
                l0.k("DrmContentsHelper", new CType[]{cType0});
                CType cType1 = dcfFile0.c;
                q.f(cType1, "getCtype(...)");
                collectionRulesDcf0 = l0.a(cType1);
                if(collectionRulesDcf0 != null) {
                    if(!collectionRulesDcf0.c) {
                        throw new h("isHasGoods.not", dcfFile0, collectionRulesDcf0);
                    }
                    if(collectionRulesDcf0.d) {
                        throw new h("isMrCap", dcfFile0, collectionRulesDcf0);
                    label_68:
                        if(exception0 instanceof m) {
                            m0 = (m)exception0;
                            throw m0;
                        }
                        else {
                            goto label_69;
                        }
                        throw m0;
                    }
                }
                goto label_78;
            }
            catch(Exception exception0) {
                goto label_68;
            }
        label_69:
            if(exception0 instanceof DcfError) {
                String s3 = ((DcfError)exception0).getMessage();
                if(s3 != null) {
                    s = s3;
                }
            }
            m0 = new l(s, null);
            throw m0;
        }
    label_78:
        ToastManager.show(0x7F1302C5);  // string:dcf_extend_processing "DCF 파일의 재생기간 연장 중입니다."
        ArrayList arrayList0 = u.a(k.z(dcfFile0), null);
        l0.getClass();
        int v1 = R8.l.e(arrayList0);
        if(collectionRulesDcf0 != null) {
            int v2 = collectionRulesDcf0.f;
            collectionRulesDcf0.f = v2 - v1;
            C8.e e0 = new C8.e(v2, collectionRulesDcf0, 10);
            LogConstantsKt.buildDebug(this.c, true, e0);
        }
        DcfExtendResult dcfExtendResult0 = (DcfExtendResult)je.p.k0(arrayList0);
        if(dcfExtendResult0.b != null && !dcfExtendResult0.b.equals(DcfError.c)) {
            throw dcfExtendResult0.b;
        }
        return new e(v1, collectionRulesDcf0);
    }
}

