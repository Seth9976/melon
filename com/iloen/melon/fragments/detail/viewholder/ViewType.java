package com.iloen.melon.fragments.detail.viewholder;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/ViewType;", "", "MyListen", "Login", "Lcom/iloen/melon/fragments/detail/viewholder/ViewType$Login;", "Lcom/iloen/melon/fragments/detail/viewholder/ViewType$MyListen;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
interface ViewType {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/ViewType$Login;", "Lcom/iloen/melon/fragments/detail/viewholder/ViewType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Login implements ViewType {
        public static final int $stable;
        @NotNull
        public static final Login INSTANCE;

        static {
            Login.INSTANCE = new Login();
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Login;
        }

        @Override
        public int hashCode() {
            return 0xE87814E6;
        }

        @Override
        @NotNull
        public String toString() {
            return "Login";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/ViewType$MyListen;", "Lcom/iloen/melon/fragments/detail/viewholder/ViewType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MyListen implements ViewType {
        public static final int $stable;
        @NotNull
        public static final MyListen INSTANCE;

        static {
            MyListen.INSTANCE = new MyListen();
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof MyListen;
        }

        @Override
        public int hashCode() {
            return -120019978;
        }

        @Override
        @NotNull
        public String toString() {
            return "MyListen";
        }
    }

}

