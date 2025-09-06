package dd;

import Qc.s;
import Uc.p;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS;
import com.kakao.tiara.data.ActionKind;
import java.util.LinkedHashMap;
import q8.c;

public final class a extends H {
    public final String g;

    public a() {
        this.g = "";
    }

    @Override  // dd.H
    public final String d() {
        return this.g;
    }

    public final void p(ActionKind actionKind0, String s, int v, int v1, CONTENTS mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, boolean z) {
        p p0 = H.c(this, actionKind0, null, v, v1, null, true, null, 0, null, 978);
        q8.a a0 = (q8.a)p0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            a1.g = s;
            p0.d = a1;
        }
        else {
            a0.g = s;
        }
        p0.e(new s(z, mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, 5));
        LinkedHashMap linkedHashMap0 = (LinkedHashMap)p0.g;
        c c0 = new c();
        String s1 = z ? mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.albumId : mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.songId;
        if(s1 == null) {
            s1 = "";
        }
        c0.a.put("toros_event_meta_id", s1);
        linkedHashMap0.putAll(c0.a);
        p0.p().track();
    }
}

