package dd;

import Uc.p;
import Vc.B;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.DJCONTENT;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STATSELEMENTS;
import com.kakao.tiara.data.ActionKind;
import java.util.LinkedHashMap;
import q8.a;

public final class c extends H {
    public final String g;

    public c() {
        this.g = "";
    }

    @Override  // dd.H
    public final String d() {
        return this.g;
    }

    public final void p(DJCONTENT mainMusicRes$RESPONSE$DJCONTENT0, int v, ActionKind actionKind0, String s, int v1, STATSELEMENTS mainMusicRes$RESPONSE$STATSELEMENTS0) {
        p p0 = H.c(this, actionKind0, null, 0, v, null, false, mainMusicRes$RESPONSE$STATSELEMENTS0, v1, s, 0x76);
        a a0 = (a)p0.d;
        if(a0 == null) {
            a a1 = new a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.f = mainMusicRes$RESPONSE$DJCONTENT0.thumbimg;
            p0.d = a1;
        }
        else {
            a0.f = mainMusicRes$RESPONSE$DJCONTENT0.thumbimg;
        }
        p0.e(new B(mainMusicRes$RESPONSE$DJCONTENT0, 29));
        q8.c c0 = new q8.c();
        c0.a.put("toros_event_meta_id", (mainMusicRes$RESPONSE$DJCONTENT0.plylstseq == null ? "" : mainMusicRes$RESPONSE$DJCONTENT0.plylstseq));
        ((LinkedHashMap)p0.g).putAll(c0.a);
        p0.p().track();
    }
}

