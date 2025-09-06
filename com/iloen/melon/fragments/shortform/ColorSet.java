package com.iloen.melon.fragments.shortform;

import e.k;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \f2\u00020\u0001:\u0004\t\n\u000B\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b\u0082\u0001\u0003\r\u000E\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/shortform/ColorSet;", "", "<init>", "()V", "colors", "", "", "getColors", "()Ljava/util/List;", "TypeA", "TypeB", "TypeC", "Companion", "Lcom/iloen/melon/fragments/shortform/ColorSet$TypeA;", "Lcom/iloen/melon/fragments/shortform/ColorSet$TypeB;", "Lcom/iloen/melon/fragments/shortform/ColorSet$TypeC;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ColorSet {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/shortform/ColorSet$Companion;", "", "<init>", "()V", "fromString", "Lcom/iloen/melon/fragments/shortform/ColorSet;", "type", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final ColorSet fromString(@NotNull String s) {
            q.g(s, "type");
            String s1 = s.toUpperCase(Locale.ROOT);
            q.f(s1, "toUpperCase(...)");
            switch(s1) {
                case "A": {
                    return TypeA.INSTANCE;
                }
                case "B": {
                    return TypeB.INSTANCE;
                }
                case "C": {
                    return TypeC.INSTANCE;
                }
                default: {
                    return null;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001A\u00020\u0006HÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/shortform/ColorSet$TypeA;", "Lcom/iloen/melon/fragments/shortform/ColorSet;", "<init>", "()V", "colors", "", "", "getColors", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TypeA extends ColorSet {
        public static final int $stable;
        @NotNull
        public static final TypeA INSTANCE;
        @NotNull
        private static final List colors;

        static {
            TypeA.INSTANCE = new TypeA();
            TypeA.colors = k.A(new Integer[]{0x7F060095, 0x7F060079});  // color:color_b000ff
            TypeA.$stable = 8;
        }

        private TypeA() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof TypeA;
        }

        @Override  // com.iloen.melon.fragments.shortform.ColorSet
        @NotNull
        public List getColors() {
            return TypeA.colors;
        }

        @Override
        public int hashCode() {
            return 508729618;
        }

        @Override
        @NotNull
        public String toString() {
            return "TypeA";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001A\u00020\u0006HÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/shortform/ColorSet$TypeB;", "Lcom/iloen/melon/fragments/shortform/ColorSet;", "<init>", "()V", "colors", "", "", "getColors", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TypeB extends ColorSet {
        public static final int $stable;
        @NotNull
        public static final TypeB INSTANCE;
        @NotNull
        private static final List colors;

        static {
            TypeB.INSTANCE = new TypeB();
            TypeB.colors = k.A(new Integer[]{0x7F060097, 0x7F060090});  // color:color_c1dd20
            TypeB.$stable = 8;
        }

        private TypeB() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof TypeB;
        }

        @Override  // com.iloen.melon.fragments.shortform.ColorSet
        @NotNull
        public List getColors() {
            return TypeB.colors;
        }

        @Override
        public int hashCode() {
            return 508729619;
        }

        @Override
        @NotNull
        public String toString() {
            return "TypeB";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001A\u00020\u0006HÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/shortform/ColorSet$TypeC;", "Lcom/iloen/melon/fragments/shortform/ColorSet;", "<init>", "()V", "colors", "", "", "getColors", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TypeC extends ColorSet {
        public static final int $stable;
        @NotNull
        public static final TypeC INSTANCE;
        @NotNull
        private static final List colors;

        static {
            TypeC.INSTANCE = new TypeC();
            TypeC.colors = k.A(new Integer[]{0x7F0600A0, 0x7F060080});  // color:color_fb8e3e
            TypeC.$stable = 8;
        }

        private TypeC() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof TypeC;
        }

        @Override  // com.iloen.melon.fragments.shortform.ColorSet
        @NotNull
        public List getColors() {
            return TypeC.colors;
        }

        @Override
        public int hashCode() {
            return 508729620;
        }

        @Override
        @NotNull
        public String toString() {
            return "TypeC";
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        ColorSet.Companion = new Companion(null);
    }

    private ColorSet() {
    }

    public ColorSet(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @NotNull
    public abstract List getColors();
}

