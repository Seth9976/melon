package com.iloen.melon.fragments.settings.alarm;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/ViewState;", "", "<init>", "()V", "Loading", "Success", "Lcom/iloen/melon/fragments/settings/alarm/ViewState$Loading;", "Lcom/iloen/melon/fragments/settings/alarm/ViewState$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ViewState {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/ViewState$Loading;", "Lcom/iloen/melon/fragments/settings/alarm/ViewState;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Loading extends ViewState {
        public static final int $stable;
        @NotNull
        public static final Loading INSTANCE;

        static {
            Loading.INSTANCE = new Loading();
        }

        private Loading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001A\u00020\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001A\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/ViewState$Success;", "Lcom/iloen/melon/fragments/settings/alarm/ViewState;", "", "Lo8/d;", "alarmList", "<init>", "(Ljava/util/List;)V", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lcom/iloen/melon/fragments/settings/alarm/ViewState$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAlarmList", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success extends ViewState {
        public static final int $stable = 8;
        @NotNull
        private final List alarmList;

        public Success(@NotNull List list0) {
            q.g(list0, "alarmList");
            super(null);
            this.alarmList = list0;
        }

        @NotNull
        public final List component1() {
            return this.alarmList;
        }

        @NotNull
        public final Success copy(@NotNull List list0) {
            q.g(list0, "alarmList");
            return new Success(list0);
        }

        public static Success copy$default(Success viewState$Success0, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = viewState$Success0.alarmList;
            }
            return viewState$Success0.copy(list0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Success ? q.b(this.alarmList, ((Success)object0).alarmList) : false;
        }

        @NotNull
        public final List getAlarmList() {
            return this.alarmList;
        }

        @Override
        public int hashCode() {
            return this.alarmList.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Success(alarmList=" + this.alarmList + ")";
        }
    }

    public static final int $stable;

    private ViewState() {
    }

    public ViewState(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

