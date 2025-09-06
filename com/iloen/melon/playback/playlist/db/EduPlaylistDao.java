package com.iloen.melon.playback.playlist.db;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.db.entity.EduEntity;
import d5.n;
import ie.H;
import ie.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@d
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\'¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\b\u0010\tJ\u001E\u0010\n\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\n\u0010\tJ,\u0010\u000E\u001A\u00020\u00072\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u0002H\u0097@¢\u0006\u0004\b\u000E\u0010\u000FJ\u0018\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0003H§@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0003H§@¢\u0006\u0004\b\u0013\u0010\u0012J \u0010\u0018\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016H§@¢\u0006\u0004\b\u0018\u0010\u0019J\u001E\u0010\u001A\u001A\u00020\u00072\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u0002H\u0097@¢\u0006\u0004\b\u001A\u0010\tJ\u0010\u0010\u001B\u001A\u00020\u0007H§@¢\u0006\u0004\b\u001B\u0010\u001CJ\u0018\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u0015\u001A\u00020\u0014H§@¢\u0006\u0004\b\u001D\u0010\u001EJ\u001E\u0010 \u001A\u00020\u00072\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\f0\u0002H\u0097@¢\u0006\u0004\b \u0010\tJ:\u0010!\u001A\u00020\u00072\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\f0\u00022\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u0002H\u0097@¢\u0006\u0004\b!\u0010\"J\u001E\u0010#\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0097@¢\u0006\u0004\b#\u0010\t¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/EduPlaylistDao;", "", "", "Lcom/iloen/melon/playback/playlist/db/entity/EduEntity;", "getAllEduPlaylist", "()Ljava/util/List;", "list", "Lie/H;", "insertAllEdu", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatedEduEntitys", "insertList", "Lcom/iloen/melon/playback/Playable;", "myOrderList", "insertEdusAndUpdateOrderInTransaction", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entity", "insertEduEntity", "(Lcom/iloen/melon/playback/playlist/db/entity/EduEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEduEntity", "", "trackId", "", "order", "updateDisplayOrderEdu", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDisPlayOrderEduList", "deleteAllEdu", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTrackIdEdu", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removedList", "deleteEduList", "deleteAndInsertEdusAndUpdateOrderInTransaction", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAndInsertEduInTransaction", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface EduPlaylistDao {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object clearAndInsertEduInTransaction(@NotNull EduPlaylistDao eduPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = eduPlaylistDao0.super.clearAndInsertEduInTransaction(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertEdusAndUpdateOrderInTransaction(@NotNull EduPlaylistDao eduPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = eduPlaylistDao0.super.deleteAndInsertEdusAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteEduList(@NotNull EduPlaylistDao eduPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = eduPlaylistDao0.super.deleteEduList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertEdusAndUpdateOrderInTransaction(@NotNull EduPlaylistDao eduPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = eduPlaylistDao0.super.insertEdusAndUpdateOrderInTransaction(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object updateDisPlayOrderEduList(@NotNull EduPlaylistDao eduPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = eduPlaylistDao0.super.updateDisPlayOrderEduList(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }
    }

    @Nullable
    default Object clearAndInsertEduInTransaction(@NotNull List list0, @NotNull Continuation continuation0) {
        return EduPlaylistDao.clearAndInsertEduInTransaction$suspendImpl(this, list0, continuation0);
    }

    static Object clearAndInsertEduInTransaction$suspendImpl(EduPlaylistDao eduPlaylistDao0, List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.EduPlaylistDao.clearAndInsertEduInTransaction.1 eduPlaylistDao$clearAndInsertEduInTransaction$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.EduPlaylistDao.clearAndInsertEduInTransaction.1) {
            eduPlaylistDao$clearAndInsertEduInTransaction$10 = (com.iloen.melon.playback.playlist.db.EduPlaylistDao.clearAndInsertEduInTransaction.1)continuation0;
            int v = eduPlaylistDao$clearAndInsertEduInTransaction$10.label;
            if((v & 0x80000000) == 0) {
                eduPlaylistDao$clearAndInsertEduInTransaction$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return EduPlaylistDao.clearAndInsertEduInTransaction$suspendImpl(eduPlaylistDao0, null, this);
                    }
                };
            }
            else {
                eduPlaylistDao$clearAndInsertEduInTransaction$10.label = v ^ 0x80000000;
            }
        }
        else {
            eduPlaylistDao$clearAndInsertEduInTransaction$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return EduPlaylistDao.clearAndInsertEduInTransaction$suspendImpl(eduPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = eduPlaylistDao$clearAndInsertEduInTransaction$10.result;
        a a0 = a.a;
        switch(eduPlaylistDao$clearAndInsertEduInTransaction$10.label) {
            case 0: {
                n.D(object0);
                eduPlaylistDao$clearAndInsertEduInTransaction$10.L$0 = eduPlaylistDao0;
                eduPlaylistDao$clearAndInsertEduInTransaction$10.L$1 = list0;
                eduPlaylistDao$clearAndInsertEduInTransaction$10.label = 1;
                if(eduPlaylistDao0.deleteAllEdu(eduPlaylistDao$clearAndInsertEduInTransaction$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list0 = (List)eduPlaylistDao$clearAndInsertEduInTransaction$10.L$1;
                eduPlaylistDao0 = (EduPlaylistDao)eduPlaylistDao$clearAndInsertEduInTransaction$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list1 = (List)eduPlaylistDao$clearAndInsertEduInTransaction$10.L$1;
                EduPlaylistDao eduPlaylistDao1 = (EduPlaylistDao)eduPlaylistDao$clearAndInsertEduInTransaction$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        eduPlaylistDao$clearAndInsertEduInTransaction$10.L$0 = null;
        eduPlaylistDao$clearAndInsertEduInTransaction$10.L$1 = null;
        eduPlaylistDao$clearAndInsertEduInTransaction$10.label = 2;
        return eduPlaylistDao0.insertAllEdu(list0, eduPlaylistDao$clearAndInsertEduInTransaction$10) == a0 ? a0 : H.a;
    }

    @Nullable
    Object deleteAllEdu(@NotNull Continuation arg1);

    @Nullable
    default Object deleteAndInsertEdusAndUpdateOrderInTransaction(@NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
        return EduPlaylistDao.deleteAndInsertEdusAndUpdateOrderInTransaction$suspendImpl(this, list0, list1, list2, continuation0);
    }

    static Object deleteAndInsertEdusAndUpdateOrderInTransaction$suspendImpl(EduPlaylistDao eduPlaylistDao0, List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.EduPlaylistDao.deleteAndInsertEdusAndUpdateOrderInTransaction.1 eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.EduPlaylistDao.deleteAndInsertEdusAndUpdateOrderInTransaction.1) {
            eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10 = (com.iloen.melon.playback.playlist.db.EduPlaylistDao.deleteAndInsertEdusAndUpdateOrderInTransaction.1)continuation0;
            int v = eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.label;
            if((v & 0x80000000) == 0) {
                eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                        return EduPlaylistDao.deleteAndInsertEdusAndUpdateOrderInTransaction$suspendImpl(eduPlaylistDao0, null, null, null, this);
                    }
                };
            }
            else {
                eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.label = v ^ 0x80000000;
            }
        }
        else {
            eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                    return EduPlaylistDao.deleteAndInsertEdusAndUpdateOrderInTransaction$suspendImpl(eduPlaylistDao0, null, null, null, this);
                }
            };
        }
        Object object0 = eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.result;
        a a0 = a.a;
        switch(eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.label) {
            case 0: {
                n.D(object0);
                eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$0 = eduPlaylistDao0;
                eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$1 = null;
                eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$2 = list1;
                eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$3 = list2;
                eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.label = 1;
                if(eduPlaylistDao0.deleteEduList(list0, eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list2 = (List)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$3;
                list1 = (List)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$2;
                List list6 = (List)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$1;
                eduPlaylistDao0 = (EduPlaylistDao)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list3 = (List)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$3;
                List list4 = (List)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$2;
                List list5 = (List)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$1;
                EduPlaylistDao eduPlaylistDao1 = (EduPlaylistDao)eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$0 = null;
        eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$1 = null;
        eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$2 = null;
        eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.L$3 = null;
        eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10.label = 2;
        return eduPlaylistDao0.insertEdusAndUpdateOrderInTransaction(list1, list2, eduPlaylistDao$deleteAndInsertEdusAndUpdateOrderInTransaction$10) == a0 ? a0 : H.a;
    }

    @Nullable
    default Object deleteEduList(@NotNull List list0, @NotNull Continuation continuation0) {
        return EduPlaylistDao.deleteEduList$suspendImpl(this, list0, continuation0);
    }

    static Object deleteEduList$suspendImpl(EduPlaylistDao eduPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.EduPlaylistDao.deleteEduList.1 eduPlaylistDao$deleteEduList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.EduPlaylistDao.deleteEduList.1) {
            eduPlaylistDao$deleteEduList$10 = (com.iloen.melon.playback.playlist.db.EduPlaylistDao.deleteEduList.1)continuation0;
            int v = eduPlaylistDao$deleteEduList$10.label;
            if((v & 0x80000000) == 0) {
                eduPlaylistDao$deleteEduList$10 = new c(continuation0) {
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
                        return EduPlaylistDao.deleteEduList$suspendImpl(eduPlaylistDao0, null, this);
                    }
                };
            }
            else {
                eduPlaylistDao$deleteEduList$10.label = v ^ 0x80000000;
            }
        }
        else {
            eduPlaylistDao$deleteEduList$10 = new c(continuation0) {
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
                    return EduPlaylistDao.deleteEduList$suspendImpl(eduPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = eduPlaylistDao$deleteEduList$10.result;
        a a0 = a.a;
        switch(eduPlaylistDao$deleteEduList$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = eduPlaylistDao$deleteEduList$10.I$0;
                Playable playable0 = (Playable)eduPlaylistDao$deleteEduList$10.L$5;
                Iterator iterator1 = (Iterator)eduPlaylistDao$deleteEduList$10.L$3;
                Iterable iterable0 = (Iterable)eduPlaylistDao$deleteEduList$10.L$2;
                List list1 = (List)eduPlaylistDao$deleteEduList$10.L$1;
                EduPlaylistDao eduPlaylistDao1 = (EduPlaylistDao)eduPlaylistDao$deleteEduList$10.L$0;
                n.D(object0);
                v1 = v2;
                eduPlaylistDao0 = eduPlaylistDao1;
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
            eduPlaylistDao$deleteEduList$10.L$0 = eduPlaylistDao0;
            eduPlaylistDao$deleteEduList$10.L$1 = null;
            eduPlaylistDao$deleteEduList$10.L$2 = null;
            eduPlaylistDao$deleteEduList$10.L$3 = iterator0;
            eduPlaylistDao$deleteEduList$10.L$4 = null;
            eduPlaylistDao$deleteEduList$10.L$5 = null;
            eduPlaylistDao$deleteEduList$10.I$0 = v1;
            eduPlaylistDao$deleteEduList$10.I$1 = 0;
            eduPlaylistDao$deleteEduList$10.label = 1;
            if(eduPlaylistDao0.deleteTrackIdEdu(s, eduPlaylistDao$deleteEduList$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    @Nullable
    Object deleteTrackIdEdu(@NotNull String arg1, @NotNull Continuation arg2);

    @NotNull
    List getAllEduPlaylist();

    @Nullable
    Object insertAllEdu(@NotNull List arg1, @NotNull Continuation arg2);

    @Nullable
    Object insertEduEntity(@NotNull EduEntity arg1, @NotNull Continuation arg2);

    @Nullable
    default Object insertEdusAndUpdateOrderInTransaction(@NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
        return EduPlaylistDao.insertEdusAndUpdateOrderInTransaction$suspendImpl(this, list0, list1, continuation0);
    }

    static Object insertEdusAndUpdateOrderInTransaction$suspendImpl(EduPlaylistDao eduPlaylistDao0, List list0, List list1, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        EduPlaylistDao eduPlaylistDao1;
        com.iloen.melon.playback.playlist.db.EduPlaylistDao.insertEdusAndUpdateOrderInTransaction.1 eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.EduPlaylistDao.insertEdusAndUpdateOrderInTransaction.1) {
            eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10 = (com.iloen.melon.playback.playlist.db.EduPlaylistDao.insertEdusAndUpdateOrderInTransaction.1)continuation0;
            int v = eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.label;
            if((v & 0x80000000) == 0) {
                eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                        return EduPlaylistDao.insertEdusAndUpdateOrderInTransaction$suspendImpl(eduPlaylistDao0, null, null, this);
                    }
                };
            }
            else {
                eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.label = v ^ 0x80000000;
            }
        }
        else {
            eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                    return EduPlaylistDao.insertEdusAndUpdateOrderInTransaction$suspendImpl(eduPlaylistDao0, null, null, this);
                }
            };
        }
        Object object0 = eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.result;
        a a0 = a.a;
    alab1:
        switch(eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.label) {
            case 0: {
                n.D(object0);
                eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$0 = eduPlaylistDao0;
                eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$1 = null;
                eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$2 = list1;
                eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.label = 1;
                if(eduPlaylistDao0.insertAllEdu(list0, eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10) != a0) {
                    eduPlaylistDao1 = eduPlaylistDao0;
                    v1 = 0;
                    iterator0 = list1.iterator();
                    goto label_36;
                }
                break;
            }
            case 1: {
                list1 = (List)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$2;
                List list2 = (List)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$1;
                eduPlaylistDao0 = (EduPlaylistDao)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                eduPlaylistDao1 = eduPlaylistDao0;
                v1 = 0;
                iterator0 = list1.iterator();
                goto label_36;
            }
            case 2: {
                v1 = eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.I$0;
                Playable playable0 = (Playable)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$6;
                iterator0 = (Iterator)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$4;
                Iterable iterable0 = (Iterable)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$3;
                List list3 = (List)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$2;
                List list4 = (List)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$1;
                eduPlaylistDao1 = (EduPlaylistDao)eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                while(true) {
                label_36:
                    if(!iterator0.hasNext()) {
                        return H.a;
                    }
                    Object object1 = iterator0.next();
                    String s = ((Playable)object1).getTrackId();
                    q.f(s, "getTrackId(...)");
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$0 = eduPlaylistDao1;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$1 = null;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$2 = null;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$3 = null;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$4 = iterator0;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$5 = null;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.L$6 = null;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.I$0 = v1;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.I$1 = 0;
                    eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10.label = 2;
                    if(eduPlaylistDao1.updateDisplayOrderEdu(s, ((Playable)object1).getOrder(), eduPlaylistDao$insertEdusAndUpdateOrderInTransaction$10) == a0) {
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
    default Object updateDisPlayOrderEduList(@NotNull List list0, @NotNull Continuation continuation0) {
        return EduPlaylistDao.updateDisPlayOrderEduList$suspendImpl(this, list0, continuation0);
    }

    static Object updateDisPlayOrderEduList$suspendImpl(EduPlaylistDao eduPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.EduPlaylistDao.updateDisPlayOrderEduList.1 eduPlaylistDao$updateDisPlayOrderEduList$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.EduPlaylistDao.updateDisPlayOrderEduList.1) {
            eduPlaylistDao$updateDisPlayOrderEduList$10 = (com.iloen.melon.playback.playlist.db.EduPlaylistDao.updateDisPlayOrderEduList.1)continuation0;
            int v = eduPlaylistDao$updateDisPlayOrderEduList$10.label;
            if((v & 0x80000000) == 0) {
                eduPlaylistDao$updateDisPlayOrderEduList$10 = new c(continuation0) {
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
                        return EduPlaylistDao.updateDisPlayOrderEduList$suspendImpl(eduPlaylistDao0, null, this);
                    }
                };
            }
            else {
                eduPlaylistDao$updateDisPlayOrderEduList$10.label = v ^ 0x80000000;
            }
        }
        else {
            eduPlaylistDao$updateDisPlayOrderEduList$10 = new c(continuation0) {
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
                    return EduPlaylistDao.updateDisPlayOrderEduList$suspendImpl(eduPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = eduPlaylistDao$updateDisPlayOrderEduList$10.result;
        a a0 = a.a;
        switch(eduPlaylistDao$updateDisPlayOrderEduList$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = eduPlaylistDao$updateDisPlayOrderEduList$10.I$0;
                Playable playable0 = (Playable)eduPlaylistDao$updateDisPlayOrderEduList$10.L$5;
                Iterator iterator1 = (Iterator)eduPlaylistDao$updateDisPlayOrderEduList$10.L$3;
                Iterable iterable0 = (Iterable)eduPlaylistDao$updateDisPlayOrderEduList$10.L$2;
                List list1 = (List)eduPlaylistDao$updateDisPlayOrderEduList$10.L$1;
                EduPlaylistDao eduPlaylistDao1 = (EduPlaylistDao)eduPlaylistDao$updateDisPlayOrderEduList$10.L$0;
                n.D(object0);
                v1 = v2;
                eduPlaylistDao0 = eduPlaylistDao1;
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
            eduPlaylistDao$updateDisPlayOrderEduList$10.L$0 = eduPlaylistDao0;
            eduPlaylistDao$updateDisPlayOrderEduList$10.L$1 = null;
            eduPlaylistDao$updateDisPlayOrderEduList$10.L$2 = null;
            eduPlaylistDao$updateDisPlayOrderEduList$10.L$3 = iterator0;
            eduPlaylistDao$updateDisPlayOrderEduList$10.L$4 = null;
            eduPlaylistDao$updateDisPlayOrderEduList$10.L$5 = null;
            eduPlaylistDao$updateDisPlayOrderEduList$10.I$0 = v1;
            eduPlaylistDao$updateDisPlayOrderEduList$10.I$1 = 0;
            eduPlaylistDao$updateDisPlayOrderEduList$10.label = 1;
            if(eduPlaylistDao0.updateDisplayOrderEdu(s, ((Playable)object1).getOrder(), eduPlaylistDao$updateDisPlayOrderEduList$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    @Nullable
    Object updateDisplayOrderEdu(@NotNull String arg1, int arg2, @NotNull Continuation arg3);

    @Nullable
    Object updateEduEntity(@NotNull EduEntity arg1, @NotNull Continuation arg2);

    @Nullable
    Object updatedEduEntitys(@NotNull List arg1, @NotNull Continuation arg2);
}

