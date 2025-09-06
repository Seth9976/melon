package pc;

import Ba.y;
import Ma.l;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.MixupPlayResponseBase;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import je.p;
import je.q;
import je.w;
import k8.Y;
import k8.o;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import ne.a;
import oe.i;
import we.n;

public final class m1 extends i implements n {
    public MixupPlayResponseBase B;
    public ArrayList D;
    public ArrayList E;
    public Iterator G;
    public int I;
    public int M;
    public final n1 N;
    public final String S;
    public List r;
    public List w;

    public m1(n1 n10, String s, Continuation continuation0) {
        this.N = n10;
        this.S = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m1(this.N, this.S, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list2;
        Object object1;
        List list1;
        MixupPlayResponseBase mixupPlayResponseBase0;
        ArrayList arrayList1;
        ArrayList arrayList0;
        Iterator iterator0;
        int v;
        ArrayList arrayList2;
        List list5;
        List list4;
        MixupPlayResponseBase mixupPlayResponseBase1;
        Object object2;
        List list7;
        List list6;
        Object object3;
        ArrayList arrayList7;
        n1 n10 = this.N;
        StatsElementsBase statsElementsBase0 = n10.d;
        a a0 = a.a;
        w w0 = w.a;
    alab1:
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList3 = new ArrayList();
                for(Object object4: n10.c) {
                    if(((Playable)object4).isMelonSong() && ((Playable)object4).hasSongId()) {
                        arrayList3.add(object4);
                    }
                }
                if(arrayList3.isEmpty()) {
                    return new c1(null, null, w0, null, false);
                }
                if(n10.e) {
                    ArrayList arrayList4 = new ArrayList(q.Q(10, arrayList3));
                    for(Object object5: arrayList3) {
                        arrayList4.add(PlayableExtensionsKt.copyAndUpdateStreaming(((Playable)object5)));
                    }
                    arrayList3 = arrayList4;
                }
                this.M = 1;
                object3 = n10.a(arrayList3, this);
                if(object3 != a0) {
                label_53:
                    if(((List)object3).isEmpty()) {
                        w1.n();
                        return null;
                    }
                    List list8 = p.K0(1000, ((List)object3));
                    y y0 = ((o)(((l)Y.f(MelonAppBase.Companion, l.class)))).g();
                    String s = w1.e(list8);
                    this.r = (List)object3;
                    this.w = list8;
                    this.M = 2;
                    object2 = y.d(y0, s, this);
                    if(object2 != a0) {
                        list7 = (List)object3;
                        list6 = list8;
                    label_66:
                        MixupPlayResponseBase mixupPlayResponseBase2 = (MixupPlayResponseBase)ApiResultKt.getOrNull(((ApiResult)object2));
                        if(mixupPlayResponseBase2 == null) {
                            return null;
                        }
                        if(w1.m(mixupPlayResponseBase2.error)) {
                            w1.n();
                            return null;
                        }
                        if(w1.l(mixupPlayResponseBase2.error)) {
                            return new c1(null, null, w0, null, false);
                        }
                        String s1 = StatsElementsBase.toJsonString(StatsElementsBase.mergeStatsElements(statsElementsBase0, mixupPlayResponseBase2.result.playlist.statsElements));
                        for(Object object6: list6) {
                            ((Playable)object6).setStatsElements(s1);
                        }
                        Iterable iterable0 = p.L0(30, list6);
                        ArrayList arrayList5 = new ArrayList(q.Q(10, iterable0));
                        Iterator iterator4 = iterable0.iterator();
                        while(iterator4.hasNext()) {
                            iterator4.next();
                            arrayList5.add("");
                        }
                        Set set0 = p.T0(arrayList5);
                        List list9 = mixupPlayResponseBase2.result.waitingList.songIdList;
                        kotlin.jvm.internal.q.f(list9, "songIdList");
                        ArrayList arrayList6 = new ArrayList();
                        for(Object object7: list9) {
                            if(!set0.contains(((String)object7))) {
                                arrayList6.add(object7);
                            }
                        }
                        this.r = list7;
                        this.w = list6;
                        this.B = mixupPlayResponseBase2;
                        this.M = 3;
                        arrayList2 = n10.k(arrayList6, this);
                        if(arrayList2 != a0) {
                            list5 = list6;
                            mixupPlayResponseBase1 = mixupPlayResponseBase2;
                            list4 = list7;
                        label_106:
                            arrayList1 = arrayList2;
                            list1 = list4;
                            arrayList0 = new ArrayList();
                            mixupPlayResponseBase0 = mixupPlayResponseBase1;
                            list2 = list5;
                            v = 0;
                            iterator0 = arrayList2.iterator();
                            while(iterator0.hasNext()) {
                                Object object8 = iterator0.next();
                                this.r = list1;
                                this.w = list2;
                                this.B = mixupPlayResponseBase0;
                                this.D = arrayList1;
                                this.E = arrayList0;
                                this.G = iterator0;
                                this.I = v;
                                this.M = 4;
                                object1 = ((Deferred)object8).await(this);
                                if(object1 == a0) {
                                    break alab1;
                                }
                            label_125:
                                if(((StreamGetSongInfoRes)object1) == null) {
                                    arrayList7 = null;
                                }
                                else {
                                    RESPONSE streamGetSongInfoRes$RESPONSE0 = ((StreamGetSongInfoRes)object1).response;
                                    if(streamGetSongInfoRes$RESPONSE0 != null) {
                                        arrayList7 = streamGetSongInfoRes$RESPONSE0.contentsInfo;
                                    }
                                }
                                if(arrayList7 != null) {
                                    arrayList0.addAll(((StreamGetSongInfoRes)object1).response.contentsInfo);
                                }
                            }
                            if(!arrayList1.isEmpty()) {
                                StatsElementsBase statsElementsBase1 = StatsElementsBase.mergeStatsElements(statsElementsBase0, mixupPlayResponseBase0.result.waitingList.statsElements);
                                w0 = Playable.makeList(arrayList0, this.S, null, statsElementsBase1);
                            }
                            if(list2.size() == 1) {
                                n10.f = true;
                            }
                            LogU.Companion.d("MixUpType", "getMixUpPlayableInfo(), seedPlayableList size : " + list2.size());
                            kotlin.jvm.internal.q.d(w0);
                            ArrayList arrayList8 = new ArrayList();
                            for(Object object9: w0) {
                                if(((Playable)object9).isService()) {
                                    arrayList8.add(object9);
                                }
                            }
                            String s2 = mixupPlayResponseBase0.result.title;
                            String s3 = mixupPlayResponseBase0.result.subtitle;
                            return list1.size() <= 1000 ? new c1(s2, s3, list2, arrayList8, false) : new c1(s2, s3, list2, arrayList8, true);
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                object3 = object0;
                goto label_53;
            }
            case 2: {
                list6 = this.w;
                list7 = this.r;
                d5.n.D(object0);
                object2 = object0;
                goto label_66;
            }
            case 3: {
                mixupPlayResponseBase1 = this.B;
                List list3 = this.w;
                list4 = this.r;
                d5.n.D(object0);
                list5 = list3;
                arrayList2 = object0;
                goto label_106;
            }
            case 4: {
                v = this.I;
                iterator0 = this.G;
                arrayList0 = this.E;
                arrayList1 = this.D;
                mixupPlayResponseBase0 = this.B;
                List list0 = this.w;
                list1 = this.r;
                d5.n.D(object0);
                object1 = object0;
                list2 = list0;
                goto label_125;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

