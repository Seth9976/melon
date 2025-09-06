package sd;

import P0.d0;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import d5.t;
import kc.d3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import oc.H;
import oc.w;
import od.b;
import pc.Z;
import q8.d;
import q8.h;
import we.a;

public final class x implements a {
    public final int a;
    public final P b;

    public x(P p0, int v) {
        this.a = v;
        this.b = p0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return new b(new x(this.b, 4));
            }
            case 1: {
                return ((b)this.b.k.getValue()).c();
            }
            case 2: {
                P p0 = this.b;
                d0 d00 = p0.l;
                if(d00.f()) {
                    if(((H)((x)d00.d).invoke()) instanceof rc.a) {
                        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
                        d0.i(d00, d0, ActionKind.ClickContent);
                        ((h)d0.b).a = d00.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d0.b(new p(d00, 2));
                        ((Event)d0.p()).track();
                    }
                    else {
                        d d1 = new d();  // 初始化器: LQb/h;-><init>()V
                        d0.i(d00, d1, ActionKind.ClickContent);
                        ((h)d1.b).a = d00.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d1.b(new p(d00, 5));
                        ((Event)d1.p()).track();
                    }
                }
                w w0 = ((d3)p0.b).k();
                if(w0 != null) {
                    PlaylistId playlistId0 = w0.getId();
                    if(playlistId0 == PlaylistId.MUSIC_WAVE) {
                        Navigator.INSTANCE.openMusicWavePlayer();
                        return ie.H.a;
                    }
                    if(playlistId0 == PlaylistId.STATION) {
                        Navigator.INSTANCE.openStationPlayer();
                        return ie.H.a;
                    }
                    if(w0 instanceof pc.d) {
                        if(e1.b.D(((Z)(((pc.d)w0))).m())) {
                            Navigator.INSTANCE.openNowPlayList();
                            return ie.H.a;
                        }
                        if(t.k(((pc.d)w0))) {
                            Navigator.openDjMalrangPlayer$default(Navigator.INSTANCE, 0, 1, null);
                            return ie.H.a;
                        }
                        Navigator.openMusicPlayer$default(Navigator.INSTANCE, 0, 1, null);
                        return ie.H.a;
                    }
                    if(e1.b.D(w0.getState())) {
                        Navigator.INSTANCE.openNowPlayList();
                        return ie.H.a;
                    }
                    Navigator.openMusicPlayer$default(Navigator.INSTANCE, 0, 1, null);
                }
                return ie.H.a;
            }
            case 3: {
                P p1 = this.b;
                d0 d01 = p1.l;
                if(d01.f()) {
                    d d2 = new d();  // 初始化器: LQb/h;-><init>()V
                    d0.i(d01, d2, ActionKind.ClickContent);
                    ((h)d2.b).a = d01.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    d2.b(new p(d01, 10));
                    ((Event)d2.p()).track();
                }
                O o0 = new O(p1, null);
                BuildersKt__Builders_commonKt.launch$default(p1.g, null, null, o0, 3, null);
                return ie.H.a;
            }
            case 4: {
                return this.b.b();
            }
            case 5: {
                P p2 = this.b;
                d0 d02 = p2.l;
                if(d02.f()) {
                    d d3 = new d();  // 初始化器: LQb/h;-><init>()V
                    d0.i(d02, d3, ActionKind.ClickContent);
                    ((h)d3.b).a = d02.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    d3.b(new p(d02, 8));
                    ((Event)d3.p()).track();
                }
                L l0 = new L(p2, null);
                BuildersKt__Builders_commonKt.launch$default(p2.g, null, null, l0, 3, null);
                return ie.H.a;
            }
            case 6: {
                N n0 = new N(this.b, null);
                BuildersKt__Builders_commonKt.launch$default(this.b.g, null, null, n0, 3, null);
                return ie.H.a;
            }
            case 7: {
                d0 d03 = this.b.l;
                if(d03.f()) {
                    d d4 = new d();  // 初始化器: LQb/h;-><init>()V
                    d0.i(d03, d4, ActionKind.ClickContent);
                    ((h)d4.b).a = d03.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    d4.b(new p(d03, 4));
                    ((Event)d4.p()).track();
                }
                Navigator.INSTANCE.openNowPlayList();
                return ie.H.a;
            }
            case 8: {
                P p3 = this.b;
                d0 d04 = p3.l;
                if(d04.f() && ((H)((x)d04.d).invoke()) instanceof rc.a) {
                    d d5 = new d();  // 初始化器: LQb/h;-><init>()V
                    d0.i(d04, d5, ActionKind.ClickContent);
                    ((h)d5.b).a = d04.d(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    d5.b(new p(d04, 7));
                    ((Event)d5.p()).track();
                }
                p3.e.s();
                ((d3)p3.b).b();
                return ie.H.a;
            }
            case 9: {
                return ((d3)this.b.b).f();
            }
            default: {
                return ((d3)this.b.b).k();
            }
        }
    }
}

