package com.iloen.melon.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/eventbus/EventLoginError;", "", "<init>", "()V", "KakaoSignUp", "Lcom/iloen/melon/eventbus/EventLoginError$KakaoSignUp;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class EventLoginError {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/eventbus/EventLoginError$KakaoSignUp;", "Lcom/iloen/melon/eventbus/EventLoginError;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class KakaoSignUp extends EventLoginError {
        public static final int $stable;
        @NotNull
        public static final KakaoSignUp INSTANCE;

        static {
            KakaoSignUp.INSTANCE = new KakaoSignUp();
        }

        private KakaoSignUp() {
            super(null);
        }
    }

    public static final int $stable;

    private EventLoginError() {
    }

    public EventLoginError(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

