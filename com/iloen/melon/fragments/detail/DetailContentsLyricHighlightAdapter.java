package com.iloen.melon.fragments.detail;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsLyricHighlightItemHolder;
import com.iloen.melon.net.v6x.response.MyMusicLyricListLyricHighlightRes.RESPONSE.LYRICHIGHLIGHTLIST;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsLyricHighlightAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/MyMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsLyricHighlightItemHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsLyricHighlightItemHolder;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsLyricHighlightItemHolder;II)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsLyricHighlightAdapter extends p {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsLyricHighlightAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_LYRIC_HIGHLIGHT", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int VIEW_TYPE_LYRIC_HIGHLIGHT = 1;

    static {
        DetailContentsLyricHighlightAdapter.Companion = new Companion(null);
        DetailContentsLyricHighlightAdapter.$stable = 8;
    }

    public DetailContentsLyricHighlightAdapter(@Nullable Context context0, @Nullable List list0) {
        super(context0, list0);
    }

    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return 1;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(O0 o00, int v, int v1) {
        this.onBindViewImpl(((DetailContentsLyricHighlightItemHolder)o00), v, v1);
    }

    public void onBindViewImpl(@NotNull DetailContentsLyricHighlightItemHolder detailContentsLyricHighlightItemHolder0, int v, int v1) {
        q.g(detailContentsLyricHighlightItemHolder0, "viewHolder");
        Object object0 = this.getItem(v1);
        q.f(object0, "getItem(...)");
        detailContentsLyricHighlightItemHolder0.bind(((LYRICHIGHLIGHTLIST)object0));
    }

    @Override  // com.iloen.melon.adapters.common.p
    public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
        return this.onCreateViewHolderImpl(viewGroup0, v);
    }

    @NotNull
    public DetailContentsLyricHighlightItemHolder onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        return DetailContentsLyricHighlightItemHolder.Companion.newInstance(viewGroup0);
    }
}

