package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.FieldOptions extends GeneratedMessageLite.ExtendableMessage {
    public static final class EditionDefault extends A1 implements o0 {
        private static final EditionDefault DEFAULT_INSTANCE = null;
        public static final int EDITION_FIELD_NUMBER = 3;
        private static volatile z2 PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private int edition_;
        private String value_;

        static {
            EditionDefault descriptorProtos$FieldOptions$EditionDefault0 = new EditionDefault();
            EditionDefault.DEFAULT_INSTANCE = descriptorProtos$FieldOptions$EditionDefault0;
            A1.registerDefaultInstance(EditionDefault.class, descriptorProtos$FieldOptions$EditionDefault0);
        }

        private EditionDefault() {
            this.value_ = "";
        }

        public static void access$36800(EditionDefault descriptorProtos$FieldOptions$EditionDefault0, F f0) {
            descriptorProtos$FieldOptions$EditionDefault0.setEdition(f0);
        }

        public static void access$36900(EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
            descriptorProtos$FieldOptions$EditionDefault0.clearEdition();
        }

        public static void access$37000(EditionDefault descriptorProtos$FieldOptions$EditionDefault0, String s) {
            descriptorProtos$FieldOptions$EditionDefault0.setValue(s);
        }

        public static void access$37100(EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
            descriptorProtos$FieldOptions$EditionDefault0.clearValue();
        }

        public static void access$37200(EditionDefault descriptorProtos$FieldOptions$EditionDefault0, o o0) {
            descriptorProtos$FieldOptions$EditionDefault0.setValueBytes(o0);
        }

        private void clearEdition() {
            this.bitField0_ &= -2;
            this.edition_ = 0;
        }

        private void clearValue() {
            this.bitField0_ &= -3;
            this.value_ = "";
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(EditionDefault.DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002ဈ\u0001\u0003᠌\u0000", new Object[]{"bitField0_", "value_", "edition_", E.b});
                }
                case 3: {
                    return new EditionDefault();
                }
                case 4: {
                    return new n0(EditionDefault.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return EditionDefault.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = EditionDefault.PARSER;
                    if(z20 == null) {
                        Class class0 = EditionDefault.class;
                        synchronized(class0) {
                            z2 z21 = EditionDefault.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                EditionDefault.PARSER = z21;
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

        public static EditionDefault getDefaultInstance() {
            return EditionDefault.DEFAULT_INSTANCE;
        }

        public F getEdition() {
            F f0 = F.b(this.edition_);
            return f0 == null ? F.b : f0;
        }

        public String getValue() [...] // 潜在的解密器

        public o getValueBytes() {
            return o.e(this.value_);
        }

        public boolean hasEdition() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) != 0;
        }

        public static n0 newBuilder() {
            return (n0)EditionDefault.DEFAULT_INSTANCE.createBuilder();
        }

        public static n0 newBuilder(EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
            return (n0)EditionDefault.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FieldOptions$EditionDefault0);
        }

        public static EditionDefault parseDelimitedFrom(InputStream inputStream0) {
            return (EditionDefault)A1.parseDelimitedFrom(EditionDefault.DEFAULT_INSTANCE, inputStream0);
        }

        public static EditionDefault parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (EditionDefault)A1.parseDelimitedFrom(EditionDefault.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static EditionDefault parseFrom(o o0) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, o0);
        }

        public static EditionDefault parseFrom(o o0, g1 g10) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, o0, g10);
        }

        public static EditionDefault parseFrom(t t0) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, t0);
        }

        public static EditionDefault parseFrom(t t0, g1 g10) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, t0, g10);
        }

        public static EditionDefault parseFrom(InputStream inputStream0) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, inputStream0);
        }

        public static EditionDefault parseFrom(InputStream inputStream0, g1 g10) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static EditionDefault parseFrom(ByteBuffer byteBuffer0) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static EditionDefault parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static EditionDefault parseFrom(byte[] arr_b) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, arr_b);
        }

        public static EditionDefault parseFrom(byte[] arr_b, g1 g10) {
            return (EditionDefault)A1.parseFrom(EditionDefault.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return EditionDefault.DEFAULT_INSTANCE.getParserForType();
        }

        private void setEdition(F f0) {
            this.edition_ = f0.a;
            this.bitField0_ |= 1;
        }

        private void setValue(String s) {
            s.getClass();
            this.bitField0_ |= 2;
            this.value_ = s;
        }

        private void setValueBytes(o o0) {
            this.value_ = o0.p();
            this.bitField0_ |= 2;
        }
    }

    public static final class FeatureSupport extends A1 implements m2 {
        private static final FeatureSupport DEFAULT_INSTANCE = null;
        public static final int DEPRECATION_WARNING_FIELD_NUMBER = 3;
        public static final int EDITION_DEPRECATED_FIELD_NUMBER = 2;
        public static final int EDITION_INTRODUCED_FIELD_NUMBER = 1;
        public static final int EDITION_REMOVED_FIELD_NUMBER = 4;
        private static volatile z2 PARSER;
        private int bitField0_;
        private String deprecationWarning_;
        private int editionDeprecated_;
        private int editionIntroduced_;
        private int editionRemoved_;

        static {
            FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0 = new FeatureSupport();
            FeatureSupport.DEFAULT_INSTANCE = descriptorProtos$FieldOptions$FeatureSupport0;
            A1.registerDefaultInstance(FeatureSupport.class, descriptorProtos$FieldOptions$FeatureSupport0);
        }

        private FeatureSupport() {
            this.deprecationWarning_ = "";
        }

        public static void access$37500(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0, F f0) {
            descriptorProtos$FieldOptions$FeatureSupport0.setEditionIntroduced(f0);
        }

        public static void access$37600(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
            descriptorProtos$FieldOptions$FeatureSupport0.clearEditionIntroduced();
        }

        public static void access$37700(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0, F f0) {
            descriptorProtos$FieldOptions$FeatureSupport0.setEditionDeprecated(f0);
        }

        public static void access$37800(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
            descriptorProtos$FieldOptions$FeatureSupport0.clearEditionDeprecated();
        }

        public static void access$37900(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0, String s) {
            descriptorProtos$FieldOptions$FeatureSupport0.setDeprecationWarning(s);
        }

        public static void access$38000(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
            descriptorProtos$FieldOptions$FeatureSupport0.clearDeprecationWarning();
        }

        public static void access$38100(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0, o o0) {
            descriptorProtos$FieldOptions$FeatureSupport0.setDeprecationWarningBytes(o0);
        }

        public static void access$38200(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0, F f0) {
            descriptorProtos$FieldOptions$FeatureSupport0.setEditionRemoved(f0);
        }

        public static void access$38300(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
            descriptorProtos$FieldOptions$FeatureSupport0.clearEditionRemoved();
        }

        private void clearDeprecationWarning() {
            this.bitField0_ &= -5;
            this.deprecationWarning_ = "";
        }

        private void clearEditionDeprecated() {
            this.bitField0_ &= -3;
            this.editionDeprecated_ = 0;
        }

        private void clearEditionIntroduced() {
            this.bitField0_ &= -2;
            this.editionIntroduced_ = 0;
        }

        private void clearEditionRemoved() {
            this.bitField0_ &= -9;
            this.editionRemoved_ = 0;
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            z2 z21;
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(FeatureSupport.DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"bitField0_", "editionIntroduced_", E.b, "editionDeprecated_", E.b, "deprecationWarning_", "editionRemoved_", E.b});
                }
                case 3: {
                    return new FeatureSupport();
                }
                case 4: {
                    return new p0(FeatureSupport.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return FeatureSupport.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = FeatureSupport.PARSER;
                    if(z20 == null) {
                        synchronized(FeatureSupport.class) {
                            z21 = FeatureSupport.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                FeatureSupport.PARSER = z21;
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

        public static FeatureSupport getDefaultInstance() {
            return FeatureSupport.DEFAULT_INSTANCE;
        }

        public String getDeprecationWarning() [...] // 潜在的解密器

        public o getDeprecationWarningBytes() {
            return o.e(this.deprecationWarning_);
        }

        public F getEditionDeprecated() {
            F f0 = F.b(this.editionDeprecated_);
            return f0 == null ? F.b : f0;
        }

        public F getEditionIntroduced() {
            F f0 = F.b(this.editionIntroduced_);
            return f0 == null ? F.b : f0;
        }

        public F getEditionRemoved() {
            F f0 = F.b(this.editionRemoved_);
            return f0 == null ? F.b : f0;
        }

        public boolean hasDeprecationWarning() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasEditionDeprecated() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasEditionIntroduced() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasEditionRemoved() {
            return (this.bitField0_ & 8) != 0;
        }

        public static p0 newBuilder() {
            return (p0)FeatureSupport.DEFAULT_INSTANCE.createBuilder();
        }

        public static p0 newBuilder(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
            return (p0)FeatureSupport.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FieldOptions$FeatureSupport0);
        }

        public static FeatureSupport parseDelimitedFrom(InputStream inputStream0) {
            return (FeatureSupport)A1.parseDelimitedFrom(FeatureSupport.DEFAULT_INSTANCE, inputStream0);
        }

        public static FeatureSupport parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (FeatureSupport)A1.parseDelimitedFrom(FeatureSupport.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static FeatureSupport parseFrom(o o0) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, o0);
        }

        public static FeatureSupport parseFrom(o o0, g1 g10) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, o0, g10);
        }

        public static FeatureSupport parseFrom(t t0) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, t0);
        }

        public static FeatureSupport parseFrom(t t0, g1 g10) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, t0, g10);
        }

        public static FeatureSupport parseFrom(InputStream inputStream0) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, inputStream0);
        }

        public static FeatureSupport parseFrom(InputStream inputStream0, g1 g10) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static FeatureSupport parseFrom(ByteBuffer byteBuffer0) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static FeatureSupport parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static FeatureSupport parseFrom(byte[] arr_b) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, arr_b);
        }

        public static FeatureSupport parseFrom(byte[] arr_b, g1 g10) {
            return (FeatureSupport)A1.parseFrom(FeatureSupport.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return FeatureSupport.DEFAULT_INSTANCE.getParserForType();
        }

        private void setDeprecationWarning(String s) {
            s.getClass();
            this.bitField0_ |= 4;
            this.deprecationWarning_ = s;
        }

        private void setDeprecationWarningBytes(o o0) {
            this.deprecationWarning_ = o0.p();
            this.bitField0_ |= 4;
        }

        private void setEditionDeprecated(F f0) {
            this.editionDeprecated_ = f0.a;
            this.bitField0_ |= 2;
        }

        private void setEditionIntroduced(F f0) {
            this.editionIntroduced_ = f0.a;
            this.bitField0_ |= 1;
        }

        private void setEditionRemoved(F f0) {
            this.editionRemoved_ = f0.a;
            this.bitField0_ |= 8;
        }
    }

    public static final int CTYPE_FIELD_NUMBER = 1;
    public static final int DEBUG_REDACT_FIELD_NUMBER = 16;
    private static final DescriptorProtos.FieldOptions DEFAULT_INSTANCE = null;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int EDITION_DEFAULTS_FIELD_NUMBER = 20;
    public static final int FEATURES_FIELD_NUMBER = 21;
    public static final int FEATURE_SUPPORT_FIELD_NUMBER = 22;
    public static final int JSTYPE_FIELD_NUMBER = 6;
    public static final int LAZY_FIELD_NUMBER = 5;
    public static final int PACKED_FIELD_NUMBER = 2;
    private static volatile z2 PARSER = null;
    public static final int RETENTION_FIELD_NUMBER = 17;
    public static final int TARGETS_FIELD_NUMBER = 19;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    public static final int UNVERIFIED_LAZY_FIELD_NUMBER = 15;
    public static final int WEAK_FIELD_NUMBER = 10;
    private int bitField0_;
    private int ctype_;
    private boolean debugRedact_;
    private boolean deprecated_;
    private O1 editionDefaults_;
    private FeatureSupport featureSupport_;
    private DescriptorProtos.FeatureSet features_;
    private int jstype_;
    private boolean lazy_;
    private byte memoizedIsInitialized;
    private boolean packed_;
    private int retention_;
    private K1 targets_;
    private static final L1 targets_converter_;
    private O1 uninterpretedOption_;
    private boolean unverifiedLazy_;
    private boolean weak_;

    static {
        DescriptorProtos.FieldOptions.targets_converter_ = new k(2);
        DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0 = new DescriptorProtos.FieldOptions();
        DescriptorProtos.FieldOptions.DEFAULT_INSTANCE = descriptorProtos$FieldOptions0;
        A1.registerDefaultInstance(DescriptorProtos.FieldOptions.class, descriptorProtos$FieldOptions0);
    }

    private DescriptorProtos.FieldOptions() {
        this.memoizedIsInitialized = 2;
        this.targets_ = A1.emptyIntList();
        this.editionDefaults_ = A1.emptyProtobufList();
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    public static void access$38600(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, m0 m00) {
        descriptorProtos$FieldOptions0.setCtype(m00);
    }

    public static void access$38700(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearCtype();
    }

    public static void access$38800(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, boolean z) {
        descriptorProtos$FieldOptions0.setPacked(z);
    }

    public static void access$38900(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearPacked();
    }

    public static void access$39000(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, q0 q00) {
        descriptorProtos$FieldOptions0.setJstype(q00);
    }

    public static void access$39100(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearJstype();
    }

    public static void access$39200(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, boolean z) {
        descriptorProtos$FieldOptions0.setLazy(z);
    }

    public static void access$39300(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearLazy();
    }

    public static void access$39400(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, boolean z) {
        descriptorProtos$FieldOptions0.setUnverifiedLazy(z);
    }

    public static void access$39500(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearUnverifiedLazy();
    }

    public static void access$39600(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, boolean z) {
        descriptorProtos$FieldOptions0.setDeprecated(z);
    }

    public static void access$39700(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearDeprecated();
    }

    public static void access$39800(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, boolean z) {
        descriptorProtos$FieldOptions0.setWeak(z);
    }

    public static void access$39900(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearWeak();
    }

    public static void access$40000(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, boolean z) {
        descriptorProtos$FieldOptions0.setDebugRedact(z);
    }

    public static void access$40100(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearDebugRedact();
    }

    public static void access$40200(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, r0 r00) {
        descriptorProtos$FieldOptions0.setRetention(r00);
    }

    public static void access$40300(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearRetention();
    }

    public static void access$40400(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, int v, s0 s00) {
        descriptorProtos$FieldOptions0.setTargets(v, s00);
    }

    public static void access$40500(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, s0 s00) {
        descriptorProtos$FieldOptions0.addTargets(s00);
    }

    public static void access$40600(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, Iterable iterable0) {
        descriptorProtos$FieldOptions0.addAllTargets(iterable0);
    }

    public static void access$40700(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearTargets();
    }

    public static void access$40800(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, int v, EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
        descriptorProtos$FieldOptions0.setEditionDefaults(v, descriptorProtos$FieldOptions$EditionDefault0);
    }

    public static void access$40900(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
        descriptorProtos$FieldOptions0.addEditionDefaults(descriptorProtos$FieldOptions$EditionDefault0);
    }

    public static void access$41000(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, int v, EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
        descriptorProtos$FieldOptions0.addEditionDefaults(v, descriptorProtos$FieldOptions$EditionDefault0);
    }

    public static void access$41100(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, Iterable iterable0) {
        descriptorProtos$FieldOptions0.addAllEditionDefaults(iterable0);
    }

    public static void access$41200(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearEditionDefaults();
    }

    public static void access$41300(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, int v) {
        descriptorProtos$FieldOptions0.removeEditionDefaults(v);
    }

    public static void access$41400(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FieldOptions0.setFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$41500(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FieldOptions0.mergeFeatures(descriptorProtos$FeatureSet0);
    }

    public static void access$41600(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearFeatures();
    }

    public static void access$41700(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$FieldOptions0.setFeatureSupport(descriptorProtos$FieldOptions$FeatureSupport0);
    }

    public static void access$41800(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$FieldOptions0.mergeFeatureSupport(descriptorProtos$FieldOptions$FeatureSupport0);
    }

    public static void access$41900(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearFeatureSupport();
    }

    public static void access$42000(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$FieldOptions0.setUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$42100(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$FieldOptions0.addUninterpretedOption(descriptorProtos$UninterpretedOption0);
    }

    public static void access$42200(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$FieldOptions0.addUninterpretedOption(v, descriptorProtos$UninterpretedOption0);
    }

    public static void access$42300(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, Iterable iterable0) {
        descriptorProtos$FieldOptions0.addAllUninterpretedOption(iterable0);
    }

    public static void access$42400(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        descriptorProtos$FieldOptions0.clearUninterpretedOption();
    }

    public static void access$42500(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0, int v) {
        descriptorProtos$FieldOptions0.removeUninterpretedOption(v);
    }

    private void addAllEditionDefaults(Iterable iterable0) {
        this.ensureEditionDefaultsIsMutable();
        b.addAll(iterable0, this.editionDefaults_);
    }

    private void addAllTargets(Iterable iterable0) {
        this.ensureTargetsIsMutable();
        for(Object object0: iterable0) {
            ((D1)this.targets_).d(((s0)object0).a);
        }
    }

    private void addAllUninterpretedOption(Iterable iterable0) {
        this.ensureUninterpretedOptionIsMutable();
        b.addAll(iterable0, this.uninterpretedOption_);
    }

    private void addEditionDefaults(int v, EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
        descriptorProtos$FieldOptions$EditionDefault0.getClass();
        this.ensureEditionDefaultsIsMutable();
        this.editionDefaults_.add(v, descriptorProtos$FieldOptions$EditionDefault0);
    }

    private void addEditionDefaults(EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
        descriptorProtos$FieldOptions$EditionDefault0.getClass();
        this.ensureEditionDefaultsIsMutable();
        this.editionDefaults_.add(descriptorProtos$FieldOptions$EditionDefault0);
    }

    private void addTargets(s0 s00) {
        s00.getClass();
        this.ensureTargetsIsMutable();
        ((D1)this.targets_).d(s00.a);
    }

    private void addUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(v, descriptorProtos$UninterpretedOption0);
    }

    private void addUninterpretedOption(DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(descriptorProtos$UninterpretedOption0);
    }

    private void clearCtype() {
        this.bitField0_ &= -2;
        this.ctype_ = 0;
    }

    private void clearDebugRedact() {
        this.bitField0_ &= 0xFFFFFF7F;
        this.debugRedact_ = false;
    }

    private void clearDeprecated() {
        this.bitField0_ &= -33;
        this.deprecated_ = false;
    }

    private void clearEditionDefaults() {
        this.editionDefaults_ = A1.emptyProtobufList();
    }

    private void clearFeatureSupport() {
        this.featureSupport_ = null;
        this.bitField0_ &= 0xFFFFFBFF;
    }

    private void clearFeatures() {
        this.features_ = null;
        this.bitField0_ &= 0xFFFFFDFF;
    }

    private void clearJstype() {
        this.bitField0_ &= -5;
        this.jstype_ = 0;
    }

    private void clearLazy() {
        this.bitField0_ &= -9;
        this.lazy_ = false;
    }

    private void clearPacked() {
        this.bitField0_ &= -3;
        this.packed_ = false;
    }

    private void clearRetention() {
        this.bitField0_ &= 0xFFFFFEFF;
        this.retention_ = 0;
    }

    private void clearTargets() {
        this.targets_ = A1.emptyIntList();
    }

    private void clearUninterpretedOption() {
        this.uninterpretedOption_ = A1.emptyProtobufList();
    }

    private void clearUnverifiedLazy() {
        this.bitField0_ &= -17;
        this.unverifiedLazy_ = false;
    }

    private void clearWeak() {
        this.bitField0_ &= -65;
        this.weak_ = false;
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
                return A1.newMessageInfo(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, "\u0001\u000E\u0000\u0001\u0001ϧ\u000E\u0000\u0003\u0002\u0001᠌\u0000\u0002ဇ\u0001\u0003ဇ\u0005\u0005ဇ\u0003\u0006᠌\u0002\nဇ\u0006\u000Fဇ\u0004\u0010ဇ\u0007\u0011᠌\b\u0013ࠞ\u0014\u001B\u0015ᐉ\t\u0016ဉ\nϧЛ", new Object[]{"bitField0_", "ctype_", E.m, "packed_", "deprecated_", "lazy_", "jstype_", E.n, "weak_", "unverifiedLazy_", "debugRedact_", "retention_", E.o, "targets_", E.p, "editionDefaults_", EditionDefault.class, "features_", "featureSupport_", "uninterpretedOption_", DescriptorProtos.UninterpretedOption.class});
            }
            case 3: {
                return new DescriptorProtos.FieldOptions();
            }
            case 4: {
                return new l0(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.FieldOptions.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.FieldOptions.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.FieldOptions.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.FieldOptions.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.FieldOptions.PARSER = z21;
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

    private void ensureEditionDefaultsIsMutable() {
        O1 o10 = this.editionDefaults_;
        if(!((c)o10).a) {
            this.editionDefaults_ = A1.mutableCopy(o10);
        }
    }

    private void ensureTargetsIsMutable() {
        K1 k10 = this.targets_;
        if(!((c)k10).a) {
            this.targets_ = A1.mutableCopy(k10);
        }
    }

    private void ensureUninterpretedOptionIsMutable() {
        O1 o10 = this.uninterpretedOption_;
        if(!((c)o10).a) {
            this.uninterpretedOption_ = A1.mutableCopy(o10);
        }
    }

    public m0 getCtype() {
        m0 m00 = m0.b(this.ctype_);
        return m00 == null ? m0.b : m00;
    }

    public boolean getDebugRedact() {
        return this.debugRedact_;
    }

    public static DescriptorProtos.FieldOptions getDefaultInstance() {
        return DescriptorProtos.FieldOptions.DEFAULT_INSTANCE;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public EditionDefault getEditionDefaults(int v) {
        return (EditionDefault)this.editionDefaults_.get(v);
    }

    public int getEditionDefaultsCount() {
        return this.editionDefaults_.size();
    }

    public List getEditionDefaultsList() {
        return this.editionDefaults_;
    }

    public o0 getEditionDefaultsOrBuilder(int v) {
        return (o0)this.editionDefaults_.get(v);
    }

    public List getEditionDefaultsOrBuilderList() {
        return this.editionDefaults_;
    }

    public FeatureSupport getFeatureSupport() {
        return this.featureSupport_ == null ? FeatureSupport.getDefaultInstance() : this.featureSupport_;
    }

    public DescriptorProtos.FeatureSet getFeatures() {
        return this.features_ == null ? DescriptorProtos.FeatureSet.getDefaultInstance() : this.features_;
    }

    public q0 getJstype() {
        q0 q00 = q0.b(this.jstype_);
        return q00 == null ? q0.b : q00;
    }

    public boolean getLazy() {
        return this.lazy_;
    }

    public boolean getPacked() {
        return this.packed_;
    }

    public r0 getRetention() {
        r0 r00 = r0.b(this.retention_);
        return r00 == null ? r0.b : r00;
    }

    public s0 getTargets(int v) {
        s0 s00 = s0.b(((D1)this.targets_).f(v));
        return s00 == null ? s0.b : s00;
    }

    public int getTargetsCount() {
        return this.targets_.size();
    }

    public List getTargetsList() {
        return new M1(this.targets_, DescriptorProtos.FieldOptions.targets_converter_);
    }

    public DescriptorProtos.UninterpretedOption getUninterpretedOption(int v) {
        return (DescriptorProtos.UninterpretedOption)this.uninterpretedOption_.get(v);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public V0 getUninterpretedOptionOrBuilder(int v) {
        return (V0)this.uninterpretedOption_.get(v);
    }

    public List getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public boolean getUnverifiedLazy() {
        return this.unverifiedLazy_;
    }

    public boolean getWeak() {
        return this.weak_;
    }

    public boolean hasCtype() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDebugRedact() {
        return (this.bitField0_ & 0x80) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 0x20) != 0;
    }

    public boolean hasFeatureSupport() {
        return (this.bitField0_ & 0x400) != 0;
    }

    public boolean hasFeatures() {
        return (this.bitField0_ & 0x200) != 0;
    }

    public boolean hasJstype() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLazy() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPacked() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRetention() {
        return (this.bitField0_ & 0x100) != 0;
    }

    public boolean hasUnverifiedLazy() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasWeak() {
        return (this.bitField0_ & 0x40) != 0;
    }

    private void mergeFeatureSupport(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$FieldOptions$FeatureSupport0.getClass();
        if(this.featureSupport_ == null || this.featureSupport_ == FeatureSupport.getDefaultInstance()) {
            this.featureSupport_ = descriptorProtos$FieldOptions$FeatureSupport0;
        }
        else {
            p0 p00 = FeatureSupport.newBuilder(this.featureSupport_);
            p00.f(descriptorProtos$FieldOptions$FeatureSupport0);
            this.featureSupport_ = (FeatureSupport)p00.b();
        }
        this.bitField0_ |= 0x400;
    }

    private void mergeFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        if(this.features_ == null || this.features_ == DescriptorProtos.FeatureSet.getDefaultInstance()) {
            this.features_ = descriptorProtos$FeatureSet0;
        }
        else {
            T t0 = DescriptorProtos.FeatureSet.newBuilder(this.features_);
            t0.f(descriptorProtos$FeatureSet0);
            this.features_ = (DescriptorProtos.FeatureSet)t0.i();
        }
        this.bitField0_ |= 0x200;
    }

    public static l0 newBuilder() {
        return (l0)DescriptorProtos.FieldOptions.DEFAULT_INSTANCE.createBuilder();
    }

    public static l0 newBuilder(DescriptorProtos.FieldOptions descriptorProtos$FieldOptions0) {
        return (l0)DescriptorProtos.FieldOptions.DEFAULT_INSTANCE.createBuilder(descriptorProtos$FieldOptions0);
    }

    public static DescriptorProtos.FieldOptions parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.FieldOptions)A1.parseDelimitedFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FieldOptions parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FieldOptions)A1.parseDelimitedFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FieldOptions parseFrom(o o0) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.FieldOptions parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.FieldOptions parseFrom(t t0) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.FieldOptions parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.FieldOptions parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.FieldOptions parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.FieldOptions parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.FieldOptions parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.FieldOptions parseFrom(byte[] arr_b) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.FieldOptions parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.FieldOptions)A1.parseFrom(DescriptorProtos.FieldOptions.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.FieldOptions.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEditionDefaults(int v) {
        this.ensureEditionDefaultsIsMutable();
        this.editionDefaults_.remove(v);
    }

    private void removeUninterpretedOption(int v) {
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(v);
    }

    private void setCtype(m0 m00) {
        this.ctype_ = m00.a;
        this.bitField0_ |= 1;
    }

    private void setDebugRedact(boolean z) {
        this.bitField0_ |= 0x80;
        this.debugRedact_ = z;
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 0x20;
        this.deprecated_ = z;
    }

    private void setEditionDefaults(int v, EditionDefault descriptorProtos$FieldOptions$EditionDefault0) {
        descriptorProtos$FieldOptions$EditionDefault0.getClass();
        this.ensureEditionDefaultsIsMutable();
        this.editionDefaults_.set(v, descriptorProtos$FieldOptions$EditionDefault0);
    }

    private void setFeatureSupport(FeatureSupport descriptorProtos$FieldOptions$FeatureSupport0) {
        descriptorProtos$FieldOptions$FeatureSupport0.getClass();
        this.featureSupport_ = descriptorProtos$FieldOptions$FeatureSupport0;
        this.bitField0_ |= 0x400;
    }

    private void setFeatures(DescriptorProtos.FeatureSet descriptorProtos$FeatureSet0) {
        descriptorProtos$FeatureSet0.getClass();
        this.features_ = descriptorProtos$FeatureSet0;
        this.bitField0_ |= 0x200;
    }

    private void setJstype(q0 q00) {
        this.jstype_ = q00.a;
        this.bitField0_ |= 4;
    }

    private void setLazy(boolean z) {
        this.bitField0_ |= 8;
        this.lazy_ = z;
    }

    private void setPacked(boolean z) {
        this.bitField0_ |= 2;
        this.packed_ = z;
    }

    private void setRetention(r0 r00) {
        this.retention_ = r00.a;
        this.bitField0_ |= 0x100;
    }

    private void setTargets(int v, s0 s00) {
        s00.getClass();
        this.ensureTargetsIsMutable();
        ((D1)this.targets_).i(v, s00.a);
    }

    private void setUninterpretedOption(int v, DescriptorProtos.UninterpretedOption descriptorProtos$UninterpretedOption0) {
        descriptorProtos$UninterpretedOption0.getClass();
        this.ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(v, descriptorProtos$UninterpretedOption0);
    }

    private void setUnverifiedLazy(boolean z) {
        this.bitField0_ |= 16;
        this.unverifiedLazy_ = z;
    }

    private void setWeak(boolean z) {
        this.bitField0_ |= 0x40;
        this.weak_ = z;
    }
}

