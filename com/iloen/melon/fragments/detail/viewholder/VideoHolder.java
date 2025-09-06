package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import Cb.k;
import J8.Z1;
import J8.k0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.VIDEO;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 \u001E2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001EB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001A\u00020\u00152\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001A\u00020\u00152\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$VIDEO;", "LJ8/k0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/k0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "index", "LJ8/Z1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$VIDEO;I)LJ8/Z1;", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "itemClickLog", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$VIDEO;I)V", "holderBind", "LJ8/k0;", "total", "I", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class VideoHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new VideoHolder(k0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "VideoHolder";
    @NotNull
    private k0 holderBind;
    private int total;

    static {
        VideoHolder.Companion = new Companion(null);
        VideoHolder.$stable = 8;
    }

    public VideoHolder(@NotNull k0 k00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(k00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(k00, onViewHolderActionBaseListener0);
        this.holderBind = k00;
        this.setTitleView(k00.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final Z1 bindItem(VIDEO detailBaseRes$VIDEO0, int v) {
        String s = null;
        Z1 z10 = Z1.a(LayoutInflater.from(this.getContext()), null);
        FrameLayout frameLayout0 = z10.a;
        Glide.with(z10.c.c).load((detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.mv169Img)).into(z10.c.c);
        z10.g.setText((detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.mvName));
        String s1 = detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.getArtistNames();
        z10.b.setText(s1);
        MelonTextView melonTextView0 = z10.f;
        String s2 = detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.playTime;
        if(s2 == null) {
            s2 = "";
        }
        melonTextView0.setText(k.f(s2));
        ImageView imageView0 = z10.e;
        int v1 = ResourceUtils.getMvAdultGradeIcon((detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.adultGrade));
        if(v1 == -1) {
            imageView0.setVisibility(8);
        }
        else {
            imageView0.setVisibility(0);
            imageView0.setImageResource(v1);
        }
        frameLayout0.setOnClickListener(new l(detailBaseRes$VIDEO0, this, v, 6));
        String s3 = k.e((detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.playTime));
        String s4 = detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.mvName;
        String s5 = this.getString(0x7F130AD2);  // string:talkback_artist "아티스트"
        if(detailBaseRes$VIDEO0 != null) {
            s = detailBaseRes$VIDEO0.getArtistNames();
        }
        String s6 = this.getString(0x7F130B19);  // string:talkback_do_play "재생하기"
        ViewUtils.setContentDescriptionWithButtonClassName(frameLayout0, d.n(a.o(s4, ", ", s5, ": ", s), ", ", s3, ", ", s6), String.format(this.getString(0x7F130BA8), Arrays.copyOf(new Object[]{this.total, ((int)(v + 1))}, 2)));  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
        return z10;
    }

    private static final void bindItem$lambda$3(VIDEO detailBaseRes$VIDEO0, VideoHolder videoHolder0, int v, View view0) {
        Navigator.openMvInfo$default((detailBaseRes$VIDEO0 == null ? null : detailBaseRes$VIDEO0.mvId), videoHolder0.getMenuId(), null, false, 12, null);
        videoHolder0.itemClickLog(detailBaseRes$VIDEO0, v);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1302FD);  // string:detail_common_title_video "비디오"
    }

    public void itemClickLog(@Nullable VIDEO detailBaseRes$VIDEO0, int v) {
    }

    @NotNull
    public static final VideoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return VideoHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
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
        MainTabTitleView mainTabTitleView2 = this.getTitleView();
        if(mainTabTitleView2 != null) {
            mainTabTitleView2.setTitle(this.getString(0x7F1302FD));  // string:detail_common_title_video "비디오"
        }
        if(this.holderBind.b.getChildCount() <= 0) {
            int v = 0;
            for(Object object0: list0) {
                if(v >= 0) {
                    Z1 z10 = this.bindItem(((VIDEO)object0), v);
                    this.holderBind.b.addView(z10.a);
                    ++v;
                    continue;
                }
                e.k.O();
                throw null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

