package com.iloen.melon.fragments.mymusic.dna;

import De.I;
import J8.E0;
import J8.F0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.detail.viewholder.s;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import d5.f;
import ie.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000BB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/E0;", "binding", "<init>", "(LJ8/E0;)V", "LJ8/E0;", "getBinding", "()LJ8/E0;", "Companion", "RepresentTagAdapter", "ItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RepresentTagViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final RepresentTagViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0240, viewGroup0, false);  // layout:dna_monthly_log_represent_tag
            int v = 0x7F0A0320;  // id:container_card
            View view1 = I.C(view0, 0x7F0A0320);  // id:container_card
            if(((FrameLayout)view1) != null) {
                v = 0x7F0A0321;  // id:container_card_dim
                View view2 = I.C(view0, 0x7F0A0321);  // id:container_card_dim
                if(view2 != null) {
                    v = 0x7F0A0333;  // id:container_tag_flex
                    View view3 = I.C(view0, 0x7F0A0333);  // id:container_tag_flex
                    if(((RecyclerView)view3) != null) {
                        v = 0x7F0A0CFC;  // id:tv_represent_tag
                        View view4 = I.C(view0, 0x7F0A0CFC);  // id:tv_represent_tag
                        if(((MelonTextView)view4) != null) {
                            return new RepresentTagViewHolder(new E0(((FrameLayout)view0), ((FrameLayout)view1), view2, ((RecyclerView)view3), ((MelonTextView)view4)), null);
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder$ItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "()V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ItemDecoration extends r0 {
        public static final int $stable = 8;

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            Context context0 = view0.getContext();
            int v = recyclerView0.getChildAdapterPosition(view0);
            j0 j00 = recyclerView0.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.RepresentTagAdapter");
            int v1 = ((RepresentTagAdapter)j00).getItemCount();
            rect0.top = ScreenUtils.dipToPixel(context0, 7.0f);
            float f = 0.0f;
            rect0.left = ScreenUtils.dipToPixel(context0, 0.0f);
            if(v != v1 - 1) {
                f = 10.0f;
            }
            rect0.right = ScreenUtils.dipToPixel(context0, f);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001DB\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ)\u0010\u0014\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder$RepresentTagAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/net/v4x/common/TagInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/mymusic/dna/OnTagItemClickListener;", "onTagItemClickListener", "Lcom/iloen/melon/fragments/mymusic/dna/OnTagItemClickListener;", "getOnTagItemClickListener", "()Lcom/iloen/melon/fragments/mymusic/dna/OnTagItemClickListener;", "setOnTagItemClickListener", "(Lcom/iloen/melon/fragments/mymusic/dna/OnTagItemClickListener;)V", "MonthlyLogTagItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RepresentTagAdapter extends y {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder$RepresentTagAdapter$MonthlyLogTagItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/F0;", "binding", "<init>", "(LJ8/F0;)V", "LJ8/F0;", "getBinding", "()LJ8/F0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MonthlyLogTagItemViewHolder extends O0 {
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder$RepresentTagAdapter$MonthlyLogTagItemViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/RepresentTagViewHolder$RepresentTagAdapter$MonthlyLogTagItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.RepresentTagAdapter.MonthlyLogTagItemViewHolder.Companion {
                private com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.RepresentTagAdapter.MonthlyLogTagItemViewHolder.Companion() {
                }

                public com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.RepresentTagAdapter.MonthlyLogTagItemViewHolder.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }

                @NotNull
                public final MonthlyLogTagItemViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
                    q.g(viewGroup0, "parent");
                    View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0241, viewGroup0, false);  // layout:dna_monthly_log_represent_tag_item
                    MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D22);  // id:tv_tag
                    if(melonTextView0 == null) {
                        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0D22));  // id:tv_tag
                    }
                    return new MonthlyLogTagItemViewHolder(new F0(((FrameLayout)view0), melonTextView0), null);
                }
            }

            public static final int $stable;
            @NotNull
            public static final com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.RepresentTagAdapter.MonthlyLogTagItemViewHolder.Companion Companion;
            @NotNull
            private final F0 binding;

            static {
                MonthlyLogTagItemViewHolder.Companion = new com.iloen.melon.fragments.mymusic.dna.RepresentTagViewHolder.RepresentTagAdapter.MonthlyLogTagItemViewHolder.Companion(null);
                MonthlyLogTagItemViewHolder.$stable = 8;
            }

            private MonthlyLogTagItemViewHolder(F0 f00) {
                super(f00.a);
                this.binding = f00;
            }

            public MonthlyLogTagItemViewHolder(F0 f00, DefaultConstructorMarker defaultConstructorMarker0) {
                this(f00);
            }

            @NotNull
            public final F0 getBinding() {
                return this.binding;
            }
        }

        public static final int $stable = 8;
        @Nullable
        private OnTagItemClickListener onTagItemClickListener;

        public RepresentTagAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            super(context0, list0);
        }

        public static void a(RepresentTagAdapter representTagViewHolder$RepresentTagAdapter0, TagInfoBase tagInfoBase0, Bundle bundle0, View view0) {
            RepresentTagAdapter.onBindViewHolder$lambda$0(representTagViewHolder$RepresentTagAdapter0, tagInfoBase0, bundle0, view0);
        }

        @Nullable
        public final OnTagItemClickListener getOnTagItemClickListener() {
            return this.onTagItemClickListener;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(@Nullable O0 o00, int v, int v1) {
            TagInfoBase tagInfoBase0 = (TagInfoBase)this.getItem(v1);
            if(tagInfoBase0 != null && o00 instanceof MonthlyLogTagItemViewHolder) {
                ((MonthlyLogTagItemViewHolder)o00).getBinding().b.setText(tagInfoBase0.tagName);
                Bundle bundle0 = f.j(new m[]{new m("Layer1", tagInfoBase0.tagName)});
                F0 f00 = ((MonthlyLogTagItemViewHolder)o00).getBinding();
                s s0 = new s(this, tagInfoBase0, bundle0, 1);
                f00.a.setOnClickListener(s0);
                ViewUtils.setContentDescriptionWithButtonClassName(((MonthlyLogTagItemViewHolder)o00).getBinding().a, tagInfoBase0.tagName);
            }
        }

        private static final void onBindViewHolder$lambda$0(RepresentTagAdapter representTagViewHolder$RepresentTagAdapter0, TagInfoBase tagInfoBase0, Bundle bundle0, View view0) {
            OnTagItemClickListener onTagItemClickListener0 = representTagViewHolder$RepresentTagAdapter0.onTagItemClickListener;
            if(onTagItemClickListener0 != null) {
                onTagItemClickListener0.onTagItemClickListener(tagInfoBase0, bundle0);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return MonthlyLogTagItemViewHolder.Companion.newInstance(viewGroup0);
        }

        public final void setOnTagItemClickListener(@Nullable OnTagItemClickListener onTagItemClickListener0) {
            this.onTagItemClickListener = onTagItemClickListener0;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final E0 binding;

    static {
        RepresentTagViewHolder.Companion = new Companion(null);
        RepresentTagViewHolder.$stable = 8;
    }

    private RepresentTagViewHolder(E0 e00) {
        super(e00.a);
        this.binding = e00;
    }

    public RepresentTagViewHolder(E0 e00, DefaultConstructorMarker defaultConstructorMarker0) {
        this(e00);
    }

    @NotNull
    public final E0 getBinding() {
        return this.binding;
    }
}

