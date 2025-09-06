package com.iloen.melon.player.playlist;

import H0.e;
import a9.a;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.melon.ui.popup.b;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import va.e0;
import va.o;
import zd.x;

public final class j implements View.OnClickListener {
    public final int a;
    public final I b;

    public j(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        I i0 = this.b;
        switch(this.a) {
            case 0: {
                D d0 = ((PlaylistMainFragment)i0).getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.player.playlist.PlaylistMainFragment.onViewCreated.8.1(((PlaylistMainFragment)i0), null), 3, null);
                ((PlaylistMainFragment)i0).q().logClickSearch();
                return;
            }
            case 1: {
                if(!((PlaylistMainViewModel)((PlaylistMainFragment)i0).getViewModel()).isDjLoginUser()) {
                    ((PlaylistMainFragment)i0).checkWithMakePlaylist();
                }
                else if(((e0)o.a()).j().getIsDj()) {
                    ArrayList arrayList0 = new ArrayList();
                    arrayList0.add(x.x);
                    arrayList0.add(x.y);
                    l0 l00 = ((PlaylistMainFragment)i0).getChildFragmentManager();
                    String s = ((PlaylistMainFragment)i0).getString(0x7F130778);  // string:mymusic_playlist_create_list "만들기"
                    q.f(s, "getString(...)");
                    b.u(l00, s, arrayList0, new g(((PlaylistMainFragment)i0), 5));
                }
                else {
                    ((PlaylistMainFragment)i0).checkWithMakePlaylist();
                }
                ((PlaylistMainFragment)i0).q().logClickAddPlaylist();
                return;
            }
            case 2: {
                e.w(((PlaylistMainFragment)i0));
                return;
            }
            default: {
                I i1 = ((VideoPlaylistFragment)i0).getParentFragment();
                if(i1 != null && i1 instanceof a) {
                    ((a)i1).removeFragment(((VideoPlaylistFragment)i0));
                }
            }
        }
    }
}

