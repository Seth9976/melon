package io.netty.buffer;

import H0.b;
import io.netty.util.ResourceLeakDetector.Level;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public abstract class AbstractByteBufAllocator implements ByteBufAllocator {
    static final int CALCULATE_THRESHOLD = 0x400000;
    static final int DEFAULT_INITIAL_CAPACITY = 0x100;
    static final int DEFAULT_MAX_CAPACITY = 0x7FFFFFFF;
    static final int DEFAULT_MAX_COMPONENTS = 16;
    private final boolean directByDefault;
    private final ByteBuf emptyBuf;

    static {
        ResourceLeakDetector.addExclusions(AbstractByteBufAllocator.class, new String[]{"toLeakAwareBuffer"});
    }

    public AbstractByteBufAllocator() {
        this(false);
    }

    public AbstractByteBufAllocator(boolean z) {
        this.directByDefault = z;
        this.emptyBuf = new EmptyByteBuf(this);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer() {
        return this.directByDefault ? this.directBuffer() : this.heapBuffer();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int v) {
        return this.directByDefault ? this.directBuffer(v) : this.heapBuffer(v);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf buffer(int v, int v1) {
        return this.directByDefault ? this.directBuffer(v, v1) : this.heapBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public int calculateNewCapacity(int v, int v1) {
        ObjectUtil.checkPositiveOrZero(v, "minNewCapacity");
        if(v > v1) {
            throw new IllegalArgumentException(String.format("minNewCapacity: %d (expected: not greater than maxCapacity(%d)", v, v1));
        }
        if(v == 0x400000) {
            return 0x400000;
        }
        if(v > 0x400000) {
            int v2 = v / 0x400000 * 0x400000;
            return v2 <= v1 - 0x400000 ? v2 + 0x400000 : v1;
        }
        return Math.min(MathUtil.findNextPositivePowerOfTwo(Math.max(v, 0x40)), v1);
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer() {
        return this.directByDefault ? this.compositeDirectBuffer() : this.compositeHeapBuffer();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeBuffer(int v) {
        return this.directByDefault ? this.compositeDirectBuffer(v) : this.compositeHeapBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer() {
        return this.compositeDirectBuffer(16);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int v) {
        return AbstractByteBufAllocator.toLeakAwareBuffer(new CompositeByteBuf(this, true, v));
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer() {
        return this.compositeHeapBuffer(16);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int v) {
        return AbstractByteBufAllocator.toLeakAwareBuffer(new CompositeByteBuf(this, false, v));
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer() {
        return this.directBuffer(0x100, 0x7FFFFFFF);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int v) {
        return this.directBuffer(v, 0x7FFFFFFF);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf directBuffer(int v, int v1) {
        if(v == 0 && v1 == 0) {
            return this.emptyBuf;
        }
        AbstractByteBufAllocator.validate(v, v1);
        return this.newDirectBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer() {
        return this.heapBuffer(0x100, 0x7FFFFFFF);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int v) {
        return this.heapBuffer(v, 0x7FFFFFFF);
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf heapBuffer(int v, int v1) {
        if(v == 0 && v1 == 0) {
            return this.emptyBuf;
        }
        AbstractByteBufAllocator.validate(v, v1);
        return this.newHeapBuffer(v, v1);
    }

    // 去混淆评级： 低(40)
    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer() {
        return this.directBuffer(0x100);
    }

    // 去混淆评级： 低(40)
    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int v) {
        return this.directBuffer(v);
    }

    // 去混淆评级： 低(40)
    @Override  // io.netty.buffer.ByteBufAllocator
    public ByteBuf ioBuffer(int v, int v1) {
        return this.directBuffer(v, v1);
    }

    public abstract ByteBuf newDirectBuffer(int arg1, int arg2);

    public abstract ByteBuf newHeapBuffer(int arg1, int arg2);

    public static ByteBuf toLeakAwareBuffer(ByteBuf byteBuf0) {
        switch(io.netty.buffer.AbstractByteBufAllocator.1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()]) {
            case 1: {
                ResourceLeakTracker resourceLeakTracker0 = AbstractByteBuf.leakDetector.track(byteBuf0);
                if(resourceLeakTracker0 != null) {
                    return new SimpleLeakAwareByteBuf(byteBuf0, resourceLeakTracker0);
                }
                break;
            }
            case 2: 
            case 3: {
                ResourceLeakTracker resourceLeakTracker1 = AbstractByteBuf.leakDetector.track(byteBuf0);
                if(resourceLeakTracker1 != null) {
                    return new AdvancedLeakAwareByteBuf(byteBuf0, resourceLeakTracker1);
                }
                break;
            }
            default: {
                return byteBuf0;
            }
        }
        return byteBuf0;
    }

    public static CompositeByteBuf toLeakAwareBuffer(CompositeByteBuf compositeByteBuf0) {
        switch(io.netty.buffer.AbstractByteBufAllocator.1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[ResourceLeakDetector.getLevel().ordinal()]) {
            case 1: {
                ResourceLeakTracker resourceLeakTracker0 = AbstractByteBuf.leakDetector.track(compositeByteBuf0);
                if(resourceLeakTracker0 != null) {
                    return new SimpleLeakAwareCompositeByteBuf(compositeByteBuf0, resourceLeakTracker0);
                }
                break;
            }
            case 2: 
            case 3: {
                ResourceLeakTracker resourceLeakTracker1 = AbstractByteBuf.leakDetector.track(compositeByteBuf0);
                if(resourceLeakTracker1 != null) {
                    return new AdvancedLeakAwareCompositeByteBuf(compositeByteBuf0, resourceLeakTracker1);
                }
                break;
            }
            default: {
                return compositeByteBuf0;
            }
        }
        return compositeByteBuf0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(StringUtil.simpleClassName(this));
        stringBuilder0.append("(directByDefault: ");
        return b.k(stringBuilder0, this.directByDefault, ')');
    }

    private static void validate(int v, int v1) {
        ObjectUtil.checkPositiveOrZero(v, "initialCapacity");
        if(v > v1) {
            throw new IllegalArgumentException(String.format("initialCapacity: %d (expected: not greater than maxCapacity(%d)", v, v1));
        }
    }

    class io.netty.buffer.AbstractByteBufAllocator.1 {
        static final int[] $SwitchMap$io$netty$util$ResourceLeakDetector$Level;

        static {
            int[] arr_v = new int[Level.values().length];
            io.netty.buffer.AbstractByteBufAllocator.1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level = arr_v;
            try {
                arr_v[Level.SIMPLE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.buffer.AbstractByteBufAllocator.1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[Level.ADVANCED.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.buffer.AbstractByteBufAllocator.1.$SwitchMap$io$netty$util$ResourceLeakDetector$Level[Level.PARANOID.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

