package com.iloen.melon.playback.playlist.music;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.db.MusicPlaylistDao;
import com.iloen.melon.playback.playlist.db.entity.MusicEntity;
import com.iloen.melon.playback.playlist.db.entity.PlayableEntityKt;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\b\u0010\tJ,\u0010\u000E\u001A\u00020\r2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u000E\u0010\u000FJ\u001E\u0010\u0011\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J:\u0010\u0013\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\rH\u0086@¢\u0006\u0004\b\u0015\u0010\tJ\u001E\u0010\u0016\u001A\u00020\r2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u0016\u0010\u0012J\u001E\u0010\u0019\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u0006H\u0086@¢\u0006\u0004\b\u0019\u0010\u0012J\u001E\u0010\u001A\u001A\u00020\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u0006H\u0086@¢\u0006\u0004\b\u001A\u0010\u0012R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001BR\u0014\u0010\u001D\u001A\u00020\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010 \u001A\u00020\u001F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/iloen/melon/playback/playlist/music/MusicPlaylistDBDataSource;", "", "Lcom/iloen/melon/playback/playlist/db/MusicPlaylistDao;", "playlistDao", "<init>", "(Lcom/iloen/melon/playback/playlist/db/MusicPlaylistDao;)V", "", "Lcom/iloen/melon/playback/Playable;", "getList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "addList", "allOrderedList", "Lie/H;", "add", "(Ljava/util/Collection;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removedList", "remove", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAndAdd", "(Ljava/util/List;Ljava/util/Collection;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "updateDisplayOrder", "Lcom/iloen/melon/playback/playlist/db/entity/MusicEntity;", "list", "updateAllList", "updatePlayableInfos", "Lcom/iloen/melon/playback/playlist/db/MusicPlaylistDao;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/sync/Mutex;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicPlaylistDBDataSource {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/playback/playlist/music/MusicPlaylistDBDataSource$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MusicPlaylistDBDataSource";
    @NotNull
    private final Mutex lock;
    @NotNull
    private final LogU log;
    @NotNull
    private final MusicPlaylistDao playlistDao;

    static {
        MusicPlaylistDBDataSource.Companion = new Companion(null);
        MusicPlaylistDBDataSource.$stable = 8;
    }

    public MusicPlaylistDBDataSource(@NotNull MusicPlaylistDao musicPlaylistDao0) {
        q.g(musicPlaylistDao0, "playlistDao");
        super();
        this.playlistDao = musicPlaylistDao0;
        this.log = new LogU("MusicPlaylistDBDataSource");
        this.lock = MutexKt.Mutex$default(false, 1, null);
    }

    @Nullable
    public final Object add(@NotNull Collection collection0, @NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        List list1;
        Collection collection1;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.add.1 musicPlaylistDBDataSource$add$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.add.1) {
            musicPlaylistDBDataSource$add$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.add.1)continuation0;
            int v = musicPlaylistDBDataSource$add$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$add$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.add(null, null, this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$add$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$add$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.add(null, null, this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$add$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$add$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                collection1 = collection0;
                musicPlaylistDBDataSource$add$10.L$0 = collection1;
                list1 = list0;
                musicPlaylistDBDataSource$add$10.L$1 = list1;
                musicPlaylistDBDataSource$add$10.L$2 = mutex0;
                musicPlaylistDBDataSource$add$10.I$0 = 0;
                musicPlaylistDBDataSource$add$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$add$10) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    goto label_34;
                }
                return a0;
            }
            case 1: {
                int v2 = musicPlaylistDBDataSource$add$10.I$0;
                mutex1 = (Mutex)musicPlaylistDBDataSource$add$10.L$2;
                list1 = (List)musicPlaylistDBDataSource$add$10.L$1;
                Collection collection2 = (Collection)musicPlaylistDBDataSource$add$10.L$0;
                n.D(object0);
                v1 = v2;
                collection1 = collection2;
                try {
                label_34:
                    LogU.debug$default(this.log, "add start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.add.2.1 musicPlaylistDBDataSource$add$2$10 = new we.n(this, list1, null) {
                        final Collection $addList;
                        final List $allOrderedList;
                        Object L$0;
                        int label;

                        {
                            this.$addList = collection0;
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            this.$allOrderedList = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.add.2.1(this.$addList, MusicPlaylistDBDataSource.this, this.$allOrderedList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.add.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.$addList));
                                    for(Object object1: this.$addList) {
                                        arrayList0.add(PlayableExtensionsKt.toMusicEntity(((Playable)object1)));
                                    }
                                    this.L$0 = null;
                                    this.label = 1;
                                    return MusicPlaylistDBDataSource.this.playlistDao.insertMusicsAndUpdateOrderInTransaction(arrayList0, this.$allOrderedList, this) == a0 ? a0 : H.a;
                                }
                                case 1: {
                                    List list0 = (List)this.L$0;
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    musicPlaylistDBDataSource$add$10.L$0 = null;
                    musicPlaylistDBDataSource$add$10.L$1 = null;
                    musicPlaylistDBDataSource$add$10.L$2 = mutex1;
                    musicPlaylistDBDataSource$add$10.I$0 = v1;
                    musicPlaylistDBDataSource$add$10.I$1 = 0;
                    musicPlaylistDBDataSource$add$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$add$2$10, musicPlaylistDBDataSource$add$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    break;
                }
                mutex2 = mutex1;
                goto label_54;
            }
            case 2: {
                mutex2 = (Mutex)musicPlaylistDBDataSource$add$10.L$2;
                List list2 = (List)musicPlaylistDBDataSource$add$10.L$1;
                Collection collection3 = (Collection)musicPlaylistDBDataSource$add$10.L$0;
                try {
                    n.D(object0);
                label_54:
                    LogU.debug$default(this.log, "add end", null, false, 6, null);
                    goto label_59;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_59:
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object clear(@NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex0;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.clear.1 musicPlaylistDBDataSource$clear$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.clear.1) {
            musicPlaylistDBDataSource$clear$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.clear.1)continuation0;
            int v = musicPlaylistDBDataSource$clear$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$clear$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.clear(this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$clear$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$clear$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.clear(this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$clear$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$clear$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                musicPlaylistDBDataSource$clear$10.L$0 = mutex0;
                musicPlaylistDBDataSource$clear$10.I$0 = 0;
                musicPlaylistDBDataSource$clear$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$clear$10) != a0) {
                    v1 = 0;
                    goto label_26;
                }
                return a0;
            }
            case 1: {
                v1 = musicPlaylistDBDataSource$clear$10.I$0;
                Mutex mutex1 = (Mutex)musicPlaylistDBDataSource$clear$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_26:
                    LogU.debug$default(this.log, "clear - start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.clear.2.1 musicPlaylistDBDataSource$clear$2$10 = new we.n(null) {
                        int label;

                        {
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.clear.2.1(MusicPlaylistDBDataSource.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.clear.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return MusicPlaylistDBDataSource.this.playlistDao.deleteAllMusic(this) == a0 ? a0 : H.a;
                                }
                                case 1: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    musicPlaylistDBDataSource$clear$10.L$0 = mutex0;
                    musicPlaylistDBDataSource$clear$10.I$0 = v1;
                    musicPlaylistDBDataSource$clear$10.I$1 = 0;
                    musicPlaylistDBDataSource$clear$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$clear$2$10, musicPlaylistDBDataSource$clear$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    break;
                }
                mutex2 = mutex0;
                goto label_42;
            }
            case 2: {
                mutex2 = (Mutex)musicPlaylistDBDataSource$clear$10.L$0;
                try {
                    n.D(object0);
                label_42:
                    LogU.debug$default(this.log, "clear - end", null, false, 6, null);
                    goto label_47;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_47:
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object getList(@NotNull Continuation continuation0) {
        List list0;
        Throwable throwable1;
        Mutex mutex2;
        Object object1;
        int v1;
        Mutex mutex0;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.getList.1 musicPlaylistDBDataSource$getList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.getList.1) {
            musicPlaylistDBDataSource$getList$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.getList.1)continuation0;
            int v = musicPlaylistDBDataSource$getList$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$getList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getList(this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$getList$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$getList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getList(this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$getList$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$getList$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                musicPlaylistDBDataSource$getList$10.L$0 = mutex0;
                musicPlaylistDBDataSource$getList$10.I$0 = 0;
                musicPlaylistDBDataSource$getList$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$getList$10) == a0) {
                    return a0;
                }
                v1 = 0;
                goto label_25;
            }
            case 1: {
                v1 = musicPlaylistDBDataSource$getList$10.I$0;
                Mutex mutex1 = (Mutex)musicPlaylistDBDataSource$getList$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_25:
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.getList.2.1 musicPlaylistDBDataSource$getList$2$10 = new we.n(null) {
                        int label;

                        {
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.getList.2.1(MusicPlaylistDBDataSource.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.getList.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            n.D(object0);
                            Iterable iterable0 = MusicPlaylistDBDataSource.this.playlistDao.getAllMusicPlaylist();
                            ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                            for(Object object1: iterable0) {
                                arrayList0.add(PlayableEntityKt.convertToPlayable(((MusicEntity)object1).getPlayableEntity(), ((MusicEntity)object1).getTrackId()));
                            }
                            return arrayList0;
                        }
                    };
                    musicPlaylistDBDataSource$getList$10.L$0 = mutex0;
                    musicPlaylistDBDataSource$getList$10.I$0 = v1;
                    musicPlaylistDBDataSource$getList$10.I$1 = 0;
                    musicPlaylistDBDataSource$getList$10.label = 2;
                    object1 = BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$getList$2$10, musicPlaylistDBDataSource$getList$10);
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    throwable1 = throwable0;
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                mutex2 = mutex0;
                object0 = object1;
                list0 = (List)object0;
                goto label_48;
            }
            case 2: {
                mutex2 = (Mutex)musicPlaylistDBDataSource$getList$10.L$0;
                try {
                    n.D(object0);
                    list0 = (List)object0;
                    goto label_48;
                }
                catch(Throwable throwable1) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable1;
    label_48:
        mutex2.unlock(null);
        return list0;
    }

    @Nullable
    public final Object remove(@NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.remove.1 musicPlaylistDBDataSource$remove$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.remove.1) {
            musicPlaylistDBDataSource$remove$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.remove.1)continuation0;
            int v = musicPlaylistDBDataSource$remove$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$remove$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.remove(null, this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$remove$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$remove$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.remove(null, this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$remove$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$remove$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                musicPlaylistDBDataSource$remove$10.L$0 = list0;
                musicPlaylistDBDataSource$remove$10.L$1 = mutex0;
                musicPlaylistDBDataSource$remove$10.I$0 = 0;
                musicPlaylistDBDataSource$remove$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$remove$10) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    goto label_30;
                }
                return a0;
            }
            case 1: {
                int v2 = musicPlaylistDBDataSource$remove$10.I$0;
                mutex1 = (Mutex)musicPlaylistDBDataSource$remove$10.L$1;
                List list1 = (List)musicPlaylistDBDataSource$remove$10.L$0;
                n.D(object0);
                v1 = v2;
                list0 = list1;
                try {
                label_30:
                    LogU.debug$default(this.log, "remove start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.remove.2.1 musicPlaylistDBDataSource$remove$2$10 = new we.n(list0, null) {
                        final List $removedList;
                        int label;

                        {
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            this.$removedList = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.remove.2.1(MusicPlaylistDBDataSource.this, this.$removedList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.remove.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return MusicPlaylistDBDataSource.this.playlistDao.deleteMusicList(this.$removedList, this) == a0 ? a0 : H.a;
                                }
                                case 1: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    musicPlaylistDBDataSource$remove$10.L$0 = null;
                    musicPlaylistDBDataSource$remove$10.L$1 = mutex1;
                    musicPlaylistDBDataSource$remove$10.I$0 = v1;
                    musicPlaylistDBDataSource$remove$10.I$1 = 0;
                    musicPlaylistDBDataSource$remove$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$remove$2$10, musicPlaylistDBDataSource$remove$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    break;
                }
                mutex2 = mutex1;
                goto label_48;
            }
            case 2: {
                mutex2 = (Mutex)musicPlaylistDBDataSource$remove$10.L$1;
                List list2 = (List)musicPlaylistDBDataSource$remove$10.L$0;
                try {
                    n.D(object0);
                label_48:
                    LogU.debug$default(this.log, "remove end", null, false, 6, null);
                    goto label_53;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_53:
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object removeAndAdd(@NotNull List list0, @NotNull Collection collection0, @NotNull List list1, @NotNull Continuation continuation0) {
        Mutex mutex3;
        int v1;
        List list3;
        Collection collection1;
        Mutex mutex1;
        List list2;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.removeAndAdd.1 musicPlaylistDBDataSource$removeAndAdd$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.removeAndAdd.1) {
            musicPlaylistDBDataSource$removeAndAdd$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.removeAndAdd.1)continuation0;
            int v = musicPlaylistDBDataSource$removeAndAdd$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$removeAndAdd$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.removeAndAdd(null, null, null, this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$removeAndAdd$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$removeAndAdd$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.removeAndAdd(null, null, null, this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$removeAndAdd$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$removeAndAdd$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                list2 = list0;
                musicPlaylistDBDataSource$removeAndAdd$10.L$0 = list2;
                musicPlaylistDBDataSource$removeAndAdd$10.L$1 = collection0;
                musicPlaylistDBDataSource$removeAndAdd$10.L$2 = list1;
                musicPlaylistDBDataSource$removeAndAdd$10.L$3 = mutex0;
                musicPlaylistDBDataSource$removeAndAdd$10.I$0 = 0;
                musicPlaylistDBDataSource$removeAndAdd$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$removeAndAdd$10) != a0) {
                    mutex1 = mutex0;
                    collection1 = collection0;
                    list3 = list1;
                    v1 = 0;
                    goto label_39;
                }
                return a0;
            }
            case 1: {
                int v2 = musicPlaylistDBDataSource$removeAndAdd$10.I$0;
                Mutex mutex2 = (Mutex)musicPlaylistDBDataSource$removeAndAdd$10.L$3;
                list3 = (List)musicPlaylistDBDataSource$removeAndAdd$10.L$2;
                Collection collection2 = (Collection)musicPlaylistDBDataSource$removeAndAdd$10.L$1;
                List list4 = (List)musicPlaylistDBDataSource$removeAndAdd$10.L$0;
                n.D(object0);
                v1 = v2;
                list2 = list4;
                mutex1 = mutex2;
                collection1 = collection2;
                try {
                label_39:
                    LogU.debug$default(this.log, "removeAndAdd start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.removeAndAdd.2.1 musicPlaylistDBDataSource$removeAndAdd$2$10 = new we.n(list2, collection1, list3, null) {
                        final Collection $addList;
                        final List $allOrderedList;
                        final List $removedList;
                        int label;

                        {
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            this.$removedList = list0;
                            this.$addList = collection0;
                            this.$allOrderedList = list1;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.removeAndAdd.2.1(MusicPlaylistDBDataSource.this, this.$removedList, this.$addList, this.$allOrderedList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.removeAndAdd.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    MusicPlaylistDao musicPlaylistDao0 = MusicPlaylistDBDataSource.this.playlistDao;
                                    List list0 = this.$removedList;
                                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.$addList));
                                    for(Object object1: this.$addList) {
                                        arrayList0.add(PlayableExtensionsKt.toMusicEntity(((Playable)object1)));
                                    }
                                    this.label = 1;
                                    return musicPlaylistDao0.deleteAndInsertMusicsAndUpdateOrderInTransaction(list0, arrayList0, this.$allOrderedList, this) == a0 ? a0 : H.a;
                                }
                                case 1: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    musicPlaylistDBDataSource$removeAndAdd$10.L$0 = null;
                    musicPlaylistDBDataSource$removeAndAdd$10.L$1 = null;
                    musicPlaylistDBDataSource$removeAndAdd$10.L$2 = null;
                    musicPlaylistDBDataSource$removeAndAdd$10.L$3 = mutex1;
                    musicPlaylistDBDataSource$removeAndAdd$10.I$0 = v1;
                    musicPlaylistDBDataSource$removeAndAdd$10.I$1 = 0;
                    musicPlaylistDBDataSource$removeAndAdd$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$removeAndAdd$2$10, musicPlaylistDBDataSource$removeAndAdd$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex3 = mutex1;
                    break;
                }
                mutex3 = mutex1;
                goto label_61;
            }
            case 2: {
                mutex3 = (Mutex)musicPlaylistDBDataSource$removeAndAdd$10.L$3;
                List list5 = (List)musicPlaylistDBDataSource$removeAndAdd$10.L$2;
                Collection collection3 = (Collection)musicPlaylistDBDataSource$removeAndAdd$10.L$1;
                List list6 = (List)musicPlaylistDBDataSource$removeAndAdd$10.L$0;
                try {
                    n.D(object0);
                label_61:
                    LogU.debug$default(this.log, "removeAndAdd end", null, false, 6, null);
                    goto label_66;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex3.unlock(null);
        throw throwable0;
    label_66:
        mutex3.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object updateAllList(@NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateAllList.1 musicPlaylistDBDataSource$updateAllList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateAllList.1) {
            musicPlaylistDBDataSource$updateAllList$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateAllList.1)continuation0;
            int v = musicPlaylistDBDataSource$updateAllList$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$updateAllList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateAllList(null, this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$updateAllList$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$updateAllList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateAllList(null, this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$updateAllList$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$updateAllList$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                musicPlaylistDBDataSource$updateAllList$10.L$0 = list0;
                musicPlaylistDBDataSource$updateAllList$10.L$1 = mutex0;
                musicPlaylistDBDataSource$updateAllList$10.I$0 = 0;
                musicPlaylistDBDataSource$updateAllList$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$updateAllList$10) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    goto label_30;
                }
                return a0;
            }
            case 1: {
                int v2 = musicPlaylistDBDataSource$updateAllList$10.I$0;
                mutex1 = (Mutex)musicPlaylistDBDataSource$updateAllList$10.L$1;
                List list1 = (List)musicPlaylistDBDataSource$updateAllList$10.L$0;
                n.D(object0);
                v1 = v2;
                list0 = list1;
                try {
                label_30:
                    LogU.debug$default(this.log, "updateAllList - start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateAllList.2.1 musicPlaylistDBDataSource$updateAllList$2$10 = new we.n(list0, null) {
                        final List $list;
                        int label;

                        {
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            this.$list = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateAllList.2.1(MusicPlaylistDBDataSource.this, this.$list, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateAllList.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return MusicPlaylistDBDataSource.this.playlistDao.clearAndInsertMusicInTransaction(this.$list, this) == a0 ? a0 : H.a;
                                }
                                case 1: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    musicPlaylistDBDataSource$updateAllList$10.L$0 = null;
                    musicPlaylistDBDataSource$updateAllList$10.L$1 = mutex1;
                    musicPlaylistDBDataSource$updateAllList$10.I$0 = v1;
                    musicPlaylistDBDataSource$updateAllList$10.I$1 = 0;
                    musicPlaylistDBDataSource$updateAllList$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$updateAllList$2$10, musicPlaylistDBDataSource$updateAllList$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    break;
                }
                mutex2 = mutex1;
                goto label_48;
            }
            case 2: {
                mutex2 = (Mutex)musicPlaylistDBDataSource$updateAllList$10.L$1;
                List list2 = (List)musicPlaylistDBDataSource$updateAllList$10.L$0;
                try {
                    n.D(object0);
                label_48:
                    LogU.debug$default(this.log, "updateAllList - end", null, false, 6, null);
                    goto label_53;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_53:
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object updateDisplayOrder(@NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateDisplayOrder.1 musicPlaylistDBDataSource$updateDisplayOrder$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateDisplayOrder.1) {
            musicPlaylistDBDataSource$updateDisplayOrder$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateDisplayOrder.1)continuation0;
            int v = musicPlaylistDBDataSource$updateDisplayOrder$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$updateDisplayOrder$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateDisplayOrder(null, this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$updateDisplayOrder$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$updateDisplayOrder$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateDisplayOrder(null, this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$updateDisplayOrder$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$updateDisplayOrder$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                musicPlaylistDBDataSource$updateDisplayOrder$10.L$0 = list0;
                musicPlaylistDBDataSource$updateDisplayOrder$10.L$1 = mutex0;
                musicPlaylistDBDataSource$updateDisplayOrder$10.I$0 = 0;
                musicPlaylistDBDataSource$updateDisplayOrder$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$updateDisplayOrder$10) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    goto label_30;
                }
                return a0;
            }
            case 1: {
                int v2 = musicPlaylistDBDataSource$updateDisplayOrder$10.I$0;
                mutex1 = (Mutex)musicPlaylistDBDataSource$updateDisplayOrder$10.L$1;
                List list1 = (List)musicPlaylistDBDataSource$updateDisplayOrder$10.L$0;
                n.D(object0);
                v1 = v2;
                list0 = list1;
                try {
                label_30:
                    LogU.debug$default(this.log, "updateDisplayOrder - start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateDisplayOrder.2.1 musicPlaylistDBDataSource$updateDisplayOrder$2$10 = new we.n(list0, null) {
                        final List $allOrderedList;
                        int label;

                        {
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            this.$allOrderedList = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateDisplayOrder.2.1(MusicPlaylistDBDataSource.this, this.$allOrderedList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updateDisplayOrder.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return MusicPlaylistDBDataSource.this.playlistDao.updateDisPlayOrderMusicList(this.$allOrderedList, this) == a0 ? a0 : H.a;
                                }
                                case 1: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    musicPlaylistDBDataSource$updateDisplayOrder$10.L$0 = null;
                    musicPlaylistDBDataSource$updateDisplayOrder$10.L$1 = mutex1;
                    musicPlaylistDBDataSource$updateDisplayOrder$10.I$0 = v1;
                    musicPlaylistDBDataSource$updateDisplayOrder$10.I$1 = 0;
                    musicPlaylistDBDataSource$updateDisplayOrder$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$updateDisplayOrder$2$10, musicPlaylistDBDataSource$updateDisplayOrder$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    break;
                }
                mutex2 = mutex1;
                goto label_48;
            }
            case 2: {
                mutex2 = (Mutex)musicPlaylistDBDataSource$updateDisplayOrder$10.L$1;
                List list2 = (List)musicPlaylistDBDataSource$updateDisplayOrder$10.L$0;
                try {
                    n.D(object0);
                label_48:
                    LogU.debug$default(this.log, "updateDisplayOrder - end", null, false, 6, null);
                    goto label_53;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_53:
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object updatePlayableInfos(@NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex1;
        com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updatePlayableInfos.1 musicPlaylistDBDataSource$updatePlayableInfos$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updatePlayableInfos.1) {
            musicPlaylistDBDataSource$updatePlayableInfos$10 = (com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updatePlayableInfos.1)continuation0;
            int v = musicPlaylistDBDataSource$updatePlayableInfos$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDBDataSource$updatePlayableInfos$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updatePlayableInfos(null, this);
                    }
                };
            }
            else {
                musicPlaylistDBDataSource$updatePlayableInfos$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDBDataSource$updatePlayableInfos$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updatePlayableInfos(null, this);
                }
            };
        }
        Object object0 = musicPlaylistDBDataSource$updatePlayableInfos$10.result;
        a a0 = a.a;
        switch(musicPlaylistDBDataSource$updatePlayableInfos$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                musicPlaylistDBDataSource$updatePlayableInfos$10.L$0 = list0;
                musicPlaylistDBDataSource$updatePlayableInfos$10.L$1 = mutex0;
                musicPlaylistDBDataSource$updatePlayableInfos$10.I$0 = 0;
                musicPlaylistDBDataSource$updatePlayableInfos$10.label = 1;
                if(mutex0.lock(null, musicPlaylistDBDataSource$updatePlayableInfos$10) != a0) {
                    mutex1 = mutex0;
                    v1 = 0;
                    goto label_30;
                }
                return a0;
            }
            case 1: {
                int v2 = musicPlaylistDBDataSource$updatePlayableInfos$10.I$0;
                mutex1 = (Mutex)musicPlaylistDBDataSource$updatePlayableInfos$10.L$1;
                List list1 = (List)musicPlaylistDBDataSource$updatePlayableInfos$10.L$0;
                n.D(object0);
                v1 = v2;
                list0 = list1;
                try {
                label_30:
                    LogU.debug$default(this.log, "updatePlayableInfos - start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updatePlayableInfos.2.1 musicPlaylistDBDataSource$updatePlayableInfos$2$10 = new we.n(list0, null) {
                        final List $list;
                        int label;

                        {
                            MusicPlaylistDBDataSource.this = musicPlaylistDBDataSource0;
                            this.$list = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updatePlayableInfos.2.1(MusicPlaylistDBDataSource.this, this.$list, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource.updatePlayableInfos.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    Object object1 = MusicPlaylistDBDataSource.this.playlistDao.updateMusicEntitys(this.$list, this);
                                    return object1 == a0 ? a0 : object1;
                                }
                                case 1: {
                                    n.D(object0);
                                    return object0;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    musicPlaylistDBDataSource$updatePlayableInfos$10.L$0 = null;
                    musicPlaylistDBDataSource$updatePlayableInfos$10.L$1 = mutex1;
                    musicPlaylistDBDataSource$updatePlayableInfos$10.I$0 = v1;
                    musicPlaylistDBDataSource$updatePlayableInfos$10.I$1 = 0;
                    musicPlaylistDBDataSource$updatePlayableInfos$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), musicPlaylistDBDataSource$updatePlayableInfos$2$10, musicPlaylistDBDataSource$updatePlayableInfos$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex1;
                    break;
                }
                mutex2 = mutex1;
                goto label_48;
            }
            case 2: {
                mutex2 = (Mutex)musicPlaylistDBDataSource$updatePlayableInfos$10.L$1;
                List list2 = (List)musicPlaylistDBDataSource$updatePlayableInfos$10.L$0;
                try {
                    n.D(object0);
                label_48:
                    LogU.debug$default(this.log, "updatePlayableInfos - end", null, false, 6, null);
                    goto label_53;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_53:
        mutex2.unlock(null);
        return H.a;
    }
}

