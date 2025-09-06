package Pa;

import A7.d;
import Cb.j;
import Na.c;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaylist.EventAddSongIds;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.v4x.response.DjPlaylistAddDjSongRes;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistInsertSongRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import d5.v;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import mb.k;
import oe.i;
import ua.u;
import va.e0;
import we.n;

public final class a extends i implements n {
    public HttpResponse B;
    public int D;
    public Object E;
    public final List G;
    public final d5.i I;
    public final String M;
    public final String N;
    public final String S;
    public final String T;
    public List r;
    public String w;

    public a(List list0, d5.i i0, String s, String s1, String s2, String s3, Continuation continuation0) {
        this.G = list0;
        this.I = i0;
        this.M = s;
        this.N = s1;
        this.S = s2;
        this.T = s3;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a(this.G, this.I, this.M, this.N, this.S, this.T, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s4;
        HttpResponse httpResponse0;
        List list0;
        Object object2;
        FlowCollector flowCollector0 = (FlowCollector)this.E;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList0 = new ArrayList();
                Iterator iterator0 = this.G.iterator();
                while(iterator0.hasNext()) {
                    iterator0.next();
                }
                if(arrayList0.isEmpty()) {
                    g g0 = new g(0x7F13081B);  // string:playlist_added_only_melon_song_msg "플레이리스트에는 멜론곡만 담기 가능합니다."
                    this.E = null;
                    this.r = null;
                    this.D = 1;
                    if(flowCollector0.emit(g0, this) == a0) {
                        return a0;
                    }
                }
                else {
                    this.E = flowCollector0;
                    this.r = arrayList0;
                    this.D = 2;
                    d5.i i0 = this.I;
                    LogU logU0 = (LogU)i0.d;
                    String s = this.M;
                    StringBuilder stringBuilder0 = d.o("addToPlaylist - plId:", s, ", plName:", this.S, ", playlistType:");
                    String s1 = this.N;
                    stringBuilder0.append(s1);
                    LogU.debug$default(logU0, stringBuilder0.toString(), null, false, 6, null);
                    StringBuilder stringBuilder1 = new StringBuilder();
                    Iterator iterator1 = arrayList0.iterator();
                    if(iterator1.hasNext()) {
                        Object object1 = iterator1.next();
                        q.f("", "getSongidString(...)");
                        throw MelonError.fromClientMessage(("Empty SongId: " + ((Playable)object1)));
                    }
                    if(stringBuilder1.length() == 0) {
                        LogU.debug$default(((LogU)i0.d), "addToPlaylist - not songs to be added", null, false, 6, null);
                        object2 = null;
                    }
                    else {
                        stringBuilder1.setLength(stringBuilder1.length() - 1);
                        boolean z = s1.equals("M20001");
                        String s2 = this.T;
                        AddPosition addPosition0 = AddPosition.b;
                        if(z) {
                            boolean z1 = MelonSettingInfo.getNormalPlayListAddPosition() == addPosition0;
                            object2 = ((u)i0.a).q(s, s1, stringBuilder1.toString(), (z1 ? "TOP" : "BOTTOM"), s2, this);
                            if(object2 != ne.a.a) {
                                object2 = (MyMusicPlaylistInsertSongRes)object2;
                            }
                        }
                        else {
                            boolean z2 = MelonSettingInfo.getDjPlayListAddPosition() == addPosition0;
                            object2 = ((v)i0.b).i(s, stringBuilder1.toString(), (z2 ? "TOP" : "BOTTOM"), s2, e1.u.w(((e0)(((k)i0.c))).j()), this);
                            if(object2 != ne.a.a) {
                                object2 = (DjPlaylistAddDjSongRes)object2;
                            }
                        }
                    }
                    if(object2 == a0) {
                        return a0;
                    }
                    list0 = arrayList0;
                    goto label_61;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            case 2: {
                List list1 = this.r;
                d5.n.D(object0);
                list0 = list1;
                object2 = object0;
            label_61:
                httpResponse0 = (HttpResponse)object2;
                if(httpResponse0 != null) {
                    f f0 = new f(httpResponse0.notification);
                    this.E = null;
                    this.r = list0;
                    String s3 = this.M;
                    this.w = s3;
                    this.B = httpResponse0;
                    this.D = 3;
                    if(flowCollector0.emit(f0, this) == a0) {
                        return a0;
                    }
                    s4 = s3;
                    goto label_78;
                }
                break;
            }
            case 3: {
                httpResponse0 = this.B;
                s4 = this.w;
                list0 = this.r;
                d5.n.D(object0);
            label_78:
                if(!j.d(httpResponse0)) {
                    throw new c("");
                }
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
                Iterator iterator2 = list0.iterator();
                while(iterator2.hasNext()) {
                    iterator2.next();
                    arrayList1.add("");
                }
                EventBusHelper.post(new EventAddSongIds(s4, arrayList1));
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

