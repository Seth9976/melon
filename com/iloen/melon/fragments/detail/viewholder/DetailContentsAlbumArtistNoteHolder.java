package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.F1;
import J8.e3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ALBUMARTISTNOTE;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u000F\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/F1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder$ArtistNoteActionListener;", "actionListener", "<init>", "(LJ8/F1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder$ArtistNoteActionListener;)V", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ALBUMARTISTNOTE;", "item", "", "position", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$ALBUMARTISTNOTE;I)V", "size", "setTotal", "(I)V", "LJ8/F1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder$ArtistNoteActionListener;", "I", "Companion", "ArtistNoteActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsAlbumArtistNoteHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder$ArtistNoteActionListener;", "", "", "albumId", "Lie/H;", "onItemClick", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface ArtistNoteActionListener {
        void onItemClick(@Nullable String arg1);
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumArtistNoteHolder$ArtistNoteActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsAlbumArtistNoteHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull ArtistNoteActionListener detailContentsAlbumArtistNoteHolder$ArtistNoteActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsAlbumArtistNoteHolder$ArtistNoteActionListener0, "actionListener");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0476, viewGroup0, false);  // layout:listitem_detail_album_artistnote
            int v = 0x7F0A05B7;  // id:item_layout
            View view1 = I.C(view0, 0x7F0A05B7);  // id:item_layout
            if(((ConstraintLayout)view1) != null) {
                v = 0x7F0A0B79;  // id:thumb_layout
                View view2 = I.C(view0, 0x7F0A0B79);  // id:thumb_layout
                if(view2 != null) {
                    e3 e30 = e3.a(view2);
                    v = 0x7F0A0C12;  // id:tv_artist
                    View view3 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                    if(((MelonTextView)view3) != null) {
                        v = 0x7F0A0C93;  // id:tv_issue_date
                        View view4 = I.C(view0, 0x7F0A0C93);  // id:tv_issue_date
                        if(((MelonTextView)view4) != null) {
                            v = 0x7F0A0CCF;  // id:tv_note
                            View view5 = I.C(view0, 0x7F0A0CCF);  // id:tv_note
                            if(((MelonTextView)view5) != null) {
                                return new DetailContentsAlbumArtistNoteHolder(new F1(((RelativeLayout)view0), ((ConstraintLayout)view1), e30, ((MelonTextView)view3), ((MelonTextView)view4), ((MelonTextView)view5)), detailContentsAlbumArtistNoteHolder$ArtistNoteActionListener0, null);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final ArtistNoteActionListener actionListener;
    @NotNull
    private final F1 binding;
    private int size;

    static {
        DetailContentsAlbumArtistNoteHolder.Companion = new Companion(null);
        DetailContentsAlbumArtistNoteHolder.$stable = 8;
    }

    private DetailContentsAlbumArtistNoteHolder(F1 f10, ArtistNoteActionListener detailContentsAlbumArtistNoteHolder$ArtistNoteActionListener0) {
        super(f10.a);
        this.binding = f10;
        this.actionListener = detailContentsAlbumArtistNoteHolder$ArtistNoteActionListener0;
        Context context0 = this.itemView.getContext();
        int v = context0.getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
        int v1 = ScreenUtils.dipToPixel(context0, 15.0f);
        int v2 = ScreenUtils.dipToPixel(context0, 64.0f);
        ViewUtils.setDefaultImage(f10.c.c, v2, true);
        int v3 = ScreenUtils.dipToPixel(context0, 0.5f);
        f10.c.b.setBorderWidth(v3);
        int v4 = ColorUtils.getColor(context0, 0x7F06014A);  // color:gray100a
        f10.c.b.setBorderColor(v4);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = f10.b.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            viewGroup$MarginLayoutParams0.setMargins(v, viewGroup$MarginLayoutParams0.topMargin, v, v1);
        }
    }

    public DetailContentsAlbumArtistNoteHolder(F1 f10, ArtistNoteActionListener detailContentsAlbumArtistNoteHolder$ArtistNoteActionListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(f10, detailContentsAlbumArtistNoteHolder$ArtistNoteActionListener0);
    }

    public final void bind(@NotNull ALBUMARTISTNOTE detailBaseRes$ALBUMARTISTNOTE0, int v) {
        q.g(detailBaseRes$ALBUMARTISTNOTE0, "item");
        this.binding.d.setText(detailBaseRes$ALBUMARTISTNOTE0.getArtistName());
        this.binding.e.setText(detailBaseRes$ALBUMARTISTNOTE0.issueDate);
        this.binding.f.setText(detailBaseRes$ALBUMARTISTNOTE0.artistNote);
        Glide.with(this.binding.c.b).load(detailBaseRes$ALBUMARTISTNOTE0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(this.binding.c.b);
        String s = detailBaseRes$ALBUMARTISTNOTE0.getArtistName() + " " + detailBaseRes$ALBUMARTISTNOTE0.issueDate + " " + detailBaseRes$ALBUMARTISTNOTE0.artistNote;
        q.f("%1$d개중 %2$d번째", "getString(...)");
        String s1 = String.format("%1$d개중 %2$d번째", Arrays.copyOf(new Object[]{this.size, ((int)(v + 1))}, 2));
        ViewUtils.setContentDescriptionWithClassName(this.binding.a, s, null, s1);
    }

    public final void setTotal(int v) {
        this.size = v;
    }
}

