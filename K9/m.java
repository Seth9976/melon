package k9;

import O8.d;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayListRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistPlayListRes;
import com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes.RESPONSE.DJPLAYLISTLIST;
import com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes;
import com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes.RESPONSE.LIKEPLYLSTLIST;
import com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes;
import com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes.RESPONSE.RECNTPLYLSTLIST;
import com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes;
import com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes;
import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import x8.f;

public final class m extends f {
    public g a;
    public HttpResponse b;
    public O8.f c;

    public final void a(g g0, HttpResponse httpResponse0) {
        q.g(httpResponse0, "response");
        this.a = g0;
        this.b = httpResponse0;
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        ArrayList arrayList0;
        Void void0 = (Void)object0;
        this.c = new O8.f(null);
        g g0 = this.a;
        if(g0 != null) {
            HttpResponse httpResponse0 = this.b;
            if(httpResponse0 != null) {
                h.g(g0, httpResponse0, PlaylistId.EMPTY.getSeq(), "0");
                HttpResponse httpResponse1 = this.b;
                if(httpResponse1 != null) {
                    if(httpResponse1 instanceof MyMusicPlaylistPlayListRes) {
                        RESPONSE myMusicPlaylistPlayListRes$RESPONSE0 = ((MyMusicPlaylistPlayListRes)httpResponse1).response;
                        if(myMusicPlaylistPlayListRes$RESPONSE0 == null || (myMusicPlaylistPlayListRes$RESPONSE0.playlistlist == null || myMusicPlaylistPlayListRes$RESPONSE0.playlistlist.isEmpty())) {
                            arrayList0 = null;
                        }
                        else {
                            arrayList0 = new ArrayList();
                            Iterator iterator0 = ((MyMusicPlaylistPlayListRes)httpResponse1).response.playlistlist.iterator();
                            q.f(iterator0, "iterator(...)");
                            while(iterator0.hasNext()) {
                                Object object1 = iterator0.next();
                                PLAYLISTLIST myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0 = (PLAYLISTLIST)object1;
                                if(myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.plylstseq != null && myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.plylstseq.length() != 0 && (myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.thumbimg != null && myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.thumbimg.length() != 0)) {
                                    arrayList0.add(new l((myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.plylsttitle == null ? "" : myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.plylsttitle), (myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.plylstseq == null ? "" : myMusicPlaylistPlayListRes$RESPONSE$PLAYLISTLIST0.plylstseq)));
                                }
                            }
                        }
                    }
                    else if(httpResponse1 instanceof MyMusicSmartPlaylistListRes) {
                        com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes.RESPONSE myMusicSmartPlaylistListRes$RESPONSE0 = ((MyMusicSmartPlaylistListRes)httpResponse1).response;
                        if(myMusicSmartPlaylistListRes$RESPONSE0 == null || (myMusicSmartPlaylistListRes$RESPONSE0.playlistList == null || myMusicSmartPlaylistListRes$RESPONSE0.playlistList.isEmpty())) {
                            arrayList0 = null;
                        }
                        else {
                            arrayList0 = new ArrayList();
                            Iterator iterator1 = ((MyMusicSmartPlaylistListRes)httpResponse1).response.playlistList.iterator();
                            q.f(iterator1, "iterator(...)");
                            while(iterator1.hasNext()) {
                                Object object2 = iterator1.next();
                                com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes.RESPONSE.PLAYLISTLIST myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0 = (com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes.RESPONSE.PLAYLISTLIST)object2;
                                if(myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylstseq != null && myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylstseq.length() != 0 && (myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.thumbimg != null && myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.thumbimg.length() != 0)) {
                                    arrayList0.add(new l((myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylsttitle == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylsttitle), (myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.thumbimg == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.thumbimg)));
                                }
                            }
                        }
                    }
                    else if(httpResponse1 instanceof DjSmartPlaylistListRes) {
                        com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes.RESPONSE djSmartPlaylistListRes$RESPONSE0 = ((DjSmartPlaylistListRes)httpResponse1).response;
                        if(djSmartPlaylistListRes$RESPONSE0 == null || (djSmartPlaylistListRes$RESPONSE0.djPlaylistList == null || djSmartPlaylistListRes$RESPONSE0.djPlaylistList.isEmpty())) {
                            arrayList0 = null;
                        }
                        else {
                            arrayList0 = new ArrayList();
                            Iterator iterator2 = ((DjSmartPlaylistListRes)httpResponse1).response.djPlaylistList.iterator();
                            q.f(iterator2, "iterator(...)");
                            while(iterator2.hasNext()) {
                                Object object3 = iterator2.next();
                                DJPLAYLISTLIST djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0 = (DJPLAYLISTLIST)object3;
                                if(djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylstseq != null && djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylstseq.length() != 0 && (djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.thumbimg != null && djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.thumbimg.length() != 0)) {
                                    arrayList0.add(new l((djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylsttitle == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylsttitle), (djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.thumbimg == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.thumbimg)));
                                }
                            }
                        }
                    }
                    else if(httpResponse1 instanceof MyMusicRecentPlaylistRes) {
                        com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes.RESPONSE myMusicRecentPlaylistRes$RESPONSE0 = ((MyMusicRecentPlaylistRes)httpResponse1).response;
                        if(myMusicRecentPlaylistRes$RESPONSE0 == null || (myMusicRecentPlaylistRes$RESPONSE0.recentPlaylistList == null || myMusicRecentPlaylistRes$RESPONSE0.recentPlaylistList.isEmpty())) {
                            arrayList0 = null;
                        }
                        else {
                            arrayList0 = new ArrayList();
                            Iterator iterator3 = ((MyMusicRecentPlaylistRes)httpResponse1).response.recentPlaylistList.iterator();
                            q.f(iterator3, "iterator(...)");
                            while(iterator3.hasNext()) {
                                Object object4 = iterator3.next();
                                RECNTPLYLSTLIST myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0 = (RECNTPLYLSTLIST)object4;
                                if(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.albumImgs != null && !myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.albumImgs.isEmpty()) {
                                    Iterator iterator4 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.albumImgs.iterator();
                                    q.f(iterator4, "iterator(...)");
                                    while(iterator4.hasNext()) {
                                        Object object5 = iterator4.next();
                                        String s = (String)object5;
                                        if(s != null && s.length() != 0) {
                                            String s1 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainTitle;
                                            q.f(s1, "mainTitle");
                                            arrayList0.add(new l(s1, s));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(httpResponse1 instanceof MyMusicLikePlaylistRes) {
                        com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes.RESPONSE myMusicLikePlaylistRes$RESPONSE0 = ((MyMusicLikePlaylistRes)httpResponse1).response;
                        if(myMusicLikePlaylistRes$RESPONSE0 == null || (myMusicLikePlaylistRes$RESPONSE0.likePlaylistList == null || myMusicLikePlaylistRes$RESPONSE0.likePlaylistList.isEmpty())) {
                            arrayList0 = null;
                        }
                        else {
                            arrayList0 = new ArrayList();
                            Iterator iterator5 = ((MyMusicLikePlaylistRes)httpResponse1).response.likePlaylistList.iterator();
                            q.f(iterator5, "iterator(...)");
                            while(iterator5.hasNext()) {
                                Object object6 = iterator5.next();
                                LIKEPLYLSTLIST myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0 = (LIKEPLYLSTLIST)object6;
                                if(myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.albumImgs != null && !myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.albumImgs.isEmpty()) {
                                    Iterator iterator6 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.albumImgs.iterator();
                                    q.f(iterator6, "iterator(...)");
                                    while(iterator6.hasNext()) {
                                        Object object7 = iterator6.next();
                                        String s2 = (String)object7;
                                        if(s2 != null && s2.length() != 0) {
                                            String s3 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.mainTitle;
                                            q.f(s3, "mainTitle");
                                            arrayList0.add(new l(s3, s2));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else {
                        arrayList0 = null;
                    }
                    if(arrayList0 != null && !arrayList0.isEmpty()) {
                        File file0 = i.c(2);
                        if(!file0.exists()) {
                            file0.mkdirs();
                        }
                        for(Object object8: arrayList0) {
                            l l0 = (l)object8;
                            if(l0.c.exists()) {
                                continue;
                            }
                            O8.f f0 = this.c;
                            if(f0 != null) {
                                String s4 = Cb.i.i(l0.c);
                                d.b(f0.a, l0.b, s4);
                                continue;
                            }
                            q.m("client");
                            throw null;
                        }
                    }
                    return H.a;
                }
                q.m("response");
                throw null;
            }
            q.m("response");
            throw null;
        }
        q.m("responseType");
        throw null;
    }
}

