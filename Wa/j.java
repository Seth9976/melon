package Wa;

import Ua.h;
import com.iloen.melon.custom.S0;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistScrapListSongRes;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE.SONGLIST;
import com.iloen.melon.playback.Playable;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public int B;
    public Object D;
    public final h E;
    public final String G;
    public final String I;
    public MyMusicPlaylistScrapListSongRes r;
    public FlowCollector w;

    public j(h h0, String s, String s1, Continuation continuation0) {
        this.E = h0;
        this.G = s;
        this.I = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j(this.E, this.G, this.I, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MyMusicPlaylistScrapListSongRes myMusicPlaylistScrapListSongRes0;
        FlowCollector flowCollector0 = (FlowCollector)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                this.D = flowCollector0;
                this.B = 1;
                object0 = ((S0)this.E.a).a0(this.G, this);
                if(object0 != a0) {
                label_19:
                    myMusicPlaylistScrapListSongRes0 = (MyMusicPlaylistScrapListSongRes)object0;
                    l l0 = new l(myMusicPlaylistScrapListSongRes0.notification);
                    this.D = flowCollector0;
                    this.r = myMusicPlaylistScrapListSongRes0;
                    this.B = 2;
                    if(flowCollector0.emit(l0, this) != a0) {
                    label_25:
                        if(!Cb.j.d(myMusicPlaylistScrapListSongRes0) || myMusicPlaylistScrapListSongRes0.response == null) {
                            return H.a;
                        }
                        ArrayList arrayList0 = new ArrayList();
                        ArrayList arrayList1 = myMusicPlaylistScrapListSongRes0.response.songList;
                        if(arrayList1 != null && arrayList1.size() >= 1) {
                            Iterator iterator0 = arrayList1.iterator();
                            q.f(iterator0, "iterator(...)");
                            while(iterator0.hasNext()) {
                                Object object1 = iterator0.next();
                                SONGLIST playlistListSongBaseRes$RESPONSE$SONGLIST0 = (SONGLIST)object1;
                                if(playlistListSongBaseRes$RESPONSE$SONGLIST0.canService) {
                                    Playable playable0 = Playable.from(playlistListSongBaseRes$RESPONSE$SONGLIST0, this.I, null);
                                    q.f(playable0, "from(...)");
                                    arrayList0.add(playable0);
                                }
                            }
                        }
                        this.D = null;
                        this.r = null;
                        this.w = flowCollector0;
                        this.B = 3;
                        object0 = FlowKt.flow(new k(arrayList0, null));
                        if(object0 != a0) {
                        label_45:
                            this.D = null;
                            this.r = null;
                            this.w = null;
                            this.B = 4;
                            if(FlowKt.emitAll(flowCollector0, ((Flow)object0), this) != a0) {
                                return H.a;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                goto label_19;
            }
            case 2: {
                myMusicPlaylistScrapListSongRes0 = this.r;
                d5.n.D(object0);
                goto label_25;
            }
            case 3: {
                flowCollector0 = this.w;
                d5.n.D(object0);
                goto label_45;
            }
            case 4: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

