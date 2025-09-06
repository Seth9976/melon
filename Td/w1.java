package td;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.melon.ui.E1;
import com.melon.ui.I1;
import com.melon.ui.M1;
import com.melon.ui.U1;
import com.melon.ui.c2;
import com.melon.ui.d2;
import com.melon.ui.g2;
import com.melon.ui.playermusic.PlayerMoreView;
import kotlin.jvm.internal.q;
import vb.t;

public final class w1 implements View.OnClickListener {
    public final int a;
    public final PlayerMoreView b;

    public w1(PlayerMoreView playerMoreView0, int v) {
        this.a = v;
        this.b = playerMoreView0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PlayerMoreView playerMoreView1 = this.b;
                Playable playable1 = playerMoreView1.N;
                if(playable1 != null) {
                    F1 f11 = playerMoreView1.M;
                    if(f11 != null) {
                        ((M)f11).onEvent(new d2(playable1));
                    }
                }
                return;
            }
            case 1: {
                PlayerMoreView playerMoreView2 = this.b;
                Playable playable2 = playerMoreView2.N;
                if(playable2 != null) {
                    F1 f12 = playerMoreView2.M;
                    if(f12 != null) {
                        q.f("", "getSongidString(...)");
                        q.f("", "getSongName(...)");
                        ((M)f12).onEvent(new M1("", "", playable2.getArtistid(), playerMoreView2.B));
                    }
                }
                return;
            }
            case 2: {
                PlayerMoreView playerMoreView3 = this.b;
                F1 f13 = playerMoreView3.M;
                if(f13 != null) {
                    ((M)f13).onEvent(new g2(playerMoreView3.N));
                }
                return;
            }
            case 3: {
                PlayerMoreView playerMoreView4 = this.b;
                Playable playable3 = playerMoreView4.N;
                if(playable3 != null) {
                    F1 f14 = playerMoreView4.M;
                    if(f14 != null) {
                        ((M)f14).onEvent(new U1(playable3, playerMoreView4.B));
                    }
                }
                return;
            }
            case 4: {
                PlayerMoreView playerMoreView5 = this.b;
                Playable playable4 = playerMoreView5.N;
                if(playable4 != null) {
                    F1 f15 = playerMoreView5.M;
                    if(f15 != null) {
                        ((M)f15).onEvent(new E1(playable4));
                    }
                }
                return;
            }
            case 5: {
                PlayerMoreView playerMoreView6 = this.b;
                Playable playable5 = playerMoreView6.N;
                if(playable5 != null) {
                    F1 f16 = playerMoreView6.M;
                    if(f16 != null) {
                        ((M)f16).onEvent(new I1(playable5, playable5.isLiked()));
                    }
                }
                return;
            }
            default: {
                PlayerMoreView playerMoreView0 = this.b;
                Playable playable0 = playerMoreView0.N;
                if(playable0 != null) {
                    F1 f10 = playerMoreView0.M;
                    if(f10 != null) {
                        q.f("", "getContentId(...)");
                        q.f("", "getSongName(...)");
                        ((M)f10).onEvent(new c2(new t("", "", "", l1.n("", "getAlbumid(...)", playable0, "getArtistNames(...)"))));
                    }
                }
            }
        }
    }
}

