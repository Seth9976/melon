package m8;

import Ic.k;
import Kc.f;
import Tf.v;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsPhotoFragment;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsSongFragment;
import com.iloen.melon.fragments.artistchannel.ArtistDetailContentsStationFragment;
import com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment;
import com.iloen.melon.fragments.artistchannel.ArtistDetailTemperatureFragment;
import com.iloen.melon.fragments.artistchannel.ArtistPickFragment;
import com.iloen.melon.fragments.detail.DjPlaylistDetailFragment;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.fragments.detail.SongDetailFragment;
import com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.SearchPhotoViewBaseReq.Params;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import i.n.i.b.a.s.e.I2;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import je.n;
import je.p;
import k8.t;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;

public abstract class h {
    public static void a(Uri uri0) {
        List list0 = uri0.getPathSegments();
        q.f(list0, "getPathSegments(...)");
        String s = (String)p.k0(list0);
        String s1 = uri0.getLastPathSegment();
        ArrayList arrayList0 = null;
        Long long0 = s1 == null ? null : v.u0(s1);
        String s2 = uri0.getQueryParameter("cid");
        if(long0 != null || s2 != null && s2.length() != 0) {
            if(s2 == null || s2.length() <= 0) {
                List list1 = uri0.getPathSegments();
                q.f(list1, "getPathSegments(...)");
                s2 = (String)p.s0(list1);
            }
            Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.d("Details.kt", "executeLegacyType() - details/" + s + " - contentId : " + s2);
            if(s != null) {
                switch(s) {
                    case "album": {
                        boolean z1 = "Y".equals(uri0.getQueryParameter("autoplay"));
                        q.d(s2);
                        k k0 = new k();
                        Bundle bundle0 = new Bundle();
                        bundle0.putString("argAlbumId", s2);
                        bundle0.putBoolean("argAutoPlay", z1);
                        k0.setArguments(bundle0);
                        Navigator.INSTANCE.open(k0);
                        break;
                    }
                    case "artist": {
                        String s3 = uri0.getQueryParameter("ctype");
                        boolean z = "Y".equals(uri0.getQueryParameter("autoplay"));
                        q.d(s2);
                        Navigator.INSTANCE.openArtistInfo(s2, s3, z);
                        break;
                    }
                    case "artistfriendship": {
                        q.d(s2);
                        Navigator.open(ArtistDetailTemperatureFragment.Companion.newInstance(s2));
                        break;
                    }
                    case "djcollection": {
                        q.d(s2);
                        Navigator.open(DjPlaylistDetailFragment.Companion.newInstance(s2));
                        break;
                    }
                    case "photo": {
                        String s4 = uri0.getQueryParameter("artistId");
                        String s5 = uri0.getQueryParameter("artistName");
                        String s6 = uri0.getQueryParameter("artistImg");
                        if(s2 != null) {
                            Navigator.INSTANCE.openPhotoInfo(s2, s4, s6, s5);
                        }
                        break;
                    }
                    case "playlist": {
                        q.d(s2);
                        f f0 = new f();
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("argAlbumId", s2);
                        f0.setArguments(bundle1);
                        Navigator.INSTANCE.open(f0);
                        break;
                    }
                    case "song": {
                        q.d(s2);
                        Navigator.open(SongDetailFragment.Companion.newInstance(s2));
                        break;
                    }
                    case "video": {
                        q.d(s2);
                        Navigator.openMvInfo$default(s2, "1000000550", null, false, 12, null);
                        break;
                    }
                    default: {
                        goto label_57;
                    }
                }
                logU$Companion0.i("Details.kt", "uri is legacy type");
                return;
            }
        }
    label_57:
        LogU.Companion.i("Details.kt", "uri is not legacy type");
        String s7 = uri0.getPath();
        if(s7 != null) {
        alab1:
            switch(s7) {
                case "/albumstation": {
                    String s8 = uri0.getQueryParameter("albumId");
                    if(s8 != null) {
                        Navigator.INSTANCE.openAlbumStation(s8);
                        return;
                    }
                    break;
                }
                case "/artistfanlist": {
                    String s29 = uri0.getQueryParameter("artistId");
                    String s30 = uri0.getQueryParameter("artistName");
                    if(s29 != null) {
                        Navigator.open(ArtistDetailFanListFragment.Companion.newInstance(s29, s30));
                        return;
                    }
                    break;
                }
                case "/artistphoto": {
                    String s21 = uri0.getQueryParameter("artistId");
                    if(s21 != null) {
                        Navigator.open(ArtistDetailContentsPhotoFragment.Companion.newInstance(s21));
                        return;
                    }
                    break;
                }
                case "/artistpick": {
                    String s31 = uri0.getQueryParameter("artistId");
                    String s32 = uri0.getQueryParameter("artistPickSeq");
                    String s33 = uri0.getQueryParameter("type");
                    if(s31 != null) {
                        String s34 = "single".equals(s33) ? "S" : "R";
                        String s35 = MelonContentUris.S0.buildUpon().appendPath(s31).build().toString();
                        q.f(s35, "toString(...)");
                        MelonAppBase.Companion.getClass();
                        a.c(t.a().getContext(), s35, true);
                        Navigator.open(ArtistPickFragment.Companion.newInstance(s31, s34, s32));
                        return;
                    }
                    break;
                }
                case "/artistsong": {
                    String s36 = uri0.getQueryParameter("artistId");
                    String s37 = uri0.getQueryParameter("artistName");
                    String s38 = uri0.getQueryParameter("filterBy");
                    String s39 = uri0.getQueryParameter("categoryCode");
                    String[] arr_s3 = {s36, s37};
                    for(int v3 = 0; v3 < 2; ++v3) {
                        if(arr_s3[v3] == null) {
                            break alab1;
                        }
                    }
                    ArrayList arrayList4 = n.g0(arr_s3);
                    String s40 = (String)arrayList4.get(0);
                    String s41 = (String)arrayList4.get(1);
                    q.g(s40, "artistId");
                    q.g(s41, "artistName");
                    Navigator.open(ArtistDetailContentsSongFragment.Companion.newInstance(s40, s41, s38, s39));
                    return;
                }
                case "/artiststation": {
                    String s22 = uri0.getQueryParameter("artistId");
                    if(s22 != null) {
                        Navigator.open(ArtistDetailContentsStationFragment.Companion.newInstance(s22));
                        return;
                    }
                    break;
                }
                case "/forumix": {
                    String[] arr_s = {uri0.getQueryParameter("contsId"), uri0.getQueryParameter("seedContsId"), uri0.getQueryParameter("seedContsTypeCode")};
                    for(int v = 0; v < 3; ++v) {
                        if(arr_s[v] == null) {
                            break alab1;
                        }
                    }
                    ArrayList arrayList1 = n.g0(arr_s);
                    String s9 = (String)arrayList1.get(0);
                    String s10 = (String)arrayList1.get(1);
                    String s11 = (String)arrayList1.get(2);
                    q.g(s9, "contsId");
                    q.g(s10, "seedContsId");
                    q.g(s11, "seedContsTypeCode");
                    if(!n.Q(new String[]{"33", "35"}, s9) && !((e0)o.a()).m()) {
                        Navigator.openLoginView(uri0);
                        return;
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new I2(s9, s10, s11, 6), 100L);
                    return;
                }
                case "/maestro": {
                    String s23 = uri0.getQueryParameter("genreArtistId");
                    if(s23 != null) {
                        Navigator.INSTANCE.openGenreArtistDetail(s23);
                        return;
                    }
                    break;
                }
                case "/playlistallsong": {
                    String[] arr_s4 = {uri0.getQueryParameter("type"), uri0.getQueryParameter("playlistSeq"), uri0.getQueryParameter("title"), uri0.getQueryParameter("songTime"), uri0.getQueryParameter("songCount")};
                    for(int v4 = 0; v4 < 5; ++v4) {
                        if(arr_s4[v4] == null) {
                            break alab1;
                        }
                    }
                    ArrayList arrayList5 = n.g0(arr_s4);
                    String s42 = (String)arrayList5.get(0);
                    String s43 = (String)arrayList5.get(1);
                    String s44 = (String)arrayList5.get(2);
                    String s45 = (String)arrayList5.get(3);
                    String s46 = (String)arrayList5.get(4);
                    q.g(s42, "playlistType");
                    q.g(s43, "playlistSeq");
                    q.g(s44, "title");
                    q.g(s45, "totalPlayTime");
                    q.g(s46, "totalSongCount");
                    Navigator.INSTANCE.openPlaylistAllSong(s42, s43, s44, s45, s46);
                    return;
                }
                case "/playlistedit": {
                    String[] arr_s1 = {uri0.getQueryParameter("type"), uri0.getQueryParameter("playlistSeq"), uri0.getQueryParameter("memberKey")};
                    for(int v1 = 0; v1 < 3; ++v1) {
                        if(arr_s1[v1] == null) {
                            break alab1;
                        }
                    }
                    ArrayList arrayList2 = n.g0(arr_s1);
                    String s12 = (String)arrayList2.get(0);
                    String s13 = (String)arrayList2.get(1);
                    String s14 = (String)arrayList2.get(2);
                    q.g(s12, "playlistType");
                    q.g(s13, "playlistSeq");
                    q.g(s14, "memberKey");
                    if(s14.equals(u.v(((e0)o.a()).j()))) {
                        Navigator.INSTANCE.openPlaylistEdit(s13, s12);
                        return;
                    }
                    break;
                }
                case "/playlistmake": {
                    String s15 = uri0.getQueryParameter("type");
                    String s16 = uri0.getQueryParameter("title");
                    String s17 = uri0.getQueryParameter("thumbnail");
                    String s18 = s17 == null ? null : URLDecoder.decode(s17, "utf-8");
                    String s19 = uri0.getQueryParameter("ids");
                    if(s19 == null) {
                        s19 = "";
                    }
                    if(s15 != null) {
                        String s20 = "M20004";
                        switch(s15) {
                            case "M20002": 
                            case "M20003": 
                            case "M20004": {
                                break;
                            }
                            case "M20005": {
                                Navigator.open(SeriesPlaylistMakeFragment.Companion.newInstance("", true));
                                return;
                            }
                            default: {
                                s20 = "M20001";
                                break;
                            }
                        }
                        if(!Tf.o.H0(s19)) {
                            arrayList0 = new ArrayList(Tf.o.R0(s19, new String[]{","}, 0, 6));
                        }
                        Navigator.open(PlaylistMakeFragment.newInstance(null, s20, arrayList0, s16, null, s18));
                        return;
                    }
                    break;
                }
                case "/searchphoto": {
                    String[] arr_s2 = {uri0.getQueryParameter("keyword"), uri0.getQueryParameter("orderBy"), uri0.getQueryParameter("photoId"), uri0.getQueryParameter("photoIndex"), uri0.getQueryParameter("artistId")};
                    for(int v2 = 0; v2 < 5; ++v2) {
                        if(arr_s2[v2] == null) {
                            break alab1;
                        }
                    }
                    ArrayList arrayList3 = n.g0(arr_s2);
                    String s25 = (String)arrayList3.get(0);
                    String s26 = (String)arrayList3.get(1);
                    String s27 = (String)arrayList3.get(2);
                    String s28 = (String)arrayList3.get(3);
                    q.g(s25, "keyword");
                    q.g(s26, "orderBy");
                    q.g(s27, "photoId");
                    q.g(s28, "photoIndex");
                    Params searchPhotoViewBaseReq$Params0 = new Params();
                    searchPhotoViewBaseReq$Params0.searchKeyword = s25;
                    searchPhotoViewBaseReq$Params0.orderBy = ProtocolUtils.parseInt(s26, 1);
                    searchPhotoViewBaseReq$Params0.photoId = s27;
                    searchPhotoViewBaseReq$Params0.photoIndex = ProtocolUtils.parseInt(s28, 1);
                    PhotoDetailViewFragment.Companion.newInstance(searchPhotoViewBaseReq$Params0).open();
                    return;
                }
                case "/songstation": {
                    String s24 = uri0.getQueryParameter("songId");
                    if(s24 != null) {
                        Navigator.INSTANCE.openSongStation(s24);
                        return;
                    }
                    break;
                }
            }
        }
    }
}

