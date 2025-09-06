package com.iloen.melon.playback.playlist.db;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.db.entity.MusicEntity;
import d5.n;
import ie.H;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u000E\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\'¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\b\u0010\tJ\u001E\u0010\u000B\u001A\u00020\n2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u000B\u0010\tJ,\u0010\u000F\u001A\u00020\u00072\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u0002H\u0097@¢\u0006\u0004\b\u000F\u0010\u0010J\u001E\u0010\u0011\u001A\u00020\u00072\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u0002H\u0097@¢\u0006\u0004\b\u0011\u0010\tJ\u0018\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0003H§@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\nH§@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u0016\u001A\u00020\u0015H§@¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0007H§@¢\u0006\u0004\b\u001C\u0010\u001DJ\u001E\u0010\u001F\u001A\u00020\u00072\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\r0\u0002H\u0097@¢\u0006\u0004\b\u001F\u0010\tJ:\u0010 \u001A\u00020\u00072\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\r0\u00022\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u0002H\u0097@¢\u0006\u0004\b \u0010!J\u001E\u0010\"\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0097@¢\u0006\u0004\b\"\u0010\t¨\u0006#À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/MusicPlaylistDao;", "", "", "Lcom/iloen/melon/playback/playlist/db/entity/MusicEntity;", "getAllMusicPlaylist", "()Ljava/util/List;", "list", "Lie/H;", "insertAllMusic", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updateMusicEntitys", "insertList", "Lcom/iloen/melon/playback/Playable;", "myOrderList", "insertMusicsAndUpdateOrderInTransaction", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDisPlayOrderMusicList", "enity", "insertMusicEntity", "(Lcom/iloen/melon/playback/playlist/db/entity/MusicEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "trackId", "order", "updateDisplayOrderMusic", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrackIdMusic", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllMusic", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removedList", "deleteMusicList", "deleteAndInsertMusicsAndUpdateOrderInTransaction", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAndInsertMusicInTransaction", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface MusicPlaylistDao {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object clearAndInsertMusicInTransaction(@NotNull MusicPlaylistDao musicPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = musicPlaylistDao0.super.clearAndInsertMusicInTransaction(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertMusicsAndUpdateOrderInTransaction(@NotNull MusicPlaylistDao musicPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = musicPlaylistDao0.super.deleteAndInsertMusicsAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteMusicList(@NotNull MusicPlaylistDao musicPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = musicPlaylistDao0.super.deleteMusicList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertMusicsAndUpdateOrderInTransaction(@NotNull MusicPlaylistDao musicPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = musicPlaylistDao0.super.insertMusicsAndUpdateOrderInTransaction(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object updateDisPlayOrderMusicList(@NotNull MusicPlaylistDao musicPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = musicPlaylistDao0.super.updateDisPlayOrderMusicList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }
    }

    @Nullable
    default Object clearAndInsertMusicInTransaction(@NotNull List list0, @NotNull Continuation continuation0) {
        return MusicPlaylistDao.clearAndInsertMusicInTransaction$suspendImpl(this, list0, continuation0);
    }

    static Object clearAndInsertMusicInTransaction$suspendImpl(MusicPlaylistDao musicPlaylistDao0, List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.MusicPlaylistDao.clearAndInsertMusicInTransaction.1 musicPlaylistDao$clearAndInsertMusicInTransaction$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MusicPlaylistDao.clearAndInsertMusicInTransaction.1) {
            musicPlaylistDao$clearAndInsertMusicInTransaction$10 = (com.iloen.melon.playback.playlist.db.MusicPlaylistDao.clearAndInsertMusicInTransaction.1)continuation0;
            int v = musicPlaylistDao$clearAndInsertMusicInTransaction$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDao$clearAndInsertMusicInTransaction$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return MusicPlaylistDao.clearAndInsertMusicInTransaction$suspendImpl(musicPlaylistDao0, null, this);
                    }
                };
            }
            else {
                musicPlaylistDao$clearAndInsertMusicInTransaction$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDao$clearAndInsertMusicInTransaction$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return MusicPlaylistDao.clearAndInsertMusicInTransaction$suspendImpl(musicPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = musicPlaylistDao$clearAndInsertMusicInTransaction$10.result;
        a a0 = a.a;
        switch(musicPlaylistDao$clearAndInsertMusicInTransaction$10.label) {
            case 0: {
                n.D(object0);
                musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$0 = musicPlaylistDao0;
                musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$1 = list0;
                musicPlaylistDao$clearAndInsertMusicInTransaction$10.label = 1;
                if(musicPlaylistDao0.deleteAllMusic(musicPlaylistDao$clearAndInsertMusicInTransaction$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list0 = (List)musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$1;
                musicPlaylistDao0 = (MusicPlaylistDao)musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list1 = (List)musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$1;
                MusicPlaylistDao musicPlaylistDao1 = (MusicPlaylistDao)musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$0 = null;
        musicPlaylistDao$clearAndInsertMusicInTransaction$10.L$1 = null;
        musicPlaylistDao$clearAndInsertMusicInTransaction$10.label = 2;
        return musicPlaylistDao0.insertAllMusic(list0, musicPlaylistDao$clearAndInsertMusicInTransaction$10) == a0 ? a0 : H.a;
    }

    @Nullable
    Object deleteAllMusic(@NotNull Continuation arg1);

    @Nullable
    default Object deleteAndInsertMusicsAndUpdateOrderInTransaction(@NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
        return MusicPlaylistDao.deleteAndInsertMusicsAndUpdateOrderInTransaction$suspendImpl(this, list0, list1, list2, continuation0);
    }

    static Object deleteAndInsertMusicsAndUpdateOrderInTransaction$suspendImpl(MusicPlaylistDao musicPlaylistDao0, List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.MusicPlaylistDao.deleteAndInsertMusicsAndUpdateOrderInTransaction.1 musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MusicPlaylistDao.deleteAndInsertMusicsAndUpdateOrderInTransaction.1) {
            musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10 = (com.iloen.melon.playback.playlist.db.MusicPlaylistDao.deleteAndInsertMusicsAndUpdateOrderInTransaction.1)continuation0;
            int v = musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                        return MusicPlaylistDao.deleteAndInsertMusicsAndUpdateOrderInTransaction$suspendImpl(musicPlaylistDao0, null, null, null, this);
                    }
                };
            }
            else {
                musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                    return MusicPlaylistDao.deleteAndInsertMusicsAndUpdateOrderInTransaction$suspendImpl(musicPlaylistDao0, null, null, null, this);
                }
            };
        }
        Object object0 = musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.result;
        a a0 = a.a;
        switch(musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.label) {
            case 0: {
                n.D(object0);
                musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$0 = musicPlaylistDao0;
                musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$1 = null;
                musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$2 = list1;
                musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$3 = list2;
                musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.label = 1;
                if(musicPlaylistDao0.deleteMusicList(list0, musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list2 = (List)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$3;
                list1 = (List)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$2;
                List list6 = (List)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$1;
                musicPlaylistDao0 = (MusicPlaylistDao)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list3 = (List)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$3;
                List list4 = (List)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$2;
                List list5 = (List)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$1;
                MusicPlaylistDao musicPlaylistDao1 = (MusicPlaylistDao)musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$0 = null;
        musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$1 = null;
        musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$2 = null;
        musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.L$3 = null;
        musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10.label = 2;
        return musicPlaylistDao0.insertMusicsAndUpdateOrderInTransaction(list1, list2, musicPlaylistDao$deleteAndInsertMusicsAndUpdateOrderInTransaction$10) == a0 ? a0 : H.a;
    }

    @Nullable
    default Object deleteMusicList(@NotNull List list0, @NotNull Continuation continuation0) {
        return MusicPlaylistDao.deleteMusicList$suspendImpl(this, list0, continuation0);
    }

    static Object deleteMusicList$suspendImpl(MusicPlaylistDao musicPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.MusicPlaylistDao.deleteMusicList.1 musicPlaylistDao$deleteMusicList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MusicPlaylistDao.deleteMusicList.1) {
            musicPlaylistDao$deleteMusicList$10 = (com.iloen.melon.playback.playlist.db.MusicPlaylistDao.deleteMusicList.1)continuation0;
            int v = musicPlaylistDao$deleteMusicList$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDao$deleteMusicList$10 = new c(continuation0) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return MusicPlaylistDao.deleteMusicList$suspendImpl(musicPlaylistDao0, null, this);
                    }
                };
            }
            else {
                musicPlaylistDao$deleteMusicList$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDao$deleteMusicList$10 = new c(continuation0) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return MusicPlaylistDao.deleteMusicList$suspendImpl(musicPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = musicPlaylistDao$deleteMusicList$10.result;
        a a0 = a.a;
        switch(musicPlaylistDao$deleteMusicList$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = musicPlaylistDao$deleteMusicList$10.I$0;
                Playable playable0 = (Playable)musicPlaylistDao$deleteMusicList$10.L$5;
                Iterator iterator1 = (Iterator)musicPlaylistDao$deleteMusicList$10.L$3;
                Iterable iterable0 = (Iterable)musicPlaylistDao$deleteMusicList$10.L$2;
                List list1 = (List)musicPlaylistDao$deleteMusicList$10.L$1;
                MusicPlaylistDao musicPlaylistDao1 = (MusicPlaylistDao)musicPlaylistDao$deleteMusicList$10.L$0;
                n.D(object0);
                v1 = v2;
                musicPlaylistDao0 = musicPlaylistDao1;
                iterator0 = iterator1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            String s = ((Playable)object1).getTrackId();
            q.f(s, "getTrackId(...)");
            musicPlaylistDao$deleteMusicList$10.L$0 = musicPlaylistDao0;
            musicPlaylistDao$deleteMusicList$10.L$1 = null;
            musicPlaylistDao$deleteMusicList$10.L$2 = null;
            musicPlaylistDao$deleteMusicList$10.L$3 = iterator0;
            musicPlaylistDao$deleteMusicList$10.L$4 = null;
            musicPlaylistDao$deleteMusicList$10.L$5 = null;
            musicPlaylistDao$deleteMusicList$10.I$0 = v1;
            musicPlaylistDao$deleteMusicList$10.I$1 = 0;
            musicPlaylistDao$deleteMusicList$10.label = 1;
            if(musicPlaylistDao0.deleteTrackIdMusic(s, musicPlaylistDao$deleteMusicList$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    @Nullable
    Object deleteTrackIdMusic(@NotNull String arg1, @NotNull Continuation arg2);

    @NotNull
    List getAllMusicPlaylist();

    @Nullable
    Object insertAllMusic(@NotNull List arg1, @NotNull Continuation arg2);

    @Nullable
    Object insertMusicEntity(@NotNull MusicEntity arg1, @NotNull Continuation arg2);

    @Nullable
    default Object insertMusicsAndUpdateOrderInTransaction(@NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
        return MusicPlaylistDao.insertMusicsAndUpdateOrderInTransaction$suspendImpl(this, list0, list1, continuation0);
    }

    static Object insertMusicsAndUpdateOrderInTransaction$suspendImpl(MusicPlaylistDao musicPlaylistDao0, List list0, List list1, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        MusicPlaylistDao musicPlaylistDao1;
        com.iloen.melon.playback.playlist.db.MusicPlaylistDao.insertMusicsAndUpdateOrderInTransaction.1 musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MusicPlaylistDao.insertMusicsAndUpdateOrderInTransaction.1) {
            musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10 = (com.iloen.melon.playback.playlist.db.MusicPlaylistDao.insertMusicsAndUpdateOrderInTransaction.1)continuation0;
            int v = musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                        return MusicPlaylistDao.insertMusicsAndUpdateOrderInTransaction$suspendImpl(musicPlaylistDao0, null, null, this);
                    }
                };
            }
            else {
                musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                    return MusicPlaylistDao.insertMusicsAndUpdateOrderInTransaction$suspendImpl(musicPlaylistDao0, null, null, this);
                }
            };
        }
        Object object0 = musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.result;
        a a0 = a.a;
    alab1:
        switch(musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.label) {
            case 0: {
                n.D(object0);
                musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$0 = musicPlaylistDao0;
                musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$1 = null;
                musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$2 = list1;
                musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.label = 1;
                if(musicPlaylistDao0.insertAllMusic(list0, musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10) != a0) {
                    musicPlaylistDao1 = musicPlaylistDao0;
                    v1 = 0;
                    iterator0 = list1.iterator();
                    goto label_36;
                }
                break;
            }
            case 1: {
                list1 = (List)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$2;
                List list2 = (List)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$1;
                musicPlaylistDao0 = (MusicPlaylistDao)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                musicPlaylistDao1 = musicPlaylistDao0;
                v1 = 0;
                iterator0 = list1.iterator();
                goto label_36;
            }
            case 2: {
                v1 = musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.I$0;
                Playable playable0 = (Playable)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$6;
                iterator0 = (Iterator)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$4;
                Iterable iterable0 = (Iterable)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$3;
                List list3 = (List)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$2;
                List list4 = (List)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$1;
                musicPlaylistDao1 = (MusicPlaylistDao)musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                while(true) {
                label_36:
                    if(!iterator0.hasNext()) {
                        return H.a;
                    }
                    Object object1 = iterator0.next();
                    String s = ((Playable)object1).getTrackId();
                    q.f(s, "getTrackId(...)");
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$0 = musicPlaylistDao1;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$1 = null;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$2 = null;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$3 = null;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$4 = iterator0;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$5 = null;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.L$6 = null;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.I$0 = v1;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.I$1 = 0;
                    musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10.label = 2;
                    if(musicPlaylistDao1.updateDisplayOrderMusic(s, ((Playable)object1).getOrder(), musicPlaylistDao$insertMusicsAndUpdateOrderInTransaction$10) == a0) {
                        break alab1;
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    @Nullable
    default Object updateDisPlayOrderMusicList(@NotNull List list0, @NotNull Continuation continuation0) {
        return MusicPlaylistDao.updateDisPlayOrderMusicList$suspendImpl(this, list0, continuation0);
    }

    static Object updateDisPlayOrderMusicList$suspendImpl(MusicPlaylistDao musicPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.MusicPlaylistDao.updateDisPlayOrderMusicList.1 musicPlaylistDao$updateDisPlayOrderMusicList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MusicPlaylistDao.updateDisPlayOrderMusicList.1) {
            musicPlaylistDao$updateDisPlayOrderMusicList$10 = (com.iloen.melon.playback.playlist.db.MusicPlaylistDao.updateDisPlayOrderMusicList.1)continuation0;
            int v = musicPlaylistDao$updateDisPlayOrderMusicList$10.label;
            if((v & 0x80000000) == 0) {
                musicPlaylistDao$updateDisPlayOrderMusicList$10 = new c(continuation0) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return MusicPlaylistDao.updateDisPlayOrderMusicList$suspendImpl(musicPlaylistDao0, null, this);
                    }
                };
            }
            else {
                musicPlaylistDao$updateDisPlayOrderMusicList$10.label = v ^ 0x80000000;
            }
        }
        else {
            musicPlaylistDao$updateDisPlayOrderMusicList$10 = new c(continuation0) {
                int I$0;
                int I$1;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return MusicPlaylistDao.updateDisPlayOrderMusicList$suspendImpl(musicPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = musicPlaylistDao$updateDisPlayOrderMusicList$10.result;
        a a0 = a.a;
        switch(musicPlaylistDao$updateDisPlayOrderMusicList$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = musicPlaylistDao$updateDisPlayOrderMusicList$10.I$0;
                Playable playable0 = (Playable)musicPlaylistDao$updateDisPlayOrderMusicList$10.L$5;
                Iterator iterator1 = (Iterator)musicPlaylistDao$updateDisPlayOrderMusicList$10.L$3;
                Iterable iterable0 = (Iterable)musicPlaylistDao$updateDisPlayOrderMusicList$10.L$2;
                List list1 = (List)musicPlaylistDao$updateDisPlayOrderMusicList$10.L$1;
                MusicPlaylistDao musicPlaylistDao1 = (MusicPlaylistDao)musicPlaylistDao$updateDisPlayOrderMusicList$10.L$0;
                n.D(object0);
                v1 = v2;
                musicPlaylistDao0 = musicPlaylistDao1;
                iterator0 = iterator1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            String s = ((Playable)object1).getTrackId();
            q.f(s, "getTrackId(...)");
            musicPlaylistDao$updateDisPlayOrderMusicList$10.L$0 = musicPlaylistDao0;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.L$1 = null;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.L$2 = null;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.L$3 = iterator0;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.L$4 = null;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.L$5 = null;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.I$0 = v1;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.I$1 = 0;
            musicPlaylistDao$updateDisPlayOrderMusicList$10.label = 1;
            if(musicPlaylistDao0.updateDisplayOrderMusic(s, ((Playable)object1).getOrder(), musicPlaylistDao$updateDisPlayOrderMusicList$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    @Nullable
    Object updateDisplayOrderMusic(@NotNull String arg1, int arg2, @NotNull Continuation arg3);

    @Nullable
    Object updateMusicEntitys(@NotNull List arg1, @NotNull Continuation arg2);
}

