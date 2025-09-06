package zd;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.types.StringIds;
import kotlin.jvm.internal.q;

public abstract class o0 extends m {
    public boolean A() {
        return !(this instanceof p0);
    }

    // 去混淆评级： 低(35)
    @Override  // zd.m
    public boolean h() {
        Playable playable0 = this.y();
        boolean z = playable0.isMelonSong() && playable0.hasSongId();
        boolean z1 = !playable0.isOriginMelon() || !z;
        return !playable0.isOriginMelon() && z;
    }

    // 去混淆评级： 低(23)
    @Override  // zd.m
    public boolean i() {
        Playable playable0 = this.y();
        boolean z = playable0.isMelonSong() && playable0.hasSongId();
        return playable0.isOriginMelon() && z && StringIds.a(playable0.getArtistid(), StringIds.e) || !playable0.isOriginMelon() && z;
    }

    @Override  // zd.m
    public boolean j() {
        Playable playable0 = this.y();
        if(playable0.isMelonSong()) {
            return this.y().isTypeOfMv() ? playable0.hasMv() : playable0.hasSongId();
        }
        return false;
    }

    @Override  // zd.m
    public boolean k() {
        return PlayableExtensionsKt.isMvEnabled(this.y());
    }

    @Override  // zd.m
    public boolean l() {
        Playable playable0 = this.y();
        if(playable0.isMelonSong()) {
            return this.y().isTypeOfMv() ? playable0.hasMv() : playable0.hasSongId();
        }
        return false;
    }

    @Override  // zd.m
    public boolean n() {
        return !(this instanceof B0);
    }

    @Override  // zd.m
    public boolean o() {
        Playable playable0 = this.y();
        return playable0.isMelonSong() && playable0.hasSongId();
    }

    @Override  // zd.m
    public String q() {
        String s = this.y().getArtistNames();
        q.f(s, "getArtistNames(...)");
        return s;
    }

    @Override  // zd.m
    public Object s() {
        return this.y().getAlbumImgThumb();
    }

    public abstract Playable y();

    // 去混淆评级： 低(30)
    public boolean z() {
        return this.o() && !this.y().isAdult() && this.y().isService();
    }
}

