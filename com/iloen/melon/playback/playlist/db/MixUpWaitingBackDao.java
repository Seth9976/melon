package com.iloen.melon.playback.playlist.db;

import d5.n;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0004\b\u0007\u0010\u0004J\u001E\u0010\n\u001A\u00020\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0004\b\n\u0010\u000BJ\u001E\u0010\f\u001A\u00020\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0097@¢\u0006\u0004\b\f\u0010\u000BJ\u001E\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001A\u00020\u0002H\u0097@¢\u0006\u0004\b\u000E\u0010\u000FJ\u001E\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0010\u0010\u000FJ\u001E\u0010\u0012\u001A\u00020\t2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0004\b\u0012\u0010\u000BJ\u0010\u0010\u0013\u001A\u00020\tH§@¢\u0006\u0004\b\u0013\u0010\u0004¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/MixUpWaitingBackDao;", "", "", "getSize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/iloen/melon/playback/playlist/db/entity/MixUpWaitingBackEntity;", "getAllOrdered", "list", "Lie/H;", "insert", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAndInsert", "n", "popTopN", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopN", "items", "delete", "clear", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface MixUpWaitingBackDao {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object clearAndInsert(@NotNull MixUpWaitingBackDao mixUpWaitingBackDao0, @NotNull List list0, @NotNull Continuation continuation0) {
            Object object0 = mixUpWaitingBackDao0.super.clearAndInsert(list0, continuation0);
            return object0 == a.a ? object0 : H.a;
        }

        @Deprecated
        @Nullable
        public static Object popTopN(@NotNull MixUpWaitingBackDao mixUpWaitingBackDao0, int v, @NotNull Continuation continuation0) {
            return mixUpWaitingBackDao0.super.popTopN(v, continuation0);
        }
    }

    @Nullable
    Object clear(@NotNull Continuation arg1);

    @Nullable
    default Object clearAndInsert(@NotNull List list0, @NotNull Continuation continuation0) {
        return MixUpWaitingBackDao.clearAndInsert$suspendImpl(this, list0, continuation0);
    }

    static Object clearAndInsert$suspendImpl(MixUpWaitingBackDao mixUpWaitingBackDao0, List list0, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao.clearAndInsert.1 mixUpWaitingBackDao$clearAndInsert$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao.clearAndInsert.1) {
            mixUpWaitingBackDao$clearAndInsert$10 = (com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao.clearAndInsert.1)continuation0;
            int v = mixUpWaitingBackDao$clearAndInsert$10.label;
            if((v & 0x80000000) == 0) {
                mixUpWaitingBackDao$clearAndInsert$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return MixUpWaitingBackDao.clearAndInsert$suspendImpl(mixUpWaitingBackDao0, null, this);
                    }
                };
            }
            else {
                mixUpWaitingBackDao$clearAndInsert$10.label = v ^ 0x80000000;
            }
        }
        else {
            mixUpWaitingBackDao$clearAndInsert$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return MixUpWaitingBackDao.clearAndInsert$suspendImpl(mixUpWaitingBackDao0, null, this);
                }
            };
        }
        Object object0 = mixUpWaitingBackDao$clearAndInsert$10.result;
        a a0 = a.a;
        switch(mixUpWaitingBackDao$clearAndInsert$10.label) {
            case 0: {
                n.D(object0);
                mixUpWaitingBackDao$clearAndInsert$10.L$0 = mixUpWaitingBackDao0;
                mixUpWaitingBackDao$clearAndInsert$10.L$1 = list0;
                mixUpWaitingBackDao$clearAndInsert$10.label = 1;
                if(mixUpWaitingBackDao0.clear(mixUpWaitingBackDao$clearAndInsert$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                list0 = (List)mixUpWaitingBackDao$clearAndInsert$10.L$1;
                mixUpWaitingBackDao0 = (MixUpWaitingBackDao)mixUpWaitingBackDao$clearAndInsert$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list1 = (List)mixUpWaitingBackDao$clearAndInsert$10.L$1;
                MixUpWaitingBackDao mixUpWaitingBackDao1 = (MixUpWaitingBackDao)mixUpWaitingBackDao$clearAndInsert$10.L$0;
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mixUpWaitingBackDao$clearAndInsert$10.L$0 = null;
        mixUpWaitingBackDao$clearAndInsert$10.L$1 = null;
        mixUpWaitingBackDao$clearAndInsert$10.label = 2;
        return mixUpWaitingBackDao0.insert(list0, mixUpWaitingBackDao$clearAndInsert$10) == a0 ? a0 : H.a;
    }

    @Nullable
    Object delete(@NotNull List arg1, @NotNull Continuation arg2);

    @Nullable
    Object getAllOrdered(@NotNull Continuation arg1);

    @Nullable
    Object getSize(@NotNull Continuation arg1);

    @Nullable
    Object getTopN(int arg1, @NotNull Continuation arg2);

    @Nullable
    Object insert(@NotNull List arg1, @NotNull Continuation arg2);

    @Nullable
    default Object popTopN(int v, @NotNull Continuation continuation0) {
        return MixUpWaitingBackDao.popTopN$suspendImpl(this, v, continuation0);
    }

    static Object popTopN$suspendImpl(MixUpWaitingBackDao mixUpWaitingBackDao0, int v, Continuation continuation0) {
        com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao.popTopN.1 mixUpWaitingBackDao$popTopN$10;
        if(continuation0 instanceof com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao.popTopN.1) {
            mixUpWaitingBackDao$popTopN$10 = (com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao.popTopN.1)continuation0;
            int v1 = mixUpWaitingBackDao$popTopN$10.label;
            if((v1 & 0x80000000) == 0) {
                mixUpWaitingBackDao$popTopN$10 = new c(continuation0) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return MixUpWaitingBackDao.popTopN$suspendImpl(mixUpWaitingBackDao0, 0, this);
                    }
                };
            }
            else {
                mixUpWaitingBackDao$popTopN$10.label = v1 ^ 0x80000000;
            }
        }
        else {
            mixUpWaitingBackDao$popTopN$10 = new c(continuation0) {
                int I$0;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return MixUpWaitingBackDao.popTopN$suspendImpl(mixUpWaitingBackDao0, 0, this);
                }
            };
        }
        Object object0 = mixUpWaitingBackDao$popTopN$10.result;
        a a0 = a.a;
        switch(mixUpWaitingBackDao$popTopN$10.label) {
            case 0: {
                n.D(object0);
                mixUpWaitingBackDao$popTopN$10.L$0 = mixUpWaitingBackDao0;
                mixUpWaitingBackDao$popTopN$10.I$0 = v;
                mixUpWaitingBackDao$popTopN$10.label = 1;
                object0 = mixUpWaitingBackDao0.getTopN(v, mixUpWaitingBackDao$popTopN$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = mixUpWaitingBackDao$popTopN$10.I$0;
                mixUpWaitingBackDao0 = (MixUpWaitingBackDao)mixUpWaitingBackDao$popTopN$10.L$0;
                n.D(object0);
                break;
            }
            case 2: {
                List list0 = (List)mixUpWaitingBackDao$popTopN$10.L$1;
                MixUpWaitingBackDao mixUpWaitingBackDao1 = (MixUpWaitingBackDao)mixUpWaitingBackDao$popTopN$10.L$0;
                n.D(object0);
                return list0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((List)object0).isEmpty()) {
            mixUpWaitingBackDao$popTopN$10.L$0 = null;
            mixUpWaitingBackDao$popTopN$10.L$1 = (List)object0;
            mixUpWaitingBackDao$popTopN$10.I$0 = v;
            mixUpWaitingBackDao$popTopN$10.label = 2;
            if(mixUpWaitingBackDao0.delete(((List)object0), mixUpWaitingBackDao$popTopN$10) == a0) {
                return a0;
            }
        }
        return (List)object0;
    }
}

