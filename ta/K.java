package ta;

import com.iloen.melon.MusicWavePreference.MusicWaveTempChannel;
import com.iloen.melon.MusicWavePreference;
import com.iloen.melon.e;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class k extends i implements n {
    public Object r;
    public final MusicWaveTempChannel w;

    public k(MusicWaveTempChannel musicWavePreference$MusicWaveTempChannel0, Continuation continuation0) {
        this.w = musicWavePreference$MusicWaveTempChannel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((MusicWavePreference)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MusicWavePreference musicWavePreference0 = (MusicWavePreference)this.r;
        d5.n.D(object0);
        e e0 = (e)musicWavePreference0.toBuilder();
        e0.d();
        ((MusicWavePreference)e0.b).setTempChannel(this.w);
        return e0.a();
    }
}

