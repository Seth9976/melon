package p8;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.kakao.tiara.TiaraSettings;
import com.kakao.tiara.TiaraTracker;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import va.e0;
import va.o;

public final class n implements FlowCollector {
    public final int a;
    public static final n b;
    public static final n c;

    static {
        n.b = new n(0);
        n.c = new n(1);
    }

    public n(int v) {
        this.a = v;
        super();
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        TiaraSettings tiaraSettings1;
        String s1;
        TiaraSettings tiaraSettings0;
        String s;
        H h0 = H.a;
        TiaraTracker tiaraTracker0 = null;
        if(this.a != 0) {
            ApplicationInfo applicationInfo0 = q.d;
            if(applicationInfo0 == null) {
                s = null;
            }
            else {
                Bundle bundle0 = applicationInfo0.metaData;
                s = bundle0 == null ? null : bundle0.getString("TIARA_MELON_SVC");
            }
            if(s != null) {
                tiaraTracker0 = TiaraTracker.get(s);
            }
            if(tiaraTracker0 == null) {
                tiaraSettings0 = q.c().getSettings();
            }
            else {
                tiaraSettings0 = tiaraTracker0.getSettings();
                if(tiaraSettings0 == null) {
                    tiaraSettings0 = q.c().getSettings();
                }
            }
            tiaraSettings0.setThirdAdAgree(Boolean.valueOf(((L)object0).a));
            tiaraSettings0.setThirdProvideAgree(Boolean.valueOf(((L)object0).b));
            if(tiaraTracker0 != null) {
                tiaraTracker0.putGlobalCustomProperty("payment_type", ((L)object0).c);
                tiaraTracker0.putGlobalCustomProperty("product_name", ((L)object0).d);
                tiaraTracker0.putGlobalCustomProperty("product_price", ((L)object0).e);
                tiaraTracker0.putGlobalCustomProperty("restrict_ad", ((L)object0).f);
                tiaraTracker0.putGlobalCustomProperty("charged", (u.u(((e0)o.a()).j()).equals("4") ? "N" : "Y"));
            }
            return h0;
        }
        ApplicationInfo applicationInfo1 = q.d;
        if(applicationInfo1 == null) {
            s1 = null;
        }
        else {
            Bundle bundle1 = applicationInfo1.metaData;
            s1 = bundle1 == null ? null : bundle1.getString("TIARA_MELON_SVC");
        }
        if(s1 != null) {
            tiaraTracker0 = TiaraTracker.get(s1);
        }
        if(tiaraTracker0 == null) {
            tiaraSettings1 = q.c().getSettings();
        }
        else {
            tiaraSettings1 = tiaraTracker0.getSettings();
            if(tiaraSettings1 == null) {
                tiaraSettings1 = q.c().getSettings();
            }
        }
        tiaraSettings1.setMelonId("");
        tiaraSettings1.setAppUserId("");
        return h0;
    }
}

