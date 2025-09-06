package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.d2;
import J8.z0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.CastList;
import com.iloen.melon.net.v6x.response.CastEpsdDetailRes.Response.RecmStationInfo;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u0000 \u001C2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001CB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001D\u0010\u0019\u001A\u00020\u00112\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/RecommendCastHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$RecmStationInfo;", "LJ8/z0;", "binding", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/z0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastList;", "item", "", "position", "LJ8/d2;", "bindItem", "(Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastList;I)LJ8/d2;", "Lie/H;", "stationClickLog", "(Lcom/iloen/melon/net/v6x/response/CastEpsdDetailRes$Response$CastList;I)V", "stationPlayClickLog", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "LJ8/z0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RecommendCastHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/RecommendCastHolder$Companion;", "", "<init>", "()V", "ITEM_SIZE_MAX", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/RecommendCastHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RecommendCastHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "actionListener");
            View view0 = o.e(viewGroup0, 0x7F0D0238, viewGroup0, false);  // layout:detail_station_episode_recommend_cast
            int v = 0x7F0A05A7;  // id:item_container
            LinearLayout linearLayout0 = (LinearLayout)I.C(view0, 0x7F0A05A7);  // id:item_container
            if(linearLayout0 != null) {
                v = 0x7F0A07CA;  // id:main_contents_title
                MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                if(mainTabTitleView0 != null) {
                    return new RecommendCastHolder(new z0(((LinearLayout)view0), linearLayout0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int ITEM_SIZE_MAX = 3;
    @NotNull
    private final z0 binding;

    static {
        RecommendCastHolder.Companion = new Companion(null);
        RecommendCastHolder.$stable = 8;
    }

    public RecommendCastHolder(@NotNull z0 z00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(z00, "binding");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(z00, onViewHolderActionBaseListener0);
        this.binding = z00;
        this.setTitleView(z00.c);
    }

    private final d2 bindItem(CastList castEpsdDetailRes$Response$CastList0, int v) {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04A2, null, false);  // layout:listitem_radio_cast_horizontal
        int v1 = 0x7F0A065F;  // id:iv_play
        View view1 = I.C(view0, 0x7F0A065F);  // id:iv_play
        if(((ImageView)view1) != null && ((ImageView)I.C(view0, 0x7F0A0694)) != null) {  // id:iv_station_logo
            v1 = 0x7F0A069A;  // id:iv_thumb
            View view2 = I.C(view0, 0x7F0A069A);  // id:iv_thumb
            if(((MelonImageView)view2) != null && ((ImageView)I.C(view0, 0x7F0A069E)) != null) {  // id:iv_thumb_default
                v1 = 0x7F0A0C4A;  // id:tv_content_date
                View view3 = I.C(view0, 0x7F0A0C4A);  // id:tv_content_date
                if(((MelonTextView)view3) != null) {
                    v1 = 0x7F0A0C4C;  // id:tv_content_name
                    View view4 = I.C(view0, 0x7F0A0C4C);  // id:tv_content_name
                    if(((MelonTextView)view4) != null) {
                        v1 = 0x7F0A0C4E;  // id:tv_content_title
                        View view5 = I.C(view0, 0x7F0A0C4E);  // id:tv_content_title
                        if(((MelonTextView)view5) != null) {
                            d2 d20 = new d2(((ConstraintLayout)view0), ((ImageView)view1), ((MelonImageView)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((MelonTextView)view5));
                            Glide.with(((MelonImageView)view2).getContext()).load(castEpsdDetailRes$Response$CastList0.verticalImgUrl).into(((MelonImageView)view2));
                            ((MelonTextView)view5).setText(castEpsdDetailRes$Response$CastList0.progTitle);
                            ((MelonTextView)view4).setText(castEpsdDetailRes$Response$CastList0.castTitle);
                            ((MelonTextView)view3).setText(castEpsdDetailRes$Response$CastList0.castDate);
                            ViewUtils.setOnClickListener(((ImageView)view1), new y(this, castEpsdDetailRes$Response$CastList0, v, 0));
                            ViewUtils.setOnClickListener(((ConstraintLayout)view0), new y(this, castEpsdDetailRes$Response$CastList0, v, 1));
                            return d20;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }

    private static final void bindItem$lambda$4$lambda$2(RecommendCastHolder recommendCastHolder0, CastList castEpsdDetailRes$Response$CastList0, int v, View view0) {
        recommendCastHolder0.getOnViewHolderActionListener().onPlayRadioCast(castEpsdDetailRes$Response$CastList0.castSeq);
        recommendCastHolder0.stationPlayClickLog(castEpsdDetailRes$Response$CastList0, v);
    }

    private static final void bindItem$lambda$4$lambda$3(RecommendCastHolder recommendCastHolder0, CastList castEpsdDetailRes$Response$CastList0, int v, View view0) {
        recommendCastHolder0.getOnViewHolderActionListener().onOpenCastEpisodeDetailView(castEpsdDetailRes$Response$CastList0.castSeq);
        recommendCastHolder0.stationClickLog(castEpsdDetailRes$Response$CastList0, v);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        RecmStationInfo castEpsdDetailRes$Response$RecmStationInfo0 = (RecmStationInfo)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(castEpsdDetailRes$Response$RecmStationInfo0.title);
        }
        if(this.binding.b.getChildCount() <= 0) {
            ArrayList arrayList0 = castEpsdDetailRes$Response$RecmStationInfo0.castList;
            q.f(arrayList0, "castList");
            int v = 0;
            for(Object object0: p.K0(3, arrayList0)) {
                if(v >= 0) {
                    q.d(((CastList)object0));
                    d2 d20 = this.bindItem(((CastList)object0), v);
                    this.binding.b.addView(d20.a);
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

    private final void stationClickLog(CastList castEpsdDetailRes$Response$CastList0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F131008);  // string:tiara_station_layer1_recommended_station "추천스테이션"
            f0.c(v + 1);
            f0.E = castEpsdDetailRes$Response$CastList0.verticalImgUrl;
            f0.e = castEpsdDetailRes$Response$CastList0.castSeq;
            f0.f = "N10082";
            f0.g = castEpsdDetailRes$Response$CastList0.castTitle;
            f0.k = castEpsdDetailRes$Response$CastList0.progTitle;
            f0.l = castEpsdDetailRes$Response$CastList0.progSeq;
            f0.a().track();
        }
    }

    private final void stationPlayClickLog(CastList castEpsdDetailRes$Response$CastList0, int v) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getString(0x7F131008);  // string:tiara_station_layer1_recommended_station "추천스테이션"
            f0.c(v + 1);
            f0.E = castEpsdDetailRes$Response$CastList0.verticalImgUrl;
            f0.e = castEpsdDetailRes$Response$CastList0.castSeq;
            f0.f = "N10082";
            f0.g = castEpsdDetailRes$Response$CastList0.castTitle;
            f0.k = castEpsdDetailRes$Response$CastList0.progTitle;
            f0.l = castEpsdDetailRes$Response$CastList0.progSeq;
            f0.a().track();
        }
    }
}

