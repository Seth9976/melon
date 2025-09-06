package rc;

import A7.d;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveLogInfoForMiniPlayer;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveNextSongInfo;
import java.util.List;
import kotlin.jvm.internal.q;
import oc.Q;

public final class n implements Q {
    public final List a;
    public final int b;
    public final MusicWaveChannelInfo c;
    public final MusicWaveNextSongInfo d;
    public final MusicWaveLogInfoForMiniPlayer e;

    public n(List list0, int v, MusicWaveChannelInfo musicWaveChannelInfo0, MusicWaveNextSongInfo musicWaveNextSongInfo0, MusicWaveLogInfoForMiniPlayer musicWaveLogInfoForMiniPlayer0) {
        q.g(list0, "playableDataList");
        super();
        this.a = list0;
        this.b = v;
        this.c = musicWaveChannelInfo0;
        this.d = musicWaveNextSongInfo0;
        this.e = musicWaveLogInfoForMiniPlayer0;
    }

    @Override  // oc.Q
    public final int b() {
        return this.b;
    }

    @Override  // oc.Q
    public final List c() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof n)) {
            return false;
        }
        if(!q.b(this.a, ((n)object0).a)) {
            return false;
        }
        if(this.b != ((n)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((n)object0).c)) {
            return false;
        }
        return q.b(this.d, ((n)object0).d) ? q.b(this.e, ((n)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
        int v1 = 0;
        int v2 = this.c == null ? 0 : this.c.hashCode();
        int v3 = this.d == null ? 0 : this.d.hashCode();
        MusicWaveLogInfoForMiniPlayer musicWaveLogInfoForMiniPlayer0 = this.e;
        if(musicWaveLogInfoForMiniPlayer0 != null) {
            v1 = musicWaveLogInfoForMiniPlayer0.hashCode();
        }
        return ((v + v2) * 0x1F + v3) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        return "MusicWavePlaylistState(playableDataList=" + this.a + ", currentIndex=" + this.b + ", channelInfo=" + this.c + ", nextSongInfo=" + this.d + ", logInfo=" + this.e + ")";
    }
}

