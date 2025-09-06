package com.iloen.melon.fragments.detail;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsMagazineItemHolder.MagazineActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsMagazineItemHolder;
import com.iloen.melon.net.v5x.response.DetailBaseRes.MAGAZINE;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001B2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001BB)\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsMagazineAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$MAGAZINE;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "actionListener", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsMagazineItemHolder$MagazineActionListener;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsMagazineAdapter extends p {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsMagazineAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_MAGAZINE", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int VIEW_TYPE_MAGAZINE = 1;
    @NotNull
    private final MagazineActionListener actionListener;

    static {
        DetailContentsMagazineAdapter.Companion = new Companion(null);
        DetailContentsMagazineAdapter.$stable = 8;
    }

    public DetailContentsMagazineAdapter(@Nullable Context context0, @Nullable List list0, @NotNull MagazineActionListener detailContentsMagazineItemHolder$MagazineActionListener0) {
        q.g(detailContentsMagazineItemHolder$MagazineActionListener0, "actionListener");
        super(context0, list0);
        this.actionListener = detailContentsMagazineItemHolder$MagazineActionListener0;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return 1;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(O0 o00, int v, int v1) {
        this.onBindViewImpl(((DetailContentsMagazineItemHolder)o00), v, v1);
    }

    public void onBindViewImpl(@NotNull DetailContentsMagazineItemHolder detailContentsMagazineItemHolder0, int v, int v1) {
        q.g(detailContentsMagazineItemHolder0, "viewHolder");
        detailContentsMagazineItemHolder0.bind(((MAGAZINE)this.getItem(v1)), v1);
    }

    @Override  // com.iloen.melon.adapters.common.p
    public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
        return this.onCreateViewHolderImpl(viewGroup0, v);
    }

    @NotNull
    public DetailContentsMagazineItemHolder onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        return DetailContentsMagazineItemHolder.Companion.newInstance(viewGroup0, this.actionListener);
    }
}

