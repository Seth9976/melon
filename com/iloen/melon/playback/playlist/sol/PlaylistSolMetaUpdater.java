package com.iloen.melon.playback.playlist.sol;

import U4.x;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.net.res.SolInfoRes.Response;
import com.melon.net.res.SolInfoRes.SolInfo;
import com.melon.net.res.SolInfoRes;
import d5.n;
import e.k;
import ie.H;
import ie.o;
import ie.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import y8.v;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001C2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001CB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\u000B\u001A\u00020\u00072\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR$\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001A\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaUpdater;", "", "", "Lcom/iloen/melon/playback/Playable;", "<init>", "()V", "list", "Lie/H;", "insertSolMetaList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "onUpdateSolMetaDataBase", "(Ljava/util/List;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaRepository;", "repository", "Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaRepository;", "getRepository", "()Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaRepository;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSolMetaUpdater {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/playlist/sol/PlaylistSolMetaUpdater$Companion;", "", "<init>", "()V", "MAX_REQUEST_SIZE", "", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_REQUEST_SIZE = 100;
    @NotNull
    private static final String TAG = "PlaylistSolMetaUpdater";
    @Nullable
    private Job job;
    @NotNull
    private final LogU log;
    @NotNull
    private final PlaylistSolMetaRepository repository;

    static {
        PlaylistSolMetaUpdater.Companion = new Companion(null);
        PlaylistSolMetaUpdater.$stable = 8;
    }

    public PlaylistSolMetaUpdater() {
        this.log = new LogU("PlaylistSolMetaUpdater");
        MelonAppBase.Companion.getClass();
        this.repository = ((PlaylistSolMetaRepositoryEntryPoint)b.B(t.a().getContext(), PlaylistSolMetaRepositoryEntryPoint.class)).playlistSolMetaRepository();
    }

    @Nullable
    public final Job getJob() {
        return this.job;
    }

    @NotNull
    public final PlaylistSolMetaRepository getRepository() {
        return this.repository;
    }

    private final Object insertSolMetaList(List list0, Continuation continuation0) {
        SolInfoRes solInfoRes1;
        SolInfoRes solInfoRes0;
        com.iloen.melon.playback.playlist.sol.PlaylistSolMetaUpdater.insertSolMetaList.1 playlistSolMetaUpdater$insertSolMetaList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.sol.PlaylistSolMetaUpdater.insertSolMetaList.1) {
            playlistSolMetaUpdater$insertSolMetaList$10 = (com.iloen.melon.playback.playlist.sol.PlaylistSolMetaUpdater.insertSolMetaList.1)continuation0;
            int v = playlistSolMetaUpdater$insertSolMetaList$10.label;
            if((v & 0x80000000) == 0) {
                playlistSolMetaUpdater$insertSolMetaList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.insertSolMetaList(null, this);
                    }
                };
            }
            else {
                playlistSolMetaUpdater$insertSolMetaList$10.label = v ^ 0x80000000;
            }
        }
        else {
            playlistSolMetaUpdater$insertSolMetaList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                Object L$8;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.insertSolMetaList(null, this);
                }
            };
        }
        Object object0 = playlistSolMetaUpdater$insertSolMetaList$10.result;
        a a0 = a.a;
        String s = null;
        switch(playlistSolMetaUpdater$insertSolMetaList$10.label) {
            case 0: {
                n.D(object0);
                LogU.debug$default(this.log, "onUpdateSolMetaDataBase()", null, false, 6, null);
                StringBuilder stringBuilder0 = new StringBuilder();
                StringBuilder stringBuilder1 = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                MelonAppBase.Companion.getClass();
                q.f("MP3", "getString(...)");
                q.f("FLAC", "getString(...)");
                int v1 = 0;
                for(Object object1: list0) {
                    if(v1 >= 0) {
                        if(v1 != 0) {
                            stringBuilder0.append(",");
                            stringBuilder1.append(",");
                            stringBuilder2.append(",");
                        }
                        stringBuilder0.append("");
                        stringBuilder1.append(((Playable)object1).getCtype().getValue());
                        stringBuilder2.append((((Playable)object1).isFlacFile() ? "FLAC" : "MP3"));
                        ++v1;
                        continue;
                    }
                    k.O();
                    throw null;
                }
                try {
                    String s1 = stringBuilder0.toString();
                    q.f(s1, "toString(...)");
                    String s2 = stringBuilder1.toString();
                    q.f(s2, "toString(...)");
                    String s3 = stringBuilder2.toString();
                    q.f(s3, "toString(...)");
                    playlistSolMetaUpdater$insertSolMetaList$10.L$0 = null;
                    playlistSolMetaUpdater$insertSolMetaList$10.L$1 = null;
                    playlistSolMetaUpdater$insertSolMetaList$10.L$2 = null;
                    playlistSolMetaUpdater$insertSolMetaList$10.L$3 = null;
                    playlistSolMetaUpdater$insertSolMetaList$10.L$4 = null;
                    playlistSolMetaUpdater$insertSolMetaList$10.L$5 = null;
                    playlistSolMetaUpdater$insertSolMetaList$10.L$6 = null;
                    playlistSolMetaUpdater$insertSolMetaList$10.I$0 = 0;
                    playlistSolMetaUpdater$insertSolMetaList$10.label = 1;
                    object0 = this.repository.getSolInfo(s1, s2, s3, playlistSolMetaUpdater$insertSolMetaList$10);
                    if(object0 != a0) {
                        goto label_64;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    goto label_67;
                }
                goto label_64;
            }
            case 1: {
                PlaylistSolMetaUpdater playlistSolMetaUpdater0 = (PlaylistSolMetaUpdater)playlistSolMetaUpdater$insertSolMetaList$10.L$6;
                String s4 = (String)playlistSolMetaUpdater$insertSolMetaList$10.L$5;
                String s5 = (String)playlistSolMetaUpdater$insertSolMetaList$10.L$4;
                StringBuilder stringBuilder3 = (StringBuilder)playlistSolMetaUpdater$insertSolMetaList$10.L$3;
                StringBuilder stringBuilder4 = (StringBuilder)playlistSolMetaUpdater$insertSolMetaList$10.L$2;
                StringBuilder stringBuilder5 = (StringBuilder)playlistSolMetaUpdater$insertSolMetaList$10.L$1;
                List list1 = (List)playlistSolMetaUpdater$insertSolMetaList$10.L$0;
                try {
                    n.D(object0);
                label_64:
                    solInfoRes0 = (SolInfoRes)ApiResultKt.getOrThrow(((ApiResult)object0));
                }
                catch(Throwable throwable0) {
                label_67:
                    solInfoRes0 = n.t(throwable0);
                }
                solInfoRes1 = solInfoRes0;
                if(solInfoRes1 instanceof o) {
                    goto label_121;
                }
                else {
                    Response solInfoRes$Response0 = solInfoRes1.getResponse();
                    if(q.b((solInfoRes$Response0 == null ? null : solInfoRes$Response0.getResult()), "0")) {
                        Response solInfoRes$Response1 = solInfoRes1.getResponse();
                        if(solInfoRes$Response1 != null) {
                            ArrayList arrayList0 = solInfoRes$Response1.getSolInfoList();
                            if(arrayList0 != null) {
                                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                                for(Object object2: arrayList0) {
                                    q.g(((SolInfo)object2), "solInfo");
                                    String s6 = ((SolInfo)object2).getCId();
                                    String s7 = ((SolInfo)object2).getCType();
                                    String s8 = ((SolInfo)object2).solTypeCode;
                                    if(s8.length() == 0) {
                                        s8 = "SO0100";
                                    }
                                    String s9 = ((SolInfo)object2).solFileUpdtDate;
                                    q.f(s9, "solFileUpdtDate");
                                    v v2 = new v((s6 == null ? "" : s6), (s7 == null ? "" : s7), s8, s9, ((SolInfo)object2).sol);
                                    LogU.debug$default(this.log, "onUpdateSolMetaDataBase() - insertSolMetaList() - SolMetaData : " + v2, null, false, 6, null);
                                    arrayList1.add(v2);
                                }
                                playlistSolMetaUpdater$insertSolMetaList$10.L$0 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$1 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$2 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$3 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$4 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$5 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$6 = solInfoRes1;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$7 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.L$8 = null;
                                playlistSolMetaUpdater$insertSolMetaList$10.I$0 = 0;
                                playlistSolMetaUpdater$insertSolMetaList$10.label = 2;
                                if(this.repository.insertSolMetaList(arrayList1, playlistSolMetaUpdater$insertSolMetaList$10) == a0) {
                                    return a0;
                                }
                                goto label_121;
                            }
                        }
                    }
                    else {
                        LogU logU0 = this.log;
                        Response solInfoRes$Response2 = solInfoRes1.getResponse();
                        if(solInfoRes$Response2 != null) {
                            s = solInfoRes$Response2.getResult();
                        }
                        LogU.error$default(logU0, "onUpdateSolMetaDataBase() - insertSolMetaList() - error : " + s, null, false, 6, null);
                        goto label_121;
                    }
                }
                return H.a;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        List list2 = (List)playlistSolMetaUpdater$insertSolMetaList$10.L$8;
        SolInfoRes solInfoRes2 = (SolInfoRes)playlistSolMetaUpdater$insertSolMetaList$10.L$7;
        solInfoRes1 = playlistSolMetaUpdater$insertSolMetaList$10.L$6;
        String s10 = (String)playlistSolMetaUpdater$insertSolMetaList$10.L$5;
        String s11 = (String)playlistSolMetaUpdater$insertSolMetaList$10.L$4;
        StringBuilder stringBuilder6 = (StringBuilder)playlistSolMetaUpdater$insertSolMetaList$10.L$3;
        StringBuilder stringBuilder7 = (StringBuilder)playlistSolMetaUpdater$insertSolMetaList$10.L$2;
        StringBuilder stringBuilder8 = (StringBuilder)playlistSolMetaUpdater$insertSolMetaList$10.L$1;
        List list3 = (List)playlistSolMetaUpdater$insertSolMetaList$10.L$0;
        n.D(object0);
    label_121:
        Throwable throwable1 = p.a(solInfoRes1);
        if(throwable1 != null) {
            LogU.error$default(this.log, e.b("onUpdateSolMetaDataBase() - insertSolMetaList() - error : ", throwable1.getMessage()), null, false, 6, null);
        }
        return H.a;
    }

    public void onUpdateSolMetaDataBase(Object object0) {
        this.onUpdateSolMetaDataBase(((List)object0));
    }

    public void onUpdateSolMetaDataBase(@NotNull List list0) {
        q.g(list0, "t");
        Job job0 = this.job;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.job = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new we.n(list0, null) {
            final List $t;
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int label;

            {
                PlaylistSolMetaUpdater.this = playlistSolMetaUpdater0;
                this.$t = list0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.sol.PlaylistSolMetaUpdater.onUpdateSolMetaDataBase.1(PlaylistSolMetaUpdater.this, this.$t, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.sol.PlaylistSolMetaUpdater.onUpdateSolMetaDataBase.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                int v2;
                Iterator iterator4;
                PlaylistSolMetaUpdater playlistSolMetaUpdater1;
                Iterator iterator2;
                int v1;
                Collection collection0;
                PlaylistSolMetaUpdater playlistSolMetaUpdater0;
                int v;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        LogU.debug$default(PlaylistSolMetaUpdater.this.log, "onUpdateSolMetaDataBase()", null, false, 6, null);
                        ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.$t));
                        for(Object object1: this.$t) {
                            arrayList0.add(PlayableExtensionsKt.copyAndUpdatedWhenLocal(((Playable)object1)));
                        }
                        ArrayList arrayList1 = new ArrayList();
                        for(Object object2: arrayList0) {
                            if(((Playable)object2).hasSongId()) {
                                arrayList1.add(object2);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        v = 0;
                        playlistSolMetaUpdater0 = PlaylistSolMetaUpdater.this;
                        collection0 = arrayList2;
                        v1 = 0;
                        iterator2 = arrayList1.iterator();
                        goto label_39;
                    }
                    case 1: {
                        v = this.I$1;
                        v1 = this.I$0;
                        Playable playable0 = (Playable)this.L$7;
                        Object object3 = this.L$6;
                        iterator2 = (Iterator)this.L$5;
                        collection0 = (Collection)this.L$4;
                        Iterable iterable0 = (Iterable)this.L$3;
                        playlistSolMetaUpdater0 = (PlaylistSolMetaUpdater)this.L$2;
                        Iterable iterable1 = (Iterable)this.L$1;
                        List list0 = (List)this.L$0;
                        n.D(object0);
                        Object object4 = object0;
                        while(true) {
                            if(!((Boolean)object4).booleanValue()) {
                                collection0.add(object3);
                            }
                        label_39:
                            if(!iterator2.hasNext()) {
                                break;
                            }
                            object3 = iterator2.next();
                            y8.t t0 = playlistSolMetaUpdater0.getRepository().getSolMeta(((Playable)object3));
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = playlistSolMetaUpdater0;
                            this.L$3 = null;
                            this.L$4 = collection0;
                            this.L$5 = iterator2;
                            this.L$6 = object3;
                            this.L$7 = null;
                            this.I$0 = v1;
                            this.I$1 = v;
                            this.I$2 = 0;
                            this.label = 1;
                            object4 = playlistSolMetaUpdater0.getRepository().isExistSolMeta(t0, this);
                            if(object4 == a0) {
                                return a0;
                            }
                        }
                        LogU.debug$default(PlaylistSolMetaUpdater.this.log, x.e(((List)collection0).size(), "onUpdateSolMetaDataBase() - needToUpdateList.size : "), null, false, 6, null);
                        Iterator iterator3 = je.p.U0(((List)collection0), 100, 100).iterator();
                        playlistSolMetaUpdater1 = PlaylistSolMetaUpdater.this;
                        iterator4 = iterator3;
                        v2 = 0;
                        break;
                    }
                    case 2: {
                        v2 = this.I$0;
                        List list1 = (List)this.L$6;
                        iterator4 = (Iterator)this.L$4;
                        playlistSolMetaUpdater1 = (PlaylistSolMetaUpdater)this.L$3;
                        Iterable iterable2 = (Iterable)this.L$2;
                        List list2 = (List)this.L$1;
                        List list3 = (List)this.L$0;
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(iterator4.hasNext()) {
                    Object object5 = iterator4.next();
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = playlistSolMetaUpdater1;
                    this.L$4 = iterator4;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.L$7 = null;
                    this.I$0 = v2;
                    this.I$1 = 0;
                    this.label = 2;
                    if(playlistSolMetaUpdater1.insertSolMetaList(((List)object5), this) != a0) {
                        continue;
                    }
                    return a0;
                }
                LogU.debug$default(PlaylistSolMetaUpdater.this.log, "onUpdateSolMetaDataBase() - end", null, false, 6, null);
                return H.a;
            }
        }, 3, null);
    }

    public final void setJob(@Nullable Job job0) {
        this.job = job0;
    }
}

