package com.iloen.melon.fragments.artistchannel.viewholder;

import J8.X;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.ComposeView;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.HIRISINGLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m0.b;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001A\u00020\u000F2\u0012\u0010\u000E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHiRisingHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$HIRISINGLIST;", "LJ8/X;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/X;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "LJ8/X;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistHiRisingHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHiRisingHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHiRisingHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistHiRisingHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0214, viewGroup0, false);  // layout:detail_item_artist_hi_rising
            if(view0 == null) {
                throw new NullPointerException("rootView");
            }
            return new ArtistHiRisingHolder(new X(((ComposeView)view0), ((ComposeView)view0)), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "ArtistHiRisingHolder";
    @NotNull
    private final X bind;

    static {
        ArtistHiRisingHolder.Companion = new Companion(null);
        ArtistHiRisingHolder.$stable = 8;
    }

    public ArtistHiRisingHolder(@NotNull X x0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(x0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(x0, onViewHolderActionBaseListener0);
        this.bind = x0;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    @NotNull
    public static final ArtistHiRisingHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistHiRisingHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        b b0 = new b(610304074, new e(1, adapterInViewHolder$Row0, this), true);
        this.bind.b.setContent(b0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final H onBindView$lambda$3(AdapterInViewHolder.Row adapterInViewHolder$Row0, ArtistHiRisingHolder artistHiRisingHolder0, l l0, int v) {
        if(((p)l0).Q(v & 1, (v & 3) != 2)) {
            Object object0 = adapterInViewHolder$Row0.getItem();
            q.f(object0, "getItem(...)");
            boolean z = ((p)l0).i(artistHiRisingHolder0);
            h h0 = ((p)l0).N();
            if(z || h0 == k.a) {
                h0 = new h(artistHiRisingHolder0, 0);
                ((p)l0).l0(h0);
            }
            ArtistHiRisingHolderKt.ArtistHiRisingSlot(((List)object0), h0, ((p)l0), 0);
            return H.a;
        }
        ((p)l0).T();
        return H.a;
    }

    private static final H onBindView$lambda$3$lambda$2$lambda$1(ArtistHiRisingHolder artistHiRisingHolder0, HIRISINGLIST artistHomeContentsRes$RESPONSE$HIRISINGLIST0, int v) {
        q.g(artistHomeContentsRes$RESPONSE$HIRISINGLIST0, "item");
        MelonLinkExecutor.open(MelonLinkInfo.b(artistHomeContentsRes$RESPONSE$HIRISINGLIST0.link));
        f f0 = artistHiRisingHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistHiRisingHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = artistHiRisingHolder0.getString(0x7F130CDB);  // string:tiara_artist_layer1_hi_rising "하이라이징"
            f0.c(v + 1);
            f0.e = artistHomeContentsRes$RESPONSE$HIRISINGLIST0.hiRisingSeq;
            f0.f = artistHiRisingHolder0.getString(0x7F130EF2);  // string:tiara_meta_type_artist_spotlight "아티스트 스포트라이트"
            f0.g = artistHomeContentsRes$RESPONSE$HIRISINGLIST0.title;
            f0.a().track();
        }
        return H.a;
    }
}

