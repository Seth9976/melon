package pc;

import Bd.v;
import Ma.m;
import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.MixUpPlayBase.PlaylistBase;
import com.iloen.melon.net.mcp.response.MixUpPlayBase;
import com.iloen.melon.net.mcp.response.MixupPlayResponseBase.Error;
import com.iloen.melon.net.mcp.response.PlayDjMalrangBase;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.DjMalrangRequestInfo;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d5.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.w;
import k8.Y;
import k8.o;
import kc.H1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ld.j;
import ne.a;
import oe.c;
import oe.i;
import z9.F;

public abstract class w1 {
    public final v1 a;
    public final H1 b;

    public w1() {
        this.a = new v1(CoroutineExceptionHandler.Key);  // 初始化器: Lme/a;-><init>(Lme/h;)V
        this.b = (H1)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).r.get();
    }

    public final Object a(List list0, c c0) {
        Iterator iterator0;
        int v2;
        boolean z;
        int v1;
        Collection collection0;
        F f2;
        Object object1;
        F f0;
        q1 q10;
        if(c0 instanceof q1) {
            q10 = (q1)c0;
            int v = q10.T;
            if((v & 0x80000000) == 0) {
                q10 = new q1(this, c0);
            }
            else {
                q10.T = v ^ 0x80000000;
            }
        }
        else {
            q10 = new q1(this, c0);
        }
        Object object0 = q10.N;
        a a0 = a.a;
    alab1:
        switch(q10.T) {
            case 0: {
                n.D(object0);
                f0 = F.a;
                q10.r = list0;
                q10.w = f0;
                q10.T = 1;
                object1 = f0.j(q10);
                if(object1 != a0) {
                    goto label_27;
                }
                break;
            }
            case 1: {
                F f1 = q10.w;
                List list1 = q10.r;
                n.D(object0);
                f0 = f1;
                list0 = list1;
                object1 = object0;
            label_27:
                if(!((Boolean)object1).booleanValue()) {
                    return list0;
                }
                f2 = f0;
                collection0 = new ArrayList();
                v1 = 0;
                z = true;
                v2 = 0;
                iterator0 = list0.iterator();
                goto label_46;
            }
            case 2: {
                v1 = q10.M;
                v2 = q10.I;
                z = q10.G;
                Object object2 = q10.E;
                iterator0 = q10.D;
                collection0 = q10.B;
                f2 = q10.w;
                n.D(object0);
                while(true) {
                    if(!((Boolean)object0).booleanValue()) {
                        collection0.add(object2);
                    }
                label_46:
                    if(!iterator0.hasNext()) {
                        return (List)collection0;
                    }
                    object2 = iterator0.next();
                    List list2 = StringUtils.tokenizeCsv(((Playable)object2).getArtistIds());
                    q10.r = null;
                    q10.w = f2;
                    q10.B = collection0;
                    q10.D = iterator0;
                    q10.E = object2;
                    q10.G = z;
                    q10.I = v2;
                    q10.M = v1;
                    q10.T = 2;
                    object0 = f2.b(list2, q10);
                    if(object0 != a0) {
                        continue;
                    }
                    break alab1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object b(String s, PlayDjMalrangBase playDjMalrangBase0, StatsElementsBase statsElementsBase0, c c0) {
        ArrayList arrayList32;
        ArrayList arrayList31;
        ArrayList arrayList29;
        ArrayList arrayList28;
        int v9;
        ArrayList arrayList25;
        ArrayList arrayList24;
        String s6;
        ArrayList arrayList23;
        ArrayList arrayList22;
        Iterator iterator3;
        ArrayList arrayList17;
        Object object6;
        ArrayList arrayList16;
        PlayDjMalrangBase playDjMalrangBase5;
        String s5;
        ArrayList arrayList15;
        ArrayList arrayList13;
        ArrayList arrayList12;
        Iterator iterator1;
        int v4;
        ArrayList arrayList8;
        PlaylistBase mixUpPlayBase$PlaylistBase7;
        StatsElementsBase statsElementsBase4;
        String s3;
        PlayDjMalrangBase playDjMalrangBase3;
        PlaylistBase mixUpPlayBase$PlaylistBase6;
        ArrayList arrayList7;
        String s2;
        PlayDjMalrangBase playDjMalrangBase2;
        PlaylistBase mixUpPlayBase$PlaylistBase5;
        ArrayList arrayList6;
        ArrayList arrayList5;
        String s1;
        PlayDjMalrangBase playDjMalrangBase1;
        ArrayList arrayList3;
        PlaylistBase mixUpPlayBase$PlaylistBase3;
        ArrayList arrayList2;
        PlaylistBase mixUpPlayBase$PlaylistBase2;
        StatsElementsBase statsElementsBase1;
        List list5;
        ArrayList arrayList0;
        Collection collection0;
        int v1;
        Integer integer1;
        Integer integer0;
        r1 r10;
        if(c0 instanceof r1) {
            r10 = (r1)c0;
            int v = r10.c0;
            if((v & 0x80000000) == 0) {
                r10 = new r1(this, c0);
            }
            else {
                r10.c0 = v ^ 0x80000000;
            }
        }
        else {
            r10 = new r1(this, c0);
        }
        Object object0 = r10.Z;
        a a0 = a.a;
        w w0 = w.a;
        switch(r10.c0) {
            case 0: {
                n.D(object0);
                PlaylistBase mixUpPlayBase$PlaylistBase0 = playDjMalrangBase0.getPlaylist();
                PlaylistBase mixUpPlayBase$PlaylistBase1 = playDjMalrangBase0.getWaitingList();
                Companion logU$Companion0 = LogU.Companion;
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    integer0 = null;
                }
                else {
                    List list0 = mixUpPlayBase$PlaylistBase0.songIdList;
                    integer0 = list0 == null ? null : new Integer(list0.size());
                }
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    integer1 = null;
                }
                else {
                    List list1 = mixUpPlayBase$PlaylistBase1.songIdList;
                    integer1 = list1 == null ? null : new Integer(list1.size());
                }
                logU$Companion0.d("MixUpType", "getDjMalrangPlayableInfo seedSize = " + integer0 + " waitSize = " + integer1);
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    v1 = 0;
                }
                else {
                    List list2 = mixUpPlayBase$PlaylistBase1.songIdList;
                    v1 = list2 == null ? 0 : list2.size();
                }
                Y.t("getDjMalrangPlayableInfo waitListSize = ", v1, logU$Companion0, "MixUpType");
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    collection0 = w0;
                }
                else {
                    List list3 = mixUpPlayBase$PlaylistBase0.songIdList;
                    collection0 = list3 == null ? w0 : p.T0(p.L0(30, list3));
                }
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    arrayList0 = null;
                }
                else {
                    List list4 = mixUpPlayBase$PlaylistBase1.songIdList;
                    if(list4 == null) {
                        arrayList0 = null;
                    }
                    else {
                        arrayList0 = new ArrayList();
                        for(Object object1: list4) {
                            if(!collection0.contains(((String)object1))) {
                                arrayList0.add(object1);
                            }
                        }
                    }
                }
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    list5 = w0;
                }
                else {
                    list5 = mixUpPlayBase$PlaylistBase0.songIdList;
                    if(list5 == null) {
                        list5 = w0;
                    }
                }
                r10.r = s;
                r10.w = playDjMalrangBase0;
                statsElementsBase1 = statsElementsBase0;
                r10.B = statsElementsBase1;
                r10.D = mixUpPlayBase$PlaylistBase0;
                r10.E = mixUpPlayBase$PlaylistBase1;
                r10.G = arrayList0;
                r10.X = v1;
                r10.c0 = 1;
                ArrayList arrayList1 = this.k(list5, r10);
                if(arrayList1 == a0) {
                    return a0;
                }
                mixUpPlayBase$PlaylistBase2 = mixUpPlayBase$PlaylistBase0;
                arrayList2 = arrayList1;
                mixUpPlayBase$PlaylistBase3 = mixUpPlayBase$PlaylistBase1;
                arrayList3 = arrayList0;
                playDjMalrangBase1 = playDjMalrangBase0;
                s1 = s;
                goto label_102;
            }
            case 1: {
                int v2 = r10.X;
                arrayList3 = r10.G;
                mixUpPlayBase$PlaylistBase3 = r10.E;
                PlaylistBase mixUpPlayBase$PlaylistBase4 = r10.D;
                StatsElementsBase statsElementsBase2 = r10.B;
                playDjMalrangBase1 = r10.w;
                s1 = r10.r;
                n.D(object0);
                statsElementsBase1 = statsElementsBase2;
                mixUpPlayBase$PlaylistBase2 = mixUpPlayBase$PlaylistBase4;
                v1 = v2;
                arrayList2 = object0;
            label_102:
                if(arrayList3 != null) {
                    w0 = arrayList3;
                }
                r10.r = s1;
                r10.w = playDjMalrangBase1;
                r10.B = statsElementsBase1;
                r10.D = mixUpPlayBase$PlaylistBase2;
                r10.E = mixUpPlayBase$PlaylistBase3;
                r10.G = null;
                r10.I = arrayList2;
                r10.X = v1;
                r10.c0 = 2;
                ArrayList arrayList4 = this.k(w0, r10);
                if(arrayList4 == a0) {
                    return a0;
                }
                arrayList5 = arrayList2;
                arrayList6 = arrayList4;
                mixUpPlayBase$PlaylistBase5 = mixUpPlayBase$PlaylistBase2;
                playDjMalrangBase2 = playDjMalrangBase1;
                s2 = s1;
                goto label_132;
            }
            case 2: {
                int v3 = r10.X;
                arrayList5 = r10.I;
                mixUpPlayBase$PlaylistBase3 = r10.E;
                mixUpPlayBase$PlaylistBase5 = r10.D;
                StatsElementsBase statsElementsBase3 = r10.B;
                playDjMalrangBase2 = r10.w;
                s2 = r10.r;
                n.D(object0);
                statsElementsBase1 = statsElementsBase3;
                v1 = v3;
                arrayList6 = object0;
            label_132:
                arrayList7 = new ArrayList();
                mixUpPlayBase$PlaylistBase6 = mixUpPlayBase$PlaylistBase3;
                playDjMalrangBase3 = playDjMalrangBase2;
                s3 = s2;
                statsElementsBase4 = statsElementsBase1;
                mixUpPlayBase$PlaylistBase7 = mixUpPlayBase$PlaylistBase5;
                arrayList8 = arrayList6;
                v4 = 0;
                iterator1 = arrayList5.iterator();
                goto label_174;
            }
            case 3: {
                int v5 = r10.Y;
                int v6 = r10.X;
                iterator1 = (Iterator)r10.S;
                ArrayList arrayList9 = r10.N;
                ArrayList arrayList10 = r10.M;
                ArrayList arrayList11 = r10.I;
                PlaylistBase mixUpPlayBase$PlaylistBase8 = r10.E;
                PlaylistBase mixUpPlayBase$PlaylistBase9 = r10.D;
                StatsElementsBase statsElementsBase5 = r10.B;
                PlayDjMalrangBase playDjMalrangBase4 = r10.w;
                String s4 = r10.r;
                n.D(object0);
                v1 = v6;
                arrayList5 = arrayList11;
                mixUpPlayBase$PlaylistBase6 = mixUpPlayBase$PlaylistBase8;
                statsElementsBase4 = statsElementsBase5;
                mixUpPlayBase$PlaylistBase7 = mixUpPlayBase$PlaylistBase9;
                arrayList7 = arrayList9;
                arrayList8 = arrayList10;
                playDjMalrangBase3 = playDjMalrangBase4;
                s3 = s4;
                int v7 = v5;
                Object object2 = object0;
                while(true) {
                    if(((StreamGetSongInfoRes)object2) == null) {
                        arrayList12 = null;
                    }
                    else {
                        RESPONSE streamGetSongInfoRes$RESPONSE0 = ((StreamGetSongInfoRes)object2).response;
                        if(streamGetSongInfoRes$RESPONSE0 != null) {
                            arrayList12 = streamGetSongInfoRes$RESPONSE0.contentsInfo;
                        }
                    }
                    if(arrayList12 != null) {
                        arrayList7.addAll(((StreamGetSongInfoRes)object2).response.contentsInfo);
                    }
                    v4 = v7;
                label_174:
                    if(!iterator1.hasNext()) {
                        break;
                    }
                    Object object3 = iterator1.next();
                    r10.r = s3;
                    r10.w = playDjMalrangBase3;
                    r10.B = statsElementsBase4;
                    r10.D = mixUpPlayBase$PlaylistBase7;
                    r10.E = mixUpPlayBase$PlaylistBase6;
                    r10.G = null;
                    r10.I = arrayList5;
                    r10.M = arrayList8;
                    r10.N = arrayList7;
                    r10.S = iterator1;
                    r10.T = null;
                    r10.X = v1;
                    r10.Y = v4;
                    r10.c0 = 3;
                    Object object4 = ((Deferred)object3).await(r10);
                    if(object4 == a0) {
                        return a0;
                    }
                    object2 = object4;
                    v7 = v4;
                }
                StatsElementsBase statsElementsBase6 = mixUpPlayBase$PlaylistBase7 == null ? null : mixUpPlayBase$PlaylistBase7.statsElements;
                arrayList13 = new ArrayList();
                if(!arrayList5.isEmpty()) {
                    ArrayList arrayList14 = Playable.makeList(arrayList7, s3, null, StatsElementsBase.mergeStatsElements(statsElementsBase4, statsElementsBase6));
                    q.f(arrayList14, "makeList(...)");
                    r10.r = s3;
                    r10.w = playDjMalrangBase3;
                    r10.B = statsElementsBase4;
                    r10.D = null;
                    r10.E = mixUpPlayBase$PlaylistBase6;
                    r10.G = null;
                    r10.I = arrayList5;
                    r10.M = arrayList8;
                    r10.N = null;
                    r10.S = arrayList13;
                    r10.T = null;
                    r10.V = arrayList13;
                    r10.X = v1;
                    r10.Y = 0;
                    r10.c0 = 4;
                    Object object5 = this.a(arrayList14, r10);
                    if(object5 == a0) {
                        return a0;
                    }
                    arrayList15 = arrayList5;
                    s5 = s3;
                    playDjMalrangBase5 = playDjMalrangBase3;
                    arrayList16 = arrayList13;
                    object6 = object5;
                    arrayList17 = arrayList16;
                    goto label_238;
                }
                goto label_250;
            }
            case 4: {
                int v8 = r10.X;
                arrayList16 = (ArrayList)r10.V;
                ArrayList arrayList18 = (ArrayList)r10.S;
                arrayList8 = r10.M;
                ArrayList arrayList19 = r10.I;
                mixUpPlayBase$PlaylistBase6 = r10.E;
                statsElementsBase4 = r10.B;
                playDjMalrangBase5 = r10.w;
                s5 = r10.r;
                n.D(object0);
                arrayList17 = arrayList18;
                arrayList15 = arrayList19;
                v1 = v8;
                object6 = object0;
            label_238:
                ArrayList arrayList20 = new ArrayList();
                for(Object object7: ((Iterable)object6)) {
                    if(((Playable)object7).isService()) {
                        arrayList20.add(object7);
                    }
                }
                arrayList16.addAll(arrayList20);
                arrayList13 = arrayList17;
                arrayList5 = arrayList15;
                playDjMalrangBase3 = playDjMalrangBase5;
                s3 = s5;
            label_250:
                ArrayList arrayList21 = new ArrayList();
                iterator3 = arrayList8.iterator();
                arrayList22 = arrayList21;
                arrayList23 = arrayList13;
                s6 = s3;
                arrayList24 = arrayList8;
                arrayList25 = arrayList5;
                v9 = 0;
                goto label_293;
            }
            case 5: {
                int v10 = r10.Y;
                int v11 = r10.X;
                Iterator iterator4 = (Iterator)r10.V;
                arrayList22 = r10.T;
                ArrayList arrayList26 = (ArrayList)r10.S;
                arrayList24 = r10.M;
                ArrayList arrayList27 = r10.I;
                PlaylistBase mixUpPlayBase$PlaylistBase10 = r10.E;
                StatsElementsBase statsElementsBase7 = r10.B;
                PlayDjMalrangBase playDjMalrangBase6 = r10.w;
                String s7 = r10.r;
                n.D(object0);
                iterator3 = iterator4;
                arrayList23 = arrayList26;
                statsElementsBase4 = statsElementsBase7;
                mixUpPlayBase$PlaylistBase6 = mixUpPlayBase$PlaylistBase10;
                v1 = v11;
                arrayList25 = arrayList27;
                playDjMalrangBase3 = playDjMalrangBase6;
                int v12 = v10;
                r1 r11 = r10;
                String s8 = s7;
                Object object8 = object0;
                while(true) {
                    if(((StreamGetSongInfoRes)object8) == null) {
                        arrayList28 = null;
                    }
                    else {
                        RESPONSE streamGetSongInfoRes$RESPONSE1 = ((StreamGetSongInfoRes)object8).response;
                        if(streamGetSongInfoRes$RESPONSE1 != null) {
                            arrayList28 = streamGetSongInfoRes$RESPONSE1.contentsInfo;
                        }
                    }
                    if(arrayList28 != null) {
                        arrayList22.addAll(((StreamGetSongInfoRes)object8).response.contentsInfo);
                    }
                    s6 = s8;
                    r10 = r11;
                    v9 = v12;
                label_293:
                    if(!iterator3.hasNext()) {
                        break;
                    }
                    Object object9 = iterator3.next();
                    r10.r = s6;
                    r10.w = playDjMalrangBase3;
                    r10.B = statsElementsBase4;
                    r10.D = null;
                    r10.E = mixUpPlayBase$PlaylistBase6;
                    r10.G = null;
                    r10.I = arrayList25;
                    r10.M = arrayList24;
                    r10.N = null;
                    r10.S = arrayList23;
                    r10.T = arrayList22;
                    r10.V = iterator3;
                    r10.X = v1;
                    r10.Y = v9;
                    r10.c0 = 5;
                    Object object10 = ((Deferred)object9).await(r10);
                    if(object10 == a0) {
                        return a0;
                    }
                    s8 = s6;
                    object8 = object10;
                    v12 = v9;
                    r11 = r10;
                }
                StatsElementsBase statsElementsBase8 = mixUpPlayBase$PlaylistBase6 == null ? null : mixUpPlayBase$PlaylistBase6.statsElements;
                arrayList29 = new ArrayList();
                if(!arrayList24.isEmpty()) {
                    ArrayList arrayList30 = Playable.makeList(arrayList22, s6, null, StatsElementsBase.mergeStatsElements(statsElementsBase4, statsElementsBase8));
                    q.f(arrayList30, "makeList(...)");
                    r10.r = null;
                    r10.w = playDjMalrangBase3;
                    r10.B = null;
                    r10.D = null;
                    r10.E = null;
                    r10.G = null;
                    r10.I = arrayList25;
                    r10.M = null;
                    r10.N = null;
                    r10.S = arrayList23;
                    r10.T = null;
                    r10.V = arrayList29;
                    r10.W = arrayList29;
                    r10.X = v1;
                    r10.Y = 0;
                    r10.c0 = 6;
                    object0 = this.a(arrayList30, r10);
                    if(object0 == a0) {
                        return a0;
                    }
                    arrayList31 = arrayList23;
                    arrayList32 = arrayList29;
                    goto label_350;
                }
                goto label_359;
            }
            case 6: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        arrayList32 = r10.W;
        ArrayList arrayList33 = (ArrayList)r10.V;
        arrayList31 = (ArrayList)r10.S;
        arrayList25 = r10.I;
        n.D(object0);
        arrayList29 = arrayList33;
    label_350:
        ArrayList arrayList34 = new ArrayList();
        for(Object object11: ((Iterable)object0)) {
            if(((Playable)object11).isService()) {
                arrayList34.add(object11);
            }
        }
        arrayList32.addAll(arrayList34);
        arrayList23 = arrayList31;
    label_359:
        if(!arrayList25.isEmpty() && arrayList23.isEmpty() && !arrayList29.isEmpty()) {
            Object object12 = arrayList29.remove(0);
            q.f(object12, "removeAt(...)");
            LogU.Companion.e("MixUpType", "getDjMalrangPlayableInfo(), SeedList is empty!!: Get waitList\'s first[" + ((Playable)object12) + "]");
            arrayList23.add(((Playable)object12));
        }
        if(arrayList23.size() > 0) {
            Playable playable0 = (Playable)arrayList23.get(0);
        }
        ArrayList arrayList35 = new ArrayList();
        for(Object object13: arrayList23) {
            if(((Playable)object13).isService()) {
                arrayList35.add(object13);
            }
        }
        ArrayList arrayList36 = new ArrayList();
        for(Object object14: arrayList29) {
            if(((Playable)object14).isService()) {
                arrayList36.add(object14);
            }
        }
        LogU.Companion.d("MixUpType", "getDjMalrangPlayableInfo(), return waitPlayableList.size : " + arrayList36.size());
        return new J0("", arrayList35, arrayList36, "", "", "", "", "", "", "");
    }

    public final Object c(String s, PlayDjMalrangBase playDjMalrangBase0, v v0, c c0) {
        v v21;
        ArrayList arrayList32;
        ArrayList arrayList31;
        v v22;
        ArrayList arrayList29;
        ArrayList arrayList28;
        int v16;
        ArrayList arrayList23;
        Iterator iterator3;
        StatsElementsBase statsElementsBase6;
        int v15;
        PlaylistBase mixUpPlayBase$PlaylistBase12;
        String s6;
        ArrayList arrayList22;
        ArrayList arrayList21;
        ArrayList arrayList18;
        ArrayList arrayList17;
        Object object6;
        ArrayList arrayList16;
        PlaylistBase mixUpPlayBase$PlaylistBase9;
        String s5;
        PlayDjMalrangBase playDjMalrangBase5;
        v v13;
        PlaylistBase mixUpPlayBase$PlaylistBase10;
        ArrayList arrayList14;
        ArrayList arrayList13;
        int v8;
        ArrayList arrayList9;
        ArrayList arrayList8;
        Iterator iterator1;
        StatsElementsBase statsElementsBase3;
        PlaylistBase mixUpPlayBase$PlaylistBase7;
        v v7;
        PlaylistBase mixUpPlayBase$PlaylistBase6;
        String s3;
        PlayDjMalrangBase playDjMalrangBase3;
        ArrayList arrayList7;
        StatsElementsBase statsElementsBase2;
        ArrayList arrayList6;
        ArrayList arrayList5;
        StatsElementsBase statsElementsBase0;
        String s1;
        v v3;
        ArrayList arrayList3;
        PlaylistBase mixUpPlayBase$PlaylistBase3;
        ArrayList arrayList2;
        PlaylistBase mixUpPlayBase$PlaylistBase2;
        PlayDjMalrangBase playDjMalrangBase1;
        List list5;
        ArrayList arrayList0;
        Collection collection0;
        int v2;
        Integer integer1;
        Integer integer0;
        s1 s10;
        if(c0 instanceof s1) {
            s10 = (s1)c0;
            int v1 = s10.d0;
            if((v1 & 0x80000000) == 0) {
                s10 = new s1(this, c0);
            }
            else {
                s10.d0 = v1 ^ 0x80000000;
            }
        }
        else {
            s10 = new s1(this, c0);
        }
        Object object0 = s10.b0;
        a a0 = a.a;
        w w0 = w.a;
        switch(s10.d0) {
            case 0: {
                n.D(object0);
                PlaylistBase mixUpPlayBase$PlaylistBase0 = playDjMalrangBase0.getPlaylist();
                PlaylistBase mixUpPlayBase$PlaylistBase1 = playDjMalrangBase0.getWaitingList();
                Companion logU$Companion0 = LogU.Companion;
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    integer0 = null;
                }
                else {
                    List list0 = mixUpPlayBase$PlaylistBase0.songIdList;
                    integer0 = list0 == null ? null : new Integer(list0.size());
                }
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    integer1 = null;
                }
                else {
                    List list1 = mixUpPlayBase$PlaylistBase1.songIdList;
                    integer1 = list1 == null ? null : new Integer(list1.size());
                }
                logU$Companion0.d("MixUpType", "getDjMalrangPlayableInfoForPool seedSize = " + integer0 + " waitSize = " + integer1);
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    v2 = 0;
                }
                else {
                    List list2 = mixUpPlayBase$PlaylistBase1.songIdList;
                    v2 = list2 == null ? 0 : list2.size();
                }
                Y.t("getDjMalrangPlayableInfoForPool waitListSize = ", v2, logU$Companion0, "MixUpType");
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    collection0 = w0;
                }
                else {
                    List list3 = mixUpPlayBase$PlaylistBase0.songIdList;
                    collection0 = list3 == null ? w0 : p.T0(p.L0(30, list3));
                }
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    arrayList0 = null;
                }
                else {
                    List list4 = mixUpPlayBase$PlaylistBase1.songIdList;
                    if(list4 == null) {
                        arrayList0 = null;
                    }
                    else {
                        arrayList0 = new ArrayList();
                        for(Object object1: list4) {
                            if(!collection0.contains(((String)object1))) {
                                arrayList0.add(object1);
                            }
                        }
                    }
                }
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    list5 = w0;
                }
                else {
                    list5 = mixUpPlayBase$PlaylistBase0.songIdList;
                    if(list5 == null) {
                        list5 = w0;
                    }
                }
                s10.r = s;
                playDjMalrangBase1 = playDjMalrangBase0;
                s10.w = playDjMalrangBase1;
                s10.B = v0;
                s10.D = null;
                s10.E = mixUpPlayBase$PlaylistBase0;
                s10.G = mixUpPlayBase$PlaylistBase1;
                s10.I = arrayList0;
                s10.Y = v2;
                s10.d0 = 1;
                ArrayList arrayList1 = this.k(list5, s10);
                if(arrayList1 == a0) {
                    return a0;
                }
                mixUpPlayBase$PlaylistBase2 = mixUpPlayBase$PlaylistBase0;
                arrayList2 = arrayList1;
                mixUpPlayBase$PlaylistBase3 = mixUpPlayBase$PlaylistBase1;
                arrayList3 = arrayList0;
                v3 = v0;
                s1 = s;
                statsElementsBase0 = null;
                goto label_105;
            }
            case 1: {
                int v4 = s10.Y;
                arrayList3 = s10.I;
                mixUpPlayBase$PlaylistBase3 = s10.G;
                PlaylistBase mixUpPlayBase$PlaylistBase4 = s10.E;
                StatsElementsBase statsElementsBase1 = s10.D;
                v3 = s10.B;
                playDjMalrangBase1 = s10.w;
                s1 = s10.r;
                n.D(object0);
                statsElementsBase0 = statsElementsBase1;
                mixUpPlayBase$PlaylistBase2 = mixUpPlayBase$PlaylistBase4;
                v2 = v4;
                arrayList2 = object0;
            label_105:
                if(arrayList3 != null) {
                    w0 = arrayList3;
                }
                s10.r = s1;
                s10.w = playDjMalrangBase1;
                s10.B = v3;
                s10.D = statsElementsBase0;
                s10.E = mixUpPlayBase$PlaylistBase2;
                s10.G = mixUpPlayBase$PlaylistBase3;
                s10.I = null;
                s10.M = arrayList2;
                s10.Y = v2;
                s10.d0 = 2;
                ArrayList arrayList4 = this.k(w0, s10);
                if(arrayList4 == a0) {
                    return a0;
                }
                arrayList5 = arrayList2;
                arrayList6 = arrayList4;
                statsElementsBase2 = statsElementsBase0;
                goto label_138;
            }
            case 2: {
                int v5 = s10.Y;
                arrayList5 = s10.M;
                mixUpPlayBase$PlaylistBase3 = s10.G;
                PlaylistBase mixUpPlayBase$PlaylistBase5 = s10.E;
                statsElementsBase2 = s10.D;
                v v6 = s10.B;
                PlayDjMalrangBase playDjMalrangBase2 = s10.w;
                String s2 = s10.r;
                n.D(object0);
                s1 = s2;
                playDjMalrangBase1 = playDjMalrangBase2;
                v3 = v6;
                mixUpPlayBase$PlaylistBase2 = mixUpPlayBase$PlaylistBase5;
                v2 = v5;
                arrayList6 = object0;
            label_138:
                arrayList7 = new ArrayList();
                playDjMalrangBase3 = playDjMalrangBase1;
                s3 = s1;
                mixUpPlayBase$PlaylistBase6 = mixUpPlayBase$PlaylistBase2;
                v7 = v3;
                mixUpPlayBase$PlaylistBase7 = mixUpPlayBase$PlaylistBase3;
                statsElementsBase3 = statsElementsBase2;
                iterator1 = arrayList5.iterator();
                arrayList8 = arrayList5;
                arrayList9 = arrayList6;
                v8 = 0;
                goto label_183;
            }
            case 3: {
                int v9 = s10.Z;
                int v10 = s10.Y;
                iterator1 = (Iterator)s10.T;
                ArrayList arrayList10 = s10.S;
                ArrayList arrayList11 = s10.N;
                ArrayList arrayList12 = s10.M;
                PlaylistBase mixUpPlayBase$PlaylistBase8 = s10.G;
                mixUpPlayBase$PlaylistBase6 = s10.E;
                StatsElementsBase statsElementsBase4 = s10.D;
                v v11 = s10.B;
                PlayDjMalrangBase playDjMalrangBase4 = s10.w;
                String s4 = s10.r;
                n.D(object0);
                s3 = s4;
                Object object2 = object0;
                v2 = v10;
                arrayList9 = arrayList11;
                arrayList8 = arrayList12;
                mixUpPlayBase$PlaylistBase7 = mixUpPlayBase$PlaylistBase8;
                statsElementsBase3 = statsElementsBase4;
                v7 = v11;
                playDjMalrangBase3 = playDjMalrangBase4;
                arrayList7 = arrayList10;
                for(int v12 = v9; true; v12 = v8) {
                    if(((StreamGetSongInfoRes)object2) == null) {
                        arrayList13 = null;
                    }
                    else {
                        RESPONSE streamGetSongInfoRes$RESPONSE0 = ((StreamGetSongInfoRes)object2).response;
                        if(streamGetSongInfoRes$RESPONSE0 != null) {
                            arrayList13 = streamGetSongInfoRes$RESPONSE0.contentsInfo;
                        }
                    }
                    if(arrayList13 != null) {
                        arrayList7.addAll(((StreamGetSongInfoRes)object2).response.contentsInfo);
                    }
                    v8 = v12;
                label_183:
                    if(!iterator1.hasNext()) {
                        break;
                    }
                    Object object3 = iterator1.next();
                    s10.r = s3;
                    s10.w = playDjMalrangBase3;
                    s10.B = v7;
                    s10.D = statsElementsBase3;
                    s10.E = mixUpPlayBase$PlaylistBase6;
                    s10.G = mixUpPlayBase$PlaylistBase7;
                    s10.I = null;
                    s10.M = arrayList8;
                    s10.N = arrayList9;
                    s10.S = arrayList7;
                    s10.T = iterator1;
                    s10.V = null;
                    s10.Y = v2;
                    s10.Z = v8;
                    s10.d0 = 3;
                    Object object4 = ((Deferred)object3).await(s10);
                    if(object4 == a0) {
                        return a0;
                    }
                    object2 = object4;
                }
                StatsElementsBase statsElementsBase5 = mixUpPlayBase$PlaylistBase6 == null ? null : mixUpPlayBase$PlaylistBase6.statsElements;
                arrayList14 = new ArrayList();
                if(arrayList8.isEmpty()) {
                    mixUpPlayBase$PlaylistBase10 = mixUpPlayBase$PlaylistBase7;
                }
                else {
                    ArrayList arrayList15 = Playable.makeList(arrayList7, s3, null, StatsElementsBase.mergeStatsElements(statsElementsBase3, statsElementsBase5));
                    q.f(arrayList15, "makeList(...)");
                    s10.r = s3;
                    s10.w = playDjMalrangBase3;
                    s10.B = v7;
                    s10.D = statsElementsBase3;
                    s10.E = null;
                    s10.G = mixUpPlayBase$PlaylistBase7;
                    s10.I = null;
                    s10.M = arrayList8;
                    s10.N = arrayList9;
                    s10.S = null;
                    s10.T = arrayList14;
                    s10.V = null;
                    s10.W = arrayList14;
                    s10.Y = v2;
                    s10.Z = 0;
                    s10.d0 = 4;
                    Object object5 = this.a(arrayList15, s10);
                    if(object5 == a0) {
                        return a0;
                    }
                    v13 = v7;
                    playDjMalrangBase5 = playDjMalrangBase3;
                    s5 = s3;
                    mixUpPlayBase$PlaylistBase9 = mixUpPlayBase$PlaylistBase7;
                    arrayList16 = arrayList14;
                    object6 = object5;
                    arrayList17 = arrayList9;
                    arrayList18 = arrayList16;
                    goto label_254;
                }
                goto label_268;
            }
            case 4: {
                int v14 = s10.Y;
                arrayList18 = (ArrayList)s10.W;
                arrayList16 = (ArrayList)s10.T;
                ArrayList arrayList19 = s10.N;
                arrayList8 = s10.M;
                PlaylistBase mixUpPlayBase$PlaylistBase11 = s10.G;
                statsElementsBase3 = s10.D;
                v13 = s10.B;
                playDjMalrangBase5 = s10.w;
                s5 = s10.r;
                n.D(object0);
                arrayList17 = arrayList19;
                v2 = v14;
                object6 = object0;
                mixUpPlayBase$PlaylistBase9 = mixUpPlayBase$PlaylistBase11;
            label_254:
                ArrayList arrayList20 = new ArrayList();
                for(Object object7: ((Iterable)object6)) {
                    if(((Playable)object7).isService()) {
                        arrayList20.add(object7);
                    }
                }
                arrayList18.addAll(arrayList20);
                arrayList9 = arrayList17;
                arrayList14 = arrayList16;
                mixUpPlayBase$PlaylistBase10 = mixUpPlayBase$PlaylistBase9;
                s3 = s5;
                playDjMalrangBase3 = playDjMalrangBase5;
                v7 = v13;
            label_268:
                arrayList21 = new ArrayList();
                arrayList22 = arrayList14;
                s6 = s3;
                mixUpPlayBase$PlaylistBase12 = mixUpPlayBase$PlaylistBase10;
                v15 = v2;
                statsElementsBase6 = statsElementsBase3;
                iterator3 = arrayList9.iterator();
                arrayList23 = arrayList9;
                v16 = 0;
                goto label_314;
            }
            case 5: {
                int v17 = s10.Z;
                int v18 = s10.Y;
                iterator3 = (Iterator)s10.W;
                arrayList21 = s10.V;
                ArrayList arrayList24 = (ArrayList)s10.T;
                ArrayList arrayList25 = s10.N;
                ArrayList arrayList26 = s10.M;
                PlaylistBase mixUpPlayBase$PlaylistBase13 = s10.G;
                statsElementsBase6 = s10.D;
                v v19 = s10.B;
                PlayDjMalrangBase playDjMalrangBase6 = s10.w;
                String s7 = s10.r;
                n.D(object0);
                arrayList22 = arrayList24;
                v7 = v19;
                int v20 = v17;
                s1 s11 = s10;
                String s8 = s7;
                Object object8 = object0;
                mixUpPlayBase$PlaylistBase12 = mixUpPlayBase$PlaylistBase13;
                ArrayList arrayList27 = arrayList25;
                playDjMalrangBase3 = playDjMalrangBase6;
                while(true) {
                    if(((StreamGetSongInfoRes)object8) == null) {
                        arrayList28 = null;
                    }
                    else {
                        RESPONSE streamGetSongInfoRes$RESPONSE1 = ((StreamGetSongInfoRes)object8).response;
                        if(streamGetSongInfoRes$RESPONSE1 != null) {
                            arrayList28 = streamGetSongInfoRes$RESPONSE1.contentsInfo;
                        }
                    }
                    if(arrayList28 != null) {
                        arrayList21.addAll(((StreamGetSongInfoRes)object8).response.contentsInfo);
                    }
                    s6 = s8;
                    s10 = s11;
                    v16 = v20;
                    v15 = v18;
                    arrayList8 = arrayList26;
                    arrayList23 = arrayList27;
                label_314:
                    if(!iterator3.hasNext()) {
                        break;
                    }
                    Object object9 = iterator3.next();
                    s10.r = s6;
                    s10.w = playDjMalrangBase3;
                    s10.B = v7;
                    s10.D = statsElementsBase6;
                    s10.E = null;
                    s10.G = mixUpPlayBase$PlaylistBase12;
                    s10.I = null;
                    s10.M = arrayList8;
                    s10.N = arrayList23;
                    s10.S = null;
                    s10.T = arrayList22;
                    s10.V = arrayList21;
                    s10.W = iterator3;
                    s10.Y = v15;
                    s10.Z = v16;
                    s10.d0 = 5;
                    Object object10 = ((Deferred)object9).await(s10);
                    if(object10 == a0) {
                        return a0;
                    }
                    s8 = s6;
                    object8 = object10;
                    arrayList27 = arrayList23;
                    arrayList26 = arrayList8;
                    v18 = v15;
                    v20 = v16;
                    s11 = s10;
                }
                StatsElementsBase statsElementsBase7 = mixUpPlayBase$PlaylistBase12 == null ? null : mixUpPlayBase$PlaylistBase12.statsElements;
                arrayList29 = new ArrayList();
                if(arrayList23.isEmpty()) {
                    v22 = v7;
                }
                else {
                    ArrayList arrayList30 = Playable.makeList(arrayList21, s6, null, StatsElementsBase.mergeStatsElements(statsElementsBase6, statsElementsBase7));
                    q.f(arrayList30, "makeList(...)");
                    s10.r = null;
                    s10.w = playDjMalrangBase3;
                    s10.B = v7;
                    s10.D = null;
                    s10.E = null;
                    s10.G = null;
                    s10.I = null;
                    s10.M = arrayList8;
                    s10.N = null;
                    s10.S = null;
                    s10.T = arrayList22;
                    s10.V = null;
                    s10.W = arrayList29;
                    s10.X = arrayList29;
                    s10.Y = v15;
                    s10.Z = 0;
                    s10.d0 = 6;
                    object0 = this.a(arrayList30, s10);
                    if(object0 == a0) {
                        return a0;
                    }
                    arrayList31 = arrayList22;
                    arrayList32 = arrayList29;
                    v21 = v7;
                    goto label_380;
                }
                goto label_390;
            }
            case 6: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        arrayList32 = s10.X;
        ArrayList arrayList33 = (ArrayList)s10.W;
        arrayList31 = (ArrayList)s10.T;
        arrayList8 = s10.M;
        v21 = s10.B;
        n.D(object0);
        arrayList29 = arrayList33;
    label_380:
        ArrayList arrayList34 = new ArrayList();
        for(Object object11: ((Iterable)object0)) {
            if(((Playable)object11).isService()) {
                arrayList34.add(object11);
            }
        }
        arrayList32.addAll(arrayList34);
        arrayList22 = arrayList31;
        v22 = v21;
    label_390:
        if(!arrayList8.isEmpty() && arrayList22.isEmpty() && !arrayList29.isEmpty()) {
            Object object12 = arrayList29.remove(0);
            q.f(object12, "removeAt(...)");
            LogU.Companion.e("MixUpType", "getDjMalrangPlayableInfoForPool(), SeedList is empty!!: Get waitList\'s first[" + ((Playable)object12) + "]");
            arrayList22.add(((Playable)object12));
        }
        String s9 = v22.c;
        String s10_1 = v22.g;
        if((v22.g == null || v22.g.length() == 0) && (s9 == null || s9.length() == 0) && (arrayList22.size() <= 0 ? null : ((Playable)arrayList22.get(0))) != null) {
            s10_1 = "";
            s9 = "";
        }
        String s11_1 = v22.b;
        String s12 = s10_1 == null ? "" : s10_1;
        String s13 = v22.e == null ? "" : v22.e;
        String s14 = s9 == null ? "" : s9;
        ArrayList arrayList35 = new ArrayList();
        for(Object object13: arrayList22) {
            if(((Playable)object13).isService()) {
                arrayList35.add(object13);
            }
        }
        ArrayList arrayList36 = new ArrayList();
        for(Object object14: arrayList29) {
            if(((Playable)object14).isService()) {
                arrayList36.add(object14);
            }
        }
        LogU.Companion.d("MixUpType", "getDjMalrangPlayableInfoForPool(), return waitPlayableList.size : " + arrayList36.size());
        return v22.k == null ? new J0(s11_1, arrayList35, arrayList36, s12, s13, s14, "", "", "", "") : new J0(s11_1, arrayList35, arrayList36, s12, s13, s14, "", "", "", v22.k);
    }

    public static DjMalrangRequestInfo d(J0 j00, Context context0) {
        q.g(context0, "context");
        return j00.h.length() <= 0 ? new DjMalrangRequestInfo("", "", "", "", "", "", "", "", null, 0x100, null) : new DjMalrangRequestInfo((j00.a == null ? "" : j00.a), j00.d, j00.e, j00.f, j00.g, j00.h, j00.i, j00.j, null);
    }

    public static String e(List list0) {
        q.g(list0, "seedPlayableList");
        return p.q0(p.L0(5, list0), ",", null, null, new j(13), 30);
    }

    public final Object f(String s, MixUpPlayBase mixUpPlayBase0, StatsElementsBase statsElementsBase0, StatsElementsBase statsElementsBase1, StatsElementsBase statsElementsBase2, i i0) {
        return this.g(s, mixUpPlayBase0.title, mixUpPlayBase0.subtitle, mixUpPlayBase0.playlist, mixUpPlayBase0.waitingList, statsElementsBase0, statsElementsBase1, statsElementsBase2, i0);
    }

    public final Object g(String s, String s1, String s2, PlaylistBase mixUpPlayBase$PlaylistBase0, PlaylistBase mixUpPlayBase$PlaylistBase1, StatsElementsBase statsElementsBase0, StatsElementsBase statsElementsBase1, StatsElementsBase statsElementsBase2, c c0) {
        w w1;
        int v3;
        String s5;
        String s4;
        String s3;
        StatsElementsBase statsElementsBase4;
        StatsElementsBase statsElementsBase3;
        ArrayList arrayList2;
        List list0;
        ArrayList arrayList1;
        Iterator iterator0;
        int v2;
        int v7;
        int v6;
        t1 t11;
        Iterator iterator2;
        ArrayList arrayList8;
        ArrayList arrayList7;
        ArrayList arrayList6;
        StatsElementsBase statsElementsBase10;
        StatsElementsBase statsElementsBase9;
        String s9;
        StatsElementsBase statsElementsBase8;
        w w2;
        String s8;
        String s12;
        String s11;
        String s10;
        StatsElementsBase statsElementsBase13;
        StatsElementsBase statsElementsBase12;
        StatsElementsBase statsElementsBase11;
        ArrayList arrayList9;
        int v8;
        ArrayList arrayList12;
        ArrayList arrayList11;
        String s16;
        StatsElementsBase statsElementsBase15;
        int v10;
        String s15;
        String s14;
        ArrayList arrayList19;
        ArrayList arrayList17;
        List list6;
        ArrayList arrayList13;
        Collection collection0;
        int v11;
        Integer integer1;
        Integer integer0;
        t1 t10;
        if(c0 instanceof t1) {
            t10 = (t1)c0;
            int v = t10.c0;
            if((v & 0x80000000) == 0) {
                t10 = new t1(this, c0);
            }
            else {
                t10.c0 = v ^ 0x80000000;
            }
        }
        else {
            t10 = new t1(this, c0);
        }
        ArrayList arrayList0 = t10.Z;
        a a0 = a.a;
        w w0 = w.a;
    alab1:
        switch(t10.c0) {
            case 0: {
                n.D(arrayList0);
                Companion logU$Companion0 = LogU.Companion;
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    integer0 = null;
                }
                else {
                    List list1 = mixUpPlayBase$PlaylistBase0.songIdList;
                    integer0 = list1 == null ? null : new Integer(list1.size());
                }
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    integer1 = null;
                }
                else {
                    List list2 = mixUpPlayBase$PlaylistBase1.songIdList;
                    integer1 = list2 == null ? null : new Integer(list2.size());
                }
                logU$Companion0.d("MixUpType", "getMixUpPlayableInfo seedSize = " + integer0 + " waitSize = " + integer1);
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    v11 = 0;
                }
                else {
                    List list3 = mixUpPlayBase$PlaylistBase1.songIdList;
                    v11 = list3 == null ? 0 : list3.size();
                }
                Y.t("getMixUpPlayableInfo waitListSize = ", v11, logU$Companion0, "MixUpType");
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    collection0 = w0;
                }
                else {
                    List list4 = mixUpPlayBase$PlaylistBase0.songIdList;
                    collection0 = list4 == null ? w0 : p.T0(p.L0(30, list4));
                }
                if(mixUpPlayBase$PlaylistBase1 == null) {
                    arrayList13 = null;
                }
                else {
                    List list5 = mixUpPlayBase$PlaylistBase1.songIdList;
                    if(list5 == null) {
                        arrayList13 = null;
                    }
                    else {
                        arrayList13 = new ArrayList();
                        for(Object object0: list5) {
                            if(!collection0.contains(((String)object0))) {
                                arrayList13.add(object0);
                            }
                        }
                    }
                }
                if(mixUpPlayBase$PlaylistBase0 == null) {
                    list6 = w0;
                }
                else {
                    list6 = mixUpPlayBase$PlaylistBase0.songIdList;
                    if(list6 == null) {
                        list6 = w0;
                    }
                }
                t10.r = s;
                t10.w = s1;
                s16 = s2;
                t10.B = s16;
                t10.D = statsElementsBase0;
                t10.E = statsElementsBase1;
                t10.G = statsElementsBase2;
                t10.I = arrayList13;
                t10.X = v11;
                t10.c0 = 1;
                ArrayList arrayList14 = this.k(list6, t10);
                if(arrayList14 != a0) {
                    arrayList11 = arrayList14;
                    statsElementsBase15 = statsElementsBase0;
                    s14 = s1;
                    arrayList12 = arrayList13;
                    statsElementsBase12 = statsElementsBase1;
                    s15 = s;
                    v10 = v11;
                    statsElementsBase11 = statsElementsBase2;
                label_158:
                    if(arrayList12 == null) {
                        arrayList12 = w0;
                    }
                    t10.r = s15;
                    t10.w = s14;
                    t10.B = s16;
                    t10.D = statsElementsBase15;
                    t10.E = statsElementsBase12;
                    t10.G = statsElementsBase11;
                    t10.I = null;
                    t10.M = arrayList11;
                    t10.X = v10;
                    t10.c0 = 2;
                    arrayList0 = this.k(arrayList12, t10);
                    if(arrayList0 != a0) {
                        s10 = s16;
                        statsElementsBase13 = statsElementsBase15;
                        v8 = v10;
                        arrayList9 = arrayList11;
                        s11 = s14;
                        s12 = s15;
                    label_178:
                        statsElementsBase9 = statsElementsBase11;
                        statsElementsBase8 = statsElementsBase12;
                        ArrayList arrayList15 = new ArrayList();
                        statsElementsBase10 = statsElementsBase13;
                        String s17 = s10;
                        ArrayList arrayList16 = arrayList0;
                        int v12 = v8;
                        s5 = s12;
                        arrayList6 = arrayList9;
                        v7 = 0;
                        Iterator iterator4 = arrayList9.iterator();
                        while(iterator4.hasNext()) {
                            Object object1 = iterator4.next();
                            w2 = w0;
                            t10.r = s5;
                            t10.w = s11;
                            t10.B = s17;
                            t10.D = statsElementsBase10;
                            t10.E = statsElementsBase8;
                            t10.G = statsElementsBase9;
                            s8 = s17;
                            t10.I = null;
                            t10.M = arrayList6;
                            t10.N = arrayList16;
                            t10.S = arrayList15;
                            t10.T = null;
                            t10.V = iterator4;
                            t10.W = null;
                            t10.X = v12;
                            t10.Y = v7;
                            t10.c0 = 3;
                            Object object2 = ((Deferred)object1).await(t10);
                            if(object2 == a0) {
                                break alab1;
                            }
                            v6 = v12;
                            arrayList0 = object2;
                            s9 = s11;
                            arrayList7 = arrayList16;
                            arrayList8 = arrayList15;
                            iterator2 = iterator4;
                            t11 = t10;
                        label_218:
                            if(((StreamGetSongInfoRes)arrayList0) == null) {
                                arrayList17 = null;
                            }
                            else {
                                RESPONSE streamGetSongInfoRes$RESPONSE0 = ((StreamGetSongInfoRes)arrayList0).response;
                                if(streamGetSongInfoRes$RESPONSE0 != null) {
                                    arrayList17 = streamGetSongInfoRes$RESPONSE0.contentsInfo;
                                }
                            }
                            if(arrayList17 != null) {
                                arrayList8.addAll(((StreamGetSongInfoRes)arrayList0).response.contentsInfo);
                            }
                            v12 = v6;
                            t10 = t11;
                            iterator4 = iterator2;
                            arrayList15 = arrayList8;
                            arrayList16 = arrayList7;
                            s11 = s9;
                            s17 = s8;
                            w0 = w2;
                        }
                        w1 = w0;
                        ArrayList arrayList18 = arrayList6.isEmpty() ? w1 : Playable.makeList(arrayList15, s5, null, StatsElementsBase.mergeStatsElements(statsElementsBase10, statsElementsBase8));
                        arrayList1 = new ArrayList();
                        v2 = v12;
                        statsElementsBase3 = statsElementsBase9;
                        s3 = s17;
                        statsElementsBase4 = statsElementsBase10;
                        s4 = s11;
                        arrayList2 = arrayList16;
                        list0 = arrayList18;
                        v3 = 0;
                        iterator0 = arrayList16.iterator();
                        while(iterator0.hasNext()) {
                            Object object3 = iterator0.next();
                            t10.r = s5;
                            t10.w = s4;
                            t10.B = s3;
                            t10.D = statsElementsBase4;
                            t10.E = null;
                            t10.G = statsElementsBase3;
                            t10.I = null;
                            t10.M = null;
                            t10.N = arrayList2;
                            t10.S = null;
                            t10.T = list0;
                            t10.V = arrayList1;
                            t10.W = iterator0;
                            t10.X = v2;
                            t10.Y = v3;
                            t10.c0 = 4;
                            arrayList0 = ((Deferred)object3).await(t10);
                            if(arrayList0 == a0) {
                                break alab1;
                            }
                        label_270:
                            if(((StreamGetSongInfoRes)arrayList0) == null) {
                                arrayList19 = null;
                            }
                            else {
                                RESPONSE streamGetSongInfoRes$RESPONSE1 = ((StreamGetSongInfoRes)arrayList0).response;
                                if(streamGetSongInfoRes$RESPONSE1 != null) {
                                    arrayList19 = streamGetSongInfoRes$RESPONSE1.contentsInfo;
                                }
                            }
                            if(arrayList19 != null) {
                                arrayList1.addAll(((StreamGetSongInfoRes)arrayList0).response.contentsInfo);
                            }
                        }
                        ArrayList arrayList20 = arrayList2.isEmpty() ? w1 : Playable.makeList(arrayList1, s5, null, StatsElementsBase.mergeStatsElements(statsElementsBase4, statsElementsBase3));
                        q.d(list0);
                        ArrayList arrayList21 = new ArrayList();
                        for(Object object4: list0) {
                            if(((Playable)object4).isService()) {
                                arrayList21.add(object4);
                            }
                        }
                        q.d(arrayList20);
                        ArrayList arrayList22 = new ArrayList();
                        for(Object object5: arrayList20) {
                            if(((Playable)object5).isService()) {
                                arrayList22.add(object5);
                            }
                        }
                        LogU.Companion.d("MixUpType", "getMixUpPlayableInfo(), return waitPlayableList.size : " + arrayList22.size());
                        return new c1(s4, s3, arrayList21, arrayList22, false);
                    }
                }
                break;
            }
            case 1: {
                int v9 = t10.X;
                ArrayList arrayList10 = t10.I;
                statsElementsBase11 = t10.G;
                statsElementsBase12 = t10.E;
                StatsElementsBase statsElementsBase14 = t10.D;
                String s13 = t10.B;
                s14 = t10.w;
                s15 = t10.r;
                n.D(arrayList0);
                v10 = v9;
                statsElementsBase15 = statsElementsBase14;
                s16 = s13;
                arrayList11 = arrayList0;
                arrayList12 = arrayList10;
                goto label_158;
            }
            case 2: {
                v8 = t10.X;
                arrayList9 = t10.M;
                statsElementsBase11 = t10.G;
                statsElementsBase12 = t10.E;
                statsElementsBase13 = t10.D;
                s10 = t10.B;
                s11 = t10.w;
                s12 = t10.r;
                n.D(arrayList0);
                goto label_178;
            }
            case 3: {
                int v4 = t10.Y;
                int v5 = t10.X;
                Deferred deferred0 = (Deferred)t10.W;
                Iterator iterator1 = (Iterator)t10.V;
                ArrayList arrayList3 = t10.S;
                ArrayList arrayList4 = t10.N;
                ArrayList arrayList5 = t10.M;
                StatsElementsBase statsElementsBase5 = t10.G;
                StatsElementsBase statsElementsBase6 = t10.E;
                StatsElementsBase statsElementsBase7 = t10.D;
                String s6 = t10.B;
                String s7 = t10.w;
                s5 = t10.r;
                n.D(arrayList0);
                s8 = s6;
                w2 = w0;
                statsElementsBase8 = statsElementsBase6;
                s9 = s7;
                statsElementsBase9 = statsElementsBase5;
                statsElementsBase10 = statsElementsBase7;
                arrayList6 = arrayList5;
                arrayList7 = arrayList4;
                arrayList8 = arrayList3;
                iterator2 = iterator1;
                t11 = t10;
                v6 = v5;
                v7 = v4;
                goto label_218;
            }
            case 4: {
                int v1 = t10.Y;
                v2 = t10.X;
                iterator0 = t10.W;
                arrayList1 = (ArrayList)t10.V;
                list0 = t10.T;
                arrayList2 = t10.N;
                statsElementsBase3 = t10.G;
                statsElementsBase4 = t10.D;
                s3 = t10.B;
                s4 = t10.w;
                s5 = t10.r;
                n.D(arrayList0);
                v3 = v1;
                w1 = w0;
                goto label_270;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public abstract Object h(String arg1, String arg2, Continuation arg3);

    public static Object i(w1 w10, String s, MixUpPlayBase mixUpPlayBase0, StatsElementsBase statsElementsBase0, StatsElementsBase statsElementsBase1, i i0, int v) {
        if((v & 8) != 0) {
            statsElementsBase0 = null;
        }
        return w10.f(s, mixUpPlayBase0, null, statsElementsBase0, statsElementsBase1, i0);
    }

    public abstract Object j(d1 arg1, Context arg2, String arg3, Continuation arg4);

    public final ArrayList k(List list0, c c0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: p.U0(list0, 500, 500)) {
            String s = p.q0(((List)object0), ",", null, null, null, 62);
            arrayList0.add(BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(c0.getContext().plus(Dispatchers.getIO()).plus(this.a)), null, null, new u1(this, s, null), 3, null));
        }
        return arrayList0;
    }

    public static boolean l(Error mixupPlayResponseBase$Error0) {
        return mixupPlayResponseBase$Error0 != null && mixupPlayResponseBase$Error0.code == 5001;
    }

    public static boolean m(Error mixupPlayResponseBase$Error0) {
        return mixupPlayResponseBase$Error0 != null && mixupPlayResponseBase$Error0.code == 5002;
    }

    public static void n() {
        ToastManager.show(0x7F1307A7);  // string:nowplaying_added_excluded_item "담지 않기 설정된 콘텐츠입니다. 설정에서 삭제 후 이용해주세요."
    }
}

