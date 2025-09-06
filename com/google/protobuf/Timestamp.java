package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Timestamp extends A1 implements m2 {
    private static final Timestamp DEFAULT_INSTANCE = null;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static volatile z2 PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private int nanos_;
    private long seconds_;

    static {
        Timestamp timestamp0 = new Timestamp();
        Timestamp.DEFAULT_INSTANCE = timestamp0;
        A1.registerDefaultInstance(Timestamp.class, timestamp0);
    }

    public static void access$100(Timestamp timestamp0, long v) {
        timestamp0.setSeconds(v);
    }

    public static void access$200(Timestamp timestamp0) {
        timestamp0.clearSeconds();
    }

    public static void access$300(Timestamp timestamp0, int v) {
        timestamp0.setNanos(v);
    }

    public static void access$400(Timestamp timestamp0) {
        timestamp0.clearNanos();
    }

    private void clearNanos() {
        this.nanos_ = 0;
    }

    private void clearSeconds() {
        this.seconds_ = 0L;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Timestamp.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"seconds_", "nanos_"});
            }
            case 3: {
                return new Timestamp();
            }
            case 4: {
                return new N2(Timestamp.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Timestamp.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Timestamp.PARSER;
                if(z20 == null) {
                    Class class0 = Timestamp.class;
                    synchronized(class0) {
                        z2 z21 = Timestamp.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Timestamp.PARSER = z21;
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

    public static Timestamp getDefaultInstance() {
        return Timestamp.DEFAULT_INSTANCE;
    }

    public int getNanos() {
        return this.nanos_;
    }

    public long getSeconds() {
        return this.seconds_;
    }

    public static N2 newBuilder() {
        return (N2)Timestamp.DEFAULT_INSTANCE.createBuilder();
    }

    public static N2 newBuilder(Timestamp timestamp0) {
        return (N2)Timestamp.DEFAULT_INSTANCE.createBuilder(timestamp0);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream0) {
        return (Timestamp)A1.parseDelimitedFrom(Timestamp.DEFAULT_INSTANCE, inputStream0);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Timestamp)A1.parseDelimitedFrom(Timestamp.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Timestamp parseFrom(o o0) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, o0);
    }

    public static Timestamp parseFrom(o o0, g1 g10) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, o0, g10);
    }

    public static Timestamp parseFrom(t t0) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, t0);
    }

    public static Timestamp parseFrom(t t0, g1 g10) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, t0, g10);
    }

    public static Timestamp parseFrom(InputStream inputStream0) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, inputStream0);
    }

    public static Timestamp parseFrom(InputStream inputStream0, g1 g10) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer0) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Timestamp parseFrom(byte[] arr_b) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, arr_b);
    }

    public static Timestamp parseFrom(byte[] arr_b, g1 g10) {
        return (Timestamp)A1.parseFrom(Timestamp.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Timestamp.DEFAULT_INSTANCE.getParserForType();
    }

    private void setNanos(int v) {
        this.nanos_ = v;
    }

    private void setSeconds(long v) {
        this.seconds_ = v;
    }
}

