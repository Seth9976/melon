package io.netty.util;

public final class AttributeKey extends AbstractConstant {
    private static final ConstantPool pool;

    static {
        AttributeKey.pool = new ConstantPool() {
            public AttributeKey newConstant(int v, String s) {
                return new AttributeKey(v, s, null);
            }

            @Override  // io.netty.util.ConstantPool
            public Constant newConstant(int v, String s) {
                return this.newConstant(v, s);
            }
        };
    }

    private AttributeKey(int v, String s) {
        super(v, s);
    }

    public AttributeKey(int v, String s, io.netty.util.AttributeKey.1 attributeKey$10) {
        this(v, s);
    }

    public static boolean exists(String s) {
        return AttributeKey.pool.exists(s);
    }

    public static AttributeKey newInstance(String s) {
        return (AttributeKey)AttributeKey.pool.newInstance(s);
    }

    public static AttributeKey valueOf(Class class0, String s) {
        return (AttributeKey)AttributeKey.pool.valueOf(class0, s);
    }

    public static AttributeKey valueOf(String s) {
        return (AttributeKey)AttributeKey.pool.valueOf(s);
    }
}

