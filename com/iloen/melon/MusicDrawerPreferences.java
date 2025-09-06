package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.b;
import com.google.protobuf.g1;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.u1;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class MusicDrawerPreferences extends A1 implements m2 {
    public static final class DrawerPlytInfo extends A1 implements m2 {
        public static final int CONTSID_FIELD_NUMBER = 2;
        public static final int CONTSTYPECODE_FIELD_NUMBER = 3;
        private static final DrawerPlytInfo DEFAULT_INSTANCE = null;
        public static final int ISOWNER_FIELD_NUMBER = 8;
        public static final int LANDINGFROMSTR_FIELD_NUMBER = 9;
        public static final int LANDINGFROM_FIELD_NUMBER = 1;
        public static final int MENUID_FIELD_NUMBER = 6;
        private static volatile z2 PARSER = null;
        public static final int SEEDCONTSID_FIELD_NUMBER = 4;
        public static final int SEEDCONTSTYPECODE_FIELD_NUMBER = 5;
        public static final int TITLE_FIELD_NUMBER = 7;
        private String contsId_;
        private String contsTypeCode_;
        private boolean isOwner_;
        private String landingFromStr_;
        private int landingFrom_;
        private String menuId_;
        private String seedContsId_;
        private String seedContsTypeCode_;
        private String title_;

        static {
            DrawerPlytInfo musicDrawerPreferences$DrawerPlytInfo0 = new DrawerPlytInfo();
            DrawerPlytInfo.DEFAULT_INSTANCE = musicDrawerPreferences$DrawerPlytInfo0;
            A1.registerDefaultInstance(DrawerPlytInfo.class, musicDrawerPreferences$DrawerPlytInfo0);
        }

        private DrawerPlytInfo() {
            this.contsId_ = "";
            this.contsTypeCode_ = "";
            this.seedContsId_ = "";
            this.seedContsTypeCode_ = "";
            this.menuId_ = "";
            this.title_ = "";
            this.landingFromStr_ = "";
        }

        private void clearContsId() {
            this.contsId_ = "";
        }

        private void clearContsTypeCode() {
            this.contsTypeCode_ = "";
        }

        private void clearIsOwner() {
            this.isOwner_ = false;
        }

        private void clearLandingFrom() {
            this.landingFrom_ = 0;
        }

        private void clearLandingFromStr() {
            this.landingFromStr_ = "";
        }

        private void clearMenuId() {
            this.menuId_ = "";
        }

        private void clearSeedContsId() {
            this.seedContsId_ = "";
        }

        private void clearSeedContsTypeCode() {
            this.seedContsTypeCode_ = "";
        }

        private void clearTitle() {
            this.title_ = "";
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            z2 z21;
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(DrawerPlytInfo.DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0007\tȈ", new Object[]{"landingFrom_", "contsId_", "contsTypeCode_", "seedContsId_", "seedContsTypeCode_", "menuId_", "title_", "isOwner_", "landingFromStr_"});
                }
                case 3: {
                    return new DrawerPlytInfo();
                }
                case 4: {
                    return new d(DrawerPlytInfo.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return DrawerPlytInfo.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = DrawerPlytInfo.PARSER;
                    if(z20 == null) {
                        synchronized(DrawerPlytInfo.class) {
                            z21 = DrawerPlytInfo.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                DrawerPlytInfo.PARSER = z21;
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

        public String getContsId() [...] // 潜在的解密器

        public o getContsIdBytes() {
            return o.e(this.contsId_);
        }

        public String getContsTypeCode() [...] // 潜在的解密器

        public o getContsTypeCodeBytes() {
            return o.e(this.contsTypeCode_);
        }

        public static DrawerPlytInfo getDefaultInstance() {
            return DrawerPlytInfo.DEFAULT_INSTANCE;
        }

        public boolean getIsOwner() {
            return this.isOwner_;
        }

        public int getLandingFrom() {
            return this.landingFrom_;
        }

        public String getLandingFromStr() [...] // 潜在的解密器

        public o getLandingFromStrBytes() {
            return o.e(this.landingFromStr_);
        }

        public String getMenuId() [...] // 潜在的解密器

        public o getMenuIdBytes() {
            return o.e(this.menuId_);
        }

        public String getSeedContsId() [...] // 潜在的解密器

        public o getSeedContsIdBytes() {
            return o.e(this.seedContsId_);
        }

        public String getSeedContsTypeCode() [...] // 潜在的解密器

        public o getSeedContsTypeCodeBytes() {
            return o.e(this.seedContsTypeCode_);
        }

        public String getTitle() [...] // 潜在的解密器

        public o getTitleBytes() {
            return o.e(this.title_);
        }

        public static void i(DrawerPlytInfo musicDrawerPreferences$DrawerPlytInfo0) {
            musicDrawerPreferences$DrawerPlytInfo0.setLandingFrom(-1);
        }

        public static d newBuilder() {
            return (d)DrawerPlytInfo.DEFAULT_INSTANCE.createBuilder();
        }

        public static d newBuilder(DrawerPlytInfo musicDrawerPreferences$DrawerPlytInfo0) {
            return (d)DrawerPlytInfo.DEFAULT_INSTANCE.createBuilder(musicDrawerPreferences$DrawerPlytInfo0);
        }

        public static DrawerPlytInfo parseDelimitedFrom(InputStream inputStream0) {
            return (DrawerPlytInfo)A1.parseDelimitedFrom(DrawerPlytInfo.DEFAULT_INSTANCE, inputStream0);
        }

        public static DrawerPlytInfo parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (DrawerPlytInfo)A1.parseDelimitedFrom(DrawerPlytInfo.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static DrawerPlytInfo parseFrom(o o0) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, o0);
        }

        public static DrawerPlytInfo parseFrom(o o0, g1 g10) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, o0, g10);
        }

        public static DrawerPlytInfo parseFrom(t t0) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, t0);
        }

        public static DrawerPlytInfo parseFrom(t t0, g1 g10) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, t0, g10);
        }

        public static DrawerPlytInfo parseFrom(InputStream inputStream0) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, inputStream0);
        }

        public static DrawerPlytInfo parseFrom(InputStream inputStream0, g1 g10) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static DrawerPlytInfo parseFrom(ByteBuffer byteBuffer0) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static DrawerPlytInfo parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static DrawerPlytInfo parseFrom(byte[] arr_b) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, arr_b);
        }

        public static DrawerPlytInfo parseFrom(byte[] arr_b, g1 g10) {
            return (DrawerPlytInfo)A1.parseFrom(DrawerPlytInfo.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return DrawerPlytInfo.DEFAULT_INSTANCE.getParserForType();
        }

        private void setContsId(String s) {
            s.getClass();
            this.contsId_ = s;
        }

        private void setContsIdBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.contsId_ = o0.p();
        }

        private void setContsTypeCode(String s) {
            s.getClass();
            this.contsTypeCode_ = s;
        }

        private void setContsTypeCodeBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.contsTypeCode_ = o0.p();
        }

        private void setIsOwner(boolean z) {
            this.isOwner_ = z;
        }

        private void setLandingFrom(int v) {
            this.landingFrom_ = v;
        }

        private void setLandingFromStr(String s) {
            s.getClass();
            this.landingFromStr_ = s;
        }

        private void setLandingFromStrBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.landingFromStr_ = o0.p();
        }

        private void setMenuId(String s) {
            s.getClass();
            this.menuId_ = s;
        }

        private void setMenuIdBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.menuId_ = o0.p();
        }

        private void setSeedContsId(String s) {
            s.getClass();
            this.seedContsId_ = s;
        }

        private void setSeedContsIdBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.seedContsId_ = o0.p();
        }

        private void setSeedContsTypeCode(String s) {
            s.getClass();
            this.seedContsTypeCode_ = s;
        }

        private void setSeedContsTypeCodeBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.seedContsTypeCode_ = o0.p();
        }

        private void setTitle(String s) {
            s.getClass();
            this.title_ = s;
        }

        private void setTitleBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.title_ = o0.p();
        }
    }

    private static final MusicDrawerPreferences DEFAULT_INSTANCE = null;
    public static final int LASTDRAWERPLYTINFO_FIELD_NUMBER = 3;
    public static final int LASTTAB_FIELD_NUMBER = 4;
    private static volatile z2 PARSER = null;
    public static final int VIEWMODESTR_FIELD_NUMBER = 5;
    private int bitField0_;
    private DrawerPlytInfo lastDrawerPlytInfo_;
    private String lastTab_;
    private String viewModeStr_;

    static {
        MusicDrawerPreferences musicDrawerPreferences0 = new MusicDrawerPreferences();
        MusicDrawerPreferences.DEFAULT_INSTANCE = musicDrawerPreferences0;
        A1.registerDefaultInstance(MusicDrawerPreferences.class, musicDrawerPreferences0);
    }

    private MusicDrawerPreferences() {
        this.lastTab_ = "";
        this.viewModeStr_ = "";
    }

    private void clearLastDrawerPlytInfo() {
        this.lastDrawerPlytInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLastTab() {
        this.lastTab_ = "";
    }

    private void clearViewModeStr() {
        this.viewModeStr_ = "";
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(MusicDrawerPreferences.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0000\u0003ဉ\u0000\u0004Ȉ\u0005Ȉ", new Object[]{"bitField0_", "lastDrawerPlytInfo_", "lastTab_", "viewModeStr_"});
            }
            case 3: {
                return new MusicDrawerPreferences();
            }
            case 4: {
                return new c(MusicDrawerPreferences.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return MusicDrawerPreferences.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = MusicDrawerPreferences.PARSER;
                if(z20 == null) {
                    Class class0 = MusicDrawerPreferences.class;
                    synchronized(class0) {
                        z2 z21 = MusicDrawerPreferences.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            MusicDrawerPreferences.PARSER = z21;
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

    public static MusicDrawerPreferences getDefaultInstance() {
        return MusicDrawerPreferences.DEFAULT_INSTANCE;
    }

    public DrawerPlytInfo getLastDrawerPlytInfo() {
        return this.lastDrawerPlytInfo_ == null ? DrawerPlytInfo.getDefaultInstance() : this.lastDrawerPlytInfo_;
    }

    public String getLastTab() [...] // 潜在的解密器

    public o getLastTabBytes() {
        return o.e(this.lastTab_);
    }

    public String getViewModeStr() [...] // 潜在的解密器

    public o getViewModeStrBytes() {
        return o.e(this.viewModeStr_);
    }

    public boolean hasLastDrawerPlytInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    private void mergeLastDrawerPlytInfo(DrawerPlytInfo musicDrawerPreferences$DrawerPlytInfo0) {
        musicDrawerPreferences$DrawerPlytInfo0.getClass();
        if(this.lastDrawerPlytInfo_ == null || this.lastDrawerPlytInfo_ == DrawerPlytInfo.getDefaultInstance()) {
            this.lastDrawerPlytInfo_ = musicDrawerPreferences$DrawerPlytInfo0;
        }
        else {
            d d0 = DrawerPlytInfo.newBuilder(this.lastDrawerPlytInfo_);
            d0.f(musicDrawerPreferences$DrawerPlytInfo0);
            this.lastDrawerPlytInfo_ = (DrawerPlytInfo)d0.b();
        }
        this.bitField0_ |= 1;
    }

    public static c newBuilder() {
        return (c)MusicDrawerPreferences.DEFAULT_INSTANCE.createBuilder();
    }

    public static c newBuilder(MusicDrawerPreferences musicDrawerPreferences0) {
        return (c)MusicDrawerPreferences.DEFAULT_INSTANCE.createBuilder(musicDrawerPreferences0);
    }

    public static MusicDrawerPreferences parseDelimitedFrom(InputStream inputStream0) {
        return (MusicDrawerPreferences)A1.parseDelimitedFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static MusicDrawerPreferences parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (MusicDrawerPreferences)A1.parseDelimitedFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MusicDrawerPreferences parseFrom(o o0) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, o0);
    }

    public static MusicDrawerPreferences parseFrom(o o0, g1 g10) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, o0, g10);
    }

    public static MusicDrawerPreferences parseFrom(t t0) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, t0);
    }

    public static MusicDrawerPreferences parseFrom(t t0, g1 g10) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, t0, g10);
    }

    public static MusicDrawerPreferences parseFrom(InputStream inputStream0) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static MusicDrawerPreferences parseFrom(InputStream inputStream0, g1 g10) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MusicDrawerPreferences parseFrom(ByteBuffer byteBuffer0) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static MusicDrawerPreferences parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static MusicDrawerPreferences parseFrom(byte[] arr_b) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, arr_b);
    }

    public static MusicDrawerPreferences parseFrom(byte[] arr_b, g1 g10) {
        return (MusicDrawerPreferences)A1.parseFrom(MusicDrawerPreferences.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return MusicDrawerPreferences.DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastDrawerPlytInfo(DrawerPlytInfo musicDrawerPreferences$DrawerPlytInfo0) {
        musicDrawerPreferences$DrawerPlytInfo0.getClass();
        this.lastDrawerPlytInfo_ = musicDrawerPreferences$DrawerPlytInfo0;
        this.bitField0_ |= 1;
    }

    private void setLastTab(String s) {
        s.getClass();
        this.lastTab_ = s;
    }

    private void setLastTabBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.lastTab_ = o0.p();
    }

    private void setViewModeStr(String s) {
        s.getClass();
        this.viewModeStr_ = s;
    }

    private void setViewModeStrBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.viewModeStr_ = o0.p();
    }
}

