package jd;

import A8.M;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.Meta.Builder;
import ie.H;
import p8.f;
import we.a;

public final class k0 implements a {
    public final int a;
    public final M0 b;

    public k0(M0 m00, int v) {
        this.a = v;
        this.b = m00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        M0 m00 = this.b;
        if(this.a != 0) {
            LogU.debug$default(m00.B, "playMusicWave() success", null, false, 6, null);
            return h0;
        }
        f f0 = m00.i();
        if(f0 != null) {
            f0.a = "페이지이동";
            f0.y = "팝업";
            f0.F = "이용권구매";
            f0.b0 = new Builder().id(m00.g().e).type("뮤직웨이브").name(m00.g().b).build();
            f0.a().track();
        }
        MelonLinkExecutor.open("ZA", M.D);
        return h0;
    }
}

