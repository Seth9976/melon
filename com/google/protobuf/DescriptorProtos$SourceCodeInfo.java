package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class DescriptorProtos.SourceCodeInfo extends GeneratedMessageLite.ExtendableMessage {
    public static final class Location extends A1 implements Q0 {
        private static final Location DEFAULT_INSTANCE = null;
        public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
        public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
        private static volatile z2 PARSER = null;
        public static final int PATH_FIELD_NUMBER = 1;
        public static final int SPAN_FIELD_NUMBER = 2;
        public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
        private int bitField0_;
        private String leadingComments_;
        private O1 leadingDetachedComments_;
        private int pathMemoizedSerializedSize;
        private K1 path_;
        private int spanMemoizedSerializedSize;
        private K1 span_;
        private String trailingComments_;

        static {
            Location descriptorProtos$SourceCodeInfo$Location0 = new Location();
            Location.DEFAULT_INSTANCE = descriptorProtos$SourceCodeInfo$Location0;
            A1.registerDefaultInstance(Location.class, descriptorProtos$SourceCodeInfo$Location0);
        }

        private Location() {
            this.pathMemoizedSerializedSize = -1;
            this.spanMemoizedSerializedSize = -1;
            this.path_ = A1.emptyIntList();
            this.span_ = A1.emptyIntList();
            this.leadingComments_ = "";
            this.trailingComments_ = "";
            this.leadingDetachedComments_ = A1.emptyProtobufList();
        }

        public static void access$57300(Location descriptorProtos$SourceCodeInfo$Location0, int v, int v1) {
            descriptorProtos$SourceCodeInfo$Location0.setPath(v, v1);
        }

        public static void access$57400(Location descriptorProtos$SourceCodeInfo$Location0, int v) {
            descriptorProtos$SourceCodeInfo$Location0.addPath(v);
        }

        public static void access$57500(Location descriptorProtos$SourceCodeInfo$Location0, Iterable iterable0) {
            descriptorProtos$SourceCodeInfo$Location0.addAllPath(iterable0);
        }

        public static void access$57600(Location descriptorProtos$SourceCodeInfo$Location0) {
            descriptorProtos$SourceCodeInfo$Location0.clearPath();
        }

        public static void access$57700(Location descriptorProtos$SourceCodeInfo$Location0, int v, int v1) {
            descriptorProtos$SourceCodeInfo$Location0.setSpan(v, v1);
        }

        public static void access$57800(Location descriptorProtos$SourceCodeInfo$Location0, int v) {
            descriptorProtos$SourceCodeInfo$Location0.addSpan(v);
        }

        public static void access$57900(Location descriptorProtos$SourceCodeInfo$Location0, Iterable iterable0) {
            descriptorProtos$SourceCodeInfo$Location0.addAllSpan(iterable0);
        }

        public static void access$58000(Location descriptorProtos$SourceCodeInfo$Location0) {
            descriptorProtos$SourceCodeInfo$Location0.clearSpan();
        }

        public static void access$58100(Location descriptorProtos$SourceCodeInfo$Location0, String s) {
            descriptorProtos$SourceCodeInfo$Location0.setLeadingComments(s);
        }

        public static void access$58200(Location descriptorProtos$SourceCodeInfo$Location0) {
            descriptorProtos$SourceCodeInfo$Location0.clearLeadingComments();
        }

        public static void access$58300(Location descriptorProtos$SourceCodeInfo$Location0, o o0) {
            descriptorProtos$SourceCodeInfo$Location0.setLeadingCommentsBytes(o0);
        }

        public static void access$58400(Location descriptorProtos$SourceCodeInfo$Location0, String s) {
            descriptorProtos$SourceCodeInfo$Location0.setTrailingComments(s);
        }

        public static void access$58500(Location descriptorProtos$SourceCodeInfo$Location0) {
            descriptorProtos$SourceCodeInfo$Location0.clearTrailingComments();
        }

        public static void access$58600(Location descriptorProtos$SourceCodeInfo$Location0, o o0) {
            descriptorProtos$SourceCodeInfo$Location0.setTrailingCommentsBytes(o0);
        }

        public static void access$58700(Location descriptorProtos$SourceCodeInfo$Location0, int v, String s) {
            descriptorProtos$SourceCodeInfo$Location0.setLeadingDetachedComments(v, s);
        }

        public static void access$58800(Location descriptorProtos$SourceCodeInfo$Location0, String s) {
            descriptorProtos$SourceCodeInfo$Location0.addLeadingDetachedComments(s);
        }

        public static void access$58900(Location descriptorProtos$SourceCodeInfo$Location0, Iterable iterable0) {
            descriptorProtos$SourceCodeInfo$Location0.addAllLeadingDetachedComments(iterable0);
        }

        public static void access$59000(Location descriptorProtos$SourceCodeInfo$Location0) {
            descriptorProtos$SourceCodeInfo$Location0.clearLeadingDetachedComments();
        }

        public static void access$59100(Location descriptorProtos$SourceCodeInfo$Location0, o o0) {
            descriptorProtos$SourceCodeInfo$Location0.addLeadingDetachedCommentsBytes(o0);
        }

        private void addAllLeadingDetachedComments(Iterable iterable0) {
            this.ensureLeadingDetachedCommentsIsMutable();
            b.addAll(iterable0, this.leadingDetachedComments_);
        }

        private void addAllPath(Iterable iterable0) {
            this.ensurePathIsMutable();
            b.addAll(iterable0, this.path_);
        }

        private void addAllSpan(Iterable iterable0) {
            this.ensureSpanIsMutable();
            b.addAll(iterable0, this.span_);
        }

        private void addLeadingDetachedComments(String s) {
            s.getClass();
            this.ensureLeadingDetachedCommentsIsMutable();
            this.leadingDetachedComments_.add(s);
        }

        private void addLeadingDetachedCommentsBytes(o o0) {
            this.ensureLeadingDetachedCommentsIsMutable();
            this.leadingDetachedComments_.add(o0.p());
        }

        private void addPath(int v) {
            this.ensurePathIsMutable();
            ((D1)this.path_).d(v);
        }

        private void addSpan(int v) {
            this.ensureSpanIsMutable();
            ((D1)this.span_).d(v);
        }

        private void clearLeadingComments() {
            this.bitField0_ &= -2;
            this.leadingComments_ = "";
        }

        private void clearLeadingDetachedComments() {
            this.leadingDetachedComments_ = A1.emptyProtobufList();
        }

        private void clearPath() {
            this.path_ = A1.emptyIntList();
        }

        private void clearSpan() {
            this.span_ = A1.emptyIntList();
        }

        private void clearTrailingComments() {
            this.bitField0_ &= -3;
            this.trailingComments_ = "";
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            z2 z21;
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(Location.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001\'\u0002\'\u0003ဈ\u0000\u0004ဈ\u0001\u0006\u001A", new Object[]{"bitField0_", "path_", "span_", "leadingComments_", "trailingComments_", "leadingDetachedComments_"});
                }
                case 3: {
                    return new Location();
                }
                case 4: {
                    return new P0(Location.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return Location.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = Location.PARSER;
                    if(z20 == null) {
                        synchronized(Location.class) {
                            z21 = Location.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                Location.PARSER = z21;
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

        private void ensureLeadingDetachedCommentsIsMutable() {
            O1 o10 = this.leadingDetachedComments_;
            if(!((c)o10).a) {
                this.leadingDetachedComments_ = A1.mutableCopy(o10);
            }
        }

        private void ensurePathIsMutable() {
            K1 k10 = this.path_;
            if(!((c)k10).a) {
                this.path_ = A1.mutableCopy(k10);
            }
        }

        private void ensureSpanIsMutable() {
            K1 k10 = this.span_;
            if(!((c)k10).a) {
                this.span_ = A1.mutableCopy(k10);
            }
        }

        public static Location getDefaultInstance() {
            return Location.DEFAULT_INSTANCE;
        }

        public String getLeadingComments() [...] // 潜在的解密器

        public o getLeadingCommentsBytes() {
            return o.e(this.leadingComments_);
        }

        public String getLeadingDetachedComments(int v) {
            return (String)this.leadingDetachedComments_.get(v);
        }

        public o getLeadingDetachedCommentsBytes(int v) {
            return o.e(((String)this.leadingDetachedComments_.get(v)));
        }

        public int getLeadingDetachedCommentsCount() {
            return this.leadingDetachedComments_.size();
        }

        public List getLeadingDetachedCommentsList() {
            return this.leadingDetachedComments_;
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

        public int getSpan(int v) {
            return ((D1)this.span_).f(v);
        }

        public int getSpanCount() {
            return this.span_.size();
        }

        public List getSpanList() {
            return this.span_;
        }

        public String getTrailingComments() [...] // 潜在的解密器

        public o getTrailingCommentsBytes() {
            return o.e(this.trailingComments_);
        }

        public boolean hasLeadingComments() {
            return (this.bitField0_ & 1) != 0;
        }

        public boolean hasTrailingComments() {
            return (this.bitField0_ & 2) != 0;
        }

        public static P0 newBuilder() {
            return (P0)Location.DEFAULT_INSTANCE.createBuilder();
        }

        public static P0 newBuilder(Location descriptorProtos$SourceCodeInfo$Location0) {
            return (P0)Location.DEFAULT_INSTANCE.createBuilder(descriptorProtos$SourceCodeInfo$Location0);
        }

        public static Location parseDelimitedFrom(InputStream inputStream0) {
            return (Location)A1.parseDelimitedFrom(Location.DEFAULT_INSTANCE, inputStream0);
        }

        public static Location parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (Location)A1.parseDelimitedFrom(Location.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static Location parseFrom(o o0) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, o0);
        }

        public static Location parseFrom(o o0, g1 g10) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, o0, g10);
        }

        public static Location parseFrom(t t0) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, t0);
        }

        public static Location parseFrom(t t0, g1 g10) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, t0, g10);
        }

        public static Location parseFrom(InputStream inputStream0) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, inputStream0);
        }

        public static Location parseFrom(InputStream inputStream0, g1 g10) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static Location parseFrom(ByteBuffer byteBuffer0) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static Location parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static Location parseFrom(byte[] arr_b) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, arr_b);
        }

        public static Location parseFrom(byte[] arr_b, g1 g10) {
            return (Location)A1.parseFrom(Location.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return Location.DEFAULT_INSTANCE.getParserForType();
        }

        private void setLeadingComments(String s) {
            s.getClass();
            this.bitField0_ |= 1;
            this.leadingComments_ = s;
        }

        private void setLeadingCommentsBytes(o o0) {
            this.leadingComments_ = o0.p();
            this.bitField0_ |= 1;
        }

        private void setLeadingDetachedComments(int v, String s) {
            s.getClass();
            this.ensureLeadingDetachedCommentsIsMutable();
            this.leadingDetachedComments_.set(v, s);
        }

        private void setPath(int v, int v1) {
            this.ensurePathIsMutable();
            ((D1)this.path_).i(v, v1);
        }

        private void setSpan(int v, int v1) {
            this.ensureSpanIsMutable();
            ((D1)this.span_).i(v, v1);
        }

        private void setTrailingComments(String s) {
            s.getClass();
            this.bitField0_ |= 2;
            this.trailingComments_ = s;
        }

        private void setTrailingCommentsBytes(o o0) {
            this.trailingComments_ = o0.p();
            this.bitField0_ |= 2;
        }
    }

    private static final DescriptorProtos.SourceCodeInfo DEFAULT_INSTANCE = null;
    public static final int LOCATION_FIELD_NUMBER = 1;
    private static volatile z2 PARSER;
    private O1 location_;
    private byte memoizedIsInitialized;

    static {
        DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0 = new DescriptorProtos.SourceCodeInfo();
        DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE = descriptorProtos$SourceCodeInfo0;
        A1.registerDefaultInstance(DescriptorProtos.SourceCodeInfo.class, descriptorProtos$SourceCodeInfo0);
    }

    private DescriptorProtos.SourceCodeInfo() {
        this.memoizedIsInitialized = 2;
        this.location_ = A1.emptyProtobufList();
    }

    public static void access$59400(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0, int v, Location descriptorProtos$SourceCodeInfo$Location0) {
        descriptorProtos$SourceCodeInfo0.setLocation(v, descriptorProtos$SourceCodeInfo$Location0);
    }

    public static void access$59500(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0, Location descriptorProtos$SourceCodeInfo$Location0) {
        descriptorProtos$SourceCodeInfo0.addLocation(descriptorProtos$SourceCodeInfo$Location0);
    }

    public static void access$59600(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0, int v, Location descriptorProtos$SourceCodeInfo$Location0) {
        descriptorProtos$SourceCodeInfo0.addLocation(v, descriptorProtos$SourceCodeInfo$Location0);
    }

    public static void access$59700(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0, Iterable iterable0) {
        descriptorProtos$SourceCodeInfo0.addAllLocation(iterable0);
    }

    public static void access$59800(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0) {
        descriptorProtos$SourceCodeInfo0.clearLocation();
    }

    public static void access$59900(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0, int v) {
        descriptorProtos$SourceCodeInfo0.removeLocation(v);
    }

    private void addAllLocation(Iterable iterable0) {
        this.ensureLocationIsMutable();
        b.addAll(iterable0, this.location_);
    }

    private void addLocation(int v, Location descriptorProtos$SourceCodeInfo$Location0) {
        descriptorProtos$SourceCodeInfo$Location0.getClass();
        this.ensureLocationIsMutable();
        this.location_.add(v, descriptorProtos$SourceCodeInfo$Location0);
    }

    private void addLocation(Location descriptorProtos$SourceCodeInfo$Location0) {
        descriptorProtos$SourceCodeInfo$Location0.getClass();
        this.ensureLocationIsMutable();
        this.location_.add(descriptorProtos$SourceCodeInfo$Location0);
    }

    private void clearLocation() {
        this.location_ = A1.emptyProtobufList();
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
                return A1.newMessageInfo(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001B", new Object[]{"location_", Location.class});
            }
            case 3: {
                return new DescriptorProtos.SourceCodeInfo();
            }
            case 4: {
                return new O0(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = DescriptorProtos.SourceCodeInfo.PARSER;
                if(z20 == null) {
                    Class class0 = DescriptorProtos.SourceCodeInfo.class;
                    synchronized(class0) {
                        z2 z21 = DescriptorProtos.SourceCodeInfo.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            DescriptorProtos.SourceCodeInfo.PARSER = z21;
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

    private void ensureLocationIsMutable() {
        O1 o10 = this.location_;
        if(!((c)o10).a) {
            this.location_ = A1.mutableCopy(o10);
        }
    }

    public static DescriptorProtos.SourceCodeInfo getDefaultInstance() {
        return DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE;
    }

    public Location getLocation(int v) {
        return (Location)this.location_.get(v);
    }

    public int getLocationCount() {
        return this.location_.size();
    }

    public List getLocationList() {
        return this.location_;
    }

    public Q0 getLocationOrBuilder(int v) {
        return (Q0)this.location_.get(v);
    }

    public List getLocationOrBuilderList() {
        return this.location_;
    }

    public static O0 newBuilder() {
        return (O0)DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static O0 newBuilder(DescriptorProtos.SourceCodeInfo descriptorProtos$SourceCodeInfo0) {
        return (O0)DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE.createBuilder(descriptorProtos$SourceCodeInfo0);
    }

    public static DescriptorProtos.SourceCodeInfo parseDelimitedFrom(InputStream inputStream0) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseDelimitedFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.SourceCodeInfo parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseDelimitedFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(o o0) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, o0);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(o o0, g1 g10) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, o0, g10);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(t t0) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, t0);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(t t0, g1 g10) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, t0, g10);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(InputStream inputStream0) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, inputStream0);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(InputStream inputStream0, g1 g10) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(ByteBuffer byteBuffer0) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(byte[] arr_b) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, arr_b);
    }

    public static DescriptorProtos.SourceCodeInfo parseFrom(byte[] arr_b, g1 g10) {
        return (DescriptorProtos.SourceCodeInfo)A1.parseFrom(DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return DescriptorProtos.SourceCodeInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void removeLocation(int v) {
        this.ensureLocationIsMutable();
        this.location_.remove(v);
    }

    private void setLocation(int v, Location descriptorProtos$SourceCodeInfo$Location0) {
        descriptorProtos$SourceCodeInfo$Location0.getClass();
        this.ensureLocationIsMutable();
        this.location_.set(v, descriptorProtos$SourceCodeInfo$Location0);
    }
}

