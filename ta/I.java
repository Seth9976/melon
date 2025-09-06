package ta;

import com.iloen.melon.MusicWavePreference;
import com.iloen.melon.e;
import ie.H;
import java.util.Collections;
import java.util.List;
import kotlin.coroutines.Continuation;
import we.n;

public final class i extends oe.i implements n {
    public Object r;
    public final String w;

    public i(String s, Continuation continuation0) {
        this.w = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((MusicWavePreference)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MusicWavePreference musicWavePreference0 = (MusicWavePreference)this.r;
        d5.n.D(object0);
        List list0 = Collections.unmodifiableList(((MusicWavePreference)((e)musicWavePreference0.toBuilder()).b).getShownEventsList());
        String s = this.w;
        if(!list0.contains(s)) {
            e e0 = (e)musicWavePreference0.toBuilder();
            e0.d();
            ((MusicWavePreference)e0.b).addShownEvents(s);
            return (MusicWavePreference)e0.a();
        }
        return musicWavePreference0;
    }
}

