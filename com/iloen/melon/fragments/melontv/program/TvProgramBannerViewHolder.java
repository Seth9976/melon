package com.iloen.melon.fragments.melontv.program;

import Ad.n;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.O0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v6x.response.TvProgramBannerRes.Response.Banner;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002*)B1\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u001F\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001A\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u001B\u0010\u001C\u001A\u00060\u001BR\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0017\u0010!\u001A\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$R\u0017\u0010%\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Landroid/view/View;", "itemView", "", "Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes$Response$Banner;", "list", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "listener", "<init>", "(Landroid/content/Context;Landroid/view/View;Ljava/util/List;Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;)V", "", "hasNotice", "Lie/H;", "setTopMargin", "(Z)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/util/List;", "getList", "()Ljava/util/List;", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "getListener", "()Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder$BannerPagerAdapter;", "pagerAdapter", "Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder$BannerPagerAdapter;", "getPagerAdapter", "()Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder$BannerPagerAdapter;", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "Companion", "BannerPagerAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TvProgramBannerViewHolder extends O0 {
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0011\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder$BannerPagerAdapter;", "Landroidx/viewpager/widget/a;", "<init>", "(Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder;)V", "", "getCount", "()I", "Landroid/view/View;", "view", "", "any", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "Landroid/view/ViewGroup;", "container", "position", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "Lie/H;", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class BannerPagerAdapter extends a {
        @Override  // androidx.viewpager.widget.a
        public void destroyItem(@NotNull ViewGroup viewGroup0, int v, @NotNull Object object0) {
            q.g(viewGroup0, "container");
            q.g(object0, "any");
            if(object0 instanceof View) {
                viewGroup0.removeView(((View)object0));
            }
        }

        @Override  // androidx.viewpager.widget.a
        public int getCount() {
            List list0 = TvProgramBannerViewHolder.this.getList();
            return list0 == null ? 0 : list0.size();
        }

        @Override  // androidx.viewpager.widget.a
        @NotNull
        public Object instantiateItem(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "container");
            Context context0 = TvProgramBannerViewHolder.this.getContext();
            if(context0 != null) {
                TvProgramBannerViewHolder tvProgramBannerViewHolder0 = TvProgramBannerViewHolder.this;
                View view0 = LayoutInflater.from(context0).inflate(0x7F0D08C1, viewGroup0, false);  // layout:tvprogram_home_banner_item_layout
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A00F1);  // id:banner_iv
                List list0 = tvProgramBannerViewHolder0.getList();
                if(list0 != null) {
                    Banner tvProgramBannerRes$Response$Banner0 = (Banner)list0.get(v);
                    if(tvProgramBannerRes$Response$Banner0 != null) {
                        Glide.with(context0).load(tvProgramBannerRes$Response$Banner0.imgUrl).into(imageView0);
                        CardView cardView0 = (CardView)view0.findViewById(0x7F0A0212);  // id:cardview
                        cardView0.setCardBackgroundColor(ColorUtils.getColorFromHexStr(tvProgramBannerRes$Response$Banner0.bgColor));
                        cardView0.setOnClickListener(new n(tvProgramBannerRes$Response$Banner0, tvProgramBannerViewHolder0, v, 12));
                        ViewUtils.setContentDescriptionWithClassName(view0, tvProgramBannerRes$Response$Banner0.imgAltText, "android.widget.Button", null);
                        viewGroup0.addView(view0);
                        return view0;
                    }
                }
            }
            Object object0 = this.instantiateItem(viewGroup0, v);
            q.f(object0, "instantiateItem(...)");
            return object0;
        }

        private static final void instantiateItem$lambda$1$lambda$0(Banner tvProgramBannerRes$Response$Banner0, TvProgramBannerViewHolder tvProgramBannerViewHolder0, int v, View view0) {
            MelonLinkExecutor.open(MelonLinkInfo.b(tvProgramBannerRes$Response$Banner0));
            tvProgramBannerViewHolder0.getListener().setBannerClickLog(tvProgramBannerRes$Response$Banner0, v + 1);
        }

        @Override  // androidx.viewpager.widget.a
        public boolean isViewFromObject(@NotNull View view0, @NotNull Object object0) {
            q.g(view0, "view");
            q.g(object0, "any");
            return view0.equals(object0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\u000E\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\u0006\u0010\r\u001A\u00020\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/melontv/program/TvProgramBannerViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "list", "", "Lcom/iloen/melon/net/v6x/response/TvProgramBannerRes$Response$Banner;", "onActionListener", "Lcom/iloen/melon/fragments/melontv/program/TvProgramHomeFragment$TvProgramItemClickListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TvProgramBannerViewHolder newInstance(@Nullable Context context0, @NotNull ViewGroup viewGroup0, @Nullable List list0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
            q.g(viewGroup0, "parent");
            q.g(tvProgramHomeFragment$TvProgramItemClickListener0, "onActionListener");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D08C0, viewGroup0, false);  // layout:tvprogram_banner_list_layout
            q.d(view0);
            return new TvProgramBannerViewHolder(context0, view0, list0, tvProgramHomeFragment$TvProgramItemClickListener0);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Context context;
    @Nullable
    private final List list;
    @NotNull
    private final TvProgramItemClickListener listener;
    @NotNull
    private final BannerPagerAdapter pagerAdapter;
    @NotNull
    private final View parent;
    @NotNull
    private final ViewPager viewPager;

    static {
        TvProgramBannerViewHolder.Companion = new Companion(null);
        TvProgramBannerViewHolder.$stable = 8;
    }

    public TvProgramBannerViewHolder(@Nullable Context context0, @NotNull View view0, @Nullable List list0, @NotNull TvProgramItemClickListener tvProgramHomeFragment$TvProgramItemClickListener0) {
        q.g(view0, "itemView");
        q.g(tvProgramHomeFragment$TvProgramItemClickListener0, "listener");
        super(view0);
        this.context = context0;
        this.list = list0;
        this.listener = tvProgramHomeFragment$TvProgramItemClickListener0;
        BannerPagerAdapter tvProgramBannerViewHolder$BannerPagerAdapter0 = new BannerPagerAdapter(this);
        this.pagerAdapter = tvProgramBannerViewHolder$BannerPagerAdapter0;
        View view1 = view0.findViewById(0x7F0A0DD6);  // id:viewpager
        q.f(view1, "findViewById(...)");
        this.viewPager = (ViewPager)view1;
        View view2 = view0.findViewById(0x7F0A0900);  // id:parent
        q.f(view2, "findViewById(...)");
        this.parent = view2;
        ((ViewPager)view1).setAdapter(tvProgramBannerViewHolder$BannerPagerAdapter0);
        ((ViewPager)view1).setClipToPadding(false);
        if(context0 != null) {
            int v = (int)context0.getResources().getDimension(0x7F070473);  // dimen:tvprogram_bannner_padding
            ((ViewPager)view1).setPadding(v, 0, v, 0);
            ((ViewPager)view1).setPageMargin(((int)context0.getResources().getDimension(0x7F070472)));  // dimen:tvprogram_banner_page_margin
        }
        tvProgramBannerViewHolder$BannerPagerAdapter0.notifyDataSetChanged();
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final List getList() {
        return this.list;
    }

    @NotNull
    public final TvProgramItemClickListener getListener() {
        return this.listener;
    }

    @NotNull
    public final BannerPagerAdapter getPagerAdapter() {
        return this.pagerAdapter;
    }

    @NotNull
    public final View getParent() {
        return this.parent;
    }

    @NotNull
    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    public final void setTopMargin(boolean z) {
        int v = z ? 0 : ScreenUtils.dipToPixel(this.context, 6.0f);
        View view0 = this.parent;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = v;
        }
        view0.setLayoutParams(viewGroup$LayoutParams0);
    }
}

