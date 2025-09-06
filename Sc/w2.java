package sc;

import com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class w2 extends i implements n {
    public int r;
    public final S2 w;

    public w2(S2 s20, Continuation continuation0) {
        this.w = s20;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w2(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                H h1 = SmartPlaylistServerSyncPreferencesRepository.INSTANCE.clearAndIncrementNotSentEditCount("enqueue SyncByServerDataFromUserSelectPopup", this);
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

