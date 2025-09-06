package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SourceContext extends A1 implements m2 {
    private static final SourceContext DEFAULT_INSTANCE = null;
    public static final int FILE_NAME_FIELD_NUMBER = 1;
    private static volatile z2 PARSER;
    private String fileName_;

    static {
        SourceContext sourceContext0 = new SourceContext();
        SourceContext.DEFAULT_INSTANCE = sourceContext0;
        A1.registerDefaultInstance(SourceContext.class, sourceContext0);
    }

    private SourceContext() {
        this.fileName_ = "";
    }

    public static void access$100(SourceContext sourceContext0, String s) {
        sourceContext0.setFileName(s);
    }

    public static void access$200(SourceContext sourceContext0) {
        sourceContext0.clearFileName();
    }

    public static void access$300(SourceContext sourceContext0, o o0) {
        sourceContext0.setFileNameBytes(o0);
    }

    private void clearFileName() {
        this.fileName_ = "";
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(SourceContext.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"fileName_"});
            }
            case 3: {
                return new SourceContext();
            }
            case 4: {
                return new I2(SourceContext.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return SourceContext.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = SourceContext.PARSER;
                if(z20 == null) {
                    Class class0 = SourceContext.class;
                    synchronized(class0) {
                        z2 z21 = SourceContext.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            SourceContext.PARSER = z21;
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

    public static SourceContext getDefaultInstance() {
        return SourceContext.DEFAULT_INSTANCE;
    }

    public String getFileName() [...] // 潜在的解密器

    public o getFileNameBytes() {
        return o.e(this.fileName_);
    }

    public static I2 newBuilder() {
        return (I2)SourceContext.DEFAULT_INSTANCE.createBuilder();
    }

    public static I2 newBuilder(SourceContext sourceContext0) {
        return (I2)SourceContext.DEFAULT_INSTANCE.createBuilder(sourceContext0);
    }

    public static SourceContext parseDelimitedFrom(InputStream inputStream0) {
        return (SourceContext)A1.parseDelimitedFrom(SourceContext.DEFAULT_INSTANCE, inputStream0);
    }

    public static SourceContext parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (SourceContext)A1.parseDelimitedFrom(SourceContext.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static SourceContext parseFrom(o o0) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, o0);
    }

    public static SourceContext parseFrom(o o0, g1 g10) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, o0, g10);
    }

    public static SourceContext parseFrom(t t0) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, t0);
    }

    public static SourceContext parseFrom(t t0, g1 g10) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, t0, g10);
    }

    public static SourceContext parseFrom(InputStream inputStream0) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, inputStream0);
    }

    public static SourceContext parseFrom(InputStream inputStream0, g1 g10) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static SourceContext parseFrom(ByteBuffer byteBuffer0) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static SourceContext parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static SourceContext parseFrom(byte[] arr_b) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, arr_b);
    }

    public static SourceContext parseFrom(byte[] arr_b, g1 g10) {
        return (SourceContext)A1.parseFrom(SourceContext.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return SourceContext.DEFAULT_INSTANCE.getParserForType();
    }

    private void setFileName(String s) {
        s.getClass();
        this.fileName_ = s;
    }

    private void setFileNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.fileName_ = o0.p();
    }
}

