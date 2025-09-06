package p8;

import com.kakao.tiara.TiaraTracker;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Click;
import com.kakao.tiara.data.LogBuilder;
import com.kakao.tiara.data.Meta;
import com.kakao.tiara.data.Search;

public final class g extends f {
    @Override  // p8.f
    public final LogBuilder a() {
        this.b();
        TiaraTracker tiaraTracker0 = q.c();
        String s = this.a;
        kotlin.jvm.internal.q.d(s);
        LogBuilder logBuilder0 = tiaraTracker0.trackEvent(s);
        kotlin.jvm.internal.q.f(logBuilder0, "trackEvent(...)");
        logBuilder0.section(this.b);
        logBuilder0.page(this.c);
        logBuilder0.customProps(this.e0);
        logBuilder0.adTrackId("2875552754074864296");
        ActionKind actionKind0 = this.d;
        if(actionKind0 != null) {
            logBuilder0.actionKind(actionKind0);
        }
        Meta meta0 = this.b0;
        if(meta0 != null) {
            logBuilder0.eventMeta(meta0);
        }
        Meta meta1 = this.c0;
        if(meta1 != null) {
            logBuilder0.pageMeta(meta1);
        }
        Click click0 = this.a0;
        if(click0 != null) {
            logBuilder0.click(click0);
        }
        Search search0 = this.d0;
        if(search0 != null) {
            logBuilder0.search(search0);
        }
        return logBuilder0;
    }
}

