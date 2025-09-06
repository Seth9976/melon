package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class w0 implements a {
    public final RelativeLayout a;
    public final MelonTextView b;
    public final MelonTextView c;

    public w0(RelativeLayout relativeLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = relativeLayout0;
        this.b = melonTextView0;
        this.c = melonTextView1;
    }

    public static w0 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D0235, viewGroup0, false);  // layout:detail_songlist_footer
        int v = 0x7F0A0817;  // id:more
        MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0817);  // id:more
        if(melonTextView0 != null) {
            v = 0x7F0A0DBB;  // id:view_all
            MelonTextView melonTextView1 = (MelonTextView)I.C(view0, 0x7F0A0DBB);  // id:view_all
            if(melonTextView1 != null) {
                return new w0(((RelativeLayout)view0), melonTextView0, melonTextView1);
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

