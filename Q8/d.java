package q8;

import Qb.h;
import android.text.TextUtils;
import com.kakao.tiara.TiaraTracker;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.LogBuilder;
import com.kakao.tiara.data.TrafficSource;
import java.util.LinkedHashMap;
import p8.q;

public class d extends h {
    public final LogBuilder p() {
        LinkedHashMap linkedHashMap0 = (LinkedHashMap)this.g;
        f f0 = (f)this.e;
        String s = f0 == null ? null : f0.a().a;
        String s1 = (String)linkedHashMap0.get("toros_event_meta_id");
        String s2 = (String)linkedHashMap0.get("toros_banner_imp_id");
        String s3 = (String)linkedHashMap0.get("toros_slot_imp_id");
        if((s1 == null || s1.length() == 0) && !TextUtils.isEmpty(s) && (!TextUtils.isEmpty(s2) || !TextUtils.isEmpty(s3))) {
            linkedHashMap0.put("toros_event_meta_id", String.valueOf(s));
        }
        TiaraTracker tiaraTracker0 = q.c();
        String s4 = ((q8.h)this.b).a;
        if(s4 == null) {
            s4 = "";
        }
        LogBuilder logBuilder0 = tiaraTracker0.trackEvent(s4);
        kotlin.jvm.internal.q.f(logBuilder0, "trackEvent(...)");
        logBuilder0.customProps(linkedHashMap0);
        logBuilder0.adTrackId("2875552754074864296");
        b b0 = (b)this.c;
        if(b0 != null) {
            String s5 = b0.b;
            ActionKind actionKind0 = b0.c;
            TrafficSource trafficSource0 = b0.d;
            logBuilder0.section(b0.a);
            logBuilder0.page(s5);
            if(actionKind0 != null) {
                logBuilder0.actionKind(actionKind0);
            }
            if(trafficSource0 != null) {
                logBuilder0.trafficSource(trafficSource0);
            }
        }
        f f1 = (f)this.e;
        if(f1 != null) {
            logBuilder0.eventMeta(g.a(f1.a()));
        }
        f f2 = (f)this.f;
        if(f2 != null) {
            logBuilder0.pageMeta(g.a(f2.a()));
        }
        a a0 = (a)this.d;
        if(a0 != null) {
            logBuilder0.click(a0.build());
        }
        return logBuilder0;
    }
}

