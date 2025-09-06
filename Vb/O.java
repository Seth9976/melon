package vb;

import Cb.g;
import M7.H;
import Na.d;
import Na.e;
import androidx.lifecycle.b;
import androidx.media3.session.legacy.V;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.response.ContentsInfoPostImgRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ContentsInfoPostImgRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertMusicMsgRes;
import com.iloen.melon.net.v6x.response.MusicWaveShareSnsRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.SharableAlbum;
import com.iloen.melon.sns.model.SharableBrandDj;
import com.iloen.melon.sns.model.SharableCast;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.sns.model.SharableMelgun;
import com.iloen.melon.sns.model.SharableMusicWave;
import com.iloen.melon.sns.model.SharableMyMusic;
import com.iloen.melon.sns.model.SharablePlaylist;
import com.iloen.melon.sns.model.SharableProgram;
import com.iloen.melon.sns.model.SharableSong;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.types.Song;
import d5.m;
import d5.n;
import e.k;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.c;
import ta.L;
import ua.u;

public final class o {
    public final u a;
    public final b b;
    public final L c;
    public final V d;

    public o(u u0, b b0, L l0, V v0) {
        this.a = u0;
        this.b = b0;
        this.c = l0;
        this.d = v0;
    }

    public final Object a(String s, String s1, String s2, c c0) {
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.r;
        a a0 = a.a;
        switch(j0.B) {
            case 0: {
                n.D(object0);
                try {
                    j0.B = 1;
                    object0 = this.c.o(s, s1, s2, j0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveShareSnsRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Flow b(Playable playable0, String s, SnsManager.SnsType snsManager$SnsType0) {
        q.g(playable0, "playable");
        q.g(snsManager$SnsType0, "snsType");
        List list0 = k.z(s);
        return FlowKt.catch(new g(V.m(this.d, playable0, list0), snsManager$SnsType0, 7), new H(3, 15, null));
    }

    public final Serializable c(Q0.a a0, Continuation continuation0) {
        String s3;
        l l0;
        if(continuation0 instanceof l) {
            l0 = (l)continuation0;
            int v = l0.D;
            if((v & 0x80000000) == 0) {
                l0 = new l(this, continuation0);
            }
            else {
                l0.D = v ^ 0x80000000;
            }
        }
        else {
            l0 = new l(this, continuation0);
        }
        Object object0 = l0.w;
        Serializable serializable0 = a.a;
        switch(l0.D) {
            case 0: {
                n.D(object0);
                ContsTypeCode contsTypeCode0 = a0.i();
                if(q.b(contsTypeCode0, ContsTypeCode.SONG) || q.b(contsTypeCode0, ContsTypeCode.ALBUM) || q.b(contsTypeCode0, ContsTypeCode.PLAYLIST) || q.b(contsTypeCode0, ContsTypeCode.DJ_PLAYLIST) || q.b(contsTypeCode0, ContsTypeCode.ARTIST_PLAYLIST) || q.b(contsTypeCode0, ContsTypeCode.MUSIC_WAVE) || q.b(contsTypeCode0, ContsTypeCode.VIDEO)) {
                    String s = a0.h();
                    String s1 = a0.i().code();
                    q.f(s1, "code(...)");
                    l0.r = a0;
                    l0.D = 1;
                    object0 = this.b.y(s, s1, l0);
                    if(object0 == serializable0) {
                        return serializable0;
                    }
                    goto label_26;
                }
                break;
            }
            case 1: {
                a0 = l0.r;
                n.D(object0);
            label_26:
                String s2 = null;
                if(((ContentsInfoPostImgRes)object0) == null) {
                    s3 = null;
                }
                else {
                    RESPONSE contentsInfoPostImgRes$RESPONSE0 = ((ContentsInfoPostImgRes)object0).response;
                    s3 = contentsInfoPostImgRes$RESPONSE0 == null ? null : contentsInfoPostImgRes$RESPONSE0.postImg;
                }
                a0.a = s3;
                if(((ContentsInfoPostImgRes)object0) != null) {
                    RESPONSE contentsInfoPostImgRes$RESPONSE1 = ((ContentsInfoPostImgRes)object0).response;
                    if(contentsInfoPostImgRes$RESPONSE1 != null) {
                        s2 = contentsInfoPostImgRes$RESPONSE1.postEditImg;
                    }
                }
                a0.b = s2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(a0 instanceof t) {
            E9.u u0 = new E9.u();  // 初始化器: Ljava/lang/Object;-><init>()V
            u0.a = ((t)a0).c;
            u0.b = ((t)a0).d;
            u0.c = ((t)a0).e;
            u0.d = (String)((t)a0).a;
            u0.e = (String)((t)a0).b;
            u0.f = ((t)a0).f;
            return new SharableSong(u0);
        }
        if(a0 instanceof vb.a) {
            com.iloen.melon.sns.model.a a1 = new com.iloen.melon.sns.model.a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a1.b = ((vb.a)a0).c;
            a1.c = ((vb.a)a0).d;
            a1.d = (String)((vb.a)a0).a;
            a1.e = (String)((vb.a)a0).b;
            a1.g = ((vb.a)a0).e;
            a1.f = ((vb.a)a0).f;
            return new SharableAlbum(a1);
        }
        if(a0 instanceof h) {
            com.iloen.melon.sns.model.c c0 = new com.iloen.melon.sns.model.c();
            c0.a = ((h)a0).c;
            c0.e = ((h)a0).d;
            c0.f = ((h)a0).f;
            c0.b = (String)((h)a0).a;
            c0.c = (String)((h)a0).b;
            return new SharablePlaylist(c0);
        }
        if(a0 instanceof vb.d) {
            com.iloen.melon.sns.model.c c1 = new com.iloen.melon.sns.model.c();  // 初始化器: Ljava/lang/Object;-><init>()V
            c1.a = ((vb.d)a0).c;
            c1.b = ((vb.d)a0).d;
            c1.c = ((vb.d)a0).e;
            c1.d = ((vb.d)a0).f;
            c1.e = ((vb.d)a0).g;
            c1.f = (String)((vb.d)a0).a;
            c1.g = (String)((vb.d)a0).b;
            return new SharableDJCollection(c1);
        }
        if(a0 instanceof i) {
            m m0 = new m(11, false);
            q.g(((i)a0).c, "progSeq");
            m0.b = ((i)a0).c;
            q.g(((i)a0).d, "title");
            m0.c = ((i)a0).d;
            q.g(((i)a0).e, "progImgUrl");
            m0.d = ((i)a0).e;
            return new SharableProgram(m0);
        }
        if(a0 instanceof vb.c) {
            q.g(((vb.c)a0).c, "castSeq");
            q.g(((vb.c)a0).d, "title");
            q.g(((vb.c)a0).e, "castImgUrl");
            Serializable serializable1 = new SharableCast();  // 初始化器: Ljava/lang/Object;-><init>()V
            serializable1.a = ((vb.c)a0).c;
            serializable1.b = ((vb.c)a0).d;
            serializable1.d = ((vb.c)a0).e;
            serializable1.e = ((vb.c)a0).f;
            return serializable1;
        }
        if(a0 instanceof f) {
            String s4 = ((f)a0).c;
            String s5 = ((f)a0).e;
            String s6 = ((f)a0).f;
            String s7 = "";
            if(s6 == null) {
                s6 = "";
            }
            String s8 = ((f)a0).g;
            if(s8 == null) {
                s8 = "";
            }
            String s9 = ((f)a0).h;
            if(s9 != null) {
                s7 = s9;
            }
            Serializable serializable2 = new SharableMusicWave();  // 初始化器: Ljava/lang/Object;-><init>()V
            serializable2.a = s4;
            serializable2.b = s5;
            serializable2.d = s6;
            serializable2.e = s8;
            serializable2.f = s7;
            return serializable2;
        }
        if(a0 instanceof vb.g) {
            String s10 = (String)((vb.g)a0).a;
            String s11 = (String)((vb.g)a0).b;
            Serializable serializable3 = new SharableMyMusic();  // 初始化器: Ljava/lang/Object;-><init>()V
            serializable3.a = ((vb.g)a0).e;
            serializable3.b = ((vb.g)a0).d;
            serializable3.d = s10;
            serializable3.e = s11;
            return serializable3;
        }
        if(a0 instanceof vb.e) {
            String s12 = (String)((vb.e)a0).a;
            String s13 = (String)((vb.e)a0).b;
            Serializable serializable4 = new SharableMelgun();  // 初始化器: Ljava/lang/Object;-><init>()V
            serializable4.a = s12;
            serializable4.b = s13;
            return serializable4;
        }
        if(!(a0 instanceof vb.b)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        String s14 = (String)((vb.b)a0).a;
        String s15 = (String)((vb.b)a0).b;
        Serializable serializable5 = new SharableBrandDj();  // 初始化器: Ljava/lang/Object;-><init>()V
        serializable5.a = ((vb.b)a0).e;
        serializable5.b = ((vb.b)a0).d;
        serializable5.d = s14;
        serializable5.e = s15;
        return serializable5;
    }

    public final Object d(String s, String s1, String s2, c c0) {
        vb.m m0;
        if(c0 instanceof vb.m) {
            m0 = (vb.m)c0;
            int v = m0.B;
            if((v & 0x80000000) == 0) {
                m0 = new vb.m(this, c0);
            }
            else {
                m0.B = v ^ 0x80000000;
            }
        }
        else {
            m0 = new vb.m(this, c0);
        }
        Object object0 = m0.r;
        a a0 = a.a;
        switch(m0.B) {
            case 0: {
                n.D(object0);
                try {
                    m0.B = 1;
                    object0 = this.a.t(s, s1, s2, m0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicMessageInsertMusicMsgRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object e(Playable playable0, SnsManager.SnsType snsManager$SnsType0, c c0) {
        String s4;
        Playable playable2;
        Playable playable1;
        vb.n n0;
        if(c0 instanceof vb.n) {
            n0 = (vb.n)c0;
            int v = n0.E;
            if((v & 0x80000000) == 0) {
                n0 = new vb.n(this, c0);
            }
            else {
                n0.E = v ^ 0x80000000;
            }
        }
        else {
            n0 = new vb.n(this, c0);
        }
        Object object0 = n0.B;
        a a0 = a.a;
        switch(n0.E) {
            case 0: {
                n.D(object0);
                playable1 = Playable.copyValueOf(playable0);
                if(playable0.isTypeOfSong() && playable0.isOriginLocal()) {
                    playable1.updateFrom(Song.e(playable0, true));
                }
                String s = playable1.getPostImg();
                if(s == null || s.length() == 0) {
                label_21:
                    String s2 = playable1.getContsTypeCode().code();
                    q.d("");
                    q.d(s2);
                    n0.r = snsManager$SnsType0;
                    n0.w = playable1;
                    n0.E = 1;
                    Object object1 = this.b.y("", s2, n0);
                    if(object1 == a0) {
                        return a0;
                    }
                    object0 = object1;
                    playable2 = playable1;
                    goto label_36;
                }
                else {
                    String s1 = playable1.getPostEditImg();
                    if(s1 == null || s1.length() == 0) {
                        goto label_21;
                    }
                }
                break;
            }
            case 1: {
                playable2 = n0.w;
                snsManager$SnsType0 = n0.r;
                n.D(object0);
            label_36:
                String s3 = null;
                if(((ContentsInfoPostImgRes)object0) == null) {
                    s4 = null;
                }
                else {
                    RESPONSE contentsInfoPostImgRes$RESPONSE0 = ((ContentsInfoPostImgRes)object0).response;
                    s4 = contentsInfoPostImgRes$RESPONSE0 == null ? null : contentsInfoPostImgRes$RESPONSE0.postImg;
                }
                playable2.setPostImg(s4);
                if(((ContentsInfoPostImgRes)object0) != null) {
                    RESPONSE contentsInfoPostImgRes$RESPONSE1 = ((ContentsInfoPostImgRes)object0).response;
                    if(contentsInfoPostImgRes$RESPONSE1 != null) {
                        s3 = contentsInfoPostImgRes$RESPONSE1.postEditImg;
                    }
                }
                playable2.setPostEditImg(s3);
                playable1 = playable2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.f("", "getSongidString(...)");
        return this.b(playable1, "", snsManager$SnsType0);
    }
}

