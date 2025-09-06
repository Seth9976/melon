package com.iloen.melon.fragments.artistchannel.viewholder;

import De.I;
import J8.g;
import Tf.o;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.a;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE.Banner;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.ArrayList;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00132\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u000F\u001A\u00020\u000E2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistBannerHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes$RESPONSE;", "LJ8/g;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/g;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "holderBind", "LJ8/g;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistBannerHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistBannerHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistBannerHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistBannerHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0035, viewGroup0, false);  // layout:artist_detail_banner
            MelonImageView melonImageView0 = (MelonImageView)I.C(view0, 0x7F0A00F1);  // id:banner_iv
            if(melonImageView0 == null) {
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A00F1));  // id:banner_iv
            }
            return new ArtistBannerHolder(new g(((LinearLayout)view0), melonImageView0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistBannerHolder";
    @NotNull
    private g holderBind;

    static {
        ArtistBannerHolder.Companion = new Companion(null);
        ArtistBannerHolder.$stable = 8;
    }

    public ArtistBannerHolder(@NotNull g g0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(g0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(g0, onViewHolderActionBaseListener0);
        this.holderBind = g0;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(Banner promotionContentsBannerRes$RESPONSE$Banner0, MelonLinkInfo melonLinkInfo0, AdapterInViewHolder.Row adapterInViewHolder$Row0, ArtistBannerHolder artistBannerHolder0, View view0) {
        ArtistBannerHolder.onBindView$lambda$3(promotionContentsBannerRes$RESPONSE$Banner0, melonLinkInfo0, adapterInViewHolder$Row0, artistBannerHolder0, view0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    @NotNull
    public static final ArtistBannerHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistBannerHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        ArrayList arrayList0 = ((RESPONSE)adapterInViewHolder$Row0.getItem()).banners;
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            Object object0 = arrayList0.get(0);
            int v = ColorUtils.getColorFromHexStr(this.getContext(), ((Banner)object0).bgColor, 0x7F06002C);  // color:bg_banner
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.a = ((Banner)object0).linktype;
            melonLinkInfo0.b = ((Banner)object0).linkurl;
            melonLinkInfo0.c = ((Banner)object0).scheme;
            MelonImageView melonImageView0 = this.holderBind.b;
            melonImageView0.setVisibility(0);
            Context context0 = this.getContext();
            if(context0 != null) {
                Glide.with(context0).load(((Banner)object0).imgUrl).apply(RequestOptions.noAnimation()).into(melonImageView0);
            }
            melonImageView0.getBackground().setTint(v);
            melonImageView0.setOnClickListener(new a(((Banner)object0), melonLinkInfo0, adapterInViewHolder$Row0, this, 1));
            String s = ((Banner)object0).imgAltText;
            ViewUtils.setContentDescriptionWithButtonClassName(melonImageView0, (s == null || !o.H0(s) != 1 ? this.getString(0x7F130B21) : ((Banner)object0).imgAltText));  // string:talkback_event_banner "이벤트 배너"
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$3(Banner promotionContentsBannerRes$RESPONSE$Banner0, MelonLinkInfo melonLinkInfo0, AdapterInViewHolder.Row adapterInViewHolder$Row0, ArtistBannerHolder artistBannerHolder0, View view0) {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        Y.w("onBindView() Go shopping >> marketscheme: ", promotionContentsBannerRes$RESPONSE$Banner0.scheme, logU$Companion0, "ArtistBannerHolder");
        logU$Companion0.d("ArtistBannerHolder", "onBindView() Go shopping >> [linkType: " + promotionContentsBannerRes$RESPONSE$Banner0.linktype + "] >> linkUrl: " + promotionContentsBannerRes$RESPONSE$Banner0.linkurl);
        MelonLinkExecutor.open(melonLinkInfo0);
        if(adapterInViewHolder$Row0.getMenuId() != null) {
            Y.w("onBindView() mBasicInfoRes.menuId : ", adapterInViewHolder$Row0.getMenuId(), logU$Companion0, "ArtistBannerHolder");
            String s = null;
            String s1 = promotionContentsBannerRes$RESPONSE$Banner0.bannerSeq == null || promotionContentsBannerRes$RESPONSE$Banner0.bannerSeq.length() == 0 ? null : promotionContentsBannerRes$RESPONSE$Banner0.bannerSeq;
            String s2 = promotionContentsBannerRes$RESPONSE$Banner0.contsTypeCode == null || promotionContentsBannerRes$RESPONSE$Banner0.contsTypeCode.length() == 0 ? null : promotionContentsBannerRes$RESPONSE$Banner0.contsTypeCode;
            if(promotionContentsBannerRes$RESPONSE$Banner0.contsId != null && promotionContentsBannerRes$RESPONSE$Banner0.contsId.length() != 0) {
                s = promotionContentsBannerRes$RESPONSE$Banner0.contsId;
            }
            d3.g.Z("3", adapterInViewHolder$Row0.getMenuId(), "Z11", s1, s2, s);
        }
        f f0 = artistBannerHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistBannerHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistBannerHolder0.getString(0x7F130CD8);  // string:tiara_artist_layer1_artist_info "아티스트 정보"
            f0.e = promotionContentsBannerRes$RESPONSE$Banner0.bannerSeq;
            f0.f = Y.i(ContsTypeCode.EVENT, "code(...)");
            f0.g = promotionContentsBannerRes$RESPONSE$Banner0.adminTitle;
            f0.a().track();
        }
    }
}

