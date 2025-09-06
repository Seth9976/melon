package com.google.gson;

import W7.b;
import com.google.gson.internal.bind.X;
import com.google.gson.internal.bind.f;
import java.io.IOException;
import java.io.StringWriter;

public abstract class q {
    public String b() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    @Override
    public final String toString() {
        try {
            StringWriter stringWriter0 = new StringWriter();
            b b0 = new b(stringWriter0);
            b0.h = 1;
            X.z.getClass();
            f.e(b0, this);
            return stringWriter0.toString();
        }
        catch(IOException iOException0) {
            throw new AssertionError(iOException0);
        }
    }
}

