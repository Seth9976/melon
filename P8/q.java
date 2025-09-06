package p8;

import A8.b;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.kakao.tiara.TiaraSettings.Builder;
import com.kakao.tiara.TiaraSettings;
import com.kakao.tiara.TiaraTracker;
import d3.g;
import e1.u;
import ie.r;
import java.util.HashMap;
import k8.t;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import m9.d;
import mb.k;
import va.e0;

public final class q {
    public static final LogU a;
    public static final CoroutineScope b;
    public static final String[] c;
    public static ApplicationInfo d;
    public static final r e;
    public static final r f;
    public static final r g;

    static {
        q.a = new LogU("MelonTiaraLog");
        q.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        q.c = new String[]{"daum.net", "kakao.com", "melon.com", "kakaopage.com"};
        q.e = g.Q(new d(29));
        q.f = g.Q(new e(0));
        q.g = g.Q(new e(1));
    }

    public static final K a() {
        return (K)q.f.getValue();
    }

    public static HashMap b() {
        HashMap hashMap0 = new HashMap();
        MelonAppBase.Companion.getClass();
        hashMap0.put("poc_id", t.a().getMelonCpId());
        hashMap0.put("log_prt_code", "SL");
        return hashMap0;
    }

    public static TiaraTracker c() {
        String s1;
        ApplicationInfo applicationInfo0 = q.d;
        String s = "";
        if(applicationInfo0 == null) {
            s1 = "";
        }
        else {
            Bundle bundle0 = applicationInfo0.metaData;
            if(bundle0 == null) {
                s1 = "";
            }
            else {
                s1 = bundle0.getString("TIARA_MELON_SVC");
                if(s1 == null) {
                    s1 = "";
                }
            }
        }
        TiaraTracker tiaraTracker0 = TiaraTracker.get("");
        if(tiaraTracker0 == null) {
            String s2 = u.w(((e0)(((k)q.e.getValue()))).j());
            HashMap hashMap0 = new HashMap();
            String s3 = Z.m(MelonAppBase.Companion, 0x7F1304C1, "getString(...)");  // string:kakao_app_key "5c2982b2ec377339ee67d3686f4813ac"
            String s4 = DeviceIdentifier.id(t.a().getDeviceData().a);
            if(s4 != null) {
                s = s4;
            }
            hashMap0.put("pcid", s);
            TiaraSettings tiaraSettings0 = new Builder().deployment((b.d() ? "production" : "dev")).batchInterval(60).batchSize(1).melonId(s2).kakaoAppKey(s3).userExAccount(hashMap0).appAdTrackId("2875552754074864296").build();
            kotlin.jvm.internal.q.f(tiaraSettings0, "build(...)");
            return TiaraTracker.newInstance(s1, tiaraSettings0);
        }
        return tiaraTracker0;
    }
}

