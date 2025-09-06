package td;

import Cb.i;
import Ic.c0;
import Ic.o;
import Ic.z;
import android.graphics.Point;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.l1;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.C3;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.playermusic.PlayerMoreView;
import com.melon.ui.playermusic.PlayerViewCalculator;
import com.melon.ui.popup.b;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.q;
import p8.f;
import va.o1;
import va.t1;
import wc.w;
import wc.x;
import we.a;
import xc.E;
import xc.d;
import xc.k;
import xc.s;

public final class z1 implements a {
    public final int a;
    public final Object b;
    public final Object c;

    public z1(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        int v = 0;
        H h0 = H.a;
        Object object0 = this.c;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                ((PlayerMoreView)object1).post(new A1(((PlayerMoreView)object1), 0));
                ((a)object0).invoke();
                return h0;
            }
            case 1: {
                int v1 = ScreenUtils.dipToPixel(((PlayerViewCalculator)object1).a, 24.0f);
                int v2 = ((PlayerViewCalculator)object1).c();
                int v3 = ((PlayerViewCalculator)object1).a.getResources().getDimensionPixelSize(0x7F07040E);  // dimen:player_like_mixup_container_height
                int v4 = ((PlayerViewCalculator)object1).a.getResources().getDimensionPixelSize(0x7F07040A);  // dimen:player_bottom_fixed_area_height
                int v5 = Math.min(((Point)object0).x - v1 * 2, ((int)(((float)(((Point)object0).y - v2 - v3 - v4)) * 0.83f)));
                if(v5 >= ScreenUtils.dipToPixel(((PlayerViewCalculator)object1).a, 160.0f)) {
                    v = v5;
                }
                LogU.Companion.d("PlayerViewCalculator", "screenSize:" + ((Point)object0) + ", topFixedHeight:" + v2 + ", bottomFixedHeight:" + v4 + ", albumSize:" + v);
                return v;
            }
            case 2: {
                ((t1)object1).b.removeOnAccountsUpdatedListener(((o1)object0));
                LogU.debug$default(((t1)object1).c, "getAllAccountsUserIdFlow() closed", null, false, 6, null);
                return h0;
            }
            case 3: {
                return new Jd.a(((StringProviderImpl)object1), new L(1, ((w)object0), w.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 27), ((w)object0).getTiaraProperty());
            }
            case 4: {
                ((w)object1).onUserEvent(new c0(((Playable)object0)));
                return h0;
            }
            case 5: {
                ((k)object1).getClass();
                if(((List)object0).size() > 1) {
                    l0 l00 = ((k)object1).getChildFragmentManager();
                    String s = i.k(((k)object1), 0x7F130111);  // string:artist_channel_popup_artist_list_title "아티스트 선택"
                    ArrayList arrayList0 = new ArrayList(q.Q(10, ((List)object0)));
                    for(Object object2: ((List)object0)) {
                        arrayList0.add(new m(((o)object2).a, ((o)object2).b));
                    }
                    b.e(l00, s, arrayList0, 1, null, new d(((k)object1), 0));
                    return h0;
                }
                if(((List)object0).size() == 1) {
                    Navigator.openArtistInfo(((o)p.k0(((List)object0))).a);
                    o o0 = (o)p.k0(((List)object0));
                    String s1 = o0.a;
                    String s2 = o0.b;
                    f f1 = ((x)((k)object1).getViewModel()).h();
                    if(f1 != null) {
                        f1.a = i.k(((k)object1), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f1.d = ActionKind.ClickContent;
                        f1.y = i.k(((k)object1), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f1.F = i.k(((k)object1), 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                        f1.e = s1;
                        f1.f = i.k(((k)object1), 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                        f1.g = s2;
                        f1.a().track();
                    }
                }
                return h0;
            }
            case 6: {
                if(((Hc.x)object1) != null) {
                    ((k)object0).sendUserEvent(new Jc.a(((Hc.x)object1).d, ((Hc.x)object1).e));
                }
                return h0;
            }
            case 7: {
                Playable playable1 = (Playable)((z)object1).a.E.invoke();
                if(playable1 != null) {
                    ((k)object0).getClass();
                    kotlin.jvm.internal.q.f("", "getAlbumid(...)");
                    kotlin.jvm.internal.q.f("", "getAlbum(...)");
                    ((k)object0).sendUserEvent(new C3(new vb.a("", "", "", l1.n("", "getIssueDate(...)", playable1, "getArtistNames(...)"))));
                    f f2 = ((x)((k)object0).getViewModel()).h();
                    if(f2 != null) {
                        f2.a = i.k(((k)object0), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f2.d = ActionKind.Share;
                        f2.y = i.k(((k)object0), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f2.F = i.k(((k)object0), 0x7F130E27);  // string:tiara_common_layer2_doing_share "공유하기"
                        f2.a().track();
                    }
                }
                return h0;
            }
            case 8: {
                if(((List)object0).size() > 1) {
                    l0 l01 = ((s)object1).getChildFragmentManager();
                    String s3 = i.k(((s)object1), 0x7F130111);  // string:artist_channel_popup_artist_list_title "아티스트 선택"
                    ArrayList arrayList1 = new ArrayList(q.Q(10, ((List)object0)));
                    for(Object object3: ((List)object0)) {
                        arrayList1.add(new m(((o)object3).a, ((o)object3).b));
                    }
                    b.e(l01, s3, arrayList1, 1, null, new xc.o(((s)object1), 0));
                    return h0;
                }
                if(((List)object0).size() == 1) {
                    Navigator.openArtistInfo(((o)p.k0(((List)object0))).a);
                    o o1 = (o)p.k0(((List)object0));
                    String s4 = o1.a;
                    String s5 = o1.b;
                    f f3 = ((x)((s)object1).getViewModel()).h();
                    if(f3 != null) {
                        f3.a = i.k(((s)object1), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f3.d = ActionKind.ClickContent;
                        f3.y = i.k(((s)object1), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f3.F = i.k(((s)object1), 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                        f3.e = s4;
                        f3.f = i.k(((s)object1), 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                        f3.g = s5;
                        f3.a().track();
                    }
                }
                return h0;
            }
            case 9: {
                if(((Hc.x)object1) != null) {
                    ((s)object0).sendUserEvent(new Jc.a(((Hc.x)object1).d, ((Hc.x)object1).e));
                }
                return h0;
            }
            case 10: {
                Playable playable2 = (Playable)((z)object1).a.E.invoke();
                if(playable2 != null) {
                    kotlin.jvm.internal.q.f("", "getAlbumid(...)");
                    kotlin.jvm.internal.q.f("", "getAlbum(...)");
                    ((s)object0).sendUserEvent(new C3(new vb.a("", "", "", l1.n("", "getIssueDate(...)", playable2, "getArtistNames(...)"))));
                    f f4 = ((x)((s)object0).getViewModel()).h();
                    if(f4 != null) {
                        f4.a = i.k(((s)object0), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f4.d = ActionKind.Share;
                        f4.y = i.k(((s)object0), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f4.F = i.k(((s)object0), 0x7F130E27);  // string:tiara_common_layer2_doing_share "공유하기"
                        f4.a().track();
                    }
                }
                return h0;
            }
            case 11: {
                ((xc.z)object1).getClass();
                if(((List)object0).size() > 1) {
                    l0 l02 = ((xc.z)object1).getChildFragmentManager();
                    String s6 = i.k(((xc.z)object1), 0x7F130111);  // string:artist_channel_popup_artist_list_title "아티스트 선택"
                    ArrayList arrayList2 = new ArrayList(q.Q(10, ((List)object0)));
                    for(Object object4: ((List)object0)) {
                        arrayList2.add(new m(((o)object4).a, ((o)object4).b));
                    }
                    b.e(l02, s6, arrayList2, 1, null, new xc.w(((xc.z)object1), 0));
                    return h0;
                }
                if(((List)object0).size() == 1) {
                    Navigator.openArtistInfo(((o)p.k0(((List)object0))).a);
                    o o2 = (o)p.k0(((List)object0));
                    String s7 = o2.a;
                    String s8 = o2.b;
                    f f5 = ((x)((xc.z)object1).getViewModel()).h();
                    if(f5 != null) {
                        f5.a = i.k(((xc.z)object1), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f5.d = ActionKind.ClickContent;
                        f5.y = i.k(((xc.z)object1), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f5.F = i.k(((xc.z)object1), 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                        f5.e = s7;
                        f5.f = i.k(((xc.z)object1), 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                        f5.g = s8;
                        f5.a().track();
                    }
                }
                return h0;
            }
            case 12: {
                if(((Hc.x)object1) != null) {
                    ((xc.z)object0).sendUserEvent(new Jc.a(((Hc.x)object1).d, ((Hc.x)object1).e));
                }
                return h0;
            }
            case 13: {
                Playable playable3 = (Playable)((z)object1).a.E.invoke();
                if(playable3 != null) {
                    ((xc.z)object0).getClass();
                    kotlin.jvm.internal.q.f("", "getAlbumid(...)");
                    kotlin.jvm.internal.q.f("", "getAlbum(...)");
                    ((xc.z)object0).sendUserEvent(new C3(new vb.a("", "", "", l1.n("", "getIssueDate(...)", playable3, "getArtistNames(...)"))));
                    f f6 = ((x)((xc.z)object0).getViewModel()).h();
                    if(f6 != null) {
                        f6.a = i.k(((xc.z)object0), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f6.d = ActionKind.Share;
                        f6.y = i.k(((xc.z)object0), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f6.F = i.k(((xc.z)object0), 0x7F130E27);  // string:tiara_common_layer2_doing_share "공유하기"
                        f6.a().track();
                    }
                }
                return h0;
            }
            case 14: {
                ((xc.H)object1).getClass();
                if(((List)object0).size() > 1) {
                    l0 l03 = ((xc.H)object1).getChildFragmentManager();
                    String s9 = i.k(((xc.H)object1), 0x7F130111);  // string:artist_channel_popup_artist_list_title "아티스트 선택"
                    ArrayList arrayList3 = new ArrayList(q.Q(10, ((List)object0)));
                    for(Object object5: ((List)object0)) {
                        arrayList3.add(new m(((o)object5).a, ((o)object5).b));
                    }
                    b.e(l03, s9, arrayList3, 1, null, new E(((xc.H)object1), 0));
                    return h0;
                }
                if(((List)object0).size() == 1) {
                    Navigator.openArtistInfo(((o)p.k0(((List)object0))).a);
                    o o3 = (o)p.k0(((List)object0));
                    String s10 = o3.a;
                    String s11 = o3.b;
                    f f7 = ((x)((xc.H)object1).getViewModel()).h();
                    if(f7 != null) {
                        f7.a = i.k(((xc.H)object1), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f7.d = ActionKind.ClickContent;
                        f7.y = i.k(((xc.H)object1), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f7.F = i.k(((xc.H)object1), 0x7F130D20);  // string:tiara_click_copy_detail_info "상세정보"
                        f7.e = s10;
                        f7.f = i.k(((xc.H)object1), 0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                        f7.g = s11;
                        f7.a().track();
                    }
                }
                return h0;
            }
            case 15: {
                if(((Hc.x)object1) != null) {
                    ((xc.H)object0).sendUserEvent(new Jc.a(((Hc.x)object1).d, ((Hc.x)object1).e));
                }
                return h0;
            }
            default: {
                Playable playable0 = (Playable)((z)object1).a.E.invoke();
                if(playable0 != null) {
                    ((xc.H)object0).getClass();
                    kotlin.jvm.internal.q.f("", "getAlbumid(...)");
                    kotlin.jvm.internal.q.f("", "getAlbum(...)");
                    ((xc.H)object0).sendUserEvent(new C3(new vb.a("", "", "", l1.n("", "getIssueDate(...)", playable0, "getArtistNames(...)"))));
                    f f0 = ((x)((xc.H)object0).getViewModel()).h();
                    if(f0 != null) {
                        f0.a = i.k(((xc.H)object0), 0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.d = ActionKind.Share;
                        f0.y = i.k(((xc.H)object0), 0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                        f0.F = i.k(((xc.H)object0), 0x7F130E27);  // string:tiara_common_layer2_doing_share "공유하기"
                        f0.a().track();
                    }
                }
                return h0;
            }
        }
    }
}

