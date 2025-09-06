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
import k8.r;

public final class EachPlytSettingPreferences extends A1 implements m2 {
    private static final EachPlytSettingPreferences DEFAULT_INSTANCE = null;
    public static final int LASTUNIQUEID_FIELD_NUMBER = 1;
    private static volatile z2 PARSER = null;
    public static final int PLAYEDTIME_FIELD_NUMBER = 2;
    public static final int SECTIONREPEATENDPOS_FIELD_NUMBER = 5;
    public static final int SECTIONREPEATSTARTPOS_FIELD_NUMBER = 4;
    public static final int SELECTEDREPEATUNIQUEID_FIELD_NUMBER = 6;
    public static final int SORTTYPE_FIELD_NUMBER = 3;
    private String lastUniqueId_;
    private long playedTime_;
    private int sectionRepeatEndPos_;
    private int sectionRepeatStartPos_;
    private O1 selectedRepeatUniqueId_;
    private int sortType_;

    static {
        EachPlytSettingPreferences eachPlytSettingPreferences0 = new EachPlytSettingPreferences();
        EachPlytSettingPreferences.DEFAULT_INSTANCE = eachPlytSettingPreferences0;
        A1.registerDefaultInstance(EachPlytSettingPreferences.class, eachPlytSettingPreferences0);
    }

    private EachPlytSettingPreferences() {
        this.lastUniqueId_ = "";
        this.selectedRepeatUniqueId_ = A1.emptyProtobufList();
    }

    private void addAllSelectedRepeatUniqueId(Iterable iterable0) {
        this.ensureSelectedRepeatUniqueIdIsMutable();
        b.addAll(iterable0, this.selectedRepeatUniqueId_);
    }

    private void addSelectedRepeatUniqueId(String s) {
        s.getClass();
        this.ensureSelectedRepeatUniqueIdIsMutable();
        this.selectedRepeatUniqueId_.add(s);
    }

    private void addSelectedRepeatUniqueIdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.ensureSelectedRepeatUniqueIdIsMutable();
        this.selectedRepeatUniqueId_.add(o0.p());
    }

    private void clearLastUniqueId() {
        this.lastUniqueId_ = "";
    }

    private void clearPlayedTime() {
        this.playedTime_ = 0L;
    }

    private void clearSectionRepeatEndPos() {
        this.sectionRepeatEndPos_ = 0;
    }

    private void clearSectionRepeatStartPos() {
        this.sectionRepeatStartPos_ = 0;
    }

    private void clearSelectedRepeatUniqueId() {
        this.selectedRepeatUniqueId_ = A1.emptyProtobufList();
    }

    private void clearSortType() {
        this.sortType_ = 0;
    }

    @Override  // com.google.protobuf.A1
    public final Object dynamicMethod(z1 z10, Object object0, Object object1) {
        z2 z21;
        switch(z10.ordinal()) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return A1.newMessageInfo(EachPlytSettingPreferences.DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002\u0002\u0003\u0004\u0004\u0004\u0005\u0004\u0006Ț", new Object[]{"lastUniqueId_", "playedTime_", "sortType_", "sectionRepeatStartPos_", "sectionRepeatEndPos_", "selectedRepeatUniqueId_"});
            }
            case 3: {
                return new EachPlytSettingPreferences();
            }
            case 4: {
                return new r(EachPlytSettingPreferences.DEFAULT_INSTANCE);  // 初始化器: Lcom/google/protobuf/t1;-><init>(Lcom/google/protobuf/A1;)V
            }
            case 5: {
                return EachPlytSettingPreferences.DEFAULT_INSTANCE;
            }
            case 6: {
                z2 z20 = EachPlytSettingPreferences.PARSER;
                if(z20 == null) {
                    synchronized(EachPlytSettingPreferences.class) {
                        z21 = EachPlytSettingPreferences.PARSER;
                        if(z21 == null) {
                            z21 = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
                            EachPlytSettingPreferences.PARSER = z21;
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

    private void ensureSelectedRepeatUniqueIdIsMutable() {
        O1 o10 = this.selectedRepeatUniqueId_;
        if(!((c)o10).a) {
            this.selectedRepeatUniqueId_ = A1.mutableCopy(o10);
        }
    }

    public static EachPlytSettingPreferences getDefaultInstance() {
        return EachPlytSettingPreferences.DEFAULT_INSTANCE;
    }

    public String getLastUniqueId() [...] // 潜在的解密器

    public o getLastUniqueIdBytes() {
        return o.e(this.lastUniqueId_);
    }

    public long getPlayedTime() {
        return this.playedTime_;
    }

    public int getSectionRepeatEndPos() {
        return this.sectionRepeatEndPos_;
    }

    public int getSectionRepeatStartPos() {
        return this.sectionRepeatStartPos_;
    }

    public String getSelectedRepeatUniqueId(int v) {
        return (String)this.selectedRepeatUniqueId_.get(v);
    }

    public o getSelectedRepeatUniqueIdBytes(int v) {
        return o.e(((String)this.selectedRepeatUniqueId_.get(v)));
    }

    public int getSelectedRepeatUniqueIdCount() {
        return this.selectedRepeatUniqueId_.size();
    }

    public List getSelectedRepeatUniqueIdList() {
        return this.selectedRepeatUniqueId_;
    }

    public int getSortType() {
        return this.sortType_;
    }

    public static r newBuilder() {
        return (r)EachPlytSettingPreferences.DEFAULT_INSTANCE.createBuilder();
    }

    public static r newBuilder(EachPlytSettingPreferences eachPlytSettingPreferences0) {
        return (r)EachPlytSettingPreferences.DEFAULT_INSTANCE.createBuilder(eachPlytSettingPreferences0);
    }

    public static EachPlytSettingPreferences parseDelimitedFrom(InputStream inputStream0) {
        return (EachPlytSettingPreferences)A1.parseDelimitedFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static EachPlytSettingPreferences parseDelimitedFrom(InputStream inputStream0, g1 g10) {
        return (EachPlytSettingPreferences)A1.parseDelimitedFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static EachPlytSettingPreferences parseFrom(o o0) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, o0);
    }

    public static EachPlytSettingPreferences parseFrom(o o0, g1 g10) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, o0, g10);
    }

    public static EachPlytSettingPreferences parseFrom(t t0) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, t0);
    }

    public static EachPlytSettingPreferences parseFrom(t t0, g1 g10) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, t0, g10);
    }

    public static EachPlytSettingPreferences parseFrom(InputStream inputStream0) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0);
    }

    public static EachPlytSettingPreferences parseFrom(InputStream inputStream0, g1 g10) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, inputStream0, g10);
    }

    public static EachPlytSettingPreferences parseFrom(ByteBuffer byteBuffer0) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, byteBuffer0);
    }

    public static EachPlytSettingPreferences parseFrom(ByteBuffer byteBuffer0, g1 g10) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, byteBuffer0, g10);
    }

    public static EachPlytSettingPreferences parseFrom(byte[] arr_b) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, arr_b);
    }

    public static EachPlytSettingPreferences parseFrom(byte[] arr_b, g1 g10) {
        return (EachPlytSettingPreferences)A1.parseFrom(EachPlytSettingPreferences.DEFAULT_INSTANCE, arr_b, g10);
    }

    public static z2 parser() {
        return EachPlytSettingPreferences.DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastUniqueId(String s) {
        s.getClass();
        this.lastUniqueId_ = s;
    }

    private void setLastUniqueIdBytes(o o0) {
        b.checkByteStringIsUtf8(o0);
        this.lastUniqueId_ = o0.p();
    }

    private void setPlayedTime(long v) {
        this.playedTime_ = v;
    }

    private void setSectionRepeatEndPos(int v) {
        this.sectionRepeatEndPos_ = v;
    }

    private void setSectionRepeatStartPos(int v) {
        this.sectionRepeatStartPos_ = v;
    }

    private void setSelectedRepeatUniqueId(int v, String s) {
        s.getClass();
        this.ensureSelectedRepeatUniqueIdIsMutable();
        this.selectedRepeatUniqueId_.set(v, s);
    }

    private void setSortType(int v) {
        this.sortType_ = v;
    }
}

