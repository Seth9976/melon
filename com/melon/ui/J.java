package com.melon.ui;

import U4.x;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import jd.k0;
import kotlin.jvm.internal.q;

public final class j implements f {
    public final MusicWaveChannelInfo a;
    public final String b;
    public final k0 c;
    public boolean d;

    public j(MusicWaveChannelInfo musicWaveChannelInfo0, String s, k0 k00) {
        q.g(s, "menuId");
        super();
        this.a = musicWaveChannelInfo0;
        this.b = s;
        this.c = k00;
        this.d = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.d = true;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j && this.a.equals(((j)object0).a) && q.b(this.b, ((j)object0).b) && this.c.equals(((j)object0).c) && this.d == ((j)object0).d;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.d) + (this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlayMusicWave(channelInfoData=" + this.a + ", menuId=" + this.b + ", onSuccessAction=" + this.c + ", isAllowBanContent=" + this.d + ")";
    }
}

