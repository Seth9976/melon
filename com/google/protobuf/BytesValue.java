package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class BytesValue extends A1 implements m2 {
    private static final BytesValue DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private o value_;

    static {
        BytesValue bytesValue0 = new BytesValue();
        BytesValue.DEFAULT_INSTANCE = bytesValue0;
        A1.registerDefaultInstance(BytesValue.class, bytesValue0);
    }

    private BytesValue() {
        this.value_ = o.b;
    }

    public static void access$200(BytesValue bytesValue0) {
        bytesValue0.clearValue();
    }

    private void clearValue() {
        this.value_ = BytesValue.getDefaultInstance().getValue();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(BytesValue.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"value_"});
            }
            case 3: {
                return new BytesValue();
            }
            case 4: {
                return new p(BytesValue.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return BytesValue.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = BytesValue.PARSER;
                if(z20 == null) {
                    Class class0 = BytesValue.class;
                    synchronized(class0) {
                        z2 z21 = BytesValue.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            BytesValue.PARSER = z21;
                        }
                        return z21;
                    }
                }
                return z20;
            }
            default: {
                throw null;
            }
        }
    }

    public static BytesValue getDefaultInstance() {
        return BytesValue.DEFAULT_INSTANCE;
    }

    public o getValue() {
        return this.value_;
    }

    public static p newBuilder() {
        return (p)BytesValue.DEFAULT_INSTANCE.createBuilder();
    }

    public static p newBuilder(BytesValue bytesValue0) {
        return (p)BytesValue.DEFAULT_INSTANCE.createBuilder(bytesValue0);
    }

    public static BytesValue of(o o0) {
        p p0 = BytesValue.newBuilder();
        p0.d();
        ((BytesValue)p0.b).setValue(o0);
        return (BytesValue)p0.a();
    }

    public static BytesValue parseDelimitedFrom(InputStream inputStream0) {
        return (BytesValue)A1.parseDelimitedFrom(BytesValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static BytesValue parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (BytesValue)A1.parseDelimitedFrom(BytesValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static BytesValue parseFrom(o o0) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, o0);
    }

    public static BytesValue parseFrom(o o0, g1 g10) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, o0, g10);
    }

    public static BytesValue parseFrom(t t0) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, t0);
    }

    public static BytesValue parseFrom(t t0, g1 g10) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, t0, g10);
    }

    public static BytesValue parseFrom(InputStream inputStream0) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, inputStream0);
    }

    public static BytesValue parseFrom(InputStream inputStream0, g1 g10) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static BytesValue parseFrom(ByteBuffer byteBuffer0) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static BytesValue parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static BytesValue parseFrom(byte[] arr_b) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, arr_b);
    }

    public static BytesValue parseFrom(byte[] arr_b, g1 g10) {
        return (BytesValue)A1.parseFrom(BytesValue.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return BytesValue.DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(o o0) {
        o0.getClass();
        this.value_ = o0;
    }
}

