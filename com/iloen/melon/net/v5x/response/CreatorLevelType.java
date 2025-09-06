package com.iloen.melon.net.v5x.response;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/iloen/melon/net/v5x/response/CreatorLevelType;", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public @interface CreatorLevelType {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/net/v5x/response/CreatorLevelType$Companion;", "", "<init>", "()V", "ARTIST", "", "BRAND", "USER", "DJ", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE = null;
        @NotNull
        public static final String ARTIST = "artist";
        @NotNull
        public static final String BRAND = "brand";
        @NotNull
        public static final String DJ = "dj";
        @NotNull
        public static final String USER = "user";

        static {
            Companion.$$INSTANCE = new Companion();
        }
    }

    @NotNull
    public static final String ARTIST = "artist";
    @NotNull
    public static final String BRAND = "brand";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String DJ = "dj";
    @NotNull
    public static final String USER = "user";

    static {
        CreatorLevelType.Companion = Companion.$$INSTANCE;
    }
}

