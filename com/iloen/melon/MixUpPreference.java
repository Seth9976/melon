package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.g1;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.u1;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class MixUpPreference extends A1 implements m2 {
    public static final class MixUpInfo extends A1 implements m2 {
        public static final int ARTISTIMG_FIELD_NUMBER = 12;
        public static final int ARTISTNAME_FIELD_NUMBER = 11;
        public static final int COLORTYPEINT_FIELD_NUMBER = 6;
        public static final int CONTSID_FIELD_NUMBER = 4;
        private static final MixUpInfo DEFAULT_INSTANCE = null;
        public static final int MAINTITLE_FIELD_NUMBER = 1;
        public static final int MIXTYPE_FIELD_NUMBER = 3;
        private static volatile z2 PARSER = null;
        public static final int PLAYLISTID_FIELD_NUMBER = 7;
        public static final int PLAYLISTTYPE_FIELD_NUMBER = 9;
        public static final int POOLID_FIELD_NUMBER = 8;
        public static final int RAPISCHANNELCD_FIELD_NUMBER = 5;
        public static final int SONGTITLE_FIELD_NUMBER = 13;
        public static final int SUBTITLE_FIELD_NUMBER = 2;
        public static final int TITLEKEY_FIELD_NUMBER = 10;
        private String artistImg_;
        private String artistName_;
        private int colorTypeInt_;
        private String contsId_;
        private String mainTitle_;
        private String mixType_;
        private String playlistId_;
        private String playlistType_;
        private String poolId_;
        private String rapisChannelCd_;
        private String songTitle_;
        private String subTitle_;
        private String titleKey_;

        static {
            MixUpInfo mixUpPreference$MixUpInfo0 = new MixUpInfo();
            MixUpInfo.DEFAULT_INSTANCE = mixUpPreference$MixUpInfo0;
            A1.registerDefaultInstance(MixUpInfo.class, mixUpPreference$MixUpInfo0);
        }

        private MixUpInfo() {
            this.mainTitle_ = "";
            this.subTitle_ = "";
            this.mixType_ = "";
            this.contsId_ = "";
            this.rapisChannelCd_ = "";
            this.playlistId_ = "";
            this.poolId_ = "";
            this.playlistType_ = "";
            this.titleKey_ = "";
            this.artistName_ = "";
            this.artistImg_ = "";
            this.songTitle_ = "";
        }

        private void clearArtistImg() {
            this.artistImg_ = "";
        }

        private void clearArtistName() {
            this.artistName_ = "";
        }

        private void clearColorTypeInt() {
            this.colorTypeInt_ = 0;
        }

        private void clearContsId() {
            this.contsId_ = "";
        }

        private void clearMainTitle() {
            this.mainTitle_ = "";
        }

        private void clearMixType() {
            this.mixType_ = "";
        }

        private void clearPlaylistId() {
            this.playlistId_ = "";
        }

        private void clearPlaylistType() {
            this.playlistType_ = "";
        }

        private void clearPoolId() {
            this.poolId_ = "";
        }

        private void clearRapisChannelCd() {
            this.rapisChannelCd_ = "";
        }

        private void clearSongTitle() {
            this.songTitle_ = "";
        }

        private void clearSubTitle() {
            this.subTitle_ = "";
        }

        private void clearTitleKey() {
            this.titleKey_ = "";
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            z2 z21;
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(MixUpInfo.DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007Ȉ\bȈ\tȈ\nȈ\u000BȈ\fȈ\rȈ", new Object[]{"mainTitle_", "subTitle_", "mixType_", "contsId_", "rapisChannelCd_", "colorTypeInt_", "playlistId_", "poolId_", "playlistType_", "titleKey_", "artistName_", "artistImg_", "songTitle_"});
                }
                case 3: {
                    return new MixUpInfo();
                }
                case 4: {
                    return new b(MixUpInfo.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return MixUpInfo.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = MixUpInfo.PARSER;
                    if(z20 == null) {
                        synchronized(MixUpInfo.class) {
                            z21 = MixUpInfo.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                MixUpInfo.PARSER = z21;
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

        public String getArtistImg() [...] // 潜在的解密器

        public o getArtistImgBytes() {
            return o.e(this.artistImg_);
        }

        public String getArtistName() [...] // 潜在的解密器

        public o getArtistNameBytes() {
            return o.e(this.artistName_);
        }

        public int getColorTypeInt() {
            return this.colorTypeInt_;
        }

        public String getContsId() [...] // 潜在的解密器

        public o getContsIdBytes() {
            return o.e(this.contsId_);
        }

        public static MixUpInfo getDefaultInstance() {
            return MixUpInfo.DEFAULT_INSTANCE;
        }

        public String getMainTitle() [...] // 潜在的解密器

        public o getMainTitleBytes() {
            return o.e(this.mainTitle_);
        }

        public String getMixType() [...] // 潜在的解密器

        public o getMixTypeBytes() {
            return o.e(this.mixType_);
        }

        public String getPlaylistId() [...] // 潜在的解密器

        public o getPlaylistIdBytes() {
            return o.e(this.playlistId_);
        }

        public String getPlaylistType() [...] // 潜在的解密器

        public o getPlaylistTypeBytes() {
            return o.e(this.playlistType_);
        }

        public String getPoolId() [...] // 潜在的解密器

        public o getPoolIdBytes() {
            return o.e(this.poolId_);
        }

        public String getRapisChannelCd() [...] // 潜在的解密器

        public o getRapisChannelCdBytes() {
            return o.e(this.rapisChannelCd_);
        }

        public String getSongTitle() [...] // 潜在的解密器

        public o getSongTitleBytes() {
            return o.e(this.songTitle_);
        }

        public String getSubTitle() [...] // 潜在的解密器

        public o getSubTitleBytes() {
            return o.e(this.subTitle_);
        }

        public String getTitleKey() [...] // 潜在的解密器

        public o getTitleKeyBytes() {
            return o.e(this.titleKey_);
        }

        public static b newBuilder() {
            return (b)MixUpInfo.DEFAULT_INSTANCE.createBuilder();
        }

        public static b newBuilder(MixUpInfo mixUpPreference$MixUpInfo0) {
            return (b)MixUpInfo.DEFAULT_INSTANCE.createBuilder(mixUpPreference$MixUpInfo0);
        }

        public static MixUpInfo parseDelimitedFrom(InputStream inputStream0) {
            return (MixUpInfo)A1.parseDelimitedFrom(MixUpInfo.DEFAULT_INSTANCE, inputStream0);
        }

        public static MixUpInfo parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (MixUpInfo)A1.parseDelimitedFrom(MixUpInfo.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static MixUpInfo parseFrom(o o0) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, o0);
        }

        public static MixUpInfo parseFrom(o o0, g1 g10) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, o0, g10);
        }

        public static MixUpInfo parseFrom(t t0) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, t0);
        }

        public static MixUpInfo parseFrom(t t0, g1 g10) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, t0, g10);
        }

        public static MixUpInfo parseFrom(InputStream inputStream0) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, inputStream0);
        }

        public static MixUpInfo parseFrom(InputStream inputStream0, g1 g10) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static MixUpInfo parseFrom(ByteBuffer byteBuffer0) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static MixUpInfo parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static MixUpInfo parseFrom(byte[] arr_b) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, arr_b);
        }

        public static MixUpInfo parseFrom(byte[] arr_b, g1 g10) {
            return (MixUpInfo)A1.parseFrom(MixUpInfo.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return MixUpInfo.DEFAULT_INSTANCE.getParserForType();
        }

        private void setArtistImg(String s) {
            s.getClass();
            this.artistImg_ = s;
        }

        private void setArtistImgBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.artistImg_ = o0.p();
        }

        private void setArtistName(String s) {
            s.getClass();
            this.artistName_ = s;
        }

        private void setArtistNameBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.artistName_ = o0.p();
        }

        private void setColorTypeInt(int v) {
            this.colorTypeInt_ = v;
        }

        private void setContsId(String s) {
            s.getClass();
            this.contsId_ = s;
        }

        private void setContsIdBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.contsId_ = o0.p();
        }

        private void setMainTitle(String s) {
            s.getClass();
            this.mainTitle_ = s;
        }

        private void setMainTitleBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.mainTitle_ = o0.p();
        }

        private void setMixType(String s) {
            s.getClass();
            this.mixType_ = s;
        }

        private void setMixTypeBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.mixType_ = o0.p();
        }

        private void setPlaylistId(String s) {
            s.getClass();
            this.playlistId_ = s;
        }

        private void setPlaylistIdBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.playlistId_ = o0.p();
        }

        private void setPlaylistType(String s) {
            s.getClass();
            this.playlistType_ = s;
        }

        private void setPlaylistTypeBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.playlistType_ = o0.p();
        }

        private void setPoolId(String s) {
            s.getClass();
            this.poolId_ = s;
        }

        private void setPoolIdBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.poolId_ = o0.p();
        }

        private void setRapisChannelCd(String s) {
            s.getClass();
            this.rapisChannelCd_ = s;
        }

        private void setRapisChannelCdBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.rapisChannelCd_ = o0.p();
        }

        private void setSongTitle(String s) {
            s.getClass();
            this.songTitle_ = s;
        }

        private void setSongTitleBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.songTitle_ = o0.p();
        }

        private void setSubTitle(String s) {
            s.getClass();
            this.subTitle_ = s;
        }

        private void setSubTitleBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.subTitle_ = o0.p();
        }

        private void setTitleKey(String s) {
            s.getClass();
            this.titleKey_ = s;
        }

        private void setTitleKeyBytes(o o0) {
            com.google.protobuf.b.checkByteStringIsUtf8(o0);
            this.titleKey_ = o0.p();
        }
    }

    private static final MixUpPreference DEFAULT_INSTANCE = null;
    public static final int FIRSTPOSITIONONWAITINGLIST_FIELD_NUMBER = 2;
    public static final int MIXUP_FIELD_NUMBER = 1;
    private static volatile z2 PARSER;
    private int bitField0_;
    private int firstPositionOnWaitingList_;
    private MixUpInfo mixup_;

    static {
        MixUpPreference mixUpPreference0 = new MixUpPreference();
        MixUpPreference.DEFAULT_INSTANCE = mixUpPreference0;
        A1.registerDefaultInstance(MixUpPreference.class, mixUpPreference0);
    }

    private void clearFirstPositionOnWaitingList() {
        this.firstPositionOnWaitingList_ = 0;
    }

    private void clearMixup() {
        this.mixup_ = null;
        this.bitField0_ &= -2;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(MixUpPreference.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"bitField0_", "mixup_", "firstPositionOnWaitingList_"});
            }
            case 3: {
                return new MixUpPreference();
            }
            case 4: {
                return new a(MixUpPreference.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return MixUpPreference.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = MixUpPreference.PARSER;
                if(z20 == null) {
                    Class class0 = MixUpPreference.class;
                    synchronized(class0) {
                        z2 z21 = MixUpPreference.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            MixUpPreference.PARSER = z21;
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

    public static MixUpPreference getDefaultInstance() {
        return MixUpPreference.DEFAULT_INSTANCE;
    }

    public int getFirstPositionOnWaitingList() {
        return this.firstPositionOnWaitingList_;
    }

    public MixUpInfo getMixup() {
        return this.mixup_ == null ? MixUpInfo.getDefaultInstance() : this.mixup_;
    }

    public boolean hasMixup() {
        return (this.bitField0_ & 1) != 0;
    }

    private void mergeMixup(MixUpInfo mixUpPreference$MixUpInfo0) {
        mixUpPreference$MixUpInfo0.getClass();
        if(this.mixup_ == null || this.mixup_ == MixUpInfo.getDefaultInstance()) {
            this.mixup_ = mixUpPreference$MixUpInfo0;
        }
        else {
            b b0 = MixUpInfo.newBuilder(this.mixup_);
            b0.f(mixUpPreference$MixUpInfo0);
            this.mixup_ = (MixUpInfo)b0.b();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a)MixUpPreference.DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MixUpPreference mixUpPreference0) {
        return (a)MixUpPreference.DEFAULT_INSTANCE.createBuilder(mixUpPreference0);
    }

    public static MixUpPreference parseDelimitedFrom(InputStream inputStream0) {
        return (MixUpPreference)A1.parseDelimitedFrom(MixUpPreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static MixUpPreference parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (MixUpPreference)A1.parseDelimitedFrom(MixUpPreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MixUpPreference parseFrom(o o0) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, o0);
    }

    public static MixUpPreference parseFrom(o o0, g1 g10) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, o0, g10);
    }

    public static MixUpPreference parseFrom(t t0) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, t0);
    }

    public static MixUpPreference parseFrom(t t0, g1 g10) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, t0, g10);
    }

    public static MixUpPreference parseFrom(InputStream inputStream0) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static MixUpPreference parseFrom(InputStream inputStream0, g1 g10) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MixUpPreference parseFrom(ByteBuffer byteBuffer0) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static MixUpPreference parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static MixUpPreference parseFrom(byte[] arr_b) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, arr_b);
    }

    public static MixUpPreference parseFrom(byte[] arr_b, g1 g10) {
        return (MixUpPreference)A1.parseFrom(MixUpPreference.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return MixUpPreference.DEFAULT_INSTANCE.getParserForType();
    }

    private void setFirstPositionOnWaitingList(int v) {
        this.firstPositionOnWaitingList_ = v;
    }

    private void setMixup(MixUpInfo mixUpPreference$MixUpInfo0) {
        mixUpPreference$MixUpInfo0.getClass();
        this.mixup_ = mixUpPreference$MixUpInfo0;
        this.bitField0_ |= 1;
    }
}

