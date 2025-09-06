package com.iloen.melon.player.playlist.music;

import W8.a;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000BB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/iloen/melon/player/playlist/music/SmartPlaylistFragment;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseFragment;", "Lcom/iloen/melon/player/playlist/music/SmartPlaylistViewModel;", "<init>", "()V", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Lie/H;", "UiWhenPlaylistEmpty", "(Landroidx/compose/runtime/l;I)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlaylistFragment extends Hilt_SmartPlaylistFragment {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/music/SmartPlaylistFragment$Companion;", "", "Lcom/iloen/melon/player/playlist/music/SmartPlaylistFragment;", "newInstance", "()Lcom/iloen/melon/player/playlist/music/SmartPlaylistFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SmartPlaylistFragment newInstance() {
            return new SmartPlaylistFragment();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        SmartPlaylistFragment.Companion = new Companion(null);
        SmartPlaylistFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.player.playlist.music.MusicPlaylistBaseFragment
    public void UiWhenPlaylistEmpty(@Nullable l l0, int v) {
        ((p)l0).c0(0x9FF5665E);
        int v1 = (v & 6) == 0 ? (((p)l0).i(this) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            boolean z = ((p)l0).i(this);
            r r0 = ((p)l0).N();
            V v2 = k.a;
            if(z || r0 == v2) {
                r0 = new r(this, 0);
                ((p)l0).l0(r0);
            }
            boolean z1 = ((p)l0).i(this);
            r r1 = ((p)l0).N();
            if(z1 || r1 == v2) {
                r1 = new r(this, 1);
                ((p)l0).l0(r1);
            }
            SmartPlaylistFragmentKt.SmartPlaylistEmptyView(r0, r1, ((p)l0), 0, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new a(this, v, 2);
        }
    }

    @Override  // com.melon.ui.J0
    @NotNull
    public Class getViewModelClass() {
        return SmartPlaylistViewModel.class;
    }
}

