package c1;

import java.text.BreakIterator;
import ye.a;

public final class c extends a {
    public final BreakIterator m;

    public c(CharSequence charSequence0) {
        BreakIterator breakIterator0 = BreakIterator.getCharacterInstance();
        breakIterator0.setText(charSequence0.toString());
        this.m = breakIterator0;
    }

    @Override  // ye.a
    public final int P(int v) {
        return this.m.following(v);
    }

    @Override  // ye.a
    public final int Q(int v) {
        return this.m.preceding(v);
    }
}

