package com.iloen.melon.userstore.utils;

import android.text.TextUtils;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.YieldKt;
import ne.a;
import oe.c;
import y9.d;
import z9.G;
import z9.J;
import z9.K;
import z9.L;
import z9.M;
import z9.O;
import z9.g;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/iloen/melon/userstore/utils/UserDataSyncTask;", "", "z9/I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class UserDataSyncTask {
    public final String a;
    public final int b;
    public String c;
    public String d;
    public HttpResponse e;

    public UserDataSyncTask(String s, int v, String s1) {
        q.g(s, "mMemberKey");
        q.g(s1, "mReason");
        super();
        this.a = s;
        this.b = v;
    }

    public final Object a(c c0) {
        J j0;
        if(c0 instanceof J) {
            j0 = (J)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new J(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new J(this, c0);
        }
        Object object0 = j0.r;
        a a0 = a.a;
        switch(j0.B) {
            case 0: {
                n.D(object0);
                K k0 = new K(this, null);
                j0.B = 1;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), k0, j0);
                if(object0 == a0) {
                    return a0;
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
        LogU.Companion.d("UserDataSyncTask", "getLatestSyncInfo() entity: " + ((d)object0));
        return object0;
    }

    public final Object b(String s, M m0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new L(s, this, null), m0);
        return object0 == a.a ? object0 : H.a;
    }

    public final Object c(g g0, c c0) {
        HttpResponse httpResponse1;
        String s2;
        int v2;
        g g6;
        Exception exception3;
        g g4;
        g g3;
        HttpResponse httpResponse0;
        g g2;
        String s1;
        d d0;
        g g1;
        int v1;
        String s;
        M m0;
        if(c0 instanceof M) {
            m0 = (M)c0;
            int v = m0.N;
            if((v & 0x80000000) == 0) {
                m0 = new M(this, c0);
            }
            else {
                m0.N = v ^ 0x80000000;
            }
        }
        else {
            m0 = new M(this, c0);
        }
        Object object0 = m0.I;
        a a0 = a.a;
        switch(m0.N) {
            case 0: {
                n.D(object0);
                LogU.Companion.d("UserDataSyncTask", "sync start.");
                s = null;
                goto label_83;
            }
            case 1: {
                try {
                    v1 = m0.E;
                    s = m0.B;
                    g1 = m0.r;
                    n.D(object0);
                    goto label_93;
                }
                catch(Exception unused_ex) {
                    return new G(MelonError.SERVER_RESPONSE_ERROR.getMessage());
                }
            }
            case 2: {
                v1 = m0.E;
                d0 = (d)m0.D;
                s1 = m0.B;
                g2 = m0.r;
                try {
                    n.D(object0);
                    goto label_105;
                }
                catch(Exception unused_ex) {
                    return new G(MelonError.SERVER_RESPONSE_ERROR.getMessage());
                }
            }
            case 3: {
                v1 = m0.E;
                d0 = (d)m0.D;
                s1 = m0.B;
                g2 = m0.r;
                try {
                    n.D(object0);
                    goto label_112;
                }
                catch(Exception unused_ex) {
                    return new G(MelonError.SERVER_RESPONSE_ERROR.getMessage());
                }
            }
            case 4: {
                v1 = m0.E;
                d d1 = (d)m0.D;
                s = m0.B;
                g1 = m0.r;
                try {
                    n.D(object0);
                    goto label_123;
                }
                catch(Exception unused_ex) {
                    return new G(MelonError.SERVER_RESPONSE_ERROR.getMessage());
                }
            }
            case 5: {
                v1 = m0.E;
                s = m0.B;
                httpResponse0 = m0.w;
                g3 = m0.r;
                n.D(object0);
                goto label_134;
            }
            case 6: {
                try {
                    v1 = m0.G;
                    s = m0.B;
                    httpResponse0 = m0.w;
                    g3 = m0.r;
                    n.D(object0);
                    goto label_150;
                }
                catch(Exception exception0) {
                    v2 = v1;
                    exception3 = exception0;
                    g6 = g3;
                    goto label_176;
                }
            }
            case 7: {
                try {
                    v1 = m0.G;
                    s = m0.B;
                    g4 = m0.r;
                    n.D(object0);
                    goto label_163;
                label_57:
                    v1 = m0.G;
                    s = m0.B;
                    g4 = m0.r;
                    n.D(object0);
                    s2 = s;
                    g6 = g4;
                    goto label_77;
                }
                catch(Exception exception1) {
                    goto label_173;
                }
            }
            case 8: {
                goto label_57;
            }
            case 9: {
                boolean z = m0.G;
                Exception exception2 = (Exception)m0.D;
                g g5 = m0.r;
                try {
                    exception3 = exception2;
                    g6 = g5;
                    n.D(object0);
                    v2 = z;
                    exception3 = exception2;
                    g6 = g5;
                    goto label_183;
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 10: {
                exception3 = (Exception)m0.D;
                g6 = m0.r;
                try {
                    n.D(object0);
                }
                catch(Exception unused_ex) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            s2 = exception3.getMessage();
            v1 = 0;
        label_77:
            if(v1 == 0) {
                return TextUtils.isEmpty(s2) ? new z9.H(this) : new G(s2);
            }
            g0 = g6;
            s = s2;
            try {
            label_83:
                m0.r = g0;
                m0.w = null;
                m0.B = s;
                m0.D = null;
                m0.E = 0;
                m0.N = 1;
                object0 = this.a(m0);
                if(object0 == a0) {
                    return a0;
                }
                g1 = g0;
                v1 = 0;
            label_93:
                d d2 = (d)object0;
                if(!TextUtils.isEmpty(d2.d)) {
                    m0.r = g1;
                    m0.w = null;
                    m0.B = s;
                    m0.D = d2;
                    m0.E = v1;
                    m0.N = 2;
                    if(g1.b(d2.d, m0) == a0) {
                        return a0;
                    }
                    g2 = g1;
                    s1 = s;
                    d0 = d2;
                label_105:
                    m0.r = g2;
                    m0.w = null;
                    m0.B = s1;
                    m0.D = d0;
                    m0.E = v1;
                    m0.N = 3;
                    if(this.b("", m0) == a0) {
                        return a0;
                    }
                label_112:
                    d2 = d0;
                    s = s1;
                    g1 = g2;
                }
                m0.r = g1;
                m0.w = null;
                m0.B = s;
                m0.D = null;
                m0.E = v1;
                m0.N = 4;
                object0 = g1.f(d2.c, m0);
                if(object0 == a0) {
                    return a0;
                }
            label_123:
                httpResponse1 = (HttpResponse)object0;
                this.e = httpResponse1;
            }
            catch(Exception unused_ex) {
                return new G(MelonError.SERVER_RESPONSE_ERROR.getMessage());
            }
            m0.r = g1;
            m0.w = httpResponse1;
            m0.B = s;
            m0.D = null;
            m0.E = v1;
            m0.N = 5;
            if(YieldKt.yield(m0) == a0) {
                return a0;
            }
            g3 = g1;
            httpResponse0 = httpResponse1;
        label_134:
            if(!httpResponse0.isSuccessful()) {
                goto label_195;
            }
            g3.c(httpResponse0);
            this.c = g3.a(httpResponse0);
            this.d = g3.e(httpResponse0);
            LogU.Companion.d("UserDataSyncTask", "SyncType: " + this.b + ", mSyncTime: " + this.c);
            try {
                m0.r = g3;
                m0.w = httpResponse0;
                m0.B = s;
                m0.G = false;
                m0.N = 6;
                if(this.b(this.c, m0) == a0) {
                    return a0;
                }
            }
            catch(Exception exception3) {
                v2 = 0;
                g6 = g3;
                goto label_176;
            }
            v1 = 0;
            try {
            label_150:
                m0.r = g3;
                m0.w = null;
                m0.B = s;
                m0.G = v1;
                m0.N = 7;
                if(g3.d(httpResponse0, this.c, m0) == a0) {
                    return a0;
                }
            }
            catch(Exception exception0) {
                v2 = v1;
                exception3 = exception0;
                g6 = g3;
                goto label_176;
            }
            g4 = g3;
            try {
            label_163:
                m0.r = g4;
                m0.w = null;
                m0.B = s;
                m0.G = v1;
                m0.N = 8;
                H h0 = BuildersKt.withContext(Dispatchers.getIO(), new O(this.c, this, null), m0);
                if(h0 == a.a) {
                    goto label_191;
                }
                h0 = H.a;
                goto label_191;
            }
            catch(Exception exception1) {
            label_173:
                v2 = v1;
                exception3 = exception1;
                g6 = g4;
            }
            try {
            label_176:
                m0.r = g6;
                m0.w = null;
                m0.B = null;
                m0.D = exception3;
                m0.G = v2;
                m0.N = 9;
                if(g6.b(this.c, m0) == a0) {
                    return a0;
                }
            label_183:
                m0.r = g6;
                m0.w = null;
                m0.B = null;
                m0.D = exception3;
                m0.G = v2;
                m0.N = 10;
                if(this.b("", m0) != a0) {
                    continue;
                }
                break;
            }
            catch(Exception unused_ex) {
            }
        }
        return a0;
    label_191:
        if(h0 != a0) {
            s2 = s;
            g6 = g4;
            goto label_77;
        label_195:
            Notification httpResponse$Notification0 = httpResponse0.notification;
            if(httpResponse$Notification0 == null) {
                s2 = MelonError.SERVER_RESPONSE_ERROR.getMessage();
            }
            else {
                String s3 = httpResponse$Notification0.message;
                if(s3 != null) {
                    s2 = s3;
                }
            }
            g6 = g3;
            goto label_77;
        }
        try {
            return a0;
        }
        catch(Exception unused_ex) {
            return new G(MelonError.SERVER_RESPONSE_ERROR.getMessage());
        }
    }
}

