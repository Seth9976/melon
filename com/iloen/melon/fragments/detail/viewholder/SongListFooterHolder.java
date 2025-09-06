package com.iloen.melon.fragments.detail.viewholder;

import Ad.s;
import J8.w0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PAGE;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListFooterHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PAGE;", "LJ8/w0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/w0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/w0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongListFooterHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListFooterHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongListFooterHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongListFooterHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new SongListFooterHolder(w0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SongListFooterHolder";
    @NotNull
    private w0 holderBind;

    static {
        SongListFooterHolder.Companion = new Companion(null);
        SongListFooterHolder.$stable = 8;
    }

    public SongListFooterHolder(@NotNull w0 w00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(w00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(w00, onViewHolderActionBaseListener0);
        this.holderBind = w00;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(SongListFooterHolder songListFooterHolder0, View view0) {
        SongListFooterHolder.onBindView$lambda$1(songListFooterHolder0, view0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    @NotNull
    public static final SongListFooterHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongListFooterHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        PAGE detailBaseRes$PAGE0 = (PAGE)adapterInViewHolder$Row0.getItem();
        if(detailBaseRes$PAGE0.isEnd) {
            this.holderBind.b.setVisibility(8);
            this.holderBind.c.setVisibility(0);
        }
        ViewUtilsKt.setAccessibilityButtonClassName(this.holderBind.b);
        this.holderBind.b.setOnClickListener(new s(23, this, detailBaseRes$PAGE0));
        ViewUtilsKt.setAccessibilityButtonClassName(this.holderBind.c);
        this.holderBind.c.setOnClickListener(new p(this, 1));
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$0(SongListFooterHolder songListFooterHolder0, PAGE detailBaseRes$PAGE0, View view0) {
        if(songListFooterHolder0.getOnViewHolderActionListener().onSongListMore()) {
            detailBaseRes$PAGE0.isEnd = true;
            songListFooterHolder0.holderBind.b.setVisibility(8);
            songListFooterHolder0.holderBind.c.setVisibility(0);
            songListFooterHolder0.getOnViewHolderActionListener().onSongListFooterRemoveCheck();
        }
    }

    private static final void onBindView$lambda$1(SongListFooterHolder songListFooterHolder0, View view0) {
        songListFooterHolder0.getOnViewHolderActionListener().onSongListViewAll();
    }
}

