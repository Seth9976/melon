package va;

import A8.l;
import H0.b;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import b3.Z;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.CookieHelper;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.sdk.auth.TokenManager;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.melon.data.newlogin.KakaoUserIdLocalDataSourceImpl;
import d3.g;
import e1.u;
import ie.H;
import ie.o;
import ie.p;
import ie.r;
import java.util.Date;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ne.a;
import oe.c;
import p8.e;

public final class n {
    public final Context a;
    public final KakaoUserIdLocalDataSourceImpl b;
    public final LogU c;
    public final r d;
    public final r e;
    public final Mutex f;

    public n(Context context0, KakaoUserIdLocalDataSourceImpl kakaoUserIdLocalDataSourceImpl0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = kakaoUserIdLocalDataSourceImpl0;
        LogU logU0 = Z.g("KakaoLoginRepository", true);
        logU0.setCategory(Category.Login);
        this.c = logU0;
        this.d = g.Q(new e(20));
        this.e = g.Q(new e(21));
        this.f = MutexKt.Mutex$default(false, 1, null);
    }

    public static final void a(n n0, l l0) {
        n0.b.b.setValue(l0.a);
        SharedPreferences.Editor sharedPreferences$Editor0 = n0.b.a.getSharedPreferences("kakao_session_store", 0).edit();
        sharedPreferences$Editor0.putLong("KakaoId", l0.a);
        sharedPreferences$Editor0.apply();
        KakaoEmoticon.updateSessionState();
    }

    public final Object b(c c0) {
        p p0;
        o o0;
        String s1;
        long v2;
        String s;
        DevLog devLog1;
        Mutex mutex1;
        long v1;
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.M;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.M = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.G;
        a a0 = a.a;
        switch(f0.M) {
            case 0: {
                d5.n.D(object0);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                Mutex mutex0 = this.f;
                LogU.debug$default(mutexLockUtil0.getLog(), androidx.appcompat.app.o.j(this.f.hashCode(), "ReentrantLock[", "]  try : KakaoLoginRepository-checkTokenValidAndUpdate"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : KakaoLoginRepository-checkTokenValidAndUpdate", devLog0, mutex0);
                if(f0.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-checkTokenValidAndUpdate", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-checkTokenValidAndUpdate");
                        try {
                            f0.r = mutex0;
                            f0.w = "KakaoLoginRepository-checkTokenValidAndUpdate";
                            f0.B = devLog0;
                            f0.D = "";
                            f0.E = v1;
                            f0.M = 1;
                            CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(f0), 1);
                            cancellableContinuationImpl0.initCancellability();
                            this.d().accessTokenInfo(new va.g(cancellableContinuationImpl0, 0));
                            object0 = cancellableContinuationImpl0.getResult();
                        }
                        catch(Exception exception0) {
                            mutex1 = mutex0;
                            devLog1 = devLog0;
                            s = "KakaoLoginRepository-checkTokenValidAndUpdate";
                            v2 = v1;
                            s1 = "";
                            o0 = d5.n.t(exception0);
                            p0 = new p(o0);
                            goto label_90;
                        }
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        s = "KakaoLoginRepository-checkTokenValidAndUpdate";
                        v2 = v1;
                        s1 = "";
                        break;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex1 = mutex0;
                    devLog1 = devLog0;
                    s = "KakaoLoginRepository-checkTokenValidAndUpdate";
                    v2 = v1;
                    s1 = "";
                    o0 = ((p)object0).a;
                    p0 = new p(o0);
                    goto label_90;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                h h0 = new h(mutex0, null, mutex0, devLog0, this);
                f0.r = null;
                f0.w = null;
                f0.B = null;
                f0.D = null;
                f0.M = 2;
                object0 = BuildersKt.withContext(reentrantMutexContextElement0, h0, f0);
                return object0 == a0 ? a0 : object0.a;
            }
            case 1: {
                try {
                    try {
                        v2 = f0.E;
                        s1 = f0.D;
                        devLog1 = f0.B;
                        s = f0.w;
                        mutex1 = f0.r;
                        d5.n.D(object0);
                        o0 = ((p)object0).a;
                        p0 = new p(o0);
                        goto label_90;
                    }
                    catch(Exception exception0) {
                    }
                    o0 = d5.n.t(exception0);
                    p0 = new p(o0);
                    goto label_90;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                return object0.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v3 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s1, " Lock return : ");
        b.t(v3, s, " (", stringBuilder0);
        stringBuilder0.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s1, " Lock return : ");
        b.t(v3, s, " (", stringBuilder1);
        l1.C(stringBuilder1, "ms)", devLog1);
        throw throwable0;
    label_90:
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s1, " Lock return : ");
        b.t(v4, s, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s1, " Lock return : ");
        b.t(v4, s, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog1);
        return p0.a;
    }

    public final l c() {
        long v = ((Number)this.b.b.getValue()).longValue();
        OAuthToken oAuthToken0 = ((TokenManager)this.e.getValue()).getToken();
        return v <= 0L || oAuthToken0 == null || oAuthToken0.getAccessToken().length() == 0 || new Date().after(oAuthToken0.getAccessTokenExpiresAt()) ? null : new l(v, oAuthToken0.getRefreshToken(), oAuthToken0.getAccessToken());
    }

    public final UserApiClient d() {
        return (UserApiClient)this.d.getValue();
    }

    public final Object e(Context context0, c c0) {
        p p0;
        o o0;
        OAuthToken oAuthToken1;
        OAuthToken oAuthToken0;
        Mutex mutex3;
        String s5;
        DevLog devLog3;
        Object object3;
        long v9;
        int v7;
        int v6;
        int v5;
        Mutex mutex2;
        String s4;
        int v4;
        int v3;
        DevLog devLog2;
        String s3;
        Object object2;
        DevLog devLog1;
        long v2;
        Mutex mutex1;
        String s2;
        Object object1;
        long v1;
        DevLog devLog0;
        Mutex mutex0;
        String s1;
        String s;
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.X;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.X = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.V;
        a a0 = a.a;
        switch(i0.X) {
            case 0: {
                d5.n.D(object0);
                s = "KakaoLoginRepository-loginWithKakaoAccount";
                s1 = "";
                mutex0 = this.f;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : KakaoLoginRepository-loginWithKakaoAccount"), null, false, 6, null);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : KakaoLoginRepository-loginWithKakaoAccount", devLog0, mutex0);
                if(i0.getContext().get(reentrantMutexContextKey0) == null) {
                    ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                    j j0 = new j(mutex0, null, mutex0, devLog0, this, context0);
                    i0.r = null;
                    i0.w = null;
                    i0.B = null;
                    i0.D = null;
                    i0.G = 0;
                    i0.I = 0;
                    i0.X = 3;
                    object0 = BuildersKt.withContext(reentrantMutexContextElement0, j0, i0);
                    if(object0 != a0) {
                        return object0.a;
                    }
                }
                else {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-loginWithKakaoAccount", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-loginWithKakaoAccount");
                    }
                    catch(Throwable throwable0) {
                        goto label_166;
                    }
                    try {
                        i0.r = mutex0;
                        i0.w = "KakaoLoginRepository-loginWithKakaoAccount";
                        i0.B = devLog0;
                        i0.D = "";
                        i0.G = 0;
                        i0.I = 0;
                        i0.M = 0;
                        i0.T = v1;
                        i0.N = 0;
                        i0.S = 0;
                        i0.X = 1;
                        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(i0), 1);
                        cancellableContinuationImpl0.initCancellability();
                        UserApiClient.loginWithKakaoAccount$default(this.d(), context0, null, null, null, null, null, new va.g(cancellableContinuationImpl0, 1), 62, null);
                        object1 = cancellableContinuationImpl0.getResult();
                    }
                    catch(Throwable throwable1) {
                        s2 = "";
                        mutex1 = mutex0;
                        v2 = v1;
                        devLog1 = devLog0;
                        break;
                    }
                    if(object1 != a0) {
                        object2 = object1;
                        s3 = "KakaoLoginRepository-loginWithKakaoAccount";
                        devLog2 = devLog0;
                        v3 = 0;
                        v4 = 0;
                        s4 = "";
                        mutex2 = mutex0;
                        v2 = v1;
                        v5 = 0;
                        v6 = 0;
                        v7 = 0;
                        goto label_104;
                    }
                }
                return a0;
            }
            case 1: {
                try {
                    int v8 = i0.N;
                    v9 = i0.T;
                    int v10 = i0.M;
                    int v11 = i0.I;
                    int v12 = i0.G;
                    int v13 = i0.S;
                    object3 = i0.D;
                    devLog3 = i0.B;
                    s5 = i0.w;
                    mutex3 = i0.r;
                    d5.n.D(object0);
                    v5 = v13;
                    object2 = object0;
                    v3 = v10;
                    v4 = v11;
                    devLog2 = devLog3;
                    v7 = v12;
                    s3 = s5;
                    mutex2 = mutex3;
                    s4 = object3;
                    v6 = v8;
                    v2 = v9;
                }
                catch(Throwable throwable1) {
                    mutex1 = mutex3;
                    v2 = v9;
                    s2 = object3;
                    devLog1 = devLog3;
                    s = s5;
                    break;
                }
                try {
                label_104:
                    oAuthToken0 = (OAuthToken)object2;
                    i0.r = mutex2;
                    i0.w = s3;
                    i0.B = devLog2;
                    i0.D = s4;
                    i0.E = oAuthToken0;
                    i0.G = v7;
                    i0.I = v4;
                    i0.M = v3;
                    i0.T = v2;
                    i0.N = v6;
                    i0.S = v5;
                    i0.X = 2;
                    CancellableContinuationImpl cancellableContinuationImpl1 = new CancellableContinuationImpl(u.D(i0), 1);
                    cancellableContinuationImpl1.initCancellability();
                    UserApiClient.me$default(this.d(), null, false, new va.g(cancellableContinuationImpl1, 2), 3, null);
                    object0 = cancellableContinuationImpl1.getResult();
                }
                catch(Throwable throwable1) {
                    mutex1 = mutex2;
                    s2 = s4;
                    devLog1 = devLog2;
                    s = s3;
                    break;
                }
                if(object0 != a0) {
                    oAuthToken1 = oAuthToken0;
                    mutex1 = mutex2;
                    s2 = s4;
                    devLog1 = devLog2;
                    s = s3;
                    goto label_143;
                }
                return a0;
            }
            case 2: {
                try {
                    v2 = i0.T;
                    oAuthToken1 = i0.E;
                    s2 = i0.D;
                    devLog1 = i0.B;
                    s = i0.w;
                    mutex1 = i0.r;
                    d5.n.D(object0);
                label_143:
                    o0 = new l(((Number)object0).longValue(), oAuthToken1.getRefreshToken(), oAuthToken1.getAccessToken());
                    n.a(this, ((l)o0));
                    goto label_155;
                }
                catch(Throwable throwable1) {
                    break;
                }
            }
            case 3: {
                d5.n.D(object0);
                return object0.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            o0 = d5.n.t(throwable1);
        }
        catch(Throwable throwable0) {
            v1 = v2;
            mutex0 = mutex1;
            s1 = s2;
            devLog0 = devLog1;
            goto label_166;
        }
        try {
        label_155:
            v1 = v2;
            mutex0 = mutex1;
            s1 = s2;
            devLog0 = devLog1;
            Throwable throwable2 = p.a(o0);
            if(throwable2 != null) {
                LogU.debug$default(this.c, "loginWithKakaoAccount Failed: " + throwable2, null, false, 6, null);
                d5.n.t(throwable2);
            }
            p0 = new p(o0);
            goto label_175;
        }
        catch(Throwable throwable0) {
        }
    label_166:
        long v14 = System.currentTimeMillis() - v1;
        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v14, s, " (", stringBuilder0);
        stringBuilder0.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v14, s, " (", stringBuilder1);
        l1.C(stringBuilder1, "ms)", devLog0);
        throw throwable0;
    label_175:
        long v15 = System.currentTimeMillis() - v1;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v15, s, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v15, s, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog0);
        return p0.a;
    }

    public final Object f(Context context0, c c0) {
        p p0;
        o o0;
        OAuthToken oAuthToken1;
        OAuthToken oAuthToken0;
        Mutex mutex3;
        String s5;
        DevLog devLog3;
        Object object3;
        long v9;
        int v7;
        int v6;
        int v5;
        Mutex mutex2;
        String s4;
        int v4;
        int v3;
        DevLog devLog2;
        String s3;
        Object object2;
        DevLog devLog1;
        long v2;
        Mutex mutex1;
        String s2;
        Object object1;
        long v1;
        DevLog devLog0;
        Mutex mutex0;
        String s1;
        String s;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v = k0.X;
            if((v & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.X = v ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.V;
        a a0 = a.a;
        switch(k0.X) {
            case 0: {
                d5.n.D(object0);
                s = "KakaoLoginRepository-loginWithKakaoTalk";
                s1 = "";
                mutex0 = this.f;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : KakaoLoginRepository-loginWithKakaoTalk"), null, false, 6, null);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : KakaoLoginRepository-loginWithKakaoTalk", devLog0, mutex0);
                if(k0.getContext().get(reentrantMutexContextKey0) == null) {
                    ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                    va.l l0 = new va.l(mutex0, null, mutex0, devLog0, this, context0);
                    k0.r = null;
                    k0.w = null;
                    k0.B = null;
                    k0.D = null;
                    k0.G = 0;
                    k0.I = 0;
                    k0.X = 3;
                    object0 = BuildersKt.withContext(reentrantMutexContextElement0, l0, k0);
                    if(object0 != a0) {
                        return object0.a;
                    }
                }
                else {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-loginWithKakaoTalk", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-loginWithKakaoTalk");
                    }
                    catch(Throwable throwable0) {
                        goto label_166;
                    }
                    try {
                        k0.r = mutex0;
                        k0.w = "KakaoLoginRepository-loginWithKakaoTalk";
                        k0.B = devLog0;
                        k0.D = "";
                        k0.G = 0;
                        k0.I = 0;
                        k0.M = 0;
                        k0.T = v1;
                        k0.N = 0;
                        k0.S = 0;
                        k0.X = 1;
                        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(k0), 1);
                        cancellableContinuationImpl0.initCancellability();
                        UserApiClient.loginWithKakaoTalk$default(this.d(), context0, 0, null, null, null, new va.g(cancellableContinuationImpl0, 3), 30, null);
                        object1 = cancellableContinuationImpl0.getResult();
                    }
                    catch(Throwable throwable1) {
                        s2 = "";
                        mutex1 = mutex0;
                        v2 = v1;
                        devLog1 = devLog0;
                        break;
                    }
                    if(object1 != a0) {
                        object2 = object1;
                        s3 = "KakaoLoginRepository-loginWithKakaoTalk";
                        devLog2 = devLog0;
                        v3 = 0;
                        v4 = 0;
                        s4 = "";
                        mutex2 = mutex0;
                        v2 = v1;
                        v5 = 0;
                        v6 = 0;
                        v7 = 0;
                        goto label_104;
                    }
                }
                return a0;
            }
            case 1: {
                try {
                    int v8 = k0.N;
                    v9 = k0.T;
                    int v10 = k0.M;
                    int v11 = k0.I;
                    int v12 = k0.G;
                    int v13 = k0.S;
                    object3 = k0.D;
                    devLog3 = k0.B;
                    s5 = k0.w;
                    mutex3 = k0.r;
                    d5.n.D(object0);
                    v5 = v13;
                    object2 = object0;
                    v3 = v10;
                    v4 = v11;
                    devLog2 = devLog3;
                    v7 = v12;
                    s3 = s5;
                    mutex2 = mutex3;
                    s4 = object3;
                    v6 = v8;
                    v2 = v9;
                }
                catch(Throwable throwable1) {
                    mutex1 = mutex3;
                    v2 = v9;
                    s2 = object3;
                    devLog1 = devLog3;
                    s = s5;
                    break;
                }
                try {
                label_104:
                    oAuthToken0 = (OAuthToken)object2;
                    k0.r = mutex2;
                    k0.w = s3;
                    k0.B = devLog2;
                    k0.D = s4;
                    k0.E = oAuthToken0;
                    k0.G = v7;
                    k0.I = v4;
                    k0.M = v3;
                    k0.T = v2;
                    k0.N = v6;
                    k0.S = v5;
                    k0.X = 2;
                    CancellableContinuationImpl cancellableContinuationImpl1 = new CancellableContinuationImpl(u.D(k0), 1);
                    cancellableContinuationImpl1.initCancellability();
                    UserApiClient.me$default(this.d(), null, false, new va.g(cancellableContinuationImpl1, 4), 3, null);
                    object0 = cancellableContinuationImpl1.getResult();
                }
                catch(Throwable throwable1) {
                    mutex1 = mutex2;
                    s2 = s4;
                    devLog1 = devLog2;
                    s = s3;
                    break;
                }
                if(object0 != a0) {
                    oAuthToken1 = oAuthToken0;
                    mutex1 = mutex2;
                    s2 = s4;
                    devLog1 = devLog2;
                    s = s3;
                    goto label_143;
                }
                return a0;
            }
            case 2: {
                try {
                    v2 = k0.T;
                    oAuthToken1 = k0.E;
                    s2 = k0.D;
                    devLog1 = k0.B;
                    s = k0.w;
                    mutex1 = k0.r;
                    d5.n.D(object0);
                label_143:
                    o0 = new l(((Number)object0).longValue(), oAuthToken1.getRefreshToken(), oAuthToken1.getAccessToken());
                    n.a(this, ((l)o0));
                    goto label_155;
                }
                catch(Throwable throwable1) {
                    break;
                }
            }
            case 3: {
                d5.n.D(object0);
                return object0.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            o0 = d5.n.t(throwable1);
        }
        catch(Throwable throwable0) {
            v1 = v2;
            mutex0 = mutex1;
            s1 = s2;
            devLog0 = devLog1;
            goto label_166;
        }
        try {
        label_155:
            v1 = v2;
            mutex0 = mutex1;
            s1 = s2;
            devLog0 = devLog1;
            Throwable throwable2 = p.a(o0);
            if(throwable2 != null) {
                LogU.debug$default(this.c, "loginWithKakaoTalk Failed: " + throwable2, null, false, 6, null);
                d5.n.t(throwable2);
            }
            p0 = new p(o0);
            goto label_175;
        }
        catch(Throwable throwable0) {
        }
    label_166:
        long v14 = System.currentTimeMillis() - v1;
        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v14, s, " (", stringBuilder0);
        stringBuilder0.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v14, s, " (", stringBuilder1);
        l1.C(stringBuilder1, "ms)", devLog0);
        throw throwable0;
    label_175:
        long v15 = System.currentTimeMillis() - v1;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v15, s, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
        b.t(v15, s, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog0);
        return p0.a;
    }

    public final Object g(Continuation continuation0) {
        long v;
        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
        Mutex mutex0 = this.f;
        LogU.debug$default(mutexLockUtil0.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : KakaoLoginRepository-logout"), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : KakaoLoginRepository-logout", devLog0, mutex0);
        if(continuation0.getContext().get(reentrantMutexContextKey0) != null) {
            try {
                v = System.currentTimeMillis();
                LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-logout", null, false, 6, null);
                devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : KakaoLoginRepository-logout");
                this.b.b.setValue(-1L);
                SharedPreferences.Editor sharedPreferences$Editor0 = this.b.a.getSharedPreferences("kakao_session_store", 0).edit();
                sharedPreferences$Editor0.clear();
                sharedPreferences$Editor0.apply();
                ((TokenManager)this.e.getValue()).clear();
                KakaoEmoticon.updateSessionState();
                CookieHelper.getInstance().removeKakaoWebLoginCookie();
            }
            catch(Throwable throwable0) {
                long v1 = System.currentTimeMillis() - v;
                StringBuilder stringBuilder0 = Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : KakaoLoginRepository-logout (", v1);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                l1.C(Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : KakaoLoginRepository-logout (", v1), "ms)", devLog0);
                throw throwable0;
            }
            long v2 = System.currentTimeMillis() - v;
            StringBuilder stringBuilder1 = Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : KakaoLoginRepository-logout (", v2);
            stringBuilder1.append("ms)");
            LogU.debug$default(mutexLockUtil0.getLog(), stringBuilder1.toString(), null, false, 6, null);
            l1.C(Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : KakaoLoginRepository-logout (", v2), "ms)", devLog0);
            return H.a;
        }
        Object object0 = BuildersKt.withContext(new ReentrantMutexContextElement(reentrantMutexContextKey0), new m(mutex0, null, mutex0, devLog0, this), continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

