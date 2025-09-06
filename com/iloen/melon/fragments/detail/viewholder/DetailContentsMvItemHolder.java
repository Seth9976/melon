package com.iloen.melon.fragments.detail.viewholder;

import Cb.k;
import J8.Z1;
import U4.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.MvInfoBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0002\u001C\u001DB\u001B\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R$\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/Z1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;", "actionListener", "<init>", "(LJ8/Z1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;)V", "Lcom/melon/net/res/common/MvInfoBase;", "item", "", "position", "Lie/H;", "bind", "(Lcom/melon/net/res/common/MvInfoBase;I)V", "size", "setTotal", "(I)V", "LJ8/Z1;", "getBinding", "()LJ8/Z1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;", "getActionListener", "()Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;", "setActionListener", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;)V", "total", "I", "Companion", "MvActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsMvItemHolder extends O0 {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsMvItemHolder newInstance(@NotNull ViewGroup viewGroup0, @Nullable MvActionListener detailContentsMvItemHolder$MvActionListener0) {
            q.g(viewGroup0, "parent");
            return new DetailContentsMvItemHolder(Z1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), detailContentsMvItemHolder$MvActionListener0, null);
        }

        public static DetailContentsMvItemHolder newInstance$default(Companion detailContentsMvItemHolder$Companion0, ViewGroup viewGroup0, MvActionListener detailContentsMvItemHolder$MvActionListener0, int v, Object object0) {
            if((v & 2) != 0) {
                detailContentsMvItemHolder$MvActionListener0 = null;
            }
            return detailContentsMvItemHolder$Companion0.newInstance(viewGroup0, detailContentsMvItemHolder$MvActionListener0);
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMvItemHolder$MvActionListener;", "", "Lcom/melon/net/res/common/MvInfoBase;", "mv", "", "position", "Lie/H;", "onPlayMv", "(Lcom/melon/net/res/common/MvInfoBase;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface MvActionListener {
        void onPlayMv(@NotNull MvInfoBase arg1, int arg2);
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private MvActionListener actionListener;
    @NotNull
    private final Z1 binding;
    private int total;

    static {
        DetailContentsMvItemHolder.Companion = new Companion(null);
        DetailContentsMvItemHolder.$stable = 8;
    }

    private DetailContentsMvItemHolder(Z1 z10, MvActionListener detailContentsMvItemHolder$MvActionListener0) {
        super(z10.a);
        this.binding = z10;
        this.actionListener = detailContentsMvItemHolder$MvActionListener0;
        int v = this.itemView.getContext().getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = z10.d.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            viewGroup$MarginLayoutParams0.setMargins(v, viewGroup$MarginLayoutParams0.topMargin, v, viewGroup$MarginLayoutParams0.bottomMargin);
        }
    }

    public DetailContentsMvItemHolder(Z1 z10, MvActionListener detailContentsMvItemHolder$MvActionListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(z10, detailContentsMvItemHolder$MvActionListener0);
    }

    public final void bind(@NotNull MvInfoBase mvInfoBase0, int v) {
        q.g(mvInfoBase0, "item");
        Glide.with(this.binding.c.c).load(mvInfoBase0.mv169Img).into(this.binding.c.c);
        this.binding.g.setText(mvInfoBase0.mvName);
        String s = mvInfoBase0.getArtistNames();
        this.binding.b.setText(s);
        this.binding.f.setText(k.f((mvInfoBase0.playTime == null ? "" : mvInfoBase0.playTime)));
        ImageView imageView0 = this.binding.e;
        int v1 = ResourceUtils.getMvAdultGradeIcon(mvInfoBase0.adultGrade);
        if(v1 == -1) {
            imageView0.setVisibility(8);
        }
        else {
            imageView0.setVisibility(0);
            imageView0.setImageResource(v1);
        }
        l l0 = new l(this, mvInfoBase0, v, 1);
        this.binding.a.setOnClickListener(l0);
        if(this.itemView.getContext() == null) {
            return;
        }
        String s1 = k.e(mvInfoBase0.playTime);
        StringBuilder stringBuilder0 = new StringBuilder(x.m(a.o(mvInfoBase0.mvName, ", ", "아티스트", ": ", mvInfoBase0.getArtistNames()), ", ", s1));
        if("19".equals(mvInfoBase0.adultGrade)) {
            stringBuilder0.append(", ");
            stringBuilder0.append("19세 미만 청소년 이용불가 콘텐츠");
        }
        stringBuilder0.append(", ");
        stringBuilder0.append("재생하기");
        String s2 = this.itemView.getContext().getString(0x7F130BA8, new Object[]{this.total, ((int)(v + 1))});  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
        q.f(s2, "getString(...)");
        ViewUtils.setContentDescriptionWithButtonClassName(this.binding.a, stringBuilder0, s2);
    }

    private static final void bind$lambda$3(DetailContentsMvItemHolder detailContentsMvItemHolder0, MvInfoBase mvInfoBase0, int v, View view0) {
        MvActionListener detailContentsMvItemHolder$MvActionListener0 = detailContentsMvItemHolder0.actionListener;
        if(detailContentsMvItemHolder$MvActionListener0 != null) {
            detailContentsMvItemHolder$MvActionListener0.onPlayMv(mvInfoBase0, v);
        }
    }

    @Nullable
    public final MvActionListener getActionListener() {
        return this.actionListener;
    }

    @NotNull
    public final Z1 getBinding() {
        return this.binding;
    }

    public final void setActionListener(@Nullable MvActionListener detailContentsMvItemHolder$MvActionListener0) {
        this.actionListener = detailContentsMvItemHolder$MvActionListener0;
    }

    public final void setTotal(int v) {
        this.total = v;
    }
}

