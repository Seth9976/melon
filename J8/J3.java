package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.iloen.melon.custom.MelonTextView;

public final class j3 implements a {
    public final LinearLayout a;
    public final MelonTextView b;
    public final ImageButton c;
    public final ImageButton d;

    public j3(LinearLayout linearLayout0, MelonTextView melonTextView0, ImageButton imageButton0, ImageButton imageButton1) {
        this.a = linearLayout0;
        this.b = melonTextView0;
        this.c = imageButton0;
        this.d = imageButton1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

