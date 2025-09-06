package com.iloen.melon.playback;

import A7.d;
import E9.w;
import G8.g;
import H0.b;
import H8.i;
import H8.k;
import M6.B;
import Ma.m;
import U4.x;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.drm.DcfExtendResult;
import com.iloen.melon.fragments.artistchannel.viewholder.f;
import com.iloen.melon.playback.playlist.LocalDownloadablePlaylist;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import je.p;
import je.q;
import k8.Y;
import k8.o;
import k8.t;
import kc.L2;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.B0;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\"\u0010\f\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0086@\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0012\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0086@\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\u0006\u0010\u0015\u001A\u00020\u0014H\u0086@\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001B\u0010\u001C\u001A\u00020\u00062\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\t\u00A2\u0006\u0004\b\u001C\u0010\u001DJ(\u0010\u001E\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\tH\u0086@\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0016\u0010!\u001A\b\u0012\u0004\u0012\u00020 0\tH\u0082@\u00A2\u0006\u0004\b!\u0010\"J2\u0010&\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\u0006\u0010#\u001A\u00020 2\u0006\u0010%\u001A\u00020$2\u0006\u0010\u000F\u001A\u00020\u000EH\u0082@\u00A2\u0006\u0004\b&\u0010\'J(\u0010)\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\f\u0010(\u001A\b\u0012\u0004\u0012\u00020\u000E0\tH\u0082@\u00A2\u0006\u0004\b)\u0010\u001FJ0\u0010*\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\u0006\u0010#\u001A\u00020 2\f\u0010(\u001A\b\u0012\u0004\u0012\u00020\u000E0\tH\u0082@\u00A2\u0006\u0004\b*\u0010+J#\u0010-\u001A\u0004\u0018\u00010\u000E*\b\u0012\u0004\u0012\u00020\u000E0\t2\u0006\u0010,\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b-\u0010.J(\u00101\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\f\u00100\u001A\b\u0012\u0004\u0012\u00020/0\tH\u0082@\u00A2\u0006\u0004\b1\u0010\u001FJ\"\u00102\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\u0006\u0010#\u001A\u00020 H\u0082@\u00A2\u0006\u0004\b2\u00103J$\u00106\u001A\b\u0012\u0004\u0012\u0002050\t2\f\u00104\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0082@\u00A2\u0006\u0004\b6\u0010\u001FJ0\u00108\u001A\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000B2\u0006\u0010#\u001A\u00020 2\f\u00107\u001A\b\u0012\u0004\u0012\u00020\u001A0\tH\u0082@\u00A2\u0006\u0004\b8\u0010+R\u0014\u0010:\u001A\u0002098\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001A\u00020<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010B\u001A\u00020?8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b@\u0010AR\u0014\u0010F\u001A\u00020C8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bD\u0010E\u00A8\u0006G"}, d2 = {"Lcom/iloen/melon/playback/TaskUpdateLocalPlaylists;", "", "<init>", "()V", "Lcom/iloen/melon/types/Song;", "song", "Lie/H;", "updateFromSongAsync", "(Lcom/iloen/melon/types/Song;)V", "", "Lcom/iloen/melon/playback/Playable;", "Lcom/melon/playlist/UpdatedPlayables;", "updateFromSong", "(Lcom/iloen/melon/types/Song;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LH8/k;", "entity", "updateFromLocalContentEntityAsync", "(LH8/k;)V", "updateFromLocalContentEntity", "(LH8/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LI8/p;", "result", "updateFromSyncResultAsync", "(LI8/p;)V", "updateFromSyncResult", "(LI8/p;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/drm/DcfExtendResult;", "resultList", "updateFromDcfExtendResultAsync", "(Ljava/util/List;)V", "updateFromDcfExtendResult", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getRegisteredLocalContentPlaylistIdList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playlistId", "", "downloadSongId", "updatePlaylistFromLocalContentEntity", "(Lcom/iloen/melon/playback/playlist/PlaylistId;ILH8/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatedList", "updateOnMediaFileUpdated", "updatePlaylistOnMediaFileUpdated", "(Lcom/iloen/melon/playback/playlist/PlaylistId;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playable", "findOrNull", "(Ljava/util/List;Lcom/iloen/melon/playback/Playable;)LH8/k;", "", "deletedEntityIds", "updateOnMediaFileDeleted", "updatePlaylistOnMediaFileDeleted", "(Lcom/iloen/melon/playback/playlist/PlaylistId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playables", "", "getDeletedPathListInPlaylist", "successList", "updatePlaylistFromDcfExtendResult", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "LG8/g;", "getLocalContentManager", "()LG8/g;", "localContentManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "playlistManager", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TaskUpdateLocalPlaylists {
    public static final int $stable = 8;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    @NotNull
    private final LogU log;

    public TaskUpdateLocalPlaylists() {
        this.log = new LogU("TaskUpdateLocalPlaylists");
        this.ioDispatcher = Dispatchers.getIO();
    }

    public static CharSequence a(Playable playable0) {
        return TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult$lambda$19$lambda$18(playable0);
    }

    private final k findOrNull(List list0, Playable playable0) {
        if(StorageUtils.isScopedStorage()) {
            for(Object object0: list0) {
                if(StorageUtils.equalsUri(((k)object0).c, "")) {
                    return (k)object0;
                }
                if(false) {
                    break;
                }
            }
            return null;
        }
        for(Object object1: list0) {
            if(StorageUtils.equalsPath(((k)object1).b, "")) {
                return (k)object1;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    private final Object getDeletedPathListInPlaylist(List list0, Continuation continuation0) {
        List list2;
        List list1;
        Object object4;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.1 taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.1) {
            taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.1)continuation0;
            int v = taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getDeletedPathListInPlaylist(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getDeletedPathListInPlaylist(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.label) {
            case 0: {
                ArrayList arrayList0 = b.m(object0);
                ArrayList arrayList1 = new ArrayList();
                for(Object object1: list0) {
                    Playable playable0 = (Playable)object1;
                    if(StorageUtils.isScopedStorage()) {
                        if(!playable0.isOriginLocal()) {
                        }
                    }
                    else if(playable0.isOriginLocal()) {
                    }
                }
                ArrayList arrayList2 = new ArrayList(q.Q(10, arrayList1));
                for(Object object2: arrayList1) {
                    Playable playable1 = (Playable)object2;
                    boolean z = !StorageUtils.isScopedStorage();
                    arrayList2.add("");
                }
                arrayList0.addAll(arrayList2);
                if(!arrayList2.isEmpty()) {
                    if(StorageUtils.isScopedStorage()) {
                        ArrayList arrayList3 = new ArrayList(q.Q(10, arrayList2));
                        for(Object object3: arrayList2) {
                            arrayList3.add(Uri.parse(((String)object3)));
                        }
                        com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.2.existLocalList.2.1 taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$2$existLocalList$2$10 = new n(arrayList3, null) {
                            final List $it;
                            int label;

                            {
                                TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                                this.$it = list0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.2.existLocalList.2.1(TaskUpdateLocalPlaylists.this, this.$it, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.2.existLocalList.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                TaskUpdateLocalPlaylists.this.getLocalContentManager().getClass();
                                kotlin.jvm.internal.q.g(this.$it, "uriList");
                                ArrayList arrayList0 = new ArrayList();
                                ArrayList arrayList1 = new ArrayList(q.Q(10, this.$it));
                                for(Object object1: this.$it) {
                                    arrayList1.add(((Uri)object1).toString());
                                }
                                ArrayList arrayList2 = p.Q0(arrayList1);
                                while(!arrayList2.isEmpty()) {
                                    List list0 = d.p(arrayList2, 500, arrayList2);
                                    arrayList2.removeAll(list0);
                                    i i0 = g.g();
                                    i0.getClass();
                                    StringBuilder stringBuilder0 = Y.p("SELECT uri FROM local_contents WHERE uri in (");
                                    a.a.k(list0.size(), stringBuilder0);
                                    stringBuilder0.append(")");
                                    arrayList0.addAll(((List)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new H8.c(stringBuilder0.toString(), 2, list0))));
                                }
                                return arrayList0;
                            }
                        };
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$0 = null;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$1 = arrayList0;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$2 = arrayList0;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$3 = null;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$4 = null;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.I$0 = 0;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.I$1 = 0;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.label = 1;
                        object4 = BuildersKt.withContext(this.ioDispatcher, taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$2$existLocalList$2$10, taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10);
                        if(object4 == a0) {
                            return a0;
                        }
                    }
                    else {
                        com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.2.existLocalList.3 taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$2$existLocalList$30 = new n(arrayList2, null) {
                            final List $localList;
                            int label;

                            {
                                TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                                this.$localList = list0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.2.existLocalList.3(TaskUpdateLocalPlaylists.this, this.$localList, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.getDeletedPathListInPlaylist.2.existLocalList.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                TaskUpdateLocalPlaylists.this.getLocalContentManager().getClass();
                                kotlin.jvm.internal.q.g(this.$localList, "dataList");
                                ArrayList arrayList0 = new ArrayList();
                                ArrayList arrayList1 = p.Q0(this.$localList);
                                while(!arrayList1.isEmpty()) {
                                    List list0 = d.p(arrayList1, 500, arrayList1);
                                    arrayList1.removeAll(list0);
                                    i i0 = g.g();
                                    i0.getClass();
                                    StringBuilder stringBuilder0 = Y.p("SELECT data FROM local_contents WHERE data in (");
                                    a.a.k(list0.size(), stringBuilder0);
                                    stringBuilder0.append(")");
                                    arrayList0.addAll(((List)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new H8.c(stringBuilder0.toString(), 0, list0))));
                                }
                                return arrayList0;
                            }
                        };
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$0 = null;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$1 = arrayList0;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$2 = arrayList0;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$3 = null;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.I$0 = 0;
                        taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.label = 2;
                        object4 = BuildersKt.withContext(this.ioDispatcher, taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$2$existLocalList$30, taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10);
                        if(object4 == a0) {
                            return a0;
                        }
                    }
                    list1 = arrayList0;
                    object0 = object4;
                    list2 = list1;
                    break;
                }
                return arrayList0;
            }
            case 1: {
                List list3 = (List)taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$4;
                goto label_69;
            }
            case 2: {
            label_69:
                List list4 = (List)taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$3;
                list2 = (List)taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$2;
                list1 = (List)taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$1;
                List list5 = (List)taskUpdateLocalPlaylists$getDeletedPathListInPlaylist$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        list2.removeAll(((List)object0));
        return list1;
    }

    private final g getLocalContentManager() {
        return g.a.m();
    }

    private final s2 getPlaylistManager() {
        return (s2)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).w.get();
    }

    private final Object getRegisteredLocalContentPlaylistIdList(Continuation continuation0) {
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.getRegisteredLocalContentPlaylistIdList.1 taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.getRegisteredLocalContentPlaylistIdList.1) {
            taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.getRegisteredLocalContentPlaylistIdList.1)continuation0;
            int v = taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getRegisteredLocalContentPlaylistIdList(this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getRegisteredLocalContentPlaylistIdList(this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10.label) {
            case 0: {
                d5.n.D(object0);
                d3 d30 = (d3)this.getPlaylistManager();
                L2 l20 = new L2(d30, null);
                B b0 = ListenableFutureKt.future$default(d30.b, null, null, l20, 3, null);
                taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10.label = 1;
                object0 = ListenableFutureKt.await(b0, taskUpdateLocalPlaylists$getRegisteredLocalContentPlaylistIdList$10);
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
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: ((Iterable)object0)) {
            if(((oc.H)object1) instanceof LocalDownloadablePlaylist) {
                arrayList0.add(object1);
            }
        }
        ArrayList arrayList1 = new ArrayList(q.Q(10, arrayList0));
        for(Object object2: arrayList0) {
            arrayList1.add(((oc.H)object2).getId());
        }
        return arrayList1;
    }

    @Nullable
    public final Object updateFromDcfExtendResult(@NotNull List list0, @NotNull Continuation continuation0) {
        List list6;
        int v1;
        List list5;
        List list4;
        Iterator iterator1;
        List list2;
        List list1;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromDcfExtendResult.1 taskUpdateLocalPlaylists$updateFromDcfExtendResult$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromDcfExtendResult.1) {
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromDcfExtendResult.1)continuation0;
            int v = taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updateFromDcfExtendResult$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateFromDcfExtendResult(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateFromDcfExtendResult(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.label) {
            case 0: {
                d5.n.D(object0);
                list1 = new ArrayList();
                for(Object object1: list0) {
                    if(kotlin.jvm.internal.q.b(((DcfExtendResult)object1).b, DcfError.c)) {
                        list1.add(object1);
                    }
                }
                if(list1.isEmpty()) {
                    LogU.debug$default(this.log, "updateFromDcfExtendResult() no success result", null, false, 6, null);
                    return je.w.a;
                }
                list2 = new ArrayList();
                taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$0 = null;
                taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$1 = list1;
                taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$2 = list2;
                taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.label = 1;
                object0 = this.getRegisteredLocalContentPlaylistIdList(taskUpdateLocalPlaylists$updateFromDcfExtendResult$10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_36;
            }
            case 1: {
                list2 = (List)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$2;
                list1 = (List)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$1;
                List list3 = (List)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$0;
                d5.n.D(object0);
            label_36:
                iterator1 = ((Iterable)object0).iterator();
                list4 = list1;
                list5 = list2;
                v1 = 0;
                goto label_52;
            }
            case 2: {
                v1 = taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.I$0;
                list5 = (List)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$7;
                PlaylistId playlistId0 = (PlaylistId)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$6;
                iterator1 = (Iterator)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$4;
                Iterable iterable0 = (Iterable)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$3;
                list6 = (List)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$2;
                list4 = (List)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$1;
                List list7 = (List)taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            list5.addAll(((Collection)object0));
            list5 = list6;
        label_52:
            if(!iterator1.hasNext()) {
                break;
            }
            Object object2 = iterator1.next();
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$0 = null;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$1 = list4;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$2 = list5;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$3 = null;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$4 = iterator1;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$5 = null;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$6 = null;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.L$7 = list5;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.I$0 = v1;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.I$1 = 0;
            taskUpdateLocalPlaylists$updateFromDcfExtendResult$10.label = 2;
            object0 = this.updatePlaylistFromDcfExtendResult(((PlaylistId)object2), list4, taskUpdateLocalPlaylists$updateFromDcfExtendResult$10);
            if(object0 == a0) {
                return a0;
            }
            list6 = list5;
        }
        return list5;
    }

    public final void updateFromDcfExtendResultAsync(@NotNull List list0) {
        kotlin.jvm.internal.q.g(list0, "resultList");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new n(list0, null) {
            final List $resultList;
            int label;

            {
                TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                this.$resultList = list0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromDcfExtendResultAsync.1(TaskUpdateLocalPlaylists.this, this.$resultList, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromDcfExtendResultAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return TaskUpdateLocalPlaylists.this.updateFromDcfExtendResult(this.$resultList, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    @Nullable
    public final Object updateFromLocalContentEntity(@NotNull k k0, @NotNull Continuation continuation0) {
        int v2;
        List list2;
        int v1;
        List list1;
        k k2;
        Iterator iterator0;
        List list0;
        k k1;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromLocalContentEntity.1 taskUpdateLocalPlaylists$updateFromLocalContentEntity$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromLocalContentEntity.1) {
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromLocalContentEntity.1)continuation0;
            int v = taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updateFromLocalContentEntity$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateFromLocalContentEntity(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateFromLocalContentEntity(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.label) {
            case 0: {
                d5.n.D(object0);
                LogU.debug$default(this.log, "updateFromLocalContentEntity() " + k0.d, null, false, 6, null);
                ArrayList arrayList0 = new ArrayList();
                taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$0 = k0;
                taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$1 = arrayList0;
                taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.label = 1;
                Object object1 = this.getRegisteredLocalContentPlaylistIdList(taskUpdateLocalPlaylists$updateFromLocalContentEntity$10);
                if(object1 == a0) {
                    return a0;
                }
                k1 = k0;
                list0 = arrayList0;
                object0 = object1;
                goto label_28;
            }
            case 1: {
                list0 = (List)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$1;
                k1 = (k)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$0;
                d5.n.D(object0);
            label_28:
                iterator0 = ((Iterable)object0).iterator();
                k2 = k1;
                list1 = list0;
                v1 = 0;
                goto label_43;
            }
            case 2: {
                v1 = taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.I$0;
                list1 = (List)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$6;
                PlaylistId playlistId0 = (PlaylistId)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$5;
                iterator0 = (Iterator)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$3;
                Iterable iterable0 = (Iterable)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$2;
                list2 = (List)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$1;
                k2 = (k)taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            list1.addAll(((Collection)object0));
            list1 = list2;
        label_43:
            if(!iterator0.hasNext()) {
                break;
            }
            Object object2 = iterator0.next();
            String s = k2.e;
            kotlin.jvm.internal.q.g(s, "<this>");
            try {
                v2 = -1;
                v2 = Integer.parseInt(s);
            }
            catch(NumberFormatException unused_ex) {
            }
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$0 = k2;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$1 = list1;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$2 = null;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$3 = iterator0;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$4 = null;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$5 = null;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.L$6 = list1;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.I$0 = v1;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.I$1 = 0;
            taskUpdateLocalPlaylists$updateFromLocalContentEntity$10.label = 2;
            object0 = this.updatePlaylistFromLocalContentEntity(((PlaylistId)object2), v2, k2, taskUpdateLocalPlaylists$updateFromLocalContentEntity$10);
            if(object0 == a0) {
                return a0;
            }
            list2 = list1;
        }
        return list1;
    }

    public final void updateFromLocalContentEntityAsync(@NotNull k k0) {
        kotlin.jvm.internal.q.g(k0, "entity");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new n(k0, null) {
            final k $entity;
            int label;

            {
                TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                this.$entity = k0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromLocalContentEntityAsync.1(TaskUpdateLocalPlaylists.this, this.$entity, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromLocalContentEntityAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return TaskUpdateLocalPlaylists.this.updateFromLocalContentEntity(this.$entity, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    @Nullable
    public final Object updateFromSong(@NotNull Song song0, @NotNull Continuation continuation0) {
        int v2;
        List list2;
        int v1;
        Iterator iterator0;
        List list1;
        Song song3;
        k k1;
        List list0;
        Song song2;
        k k0;
        Object object1;
        StringBuilder stringBuilder0;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSong.1 taskUpdateLocalPlaylists$updateFromSong$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSong.1) {
            taskUpdateLocalPlaylists$updateFromSong$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSong.1)continuation0;
            int v = taskUpdateLocalPlaylists$updateFromSong$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updateFromSong$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
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
                        return continuation0.updateFromSong(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updateFromSong$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updateFromSong$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
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
                    return continuation0.updateFromSong(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updateFromSong$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updateFromSong$10.label) {
            case 0: {
                d5.n.D(object0);
                stringBuilder0 = new StringBuilder();
                stringBuilder0.append("updateFromSong() songId: ");
                stringBuilder0.append(song0.b);
                com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSong.entity.1 taskUpdateLocalPlaylists$updateFromSong$entity$10 = new n(this, stringBuilder0, null) {
                    final StringBuilder $builder;
                    final Song $song;
                    int label;

                    {
                        this.$song = song0;
                        TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                        this.$builder = stringBuilder0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSong.entity.1(this.$song, TaskUpdateLocalPlaylists.this, this.$builder, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSong.entity.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        if(StorageUtils.isScopedStorage()) {
                            Song song0 = this.$song;
                            Uri uri0 = song0.j;
                            if(uri0 != null) {
                                TaskUpdateLocalPlaylists.this.getLocalContentManager().getClass();
                                k k0 = g.j(uri0);
                                this.$builder.append(" uri: ");
                                this.$builder.append(song0.j.toString());
                                return k0;
                            }
                        }
                        else {
                            Song song1 = this.$song;
                            String s = song1.a;
                            if(s != null) {
                                TaskUpdateLocalPlaylists.this.getLocalContentManager().getClass();
                                k k1 = g.k(s);
                                this.$builder.append(" path: ");
                                this.$builder.append(song1.a);
                                return k1;
                            }
                        }
                        return null;
                    }
                };
                taskUpdateLocalPlaylists$updateFromSong$10.L$0 = song0;
                taskUpdateLocalPlaylists$updateFromSong$10.L$1 = stringBuilder0;
                taskUpdateLocalPlaylists$updateFromSong$10.label = 1;
                object1 = BuildersKt.withContext(this.ioDispatcher, taskUpdateLocalPlaylists$updateFromSong$entity$10, taskUpdateLocalPlaylists$updateFromSong$10);
                if(object1 == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                StringBuilder stringBuilder1 = (StringBuilder)taskUpdateLocalPlaylists$updateFromSong$10.L$1;
                Song song1 = (Song)taskUpdateLocalPlaylists$updateFromSong$10.L$0;
                d5.n.D(object0);
                stringBuilder0 = stringBuilder1;
                song0 = song1;
                object1 = object0;
            label_30:
                k0 = (k)object1;
                String s = stringBuilder0.toString();
                kotlin.jvm.internal.q.f(s, "toString(...)");
                LogU.debug$default(this.log, s, null, false, 6, null);
                if(k0 != null) {
                    LogU.debug$default(this.log, "updateFromSong() song exist", null, false, 6, null);
                    ArrayList arrayList0 = new ArrayList();
                    taskUpdateLocalPlaylists$updateFromSong$10.L$0 = song0;
                    taskUpdateLocalPlaylists$updateFromSong$10.L$1 = null;
                    taskUpdateLocalPlaylists$updateFromSong$10.L$2 = k0;
                    taskUpdateLocalPlaylists$updateFromSong$10.L$3 = arrayList0;
                    taskUpdateLocalPlaylists$updateFromSong$10.label = 2;
                    Object object2 = this.getRegisteredLocalContentPlaylistIdList(taskUpdateLocalPlaylists$updateFromSong$10);
                    if(object2 == a0) {
                        return a0;
                    }
                    song2 = song0;
                    list0 = arrayList0;
                    object0 = object2;
                    goto label_54;
                }
                return je.w.a;
            }
            case 2: {
                list0 = (List)taskUpdateLocalPlaylists$updateFromSong$10.L$3;
                k0 = (k)taskUpdateLocalPlaylists$updateFromSong$10.L$2;
                StringBuilder stringBuilder2 = (StringBuilder)taskUpdateLocalPlaylists$updateFromSong$10.L$1;
                song2 = (Song)taskUpdateLocalPlaylists$updateFromSong$10.L$0;
                d5.n.D(object0);
            label_54:
                k1 = k0;
                song3 = song2;
                list1 = list0;
                iterator0 = ((Iterable)object0).iterator();
                v1 = 0;
                goto label_72;
            }
            case 3: {
                v1 = taskUpdateLocalPlaylists$updateFromSong$10.I$0;
                list1 = (List)taskUpdateLocalPlaylists$updateFromSong$10.L$8;
                PlaylistId playlistId0 = (PlaylistId)taskUpdateLocalPlaylists$updateFromSong$10.L$7;
                iterator0 = (Iterator)taskUpdateLocalPlaylists$updateFromSong$10.L$5;
                Iterable iterable0 = (Iterable)taskUpdateLocalPlaylists$updateFromSong$10.L$4;
                list2 = (List)taskUpdateLocalPlaylists$updateFromSong$10.L$3;
                k1 = (k)taskUpdateLocalPlaylists$updateFromSong$10.L$2;
                StringBuilder stringBuilder3 = (StringBuilder)taskUpdateLocalPlaylists$updateFromSong$10.L$1;
                song3 = (Song)taskUpdateLocalPlaylists$updateFromSong$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            list1.addAll(((Collection)object0));
            list1 = list2;
        label_72:
            if(!iterator0.hasNext()) {
                break;
            }
            Object object3 = iterator0.next();
            song3.getClass();
            try {
                v2 = -1;
                v2 = Integer.parseInt(song3.b);
            }
            catch(Exception unused_ex) {
            }
            taskUpdateLocalPlaylists$updateFromSong$10.L$0 = song3;
            taskUpdateLocalPlaylists$updateFromSong$10.L$1 = null;
            taskUpdateLocalPlaylists$updateFromSong$10.L$2 = k1;
            taskUpdateLocalPlaylists$updateFromSong$10.L$3 = list1;
            taskUpdateLocalPlaylists$updateFromSong$10.L$4 = null;
            taskUpdateLocalPlaylists$updateFromSong$10.L$5 = iterator0;
            taskUpdateLocalPlaylists$updateFromSong$10.L$6 = null;
            taskUpdateLocalPlaylists$updateFromSong$10.L$7 = null;
            taskUpdateLocalPlaylists$updateFromSong$10.L$8 = list1;
            taskUpdateLocalPlaylists$updateFromSong$10.I$0 = v1;
            taskUpdateLocalPlaylists$updateFromSong$10.I$1 = 0;
            taskUpdateLocalPlaylists$updateFromSong$10.label = 3;
            object0 = this.updatePlaylistFromLocalContentEntity(((PlaylistId)object3), v2, k1, taskUpdateLocalPlaylists$updateFromSong$10);
            if(object0 == a0) {
                return a0;
            }
            list2 = list1;
        }
        return list1;
    }

    public final void updateFromSongAsync(@NotNull Song song0) {
        kotlin.jvm.internal.q.g(song0, "song");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new n(song0, null) {
            final Song $song;
            int label;

            {
                TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                this.$song = song0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSongAsync.1(TaskUpdateLocalPlaylists.this, this.$song, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSongAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return TaskUpdateLocalPlaylists.this.updateFromSong(this.$song, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    @Nullable
    public final Object updateFromSyncResult(@NotNull I8.p p0, @NotNull Continuation continuation0) {
        List list6;
        List list5;
        List list3;
        List list2;
        I8.p p2;
        List list1;
        List list0;
        I8.p p1;
        ArrayList arrayList0;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSyncResult.1 taskUpdateLocalPlaylists$updateFromSyncResult$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSyncResult.1) {
            taskUpdateLocalPlaylists$updateFromSyncResult$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSyncResult.1)continuation0;
            int v = taskUpdateLocalPlaylists$updateFromSyncResult$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updateFromSyncResult$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        return continuation0.updateFromSyncResult(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updateFromSyncResult$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updateFromSyncResult$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                    return continuation0.updateFromSyncResult(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updateFromSyncResult$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updateFromSyncResult$10.label) {
            case 0: {
                d5.n.D(object0);
                LogU.info$default(this.log, "updateFromSyncResult() " + p0, null, false, 6, null);
                arrayList0 = new ArrayList();
                if(!p0.c.isEmpty()) {
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$0 = p0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$1 = arrayList0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$2 = arrayList0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.label = 1;
                    Object object1 = this.updateOnMediaFileDeleted(p0.c, taskUpdateLocalPlaylists$updateFromSyncResult$10);
                    if(object1 == a0) {
                        return a0;
                    }
                    p1 = p0;
                    list0 = arrayList0;
                    object0 = object1;
                    list1 = list0;
                    goto label_32;
                }
                goto label_35;
            }
            case 1: {
                list0 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$2;
                list1 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$1;
                p1 = (I8.p)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$0;
                d5.n.D(object0);
            label_32:
                list0.addAll(((Collection)object0));
                arrayList0 = list1;
                p0 = p1;
            label_35:
                if(!((Collection)p0.b).isEmpty()) {
                    this.getLocalContentManager().getClass();
                    ArrayList arrayList1 = g.m(((List)p0.b));
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$0 = p0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$1 = arrayList0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$2 = null;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$3 = arrayList0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.label = 2;
                    Object object2 = this.updateOnMediaFileUpdated(arrayList1, taskUpdateLocalPlaylists$updateFromSyncResult$10);
                    if(object2 == a0) {
                        return a0;
                    }
                    p2 = p0;
                    list2 = arrayList0;
                    object0 = object2;
                    list3 = list2;
                    goto label_55;
                }
                goto label_58;
            }
            case 2: {
                list2 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$3;
                List list4 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$2;
                list3 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$1;
                p2 = (I8.p)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$0;
                d5.n.D(object0);
            label_55:
                list2.addAll(((Collection)object0));
                arrayList0 = list3;
                p0 = p2;
            label_58:
                if(!((Collection)p0.a).isEmpty()) {
                    this.getLocalContentManager().getClass();
                    ArrayList arrayList2 = g.m(((List)p0.a));
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$0 = null;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$1 = arrayList0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$2 = null;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.L$3 = arrayList0;
                    taskUpdateLocalPlaylists$updateFromSyncResult$10.label = 3;
                    Object object3 = this.updateOnMediaFileUpdated(arrayList2, taskUpdateLocalPlaylists$updateFromSyncResult$10);
                    if(object3 == a0) {
                        return a0;
                    }
                    list5 = arrayList0;
                    object0 = object3;
                    list6 = list5;
                    break;
                }
                return arrayList0;
            }
            case 3: {
                list6 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$3;
                List list7 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$2;
                list5 = (List)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$1;
                I8.p p3 = (I8.p)taskUpdateLocalPlaylists$updateFromSyncResult$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        list6.addAll(((Collection)object0));
        return list5;
    }

    public final void updateFromSyncResultAsync(@NotNull I8.p p0) {
        kotlin.jvm.internal.q.g(p0, "result");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new n(p0, null) {
            final I8.p $result;
            int label;

            {
                TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                this.$result = p0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSyncResultAsync.1(TaskUpdateLocalPlaylists.this, this.$result, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateFromSyncResultAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return TaskUpdateLocalPlaylists.this.updateFromSyncResult(this.$result, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    private final Object updateOnMediaFileDeleted(List list0, Continuation continuation0) {
        List list4;
        int v1;
        Iterator iterator0;
        List list3;
        List list1;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateOnMediaFileDeleted.1 taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateOnMediaFileDeleted.1) {
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateOnMediaFileDeleted.1)continuation0;
            int v = taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateOnMediaFileDeleted(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateOnMediaFileDeleted(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.label) {
            case 0: {
                d5.n.D(object0);
                LogU.info$default(this.log, x.e(list0.size(), "updateOnMediaFileDeleted() items : "), null, false, 6, null);
                if(list0.isEmpty()) {
                    return je.w.a;
                }
                list1 = new ArrayList();
                taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$0 = null;
                taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$1 = list1;
                taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.label = 1;
                object0 = this.getRegisteredLocalContentPlaylistIdList(taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10);
                if(object0 == a0) {
                    return a0;
                }
                list3 = list1;
                iterator0 = ((Iterable)object0).iterator();
                v1 = 0;
                goto label_41;
            }
            case 1: {
                list1 = (List)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$1;
                List list2 = (List)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$0;
                d5.n.D(object0);
                list3 = list1;
                iterator0 = ((Iterable)object0).iterator();
                v1 = 0;
                goto label_41;
            }
            case 2: {
                v1 = taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.I$0;
                list3 = (List)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$6;
                PlaylistId playlistId0 = (PlaylistId)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$5;
                iterator0 = (Iterator)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$3;
                Iterable iterable0 = (Iterable)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$2;
                list4 = (List)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$1;
                List list5 = (List)taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            list3.addAll(((Collection)object0));
            list3 = list4;
        label_41:
            if(!iterator0.hasNext()) {
                break;
            }
            Object object1 = iterator0.next();
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$0 = null;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$1 = list3;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$2 = null;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$3 = iterator0;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$4 = null;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$5 = null;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.L$6 = list3;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.I$0 = v1;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.I$1 = 0;
            taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10.label = 2;
            object0 = this.updatePlaylistOnMediaFileDeleted(((PlaylistId)object1), taskUpdateLocalPlaylists$updateOnMediaFileDeleted$10);
            if(object0 == a0) {
                return a0;
            }
            list4 = list3;
        }
        return list3;
    }

    private final Object updateOnMediaFileUpdated(List list0, Continuation continuation0) {
        List list5;
        int v1;
        List list4;
        List list3;
        Iterator iterator0;
        List list2;
        List list1;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateOnMediaFileUpdated.1 taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateOnMediaFileUpdated.1) {
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updateOnMediaFileUpdated.1)continuation0;
            int v = taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateOnMediaFileUpdated(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateOnMediaFileUpdated(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.label) {
            case 0: {
                d5.n.D(object0);
                LogU.info$default(this.log, x.e(list0.size(), "updateOnMediaFileUpdated items : "), null, false, 6, null);
                if(list0.isEmpty()) {
                    return je.w.a;
                }
                ArrayList arrayList0 = new ArrayList();
                taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$0 = list0;
                taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$1 = arrayList0;
                taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.label = 1;
                Object object1 = this.getRegisteredLocalContentPlaylistIdList(taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10);
                if(object1 == a0) {
                    return a0;
                }
                list1 = list0;
                list2 = arrayList0;
                object0 = object1;
                goto label_30;
            }
            case 1: {
                list2 = (List)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$1;
                list1 = (List)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$0;
                d5.n.D(object0);
            label_30:
                iterator0 = ((Iterable)object0).iterator();
                list3 = list1;
                list4 = list2;
                v1 = 0;
                goto label_45;
            }
            case 2: {
                v1 = taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.I$0;
                list4 = (List)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$6;
                PlaylistId playlistId0 = (PlaylistId)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$5;
                iterator0 = (Iterator)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$3;
                Iterable iterable0 = (Iterable)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$2;
                list5 = (List)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$1;
                list3 = (List)taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            list4.addAll(((Collection)object0));
            list4 = list5;
        label_45:
            if(!iterator0.hasNext()) {
                break;
            }
            Object object2 = iterator0.next();
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$0 = list3;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$1 = list4;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$2 = null;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$3 = iterator0;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$4 = null;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$5 = null;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.L$6 = list4;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.I$0 = v1;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.I$1 = 0;
            taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10.label = 2;
            object0 = this.updatePlaylistOnMediaFileUpdated(((PlaylistId)object2), list3, taskUpdateLocalPlaylists$updateOnMediaFileUpdated$10);
            if(object0 == a0) {
                return a0;
            }
            list5 = list4;
        }
        return list4;
    }

    private final Object updatePlaylistFromDcfExtendResult(PlaylistId playlistId0, List list0, Continuation continuation0) {
        PlaylistId playlistId2;
        B0 b00;
        List list2;
        PlaylistId playlistId1;
        List list1;
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.1 taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.1) {
            taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.1)continuation0;
            int v = taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        return continuation0.updatePlaylistFromDcfExtendResult(null, null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                    return continuation0.updatePlaylistFromDcfExtendResult(null, null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.label) {
            case 0: {
                list1 = b.m(object0);
                if(StorageUtils.isScopedStorage()) {
                    ArrayList arrayList0 = new ArrayList(q.Q(10, list0));
                    for(Object object1: list0) {
                        Uri uri0 = ((DcfExtendResult)object1).a.h;
                        if(uri0 == null) {
                            uri0 = Uri.EMPTY;
                        }
                        arrayList0.add(uri0.toString());
                    }
                    HashSet hashSet0 = p.N0(arrayList0);
                    B b0 = ((d3)this.getPlaylistManager()).C(playlistId0, "updatePlaylistFromDcfExtendResult", true, true, new n(list1, hashSet0, null) {
                        final HashSet $successUriSet;
                        final List $updatedPlayables;
                        Object L$0;
                        int label;

                        {
                            TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                            this.$updatedPlayables = list0;
                            this.$successUriSet = hashSet0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.2(TaskUpdateLocalPlaylists.this, this.$updatedPlayables, this.$successUriSet, continuation0);
                            continuation1.L$0 = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((List)object0), ((Continuation)object1));
                        }

                        public final Object invoke(List list0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.2)this.create(list0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            List list0 = (List)this.L$0;
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.2.1 taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$2$10 = new n(this.$successUriSet, this.$updatedPlayables, null) {
                                        final List $playables;
                                        final HashSet $successUriSet;
                                        final List $updatedPlayables;
                                        int label;

                                        {
                                            this.$playables = list0;
                                            this.$successUriSet = hashSet0;
                                            this.$updatedPlayables = list1;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.2.1(this.$playables, this.$successUriSet, this.$updatedPlayables, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            if(this.label != 0) {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                            d5.n.D(object0);
                                            HashSet hashSet0 = this.$successUriSet;
                                            List list0 = this.$updatedPlayables;
                                            for(Object object1: this.$playables) {
                                                Playable playable0 = (Playable)object1;
                                                if(playable0.isOriginLocal() && hashSet0.contains(playable0.getUriString())) {
                                                    list0.add(playable0);
                                                }
                                            }
                                            return H.a;
                                        }
                                    };
                                    this.L$0 = null;
                                    this.label = 1;
                                    return BuildersKt.withContext(TaskUpdateLocalPlaylists.this.ioDispatcher, taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$2$10, this) == a0 ? a0 : this.$updatedPlayables;
                                }
                                case 1: {
                                    d5.n.D(object0);
                                    return this.$updatedPlayables;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    });
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$0 = playlistId0;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$1 = null;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$2 = list1;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$3 = null;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.label = 1;
                    object0 = ListenableFutureKt.await(b0, taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    playlistId1 = playlistId0;
                    list2 = list1;
                    b00 = (B0)object0;
                }
                else {
                    ArrayList arrayList1 = new ArrayList(q.Q(10, list0));
                    for(Object object2: list0) {
                        arrayList1.add(((DcfExtendResult)object2).a.c());
                    }
                    HashSet hashSet1 = p.N0(arrayList1);
                    B b1 = ((d3)this.getPlaylistManager()).C(playlistId0, "updatePlaylistFromDcfExtendResult", true, true, new n(list1, hashSet1, null) {
                        final HashSet $successPathSet;
                        final List $updatedPlayables;
                        Object L$0;
                        int label;

                        {
                            TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                            this.$updatedPlayables = list0;
                            this.$successPathSet = hashSet0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.3(TaskUpdateLocalPlaylists.this, this.$updatedPlayables, this.$successPathSet, continuation0);
                            continuation1.L$0 = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((List)object0), ((Continuation)object1));
                        }

                        public final Object invoke(List list0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.3)this.create(list0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            List list0 = (List)this.L$0;
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.3.1 taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$3$10 = new n(this.$successPathSet, this.$updatedPlayables, null) {
                                        final List $playables;
                                        final HashSet $successPathSet;
                                        final List $updatedPlayables;
                                        int label;

                                        {
                                            this.$playables = list0;
                                            this.$successPathSet = hashSet0;
                                            this.$updatedPlayables = list1;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.3.1(this.$playables, this.$successPathSet, this.$updatedPlayables, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromDcfExtendResult.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            if(this.label != 0) {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                            d5.n.D(object0);
                                            HashSet hashSet0 = this.$successPathSet;
                                            List list0 = this.$updatedPlayables;
                                            for(Object object1: this.$playables) {
                                                Playable playable0 = (Playable)object1;
                                                if(playable0.isOriginLocal() && hashSet0.contains(playable0.getData())) {
                                                    list0.add(playable0);
                                                }
                                            }
                                            return H.a;
                                        }
                                    };
                                    this.L$0 = null;
                                    this.label = 1;
                                    return BuildersKt.withContext(TaskUpdateLocalPlaylists.this.ioDispatcher, taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$3$10, this) == a0 ? a0 : this.$updatedPlayables;
                                }
                                case 1: {
                                    d5.n.D(object0);
                                    return this.$updatedPlayables;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    });
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$0 = playlistId0;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$1 = null;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$2 = list1;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$3 = null;
                    taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.label = 2;
                    object0 = ListenableFutureKt.await(b1, taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10);
                    if(object0 == a0) {
                        return a0;
                    }
                    playlistId2 = playlistId0;
                    goto label_69;
                }
                break;
            }
            case 1: {
                HashSet hashSet2 = (HashSet)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$3;
                list2 = (List)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$2;
                List list3 = (List)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$1;
                playlistId1 = (PlaylistId)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$0;
                d5.n.D(object0);
                b00 = (B0)object0;
                break;
            }
            case 2: {
                HashSet hashSet3 = (HashSet)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$3;
                List list4 = (List)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$2;
                List list5 = (List)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$1;
                PlaylistId playlistId3 = (PlaylistId)taskUpdateLocalPlaylists$updatePlaylistFromDcfExtendResult$10.L$0;
                d5.n.D(object0);
                list1 = list4;
                playlistId2 = playlistId3;
            label_69:
                B0 b01 = (B0)object0;
                playlistId1 = playlistId2;
                list2 = list1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s = p.q0(list2, null, null, null, new f(11), 0x1F);
        LogU.debug$default(this.log, "updatePlaylistFromDcfExtendResult() playlistId:" + playlistId1 + ", updatedPlayables: " + s, null, false, 6, null);
        return list2;
    }

    private static final CharSequence updatePlaylistFromDcfExtendResult$lambda$19$lambda$18(Playable playable0) {
        kotlin.jvm.internal.q.g(playable0, "it");
        CharSequence charSequence0 = playable0.getSongName();
        kotlin.jvm.internal.q.f(charSequence0, "getSongName(...)");
        return charSequence0;
    }

    private final Object updatePlaylistFromLocalContentEntity(PlaylistId playlistId0, int v, k k0, Continuation continuation0) {
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.1 taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.1) {
            taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.1)continuation0;
            int v1 = taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.label;
            if((v1 & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
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
                        return continuation0.updatePlaylistFromLocalContentEntity(null, 0, null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.label = v1 ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
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
                    return continuation0.updatePlaylistFromLocalContentEntity(null, 0, null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.label) {
            case 0: {
                ArrayList arrayList0 = b.m(object0);
                B b0 = ((d3)this.getPlaylistManager()).C(playlistId0, "updatePlaylistFromLocalContentEntity", true, true, new n(arrayList0, v, k0, null) {
                    final int $downloadSongId;
                    final k $entity;
                    final List $updatedPlayables;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;

                    {
                        TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                        this.$updatedPlayables = list0;
                        this.$downloadSongId = v;
                        this.$entity = k0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.2(TaskUpdateLocalPlaylists.this, this.$updatedPlayables, this.$downloadSongId, this.$entity, continuation0);
                        continuation1.L$0 = object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((List)object0), ((Continuation)object1));
                    }

                    public final Object invoke(List list0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.2)this.create(list0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        List list0 = (List)this.L$0;
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                                kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                                h0.a = "";
                                for(Object object1: list0) {
                                    Playable playable0 = (Playable)object1;
                                    if(!playable0.isTypeOfSong() && !playable0.isTypeOfEdu() || !playable0.isDownloadOriginNowplaying()) {
                                        continue;
                                    }
                                    goto label_15;
                                }
                                object1 = null;
                            label_15:
                                if(((Playable)object1) != null) {
                                    c0.a = true;
                                    h0.a = ((Playable)object1).getCtype().getValue();
                                }
                                com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.2.1 taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$2$10 = new n(this.$downloadSongId, h0, this.$entity, c0, TaskUpdateLocalPlaylists.this, this.$updatedPlayables, null) {
                                    final kotlin.jvm.internal.H $cType;
                                    final int $downloadSongId;
                                    final k $entity;
                                    final C $isDownloadOriginNowPlaying;
                                    final List $playables;
                                    final List $updatedPlayables;
                                    int label;

                                    {
                                        this.$playables = list0;
                                        this.$downloadSongId = v;
                                        this.$cType = h0;
                                        this.$entity = k0;
                                        this.$isDownloadOriginNowPlaying = c0;
                                        TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                                        this.$updatedPlayables = list1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.2.1(this.$playables, this.$downloadSongId, this.$cType, this.$entity, this.$isDownloadOriginNowPlaying, TaskUpdateLocalPlaylists.this, this.$updatedPlayables, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistFromLocalContentEntity.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        if(this.label != 0) {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                        d5.n.D(object0);
                                        int v = this.$downloadSongId;
                                        kotlin.jvm.internal.H h0 = this.$cType;
                                        k k0 = this.$entity;
                                        C c0 = this.$isDownloadOriginNowPlaying;
                                        TaskUpdateLocalPlaylists taskUpdateLocalPlaylists0 = TaskUpdateLocalPlaylists.this;
                                        List list0 = this.$updatedPlayables;
                                        for(Object object1: this.$playables) {
                                            Playable playable0 = (Playable)object1;
                                            if(v != -1) {
                                                if(v != playable0.getSongid() || !playable0.isOriginMelon() || !kotlin.jvm.internal.q.b(h0.a, playable0.getCtype().getValue())) {
                                                    continue;
                                                }
                                                String s = k0.d;
                                                if(c0.a) {
                                                    playable0.setOrigin(1);
                                                    playable0.setStreamPath(null);
                                                    playable0.setDuration(((long)k0.l));
                                                    playable0.setDurationLimit(-1L);
                                                    if(FilenameUtils.isDcf(s)) {
                                                        playable0.setSongName(StringUtils.getTitleForDCF(k0.k));
                                                    }
                                                    else {
                                                        playable0.setSongName(k0.k);
                                                    }
                                                    playable0.setDownloadOrigin(0);
                                                    playable0.setIsFlacSt(false);
                                                }
                                                if(!FilenameUtils.isMp4(s) || !playable0.isTypeOfMv()) {
                                                    playable0.setData(k0.b);
                                                    if(StorageUtils.isScopedStorage()) {
                                                        playable0.setUriString(k0.c);
                                                    }
                                                    playable0.setDisplayName(k0.d);
                                                }
                                                else {
                                                    playable0.setData(k0.b);
                                                }
                                                playable0.setMediaStoreAlbumId(k0.w);
                                                playable0.setLocalAlbumKey(k0.p);
                                                LogU.debug$default(taskUpdateLocalPlaylists0.log, "updatePlaylistFromLocalContentEntity() update downloaded media: " + playable0, null, false, 6, null);
                                                list0.add(playable0);
                                            }
                                            else if(playable0.isOriginLocal()) {
                                                if(!StorageUtils.isScopedStorage()) {
                                                    if(StorageUtils.equalsPath(k0.b, "")) {
                                                        goto label_43;
                                                    }
                                                    continue;
                                                }
                                                else if(!StorageUtils.equalsUri(k0.c, "")) {
                                                    continue;
                                                }
                                            label_43:
                                                LogU.debug$default(taskUpdateLocalPlaylists0.log, "updatePlaylistFromLocalContentEntity() update local media: " + playable0, null, false, 6, null);
                                                MelonAppBase.Companion.getClass();
                                                if(StorageUtils.isDcfContent(playable0, t.a().getContext())) {
                                                    playable0.setSongName(StringUtils.getTitleForDCF(k0.k));
                                                }
                                                playable0.setAlbum(k0.q, k0.o);
                                                playable0.setMediaStoreAlbumId(k0.w);
                                                playable0.setLocalAlbumKey(k0.p);
                                                playable0.setArtist(k0.n, k0.m);
                                                playable0.setDuration(((long)k0.l));
                                                list0.add(playable0);
                                            }
                                        }
                                        return H.a;
                                    }
                                };
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 1;
                                return BuildersKt.withContext(TaskUpdateLocalPlaylists.this.ioDispatcher, taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$2$10, this) == a0 ? a0 : this.$updatedPlayables;
                            }
                            case 1: {
                                Playable playable1 = (Playable)this.L$3;
                                kotlin.jvm.internal.H h1 = (kotlin.jvm.internal.H)this.L$2;
                                C c1 = (C)this.L$1;
                                d5.n.D(object0);
                                return this.$updatedPlayables;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                });
                taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.L$0 = null;
                taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.L$1 = null;
                taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.L$2 = arrayList0;
                taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.I$0 = v;
                taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.label = 1;
                return ListenableFutureKt.await(b0, taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10) == a0 ? a0 : arrayList0;
            }
            case 1: {
                List list0 = (List)taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.L$2;
                k k1 = (k)taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.L$1;
                PlaylistId playlistId1 = (PlaylistId)taskUpdateLocalPlaylists$updatePlaylistFromLocalContentEntity$10.L$0;
                d5.n.D(object0);
                return list0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object updatePlaylistOnMediaFileDeleted(PlaylistId playlistId0, Continuation continuation0) {
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.1 taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.1) {
            taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.1)continuation0;
            int v = taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updatePlaylistOnMediaFileDeleted(null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updatePlaylistOnMediaFileDeleted(null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.label) {
            case 0: {
                ArrayList arrayList0 = b.m(object0);
                B b0 = ((d3)this.getPlaylistManager()).C(playlistId0, "updatePlaylistOnMediaFileDeleted", true, true, new n(arrayList0, null) {
                    final List $updatedPlayables;
                    Object L$0;
                    int label;

                    {
                        TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                        this.$updatedPlayables = list0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.2(TaskUpdateLocalPlaylists.this, this.$updatedPlayables, continuation0);
                        continuation1.L$0 = object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((List)object0), ((Continuation)object1));
                    }

                    public final Object invoke(List list0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.2)this.create(list0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        List list0 = (List)this.L$0;
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.2.1 taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$2$10 = new n(list0, this.$updatedPlayables, null) {
                                    final List $playables;
                                    final List $updatedPlayables;
                                    int label;

                                    {
                                        TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                                        this.$playables = list0;
                                        this.$updatedPlayables = list1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.2.1(TaskUpdateLocalPlaylists.this, this.$playables, this.$updatedPlayables, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileDeleted.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                this.label = 1;
                                                object0 = TaskUpdateLocalPlaylists.this.getDeletedPathListInPlaylist(this.$playables, this);
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
                                        ArrayList arrayList0 = new ArrayList();
                                        Iterator iterator0 = this.$playables.iterator();
                                        while(true) {
                                            boolean z = false;
                                            if(!iterator0.hasNext()) {
                                                break;
                                            }
                                            Object object1 = iterator0.next();
                                            if(((Playable)object1).isOriginLocal()) {
                                                boolean z1 = !StorageUtils.isScopedStorage();
                                                z = ((List)object0).contains("");
                                            }
                                            if(z) {
                                                arrayList0.add(object1);
                                            }
                                        }
                                        List list0 = this.$updatedPlayables;
                                        for(Object object2: arrayList0) {
                                            Playable playable0 = (Playable)object2;
                                            boolean z2 = !StorageUtils.isScopedStorage();
                                            if(((List)object0).contains("")) {
                                                playable0.setOrigin(0);
                                                playable0.setUriString("");
                                                playable0.setData("");
                                                playable0.setDisplayName("");
                                                list0.add(playable0);
                                            }
                                        }
                                        return H.a;
                                    }
                                };
                                this.L$0 = null;
                                this.label = 1;
                                return BuildersKt.withContext(TaskUpdateLocalPlaylists.this.ioDispatcher, taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$2$10, this) == a0 ? a0 : this.$updatedPlayables;
                            }
                            case 1: {
                                d5.n.D(object0);
                                return this.$updatedPlayables;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                });
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.L$0 = null;
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.L$1 = arrayList0;
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.label = 1;
                return ListenableFutureKt.await(b0, taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10) == a0 ? a0 : arrayList0;
            }
            case 1: {
                List list0 = (List)taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.L$1;
                PlaylistId playlistId1 = (PlaylistId)taskUpdateLocalPlaylists$updatePlaylistOnMediaFileDeleted$10.L$0;
                d5.n.D(object0);
                return list0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object updatePlaylistOnMediaFileUpdated(PlaylistId playlistId0, List list0, Continuation continuation0) {
        com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.1 taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10;
        if(continuation0 instanceof com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.1) {
            taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10 = (com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.1)continuation0;
            int v = taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.label;
            if((v & 0x80000000) == 0) {
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        return continuation0.updatePlaylistOnMediaFileUpdated(null, null, this);
                    }
                };
            }
            else {
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.label = v ^ 0x80000000;
            }
        }
        else {
            taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                    return continuation0.updatePlaylistOnMediaFileUpdated(null, null, this);
                }
            };
        }
        Object object0 = taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.result;
        a a0 = a.a;
        switch(taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.label) {
            case 0: {
                ArrayList arrayList0 = b.m(object0);
                B b0 = ((d3)this.getPlaylistManager()).C(playlistId0, "updatePlaylistOnMediaFileUpdated", true, true, new n(arrayList0, list0, null) {
                    final List $updatedList;
                    final List $updatedPlayables;
                    Object L$0;
                    int label;

                    {
                        TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                        this.$updatedPlayables = list0;
                        this.$updatedList = list1;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.2(TaskUpdateLocalPlaylists.this, this.$updatedPlayables, this.$updatedList, continuation0);
                        continuation1.L$0 = object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((List)object0), ((Continuation)object1));
                    }

                    public final Object invoke(List list0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.2)this.create(list0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        List list0 = (List)this.L$0;
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.2.1 taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$2$10 = new n(TaskUpdateLocalPlaylists.this, this.$updatedList, this.$updatedPlayables, null) {
                                    final List $playables;
                                    final List $updatedList;
                                    final List $updatedPlayables;
                                    int label;

                                    {
                                        this.$playables = list0;
                                        TaskUpdateLocalPlaylists.this = taskUpdateLocalPlaylists0;
                                        this.$updatedList = list1;
                                        this.$updatedPlayables = list2;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.2.1(this.$playables, TaskUpdateLocalPlaylists.this, this.$updatedList, this.$updatedPlayables, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.playback.TaskUpdateLocalPlaylists.updatePlaylistOnMediaFileUpdated.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        if(this.label != 0) {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                        d5.n.D(object0);
                                        TaskUpdateLocalPlaylists taskUpdateLocalPlaylists0 = TaskUpdateLocalPlaylists.this;
                                        List list0 = this.$updatedList;
                                        List list1 = this.$updatedPlayables;
                                        for(Object object1: this.$playables) {
                                            Playable playable0 = (Playable)object1;
                                            if(playable0.isOriginLocal()) {
                                                k k0 = taskUpdateLocalPlaylists0.findOrNull(list0, playable0);
                                                if(k0 != null) {
                                                    playable0.setData(k0.b);
                                                    if(StorageUtils.isScopedStorage()) {
                                                        playable0.setUriString(k0.c);
                                                    }
                                                    playable0.setDisplayName(k0.d);
                                                    playable0.setAlbum(k0.q, k0.o);
                                                    playable0.setArtist(k0.n, k0.m);
                                                    playable0.setLocalAlbumKey(k0.p);
                                                    playable0.setDuration(((long)k0.l));
                                                    list1.add(playable0);
                                                }
                                            }
                                        }
                                        return H.a;
                                    }
                                };
                                this.L$0 = null;
                                this.label = 1;
                                return BuildersKt.withContext(TaskUpdateLocalPlaylists.this.ioDispatcher, taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$2$10, this) == a0 ? a0 : this.$updatedPlayables;
                            }
                            case 1: {
                                d5.n.D(object0);
                                return this.$updatedPlayables;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                });
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.L$0 = null;
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.L$1 = null;
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.L$2 = arrayList0;
                taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.label = 1;
                return ListenableFutureKt.await(b0, taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10) == a0 ? a0 : arrayList0;
            }
            case 1: {
                List list1 = (List)taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.L$2;
                List list2 = (List)taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.L$1;
                PlaylistId playlistId1 = (PlaylistId)taskUpdateLocalPlaylists$updatePlaylistOnMediaFileUpdated$10.L$0;
                d5.n.D(object0);
                return list1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

