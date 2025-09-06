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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000F\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\'¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\n\u001A\u00020\t2\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\n\u0010\u000BJ\u001E\u0010\r\u001A\u00020\t2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\r\u0010\u000EJ\u001E\u0010\u0010\u001A\u00020\u000F2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0010\u0010\u000EJ\u001E\u0010\u0011\u001A\u00020\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\u0011\u0010\u000EJ \u0010\u0015\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u000FH§@¢\u0006\u0004\b\u0015\u0010\u0016J\u001E\u0010\u0018\u001A\u00020\t2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\u0018\u0010\u000EJ:\u0010\u001A\u001A\u00020\t2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0097@¢\u0006\u0004\b\u001A\u0010\u001BJ\u001E\u0010\u001C\u001A\u00020\t2\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0097@¢\u0006\u0004\b\u001C\u0010\u000EJ\u0018\u0010\u001D\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0012H§@¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\tH§@¢\u0006\u0004\b\u001F\u0010 ¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/SmartPlaylistDao;", "", "", "Lcom/iloen/melon/playback/playlist/db/entity/SmartEntity;", "getAllSmartEntities", "()Ljava/util/List;", "entities", "Lcom/iloen/melon/playback/Playable;", "myOrderList", "Lie/H;", "insertSmartEntitiesAndUpdateOrder", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "list", "insertSmartEntities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updateSmartEntities", "updateOrdersSmart", "", "trackId", "order", "updateDisplayOrderByTrackIdSmart", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removedList", "deleteSmartEntities", "insertList", "deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAndInsertSmartEntities", "deleteSmartEntityByTrackId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllSmartEntities", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface SmartPlaylistDao {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object clearAndInsertSmartEntities(@NotNull SmartPlaylistDao smartPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = smartPlaylistDao0.super.clearAndInsertSmartEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(@NotNull SmartPlaylistDao smartPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
            Object object0 = smartPlaylistDao0.super.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(list0, list1, list2, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object deleteSmartEntities(@NotNull SmartPlaylistDao smartPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = smartPlaylistDao0.super.deleteSmartEntities(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object insertSmartEntitiesAndUpdateOrder(@NotNull SmartPlaylistDao smartPlaylistDao0, @NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
            Object object0 = smartPlaylistDao0.super.insertSmartEntitiesAndUpdateOrder(list0, list1, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object updateOrdersSmart(@NotNull SmartPlaylistDao smartPlaylistDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = smartPlaylistDao0.super.updateOrdersSmart(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }
    }

    @Nullable
    default Object clearAndInsertSmartEntities(@NotNull List list0, @NotNull Continuation continuation0) {
        return SmartPlaylistDao.clearAndInsertSmartEntities$suspendImpl(this, list0, continuation0);
    }

    static Object clearAndInsertSmartEntities$suspendImpl(SmartPlaylistDao smartPlaylistDao0, List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.SmartPlaylistDao.clearAndInsertSmartEntities.1 smartPlaylistDao$clearAndInsertSmartEntities$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.SmartPlaylistDao.clearAndInsertSmartEntities.1) {
            smartPlaylistDao$clearAndInsertSmartEntities$10 = (com.iloen.melon.playback.playlist.db.SmartPlaylistDao.clearAndInsertSmartEntities.1)continuation0;
            int v = smartPlaylistDao$clearAndInsertSmartEntities$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDao$clearAndInsertSmartEntities$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return SmartPlaylistDao.clearAndInsertSmartEntities$suspendImpl(smartPlaylistDao0, null, this);
                    }
                };
            }
            else {
                smartPlaylistDao$clearAndInsertSmartEntities$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDao$clearAndInsertSmartEntities$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return SmartPlaylistDao.clearAndInsertSmartEntities$suspendImpl(smartPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = smartPlaylistDao$clearAndInsertSmartEntities$10.result;
        a a0 = a.a;
        switch(smartPlaylistDao$clearAndInsertSmartEntities$10.label) {
            case 0: {
                n.D(object0);
                smartPlaylistDao$clearAndInsertSmartEntities$10.L$0 = smartPlaylistDao0;
                smartPlaylistDao$clearAndInsertSmartEntities$10.L$1 = list0;
                smartPlaylistDao$clearAndInsertSmartEntities$10.label = 1;
                if(smartPlaylistDao0.deleteAllSmartEntities(smartPlaylistDao$clearAndInsertSmartEntities$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list0 = (List)smartPlaylistDao$clearAndInsertSmartEntities$10.L$1;
                smartPlaylistDao0 = (SmartPlaylistDao)smartPlaylistDao$clearAndInsertSmartEntities$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list1 = (List)smartPlaylistDao$clearAndInsertSmartEntities$10.L$1;
                SmartPlaylistDao smartPlaylistDao1 = (SmartPlaylistDao)smartPlaylistDao$clearAndInsertSmartEntities$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        smartPlaylistDao$clearAndInsertSmartEntities$10.L$0 = null;
        smartPlaylistDao$clearAndInsertSmartEntities$10.L$1 = null;
        smartPlaylistDao$clearAndInsertSmartEntities$10.label = 2;
        return smartPlaylistDao0.insertSmartEntities(list0, smartPlaylistDao$clearAndInsertSmartEntities$10) == a0 ? a0 : H.a;
    }

    @Nullable
    Object deleteAllSmartEntities(@NotNull Continuation arg1);

    @Nullable
    default Object deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction(@NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull Continuation continuation0) {
        return SmartPlaylistDao.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$suspendImpl(this, list0, list1, list2, continuation0);
    }

    static Object deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$suspendImpl(SmartPlaylistDao smartPlaylistDao0, List list0, List list1, List list2, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.SmartPlaylistDao.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction.1 smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.SmartPlaylistDao.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction.1) {
            smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10 = (com.iloen.melon.playback.playlist.db.SmartPlaylistDao.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction.1)continuation0;
            int v = smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                        return SmartPlaylistDao.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$suspendImpl(smartPlaylistDao0, null, null, null, this);
                    }
                };
            }
            else {
                smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10 = new c(continuation0) {
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
                    return SmartPlaylistDao.deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$suspendImpl(smartPlaylistDao0, null, null, null, this);
                }
            };
        }
        Object object0 = smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.result;
        a a0 = a.a;
        switch(smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.label) {
            case 0: {
                n.D(object0);
                smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$0 = smartPlaylistDao0;
                smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$1 = null;
                smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$2 = list1;
                smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$3 = list2;
                smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.label = 1;
                if(smartPlaylistDao0.deleteSmartEntities(list0, smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list2 = (List)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$3;
                list1 = (List)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$2;
                List list6 = (List)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$1;
                smartPlaylistDao0 = (SmartPlaylistDao)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list3 = (List)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$3;
                List list4 = (List)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$2;
                List list5 = (List)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$1;
                SmartPlaylistDao smartPlaylistDao1 = (SmartPlaylistDao)smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$0 = null;
        smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$1 = null;
        smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$2 = null;
        smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.L$3 = null;
        smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10.label = 2;
        return smartPlaylistDao0.insertSmartEntitiesAndUpdateOrder(list1, list2, smartPlaylistDao$deleteAndInsertSmartEntitiesAndUpdateOrderInTransaction$10) == a0 ? a0 : H.a;
    }

    @Nullable
    default Object deleteSmartEntities(@NotNull List list0, @NotNull Continuation continuation0) {
        return SmartPlaylistDao.deleteSmartEntities$suspendImpl(this, list0, continuation0);
    }

    static Object deleteSmartEntities$suspendImpl(SmartPlaylistDao smartPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.SmartPlaylistDao.deleteSmartEntities.1 smartPlaylistDao$deleteSmartEntities$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.SmartPlaylistDao.deleteSmartEntities.1) {
            smartPlaylistDao$deleteSmartEntities$10 = (com.iloen.melon.playback.playlist.db.SmartPlaylistDao.deleteSmartEntities.1)continuation0;
            int v = smartPlaylistDao$deleteSmartEntities$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDao$deleteSmartEntities$10 = new c(continuation0) {
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
                        return SmartPlaylistDao.deleteSmartEntities$suspendImpl(smartPlaylistDao0, null, this);
                    }
                };
            }
            else {
                smartPlaylistDao$deleteSmartEntities$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDao$deleteSmartEntities$10 = new c(continuation0) {
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
                    return SmartPlaylistDao.deleteSmartEntities$suspendImpl(smartPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = smartPlaylistDao$deleteSmartEntities$10.result;
        a a0 = a.a;
        switch(smartPlaylistDao$deleteSmartEntities$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = smartPlaylistDao$deleteSmartEntities$10.I$0;
                Playable playable0 = (Playable)smartPlaylistDao$deleteSmartEntities$10.L$5;
                Iterator iterator1 = (Iterator)smartPlaylistDao$deleteSmartEntities$10.L$3;
                Iterable iterable0 = (Iterable)smartPlaylistDao$deleteSmartEntities$10.L$2;
                List list1 = (List)smartPlaylistDao$deleteSmartEntities$10.L$1;
                SmartPlaylistDao smartPlaylistDao1 = (SmartPlaylistDao)smartPlaylistDao$deleteSmartEntities$10.L$0;
                n.D(object0);
                v1 = v2;
                smartPlaylistDao0 = smartPlaylistDao1;
                iterator0 = iterator1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator0.hasNext()) {
            iterator0.next();
            q.f("", "getTrackId(...)");
            smartPlaylistDao$deleteSmartEntities$10.L$0 = smartPlaylistDao0;
            smartPlaylistDao$deleteSmartEntities$10.L$1 = null;
            smartPlaylistDao$deleteSmartEntities$10.L$2 = null;
            smartPlaylistDao$deleteSmartEntities$10.L$3 = iterator0;
            smartPlaylistDao$deleteSmartEntities$10.L$4 = null;
            smartPlaylistDao$deleteSmartEntities$10.L$5 = null;
            smartPlaylistDao$deleteSmartEntities$10.I$0 = v1;
            smartPlaylistDao$deleteSmartEntities$10.I$1 = 0;
            smartPlaylistDao$deleteSmartEntities$10.label = 1;
            if(smartPlaylistDao0.deleteSmartEntityByTrackId("", smartPlaylistDao$deleteSmartEntities$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    @Nullable
    Object deleteSmartEntityByTrackId(@NotNull String arg1, @NotNull Continuation arg2);

    @NotNull
    List getAllSmartEntities();

    @Nullable
    Object insertSmartEntities(@NotNull List arg1, @NotNull Continuation arg2);

    @Nullable
    default Object insertSmartEntitiesAndUpdateOrder(@NotNull List list0, @NotNull List list1, @NotNull Continuation continuation0) {
        return SmartPlaylistDao.insertSmartEntitiesAndUpdateOrder$suspendImpl(this, list0, list1, continuation0);
    }

    static Object insertSmartEntitiesAndUpdateOrder$suspendImpl(SmartPlaylistDao smartPlaylistDao0, List list0, List list1, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        SmartPlaylistDao smartPlaylistDao1;
        com.iloen.melon.playback.playlist.db.SmartPlaylistDao.insertSmartEntitiesAndUpdateOrder.1 smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.SmartPlaylistDao.insertSmartEntitiesAndUpdateOrder.1) {
            smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10 = (com.iloen.melon.playback.playlist.db.SmartPlaylistDao.insertSmartEntitiesAndUpdateOrder.1)continuation0;
            int v = smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10 = new c(continuation0) {
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
                        return SmartPlaylistDao.insertSmartEntitiesAndUpdateOrder$suspendImpl(smartPlaylistDao0, null, null, this);
                    }
                };
            }
            else {
                smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10 = new c(continuation0) {
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
                    return SmartPlaylistDao.insertSmartEntitiesAndUpdateOrder$suspendImpl(smartPlaylistDao0, null, null, this);
                }
            };
        }
        Object object0 = smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.result;
        a a0 = a.a;
    alab1:
        switch(smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.label) {
            case 0: {
                n.D(object0);
                smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$0 = smartPlaylistDao0;
                smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$1 = null;
                smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$2 = list1;
                smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.label = 1;
                if(smartPlaylistDao0.insertSmartEntities(list0, smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10) != a0) {
                    smartPlaylistDao1 = smartPlaylistDao0;
                    v1 = 0;
                    iterator0 = list1.iterator();
                    goto label_36;
                }
                break;
            }
            case 1: {
                list1 = (List)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$2;
                List list2 = (List)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$1;
                smartPlaylistDao0 = (SmartPlaylistDao)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$0;
                n.D(object0);
                smartPlaylistDao1 = smartPlaylistDao0;
                v1 = 0;
                iterator0 = list1.iterator();
                goto label_36;
            }
            case 2: {
                v1 = smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.I$0;
                Playable playable0 = (Playable)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$6;
                iterator0 = (Iterator)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$4;
                Iterable iterable0 = (Iterable)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$3;
                List list3 = (List)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$2;
                List list4 = (List)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$1;
                smartPlaylistDao1 = (SmartPlaylistDao)smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$0;
                n.D(object0);
                while(true) {
                label_36:
                    if(!iterator0.hasNext()) {
                        return H.a;
                    }
                    Object object1 = iterator0.next();
                    q.f("", "getTrackId(...)");
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$0 = smartPlaylistDao1;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$1 = null;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$2 = null;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$3 = null;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$4 = iterator0;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$5 = null;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.L$6 = null;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.I$0 = v1;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.I$1 = 0;
                    smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10.label = 2;
                    if(smartPlaylistDao1.updateDisplayOrderByTrackIdSmart("", ((Playable)object1).getOrder(), smartPlaylistDao$insertSmartEntitiesAndUpdateOrder$10) == a0) {
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
    Object updateDisplayOrderByTrackIdSmart(@NotNull String arg1, int arg2, @NotNull Continuation arg3);

    @Nullable
    default Object updateOrdersSmart(@NotNull List list0, @NotNull Continuation continuation0) {
        return SmartPlaylistDao.updateOrdersSmart$suspendImpl(this, list0, continuation0);
    }

    static Object updateOrdersSmart$suspendImpl(SmartPlaylistDao smartPlaylistDao0, List list0, Continuation continuation0) {
        Iterator iterator0;
        int v1;
        com.iloen.melon.playback.playlist.db.SmartPlaylistDao.updateOrdersSmart.1 smartPlaylistDao$updateOrdersSmart$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.SmartPlaylistDao.updateOrdersSmart.1) {
            smartPlaylistDao$updateOrdersSmart$10 = (com.iloen.melon.playback.playlist.db.SmartPlaylistDao.updateOrdersSmart.1)continuation0;
            int v = smartPlaylistDao$updateOrdersSmart$10.label;
            if((v & 0x80000000) == 0) {
                smartPlaylistDao$updateOrdersSmart$10 = new c(continuation0) {
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
                        return SmartPlaylistDao.updateOrdersSmart$suspendImpl(smartPlaylistDao0, null, this);
                    }
                };
            }
            else {
                smartPlaylistDao$updateOrdersSmart$10.label = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistDao$updateOrdersSmart$10 = new c(continuation0) {
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
                    return SmartPlaylistDao.updateOrdersSmart$suspendImpl(smartPlaylistDao0, null, this);
                }
            };
        }
        Object object0 = smartPlaylistDao$updateOrdersSmart$10.result;
        a a0 = a.a;
        switch(smartPlaylistDao$updateOrdersSmart$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                iterator0 = list0.iterator();
                break;
            }
            case 1: {
                int v2 = smartPlaylistDao$updateOrdersSmart$10.I$0;
                Playable playable0 = (Playable)smartPlaylistDao$updateOrdersSmart$10.L$5;
                Iterator iterator1 = (Iterator)smartPlaylistDao$updateOrdersSmart$10.L$3;
                Iterable iterable0 = (Iterable)smartPlaylistDao$updateOrdersSmart$10.L$2;
                List list1 = (List)smartPlaylistDao$updateOrdersSmart$10.L$1;
                SmartPlaylistDao smartPlaylistDao1 = (SmartPlaylistDao)smartPlaylistDao$updateOrdersSmart$10.L$0;
                n.D(object0);
                v1 = v2;
                smartPlaylistDao0 = smartPlaylistDao1;
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
            smartPlaylistDao$updateOrdersSmart$10.L$0 = smartPlaylistDao0;
            smartPlaylistDao$updateOrdersSmart$10.L$1 = null;
            smartPlaylistDao$updateOrdersSmart$10.L$2 = null;
            smartPlaylistDao$updateOrdersSmart$10.L$3 = iterator0;
            smartPlaylistDao$updateOrdersSmart$10.L$4 = null;
            smartPlaylistDao$updateOrdersSmart$10.L$5 = null;
            smartPlaylistDao$updateOrdersSmart$10.I$0 = v1;
            smartPlaylistDao$updateOrdersSmart$10.I$1 = 0;
            smartPlaylistDao$updateOrdersSmart$10.label = 1;
            if(smartPlaylistDao0.updateDisplayOrderByTrackIdSmart(s, ((Playable)object1).getOrder(), smartPlaylistDao$updateOrdersSmart$10) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }

    @Nullable
    Object updateSmartEntities(@NotNull List arg1, @NotNull Continuation arg2);
}

