package com.iloen.melon.fragments.detail.viewholder;

import J8.M1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.DetailBaseRes.MAGAZINE;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u001B\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000ER\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/M1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "actionListener", "<init>", "(LJ8/M1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;)V", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;", "item", "", "position", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;I)V", "LJ8/M1;", "getBinding", "()LJ8/M1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "Companion", "MagazineActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsMagazineItemHolder extends O0 {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsMagazineItemHolder newInstance(@NotNull ViewGroup viewGroup0, @Nullable MagazineActionListener detailContentsMagazineItemHolder$MagazineActionListener0) {
            q.g(viewGroup0, "parent");
            return new DetailContentsMagazineItemHolder(M1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), detailContentsMagazineItemHolder$MagazineActionListener0, null);
        }

        public static DetailContentsMagazineItemHolder newInstance$default(Companion detailContentsMagazineItemHolder$Companion0, ViewGroup viewGroup0, MagazineActionListener detailContentsMagazineItemHolder$MagazineActionListener0, int v, Object object0) {
            if((v & 2) != 0) {
                detailContentsMagazineItemHolder$MagazineActionListener0 = null;
            }
            return detailContentsMagazineItemHolder$Companion0.newInstance(viewGroup0, detailContentsMagazineItemHolder$MagazineActionListener0);
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;", "magazine", "", "position", "Lie/H;", "onLandMagazine", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface MagazineActionListener {
        void onLandMagazine(@Nullable MAGAZINE arg1, int arg2);
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final MagazineActionListener actionListener;
    @NotNull
    private final M1 binding;

    static {
        DetailContentsMagazineItemHolder.Companion = new Companion(null);
        DetailContentsMagazineItemHolder.$stable = 8;
    }

    private DetailContentsMagazineItemHolder(M1 m10, MagazineActionListener detailContentsMagazineItemHolder$MagazineActionListener0) {
        super(m10.a);
        this.binding = m10;
        this.actionListener = detailContentsMagazineItemHolder$MagazineActionListener0;
        int v = this.itemView.getContext().getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = m10.d.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            viewGroup$MarginLayoutParams0.setMargins(v, viewGroup$MarginLayoutParams0.topMargin, v, viewGroup$MarginLayoutParams0.bottomMargin);
        }
    }

    public DetailContentsMagazineItemHolder(M1 m10, MagazineActionListener detailContentsMagazineItemHolder$MagazineActionListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(m10, detailContentsMagazineItemHolder$MagazineActionListener0);
    }

    public final void bind(@Nullable MAGAZINE detailBaseRes$MAGAZINE0, int v) {
        CharSequence charSequence0 = null;
        Glide.with(this.binding.c.b).load((detailBaseRes$MAGAZINE0 == null ? null : detailBaseRes$MAGAZINE0.contsImg)).into(this.binding.c.b);
        this.binding.e.setText((detailBaseRes$MAGAZINE0 == null ? null : detailBaseRes$MAGAZINE0.contsName));
        MelonTextView melonTextView0 = this.binding.b;
        if(detailBaseRes$MAGAZINE0 != null) {
            String s = detailBaseRes$MAGAZINE0.cateName;
            if(s != null) {
                if(s.length() == 0) {
                    s = ProtocolUtils.getArtistNames(detailBaseRes$MAGAZINE0.artistList);
                }
                charSequence0 = s;
            }
        }
        melonTextView0.setText(charSequence0);
        l l0 = new l(this, detailBaseRes$MAGAZINE0, v, 0);
        this.binding.a.setOnClickListener(l0);
    }

    private static final void bind$lambda$3(DetailContentsMagazineItemHolder detailContentsMagazineItemHolder0, MAGAZINE detailBaseRes$MAGAZINE0, int v, View view0) {
        MagazineActionListener detailContentsMagazineItemHolder$MagazineActionListener0 = detailContentsMagazineItemHolder0.actionListener;
        if(detailContentsMagazineItemHolder$MagazineActionListener0 != null) {
            detailContentsMagazineItemHolder$MagazineActionListener0.onLandMagazine(detailBaseRes$MAGAZINE0, v);
        }
    }

    @NotNull
    public final M1 getBinding() {
        return this.binding;
    }
}

