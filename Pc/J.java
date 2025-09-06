package pc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.db.MixUpPlaylistDao;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public final List B;
    public final Collection D;
    public final List E;
    public int r;
    public final q w;

    public j(q q0, List list0, Collection collection0, List list1, Continuation continuation0) {
        this.w = q0;
        this.B = list0;
        this.D = collection0;
        this.E = list1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                MixUpPlaylistDao mixUpPlaylistDao0 = this.w.a;
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.D));
                for(Object object1: this.D) {
                    arrayList0.add(PlayableExtensionsKt.toMixUpEntity(((Playable)object1)));
                }
                this.r = 1;
                return mixUpPlaylistDao0.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(this.B, arrayList0, this.E, this) == a0 ? a0 : H.a;
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

