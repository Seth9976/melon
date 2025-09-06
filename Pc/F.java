package pc;

import com.iloen.melon.playback.playlist.db.entity.MixUpEntity;
import com.iloen.melon.playback.playlist.db.entity.PlayableEntityKt;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final q r;

    public f(q q0, Continuation continuation0) {
        this.r = q0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Iterable iterable0 = this.r.a.getAllMixUpEntities();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object1: iterable0) {
            arrayList0.add(PlayableEntityKt.convertToPlayable(((MixUpEntity)object1).getPlayableEntity(), ((MixUpEntity)object1).getTrackId()));
        }
        return arrayList0;
    }
}

