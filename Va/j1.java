package va;

import A7.d;
import A8.J;
import A8.K;
import A8.c;
import A8.e;
import A8.g;
import A8.h;
import A8.q;
import A8.r;
import A8.t;
import A8.u;
import Cb.j;
import H0.b;
import androidx.appcompat.app.o;
import b3.Z;
import com.iloen.melon.LoginUser;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.LoginLoginRes.Response;
import com.iloen.melon.net.v4x.response.LoginLoginRes;
import com.iloen.melon.net.v6x.response.InformMyProfileRes.RESPONSE;
import com.iloen.melon.net.v6x.response.InformMyProfileRes;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.datastore.LoginUserPreferencesSerializer;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.utils.system.DeviceData;
import d5.n;
import e.k;
import i.n.i.b.a.s.e.M3;
import ie.H;
import k8.Y;
import k9.i;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import mb.l;
import ne.a;
import ob.f;
import pd.s;

public final class j1 implements l {
    public final J0 a;
    public final I0 b;
    public final DeviceData c;
    public final LogU d;
    public final Mutex e;
    public LoginUser f;
    public final Flow g;
    public final Flow h;
    public boolean i;

    public j1(J0 j00, I0 i00, DeviceData deviceData0) {
        this.a = j00;
        this.b = i00;
        this.c = deviceData0;
        LogU logU0 = Z.g("MelonLoginRepository", true);
        logU0.setCategory(Category.Login);
        this.d = logU0;
        this.e = MutexKt.Mutex$default(false, 1, null);
        this.f = (LoginUser)BuildersKt__BuildersKt.runBlocking$default(null, new f1(this, null), 1, null);
        this.g = FlowKt.distinctUntilChanged(new s(FlowKt.catch(i00.a.getData(), new n0(i00, null, 2)), 8));
        this.h = FlowKt.distinctUntilChanged(FlowKt.combine(new s(FlowKt.catch(i00.a.getData(), new n0(i00, null, 3)), 9), new s(FlowKt.catch(i00.a.getData(), new n0(i00, null, 4)), 10), new f(3, 2, null)));
        boolean z = this.f.getIsSetAdultAuth();
        boolean z1 = this.f.getMacOk();
        StringBuilder stringBuilder0 = d.o("init() loginUser: \n adult_flag_type: ", "", "\n app_user_id: ", "", "\n artist_id: ");
        d.u(stringBuilder0, "", "\n bnr_sgmt: ", "", "\n display_user_id: ");
        d.u(stringBuilder0, "", "\n hifi_prod_type: ", "", "\n is_set_adult_auth: ");
        Y.y(stringBuilder0, z, "\n login_type: ", "", "\n mac_ok: ");
        Y.y(stringBuilder0, z1, "\n member_image_url: ", "", "\n member_key: ");
        d.u(stringBuilder0, "", "\n member_nick_name: ", "", "\n product_info: ");
        d.u(stringBuilder0, "", "\n session_id: ", "", "\n tmp_call: ");
        d.u(stringBuilder0, "", "\n user_id: ", "", "\n token is null or empty: ");
        stringBuilder0.append(true);
        LogU.debug$default(logU0, stringBuilder0.toString(), null, false, 6, null);
    }

    public static final q a(j1 j10, r r0, u u0) {
        j10.getClass();
        String s = j10.c.e();
        String s1 = j10.c.h();
        e e0 = j10.c.c();
        String s2 = j10.c.g();
        K k0 = j10.c.f();
        g g0 = DeviceData.d();
        return new q("", null, null, r0, s, s1, c.b, e0, s2, k0, g0, u0, null, null, null, J.b);
    }

    public static final Object b(j1 j10, q q0, oe.c c0) {
        Response loginLoginRes$Response2;
        i1 i13;
        Integer integer1;
        String s26;
        String s25;
        Integer integer0;
        i1 i12;
        q q2;
        Object object2;
        i1 i11;
        a a1;
        i1 i10;
        j10.getClass();
        if(c0 instanceof i1) {
            i10 = (i1)c0;
            int v = i10.E;
            if((v & 0x80000000) == 0) {
                i10 = new i1(j10, c0);
            }
            else {
                i10.E = v ^ 0x80000000;
            }
        }
        else {
            i10 = new i1(j10, c0);
        }
        Object object0 = i10.B;
        a a0 = a.a;
        switch(i10.E) {
            case 0: {
                n.D(object0);
                String s = q0.i;
                J j0 = q0.p;
                g g0 = q0.k;
                K k0 = q0.j;
                e e0 = q0.h;
                c c1 = q0.g;
                String s1 = q0.f;
                u u0 = q0.l;
                r r0 = q0.d;
                String s2 = q0.b;
                StringBuilder stringBuilder0 = d.o("requestLogin() param\n id: ", q0.a, "\n pwd: ", s2, "\n token is null or empty: ");
                stringBuilder0.append(q0.c == null || q0.c.length() == 0);
                stringBuilder0.append("\n loginType: ");
                stringBuilder0.append(r0);
                stringBuilder0.append("\n option: ");
                stringBuilder0.append(u0);
                stringBuilder0.append("\n mdn: ");
                stringBuilder0.append(q0.e);
                stringBuilder0.append("\n min: ");
                stringBuilder0.append(s1);
                stringBuilder0.append("\n dcf: ");
                stringBuilder0.append(c1);
                stringBuilder0.append("\n deviceType: ");
                stringBuilder0.append(e0);
                stringBuilder0.append("\n mac: ");
                stringBuilder0.append(s);
                stringBuilder0.append("\n sktFlag: ");
                stringBuilder0.append(k0);
                stringBuilder0.append("\n drmInst: ");
                stringBuilder0.append(g0);
                stringBuilder0.append("\n kakaoId: ");
                d.u(stringBuilder0, q0.m, "\n kakaoToken: ", q0.n, "\n kakaoRefreshToken: ");
                stringBuilder0.append(q0.o);
                stringBuilder0.append("\n storeType: ");
                stringBuilder0.append(j0);
                LogU.debug$default(j10.d, stringBuilder0.toString(), null, false, 6, null);
                i10.r = q0;
                i10.E = 1;
                Ba.q q1 = j10.a.a;
                String s3 = q0.a;
                if(s2 == null || s2.length() == 0) {
                    s2 = null;
                }
                String s4 = q0.c;
                String s5 = s1;
                String s6 = r0.a;
                String s7 = q0.e;
                if(s5.length() == 0) {
                    s5 = null;
                }
                a1 = a0;
                Object object1 = q1.g(s3, s2, s4, s6, s7, s5, c1.a, e0.a, s, k0.a, g0.a, u0.a, q0.m, q0.n, q0.o, j0.a, i10);
                i11 = i10;
                if(object1 == a1) {
                    return a1;
                }
                object2 = object1;
                q2 = q0;
                goto label_76;
            }
            case 1: {
                q q3 = i10.r;
                n.D(object0);
                object2 = object0;
                i11 = i10;
                a1 = a0;
                q2 = q3;
            label_76:
                a7.c c2 = a7.c.a();
                LoginLoginRes loginLoginRes0 = (LoginLoginRes)ApiResultKt.getOrNull(((ApiResult)object2));
                String s8 = loginLoginRes0 == null ? null : loginLoginRes0.resultCode;
                LoginLoginRes loginLoginRes1 = (LoginLoginRes)ApiResultKt.getOrNull(((ApiResult)object2));
                String s9 = loginLoginRes1 == null ? null : loginLoginRes1.errorCode;
                LoginLoginRes loginLoginRes2 = (LoginLoginRes)ApiResultKt.getOrNull(((ApiResult)object2));
                String s10 = loginLoginRes2 == null ? null : loginLoginRes2.errorMsg;
                StringBuilder stringBuilder1 = d.o("getLoginRes resultCode: ", s8, " errorCode: ", s9, " errorMsg: ");
                stringBuilder1.append(s10);
                c2.b(stringBuilder1.toString());
                LoginLoginRes loginLoginRes3 = (LoginLoginRes)ApiResultKt.getOrNull(((ApiResult)object2));
                Response loginLoginRes$Response0 = loginLoginRes3 == null ? null : loginLoginRes3.response;
                LogU logU0 = j10.d;
                String s11 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.adultFlag;
                String s12 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.appUserId;
                String s13 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.artistId;
                String s14 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.displayLoginId;
                String s15 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.displayMemberId;
                String s16 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.isSetAdultAuthNum;
                String s17 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.joinType;
                String s18 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.joinUrl;
                String s19 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.langDcfYn;
                String s20 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.loginType;
                String s21 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.macOk;
                String s22 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.memberId;
                if(loginLoginRes$Response0 == null) {
                    i12 = i11;
                    integer0 = null;
                }
                else {
                    i12 = i11;
                    integer0 = new Integer(loginLoginRes$Response0.memberKey);
                }
                String s23 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.memberName;
                String s24 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.memberNickname;
                if(loginLoginRes$Response0 == null) {
                    s26 = s23;
                    s25 = s24;
                    integer1 = null;
                }
                else {
                    s25 = s24;
                    s26 = s23;
                    integer1 = new Integer(loginLoginRes$Response0.memberType);
                }
                String s27 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.min;
                String s28 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.myInfoNotiMsg;
                String s29 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.realName;
                String s30 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.sessionId;
                String s31 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.songDcfYn;
                String s32 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.tmpCall;
                String s33 = loginLoginRes$Response0 == null ? null : loginLoginRes$Response0.token;
                StringBuilder stringBuilder2 = d.o("requestLogin() loginResult response:\n adultFlag = ", s11, "\n appUserId = ", s12, "\n artistId = ");
                d.u(stringBuilder2, s13, "\n displayLoginId = ", s14, "\n displayMemberId = ");
                d.u(stringBuilder2, s15, "\n isSetAdultAuthNum = ", s16, "\n joinType = ");
                d.u(stringBuilder2, s17, "\n joinUrl = ", s18, "\n langDcfYn = ");
                d.u(stringBuilder2, s19, "\n loginType = ", s20, "\n macOk = ");
                d.u(stringBuilder2, s21, "\n memberId = ", s22, "\n memberKey = ");
                stringBuilder2.append(integer0);
                stringBuilder2.append("\n memberName = ");
                stringBuilder2.append(s26);
                stringBuilder2.append("\n memberNickname = ");
                stringBuilder2.append(s25);
                stringBuilder2.append("\n memberType = ");
                stringBuilder2.append(integer1);
                stringBuilder2.append("\n min = ");
                d.u(stringBuilder2, s27, "\n myInfoNotiMsg = ", s28, "\n realName = ");
                d.u(stringBuilder2, s29, "\n sessionId = ", s30, "\n songDcfYn = ");
                d.u(stringBuilder2, s31, "\n tmpCall = ", s32, "\n token is null or empty = ");
                stringBuilder2.append(s33 == null || s33.length() == 0);
                LogU.debug$default(logU0, stringBuilder2.toString(), null, false, 6, null);
                if(((ApiResult)object2) instanceof Success) {
                    LoginLoginRes loginLoginRes4 = (LoginLoginRes)((Success)(((ApiResult)object2))).getData();
                    Response loginLoginRes$Response1 = loginLoginRes4.response;
                    if(j.d(loginLoginRes4) && loginLoginRes$Response1 != null) {
                        long v1 = System.currentTimeMillis();
                        i12.r = null;
                        i12.w = loginLoginRes$Response1;
                        i12.E = 2;
                        String s34 = loginLoginRes$Response1.memberId;
                        boolean z = loginLoginRes$Response1.token == null || loginLoginRes$Response1.token.length() == 0;
                        String s35 = loginLoginRes$Response1.loginType;
                        int v2 = loginLoginRes$Response1.memberKey;
                        int v3 = loginLoginRes$Response1.memberType;
                        String s36 = loginLoginRes$Response1.adultFlag;
                        String s37 = loginLoginRes$Response1.macOk;
                        String s38 = loginLoginRes$Response1.artistId;
                        String s39 = loginLoginRes$Response1.sessionId;
                        String s40 = loginLoginRes$Response1.isSetAdultAuthNum;
                        String s41 = loginLoginRes$Response1.tmpCall;
                        String s42 = loginLoginRes$Response1.appUserId;
                        String s43 = loginLoginRes$Response1.displayLoginId;
                        StringBuilder stringBuilder3 = new StringBuilder("updateLoginData() res:\n memberId = ");
                        stringBuilder3.append(s34);
                        stringBuilder3.append("\n token is null or empty = ");
                        stringBuilder3.append(z);
                        stringBuilder3.append("\n loginType = ");
                        d.t(stringBuilder3, s35, "\n memberKey = ", v2, "\n memberType = ");
                        stringBuilder3.append(v3);
                        stringBuilder3.append("\n adultFlag = ");
                        stringBuilder3.append(s36);
                        stringBuilder3.append("\n macOk = ");
                        d.u(stringBuilder3, s37, "\n artistId = ", s38, "\n sessionId = ");
                        d.u(stringBuilder3, s39, "\n isSetAdultAuth = ", s40, "\n tmpCall = ");
                        d.u(stringBuilder3, s41, "\n appUserId = ", s42, "\n displayUserId = ");
                        stringBuilder3.append(s43);
                        stringBuilder3.append("\n currentTime = ");
                        stringBuilder3.append(v1);
                        LogU.debug$default(j10.d, stringBuilder3.toString(), null, false, 6, null);
                        k8.s s44 = (k8.s)j10.f.toBuilder();
                        String s45 = loginLoginRes$Response1.memberId;
                        String s46 = "";
                        if(s45 == null) {
                            s45 = "";
                        }
                        s44.d();
                        ((LoginUser)s44.b).setUserId(s45);
                        String s47 = loginLoginRes$Response1.token == null ? "" : loginLoginRes$Response1.token;
                        s44.d();
                        ((LoginUser)s44.b).setToken(s47);
                        String s48 = loginLoginRes$Response1.loginType;
                        r.b.getClass();
                        r r1 = z6.f.e(s48);
                        s44.d();
                        ((LoginUser)s44.b).setLoginType(r1.a);
                        String s49 = String.valueOf(loginLoginRes$Response1.memberKey);
                        s44.d();
                        ((LoginUser)s44.b).setMemberKey(s49);
                        Integer integer2 = new Integer(loginLoginRes$Response1.memberType);
                        t.b.getClass();
                        t t0 = w7.d.d(integer2);
                        s44.d();
                        ((LoginUser)s44.b).setMemberType(t0.a);
                        String s50 = loginLoginRes$Response1.adultFlag;
                        A8.a.b.getClass();
                        A8.a a2 = w7.d.b(s50);
                        s44.d();
                        ((LoginUser)s44.b).setAdultFlagType(a2.a);
                        s44.m(kotlin.jvm.internal.q.b(loginLoginRes$Response1.macOk, "Y"));
                        String s51 = loginLoginRes$Response1.min == null ? "" : loginLoginRes$Response1.min;
                        s44.d();
                        ((LoginUser)s44.b).setMin(s51);
                        String s52 = loginLoginRes$Response1.artistId == null ? "" : loginLoginRes$Response1.artistId;
                        s44.d();
                        ((LoginUser)s44.b).setArtistId(s52);
                        String s53 = loginLoginRes$Response1.sessionId == null ? "" : loginLoginRes$Response1.sessionId;
                        s44.d();
                        ((LoginUser)s44.b).setSessionId(s53);
                        s44.l(kotlin.jvm.internal.q.b(loginLoginRes$Response1.isSetAdultAuthNum, "Y"));
                        String s54 = loginLoginRes$Response1.tmpCall == null ? "" : loginLoginRes$Response1.tmpCall;
                        s44.d();
                        ((LoginUser)s44.b).setTmpCall(s54);
                        s44.i((loginLoginRes$Response1.appUserId == null ? "" : loginLoginRes$Response1.appUserId));
                        String s55 = loginLoginRes$Response1.displayLoginId;
                        if(s55 != null) {
                            s46 = s55;
                        }
                        s44.d();
                        ((LoginUser)s44.b).setDisplayUserId(s46);
                        s44.d();
                        ((LoginUser)s44.b).setAutoLoginSuccessTime(v1);
                        j10.f = (LoginUser)s44.a();
                        String s56 = loginLoginRes$Response1.memberId;
                        String s57 = loginLoginRes$Response1.token;
                        r r2 = z6.f.e(loginLoginRes$Response1.loginType);
                        String s58 = String.valueOf(loginLoginRes$Response1.memberKey);
                        t t1 = w7.d.d(new Integer(loginLoginRes$Response1.memberType));
                        A8.a a3 = w7.d.b(loginLoginRes$Response1.adultFlag);
                        boolean z1 = kotlin.jvm.internal.q.b(loginLoginRes$Response1.macOk, "Y");
                        String s59 = loginLoginRes$Response1.min;
                        String s60 = loginLoginRes$Response1.artistId;
                        String s61 = loginLoginRes$Response1.sessionId;
                        boolean z2 = kotlin.jvm.internal.q.b(loginLoginRes$Response1.isSetAdultAuthNum, "Y");
                        H h0 = j10.b.g(s56, s57, r2, s58, t1, a3, z1, s59, s60, s61, z2, loginLoginRes$Response1.tmpCall, loginLoginRes$Response1.appUserId, loginLoginRes$Response1.displayLoginId, new Long(v1), i12);
                        i13 = i12;
                        if(h0 != a1) {
                            h0 = H.a;
                        }
                        if(h0 == a1) {
                            return a1;
                        }
                        loginLoginRes$Response2 = loginLoginRes$Response1;
                        goto label_259;
                    }
                    return new k1(loginLoginRes4.notification, q2.d);
                }
                if(!(((ApiResult)object2) instanceof Failure)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new l1(new Exception(((Failure)(((ApiResult)object2))).throwCommonException()));
            }
            case 2: {
                Response loginLoginRes$Response3 = i10.w;
                n.D(object0);
                loginLoginRes$Response2 = loginLoginRes$Response3;
                i13 = i10;
                a1 = a0;
            label_259:
                i13.r = null;
                i13.w = loginLoginRes$Response2;
                i13.E = 3;
                if(j10.p(String.valueOf(loginLoginRes$Response2.memberKey), i13) == a1) {
                    return a1;
                }
                break;
            }
            case 3: {
                loginLoginRes$Response2 = i10.w;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s62 = loginLoginRes$Response2.loginType;
        r.b.getClass();
        return new m1(z6.f.e(s62));
    }

    public final Object c(String s, String s1, u u0, oe.c c0) {
        long v2;
        String s4;
        DevLog devLog1;
        String s3;
        Mutex mutex1;
        long v1;
        String s2;
        P0 p00;
        if(c0 instanceof P0) {
            p00 = (P0)c0;
            int v = p00.M;
            if((v & 0x80000000) == 0) {
                p00 = new P0(this, c0);
            }
            else {
                p00.M = v ^ 0x80000000;
            }
        }
        else {
            p00 = new P0(this, c0);
        }
        Object object0 = p00.G;
        a a0 = a.a;
        switch(p00.M) {
            case 0: {
                n.D(object0);
                s2 = "";
                Mutex mutex0 = this.e;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : MelonLoginRepository-doLoginByAuto"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : MelonLoginRepository-doLoginByAuto", devLog0, mutex0);
                if(p00.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByAuto", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByAuto");
                        LogU.debug$default(this.d, "doLoginByAuto() \n userId: " + s + ",\n token is empty: " + (s1.length() == 0) + ",\n option: " + u0 + ",\n savedLoginType: " + "" + ",\n paramLoginType: 3", null, false, 6, null);
                        r.b.getClass();
                        q q0 = q.a(j1.a(this, z6.f.e("3"), u0), s, null, s1, null, null, null, 0xFFFA);
                        p00.r = mutex0;
                        p00.w = "MelonLoginRepository-doLoginByAuto";
                        p00.B = devLog0;
                        p00.D = "";
                        p00.E = v1;
                        p00.M = 1;
                        object0 = j1.b(this, q0, p00);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        s3 = "MelonLoginRepository-doLoginByAuto";
                        devLog1 = devLog0;
                        goto label_70;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex1 = mutex0;
                    s4 = "";
                    v2 = v1;
                    s3 = "MelonLoginRepository-doLoginByAuto";
                    devLog1 = devLog0;
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                O0 o00 = new O0(mutex0, null, mutex0, devLog0, this, s, s1, u0);
                p00.r = null;
                p00.w = null;
                p00.B = null;
                p00.D = null;
                p00.M = 2;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, o00, p00);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                try {
                    v2 = p00.E;
                    s4 = p00.D;
                    devLog1 = p00.B;
                    s3 = p00.w;
                    mutex1 = p00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    s2 = s4;
                    v1 = v2;
                }
            label_70:
                long v3 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
                b.t(v3, s3, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
                b.t(v3, s3, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog1);
                throw throwable0;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s4, " Lock return : ");
        b.t(v4, s3, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s4, " Lock return : ");
        b.t(v4, s3, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog1);
        return object0;
    }

    public final Object d(String s, String s1, oe.c c0) {
        String s3;
        long v2;
        String s2;
        DevLog devLog1;
        Mutex mutex1;
        long v1;
        R0 r00;
        if(c0 instanceof R0) {
            r00 = (R0)c0;
            int v = r00.M;
            if((v & 0x80000000) == 0) {
                r00 = new R0(this, c0);
            }
            else {
                r00.M = v ^ 0x80000000;
            }
        }
        else {
            r00 = new R0(this, c0);
        }
        Object object0 = r00.G;
        a a0 = a.a;
        switch(r00.M) {
            case 0: {
                n.D(object0);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                Mutex mutex0 = this.e;
                LogU.debug$default(mutexLockUtil0.getLog(), o.j(this.e.hashCode(), "ReentrantLock[", "]  try : MelonLoginRepository-doLoginByIdAndPassword()"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : MelonLoginRepository-doLoginByIdAndPassword()", devLog0, mutex0);
                if(r00.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByIdAndPassword()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByIdAndPassword()");
                        q q0 = q.a(j1.a(this, r.d, u.d), s, s1, null, null, null, null, 0xFFFC);
                        r00.r = mutex0;
                        r00.w = "MelonLoginRepository-doLoginByIdAndPassword()";
                        r00.B = devLog0;
                        r00.D = "";
                        r00.E = v1;
                        r00.M = 1;
                        object0 = j1.b(this, q0, r00);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        s2 = "MelonLoginRepository-doLoginByIdAndPassword()";
                        v2 = v1;
                        s3 = "";
                        goto label_67;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex1 = mutex0;
                    devLog1 = devLog0;
                    s2 = "MelonLoginRepository-doLoginByIdAndPassword()";
                    v2 = v1;
                    s3 = "";
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                Q0 q00 = new Q0(mutex0, null, mutex0, devLog0, this, s, s1);
                r00.r = null;
                r00.w = null;
                r00.B = null;
                r00.D = null;
                r00.M = 2;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, q00, r00);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                try {
                    v2 = r00.E;
                    s3 = r00.D;
                    devLog1 = r00.B;
                    s2 = r00.w;
                    mutex1 = r00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_67:
                long v3 = System.currentTimeMillis() - v2;
                StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
                b.t(v3, s2, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
                b.t(v3, s2, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog1);
                throw throwable0;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
        b.t(v4, s2, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
        b.t(v4, s2, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog1);
        return object0;
    }

    public final Object e(String s, String s1, oe.c c0) {
        long v2;
        String s3;
        Mutex mutex1;
        String s2;
        long v1;
        DevLog devLog0;
        T0 t00;
        if(c0 instanceof T0) {
            t00 = (T0)c0;
            int v = t00.M;
            if((v & 0x80000000) == 0) {
                t00 = new T0(this, c0);
            }
            else {
                t00.M = v ^ 0x80000000;
            }
        }
        else {
            t00 = new T0(this, c0);
        }
        Object object0 = t00.G;
        a a0 = a.a;
        switch(t00.M) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : MelonLoginRepository-doLoginByIdAndPasswordWithUsingSimple()"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : MelonLoginRepository-doLoginByIdAndPasswordWithUsingSimple()", devLog0, mutex0);
                if(t00.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByIdAndPasswordWithUsingSimple()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByIdAndPasswordWithUsingSimple()");
                        LogU.debug$default(this.d, "doLoginByIdAndPasswordWithUsingSimple() userId: " + s + ", password: " + s1, null, false, 6, null);
                        q q0 = q.a(j1.a(this, r.e, u.d), s, s1, null, null, null, null, 0xFFFC);
                        t00.r = mutex0;
                        t00.w = "MelonLoginRepository-doLoginByIdAndPasswordWithUsingSimple()";
                        t00.B = devLog0;
                        t00.D = "";
                        t00.E = v1;
                        t00.M = 1;
                        object0 = j1.b(this, q0, t00);
                    }
                    catch(Throwable throwable0) {
                        s2 = "MelonLoginRepository-doLoginByIdAndPasswordWithUsingSimple()";
                        mutex1 = mutex0;
                        s3 = "";
                        goto label_66;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    s2 = "MelonLoginRepository-doLoginByIdAndPasswordWithUsingSimple()";
                    v2 = v1;
                    mutex1 = mutex0;
                    s3 = "";
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                S0 s00 = new S0(mutex0, null, mutex0, devLog0, this, s, s1);
                t00.r = null;
                t00.w = null;
                t00.B = null;
                t00.D = null;
                t00.M = 2;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, s00, t00);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                try {
                    v2 = t00.E;
                    s3 = t00.D;
                    devLog0 = t00.B;
                    s2 = t00.w;
                    mutex1 = t00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    v1 = v2;
                }
            label_66:
                long v3 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
                b.t(v3, s2, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
                b.t(v3, s2, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog0);
                throw throwable0;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
        b.t(v4, s2, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
        b.t(v4, s2, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog0);
        return object0;
    }

    public final Object f(String s, String s1, oe.c c0) {
        long v2;
        String s3;
        Mutex mutex1;
        String s2;
        long v1;
        DevLog devLog0;
        V0 v00;
        if(c0 instanceof V0) {
            v00 = (V0)c0;
            int v = v00.M;
            if((v & 0x80000000) == 0) {
                v00 = new V0(this, c0);
            }
            else {
                v00.M = v ^ 0x80000000;
            }
        }
        else {
            v00 = new V0(this, c0);
        }
        Object object0 = v00.G;
        a a0 = a.a;
        switch(v00.M) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : MelonLoginRepository-doLoginByIdAndTokenFromSimple()"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : MelonLoginRepository-doLoginByIdAndTokenFromSimple()", devLog0, mutex0);
                if(v00.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByIdAndTokenFromSimple()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByIdAndTokenFromSimple()");
                        LogU.debug$default(this.d, "doLoginByIdAndTokenFromSimple() userId: " + s + ", authToken: " + s1, null, false, 6, null);
                        q q0 = q.a(j1.a(this, r.f, u.d), s, null, s1, null, null, null, 0xFFFA);
                        v00.r = mutex0;
                        v00.w = "MelonLoginRepository-doLoginByIdAndTokenFromSimple()";
                        v00.B = devLog0;
                        v00.D = "";
                        v00.E = v1;
                        v00.M = 1;
                        object0 = j1.b(this, q0, v00);
                    }
                    catch(Throwable throwable0) {
                        s2 = "MelonLoginRepository-doLoginByIdAndTokenFromSimple()";
                        mutex1 = mutex0;
                        s3 = "";
                        goto label_66;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    s2 = "MelonLoginRepository-doLoginByIdAndTokenFromSimple()";
                    v2 = v1;
                    mutex1 = mutex0;
                    s3 = "";
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                U0 u00 = new U0(mutex0, null, mutex0, devLog0, this, s, s1);
                v00.r = null;
                v00.w = null;
                v00.B = null;
                v00.D = null;
                v00.M = 2;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, u00, v00);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                try {
                    v2 = v00.E;
                    s3 = v00.D;
                    devLog0 = v00.B;
                    s2 = v00.w;
                    mutex1 = v00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    v1 = v2;
                }
            label_66:
                long v3 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
                b.t(v3, s2, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
                b.t(v3, s2, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog0);
                throw throwable0;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
        b.t(v4, s2, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s3, " Lock return : ");
        b.t(v4, s2, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog0);
        return object0;
    }

    public final Object g(r r0, u u0, String s, String s1, String s2, oe.c c0) {
        long v2;
        String s4;
        Mutex mutex1;
        String s3;
        long v1;
        DevLog devLog0;
        X0 x00;
        if(c0 instanceof X0) {
            x00 = (X0)c0;
            int v = x00.M;
            if((v & 0x80000000) == 0) {
                x00 = new X0(this, c0);
            }
            else {
                x00.M = v ^ 0x80000000;
            }
        }
        else {
            x00 = new X0(this, c0);
        }
        Object object0 = x00.G;
        a a0 = a.a;
        switch(x00.M) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.e;
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), o.j(mutex0.hashCode(), "ReentrantLock[", "]  try : MelonLoginRepository-doLoginByKakao()"), null, false, 6, null);
                devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : MelonLoginRepository-doLoginByKakao()", devLog0, mutex0);
                if(x00.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByKakao()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByKakao()");
                        LogU.debug$default(this.d, "doLoginByKakao() \n loginType: " + r0 + ",\n loginOption: " + u0 + ",\n kakaoId: " + s + ",\n kakaoToken: " + s1 + ",\n kakaoRefreshToken: " + s2, null, false, 6, null);
                        if(!k.A(new r[]{r.g, r.h, r.i}).contains(r0)) {
                            try {
                                if(!A8.b.e()) {
                                    throw new IllegalArgumentException("doLoginByKakao(), loginType must be KAKAO, KAKAO_BY_SCHEME, KAKAO_BY_KAKAO_FAMILY");
                                }
                                LogU.error$default(this.d, "doLoginByKakao(), loginType must be KAKAO, KAKAO_BY_SCHEME, KAKAO_BY_KAKAO_FAMILY", null, false, 6, null);
                            }
                            catch(Throwable throwable0) {
                                s3 = "MelonLoginRepository-doLoginByKakao()";
                                mutex1 = mutex0;
                                s4 = "";
                                goto label_76;
                            }
                        }
                        q q0 = q.a(j1.a(this, r0, u0), null, null, null, s, s1, s2, 0x8FFF);
                        x00.r = mutex0;
                        x00.w = "MelonLoginRepository-doLoginByKakao()";
                        x00.B = devLog0;
                        x00.D = "";
                        x00.E = v1;
                        x00.M = 1;
                        object0 = j1.b(this, q0, x00);
                    }
                    catch(Throwable throwable0) {
                        s3 = "MelonLoginRepository-doLoginByKakao()";
                        mutex1 = mutex0;
                        s4 = "";
                        goto label_76;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    s3 = "MelonLoginRepository-doLoginByKakao()";
                    v2 = v1;
                    mutex1 = mutex0;
                    s4 = "";
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                W0 w00 = new W0(mutex0, null, mutex0, devLog0, this, r0, u0, s, s1, s2);
                x00.r = null;
                x00.w = null;
                x00.B = null;
                x00.D = null;
                x00.M = 2;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, w00, x00);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                try {
                    v2 = x00.E;
                    s4 = x00.D;
                    devLog0 = x00.B;
                    s3 = x00.w;
                    mutex1 = x00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    v1 = v2;
                }
            label_76:
                long v3 = System.currentTimeMillis() - v1;
                StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s4, " Lock return : ");
                b.t(v3, s3, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s4, " Lock return : ");
                b.t(v3, s3, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog0);
                throw throwable0;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s4, " Lock return : ");
        b.t(v4, s3, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s4, " Lock return : ");
        b.t(v4, s3, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog0);
        return object0;
    }

    public final Object h(String s, oe.c c0) {
        String s2;
        long v2;
        String s1;
        DevLog devLog1;
        Mutex mutex1;
        long v1;
        Z0 z00;
        if(c0 instanceof Z0) {
            z00 = (Z0)c0;
            int v = z00.M;
            if((v & 0x80000000) == 0) {
                z00 = new Z0(this, c0);
            }
            else {
                z00.M = v ^ 0x80000000;
            }
        }
        else {
            z00 = new Z0(this, c0);
        }
        Object object0 = z00.G;
        a a0 = a.a;
        switch(z00.M) {
            case 0: {
                n.D(object0);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                Mutex mutex0 = this.e;
                LogU.debug$default(mutexLockUtil0.getLog(), o.j(this.e.hashCode(), "ReentrantLock[", "]  try : MelonLoginRepository-doLoginByOtp()"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : MelonLoginRepository-doLoginByOtp()", devLog0, mutex0);
                if(z00.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByOtp()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByOtp()");
                        LogU.debug$default(this.d, "doLoginByOtp()", null, false, 6, null);
                        q q0 = q.a(j1.a(this, r.j, u.d), null, null, s, null, null, null, 0xFFFB);
                        z00.r = mutex0;
                        z00.w = "MelonLoginRepository-doLoginByOtp()";
                        z00.B = devLog0;
                        z00.D = "";
                        z00.E = v1;
                        z00.M = 1;
                        object0 = j1.b(this, q0, z00);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        s1 = "MelonLoginRepository-doLoginByOtp()";
                        v2 = v1;
                        s2 = "";
                        goto label_68;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex1 = mutex0;
                    devLog1 = devLog0;
                    s1 = "MelonLoginRepository-doLoginByOtp()";
                    v2 = v1;
                    s2 = "";
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                Y0 y00 = new Y0(mutex0, null, mutex0, devLog0, this, s);
                z00.r = null;
                z00.w = null;
                z00.B = null;
                z00.D = null;
                z00.M = 2;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, y00, z00);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                try {
                    v2 = z00.E;
                    s2 = z00.D;
                    devLog1 = z00.B;
                    s1 = z00.w;
                    mutex1 = z00.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_68:
                long v3 = System.currentTimeMillis() - v2;
                StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
                b.t(v3, s1, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
                b.t(v3, s1, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog1);
                throw throwable0;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
        b.t(v4, s1, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
        b.t(v4, s1, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog1);
        return object0;
    }

    public final Object i(String s, oe.c c0) {
        String s2;
        long v2;
        String s1;
        DevLog devLog1;
        Mutex mutex1;
        long v1;
        b1 b10;
        if(c0 instanceof b1) {
            b10 = (b1)c0;
            int v = b10.M;
            if((v & 0x80000000) == 0) {
                b10 = new b1(this, c0);
            }
            else {
                b10.M = v ^ 0x80000000;
            }
        }
        else {
            b10 = new b1(this, c0);
        }
        Object object0 = b10.G;
        a a0 = a.a;
        switch(b10.M) {
            case 0: {
                n.D(object0);
                MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                Mutex mutex0 = this.e;
                LogU.debug$default(mutexLockUtil0.getLog(), o.j(this.e.hashCode(), "ReentrantLock[", "]  try : MelonLoginRepository-doLoginByOtpBackground()"), null, false, 6, null);
                DevLog devLog0 = DevLog.Companion.get("MutexLockUtil");
                ReentrantMutexContextKey reentrantMutexContextKey0 = com.iloen.melon.custom.l1.b("ReentrantLock[", mutex0.hashCode(), "]  try : MelonLoginRepository-doLoginByOtpBackground()", devLog0, mutex0);
                if(b10.getContext().get(reentrantMutexContextKey0) != null) {
                    try {
                        v1 = System.currentTimeMillis();
                        LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByOtpBackground()", null, false, 6, null);
                        devLog0.put("ReentrantLock[" + mutex0.hashCode() + "]  Lock obtain : MelonLoginRepository-doLoginByOtpBackground()");
                        LogU.debug$default(this.d, "doLoginByOtp()", null, false, 6, null);
                        q q0 = q.a(j1.a(this, r.k, u.d), null, null, s, null, null, null, 0xFFFB);
                        this.i = true;
                        b10.r = mutex0;
                        b10.w = "MelonLoginRepository-doLoginByOtpBackground()";
                        b10.B = devLog0;
                        b10.D = "";
                        b10.E = v1;
                        b10.M = 1;
                        object0 = j1.b(this, q0, b10);
                    }
                    catch(Throwable throwable0) {
                        mutex1 = mutex0;
                        devLog1 = devLog0;
                        s1 = "MelonLoginRepository-doLoginByOtpBackground()";
                        v2 = v1;
                        s2 = "";
                        goto label_69;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    mutex1 = mutex0;
                    devLog1 = devLog0;
                    s1 = "MelonLoginRepository-doLoginByOtpBackground()";
                    v2 = v1;
                    s2 = "";
                    break;
                }
                ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey0);
                a1 a10 = new a1(mutex0, null, mutex0, devLog0, this, s);
                b10.r = null;
                b10.w = null;
                b10.B = null;
                b10.D = null;
                b10.M = 2;
                Object object1 = BuildersKt.withContext(reentrantMutexContextElement0, a10, b10);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                try {
                    v2 = b10.E;
                    s2 = b10.D;
                    devLog1 = b10.B;
                    s1 = b10.w;
                    mutex1 = b10.r;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
            label_69:
                long v3 = System.currentTimeMillis() - v2;
                StringBuilder stringBuilder0 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
                b.t(v3, s1, " (", stringBuilder0);
                stringBuilder0.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                StringBuilder stringBuilder1 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
                b.t(v3, s1, " (", stringBuilder1);
                com.iloen.melon.custom.l1.C(stringBuilder1, "ms)", devLog1);
                throw throwable0;
            }
            case 2: {
                n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = System.currentTimeMillis() - v2;
        StringBuilder stringBuilder2 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
        b.t(v4, s1, " (", stringBuilder2);
        stringBuilder2.append("ms)");
        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
        StringBuilder stringBuilder3 = va.e.e(mutex1.hashCode(), "ReentrantLock[", "] ", s2, " Lock return : ");
        b.t(v4, s1, " (", stringBuilder3);
        com.iloen.melon.custom.l1.C(stringBuilder3, "ms)", devLog1);
        return object0;
    }

    public final Object j(A8.k k0, String s, String s1, long v, String s2, String s3, oe.c c0) {
        d1 d10;
        if(c0 instanceof d1) {
            d10 = (d1)c0;
            int v1 = d10.B;
            if((v1 & 0x80000000) == 0) {
                d10 = new d1(this, c0);
            }
            else {
                d10.B = v1 ^ 0x80000000;
            }
        }
        else {
            d10 = new d1(this, c0);
        }
        Object object0 = d10.r;
        a a0 = a.a;
        switch(d10.B) {
            case 0: {
                n.D(object0);
                d10.B = 1;
                k0.getClass();
                object0 = this.a.a.a("1", s, s1, (v <= 0L ? "" : String.valueOf(v)), s2, s3, (s2.length() == 0 ? "N" : "Y"), d10);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object k(String s, oe.c c0) {
        c1 c10;
        if(c0 instanceof c1) {
            c10 = (c1)c0;
            int v = c10.B;
            if((v & 0x80000000) == 0) {
                c10 = new c1(this, c0);
            }
            else {
                c10.B = v ^ 0x80000000;
            }
        }
        else {
            c10 = new c1(this, c0);
        }
        Object object0 = c10.r;
        a a0 = a.a;
        switch(c10.B) {
            case 0: {
                n.D(object0);
                c10.B = 1;
                object0 = this.a.a.c(s, c10);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final LoginUser l() {
        return this.f;
    }

    public final Object m(long v, oe.c c0) {
        long v5;
        int v4;
        long v3;
        int v6;
        long v2;
        e1 e10;
        if(c0 instanceof e1) {
            e10 = (e1)c0;
            int v1 = e10.G;
            if((v1 & 0x80000000) == 0) {
                e10 = new e1(this, c0);
            }
            else {
                e10.G = v1 ^ 0x80000000;
            }
        }
        else {
            e10 = new e1(this, c0);
        }
        Object object0 = e10.D;
        a a0 = a.a;
        I0 i00 = this.b;
        boolean z = true;
        switch(e10.G) {
            case 0: {
                n.D(object0);
                e10.r = v;
                e10.G = 1;
                object0 = FlowKt.first(new s(FlowKt.catch(i00.a.getData(), new n0(i00, null, 1)), 7), e10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_23;
            }
            case 1: {
                v = e10.r;
                n.D(object0);
            label_23:
                v2 = ((Number)object0).longValue();
                if(A8.b.d()) {
                    v6 = 21600000;
                }
                else {
                    e10.r = v;
                    e10.w = v2;
                    e10.B = 60000;
                    e10.G = 2;
                    Object object1 = FlowKt.first(new s(FlowKt.catch(i00.a.getData(), new n0(i00, null, 0)), 6), e10);
                    if(object1 == a0) {
                        return a0;
                    }
                    v3 = v;
                    v4 = 60000;
                    object0 = object1;
                    v5 = v2;
                    v6 = ((Number)object0).intValue() * v4;
                    v2 = v5;
                    v = v3;
                    break;
                }
                break;
            }
            case 2: {
                v4 = e10.B;
                v5 = e10.w;
                v3 = e10.r;
                n.D(object0);
                v6 = ((Number)object0).intValue() * v4;
                v2 = v5;
                v = v3;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(v >= v2 + ((long)v6)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    // 去混淆评级： 低(33)
    public final boolean n() {
        if(e1.u.o("")) {
            kotlin.jvm.internal.q.f("", "getToken(...)");
        }
        return false;
    }

    public final Object o(oe.c c0) {
        g1 g10;
        if(c0 instanceof g1) {
            g10 = (g1)c0;
            int v = g10.B;
            if((v & 0x80000000) == 0) {
                g10 = new g1(this, c0);
            }
            else {
                g10.B = v ^ 0x80000000;
            }
        }
        else {
            g10 = new g1(this, c0);
        }
        Object object0 = g10.r;
        a a0 = a.a;
        switch(g10.B) {
            case 0: {
                n.D(object0);
                LoginUser loginUser0 = LoginUserPreferencesSerializer.INSTANCE.createDefaultValue();
                kotlin.jvm.internal.q.g(loginUser0, "<set-?>");
                this.f = loginUser0;
                g10.B = 1;
                if(this.b.a(g10) == a0) {
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
        this.i = false;
        return H.a;
    }

    public final Object p(String s, oe.c c0) {
        H h1;
        RESPONSE informMyProfileRes$RESPONSE0;
        h1 h10;
        if(c0 instanceof h1) {
            h10 = (h1)c0;
            int v = h10.D;
            if((v & 0x80000000) == 0) {
                h10 = new h1(this, c0);
            }
            else {
                h10.D = v ^ 0x80000000;
            }
        }
        else {
            h10 = new h1(this, c0);
        }
        Object object0 = h10.w;
        a a0 = a.a;
        H h0 = H.a;
        switch(h10.D) {
            case 0: {
                n.D(object0);
                h10.D = 1;
                object0 = this.a.b.d(s, h10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_20;
            }
            case 1: {
                n.D(object0);
            label_20:
                LogU.debug$default(this.d, "requestInformMyProfile result: " + ((ApiResult)object0), null, false, 6, null);
                if(!(((ApiResult)object0) instanceof Success)) {
                    goto label_65;
                }
                if(j.d(((HttpResponse)((Success)(((ApiResult)object0))).getData()))) {
                    informMyProfileRes$RESPONSE0 = ((InformMyProfileRes)((Success)(((ApiResult)object0))).getData()).response;
                    h10.r = informMyProfileRes$RESPONSE0;
                    h10.D = 2;
                    if(informMyProfileRes$RESPONSE0 == null) {
                        LogU.debug$default(this.d, "updateProfileData() res is null", null, false, 6, null);
                        h1 = h0;
                    }
                    else {
                        k8.s s1 = (k8.s)this.f.toBuilder();
                        s1.k(informMyProfileRes$RESPONSE0.isDj);
                        String s2 = informMyProfileRes$RESPONSE0.myPageImg;
                        String s3 = "";
                        if(s2 == null) {
                            s2 = "";
                        }
                        s1.d();
                        ((LoginUser)s1.b).setMemberImageUrl(s2);
                        s1.n((informMyProfileRes$RESPONSE0.memberNickname == null ? "" : informMyProfileRes$RESPONSE0.memberNickname));
                        String s4 = informMyProfileRes$RESPONSE0.bnrSgmt == null ? "" : informMyProfileRes$RESPONSE0.bnrSgmt;
                        s1.d();
                        ((LoginUser)s1.b).setBnrSgmt(s4);
                        s1.j(informMyProfileRes$RESPONSE0.hasFlacStProd);
                        String s5 = informMyProfileRes$RESPONSE0.hifiProd;
                        h.b.getClass();
                        h h2 = w7.d.c(s5);
                        s1.d();
                        ((LoginUser)s1.b).setHifiProdType(h2.a);
                        String s6 = informMyProfileRes$RESPONSE0.productInfo;
                        if(s6 != null) {
                            s3 = s6;
                        }
                        s1.d();
                        ((LoginUser)s1.b).setProductInfo(s3);
                        this.f = (LoginUser)s1.a();
                        Boolean boolean0 = Boolean.valueOf(informMyProfileRes$RESPONSE0.isDj);
                        String s7 = informMyProfileRes$RESPONSE0.myPageImg;
                        String s8 = informMyProfileRes$RESPONSE0.memberNickname;
                        String s9 = informMyProfileRes$RESPONSE0.bnrSgmt;
                        Boolean boolean1 = Boolean.valueOf(informMyProfileRes$RESPONSE0.hasFlacStProd);
                        h h3 = w7.d.c(informMyProfileRes$RESPONSE0.hifiProd);
                        h1 = this.b.j(boolean0, s7, s8, s9, boolean1, h3, informMyProfileRes$RESPONSE0.productInfo, h10);
                        if(h1 != a0) {
                            h1 = h0;
                        }
                    }
                    if(h1 == a0) {
                        return a0;
                    label_65:
                        if(!(((ApiResult)object0) instanceof Failure)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        ((Failure)(((ApiResult)object0))).throwCommonException();
                        LogU.debug$default(this.d, "requestInformMyProfile is network error", null, false, 6, null);
                        return h0;
                    }
                    goto label_72;
                }
                return h0;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        informMyProfileRes$RESPONSE0 = h10.r;
        n.D(object0);
    label_72:
        if(informMyProfileRes$RESPONSE0 == null) {
            LogU.debug$default(this.d, "updateAuthInfo() res is null", null, false, 6, null);
            return h0;
        }
        String s10 = informMyProfileRes$RESPONSE0.productInfo;
        if(s10 != null) {
            i.e(s10);
            if(k9.j.a() != 5) {
                k9.h.j();
                Q8.d.a.d();
            }
        }
        return h0;
    }
}

