package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import com.iloen.melon.custom.MelonTextView;

public final class x2 implements a {
    public final RelativeLayout a;
    public final ToggleButton b;

    public x2(RelativeLayout relativeLayout0, ImageView imageView0, LinearLayout linearLayout0, LinearLayout linearLayout1, ToggleButton toggleButton0, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = relativeLayout0;
        this.b = toggleButton0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

