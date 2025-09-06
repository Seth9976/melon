package com.iloen.melon.fragments.detail.viewholder;

import J8.j0;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongTicketHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder;", "LJ8/j0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/j0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongTicketHolder extends TicketHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongTicketHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongTicketHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongTicketHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new SongTicketHolder(j0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SongTicketHolder";

    static {
        SongTicketHolder.Companion = new Companion(null);
        SongTicketHolder.$stable = 8;
    }

    public SongTicketHolder(@NotNull j0 j00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(j00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(j00, onViewHolderActionBaseListener0);
    }

    @NotNull
    public static final SongTicketHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongTicketHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }
}

