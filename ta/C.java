package ta;

import com.melon.data.musicwave.MusicWaveLocalDataSourceImpl;

public final class c extends oe.c {
    public int B;
    public Object r;
    public final MusicWaveLocalDataSourceImpl w;

    public c(MusicWaveLocalDataSourceImpl musicWaveLocalDataSourceImpl0, oe.c c0) {
        this.w = musicWaveLocalDataSourceImpl0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.b(this);
    }
}

