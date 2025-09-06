package kc;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.error.MelonDebugUtils;
import com.melon.playlist.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.i;
import we.n;

public final class l extends i implements n {
    public int B;
    public int D;
    public final Mutex E;
    public final PlaylistId G;
    public final b I;
    public Mutex r;
    public Object w;

    public l(Mutex mutex0, Continuation continuation0, PlaylistId playlistId0, b b0) {
        this.E = mutex0;
        this.G = playlistId0;
        this.I = b0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.E, continuation0, this.G, this.I);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Throwable throwable1;
        Object object4;
        Mutex mutex2;
        Boolean boolean1;
        int v;
        Object object1;
        Mutex mutex0;
        PlaylistId playlistId0 = this.G;
        a a0 = a.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                mutex0 = this.E;
                this.r = mutex0;
                object1 = null;
                this.w = null;
                v = 0;
                this.B = 0;
                this.D = 1;
                if(mutex0.lock(null, this) == a0) {
                    return a0;
                }
                goto label_21;
            }
            case 1: {
                int v1 = this.B;
                Object object2 = this.w;
                Mutex mutex1 = this.r;
                d5.n.D(object0);
                mutex0 = mutex1;
                v = v1;
                object1 = object2;
                try {
                label_21:
                    boolean z = playlistId0.isDeprecated();
                    b b0 = this.I;
                    if(z) {
                        LogU.error$default(b0.l, "changePlaylist failed. - cannot change to deprecated playlist " + playlistId0, null, false, 6, null);
                        boolean1 = Boolean.FALSE;
                    }
                    else {
                        Boolean boolean0 = (Boolean)b0.r.getValue();
                        if(boolean0 == null) {
                            MelonDebugUtils.INSTANCE.errorLogOrException(b0.l, "changePlaylist failed. - isUseSmartPlaylist is null");
                            boolean1 = Boolean.FALSE;
                        }
                        else if(boolean0.booleanValue() && playlistId0 == PlaylistId.MUSIC) {
                            LogU.error$default(b0.l, "changePlaylist failed. - cannot change to music playlist when smart on", null, false, 6, null);
                            boolean1 = Boolean.FALSE;
                        }
                        else if(!boolean0.booleanValue() && playlistId0 == PlaylistId.SMART) {
                            LogU.error$default(b0.l, "changePlaylist failed. - cannot change to smart playlist when smart off", null, false, 6, null);
                            boolean1 = Boolean.FALSE;
                        }
                        else {
                            this.r = mutex0;
                            this.w = object1;
                            this.B = v;
                            this.D = 2;
                            Object object3 = b.b(b0, playlistId0, this);
                            if(object3 == a0) {
                                return a0;
                            }
                            mutex2 = mutex0;
                            object0 = object3;
                            object4 = object1;
                            boolean1 = object0;
                            object1 = object4;
                            mutex0 = mutex2;
                            break;
                        }
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    throwable1 = throwable0;
                    object4 = object1;
                    mutex2.unlock(object4);
                    throw throwable1;
                }
            }
            case 2: {
                try {
                    object4 = this.w;
                    mutex2 = this.r;
                    d5.n.D(object0);
                    boolean1 = object0;
                    object1 = object4;
                    mutex0 = mutex2;
                    break;
                }
                catch(Throwable throwable2) {
                    throwable1 = throwable2;
                }
                mutex2.unlock(object4);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex0.unlock(object1);
        return boolean1;
    }
}

