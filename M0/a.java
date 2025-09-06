package m0;

import java.util.concurrent.atomic.AtomicInteger;

public final class a extends AtomicInteger {
    @Override
    public final byte byteValue() {
        return (byte)super.intValue();
    }

    @Override
    public final short shortValue() {
        return (short)super.intValue();
    }
}

