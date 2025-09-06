package com.iloen.melon.playback.playlist.db;

import com.iloen.melon.playback.Playable;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000F\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\'¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\n\u001A\u00020\t2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\n\u0010\u000BJ\u001E\u0010\r\u001A\u00020\t2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\r\u0010\u000EJ\u001E\u0010\u0010\u001A\u00020\u000F2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0010\u0010\u000EJ\u001E\u0010\u0011\u001A\u00020\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\u0011\u0010\u000EJ \u0010\u0015\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u000FH§@¢\u0006\u0004\b\u0015\u0010\u0016J\u001E\u0010\u0018\u001A\u00020\t2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\u0018\u0010\u000EJ:\u0010\u001A\u001A\u00020\t2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\u001A\u0010\u001BJ\u001E\u0010\u001C\u001A\u00020\t2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0097@¢\u0006\u0004\b\u001C\u0010\u000EJ\u0018\u0010\u001D\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0012H§@¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\tH§@¢\u0006\u0004\b\u001F\u0010 ¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/MixUpPlaylistDao;", "", "", "Lcom/iloen/melon/playback/playlist/db/entity/MixUpEntity;", "getAllMixUpEntities", "()Ljava/util/List;", "entities", "Lcom/iloen/melon/playback/Playable;", "myOrderList", "Lie/H;", "insertMixUpEntitiesAndUpdateOrder", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "insertMixUpEntities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updateMixUpEntities", "updateOrdersMixUp", "", "trackId", "order", "updateDisplayOrderByTrackIdMixUp", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removedList", "deleteMixUpEntities", "insertList", "deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAndInsertMixUpEntities", "deleteEntityByTrackIdMixUp", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllEntitiesMixUp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface MixUpPlaylistDao {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object clearAndInsertMixUpEntities(@NotNull MixUpPlaylistDao mixUpPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = mixUpPlaylistDao0.super.clearAndInsertMixUpEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(@NotNull MixUpPlaylistDao mixUpPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = mixUpPlaylistDao0.super.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteMixUpEntities(@NotNull MixUpPlaylistDao mixUpPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = mixUpPlaylistDao0.super.deleteMixUpEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertMixUpEntitiesAndUpdateOrder(@NotNull MixUpPlaylistDao mixUpPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = mixUpPlaylistDao0.super.insertMixUpEntitiesAndUpdateOrder(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object updateOrdersMixUp(@NotNull MixUpPlaylistDao mixUpPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = mixUpPlaylistDao0.super.updateOrdersMixUp(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }
    }

    @Nullable
    default Object clearAndInsertMixUpEntities(@NotNull List list0, @NotNull Continuation continuation0) {
        return MixUpPlaylistDao.clearAndInsertMixUpEntities$suspendImpl(this, list0, continuation0);
    }

    static Object clearAndInsertMixUpEntities$suspendImpl(MixUpPlaylistDao mixUpPlaylistDao0, List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.clearAndInsertMixUpEntities.1 mixUpPlaylistDao$clearAndInsertMixUpEntities$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.clearAndInsertMixUpEntities.1) {
            mixUpPlaylistDao$clearAndInsertMixUpEntities$10 = (com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.clearAndInsertMixUpEntities.1)continuation0;
            int v = mixUpPlaylistDao$clearAndInsertMixUpEntities$10.label;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistDao$clearAndInsertMixUpEntities$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return MixUpPlaylistDao.clearAndInsertMixUpEntities$suspendImpl(mixUpPlaylistDao0, null, this);
                    }
                };
            }
            else {
                mixUpPlaylistDao$clearAndInsertMixUpEntities$10.label = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistDao$clearAndInsertMixUpEntities$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return MixUpPlaylistDao.clearAndInsertMixUpEntities$suspendImpl(mixUpPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = mixUpPlaylistDao$clearAndInsertMixUpEntities$10.result;
        a a0 = a.a;
        switch(mixUpPlaylistDao$clearAndInsertMixUpEntities$10.label) {
            case 0: {
                n.D(object0);
                mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$0 = mixUpPlaylistDao0;
                mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$1 = list0;
                mixUpPlaylistDao$clearAndInsertMixUpEntities$10.label = 1;
                if(mixUpPlaylistDao0.deleteAllEntitiesMixUp(mixUpPlaylistDao$clearAndInsertMixUpEntities$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list0 = (List)mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$1;
                mixUpPlaylistDao0 = (MixUpPlaylistDao)mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list1 = (List)mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$1;
                MixUpPlaylistDao mixUpPlaylistDao1 = (MixUpPlaylistDao)mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$0 = null;
        mixUpPlaylistDao$clearAndInsertMixUpEntities$10.L$1 = null;
        mixUpPlaylistDao$clearAndInsertMixUpEntities$10.label = 2;
        return mixUpPlaylistDao0.insertMixUpEntities(list0, mixUpPlaylistDao$clearAndInsertMixUpEntities$10) == a0 ? a0 : H.a;
    }

    @Nullable
    Object deleteAllEntitiesMixUp(@NotNull Continuation arg1);

    @Nullable
    default Object deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp(@NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
        return MixUpPlaylistDao.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$suspendImpl(this, list0, list1, list2, continuation0);
    }

    static Object deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$suspendImpl(MixUpPlaylistDao mixUpPlaylistDao0, List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp.1 mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp.1) {
            mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10 = (com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp.1)continuation0;
            int v = mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.label;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10 = new c(continuation0) {
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
                        return MixUpPlaylistDao.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$suspendImpl(mixUpPlaylistDao0, null, null, null, this);
                    }
                };
            }
            else {
                mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.label = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10 = new c(continuation0) {
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
                    return MixUpPlaylistDao.deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$suspendImpl(mixUpPlaylistDao0, null, null, null, this);
                }
            };
        }
        Object object0 = mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.result;
        a a0 = a.a;
        switch(mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.label) {
            case 0: {
                n.D(object0);
                mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$0 = mixUpPlaylistDao0;
                mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$1 = null;
                mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$2 = list1;
                mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$3 = list2;
                mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.label = 1;
                if(mixUpPlaylistDao0.deleteMixUpEntities(list0, mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list2 = (List)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$3;
                list1 = (List)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$2;
                List list6 = (List)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$1;
                mixUpPlaylistDao0 = (MixUpPlaylistDao)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list3 = (List)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$3;
                List list4 = (List)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$2;
                List list5 = (List)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$1;
                MixUpPlaylistDao mixUpPlaylistDao1 = (MixUpPlaylistDao)mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$0 = null;
        mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$1 = null;
        mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$2 = null;
        mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.L$3 = null;
        mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10.label = 2;
        return mixUpPlaylistDao0.insertMixUpEntitiesAndUpdateOrder(list1, list2, mixUpPlaylistDao$deleteAndInsertEntitiesAndUpdateOrderInTransactionMixUp$10) == a0 ? a0 : H.a;
    }

    @Nullable
    Object deleteEntityByTrackIdMixUp(@NotNull String arg1, @NotNull Continuation arg2);

    @Nullable
    default Object deleteMixUpEntities(@NotNull List list0, @NotNull Continuation continuation0) {
        return MixUpPlaylistDao.deleteMixUpEntities$suspendImpl(this, list0, continuation0);
    }

    static Object deleteMixUpEntities$suspendImpl(MixUpPlaylistDao mixUpPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.deleteMixUpEntities.1 mixUpPlaylistDao$deleteMixUpEntities$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.deleteMixUpEntities.1) {
            mixUpPlaylistDao$deleteMixUpEntities$10 = (com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.deleteMixUpEntities.1)continuation0;
            int v = mixUpPlaylistDao$deleteMixUpEntities$10.label;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistDao$deleteMixUpEntities$10 = new c(continuation0) {
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
                        return MixUpPlaylistDao.deleteMixUpEntities$suspendImpl(mixUpPlaylistDao0, null, this);
                    }
                };
            }
            else {
                mixUpPlaylistDao$deleteMixUpEntities$10.label = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistDao$deleteMixUpEntities$10 = new c(continuation0) {
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
                    return MixUpPlaylistDao.deleteMixUpEntities$suspendImpl(mixUpPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = mixUpPlaylistDao$deleteMixUpEntities$10.result;
        a a0 = a.a;
        switch(mixUpPlaylistDao$deleteMixUpEntities$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = mixUpPlaylistDao$deleteMixUpEntities$10.I$0;
                Playable playable0 = (Playable)mixUpPlaylistDao$deleteMixUpEntities$10.L$5;
                Iterator iterator1 = (Iterator)mixUpPlaylistDao$deleteMixUpEntities$10.L$3;
                Iterable iterable0 = (Iterable)mixUpPlaylistDao$deleteMixUpEntities$10.L$2;
                List list1 = (List)mixUpPlaylistDao$deleteMixUpEntities$10.L$1;
                MixUpPlaylistDao mixUpPlaylistDao1 = (MixUpPlaylistDao)mixUpPlaylistDao$deleteMixUpEntities$10.L$0;
                n.D(object0);
                v1 = v2;
                mixUpPlaylistDao0 = mixUpPlaylistDao1;
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
            mixUpPlaylistDao$deleteMixUpEntities$10.L$0 = mixUpPlaylistDao0;
            mixUpPlaylistDao$deleteMixUpEntities$10.L$1 = null;
            mixUpPlaylistDao$deleteMixUpEntities$10.L$2 = null;
            mixUpPlaylistDao$deleteMixUpEntities$10.L$3 = iterator0;
            mixUpPlaylistDao$deleteMixUpEntities$10.L$4 = null;
            mixUpPlaylistDao$deleteMixUpEntities$10.L$5 = null;
            mixUpPlaylistDao$deleteMixUpEntities$10.I$0 = v1;
            mixUpPlaylistDao$deleteMixUpEntities$10.I$1 = 0;
            mixUpPlaylistDao$deleteMixUpEntities$10.label = 1;
            if(mixUpPlaylistDao0.deleteEntityByTrackIdMixUp(s, mixUpPlaylistDao$deleteMixUpEntities$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    @NotNull
    List getAllMixUpEntities();

    @Nullable
    Object insertMixUpEntities(@NotNull List arg1, @NotNull Continuation arg2);

    @Nullable
    default Object insertMixUpEntitiesAndUpdateOrder(@NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
        return MixUpPlaylistDao.insertMixUpEntitiesAndUpdateOrder$suspendImpl(this, list0, list1, continuation0);
    }

    static Object insertMixUpEntitiesAndUpdateOrder$suspendImpl(MixUpPlaylistDao mixUpPlaylistDao0, List list0, List list1, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        MixUpPlaylistDao mixUpPlaylistDao1;
        com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.insertMixUpEntitiesAndUpdateOrder.1 mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.insertMixUpEntitiesAndUpdateOrder.1) {
            mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10 = (com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.insertMixUpEntitiesAndUpdateOrder.1)continuation0;
            int v = mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.label;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10 = new c(continuation0) {
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
                        return MixUpPlaylistDao.insertMixUpEntitiesAndUpdateOrder$suspendImpl(mixUpPlaylistDao0, null, null, this);
                    }
                };
            }
            else {
                mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.label = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10 = new c(continuation0) {
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
                    return MixUpPlaylistDao.insertMixUpEntitiesAndUpdateOrder$suspendImpl(mixUpPlaylistDao0, null, null, this);
                }
            };
        }
        Object object0 = mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.result;
        a a0 = a.a;
    alab1:
        switch(mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.label) {
            case 0: {
                n.D(object0);
                mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$0 = mixUpPlaylistDao0;
                mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$1 = null;
                mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$2 = list1;
                mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.label = 1;
                if(mixUpPlaylistDao0.insertMixUpEntities(list0, mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10) != a0) {
                    mixUpPlaylistDao1 = mixUpPlaylistDao0;
                    v1 = 0;
                    iterator0 = list1.iterator();
                    goto label_36;
                }
                break;
            }
            case 1: {
                list1 = (List)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$2;
                List list2 = (List)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$1;
                mixUpPlaylistDao0 = (MixUpPlaylistDao)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$0;
                n.D(object0);
                mixUpPlaylistDao1 = mixUpPlaylistDao0;
                v1 = 0;
                iterator0 = list1.iterator();
                goto label_36;
            }
            case 2: {
                v1 = mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.I$0;
                Playable playable0 = (Playable)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$6;
                iterator0 = (Iterator)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$4;
                Iterable iterable0 = (Iterable)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$3;
                List list3 = (List)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$2;
                List list4 = (List)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$1;
                mixUpPlaylistDao1 = (MixUpPlaylistDao)mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$0;
                n.D(object0);
                while(true) {
                label_36:
                    if(!iterator0.hasNext()) {
                        return H.a;
                    }
                    Object object1 = iterator0.next();
                    String s = ((Playable)object1).getTrackId();
                    q.f(s, "getTrackId(...)");
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$0 = mixUpPlaylistDao1;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$1 = null;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$2 = null;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$3 = null;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$4 = iterator0;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$5 = null;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.L$6 = null;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.I$0 = v1;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.I$1 = 0;
                    mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10.label = 2;
                    if(mixUpPlaylistDao1.updateDisplayOrderByTrackIdMixUp(s, ((Playable)object1).getOrder(), mixUpPlaylistDao$insertMixUpEntitiesAndUpdateOrder$10) == a0) {
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
    Object updateDisplayOrderByTrackIdMixUp(@NotNull String arg1, int arg2, @NotNull Continuation arg3);

    @Nullable
    Object updateMixUpEntities(@NotNull List arg1, @NotNull Continuation arg2);

    @Nullable
    default Object updateOrdersMixUp(@NotNull List list0, @NotNull Continuation continuation0) {
        return MixUpPlaylistDao.updateOrdersMixUp$suspendImpl(this, list0, continuation0);
    }

    static Object updateOrdersMixUp$suspendImpl(MixUpPlaylistDao mixUpPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.updateOrdersMixUp.1 mixUpPlaylistDao$updateOrdersMixUp$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.updateOrdersMixUp.1) {
            mixUpPlaylistDao$updateOrdersMixUp$10 = (com.iloen.melon.playback.playlist.db.MixUpPlaylistDao.updateOrdersMixUp.1)continuation0;
            int v = mixUpPlaylistDao$updateOrdersMixUp$10.label;
            if((v & 0x80000000) == 0) {
                mixUpPlaylistDao$updateOrdersMixUp$10 = new c(continuation0) {
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
                        return MixUpPlaylistDao.updateOrdersMixUp$suspendImpl(mixUpPlaylistDao0, null, this);
                    }
                };
            }
            else {
                mixUpPlaylistDao$updateOrdersMixUp$10.label = v ^ 0x80000000;
            }
        }
        else {
            mixUpPlaylistDao$updateOrdersMixUp$10 = new c(continuation0) {
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
                    return MixUpPlaylistDao.updateOrdersMixUp$suspendImpl(mixUpPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = mixUpPlaylistDao$updateOrdersMixUp$10.result;
        a a0 = a.a;
        switch(mixUpPlaylistDao$updateOrdersMixUp$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = mixUpPlaylistDao$updateOrdersMixUp$10.I$0;
                Playable playable0 = (Playable)mixUpPlaylistDao$updateOrdersMixUp$10.L$5;
                Iterator iterator1 = (Iterator)mixUpPlaylistDao$updateOrdersMixUp$10.L$3;
                Iterable iterable0 = (Iterable)mixUpPlaylistDao$updateOrdersMixUp$10.L$2;
                List list1 = (List)mixUpPlaylistDao$updateOrdersMixUp$10.L$1;
                MixUpPlaylistDao mixUpPlaylistDao1 = (MixUpPlaylistDao)mixUpPlaylistDao$updateOrdersMixUp$10.L$0;
                n.D(object0);
                v1 = v2;
                mixUpPlaylistDao0 = mixUpPlaylistDao1;
                iterator0 = iterator1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            Object object1 = iterator0.next();
            q.f("", "getTrackId(...)");
            mixUpPlaylistDao$updateOrdersMixUp$10.L$0 = mixUpPlaylistDao0;
            mixUpPlaylistDao$updateOrdersMixUp$10.L$1 = null;
            mixUpPlaylistDao$updateOrdersMixUp$10.L$2 = null;
            mixUpPlaylistDao$updateOrdersMixUp$10.L$3 = iterator0;
            mixUpPlaylistDao$updateOrdersMixUp$10.L$4 = null;
            mixUpPlaylistDao$updateOrdersMixUp$10.L$5 = null;
            mixUpPlaylistDao$updateOrdersMixUp$10.I$0 = v1;
            mixUpPlaylistDao$updateOrdersMixUp$10.I$1 = 0;
            mixUpPlaylistDao$updateOrdersMixUp$10.label = 1;
            if(mixUpPlaylistDao0.updateDisplayOrderByTrackIdMixUp("", ((Playable)object1).getOrder(), mixUpPlaylistDao$updateOrdersMixUp$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }
}

