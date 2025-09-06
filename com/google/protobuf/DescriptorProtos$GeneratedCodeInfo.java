package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.GeneratedCodeInfo extends A1 implements m2 {
    public static final class Annotation extends A1 implements B0 {
        public static final int BEGIN_FIELD_NUMBER = 3;
        private static final Annotation DEFAULT_INSTANCE = null;
        public static final int END_FIELD_NUMBER = 4;
        private static volatile z2 PARSER = null;
        public static final int PATH_FIELD_NUMBER = 1;
        public static final int SEMANTIC_FIELD_NUMBER = 5;
        public static final int SOURCE_FILE_FIELD_NUMBER = 2;
        private int begin_;
        private int bitField0_;
        private int end_;
        private int pathMemoizedSerializedSize;
        private K1 path_;
        private int semantic_;
        private String sourceFile_;

        static {
            Annotation descriptorProtos$GeneratedCodeInfo$Annotation0 = new Annotation();
            Annotation.DEFAULT_INSTANCE = descriptorProtos$GeneratedCodeInfo$Annotation0;
            A1.registerDefaultInstance(Annotation.class, descriptorProtos$GeneratedCodeInfo$Annotation0);
        }

        private Annotation() {
            this.pathMemoizedSerializedSize = -1;
            this.path_ = A1.emptyIntList();
            this.sourceFile_ = "";
        }

        public static void access$60200(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, int v, int v1) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.setPath(v, v1);
        }

        public static void access$60300(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, int v) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.addPath(v);
        }

        public static void access$60400(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, Iterable iterable0) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.addAllPath(iterable0);
        }

        public static void access$60500(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.clearPath();
        }

        public static void access$60600(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, String s) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.setSourceFile(s);
        }

        public static void access$60700(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.clearSourceFile();
        }

        public static void access$60800(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, o o0) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.setSourceFileBytes(o0);
        }

        public static void access$60900(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, int v) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.setBegin(v);
        }

        public static void access$61000(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.clearBegin();
        }

        public static void access$61100(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, int v) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.setEnd(v);
        }

        public static void access$61200(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.clearEnd();
        }

        public static void access$61300(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0, A0 a00) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.setSemantic(a00);
        }

        public static void access$61400(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
            descriptorProtos$GeneratedCodeInfo$Annotation0.clearSemantic();
        }

        private void addAllPath(Iterable iterable0) {
            this.ensurePathIsMutable();
            b.addAll(iterable0, this.path_);
        }

        private void addPath(int v) {
            this.ensurePathIsMutable();
            ((D1)this.path_).d(v);
        }

        private void clearBegin() {
            this.bitField0_ &= -3;
            this.begin_ = 0;
        }

        private void clearEnd() {
            this.bitField0_ &= -5;
            this.end_ = 0;
        }

        private void clearPath() {
            this.path_ = A1.emptyIntList();
        }

        private void clearSemantic() {
            this.bitField0_ &= -9;
            this.semantic_ = 0;
        }

        private void clearSourceFile() {
            this.bitField0_ &= -2;
            this.sourceFile_ = "";
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            z2 z21;
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(Annotation.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\'\u0002ဈ\u0000\u0003င\u0001\u0004င\u0002\u0005᠌\u0003", new Object[]{"bitField0_", "path_", "sourceFile_", "begin_", "end_", "semantic_", z0.a});
                }
                case 3: {
                    return new Annotation();
                }
                case 4: {
                    return new y0(Annotation.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return Annotation.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = Annotation.PARSER;
                    if(z20 == null) {
                        synchronized(Annotation.class) {
                            z21 = Annotation.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                Annotation.PARSER = z21;
                            }
                        }
                        return z21;
                    }
                    return z20;
                }
                default: {
                    throw null;
                }
            }
        }

        private void ensurePathIsMutable() {
            K1 k10 = this.path_;
            if(!((c)k10).a) {
                this.path_ = A1.mutableCopy(k10);
            }
        }

        public int getBegin() {
            return this.begin_;
        }

        public static Annotation getDefaultInstance() {
            return Annotation.DEFAULT_INSTANCE;
        }

        public int getEnd() {
            return this.end_;
        }

        public int getPath(int v) {
            return ((D1)this.path_).f(v);
        }

        public int getPathCount() {
            return this.path_.size();
        }

        public List getPathList() {
            return this.path_;
        }

        public A0 getSemantic() {
            A0 a00 = A0.b(this.semantic_);
            return a00 == null ? A0.b : a00;
        }

        public String getSourceFile() [...] // 潜在的解密器

        public o getSourceFileBytes() {
            return o.e(this.sourceFile_);
        }

        public boolean hasBegin() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasEnd() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasSemantic() {
            return (this.bitField0_ & 8) != 0;
        }

        public boolean hasSourceFile() {
            return (this.bitField0_ & 1) != 0;
        }

        public static y0 newBuilder() {
            return (y0)Annotation.DEFAULT_INSTANCE.createBuilder();
        }

        public static y0 newBuilder(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
            return (y0)Annotation.DEFAULT_INSTANCE.createBuilder(descriptorProtos$GeneratedCodeInfo$Annotation0);
        }

        public static Annotation parseDelimitedFrom(InputStream inputStream0) {
            return (Annotation)A1.parseDelimitedFrom(Annotation.DEFAULT_INSTANCE, inputStream0);
        }

        public static Annotation parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (Annotation)A1.parseDelimitedFrom(Annotation.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static Annotation parseFrom(o o0) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, o0);
        }

        public static Annotation parseFrom(o o0, g1 g10) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, o0, g10);
        }

        public static Annotation parseFrom(t t0) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, t0);
        }

        public static Annotation parseFrom(t t0, g1 g10) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, t0, g10);
        }

        public static Annotation parseFrom(InputStream inputStream0) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, inputStream0);
        }

        public static Annotation parseFrom(InputStream inputStream0, g1 g10) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static Annotation parseFrom(ByteBuffer byteBuffer0) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static Annotation parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static Annotation parseFrom(byte[] arr_b) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, arr_b);
        }

        public static Annotation parseFrom(byte[] arr_b, g1 g10) {
            return (Annotation)A1.parseFrom(Annotation.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return Annotation.DEFAULT_INSTANCE.getParserForType();
        }

        private void setBegin(int v) {
            this.bitField0_ |= 2;
            this.begin_ = v;
        }

        private void setEnd(int v) {
            this.bitField0_ |= 4;
            this.end_ = v;
        }

        private void setPath(int v, int v1) {
            this.ensurePathIsMutable();
            ((D1)this.path_).i(v, v1);
        }

        private void setSemantic(A0 a00) {
            this.semantic_ = a00.a;
            this.bitField0_ |= 8;
        }

        private void setSourceFile(String s) {
            s.getClass();
            this.bitField0_ |= 1;
            this.sourceFile_ = s;
        }

        private void setSourceFileBytes(o o0) {
            this.sourceFile_ = o0.p();
            this.bitField0_ |= 1;
        }
    }

    public static final int ANNOTATION_FIELD_NUMBER = 1;
    private static final DescriptorProtos.GeneratedCodeInfo DEFAULT_INSTANCE;
    private static volatile z2 PARSER;
    private O1 annotation_;

    static {
        DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0 = new DescriptorProtos.GeneratedCodeInfo();
        DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE = descriptorProtos$GeneratedCodeInfo0;
        A1.registerDefaultInstance(DescriptorProtos.GeneratedCodeInfo.class, descriptorProtos$GeneratedCodeInfo0);
    }

    private DescriptorProtos.GeneratedCodeInfo() {
        this.annotation_ = A1.emptyProtobufList();
    }

    public static void access$61700(DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0, int v, Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
        descriptorProtos$GeneratedCodeInfo0.setAnnotation(v, descriptorProtos$GeneratedCodeInfo$Annotation0);
    }

    public static void access$61800(DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0, Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
        descriptorProtos$GeneratedCodeInfo0.addAnnotation(descriptorProtos$GeneratedCodeInfo$Annotation0);
    }

    public static void access$61900(DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0, int v, Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
        descriptorProtos$GeneratedCodeInfo0.addAnnotation(v, descriptorProtos$GeneratedCodeInfo$Annotation0);
    }

    public static void access$62000(DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0, Iterable iterable0) {
        descriptorProtos$GeneratedCodeInfo0.addAllAnnotation(iterable0);
    }

    public static void access$62100(DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0) {
        descriptorProtos$GeneratedCodeInfo0.clearAnnotation();
    }

    public static void access$62200(DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0, int v) {
        descriptorProtos$GeneratedCodeInfo0.removeAnnotation(v);
    }

    private void addAllAnnotation(Iterable iterable0) {
        this.ensureAnnotationIsMutable();
        b.addAll(iterable0, this.annotation_);
    }

    private void addAnnotation(int v, Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
        descriptorProtos$GeneratedCodeInfo$Annotation0.getClass();
        this.ensureAnnotationIsMutable();
        this.annotation_.add(v, descriptorProtos$GeneratedCodeInfo$Annotation0);
    }

    private void addAnnotation(Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
        descriptorProtos$GeneratedCodeInfo$Annotation0.getClass();
        this.ensureAnnotationIsMutable();
        this.annotation_.add(descriptorProtos$GeneratedCodeInfo$Annotation0);
    }

    private void clearAnnotation() {
        this.annotation_ = A1.emptyProtobufList();
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001B", new Object[]{"annotation_", Annotation.class});
            }
            case 3: {
                return new DescriptorProtos.GeneratedCodeInfo();
            }
            case 4: {
                return new C0(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.GeneratedCodeInfo.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.GeneratedCodeInfo.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.GeneratedCodeInfo.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.GeneratedCodeInfo.PARSER = z21;
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

    private void ensureAnnotationIsMutable() {
        O1 o10 = this.annotation_;
        if(!((c)o10).a) {
            this.annotation_ = A1.mutableCopy(o10);
        }
    }

    public Annotation getAnnotation(int v) {
        return (Annotation)this.annotation_.get(v);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List getAnnotationList() {
        return this.annotation_;
    }

    public B0 getAnnotationOrBuilder(int v) {
        return (B0)this.annotation_.get(v);
    }

    public List getAnnotationOrBuilderList() {
        return this.annotation_;
    }

    public static DescriptorProtos.GeneratedCodeInfo getDefaultInstance() {
        return DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE;
    }

    public static C0 newBuilder() {
        return (C0)DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static C0 newBuilder(DescriptorProtos.GeneratedCodeInfo descriptorProtos$GeneratedCodeInfo0) {
        return (C0)DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE.createBuilder(descriptorProtos$GeneratedCodeInfo0);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseDelimitedFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseDelimitedFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(o o0) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(t t0) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(byte[] arr_b) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.GeneratedCodeInfo parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.GeneratedCodeInfo)A1.parseFrom(DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.GeneratedCodeInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeAnnotation(int v) {
        this.ensureAnnotationIsMutable();
        this.annotation_.remove(v);
    }

    private void setAnnotation(int v, Annotation descriptorProtos$GeneratedCodeInfo$Annotation0) {
        descriptorProtos$GeneratedCodeInfo$Annotation0.getClass();
        this.ensureAnnotationIsMutable();
        this.annotation_.set(v, descriptorProtos$GeneratedCodeInfo$Annotation0);
    }
}

