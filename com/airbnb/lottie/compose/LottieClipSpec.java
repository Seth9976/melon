package com.airbnb.lottie.compose;

import A7.d;
import P4.a;
import androidx.appcompat.app.o;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\n\u000B\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H ¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H ¢\u0006\u0002\b\t\u0082\u0001\u0004\u000E\u000F\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec;", "", "()V", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "Frame", "Marker", "Markers", "Progress", "Lcom/airbnb/lottie/compose/LottieClipSpec$Frame;", "Lcom/airbnb/lottie/compose/LottieClipSpec$Marker;", "Lcom/airbnb/lottie/compose/LottieClipSpec$Markers;", "Lcom/airbnb/lottie/compose/LottieClipSpec$Progress;", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class LottieClipSpec {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000BJ\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000BJ\t\u0010\u0011\u001A\u00020\u0006HÆ\u0003J0\u0010\u0012\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001A\u00020\u00062\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\u0015\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0010¢\u0006\u0002\b\u001BJ\u0015\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0010¢\u0006\u0002\b\u001DJ\t\u0010\u001E\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001F\u001A\u00020 HÖ\u0001R\u0012\u0010\b\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u000E\u0010\u000B¨\u0006!"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Frame;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "min", "", "max", "maxInclusive", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "actualMaxFrame", "Ljava/lang/Integer;", "getMax", "()Ljava/lang/Integer;", "getMaxInclusive", "()Z", "getMin", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/airbnb/lottie/compose/LottieClipSpec$Frame;", "equals", "other", "", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "toString", "", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Frame extends LottieClipSpec {
        public static final int $stable;
        @Nullable
        private final Integer actualMaxFrame;
        @Nullable
        private final Integer max;
        private final boolean maxInclusive;
        @Nullable
        private final Integer min;

        public Frame() {
            this(null, null, false, 7, null);
        }

        public Frame(@Nullable Integer integer0, @Nullable Integer integer1, boolean z) {
            super(null);
            this.min = integer0;
            this.max = integer1;
            this.maxInclusive = z;
            if(integer1 == null) {
                integer1 = null;
            }
            else if(!z) {
                integer1 = (int)(((int)integer1) - 1);
            }
            this.actualMaxFrame = integer1;
        }

        public Frame(Integer integer0, Integer integer1, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                integer0 = null;
            }
            if((v & 2) != 0) {
                integer1 = null;
            }
            if((v & 4) != 0) {
                z = true;
            }
            this(integer0, integer1, z);
        }

        @Nullable
        public final Integer component1() {
            return this.min;
        }

        @Nullable
        public final Integer component2() {
            return this.max;
        }

        public final boolean component3() {
            return this.maxInclusive;
        }

        @NotNull
        public final Frame copy(@Nullable Integer integer0, @Nullable Integer integer1, boolean z) {
            return new Frame(integer0, integer1, z);
        }

        public static Frame copy$default(Frame lottieClipSpec$Frame0, Integer integer0, Integer integer1, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                integer0 = lottieClipSpec$Frame0.min;
            }
            if((v & 2) != 0) {
                integer1 = lottieClipSpec$Frame0.max;
            }
            if((v & 4) != 0) {
                z = lottieClipSpec$Frame0.maxInclusive;
            }
            return lottieClipSpec$Frame0.copy(integer0, integer1, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Frame)) {
                return false;
            }
            if(!q.b(this.min, ((Frame)object0).min)) {
                return false;
            }
            return q.b(this.max, ((Frame)object0).max) ? this.maxInclusive == ((Frame)object0).maxInclusive : false;
        }

        @Nullable
        public final Integer getMax() {
            return this.max;
        }

        public final boolean getMaxInclusive() {
            return this.maxInclusive;
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            return this.actualMaxFrame == null ? 1.0f : a.i(((float)(((int)this.actualMaxFrame))) / lottieComposition0.getEndFrame(), 0.0f, 1.0f);
        }

        @Nullable
        public final Integer getMin() {
            return this.min;
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            return this.min == null ? 0.0f : a.i(((float)(((int)this.min))) / lottieComposition0.getEndFrame(), 0.0f, 1.0f);
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.min == null ? 0 : this.min.hashCode();
            Integer integer0 = this.max;
            if(integer0 != null) {
                v = integer0.hashCode();
            }
            return Boolean.hashCode(this.maxInclusive) + (v1 * 0x1F + v) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("Frame(min=");
            stringBuilder0.append(this.min);
            stringBuilder0.append(", max=");
            stringBuilder0.append(this.max);
            stringBuilder0.append(", maxInclusive=");
            return o.s(stringBuilder0, this.maxInclusive, ")");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fHÖ\u0003J\u0015\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0010¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Marker;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "marker", "", "(Ljava/lang/String;)V", "getMarker", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "", "toString", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Marker extends LottieClipSpec {
        public static final int $stable;
        @NotNull
        private final String marker;

        public Marker(@NotNull String s) {
            q.g(s, "marker");
            super(null);
            this.marker = s;
        }

        @NotNull
        public final String component1() {
            return this.marker;
        }

        @NotNull
        public final Marker copy(@NotNull String s) {
            q.g(s, "marker");
            return new Marker(s);
        }

        public static Marker copy$default(Marker lottieClipSpec$Marker0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = lottieClipSpec$Marker0.marker;
            }
            return lottieClipSpec$Marker0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Marker ? q.b(this.marker, ((Marker)object0).marker) : false;
        }

        @NotNull
        public final String getMarker() {
            return this.marker;
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            com.airbnb.lottie.model.Marker marker0 = lottieComposition0.getMarker(this.marker);
            return marker0 == null ? 1.0f : a.i((marker0.startFrame + marker0.durationFrames) / lottieComposition0.getEndFrame(), 0.0f, 1.0f);
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            com.airbnb.lottie.model.Marker marker0 = lottieComposition0.getMarker(this.marker);
            return marker0 == null ? a.i(0.0f / lottieComposition0.getEndFrame(), 0.0f, 1.0f) : a.i(marker0.startFrame / lottieComposition0.getEndFrame(), 0.0f, 1.0f);
        }

        @Override
        public int hashCode() {
            return this.marker.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Marker(marker=" + this.marker + ")";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u000E\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0006HÆ\u0003J+\u0010\u0010\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00062\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013HÖ\u0003J\u0015\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0010¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0010¢\u0006\u0002\b\u001AJ\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\t¨\u0006\u001E"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Markers;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "min", "", "max", "maxInclusive", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getMax", "()Ljava/lang/String;", "getMaxInclusive", "()Z", "getMin", "component1", "component2", "component3", "copy", "equals", "other", "", "getMaxProgress", "", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "", "toString", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Markers extends LottieClipSpec {
        public static final int $stable;
        @Nullable
        private final String max;
        private final boolean maxInclusive;
        @Nullable
        private final String min;

        public Markers() {
            this(null, null, false, 7, null);
        }

        public Markers(@Nullable String s, @Nullable String s1, boolean z) {
            super(null);
            this.min = s;
            this.max = s1;
            this.maxInclusive = z;
        }

        public Markers(String s, String s1, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = null;
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                z = true;
            }
            this(s, s1, z);
        }

        @Nullable
        public final String component1() {
            return this.min;
        }

        @Nullable
        public final String component2() {
            return this.max;
        }

        public final boolean component3() {
            return this.maxInclusive;
        }

        @NotNull
        public final Markers copy(@Nullable String s, @Nullable String s1, boolean z) {
            return new Markers(s, s1, z);
        }

        public static Markers copy$default(Markers lottieClipSpec$Markers0, String s, String s1, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                s = lottieClipSpec$Markers0.min;
            }
            if((v & 2) != 0) {
                s1 = lottieClipSpec$Markers0.max;
            }
            if((v & 4) != 0) {
                z = lottieClipSpec$Markers0.maxInclusive;
            }
            return lottieClipSpec$Markers0.copy(s, s1, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Markers)) {
                return false;
            }
            if(!q.b(this.min, ((Markers)object0).min)) {
                return false;
            }
            return q.b(this.max, ((Markers)object0).max) ? this.maxInclusive == ((Markers)object0).maxInclusive : false;
        }

        @Nullable
        public final String getMax() {
            return this.max;
        }

        public final boolean getMaxInclusive() {
            return this.maxInclusive;
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            String s = this.max;
            if(s == null) {
                return 1.0f;
            }
            com.airbnb.lottie.model.Marker marker0 = lottieComposition0.getMarker(s);
            return marker0 == null ? a.i(0.0f / lottieComposition0.getEndFrame(), 0.0f, 1.0f) : a.i((marker0.startFrame + ((float)(this.maxInclusive ? 0 : -1))) / lottieComposition0.getEndFrame(), 0.0f, 1.0f);
        }

        @Nullable
        public final String getMin() {
            return this.min;
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            String s = this.min;
            if(s == null) {
                return 0.0f;
            }
            com.airbnb.lottie.model.Marker marker0 = lottieComposition0.getMarker(s);
            return marker0 == null ? a.i(0.0f / lottieComposition0.getEndFrame(), 0.0f, 1.0f) : a.i(marker0.startFrame / lottieComposition0.getEndFrame(), 0.0f, 1.0f);
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.min == null ? 0 : this.min.hashCode();
            String s = this.max;
            if(s != null) {
                v = s.hashCode();
            }
            return Boolean.hashCode(this.maxInclusive) + (v1 * 0x1F + v) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return o.s(d.o("Markers(min=", this.min, ", max=", this.max, ", maxInclusive="), this.maxInclusive, ")");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FHÖ\u0003J\u0015\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u0012H\u0010¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u0012H\u0010¢\u0006\u0002\b\u0015J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u001A"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Progress;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "min", "", "max", "(FF)V", "getMax", "()F", "getMin", "component1", "component2", "copy", "equals", "", "other", "", "getMaxProgress", "composition", "Lcom/airbnb/lottie/LottieComposition;", "getMaxProgress$lottie_compose_release", "getMinProgress", "getMinProgress$lottie_compose_release", "hashCode", "", "toString", "", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Progress extends LottieClipSpec {
        public static final int $stable;
        private final float max;
        private final float min;

        public Progress() {
            this(0.0f, 0.0f, 3, null);
        }

        public Progress(float f, float f1) {
            super(null);
            this.min = f;
            this.max = f1;
        }

        public Progress(float f, float f1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                f = 0.0f;
            }
            if((v & 2) != 0) {
                f1 = 1.0f;
            }
            this(f, f1);
        }

        public final float component1() {
            return this.min;
        }

        public final float component2() {
            return this.max;
        }

        @NotNull
        public final Progress copy(float f, float f1) {
            return new Progress(f, f1);
        }

        public static Progress copy$default(Progress lottieClipSpec$Progress0, float f, float f1, int v, Object object0) {
            if((v & 1) != 0) {
                f = lottieClipSpec$Progress0.min;
            }
            if((v & 2) != 0) {
                f1 = lottieClipSpec$Progress0.max;
            }
            return lottieClipSpec$Progress0.copy(f, f1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Progress)) {
                return false;
            }
            return Float.compare(this.min, ((Progress)object0).min) == 0 ? Float.compare(this.max, ((Progress)object0).max) == 0 : false;
        }

        public final float getMax() {
            return this.max;
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMaxProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            return this.max;
        }

        public final float getMin() {
            return this.min;
        }

        @Override  // com.airbnb.lottie.compose.LottieClipSpec
        public float getMinProgress$lottie_compose_release(@NotNull LottieComposition lottieComposition0) {
            q.g(lottieComposition0, "composition");
            return this.min;
        }

        @Override
        public int hashCode() {
            return Float.hashCode(this.max) + Float.hashCode(this.min) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "Progress(min=" + this.min + ", max=" + this.max + ")";
        }
    }

    public static final int $stable;

    private LottieClipSpec() {
    }

    public LottieClipSpec(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    public abstract float getMaxProgress$lottie_compose_release(@NotNull LottieComposition arg1);

    public abstract float getMinProgress$lottie_compose_release(@NotNull LottieComposition arg1);
}

