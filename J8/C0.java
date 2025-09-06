package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class c0 implements a {
    public final LinearLayout a;
    public final MainTabTitleView b;
    public final RecyclerView c;

    public c0(LinearLayout linearLayout0, RecyclerView recyclerView0, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = mainTabTitleView0;
        this.c = recyclerView0;
    }

    public static c0 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D021A, viewGroup0, false);  // layout:detail_item_photo
        int v = 0x7F0A07CA;  // id:main_contents_title
        MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
        if(mainTabTitleView0 != null) {
            v = 0x7F0A09CF;  // id:recycler_horizontal
            RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
            if(recyclerView0 != null) {
                return new c0(((LinearLayout)view0), recyclerView0, mainTabTitleView0);
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

