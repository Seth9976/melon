package hd;

import Kd.g;
import Kd.h;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.n0;
import com.melon.ui.n;
import ie.H;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.q;
import we.a;

public final class q1 implements a {
    public final int a;
    public final s1 b;
    public final String c;
    public final g d;

    public q1(g g0, s1 s10, String s) {
        this.a = 0;
        super();
        this.d = g0;
        this.b = s10;
        this.c = s;
    }

    public q1(s1 s10, String s, g g0) {
        this.a = 1;
        super();
        this.b = s10;
        this.c = s;
        this.d = g0;
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            n0 n00 = this.b.getViewModel();
            String s = this.b.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            q.f(s, "getString(...)");
            String s1 = this.b.getString(0x7F130E80);  // string:tiara_dna_layer1_many_listen "최다 감상곡"
            q.f(s1, "getString(...)");
            String s2 = this.b.getString(0x7F130E77);  // string:tiara_dna_copy_play_music "음악재생"
            q.f(s2, "getString(...)");
            String s3 = this.b.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
            q.f(s3, "getString(...)");
            O1.f(((O1)n00), s, ActionKind.PlayMusic, s1, null, this.c, s2, null, null, null, this.d.a, s3, this.d.b, 456);
            List list0 = Collections.singletonList(h.b(this.d, "9999999999"));
            q.f(list0, "singletonList(...)");
            n n0 = new n(list0, "9999999999", false, false, null, 0x7C);
            this.b.sendUserEvent(n0);
            return H.a;
        }
        Navigator.openAlbumInfo(this.d.c);
        n0 n01 = this.b.getViewModel();
        String s4 = this.b.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        q.f(s4, "getString(...)");
        String s5 = this.b.getString(0x7F130E80);  // string:tiara_dna_layer1_many_listen "최다 감상곡"
        q.f(s5, "getString(...)");
        String s6 = this.b.getString(0x7F130E6E);  // string:tiara_dna_copy_move_album_detail "앨범상세이동"
        q.f(s6, "getString(...)");
        String s7 = this.b.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
        q.f(s7, "getString(...)");
        O1.f(((O1)n01), s4, ActionKind.ClickContent, s5, null, this.c, s6, null, null, null, this.d.c, s7, this.d.d, 456);
        return H.a;
    }
}

