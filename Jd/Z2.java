package jd;

import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import com.melon.playlist.interfaces.PlayableData;
import kotlin.jvm.internal.q;

public final class z2 {
    public final PlayableData a;
    public final MusicWaveChannelInfo b;

    public z2(PlayableData playableData0, MusicWaveChannelInfo musicWaveChannelInfo0) {
        this.a = playableData0;
        this.b = musicWaveChannelInfo0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z2)) {
            return false;
        }
        return q.b(this.a, ((z2)object0).a) ? q.b(this.b, ((z2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        MusicWaveChannelInfo musicWaveChannelInfo0 = this.b;
        if(musicWaveChannelInfo0 != null) {
            v = musicWaveChannelInfo0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "MusicWavePlayableData(rawPlayableData=" + this.a + ", channelInfoData=" + this.b + ")";
    }
}

