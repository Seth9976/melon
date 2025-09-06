package xc;

import Cb.i;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import m0.b;
import p8.f;
import wc.x;
import we.k;
import xd.g;
import xd.h;

public final class w implements k {
    public final int a;
    public final z b;

    public w(z z0, int v) {
        this.a = v;
        this.b = z0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((O.w)object0), "$this$LazyRow");
            O.w.b(((O.w)object0), 10, new b(0x8F8D42CA, new y(this.b, 1), true));
            return H.a;
        }
        q.g(((h)object0), "action");
        if(((h)object0) instanceof g) {
            String s = ((g)(((h)object0))).b;
            Navigator.openArtistInfo(s);
            String s1 = ((g)(((h)object0))).c;
            z z0 = this.b;
            f f0 = ((x)z0.getViewModel()).h();
            if(f0 != null) {
                f0.a = i.k(z0, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = i.k(z0, 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                f0.F = i.k(z0, 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                f0.e = s;
                f0.f = i.k(z0, 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                f0.g = s1;
                f0.a().track();
            }
        }
        return H.a;
    }
}

