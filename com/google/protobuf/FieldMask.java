package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class FieldMask extends A1 implements m2 {
    private static final FieldMask DEFAULT_INSTANCE = null;
    private static volatile z2 PARSER = null;
    public static final int PATHS_FIELD_NUMBER = 1;
    private O1 paths_;

    static {
        FieldMask fieldMask0 = new FieldMask();
        FieldMask.DEFAULT_INSTANCE = fieldMask0;
        A1.registerDefaultInstance(FieldMask.class, fieldMask0);
    }

    private FieldMask() {
        this.paths_ = A1.emptyProtobufList();
    }

    public static void access$100(FieldMask fieldMask0, int v, String s) {
        fieldMask0.setPaths(v, s);
    }

    public static void access$200(FieldMask fieldMask0, String s) {
        fieldMask0.addPaths(s);
    }

    public static void access$300(FieldMask fieldMask0, Iterable iterable0) {
        fieldMask0.addAllPaths(iterable0);
    }

    public static void access$400(FieldMask fieldMask0) {
        fieldMask0.clearPaths();
    }

    public static void access$500(FieldMask fieldMask0, o o0) {
        fieldMask0.addPathsBytes(o0);
    }

    private void addAllPaths(Iterable iterable0) {
        this.ensurePathsIsMutable();
        b.addAll(iterable0, this.paths_);
    }

    private void addPaths(String s) {
        s.getClass();
        this.ensurePathsIsMutable();
        this.paths_.add(s);
    }

    private void addPathsBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.ensurePathsIsMutable();
        this.paths_.add(o0.p());
    }

    private void clearPaths() {
        this.paths_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(FieldMask.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"paths_"});
            }
            case 3: {
                return new FieldMask();
            }
            case 4: {
                return new m1(FieldMask.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return FieldMask.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = FieldMask.PARSER;
                if(z20 == null) {
                    Class class0 = FieldMask.class;
                    synchronized(class0) {
                        z2 z21 = FieldMask.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            FieldMask.PARSER = z21;
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

    private void ensurePathsIsMutable() {
        O1 o10 = this.paths_;
        if(!((c)o10).a) {
            this.paths_ = A1.mutableCopy(o10);
        }
    }

    public static FieldMask getDefaultInstance() {
        return FieldMask.DEFAULT_INSTANCE;
    }

    public String getPaths(int v) {
        return (String)this.paths_.get(v);
    }

    public o getPathsBytes(int v) {
        return o.e(((String)this.paths_.get(v)));
    }

    public int getPathsCount() {
        return this.paths_.size();
    }

    public List getPathsList() {
        return this.paths_;
    }

    public static m1 newBuilder() {
        return (m1)FieldMask.DEFAULT_INSTANCE.createBuilder();
    }

    public static m1 newBuilder(FieldMask fieldMask0) {
        return (m1)FieldMask.DEFAULT_INSTANCE.createBuilder(fieldMask0);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream0) {
        return (FieldMask)A1.parseDelimitedFrom(FieldMask.DEFAULT_INSTANCE, inputStream0);
    }

    public static FieldMask parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (FieldMask)A1.parseDelimitedFrom(FieldMask.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static FieldMask parseFrom(o o0) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, o0);
    }

    public static FieldMask parseFrom(o o0, g1 g10) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, o0, g10);
    }

    public static FieldMask parseFrom(t t0) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, t0);
    }

    public static FieldMask parseFrom(t t0, g1 g10) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, t0, g10);
    }

    public static FieldMask parseFrom(InputStream inputStream0) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, inputStream0);
    }

    public static FieldMask parseFrom(InputStream inputStream0, g1 g10) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer0) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static FieldMask parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static FieldMask parseFrom(byte[] arr_b) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, arr_b);
    }

    public static FieldMask parseFrom(byte[] arr_b, g1 g10) {
        return (FieldMask)A1.parseFrom(FieldMask.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return FieldMask.DEFAULT_INSTANCE.getParserForType();
    }

    private void setPaths(int v, String s) {
        s.getClass();
        this.ensurePathsIsMutable();
        this.paths_.set(v, s);
    }
}

