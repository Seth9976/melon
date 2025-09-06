package va;

import A8.A;
import A8.G;
import A8.r;
import A8.w;
import A8.y;
import A8.z;
import Cb.i;
import Cb.j;
import R8.b;
import R8.t;
import U4.x;
import Uf.d;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import b3.Z;
import co.ab180.airbridge.Airbridge;
import com.iloen.melon.LoginUser;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventAlertDialog;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.playback.EpPlayLogger;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.DevLog.Companion;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.CookieHelper;
import com.iloen.melon.utils.system.BadgeUtils;
import com.iloen.melon.utils.time.TimeUtils;
import com.melon.utils.system.DeviceData;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import k8.a;
import kb.D;
import kc.F0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import mb.f;
import mb.k;
import mb.l;
import mb.o;
import me.g;
import vc.c;

public final class e0 implements k {
    public final Context a;
    public final l b;
    public final f c;
    public final o d;
    public final D e;
    public final DeviceData f;
    public final a g;
    public final CoroutineDispatcher h;
    public final CoroutineScope i;
    public final LogU j;
    public final DevLog k;
    public int l;
    public final MutableStateFlow m;
    public final Mutex n;
    public static final long o;

    static {
        e0.o = x1.a.P(1, d.d);
    }

    public e0(Context context0, l l0, f f0, o o0, D d0, DeviceData deviceData0, a a0, CoroutineDispatcher coroutineDispatcher0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = l0;
        this.c = f0;
        this.d = o0;
        this.e = d0;
        this.f = deviceData0;
        this.g = a0;
        this.h = coroutineDispatcher0;
        this.i = CoroutineScopeKt.CoroutineScope(coroutineDispatcher0.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        LogU logU0 = Z.g("LoginUseCase", true);
        logU0.setCategory(Category.Login);
        this.j = logU0;
        this.k = DevLog.Companion.get("Account");
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(new va.a("", "", ""));
        this.m = mutableStateFlow0;
        FlowKt.asStateFlow(mutableStateFlow0);
        this.n = ((j1)l0).e;
    }

    public final void A(boolean z) {
        c0 c00 = new c0(this, z, null);
        BuildersKt__Builders_commonKt.launch$default(this.i, null, null, c00, 3, null);
    }

    public static final Object e(e0 e00, G g0, Notification httpResponse$Notification0, Continuation continuation0) {
        Q q0;
        e00.getClass();
        if(continuation0 instanceof Q) {
            q0 = (Q)continuation0;
            int v = q0.E;
            if((v & 0x80000000) == 0) {
                q0 = new Q(e00, continuation0);
            }
            else {
                q0.E = v ^ 0x80000000;
            }
        }
        else {
            q0 = new Q(e00, continuation0);
        }
        Object object0 = q0.B;
        ne.a a0 = ne.a.a;
        switch(q0.E) {
            case 0: {
                n.D(object0);
                String s = g0.a();
                String s1 = "RequestLoginFailure+reqMemberKey:" + ("+loginMethodDesc:" + s) + ("+errorMessage:" + (httpResponse$Notification0 == null ? null : httpResponse$Notification0.message));
                q.f(s1, "toString(...)");
                Reporter.createReporter(Type.LOGIN, LogLevel.INFO).setMessage(s1).report();
                q0.r = g0;
                q0.w = httpResponse$Notification0;
                q0.E = 1;
                if(e00.z(s, false, q0) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                httpResponse$Notification0 = q0.w;
                g0 = q0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        j.b(httpResponse$Notification0, false, 3);
        if(g0 instanceof w) {
            c.a();
        }
        e00.l = 0;
        return H.a;
    }

    public static final Object f(e0 e00, G g0, r r0, Continuation continuation0) {
        G g4;
        String s7;
        LoginUser loginUser5;
        LoginUser loginUser4;
        String s5;
        String s4;
        G g2;
        String s3;
        LoginUser loginUser3;
        G g1;
        LoginUser loginUser2;
        String s2;
        LoginUser loginUser1;
        String s1;
        S s0;
        CoroutineDispatcher coroutineDispatcher0 = e00.h;
        if(continuation0 instanceof S) {
            s0 = (S)continuation0;
            int v = s0.I;
            if((v & 0x80000000) == 0) {
                s0 = new S(e00, continuation0);
            }
            else {
                s0.I = v ^ 0x80000000;
            }
        }
        else {
            s0 = new S(e00, continuation0);
        }
        Object object0 = s0.E;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(s0.I) {
            case 0: {
                n.D(object0);
                s1 = g0.a();
                LoginUser loginUser0 = ((j1)e00.b).f;
                if(e.k.A(new r[]{r.e, r.f}).contains(r0)) {
                    q.d("");
                    s0.r = g0;
                    s0.w = s1;
                    s0.B = loginUser0;
                    s0.D = "";
                    s0.I = 1;
                    t1 t10 = e00.d.a.a;
                    AccountManager accountManager0 = t10.b;
                    Account account0 = t10.b("");
                    if(account0 == null) {
                        loginUser1 = loginUser0;
                        if(t10.a().size() < 3) {
                            Account account1 = new Account("", "com.iloen.auth.login");
                            try {
                                if(accountManager0.addAccountExplicitly(account1, null, null)) {
                                    accountManager0.setUserData(account1, "melon_key_updated_time", "1757130099887");
                                    accountManager0.setAuthToken(account1, "com.iloen.auth.login", "");
                                }
                                else {
                                    LogU.debug$default(t10.c, "addAccount failed", null, false, 6, null);
                                }
                            }
                            catch(Exception exception0) {
                                LogU.error$default(t10.c, "addAccount failed", exception0, false, 4, null);
                            }
                        }
                        else {
                            LogU.debug$default(t10.c, "canAddAccount is false", null, false, 6, null);
                        }
                    }
                    else {
                        accountManager0.setUserData(account0, "melon_key_updated_time", "1757130099886");
                        accountManager0.setAuthToken(account0, "com.iloen.auth.login", "");
                        loginUser1 = loginUser0;
                    }
                    if(h0 == a0) {
                        return a0;
                    }
                }
                else {
                    loginUser1 = loginUser0;
                }
                s2 = "";
                loginUser2 = loginUser1;
                g1 = g0;
                goto label_58;
            }
            case 1: {
                s2 = s0.D;
                loginUser2 = s0.B;
                s1 = s0.w;
                g1 = s0.r;
                n.D(object0);
            label_58:
                a7.c.a().b("login");
                a7.c c0 = a7.c.a();
                I7.k k0 = new I7.k(c0.a, "loginMethodDesc", s1, 27);
                c0.a.o.a.a(k0);
                T t0 = new T(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                s0.r = g1;
                s0.w = s1;
                s0.B = loginUser2;
                s0.D = s2;
                s0.I = 2;
                if(BuildersKt.withContext(coroutineDispatcher0, t0, s0) != a0) {
                    goto label_75;
                }
                return a0;
            }
            case 2: {
                s2 = s0.D;
                loginUser2 = s0.B;
                s1 = s0.w;
                g1 = s0.r;
                n.D(object0);
            label_75:
                U u0 = new U(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                s0.r = g1;
                s0.w = s1;
                s0.B = loginUser2;
                s0.D = s2;
                s0.I = 3;
                if(BuildersKt.withContext(coroutineDispatcher0, u0, s0) != a0) {
                    loginUser3 = loginUser2;
                    s3 = s1;
                    g2 = g1;
                    goto label_91;
                }
                return a0;
            }
            case 3: {
                s2 = s0.D;
                loginUser3 = s0.B;
                s3 = s0.w;
                g2 = s0.r;
                n.D(object0);
            label_91:
                if(TextUtils.isEmpty(s2)) {
                    MelonSettingInfo.setOfflineMemberKey("");
                }
                else {
                    try {
                        MelonSettingInfo.setOfflineMemberKey(MelonCryptoManager.encrypt(s2));
                    }
                    catch(Exception unused_ex) {
                    }
                }
                if(loginUser3.getMacOk()) {
                    s4 = "";
                }
                else {
                    s4 = e00.f.j() ? "" : "88888888888";
                }
                MelonSettingInfo.setVirtualMin(s4);
                new t(0).execute(null);
                V v1 = new V(e00, null);
                s0.r = g2;
                s0.w = s3;
                s0.B = loginUser3;
                s0.D = s2;
                s0.I = 4;
                if(BuildersKt.withContext(coroutineDispatcher0, v1, s0) != a0) {
                    goto label_114;
                }
                return a0;
            }
            case 4: {
                s2 = s0.D;
                loginUser3 = s0.B;
                s3 = s0.w;
                g2 = s0.r;
                n.D(object0);
            label_114:
                if(!(g2 instanceof w)) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineDispatcher0), null, null, new W(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                }
                s0.r = g2;
                s0.w = s3;
                s0.B = loginUser3;
                s0.D = s2;
                s0.I = 5;
                b b0 = new b(1, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                H h1 = R8.l.f.j(b0, s0);
                if(h1 != ne.a.a) {
                    h1 = h0;
                }
                if(h1 != a0) {
                    s5 = s2;
                    loginUser4 = loginUser3;
                    goto label_136;
                }
                return a0;
            }
            case 5: {
                s5 = s0.D;
                loginUser4 = s0.B;
                String s6 = s0.w;
                G g3 = s0.r;
                n.D(object0);
                s3 = s6;
                g2 = g3;
            label_136:
                s0.r = g2;
                s0.w = s3;
                s0.B = loginUser4;
                s0.D = s5;
                s0.I = 6;
                R8.a a1 = new R8.a(1, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                H h2 = R8.l.f.j(a1, s0);
                if(h2 != ne.a.a) {
                    h2 = h0;
                }
                if(h2 != a0) {
                    loginUser5 = loginUser4;
                    s7 = s3;
                    g4 = g2;
                    break;
                }
                return a0;
            }
            case 6: {
                s5 = s0.D;
                loginUser5 = s0.B;
                s7 = s0.w;
                g4 = s0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.g(s5, "memberKey");
        p8.k k1 = new p8.k(s5, null);
        BuildersKt__Builders_commonKt.launch$default(p8.q.b, null, null, k1, 3, null);
        q.f("", "getMemberKey(...)");
        Airbridge.setUserID("");
        int v2 = u.I(((e0)(((k)p8.a.a.getValue()))).j()) ? 0x7F130043 : 0x7F130048;  // string:airbridge_kakao "kakao"
        Airbridge.trackEvent("airbridge.user.signin", je.D.O(new m("action", ResourceUtilsKt.getString(v2, new Object[0]))), je.D.O(new m("", ResourceUtilsKt.getString(v2, new Object[0]))));
        p9.a.a(e00.a, 1, "");
        String s8 = "RequestLoginSuccess" + ("+reqMemberKey:" + s5) + ("+loginMethodDesc:" + s7) + ("+loginResMemberType:" + new Integer(loginUser5.getMemberType()));
        q.f(s8, "toString(...)");
        Reporter.createReporter(Type.LOGIN, LogLevel.INFO).setMessage(s8).report();
        if(g4 instanceof w) {
            c.a();
        }
        e00.l = 0;
        return h0;
    }

    public static final void g(e0 e00) {
        e00.l = 0;
        EventBusHelper.post(EventAlertDialog.fromNetworkError(0x7F130609));  // string:melon_login_fail "멜론 로그인 실패하였습니다. 다시 시도해주시기 바랍니다."
    }

    public static final void i(e0 e00, long v, String s, String s1) {
        e00.getClass();
        if(!A8.b.d()) {
            StringBuilder stringBuilder0 = new StringBuilder("updateAutoLoginEventFlow() executeTime: ");
            stringBuilder0.append(v);
            stringBuilder0.append(", caller: ");
            stringBuilder0.append(s);
            String s2 = x.m(stringBuilder0, ", result: ", s1);
            LogU.debug$default(e00.j, s2, null, false, 6, null);
            MutableStateFlow mutableStateFlow0 = e00.m;
            while(true) {
                Object object0 = mutableStateFlow0.getValue();
                String s3 = TimeUtils.INSTANCE.long2Timestamp(v);
                ((va.a)object0).getClass();
                q.g(s3, "executeTime");
                q.g(s, "caller");
                if(mutableStateFlow0.compareAndSet(object0, new va.a(s3, s, s1))) {
                    break;
                }
            }
        }
    }

    public final LoginUser j() {
        return ((j1)this.b).f;
    }

    public final Flow k() {
        return ((j1)this.b).g;
    }

    public final Object l(F0 f00) {
        LoginUser loginUser0;
        long v;
        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
        Mutex mutex0 = this.n;
        LogU.debug$default(mutexLockUtil0.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-getLoginUserSuspend"), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : LoginUseCase-getLoginUserSuspend", devLog0, mutex0);
        if(f00.getContext().get(reentrantMutexContextKey0) != null) {
            try {
                v = System.currentTimeMillis();
                LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-getLoginUserSuspend", null, false, 6, null);
                devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-getLoginUserSuspend");
                loginUser0 = this.j();
            }
            catch(Throwable throwable0) {
                long v1 = System.currentTimeMillis() - v;
                StringBuilder stringBuilder0 = Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-getLoginUserSuspend (", v1);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                l1.C(Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-getLoginUserSuspend (", v1), "ms)", devLog0);
                throw throwable0;
            }
            long v2 = System.currentTimeMillis() - v;
            StringBuilder stringBuilder1 = Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-getLoginUserSuspend (", v2);
            stringBuilder1.append("ms)");
            LogU.debug$default(mutexLockUtil0.getLog(), stringBuilder1.toString(), null, false, 6, null);
            l1.C(Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-getLoginUserSuspend (", v2), "ms)", devLog0);
            return loginUser0;
        }
        return BuildersKt.withContext(new ReentrantMutexContextElement(reentrantMutexContextKey0), new p(mutex0, null, mutex0, devLog0, this), f00);
    }

    public final boolean m() {
        return ((j1)this.b).n();
    }

    public final Flow n() {
        return ((j1)this.b).h;
    }

    public final Object o(oe.c c0) {
        Boolean boolean0;
        long v;
        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
        Mutex mutex0 = this.n;
        LogU.debug$default(mutexLockUtil0.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-isLogin"), null, false, 6, null);
        DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
        ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : LoginUseCase-isLogin", devLog0, mutex0);
        if(c0.getContext().get(reentrantMutexContextKey0) != null) {
            try {
                v = System.currentTimeMillis();
                LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-isLogin", null, false, 6, null);
                devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-isLogin");
                boolean0 = Boolean.valueOf(((j1)this.b).n());
            }
            catch(Throwable throwable0) {
                long v1 = System.currentTimeMillis() - v;
                StringBuilder stringBuilder0 = Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-isLogin (", v1);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                l1.C(Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-isLogin (", v1), "ms)", devLog0);
                throw throwable0;
            }
            long v2 = System.currentTimeMillis() - v;
            StringBuilder stringBuilder1 = Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-isLogin (", v2);
            stringBuilder1.append("ms)");
            LogU.debug$default(mutexLockUtil0.getLog(), stringBuilder1.toString(), null, false, 6, null);
            l1.C(Z.n(mutex0.hashCode(), "ReentrantLock[", "]  Lock return : LoginUseCase-isLogin (", v2), "ms)", devLog0);
            return boolean0;
        }
        return BuildersKt.withContext(new ReentrantMutexContextElement(reentrantMutexContextKey0), new va.q(mutex0, null, mutex0, devLog0, this), c0);
    }

    public final Object p(A8.u u0, String s, oe.c c0) {
        n1 n11;
        String s22;
        e0 e00;
        Object object7;
        String s21;
        long v24;
        Object object6;
        Mutex mutex4;
        String s19;
        long v22;
        Object object5;
        int v19;
        int v18;
        ne.a a3;
        int v17;
        String s18;
        n1 n10;
        Mutex mutex3;
        String s17;
        Mutex mutex2;
        String s15;
        Object object4;
        DevLog devLog3;
        long v16;
        int v11;
        String s13;
        int v10;
        String s12;
        int v9;
        ne.a a2;
        Object object3;
        w w1;
        int v8;
        String s11;
        A8.u u1;
        String s9;
        Object object2;
        DevLog devLog2;
        long v7;
        String s8;
        String s7;
        int v6;
        String s6;
        int v5;
        int v4;
        ne.a a1;
        long v2;
        DevLog devLog1;
        String s5;
        String s4;
        long v1;
        DevLog devLog0;
        Mutex mutex0;
        String s3;
        String s2;
        s s1;
        if(c0 instanceof s) {
            s1 = (s)c0;
            int v = s1.e0;
            if((v & 0x80000000) == 0) {
                s1 = new s(this, c0);
            }
            else {
                s1.e0 = v ^ 0x80000000;
            }
        }
        else {
            s1 = new s(this, c0);
        }
        Object object0 = s1.c0;
        ne.a a0 = ne.a.a;
        switch(s1.e0) {
            case 0: {
                n.D(object0);
                if(!Td.b.f(this.a, l9.a.c)) {
                    return new g0(N0.d);
                }
                s2 = "LoginUseCase-loginByAuto";
                s3 = "";
                mutex0 = this.n;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByAuto"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : LoginUseCase-loginByAuto", devLog0, mutex0);
                if(s1.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByAuto", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByAuto");
                        new w(this.l);
                        LogU.debug$default(this.j, "loginByAuto() userId : , token is empty: " + true, null, false, 6, null);
                        object0 = new g0(M0.d);
                        break;
                    }
                    catch(Throwable throwable0) {
                        s4 = "LoginUseCase-loginByAuto";
                        s5 = "";
                        devLog1 = devLog0;
                        v2 = v1;
                        goto label_460;
                    }
                }
                a1 = a0;
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                va.r r0 = new va.r(mutex0, null, mutex0, devLog0, this, s, u0);
                s1.r = null;
                s1.w = null;
                s1.B = null;
                s1.D = null;
                s1.E = null;
                s1.G = null;
                s1.W = 0;
                s1.X = 0;
                s1.e0 = 9;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, r0, s1);
                return object1 == a1 ? a1 : object1;
            }
            case 1: {
                try {
                    int v3 = s1.Y;
                    v4 = s1.X;
                    v5 = s1.W;
                    s6 = s1.S;
                    v6 = s1.Z;
                    s7 = s1.N;
                    s8 = s1.M;
                    v7 = s1.b0;
                    devLog2 = s1.E;
                    object2 = s1.G;
                    s9 = s1.D;
                    Mutex mutex1 = s1.B;
                    w w0 = s1.I;
                    String s10 = s1.w;
                    u1 = s1.r;
                    mutex0 = mutex1;
                    n.D(object0);
                    mutex0 = mutex1;
                    s11 = s10;
                    devLog0 = devLog2;
                    s3 = object2;
                    v8 = v3;
                    w1 = w0;
                    v1 = v7;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog2;
                    s5 = object2;
                    s4 = s9;
                    v2 = v7;
                    goto label_460;
                }
                try {
                    if(((Boolean)object0).booleanValue()) {
                        e0.i(this, i.c(this), s11, "SKIPPED");
                        this.l = 0;
                        object0 = new g0(K0.d);
                        s2 = s9;
                    }
                    else {
                        s1.r = null;
                        s1.w = s11;
                        s1.B = mutex0;
                        s1.D = s9;
                        s1.E = devLog0;
                        s1.G = s3;
                        s1.I = w1;
                        s1.M = null;
                        s1.N = null;
                        s1.S = s6;
                        s1.W = v5;
                        s1.X = v4;
                        s1.Y = v8;
                        s1.b0 = v1;
                        s1.Z = v6;
                        s1.e0 = 2;
                        object3 = ((j1)this.b).c(s8, s7, u1, s1);
                        a2 = a0;
                        goto label_116;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    s4 = s9;
                    s5 = s3;
                    devLog1 = devLog0;
                    v2 = v1;
                    goto label_460;
                }
            label_116:
                if(object3 == a2) {
                    return a2;
                }
                v9 = v5;
                v2 = v1;
                s12 = s6;
                v10 = v6;
                s13 = s9;
                v11 = v4;
                goto label_160;
            }
            case 2: {
                try {
                    int v12 = s1.Y;
                    int v13 = s1.X;
                    int v14 = s1.W;
                    String s14 = s1.S;
                    int v15 = s1.Z;
                    v16 = s1.b0;
                    devLog3 = s1.E;
                    object4 = s1.G;
                    s15 = s1.D;
                    mutex2 = s1.B;
                    w w2 = s1.I;
                    String s16 = s1.w;
                    n.D(object0);
                    v11 = v13;
                    s13 = s15;
                    s3 = object4;
                    s11 = s16;
                    object3 = object0;
                    s12 = s14;
                    a2 = a0;
                    v8 = v12;
                    w1 = w2;
                    v10 = v15;
                    mutex0 = mutex2;
                    v2 = v16;
                    devLog0 = devLog3;
                    v9 = v14;
                }
                catch(Throwable throwable0) {
                    s5 = object4;
                    mutex0 = mutex2;
                    devLog1 = devLog3;
                    v2 = v16;
                    s4 = s15;
                    goto label_460;
                }
                try {
                label_160:
                    LogU.debug$default(this.j, "loginByAuto() result : " + ((n1)object3), null, false, 6, null);
                    c9.a.a(s12, s11, ((n1)object3));
                    if(((n1)object3) instanceof m1) {
                        goto label_249;
                    }
                    else {
                        a1 = a2;
                        if(((n1)object3) instanceof k1) {
                            goto label_226;
                        }
                        else {
                            if(!(((n1)object3) instanceof va.l1)) {
                                throw new M3(9);
                            }
                            if(this.l >= 3) {
                                if(this.m()) {
                                    s1.r = null;
                                    s1.w = null;
                                    s1.B = mutex0;
                                    s1.D = s13;
                                    s1.E = devLog0;
                                    s1.G = s3;
                                    s1.I = null;
                                    s1.M = null;
                                    s1.N = null;
                                    s1.S = null;
                                    s1.T = (va.l1)(((n1)object3));
                                    s1.W = v9;
                                    s1.X = v11;
                                    s1.Y = v8;
                                    s1.b0 = v2;
                                    s1.Z = v10;
                                    s1.e0 = 8;
                                    if(e0.f(this, w1, r.c, s1) != a1) {
                                        s17 = s13;
                                        s5 = s3;
                                        mutex3 = mutex0;
                                        devLog1 = devLog0;
                                        n10 = (n1)object3;
                                        v1 = v2;
                                        object0 = new f0(((va.l1)n10).a);
                                        goto label_469;
                                    }
                                    return a1;
                                }
                                else {
                                    this.l = 0;
                                    n10 = (n1)object3;
                                    s17 = s13;
                                    s5 = s3;
                                    mutex3 = mutex0;
                                    devLog1 = devLog0;
                                    v1 = v2;
                                    object0 = new f0(((va.l1)n10).a);
                                }
                                goto label_469;
                            }
                            else {
                                goto label_202;
                            }
                        }
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    s4 = s13;
                    s5 = s3;
                    devLog1 = devLog0;
                    goto label_460;
                }
                try {
                    v1 = v2;
                    object0 = new f0(((va.l1)n10).a);
                    goto label_469;
                }
                catch(Throwable throwable0) {
                    goto label_458;
                }
                try {
                label_202:
                    ++this.l;
                    s1.r = null;
                    s18 = s11;
                    s1.w = s18;
                    s1.B = mutex0;
                    s1.D = s13;
                    s1.E = devLog0;
                    s1.G = s3;
                    s1.I = null;
                    s1.M = null;
                    s1.N = null;
                    s1.S = null;
                    s1.T = null;
                    s1.W = v9;
                    s1.X = v11;
                    s1.Y = v8;
                    s1.b0 = v2;
                    s1.Z = v10;
                    s1.e0 = 6;
                    if(DelayKt.delay-VtjQ1oo(e0.o, s1) != a1) {
                        s5 = s3;
                        devLog1 = devLog0;
                        v17 = v9;
                        goto label_393;
                    label_226:
                        s1.r = null;
                        s1.w = null;
                        s1.B = mutex0;
                        s1.D = s13;
                        s1.E = devLog0;
                        s1.G = s3;
                        s1.I = null;
                        s1.M = null;
                        s1.N = null;
                        s1.S = null;
                        s1.T = null;
                        s1.W = v9;
                        s1.X = v11;
                        s1.Y = v8;
                        s1.b0 = v2;
                        s1.Z = v10;
                        s1.e0 = 5;
                        if(e0.e(this, w1, ((k1)(((n1)object3))).a, s1) != a1) {
                            s17 = s13;
                            s5 = s3;
                            mutex3 = mutex0;
                            devLog1 = devLog0;
                            object0 = new g0(L0.d);
                            goto label_418;
                        label_249:
                            s1.r = null;
                            s1.w = s11;
                            s1.B = mutex0;
                            s1.D = s13;
                            s1.E = devLog0;
                            s1.G = s3;
                            s1.I = null;
                            s1.M = null;
                            s1.N = null;
                            s1.S = null;
                            s1.T = null;
                            s1.W = v9;
                            s1.X = v11;
                            s1.Y = v8;
                            s1.b0 = v2;
                            s1.Z = v10;
                            s1.e0 = 3;
                            a3 = a2;
                            if(e0.f(this, w1, ((m1)(((n1)object3))).a, s1) != a3) {
                                v18 = v10;
                                v19 = v8;
                                s17 = s13;
                                goto label_300;
                            }
                            return a3;
                        }
                    }
                    return a1;
                }
                catch(Throwable throwable0) {
                    s4 = s13;
                    s5 = s3;
                    devLog1 = devLog0;
                    goto label_460;
                }
                v18 = v10;
                v19 = v8;
                s17 = s13;
                goto label_300;
            }
            case 3: {
                try {
                    v19 = s1.Y;
                    int v20 = s1.X;
                    int v21 = s1.W;
                    object5 = s1.G;
                    devLog1 = s1.E;
                    v22 = s1.b0;
                    s19 = s1.D;
                    mutex4 = s1.B;
                    int v23 = s1.Z;
                    String s20 = s1.w;
                    n.D(object0);
                    s11 = s20;
                    devLog0 = devLog1;
                    v9 = v21;
                    s3 = object5;
                    v18 = v23;
                    mutex0 = mutex4;
                    v11 = v20;
                    a3 = a0;
                    s17 = s19;
                    v2 = v22;
                }
                catch(Throwable throwable0) {
                    s4 = s19;
                    mutex0 = mutex4;
                    s5 = object5;
                    v2 = v22;
                    goto label_460;
                }
                try {
                label_300:
                    s1.r = null;
                    s1.w = s11;
                    s1.B = mutex0;
                    s1.D = s17;
                    s1.E = devLog0;
                    s1.G = s3;
                    s1.I = null;
                    s1.M = null;
                    s1.N = null;
                    s1.S = null;
                    s1.T = null;
                    s1.V = this;
                    s1.W = v9;
                    s1.X = v11;
                    s1.Y = v19;
                    s1.b0 = v2;
                    s1.Z = v18;
                    s1.e0 = 4;
                    object6 = FlowKt.first(new pd.s(FlowKt.catch(((j1)this.b).b.a.getData(), new n0(((j1)this.b).b, null, 1)), 7), s1);
                }
                catch(Throwable throwable0) {
                    s5 = s3;
                    s4 = s17;
                    devLog1 = devLog0;
                    goto label_460;
                }
                if(object6 != a3) {
                    v24 = v2;
                    s5 = s3;
                    devLog1 = devLog0;
                    s21 = s11;
                    object7 = object6;
                    e00 = this;
                    goto label_349;
                }
                return a3;
            }
            case 4: {
                try {
                    v2 = s1.b0;
                    e00 = s1.V;
                    s5 = s1.G;
                    devLog1 = s1.E;
                    s17 = s1.D;
                    Mutex mutex5 = s1.B;
                    s21 = s1.w;
                    mutex0 = mutex5;
                    n.D(object0);
                    mutex0 = mutex5;
                    v24 = v2;
                    object7 = object0;
                }
                catch(Throwable throwable0) {
                    s4 = s17;
                    goto label_460;
                }
                try {
                label_349:
                    e0.i(e00, ((Number)object7).longValue(), s21, "SUCCESS");
                    object0 = h0.a;
                    v1 = v24;
                    devLog0 = devLog1;
                    s3 = s5;
                    s2 = s17;
                    break;
                }
                catch(Throwable throwable0) {
                    v2 = v24;
                    goto label_459;
                }
            }
            case 5: {
                try {
                    v2 = s1.b0;
                    s5 = s1.G;
                    devLog1 = s1.E;
                    s17 = s1.D;
                    mutex3 = s1.B;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                    mutex0 = mutex3;
                    s4 = s17;
                    goto label_460;
                }
                try {
                    object0 = new g0(L0.d);
                    goto label_418;
                }
                catch(Throwable throwable0) {
                    goto label_458;
                }
            }
            case 6: {
                try {
                    long v25 = s1.b0;
                    int v26 = s1.Y;
                    int v27 = s1.X;
                    v17 = s1.W;
                    Object object8 = s1.G;
                    int v28 = s1.Z;
                    DevLog devLog4 = s1.E;
                    s22 = s1.D;
                    Mutex mutex6 = s1.B;
                    s18 = s1.w;
                    devLog1 = devLog4;
                    s5 = object8;
                    mutex0 = mutex6;
                    v2 = v25;
                    n.D(object0);
                    v11 = v27;
                    devLog1 = devLog4;
                    s13 = s22;
                    a1 = a0;
                    v8 = v26;
                    s5 = object8;
                    mutex0 = mutex6;
                    v2 = v25;
                    v10 = v28;
                }
                catch(Throwable throwable0) {
                    s4 = s22;
                    goto label_460;
                }
                try {
                label_393:
                    s1.r = null;
                    s1.w = null;
                    s1.B = mutex0;
                    s1.D = s13;
                    s1.E = devLog1;
                    s1.G = s5;
                    s1.I = null;
                    s1.M = null;
                    s1.N = null;
                    s1.S = null;
                    s1.T = null;
                    s1.W = v17;
                    s1.X = v11;
                    s1.Y = v8;
                    s1.b0 = v2;
                    s1.Z = v10;
                    s1.e0 = 7;
                    object0 = k.a(this, s18 + this.l, s1);
                }
                catch(Throwable throwable0) {
                    s4 = s13;
                    goto label_460;
                }
                if(object0 != a1) {
                    s17 = s13;
                    mutex3 = mutex0;
                label_418:
                    v1 = v2;
                    devLog0 = devLog1;
                    mutex0 = mutex3;
                    s3 = s5;
                    s2 = s17;
                    break;
                }
                try {
                    return a1;
                }
                catch(Throwable throwable0) {
                    s4 = s13;
                    s5 = s3;
                }
                devLog1 = devLog0;
                goto label_460;
            }
            case 7: {
                try {
                    v2 = s1.b0;
                    s5 = s1.G;
                    devLog1 = s1.E;
                    s17 = s1.D;
                    mutex3 = s1.B;
                    n.D(object0);
                    v1 = v2;
                    devLog0 = devLog1;
                    mutex0 = mutex3;
                    s3 = s5;
                    s2 = s17;
                    break;
                label_442:
                    v2 = s1.b0;
                    n11 = s1.T;
                    s5 = s1.G;
                    devLog1 = s1.E;
                    s17 = s1.D;
                    mutex3 = s1.B;
                    n.D(object0);
                    v1 = v2;
                    object0 = new f0(((va.l1)n11).a);
                    goto label_469;
                }
                catch(Throwable throwable0) {
                }
                mutex0 = mutex3;
                s4 = s17;
                goto label_460;
            }
            case 8: {
                goto label_442;
                try {
                    v1 = v2;
                    object0 = new f0(((va.l1)n11).a);
                    goto label_469;
                }
                catch(Throwable throwable0) {
                label_458:
                    mutex0 = mutex3;
                }
            label_459:
                s4 = s17;
            label_460:
                long v29 = System.currentTimeMillis() - v2;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s5);
                H0.b.t(v29, s4, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s5);
                H0.b.t(v29, s4, " (", stringBuilder1);
                l1.C(stringBuilder1, "ms)", devLog1);
                throw throwable0;
            label_469:
                devLog0 = devLog1;
                mutex0 = mutex3;
                s3 = s5;
                s2 = s17;
                break;
            }
            case 9: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v30 = System.currentTimeMillis() - v1;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s3);
        H0.b.t(v30, s2, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s3);
        H0.b.t(v30, s2, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog0);
        return object0;
    }

    public final Object q(String s, String s1, oe.c c0) {
        com.iloen.melon.custom.L0 l03;
        DevLog devLog4;
        Mutex mutex5;
        long v13;
        Mutex mutex4;
        Object object4;
        ne.a a3;
        Mutex mutex3;
        String s4;
        com.iloen.melon.custom.L0 l02;
        DevLog devLog3;
        long v8;
        n1 n10;
        int v7;
        A8.x x1;
        int v6;
        int v5;
        int v4;
        Mutex mutex2;
        DevLog devLog2;
        com.iloen.melon.custom.L0 l01;
        String s3;
        com.iloen.melon.custom.L0 l00;
        String s2;
        Object object1;
        A8.x x0;
        a a2;
        DevLog devLog1;
        Mutex mutex1;
        k8.b b0;
        long v3;
        v v0;
        if(c0 instanceof v) {
            v0 = (v)c0;
            int v1 = v0.X;
            if((v1 & 0x80000000) == 0) {
                v0 = new v(this, c0);
            }
            else {
                v0.X = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new v(this, c0);
        }
        Object object0 = v0.V;
        ne.a a0 = ne.a.a;
        int v2 = v0.X;
        switch(v2) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.n;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByIdAndPassword()"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : LoginUseCase-loginByIdAndPassword()", devLog0, mutex0);
                g g0 = v0.getContext().get(reentrantMutexContextKey0);
                a a1 = this.g;
                if(g0 != null) {
                    try {
                        v3 = System.currentTimeMillis();
                        b0 = (k8.b)a1;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        a2 = a1;
                        goto label_67;
                    }
                    try {
                        b0.a(" LoginUseCase-loginByIdAndPassword()", true);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        a2 = a1;
                        goto label_67;
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByIdAndPassword()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByIdAndPassword()");
                        x0 = () -> "ID_PWD";
                        v0.r = mutex0;
                        v0.w = "LoginUseCase-loginByIdAndPassword()";
                        v0.B = a1;
                        v0.D = devLog0;
                        v0.E = "";
                        v0.G = x0;
                        v0.I = 0;
                        v0.M = 0;
                        v0.N = 0;
                        v0.T = v3;
                        v0.S = 0;
                        v0.X = 1;
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog0;
                        mutex1 = mutex0;
                        s2 = "";
                        l00 = a1;
                        s3 = "LoginUseCase-loginByIdAndPassword()";
                        goto label_226;
                    }
                    try {
                        a2 = a1;
                        object1 = ((j1)this.b).d(s, s1, v0);
                        goto label_72;
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog0;
                        mutex1 = mutex0;
                    }
                label_67:
                    a1 = a2;
                    s2 = "";
                    l00 = a1;
                    s3 = "LoginUseCase-loginByIdAndPassword()";
                    goto label_226;
                label_72:
                    if(object1 == a0) {
                        return a0;
                    }
                    try {
                        l01 = a2;
                        s2 = "";
                        devLog2 = devLog0;
                        mutex2 = mutex0;
                        s3 = "LoginUseCase-loginByIdAndPassword()";
                        v4 = 0;
                        v5 = 0;
                        v6 = 0;
                        x1 = x0;
                        v7 = 0;
                        n10 = (n1)object1;
                        LogU.debug$default(this.j, "loginByIdAndPassword() result : " + n10, null, false, 6, null);
                        goto label_134;
                    }
                    catch(Throwable throwable0) {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        mutex1 = mutex5;
                        devLog1 = devLog4;
                        l00 = l03;
                        goto label_226;
                    }
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                va.u u0 = new va.u(mutex0, null, a1, mutex0, devLog0, this, s, s1);
                v0.r = null;
                v0.w = null;
                v0.B = null;
                v0.D = null;
                v0.E = null;
                v0.I = 0;
                v0.M = 0;
                v0.X = 4;
                Object object2 = BuildersKt.withContext(reentrantMutexContextElement0, u0, v0);
                return object2 == a0 ? a0 : object2;
            }
            case 1: {
                try {
                    v8 = v0.T;
                    int v9 = v0.N;
                    int v10 = v0.M;
                    int v11 = v0.I;
                    A8.x x2 = v0.G;
                    int v12 = v0.S;
                    Object object3 = v0.E;
                    devLog3 = v0.D;
                    l02 = v0.B;
                    s4 = v0.w;
                    mutex3 = v0.r;
                    s2 = object3;
                    n.D(object0);
                    v4 = v12;
                    v6 = v10;
                    devLog2 = devLog3;
                    v5 = v11;
                    mutex2 = mutex3;
                    x1 = x2;
                    v7 = v9;
                    s2 = object3;
                    v3 = v8;
                    l01 = l02;
                    s3 = s4;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog3;
                    mutex1 = mutex3;
                    v3 = v8;
                    l00 = l02;
                    s3 = s4;
                    goto label_226;
                }
                try {
                    n10 = (n1)object0;
                    LogU.debug$default(this.j, "loginByIdAndPassword() result : " + n10, null, false, 6, null);
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex2;
                    devLog4 = devLog2;
                    l03 = l01;
                    mutex1 = mutex5;
                    devLog1 = devLog4;
                    l00 = l03;
                    goto label_226;
                }
            label_134:
                if(n10 instanceof m1) {
                    try {
                        v0.r = mutex2;
                        v0.w = s3;
                        v0.B = l01;
                        v0.D = devLog2;
                        v0.E = s2;
                        v0.G = null;
                        v0.I = v5;
                        v0.M = v6;
                        v0.N = v7;
                        v0.T = v3;
                        v0.S = v4;
                        v0.X = 2;
                        a3 = a0;
                        if(e0.f(this, x1, ((m1)n10).a, v0) != a3) {
                            object4 = h0.a;
                            break;
                        }
                        return a3;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        devLog1 = devLog2;
                        l00 = l01;
                        goto label_226;
                    }
                    try {
                        object4 = h0.a;
                    }
                    catch(Throwable throwable0) {
                        goto label_222;
                    }
                }
                else if(n10 instanceof k1) {
                    try {
                        v0.r = mutex2;
                        v0.w = s3;
                        v0.B = l01;
                        v0.D = devLog2;
                        v0.E = s2;
                        v0.G = null;
                        v0.I = v5;
                        v0.M = v6;
                        v0.N = v7;
                        v0.T = v3;
                        v0.S = v4;
                        v0.X = 3;
                        a3 = a0;
                        if(e0.e(this, x1, ((k1)n10).a, v0) != a3) {
                            mutex4 = mutex2;
                            v13 = v3;
                            object4 = new g0(L0.d);
                            v3 = v13;
                            mutex2 = mutex4;
                            break;
                        }
                        return a3;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        devLog1 = devLog2;
                        l00 = l01;
                        goto label_226;
                    }
                    try {
                        mutex4 = mutex2;
                        v13 = v3;
                        object4 = new g0(L0.d);
                        v3 = v13;
                        mutex2 = mutex4;
                        break;
                    }
                    catch(Throwable throwable0) {
                        goto label_222;
                    }
                    return a3;
                }
                else {
                    try {
                        if(n10 instanceof va.l1) {
                            e0.g(this);
                            object4 = new f0(((va.l1)n10).a);
                            break;
                        }
                    }
                    catch(Throwable throwable0) {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        mutex1 = mutex5;
                        devLog1 = devLog4;
                        l00 = l03;
                        goto label_226;
                    }
                    try {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    catch(Throwable throwable0) {
                    }
                    mutex1 = mutex5;
                    devLog1 = devLog4;
                    l00 = l03;
                    goto label_226;
                }
                break;
            }
            case 2: {
                try {
                    v13 = v0.T;
                    s2 = v0.E;
                    devLog2 = v0.D;
                    l01 = v0.B;
                    s3 = v0.w;
                    mutex4 = v0.r;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                    goto label_214;
                }
                try {
                    object4 = h0.a;
                    v3 = v13;
                    mutex2 = mutex4;
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_222;
                }
            }
            case 3: {
                try {
                    v13 = v0.T;
                    s2 = v0.E;
                    devLog2 = v0.D;
                    l01 = v0.B;
                    s3 = v0.w;
                    mutex4 = v0.r;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                label_214:
                    devLog1 = devLog2;
                    mutex1 = mutex4;
                    l00 = l01;
                    v3 = v13;
                    goto label_226;
                }
                try {
                    object4 = new g0(L0.d);
                    v3 = v13;
                    mutex2 = mutex4;
                    break;
                }
                catch(Throwable throwable0) {
                label_222:
                    v3 = v13;
                    devLog1 = devLog2;
                    l00 = l01;
                    mutex1 = mutex4;
                }
            label_226:
                long v14 = System.currentTimeMillis() - v3;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
                H0.b.t(v14, s3, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
                H0.b.t(v14, s3, " (", stringBuilder1);
                l1.C(stringBuilder1, "ms)", devLog1);
                if(l00 != null) {
                    com.iloen.melon.utils.a.u(s2, " ", s3, l00, false);
                }
                throw throwable0;
            }
            default: {
                if(v2 != 4) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                return object0;
            }
        }
        long v15 = System.currentTimeMillis() - v3;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s2);
        H0.b.t(v15, s3, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s2);
        H0.b.t(v15, s3, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog2);
        if(l01 != null) {
            com.iloen.melon.utils.a.u(s2, " ", s3, l01, false);
        }
        return object4;
    }

    public final Object r(String s, String s1, oe.c c0) {
        com.iloen.melon.custom.L0 l03;
        DevLog devLog4;
        Mutex mutex5;
        long v12;
        Mutex mutex4;
        Object object4;
        ne.a a3;
        Mutex mutex3;
        String s4;
        com.iloen.melon.custom.L0 l02;
        DevLog devLog3;
        long v7;
        n1 n10;
        int v6;
        y y1;
        int v5;
        int v4;
        int v3;
        Mutex mutex2;
        DevLog devLog2;
        com.iloen.melon.custom.L0 l01;
        String s3;
        com.iloen.melon.custom.L0 l00;
        String s2;
        Object object1;
        y y0;
        a a2;
        DevLog devLog1;
        Mutex mutex1;
        k8.b b0;
        long v2;
        va.x x0;
        if(c0 instanceof va.x) {
            x0 = (va.x)c0;
            int v = x0.X;
            if((v & 0x80000000) == 0) {
                x0 = new va.x(this, c0);
            }
            else {
                x0.X = v ^ 0x80000000;
            }
        }
        else {
            x0 = new va.x(this, c0);
        }
        Object object0 = x0.V;
        ne.a a0 = ne.a.a;
        int v1 = x0.X;
        switch(v1) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.n;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByIdAndPasswordWithUsingSimple()"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : LoginUseCase-loginByIdAndPasswordWithUsingSimple()", devLog0, mutex0);
                g g0 = x0.getContext().get(reentrantMutexContextKey0);
                a a1 = this.g;
                if(g0 != null) {
                    try {
                        v2 = System.currentTimeMillis();
                        b0 = (k8.b)a1;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        a2 = a1;
                        goto label_67;
                    }
                    try {
                        b0.a(" LoginUseCase-loginByIdAndPasswordWithUsingSimple()", true);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        a2 = a1;
                        goto label_67;
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByIdAndPasswordWithUsingSimple()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginByIdAndPasswordWithUsingSimple()");
                        y0 = () -> "ID_PWD_SAVE_SIMPLE";
                        x0.r = mutex0;
                        x0.w = "LoginUseCase-loginByIdAndPasswordWithUsingSimple()";
                        x0.B = a1;
                        x0.D = devLog0;
                        x0.E = "";
                        x0.G = y0;
                        x0.I = 0;
                        x0.M = 0;
                        x0.N = 0;
                        x0.T = v2;
                        x0.S = 0;
                        x0.X = 1;
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog0;
                        mutex1 = mutex0;
                        s2 = "";
                        l00 = a1;
                        s3 = "LoginUseCase-loginByIdAndPasswordWithUsingSimple()";
                        goto label_226;
                    }
                    try {
                        a2 = a1;
                        object1 = ((j1)this.b).e(s, s1, x0);
                        goto label_72;
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog0;
                        mutex1 = mutex0;
                    }
                label_67:
                    a1 = a2;
                    s2 = "";
                    l00 = a1;
                    s3 = "LoginUseCase-loginByIdAndPasswordWithUsingSimple()";
                    goto label_226;
                label_72:
                    if(object1 == a0) {
                        return a0;
                    }
                    try {
                        l01 = a2;
                        s2 = "";
                        devLog2 = devLog0;
                        mutex2 = mutex0;
                        s3 = "LoginUseCase-loginByIdAndPasswordWithUsingSimple()";
                        v3 = 0;
                        v4 = 0;
                        v5 = 0;
                        y1 = y0;
                        v6 = 0;
                        n10 = (n1)object1;
                        LogU.debug$default(this.j, "loginByIdAndPasswordWithSimple() result : " + n10, null, false, 6, null);
                        goto label_134;
                    }
                    catch(Throwable throwable0) {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        mutex1 = mutex5;
                        devLog1 = devLog4;
                        l00 = l03;
                        goto label_226;
                    }
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                va.w w0 = new va.w(mutex0, null, a1, mutex0, devLog0, this, s, s1);
                x0.r = null;
                x0.w = null;
                x0.B = null;
                x0.D = null;
                x0.E = null;
                x0.I = 0;
                x0.M = 0;
                x0.X = 4;
                Object object2 = BuildersKt.withContext(reentrantMutexContextElement0, w0, x0);
                return object2 == a0 ? a0 : object2;
            }
            case 1: {
                try {
                    v7 = x0.T;
                    int v8 = x0.N;
                    int v9 = x0.M;
                    int v10 = x0.I;
                    y y2 = x0.G;
                    int v11 = x0.S;
                    Object object3 = x0.E;
                    devLog3 = x0.D;
                    l02 = x0.B;
                    s4 = x0.w;
                    mutex3 = x0.r;
                    s2 = object3;
                    n.D(object0);
                    v3 = v11;
                    v5 = v9;
                    devLog2 = devLog3;
                    v4 = v10;
                    mutex2 = mutex3;
                    y1 = y2;
                    v6 = v8;
                    s2 = object3;
                    v2 = v7;
                    l01 = l02;
                    s3 = s4;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog3;
                    mutex1 = mutex3;
                    v2 = v7;
                    l00 = l02;
                    s3 = s4;
                    goto label_226;
                }
                try {
                    n10 = (n1)object0;
                    LogU.debug$default(this.j, "loginByIdAndPasswordWithSimple() result : " + n10, null, false, 6, null);
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex2;
                    devLog4 = devLog2;
                    l03 = l01;
                    mutex1 = mutex5;
                    devLog1 = devLog4;
                    l00 = l03;
                    goto label_226;
                }
            label_134:
                if(n10 instanceof m1) {
                    try {
                        x0.r = mutex2;
                        x0.w = s3;
                        x0.B = l01;
                        x0.D = devLog2;
                        x0.E = s2;
                        x0.G = null;
                        x0.I = v4;
                        x0.M = v5;
                        x0.N = v6;
                        x0.T = v2;
                        x0.S = v3;
                        x0.X = 2;
                        a3 = a0;
                        if(e0.f(this, y1, ((m1)n10).a, x0) != a3) {
                            object4 = h0.a;
                            break;
                        }
                        return a3;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        devLog1 = devLog2;
                        l00 = l01;
                        goto label_226;
                    }
                    try {
                        object4 = h0.a;
                    }
                    catch(Throwable throwable0) {
                        goto label_222;
                    }
                }
                else if(n10 instanceof k1) {
                    try {
                        x0.r = mutex2;
                        x0.w = s3;
                        x0.B = l01;
                        x0.D = devLog2;
                        x0.E = s2;
                        x0.G = null;
                        x0.I = v4;
                        x0.M = v5;
                        x0.N = v6;
                        x0.T = v2;
                        x0.S = v3;
                        x0.X = 3;
                        a3 = a0;
                        if(e0.e(this, y1, ((k1)n10).a, x0) != a3) {
                            mutex4 = mutex2;
                            v12 = v2;
                            object4 = new g0(L0.d);
                            v2 = v12;
                            mutex2 = mutex4;
                            break;
                        }
                        return a3;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        devLog1 = devLog2;
                        l00 = l01;
                        goto label_226;
                    }
                    try {
                        mutex4 = mutex2;
                        v12 = v2;
                        object4 = new g0(L0.d);
                        v2 = v12;
                        mutex2 = mutex4;
                        break;
                    }
                    catch(Throwable throwable0) {
                        goto label_222;
                    }
                    return a3;
                }
                else {
                    try {
                        if(n10 instanceof va.l1) {
                            e0.g(this);
                            object4 = new f0(((va.l1)n10).a);
                            break;
                        }
                    }
                    catch(Throwable throwable0) {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        mutex1 = mutex5;
                        devLog1 = devLog4;
                        l00 = l03;
                        goto label_226;
                    }
                    try {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    catch(Throwable throwable0) {
                    }
                    mutex1 = mutex5;
                    devLog1 = devLog4;
                    l00 = l03;
                    goto label_226;
                }
                break;
            }
            case 2: {
                try {
                    v12 = x0.T;
                    s2 = x0.E;
                    devLog2 = x0.D;
                    l01 = x0.B;
                    s3 = x0.w;
                    mutex4 = x0.r;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                    goto label_214;
                }
                try {
                    object4 = h0.a;
                    v2 = v12;
                    mutex2 = mutex4;
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_222;
                }
            }
            case 3: {
                try {
                    v12 = x0.T;
                    s2 = x0.E;
                    devLog2 = x0.D;
                    l01 = x0.B;
                    s3 = x0.w;
                    mutex4 = x0.r;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                label_214:
                    devLog1 = devLog2;
                    mutex1 = mutex4;
                    l00 = l01;
                    v2 = v12;
                    goto label_226;
                }
                try {
                    object4 = new g0(L0.d);
                    v2 = v12;
                    mutex2 = mutex4;
                    break;
                }
                catch(Throwable throwable0) {
                label_222:
                    v2 = v12;
                    devLog1 = devLog2;
                    l00 = l01;
                    mutex1 = mutex4;
                }
            label_226:
                long v13 = System.currentTimeMillis() - v2;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
                H0.b.t(v13, s3, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
                H0.b.t(v13, s3, " (", stringBuilder1);
                l1.C(stringBuilder1, "ms)", devLog1);
                if(l00 != null) {
                    com.iloen.melon.utils.a.u(s2, " ", s3, l00, false);
                }
                throw throwable0;
            }
            default: {
                if(v1 != 4) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                return object0;
            }
        }
        long v14 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s2);
        H0.b.t(v14, s3, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s2);
        H0.b.t(v14, s3, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog2);
        if(l01 != null) {
            com.iloen.melon.utils.a.u(s2, " ", s3, l01, false);
        }
        return object4;
    }

    public final Object s(A8.l l0, A8.u u0, oe.c c0) {
        long v2;
        com.iloen.melon.custom.L0 l01;
        Mutex mutex0;
        String s1;
        com.iloen.melon.custom.L0 l00;
        DevLog devLog0;
        long v1;
        Mutex mutex1;
        n1 n10;
        DevLog devLog2;
        String s3;
        int v11;
        z z2;
        int v10;
        ne.a a1;
        int v9;
        int v8;
        Mutex mutex2;
        String s2;
        com.iloen.melon.custom.L0 l02;
        DevLog devLog1;
        Object object1;
        ne.a a2;
        Object object3;
        Object object2;
        A8.u u1;
        r r0;
        l l1;
        String s5;
        Long long0;
        long v13;
        z z3;
        long v12;
        va.z z0;
        String s = "";
        if(c0 instanceof va.z) {
            z0 = (va.z)c0;
            int v = z0.X;
            if((v & 0x80000000) == 0) {
                z0 = new va.z(this, c0);
            }
            else {
                z0.X = v ^ 0x80000000;
            }
        }
        else {
            z0 = new va.z(this, c0);
        }
        Object object0 = z0.V;
        ne.a a0 = ne.a.a;
        switch(z0.X) {
            case 0: {
                n.D(object0);
                Mutex mutex3 = this.n;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex3.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByKakao()"), null, false, 6, null);
                DevLog devLog3 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex3.hashCode(), "]  try : LoginUseCase-loginByKakao()", devLog3, mutex3);
                g g0 = z0.getContext().get(reentrantMutexContextKey0);
                l01 = this.g;
                if(g0 != null) {
                    try {
                        v12 = System.currentTimeMillis();
                        ((k8.b)l01).a(" LoginUseCase-loginByKakao()", true);
                    }
                    catch(Throwable throwable0) {
                        devLog0 = devLog3;
                        v2 = v12;
                        mutex1 = mutex3;
                        s1 = "LoginUseCase-loginByKakao()";
                        goto label_225;
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByKakao()", null, false, 6, null);
                        devLog3.put("ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByKakao()");
                        z3 = () -> "KAKAO";
                    }
                    catch(Throwable throwable0) {
                        devLog0 = devLog3;
                        v2 = v12;
                        mutex1 = mutex3;
                        s1 = "LoginUseCase-loginByKakao()";
                        goto label_225;
                    }
                    if(l0 == null) {
                        v13 = v12;
                        long0 = null;
                    }
                    else {
                        try {
                            v13 = v12;
                            long0 = new Long(l0.a);
                        }
                        catch(Throwable throwable0) {
                            goto label_126;
                        }
                    }
                    try {
                        LogU.debug$default(this.j, "loginByKakao(), kakaoLoginData-userId: " + long0, null, false, 6, null);
                        this.k.put("loginByKakao(), kakaoLoginData-userId: " + long0);
                        if(l0 == null) {
                            goto label_117;
                        }
                        else {
                            goto label_111;
                        }
                        goto label_118;
                    }
                    catch(Throwable throwable0) {
                        goto label_146;
                    }
                    try {
                    label_111:
                        String s4 = new Long(l0.a).toString();
                        if(s4 == null) {
                            s5 = "";
                            goto label_118;
                        label_117:
                            s5 = "";
                        }
                        else {
                            s5 = s4;
                        }
                        try {
                        label_118:
                            l1 = this.b;
                            r0 = r.g;
                            if(u0 == null) {
                                try {
                                    u1 = A8.u.d;
                                    goto label_131;
                                }
                                catch(Throwable throwable0) {
                                }
                                goto label_126;
                            }
                            else {
                                u1 = u0;
                                goto label_131;
                            label_126:
                                mutex1 = mutex3;
                                v2 = v13;
                                s1 = "LoginUseCase-loginByKakao()";
                                devLog0 = devLog3;
                                goto label_225;
                            }
                            try {
                            label_131:
                                z0.r = mutex3;
                                z0.w = "LoginUseCase-loginByKakao()";
                                z0.B = l01;
                                z0.D = devLog3;
                                z0.E = "";
                                z0.G = z3;
                                z0.I = 0;
                                z0.M = 0;
                                z0.N = 0;
                                v2 = v13;
                                z0.T = v2;
                                z0.S = 0;
                                z0.X = 1;
                                goto label_150;
                            }
                            catch(Throwable throwable0) {
                            }
                        }
                        catch(Throwable throwable0) {
                        }
                    }
                    catch(Throwable throwable0) {
                        goto label_126;
                    }
                label_146:
                    devLog0 = devLog3;
                    mutex1 = mutex3;
                    v2 = v13;
                    s1 = "LoginUseCase-loginByKakao()";
                    goto label_225;
                    try {
                    label_150:
                        mutex1 = mutex3;
                        devLog0 = devLog3;
                        object2 = ((j1)l1).g(r0, u1, s5, (l0 == null ? null : l0.c), (l0 == null ? null : l0.b), z0);
                        a1 = a0;
                    }
                    catch(Throwable throwable0) {
                        s1 = "LoginUseCase-loginByKakao()";
                        goto label_225;
                    }
                    if(object2 != a1) {
                        try {
                            s1 = "LoginUseCase-loginByKakao()";
                            mutex2 = mutex1;
                            v9 = 0;
                            v10 = 0;
                            v11 = 0;
                            v8 = 0;
                            z2 = z3;
                            devLog2 = devLog0;
                            s3 = "";
                            n10 = (n1)object2;
                            LogU.debug$default(this.j, "loginByKakao() doLoginByKakao result: " + n10, null, false, 6, null);
                        label_170:
                            if(!(n10 instanceof m1)) {
                                goto label_189;
                            }
                            z0.r = mutex2;
                            z0.w = s1;
                            z0.B = l01;
                            z0.D = devLog2;
                            z0.E = s3;
                            z0.G = null;
                            z0.I = v9;
                            z0.M = v10;
                            z0.N = v11;
                            z0.T = v2;
                            z0.S = v8;
                            z0.X = 2;
                            if(e0.f(this, z2, ((m1)n10).a, z0) != a1) {
                                goto label_184;
                            }
                            return a1;
                        }
                        catch(Throwable throwable0) {
                            goto label_222;
                        }
                    label_184:
                        mutex0 = mutex2;
                        s = s3;
                        devLog0 = devLog2;
                        try {
                            object3 = h0.a;
                            goto label_212;
                        }
                        catch(Throwable throwable0) {
                            mutex1 = mutex0;
                            goto label_225;
                        }
                    label_189:
                        if(n10 instanceof k1) {
                            try {
                                z0.r = mutex2;
                                z0.w = s1;
                                z0.B = l01;
                                z0.D = devLog2;
                                z0.E = s3;
                                z0.G = null;
                                z0.I = v9;
                                z0.M = v10;
                                z0.N = v11;
                                z0.T = v2;
                                z0.S = v8;
                                z0.X = 3;
                                a2 = a1;
                                if(e0.e(this, z2, ((k1)n10).a, z0) != a2) {
                                    goto label_204;
                                }
                                return a2;
                            }
                            catch(Throwable throwable0) {
                                goto label_222;
                            }
                        label_204:
                            mutex0 = mutex2;
                            s = s3;
                            devLog0 = devLog2;
                            try {
                            label_207:
                                object3 = new g0(L0.d);
                            }
                            catch(Throwable throwable0) {
                                mutex1 = mutex0;
                                goto label_225;
                            }
                        label_212:
                            devLog2 = devLog0;
                            s3 = s;
                            mutex2 = mutex0;
                        }
                        else {
                            try {
                                if(!(n10 instanceof va.l1)) {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                                e0.g(this);
                                object3 = new f0(((va.l1)n10).a);
                                goto label_236;
                            }
                            catch(Throwable throwable0) {
                            label_222:
                                mutex1 = mutex2;
                                s = s3;
                                devLog0 = devLog2;
                            }
                        label_225:
                            long v14 = System.currentTimeMillis() - v2;
                            StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s);
                            H0.b.t(v14, s1, " (", stringBuilder0);
                            stringBuilder0.append("ms)");
                            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                            StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s);
                            H0.b.t(v14, s1, " (", stringBuilder1);
                            l1.C(stringBuilder1, "ms)", devLog0);
                            if(l01 != null) {
                                com.iloen.melon.utils.a.u(s, " ", s1, l01, false);
                            }
                            throw throwable0;
                        }
                    label_236:
                        long v15 = System.currentTimeMillis() - v2;
                        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
                        H0.b.t(v15, s1, " (", stringBuilder2);
                        stringBuilder2.append("ms)");
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
                        H0.b.t(v15, s1, " (", stringBuilder3);
                        l1.C(stringBuilder3, "ms)", devLog2);
                        if(l01 != null) {
                            com.iloen.melon.utils.a.u(s3, " ", s1, l01, false);
                        }
                        return object3;
                    }
                    return a1;
                }
                a2 = a0;
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                va.y y0 = new va.y(mutex3, null, l01, mutex3, devLog3, l0, this, u0);
                z0.r = null;
                z0.w = null;
                z0.B = null;
                z0.D = null;
                z0.E = null;
                z0.I = 0;
                z0.M = 0;
                z0.X = 4;
                Object object4 = BuildersKt.withContext(reentrantMutexContextElement0, y0, z0);
                return object4 == a2 ? a2 : object4;
            }
            case 1: {
                try {
                    int v3 = z0.S;
                    long v4 = z0.T;
                    int v5 = z0.N;
                    int v6 = z0.I;
                    z z1 = z0.G;
                    int v7 = z0.M;
                    object1 = z0.E;
                    devLog1 = z0.D;
                    l02 = z0.B;
                    s2 = z0.w;
                    mutex2 = z0.r;
                    v2 = v4;
                    n.D(object0);
                    v8 = v3;
                    v9 = v6;
                    a1 = a0;
                    v10 = v7;
                    s1 = s2;
                    l01 = l02;
                    z2 = z1;
                    v11 = v5;
                    v2 = v4;
                    s3 = object1;
                    devLog2 = devLog1;
                }
                catch(Throwable throwable0) {
                    devLog0 = devLog1;
                    l01 = l02;
                    mutex1 = mutex2;
                    s1 = s2;
                    s = object1;
                    goto label_225;
                }
                try {
                    n10 = (n1)object0;
                    LogU.debug$default(this.j, "loginByKakao() doLoginByKakao result: " + n10, null, false, 6, null);
                    goto label_170;
                }
                catch(Throwable throwable0) {
                    goto label_222;
                }
            }
            case 2: {
                goto label_26;
            }
            case 3: {
                try {
                    v1 = z0.T;
                    s = z0.E;
                    devLog0 = z0.D;
                    l00 = z0.B;
                    s1 = z0.w;
                    mutex0 = z0.r;
                    n.D(object0);
                    l01 = l00;
                    v2 = v1;
                    goto label_207;
                label_26:
                    v1 = z0.T;
                    s = z0.E;
                    devLog0 = z0.D;
                    l00 = z0.B;
                    s1 = z0.w;
                    mutex0 = z0.r;
                    n.D(object0);
                    l01 = l00;
                    v2 = v1;
                    object3 = h0.a;
                    goto label_212;
                }
                catch(Throwable throwable0) {
                }
                l01 = l00;
                mutex1 = mutex0;
                v2 = v1;
                goto label_225;
            }
            case 4: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object t(A8.l l0, A8.u u0, oe.c c0) {
        ne.a a5;
        Object object3;
        A8.u u1;
        r r0;
        l l1;
        String s6;
        Long long0;
        A a4;
        Mutex mutex4;
        DevLog devLog3;
        long v13;
        Object object2;
        DevLog devLog2;
        String s4;
        long v12;
        n1 n10;
        String s3;
        com.iloen.melon.custom.L0 l02;
        Mutex mutex2;
        long v11;
        String s2;
        Mutex mutex1;
        long v10;
        A a3;
        DevLog devLog1;
        String s1;
        com.iloen.melon.custom.L0 l01;
        ne.a a2;
        int v9;
        int v8;
        int v7;
        Mutex mutex0;
        String s;
        com.iloen.melon.custom.L0 l00;
        Object object1;
        DevLog devLog0;
        long v6;
        int v4;
        B b0;
        if(c0 instanceof B) {
            b0 = (B)c0;
            int v = b0.X;
            if((v & 0x80000000) == 0) {
                b0 = new B(this, c0);
            }
            else {
                b0.X = v ^ 0x80000000;
            }
        }
        else {
            b0 = new B(this, c0);
        }
        Object object0 = b0.V;
        ne.a a0 = ne.a.a;
        int v1 = b0.X;
        if(v1 != 0) {
            switch(v1) {
                case 1: {
                    try {
                        int v2 = b0.S;
                        int v3 = b0.N;
                        v4 = b0.M;
                        int v5 = b0.I;
                        A a1 = b0.G;
                        v6 = b0.T;
                        devLog0 = b0.D;
                        object1 = b0.E;
                        l00 = b0.B;
                        s = b0.w;
                        mutex0 = b0.r;
                        n.D(object0);
                        v7 = v2;
                        v8 = v3;
                        v9 = v5;
                        a2 = a0;
                        l01 = l00;
                        s1 = object1;
                        devLog1 = devLog0;
                        a3 = a1;
                        v10 = v6;
                        mutex1 = mutex0;
                        s2 = s;
                    }
                    catch(Throwable throwable0) {
                        v11 = v6;
                        s1 = object1;
                        mutex2 = mutex0;
                        l02 = l00;
                        s3 = s;
                        devLog1 = devLog0;
                        goto label_233;
                    }
                    try {
                        n10 = (n1)object0;
                        goto label_177;
                    }
                    catch(Throwable throwable0) {
                        goto label_229;
                    }
                }
                case 2: {
                    try {
                        v12 = b0.T;
                        s4 = b0.E;
                        devLog2 = b0.D;
                        l02 = b0.B;
                        s3 = b0.w;
                        mutex2 = b0.r;
                        n.D(object0);
                        devLog1 = devLog2;
                        s1 = s4;
                        s2 = s3;
                        mutex1 = mutex2;
                        v10 = v12;
                        object2 = h0.a;
                        l01 = l02;
                        goto label_244;
                    label_66:
                        v12 = b0.T;
                        s4 = b0.E;
                        devLog2 = b0.D;
                        l02 = b0.B;
                        s3 = b0.w;
                        mutex2 = b0.r;
                        n.D(object0);
                        s2 = s3;
                        mutex1 = mutex2;
                        v10 = v12;
                        goto label_211;
                    }
                    catch(Throwable throwable0) {
                    }
                    v11 = v12;
                    devLog1 = devLog2;
                    s1 = s4;
                    goto label_233;
                }
                case 3: {
                    goto label_66;
                }
                case 4: {
                    n.D(object0);
                    return object0;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
        }
        n.D(object0);
        Mutex mutex3 = this.n;
        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex3.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByKakaoFromKakaoFamily()"), null, false, 6, null);
        devLog1 = DevLog.Companion.get("MutexLockUtil");
        ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex3.hashCode(), "]  try : LoginUseCase-loginByKakaoFromKakaoFamily()", devLog1, mutex3);
        g g0 = b0.getContext().get(reentrantMutexContextKey0);
        l01 = this.g;
        if(g0 != null) {
            try {
                v13 = System.currentTimeMillis();
                ((k8.b)l01).a(" LoginUseCase-loginByKakaoFromKakaoFamily()", true);
            }
            catch(Throwable throwable0) {
                devLog3 = devLog1;
                mutex4 = mutex3;
                v11 = v13;
                goto label_159;
            }
            try {
                LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByKakaoFromKakaoFamily()", null, false, 6, null);
                devLog1.put("ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByKakaoFromKakaoFamily()");
                a4 = () -> "KAKAO_FAMILY";
            }
            catch(Throwable throwable0) {
                mutex4 = mutex3;
                v11 = v13;
                s3 = "LoginUseCase-loginByKakaoFromKakaoFamily()";
                l02 = l01;
                mutex2 = mutex4;
                s1 = "";
                goto label_233;
            }
            if(l0 == null) {
                v11 = v13;
                long0 = null;
            }
            else {
                try {
                    v11 = v13;
                    long0 = new Long(l0.a);
                }
                catch(Throwable throwable0) {
                    goto label_130;
                }
            }
            try {
                LogU.debug$default(this.j, "loginByKakaoFromKakaoFamily(), kakaoLoginData-userId : " + long0, null, false, 6, null);
                this.k.put("loginByKakaoFromKakaoFamily(), kakaoLoginData-userId : " + long0);
                if(l0 == null) {
                    goto label_121;
                }
                else {
                    goto label_115;
                }
                goto label_122;
            }
            catch(Throwable throwable0) {
                goto label_149;
            }
            try {
            label_115:
                String s5 = new Long(l0.a).toString();
                if(s5 == null) {
                    s6 = "";
                    goto label_122;
                label_121:
                    s6 = "";
                }
                else {
                    s6 = s5;
                }
                try {
                label_122:
                    l1 = this.b;
                    r0 = r.i;
                    if(u0 == null) {
                        try {
                            u1 = A8.u.d;
                            goto label_135;
                        }
                        catch(Throwable throwable0) {
                        }
                        goto label_130;
                    }
                    else {
                        u1 = u0;
                        goto label_135;
                    label_130:
                        mutex2 = mutex3;
                        l02 = l01;
                        s3 = "LoginUseCase-loginByKakaoFromKakaoFamily()";
                        s1 = "";
                        goto label_233;
                    }
                    try {
                    label_135:
                        b0.r = mutex3;
                        b0.w = "LoginUseCase-loginByKakaoFromKakaoFamily()";
                        b0.B = l01;
                        b0.D = devLog1;
                        b0.E = "";
                        b0.G = a4;
                        b0.I = 0;
                        b0.M = 0;
                        b0.N = 0;
                        b0.T = v11;
                        b0.S = 0;
                        b0.X = 1;
                        goto label_153;
                    }
                    catch(Throwable throwable0) {
                    }
                }
                catch(Throwable throwable0) {
                }
            }
            catch(Throwable throwable0) {
                goto label_130;
            }
        label_149:
            mutex4 = mutex3;
            s3 = "LoginUseCase-loginByKakaoFromKakaoFamily()";
            l02 = l01;
            mutex2 = mutex4;
            s1 = "";
            goto label_233;
            try {
            label_153:
                mutex4 = mutex3;
                devLog3 = devLog1;
                object3 = ((j1)l1).g(r0, u1, s6, (l0 == null ? null : l0.c), (l0 == null ? null : l0.b), b0);
                a2 = a0;
                goto label_165;
            }
            catch(Throwable throwable0) {
            }
        label_159:
            s3 = "LoginUseCase-loginByKakaoFromKakaoFamily()";
            l02 = l01;
            devLog1 = devLog3;
            mutex2 = mutex4;
            s1 = "";
            goto label_233;
        label_165:
            if(object3 != a2) {
                try {
                    a3 = a4;
                    s2 = "LoginUseCase-loginByKakaoFromKakaoFamily()";
                    devLog1 = devLog3;
                    mutex1 = mutex4;
                    s1 = "";
                    v10 = v11;
                    v9 = 0;
                    v4 = 0;
                    v8 = 0;
                    v7 = 0;
                    n10 = (n1)object3;
                label_177:
                    if(!(n10 instanceof m1)) {
                        goto label_193;
                    }
                    b0.r = mutex1;
                    b0.w = s2;
                    b0.B = l01;
                    b0.D = devLog1;
                    b0.E = s1;
                    b0.G = null;
                    b0.I = v9;
                    b0.M = v4;
                    b0.N = v8;
                    b0.T = v10;
                    b0.S = v7;
                    b0.X = 2;
                    if(e0.f(this, a3, ((m1)n10).a, b0) != a2) {
                        object2 = h0.a;
                        goto label_244;
                    label_193:
                        if(n10 instanceof k1) {
                            b0.r = mutex1;
                            b0.w = s2;
                            b0.B = l01;
                            b0.D = devLog1;
                            b0.E = s1;
                            b0.G = null;
                            b0.I = v9;
                            b0.M = v4;
                            b0.N = v8;
                            b0.T = v10;
                            b0.S = v7;
                            b0.X = 3;
                            a5 = a2;
                            if(e0.e(this, a3, ((k1)n10).a, b0) != a5) {
                                goto label_208;
                            }
                            return a5;
                        }
                        else {
                            goto label_223;
                        }
                        goto label_244;
                    }
                    return a2;
                }
                catch(Throwable throwable0) {
                    goto label_229;
                }
            label_208:
                s4 = s1;
                devLog2 = devLog1;
                l02 = l01;
                try {
                label_211:
                    devLog1 = devLog2;
                    object2 = new g0(L0.d);
                    devLog1 = devLog2;
                    l01 = l02;
                    s1 = s4;
                    goto label_244;
                }
                catch(Throwable throwable0) {
                    v11 = v10;
                    s3 = s2;
                    mutex2 = mutex1;
                }
                s1 = s4;
                goto label_233;
                try {
                label_223:
                    if(!(n10 instanceof va.l1)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    e0.g(this);
                    object2 = new f0(((va.l1)n10).a);
                    goto label_244;
                }
                catch(Throwable throwable0) {
                label_229:
                    v11 = v10;
                    s3 = s2;
                    l02 = l01;
                    mutex2 = mutex1;
                }
            label_233:
                long v14 = System.currentTimeMillis() - v11;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s1);
                H0.b.t(v14, s3, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s1);
                H0.b.t(v14, s3, " (", stringBuilder1);
                l1.C(stringBuilder1, "ms)", devLog1);
                if(l02 != null) {
                    com.iloen.melon.utils.a.u(s1, " ", s3, l02, false);
                }
                throw throwable0;
            label_244:
                long v15 = System.currentTimeMillis() - v10;
                StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s1);
                H0.b.t(v15, s2, " (", stringBuilder2);
                stringBuilder2.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s1);
                H0.b.t(v15, s2, " (", stringBuilder3);
                l1.C(stringBuilder3, "ms)", devLog1);
                if(l01 != null) {
                    com.iloen.melon.utils.a.u(s1, " ", s2, l01, false);
                }
                return object2;
            }
            return a2;
        }
        a5 = a0;
        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
        va.A a6 = new va.A(mutex3, null, l01, mutex3, devLog1, l0, this, u0);
        b0.r = null;
        b0.w = null;
        b0.B = null;
        b0.D = null;
        b0.E = null;
        b0.I = 0;
        b0.M = 0;
        b0.X = 4;
        Object object4 = BuildersKt.withContext(reentrantMutexContextElement0, a6, b0);
        return object4 == a5 ? a5 : object4;
    }

    public final Object u(A8.l l0, A8.u u0, oe.c c0) {
        ne.a a2;
        Object object3;
        Object object2;
        j1 j10;
        String s7;
        r r0;
        l l1;
        String s6;
        Long long0;
        A8.B b3;
        Mutex mutex4;
        k8.b b2;
        long v13;
        String s4;
        long v12;
        String s3;
        com.iloen.melon.custom.L0 l02;
        DevLog devLog2;
        Mutex mutex2;
        long v11;
        long v10;
        String s2;
        int v9;
        DevLog devLog1;
        Mutex mutex1;
        com.iloen.melon.custom.L0 l01;
        ne.a a1;
        A8.B b1;
        int v8;
        int v7;
        Mutex mutex0;
        String s1;
        com.iloen.melon.custom.L0 l00;
        Object object1;
        DevLog devLog0;
        long v6;
        int v4;
        va.D d0;
        String s = "";
        if(c0 instanceof va.D) {
            d0 = (va.D)c0;
            int v = d0.X;
            if((v & 0x80000000) == 0) {
                d0 = new va.D(this, c0);
            }
            else {
                d0.X = v ^ 0x80000000;
            }
        }
        else {
            d0 = new va.D(this, c0);
        }
        Object object0 = d0.V;
        ne.a a0 = ne.a.a;
        int v1 = d0.X;
        if(v1 != 0) {
            switch(v1) {
                case 1: {
                    try {
                        int v2 = d0.S;
                        int v3 = d0.N;
                        v4 = d0.M;
                        int v5 = d0.I;
                        A8.B b0 = d0.G;
                        v6 = d0.T;
                        devLog0 = d0.D;
                        object1 = d0.E;
                        l00 = d0.B;
                        s1 = d0.w;
                        mutex0 = d0.r;
                        n.D(object0);
                        v7 = v2;
                        v8 = v3;
                        b1 = b0;
                        a1 = a0;
                        l01 = l00;
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        v9 = v5;
                        s2 = s1;
                        v10 = v6;
                        s = object1;
                        goto label_172;
                    }
                    catch(Throwable throwable0) {
                        v11 = v6;
                        mutex2 = mutex0;
                        devLog2 = devLog0;
                        l02 = l00;
                        s3 = s1;
                        s = object1;
                        goto label_225;
                    }
                }
                case 2: {
                    try {
                        v12 = d0.T;
                        s4 = d0.E;
                        devLog2 = d0.D;
                        l02 = d0.B;
                        s3 = d0.w;
                        mutex2 = d0.r;
                        n.D(object0);
                        goto label_242;
                    label_58:
                        v12 = d0.T;
                        s4 = d0.E;
                        devLog2 = d0.D;
                        l02 = d0.B;
                        s3 = d0.w;
                        mutex2 = d0.r;
                        n.D(object0);
                        object3 = new g0(L0.d);
                        goto label_243;
                    }
                    catch(Throwable throwable0) {
                    }
                    v11 = v12;
                    s = s4;
                    goto label_225;
                }
                case 3: {
                    goto label_58;
                }
                case 4: {
                    n.D(object0);
                    return object0;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
        }
        n.D(object0);
        Mutex mutex3 = this.n;
        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex3.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByKakaoScheme()"), null, false, 6, null);
        DevLog devLog3 = DevLog.Companion.get("MutexLockUtil");
        ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex3.hashCode(), "]  try : LoginUseCase-loginByKakaoScheme()", devLog3, mutex3);
        g g0 = d0.getContext().get(reentrantMutexContextKey0);
        l01 = this.g;
        if(g0 != null) {
            try {
                v13 = System.currentTimeMillis();
                b2 = (k8.b)l01;
            }
            catch(Throwable throwable0) {
                devLog1 = devLog3;
                mutex4 = mutex3;
                v11 = v13;
                goto label_157;
            }
            try {
                b2.a(" LoginUseCase-loginByKakaoScheme()", true);
            }
            catch(Throwable throwable0) {
                devLog1 = devLog3;
                mutex4 = mutex3;
                v11 = v13;
                goto label_157;
            }
            try {
                LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByKakaoScheme()", null, false, 6, null);
                devLog3.put("ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByKakaoScheme()");
                b3 = () -> "KAKAO_SCHEME";
            }
            catch(Throwable throwable0) {
                devLog1 = devLog3;
                mutex4 = mutex3;
                v11 = v13;
                goto label_157;
            }
            if(l0 == null) {
                v11 = v13;
                long0 = null;
            }
            else {
                try {
                    v11 = v13;
                    long0 = new Long(l0.a);
                }
                catch(Throwable throwable0) {
                    goto label_128;
                }
            }
            try {
                LogU.debug$default(this.j, "loginByKakaoScheme(), kakaoLoginData-userId: " + long0, null, false, 6, null);
                this.k.put("loginByKakaoScheme(), kakaoLoginData-userId: " + long0);
                if(l0 == null) {
                    goto label_119;
                }
                else {
                    goto label_113;
                }
                l1 = this.b;
                r0 = r.h;
                s7 = l0 == null ? null : l0.c;
                goto label_133;
            }
            catch(Throwable throwable0) {
                devLog1 = devLog3;
                mutex4 = mutex3;
                goto label_157;
            }
            try {
            label_113:
                String s5 = new Long(l0.a).toString();
                if(s5 == null) {
                    s6 = "";
                    l1 = this.b;
                    r0 = r.h;
                    s7 = l0 == null ? null : l0.c;
                    goto label_133;
                label_119:
                    s6 = "";
                }
                else {
                    s6 = s5;
                }
                try {
                    l1 = this.b;
                    r0 = r.h;
                    s7 = l0 == null ? null : l0.c;
                    goto label_133;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog3;
                    mutex4 = mutex3;
                    goto label_157;
                }
                try {
                    s7 = l0.c;
                    goto label_133;
                }
                catch(Throwable throwable0) {
                }
                goto label_128;
            }
            catch(Throwable throwable0) {
            label_128:
                mutex2 = mutex3;
                l02 = l01;
                s3 = "LoginUseCase-loginByKakaoScheme()";
                devLog2 = devLog3;
                goto label_225;
            }
            try {
            label_133:
                d0.r = mutex3;
                d0.w = "LoginUseCase-loginByKakaoScheme()";
                d0.B = l01;
                d0.D = devLog3;
                d0.E = "";
                d0.G = b3;
                d0.I = 0;
                d0.M = 0;
                d0.N = 0;
                d0.T = v11;
                d0.S = 0;
                d0.X = 1;
                j10 = (j1)l1;
                devLog1 = devLog3;
                mutex4 = mutex3;
            }
            catch(Throwable throwable0) {
                devLog1 = devLog3;
                mutex4 = mutex3;
                goto label_157;
            }
            try {
                object2 = j10.g(r0, u0, s6, s7, (l0 == null ? null : l0.b), d0);
                a1 = a0;
                goto label_162;
            }
            catch(Throwable throwable0) {
            }
        label_157:
            mutex2 = mutex4;
            devLog2 = devLog1;
            l02 = l01;
            s3 = "LoginUseCase-loginByKakaoScheme()";
            goto label_225;
        label_162:
            if(object2 != a1) {
                b1 = b3;
                object0 = object2;
                mutex1 = mutex4;
                s2 = "LoginUseCase-loginByKakaoScheme()";
                v10 = v11;
                v4 = 0;
                v9 = 0;
                v8 = 0;
                v7 = 0;
                try {
                label_172:
                    if(!(((n1)object0) instanceof m1)) {
                        if(!(((n1)object0) instanceof k1)) {
                            if(!(((n1)object0) instanceof va.l1)) {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                            e0.g(this);
                            object3 = new f0(((va.l1)(((n1)object0))).a);
                            goto label_249;
                        }
                        d0.r = mutex1;
                        d0.w = s2;
                        d0.B = l01;
                        d0.D = devLog1;
                        d0.E = s;
                        d0.G = null;
                        d0.I = v9;
                        d0.M = v4;
                        d0.N = v8;
                        d0.T = v10;
                        d0.S = v7;
                        d0.X = 3;
                        a2 = a1;
                        if(e0.e(this, b1, ((k1)(((n1)object0))).a, d0) != a2) {
                            goto label_193;
                        }
                        return a2;
                    }
                    goto label_205;
                }
                catch(Throwable throwable0) {
                    goto label_220;
                }
            label_193:
                s4 = s;
                v12 = v10;
                mutex2 = mutex1;
                devLog2 = devLog1;
                s3 = s2;
                l02 = l01;
                try {
                    object3 = new g0(L0.d);
                    goto label_243;
                }
                catch(Throwable throwable0) {
                    v11 = v12;
                    s = s4;
                    goto label_225;
                }
                try {
                label_205:
                    d0.r = mutex1;
                    d0.w = s2;
                    d0.B = l01;
                    d0.D = devLog1;
                    d0.E = s;
                    d0.G = null;
                    d0.I = v9;
                    d0.M = v4;
                    d0.N = v8;
                    d0.T = v10;
                    d0.S = v7;
                    d0.X = 2;
                    if(e0.f(this, b1, ((m1)(((n1)object0))).a, d0) != a1) {
                        goto label_236;
                    }
                    return a1;
                }
                catch(Throwable throwable0) {
                label_220:
                    v11 = v10;
                    s3 = s2;
                    l02 = l01;
                    mutex2 = mutex1;
                    devLog2 = devLog1;
                }
            label_225:
                long v14 = System.currentTimeMillis() - v11;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s);
                H0.b.t(v14, s3, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s);
                H0.b.t(v14, s3, " (", stringBuilder1);
                l1.C(stringBuilder1, "ms)", devLog2);
                if(l02 != null) {
                    com.iloen.melon.utils.a.u(s, " ", s3, l02, false);
                }
                throw throwable0;
            label_236:
                s4 = s;
                v12 = v10;
                mutex2 = mutex1;
                devLog2 = devLog1;
                s3 = s2;
                l02 = l01;
            label_242:
                object3 = h0.a;
            label_243:
                l01 = l02;
                s2 = s3;
                s = s4;
                devLog1 = devLog2;
                mutex1 = mutex2;
                v10 = v12;
            label_249:
                long v15 = System.currentTimeMillis() - v10;
                StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s);
                H0.b.t(v15, s2, " (", stringBuilder2);
                stringBuilder2.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s);
                H0.b.t(v15, s2, " (", stringBuilder3);
                l1.C(stringBuilder3, "ms)", devLog1);
                if(l01 != null) {
                    com.iloen.melon.utils.a.u(s, " ", s2, l01, false);
                }
                return object3;
            }
            return a1;
        }
        a2 = a0;
        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
        C c1 = new C(mutex3, null, l01, mutex3, devLog3, l0, this, u0);
        d0.r = null;
        d0.w = null;
        d0.B = null;
        d0.D = null;
        d0.E = null;
        d0.I = 0;
        d0.M = 0;
        d0.X = 4;
        Object object4 = BuildersKt.withContext(reentrantMutexContextElement0, c1, d0);
        return object4 == a2 ? a2 : object4;
    }

    public final Object v(String s, oe.c c0) {
        Mutex mutex0;
        String s2;
        com.iloen.melon.custom.L0 l00;
        DevLog devLog0;
        String s1;
        long v1;
        Mutex mutex1;
        long v2;
        DevLog devLog1;
        String s4;
        String s3;
        A8.C c2;
        com.iloen.melon.custom.L0 l02;
        Object object2;
        int v7;
        Mutex mutex2;
        String s5;
        com.iloen.melon.custom.L0 l01;
        DevLog devLog2;
        Object object1;
        int v5;
        int v4;
        int v3;
        Object object4;
        n1 n10;
        Object object3;
        A8.C c3;
        long v8;
        F f0;
        if(c0 instanceof F) {
            f0 = (F)c0;
            int v = f0.X;
            if((v & 0x80000000) == 0) {
                f0 = new F(this, c0);
            }
            else {
                f0.X = v ^ 0x80000000;
            }
        }
        else {
            f0 = new F(this, c0);
        }
        Object object0 = f0.V;
        ne.a a0 = ne.a.a;
        switch(f0.X) {
            case 0: {
                n.D(object0);
                Mutex mutex3 = this.n;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex3.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByOtp()"), null, false, 6, null);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                DevLog devLog3 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex3.hashCode(), "]  try : LoginUseCase-loginByOtp()", devLog3, mutex3);
                g g0 = f0.getContext().get(reentrantMutexContextKey0);
                l00 = this.g;
                if(g0 != null) {
                    try {
                        v8 = System.currentTimeMillis();
                        ((k8.b)l00).a(" LoginUseCase-loginByOtp()", true);
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByOtp()", null, false, 6, null);
                        devLog3.put("ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByOtp()");
                        c3 = () -> "OTP";
                        f0.r = mutex3;
                        f0.w = "LoginUseCase-loginByOtp()";
                        f0.B = l00;
                        f0.D = devLog3;
                        f0.E = "";
                        f0.G = c3;
                        f0.I = 0;
                        f0.M = 0;
                        f0.N = 0;
                        f0.T = v8;
                        f0.S = 0;
                        f0.X = 1;
                        object3 = ((j1)this.b).h(s, f0);
                    }
                    catch(Throwable throwable0) {
                        s3 = "LoginUseCase-loginByOtp()";
                        mutex1 = mutex3;
                        s4 = "";
                        devLog1 = devLog3;
                        v2 = v8;
                        goto label_185;
                    }
                    if(object3 == a0) {
                        return a0;
                    }
                    c2 = c3;
                    object2 = object3;
                    mutex2 = mutex3;
                    l02 = l00;
                    v7 = 0;
                    v3 = 0;
                    s3 = "LoginUseCase-loginByOtp()";
                    v5 = 0;
                    s4 = "";
                    devLog1 = devLog3;
                    v2 = v8;
                    v4 = 0;
                    try {
                    label_113:
                        n10 = (n1)object2;
                        if(n10 instanceof m1) {
                            goto label_115;
                        }
                        else {
                            goto label_136;
                        }
                        goto label_196;
                    }
                    catch(Throwable throwable0) {
                        goto label_183;
                    }
                    try {
                    label_115:
                        f0.r = mutex2;
                        f0.w = s3;
                        f0.B = l02;
                        f0.D = devLog1;
                        f0.E = s4;
                        f0.G = null;
                        f0.I = v5;
                        f0.M = v4;
                        f0.N = v3;
                        f0.T = v2;
                        f0.S = v7;
                        f0.X = 2;
                        if(e0.f(this, c2, ((m1)n10).a, f0) != a0) {
                            goto label_128;
                        }
                        return a0;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        l00 = l02;
                        goto label_185;
                    }
                label_128:
                    mutex0 = mutex2;
                    v1 = v2;
                    s1 = s4;
                    devLog0 = devLog1;
                    l00 = l02;
                    s2 = s3;
                    try {
                        object4 = h0.a;
                        goto label_170;
                    }
                    catch(Throwable throwable0) {
                        goto label_164;
                    }
                label_136:
                    if(n10 instanceof k1) {
                        try {
                            f0.r = mutex2;
                            f0.w = s3;
                            f0.B = l02;
                            f0.D = devLog1;
                            f0.E = s4;
                            f0.G = null;
                            f0.I = v5;
                            f0.M = v4;
                            f0.N = v3;
                            f0.T = v2;
                            f0.S = v7;
                            f0.X = 3;
                            if(e0.e(this, c2, ((k1)n10).a, f0) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable0) {
                            mutex1 = mutex2;
                            l00 = l02;
                            goto label_185;
                        }
                        mutex0 = mutex2;
                        v1 = v2;
                        s1 = s4;
                        devLog0 = devLog1;
                        l00 = l02;
                        s2 = s3;
                        try {
                        label_161:
                            object4 = new g0(L0.d);
                        }
                        catch(Throwable throwable0) {
                        label_164:
                            s4 = s1;
                            devLog1 = devLog0;
                            s3 = s2;
                            v2 = v1;
                            mutex1 = mutex0;
                            goto label_185;
                        }
                    label_170:
                        s4 = s1;
                        devLog1 = devLog0;
                        l02 = l00;
                        s3 = s2;
                        v2 = v1;
                        mutex2 = mutex0;
                    }
                    else {
                        try {
                            if(!(n10 instanceof va.l1)) {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                            e0.g(this);
                            object4 = new f0(((va.l1)n10).a);
                            goto label_196;
                        }
                        catch(Throwable throwable0) {
                        label_183:
                            l00 = l02;
                            mutex1 = mutex2;
                        }
                    label_185:
                        long v9 = System.currentTimeMillis() - v2;
                        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s4);
                        H0.b.t(v9, s3, " (", stringBuilder0);
                        stringBuilder0.append("ms)");
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s4);
                        H0.b.t(v9, s3, " (", stringBuilder1);
                        l1.C(stringBuilder1, "ms)", devLog1);
                        if(l00 != null) {
                            com.iloen.melon.utils.a.u(s4, " ", s3, l00, false);
                        }
                        throw throwable0;
                    }
                label_196:
                    long v10 = System.currentTimeMillis() - v2;
                    StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s4);
                    H0.b.t(v10, s3, " (", stringBuilder2);
                    stringBuilder2.append("ms)");
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                    StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s4);
                    H0.b.t(v10, s3, " (", stringBuilder3);
                    l1.C(stringBuilder3, "ms)", devLog1);
                    if(l02 != null) {
                        com.iloen.melon.utils.a.u(s4, " ", s3, l02, false);
                    }
                    return object4;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                E e0 = new E(mutex3, null, l00, mutex3, devLog3, this, s);
                f0.r = null;
                f0.w = null;
                f0.B = null;
                f0.D = null;
                f0.E = null;
                f0.I = 0;
                f0.M = 0;
                f0.X = 4;
                Object object5 = BuildersKt.withContext(reentrantMutexContextElement0, e0, f0);
                return object5 == a0 ? a0 : object5;
            }
            case 1: {
                try {
                    v2 = f0.T;
                    v3 = f0.N;
                    v4 = f0.M;
                    v5 = f0.I;
                    A8.C c1 = f0.G;
                    int v6 = f0.S;
                    object1 = f0.E;
                    devLog2 = f0.D;
                    l01 = f0.B;
                    s5 = f0.w;
                    mutex2 = f0.r;
                    n.D(object0);
                    v7 = v6;
                    object2 = object0;
                    s3 = s5;
                    l02 = l01;
                    c2 = c1;
                    s4 = object1;
                    devLog1 = devLog2;
                    goto label_113;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex2;
                    s4 = object1;
                    l00 = l01;
                    s3 = s5;
                    devLog1 = devLog2;
                    goto label_185;
                }
            }
            case 2: {
                goto label_23;
            label_32:
                s3 = s2;
                s4 = s1;
                devLog1 = devLog0;
                v2 = v1;
                mutex1 = mutex0;
                goto label_185;
            }
            case 3: {
                try {
                    v1 = f0.T;
                    s1 = f0.E;
                    devLog0 = f0.D;
                    l00 = f0.B;
                    s2 = f0.w;
                    mutex0 = f0.r;
                    n.D(object0);
                    goto label_161;
                label_23:
                    v1 = f0.T;
                    s1 = f0.E;
                    devLog0 = f0.D;
                    l00 = f0.B;
                    s2 = f0.w;
                    mutex0 = f0.r;
                    n.D(object0);
                    object4 = h0.a;
                    goto label_170;
                }
                catch(Throwable throwable0) {
                }
                goto label_32;
            }
            case 4: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object w(String s, oe.c c0) {
        Mutex mutex0;
        String s2;
        com.iloen.melon.custom.L0 l00;
        DevLog devLog0;
        String s1;
        long v1;
        Mutex mutex1;
        long v2;
        DevLog devLog1;
        String s4;
        String s3;
        A8.D d1;
        com.iloen.melon.custom.L0 l02;
        Object object2;
        int v7;
        Mutex mutex2;
        String s5;
        com.iloen.melon.custom.L0 l01;
        DevLog devLog2;
        Object object1;
        int v5;
        int v4;
        int v3;
        Object object4;
        n1 n10;
        Object object3;
        A8.D d2;
        long v8;
        va.H h0;
        if(c0 instanceof va.H) {
            h0 = (va.H)c0;
            int v = h0.X;
            if((v & 0x80000000) == 0) {
                h0 = new va.H(this, c0);
            }
            else {
                h0.X = v ^ 0x80000000;
            }
        }
        else {
            h0 = new va.H(this, c0);
        }
        Object object0 = h0.V;
        ne.a a0 = ne.a.a;
        switch(h0.X) {
            case 0: {
                n.D(object0);
                Mutex mutex3 = this.n;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex3.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginByOtpBackground()"), null, false, 6, null);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                DevLog devLog3 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex3.hashCode(), "]  try : LoginUseCase-loginByOtpBackground()", devLog3, mutex3);
                g g0 = h0.getContext().get(reentrantMutexContextKey0);
                l00 = this.g;
                if(g0 != null) {
                    try {
                        v8 = System.currentTimeMillis();
                        ((k8.b)l00).a(" LoginUseCase-loginByOtpBackground()", true);
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByOtpBackground()", null, false, 6, null);
                        devLog3.put("ReentrantLock[" + mutex3.hashCode() + "]  Lock obtain : LoginUseCase-loginByOtpBackground()");
                        d2 = () -> "OTP_BACKGROUND";
                        h0.r = mutex3;
                        h0.w = "LoginUseCase-loginByOtpBackground()";
                        h0.B = l00;
                        h0.D = devLog3;
                        h0.E = "";
                        h0.G = d2;
                        h0.I = 0;
                        h0.M = 0;
                        h0.N = 0;
                        h0.T = v8;
                        h0.S = 0;
                        h0.X = 1;
                        object3 = ((j1)this.b).i(s, h0);
                    }
                    catch(Throwable throwable0) {
                        s3 = "LoginUseCase-loginByOtpBackground()";
                        mutex1 = mutex3;
                        s4 = "";
                        devLog1 = devLog3;
                        v2 = v8;
                        goto label_185;
                    }
                    if(object3 == a0) {
                        return a0;
                    }
                    d1 = d2;
                    object2 = object3;
                    mutex2 = mutex3;
                    l02 = l00;
                    v7 = 0;
                    v3 = 0;
                    s3 = "LoginUseCase-loginByOtpBackground()";
                    v5 = 0;
                    s4 = "";
                    devLog1 = devLog3;
                    v2 = v8;
                    v4 = 0;
                    try {
                    label_113:
                        n10 = (n1)object2;
                        if(n10 instanceof m1) {
                            goto label_115;
                        }
                        else {
                            goto label_136;
                        }
                        goto label_196;
                    }
                    catch(Throwable throwable0) {
                        goto label_183;
                    }
                    try {
                    label_115:
                        h0.r = mutex2;
                        h0.w = s3;
                        h0.B = l02;
                        h0.D = devLog1;
                        h0.E = s4;
                        h0.G = null;
                        h0.I = v5;
                        h0.M = v4;
                        h0.N = v3;
                        h0.T = v2;
                        h0.S = v7;
                        h0.X = 2;
                        if(e0.f(this, d1, ((m1)n10).a, h0) != a0) {
                            goto label_128;
                        }
                        return a0;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        l00 = l02;
                        goto label_185;
                    }
                label_128:
                    mutex0 = mutex2;
                    v1 = v2;
                    s1 = s4;
                    devLog0 = devLog1;
                    l00 = l02;
                    s2 = s3;
                    try {
                        object4 = h0.a;
                        goto label_170;
                    }
                    catch(Throwable throwable0) {
                        goto label_164;
                    }
                label_136:
                    if(n10 instanceof k1) {
                        try {
                            h0.r = mutex2;
                            h0.w = s3;
                            h0.B = l02;
                            h0.D = devLog1;
                            h0.E = s4;
                            h0.G = null;
                            h0.I = v5;
                            h0.M = v4;
                            h0.N = v3;
                            h0.T = v2;
                            h0.S = v7;
                            h0.X = 3;
                            if(e0.e(this, d1, ((k1)n10).a, h0) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable0) {
                            mutex1 = mutex2;
                            l00 = l02;
                            goto label_185;
                        }
                        mutex0 = mutex2;
                        v1 = v2;
                        s1 = s4;
                        devLog0 = devLog1;
                        l00 = l02;
                        s2 = s3;
                        try {
                        label_161:
                            object4 = new g0(L0.d);
                        }
                        catch(Throwable throwable0) {
                        label_164:
                            s4 = s1;
                            devLog1 = devLog0;
                            s3 = s2;
                            v2 = v1;
                            mutex1 = mutex0;
                            goto label_185;
                        }
                    label_170:
                        s4 = s1;
                        devLog1 = devLog0;
                        l02 = l00;
                        s3 = s2;
                        v2 = v1;
                        mutex2 = mutex0;
                    }
                    else {
                        try {
                            if(!(n10 instanceof va.l1)) {
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                            e0.g(this);
                            object4 = new f0(((va.l1)n10).a);
                            goto label_196;
                        }
                        catch(Throwable throwable0) {
                        label_183:
                            l00 = l02;
                            mutex1 = mutex2;
                        }
                    label_185:
                        long v9 = System.currentTimeMillis() - v2;
                        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s4);
                        H0.b.t(v9, s3, " (", stringBuilder0);
                        stringBuilder0.append("ms)");
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s4);
                        H0.b.t(v9, s3, " (", stringBuilder1);
                        l1.C(stringBuilder1, "ms)", devLog1);
                        if(l00 != null) {
                            com.iloen.melon.utils.a.u(s4, " ", s3, l00, false);
                        }
                        throw throwable0;
                    }
                label_196:
                    long v10 = System.currentTimeMillis() - v2;
                    StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s4);
                    H0.b.t(v10, s3, " (", stringBuilder2);
                    stringBuilder2.append("ms)");
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                    StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s4);
                    H0.b.t(v10, s3, " (", stringBuilder3);
                    l1.C(stringBuilder3, "ms)", devLog1);
                    if(l02 != null) {
                        com.iloen.melon.utils.a.u(s4, " ", s3, l02, false);
                    }
                    return object4;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                va.G g1 = new va.G(mutex3, null, l00, mutex3, devLog3, this, s);
                h0.r = null;
                h0.w = null;
                h0.B = null;
                h0.D = null;
                h0.E = null;
                h0.I = 0;
                h0.M = 0;
                h0.X = 4;
                Object object5 = BuildersKt.withContext(reentrantMutexContextElement0, g1, h0);
                return object5 == a0 ? a0 : object5;
            }
            case 1: {
                try {
                    v2 = h0.T;
                    v3 = h0.N;
                    v4 = h0.M;
                    v5 = h0.I;
                    A8.D d0 = h0.G;
                    int v6 = h0.S;
                    object1 = h0.E;
                    devLog2 = h0.D;
                    l01 = h0.B;
                    s5 = h0.w;
                    mutex2 = h0.r;
                    n.D(object0);
                    v7 = v6;
                    object2 = object0;
                    s3 = s5;
                    l02 = l01;
                    d1 = d0;
                    s4 = object1;
                    devLog1 = devLog2;
                    goto label_113;
                }
                catch(Throwable throwable0) {
                    mutex1 = mutex2;
                    s4 = object1;
                    l00 = l01;
                    s3 = s5;
                    devLog1 = devLog2;
                    goto label_185;
                }
            }
            case 2: {
                goto label_23;
            label_32:
                s3 = s2;
                s4 = s1;
                devLog1 = devLog0;
                v2 = v1;
                mutex1 = mutex0;
                goto label_185;
            }
            case 3: {
                try {
                    v1 = h0.T;
                    s1 = h0.E;
                    devLog0 = h0.D;
                    l00 = h0.B;
                    s2 = h0.w;
                    mutex0 = h0.r;
                    n.D(object0);
                    goto label_161;
                label_23:
                    v1 = h0.T;
                    s1 = h0.E;
                    devLog0 = h0.D;
                    l00 = h0.B;
                    s2 = h0.w;
                    mutex0 = h0.r;
                    n.D(object0);
                    object4 = h0.a;
                    goto label_170;
                }
                catch(Throwable throwable0) {
                }
                goto label_32;
            }
            case 4: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object x(String s, String s1, oe.c c0) {
        f0 f00;
        long v20;
        Mutex mutex5;
        Object object5;
        int v14;
        Mutex mutex4;
        String s16;
        ne.a a2;
        int v13;
        String s15;
        String s14;
        long v11;
        Mutex mutex3;
        String s13;
        String s12;
        n1 n10;
        DevLog devLog2;
        Object object4;
        int v5;
        A8.E e1;
        String s7;
        int v4;
        int v3;
        int v2;
        String s6;
        String s5;
        Object object2;
        DevLog devLog1;
        String s4;
        Mutex mutex1;
        com.iloen.melon.custom.L0 l00;
        Object object1;
        String s3;
        A8.E e0;
        long v1;
        DevLog devLog0;
        String s2;
        J j0;
        l l0 = this.b;
        if(c0 instanceof J) {
            j0 = (J)c0;
            int v = j0.b0;
            if((v & 0x80000000) == 0) {
                j0 = new J(this, c0);
            }
            else {
                j0.b0 = v ^ 0x80000000;
            }
        }
        else {
            j0 = new J(this, c0);
        }
        Object object0 = j0.Y;
        ne.a a0 = ne.a.a;
        switch(j0.b0) {
            case 0: {
                n.D(object0);
                s2 = "";
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                Mutex mutex0 = this.n;
                LogU.debug$default(mutexLockUtil0.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginFromRestore"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : LoginUseCase-loginFromRestore", devLog0, mutex0);
                g g0 = j0.getContext().get(reentrantMutexContextKey0);
                a a1 = this.g;
                if(g0 != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        ((k8.b)a1).a(" LoginUseCase-loginFromRestore", true);
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginFromRestore", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginFromRestore");
                        e0 = new A8.E(this.l);
                        s3 = "";
                        j0.r = s;
                        j0.w = s1;
                        j0.B = mutex0;
                        j0.D = "LoginUseCase-loginFromRestore";
                        j0.E = a1;
                        j0.G = devLog0;
                        j0.I = "";
                        j0.M = e0;
                        j0.N = "";
                        j0.S = 0;
                        j0.T = 0;
                        j0.V = 0;
                        j0.X = v1;
                        j0.W = 0;
                        j0.b0 = 1;
                        object1 = ((j1)l0).c(s, s1, A8.u.d, j0);
                    }
                    catch(Throwable throwable0) {
                        l00 = a1;
                        mutex1 = mutex0;
                        s4 = "LoginUseCase-loginFromRestore";
                        devLog1 = devLog0;
                        goto label_336;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    object2 = object1;
                    s5 = s;
                    s6 = s1;
                    l00 = a1;
                    v2 = 0;
                    v3 = 0;
                    v4 = 0;
                    mutex1 = mutex0;
                    s4 = "LoginUseCase-loginFromRestore";
                    s7 = "";
                    e1 = e0;
                    v5 = 0;
                    goto label_125;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                I i0 = new I(mutex0, null, a1, mutex0, devLog0, this, s, s1);
                j0.r = null;
                j0.w = null;
                j0.B = null;
                j0.D = null;
                j0.E = null;
                j0.G = null;
                j0.I = null;
                j0.S = 0;
                j0.T = 0;
                j0.b0 = 6;
                Object object3 = BuildersKt.withContext(reentrantMutexContextElement0, i0, j0);
                return object3 == a0 ? a0 : object3;
            }
            case 1: {
                try {
                    long v6 = j0.X;
                    int v7 = j0.T;
                    int v8 = j0.S;
                    int v9 = j0.W;
                    String s8 = j0.N;
                    int v10 = j0.V;
                    object4 = j0.I;
                    devLog2 = j0.G;
                    com.iloen.melon.custom.L0 l01 = j0.E;
                    String s9 = j0.D;
                    Mutex mutex2 = j0.B;
                    A8.E e2 = j0.M;
                    String s10 = j0.w;
                    String s11 = j0.r;
                    l00 = l01;
                    s4 = s9;
                    mutex1 = mutex2;
                    v1 = v6;
                    n.D(object0);
                    s4 = s9;
                    s6 = s10;
                    mutex1 = mutex2;
                    e1 = e2;
                    s5 = s11;
                    v5 = v9;
                    v4 = v7;
                    l00 = l01;
                    s3 = s8;
                    devLog0 = devLog2;
                    s7 = object4;
                    v2 = v8;
                    object2 = object0;
                    v3 = v10;
                    v1 = v6;
                }
                catch(Throwable throwable0) {
                    s2 = object4;
                    devLog1 = devLog2;
                    goto label_336;
                }
                try {
                label_125:
                    n10 = (n1)object2;
                    LogU.debug$default(this.j, "loginFromRestore() result : " + n10, null, false, 6, null);
                    c9.a.a(s3, "loginFromRestore", n10);
                    if(n10 instanceof m1) {
                        try {
                            j0.r = null;
                            j0.w = null;
                            j0.B = mutex1;
                            j0.D = s4;
                            j0.E = l00;
                            j0.G = devLog0;
                            j0.I = s7;
                            j0.M = null;
                            j0.N = null;
                            j0.S = v2;
                            j0.T = v4;
                            j0.V = v3;
                            j0.X = v1;
                            j0.W = v5;
                            j0.b0 = 2;
                            if(e0.f(this, e1, ((m1)n10).a, j0) != a0) {
                                goto label_169;
                            }
                            return a0;
                        label_146:
                            if(n10 instanceof k1) {
                                j0.r = null;
                                j0.w = null;
                                j0.B = mutex1;
                                j0.D = s4;
                                j0.E = l00;
                                j0.G = devLog0;
                                j0.I = s7;
                                j0.M = null;
                                j0.N = null;
                                j0.S = v2;
                                j0.T = v4;
                                j0.V = v3;
                                j0.X = v1;
                                j0.W = v5;
                                j0.b0 = 3;
                                if(e0.e(this, e1, ((k1)n10).a, j0) == a0) {
                                    return a0;
                                }
                                goto label_169;
                            }
                            else {
                                goto label_175;
                            }
                        }
                        catch(Throwable throwable0) {
                            s2 = s7;
                            devLog1 = devLog0;
                            goto label_336;
                        }
                    }
                    else {
                        goto label_146;
                    label_169:
                        s12 = s7;
                        s13 = s4;
                        mutex3 = mutex1;
                        devLog1 = devLog0;
                        v11 = v1;
                        break;
                    label_175:
                        if(!(n10 instanceof va.l1)) {
                            s14 = s7;
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        goto label_180;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    s14 = s7;
                    devLog1 = devLog0;
                    s2 = s14;
                    goto label_336;
                }
            label_180:
                int v12 = this.l;
                if(v12 < 3) {
                    try {
                        this.l = v12 + 1;
                        j0.r = s5;
                        s15 = s6;
                        j0.w = s15;
                        j0.B = mutex1;
                        j0.D = s4;
                        j0.E = l00;
                        j0.G = devLog0;
                        j0.I = s7;
                        j0.M = null;
                        j0.N = null;
                        j0.S = v2;
                        j0.T = v4;
                        j0.V = v3;
                        j0.X = v1;
                        j0.W = v5;
                        j0.b0 = 4;
                        if(DelayKt.delay-VtjQ1oo(e0.o, j0) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog0;
                        s2 = s7;
                        goto label_336;
                    }
                    v13 = v5;
                    a2 = a0;
                    devLog1 = devLog0;
                    s16 = s5;
                    mutex4 = mutex1;
                    v14 = v2;
                    s12 = s7;
                    goto label_279;
                }
                else {
                    try {
                        s14 = s7;
                        this.l = 0;
                        va.l1 l10 = (va.l1)n10;
                        s13 = s4;
                        mutex3 = mutex1;
                        devLog1 = devLog0;
                        v11 = v1;
                        s12 = s14;
                        break;
                    }
                    catch(Throwable throwable0) {
                    }
                    devLog1 = devLog0;
                    s2 = s14;
                    goto label_336;
                }
                break;
            }
            case 2: {
                v11 = j0.X;
                s12 = j0.I;
                devLog1 = j0.G;
                l00 = j0.E;
                s13 = j0.D;
                mutex3 = j0.B;
                goto label_243;
            }
            case 3: {
                v11 = j0.X;
                s12 = j0.I;
                devLog1 = j0.G;
                l00 = j0.E;
                s13 = j0.D;
                mutex3 = j0.B;
                try {
                label_243:
                    n.D(object0);
                    break;
                    try {
                    label_245:
                        long v15 = j0.X;
                        int v16 = j0.V;
                        int v17 = j0.T;
                        int v18 = j0.S;
                        int v19 = j0.W;
                        object5 = j0.I;
                        DevLog devLog3 = j0.G;
                        com.iloen.melon.custom.L0 l02 = j0.E;
                        String s17 = j0.D;
                        mutex5 = j0.B;
                        String s18 = j0.w;
                        s16 = j0.r;
                        devLog1 = devLog3;
                        l00 = l02;
                        s4 = s17;
                        v1 = v15;
                        n.D(object0);
                        v4 = v17;
                        l00 = l02;
                        a2 = a0;
                        s4 = s17;
                        s15 = s18;
                        v14 = v18;
                        mutex4 = mutex5;
                        v1 = v15;
                        v3 = v16;
                        v13 = v19;
                        s12 = object5;
                        devLog1 = devLog3;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex5;
                        s2 = object5;
                        goto label_336;
                    }
                    try {
                    label_279:
                        j0.r = null;
                        j0.w = null;
                        j0.B = mutex4;
                        j0.D = s4;
                        j0.E = l00;
                        j0.G = devLog1;
                        j0.I = s12;
                        j0.M = null;
                        j0.N = null;
                        j0.S = v14;
                        j0.T = v4;
                        j0.V = v3;
                        j0.X = v1;
                        j0.W = v13;
                        j0.b0 = 5;
                        object0 = this.x(s16, s15, j0);
                    }
                    catch(Throwable throwable0) {
                        s2 = s12;
                        mutex1 = mutex4;
                        goto label_336;
                    }
                    if(object0 != a2) {
                        s13 = s4;
                        mutex3 = mutex4;
                        v11 = v1;
                        goto label_320;
                    }
                    return a2;
                label_306:
                    v11 = j0.X;
                    s12 = j0.I;
                    devLog1 = j0.G;
                    l00 = j0.E;
                    s13 = j0.D;
                    mutex3 = j0.B;
                    n.D(object0);
                    goto label_320;
                }
                catch(Throwable throwable0) {
                }
                goto label_315;
            }
            case 4: {
                goto label_245;
            }
            case 5: {
                goto label_306;
            label_315:
                s4 = s13;
                v20 = v11;
                s2 = s12;
                mutex1 = mutex3;
                goto label_335;
                try {
                label_320:
                    i0 i00 = (i0)object0;
                    break;
                }
                catch(Throwable throwable0) {
                    v1 = v11;
                    s2 = s12;
                    s4 = s13;
                    mutex1 = mutex3;
                    goto label_336;
                }
            }
            case 6: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            f00 = new f0(new Exception("LoginFromRestoreFailed"));
            goto label_347;
        }
        catch(Throwable throwable0) {
            s4 = s13;
            mutex1 = mutex3;
            v20 = v11;
            s2 = s12;
        }
    label_335:
        v1 = v20;
    label_336:
        long v21 = System.currentTimeMillis() - v1;
        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
        H0.b.t(v21, s4, " (", stringBuilder0);
        stringBuilder0.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
        H0.b.t(v21, s4, " (", stringBuilder1);
        l1.C(stringBuilder1, "ms)", devLog1);
        if(l00 != null) {
            com.iloen.melon.utils.a.u(s2, " ", s4, l00, false);
        }
        throw throwable0;
    label_347:
        long v22 = System.currentTimeMillis() - v11;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex3.hashCode(), s12);
        H0.b.t(v22, s13, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex3.hashCode(), s12);
        H0.b.t(v22, s13, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog1);
        if(l00 != null) {
            com.iloen.melon.utils.a.u(s12, " ", s13, l00, false);
        }
        return f00;
    }

    public final Object y(String s, String s1, oe.c c0) {
        com.iloen.melon.custom.L0 l03;
        DevLog devLog4;
        Mutex mutex5;
        long v12;
        Mutex mutex4;
        Object object4;
        ne.a a3;
        Mutex mutex3;
        String s4;
        com.iloen.melon.custom.L0 l02;
        DevLog devLog3;
        long v7;
        n1 n10;
        int v6;
        A8.F f1;
        int v5;
        int v4;
        int v3;
        Mutex mutex2;
        DevLog devLog2;
        com.iloen.melon.custom.L0 l01;
        String s3;
        com.iloen.melon.custom.L0 l00;
        String s2;
        Object object1;
        A8.F f0;
        a a2;
        DevLog devLog1;
        Mutex mutex1;
        k8.b b0;
        long v2;
        L l0;
        if(c0 instanceof L) {
            l0 = (L)c0;
            int v = l0.X;
            if((v & 0x80000000) == 0) {
                l0 = new L(this, c0);
            }
            else {
                l0.X = v ^ 0x80000000;
            }
        }
        else {
            l0 = new L(this, c0);
        }
        Object object0 = l0.V;
        ne.a a0 = ne.a.a;
        int v1 = l0.X;
        switch(v1) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.n;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), androidx.appcompat.app.o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-loginFromSimple()"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : LoginUseCase-loginFromSimple()", devLog0, mutex0);
                g g0 = l0.getContext().get(reentrantMutexContextKey0);
                a a1 = this.g;
                if(g0 != null) {
                    try {
                        v2 = System.currentTimeMillis();
                        b0 = (k8.b)a1;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        a2 = a1;
                        goto label_67;
                    }
                    try {
                        b0.a(" LoginUseCase-loginFromSimple()", true);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        a2 = a1;
                        goto label_67;
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginFromSimple()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : LoginUseCase-loginFromSimple()");
                        f0 = () -> "SIMPLE";
                        l0.r = mutex0;
                        l0.w = "LoginUseCase-loginFromSimple()";
                        l0.B = a1;
                        l0.D = devLog0;
                        l0.E = "";
                        l0.G = f0;
                        l0.I = 0;
                        l0.M = 0;
                        l0.N = 0;
                        l0.T = v2;
                        l0.S = 0;
                        l0.X = 1;
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog0;
                        mutex1 = mutex0;
                        s2 = "";
                        l00 = a1;
                        s3 = "LoginUseCase-loginFromSimple()";
                        goto label_226;
                    }
                    try {
                        a2 = a1;
                        object1 = ((j1)this.b).f(s, s1, l0);
                        goto label_72;
                    }
                    catch(Throwable throwable0) {
                        devLog1 = devLog0;
                        mutex1 = mutex0;
                    }
                label_67:
                    a1 = a2;
                    s2 = "";
                    l00 = a1;
                    s3 = "LoginUseCase-loginFromSimple()";
                    goto label_226;
                label_72:
                    if(object1 == a0) {
                        return a0;
                    }
                    try {
                        l01 = a2;
                        s2 = "";
                        devLog2 = devLog0;
                        mutex2 = mutex0;
                        s3 = "LoginUseCase-loginFromSimple()";
                        v3 = 0;
                        v4 = 0;
                        v5 = 0;
                        f1 = f0;
                        v6 = 0;
                        n10 = (n1)object1;
                        LogU.debug$default(this.j, "loginFromSimple() result : " + n10, null, false, 6, null);
                        goto label_134;
                    }
                    catch(Throwable throwable0) {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        mutex1 = mutex5;
                        devLog1 = devLog4;
                        l00 = l03;
                        goto label_226;
                    }
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                K k0 = new K(mutex0, null, a1, mutex0, devLog0, this, s, s1);
                l0.r = null;
                l0.w = null;
                l0.B = null;
                l0.D = null;
                l0.E = null;
                l0.I = 0;
                l0.M = 0;
                l0.X = 4;
                Object object2 = BuildersKt.withContext(reentrantMutexContextElement0, k0, l0);
                return object2 == a0 ? a0 : object2;
            }
            case 1: {
                try {
                    v7 = l0.T;
                    int v8 = l0.N;
                    int v9 = l0.M;
                    int v10 = l0.I;
                    A8.F f2 = l0.G;
                    int v11 = l0.S;
                    Object object3 = l0.E;
                    devLog3 = l0.D;
                    l02 = l0.B;
                    s4 = l0.w;
                    mutex3 = l0.r;
                    s2 = object3;
                    n.D(object0);
                    v3 = v11;
                    v5 = v9;
                    devLog2 = devLog3;
                    v4 = v10;
                    mutex2 = mutex3;
                    f1 = f2;
                    v6 = v8;
                    s2 = object3;
                    v2 = v7;
                    l01 = l02;
                    s3 = s4;
                }
                catch(Throwable throwable0) {
                    devLog1 = devLog3;
                    mutex1 = mutex3;
                    v2 = v7;
                    l00 = l02;
                    s3 = s4;
                    goto label_226;
                }
                try {
                    n10 = (n1)object0;
                    LogU.debug$default(this.j, "loginFromSimple() result : " + n10, null, false, 6, null);
                }
                catch(Throwable throwable0) {
                    mutex5 = mutex2;
                    devLog4 = devLog2;
                    l03 = l01;
                    mutex1 = mutex5;
                    devLog1 = devLog4;
                    l00 = l03;
                    goto label_226;
                }
            label_134:
                if(n10 instanceof m1) {
                    try {
                        l0.r = mutex2;
                        l0.w = s3;
                        l0.B = l01;
                        l0.D = devLog2;
                        l0.E = s2;
                        l0.G = null;
                        l0.I = v4;
                        l0.M = v5;
                        l0.N = v6;
                        l0.T = v2;
                        l0.S = v3;
                        l0.X = 2;
                        a3 = a0;
                        if(e0.f(this, f1, ((m1)n10).a, l0) != a3) {
                            object4 = h0.a;
                            break;
                        }
                        return a3;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        devLog1 = devLog2;
                        l00 = l01;
                        goto label_226;
                    }
                    try {
                        object4 = h0.a;
                    }
                    catch(Throwable throwable0) {
                        goto label_222;
                    }
                }
                else if(n10 instanceof k1) {
                    try {
                        l0.r = mutex2;
                        l0.w = s3;
                        l0.B = l01;
                        l0.D = devLog2;
                        l0.E = s2;
                        l0.G = null;
                        l0.I = v4;
                        l0.M = v5;
                        l0.N = v6;
                        l0.T = v2;
                        l0.S = v3;
                        l0.X = 3;
                        a3 = a0;
                        if(e0.e(this, f1, ((k1)n10).a, l0) != a3) {
                            mutex4 = mutex2;
                            v12 = v2;
                            object4 = new g0(L0.d);
                            v2 = v12;
                            mutex2 = mutex4;
                            break;
                        }
                        return a3;
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex2;
                        devLog1 = devLog2;
                        l00 = l01;
                        goto label_226;
                    }
                    try {
                        mutex4 = mutex2;
                        v12 = v2;
                        object4 = new g0(L0.d);
                        v2 = v12;
                        mutex2 = mutex4;
                        break;
                    }
                    catch(Throwable throwable0) {
                        goto label_222;
                    }
                    return a3;
                }
                else {
                    try {
                        if(n10 instanceof va.l1) {
                            e0.g(this);
                            object4 = new f0(((va.l1)n10).a);
                            break;
                        }
                    }
                    catch(Throwable throwable0) {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        mutex1 = mutex5;
                        devLog1 = devLog4;
                        l00 = l03;
                        goto label_226;
                    }
                    try {
                        mutex5 = mutex2;
                        devLog4 = devLog2;
                        l03 = l01;
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    catch(Throwable throwable0) {
                    }
                    mutex1 = mutex5;
                    devLog1 = devLog4;
                    l00 = l03;
                    goto label_226;
                }
                break;
            }
            case 2: {
                try {
                    v12 = l0.T;
                    s2 = l0.E;
                    devLog2 = l0.D;
                    l01 = l0.B;
                    s3 = l0.w;
                    mutex4 = l0.r;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                    goto label_214;
                }
                try {
                    object4 = h0.a;
                    v2 = v12;
                    mutex2 = mutex4;
                    break;
                }
                catch(Throwable throwable0) {
                    goto label_222;
                }
            }
            case 3: {
                try {
                    v12 = l0.T;
                    s2 = l0.E;
                    devLog2 = l0.D;
                    l01 = l0.B;
                    s3 = l0.w;
                    mutex4 = l0.r;
                    n.D(object0);
                }
                catch(Throwable throwable0) {
                label_214:
                    devLog1 = devLog2;
                    mutex1 = mutex4;
                    l00 = l01;
                    v2 = v12;
                    goto label_226;
                }
                try {
                    object4 = new g0(L0.d);
                    v2 = v12;
                    mutex2 = mutex4;
                    break;
                }
                catch(Throwable throwable0) {
                label_222:
                    v2 = v12;
                    devLog1 = devLog2;
                    l00 = l01;
                    mutex1 = mutex4;
                }
            label_226:
                long v13 = System.currentTimeMillis() - v2;
                StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
                H0.b.t(v13, s3, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex1.hashCode(), s2);
                H0.b.t(v13, s3, " (", stringBuilder1);
                l1.C(stringBuilder1, "ms)", devLog1);
                if(l00 != null) {
                    com.iloen.melon.utils.a.u(s2, " ", s3, l00, false);
                }
                throw throwable0;
            }
            default: {
                if(v1 != 4) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                return object0;
            }
        }
        long v14 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s2);
        H0.b.t(v14, s3, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s2);
        H0.b.t(v14, s3, " (", stringBuilder3);
        l1.C(stringBuilder3, "ms)", devLog2);
        if(l01 != null) {
            com.iloen.melon.utils.a.u(s2, " ", s3, l01, false);
        }
        return object4;
    }

    public final Object z(String s, boolean z, Continuation continuation0) {
        String s4;
        String s3;
        Mutex mutex0;
        String s2;
        com.iloen.melon.custom.L0 l00;
        DevLog devLog0;
        String s1;
        long v1;
        int v10;
        int v9;
        boolean z2;
        ne.a a1;
        int v8;
        int v7;
        Mutex mutex1;
        String s5;
        DevLog devLog1;
        Object object1;
        long v2;
        ne.a a2;
        long v16;
        Mutex mutex2;
        String s7;
        DevLog devLog2;
        String s6;
        boolean z3;
        int v14;
        int v13;
        long v11;
        String s8;
        Object object2;
        a7.c c0;
        String s9;
        long v21;
        k8.b b0;
        long v20;
        N n0;
        CoroutineDispatcher coroutineDispatcher0 = this.h;
        f f0 = this.c;
        l l0 = this.b;
        if(continuation0 instanceof N) {
            n0 = (N)continuation0;
            int v = n0.X;
            if((v & 0x80000000) == 0) {
                n0 = new N(this, continuation0);
            }
            else {
                n0.X = v ^ 0x80000000;
            }
        }
        else {
            n0 = new N(this, continuation0);
        }
        ne.a a0 = ne.a.a;
        Object object0 = n0.V;
        switch(n0.X) {
            case 0: {
                n.D(object0);
                Mutex mutex4 = this.n;
                s3 = "LoginUseCase-logout()";
                a a3 = this.g;
                s4 = "";
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(mutexLockUtil0.getLog(), androidx.appcompat.app.o.j(mutex4.hashCode(), "ReentrantLock[", "]  try : LoginUseCase-logout()"), null, false, 6, null);
                Companion devLog$Companion0 = DevLog.Companion;
                DevLog devLog4 = devLog$Companion0.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = l1.b("ReentrantLock[", mutex4.hashCode(), "]  try : LoginUseCase-logout()", devLog4, mutex4);
                if(n0.getContext().get(reentrantMutexContextKey0) == null) {
                    a1 = a0;
                    ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                    M m0 = new M(mutex4, null, a3, mutex4, devLog4, this, s, z);
                    n0.r = null;
                    n0.w = null;
                    n0.B = null;
                    n0.D = null;
                    n0.E = null;
                    n0.G = z;
                    n0.I = 0;
                    n0.M = 0;
                    n0.X = 5;
                    if(BuildersKt.withContext(reentrantMutexContextElement0, m0, n0) == a1) {
                        try {
                            return a1;
                        }
                        catch(Throwable throwable0) {
                        label_308:
                            s4 = s1;
                            s3 = s2;
                        }
                    label_310:
                        long v25 = System.currentTimeMillis() - v1;
                        StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s4);
                        H0.b.t(v25, s3, " (", stringBuilder2);
                        stringBuilder2.append("ms)");
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                        StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s4);
                        H0.b.t(v25, s3, " (", stringBuilder3);
                        l1.C(stringBuilder3, "ms)", devLog0);
                        if(l00 != null) {
                            com.iloen.melon.utils.a.u(s4, " ", s3, l00, false);
                        }
                        throw throwable0;
                    }
                }
                else {
                    try {
                        v20 = System.currentTimeMillis();
                        b0 = (k8.b)a3;
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        b0.a(" LoginUseCase-logout()", true);
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex4.hashCode() + "]  Lock obtain : LoginUseCase-logout()", null, false, 6, null);
                        devLog4.put("ReentrantLock[" + mutex4.hashCode() + "]  Lock obtain : LoginUseCase-logout()");
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        LoginUser loginUser0 = ((j1)l0).f;
                        LoginUser loginUser1 = ((j1)l0).f;
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        s9 = "logout() : \t reason=" + s + ", \n\t userId=" + "" + ", \n\t closeKakaoSession=" + z;
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        LogU.Companion.d("LoginUseCase", s9);
                        devLog$Companion0.get("Account").put(s9);
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        a7.c.a().b("logout");
                        c0 = a7.c.a();
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        I7.k k0 = new I7.k(c0.a, "log_reason", s, 27);
                        c0.a.o.a.a(k0);
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        c9.a.b("", s, Boolean.valueOf(z));
                        EpPlayLogger.INSTANCE.logout();
                        n0.r = mutex4;
                        n0.w = "LoginUseCase-logout()";
                        n0.B = a3;
                        n0.D = devLog4;
                        n0.E = "";
                        n0.G = z;
                        n0.I = 0;
                        n0.M = 0;
                        n0.N = 0;
                        v21 = v20;
                        n0.T = v21;
                        n0.S = 0;
                        n0.X = 1;
                    }
                    catch(Throwable throwable0) {
                        v21 = v20;
                        goto label_181;
                    }
                    try {
                        a2 = a0;
                        if(((j1)l0).o(n0) == a2) {
                            return a2;
                        }
                        goto label_187;
                    }
                    catch(Throwable throwable0) {
                    }
                label_181:
                    mutex0 = mutex4;
                    devLog0 = devLog4;
                    v1 = v21;
                    l00 = a3;
                    goto label_310;
                label_187:
                    z2 = z;
                    s2 = "LoginUseCase-logout()";
                    s1 = "";
                    v10 = 0;
                    v7 = 0;
                    v9 = 0;
                    devLog0 = devLog4;
                    l00 = a3;
                    v8 = 0;
                    mutex0 = mutex4;
                    v1 = v21;
                    try {
                    label_198:
                        this.e.q();
                        if(z2 && f0.a.c() != null) {
                            n0.r = mutex0;
                            n0.w = s2;
                            n0.B = l00;
                            n0.D = devLog0;
                            n0.E = s1;
                            n0.G = true;
                            n0.I = v9;
                            n0.M = v10;
                            n0.N = v8;
                            n0.T = v1;
                            n0.S = v7;
                            n0.X = 2;
                            if(f0.d(n0) == a2) {
                                return a2;
                            }
                            s6 = s1;
                            v16 = v1;
                            mutex2 = mutex0;
                            v13 = v10;
                            v14 = v9;
                            z3 = true;
                        label_219:
                            mutex0 = mutex2;
                            v1 = v16;
                            s1 = s6;
                            z2 = z3;
                            v9 = v14;
                            v10 = v13;
                        }
                        LogU.debug$default(z9.F.b, "clearAll()", null, false, 6, null);
                        z9.F.f.a();
                        z9.F.g = false;
                        z9.F.h = false;
                        CookieHelper cookieHelper0 = CookieHelper.getInstance();
                        cookieHelper0.removeKakaoWebLoginCookie();
                        cookieHelper0.removeSessionCookie();
                        O o0 = new O(cookieHelper0, null);
                        n0.r = mutex0;
                        n0.w = s2;
                        n0.B = l00;
                        n0.D = devLog0;
                        n0.E = s1;
                        n0.G = z2;
                        n0.I = v9;
                        n0.M = v10;
                        n0.N = v8;
                        n0.T = v1;
                        n0.S = v7;
                        n0.X = 3;
                        a1 = a2;
                        if(BuildersKt.withContext(coroutineDispatcher0, o0, n0) == a1) {
                            return a1;
                        }
                    label_247:
                        P p0 = new P(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        n0.r = mutex0;
                        n0.w = s2;
                        n0.B = l00;
                        n0.D = devLog0;
                        n0.E = s1;
                        n0.G = z2;
                        n0.I = v9;
                        n0.M = v10;
                        n0.N = v8;
                        n0.T = v1;
                        n0.S = v7;
                        n0.X = 4;
                        if(BuildersKt.withContext(coroutineDispatcher0, p0, n0) == a1) {
                            return a1;
                        }
                    label_261:
                        Bb.g g0 = Bb.g.a;
                        synchronized(g0) {
                            Bb.g.b.clear();
                        }
                        synchronized(g0) {
                            Bb.g.c.clear();
                        }
                        Bb.b.a();
                        BadgeUtils.setBadge(this.a, 0);
                        p9.a.a(this.a, 1, "");
                        p8.l l1 = new p8.l(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        BuildersKt__Builders_commonKt.launch$default(p8.q.b, null, null, l1, 3, null);
                        Airbridge.clearUserID();
                        Airbridge.trackEvent$default("airbridge.user.signout", null, null, 6, null);
                    }
                    catch(Throwable throwable0) {
                        goto label_308;
                    }
                    long v24 = System.currentTimeMillis() - v1;
                    StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
                    H0.b.t(v24, s2, " (", stringBuilder0);
                    stringBuilder0.append("ms)");
                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                    StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex0.hashCode(), s1);
                    H0.b.t(v24, s2, " (", stringBuilder1);
                    l1.C(stringBuilder1, "ms)", devLog0);
                    if(l00 != null) {
                        com.iloen.melon.utils.a.u(s1, " ", s2, l00, false);
                        return H.a;
                    }
                }
                break;
            }
            case 1: {
                try {
                    long v17 = n0.T;
                    int v18 = n0.N;
                    v10 = n0.M;
                    v9 = n0.I;
                    z2 = n0.G;
                    int v19 = n0.S;
                    object2 = n0.E;
                    DevLog devLog3 = n0.D;
                    com.iloen.melon.custom.L0 l03 = n0.B;
                    s8 = n0.w;
                    Mutex mutex3 = n0.r;
                    mutex0 = mutex3;
                    v1 = v17;
                    devLog0 = devLog3;
                    l00 = l03;
                    n.D(object0);
                    s1 = object2;
                    v8 = v18;
                    devLog0 = devLog3;
                    a2 = a0;
                    l00 = l03;
                    s2 = s8;
                    v7 = v19;
                    mutex0 = mutex3;
                    v1 = v17;
                    goto label_198;
                }
                catch(Throwable throwable0) {
                    s3 = s8;
                    s4 = object2;
                    goto label_310;
                }
            }
            case 2: {
                try {
                    v11 = n0.T;
                    int v12 = n0.N;
                    v13 = n0.M;
                    v14 = n0.I;
                    z3 = n0.G;
                    s6 = n0.E;
                    int v15 = n0.S;
                    devLog2 = n0.D;
                    com.iloen.melon.custom.L0 l02 = n0.B;
                    s7 = n0.w;
                    mutex2 = n0.r;
                    l00 = l02;
                    n.D(object0);
                    v16 = v11;
                    a2 = a0;
                    v7 = v15;
                    devLog0 = devLog2;
                    l00 = l02;
                    v8 = v12;
                    s2 = s7;
                    goto label_219;
                }
                catch(Throwable throwable0) {
                    s3 = s7;
                    mutex0 = mutex2;
                    v1 = v11;
                    s4 = s6;
                    devLog0 = devLog2;
                    goto label_310;
                }
            }
            case 3: {
                try {
                    v2 = n0.T;
                    int v3 = n0.N;
                    int v4 = n0.M;
                    int v5 = n0.I;
                    boolean z1 = n0.G;
                    object1 = n0.E;
                    int v6 = n0.S;
                    devLog1 = n0.D;
                    com.iloen.melon.custom.L0 l01 = n0.B;
                    s5 = n0.w;
                    mutex1 = n0.r;
                    l00 = l01;
                    n.D(object0);
                    v7 = v6;
                    v8 = v3;
                    s2 = s5;
                    a1 = a0;
                    l00 = l01;
                    mutex0 = mutex1;
                    v1 = v2;
                    s1 = object1;
                    devLog0 = devLog1;
                    z2 = z1;
                    v9 = v5;
                    v10 = v4;
                    goto label_247;
                }
                catch(Throwable throwable0) {
                    s3 = s5;
                    mutex0 = mutex1;
                    v1 = v2;
                    s4 = object1;
                    devLog0 = devLog1;
                    goto label_310;
                }
            }
            case 4: {
                try {
                    v1 = n0.T;
                    s1 = n0.E;
                    devLog0 = n0.D;
                    l00 = n0.B;
                    s2 = n0.w;
                    mutex0 = n0.r;
                    n.D(object0);
                    goto label_261;
                }
                catch(Throwable throwable0) {
                    s3 = s2;
                    s4 = s1;
                    goto label_310;
                }
            }
            case 5: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

