package xc;

import Cb.i;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import p8.f;
import we.o;

public final class x implements o {
    public final int a;
    public final z b;

    public x(z z0, int v) {
        this.a = v;
        this.b = z0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            q.g(((Playable)object2), "<unused var>");
            z z0 = this.b;
            f f0 = ((wc.x)z0.getViewModel()).h();
            if(f0 != null) {
                f0.a = i.k(z0, 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.d = ActionKind.ClickContent;
                f0.y = i.k(z0, 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                f0.F = i.k(z0, 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                f0.e = (String)object0;
                f0.f = i.k(z0, 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                f0.g = (String)object1;
                f0.a().track();
            }
            return H.a;
        }
        int v = (int)(((Integer)object2));
        q.g(((a)object0), "$this$item");
        if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
            this.b.r(((p)(((l)object1))), 0);
            return H.a;
        }
        ((p)(((l)object1))).T();
        return H.a;
    }
}

