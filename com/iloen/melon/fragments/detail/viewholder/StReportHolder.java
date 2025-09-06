package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.v0;
import Vb.i;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.ComposeView;
import cd.V2;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.ui.ListeningGraphKt;
import com.iloen.melon.fragments.detail.ui.ListeningUiState;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import p8.f;
import va.e0;
import va.o;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001A2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001AB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0011\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001A\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/StReportHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;", "LJ8/v0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/v0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/detail/viewholder/ViewType;", "viewType", "uiState", "Lie/H;", "updateMyListenContainer", "(Lcom/iloen/melon/fragments/detail/viewholder/ViewType;Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;)V", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "showLoginPopup", "()V", "", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/v0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StReportHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/StReportHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/StReportHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final StReportHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0234, viewGroup0, false);  // layout:detail_song_streaming_report
            int v = 0x7F0A0172;  // id:btn_login
            View view1 = I.C(view0, 0x7F0A0172);  // id:btn_login
            if(((MelonTextView)view1) != null) {
                v = 0x7F0A0309;  // id:compose_view
                View view2 = I.C(view0, 0x7F0A0309);  // id:compose_view
                if(((ComposeView)view2) != null) {
                    v = 0x7F0A03D8;  // id:divider_view
                    View view3 = I.C(view0, 0x7F0A03D8);  // id:divider_view
                    if(view3 != null) {
                        v = 0x7F0A07A8;  // id:login_container
                        View view4 = I.C(view0, 0x7F0A07A8);  // id:login_container
                        if(((LinearLayout)view4) != null) {
                            v = 0x7F0A07CA;  // id:main_contents_title
                            View view5 = I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                            if(((MainTabTitleView)view5) != null) {
                                v = 0x7F0A0892;  // id:my_listen_container
                                View view6 = I.C(view0, 0x7F0A0892);  // id:my_listen_container
                                if(((LinearLayout)view6) != null) {
                                    v = 0x7F0A0C58;  // id:tv_daily_listener_count
                                    View view7 = I.C(view0, 0x7F0A0C58);  // id:tv_daily_listener_count
                                    if(((MelonTextView)view7) != null) {
                                        v = 0x7F0A0C79;  // id:tv_first_listener_date
                                        View view8 = I.C(view0, 0x7F0A0C79);  // id:tv_first_listener_date
                                        if(((MelonTextView)view8) != null) {
                                            v = 0x7F0A0CA5;  // id:tv_listener_percent_title
                                            View view9 = I.C(view0, 0x7F0A0CA5);  // id:tv_listener_percent_title
                                            if(((MelonTextView)view9) != null) {
                                                v = 0x7F0A0CC8;  // id:tv_my_listen_count
                                                View view10 = I.C(view0, 0x7F0A0CC8);  // id:tv_my_listen_count
                                                if(((MelonTextView)view10) != null) {
                                                    v = 0x7F0A0D46;  // id:tv_total_listen_count
                                                    View view11 = I.C(view0, 0x7F0A0D46);  // id:tv_total_listen_count
                                                    if(((MelonTextView)view11) != null) {
                                                        v = 0x7F0A0D47;  // id:tv_total_listener_count
                                                        View view12 = I.C(view0, 0x7F0A0D47);  // id:tv_total_listener_count
                                                        if(((MelonTextView)view12) != null) {
                                                            return new StReportHolder(new v0(((LinearLayout)view0), ((MelonTextView)view1), ((ComposeView)view2), view3, ((LinearLayout)view4), ((MainTabTitleView)view5), ((LinearLayout)view6), ((MelonTextView)view7), ((MelonTextView)view8), ((MelonTextView)view9), ((MelonTextView)view10), ((MelonTextView)view11), ((MelonTextView)view12)), onViewHolderActionBaseListener0);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "StReportHolder";
    @NotNull
    private v0 holderBind;

    static {
        StReportHolder.Companion = new Companion(null);
        StReportHolder.$stable = 8;
    }

    public StReportHolder(@NotNull v0 v00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(v00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(v00, onViewHolderActionBaseListener0);
        this.holderBind = v00;
        this.setTitleView(v00.f);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130A89);  // string:song_detail_title_streaming_report "스트리밍 리포트"
    }

    @NotNull
    public static final StReportHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return StReportHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        StreamReportUiState streamReportUiState0 = (StreamReportUiState)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
            mainTabTitleView0.setIconRes(0x7F080474);  // drawable:ic_info_15
            mainTabTitleView0.setTitleRightMargin(0.0f);
            mainTabTitleView0.setIconContentDescription(0x7F130B54);  // string:talkback_info_popup "안내 팝업"
            mainTabTitleView0.setRightmostIconRes(0x7F080175);  // drawable:btn_common_share_22
            mainTabTitleView0.setRightmostIconContentDescription(0x7F130C48);  // string:talkback_share_btn "공유 버튼"
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onRightmostIconClick(View view0) {
                    q.g(view0, "view");
                    Navigator.INSTANCE.openStreamingCard(this.$row.getContentId());
                    f f0 = adapterInViewHolder$Row0.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = adapterInViewHolder$Row0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                        f0.d = ActionKind.Share;
                        f0.y = adapterInViewHolder$Row0.getString(0x7F130E18);  // string:tiara_common_layer1_song_streaming_report "스트리밍리포트"
                        f0.F = adapterInViewHolder$Row0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                        f0.a().track();
                    }
                }

                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onTitleIconClick(View view0) {
                    q.g(view0, "view");
                    this.getGuidePopupAction().invoke();
                    f f0 = adapterInViewHolder$Row0.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = adapterInViewHolder$Row0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = adapterInViewHolder$Row0.getString(0x7F130E18);  // string:tiara_common_layer1_song_streaming_report "스트리밍리포트"
                        f0.F = adapterInViewHolder$Row0.getString(0x7F130D3B);  // string:tiara_click_copy_info "안내"
                        f0.a().track();
                    }
                }
            });
        }
        v0 v00 = this.holderBind;
        ComposeView composeView0 = v00.c;
        MelonTextView melonTextView0 = v00.j;
        StReportHolderKt.access$setCountText(v00.l, streamReportUiState0.getTotalListenCount());
        StReportHolderKt.access$setCountText(v00.m, streamReportUiState0.getTotalListenerCount());
        StReportHolderKt.access$setCountText(v00.h, streamReportUiState0.getDailyListenerCount());
        StReportHolderKt.access$setCountText(v00.i, streamReportUiState0.getFirstListenDate());
        MyListen viewType$MyListen0 = ((e0)o.a()).m() ? MyListen.INSTANCE : Login.INSTANCE;
        this.updateMyListenContainer(viewType$MyListen0, streamReportUiState0);
        if(!q.b(streamReportUiState0.getListeningUiState(), ListeningUiState.Companion.getEmpty()) && streamReportUiState0.getDailyListenerCount().length() != 0) {
            melonTextView0.setVisibility(0);
            composeView0.setVisibility(0);
            composeView0.setContent(new b(1056463805, new V2(streamReportUiState0, 1), true));
            return;
        }
        melonTextView0.setVisibility(8);
        composeView0.setVisibility(8);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final H onBindView$lambda$3$lambda$2$lambda$1(StreamReportUiState streamReportUiState0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            ListeningGraphKt.ListeningGraph(streamReportUiState0.getListeningUiState(), ((p)l0), 0);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    public final void showLoginPopup() {
        com.melon.ui.popup.b.x(MelonFragmentManager.getInstance().getCurrentActivity().getSupportFragmentManager(), "안내", "로그인이 필요한 서비스입니다.\n로그인하시겠습니까?", false, false, null, null, new i(26), null, null, null, 0xEF8);
    }

    private static final H showLoginPopup$lambda$7() {
        Navigator.openLoginView(r8.f.f);
        return H.a;
    }

    private final void updateMyListenContainer(ViewType viewType0, StreamReportUiState streamReportUiState0) {
        v0 v00 = this.holderBind;
        if(q.b(viewType0, MyListen.INSTANCE)) {
            v00.e.setVisibility(8);
            v00.g.setVisibility(0);
            MelonTextView melonTextView0 = v00.k;
            String s = streamReportUiState0.getListenCount();
            if(s.length() == 0) {
                s = "0";
            }
            melonTextView0.setText(s);
            return;
        }
        if(!q.b(viewType0, Login.INSTANCE)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        v00.e.setVisibility(0);
        v00.g.setVisibility(8);
        com.iloen.melon.fragments.detail.viewholder.p p0 = new com.iloen.melon.fragments.detail.viewholder.p(this, 3);
        ViewUtils.setOnClickListener(v00.b, p0);
    }

    private static final void updateMyListenContainer$lambda$6$lambda$5(StReportHolder stReportHolder0, View view0) {
        stReportHolder0.showLoginPopup();
    }
}

