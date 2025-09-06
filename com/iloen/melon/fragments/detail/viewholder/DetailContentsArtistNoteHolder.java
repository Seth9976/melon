package com.iloen.melon.fragments.detail.viewholder;

import J8.x1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ARTISTNOTE;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000FR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/x1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder$ArtistNoteActionListener;", "actionListener", "<init>", "(LJ8/x1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder$ArtistNoteActionListener;)V", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ARTISTNOTE;", "item", "", "position", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ARTISTNOTE;I)V", "LJ8/x1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder$ArtistNoteActionListener;", "Companion", "ArtistNoteActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsArtistNoteHolder extends O0 {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder$ArtistNoteActionListener;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ARTISTNOTE;", "item", "", "position", "Lie/H;", "onPlayItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ARTISTNOTE;I)V", "onClickItem", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface ArtistNoteActionListener {
        void onClickItem(@NotNull ARTISTNOTE arg1, int arg2);

        void onPlayItem(@NotNull ARTISTNOTE arg1, int arg2);
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsArtistNoteHolder$ArtistNoteActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsArtistNoteHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull ArtistNoteActionListener detailContentsArtistNoteHolder$ArtistNoteActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsArtistNoteHolder$ArtistNoteActionListener0, "actionListener");
            return new DetailContentsArtistNoteHolder(x1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), detailContentsArtistNoteHolder$ArtistNoteActionListener0, null);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final ArtistNoteActionListener actionListener;
    @NotNull
    private final x1 binding;

    static {
        DetailContentsArtistNoteHolder.Companion = new Companion(null);
        DetailContentsArtistNoteHolder.$stable = 8;
    }

    private DetailContentsArtistNoteHolder(x1 x10, ArtistNoteActionListener detailContentsArtistNoteHolder$ArtistNoteActionListener0) {
        super(x10.a);
        this.binding = x10;
        this.actionListener = detailContentsArtistNoteHolder$ArtistNoteActionListener0;
        Context context0 = this.itemView.getContext();
        int v = context0.getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
        int v1 = ScreenUtils.dipToPixel(context0, 11.0f);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = x10.d.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            viewGroup$MarginLayoutParams0.setMargins(v, viewGroup$MarginLayoutParams0.topMargin, v, v1);
        }
    }

    public DetailContentsArtistNoteHolder(x1 x10, ArtistNoteActionListener detailContentsArtistNoteHolder$ArtistNoteActionListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(x10, detailContentsArtistNoteHolder$ArtistNoteActionListener0);
    }

    public final void bind(@NotNull ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v) {
        q.g(detailBaseRes$ARTISTNOTE0, "item");
        Glide.with(this.binding.c.b).load(detailBaseRes$ARTISTNOTE0.albumImg).into(this.binding.c.b);
        this.binding.f.setText(detailBaseRes$ARTISTNOTE0.albumName);
        this.binding.b.setText(detailBaseRes$ARTISTNOTE0.artistNote);
        i i0 = new i(this, detailBaseRes$ARTISTNOTE0, v, 0);
        this.binding.c.a.setOnClickListener(i0);
        i i1 = new i(this, detailBaseRes$ARTISTNOTE0, v, 1);
        this.binding.f.setOnClickListener(i1);
        i i2 = new i(this, detailBaseRes$ARTISTNOTE0, v, 2);
        this.binding.b.setOnClickListener(i2);
        i i3 = new i(this, detailBaseRes$ARTISTNOTE0, v, 3);
        this.binding.e.setOnClickListener(i3);
    }

    private static final void bind$lambda$2(DetailContentsArtistNoteHolder detailContentsArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        detailContentsArtistNoteHolder0.actionListener.onClickItem(detailBaseRes$ARTISTNOTE0, v);
    }

    private static final void bind$lambda$3(DetailContentsArtistNoteHolder detailContentsArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        detailContentsArtistNoteHolder0.actionListener.onClickItem(detailBaseRes$ARTISTNOTE0, v);
    }

    private static final void bind$lambda$4(DetailContentsArtistNoteHolder detailContentsArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        detailContentsArtistNoteHolder0.actionListener.onClickItem(detailBaseRes$ARTISTNOTE0, v);
    }

    private static final void bind$lambda$5(DetailContentsArtistNoteHolder detailContentsArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, View view0) {
        detailContentsArtistNoteHolder0.actionListener.onPlayItem(detailBaseRes$ARTISTNOTE0, v);
    }
}

