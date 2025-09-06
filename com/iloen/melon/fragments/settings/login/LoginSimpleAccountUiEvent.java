package com.iloen.melon.fragments.settings.login;

import com.melon.ui.I4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiEvent;", "Lcom/melon/ui/I4;", "<init>", "()V", "ClosePage", "ExecuteReturnUri", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiEvent$ClosePage;", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiEvent$ExecuteReturnUri;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class LoginSimpleAccountUiEvent implements I4 {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiEvent$ClosePage;", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiEvent;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClosePage extends LoginSimpleAccountUiEvent {
        public static final int $stable;
        @NotNull
        public static final ClosePage INSTANCE;

        static {
            ClosePage.INSTANCE = new ClosePage();
        }

        private ClosePage() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiEvent$ExecuteReturnUri;", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiEvent;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ExecuteReturnUri extends LoginSimpleAccountUiEvent {
        public static final int $stable;
        @NotNull
        public static final ExecuteReturnUri INSTANCE;

        static {
            ExecuteReturnUri.INSTANCE = new ExecuteReturnUri();
        }

        private ExecuteReturnUri() {
            super(null);
        }
    }

    public static final int $stable;

    private LoginSimpleAccountUiEvent() {
    }

    public LoginSimpleAccountUiEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

