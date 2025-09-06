package com.iloen.melon.fragments.detail.viewholder;

import J8.V1;
import J8.h0;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.STATION;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 #2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001A\u00020\u00152\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001B\u0010\u0018\u001A\u0004\u0018\u00010\u00112\b\u0010\u000B\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0016\u0010\u001F\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0016\u0010!\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;", "LJ8/h0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/h0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "position", "LJ8/V1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;I)LJ8/V1;", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "getArtistName", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;)Ljava/lang/String;", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;ILcom/iloen/melon/net/v5x/response/DetailBaseRes$STATION;)V", "holderBind", "LJ8/h0;", "total", "I", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class StationHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/StationHolder$Companion;", "", "<init>", "()V", "TAG", "", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_NAVIGATE_STATION_DETAIL", "TALKBACK_ACTION_PLAYBACK", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final StationHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new StationHolder(h0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "StationHolder";
    public static final int TALKBACK_ACTION_DEFAULT = 100000000;
    public static final int TALKBACK_ACTION_NAVIGATE_STATION_DETAIL = 100000001;
    public static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    @NotNull
    private h0 holderBind;
    private int total;

    static {
        StationHolder.Companion = new Companion(null);
        StationHolder.$stable = 8;
    }

    public StationHolder(@NotNull h0 h00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(h00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(h00, onViewHolderActionBaseListener0);
        this.holderBind = h00;
        this.setTitleView(h00.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static final int access$getTotal$p(StationHolder stationHolder0) {
        return stationHolder0.total;
    }

    private final V1 bindItem(STATION detailBaseRes$STATION0, int v) {
        String s1;
        String s = null;
        V1 v10 = V1.a(LayoutInflater.from(this.getContext()), null);
        FrameLayout frameLayout0 = v10.a;
        ImageView imageView0 = v10.e;
        MelonTextView melonTextView0 = v10.g;
        MelonImageView melonImageView0 = v10.c.b;
        if(detailBaseRes$STATION0 == null || (detailBaseRes$STATION0.verticalImgUrl == null || detailBaseRes$STATION0.verticalImgUrl.length() <= 0)) {
            s1 = detailBaseRes$STATION0 == null ? null : detailBaseRes$STATION0.castImg;
        }
        else {
            s1 = detailBaseRes$STATION0.verticalImgUrl;
        }
        Glide.with(melonImageView0).load(s1).into(melonImageView0);
        String s2 = detailBaseRes$STATION0 == null ? null : detailBaseRes$STATION0.progTitle;
        ViewUtils.hideWhen(melonTextView0, s2 == null || s2.length() == 0);
        melonTextView0.setText(s2);
        MelonTextView melonTextView1 = v10.f;
        if(detailBaseRes$STATION0 != null) {
            s = detailBaseRes$STATION0.castTitle;
        }
        melonTextView1.setText(s);
        String s3 = this.getArtistName(detailBaseRes$STATION0);
        v10.b.setText(s3);
        imageView0.setOnClickListener(new A(this, detailBaseRes$STATION0, v, 0));
        frameLayout0.setOnClickListener(new A(this, detailBaseRes$STATION0, v, 1));
        imageView0.setImportantForAccessibility(2);
        frameLayout0.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, e.c(s2.getString(0x7F130AF4), " ", s2.getString(0x7F130AF1))));  // string:talkback_common_station "스테이션"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, s2.getString(0x7F130C59)));  // string:talkback_songlist_song_play "재생"
                String s = s2.getString(0x7F130AF4);  // string:talkback_common_station "스테이션"
                String s1 = s2.getString(0x7F130AE1);  // string:talkback_category "카테고리"
                String s2 = s2.getString(0x7F130C6F);  // string:talkback_title "제목"
                CharSequence charSequence0 = v.f.getText();
                String s3 = s2.getString(0x7F130AD2);  // string:talkback_artist "아티스트"
                CharSequence charSequence1 = v.b.getText();
                String s4 = s2.getString(0x7F130AF1);  // string:talkback_common_navigate_detail "상세보기"
                StringBuilder stringBuilder0 = a.o(s, ", ", s1, ": ", v10);
                stringBuilder0.append(", ");
                stringBuilder0.append(s2);
                stringBuilder0.append(": ");
                stringBuilder0.append(charSequence0);
                stringBuilder0.append(", ");
                stringBuilder0.append(s3);
                stringBuilder0.append(": ");
                stringBuilder0.append(charSequence1);
                stringBuilder0.append(", ");
                stringBuilder0.append(s4);
                accessibilityNodeInfo0.setContentDescription(stringBuilder0.toString());
                accessibilityNodeInfo0.setClassName("android.widget.Button");
                accessibilityNodeInfo0.setHintText(String.format(s2.getString(0x7F130BA8), Arrays.copyOf(new Object[]{StationHolder.access$getTotal$p(s2), ((int)(this.$position + 1))}, 2)));  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        v.a.performClick();
                        return true;
                    }
                    case 100000002: {
                        v.e.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        });
        return v10;
    }

    private static final void bindItem$lambda$2(StationHolder stationHolder0, STATION detailBaseRes$STATION0, int v, View view0) {
        stationHolder0.getOnViewHolderActionListener().onPlayRadioCast((detailBaseRes$STATION0 == null ? null : detailBaseRes$STATION0.castSeq));
        String s = stationHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        stationHolder0.itemClickLog(ActionKind.PlayMusic, s, v, detailBaseRes$STATION0);
    }

    private static final void bindItem$lambda$3(StationHolder stationHolder0, STATION detailBaseRes$STATION0, int v, View view0) {
        stationHolder0.getOnViewHolderActionListener().onOpenCastEpisodeDetailView((detailBaseRes$STATION0 == null ? null : detailBaseRes$STATION0.castSeq));
        String s = stationHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        stationHolder0.itemClickLog(ActionKind.ClickContent, s, v, detailBaseRes$STATION0);
    }

    @Nullable
    public String getArtistName(@Nullable STATION detailBaseRes$STATION0) {
        return detailBaseRes$STATION0 == null ? ProtocolUtils.getArtistNames(null) : ProtocolUtils.getArtistNames(detailBaseRes$STATION0.artistList);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1302FB);  // string:detail_common_title_station "스테이션"
    }

    public void itemClickLog(@NotNull ActionKind actionKind0, @NotNull String s, int v, @Nullable STATION detailBaseRes$STATION0) {
        q.g(actionKind0, "actionKind");
        q.g(s, "actionName");
    }

    @NotNull
    public static final StationHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return StationHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        this.total = list0.size();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        if(this.holderBind.b.getChildCount() <= 0) {
            int v = 0;
            for(Object object0: list0) {
                if(v >= 0) {
                    V1 v10 = this.bindItem(((STATION)object0), v);
                    this.holderBind.b.addView(v10.a);
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

