package Dd;

import A9.a;
import Ac.A2;
import Ac.C1;
import Ac.E1;
import Ac.g2;
import Ac.m2;
import Ac.w1;
import Ac.x1;
import Cb.i;
import Cd.t;
import E9.h;
import Md.f;
import Md.l;
import Pc.e;
import Ua.N;
import Za.b;
import androidx.lifecycle.f0;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.fragments.friend.FriendPagerFragment;
import com.iloen.melon.fragments.friend.OtherFriendPagerFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageListFragment;
import com.iloen.melon.fragments.mymusic.MemberProfileEditFragment;
import com.iloen.melon.fragments.mymusic.MyMusicTabFragment;
import com.iloen.melon.fragments.mymusic.PlaylistFragment.Companion;
import com.iloen.melon.fragments.mymusic.PlaylistFragment;
import com.iloen.melon.fragments.present.PresentSongSendFragment;
import com.iloen.melon.fragments.present.PresentTabFragment;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.DjReport;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.LIKEINFO.LIKESONGIMGLIST;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.LIKEINFO.PLYLSTINFO;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.LIKEINFO;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.MYPROFILE.DJPICKPLAYLIST;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.MYPROFILE.FANLOUNGEINFO;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.MYPROFILE;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.PLAYLIST;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE.POWERDJINDICATOR;
import com.iloen.melon.net.v6x.response.MyMusicInformProfileRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ProfileBaseRes.CASTLIST.SUBCONTENTLIST;
import com.iloen.melon.net.v6x.response.ProfileBaseRes.SnsInfoBase;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.ui.I3;
import com.melon.ui.K4;
import com.melon.ui.Q;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.c3;
import com.melon.ui.d1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.m;
import com.melon.ui.n4;
import com.melon.ui.o;
import com.melon.ui.q4;
import com.melon.ui.s4;
import d5.n;
import e1.u;
import ea.d;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import oe.c;
import va.e0;
import vb.g;
import zd.v0;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u000E\u0003\u0004\u0005\u0006\u0007\b\t\n\n\n\u000B\n\n\f¨\u0006\r"}, d2 = {"LDd/g1;", "LDd/h2;", "", "Dd/R0", "Dd/k0", "Dd/l0", "Dd/Q0", "Dd/j0", "Dd/P0", "Dd/O0", "Ac/p0", "Dd/N0", "Dd/M0", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class g1 extends h2 {
    public final g2 k;
    public final d l;
    public final b m;
    public final Q n;
    public final StringProviderImpl o;
    public final k p;
    public final LogU q;
    public POWERDJINDICATOR r;
    public boolean s;
    public static final int t;

    public g1(d d0, b b0, Q q0, n4 n40, StringProviderImpl stringProviderImpl0, k k0, N n0) {
        q.g(k0, "loginUseCase");
        super(q0, n40, stringProviderImpl0, k0);
        this.k = new g2(n0);
        this.l = d0;
        this.m = b0;
        this.n = q0;
        this.o = stringProviderImpl0;
        this.p = k0;
        LogU logU0 = new LogU("MemberProfileViewModel");
        logU0.setCategory(Category.UI);
        this.q = logU0;
    }

    @Override  // com.melon.ui.k1
    public final f cacheServiceType() {
        return f.g;
    }

    public static P1 l(g1 g10, C c0, C c1, d1 d10) {
        String s28;
        String s26;
        ArrayList arrayList5;
        List list1;
        List list0;
        ArrayList arrayList1;
        FANLOUNGEINFO myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0;
        String s2;
        q.g(d10, "fetchResult");
        if(d10 instanceof Z0) {
            c3 c30 = ((Z0)d10).a;
            if(c30.d instanceof CancellationException) {
                LogU.debug$default(g10.q, "fetchResult.errorUiState.exception is CancellationException", null, false, 6, null);
                return null;
            }
            return new M1(c30);
        }
        if(d10 instanceof b1) {
            return new N1(((b1)d10).a);
        }
        if(d10 instanceof c1) {
            c0.a = true;
            RESPONSE myMusicInformProfileRes$RESPONSE0 = (RESPONSE)((c1)d10).a;
            MYPROFILE myMusicInformProfileRes$RESPONSE$MYPROFILE0 = myMusicInformProfileRes$RESPONSE0.myProfile;
            String s = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.memberNickName;
            if(s == null) {
                s = "";
            }
            StringProviderImpl stringProviderImpl0 = g10.o;
            g10.g = s;
            g10.h = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? false : myMusicInformProfileRes$RESPONSE$MYPROFILE0.isDj;
            g10.i = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? false : myMusicInformProfileRes$RESPONSE$MYPROFILE0.isPowerDj;
            boolean z = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? false : myMusicInformProfileRes$RESPONSE$MYPROFILE0.isArtistUser;
            String s1 = "N";
            if(myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null) {
                s2 = "N";
            }
            else {
                s2 = myMusicInformProfileRes$RESPONSE$MYPROFILE0.artistChnFlag;
                if(s2 == null) {
                    s2 = "N";
                }
            }
            boolean z1 = g10.f && z || !g10.f && s2.equals("Y");
            if(!ProtocolUtils.parseBoolean((myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.fanLoungeOpenFlag)) || !i.l((myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.fanLoungeInfo))) {
                myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0 = null;
            }
            else {
                myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.fanLoungeInfo;
            }
            c1.a = ProtocolUtils.parseBoolean((myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.djCmtOpenFlag));
            ArrayList arrayList0 = new ArrayList();
            boolean z2 = g10.f;
            boolean z3 = myMusicInformProfileRes$RESPONSE0.isMyFriend && !q.b(g10.e, u.v(((e0)g10.p).j()));
            String s3 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.followerCnt;
            String s4 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.followingCnt;
            String s5 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.plylstCnt;
            String s6 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.artistId;
            String s7 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.memberDjIconType;
            String s8 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.djTitle;
            arrayList0.add(new V1(z2, z3, ProtocolUtils.parseBoolean((myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.msgRecvFlag)), g10.h, g10.i, (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.myPageImg), (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.myPageImgOrg), (s3 == null ? "" : s3), (s4 == null ? "" : s4), null, (s5 == null ? "" : s5), (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.memberNickName), (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? false : myMusicInformProfileRes$RESPONSE$MYPROFILE0.isOfficial), (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.myPageDesc), z1, (s6 == null ? "" : s6), myMusicInformProfileRes$RESPONSE0.djReport, (s7 == null ? "" : s7), (s8 == null ? "" : s8), (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? false : myMusicInformProfileRes$RESPONSE$MYPROFILE0.isUnderFourTeenMember), myMusicInformProfileRes$RESPONSE$MYPROFILE$FANLOUNGEINFO0, c1.a, (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.snsInfo), (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.postImg), (myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.postEditImg), 0x200));
            g10.r = myMusicInformProfileRes$RESPONSE0.powerDjIndicator;
            if(g10.f && g10.h && i.l(myMusicInformProfileRes$RESPONSE0.powerDjIndicator)) {
                POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0 = g10.r;
                q.d(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0);
                if(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0.isSlotDisp) {
                    POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR1 = g10.r;
                    q.d(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR1);
                    int v = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR1.isBlackList ? 1209600000 : 604800000;
                    long v1 = MelonPrefs.getInstance().getLong("powerDjApplySlotClosedTime", -1L);
                    if(v1 < 0L || System.currentTimeMillis() > ((long)v) + v1) {
                        POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR2 = g10.r;
                        q.d(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR2);
                        String s9 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR2.totalRate;
                        q.f(s9, "totalRate");
                        POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR3 = g10.r;
                        q.d(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR3);
                        String s10 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR3.applyStatusMessage;
                        q.f(s10, "applyStatusMessage");
                        POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR4 = g10.r;
                        q.d(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR4);
                        String s11 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR4.linkType;
                        q.f(s11, "linkType");
                        POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR5 = g10.r;
                        q.d(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR5);
                        String s12 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR5.linkUrl;
                        q.f(s12, "linkUrl");
                        arrayList0.add(new P0(s9, s10, s11, s12));
                    }
                }
            }
            String s13 = g10.r == null ? null : g10.r.approvePopMessage;
            if(s13 != null && s13.length() != 0 && !MelonPrefs.getInstance().getBoolean("powerDjPassPopupShown", false) && !g10.s) {
                g10.sendUiEvent(new q4(12, stringProviderImpl0.a(0x7F1300D0), s13, null, new a(13)));  // string:alert_dlg_title_info "안내"
                g10.s = true;
            }
            if(g10.h && ProtocolUtils.parseBoolean((myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.djPickFlag))) {
                DJPICKPLAYLIST myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0 = myMusicInformProfileRes$RESPONSE$MYPROFILE0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE0.djPickPlaylist;
                String s14 = myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0.plylstseq;
                String s15 = myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0.plylsttitle;
                String s16 = myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0.contsTypeCode;
                String s17 = myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0.thumbimg;
                String s18 = myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0.plylsttitle;
                arrayList0.add(new j0((s14 == null ? "" : s14), (s15 == null ? "" : s15), (s16 == null ? "" : s16), (s17 == null ? "" : s17), (s18 == null ? "" : s18), (myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0 == null ? null : myMusicInformProfileRes$RESPONSE$MYPROFILE$DJPICKPLAYLIST0.statsElements)));
            }
            if(g10.h) {
                PLAYLIST myMusicInformProfileRes$RESPONSE$PLAYLIST0 = myMusicInformProfileRes$RESPONSE0.playlist;
                if(myMusicInformProfileRes$RESPONSE$PLAYLIST0 == null) {
                    list0 = null;
                }
                else {
                    arrayList1 = myMusicInformProfileRes$RESPONSE$PLAYLIST0.djPlaylistList;
                    list0 = arrayList1 == null ? null : p.K0(6, arrayList1);
                }
            }
            else {
                PLAYLIST myMusicInformProfileRes$RESPONSE$PLAYLIST1 = myMusicInformProfileRes$RESPONSE0.playlist;
                if(myMusicInformProfileRes$RESPONSE$PLAYLIST1 == null) {
                    list0 = null;
                }
                else {
                    arrayList1 = myMusicInformProfileRes$RESPONSE$PLAYLIST1.playlistList;
                    list0 = arrayList1 == null ? null : p.K0(6, arrayList1);
                }
            }
            if(g10.f || list0 != null && !list0.isEmpty()) {
                boolean z4 = g10.h;
                arrayList0.add(new d2(stringProviderImpl0.a(0x7F130CAE), "TITLE_TYPE_PLAYLIST", z4, ((boolean)((list0 == null || list0.isEmpty() ? 1 : 0) ^ 1))));  // string:text_playlist "플레이리스트"
                boolean z5 = g10.h;
                q.d(list0);
                arrayList0.add(new W1(z5, list0));
            }
            if(g10.i) {
                PLAYLIST myMusicInformProfileRes$RESPONSE$PLAYLIST2 = myMusicInformProfileRes$RESPONSE0.playlist;
                if(myMusicInformProfileRes$RESPONSE$PLAYLIST2 == null) {
                    list1 = null;
                }
                else {
                    ArrayList arrayList2 = myMusicInformProfileRes$RESPONSE$PLAYLIST2.seriesPlaylistList;
                    list1 = arrayList2 == null ? null : p.K0(4, arrayList2);
                }
                if(list1 != null && !list1.isEmpty()) {
                    arrayList0.add(new d2(stringProviderImpl0.a(0x7F130CB5), "TITLE_TYPE_SERIES_PLAYLIST", false, true));  // string:text_series_playlist "시리즈 플레이리스트"
                    arrayList0.add(new Q0(list1));
                }
            }
            if(myMusicInformProfileRes$RESPONSE$MYPROFILE0 != null) {
                String s19 = myMusicInformProfileRes$RESPONSE$MYPROFILE0.likeOpenFlag;
                if(s19 != null) {
                    s1 = s19;
                }
            }
            if(ProtocolUtils.parseBoolean(s1)) {
                LIKEINFO myMusicInformProfileRes$RESPONSE$LIKEINFO0 = myMusicInformProfileRes$RESPONSE0.likeInfo;
                String s20 = myMusicInformProfileRes$RESPONSE$LIKEINFO0 == null ? null : myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeSongName;
                boolean z6 = s20 != null && s20.length() != 0 && myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeSongCnt > 0;
                String s21 = myMusicInformProfileRes$RESPONSE$LIKEINFO0 == null ? null : myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeAlbumName;
                boolean z7 = s21 != null && s21.length() != 0 && myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeAlbumCnt > 0;
                String s22 = myMusicInformProfileRes$RESPONSE$LIKEINFO0 == null ? null : myMusicInformProfileRes$RESPONSE$LIKEINFO0.likePlylstName;
                boolean z8 = s22 != null && s22.length() != 0 && myMusicInformProfileRes$RESPONSE$LIKEINFO0.likePlylstCnt > 0;
                if(g10.f || myMusicInformProfileRes$RESPONSE$LIKEINFO0 != null && (myMusicInformProfileRes$RESPONSE$LIKEINFO0.guideText == null || myMusicInformProfileRes$RESPONSE$LIKEINFO0.guideText.length() == 0)) {
                    arrayList0.add(new d2(stringProviderImpl0.a(0x7F13089D), "TITLE_TYPE_LIKE", false, true));  // string:profile_liked "좋아요"
                    if(myMusicInformProfileRes$RESPONSE$LIKEINFO0 != null && (z6 || z7 || z8)) {
                        String s23 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeSongName == null ? "" : myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeSongName;
                        int v2 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeSongCnt;
                        ArrayList arrayList3 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeSongImgList;
                        if(arrayList3 == null) {
                            arrayList5 = null;
                        }
                        else {
                            ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList3));
                            for(Object object0: arrayList3) {
                                String s24 = ((LIKESONGIMGLIST)object0).albumImg;
                                if(s24 == null) {
                                    s24 = "";
                                }
                                arrayList4.add(s24);
                            }
                            arrayList5 = arrayList4;
                        }
                        String s25 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeAlbumName == null ? "" : myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeAlbumName;
                        int v3 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.likeAlbumCnt;
                        ArrayList arrayList6 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.albumInfo;
                        if(arrayList6 == null) {
                            s26 = null;
                        }
                        else {
                            AlbumInfoBase albumInfoBase0 = (AlbumInfoBase)p.m0(arrayList6);
                            s26 = albumInfoBase0 == null ? null : albumInfoBase0.albumImg;
                        }
                        String s27 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.likePlylstName == null ? "" : myMusicInformProfileRes$RESPONSE$LIKEINFO0.likePlylstName;
                        int v4 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.likePlylstCnt;
                        ArrayList arrayList7 = myMusicInformProfileRes$RESPONSE$LIKEINFO0.plylstInfo;
                        if(arrayList7 == null) {
                            s28 = null;
                        }
                        else {
                            PLYLSTINFO myMusicInformProfileRes$RESPONSE$LIKEINFO$PLYLSTINFO0 = (PLYLSTINFO)p.m0(arrayList7);
                            s28 = myMusicInformProfileRes$RESPONSE$LIKEINFO$PLYLSTINFO0 == null ? null : myMusicInformProfileRes$RESPONSE$LIKEINFO$PLYLSTINFO0.thumbimg;
                        }
                        arrayList0.add(new l0(z6, z7, z8, s23, v2, arrayList5, s25, v3, (s26 == null ? "" : s26), s27, v4, (s28 == null ? "" : s28)));
                    }
                    else {
                        arrayList0.add(k0.a);
                    }
                }
            }
            ArrayList arrayList8 = myMusicInformProfileRes$RESPONSE0.castList == null ? null : myMusicInformProfileRes$RESPONSE0.castList.subContentList;
            if(arrayList8 != null && !arrayList8.isEmpty()) {
                String s29 = myMusicInformProfileRes$RESPONSE0.castList == null ? null : myMusicInformProfileRes$RESPONSE0.castList.subContentTitle;
                if(s29 == null) {
                    s29 = "";
                }
                arrayList0.add(new d2(s29, "TITLE_TYPE_STATION", false, true));
                int v5 = 0;
                for(Object object1: arrayList8) {
                    if(v5 >= 0) {
                        String s30 = ((SUBCONTENTLIST)object1).castSeq;
                        String s31 = ((SUBCONTENTLIST)object1).imgUrl;
                        String s32 = ((SUBCONTENTLIST)object1).progTitle;
                        String s33 = ((SUBCONTENTLIST)object1).castTitle;
                        String s34 = ((SUBCONTENTLIST)object1).dispStartDate;
                        arrayList0.add(new c2(v5, (s30 == null ? "" : s30), (s31 == null ? "" : s31), (s32 == null ? "" : s32), (s33 == null ? "" : s33), (s34 == null ? "" : s34)));
                        ++v5;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
            }
            POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR6 = g10.r;
            if(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR6 != null && g10.f && g10.h && !q.b(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR6.applyStatus, "M32002")) {
                String s35 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR6.bottomMessage;
                q.f(s35, "bottomMessage");
                String s36 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR6.linkType;
                q.f(s36, "linkType");
                String s37 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR6.linkUrl;
                q.f(s37, "linkUrl");
                arrayList0.add(new O0(s35, s36, s37));
            }
            ArrayList arrayList9 = new ArrayList();
            for(Object object2: arrayList0) {
                if(!(((K4)object2) instanceof V1)) {
                    arrayList9.add(object2);
                }
            }
            if(arrayList9.size() == 0 && !g1.m(c0, g10, c1)) {
                arrayList0.add(U1.a);
                return new O1(arrayList0);
            }
            arrayList0.add(T1.a);
            return new O1(arrayList0);
        }
        if(!(d10 instanceof a1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return null;
    }

    // 去混淆评级： 低(30)
    public static final boolean m(C c0, g1 g10, C c1) {
        return c0.a && g10.h && c1.a;
    }

    public final Object n(boolean z, boolean z1, c c0) {
        return this.k.j(true, true, c0);
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(com.melon.ui.g1 g10, Continuation continuation0) {
        L0 l00;
        String s;
        C c2;
        int v5;
        String s2;
        L0 l02;
        int v4;
        C c1;
        L0 l01;
        String s1;
        int v8;
        C c4;
        C c3;
        X0 x00;
        if(continuation0 instanceof X0) {
            x00 = (X0)continuation0;
            int v = x00.N;
            if((v & 0x80000000) == 0) {
                x00 = new X0(this, ((c)continuation0));
            }
            else {
                x00.N = v ^ 0x80000000;
            }
        }
        else {
            x00 = new X0(this, ((c)continuation0));
        }
        Object object0 = x00.I;
        ne.a a0 = ne.a.a;
        g2 g20 = this.k;
        int v1 = 0;
        switch(x00.N) {
            case 0: {
                n.D(object0);
                c1 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                C c5 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                l02 = this.getProgressUpdater();
                s2 = "MemberProfileViewModel";
                d d0 = this.l;
                if(l02 == null) {
                    x00.r = c1;
                    x00.w = c5;
                    x00.B = null;
                    x00.D = null;
                    x00.E = 0;
                    x00.G = 0;
                    x00.N = 1;
                    object0 = d0.m(this.e, x00);
                    if(object0 == a0) {
                        return a0;
                    }
                    c3 = c5;
                    c4 = c1;
                    v8 = 0;
                label_67:
                    K4 k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), new m2(this, c4, c3, 5));
                    if(k40 != null) {
                        this.updateUiState(new t(k40, 3));
                        if(g1.m(c4, this, c3)) {
                            String s3 = this.e;
                            q.g(s3, "contentRefValue");
                            g20.getClass();
                            g20.b = 11;
                            g20.c = s3;
                            g20.e.setValue(null);
                            g20.g.setValue(null);
                            if(g20.f()) {
                                x00.r = null;
                                x00.w = null;
                                x00.B = null;
                                x00.D = null;
                                x00.E = v1;
                                x00.G = v8;
                                x00.N = 2;
                                if(this.n(true, true, x00) == a0) {
                                    return a0;
                                }
                            }
                        }
                    }
                }
                else {
                    l02.a("MemberProfileViewModel true", true);
                    try {
                        x00.r = c1;
                        x00.w = c5;
                        x00.B = l02;
                        x00.D = "MemberProfileViewModel";
                        x00.E = 0;
                        x00.G = 0;
                        x00.N = 3;
                        object0 = d0.m(this.e, x00);
                        if(object0 == a0) {
                            return a0;
                        }
                        c2 = c5;
                        v4 = 0;
                        v5 = 0;
                    label_101:
                        K4 k41 = this.handleDefaultHttpResponseResult(((Na.f)object0), new m2(this, c1, c2, 5));
                        if(k41 != null) {
                            this.updateUiState(new t(k41, 3));
                            if(g1.m(c1, this, c2)) {
                                String s4 = this.e;
                                q.g(s4, "contentRefValue");
                                g20.getClass();
                                g20.b = 11;
                                g20.c = s4;
                                g20.e.setValue(null);
                                g20.g.setValue(null);
                                if(g20.f()) {
                                    x00.r = null;
                                    x00.w = null;
                                    x00.B = l02;
                                    x00.D = s2;
                                    x00.E = v5;
                                    x00.G = v4;
                                    x00.N = 4;
                                    if(this.n(true, true, x00) == a0) {
                                        return a0;
                                    }
                                    goto label_127;
                                }
                            }
                        }
                        goto label_131;
                    }
                    catch(Throwable throwable0) {
                        l00 = l02;
                        s = s2;
                    }
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                label_127:
                    l00 = l02;
                    s = s2;
                label_129:
                    s2 = s;
                    l02 = l00;
                label_131:
                    Y.v(s2, " false", l02, false);
                }
                break;
            }
            case 1: {
                int v6 = x00.G;
                int v7 = x00.E;
                c3 = x00.w;
                c4 = x00.r;
                n.D(object0);
                v1 = v7;
                v8 = v6;
                goto label_67;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            case 3: {
                try {
                    int v2 = x00.G;
                    int v3 = x00.E;
                    s1 = x00.D;
                    l01 = x00.B;
                    C c0 = x00.w;
                    c1 = x00.r;
                    n.D(object0);
                    v4 = v2;
                    l02 = l01;
                    s2 = s1;
                    v5 = v3;
                    c2 = c0;
                    goto label_101;
                }
                catch(Throwable throwable0) {
                    s = s1;
                    l00 = l01;
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                }
            }
            case 4: {
                try {
                    s = x00.D;
                    l00 = x00.B;
                    n.D(object0);
                    goto label_129;
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    @Override  // Dd.h2
    public final void onUserEvent(e e0) {
        m m0;
        String s = null;
        q.g(e0, "userEvent");
        d d0 = this.l;
        StringProviderImpl stringProviderImpl0 = this.o;
        if(e0 instanceof K0) {
            if(this.h) {
                this.sendUiEvent(new X1(stringProviderImpl0.a(0x7F130C9F), this.i));  // string:text_make_playlist "플레이리스트 만들기"
                return;
            }
            this.c(d0);
            return;
        }
        if(e0 instanceof Dd.L0) {
            s s1 = this.e();
            if(s1 == null) {
                return;
            }
            v0 v00 = new v0(this.g, ((V1)s1.c).f, this.f, this.h, this.i);
            POWERDJINDICATOR myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0 = this.r;
            String s2 = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0 == null ? null : myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0.linkType;
            if(myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0 != null) {
                s = myMusicInformProfileRes$RESPONSE$POWERDJINDICATOR0.linkUrl;
            }
            this.sendUiEvent(new Y1(v00, s2, s));
            p8.f f0 = this.i();
            if(f0 == null) {
                return;
            }
            f0.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = stringProviderImpl0.a(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
            f0.F = stringProviderImpl0.a(0x7F130D54);  // string:tiara_click_copy_more "더보기"
            if(!this.f) {
                f0.v = this.f("");
                f0.u = this.g;
            }
            f0.a().track();
            return;
        }
        if(e0 instanceof o0) {
            this.c(d0);
            return;
        }
        s4 s40 = s4.a;
        if(e0 instanceof n0) {
            if(!this.isLoginUser()) {
                this.sendUiEvent(s40);
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new T0(d0, this, null), 2, null);
            return;
        }
        if(e0 instanceof p0) {
            if(!this.isLoginUser()) {
                this.sendUiEvent(s40);
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new W0(d0, this, null), 2, null);
            return;
        }
        if(e0 instanceof s0) {
            if(!this.isLoginUser()) {
                this.sendUiEvent(s40);
                return;
            }
            ArrayList arrayList0 = new ArrayList();
            String s3 = this.e;
            String s4 = this.g;
            Receiver toReceiverView$Receiver0 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
            toReceiverView$Receiver0.a = s3;
            toReceiverView$Receiver0.b = null;
            toReceiverView$Receiver0.c = s4;
            toReceiverView$Receiver0.d = null;
            toReceiverView$Receiver0.e = null;
            arrayList0.add(toReceiverView$Receiver0);
            ArrayList arrayList1 = h.W(arrayList0);
            Navigator.open(PresentSongSendFragment.Companion.newInstance(null, arrayList1, null));
            return;
        }
        if(e0 instanceof m0) {
            MelonLinkExecutor.open(((m0)e0).a, ((m0)e0).b);
            return;
        }
        if(e0 instanceof q0) {
            l.a(f.g);
            Navigator.open(PresentTabFragment.Companion.newInstance());
            return;
        }
        if(e0 instanceof r0) {
            if(!this.isLoginUser()) {
                this.sendUiEvent(s40);
                return;
            }
            MelonLinkExecutor.open("PA", MelonLinkExecutor.getCleanReportUrl("PROFILE", this.e));
            return;
        }
        if(e0 instanceof E0) {
            Navigator.openPhotoUrl(((E0)e0).a.g);
            p8.f f1 = this.i();
            if(f1 == null) {
                return;
            }
            f1.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f1.y = stringProviderImpl0.a(0x7F130FBF);  // string:tiara_profile_layer1_profile_area "프로필영역"
            f1.F = stringProviderImpl0.a(0x7F130D83);  // string:tiara_click_copy_profile_image "프로필이미지"
            if(!this.f) {
                f1.v = this.f("");
                f1.u = this.g;
            }
            f1.a().track();
            return;
        }
        if(e0 instanceof w0) {
            if(this.f) {
                Navigator.open(FriendPagerFragment.Companion.newInstance(this.g, 0));
            }
            else {
                Navigator.open(OtherFriendPagerFragment.newInstance(this.g, this.e, 0));
            }
            p8.f f2 = this.i();
            if(f2 == null) {
                return;
            }
            f2.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f2.y = stringProviderImpl0.a(0x7F130FBF);  // string:tiara_profile_layer1_profile_area "프로필영역"
            f2.F = stringProviderImpl0.a(0x7F130FB6);  // string:tiara_profile_layer1_follower "팔로워"
            if(!this.f) {
                f2.v = this.f("");
                f2.u = this.g;
            }
            f2.a().track();
            return;
        }
        if(e0 instanceof x0) {
            if(this.f) {
                Navigator.open(FriendPagerFragment.Companion.newInstance(this.g, 1));
            }
            else {
                Navigator.open(OtherFriendPagerFragment.newInstance(this.g, this.e, 1));
            }
            p8.f f3 = this.i();
            if(f3 == null) {
                return;
            }
            f3.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f3.y = stringProviderImpl0.a(0x7F130FBF);  // string:tiara_profile_layer1_profile_area "프로필영역"
            f3.F = stringProviderImpl0.a(0x7F130FB7);  // string:tiara_profile_layer1_following "팔로잉"
            if(!this.f) {
                f3.v = this.f("");
                f3.u = this.g;
            }
            f3.a().track();
            return;
        }
        if(e0 instanceof B0) {
            V1 v10 = ((B0)e0).a;
            if(!v10.d) {
                Navigator.open(Companion.newInstance$default(PlaylistFragment.Companion, false, this.e, v10.e, 0, 8, null));
            }
            else if(this.f) {
                Navigator.open(MyMusicTabFragment.Companion.newInstance("playlist", 0, v10.e));
            }
            else {
                Navigator.open(MyMusicTabFragment.Companion.newInstance(this.e, "playlist", "", 0, v10.e));
            }
            p8.f f4 = this.i();
            if(f4 == null) {
                return;
            }
            f4.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f4.y = stringProviderImpl0.a(0x7F130FBF);  // string:tiara_profile_layer1_profile_area "프로필영역"
            f4.F = stringProviderImpl0.a(0x7F130FBE);  // string:tiara_profile_layer1_playlist "플레이리스트"
            if(!this.f) {
                f4.v = this.f("");
                f4.u = this.g;
            }
            f4.a().track();
            return;
        }
        if(e0 instanceof A0) {
            this.resetFetchTime();
            Navigator.open(new MemberProfileEditFragment());
            p8.f f5 = this.i();
            if(f5 == null) {
                return;
            }
            f5.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f5.y = stringProviderImpl0.a(0x7F130FBF);  // string:tiara_profile_layer1_profile_area "프로필영역"
            f5.F = stringProviderImpl0.a(0x7F130D98);  // string:tiara_click_copy_setting "설정"
            f5.a().track();
            return;
        }
        if(e0 instanceof Dd.v0) {
            Navigator.openArtistInfo(((Dd.v0)e0).a);
            p8.f f6 = this.i();
            if(f6 == null) {
                return;
            }
            f6.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f6.y = stringProviderImpl0.a(0x7F130FBF);  // string:tiara_profile_layer1_profile_area "프로필영역"
            f6.F = stringProviderImpl0.a(0x7F130CFE);  // string:tiara_click_copy_artist_info "아티스트채널"
            if(!this.f) {
                f6.v = this.f("");
                f6.u = this.g;
            }
            f6.a().track();
            return;
        }
        if(e0 instanceof C0) {
            g g0 = new g(this.e, this.e, this.g);
            g0.a = ((C0)e0).a.W;
            g0.b = ((C0)e0).a.X;
            this.updateUserEvent(new I3(g0));
            p8.f f7 = this.i();
            if(f7 == null) {
                return;
            }
            f7.a = stringProviderImpl0.a(0x7F130DC4);  // string:tiara_common_action_name_do_share "공유하기"
            f7.d = ActionKind.Share;
            f7.y = stringProviderImpl0.a(0x7F130FBF);  // string:tiara_profile_layer1_profile_area "프로필영역"
            f7.F = stringProviderImpl0.a(0x7F130D99);  // string:tiara_click_copy_share "공유하기"
            if(!this.f) {
                f7.v = this.f("");
                f7.u = this.g;
            }
            f7.a().track();
            return;
        }
        if(e0 instanceof D0) {
            List list0 = ((D0)e0).a;
            if((list0 == null ? 0 : list0.size()) > 1) {
                ArrayList arrayList2 = new ArrayList();
                if(list0 != null) {
                    for(Object object0: list0) {
                        String s5 = ((SnsInfoBase)object0).dtlInfoCode;
                        if(s5 == null) {
                            s5 = "";
                        }
                        String s6 = ((SnsInfoBase)object0).dtlInfoCodeStr;
                        if(s6 == null) {
                            s6 = "";
                        }
                        String s7 = ((SnsInfoBase)object0).dtlInfoVal;
                        if(s7 == null) {
                            s7 = "";
                        }
                        arrayList2.add(new R0(s5, s6, s7));
                    }
                }
                this.sendUiEvent(new b2(stringProviderImpl0.a(0x7F130C9B), arrayList2));  // string:text_go_channel "채널 이동"
                return;
            }
            if((list0 == null ? 0 : list0.size()) != 1) {
                return;
            }
            if(list0 != null) {
                SnsInfoBase profileBaseRes$SnsInfoBase0 = (SnsInfoBase)list0.get(0);
                if(profileBaseRes$SnsInfoBase0 != null) {
                    s = profileBaseRes$SnsInfoBase0.dtlInfoVal;
                }
            }
            Navigator.openUrl(s, OpenType.Browser);
            return;
        }
        if(e0 instanceof y0) {
            if(this.f && i.l(((y0)e0).a.B)) {
                DjReport myMusicInformProfileRes$RESPONSE$DjReport0 = ((y0)e0).a.B;
                String s8 = myMusicInformProfileRes$RESPONSE$DjReport0 == null ? null : myMusicInformProfileRes$RESPONSE$DjReport0.linktype;
                if(myMusicInformProfileRes$RESPONSE$DjReport0 != null) {
                    s = myMusicInformProfileRes$RESPONSE$DjReport0.linkurl;
                }
                MelonLinkExecutor.open(s8, s);
                return;
            }
            u0.L(this, Dispatchers.getIO(), new Dd.Z0(this, e0, null), 2);
            return;
        }
        if(e0 instanceof z0) {
            Td.b.a(((z0)e0).b);
            if(this.f) {
                TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                Navigator.open(MusicMessageListFragment.Companion.newInstance());
                return;
            }
            if(!this.isLoginUser()) {
                this.sendUiEvent(s40);
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            String s9 = this.e;
            String s10 = this.g;
            Receiver toReceiverView$Receiver1 = new Receiver();  // 初始化器: Ljava/lang/Object;-><init>()V
            toReceiverView$Receiver1.a = s9;
            toReceiverView$Receiver1.b = null;
            toReceiverView$Receiver1.c = s10;
            toReceiverView$Receiver1.d = null;
            toReceiverView$Receiver1.e = null;
            arrayList3.add(toReceiverView$Receiver1);
            ArrayList arrayList4 = h.W(arrayList3);
            Navigator.open(MusicMessageEditorFragment.Companion.newInstance(arrayList4, null, null));
            return;
        }
        if(e0 instanceof H0) {
            Navigator.open(MyMusicTabFragment.Companion.newInstance(this.e, (this.f ? "mylike" : "otherlike"), "", 0, false));
            p8.f f8 = this.i();
            if(f8 == null) {
                return;
            }
            f8.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f8.d = ActionKind.ClickContent;
            f8.y = stringProviderImpl0.a(0x7F130FBA);  // string:tiara_profile_layer1_like "좋아요"
            H0 h00 = (H0)e0;
            f8.c(0);
            if(!this.f) {
                f8.v = stringProviderImpl0.a(0x7F130FC9);  // string:tiara_profile_provider_type_normal "일반"
                f8.u = this.g;
            }
            f8.a().track();
            return;
        }
        if(e0 instanceof F0) {
            Navigator.open(MyMusicTabFragment.Companion.newInstance(this.e, (this.f ? "mylike" : "otherlike"), "", 1, false));
            p8.f f9 = this.i();
            if(f9 == null) {
                return;
            }
            f9.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f9.d = ActionKind.ClickContent;
            f9.y = stringProviderImpl0.a(0x7F130FBA);  // string:tiara_profile_layer1_like "좋아요"
            F0 f00 = (F0)e0;
            f9.c(0);
            if(!this.f) {
                f9.v = stringProviderImpl0.a(0x7F130FC9);  // string:tiara_profile_provider_type_normal "일반"
                f9.u = this.g;
            }
            f9.a().track();
            return;
        }
        if(e0 instanceof G0) {
            Navigator.open(MyMusicTabFragment.Companion.newInstance(this.e, (this.f ? "mylike" : "otherlike"), "", 2, false));
            p8.f f10 = this.i();
            if(f10 == null) {
                return;
            }
            f10.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f10.d = ActionKind.ClickContent;
            f10.y = stringProviderImpl0.a(0x7F130FBA);  // string:tiara_profile_layer1_like "좋아요"
            G0 g00 = (G0)e0;
            f10.c(0);
            if(!this.f) {
                f10.v = stringProviderImpl0.a(0x7F130FC9);  // string:tiara_profile_provider_type_normal "일반"
                f10.u = this.g;
            }
            f10.a().track();
            return;
        }
        if(e0 instanceof I0) {
            MelonPrefs.getInstance().setLong("powerDjApplySlotClosedTime", System.currentTimeMillis());
            O1 o10 = this.h();
            if(o10 != null) {
                s = o10.a;
            }
            if(((Collection)s) == null || ((Collection)s).isEmpty()) {
                return;
            }
            ArrayList arrayList5 = p.Q0(((Collection)s));
            int v = 0;
            Iterator iterator1 = ((List)s).iterator();
            while(true) {
                if(!iterator1.hasNext()) {
                    v = -1;
                    break;
                }
                Object object1 = iterator1.next();
                if(((K4)object1) instanceof P0) {
                    break;
                }
                ++v;
            }
            if(v < 0) {
                return;
            }
            arrayList5.remove(v);
            if(this.h() == null) {
                return;
            }
            this.updateUiState(new i0(this, arrayList5, 0));
            return;
        }
        if(e0 instanceof J0) {
            MelonLinkExecutor.open(((J0)e0).a.c, ((J0)e0).a.d);
            return;
        }
        if(e0 instanceof Dd.u0) {
            String s11 = ((Dd.u0)e0).a;
            Navigator.openDjPlaylistDetail(s11);
            p8.f f11 = this.i();
            if(f11 == null) {
                return;
            }
            f11.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f11.d = ActionKind.ClickContent;
            f11.y = stringProviderImpl0.a(0x7F130FB3);  // string:tiara_profile_layer1_dj_pick "DJ PICK"
            f11.c(1);
            if(!this.f) {
                f11.v = this.f("");
                f11.u = this.g;
            }
            f11.e = s11;
            f11.f = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            f11.g = ((Dd.u0)e0).b;
            f11.a().track();
            return;
        }
        if(e0 instanceof t0) {
            String s12 = ((t0)e0).a;
            com.melon.ui.k k0 = new com.melon.ui.k(s12, this.getMenuId(), ((t0)e0).d, 0x20);
            T2.a a0 = f0.h(this);
            Cd.Q q0 = new Cd.Q(1, this, g1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 18);
            this.n.d(k0, a0, q0);
            p8.f f12 = this.i();
            if(f12 == null) {
                return;
            }
            f12.a = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f12.d = ActionKind.PlayMusic;
            f12.y = stringProviderImpl0.a(0x7F130FB3);  // string:tiara_profile_layer1_dj_pick "DJ PICK"
            f12.c(1);
            if(!this.f) {
                f12.v = this.f("");
                f12.u = this.g;
            }
            f12.e = s12;
            f12.f = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            f12.g = ((t0)e0).b;
            f12.a().track();
            return;
        }
        if(e0 instanceof N0) {
            String s13 = ((N0)e0).a;
            Navigator.INSTANCE.openSeriesFolderDetail(s13);
            p8.f f13 = this.i();
            if(f13 != null) {
                f13.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f13.d = ActionKind.ClickContent;
                f13.y = stringProviderImpl0.a(0x7F130FC3);  // string:tiara_profile_layer1_series_playlist "시리즈플레이리스트"
                f13.c(((N0)e0).d + 1);
                if(!this.f) {
                    f13.v = this.f("");
                    f13.u = this.g;
                }
                f13.e = s13;
                f13.f = p8.b.a(((N0)e0).c);
                f13.g = ((N0)e0).b;
                f13.a().track();
            }
            return;
        }
        if(e0 instanceof M0) {
            MelonLinkExecutor.open(((M0)e0).a, ((M0)e0).b);
            return;
        }
        if(e0 instanceof C1) {
            if(((C1)e0) instanceof w1) {
                m0 = new m(((w1)e0).a, ((w1)e0).c, null, null, 0x30);
            }
            else if(((C1)e0) instanceof x1) {
                m0 = new o(((x1)e0).a, ((x1)e0).c, null, 36);
            }
            else {
                m0 = null;
            }
            if(((C1)e0) instanceof E1) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new Dd.a1(this, null), 2, null);
                return;
            }
            boolean z = this.isLoginUser();
            T2.a a1 = f0.h(this);
            Cd.Q q1 = new Cd.Q(1, this, g1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 19);
            A2 a20 = new A2(this, 14);
            W.p p0 = new W.p();  // 初始化器: Ljava/lang/Object;-><init>()V
            p0.a = this.getTiaraProperty();
            p0.b = stringProviderImpl0.a(0x7F13089A);  // string:profile_comment "DJ에게 한마디"
            q.g(this.o, "stringProvider");
            q.g(this.n, "addPlayUserEventHelper");
            this.k.e(e0, z, this.o, this.n, m0, a1, q1, a20, p0);
            return;
        }
        super.onUserEvent(e0);
    }
}

