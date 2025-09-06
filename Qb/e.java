package qb;

import Cb.j;
import bb.g;
import bb.m;
import bb.o;
import com.iloen.melon.net.v4x.response.ArtistListArtistInfoRes.RESPONSE.ARTISTLIST;
import com.iloen.melon.net.v4x.response.ArtistListArtistInfoRes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.D;
import je.q;
import je.x;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.n;
import x9.c;

public final class e extends i implements n {
    public int B;
    public Object D;
    public final o E;
    public final H G;
    public final String I;
    public final c M;
    public List r;
    public ArtistListArtistInfoRes w;

    public e(o o0, H h0, String s, c c0, Continuation continuation0) {
        this.E = o0;
        this.G = h0;
        this.I = s;
        this.M = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.E, this.G, this.I, this.M, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        ArtistListArtistInfoRes artistListArtistInfoRes0;
        Serializable serializable0;
        List list1;
        x x1;
        FlowCollector flowCollector0 = (FlowCollector)this.D;
        a a0 = a.a;
        x x0 = x.a;
        int v = 16;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                o o0 = this.E;
                if(o0 instanceof m) {
                    Iterable iterable0 = ((m)o0).a;
                    int v1 = D.N(q.Q(10, iterable0));
                    if(v1 < 16) {
                        v1 = 16;
                    }
                    x1 = new LinkedHashMap(v1);
                    for(Object object1: iterable0) {
                        x1.put(((g)object1).a, Boolean.valueOf(((g)object1).b));
                    }
                }
                else {
                    x1 = x0;
                }
                Iterable iterable1 = (Iterable)this.G.a;
                ArrayList arrayList0 = new ArrayList(q.Q(10, iterable1));
                for(Object object2: iterable1) {
                    Boolean boolean0 = (Boolean)x1.get(((qb.a)object2).b);
                    arrayList0.add(qb.a.a(((qb.a)object2), null, (boolean0 == null ? false : boolean0.booleanValue()), 0x6F));
                }
                Na.e e0 = new Na.e(new b(arrayList0));
                this.D = flowCollector0;
                this.r = arrayList0;
                this.B = 1;
                if(flowCollector0.emit(e0, this) != a0) {
                    list1 = arrayList0;
                label_48:
                    String s = this.I;
                    if(s.length() <= 0) {
                        return ie.H.a;
                    }
                    this.D = flowCollector0;
                    this.r = list1;
                    this.B = 2;
                    serializable0 = ((V9.c)this.M.b).a(s, this);
                    if(serializable0 != a0) {
                    label_55:
                        Na.e e1 = new Na.e(new qb.c(((ArtistListArtistInfoRes)serializable0).notification));
                        this.D = flowCollector0;
                        this.r = list1;
                        this.w = (ArtistListArtistInfoRes)serializable0;
                        this.B = 3;
                        if(flowCollector0.emit(e1, this) != a0) {
                            list0 = list1;
                            artistListArtistInfoRes0 = (ArtistListArtistInfoRes)serializable0;
                        label_63:
                            if(!j.d(artistListArtistInfoRes0)) {
                                return ie.H.a;
                            }
                            ArrayList arrayList1 = artistListArtistInfoRes0.response == null ? null : artistListArtistInfoRes0.response.artistList;
                            if(arrayList1 != null && !arrayList1.isEmpty()) {
                                ArrayList arrayList2 = artistListArtistInfoRes0.response.artistList;
                                kotlin.jvm.internal.q.f(arrayList2, "artistList");
                                int v2 = D.N(q.Q(10, arrayList2));
                                if(v2 >= 16) {
                                    v = v2;
                                }
                                x0 = new LinkedHashMap(v);
                                for(Object object3: arrayList2) {
                                    x0.put(((ARTISTLIST)object3).getArtistId(), object3);
                                }
                            }
                            ArrayList arrayList3 = new ArrayList(q.Q(10, list0));
                            for(Object object4: list0) {
                                ARTISTLIST artistListArtistInfoRes$RESPONSE$ARTISTLIST0 = (ARTISTLIST)x0.get(((qb.a)object4).b);
                                arrayList3.add(qb.a.a(((qb.a)object4), (artistListArtistInfoRes$RESPONSE$ARTISTLIST0 == null ? null : artistListArtistInfoRes$RESPONSE$ARTISTLIST0.getArtistImg()), false, 0x77));
                            }
                            Na.e e2 = new Na.e(new b(arrayList3));
                            this.D = null;
                            this.r = null;
                            this.w = null;
                            this.B = 4;
                            if(flowCollector0.emit(e2, this) != a0) {
                                return ie.H.a;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                list1 = this.r;
                d5.n.D(object0);
                goto label_48;
            }
            case 2: {
                list1 = this.r;
                d5.n.D(object0);
                serializable0 = object0;
                goto label_55;
            }
            case 3: {
                artistListArtistInfoRes0 = this.w;
                list0 = this.r;
                d5.n.D(object0);
                goto label_63;
            }
            case 4: {
                d5.n.D(object0);
                return ie.H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

