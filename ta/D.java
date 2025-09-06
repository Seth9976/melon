package ta;

import com.melon.data.musicwave.MusicWaveLocalDataSourceImpl;
import oe.c;

public final class d extends c {
    public int B;
    public Object r;
    public final MusicWaveLocalDataSourceImpl w;

    public d(MusicWaveLocalDataSourceImpl musicWaveLocalDataSourceImpl0, c c0) {
        this.w = musicWaveLocalDataSourceImpl0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(this);
    }
}

