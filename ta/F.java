package ta;

import com.melon.data.musicwave.MusicWaveLocalDataSourceImpl;
import oe.c;

public final class f extends c {
    public final MusicWaveLocalDataSourceImpl B;
    public int D;
    public String r;
    public Object w;

    public f(MusicWaveLocalDataSourceImpl musicWaveLocalDataSourceImpl0, c c0) {
        this.B = musicWaveLocalDataSourceImpl0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.e(null, this);
    }
}

