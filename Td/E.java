package td;

import android.graphics.Point;
import com.melon.ui.playermusic.BgType.SpecialVideo;
import com.melon.ui.playermusic.PlayerViewCalculator;
import com.melon.ui.playermusic.d;
import ie.H;
import kotlin.jvm.internal.q;
import pc.t;
import q8.i;
import r1.l;
import we.k;

public final class e implements k {
    public final int a;
    public final d b;

    public e(d d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((Float)object0).floatValue();
                this.b.l.setValue(((Float)object0));
                return H.a;
            }
            case 1: {
                q.g(((SpecialVideo)object0), "it");
                t t0 = this.b.f;
                if(t0 != null) {
                    b0 b00 = (b0)t0.b;
                    M1 m10 = b00.q();
                    i i0 = new i();
                    i0.b = ((t1)b00.getViewModel()).getCurrentPlayable() == null ? null : "";
                    i0.c = b00.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
                    i0.i = b00.getString(0x7F130D9F);  // string:tiara_click_copy_song_info "곡정보"
                    i0.j = ((SpecialVideo)object0).c;
                    m10.b("1757130088549", i0.build());
                }
                return H.a;
            }
            case 2: {
                q.g(((String)object0), "it");
                t t1 = this.b.f;
                if(t1 != null) {
                    b0 b01 = (b0)t1.b;
                    M1 m11 = b01.q();
                    i i1 = new i();
                    i1.b = ((t1)b01.getViewModel()).getCurrentPlayable() == null ? null : "";
                    i1.c = b01.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
                    i1.i = b01.getString(0x7F130D9F);  // string:tiara_click_copy_song_info "곡정보"
                    i1.j = (String)object0;
                    m11.b("1757130088547", i1.build());
                }
                return H.a;
            }
            case 3: {
                PlayerViewCalculator playerViewCalculator0 = (PlayerViewCalculator)this.b.m.getValue();
                playerViewCalculator0.getClass();
                return playerViewCalculator0.b(new Point(((int)(((l)object0).a >> 0x20)), ((int)(((l)object0).a & 0xFFFFFFFFL))));
            }
            default: {
                return ((PlayerViewCalculator)this.b.m.getValue()).a(((int)(((Integer)object0))));
            }
        }
    }
}

