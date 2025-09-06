package com.iloen.melon.fragments.detail;

import B9.r;
import B9.t;
import B9.u;
import H0.e;
import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.adapters.common.p;
import com.melon.net.res.common.DjPlayListInfoBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B;\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u0012\b\b\u0002\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001C\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001ER\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\u001FR\u0014\u0010\r\u001A\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010 R\u0014\u0010!\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailContentsDjPlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "LB9/u;", "Landroid/content/Context;", "context", "", "list", "LB9/t;", "clickListener", "", "showLikeCount", "LB9/r;", "playlistMarginType", "<init>", "(Landroid/content/Context;Ljava/util/List;LB9/t;ZLB9/r;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)LB9/u;", "viewHolder", "Lie/H;", "onBindViewImpl", "(LB9/u;II)V", "LB9/t;", "Z", "LB9/r;", "VIEW_TYPE_DJ_PLAYLIST", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsDjPlaylistAdapter extends p {
    public static final int $stable = 8;
    private final int VIEW_TYPE_DJ_PLAYLIST;
    @NotNull
    private final t clickListener;
    @NotNull
    private final r playlistMarginType;
    private final boolean showLikeCount;

    public DetailContentsDjPlaylistAdapter(@NotNull Context context0, @Nullable List list0, @NotNull t t0, boolean z, @NotNull r r0) {
        q.g(context0, "context");
        q.g(t0, "clickListener");
        q.g(r0, "playlistMarginType");
        super(context0, list0);
        this.clickListener = t0;
        this.showLikeCount = z;
        this.playlistMarginType = r0;
        this.VIEW_TYPE_DJ_PLAYLIST = 1;
    }

    public DetailContentsDjPlaylistAdapter(Context context0, List list0, t t0, boolean z, r r0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 8) != 0) {
            z = true;
        }
        if((v & 16) != 0) {
            r0 = B9.q.c;
        }
        this(context0, list0, t0, z, r0);
    }

    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return this.VIEW_TYPE_DJ_PLAYLIST;
    }

    public void onBindViewImpl(@Nullable u u0, int v, int v1) {
        if(u0 != null) {
            u0.c(((DjPlayListInfoBase)this.getItem(v1)), v1, this.clickListener, this.showLikeCount);
        }
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(O0 o00, int v, int v1) {
        this.onBindViewImpl(((u)o00), v, v1);
    }

    @NotNull
    public u onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        return e.P(viewGroup0, this.playlistMarginType);
    }

    @Override  // com.iloen.melon.adapters.common.p
    public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
        return this.onCreateViewHolderImpl(viewGroup0, v);
    }
}

