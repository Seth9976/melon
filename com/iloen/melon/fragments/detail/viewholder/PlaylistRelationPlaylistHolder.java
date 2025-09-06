package com.iloen.melon.fragments.detail.viewholder;

import J8.e0;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;
import com.kakao.tiara.data.ActionKind;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0013\u001A\u00020\u00122\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationPlaylistHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "LJ8/e0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/e0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "getTitleName", "()Ljava/lang/String;", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "", "position", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PLAYLIST;", "item", "Lie/H;", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;ILcom/iloen/melon/net/v5x/response/DetailBaseRes$PLAYLIST;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistRelationPlaylistHolder extends PlaylistHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationPlaylistHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationPlaylistHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistRelationPlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new PlaylistRelationPlaylistHolder(e0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistRelationPlaylistHolder";

    static {
        PlaylistRelationPlaylistHolder.Companion = new Companion(null);
        PlaylistRelationPlaylistHolder.$stable = 8;
    }

    public PlaylistRelationPlaylistHolder(@NotNull e0 e00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(e00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(e00, onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.PlaylistHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F13034A);  // string:dj_playlist_title_relation_playlist "연관 플레이리스트"
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.PlaylistHolder
    public void itemClickLog(@NotNull ActionKind actionKind0, @NotNull String s, int v, @Nullable PLAYLIST detailBaseRes$PLAYLIST0) {
        q.g(actionKind0, "actionKind");
        q.g(s, "actionName");
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.d = actionKind0;
            f0.a = s;
            f0.y = this.getString(0x7F130E67);  // string:tiara_djplaylist_layer1_relation_playlist "연관플레이리스트"
            f0.c(v + 1);
            String s1 = null;
            f0.e = detailBaseRes$PLAYLIST0 == null ? null : detailBaseRes$PLAYLIST0.plylstseq;
            f0.f = this.getString(0x7F130EF6);  // string:tiara_meta_type_djplaylist "DJ플레이리스트"
            if(detailBaseRes$PLAYLIST0 != null) {
                s1 = detailBaseRes$PLAYLIST0.plylsttitle;
            }
            f0.g = s1;
            f0.a().track();
        }
    }

    @NotNull
    public static final PlaylistRelationPlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return PlaylistRelationPlaylistHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }
}

