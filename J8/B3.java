package J8;

import Q4.a;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.iloen.melon.custom.MelonBigButton;
import com.iloen.melon.custom.MelonTextView;

public final class b3 implements a {
    public final LinearLayoutCompat a;
    public final MelonBigButton b;
    public final MelonBigButton c;
    public final MelonTextView d;

    public b3(LinearLayoutCompat linearLayoutCompat0, MelonBigButton melonBigButton0, MelonBigButton melonBigButton1, MelonTextView melonTextView0) {
        this.a = linearLayoutCompat0;
        this.b = melonBigButton0;
        this.c = melonBigButton1;
        this.d = melonTextView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

