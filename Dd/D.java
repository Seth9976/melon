package dd;

import Qc.s;
import Uc.p;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJCONTENT;
import com.kakao.tiara.data.ActionKind;
import q8.a;

public final class d extends H {
    public final String g;

    public d() {
        this.g = "";
    }

    @Override  // dd.H
    public final String d() {
        return this.g;
    }

    public final void p(DJCONTENT mainMusicRes$RESPONSE$DJCONTENT0, int v, ActionKind actionKind0, boolean z) {
        p p0 = H.c(this, actionKind0, null, 0, v, null, false, null, 0, null, 0x3F6);
        a a0 = (a)p0.d;
        String s = null;
        if(a0 == null) {
            a a1 = new a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            if(mainMusicRes$RESPONSE$DJCONTENT0 != null) {
                s = mainMusicRes$RESPONSE$DJCONTENT0.thumbimg;
            }
            a1.f = s;
            p0.d = a1;
        }
        else {
            if(mainMusicRes$RESPONSE$DJCONTENT0 != null) {
                s = mainMusicRes$RESPONSE$DJCONTENT0.thumbimg;
            }
            a0.f = s;
        }
        p0.e(new s(z, mainMusicRes$RESPONSE$DJCONTENT0, 6));
        p0.p().track();
    }
}

