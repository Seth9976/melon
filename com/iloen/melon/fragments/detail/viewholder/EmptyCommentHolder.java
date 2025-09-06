package com.iloen.melon.fragments.detail.viewholder;

import J8.Q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0017\u0018\u0000 \u001A2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001AB\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001D\u0010\u0010\u001A\u00020\u00032\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0013\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001A\u00020\f8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u000E\"\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lie/H;", "LJ8/Q;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "", "isArtistChannel", "<init>", "(LJ8/Q;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;Z)V", "", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Z", "holderBind", "LJ8/Q;", "titleText", "Ljava/lang/String;", "getTitleText", "setTitleText", "(Ljava/lang/String;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class EmptyCommentHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\rH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "isArtistChannel", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final EmptyCommentHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, boolean z) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new EmptyCommentHolder(Q.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0, z);
        }

        public static EmptyCommentHolder newInstance$default(Companion emptyCommentHolder$Companion0, ViewGroup viewGroup0, OnViewHolderActionBaseListener onViewHolderActionBaseListener0, boolean z, int v, Object object0) {
            if((v & 4) != 0) {
                z = false;
            }
            return emptyCommentHolder$Companion0.newInstance(viewGroup0, onViewHolderActionBaseListener0, z);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "EmptyCommentHolder";
    @NotNull
    private Q holderBind;
    private final boolean isArtistChannel;
    @NotNull
    private String titleText;

    static {
        EmptyCommentHolder.Companion = new Companion(null);
        EmptyCommentHolder.$stable = 8;
    }

    public EmptyCommentHolder(@NotNull Q q0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, boolean z) {
        q.g(q0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(q0, onViewHolderActionBaseListener0);
        this.isArtistChannel = z;
        this.holderBind = q0;
        this.titleText = this.getString((z ? 0x7F1307CD : 0x7F130212));  // string:one_word "한마디"
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(EmptyCommentHolder emptyCommentHolder0, View view0) {
        EmptyCommentHolder.onBindView$lambda$0(emptyCommentHolder0, view0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.titleText;
    }

    @NotNull
    public final String getTitleText() {
        return this.titleText;
    }

    @NotNull
    public static final EmptyCommentHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0, boolean z) {
        return EmptyCommentHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0, z);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        if(this.isArtistChannel) {
            ViewUtilsKt.setMarginToDp(this.holderBind.b, 0.0f, 0.0f, 0.0f, 0.0f);
            this.holderBind.c.setTextSize(1, 18.0f);
        }
        this.holderBind.c.setText(this.getTitleName());
        this.holderBind.d.setOnClickListener(new p(this, 0));
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$0(EmptyCommentHolder emptyCommentHolder0, View view0) {
        emptyCommentHolder0.getOnViewHolderActionListener().onOpenCommentWriteView();
    }

    public final void setTitleText(@NotNull String s) {
        q.g(s, "<set-?>");
        this.titleText = s;
    }
}

