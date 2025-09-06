package y;

import U4.x;

public class e extends Exception {
    public e(String s, d d0) {
        StringBuilder stringBuilder0 = x.p(s, ", frames: ");
        stringBuilder0.append(d0.h());
        super(stringBuilder0.toString());
    }

    public e(String s, d d0, Exception exception0) {
        StringBuilder stringBuilder0 = x.p(s, ", frames: ");
        stringBuilder0.append(d0.h());
        super(stringBuilder0.toString(), exception0);
    }
}

