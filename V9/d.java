package v9;

import com.iloen.melon.types.ContextItemType;

public final class d extends ContextItemType {
    public final String R;
    public final String S;

    public d(int v, String s, String s1) {
        super(v, -1, -1, -1, -1);
        this.R = s;
        this.S = s1;
    }

    public d(String s) {
        super(-1, -1, -1, -1, -1);
        this.R = s;
        this.S = null;
    }
}

