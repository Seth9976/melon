package com.iloen.melon.fragments.detail.viewholder;

import A6.b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.main.common.TabItemViewHolder;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \f2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\fB\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\n\u001A\u00020\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailSongHolder;", "Lcom/iloen/melon/fragments/main/common/TabItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailSongHolder extends TabItemViewHolder {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailSongHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailSongHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailSongHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D04A8, viewGroup0, false);  // layout:listitem_song
            q.d(view0);
            return new DetailSongHolder(view0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "FooterHolder";

    static {
        DetailSongHolder.Companion = new Companion(null);
        DetailSongHolder.$stable = 8;
    }

    public DetailSongHolder(@NotNull View view0) {
        q.g(view0, "itemView");
        super(view0);
        view0.addOnAttachStateChangeListener(this);
    }

    public static void a(FOOTER mainMusicRes$RESPONSE$FOOTER0, View view0) {
        DetailSongHolder.onBindView$lambda$0(mainMusicRes$RESPONSE$FOOTER0, view0);
    }

    @NotNull
    public static final DetailSongHolder newInstance(@NotNull ViewGroup viewGroup0) {
        return DetailSongHolder.Companion.newInstance(viewGroup0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        FOOTER mainMusicRes$RESPONSE$FOOTER0 = (FOOTER)adapterInViewHolder$Row0.getItem();
        TextView textView0 = (TextView)this.itemView.findViewById(0x7F0A0D34);  // id:tv_title
        TextView textView1 = (TextView)this.itemView.findViewById(0x7F0A0D1E);  // id:tv_sub_title
        textView0.setText(mainMusicRes$RESPONSE$FOOTER0.getText1());
        textView1.setText(mainMusicRes$RESPONSE$FOOTER0.getText2());
        textView0.setOnClickListener(new b(mainMusicRes$RESPONSE$FOOTER0, 29));
    }

    @Override  // com.iloen.melon.fragments.main.common.TabItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$0(FOOTER mainMusicRes$RESPONSE$FOOTER0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(mainMusicRes$RESPONSE$FOOTER0));
    }
}

