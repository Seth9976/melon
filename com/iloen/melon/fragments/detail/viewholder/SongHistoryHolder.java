package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.q0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.SongAchievementInfo.RecordList;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import e.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \u001A2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001AB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001D\u0010\u0011\u001A\u00020\u00102\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState;", "LJ8/q0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/q0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "recordCode", "", "getRecordIcon", "(Ljava/lang/String;)I", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "clickLog", "itemClickLog", "(Ljava/lang/String;)V", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/q0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongHistoryHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryHolder$Companion;", "", "<init>", "()V", "TAG", "", "RECORD_TYPE_C1", "RECORD_TYPE_C2", "RECORD_TYPE_C3", "RECORD_TYPE_C4", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongHistoryHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D022B, viewGroup0, false);  // layout:detail_song_history
            int v = 0x7F0A03D8;  // id:divider_view
            View view1 = I.C(view0, 0x7F0A03D8);  // id:divider_view
            if(view1 != null) {
                v = 0x7F0A05A7;  // id:item_container
                View view2 = I.C(view0, 0x7F0A05A7);  // id:item_container
                if(((LinearLayout)view2) != null) {
                    v = 0x7F0A07CA;  // id:main_contents_title
                    View view3 = I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                    if(((MainTabTitleView)view3) != null) {
                        v = 0x7F0A0906;  // id:past_rank_container
                        View view4 = I.C(view0, 0x7F0A0906);  // id:past_rank_container
                        if(((LinearLayout)view4) != null && ((LinearLayout)I.C(view0, 0x7F0A09AE)) != null) {  // id:rank_container
                            v = 0x7F0A09CA;  // id:record_history_container
                            View view5 = I.C(view0, 0x7F0A09CA);  // id:record_history_container
                            if(((LinearLayout)view5) != null) {
                                v = 0x7F0A0C26;  // id:tv_best_rank
                                View view6 = I.C(view0, 0x7F0A0C26);  // id:tv_best_rank
                                if(((MelonTextView)view6) != null) {
                                    v = 0x7F0A0C27;  // id:tv_best_rank_date
                                    View view7 = I.C(view0, 0x7F0A0C27);  // id:tv_best_rank_date
                                    if(((MelonTextView)view7) != null && ((MelonTextView)I.C(view0, 0x7F0A0C35)) != null) {  // id:tv_chart_title
                                        v = 0x7F0A0CD8;  // id:tv_past_rank
                                        View view8 = I.C(view0, 0x7F0A0CD8);  // id:tv_past_rank
                                        if(((MelonTextView)view8) != null && ((MelonTextView)I.C(view0, 0x7F0A0CF4)) != null) {  // id:tv_rank_title
                                            return new SongHistoryHolder(new q0(((RelativeLayout)view0), view1, ((LinearLayout)view2), ((MainTabTitleView)view3), ((LinearLayout)view4), ((LinearLayout)view5), ((MelonTextView)view6), ((MelonTextView)view7), ((MelonTextView)view8)), onViewHolderActionBaseListener0);
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
    private static final String RECORD_TYPE_C1 = "C1";
    @NotNull
    private static final String RECORD_TYPE_C2 = "C2";
    @NotNull
    private static final String RECORD_TYPE_C3 = "C3";
    @NotNull
    private static final String RECORD_TYPE_C4 = "C4";
    @NotNull
    public static final String TAG = "SongHistoryHolder";
    @NotNull
    private q0 holderBind;

    static {
        SongHistoryHolder.Companion = new Companion(null);
        SongHistoryHolder.$stable = 8;
    }

    public SongHistoryHolder(@NotNull q0 q00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(q00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(q00, onViewHolderActionBaseListener0);
        this.holderBind = q00;
        this.setTitleView(q00.d);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final int getRecordIcon(String s) {
        if(q.b(s, "C2")) {
            return 0x7F0803C1;  // drawable:ic_chart_moment
        }
        return q.b(s, "C3") ? 0x7F0803BE : 0x7F0803BD;  // drawable:ic_chart_cumulative
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130A87);  // string:song_detail_title_song_history "이 곡의 기록"
    }

    public final void itemClickLog(@NotNull String s) {
        q.g(s, "clickLog");
        LogU.Companion.d("SongHistoryHolder", "#### clickLog : " + s);
    }

    @NotNull
    public static final SongHistoryHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongHistoryHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        SongHistoryUiState songHistoryUiState0 = (SongHistoryUiState)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
            mainTabTitleView0.setIconRes(0x7F080474);  // drawable:ic_info_15
            mainTabTitleView0.setTitleRightMargin(0.0f);
            mainTabTitleView0.setIconContentDescription(0x7F130B54);  // string:talkback_info_popup "안내 팝업"
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onTitleIconClick(View view0) {
                    q.g(view0, "view");
                    this.getGuidePopupAction().invoke();
                    f f0 = SongHistoryHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = SongHistoryHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = SongHistoryHolder.this.getString(0x7F130E12);  // string:tiara_common_layer1_song_history "이곡의기록"
                        f0.F = SongHistoryHolder.this.getString(0x7F130D3B);  // string:tiara_click_copy_info "안내"
                        f0.a().track();
                    }
                }
            });
        }
        q0 q00 = this.holderBind;
        if(songHistoryUiState0.getYesterdayRank().length() == 0) {
            q00.e.setVisibility(0);
            int v = ColorUtils.getColor(q00.i.getContext(), 0x7F060160);  // color:gray600s_support_high_contrast
            q00.i.setTextColor(v);
            q00.i.setText("-");
        }
        else if(songHistoryUiState0.isChartIn()) {
            q00.e.setVisibility(0);
            int v1 = ColorUtils.getColor(q00.i.getContext(), 0x7F06017B);  // color:green500s
            q00.i.setTextColor(v1);
            String s = this.getString(0x7F1305BF);  // string:mc_rank "%s위"
            l1.D(new Object[]{songHistoryUiState0.getYesterdayRank()}, 1, s, q00.i);
        }
        else {
            q00.e.setVisibility(8);
        }
        if(songHistoryUiState0.getBestRank().length() > 0) {
            int v2 = ColorUtils.getColor(q00.g.getContext(), 0x7F06016D);  // color:gray900s
            q00.g.setTextColor(v2);
            String s1 = this.getString(0x7F1305BF);  // string:mc_rank "%s위"
            l1.D(new Object[]{songHistoryUiState0.getBestRank()}, 1, s1, q00.g);
            q00.h.setText(songHistoryUiState0.getBestRankDate());
        }
        else {
            int v3 = ColorUtils.getColor(q00.g.getContext(), 0x7F060160);  // color:gray600s_support_high_contrast
            q00.g.setTextColor(v3);
            q00.g.setText("-");
            q00.h.setText("");
        }
        if(!songHistoryUiState0.getRecordList().isEmpty()) {
            LinearLayout linearLayout0 = q00.c;
            q00.f.setVisibility(0);
            if(linearLayout0.getChildCount() <= 0) {
                int v4 = 0;
                for(Object object0: songHistoryUiState0.getRecordList()) {
                    if(v4 >= 0) {
                        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D022C, linearLayout0, false);  // layout:detail_song_history_item
                        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A067A);  // id:iv_record
                        String s2 = ((RecordList)object0).recordCode;
                        q.f(s2, "recordCode");
                        imageView0.setBackgroundResource(this.getRecordIcon(s2));
                        ((TextView)view0.findViewById(0x7F0A0CF9)).setText(((RecordList)object0).record);  // id:tv_record
                        linearLayout0.addView(view0);
                        ++v4;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
            return;
        }
        q00.f.setVisibility(8);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

