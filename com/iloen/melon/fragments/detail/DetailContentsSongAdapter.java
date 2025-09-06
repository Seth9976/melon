package com.iloen.melon.fragments.detail;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder.DetailContentsSong;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder.SongActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsSongHolder;
import com.iloen.melon.fragments.main.common.OnImpLogListener;
import com.melon.net.res.common.SongInfoBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0007\u0018\u0000 \'2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\'BK\b\u0007\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u0012\b\b\u0002\u0010\f\u001A\u00020\n\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\'\u0010 \u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010#R\u0014\u0010\f\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R\u0018\u0010\u000E\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010$R\u0016\u0010%\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/SongInfoBase;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "actionListener", "", "showHotAndTitleBadge", "isRankWithoutGap", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "onImpLogListener", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;ZZLcom/iloen/melon/fragments/main/common/OnImpLogListener;)V", "", "index", "Lie/H;", "setOriginSongIndex", "(I)V", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder;", "viewHolder", "onBindViewImpl", "(Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsSongHolder$SongActionListener;", "Z", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "originSongIndex", "I", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsSongAdapter extends p {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsSongAdapter$Companion;", "", "<init>", "()V", "VIEW_TYPE_SONG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int VIEW_TYPE_SONG = 1;
    @NotNull
    private final SongActionListener actionListener;
    private final boolean isRankWithoutGap;
    @Nullable
    private OnImpLogListener onImpLogListener;
    private int originSongIndex;
    private final boolean showHotAndTitleBadge;

    static {
        DetailContentsSongAdapter.Companion = new Companion(null);
        DetailContentsSongAdapter.$stable = 8;
    }

    public DetailContentsSongAdapter(@Nullable Context context0, @Nullable List list0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0) {
        q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
        this(context0, list0, detailContentsSongHolder$SongActionListener0, false, false, null, 56, null);
    }

    public DetailContentsSongAdapter(@Nullable Context context0, @Nullable List list0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z) {
        q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
        this(context0, list0, detailContentsSongHolder$SongActionListener0, z, false, null, 0x30, null);
    }

    public DetailContentsSongAdapter(@Nullable Context context0, @Nullable List list0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1) {
        q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
        this(context0, list0, detailContentsSongHolder$SongActionListener0, z, z1, null, 0x20, null);
    }

    public DetailContentsSongAdapter(@Nullable Context context0, @Nullable List list0, @NotNull SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, @Nullable OnImpLogListener onImpLogListener0) {
        q.g(detailContentsSongHolder$SongActionListener0, "actionListener");
        super(context0, list0);
        this.actionListener = detailContentsSongHolder$SongActionListener0;
        this.showHotAndTitleBadge = z;
        this.isRankWithoutGap = z1;
        this.onImpLogListener = onImpLogListener0;
        this.originSongIndex = -1;
    }

    public DetailContentsSongAdapter(Context context0, List list0, SongActionListener detailContentsSongHolder$SongActionListener0, boolean z, boolean z1, OnImpLogListener onImpLogListener0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            z = true;
        }
        if((v & 16) != 0) {
            z1 = false;
        }
        if((v & 0x20) != 0) {
            onImpLogListener0 = null;
        }
        this(context0, list0, detailContentsSongHolder$SongActionListener0, z, z1, onImpLogListener0);
    }

    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return 1;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(O0 o00, int v, int v1) {
        this.onBindViewImpl(((DetailContentsSongHolder)o00), v, v1);
    }

    public void onBindViewImpl(@NotNull DetailContentsSongHolder detailContentsSongHolder0, int v, int v1) {
        q.g(detailContentsSongHolder0, "viewHolder");
        detailContentsSongHolder0.setTotal(this.getList().size());
        detailContentsSongHolder0.bind(new DetailContentsSong(((SongInfoBase)this.getItem(v1)), v, v1, this.isMarked(v1), this.isMarqueeNeeded(v1), this.originSongIndex == v1));
    }

    @Override  // com.iloen.melon.adapters.common.p
    public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
        return this.onCreateViewHolderImpl(viewGroup0, v);
    }

    @NotNull
    public DetailContentsSongHolder onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        return DetailContentsSongHolder.Companion.newInstance(viewGroup0, this.actionListener, this.showHotAndTitleBadge, this.isRankWithoutGap, this.onImpLogListener);
    }

    public final void setOriginSongIndex(int v) {
        this.originSongIndex = v;
    }
}

