package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class JavaFeaturesProto.JavaFeatures extends A1 implements m2 {
    public static final class NestInFileClassFeature extends A1 implements m2 {
        private static final NestInFileClassFeature DEFAULT_INSTANCE;
        private static volatile z2 PARSER;

        static {
            NestInFileClassFeature javaFeaturesProto$JavaFeatures$NestInFileClassFeature0 = new NestInFileClassFeature();
            NestInFileClassFeature.DEFAULT_INSTANCE = javaFeaturesProto$JavaFeatures$NestInFileClassFeature0;
            A1.registerDefaultInstance(NestInFileClassFeature.class, javaFeaturesProto$JavaFeatures$NestInFileClassFeature0);
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(NestInFileClassFeature.DEFAULT_INSTANCE, "\u0001\u0000", null);
                }
                case 3: {
                    return new NestInFileClassFeature();
                }
                case 4: {
                    return new T1(NestInFileClassFeature.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return NestInFileClassFeature.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = NestInFileClassFeature.PARSER;
                    if(z20 == null) {
                        Class class0 = NestInFileClassFeature.class;
                        synchronized(class0) {
                            z2 z21 = NestInFileClassFeature.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                NestInFileClassFeature.PARSER = z21;
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

        public static NestInFileClassFeature getDefaultInstance() {
            return NestInFileClassFeature.DEFAULT_INSTANCE;
        }

        public static T1 newBuilder() {
            return (T1)NestInFileClassFeature.DEFAULT_INSTANCE.createBuilder();
        }

        public static T1 newBuilder(NestInFileClassFeature javaFeaturesProto$JavaFeatures$NestInFileClassFeature0) {
            return (T1)NestInFileClassFeature.DEFAULT_INSTANCE.createBuilder(javaFeaturesProto$JavaFeatures$NestInFileClassFeature0);
        }

        public static NestInFileClassFeature parseDelimitedFrom(InputStream inputStream0) {
            return (NestInFileClassFeature)A1.parseDelimitedFrom(NestInFileClassFeature.DEFAULT_INSTANCE, inputStream0);
        }

        public static NestInFileClassFeature parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (NestInFileClassFeature)A1.parseDelimitedFrom(NestInFileClassFeature.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static NestInFileClassFeature parseFrom(o o0) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, o0);
        }

        public static NestInFileClassFeature parseFrom(o o0, g1 g10) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, o0, g10);
        }

        public static NestInFileClassFeature parseFrom(t t0) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, t0);
        }

        public static NestInFileClassFeature parseFrom(t t0, g1 g10) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, t0, g10);
        }

        public static NestInFileClassFeature parseFrom(InputStream inputStream0) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, inputStream0);
        }

        public static NestInFileClassFeature parseFrom(InputStream inputStream0, g1 g10) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static NestInFileClassFeature parseFrom(ByteBuffer byteBuffer0) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static NestInFileClassFeature parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static NestInFileClassFeature parseFrom(byte[] arr_b) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, arr_b);
        }

        public static NestInFileClassFeature parseFrom(byte[] arr_b, g1 g10) {
            return (NestInFileClassFeature)A1.parseFrom(NestInFileClassFeature.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return NestInFileClassFeature.DEFAULT_INSTANCE.getParserForType();
        }
    }

    private static final JavaFeaturesProto.JavaFeatures DEFAULT_INSTANCE = null;
    public static final int LARGE_ENUM_FIELD_NUMBER = 3;
    public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
    public static final int NEST_IN_FILE_CLASS_FIELD_NUMBER = 5;
    private static volatile z2 PARSER = null;
    public static final int USE_OLD_OUTER_CLASSNAME_DEFAULT_FIELD_NUMBER = 4;
    public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean largeEnum_;
    private boolean legacyClosedEnum_;
    private int nestInFileClass_;
    private boolean useOldOuterClassnameDefault_;
    private int utf8Validation_;

    static {
        JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0 = new JavaFeaturesProto.JavaFeatures();
        JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE = javaFeaturesProto$JavaFeatures0;
        A1.registerDefaultInstance(JavaFeaturesProto.JavaFeatures.class, javaFeaturesProto$JavaFeatures0);
    }

    public static void access$1000(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0) {
        javaFeaturesProto$JavaFeatures0.clearUseOldOuterClassnameDefault();
    }

    public static void access$1100(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0, V1 v10) {
        javaFeaturesProto$JavaFeatures0.setNestInFileClass(v10);
    }

    public static void access$1200(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0) {
        javaFeaturesProto$JavaFeatures0.clearNestInFileClass();
    }

    public static void access$300(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0, boolean z) {
        javaFeaturesProto$JavaFeatures0.setLegacyClosedEnum(z);
    }

    public static void access$400(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0) {
        javaFeaturesProto$JavaFeatures0.clearLegacyClosedEnum();
    }

    public static void access$500(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0, W1 w10) {
        javaFeaturesProto$JavaFeatures0.setUtf8Validation(w10);
    }

    public static void access$600(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0) {
        javaFeaturesProto$JavaFeatures0.clearUtf8Validation();
    }

    public static void access$700(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0, boolean z) {
        javaFeaturesProto$JavaFeatures0.setLargeEnum(z);
    }

    public static void access$800(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0) {
        javaFeaturesProto$JavaFeatures0.clearLargeEnum();
    }

    public static void access$900(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0, boolean z) {
        javaFeaturesProto$JavaFeatures0.setUseOldOuterClassnameDefault(z);
    }

    private void clearLargeEnum() {
        this.bitField0_ &= -5;
        this.largeEnum_ = false;
    }

    private void clearLegacyClosedEnum() {
        this.bitField0_ &= -2;
        this.legacyClosedEnum_ = false;
    }

    private void clearNestInFileClass() {
        this.bitField0_ &= -17;
        this.nestInFileClass_ = 0;
    }

    private void clearUseOldOuterClassnameDefault() {
        this.bitField0_ &= -9;
        this.useOldOuterClassnameDefault_ = false;
    }

    private void clearUtf8Validation() {
        this.bitField0_ &= -3;
        this.utf8Validation_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005᠌\u0004", new Object[]{"bitField0_", "legacyClosedEnum_", "utf8Validation_", E.t, "largeEnum_", "useOldOuterClassnameDefault_", "nestInFileClass_", U1.a});
            }
            case 3: {
                return new JavaFeaturesProto.JavaFeatures();
            }
            case 4: {
                return new S1(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = JavaFeaturesProto.JavaFeatures.PARSER;
                if(z20 == null) {
                    synchronized(JavaFeaturesProto.JavaFeatures.class) {
                        z21 = JavaFeaturesProto.JavaFeatures.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            JavaFeaturesProto.JavaFeatures.PARSER = z21;
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

    public static JavaFeaturesProto.JavaFeatures getDefaultInstance() {
        return JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE;
    }

    public boolean getLargeEnum() {
        return this.largeEnum_;
    }

    public boolean getLegacyClosedEnum() {
        return this.legacyClosedEnum_;
    }

    public V1 getNestInFileClass() {
        V1 v10 = V1.b(this.nestInFileClass_);
        return v10 == null ? V1.b : v10;
    }

    public boolean getUseOldOuterClassnameDefault() {
        return this.useOldOuterClassnameDefault_;
    }

    public W1 getUtf8Validation() {
        W1 w10 = W1.b(this.utf8Validation_);
        return w10 == null ? W1.b : w10;
    }

    public boolean hasLargeEnum() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLegacyClosedEnum() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNestInFileClass() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasUseOldOuterClassnameDefault() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasUtf8Validation() {
        return (this.bitField0_ & 2) != 0;
    }

    public static S1 newBuilder() {
        return (S1)JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE.createBuilder();
    }

    public static S1 newBuilder(JavaFeaturesProto.JavaFeatures javaFeaturesProto$JavaFeatures0) {
        return (S1)JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE.createBuilder(javaFeaturesProto$JavaFeatures0);
    }

    public static JavaFeaturesProto.JavaFeatures parseDelimitedFrom(InputStream inputStream0) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseDelimitedFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, inputStream0);
    }

    public static JavaFeaturesProto.JavaFeatures parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseDelimitedFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(o o0) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, o0);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(o o0, g1 g10) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, o0, g10);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(t t0) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, t0);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(t t0, g1 g10) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, t0, g10);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(InputStream inputStream0) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, inputStream0);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(InputStream inputStream0, g1 g10) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(ByteBuffer byteBuffer0) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(byte[] arr_b) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, arr_b);
    }

    public static JavaFeaturesProto.JavaFeatures parseFrom(byte[] arr_b, g1 g10) {
        return (JavaFeaturesProto.JavaFeatures)A1.parseFrom(JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return JavaFeaturesProto.JavaFeatures.DEFAULT_INSTANCE.getParserForType();
    }

    private void setLargeEnum(boolean z) {
        this.bitField0_ |= 4;
        this.largeEnum_ = z;
    }

    private void setLegacyClosedEnum(boolean z) {
        this.bitField0_ |= 1;
        this.legacyClosedEnum_ = z;
    }

    private void setNestInFileClass(V1 v10) {
        this.nestInFileClass_ = v10.a;
        this.bitField0_ |= 16;
    }

    private void setUseOldOuterClassnameDefault(boolean z) {
        this.bitField0_ |= 8;
        this.useOldOuterClassnameDefault_ = z;
    }

    private void setUtf8Validation(W1 w10) {
        this.utf8Validation_ = w10.a;
        this.bitField0_ |= 2;
    }
}

