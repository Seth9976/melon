package com.iloen.melon.fragments.mymusic.dna;

import De.I;
import J8.H0;
import J8.I0;
import J8.f3;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.SongInfoBase;
import d5.f;
import ie.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000BB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/H0;", "binding", "<init>", "(LJ8/H0;)V", "LJ8/H0;", "getBinding", "()LJ8/H0;", "Companion", "MonthlyDnaLogAdapter", "ItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DnaSummaryViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DnaSummaryViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0243, viewGroup0, false);  // layout:dna_monthly_log_summary
            int v = 0x7F0A09CF;  // id:recycler_horizontal
            RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
            if(recyclerView0 != null) {
                v = 0x7F0A0CC2;  // id:tv_most_listened_songs_title
                MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0CC2);  // id:tv_most_listened_songs_title
                if(melonTextView0 != null) {
                    v = 0x7F0A0D21;  // id:tv_summary
                    MelonTextView melonTextView1 = (MelonTextView)I.C(view0, 0x7F0A0D21);  // id:tv_summary
                    if(melonTextView1 != null) {
                        return new DnaSummaryViewHolder(new H0(((ConstraintLayout)view0), recyclerView0, melonTextView0, melonTextView1));
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder$ItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "()V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter");
            int v1 = ((MonthlyDnaLogAdapter)j00).getItemCount();
            float f = 6.0f;
            rect0.left = ScreenUtils.dipToPixel(context0, (v == 0 ? 20.0f : 6.0f));
            if(v == v1 - 1) {
                f = 20.0f;
            }
            rect0.right = ScreenUtils.dipToPixel(context0, f);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\'\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u0010\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001A\u00020\u00152\b\u0010\u0012\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR$\u0010\u001C\u001A\u0004\u0018\u00010\u001B8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder$MonthlyDnaLogAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/melon/net/res/common/SongInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "title", "", "list", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/iloen/melon/fragments/mymusic/dna/OnSongItemClickListener;", "onSongItemClickListener", "Lcom/iloen/melon/fragments/mymusic/dna/OnSongItemClickListener;", "getOnSongItemClickListener", "()Lcom/iloen/melon/fragments/mymusic/dna/OnSongItemClickListener;", "setOnSongItemClickListener", "(Lcom/iloen/melon/fragments/mymusic/dna/OnSongItemClickListener;)V", "MonthlyLogSongItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MonthlyDnaLogAdapter extends y {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder$MonthlyDnaLogAdapter$MonthlyLogSongItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/I0;", "binding", "<init>", "(LJ8/I0;)V", "LJ8/I0;", "getBinding", "()LJ8/I0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MonthlyLogSongItemViewHolder extends O0 {
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder$MonthlyDnaLogAdapter$MonthlyLogSongItemViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/DnaSummaryViewHolder$MonthlyDnaLogAdapter$MonthlyLogSongItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter.MonthlyLogSongItemViewHolder.Companion {
                private com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter.MonthlyLogSongItemViewHolder.Companion() {
                }

                public com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter.MonthlyLogSongItemViewHolder.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }

                @NotNull
                public final MonthlyLogSongItemViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
                    q.g(viewGroup0, "parent");
                    View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0244, viewGroup0, false);  // layout:dna_monthly_log_summary_song_item
                    int v = 0x7F0A0547;  // id:icon_19
                    View view1 = I.C(view0, 0x7F0A0547);  // id:icon_19
                    if(((ImageView)view1) != null) {
                        v = 0x7F0A091E;  // id:play_iv
                        View view2 = I.C(view0, 0x7F0A091E);  // id:play_iv
                        if(((ImageView)view2) != null) {
                            v = 0x7F0A0B69;  // id:thumb
                            View view3 = I.C(view0, 0x7F0A0B69);  // id:thumb
                            if(view3 != null) {
                                f3 f30 = f3.a(view3);
                                v = 0x7F0A0C5E;  // id:tv_desc
                                View view4 = I.C(view0, 0x7F0A0C5E);  // id:tv_desc
                                if(((MelonTextView)view4) != null) {
                                    v = 0x7F0A0D34;  // id:tv_title
                                    View view5 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                    if(((MelonTextView)view5) != null) {
                                        return new MonthlyLogSongItemViewHolder(new I0(((LinearLayout)view0), ((ImageView)view1), ((ImageView)view2), f30, ((MelonTextView)view4), ((MelonTextView)view5)), null);
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
            public static final com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter.MonthlyLogSongItemViewHolder.Companion Companion;
            @NotNull
            private final I0 binding;

            static {
                MonthlyLogSongItemViewHolder.Companion = new com.iloen.melon.fragments.mymusic.dna.DnaSummaryViewHolder.MonthlyDnaLogAdapter.MonthlyLogSongItemViewHolder.Companion(null);
                MonthlyLogSongItemViewHolder.$stable = 8;
            }

            private MonthlyLogSongItemViewHolder(I0 i00) {
                super(i00.a);
                this.binding = i00;
            }

            public MonthlyLogSongItemViewHolder(I0 i00, DefaultConstructorMarker defaultConstructorMarker0) {
                this(i00);
            }

            @NotNull
            public final I0 getBinding() {
                return this.binding;
            }
        }

        public static final int $stable = 8;
        @Nullable
        private OnSongItemClickListener onSongItemClickListener;
        @NotNull
        private final String title;

        public MonthlyDnaLogAdapter(@NotNull Context context0, @NotNull String s, @Nullable List list0) {
            q.g(context0, "context");
            q.g(s, "title");
            super(context0, list0);
            this.title = s;
        }

        @Nullable
        public final OnSongItemClickListener getOnSongItemClickListener() {
            return this.onSongItemClickListener;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(@Nullable O0 o00, int v, int v1) {
            SongInfoBase songInfoBase0 = (SongInfoBase)this.getItem(v1);
            if(songInfoBase0 != null && o00 instanceof MonthlyLogSongItemViewHolder) {
                ((MonthlyLogSongItemViewHolder)o00).getBinding().f.setText(songInfoBase0.songName);
                I0 i00 = ((MonthlyLogSongItemViewHolder)o00).getBinding();
                String s = songInfoBase0.getArtistNames();
                i00.e.setText(s);
                Glide.with(this.getContext()).load(songInfoBase0.albumImg).into(((MonthlyLogSongItemViewHolder)o00).getBinding().d.b);
                ViewUtils.showWhen(((MonthlyLogSongItemViewHolder)o00).getBinding().b, songInfoBase0.isAdult);
                Bundle bundle0 = f.j(new m[]{new m("Layer1", this.title), new m("ordnum", String.valueOf(v1 + 1))});
                I0 i01 = ((MonthlyLogSongItemViewHolder)o00).getBinding();
                a a0 = new a(this, songInfoBase0, bundle0, 0);
                i01.c.setOnClickListener(a0);
                I0 i02 = ((MonthlyLogSongItemViewHolder)o00).getBinding();
                a a1 = new a(this, songInfoBase0, bundle0, 1);
                i02.a.setOnClickListener(a1);
            }
        }

        private static final void onBindViewHolder$lambda$0(MonthlyDnaLogAdapter dnaSummaryViewHolder$MonthlyDnaLogAdapter0, SongInfoBase songInfoBase0, Bundle bundle0, View view0) {
            OnSongItemClickListener onSongItemClickListener0 = dnaSummaryViewHolder$MonthlyDnaLogAdapter0.onSongItemClickListener;
            if(onSongItemClickListener0 != null) {
                onSongItemClickListener0.onSongPlayClickListener(songInfoBase0, bundle0);
            }
        }

        private static final void onBindViewHolder$lambda$1(MonthlyDnaLogAdapter dnaSummaryViewHolder$MonthlyDnaLogAdapter0, SongInfoBase songInfoBase0, Bundle bundle0, View view0) {
            OnSongItemClickListener onSongItemClickListener0 = dnaSummaryViewHolder$MonthlyDnaLogAdapter0.onSongItemClickListener;
            if(onSongItemClickListener0 != null) {
                onSongItemClickListener0.onSongItemClickListener(songInfoBase0, bundle0);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return MonthlyLogSongItemViewHolder.Companion.newInstance(viewGroup0);
        }

        public final void setOnSongItemClickListener(@Nullable OnSongItemClickListener onSongItemClickListener0) {
            this.onSongItemClickListener = onSongItemClickListener0;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final H0 binding;

    static {
        DnaSummaryViewHolder.Companion = new Companion(null);
        DnaSummaryViewHolder.$stable = 8;
    }

    public DnaSummaryViewHolder(@NotNull H0 h00) {
        q.g(h00, "binding");
        super(h00.a);
        this.binding = h00;
    }

    @NotNull
    public final H0 getBinding() {
        return this.binding;
    }
}

