package com.iloen.melon.fragments.mymusic.dna;

import De.I;
import J8.G0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.MelonTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/ShortcutsViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/G0;", "binding", "<init>", "(LJ8/G0;)V", "LJ8/G0;", "getBinding", "()LJ8/G0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ShortcutsViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/ShortcutsViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/dna/ShortcutsViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ShortcutsViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0242, viewGroup0, false);  // layout:dna_monthly_log_shortcuts
            MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A01B9);  // id:btn_shortcuts
            if(melonTextView0 == null) {
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A01B9));  // id:btn_shortcuts
            }
            return new ShortcutsViewHolder(new G0(((FrameLayout)view0), melonTextView0), null);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final G0 binding;

    static {
        ShortcutsViewHolder.Companion = new Companion(null);
        ShortcutsViewHolder.$stable = 8;
    }

    private ShortcutsViewHolder(G0 g00) {
        super(g00.a);
        this.binding = g00;
    }

    public ShortcutsViewHolder(G0 g00, DefaultConstructorMarker defaultConstructorMarker0) {
        this(g00);
    }

    @NotNull
    public final G0 getBinding() {
        return this.binding;
    }
}

