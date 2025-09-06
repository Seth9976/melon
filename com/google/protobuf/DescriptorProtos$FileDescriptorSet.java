package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.FileDescriptorSet extends GeneratedMessageLite.ExtendableMessage {
    private static final DescriptorProtos.FileDescriptorSet DEFAULT_INSTANCE = null;
    public static final int FILE_FIELD_NUMBER = 1;
    private static volatile z2 PARSER;
    private O1 file_;
    private byte memoizedIsInitialized;

    static {
        DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0 = new DescriptorProtos.FileDescriptorSet();
        DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE = descriptorProtos$FileDescriptorSet0;
        A1.registerDefaultInstance(DescriptorProtos.FileDescriptorSet.class, descriptorProtos$FileDescriptorSet0);
    }

    private DescriptorProtos.FileDescriptorSet() {
        this.memoizedIsInitialized = 2;
        this.file_ = A1.emptyProtobufList();
    }

    public static void access$100(DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0, int v, DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorSet0.setFile(v, descriptorProtos$FileDescriptorProto0);
    }

    public static void access$200(DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0, DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorSet0.addFile(descriptorProtos$FileDescriptorProto0);
    }

    public static void access$300(DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0, int v, DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorSet0.addFile(v, descriptorProtos$FileDescriptorProto0);
    }

    public static void access$400(DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0, Iterable iterable0) {
        descriptorProtos$FileDescriptorSet0.addAllFile(iterable0);
    }

    public static void access$500(DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0) {
        descriptorProtos$FileDescriptorSet0.clearFile();
    }

    public static void access$600(DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0, int v) {
        descriptorProtos$FileDescriptorSet0.removeFile(v);
    }

    private void addAllFile(Iterable iterable0) {
        this.ensureFileIsMutable();
        b.addAll(iterable0, this.file_);
    }

    private void addFile(int v, DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.getClass();
        this.ensureFileIsMutable();
        this.file_.add(v, descriptorProtos$FileDescriptorProto0);
    }

    private void addFile(DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.getClass();
        this.ensureFileIsMutable();
        this.file_.add(descriptorProtos$FileDescriptorProto0);
    }

    private void clearFile() {
        this.file_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return this.memoizedIsInitialized;
            }
            case 1: {
                this.memoizedIsInitialized = (byte)(object0 == null ? 0 : 1);
                return null;
            }
            case 2: {
                return A1.newMessageInfo(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"file_", DescriptorProtos.FileDescriptorProto.class});
            }
            case 3: {
                return new DescriptorProtos.FileDescriptorSet();
            }
            case 4: {
                return new v0(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.FileDescriptorSet.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.FileDescriptorSet.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.FileDescriptorSet.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.FileDescriptorSet.PARSER = z21;
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

    private void ensureFileIsMutable() {
        O1 o10 = this.file_;
        if(!((c)o10).a) {
            this.file_ = A1.mutableCopy(o10);
        }
    }

    public static DescriptorProtos.FileDescriptorSet getDefaultInstance() {
        return DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE;
    }

    public DescriptorProtos.FileDescriptorProto getFile(int v) {
        return (DescriptorProtos.FileDescriptorProto)this.file_.get(v);
    }

    public int getFileCount() {
        return this.file_.size();
    }

    public List getFileList() {
        return this.file_;
    }

    public u0 getFileOrBuilder(int v) {
        return (u0)this.file_.get(v);
    }

    public List getFileOrBuilderList() {
        return this.file_;
    }

    public static v0 newBuilder() {
        return (v0)DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE.createBuilder();
    }

    public static v0 newBuilder(DescriptorProtos.FileDescriptorSet descriptorProtos$FileDescriptorSet0) {
        return (v0)DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FileDescriptorSet0);
    }

    public static DescriptorProtos.FileDescriptorSet parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseDelimitedFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FileDescriptorSet parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseDelimitedFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(o o0) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(t t0) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(byte[] arr_b) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.FileDescriptorSet parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.FileDescriptorSet)A1.parseFrom(DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.FileDescriptorSet.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFile(int v) {
        this.ensureFileIsMutable();
        this.file_.remove(v);
    }

    private void setFile(int v, DescriptorProtos.FileDescriptorProto descriptorProtos$FileDescriptorProto0) {
        descriptorProtos$FileDescriptorProto0.getClass();
        this.ensureFileIsMutable();
        this.file_.set(v, descriptorProtos$FileDescriptorProto0);
    }
}

