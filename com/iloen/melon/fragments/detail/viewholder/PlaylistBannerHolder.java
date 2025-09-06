package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.P1;
import J8.d0;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.viewholder.c;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.BANNERLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import he.e;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u001B2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001BB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001A\u00020\u00132\u0012\u0010\u0012\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistBannerHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$BANNERLIST;", "LJ8/d0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/d0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "LJ8/P1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$BANNERLIST;)LJ8/P1;", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "clickLog", "itemClickLog", "(Ljava/lang/String;)V", "holderBind", "LJ8/d0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PlaylistBannerHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistBannerHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistBannerHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistBannerHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D021C, viewGroup0, false);  // layout:detail_item_playlist_banner
            LinearLayout linearLayout0 = (LinearLayout)I.C(view0, 0x7F0A00EE);  // id:banner_container
            if(linearLayout0 == null) {
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A00EE));  // id:banner_container
            }
            return new PlaylistBannerHolder(new d0(((LinearLayout)view0), linearLayout0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistBannerHolder";
    @NotNull
    private d0 holderBind;

    static {
        PlaylistBannerHolder.Companion = new Companion(null);
        PlaylistBannerHolder.$stable = 8;
    }

    public PlaylistBannerHolder(@NotNull d0 d00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(d00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(d00, onViewHolderActionBaseListener0);
        this.holderBind = d00;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(PlaylistBannerHolder playlistBannerHolder0, boolean z, BANNERLIST detailBaseRes$BANNERLIST0, View view0) {
        PlaylistBannerHolder.bindItem$lambda$4$lambda$2(playlistBannerHolder0, z, detailBaseRes$BANNERLIST0, view0);
    }

    private final P1 bindItem(BANNERLIST detailBaseRes$BANNERLIST0) {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0480, null, false);  // layout:listitem_detail_playlist_banner
        int v = 0x7F0A00EE;  // id:banner_container
        View view1 = I.C(view0, 0x7F0A00EE);  // id:banner_container
        if(((RelativeLayout)view1) != null) {
            v = 0x7F0A00EF;  // id:banner_cover
            View view2 = I.C(view0, 0x7F0A00EF);  // id:banner_cover
            if(view2 != null) {
                v = 0x7F0A00F1;  // id:banner_iv
                View view3 = I.C(view0, 0x7F0A00F1);  // id:banner_iv
                if(((ImageView)view3) != null) {
                    v = 0x7F0A0702;  // id:layout_bg
                    ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A0702);  // id:layout_bg
                    if(imageView0 != null) {
                        v = 0x7F0A0921;  // id:play_time
                        View view4 = I.C(view0, 0x7F0A0921);  // id:play_time
                        if(((MelonTextView)view4) != null) {
                            P1 p10 = new P1(((ConstraintLayout)view0), ((RelativeLayout)view1), view2, ((ImageView)view3), imageView0, ((MelonTextView)view4));
                            boolean z = TextUtils.equals("N10003", detailBaseRes$BANNERLIST0.contstypecode) || TextUtils.equals("N10076", detailBaseRes$BANNERLIST0.contstypecode) || TextUtils.equals("N10077", detailBaseRes$BANNERLIST0.contstypecode);
                            ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((RelativeLayout)view1).getLayoutParams();
                            q.f(viewGroup$LayoutParams0, "getLayoutParams(...)");
                            if(z) {
                                ViewUtils.showWhen(view2, true);
                                ViewUtils.showWhen(((MelonTextView)view4), true);
                                ((MelonTextView)view4).setText(detailBaseRes$BANNERLIST0.playTime);
                            }
                            else {
                                ViewUtils.hideWhen(view2, true);
                                ViewUtils.hideWhen(((MelonTextView)view4), true);
                            }
                            view2.setLayoutParams(viewGroup$LayoutParams0);
                            ViewUtils.setOnClickListener(((RelativeLayout)view1), new c(this, z, detailBaseRes$BANNERLIST0, 2));
                            imageView0.setVisibility(8);
                            if(!TextUtils.isEmpty(detailBaseRes$BANNERLIST0.bgcolor)) {
                                try {
                                    int[] arr_v = {ColorUtils.getColorFromHexStr(detailBaseRes$BANNERLIST0.bgcolor)};
                                    imageView0.setImageTintList(new ColorStateList(new int[][]{new int[0]}, arr_v));
                                    imageView0.setVisibility(0);
                                }
                                catch(Exception unused_ex) {
                                    LogU.Companion.w("PlaylistBannerHolder", "bindItem() BG error");
                                }
                            }
                            Context context0 = this.getContext();
                            if(context0 != null) {
                                RequestOptions requestOptions0 = RequestOptions.bitmapTransform(new MultiTransformation(new Transformation[]{new CenterCrop(), new e(ScreenUtils.dipToPixel(this.getContext(), 4.0f), RoundedCornersTransformation.CornerType.ALL)}));
                                q.f(requestOptions0, "bitmapTransform(...)");
                                Glide.with(context0).asBitmap().load(detailBaseRes$BANNERLIST0.imgurl).apply(requestOptions0).into(p10.c);
                            }
                            return p10;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    private static final void bindItem$lambda$4$lambda$2(PlaylistBannerHolder playlistBannerHolder0, boolean z, BANNERLIST detailBaseRes$BANNERLIST0, View view0) {
        f f0 = playlistBannerHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 == null) {
            f0 = null;
        }
        else {
            f0.a = playlistBannerHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.b = playlistBannerHolder0.getString(0x7F130F97);  // string:tiara_partnerplaylist_section "파트너DJ페이지"
            f0.c = playlistBannerHolder0.getString(0x7F130F96);  // string:tiara_partnerplaylist_page "파트너DJ페이지_홈"
            f0.y = playlistBannerHolder0.getString(0x7F130D06);  // string:tiara_click_copy_banner "배너"
            f0.F = playlistBannerHolder0.getString(0x7F130D06);  // string:tiara_click_copy_banner "배너"
        }
        if(z) {
            if(TextUtils.equals("N10003", detailBaseRes$BANNERLIST0.contstypecode)) {
                Navigator.openMvInfo$default(detailBaseRes$BANNERLIST0.contsid, playlistBannerHolder0.getMenuId(), null, false, 12, null);
            }
            else {
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                melonLinkInfo0.a = detailBaseRes$BANNERLIST0.linktype;
                melonLinkInfo0.b = detailBaseRes$BANNERLIST0.linkurl;
                MelonLinkExecutor.open(melonLinkInfo0);
            }
            if(f0 != null) {
                f0.e = detailBaseRes$BANNERLIST0.contsid;
            }
            if(f0 != null) {
                f0.f = playlistBannerHolder0.getString(0x7F130F04);  // string:tiara_meta_type_video "뮤직비디오"
            }
            if(f0 != null) {
                f0.g = detailBaseRes$BANNERLIST0.title;
            }
        }
        else {
            MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
            melonLinkInfo1.a = detailBaseRes$BANNERLIST0.linktype;
            melonLinkInfo1.b = detailBaseRes$BANNERLIST0.linkurl;
            MelonLinkExecutor.open(melonLinkInfo1);
            if(f0 != null) {
                f0.m = detailBaseRes$BANNERLIST0.imgurl;
            }
        }
        if(f0 != null) {
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() [...] // Inlined contents

    public void itemClickLog(@NotNull String s) {
        q.g(s, "clickLog");
    }

    @NotNull
    public static final PlaylistBannerHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return PlaylistBannerHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle("");
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        if(this.holderBind.b.getChildCount() <= 0 && list0 != null) {
            for(Object object0: list0) {
                P1 p10 = this.bindItem(((BANNERLIST)object0));
                this.holderBind.b.addView(p10.a);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

