package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Mixin extends A1 implements t2 {
    private static final Mixin DEFAULT_INSTANCE = null;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile z2 PARSER = null;
    public static final int ROOT_FIELD_NUMBER = 2;
    private String name_;
    private String root_;

    static {
        Mixin mixin0 = new Mixin();
        Mixin.DEFAULT_INSTANCE = mixin0;
        A1.registerDefaultInstance(Mixin.class, mixin0);
    }

    private Mixin() {
        this.name_ = "";
        this.root_ = "";
    }

    public static void access$100(Mixin mixin0, String s) {
        mixin0.setName(s);
    }

    public static void access$200(Mixin mixin0) {
        mixin0.clearName();
    }

    public static void access$300(Mixin mixin0, o o0) {
        mixin0.setNameBytes(o0);
    }

    public static void access$400(Mixin mixin0, String s) {
        mixin0.setRoot(s);
    }

    public static void access$500(Mixin mixin0) {
        mixin0.clearRoot();
    }

    public static void access$600(Mixin mixin0, o o0) {
        mixin0.setRootBytes(o0);
    }

    private void clearName() {
        this.name_ = "";
    }

    private void clearRoot() {
        this.root_ = "";
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(Mixin.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "root_"});
            }
            case 3: {
                return new Mixin();
            }
            case 4: {
                return new s2(Mixin.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return Mixin.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = Mixin.PARSER;
                if(z20 == null) {
                    Class class0 = Mixin.class;
                    synchronized(class0) {
                        z2 z21 = Mixin.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            Mixin.PARSER = z21;
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

    public static Mixin getDefaultInstance() {
        return Mixin.DEFAULT_INSTANCE;
    }

    public String getName() [...] // 潜在的解密器

    public o getNameBytes() {
        return o.e(this.name_);
    }

    public String getRoot() [...] // 潜在的解密器

    public o getRootBytes() {
        return o.e(this.root_);
    }

    public static s2 newBuilder() {
        return (s2)Mixin.DEFAULT_INSTANCE.createBuilder();
    }

    public static s2 newBuilder(Mixin mixin0) {
        return (s2)Mixin.DEFAULT_INSTANCE.createBuilder(mixin0);
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream0) {
        return (Mixin)A1.parseDelimitedFrom(Mixin.DEFAULT_INSTANCE, inputStream0);
    }

    public static Mixin parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (Mixin)A1.parseDelimitedFrom(Mixin.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Mixin parseFrom(o o0) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, o0);
    }

    public static Mixin parseFrom(o o0, g1 g10) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, o0, g10);
    }

    public static Mixin parseFrom(t t0) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, t0);
    }

    public static Mixin parseFrom(t t0, g1 g10) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, t0, g10);
    }

    public static Mixin parseFrom(InputStream inputStream0) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, inputStream0);
    }

    public static Mixin parseFrom(InputStream inputStream0, g1 g10) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static Mixin parseFrom(ByteBuffer byteBuffer0) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static Mixin parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static Mixin parseFrom(byte[] arr_b) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, arr_b);
    }

    public static Mixin parseFrom(byte[] arr_b, g1 g10) {
        return (Mixin)A1.parseFrom(Mixin.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return Mixin.DEFAULT_INSTANCE.getParserForType();
    }

    private void setName(String s) {
        s.getClass();
        this.name_ = s;
    }

    private void setNameBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.name_ = o0.p();
    }

    private void setRoot(String s) {
        s.getClass();
        this.root_ = s;
    }

    private void setRootBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.root_ = o0.p();
    }
}

