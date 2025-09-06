package com.iloen.melon.playback.playlist.smartplaylist;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableExtensionsKt;
import com.iloen.melon.playback.playlist.db.SmartPlaylistDao;
import com.iloen.melon.playback.playlist.db.entity.PlayableEntityKt;
import com.iloen.melon.playback.playlist.db.entity.SmartEntity;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\b\u0010\tJ,\u0010\u000E\u001A\u00020\r2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u000E\u0010\u000FJ\u001E\u0010\u0011\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J:\u0010\u0014\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\rH\u0086@¢\u0006\u0004\b\u0016\u0010\tJ\u001E\u0010\u0018\u001A\u00020\r2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@¢\u0006\u0004\b\u0018\u0010\u0012J\u001E\u0010\u001A\u001A\u00020\r2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0006H\u0086@¢\u0006\u0004\b\u001A\u0010\u0012J\u001E\u0010\u001B\u001A\u00020\r2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0006H\u0086@¢\u0006\u0004\b\u001B\u0010\u0012R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001CR\u0014\u0010\u001E\u001A\u00020\u001D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0014\u0010!\u001A\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/iloen/melon/playback/playlist/smartplaylist/SmartPlaylistDBDataSource;", "", "Lcom/iloen/melon/playback/playlist/db/SmartPlaylistDao;", "playlistDao", "<init>", "(Lcom/iloen/melon/playback/playlist/db/SmartPlaylistDao;)V", "", "Lcom/iloen/melon/playback/Playable;", "getList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "playables", "myPrefSortedList", "Lie/H;", "add", "(Ljava/util/Collection;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removedList", "remove", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addPlayables", "removeAndAdd", "(Ljava/util/List;Ljava/util/Collection;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAllList", "list", "updateDisplayOrder", "Lcom/iloen/melon/playback/playlist/db/entity/SmartEntity;", "updateAllList", "updatePlayableInfos", "Lcom/iloen/melon/playback/playlist/db/SmartPlaylistDao;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/sync/Mutex;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlaylistDBDataSource {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/playback/playlist/smartplaylist/SmartPlaylistDBDataSource$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    private static final String TAG = "SmartPlaylistDBDataSource";
    @NotNull
    private final Mutex lock;
    @NotNull
    private final LogU log;
    @NotNull
    private final SmartPlaylistDao playlistDao;

    static {
        SmartPlaylistDBDataSource.Companion = new Companion(null);
        SmartPlaylistDBDataSource.$stable = 8;
    }

    @Inject
    public SmartPlaylistDBDataSource(@NotNull SmartPlaylistDao smartPlaylistDao0) {
        q.g(smartPlaylistDao0, "playlistDao");
        super();
        this.playlistDao = smartPlaylistDao0;
        this.log = new LogU("SmartPlaylistDBDataSource");
        this.lock = MutexKt.Mutex$default(false, 1, null);
    }

    @Nullable
    public final Object add(@NotNull Collection collection0, @NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        Throwable throwable1;
        int v1;
        Mutex mutex1;
        List list1;
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.add.1 smartPlaylistDBDataSource$add$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.add.1) {
            smartPlaylistDBDataSource$add$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.add.1)continuation0;
            int v = smartPlaylistDBDataSource$add$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$add$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                smartPlaylistDBDataSource$add$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$add$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = smartPlaylistDBDataSource$add$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$add$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                smartPlaylistDBDataSource$add$10.L$0 = collection0;
                smartPlaylistDBDataSource$add$10.L$1 = list0;
                smartPlaylistDBDataSource$add$10.L$2 = mutex0;
                smartPlaylistDBDataSource$add$10.I$0 = 0;
                smartPlaylistDBDataSource$add$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$add$10) != a0) {
                    list1 = list0;
                    mutex1 = mutex0;
                    v1 = 0;
                    goto label_33;
                }
                return a0;
            }
            case 1: {
                int v2 = smartPlaylistDBDataSource$add$10.I$0;
                mutex1 = (Mutex)smartPlaylistDBDataSource$add$10.L$2;
                list1 = (List)smartPlaylistDBDataSource$add$10.L$1;
                Collection collection1 = (Collection)smartPlaylistDBDataSource$add$10.L$0;
                n.D(object0);
                v1 = v2;
                collection0 = collection1;
                try {
                label_33:
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.add.2.1 smartPlaylistDBDataSource$add$2$10 = new we.n(this, list1, null) {
                        final List $myPrefSortedList;
                        final Collection $playables;
                        Object L$0;
                        int label;

                        {
                            this.$playables = collection0;
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            this.$myPrefSortedList = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.add.2.1(this.$playables, SmartPlaylistDBDataSource.this, this.$myPrefSortedList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.add.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.$playables));
                                    for(Object object1: this.$playables) {
                                        arrayList0.add(PlayableExtensionsKt.toSmartEntity(((Playable)object1)));
                                    }
                                    this.L$0 = null;
                                    this.label = 1;
                                    return SmartPlaylistDBDataSource.this.playlistDao.insertSmartEntitiesAndUpdateOrder(arrayList0, this.$myPrefSortedList, this) == a0 ? a0 : H.a;
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
                    smartPlaylistDBDataSource$add$10.L$0 = null;
                    smartPlaylistDBDataSource$add$10.L$1 = null;
                    smartPlaylistDBDataSource$add$10.L$2 = mutex1;
                    smartPlaylistDBDataSource$add$10.I$0 = v1;
                    smartPlaylistDBDataSource$add$10.I$1 = 0;
                    smartPlaylistDBDataSource$add$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$add$2$10, smartPlaylistDBDataSource$add$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex1;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex1;
                break;
            }
            case 2: {
                mutex2 = (Mutex)smartPlaylistDBDataSource$add$10.L$2;
                List list2 = (List)smartPlaylistDBDataSource$add$10.L$1;
                Collection collection2 = (Collection)smartPlaylistDBDataSource$add$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
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
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.getList.1 smartPlaylistDBDataSource$getList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.getList.1) {
            smartPlaylistDBDataSource$getList$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.getList.1)continuation0;
            int v = smartPlaylistDBDataSource$getList$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$getList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                smartPlaylistDBDataSource$getList$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$getList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = smartPlaylistDBDataSource$getList$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$getList$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                smartPlaylistDBDataSource$getList$10.L$0 = mutex0;
                smartPlaylistDBDataSource$getList$10.I$0 = 0;
                smartPlaylistDBDataSource$getList$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$getList$10) == a0) {
                    return a0;
                }
                v1 = 0;
                goto label_25;
            }
            case 1: {
                v1 = smartPlaylistDBDataSource$getList$10.I$0;
                Mutex mutex1 = (Mutex)smartPlaylistDBDataSource$getList$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_25:
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.getList.2.1 smartPlaylistDBDataSource$getList$2$10 = new we.n(null) {
                        int label;

                        {
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.getList.2.1(SmartPlaylistDBDataSource.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.getList.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            n.D(object0);
                            Iterable iterable0 = SmartPlaylistDBDataSource.this.playlistDao.getAllSmartEntities();
                            ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                            for(Object object1: iterable0) {
                                arrayList0.add(PlayableEntityKt.convertToPlayable(((SmartEntity)object1).getPlayableEntity(), ((SmartEntity)object1).getTrackId()));
                            }
                            return arrayList0;
                        }
                    };
                    smartPlaylistDBDataSource$getList$10.L$0 = mutex0;
                    smartPlaylistDBDataSource$getList$10.I$0 = v1;
                    smartPlaylistDBDataSource$getList$10.I$1 = 0;
                    smartPlaylistDBDataSource$getList$10.label = 2;
                    object1 = BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$getList$2$10, smartPlaylistDBDataSource$getList$10);
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
                mutex2 = (Mutex)smartPlaylistDBDataSource$getList$10.L$0;
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
        Throwable throwable1;
        int v1;
        Mutex mutex0;
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.remove.1 smartPlaylistDBDataSource$remove$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.remove.1) {
            smartPlaylistDBDataSource$remove$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.remove.1)continuation0;
            int v = smartPlaylistDBDataSource$remove$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$remove$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                smartPlaylistDBDataSource$remove$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$remove$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = smartPlaylistDBDataSource$remove$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$remove$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                smartPlaylistDBDataSource$remove$10.L$0 = list0;
                smartPlaylistDBDataSource$remove$10.L$1 = mutex0;
                smartPlaylistDBDataSource$remove$10.I$0 = 0;
                smartPlaylistDBDataSource$remove$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$remove$10) != a0) {
                    v1 = 0;
                    goto label_30;
                }
                return a0;
            }
            case 1: {
                int v2 = smartPlaylistDBDataSource$remove$10.I$0;
                Mutex mutex1 = (Mutex)smartPlaylistDBDataSource$remove$10.L$1;
                List list1 = (List)smartPlaylistDBDataSource$remove$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                list0 = list1;
                try {
                label_30:
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.remove.2.1 smartPlaylistDBDataSource$remove$2$10 = new we.n(list0, null) {
                        final List $removedList;
                        int label;

                        {
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            this.$removedList = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.remove.2.1(SmartPlaylistDBDataSource.this, this.$removedList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.remove.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return SmartPlaylistDBDataSource.this.playlistDao.deleteSmartEntities(this.$removedList, this) == a0 ? a0 : H.a;
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
                    smartPlaylistDBDataSource$remove$10.L$0 = null;
                    smartPlaylistDBDataSource$remove$10.L$1 = mutex0;
                    smartPlaylistDBDataSource$remove$10.I$0 = v1;
                    smartPlaylistDBDataSource$remove$10.I$1 = 0;
                    smartPlaylistDBDataSource$remove$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$remove$2$10, smartPlaylistDBDataSource$remove$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                mutex2 = (Mutex)smartPlaylistDBDataSource$remove$10.L$1;
                List list2 = (List)smartPlaylistDBDataSource$remove$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object removeAllList(@NotNull Continuation continuation0) {
        Throwable throwable1;
        Mutex mutex2;
        int v1;
        Mutex mutex0;
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAllList.1 smartPlaylistDBDataSource$removeAllList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAllList.1) {
            smartPlaylistDBDataSource$removeAllList$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAllList.1)continuation0;
            int v = smartPlaylistDBDataSource$removeAllList$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$removeAllList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        return continuation0.removeAllList(this);
                    }
                };
            }
            else {
                smartPlaylistDBDataSource$removeAllList$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$removeAllList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                    return continuation0.removeAllList(this);
                }
            };
        }
        Object object0 = smartPlaylistDBDataSource$removeAllList$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$removeAllList$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                smartPlaylistDBDataSource$removeAllList$10.L$0 = mutex0;
                smartPlaylistDBDataSource$removeAllList$10.I$0 = 0;
                smartPlaylistDBDataSource$removeAllList$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$removeAllList$10) != a0) {
                    v1 = 0;
                    goto label_26;
                }
                return a0;
            }
            case 1: {
                v1 = smartPlaylistDBDataSource$removeAllList$10.I$0;
                Mutex mutex1 = (Mutex)smartPlaylistDBDataSource$removeAllList$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                try {
                label_26:
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAllList.2.1 smartPlaylistDBDataSource$removeAllList$2$10 = new we.n(null) {
                        int label;

                        {
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAllList.2.1(SmartPlaylistDBDataSource.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAllList.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return SmartPlaylistDBDataSource.this.playlistDao.deleteAllSmartEntities(this) == a0 ? a0 : H.a;
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
                    smartPlaylistDBDataSource$removeAllList$10.L$0 = mutex0;
                    smartPlaylistDBDataSource$removeAllList$10.I$0 = v1;
                    smartPlaylistDBDataSource$removeAllList$10.I$1 = 0;
                    smartPlaylistDBDataSource$removeAllList$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$removeAllList$2$10, smartPlaylistDBDataSource$removeAllList$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    throwable1 = throwable0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                mutex2 = (Mutex)smartPlaylistDBDataSource$removeAllList$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
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
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAndAdd.1 smartPlaylistDBDataSource$removeAndAdd$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAndAdd.1) {
            smartPlaylistDBDataSource$removeAndAdd$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAndAdd.1)continuation0;
            int v = smartPlaylistDBDataSource$removeAndAdd$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$removeAndAdd$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                smartPlaylistDBDataSource$removeAndAdd$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$removeAndAdd$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = smartPlaylistDBDataSource$removeAndAdd$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$removeAndAdd$10.label) {
            case 0: {
                n.D(object0);
                Mutex mutex0 = this.lock;
                list2 = list0;
                smartPlaylistDBDataSource$removeAndAdd$10.L$0 = list2;
                smartPlaylistDBDataSource$removeAndAdd$10.L$1 = collection0;
                smartPlaylistDBDataSource$removeAndAdd$10.L$2 = list1;
                smartPlaylistDBDataSource$removeAndAdd$10.L$3 = mutex0;
                smartPlaylistDBDataSource$removeAndAdd$10.I$0 = 0;
                smartPlaylistDBDataSource$removeAndAdd$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$removeAndAdd$10) != a0) {
                    mutex1 = mutex0;
                    collection1 = collection0;
                    list3 = list1;
                    v1 = 0;
                    goto label_39;
                }
                return a0;
            }
            case 1: {
                int v2 = smartPlaylistDBDataSource$removeAndAdd$10.I$0;
                Mutex mutex2 = (Mutex)smartPlaylistDBDataSource$removeAndAdd$10.L$3;
                list3 = (List)smartPlaylistDBDataSource$removeAndAdd$10.L$2;
                Collection collection2 = (Collection)smartPlaylistDBDataSource$removeAndAdd$10.L$1;
                List list4 = (List)smartPlaylistDBDataSource$removeAndAdd$10.L$0;
                n.D(object0);
                v1 = v2;
                list2 = list4;
                mutex1 = mutex2;
                collection1 = collection2;
                try {
                label_39:
                    LogU.debug$default(this.log, "removeAndAdd start", null, false, 6, null);
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAndAdd.2.1 smartPlaylistDBDataSource$removeAndAdd$2$10 = new we.n(list2, collection1, list3, null) {
                        final Collection $addPlayables;
                        final List $myPrefSortedList;
                        final List $removedList;
                        int label;

                        {
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            this.$removedList = list0;
                            this.$addPlayables = collection0;
                            this.$myPrefSortedList = list1;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAndAdd.2.1(SmartPlaylistDBDataSource.this, this.$removedList, this.$addPlayables, this.$myPrefSortedList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.removeAndAdd.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    SmartPlaylistDao smartPlaylistDao0 = SmartPlaylistDBDataSource.this.playlistDao;
                                    List list0 = this.$removedList;
                                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.$addPlayables));
                                    for(Object object1: this.$addPlayables) {
                                        arrayList0.add(PlayableExtensionsKt.toSmartEntity(((Playable)object1)));
                                    }
                                    this.label = 1;
                                    return smartPlaylistDao0.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(list0, arrayList0, this.$myPrefSortedList, this) == a0 ? a0 : H.a;
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
                    smartPlaylistDBDataSource$removeAndAdd$10.L$0 = null;
                    smartPlaylistDBDataSource$removeAndAdd$10.L$1 = null;
                    smartPlaylistDBDataSource$removeAndAdd$10.L$2 = null;
                    smartPlaylistDBDataSource$removeAndAdd$10.L$3 = mutex1;
                    smartPlaylistDBDataSource$removeAndAdd$10.I$0 = v1;
                    smartPlaylistDBDataSource$removeAndAdd$10.I$1 = 0;
                    smartPlaylistDBDataSource$removeAndAdd$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$removeAndAdd$2$10, smartPlaylistDBDataSource$removeAndAdd$10) == a0) {
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
                mutex3 = (Mutex)smartPlaylistDBDataSource$removeAndAdd$10.L$3;
                List list5 = (List)smartPlaylistDBDataSource$removeAndAdd$10.L$2;
                Collection collection3 = (Collection)smartPlaylistDBDataSource$removeAndAdd$10.L$1;
                List list6 = (List)smartPlaylistDBDataSource$removeAndAdd$10.L$0;
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
        Throwable throwable1;
        int v1;
        Mutex mutex0;
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateAllList.1 smartPlaylistDBDataSource$updateAllList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateAllList.1) {
            smartPlaylistDBDataSource$updateAllList$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateAllList.1)continuation0;
            int v = smartPlaylistDBDataSource$updateAllList$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$updateAllList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                smartPlaylistDBDataSource$updateAllList$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$updateAllList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = smartPlaylistDBDataSource$updateAllList$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$updateAllList$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                smartPlaylistDBDataSource$updateAllList$10.L$0 = list0;
                smartPlaylistDBDataSource$updateAllList$10.L$1 = mutex0;
                smartPlaylistDBDataSource$updateAllList$10.I$0 = 0;
                smartPlaylistDBDataSource$updateAllList$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$updateAllList$10) != a0) {
                    v1 = 0;
                    goto label_30;
                }
                return a0;
            }
            case 1: {
                int v2 = smartPlaylistDBDataSource$updateAllList$10.I$0;
                Mutex mutex1 = (Mutex)smartPlaylistDBDataSource$updateAllList$10.L$1;
                List list1 = (List)smartPlaylistDBDataSource$updateAllList$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                list0 = list1;
                try {
                label_30:
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateAllList.2.1 smartPlaylistDBDataSource$updateAllList$2$10 = new we.n(list0, null) {
                        final List $list;
                        int label;

                        {
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            this.$list = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateAllList.2.1(SmartPlaylistDBDataSource.this, this.$list, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateAllList.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return SmartPlaylistDBDataSource.this.playlistDao.clearAndInsertSmartEntities(this.$list, this) == a0 ? a0 : H.a;
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
                    smartPlaylistDBDataSource$updateAllList$10.L$0 = null;
                    smartPlaylistDBDataSource$updateAllList$10.L$1 = mutex0;
                    smartPlaylistDBDataSource$updateAllList$10.I$0 = v1;
                    smartPlaylistDBDataSource$updateAllList$10.I$1 = 0;
                    smartPlaylistDBDataSource$updateAllList$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$updateAllList$2$10, smartPlaylistDBDataSource$updateAllList$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                mutex2 = (Mutex)smartPlaylistDBDataSource$updateAllList$10.L$1;
                List list2 = (List)smartPlaylistDBDataSource$updateAllList$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object updateDisplayOrder(@NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        Throwable throwable1;
        int v1;
        Mutex mutex0;
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateDisplayOrder.1 smartPlaylistDBDataSource$updateDisplayOrder$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateDisplayOrder.1) {
            smartPlaylistDBDataSource$updateDisplayOrder$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateDisplayOrder.1)continuation0;
            int v = smartPlaylistDBDataSource$updateDisplayOrder$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$updateDisplayOrder$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                smartPlaylistDBDataSource$updateDisplayOrder$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$updateDisplayOrder$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = smartPlaylistDBDataSource$updateDisplayOrder$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$updateDisplayOrder$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                smartPlaylistDBDataSource$updateDisplayOrder$10.L$0 = list0;
                smartPlaylistDBDataSource$updateDisplayOrder$10.L$1 = mutex0;
                smartPlaylistDBDataSource$updateDisplayOrder$10.I$0 = 0;
                smartPlaylistDBDataSource$updateDisplayOrder$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$updateDisplayOrder$10) != a0) {
                    v1 = 0;
                    goto label_30;
                }
                return a0;
            }
            case 1: {
                int v2 = smartPlaylistDBDataSource$updateDisplayOrder$10.I$0;
                Mutex mutex1 = (Mutex)smartPlaylistDBDataSource$updateDisplayOrder$10.L$1;
                List list1 = (List)smartPlaylistDBDataSource$updateDisplayOrder$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                list0 = list1;
                try {
                label_30:
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateDisplayOrder.2.1 smartPlaylistDBDataSource$updateDisplayOrder$2$10 = new we.n(list0, null) {
                        final List $list;
                        int label;

                        {
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            this.$list = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateDisplayOrder.2.1(SmartPlaylistDBDataSource.this, this.$list, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updateDisplayOrder.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    return SmartPlaylistDBDataSource.this.playlistDao.updateOrdersSmart(this.$list, this) == a0 ? a0 : H.a;
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
                    smartPlaylistDBDataSource$updateDisplayOrder$10.L$0 = null;
                    smartPlaylistDBDataSource$updateDisplayOrder$10.L$1 = mutex0;
                    smartPlaylistDBDataSource$updateDisplayOrder$10.I$0 = v1;
                    smartPlaylistDBDataSource$updateDisplayOrder$10.I$1 = 0;
                    smartPlaylistDBDataSource$updateDisplayOrder$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$updateDisplayOrder$2$10, smartPlaylistDBDataSource$updateDisplayOrder$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable1;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                mutex2 = (Mutex)smartPlaylistDBDataSource$updateDisplayOrder$10.L$1;
                List list2 = (List)smartPlaylistDBDataSource$updateDisplayOrder$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                mutex2.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    @Nullable
    public final Object updatePlayableInfos(@NotNull List list0, @NotNull Continuation continuation0) {
        Mutex mutex2;
        Throwable throwable1;
        Object object1;
        int v1;
        Mutex mutex0;
        com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updatePlayableInfos.1 smartPlaylistDBDataSource$updatePlayableInfos$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updatePlayableInfos.1) {
            smartPlaylistDBDataSource$updatePlayableInfos$10 = (com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updatePlayableInfos.1)continuation0;
            int v = smartPlaylistDBDataSource$updatePlayableInfos$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDBDataSource$updatePlayableInfos$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                smartPlaylistDBDataSource$updatePlayableInfos$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDBDataSource$updatePlayableInfos$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = smartPlaylistDBDataSource$updatePlayableInfos$10.result;
        a a0 = a.a;
        switch(smartPlaylistDBDataSource$updatePlayableInfos$10.label) {
            case 0: {
                n.D(object0);
                mutex0 = this.lock;
                smartPlaylistDBDataSource$updatePlayableInfos$10.L$0 = list0;
                smartPlaylistDBDataSource$updatePlayableInfos$10.L$1 = mutex0;
                smartPlaylistDBDataSource$updatePlayableInfos$10.I$0 = 0;
                smartPlaylistDBDataSource$updatePlayableInfos$10.label = 1;
                if(mutex0.lock(null, smartPlaylistDBDataSource$updatePlayableInfos$10) == a0) {
                    return a0;
                }
                v1 = 0;
                goto label_29;
            }
            case 1: {
                int v2 = smartPlaylistDBDataSource$updatePlayableInfos$10.I$0;
                Mutex mutex1 = (Mutex)smartPlaylistDBDataSource$updatePlayableInfos$10.L$1;
                List list1 = (List)smartPlaylistDBDataSource$updatePlayableInfos$10.L$0;
                n.D(object0);
                mutex0 = mutex1;
                v1 = v2;
                list0 = list1;
                try {
                label_29:
                    com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updatePlayableInfos.2.1 smartPlaylistDBDataSource$updatePlayableInfos$2$10 = new we.n(list0, null) {
                        final List $list;
                        int label;

                        {
                            SmartPlaylistDBDataSource.this = smartPlaylistDBDataSource0;
                            this.$list = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updatePlayableInfos.2.1(SmartPlaylistDBDataSource.this, this.$list, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource.updatePlayableInfos.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    this.label = 1;
                                    Object object1 = SmartPlaylistDBDataSource.this.playlistDao.updateSmartEntities(this.$list, this);
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
                    smartPlaylistDBDataSource$updatePlayableInfos$10.L$0 = null;
                    smartPlaylistDBDataSource$updatePlayableInfos$10.L$1 = mutex0;
                    smartPlaylistDBDataSource$updatePlayableInfos$10.I$0 = v1;
                    smartPlaylistDBDataSource$updatePlayableInfos$10.I$1 = 0;
                    smartPlaylistDBDataSource$updatePlayableInfos$10.label = 2;
                    object1 = BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistDBDataSource$updatePlayableInfos$2$10, smartPlaylistDBDataSource$updatePlayableInfos$10);
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    mutex2 = mutex0;
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                mutex2 = mutex0;
                goto label_49;
            }
            case 2: {
                mutex2 = (Mutex)smartPlaylistDBDataSource$updatePlayableInfos$10.L$1;
                List list2 = (List)smartPlaylistDBDataSource$updatePlayableInfos$10.L$0;
                try {
                    n.D(object0);
                label_49:
                    ((Number)object0).intValue();
                    goto label_54;
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
    label_54:
        mutex2.unlock(null);
        return H.a;
    }
}

