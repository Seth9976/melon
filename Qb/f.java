package qb;

import Cb.j;
import Na.e;
import com.iloen.melon.net.v4x.response.ArtistListArtistInfoRes.RESPONSE.ARTISTLIST;
import com.iloen.melon.net.v4x.response.ArtistListArtistInfoRes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.D;
import je.x;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.n;
import x9.c;

public final class f extends i implements n {
    public int B;
    public Object D;
    public final H E;
    public final String G;
    public final c I;
    public List r;
    public ArtistListArtistInfoRes w;

    public f(String s, Continuation continuation0, H h0, c c0) {
        this.E = h0;
        this.G = s;
        this.I = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.G, continuation0, this.E, this.I);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        ArtistListArtistInfoRes artistListArtistInfoRes0;
        x x0;
        FlowCollector flowCollector0 = (FlowCollector)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                List list2 = (List)this.E.a;
                String s = this.G;
                if(s.length() > 0) {
                    this.D = flowCollector0;
                    this.r = list2;
                    this.B = 1;
                    Serializable serializable0 = ((V9.c)this.I.b).a(s, this);
                    if(serializable0 == a0) {
                        return a0;
                    }
                    list0 = list2;
                    object0 = serializable0;
                label_25:
                    artistListArtistInfoRes0 = (ArtistListArtistInfoRes)object0;
                    e e0 = new e(new qb.c(artistListArtistInfoRes0.notification));
                    this.D = flowCollector0;
                    this.r = list0;
                    this.w = artistListArtistInfoRes0;
                    this.B = 2;
                    if(flowCollector0.emit(e0, this) == a0) {
                        return a0;
                    }
                label_32:
                    if(j.d(artistListArtistInfoRes0)) {
                        ArrayList arrayList0 = artistListArtistInfoRes0.response == null ? null : artistListArtistInfoRes0.response.artistList;
                        if(arrayList0 == null || arrayList0.isEmpty()) {
                            x0 = x.a;
                        }
                        else {
                            ArrayList arrayList1 = artistListArtistInfoRes0.response.artistList;
                            q.f(arrayList1, "artistList");
                            int v = D.N(je.q.Q(10, arrayList1));
                            if(v < 16) {
                                v = 16;
                            }
                            x0 = new LinkedHashMap(v);
                            for(Object object1: arrayList1) {
                                x0.put(((ARTISTLIST)object1).getArtistId(), object1);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList(je.q.Q(10, list0));
                        for(Object object2: list0) {
                            ARTISTLIST artistListArtistInfoRes$RESPONSE$ARTISTLIST0 = (ARTISTLIST)x0.get(((qb.a)object2).b);
                            arrayList2.add(qb.a.a(((qb.a)object2), (artistListArtistInfoRes$RESPONSE$ARTISTLIST0 == null ? null : artistListArtistInfoRes$RESPONSE$ARTISTLIST0.getArtistImg()), false, 0x77));
                        }
                        e e1 = new e(new b(arrayList2));
                        this.D = null;
                        this.r = null;
                        this.w = null;
                        this.B = 3;
                        if(flowCollector0.emit(e1, this) == a0) {
                            return a0;
                        }
                    }
                    else {
                        e e2 = new e(new b(list0));
                        this.D = null;
                        this.r = null;
                        this.w = null;
                        this.B = 4;
                        if(flowCollector0.emit(e2, this) == a0) {
                            return a0;
                        }
                    }
                }
                else {
                    e e3 = new e(new b(list2));
                    this.D = null;
                    this.r = null;
                    this.B = 5;
                    if(flowCollector0.emit(e3, this) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                List list1 = this.r;
                d5.n.D(object0);
                list0 = list1;
                goto label_25;
            }
            case 2: {
                artistListArtistInfoRes0 = this.w;
                list0 = this.r;
                d5.n.D(object0);
                goto label_32;
            }
            case 3: 
            case 4: 
            case 5: {
                d5.n.D(object0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ie.H.a;
    }
}

