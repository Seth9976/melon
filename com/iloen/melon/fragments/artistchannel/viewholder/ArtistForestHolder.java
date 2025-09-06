package com.iloen.melon.fragments.artistchannel.viewholder;

import Ad.s;
import De.I;
import J8.j;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.FORESTARTISTINFO;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u00162\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u000F\u001A\u00020\u000E2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistForestHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO;", "LJ8/j;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/j;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "clickLog", "itemClickLog", "(Ljava/lang/String;)V", "holderBind", "LJ8/j;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistForestHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistForestHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistForestHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistForestHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0038, viewGroup0, false);  // layout:artist_detail_forest
            int v = 0x7F0A009B;  // id:amount_tv
            View view1 = I.C(view0, 0x7F0A009B);  // id:amount_tv
            if(((MelonTextView)view1) != null) {
                v = 0x7F0A01E8;  // id:button_tv
                View view2 = I.C(view0, 0x7F0A01E8);  // id:button_tv
                if(((MelonTextView)view2) != null) {
                    v = 0x7F0A034C;  // id:count_tv
                    View view3 = I.C(view0, 0x7F0A034C);  // id:count_tv
                    if(((MelonTextView)view3) != null) {
                        v = 0x7F0A04D9;  // id:forest_iv
                        View view4 = I.C(view0, 0x7F0A04D9);  // id:forest_iv
                        if(((MelonImageView)view4) != null) {
                            v = 0x7F0A0772;  // id:line_view
                            View view5 = I.C(view0, 0x7F0A0772);  // id:line_view
                            if(view5 != null) {
                                v = 0x7F0A07CA;  // id:main_contents_title
                                View view6 = I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                                if(((MainTabTitleView)view6) != null) {
                                    v = 0x7F0A09B6;  // id:rate_tv
                                    View view7 = I.C(view0, 0x7F0A09B6);  // id:rate_tv
                                    if(((MelonTextView)view7) != null) {
                                        return new ArtistForestHolder(new j(((LinearLayout)view0), ((MelonTextView)view1), ((MelonTextView)view2), ((MelonTextView)view3), ((MelonImageView)view4), view5, ((MainTabTitleView)view6), ((MelonTextView)view7)), onViewHolderActionBaseListener0);
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
    private static final String TAG = "ArtistForestHolder";
    @NotNull
    private j holderBind;

    static {
        ArtistForestHolder.Companion = new Companion(null);
        ArtistForestHolder.$stable = 8;
    }

    public ArtistForestHolder(@NotNull j j0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(j0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(j0, onViewHolderActionBaseListener0);
        this.holderBind = j0;
        this.setTitleView(j0.g);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130141);  // string:artist_forest_streaming "숲트리밍"
    }

    public void itemClickLog(@NotNull String s) {
        q.g(s, "clickLog");
    }

    @NotNull
    public static final ArtistForestHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistForestHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        FORESTARTISTINFO artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0 = (FORESTARTISTINFO)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
            mainTabTitleView0.setTitleClickable(true);
            mainTabTitleView0.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    MelonLinkExecutor.open(MelonLinkInfo.b(this.link));
                    f f0 = ArtistForestHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistForestHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.d = ActionKind.ClickContent;
                        f0.y = ArtistForestHolder.this.getString(0x7F130DE2);  // string:tiara_common_layer1_artist_forest "숲트리밍"
                        f0.F = ArtistForestHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
        j j0 = this.holderBind;
        MelonTextView melonTextView0 = j0.c;
        String s = this.getString(0x7F130897);  // string:price "%1$s원"
        l1.D(new Object[]{artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.participationAmount}, 1, s, j0.b);
        String s1 = this.getString(0x7F1307DF);  // string:percent "%1$s%%"
        l1.D(new Object[]{artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.achievementRate}, 1, s1, j0.h);
        int v = 0x7F1304BD;  // string:joining "참여중"
        String s2 = String.format(o.o("%s", this.getString(0x7F130807), " ", this.getString(0x7F1304BD)), Arrays.copyOf(new Object[]{artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.enrollCount}, 1));  // string:person "명"
        j0.d.setText(s2);
        Context context0 = this.getContext();
        if(context0 != null) {
            Glide.with(context0).load(artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.forestImagePath).into(j0.e);
        }
        if(!artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.isEnroll) {
            v = 0x7F1304BC;  // string:join "참여하기"
        }
        melonTextView0.setText(this.getString(v));
        melonTextView0.setOnClickListener(new s(18, artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0, this));
        ViewUtils.setContentDescriptionWithButtonClassName(melonTextView0, melonTextView0.getText());
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$4$lambda$3(FORESTARTISTINFO artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0, ArtistForestHolder artistForestHolder0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(artistHomeBasicInfoRes$RESPONSE$FORESTARTISTINFO0.link));
        f f0 = artistForestHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistForestHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistForestHolder0.getString(0x7F130DE2);  // string:tiara_common_layer1_artist_forest "숲트리밍"
            f0.F = artistForestHolder0.getString(0x7F131027);  // string:tiara_temperature_copy_join "참여하기"
            f0.a().track();
        }
    }
}

