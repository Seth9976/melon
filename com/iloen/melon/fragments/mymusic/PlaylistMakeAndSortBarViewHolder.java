package com.iloen.melon.fragments.mymusic;

import De.I;
import J8.b3;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.MelonBigButton;
import com.iloen.melon.custom.MelonTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/PlaylistMakeAndSortBarViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/b3;", "binding", "<init>", "(LJ8/b3;)V", "LJ8/b3;", "getBinding", "()LJ8/b3;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistMakeAndSortBarViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/PlaylistMakeAndSortBarViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/PlaylistMakeAndSortBarViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistMakeAndSortBarViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D085B, viewGroup0, false);  // layout:sortbar_playlist
            int v = 0x7F0A0168;  // id:btn_image_add
            MelonBigButton melonBigButton0 = (MelonBigButton)I.C(view0, 0x7F0A0168);  // id:btn_image_add
            if(melonBigButton0 != null) {
                v = 0x7F0A017E;  // id:btn_new_make
                MelonBigButton melonBigButton1 = (MelonBigButton)I.C(view0, 0x7F0A017E);  // id:btn_new_make
                if(melonBigButton1 != null) {
                    v = 0x7F0A0ABB;  // id:sorting
                    MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0ABB);  // id:sorting
                    if(melonTextView0 != null) {
                        return new PlaylistMakeAndSortBarViewHolder(new b3(((LinearLayoutCompat)view0), melonBigButton0, melonBigButton1, melonTextView0));
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
    private final b3 binding;

    static {
        PlaylistMakeAndSortBarViewHolder.Companion = new Companion(null);
        PlaylistMakeAndSortBarViewHolder.$stable = 8;
    }

    public PlaylistMakeAndSortBarViewHolder(@NotNull b3 b30) {
        q.g(b30, "binding");
        super(b30.a);
        this.binding = b30;
    }

    @NotNull
    public final b3 getBinding() {
        return this.binding;
    }
}

