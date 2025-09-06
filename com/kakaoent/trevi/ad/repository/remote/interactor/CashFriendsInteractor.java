package com.kakaoent.trevi.ad.repository.remote.interactor;

import com.google.gson.t;
import com.kakaoent.trevi.ad.domain.CashFriendsApplyApiData;
import com.kakaoent.trevi.ad.domain.CashFriendsCPVTrackApiData;
import com.kakaoent.trevi.ad.network.ApiModule;
import com.kakaoent.trevi.ad.repository.remote.api.CashFriendsApplyApi;
import com.kakaoent.trevi.ad.repository.remote.api.CashFriendsImpApi;
import com.kakaoent.trevi.ad.repository.remote.api.CashFriendsTrackApi.DefaultImpls;
import com.kakaoent.trevi.ad.repository.remote.api.CashFriendsTrackApi;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001B\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\u000BJ1\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\b2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\f2\b\b\u0002\u0010\u000F\u001A\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001A\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001A\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001A\u001A\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsInteractor;", "", "<init>", "()V", "Lie/H;", "changeApi", "Lcom/google/gson/t;", "jsonObject", "Lkotlinx/coroutines/flow/Flow;", "Lcom/kakaoent/trevi/ad/domain/CashFriendsApplyApiData;", "notifyInstalled", "(Lcom/google/gson/t;)Lkotlinx/coroutines/flow/Flow;", "", "ask", "actType", "env", "Lcom/kakaoent/trevi/ad/domain/CashFriendsCPVTrackApiData;", "sendVideoTracking", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsApplyApi;", "applyApi", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsApplyApi;", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsTrackApi;", "trackApi", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsTrackApi;", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsImpApi;", "impApi", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsImpApi;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsInteractor {
    @NotNull
    public static final CashFriendsInteractor INSTANCE;
    private static CashFriendsApplyApi applyApi;
    private static CashFriendsImpApi impApi;
    private static CashFriendsTrackApi trackApi;

    static {
        CashFriendsInteractor.INSTANCE = new CashFriendsInteractor();
    }

    public final void changeApi() {
        CashFriendsInteractor.applyApi = (CashFriendsApplyApi)ApiModule.INSTANCE.getApi(CashFriendsApplyApi.class);
        CashFriendsInteractor.trackApi = (CashFriendsTrackApi)ApiModule.INSTANCE.getApi(CashFriendsTrackApi.class);
        CashFriendsInteractor.impApi = (CashFriendsImpApi)ApiModule.INSTANCE.getApi(CashFriendsImpApi.class);
    }

    @NotNull
    public final Flow notifyInstalled(@NotNull t t0) {
        q.g(t0, "jsonObject");
        return FlowKt.flowOn(FlowKt.flow(new n(null) {
            final t $jsonObject;
            private Object L$0;
            int label;

            {
                this.$jsonObject = t0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                Continuation continuation1 = new com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsInteractor.notifyInstalled.1(this.$jsonObject, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((FlowCollector)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector flowCollector0, @Nullable Continuation continuation0) {
                return ((com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsInteractor.notifyInstalled.1)this.create(flowCollector0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                FlowCollector flowCollector0;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        flowCollector0 = (FlowCollector)this.L$0;
                        CashFriendsApplyApi cashFriendsApplyApi0 = CashFriendsInteractor.applyApi;
                        if(cashFriendsApplyApi0 != null) {
                            this.L$0 = flowCollector0;
                            this.label = 1;
                            object0 = cashFriendsApplyApi0.notifyInstalled(this.$jsonObject, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            break;
                        }
                        q.m("applyApi");
                        throw null;
                    }
                    case 1: {
                        flowCollector0 = (FlowCollector)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                this.L$0 = null;
                this.label = 2;
                return flowCollector0.emit(((CashFriendsApplyApiData)object0), this) == a0 ? a0 : H.a;
            }
        }), Dispatchers.getIO());
    }

    @NotNull
    public final Flow sendVideoTracking(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "ask");
        q.g(s1, "actType");
        q.g(s2, "env");
        return FlowKt.flowOn(FlowKt.flow(new n(s1, s2, null) {
            final String $actType;
            final String $ask;
            final String $env;
            private Object L$0;
            int label;

            {
                this.$ask = s;
                this.$actType = s1;
                this.$env = s2;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                Continuation continuation1 = new com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsInteractor.sendVideoTracking.1(this.$ask, this.$actType, this.$env, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((FlowCollector)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull FlowCollector flowCollector0, @Nullable Continuation continuation0) {
                return ((com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsInteractor.sendVideoTracking.1)this.create(flowCollector0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                FlowCollector flowCollector0;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        flowCollector0 = (FlowCollector)this.L$0;
                        CashFriendsTrackApi cashFriendsTrackApi0 = CashFriendsInteractor.trackApi;
                        if(cashFriendsTrackApi0 != null) {
                            this.L$0 = flowCollector0;
                            this.label = 1;
                            object0 = DefaultImpls.sendVideoTracking$default(cashFriendsTrackApi0, this.$ask, this.$actType, this.$env, null, this, 8, null);
                            if(object0 == a0) {
                                return a0;
                            }
                            break;
                        }
                        q.m("trackApi");
                        throw null;
                    }
                    case 1: {
                        flowCollector0 = (FlowCollector)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                this.L$0 = null;
                this.label = 2;
                return flowCollector0.emit(((CashFriendsCPVTrackApiData)object0), this) == a0 ? a0 : H.a;
            }
        }), Dispatchers.getIO());
    }
}

