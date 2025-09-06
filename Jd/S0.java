package jd;

import com.iloen.melon.playback.playlist.musicwave.MusicWaveNextSongInfo;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import we.n;

public final class s0 extends i implements n {
    public final ProducerScope B;
    public int r;
    public Object w;

    public s0(ProducerScope producerScope0, Continuation continuation0) {
        this.B = producerScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new s0(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s0)this.create(((MusicWaveNextSongInfo)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MusicWaveNextSongInfo musicWaveNextSongInfo0 = (MusicWaveNextSongInfo)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.w = null;
                this.r = 1;
                return this.B.send(musicWaveNextSongInfo0, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

