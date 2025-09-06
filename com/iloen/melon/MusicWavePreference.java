package com.iloen.melon;

import com.google.protobuf.A1;
import com.google.protobuf.O1;
import com.google.protobuf.b;
import com.google.protobuf.c;
import com.google.protobuf.g1;
import com.google.protobuf.m2;
import com.google.protobuf.o;
import com.google.protobuf.t;
import com.google.protobuf.u1;
import com.google.protobuf.z1;
import com.google.protobuf.z2;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class MusicWavePreference extends A1 implements m2 {
    public static final class MusicWaveTempChannel extends A1 implements m2 {
        private static final MusicWaveTempChannel DEFAULT_INSTANCE = null;
        private static volatile z2 PARSER = null;
        public static final int SONGIDS_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 1;
        private String songIds_;
        private String title_;

        static {
            MusicWaveTempChannel musicWavePreference$MusicWaveTempChannel0 = new MusicWaveTempChannel();
            MusicWaveTempChannel.DEFAULT_INSTANCE = musicWavePreference$MusicWaveTempChannel0;
            A1.registerDefaultInstance(MusicWaveTempChannel.class, musicWavePreference$MusicWaveTempChannel0);
        }

        private MusicWaveTempChannel() {
            this.title_ = "";
            this.songIds_ = "";
        }

        private void clearSongIds() {
            this.songIds_ = "";
        }

        private void clearTitle() {
            this.title_ = "";
        }

        @Override  // com.google.protobuf.A1
        public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
            switch(z10.ordinal()) {
                case 0: {
                    return (byte)1;
                }
                case 2: {
                    return A1.newMessageInfo(MusicWaveTempChannel.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"title_", "songIds_"});
                }
                case 3: {
                    return new MusicWaveTempChannel();
                }
                case 4: {
                    return new f(MusicWaveTempChannel.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
                }
                case 5: {
                    return MusicWaveTempChannel.DEFAULT_INSTANCE;
                }
                case 6: {
                    z2 z20 = MusicWaveTempChannel.PARSER;
                    if(z20 == null) {
                        Class class0 = MusicWaveTempChannel.class;
                        synchronized(class0) {
                            z2 z21 = MusicWaveTempChannel.PARSER;
                            if(z21 == null) {
                                z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                                MusicWaveTempChannel.PARSER = z21;
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

        public static MusicWaveTempChannel getDefaultInstance() {
            return MusicWaveTempChannel.DEFAULT_INSTANCE;
        }

        public String getSongIds() [...] // 潜在的解密器

        public o getSongIdsBytes() {
            return o.e(this.songIds_);
        }

        public String getTitle() [...] // 潜在的解密器

        public o getTitleBytes() {
            return o.e(this.title_);
        }

        public static f newBuilder() {
            return (f)MusicWaveTempChannel.DEFAULT_INSTANCE.createBuilder();
        }

        public static f newBuilder(MusicWaveTempChannel musicWavePreference$MusicWaveTempChannel0) {
            return (f)MusicWaveTempChannel.DEFAULT_INSTANCE.createBuilder(musicWavePreference$MusicWaveTempChannel0);
        }

        public static MusicWaveTempChannel parseDelimitedFrom(InputStream inputStream0) {
            return (MusicWaveTempChannel)A1.parseDelimitedFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, inputStream0);
        }

        public static MusicWaveTempChannel parseDelimitedFrom(InputStream inputStream0, g1 g10) {
            return (MusicWaveTempChannel)A1.parseDelimitedFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static MusicWaveTempChannel parseFrom(o o0) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, o0);
        }

        public static MusicWaveTempChannel parseFrom(o o0, g1 g10) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, o0, g10);
        }

        public static MusicWaveTempChannel parseFrom(t t0) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, t0);
        }

        public static MusicWaveTempChannel parseFrom(t t0, g1 g10) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, t0, g10);
        }

        public static MusicWaveTempChannel parseFrom(InputStream inputStream0) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, inputStream0);
        }

        public static MusicWaveTempChannel parseFrom(InputStream inputStream0, g1 g10) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, inputStream0, g10);
        }

        public static MusicWaveTempChannel parseFrom(ByteBuffer byteBuffer0) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, byteBuffer0);
        }

        public static MusicWaveTempChannel parseFrom(ByteBuffer byteBuffer0, g1 g10) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, byteBuffer0, g10);
        }

        public static MusicWaveTempChannel parseFrom(byte[] arr_b) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, arr_b);
        }

        public static MusicWaveTempChannel parseFrom(byte[] arr_b, g1 g10) {
            return (MusicWaveTempChannel)A1.parseFrom(MusicWaveTempChannel.DEFAULT_INSTANCE, arr_b, g10);
        }

        public static z2 parser() {
            return MusicWaveTempChannel.DEFAULT_INSTANCE.getParserForType();
        }

        private void setSongIds(String s) {
            s.getClass();
            this.songIds_ = s;
        }

        private void setSongIdsBytes(o o0) {
            b.checkByteStringIsUtf8(o0);
            this.songIds_ = o0.p();
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

    public static final int CHANNELREFRESHFLAG_FIELD_NUMBER = 2;
    private static final MusicWavePreference DEFAULT_INSTANCE = null;
    public static final int ISNOTFIRSTCHAT_FIELD_NUMBER = 3;
    public static final int LASTSENTCHATTIME_FIELD_NUMBER = 4;
    private static volatile z2 PARSER = null;
    public static final int SHOWNEVENTS_FIELD_NUMBER = 5;
    public static final int TEMPCHANNEL_FIELD_NUMBER = 1;
    private int bitField0_;
    private String channelRefreshFlag_;
    private boolean isNotFirstChat_;
    private long lastSentChatTime_;
    private O1 shownEvents_;
    private MusicWaveTempChannel tempChannel_;

    static {
        MusicWavePreference musicWavePreference0 = new MusicWavePreference();
        MusicWavePreference.DEFAULT_INSTANCE = musicWavePreference0;
        A1.registerDefaultInstance(MusicWavePreference.class, musicWavePreference0);
    }

    private MusicWavePreference() {
        this.channelRefreshFlag_ = "";
        this.shownEvents_ = A1.emptyProtobufList();
    }

    private void addAllShownEvents(Iterable iterable0) {
        this.ensureShownEventsIsMutable();
        b.addAll(iterable0, this.shownEvents_);
    }

    private void addShownEvents(String s) {
        s.getClass();
        this.ensureShownEventsIsMutable();
        this.shownEvents_.add(s);
    }

    private void addShownEventsBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.ensureShownEventsIsMutable();
        this.shownEvents_.add(o0.p());
    }

    private void clearChannelRefreshFlag() {
        this.channelRefreshFlag_ = "";
    }

    private void clearIsNotFirstChat() {
        this.isNotFirstChat_ = false;
    }

    private void clearLastSentChatTime() {
        this.lastSentChatTime_ = 0L;
    }

    private void clearShownEvents() {
        this.shownEvents_ = A1.emptyProtobufList();
    }

    private void clearTempChannel() {
        this.tempChannel_ = null;
        this.bitField0_ &= -2;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(MusicWavePreference.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u0007\u0004\u0002\u0005Ț", new Object[]{"bitField0_", "tempChannel_", "channelRefreshFlag_", "isNotFirstChat_", "lastSentChatTime_", "shownEvents_"});
            }
            case 3: {
                return new MusicWavePreference();
            }
            case 4: {
                return new e(MusicWavePreference.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return MusicWavePreference.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = MusicWavePreference.PARSER;
                if(z20 == null) {
                    synchronized(MusicWavePreference.class) {
                        z21 = MusicWavePreference.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            MusicWavePreference.PARSER = z21;
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

    private void ensureShownEventsIsMutable() {
        O1 o10 = this.shownEvents_;
        if(!((c)o10).a) {
            this.shownEvents_ = A1.mutableCopy(o10);
        }
    }

    public String getChannelRefreshFlag() [...] // 潜在的解密器

    public o getChannelRefreshFlagBytes() {
        return o.e(this.channelRefreshFlag_);
    }

    public static MusicWavePreference getDefaultInstance() {
        return MusicWavePreference.DEFAULT_INSTANCE;
    }

    public boolean getIsNotFirstChat() {
        return this.isNotFirstChat_;
    }

    public long getLastSentChatTime() {
        return this.lastSentChatTime_;
    }

    public String getShownEvents(int v) {
        return (String)this.shownEvents_.get(v);
    }

    public o getShownEventsBytes(int v) {
        return o.e(((String)this.shownEvents_.get(v)));
    }

    public int getShownEventsCount() {
        return this.shownEvents_.size();
    }

    public List getShownEventsList() {
        return this.shownEvents_;
    }

    public MusicWaveTempChannel getTempChannel() {
        return this.tempChannel_ == null ? MusicWaveTempChannel.getDefaultInstance() : this.tempChannel_;
    }

    public boolean hasTempChannel() {
        return (this.bitField0_ & 1) != 0;
    }

    public static void i(MusicWavePreference musicWavePreference0) {
        musicWavePreference0.setIsNotFirstChat(true);
    }

    private void mergeTempChannel(MusicWaveTempChannel musicWavePreference$MusicWaveTempChannel0) {
        musicWavePreference$MusicWaveTempChannel0.getClass();
        if(this.tempChannel_ == null || this.tempChannel_ == MusicWaveTempChannel.getDefaultInstance()) {
            this.tempChannel_ = musicWavePreference$MusicWaveTempChannel0;
        }
        else {
            f f0 = MusicWaveTempChannel.newBuilder(this.tempChannel_);
            f0.f(musicWavePreference$MusicWaveTempChannel0);
            this.tempChannel_ = (MusicWaveTempChannel)f0.b();
        }
        this.bitField0_ |= 1;
    }

    public static e newBuilder() {
        return (e)MusicWavePreference.DEFAULT_INSTANCE.createBuilder();
    }

    public static e newBuilder(MusicWavePreference musicWavePreference0) {
        return (e)MusicWavePreference.DEFAULT_INSTANCE.createBuilder(musicWavePreference0);
    }

    public static MusicWavePreference parseDelimitedFrom(InputStream inputStream0) {
        return (MusicWavePreference)A1.parseDelimitedFrom(MusicWavePreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static MusicWavePreference parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (MusicWavePreference)A1.parseDelimitedFrom(MusicWavePreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MusicWavePreference parseFrom(o o0) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, o0);
    }

    public static MusicWavePreference parseFrom(o o0, g1 g10) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, o0, g10);
    }

    public static MusicWavePreference parseFrom(t t0) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, t0);
    }

    public static MusicWavePreference parseFrom(t t0, g1 g10) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, t0, g10);
    }

    public static MusicWavePreference parseFrom(InputStream inputStream0) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, inputStream0);
    }

    public static MusicWavePreference parseFrom(InputStream inputStream0, g1 g10) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static MusicWavePreference parseFrom(ByteBuffer byteBuffer0) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static MusicWavePreference parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static MusicWavePreference parseFrom(byte[] arr_b) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, arr_b);
    }

    public static MusicWavePreference parseFrom(byte[] arr_b, g1 g10) {
        return (MusicWavePreference)A1.parseFrom(MusicWavePreference.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return MusicWavePreference.DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelRefreshFlag(String s) {
        s.getClass();
        this.channelRefreshFlag_ = s;
    }

    private void setChannelRefreshFlagBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.channelRefreshFlag_ = o0.p();
    }

    private void setIsNotFirstChat(boolean z) {
        this.isNotFirstChat_ = z;
    }

    private void setLastSentChatTime(long v) {
        this.lastSentChatTime_ = v;
    }

    private void setShownEvents(int v, String s) {
        s.getClass();
        this.ensureShownEventsIsMutable();
        this.shownEvents_.set(v, s);
    }

    private void setTempChannel(MusicWaveTempChannel musicWavePreference$MusicWaveTempChannel0) {
        musicWavePreference$MusicWaveTempChannel0.getClass();
        this.tempChannel_ = musicWavePreference$MusicWaveTempChannel0;
        this.bitField0_ |= 1;
    }
}

