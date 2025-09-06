package com.iloen.melon.fragments.mymusic.dna;

import De.I;
import J8.D0;
import J8.f2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.MelonTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MostListenedGenreViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/D0;", "binding", "<init>", "(LJ8/D0;)V", "LJ8/D0;", "getBinding", "()LJ8/D0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MostListenedGenreViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MostListenedGenreViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/MostListenedGenreViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MostListenedGenreViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D023F, viewGroup0, false);  // layout:dna_monthly_log_most_genre
            int v = 0x7F0A0330;  // id:container_more
            View view1 = I.C(view0, 0x7F0A0330);  // id:container_more
            if(((MelonTextView)view1) != null) {
                v = 0x7F0A0332;  // id:container_songs
                View view2 = I.C(view0, 0x7F0A0332);  // id:container_songs
                if(((LinearLayout)view2) != null && ((ImageView)I.C(view0, 0x7F0A0546)) != null) {  // id:icon
                    v = 0x7F0A081F;  // id:most_listened_genre_song_1
                    View view3 = I.C(view0, 0x7F0A081F);  // id:most_listened_genre_song_1
                    if(view3 != null) {
                        f2 f20 = f2.a(view3);
                        v = 0x7F0A0820;  // id:most_listened_genre_song_2
                        View view4 = I.C(view0, 0x7F0A0820);  // id:most_listened_genre_song_2
                        if(view4 != null) {
                            f2 f21 = f2.a(view4);
                            v = 0x7F0A0821;  // id:most_listened_genre_song_3
                            View view5 = I.C(view0, 0x7F0A0821);  // id:most_listened_genre_song_3
                            if(view5 != null) {
                                f2 f22 = f2.a(view5);
                                v = 0x7F0A0CBF;  // id:tv_most_listened_genre
                                View view6 = I.C(view0, 0x7F0A0CBF);  // id:tv_most_listened_genre
                                if(((MelonTextView)view6) != null && ((MelonTextView)I.C(view0, 0x7F0A0CC0)) != null) {  // id:tv_most_listened_genre_song_title
                                    v = 0x7F0A0CC1;  // id:tv_most_listened_genre_title
                                    View view7 = I.C(view0, 0x7F0A0CC1);  // id:tv_most_listened_genre_title
                                    if(((MelonTextView)view7) != null) {
                                        return new MostListenedGenreViewHolder(new D0(((FrameLayout)view0), ((MelonTextView)view1), ((LinearLayout)view2), f20, f21, f22, ((MelonTextView)view6), ((MelonTextView)view7)), null);
                                    }
                                }
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
    private final D0 binding;

    static {
        MostListenedGenreViewHolder.Companion = new Companion(null);
        MostListenedGenreViewHolder.$stable = 8;
    }

    private MostListenedGenreViewHolder(D0 d00) {
        super(d00.a);
        this.binding = d00;
    }

    public MostListenedGenreViewHolder(D0 d00, DefaultConstructorMarker defaultConstructorMarker0) {
        this(d00);
    }

    @NotNull
    public final D0 getBinding() {
        return this.binding;
    }
}

