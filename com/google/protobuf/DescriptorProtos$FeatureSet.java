package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DescriptorProtos.FeatureSet extends GeneratedMessageLite.ExtendableMessage {
    public static final class VisibilityFeature extends A1 implements m2 {
        private static final VisibilityFeature DEFAULT_INSTANCE;
        private static volatile z2 PARSER;

        static {
            VisibilityFeature descriptorProtos$FeatureSet$VisibilityFeature0 = new VisibilityFeature();
            VisibilityFeature.DEFAULT_INSTANCE = descriptorProtos$FeatureSet$VisibilityFeature0;
            A1.registerDefaultInstance(VisibilityFeature.class, descriptorProtos$FeatureSet$VisibilityFeature0);
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(VisibilityFeature.DEFAULT_INSTANCE, "\u0001\u0000", null);
                }
                case 3: {
                    return new VisibilityFeature();
                }
                case 4: {
                    return new b0(VisibilityFeature.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return VisibilityFeature.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = VisibilityFeature.PARSER;
                    if(z20 == null) {
                        Class class0 = VisibilityFeature.class;
                        synchronized(class0) {
                            z2 z21 = VisibilityFeature.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                VisibilityFeature.PARSER = z21;
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

        public static VisibilityFeature getDefaultInstance() {
            return VisibilityFeature.DEFAULT_INSTANCE;
        }

        public static b0 newBuilder() {
            return (b0)VisibilityFeature.DEFAULT_INSTANCE.createBuilder();
        }

        public static b0 newBuilder(VisibilityFeature descriptorProtos$FeatureSet$VisibilityFeature0) {
            return (b0)VisibilityFeature.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FeatureSet$VisibilityFeature0);
        }

        public static VisibilityFeature parseDelimitedFrom(InputStream inputStream0) {
            return (VisibilityFeature)A1.parseDelimitedFrom(VisibilityFeature.DEFAULT_INSTANCE, inputStream0);
        }

        public static VisibilityFeature parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (VisibilityFeature)A1.parseDelimitedFrom(VisibilityFeature.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static VisibilityFeature parseFrom(o o0) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, o0);
        }

        public static VisibilityFeature parseFrom(o o0, g1 g10) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, o0, g10);
        }

        public static VisibilityFeature parseFrom(t t0) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, t0);
        }

        public static VisibilityFeature parseFrom(t t0, g1 g10) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, t0, g10);
        }

        public static VisibilityFeature parseFrom(InputStream inputStream0) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, inputStream0);
        }

        public static VisibilityFeature parseFrom(InputStream inputStream0, g1 g10) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static VisibilityFeature parseFrom(ByteBuffer byteBuffer0) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static VisibilityFeature parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static VisibilityFeature parseFrom(byte[] arr_b) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, arr_b);
        }

        public static VisibilityFeature parseFrom(byte[] arr_b, g1 g10) {
            return (VisibilityFeature)A1.parseFrom(VisibilityFeature.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return VisibilityFeature.DEFAULT_INSTANCE.getParserForType();
        }
    }

    private static final DescriptorProtos.FeatureSet DEFAULT_INSTANCE = null;
    public static final int DEFAULT_SYMBOL_VISIBILITY_FIELD_NUMBER = 8;
    public static final int ENFORCE_NAMING_STYLE_FIELD_NUMBER = 7;
    public static final int ENUM_TYPE_FIELD_NUMBER = 2;
    public static final int FIELD_PRESENCE_FIELD_NUMBER = 1;
    public static final int JSON_FORMAT_FIELD_NUMBER = 6;
    public static final int MESSAGE_ENCODING_FIELD_NUMBER = 5;
    private static volatile z2 PARSER = null;
    public static final int REPEATED_FIELD_ENCODING_FIELD_NUMBER = 3;
    public static final int UTF8_VALIDATION_FIELD_NUMBER = 4;
    private int bitField0_;
    private int defaultSymbolVisibility_;
    private int enforceNamingStyle_;
    private int enumType_;
    private int fieldPresence_;
    private int jsonFormat_;
    private byte memoizedIsInitialized;
    private int messageEncoding_;
    private int repeatedFieldEncoding_;
    private int utf8Validation_;

    static {
        DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0 = new DescriptorProtos.FeatureSet();
        DescriptorProtos.FeatureSet.DEFAULT_INSTANCE = descriptorProtos$FeatureSet0;
        A1.registerDefaultInstance(DescriptorProtos.FeatureSet.class, descriptorProtos$FeatureSet0);
    }

    private DescriptorProtos.FeatureSet() {
        this.memoizedIsInitialized = 2;
    }

    public static void access$53300(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, W w0) {
        descriptorProtos$FeatureSet0.setFieldPresence(w0);
    }

    public static void access$53400(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearFieldPresence();
    }

    public static void access$53500(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, V v0) {
        descriptorProtos$FeatureSet0.setEnumType(v0);
    }

    public static void access$53600(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearEnumType();
    }

    public static void access$53700(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, Z z0) {
        descriptorProtos$FeatureSet0.setRepeatedFieldEncoding(z0);
    }

    public static void access$53800(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearRepeatedFieldEncoding();
    }

    public static void access$53900(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, a0 a00) {
        descriptorProtos$FeatureSet0.setUtf8Validation(a00);
    }

    public static void access$54000(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearUtf8Validation();
    }

    public static void access$54100(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, Y y0) {
        descriptorProtos$FeatureSet0.setMessageEncoding(y0);
    }

    public static void access$54200(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearMessageEncoding();
    }

    public static void access$54300(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, X x0) {
        descriptorProtos$FeatureSet0.setJsonFormat(x0);
    }

    public static void access$54400(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearJsonFormat();
    }

    public static void access$54500(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, U u0) {
        descriptorProtos$FeatureSet0.setEnforceNamingStyle(u0);
    }

    public static void access$54600(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearEnforceNamingStyle();
    }

    public static void access$54700(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0, d0 d00) {
        descriptorProtos$FeatureSet0.setDefaultSymbolVisibility(d00);
    }

    public static void access$54800(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.clearDefaultSymbolVisibility();
    }

    private void clearDefaultSymbolVisibility() {
        this.bitField0_ &= 0xFFFFFF7F;
        this.defaultSymbolVisibility_ = 0;
    }

    private void clearEnforceNamingStyle() {
        this.bitField0_ &= -65;
        this.enforceNamingStyle_ = 0;
    }

    private void clearEnumType() {
        this.bitField0_ &= -3;
        this.enumType_ = 0;
    }

    private void clearFieldPresence() {
        this.bitField0_ &= -2;
        this.fieldPresence_ = 0;
    }

    private void clearJsonFormat() {
        this.bitField0_ &= -33;
        this.jsonFormat_ = 0;
    }

    private void clearMessageEncoding() {
        this.bitField0_ &= -17;
        this.messageEncoding_ = 0;
    }

    private void clearRepeatedFieldEncoding() {
        this.bitField0_ &= -5;
        this.repeatedFieldEncoding_ = 0;
    }

    private void clearUtf8Validation() {
        this.bitField0_ &= -9;
        this.utf8Validation_ = 0;
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
                return A1.newMessageInfo(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"bitField0_", "fieldPresence_", E.f, "enumType_", E.e, "repeatedFieldEncoding_", E.i, "utf8Validation_", E.j, "messageEncoding_", E.h, "jsonFormat_", E.g, "enforceNamingStyle_", E.d, "defaultSymbolVisibility_", c0.a});
            }
            case 3: {
                return new DescriptorProtos.FeatureSet();
            }
            case 4: {
                return new T(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.FeatureSet.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.FeatureSet.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.FeatureSet.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.FeatureSet.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.FeatureSet.PARSER = z21;
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

    public static DescriptorProtos.FeatureSet getDefaultInstance() {
        return DescriptorProtos.FeatureSet.DEFAULT_INSTANCE;
    }

    public d0 getDefaultSymbolVisibility() {
        d0 d00 = d0.b(this.defaultSymbolVisibility_);
        return d00 == null ? d0.b : d00;
    }

    public U getEnforceNamingStyle() {
        U u0 = U.b(this.enforceNamingStyle_);
        return u0 == null ? U.b : u0;
    }

    public V getEnumType() {
        V v0 = V.b(this.enumType_);
        return v0 == null ? V.b : v0;
    }

    public W getFieldPresence() {
        W w0 = W.b(this.fieldPresence_);
        return w0 == null ? W.b : w0;
    }

    public X getJsonFormat() {
        X x0 = X.b(this.jsonFormat_);
        return x0 == null ? X.b : x0;
    }

    public Y getMessageEncoding() {
        Y y0 = Y.b(this.messageEncoding_);
        return y0 == null ? Y.b : y0;
    }

    public Z getRepeatedFieldEncoding() {
        Z z0 = Z.b(this.repeatedFieldEncoding_);
        return z0 == null ? Z.b : z0;
    }

    public a0 getUtf8Validation() {
        a0 a00 = a0.b(this.utf8Validation_);
        return a00 == null ? a0.b : a00;
    }

    public boolean hasDefaultSymbolVisibility() {
        return (this.bitField0_ & 0x80) != 0;
    }

    public boolean hasEnforceNamingStyle() {
        return (this.bitField0_ & 0x40) != 0;
    }

    public boolean hasEnumType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFieldPresence() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasJsonFormat() {
        return (this.bitField0_ & 0x20) != 0;
    }

    public boolean hasMessageEncoding() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasRepeatedFieldEncoding() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasUtf8Validation() {
        return (this.bitField0_ & 8) != 0;
    }

    public static T newBuilder() {
        return (T)DescriptorProtos.FeatureSet.DEFAULT_INSTANCE.createBuilder();
    }

    public static T newBuilder(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        return (T)DescriptorProtos.FeatureSet.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FeatureSet0);
    }

    public static DescriptorProtos.FeatureSet parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.FeatureSet)A1.parseDelimitedFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FeatureSet parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FeatureSet)A1.parseDelimitedFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FeatureSet parseFrom(o o0) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.FeatureSet parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.FeatureSet parseFrom(t t0) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.FeatureSet parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.FeatureSet parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FeatureSet parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FeatureSet parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.FeatureSet parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.FeatureSet parseFrom(byte[] arr_b) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.FeatureSet parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.FeatureSet)A1.parseFrom(DescriptorProtos.FeatureSet.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.FeatureSet.DEFAULT_INSTANCE.getParserForType();
    }

    private void setDefaultSymbolVisibility(d0 d00) {
        this.defaultSymbolVisibility_ = d00.a;
        this.bitField0_ |= 0x80;
    }

    private void setEnforceNamingStyle(U u0) {
        this.enforceNamingStyle_ = u0.a;
        this.bitField0_ |= 0x40;
    }

    private void setEnumType(V v0) {
        this.enumType_ = v0.a;
        this.bitField0_ |= 2;
    }

    private void setFieldPresence(W w0) {
        this.fieldPresence_ = w0.a;
        this.bitField0_ |= 1;
    }

    private void setJsonFormat(X x0) {
        this.jsonFormat_ = x0.a;
        this.bitField0_ |= 0x20;
    }

    private void setMessageEncoding(Y y0) {
        this.messageEncoding_ = y0.a;
        this.bitField0_ |= 16;
    }

    private void setRepeatedFieldEncoding(Z z0) {
        this.repeatedFieldEncoding_ = z0.a;
        this.bitField0_ |= 4;
    }

    private void setUtf8Validation(a0 a00) {
        this.utf8Validation_ = a00.a;
        this.bitField0_ |= 8;
    }
}

