package p8;

import com.kakao.tiara.data.LogBuilder;

public final class i extends f {
    @Override  // p8.f
    public final LogBuilder a() {
        this.b();
        LogBuilder logBuilder0 = q.c().trackViewImp();
        kotlin.jvm.internal.q.f(logBuilder0, "trackViewImp(...)");
        logBuilder0.section(this.b);
        logBuilder0.page(this.c);
        logBuilder0.customProps(this.e0);
        logBuilder0.adTrackId("2875552754074864296");
        if(this.Z.getContents() != null) {
            logBuilder0.viewImpContents(this.Z);
        }
        return logBuilder0;
    }
}

