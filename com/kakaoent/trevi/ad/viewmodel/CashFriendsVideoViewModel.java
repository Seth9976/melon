package com.kakaoent.trevi.ad.viewmodel;

import androidx.appcompat.app.o;
import androidx.lifecycle.f0;
import androidx.lifecycle.m0;
import com.kakaoent.trevi.ad.domain.CashFriendsCPVTrackApiData;
import com.kakaoent.trevi.ad.repository.remote.interactor.CashFriendsInteractor;
import com.kakaoent.trevi.ad.util.TreviLog;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u001D\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\f0\u000F8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel;", "Landroidx/lifecycle/m0;", "<init>", "()V", "", "ask", "actType", "env", "Lie/H;", "sendTracking", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/coroutines/channels/Channel;", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event;", "eventChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/flow/Flow;", "eventsFlow", "Lkotlinx/coroutines/flow/Flow;", "getEventsFlow", "()Lkotlinx/coroutines/flow/Flow;", "", "retryCount", "I", "Companion", "Event", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsVideoViewModel extends m0 {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Companion;", "", "()V", "TAG", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event;", "", "()V", "CompleteFailVideoTracking", "SuccessVideoTracking", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event$CompleteFailVideoTracking;", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event$SuccessVideoTracking;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static abstract class Event {
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001A\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001A\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event$CompleteFailVideoTracking;", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event;", "", "actType", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getActType", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class CompleteFailVideoTracking extends Event {
            @NotNull
            private final String actType;

            public CompleteFailVideoTracking(@NotNull String s) {
                q.g(s, "actType");
                super(null);
                this.actType = s;
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                return object0 instanceof CompleteFailVideoTracking ? q.b(this.actType, ((CompleteFailVideoTracking)object0).actType) : false;
            }

            @Override
            public int hashCode() {
                return this.actType.hashCode();
            }

            @Override
            @NotNull
            public String toString() {
                return o.r(new StringBuilder("CompleteFailVideoTracking(actType="), this.actType, ')');
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u001A\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001A\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event$SuccessVideoTracking;", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event;", "Lcom/kakaoent/trevi/ad/domain/CashFriendsCPVTrackApiData;", "trackingData", "", "actType", "<init>", "(Lcom/kakaoent/trevi/ad/domain/CashFriendsCPVTrackApiData;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/kakaoent/trevi/ad/domain/CashFriendsCPVTrackApiData;", "getTrackingData", "()Lcom/kakaoent/trevi/ad/domain/CashFriendsCPVTrackApiData;", "Ljava/lang/String;", "getActType", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
        public static final class SuccessVideoTracking extends Event {
            @NotNull
            private final String actType;
            @NotNull
            private final CashFriendsCPVTrackApiData trackingData;

            public SuccessVideoTracking(@NotNull CashFriendsCPVTrackApiData cashFriendsCPVTrackApiData0, @NotNull String s) {
                q.g(cashFriendsCPVTrackApiData0, "trackingData");
                q.g(s, "actType");
                super(null);
                this.trackingData = cashFriendsCPVTrackApiData0;
                this.actType = s;
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                if(!(object0 instanceof SuccessVideoTracking)) {
                    return false;
                }
                return q.b(this.trackingData, ((SuccessVideoTracking)object0).trackingData) ? q.b(this.actType, ((SuccessVideoTracking)object0).actType) : false;
            }

            @NotNull
            public final String getActType() {
                return this.actType;
            }

            @NotNull
            public final CashFriendsCPVTrackApiData getTrackingData() {
                return this.trackingData;
            }

            @Override
            public int hashCode() {
                return this.actType.hashCode() + this.trackingData.hashCode() * 0x1F;
            }

            @Override
            @NotNull
            public String toString() {
                StringBuilder stringBuilder0 = new StringBuilder("SuccessVideoTracking(trackingData=");
                stringBuilder0.append(this.trackingData);
                stringBuilder0.append(", actType=");
                return o.r(stringBuilder0, this.actType, ')');
            }
        }

        private Event() {
        }

        public Event(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Channel eventChannel;
    @NotNull
    private final Flow eventsFlow;
    private int retryCount;

    static {
        CashFriendsVideoViewModel.Companion = new Companion(null);
    }

    public CashFriendsVideoViewModel() {
        Channel channel0 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this.eventChannel = channel0;
        this.eventsFlow = FlowKt.receiveAsFlow(channel0);
    }

    @NotNull
    public final Flow getEventsFlow() {
        return this.eventsFlow;
    }

    public final void sendTracking(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "ask");
        q.g(s1, "actType");
        q.g(s2, "env");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(s1, s2, this, null) {
            final String $actType;
            final String $ask;
            final String $env;
            int label;

            {
                this.$ask = s;
                this.$actType = s1;
                this.$env = s2;
                CashFriendsVideoViewModel.this = cashFriendsVideoViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.sendTracking.1(this.$ask, this.$actType, this.$env, CashFriendsVideoViewModel.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                return ((com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.sendTracking.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.catch(FlowKt.onEach(CashFriendsInteractor.INSTANCE.sendVideoTracking(this.$ask, this.$actType, this.$env), new n(this.$actType, null) {
                            final String $actType;
                            Object L$0;
                            int label;

                            {
                                CashFriendsVideoViewModel.this = cashFriendsVideoViewModel0;
                                this.$actType = s;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            @NotNull
                            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                Continuation continuation1 = new com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.sendTracking.1.1(CashFriendsVideoViewModel.this, this.$actType, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Nullable
                            public final Object invoke(@NotNull CashFriendsCPVTrackApiData cashFriendsCPVTrackApiData0, @Nullable Continuation continuation0) {
                                return ((com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.sendTracking.1.1)this.create(cashFriendsCPVTrackApiData0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CashFriendsCPVTrackApiData)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        CashFriendsCPVTrackApiData cashFriendsCPVTrackApiData0 = (CashFriendsCPVTrackApiData)this.L$0;
                                        CashFriendsVideoViewModel.this.retryCount = 0;
                                        SuccessVideoTracking cashFriendsVideoViewModel$Event$SuccessVideoTracking0 = new SuccessVideoTracking(cashFriendsCPVTrackApiData0, this.$actType);
                                        this.label = 1;
                                        return CashFriendsVideoViewModel.this.eventChannel.send(cashFriendsVideoViewModel$Event$SuccessVideoTracking0, this) == a0 ? a0 : H.a;
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
                        }), new we.o(CashFriendsVideoViewModel.this, this.$ask, this.$env, null) {
                            final String $actType;
                            final String $ask;
                            final String $env;
                            Object L$0;
                            int label;

                            {
                                this.$actType = s;
                                CashFriendsVideoViewModel.this = cashFriendsVideoViewModel0;
                                this.$ask = s1;
                                this.$env = s2;
                                super(3, continuation0);
                            }

                            @Override  // we.o
                            public Object invoke(Object object0, Object object1, Object object2) {
                                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
                            }

                            @Nullable
                            public final Object invoke(@NotNull FlowCollector flowCollector0, @NotNull Throwable throwable0, @Nullable Continuation continuation0) {
                                com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.sendTracking.1.2 cashFriendsVideoViewModel$sendTracking$1$20 = new com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.sendTracking.1.2(this.$actType, CashFriendsVideoViewModel.this, this.$ask, this.$env, continuation0);
                                cashFriendsVideoViewModel$sendTracking$1$20.L$0 = throwable0;
                                return cashFriendsVideoViewModel$sendTracking$1$20.invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        String s = "sendTracking + " + e2.a.T(((Throwable)this.L$0));
                                        TreviLog.INSTANCE.e("CashFriendsVideoViewModel", s);
                                        if(q.b(this.$actType, "V_COMPLETE") && CashFriendsVideoViewModel.this.retryCount < 2) {
                                            ++CashFriendsVideoViewModel.this.retryCount;
                                            CashFriendsVideoViewModel.this.sendTracking(this.$ask, this.$actType, this.$env);
                                            return H.a;
                                        }
                                        CashFriendsVideoViewModel.this.retryCount = 0;
                                        CompleteFailVideoTracking cashFriendsVideoViewModel$Event$CompleteFailVideoTracking0 = new CompleteFailVideoTracking(this.$actType);
                                        this.label = 1;
                                        return CashFriendsVideoViewModel.this.eventChannel.send(cashFriendsVideoViewModel$Event$CompleteFailVideoTracking0, this) == a0 ? a0 : H.a;
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
                        });
                        this.label = 1;
                        return FlowKt.collect(flow0, this) == a0 ? a0 : H.a;
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
}

