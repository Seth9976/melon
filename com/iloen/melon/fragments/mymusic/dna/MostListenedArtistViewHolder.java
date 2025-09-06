package com.iloen.melon.fragments.mymusic.dna;

import De.I;
import J8.C0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.O0;
import com.google.android.material.imageview.ShapeableImageView;
import com.iloen.melon.custom.MelonTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MostListenedArtistViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/C0;", "binding", "<init>", "(LJ8/C0;)V", "LJ8/C0;", "getBinding", "()LJ8/C0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MostListenedArtistViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MostListenedArtistViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/MostListenedArtistViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MostListenedArtistViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D023E, viewGroup0, false);  // layout:dna_monthly_log_most_artist
            int v = 0x7F0A00B4;  // id:artist_desc_together
            View view1 = I.C(view0, 0x7F0A00B4);  // id:artist_desc_together
            if(((LinearLayout)view1) != null) {
                v = 0x7F0A00C0;  // id:artist_thumbnail
                View view2 = I.C(view0, 0x7F0A00C0);  // id:artist_thumbnail
                if(((ShapeableImageView)view2) != null && ((LinearLayout)I.C(view0, 0x7F0A031C)) != null) {  // id:container_artist
                    v = 0x7F0A0CBC;  // id:tv_most_listened_artist
                    View view3 = I.C(view0, 0x7F0A0CBC);  // id:tv_most_listened_artist
                    if(((MelonTextView)view3) != null) {
                        v = 0x7F0A0CBD;  // id:tv_most_listened_artist_end
                        View view4 = I.C(view0, 0x7F0A0CBD);  // id:tv_most_listened_artist_end
                        if(((MelonTextView)view4) != null) {
                            v = 0x7F0A0CBE;  // id:tv_most_listened_artist_suffix
                            View view5 = I.C(view0, 0x7F0A0CBE);  // id:tv_most_listened_artist_suffix
                            if(((MelonTextView)view5) != null) {
                                v = 0x7F0A0D34;  // id:tv_title
                                View view6 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                if(((MelonTextView)view6) != null) {
                                    return new MostListenedArtistViewHolder(new C0(((FrameLayout)view0), ((LinearLayout)view1), ((ShapeableImageView)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((MelonTextView)view5), ((MelonTextView)view6)), null);
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
    private final C0 binding;

    static {
        MostListenedArtistViewHolder.Companion = new Companion(null);
        MostListenedArtistViewHolder.$stable = 8;
    }

    private MostListenedArtistViewHolder(C0 c00) {
        super(c00.a);
        this.binding = c00;
    }

    public MostListenedArtistViewHolder(C0 c00, DefaultConstructorMarker defaultConstructorMarker0) {
        this(c00);
    }

    @NotNull
    public final C0 getBinding() {
        return this.binding;
    }
}

