package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class h0 implements a {
    public final LinearLayout a;
    public final LinearLayout b;
    public final MainTabTitleView c;

    public h0(LinearLayout linearLayout0, LinearLayout linearLayout1, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = linearLayout1;
        this.c = mainTabTitleView0;
    }

    public static h0 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D021F, viewGroup0, false);  // layout:detail_item_station
        int v = 0x7F0A05A7;  // id:item_container
        LinearLayout linearLayout0 = (LinearLayout)I.C(view0, 0x7F0A05A7);  // id:item_container
        if(linearLayout0 != null) {
            v = 0x7F0A07CA;  // id:main_contents_title
            MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
            if(mainTabTitleView0 != null) {
                return new h0(((LinearLayout)view0), linearLayout0, mainTabTitleView0);
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

