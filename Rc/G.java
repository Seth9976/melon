package rc;

import com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE.LOG.MINIPLAYER;
import com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE.LOG;
import com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE.NEXTSONG;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.MusicWaveAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveLogInfoForMiniPlayer;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveNextSongInfo;
import df.v;
import e.k;
import ie.H;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import we.n;

public final class g extends i implements n {
    public Object B;
    public final MusicWaveAddRequestPlayableListInfo D;
    public final m E;
    public rc.n r;
    public int w;

    public g(MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0, Continuation continuation0, m m0) {
        this.D = musicWaveAddRequestPlayableListInfo0;
        this.E = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g(this.D, continuation0, this.E);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((rc.n)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s2;
        String s1;
        Object object1;
        rc.n n0 = (rc.n)this.B;
        a a0 = a.a;
        String s = null;
        MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                Playable playable0 = (Playable)p.k0(musicWaveAddRequestPlayableListInfo0.getUserRequestedPlaylist());
                playable0.setCreatedAt(System.currentTimeMillis());
                this.E.e = musicWaveAddRequestPlayableListInfo0.getTimePos();
                List list0 = k.z(playable0);
                this.B = null;
                this.r = n0;
                this.w = 1;
                object1 = v.k(list0, this.E.f, this);
                if(object1 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n0 = this.r;
                d5.n.D(object0);
                object1 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        MusicWaveChannelInfo musicWaveChannelInfo0 = musicWaveAddRequestPlayableListInfo0.getChannelInfo();
        NEXTSONG musicWavePlayInfoRes$RESPONSE$NEXTSONG0 = musicWaveAddRequestPlayableListInfo0.getNextSongResponse();
        MusicWaveNextSongInfo musicWaveNextSongInfo0 = new MusicWaveNextSongInfo((musicWavePlayInfoRes$RESPONSE$NEXTSONG0 == null ? null : musicWavePlayInfoRes$RESPONSE$NEXTSONG0.songId), (musicWavePlayInfoRes$RESPONSE$NEXTSONG0 == null ? null : musicWavePlayInfoRes$RESPONSE$NEXTSONG0.songName), (musicWavePlayInfoRes$RESPONSE$NEXTSONG0 == null ? null : musicWavePlayInfoRes$RESPONSE$NEXTSONG0.artistName), (musicWavePlayInfoRes$RESPONSE$NEXTSONG0 == null ? null : musicWavePlayInfoRes$RESPONSE$NEXTSONG0.imgUrl), (musicWavePlayInfoRes$RESPONSE$NEXTSONG0 == null ? null : musicWavePlayInfoRes$RESPONSE$NEXTSONG0.cType));
        LOG musicWavePlayInfoRes$RESPONSE$LOG0 = musicWaveAddRequestPlayableListInfo0.getLogResponse();
        if(musicWavePlayInfoRes$RESPONSE$LOG0 == null) {
            s1 = null;
        }
        else {
            MINIPLAYER musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER0 = musicWavePlayInfoRes$RESPONSE$LOG0.miniplayer;
            s1 = musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER0 == null ? null : musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER0.key;
        }
        if(musicWavePlayInfoRes$RESPONSE$LOG0 == null) {
            s2 = null;
        }
        else {
            MINIPLAYER musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER1 = musicWavePlayInfoRes$RESPONSE$LOG0.miniplayer;
            s2 = musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER1 == null ? null : musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER1.title;
        }
        if(musicWavePlayInfoRes$RESPONSE$LOG0 != null) {
            MINIPLAYER musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER2 = musicWavePlayInfoRes$RESPONSE$LOG0.miniplayer;
            if(musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER2 != null) {
                s = musicWavePlayInfoRes$RESPONSE$LOG$MINIPLAYER2.menuId;
            }
        }
        MusicWaveLogInfoForMiniPlayer musicWaveLogInfoForMiniPlayer0 = new MusicWaveLogInfoForMiniPlayer(s1, s2, s);
        n0.getClass();
        q.g(((List)object1), "playableDataList");
        return new rc.n(((List)object1), 0, musicWaveChannelInfo0, musicWaveNextSongInfo0, musicWaveLogInfoForMiniPlayer0);
    }
}

