package rc;

import com.iloen.melon.playback.playlist.add.MusicWaveAddRequestPlayableListInfo;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import va.e0;
import va.o;
import we.n;

public final class h extends i implements n {
    public final MusicWaveAddRequestPlayableListInfo B;
    public int r;
    public final m w;

    public h(MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0, Continuation continuation0, m m0) {
        this.w = m0;
        this.B = musicWaveAddRequestPlayableListInfo0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.B, continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0 = this.B;
        m m0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                g g0 = new g(musicWaveAddRequestPlayableListInfo0, null, m0);
                this.r = 1;
                object0 = m0.j(g0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        rc.n n0 = (rc.n)object0;
        String s = u.w(((e0)o.a()).j());
        m0.a.enterMusicWaveChannel(s, musicWaveAddRequestPlayableListInfo0.getChannelInfo().getId(), musicWaveAddRequestPlayableListInfo0.getChannelInfo().getType(), musicWaveAddRequestPlayableListInfo0.getSongId());
        return object0;
    }
}

