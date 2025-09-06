package com.iloen.melon.activity.crop;

import android.graphics.BitmapFactory.Options;

public final class a {
    public int a;
    public BitmapFactory.Options b;

    @Override
    public final String toString() {
        String s;
        int v = this.a;
        if(v == 1) {
            s = "Cancel";
        }
        else {
            s = v == 2 ? "Allow" : "?";
        }
        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("thread state = ", s, ", options = ");
        stringBuilder0.append(this.b);
        return stringBuilder0.toString();
    }
}

