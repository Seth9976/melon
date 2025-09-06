package com.iloen.melon.player.playlist.search;

import M6.B;
import Tf.o;
import android.net.Uri;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import e.k;
import e1.F;
import e1.b;
import java.text.Normalizer.Form;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.w;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.H;
import oc.L;
import oc.O;
import oc.Q;
import oc.x;
import oe.e;
import oe.i;
import we.n;
import we.q;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\u00020\u0003*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/iloen/melon/player/playlist/search/SearchListType;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/channels/ProducerScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.search.PlaylistSearchViewModel$initUiStateFlow$1", f = "PlaylistSearchViewModel.kt", l = {0x7C, 0x81, 0x83, 0x100}, m = "invokeSuspend")
final class PlaylistSearchViewModel.initUiStateFlow.1 extends i implements n {
    public Object B;
    public final PlaylistSearchViewModel D;
    public H r;
    public int w;

    public PlaylistSearchViewModel.initUiStateFlow.1(PlaylistSearchViewModel playlistSearchViewModel0, Continuation continuation0) {
        this.D = playlistSearchViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new PlaylistSearchViewModel.initUiStateFlow.1(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((ProducerScope)object0), ((Continuation)object1));
    }

    public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
        return ((PlaylistSearchViewModel.initUiStateFlow.1)this.create(producerScope0, continuation0)).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h1;
        ProducerScope producerScope0 = (ProducerScope)this.B;
        a a0 = a.a;
        ie.H h0 = ie.H.a;
        PlaylistSearchViewModel playlistSearchViewModel0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                if(playlistSearchViewModel0.getPlaylistId() == null) {
                    LogU.warn$default(PlaylistSearchViewModel.access$getLog$p(playlistSearchViewModel0), "initUiStateFlow() playlistId is null", null, false, 6, null);
                    this.B = null;
                    this.w = 1;
                    return producerScope0.send(w.a, this) != a0 ? h0 : a0;
                }
                h1 = PlaylistSearchViewModel.access$getPlaylistForDrawer$p(playlistSearchViewModel0);
                if(h1 == null) {
                    B b0 = ((d3)PlaylistSearchViewModel.access$getPlaylistManager$p(playlistSearchViewModel0)).p(playlistSearchViewModel0.getPlaylistId());
                    this.B = producerScope0;
                    this.w = 2;
                    Object object1 = ListenableFutureKt.await(b0, this);
                    if(object1 != a0) {
                        h1 = (H)object1;
                        goto label_31;
                    }
                }
                else {
                label_31:
                    boolean z = b.D(h1.getState());
                    boolean z1 = ((Boolean)playlistSearchViewModel0.isDone().getValue()).booleanValue();
                    List list0 = k.z(new EmptyViewType(SearchEmptyViewTextType.EMPTY_KEYWORD, z, z1));
                    this.B = producerScope0;
                    this.r = h1;
                    this.w = 3;
                    if(producerScope0.send(list0, this) != a0) {
                    label_38:
                        Flow flow0 = FlowKt.flowOn(FlowKt.distinctUntilChanged(FlowKt.combine(playlistSearchViewModel0.getKeyword(), playlistSearchViewModel0.isDone(), h1.d(), PlaylistSearchViewModel.access$getPlayerUseCase$p(playlistSearchViewModel0).h(), new q(playlistSearchViewModel0, null) {
                            public String B;
                            public H D;
                            public PlaylistSearchViewModel E;
                            public Collection G;
                            public Iterator I;
                            public Playable M;
                            public IndexInfo N;
                            public IndexInfo S;
                            public Uri T;
                            public String V;
                            public String W;
                            public String X;
                            public Collection Y;
                            public boolean Z;
                            public boolean b0;
                            public boolean c0;
                            public int d0;
                            public int e0;
                            public int f0;
                            public int g0;
                            public int h0;
                            public int i0;
                            public int j0;
                            public int k0;
                            public CharSequence l0;
                            public boolean m0;
                            public Q n0;
                            public boolean o0;
                            public final H p0;
                            public final PlaylistSearchViewModel q0;
                            public String r;
                            public List w;

                            {
                                this.p0 = h0;
                                this.q0 = playlistSearchViewModel0;
                                super(5, continuation0);
                            }

                            public final Object invoke(CharSequence charSequence0, boolean z, Q q0, boolean z1, Continuation continuation0) {
                                com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1 playlistSearchViewModel$initUiStateFlow$1$10 = new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1(this.p0, this.q0, continuation0);
                                playlistSearchViewModel$initUiStateFlow$1$10.l0 = charSequence0;
                                playlistSearchViewModel$initUiStateFlow$1$10.m0 = z;
                                playlistSearchViewModel$initUiStateFlow$1$10.n0 = q0;
                                playlistSearchViewModel$initUiStateFlow$1$10.o0 = z1;
                                return playlistSearchViewModel$initUiStateFlow$1$10.invokeSuspend(ie.H.a);
                            }

                            @Override  // we.q
                            public Object invoke(Object object0, Object object1, Object object2, Object object3, Object object4) {
                                return this.invoke(((CharSequence)object0), ((Boolean)object1).booleanValue(), ((Q)object2), ((Boolean)object3).booleanValue(), ((Continuation)object4));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                String s14;
                                String s13;
                                Playable playable2;
                                Object object1;
                                String s12;
                                Enum enum0;
                                List list2;
                                H h3;
                                int v12;
                                Q q2;
                                String s11;
                                String s10;
                                Playable playable1;
                                IndexInfo indexInfo3;
                                IndexInfo indexInfo2;
                                Uri uri1;
                                String s9;
                                String s8;
                                int v11;
                                boolean z8;
                                boolean z7;
                                boolean z6;
                                PlaylistSearchViewModel playlistSearchViewModel2;
                                Collection collection2;
                                Iterator iterator1;
                                Collection collection1;
                                int v9;
                                int v8;
                                int v7;
                                int v5;
                                int v4;
                                Iterator iterator0;
                                H h1;
                                PlaylistSearchViewModel playlistSearchViewModel1;
                                int v3;
                                String s2;
                                int v2;
                                int v1;
                                Q q1;
                                Collection collection0;
                                String s1;
                                List list0;
                                int v;
                                CharSequence charSequence0 = this.l0;
                                boolean z = this.m0;
                                Q q0 = this.n0;
                                boolean z1 = this.o0;
                                a a0 = a.a;
                                H h0 = this.p0;
                                switch(this.k0) {
                                    case 0: {
                                        d5.n.D(object0);
                                        String s = charSequence0.toString();
                                        if(charSequence0.length() == 0) {
                                            boolean z2 = b.D(h0.getState());
                                            return k.z(new EmptyViewType(SearchEmptyViewTextType.EMPTY_KEYWORD, z2, z));
                                        }
                                        PlaylistSearchViewModel playlistSearchViewModel0 = this.q0;
                                        PlaylistId playlistId0 = ((d3)playlistSearchViewModel0.c).j();
                                        v = playlistSearchViewModel0.isDrawerViewMode() || playlistId0 != playlistSearchViewModel0.getPlaylistId() ? 0 : 1;
                                        list0 = q0 instanceof O ? ((O)q0).d() : w.a;
                                        s1 = Normalizer.normalize(s, Normalizer.Form.NFD);
                                        Iterable iterable0 = q0.c();
                                        collection0 = new ArrayList(je.q.Q(10, iterable0));
                                        q1 = q0;
                                        v1 = 0;
                                        v2 = 0;
                                        s2 = s;
                                        v3 = 0;
                                        playlistSearchViewModel1 = playlistSearchViewModel0;
                                        h1 = h0;
                                        iterator0 = iterable0.iterator();
                                        goto label_92;
                                    }
                                    case 1: {
                                        boolean z3 = this.c0;
                                        v4 = this.j0;
                                        v5 = this.i0;
                                        boolean z4 = this.b0;
                                        boolean z5 = this.Z;
                                        int v6 = this.h0;
                                        v7 = this.g0;
                                        v8 = this.f0;
                                        v9 = this.e0;
                                        int v10 = this.d0;
                                        collection1 = this.Y;
                                        String s3 = this.X;
                                        String s4 = this.W;
                                        String s5 = this.V;
                                        Uri uri0 = this.T;
                                        IndexInfo indexInfo0 = this.S;
                                        IndexInfo indexInfo1 = this.N;
                                        Playable playable0 = this.M;
                                        iterator1 = this.I;
                                        collection2 = this.G;
                                        playlistSearchViewModel2 = this.E;
                                        H h2 = this.D;
                                        String s6 = this.B;
                                        List list1 = this.w;
                                        String s7 = this.r;
                                        d5.n.D(object0);
                                        z6 = z3;
                                        z7 = z4;
                                        z8 = z5;
                                        v11 = v6;
                                        s8 = s4;
                                        s9 = s5;
                                        uri1 = uri0;
                                        indexInfo2 = indexInfo0;
                                        indexInfo3 = indexInfo1;
                                        playable1 = playable0;
                                        s10 = s6;
                                        s11 = s7;
                                        q2 = q0;
                                        v12 = v10;
                                        h3 = h2;
                                        list2 = list1;
                                        enum0 = object0;
                                        s12 = s3;
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            alab1:
                                while(true) {
                                    s1 = s10;
                                    v3 = v7;
                                    Collection collection3 = collection1;
                                    q1 = q2;
                                    playlistSearchViewModel1 = playlistSearchViewModel2;
                                    SearchWrapperPlayable searchListType$SearchWrapperPlayable0 = new SearchWrapperPlayable(s12, s8, s9, z6, uri1, v4 != 0, v5 != 0, z7, z8, ((pb.b)enum0), indexInfo3, indexInfo2, playable1, v11);
                                    v2 = v9;
                                    list0 = list2;
                                    H h4 = h3;
                                    s2 = s11;
                                    v1 = v8;
                                    iterator0 = iterator1;
                                    v = v12;
                                    while(true) {
                                        collection3.add(searchListType$SearchWrapperPlayable0);
                                        collection0 = collection2;
                                        h1 = h4;
                                    label_92:
                                        if(!iterator0.hasNext()) {
                                            break alab1;
                                        }
                                        object1 = iterator0.next();
                                        if(v3 < 0) {
                                            k.O();
                                            throw null;
                                        }
                                        playable2 = ((PlayableData)object1).a;
                                        Normalizer.Form normalizer$Form0 = Normalizer.Form.NFD;
                                        v12 = v;
                                        s13 = Normalizer.isNormalized("", normalizer$Form0) ? s1 : s2;
                                        s14 = Normalizer.isNormalized("", normalizer$Form0) ? s1 : s2;
                                        kotlin.jvm.internal.q.f("", "getSongName(...)");
                                        kotlin.jvm.internal.q.d(s13);
                                        if(o.v0("", s13, true)) {
                                            break;
                                        }
                                        kotlin.jvm.internal.q.f("", "getArtistNames(...)");
                                        kotlin.jvm.internal.q.d(s14);
                                        iterator1 = iterator0;
                                        if(o.v0("", s14, true)) {
                                            goto label_116;
                                        }
                                        collection3 = collection0;
                                        collection2 = collection3;
                                        h4 = h1;
                                        ++v3;
                                        searchListType$SearchWrapperPlayable0 = null;
                                        v = v12;
                                        iterator0 = iterator1;
                                    }
                                    iterator1 = iterator0;
                                label_116:
                                    kotlin.jvm.internal.q.f("", "getSongName(...)");
                                    int v13 = o.F0("", s13, 0, true, 2);
                                    IndexInfo indexInfo4 = v13 == -1 ? null : new IndexInfo(v13, charSequence0.length() + v13);
                                    kotlin.jvm.internal.q.f("", "getArtistNames(...)");
                                    kotlin.jvm.internal.q.d(s14);
                                    int v14 = 0;
                                    int v15 = o.F0("", s14, 0, true, 2);
                                    IndexInfo indexInfo5 = v15 == -1 ? null : new IndexInfo(v15, charSequence0.length() + v15);
                                    boolean z9 = q1.b() == v3;
                                    Boolean boolean0 = !(h1 instanceof x) || !((L)((x)h1).y().getValue()).e() || playable2.isOriginLocal() ? Boolean.FALSE : k9.e.c("", playable2.getCtype().getValue());
                                    kotlin.jvm.internal.q.f("", "getTrackId(...)");
                                    kotlin.jvm.internal.q.f("", "getSongName(...)");
                                    kotlin.jvm.internal.q.f("", "getArtistNames(...)");
                                    boolean z10 = list0.contains(new Integer(v3));
                                    Uri uri2 = ((PlayableData)object1).m;
                                    if(v12 != 0 && z9) {
                                        v14 = 1;
                                    }
                                    int v16 = v12 == 0 || !z9 || !z1 ? 0 : 1;
                                    boolean z11 = playable2.isAdult();
                                    boolean z12 = boolean0.booleanValue();
                                    boolean z13 = playable2.isOriginMelon();
                                    boolean z14 = playable2.isOriginLocal();
                                    com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1.matchedPlayableList.1.1 playlistSearchViewModel$initUiStateFlow$1$1$matchedPlayableList$1$10 = new we.k(playable2, null) {
                                        public final Playable B;
                                        public int r;
                                        public final PlaylistSearchViewModel w;

                                        {
                                            this.w = playlistSearchViewModel0;
                                            this.B = playable0;
                                            super(1, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Continuation continuation0) {
                                            return new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1.matchedPlayableList.1.1(this.w, this.B, continuation0);
                                        }

                                        @Override  // we.k
                                        public Object invoke(Object object0) {
                                            return this.invoke(((Continuation)object0));
                                        }

                                        public final Object invoke(Continuation continuation0) {
                                            return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1.matchedPlayableList.1.1)this.create(continuation0)).invokeSuspend(ie.H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            a a0 = a.a;
                                            switch(this.r) {
                                                case 0: {
                                                    d5.n.D(object0);
                                                    com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1.matchedPlayableList.1.1.1 playlistSearchViewModel$initUiStateFlow$1$1$matchedPlayableList$1$1$10 = new n(null) {
                                                        public final Playable r;

                                                        {
                                                            this.r = playable0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1.matchedPlayableList.1.1.1(this.r, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.1.matchedPlayableList.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            d5.n.D(object0);
                                                            return "";
                                                        }
                                                    };
                                                    this.r = 1;
                                                    object0 = BuildersKt.withContext(PlaylistSearchViewModel.access$getIoDispatcher$p(this.w), playlistSearchViewModel$initUiStateFlow$1$1$matchedPlayableList$1$1$10, this);
                                                    if(object0 == a0) {
                                                        return a0;
                                                    }
                                                    break;
                                                }
                                                case 1: {
                                                    d5.n.D(object0);
                                                    break;
                                                }
                                                default: {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                            }
                                            kotlin.jvm.internal.q.f(object0, "withContext(...)");
                                            return object0;
                                        }
                                    };
                                    this.l0 = charSequence0;
                                    this.n0 = q1;
                                    s11 = s2;
                                    this.r = s11;
                                    q2 = q1;
                                    this.w = list0;
                                    s10 = s1;
                                    this.B = s10;
                                    this.D = h1;
                                    this.E = playlistSearchViewModel1;
                                    this.G = collection0;
                                    playlistSearchViewModel2 = playlistSearchViewModel1;
                                    this.I = iterator1;
                                    this.M = playable2;
                                    this.N = indexInfo4;
                                    this.S = indexInfo5;
                                    this.T = uri2;
                                    this.V = "";
                                    this.W = "";
                                    this.X = "";
                                    this.Y = collection0;
                                    this.m0 = z;
                                    this.o0 = z1;
                                    this.d0 = v12;
                                    this.e0 = v2;
                                    this.f0 = v1;
                                    this.g0 = v3 + 1;
                                    this.h0 = v3;
                                    this.Z = z12;
                                    this.b0 = z11;
                                    this.i0 = v16;
                                    this.j0 = v14;
                                    this.c0 = z10;
                                    this.k0 = 1;
                                    playlistSearchViewModel1.e.getClass();
                                    enum0 = new F().t(z13, z14, playlistSearchViewModel$initUiStateFlow$1$1$matchedPlayableList$1$10, this);  // 初始化器: Ljava/lang/Object;-><init>()V
                                    if(enum0 == a0) {
                                        return a0;
                                    }
                                    v11 = v3;
                                    s9 = "";
                                    z8 = z12;
                                    indexInfo3 = indexInfo4;
                                    playable1 = playable2;
                                    indexInfo2 = indexInfo5;
                                    v8 = v1;
                                    v9 = v2;
                                    v5 = v16;
                                    h3 = h1;
                                    z7 = z11;
                                    list2 = list0;
                                    z6 = z10;
                                    collection2 = collection0;
                                    s12 = "";
                                    s8 = "";
                                    v7 = v3 + 1;
                                    v4 = v14;
                                    collection1 = collection2;
                                    uri1 = uri2;
                                }
                                ArrayList arrayList0 = p.i0(((List)collection0));
                                if(arrayList0.isEmpty()) {
                                    boolean z15 = b.D(h0.getState());
                                    return k.z(new EmptyViewType(SearchEmptyViewTextType.EMPTY_RESULT, z15, z));
                                }
                                ArrayList arrayList1 = new ArrayList();
                                arrayList1.addAll(arrayList0);
                                arrayList1.add(FooterType.INSTANCE);
                                return arrayList1;
                            }
                        })), PlaylistSearchViewModel.access$getDefaultDispatcher$p(playlistSearchViewModel0));
                        com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.2 playlistSearchViewModel$initUiStateFlow$1$20 = new n(null) {
                            public final ProducerScope B;
                            public int r;
                            public Object w;

                            {
                                this.B = producerScope0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.2(this.B, continuation0);
                                continuation1.w = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((List)object0), ((Continuation)object1));
                            }

                            public final Object invoke(List list0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.search.PlaylistSearchViewModel.initUiStateFlow.1.2)this.create(list0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                List list0 = (List)this.w;
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        this.w = null;
                                        this.r = 1;
                                        return this.B.send(list0, this) == a0 ? a0 : ie.H.a;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return ie.H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.B = null;
                        this.r = null;
                        this.w = 4;
                        if(FlowKt.collectLatest(flow0, playlistSearchViewModel$initUiStateFlow$1$20, this) != a0) {
                            return h0;
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            case 2: {
                d5.n.D(object0);
                h1 = (H)object0;
                goto label_31;
            }
            case 3: {
                h1 = this.r;
                d5.n.D(object0);
                goto label_38;
            }
            case 4: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

