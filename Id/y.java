package id;

import U4.x;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.SearchInformSongWithPianoforteRes.RESPONSE.SONGINFO;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.entity.MusicSearchHistoryEntity;
import i.n.i.b.a.s.e.Ga;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class y extends i implements n {
    public final B B;
    public int r;
    public final A w;

    public y(A a0, B b0, Continuation continuation0) {
        this.w = a0;
        this.B = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        A a1 = this.w;
        boolean z = true;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = a1.a.n(this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_13;
            }
            case 1: {
                d5.n.D(object0);
            label_13:
                if(((Number)object0).intValue() >= 100) {
                    this.r = 2;
                    object0 = a1.a.d(this);
                    if(object0 == a0) {
                        return a0;
                    }
                    LogU.debug$default(a1.b, x.e(((Number)object0).intValue(), "deleteOldestSongResult : "), null, false, 6, null);
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                LogU.debug$default(a1.b, x.e(((Number)object0).intValue(), "deleteOldestSongResult : "), null, false, 6, null);
                break;
            }
            case 3: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Ga ga0 = a1.a;
        MusicSearchHistoryEntity musicSearchHistoryEntity0 = new MusicSearchHistoryEntity();
        B b0 = this.B;
        String s = null;
        String s1 = b0.b == null ? null : b0.b.songId;
        String s2 = "";
        if(s1 == null) {
            s1 = "";
        }
        musicSearchHistoryEntity0.setSongId(s1);
        String s3 = b0.b == null ? null : b0.b.songName;
        if(s3 == null) {
            s3 = "";
        }
        musicSearchHistoryEntity0.setSongName(s3);
        String s4 = b0.b == null ? null : b0.b.albumId;
        if(s4 == null) {
            s4 = "";
        }
        musicSearchHistoryEntity0.setAlbumId(s4);
        String s5 = b0.b == null ? null : b0.b.albumName;
        if(s5 == null) {
            s5 = "";
        }
        musicSearchHistoryEntity0.setAlbumName(s5);
        String s6 = b0.b == null ? null : b0.b.albumImg;
        if(s6 == null) {
            s6 = "";
        }
        musicSearchHistoryEntity0.setAlbumImgPath(s6);
        q.f("", "toString(...)");
        musicSearchHistoryEntity0.setArtistId("");
        String s7 = ProtocolUtils.getArtistNames((b0.b == null ? null : b0.b.artistList));
        if(s7 == null) {
            s7 = "";
        }
        musicSearchHistoryEntity0.setArtistName(s7);
        musicSearchHistoryEntity0.setService(b0.b != null && b0.b.canService);
        if(b0.b == null || !b0.b.isAdult) {
            z = false;
        }
        musicSearchHistoryEntity0.setAdult(z);
        SONGINFO searchInformSongWithPianoforteRes$RESPONSE$SONGINFO0 = b0.b;
        if(searchInformSongWithPianoforteRes$RESPONSE$SONGINFO0 != null) {
            s = searchInformSongWithPianoforteRes$RESPONSE$SONGINFO0.playTime;
        }
        if(s != null) {
            s2 = s;
        }
        musicSearchHistoryEntity0.setPlayTime(s2);
        q.f("1", "getValue(...)");
        musicSearchHistoryEntity0.setCType("1");
        musicSearchHistoryEntity0.setTimestamp(System.currentTimeMillis());
        this.r = 3;
        Object object1 = ga0.o(musicSearchHistoryEntity0, this);
        return object1 == a0 ? a0 : object1;
    }
}

