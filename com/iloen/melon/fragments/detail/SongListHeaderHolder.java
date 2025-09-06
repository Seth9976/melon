package com.iloen.melon.fragments.detail;

import De.I;
import J8.A0;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.MelonTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongListHeaderHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/A0;", "binding", "<init>", "(LJ8/A0;)V", "LJ8/A0;", "getBinding", "()LJ8/A0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class SongListHeaderHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/detail/SongListHeaderHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/SongListHeaderHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongListHeaderHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = o.e(viewGroup0, 0x7F0D0239, viewGroup0, false);  // layout:detail_station_episode_songlist_header
            MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0921);  // id:play_time
            if(melonTextView0 == null || ((MelonTextView)I.C(view0, 0x7F0A0B8D)) == null) {  // id:title
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0921));  // id:play_time
            }
            return new SongListHeaderHolder(new A0(((ConstraintLayout)view0), melonTextView0));
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final A0 binding;

    static {
        SongListHeaderHolder.Companion = new Companion(null);
    }

    public SongListHeaderHolder(@NotNull A0 a00) {
        q.g(a00, "binding");
        super(a00.a);
        this.binding = a00;
    }

    @NotNull
    public final A0 getBinding() {
        return this.binding;
    }
}

