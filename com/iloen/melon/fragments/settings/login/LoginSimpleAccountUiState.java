package com.iloen.melon.fragments.settings.login;

import com.melon.ui.K4;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiState;", "Lcom/melon/ui/K4;", "<init>", "()V", "Screen", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiState$Screen;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class LoginSimpleAccountUiState implements K4 {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiState$Screen;", "Lcom/iloen/melon/fragments/settings/login/LoginSimpleAccountUiState;", "simpleAccountUserIds", "", "", "<init>", "(Ljava/util/List;)V", "getSimpleAccountUserIds", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Screen extends LoginSimpleAccountUiState {
        public static final int $stable = 8;
        @NotNull
        private final List simpleAccountUserIds;

        public Screen(@NotNull List list0) {
            q.g(list0, "simpleAccountUserIds");
            super(null);
            this.simpleAccountUserIds = list0;
        }

        @NotNull
        public final List component1() {
            return this.simpleAccountUserIds;
        }

        @NotNull
        public final Screen copy(@NotNull List list0) {
            q.g(list0, "simpleAccountUserIds");
            return new Screen(list0);
        }

        public static Screen copy$default(Screen loginSimpleAccountUiState$Screen0, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = loginSimpleAccountUiState$Screen0.simpleAccountUserIds;
            }
            return loginSimpleAccountUiState$Screen0.copy(list0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Screen ? q.b(this.simpleAccountUserIds, ((Screen)object0).simpleAccountUserIds) : false;
        }

        @NotNull
        public final List getSimpleAccountUserIds() {
            return this.simpleAccountUserIds;
        }

        @Override
        public int hashCode() {
            return this.simpleAccountUserIds.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Screen(simpleAccountUserIds=" + this.simpleAccountUserIds + ")";
        }
    }

    public static final int $stable;

    private LoginSimpleAccountUiState() {
    }

    public LoginSimpleAccountUiState(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

