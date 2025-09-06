package l8;

import A7.d;
import M6.B;
import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.activity.MelonAppSvcActivity;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq.Params.Builder;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playlist.interfaces.SetRepeatResult;
import com.melon.playlist.interfaces.SetShuffleResult.Success;
import com.melon.playlist.interfaces.SetShuffleResult;
import ie.H;
import java.util.Set;
import kc.d3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import ob.z;
import oc.M;
import oe.i;
import p8.O;
import qd.W;
import r8.f;
import we.n;

public final class s extends i implements n {
    public int B;
    public final Uri D;
    public final MelonAppSvcActivity E;
    public final Activity G;
    public int r;
    public String w;

    public s(Uri uri0, MelonAppSvcActivity melonAppSvcActivity0, Activity activity0, Continuation continuation0) {
        this.D = uri0;
        this.E = melonAppSvcActivity0;
        this.G = activity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s(this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        M m0;
        Object object4;
        int v3;
        String s8;
        Object object3;
        Object object2;
        Object object1;
        int v;
        a a0 = a.a;
        Activity activity0 = this.G;
        H h0 = H.a;
        Uri uri0 = this.D;
        MelonAppSvcActivity melonAppSvcActivity0 = this.E;
    alab1:
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                Companion logU$Companion0 = LogU.Companion;
                String s = uri0.getAuthority();
                String s1 = uri0.getHost();
                String s2 = uri0.getPath();
                String s3 = uri0.getSchemeSpecificPart();
                StringBuilder stringBuilder0 = new StringBuilder("uri: ");
                stringBuilder0.append(uri0);
                stringBuilder0.append(", a:");
                stringBuilder0.append(s);
                stringBuilder0.append(", h:");
                d.u(stringBuilder0, s1, ", p:", s2, ", ssp:");
                stringBuilder0.append(s3);
                logU$Companion0.d("MelonAppSvcActivity", stringBuilder0.toString());
                v = "melonappsvc".equalsIgnoreCase(uri0.getScheme()) ? f.c.match(uri0) : -1;
                logU$Companion0.i("MelonAppSvcActivity", "URI match result: " + v);
                logU$Companion0.i("MelonAppSvcActivity", " >> menuId: " + uri0.getQueryParameter("menuid"));
                String s4 = uri0.getQueryParameter("launchedby");
                String s5 = uri0.getQueryParameter("ref");
                if(TextUtils.isEmpty(s4) && TextUtils.isEmpty(s5)) {
                    s5 = "unknown";
                }
                if(!TextUtils.isEmpty(s5)) {
                    s4 = s5;
                }
                O.a(new InflowPvLogDummyReq(melonAppSvcActivity0, new Builder(s4).uri(uri0).build()));
                switch(v) {
                    case 0x8FD: {
                        logU$Companion0.d("MelonAppSvcActivity", "PLAY_CONTROL_PLAY");
                        melonAppSvcActivity0.getPlayerUseCase().u();
                        return h0;
                    }
                    case 0x8FE: {
                        logU$Companion0.d("MelonAppSvcActivity", "PLAY_CONTROL_PAUSE");
                        melonAppSvcActivity0.getPlayerUseCase().s();
                        return h0;
                    }
                    case 0x8FF: {
                        boolean z1 = q.b(uri0.getQueryParameter("forced"), "Y");
                        logU$Companion0.d("MelonAppSvcActivity", "PLAY_CONTROL_PREV : " + z1);
                        z z2 = melonAppSvcActivity0.getPlayerUseCase();
                        this.r = 0x8FF;
                        this.B = 1;
                        if(z2.x(z1, this) == a0) {
                            return a0;
                        }
                        break alab1;
                    }
                    case 0x900: {
                        logU$Companion0.d("MelonAppSvcActivity", "PLAY_CONTROL_NEXT");
                        z z3 = melonAppSvcActivity0.getPlayerUseCase();
                        this.r = 0x900;
                        this.B = 2;
                        if(z3.q(this) == a0) {
                            return a0;
                        }
                        break alab1;
                    }
                    case 0x901: {
                        logU$Companion0.d("MelonAppSvcActivity", "PLAY_CONTROL_MODE");
                        Set set0 = uri0.getQueryParameterNames();
                        if(set0.contains("shuffle")) {
                            z z4 = melonAppSvcActivity0.getPlayerUseCase();
                            this.r = 0x901;
                            this.B = 3;
                            object1 = z4.o(this);
                            if(object1 == a0) {
                                return a0;
                            }
                            goto label_82;
                        }
                        else if(set0.contains("repeat")) {
                            z z5 = melonAppSvcActivity0.getPlayerUseCase();
                            this.r = 0x901;
                            this.B = 5;
                            object2 = z5.o(this);
                            if(object2 == a0) {
                                return a0;
                            }
                            goto label_107;
                        }
                        break alab1;
                    }
                    case 0x903: {
                        logU$Companion0.d("MelonAppSvcActivity", "PLAY_CONTROL_REPLAY");
                        z z0 = melonAppSvcActivity0.getPlayerUseCase();
                        LogU.info$default(z0.e.h, "replay()", null, false, 6, null);
                        Qb.q q0 = new Qb.q(z0.e, null);
                        z0.e.f(q0);
                        return h0;
                    }
                    default: {
                        logU$Companion0.w("MelonAppSvcActivity", "not a melonappsvc uri: " + uri0);
                        ToastManager.show(0x7F1310D7);  // string:unknown_scheme "현재 버전에서 지원하지 않는 기능입니다. 앱 업데이트 후 사용해주세요."
                        return h0;
                    }
                }
            }
            case 1: 
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            case 3: {
                int v1 = this.r;
                d5.n.D(object0);
                v = v1;
                object1 = object0;
            label_82:
                if(((Boolean)object1).booleanValue()) {
                    ((W)melonAppSvcActivity0.getShuffleRepeatChangeNotifier()).b(activity0);
                }
                String s6 = uri0.getQueryParameter("shuffle");
                if(s6 != null && s6.length() != 0) {
                    if(s6.equals("TOGGLE")) {
                        z z6 = melonAppSvcActivity0.getPlayerUseCase();
                        this.w = null;
                        this.r = v;
                        this.B = 4;
                        object3 = z6.F(this);
                        if(object3 == a0) {
                            return a0;
                        }
                        goto label_100;
                    }
                    ((d3)melonAppSvcActivity0.getPlaylistManager()).z(s6.equals("Y"));
                    return h0;
                }
                LogU.Companion.w("MelonAppSvcActivity", "PLAY_CONTROL_MODE_SHUFFLE - no value");
                return h0;
            }
            case 4: {
                d5.n.D(object0);
                object3 = object0;
            label_100:
                if(((SetShuffleResult)object3) instanceof Success) {
                    ((W)melonAppSvcActivity0.getShuffleRepeatChangeNotifier()).d(((Success)(((SetShuffleResult)object3))));
                    return h0;
                }
                break;
            }
            case 5: {
                int v2 = this.r;
                d5.n.D(object0);
                v = v2;
                object2 = object0;
            label_107:
                if(((Boolean)object2).booleanValue()) {
                    ((W)melonAppSvcActivity0.getShuffleRepeatChangeNotifier()).a(activity0);
                }
                String s7 = uri0.getQueryParameter("repeat");
                if(s7 != null && s7.length() != 0) {
                    B b0 = ((d3)melonAppSvcActivity0.getPlaylistManager()).h();
                    this.w = s7;
                    this.r = v;
                    this.B = 6;
                    if(ListenableFutureKt.await(b0, this) == a0) {
                        return a0;
                    }
                    s8 = s7;
                    v3 = v;
                    goto label_124;
                }
                LogU.Companion.w("MelonAppSvcActivity", "PLAY_CONTROL_MODE_REPEAT - no value");
                return h0;
            }
            case 6: {
                v3 = this.r;
                s8 = this.w;
                d5.n.D(object0);
            label_124:
                if(!q.b(s8, "TOGGLE")) {
                    goto label_132;
                }
                z z7 = melonAppSvcActivity0.getPlayerUseCase();
                this.w = null;
                this.r = v3;
                this.B = 7;
                object4 = z7.E(this);
                if(object4 == a0) {
                    return a0;
                label_132:
                    if("ALL".equals(s8)) {
                        m0 = M.b;
                    }
                    else {
                        m0 = "ONE".equals(s8) ? M.c : M.a;
                    }
                    ((d3)melonAppSvcActivity0.getPlaylistManager()).y(m0);
                    return h0;
                }
                goto label_140;
            }
            case 7: {
                d5.n.D(object0);
                object4 = object0;
            label_140:
                if(((SetRepeatResult)object4) instanceof com.melon.playlist.interfaces.SetRepeatResult.Success) {
                    ((W)melonAppSvcActivity0.getShuffleRepeatChangeNotifier()).c(((com.melon.playlist.interfaces.SetRepeatResult.Success)(((SetRepeatResult)object4))));
                    return h0;
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

