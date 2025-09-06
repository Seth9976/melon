package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.custom.LocalPlaylistCreatingInputBarView;
import com.iloen.melon.custom.title.TitleBar;

public final class c implements a {
    public final RelativeLayout a;
    public final FrameLayout b;
    public final LocalPlaylistCreatingInputBarView c;
    public final ImageView d;
    public final RecyclerView e;
    public final b f;

    public c(RelativeLayout relativeLayout0, FrameLayout frameLayout0, LocalPlaylistCreatingInputBarView localPlaylistCreatingInputBarView0, ImageView imageView0, RecyclerView recyclerView0, b b0) {
        this.a = relativeLayout0;
        this.b = frameLayout0;
        this.c = localPlaylistCreatingInputBarView0;
        this.d = imageView0;
        this.e = recyclerView0;
        this.f = b0;
    }

    public static c a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D002C, viewGroup0, false);  // layout:add_to_playlist_popup_layout
        int v = 0x7F0A0425;  // id:empty
        View view1 = I.C(view0, 0x7F0A0425);  // id:empty
        if(((FrameLayout)view1) != null) {
            v = 0x7F0A0581;  // id:inputBarView
            View view2 = I.C(view0, 0x7F0A0581);  // id:inputBarView
            if(((LocalPlaylistCreatingInputBarView)view2) != null) {
                v = 0x7F0A0606;  // id:iv_bottom_shadow
                View view3 = I.C(view0, 0x7F0A0606);  // id:iv_bottom_shadow
                if(((ImageView)view3) != null && ((RelativeLayout)I.C(view0, 0x7F0A06E4)) != null) {  // id:layoutList
                    v = 0x7F0A0957;  // id:popup_list
                    View view4 = I.C(view0, 0x7F0A0957);  // id:popup_list
                    if(((RecyclerView)view4) != null) {
                        v = 0x7F0A0BAD;  // id:titlebar
                        View view5 = I.C(view0, 0x7F0A0BAD);  // id:titlebar
                        if(view5 != null) {
                            return new c(((RelativeLayout)view0), ((FrameLayout)view1), ((LocalPlaylistCreatingInputBarView)view2), ((ImageView)view3), ((RecyclerView)view4), new b(((TitleBar)view5), ((TitleBar)view5), 12));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

