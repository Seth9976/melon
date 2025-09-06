package com.iloen.melon.fragments.detail.viewholder;

import J8.M1;
import J8.b0;
import U4.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.MAGAZINE;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.ui.ViewUtils;
import e.k;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 \u001E2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001EB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001A\u00020\u00152\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001A\u00020\u00152\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;", "LJ8/b0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/b0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "index", "LJ8/M1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;I)LJ8/M1;", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "itemClickLog", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;I)V", "holderBind", "LJ8/b0;", "total", "I", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MagazineHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MagazineHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new MagazineHolder(b0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MagazineHolder";
    @NotNull
    private b0 holderBind;
    private int total;

    static {
        MagazineHolder.Companion = new Companion(null);
        MagazineHolder.$stable = 8;
    }

    public MagazineHolder(@NotNull b0 b00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(b00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(b00, onViewHolderActionBaseListener0);
        this.holderBind = b00;
        this.setTitleView(b00.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final M1 bindItem(MAGAZINE detailBaseRes$MAGAZINE0, int v) {
        String s = null;
        M1 m10 = M1.a(LayoutInflater.from(this.getContext()), null);
        FrameLayout frameLayout0 = m10.a;
        Glide.with(m10.c.b).load((detailBaseRes$MAGAZINE0 == null ? null : detailBaseRes$MAGAZINE0.contsImg)).into(m10.c.b);
        m10.e.setText((detailBaseRes$MAGAZINE0 == null ? null : detailBaseRes$MAGAZINE0.contsName));
        String s1 = detailBaseRes$MAGAZINE0 == null || (detailBaseRes$MAGAZINE0.cateName == null || detailBaseRes$MAGAZINE0.cateName.length() <= 0) ? ProtocolUtils.getArtistNames((detailBaseRes$MAGAZINE0 == null ? null : detailBaseRes$MAGAZINE0.artistList)) : detailBaseRes$MAGAZINE0.cateName;
        m10.b.setText(s1);
        frameLayout0.setOnClickListener(new l(detailBaseRes$MAGAZINE0, this, v));
        if(detailBaseRes$MAGAZINE0 != null) {
            s = detailBaseRes$MAGAZINE0.contsName;
        }
        ViewUtils.setContentDescriptionWithButtonClassName(frameLayout0, x.l(s, " ", this.getString(0x7F130C3C), " ", s1), String.format(this.getString(0x7F130BA8), Arrays.copyOf(new Object[]{this.total, ((int)(v + 1))}, 2)));  // string:talkback_section_name "코너명"
        return m10;
    }

    private static final void bindItem$lambda$2(MAGAZINE detailBaseRes$MAGAZINE0, MagazineHolder magazineHolder0, int v, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b((detailBaseRes$MAGAZINE0 == null ? null : detailBaseRes$MAGAZINE0.link)));
        magazineHolder0.itemClickLog(detailBaseRes$MAGAZINE0, v);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1302F8);  // string:detail_common_title_magazine "매거진"
    }

    public void itemClickLog(@Nullable MAGAZINE detailBaseRes$MAGAZINE0, int v) {
    }

    @NotNull
    public static final MagazineHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return MagazineHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
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
                    M1 m10 = this.bindItem(((MAGAZINE)object0), v);
                    this.holderBind.b.addView(m10.a);
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

