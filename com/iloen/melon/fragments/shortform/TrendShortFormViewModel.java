package com.iloen.melon.fragments.shortform;

import android.content.Context;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.f0;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.fragments.comments.BbsParam;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.TrendShorFormReq;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response;
import com.iloen.melon.net.v6x.response.TrendShortFormRes;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.b;
import u8.c;
import u8.d;
import u8.e;
import v8.f;
import v8.g;
import v8.h;
import v9.i;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003JKLB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0012J\u001A\u0010\u0016\u001A\u00020\u00052\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0096@\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001A\u00020\n2\u0006\u0010\u0018\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0015\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\u001B\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\r\u0010\u001F\u001A\u00020\n\u00A2\u0006\u0004\b\u001F\u0010\u0004J\r\u0010 \u001A\u00020\n\u00A2\u0006\u0004\b \u0010\u0004R\u0014\u0010\"\u001A\u00020!8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\"\u0010#R\u001A\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00050$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u001D\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00050\'8\u0006\u00A2\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+R \u0010/\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0,8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u00100R#\u00102\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-018\u0006\u00A2\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u00105R$\u00108\u001A\u0002062\u0006\u00107\u001A\u0002068\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b:\u0010;R\u001A\u0010=\u001A\b\u0012\u0004\u0012\u00020\b0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u001D\u0010@\u001A\b\u0012\u0004\u0012\u00020\b0?8\u0006\u00A2\u0006\f\n\u0004\b@\u0010A\u001A\u0004\bB\u0010CR\u001A\u0010D\u001A\b\u0012\u0004\u0012\u00020\r0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bD\u0010>R\u001D\u0010E\u001A\b\u0012\u0004\u0012\u00020\r0?8\u0006\u00A2\u0006\f\n\u0004\bE\u0010A\u001A\u0004\bF\u0010CR$\u0010G\u001A\u00020\u00102\u0006\u00107\u001A\u00020\u00108\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\bG\u0010H\u001A\u0004\bI\u0010\u0012\u00A8\u0006M"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel;", "Lv8/f;", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes;", "<init>", "()V", "", "canPlay", "()Z", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent;", "event", "Lie/H;", "emitClickEvent", "(Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent;)V", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$EtcEvent;", "emitEtcEvent", "(Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$EtcEvent;)V", "", "getTag", "()Ljava/lang/String;", "getCacheKey", "Lv9/i;", "fetchType", "fetchRequest", "(Lv9/i;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "soundFlag", "setSoundFlag", "(Z)V", "Lcom/iloen/melon/fragments/comments/BbsParam;", "bbsParam", "showCommentPopup", "(Lcom/iloen/melon/fragments/comments/BbsParam;)V", "showLoginPopup", "clickSoundButton", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_soundAble", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "soundAble", "Lkotlinx/coroutines/flow/StateFlow;", "getSoundAble", "()Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/lifecycle/L;", "", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "_list", "Landroidx/lifecycle/L;", "Landroidx/lifecycle/K;", "list", "Landroidx/lifecycle/K;", "getList", "()Landroidx/lifecycle/K;", "", "value", "listSize", "I", "getListSize", "()I", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_clickEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "clickEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getClickEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_etcEventFlow", "etcEventFlow", "getEtcEventFlow", "menuId", "Ljava/lang/String;", "getMenuId", "Companion", "ClickEvent", "EtcEvent", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendShortFormViewModel extends f {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent;", "", "<init>", "()V", "ShowComment", "ShowLoginPopup", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent$ShowComment;", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent$ShowLoginPopup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class ClickEvent {
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent$ShowComment;", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent;", "bbsParam", "Lcom/iloen/melon/fragments/comments/BbsParam;", "<init>", "(Lcom/iloen/melon/fragments/comments/BbsParam;)V", "getBbsParam", "()Lcom/iloen/melon/fragments/comments/BbsParam;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ShowComment extends ClickEvent {
            public static final int $stable;
            @NotNull
            private final BbsParam bbsParam;

            public ShowComment(@NotNull BbsParam bbsParam0) {
                q.g(bbsParam0, "bbsParam");
                super(null);
                this.bbsParam = bbsParam0;
            }

            @NotNull
            public final BbsParam component1() {
                return this.bbsParam;
            }

            @NotNull
            public final ShowComment copy(@NotNull BbsParam bbsParam0) {
                q.g(bbsParam0, "bbsParam");
                return new ShowComment(bbsParam0);
            }

            public static ShowComment copy$default(ShowComment trendShortFormViewModel$ClickEvent$ShowComment0, BbsParam bbsParam0, int v, Object object0) {
                if((v & 1) != 0) {
                    bbsParam0 = trendShortFormViewModel$ClickEvent$ShowComment0.bbsParam;
                }
                return trendShortFormViewModel$ClickEvent$ShowComment0.copy(bbsParam0);
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                return object0 instanceof ShowComment ? q.b(this.bbsParam, ((ShowComment)object0).bbsParam) : false;
            }

            @NotNull
            public final BbsParam getBbsParam() {
                return this.bbsParam;
            }

            @Override
            public int hashCode() {
                return this.bbsParam.hashCode();
            }

            @Override
            @NotNull
            public String toString() {
                return "ShowComment(bbsParam=" + this.bbsParam + ")";
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent$ShowLoginPopup;", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ShowLoginPopup extends ClickEvent {
            public static final int $stable;
            @NotNull
            public static final ShowLoginPopup INSTANCE;

            static {
                ShowLoginPopup.INSTANCE = new ShowLoginPopup();
            }

            private ShowLoginPopup() {
                super(null);
            }

            // 去混淆评级： 低(20)
            @Override
            public boolean equals(@Nullable Object object0) {
                return this == object0 ? true : object0 instanceof ShowLoginPopup;
            }

            @Override
            public int hashCode() {
                return -1217520107;
            }

            @Override
            @NotNull
            public String toString() {
                return "ShowLoginPopup";
            }
        }

        public static final int $stable;

        private ClickEvent() {
        }

        public ClickEvent(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$EtcEvent;", "", "<init>", "()V", "ClickSoundButton", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$EtcEvent$ClickSoundButton;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class EtcEvent {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$EtcEvent$ClickSoundButton;", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$EtcEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ClickSoundButton extends EtcEvent {
            public static final int $stable;
            @NotNull
            public static final ClickSoundButton INSTANCE;

            static {
                ClickSoundButton.INSTANCE = new ClickSoundButton();
            }

            private ClickSoundButton() {
                super(null);
            }

            // 去混淆评级： 低(20)
            @Override
            public boolean equals(@Nullable Object object0) {
                return this == object0 ? true : object0 instanceof ClickSoundButton;
            }

            @Override
            public int hashCode() {
                return 0x37A222FA;
            }

            @Override
            @NotNull
            public String toString() {
                return "ClickSoundButton";
            }
        }

        public static final int $stable;

        private EtcEvent() {
        }

        public EtcEvent(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TrendShortFormViewModel";
    @NotNull
    private final MutableSharedFlow _clickEventFlow;
    @NotNull
    private final MutableSharedFlow _etcEventFlow;
    @NotNull
    private final L _list;
    @NotNull
    private final MutableStateFlow _soundAble;
    @NotNull
    private final SharedFlow clickEventFlow;
    @NotNull
    private final SharedFlow etcEventFlow;
    @NotNull
    private final K list;
    private int listSize;
    @NotNull
    private final LogU log;
    @NotNull
    private String menuId;
    @NotNull
    private final StateFlow soundAble;

    static {
        TrendShortFormViewModel.Companion = new Companion(null);
        TrendShortFormViewModel.$stable = 8;
    }

    public TrendShortFormViewModel() {
        LogU logU0 = new LogU("TrendShortFormViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._soundAble = mutableStateFlow0;
        this.soundAble = mutableStateFlow0;
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this._list = l0;
        this.list = l0;
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._clickEventFlow = mutableSharedFlow0;
        this.clickEventFlow = FlowKt.asSharedFlow(mutableSharedFlow0);
        MutableSharedFlow mutableSharedFlow1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._etcEventFlow = mutableSharedFlow1;
        this.etcEventFlow = FlowKt.asSharedFlow(mutableSharedFlow1);
        this.menuId = "";
    }

    // 去混淆评级： 低(23)
    private final boolean canPlay() {
        if(MelonSettingInfo.isLowMemoryMode()) {
            return false;
        }
        return MelonSettingInfo.getUseWifiForBgAutoPlay() ? true : NetUtils.checkDataNetwork() == 1 && MelonSettingInfo.getUseDataForBgAutoPlay();
    }

    public final void clickSoundButton() {
        this.emitEtcEvent(ClickSoundButton.INSTANCE);
    }

    private final void emitClickEvent(ClickEvent trendShortFormViewModel$ClickEvent0) {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(trendShortFormViewModel$ClickEvent0, null) {
            final ClickEvent $event;
            int label;

            {
                TrendShortFormViewModel.this = trendShortFormViewModel0;
                this.$event = trendShortFormViewModel$ClickEvent0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.emitClickEvent.1(TrendShortFormViewModel.this, this.$event, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.emitClickEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return TrendShortFormViewModel.this._clickEventFlow.emit(this.$event, this) == a0 ? a0 : H.a;
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

    private final void emitEtcEvent(EtcEvent trendShortFormViewModel$EtcEvent0) {
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n(trendShortFormViewModel$EtcEvent0, null) {
            final EtcEvent $event;
            int label;

            {
                TrendShortFormViewModel.this = trendShortFormViewModel0;
                this.$event = trendShortFormViewModel$EtcEvent0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.emitEtcEvent.1(TrendShortFormViewModel.this, this.$event, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.emitEtcEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return TrendShortFormViewModel.this._etcEventFlow.emit(this.$event, this) == a0 ? a0 : H.a;
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

    @Override  // v8.f
    @Nullable
    public Object fetchRequest(@Nullable i i0, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getMain(), new n(i0, null) {
            final i $fetchType;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int label;

            {
                TrendShortFormViewModel.this = trendShortFormViewModel0;
                this.$fetchType = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2(TrendShortFormViewModel.this, this.$fetchType, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s;
                ArrayList arrayList0;
                a a0 = a.a;
                int v = this.label;
                boolean z = true;
                switch(v) {
                    case 0: {
                        d5.n.D(object0);
                        g g0 = new g(new TrendShorFormReq(Y.a(MelonAppBase.Companion)), TrendShortFormViewModel.this.getTag());
                        new c(TrendShortFormViewModel.this.getCacheKey());
                        com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$10 = new n(null) {
                            final g $requestWrapper;
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;

                            {
                                this.$requestWrapper = g0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1(this.$requestWrapper, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.2 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$1$20 = new n("DataAccessStrategy", "TrendShortFormRes", null) {
                                            final k $networkCall;
                                            final String $responseClassName;
                                            final String $tag;
                                            int label;

                                            {
                                                this.$networkCall = k0;
                                                this.$tag = s;
                                                this.$responseClassName = s1;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.2(this.$networkCall, this.$tag, this.$responseClassName, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d d0;
                                                a a0 = a.a;
                                                switch(this.label) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        this.label = 1;
                                                        object0 = this.$networkCall.invoke(this);
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
                                                switch(((d)object0).a.ordinal()) {
                                                    case 0: {
                                                        HttpResponse httpResponse0 = ((d)object0).b;
                                                        if(httpResponse0 == null) {
                                                            VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                            d0 = new d(e.b, null, volleyError0);
                                                        }
                                                        else {
                                                            d0 = new d(e.a, httpResponse0, null);
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d0 = new d(e.b, null, ((d)object0).c);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                                LogU.Companion.d(this.$tag, "getData() " + this.$responseClassName + " " + d0);
                                                return d0;
                                            }
                                        };
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.I$0 = 0;
                                        this.label = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$1$20, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        String s = (String)this.L$2;
                                        String s1 = (String)this.L$1;
                                        k k0 = (k)this.L$0;
                                        d5.n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }

                                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                                public final class com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.1 extends oe.i implements k {
                                    final g $requestWrapper;
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    int label;

                                    public com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.1(g g0, Continuation continuation0) {
                                        this.$requestWrapper = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.1(this.$requestWrapper, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                b.b();
                                                com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.1.1 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$1$1$10 = new n(null) {
                                                    final g $request;
                                                    int label;

                                                    {
                                                        this.$request = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.1.1(this.$request, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        if(this.label == 0) {
                                                            d5.n.D(object0);
                                                            try {
                                                                LogU.Companion.d("RemoteDataSource", "request.tag:" + this.$request.b);
                                                                RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                HttpResponse httpResponse0 = RequestBuilder.newInstance(this.$request.a).listener(requestFuture0).tag(this.$request.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                if(httpResponse0 != null && httpResponse0 instanceof TrendShortFormRes) {
                                                                    return new d(e.a, httpResponse0, null);
                                                                }
                                                                VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                return new d(e.b, null, volleyError1);
                                                            }
                                                            catch(VolleyError volleyError0) {
                                                                return new d(e.b, null, volleyError0);
                                                            }
                                                        }
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                };
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.I$0 = 0;
                                                this.label = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$1$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                g g0 = (g)this.L$1;
                                                t8.a a1 = (t8.a)this.L$0;
                                                d5.n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }

                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$10, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                    label_25:
                        g g1 = (g)this.L$5;
                        b b0 = (b)this.L$4;
                        c c1 = (c)this.L$3;
                        g g2 = (g)this.L$2;
                        b b1 = (b)this.L$1;
                        Context context0 = (Context)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        if(v != 2) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        c c0 = (c)this.L$6;
                        goto label_25;
                    }
                }
                v8.i i0 = e1.n.g(((d)object0), this.$fetchType);
                Object object1 = i0.c;
                h h0 = i0.a;
                h h1 = h.a;
                if(h0 == h1) {
                    if(((TrendShortFormRes)object1) == null) {
                        arrayList0 = new ArrayList();
                    }
                    else {
                        Response trendShortFormRes$Response0 = ((TrendShortFormRes)object1).response;
                        if(trendShortFormRes$Response0 == null) {
                            arrayList0 = new ArrayList();
                        }
                        else {
                            arrayList0 = trendShortFormRes$Response0.slotList;
                            if(arrayList0 == null) {
                                arrayList0 = new ArrayList();
                            }
                        }
                    }
                    if(!arrayList0.isEmpty()) {
                        TrendShortFormViewModel.this._list.postValue(arrayList0);
                        TrendShortFormViewModel.this.listSize = arrayList0.size();
                    }
                    TrendShortFormViewModel trendShortFormViewModel0 = TrendShortFormViewModel.this;
                    if(((TrendShortFormRes)object1) == null) {
                        s = "";
                    }
                    else {
                        s = ((TrendShortFormRes)object1).getMenuId();
                        if(s == null) {
                            s = "";
                        }
                    }
                    trendShortFormViewModel0.menuId = s;
                }
                TrendShortFormViewModel.this.get_response().setValue(i0);
                if(h0 != h1) {
                    z = false;
                }
                return Boolean.valueOf(z);

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                public final class com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2 extends oe.i implements n {
                    final c $cacheStrategyInfo;
                    final g $requestWrapper;
                    final int $startIndex;
                    int I$0;
                    long J$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;

                    public com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2(c c0, int v, g g0, Continuation continuation0) {
                        this.$cacheStrategyInfo = c0;
                        this.$startIndex = v;
                        this.$requestWrapper = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2(this.$cacheStrategyInfo, this.$startIndex, this.$requestWrapper, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.1 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$10 = new k(null) {
                                    final g $requestWrapper;
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    int label;

                                    {
                                        this.$requestWrapper = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.1(this.$requestWrapper, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                b.b();
                                                com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.1.1 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$1$10 = new n(null) {
                                                    final g $request;
                                                    int label;

                                                    {
                                                        this.$request = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.1.1(this.$request, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        if(this.label == 0) {
                                                            d5.n.D(object0);
                                                            try {
                                                                LogU.Companion.d("RemoteDataSource", "request.tag:" + this.$request.b);
                                                                RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                HttpResponse httpResponse0 = RequestBuilder.newInstance(this.$request.a).listener(requestFuture0).tag(this.$request.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                if(httpResponse0 != null && httpResponse0 instanceof TrendShortFormRes) {
                                                                    return new d(e.a, httpResponse0, null);
                                                                }
                                                                VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                return new d(e.b, null, volleyError1);
                                                            }
                                                            catch(VolleyError volleyError0) {
                                                                return new d(e.b, null, volleyError0);
                                                            }
                                                        }
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                };
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.I$0 = 0;
                                                this.label = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                g g0 = (g)this.L$1;
                                                t8.a a1 = (t8.a)this.L$0;
                                                d5.n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.2 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$20 = new we.a() {
                                    @Override  // we.a
                                    public Object invoke() {
                                        return this.invoke();
                                    }

                                    public final s8.b invoke() {
                                        return b.a().a(this.$cacheStrategyInfo.a);
                                    }
                                };
                                com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.3 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$30 = new k() {
                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        this.invoke(((HttpResponse)object0));
                                        return H.a;
                                    }

                                    public final void invoke(HttpResponse httpResponse0) {
                                        q.g(httpResponse0, "it");
                                        s8.a a0 = b.a();
                                        String s = b.c.k(httpResponse0);
                                        q.f(s, "toJson(...)");
                                        a0.b(new s8.b(this.$startIndex, this.$startIndex.a, s, System.currentTimeMillis()));
                                    }
                                };
                                com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.4 trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$40 = new n(new Integer(this.$startIndex), this.$cacheStrategyInfo.b, trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$10, trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$30, null) {
                                    final we.a $databaseQuery;
                                    final long $expiredTimeLimit;
                                    final k $networkCall;
                                    final k $saveCallResult;
                                    final Integer $startIndex;
                                    private Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
                                    int label;

                                    {
                                        this.$databaseQuery = a0;
                                        this.$startIndex = integer0;
                                        this.$expiredTimeLimit = v;
                                        this.$networkCall = k0;
                                        this.$saveCallResult = k1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.4(this.$databaseQuery, this.$startIndex, this.$expiredTimeLimit, this.$networkCall, this.$saveCallResult, continuation0);
                                        continuation1.L$0 = object0;
                                        return continuation1;
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d d0;
                                        String s1;
                                        String s;
                                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                                logU$Companion0.d("DataAccessStrategy", "getData() TrendShortFormRes");
                                                s8.b b0 = this.$databaseQuery == null ? null : ((s8.b)this.$databaseQuery.invoke());
                                                if(b0 != null && !u.H(b0, this.$startIndex, this.$expiredTimeLimit)) {
                                                    HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, TrendShortFormRes.class);
                                                    if(httpResponse0 != null) {
                                                        logU$Companion0.d("DataAccessStrategy", "getData() TrendShortFormRes cacheEntity not expired. > return cachedRes");
                                                        return new d(e.a, httpResponse0, null);
                                                    }
                                                }
                                                logU$Companion0.d("DataAccessStrategy", "getData() TrendShortFormRes cacheEntity expired.");
                                                this.L$0 = coroutineScope0;
                                                this.L$1 = "DataAccessStrategy";
                                                this.L$2 = "TrendShortFormRes";
                                                this.L$3 = null;
                                                this.label = 1;
                                                object0 = this.$networkCall.invoke(this);
                                                if(object0 == a0) {
                                                    return a0;
                                                }
                                                s = "TrendShortFormRes";
                                                s1 = "DataAccessStrategy";
                                                break;
                                            }
                                            case 1: {
                                                s8.b b1 = (s8.b)this.L$3;
                                                s = (String)this.L$2;
                                                String s2 = (String)this.L$1;
                                                d5.n.D(object0);
                                                s1 = s2;
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        switch(((d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse1 = ((d)object0).b;
                                                if(httpResponse1 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new d(e.b, null, volleyError0);
                                                }
                                                else {
                                                    d d1 = new d(e.a, httpResponse1, null);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new n(((d)object0), null) {
                                                        final d $responseContainer;
                                                        final k $saveCallResult;
                                                        int label;

                                                        {
                                                            this.$saveCallResult = k0;
                                                            this.$responseContainer = d0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.4.1(this.$saveCallResult, this.$responseContainer, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.shortform.TrendShortFormViewModel.fetchRequest.2.invokeSuspend..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            k k0 = this.$saveCallResult;
                                                            if(k0 != null) {
                                                                k0.invoke(this.$responseContainer.b);
                                                            }
                                                            return H.a;
                                                        }
                                                    }, 2, null);
                                                    d0 = d1;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new d(e.b, null, ((d)object0).c);
                                                break;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                        LogU.Companion.d(s1, "getData() " + s + " " + d0);
                                        return d0;
                                    }
                                };
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = this.$cacheStrategyInfo.b;
                                this.I$0 = 0;
                                this.label = 1;
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), trendShortFormViewModel$fetchRequest$2$invokeSuspend$$inlined$request$default$2$40, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                k k0 = (k)this.L$3;
                                we.a a1 = (we.a)this.L$2;
                                k k1 = (k)this.L$1;
                                Integer integer0 = (Integer)this.L$0;
                                d5.n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                }

            }
        }, continuation0);
    }

    @Override  // v8.f
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.e1.buildUpon().build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public final SharedFlow getClickEventFlow() {
        return this.clickEventFlow;
    }

    @NotNull
    public final SharedFlow getEtcEventFlow() {
        return this.etcEventFlow;
    }

    @NotNull
    public final K getList() {
        return this.list;
    }

    public final int getListSize() {
        return this.listSize;
    }

    @NotNull
    public final String getMenuId() {
        return this.menuId;
    }

    @NotNull
    public final StateFlow getSoundAble() {
        return this.soundAble;
    }

    @Override  // v8.a
    @NotNull
    public String getTag() {
        String s = MelonContentUris.e1.buildUpon().build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    public final void setSoundFlag(boolean z) {
        this._soundAble.setValue(Boolean.valueOf(z));
    }

    public final void showCommentPopup(@NotNull BbsParam bbsParam0) {
        q.g(bbsParam0, "bbsParam");
        this.emitClickEvent(new ShowComment(bbsParam0));
    }

    public final void showLoginPopup() {
        this.emitClickEvent(ShowLoginPopup.INSTANCE);
    }
}

