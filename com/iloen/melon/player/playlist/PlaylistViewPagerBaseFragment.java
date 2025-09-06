package com.iloen.melon.player.playlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.IFragmentContainer;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistViewPagerBaseFragment;", "Landroidx/fragment/app/I;", "Lcom/iloen/melon/fragments/IFragmentContainer;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Intent;", "intent", "", "requestCode", "Lie/H;", "startActivityForResult", "(Landroid/content/Intent;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistViewPagerBaseFragment extends I implements IFragmentContainer {
    public static final int $stable = 8;

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0595, viewGroup0, false);  // layout:playlist_base_pager_fragment_layout
        if(view0 == null) {
            throw new NullPointerException("rootView");
        }
        return (FragmentContainerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @d
    public void startActivityForResult(@NotNull Intent intent0, int v) {
        q.g(intent0, "intent");
        I i0 = this.getParentFragment();
        if(i0 != null) {
            i0.startActivityForResult(intent0, v);
            return;
        }
        super.startActivityForResult(intent0, v);
    }
}

