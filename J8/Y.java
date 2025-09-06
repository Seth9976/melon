package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;

public final class y implements a {
    public final LinearLayout a;
    public final ComposeView b;

    public y(LinearLayout linearLayout0, ComposeView composeView0) {
        this.a = linearLayout0;
        this.b = composeView0;
    }

    public static y a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D01A5, viewGroup0, false);  // layout:compose_fragment_layout
        ComposeView composeView0 = (ComposeView)I.C(view0, 0x7F0A0309);  // id:compose_view
        if(composeView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0309));  // id:compose_view
        }
        return new y(((LinearLayout)view0), composeView0);
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

