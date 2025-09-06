package com.kakao.sdk.user.model;

import com.kakao.sdk.common.json.UnknownValue;
import i.n.i.b.a.s.e.M3;
import ie.C;
import ie.I;
import ie.j;
import ie.k;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000F\b\u0087\u0001\u0018\u0000 \u000F2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000FB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000E¨\u0006\u0010"}, d2 = {"Lcom/kakao/sdk/user/model/AgeRange;", "", "(Ljava/lang/String;I)V", "AGE_0_9", "AGE_10_14", "AGE_15_19", "AGE_20_29", "AGE_30_39", "AGE_40_49", "AGE_50_59", "AGE_60_69", "AGE_70_79", "AGE_80_89", "AGE_90_ABOVE", "UNKNOWN", "Companion", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@Serializable(with = AgeRangeSerializer.class)
public enum AgeRange {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000F\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/AgeRange$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/kakao/sdk/user/model/AgeRange;", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final j get$cachedSerializer$delegate() {
            return AgeRange.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer serializer() {
            return (KSerializer)this.get$cachedSerializer$delegate().getValue();
        }
    }

    @SerialName("0~9")
    AGE_0_9,
    @SerialName("10~14")
    AGE_10_14,
    @SerialName("15~19")
    AGE_15_19,
    @SerialName("20~29")
    AGE_20_29,
    @SerialName("30~39")
    AGE_30_39,
    @SerialName("40~49")
    AGE_40_49,
    @SerialName("50~59")
    AGE_50_59,
    @SerialName("60~69")
    AGE_60_69,
    @SerialName("70~79")
    AGE_70_79,
    @SerialName("80~89")
    AGE_80_89,
    @SerialName("90~")
    AGE_90_ABOVE,
    @UnknownValue
    UNKNOWN;

    @NotNull
    private static final j $cachedSerializer$delegate;
    @NotNull
    public static final Companion Companion;

    private static final AgeRange[] $values() [...] // Inlined contents

    static {
        j j0;
        AgeRange.Companion = new Companion(null);
        a a0 = AgeRange.Companion..cachedSerializer.delegate.1.INSTANCE;
        C c0 = C.a;
        if(a0 == null) {
            NullPointerException nullPointerException0 = new NullPointerException(q.i("initializer"));
            q.l(nullPointerException0, q.class.getName());
            throw nullPointerException0;
        }
        switch(k.b.ordinal()) {
            case 0: {
                j0 = new r(a0);
                break;
            }
            case 1: {
                j j1 = new ie.q();  // 初始化器: Ljava/lang/Object;-><init>()V
                j1.a = a0;
                j1.b = c0;
                j0 = j1;
                break;
            }
            case 2: {
                j j2 = new I();  // 初始化器: Ljava/lang/Object;-><init>()V
                j2.a = a0;
                j2.b = c0;
                j0 = j2;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        AgeRange.$cachedSerializer$delegate = j0;
    }
}

