package com.iloen.melon.player.playlist;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.I;
import androidx.fragment.app.N0;
import androidx.fragment.app.l0;
import com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment;
import com.iloen.melon.player.playlist.mixup.MixUpPlaylistViewPagerFragment;
import com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\t\u001A\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\'\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistViewPagerAdapter;", "Landroidx/fragment/app/N0;", "Landroidx/fragment/app/l0;", "fm", "<init>", "(Landroidx/fragment/app/l0;)V", "", "getCount", "()I", "position", "Landroidx/fragment/app/I;", "getItem", "(I)Landroidx/fragment/app/I;", "Landroid/view/ViewGroup;", "container", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "Lcom/iloen/melon/player/playlist/PlaylistViewPagerBaseFragment;", "getRegisteredFragment", "(I)Lcom/iloen/melon/player/playlist/PlaylistViewPagerBaseFragment;", "any", "Lie/H;", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "clear", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistViewPagerAdapter extends N0 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistViewPagerAdapter$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final SparseArray a;

    static {
        PlaylistViewPagerAdapter.Companion = new Companion(null);
        PlaylistViewPagerAdapter.$stable = 8;
    }

    public PlaylistViewPagerAdapter(@NotNull l0 l00) {
        q.g(l00, "fm");
        super(l00);
        LogU.Companion.create("PlaylistViewPagerAdapter", true, Category.UI);
        this.a = new SparseArray();
    }

    public final void clear() {
        this.a.clear();
    }

    @Override  // androidx.fragment.app.N0
    public void destroyItem(@NotNull ViewGroup viewGroup0, int v, @NotNull Object object0) {
        q.g(viewGroup0, "container");
        q.g(object0, "any");
        this.a.remove(v);
        super.destroyItem(viewGroup0, v, object0);
    }

    @Override  // androidx.viewpager.widget.a
    public int getCount() {
        return 3;
    }

    @Override  // androidx.fragment.app.N0
    @NotNull
    public I getItem(int v) {
        if(v == PlaylistTab.MUSIC.getIndex()) {
            return new MusicSmartPlaylistViewPagerFragment();
        }
        if(v == PlaylistTab.DRAWER.getIndex()) {
            return new DrawerPlaylistViewPagerFragment();
        }
        if(v != PlaylistTab.MIX_UP.getIndex()) {
            throw new IllegalArgumentException("Invalid position: " + v);
        }
        return new MixUpPlaylistViewPagerFragment();
    }

    @Nullable
    public final PlaylistViewPagerBaseFragment getRegisteredFragment(int v) {
        return (PlaylistViewPagerBaseFragment)this.a.get(v);
    }

    @Override  // androidx.fragment.app.N0
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "container");
        Object object0 = super.instantiateItem(viewGroup0, v);
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.player.playlist.PlaylistViewPagerBaseFragment");
        this.a.put(v, ((PlaylistViewPagerBaseFragment)object0));
        return (PlaylistViewPagerBaseFragment)object0;
    }
}

