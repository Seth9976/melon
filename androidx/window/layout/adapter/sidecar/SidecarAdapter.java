package androidx.window.layout.adapter.sidecar;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature.State;
import androidx.window.layout.HardwareFoldingFeature.Type;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001A\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\bJ\u001C\u0010\n\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u000B2\b\u0010\t\u001A\u0004\u0018\u00010\u000BH\u0002J(\u0010\f\u001A\u00020\u00062\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\r2\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\rH\u0002J\u001A\u0010\u000E\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u000F2\b\u0010\t\u001A\u0004\u0018\u00010\u000FJ\u001F\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\bH\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0010\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0017\u001A\u00020\bJ\"\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\r2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u000B0\r2\u0006\u0010\u0013\u001A\u00020\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarAdapter;", "", "verificationMode", "Landroidx/window/core/VerificationMode;", "(Landroidx/window/core/VerificationMode;)V", "isEqualSidecarDeviceState", "", "first", "Landroidx/window/sidecar/SidecarDeviceState;", "second", "isEqualSidecarDisplayFeature", "Landroidx/window/sidecar/SidecarDisplayFeature;", "isEqualSidecarDisplayFeatures", "", "isEqualSidecarWindowLayoutInfo", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "translate", "Landroidx/window/layout/DisplayFeature;", "feature", "deviceState", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "extensionInfo", "state", "sidecarDisplayFeatures", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SidecarAdapter {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\'\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00020\u0010H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001C\u0010\u001A\u001A\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Landroidx/window/layout/adapter/sidecar/SidecarAdapter$Companion;", "", "<init>", "()V", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "info", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "getSidecarDisplayFeatures", "(Landroidx/window/sidecar/SidecarWindowLayoutInfo;)Ljava/util/List;", "displayFeatures", "Lie/H;", "setSidecarDisplayFeatures", "(Landroidx/window/sidecar/SidecarWindowLayoutInfo;Ljava/util/List;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "sidecarDeviceState", "", "getSidecarDevicePosture$window_release", "(Landroidx/window/sidecar/SidecarDeviceState;)I", "getSidecarDevicePosture", "getRawSidecarDevicePosture", "posture", "setSidecarDevicePosture", "(Landroidx/window/sidecar/SidecarDeviceState;I)V", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final int getRawSidecarDevicePosture(@NotNull SidecarDeviceState sidecarDeviceState0) {
            q.g(sidecarDeviceState0, "sidecarDeviceState");
            return sidecarDeviceState0.posture;
        }

        public final int getSidecarDevicePosture$window_release(@NotNull SidecarDeviceState sidecarDeviceState0) {
            q.g(sidecarDeviceState0, "sidecarDeviceState");
            int v = this.getRawSidecarDevicePosture(sidecarDeviceState0);
            return v < 0 || v > 4 ? 0 : v;
        }

        @SuppressLint({"BanUncheckedReflection"})
        @NotNull
        public final List getSidecarDisplayFeatures(@NotNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo0) {
            q.g(sidecarWindowLayoutInfo0, "info");
            return sidecarWindowLayoutInfo0.displayFeatures == null ? w.a : sidecarWindowLayoutInfo0.displayFeatures;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void setSidecarDevicePosture(@NotNull SidecarDeviceState sidecarDeviceState0, int v) {
            q.g(sidecarDeviceState0, "sidecarDeviceState");
            sidecarDeviceState0.posture = v;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void setSidecarDisplayFeatures(@NotNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo0, @NotNull List list0) {
            q.g(sidecarWindowLayoutInfo0, "info");
            q.g(list0, "displayFeatures");
            sidecarWindowLayoutInfo0.displayFeatures = list0;
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final String TAG;
    @NotNull
    private final VerificationMode verificationMode;

    static {
        SidecarAdapter.Companion = new Companion(null);
        SidecarAdapter.TAG = "SidecarAdapter";
    }

    public SidecarAdapter() {
        this(null, 1, null);
    }

    public SidecarAdapter(@NotNull VerificationMode verificationMode0) {
        q.g(verificationMode0, "verificationMode");
        super();
        this.verificationMode = verificationMode0;
    }

    public SidecarAdapter(VerificationMode verificationMode0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            verificationMode0 = VerificationMode.QUIET;
        }
        this(verificationMode0);
    }

    public final boolean isEqualSidecarDeviceState(@Nullable SidecarDeviceState sidecarDeviceState0, @Nullable SidecarDeviceState sidecarDeviceState1) {
        if(q.b(sidecarDeviceState0, sidecarDeviceState1)) {
            return true;
        }
        if(sidecarDeviceState0 == null) {
            return false;
        }
        return sidecarDeviceState1 == null ? false : SidecarAdapter.Companion.getSidecarDevicePosture$window_release(sidecarDeviceState0) == SidecarAdapter.Companion.getSidecarDevicePosture$window_release(sidecarDeviceState1);
    }

    private final boolean isEqualSidecarDisplayFeature(SidecarDisplayFeature sidecarDisplayFeature0, SidecarDisplayFeature sidecarDisplayFeature1) {
        if(q.b(sidecarDisplayFeature0, sidecarDisplayFeature1)) {
            return true;
        }
        if(sidecarDisplayFeature0 == null) {
            return false;
        }
        if(sidecarDisplayFeature1 == null) {
            return false;
        }
        return sidecarDisplayFeature0.getType() == sidecarDisplayFeature1.getType() ? q.b(sidecarDisplayFeature0.getRect(), sidecarDisplayFeature1.getRect()) : false;
    }

    private final boolean isEqualSidecarDisplayFeatures(List list0, List list1) {
        if(list0 == list1) {
            return true;
        }
        if(list0 == null) {
            return false;
        }
        if(list1 == null) {
            return false;
        }
        if(list0.size() != list1.size()) {
            return false;
        }
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!this.isEqualSidecarDisplayFeature(((SidecarDisplayFeature)list0.get(v1)), ((SidecarDisplayFeature)list1.get(v1)))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEqualSidecarWindowLayoutInfo(@Nullable SidecarWindowLayoutInfo sidecarWindowLayoutInfo0, @Nullable SidecarWindowLayoutInfo sidecarWindowLayoutInfo1) {
        if(q.b(sidecarWindowLayoutInfo0, sidecarWindowLayoutInfo1)) {
            return true;
        }
        if(sidecarWindowLayoutInfo0 == null) {
            return false;
        }
        return sidecarWindowLayoutInfo1 == null ? false : this.isEqualSidecarDisplayFeatures(SidecarAdapter.Companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo0), SidecarAdapter.Companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo1));
    }

    @NotNull
    public final WindowLayoutInfo translate(@Nullable SidecarWindowLayoutInfo sidecarWindowLayoutInfo0, @NotNull SidecarDeviceState sidecarDeviceState0) {
        q.g(sidecarDeviceState0, "state");
        if(sidecarWindowLayoutInfo0 == null) {
            return new WindowLayoutInfo(w.a);
        }
        SidecarDeviceState sidecarDeviceState1 = new SidecarDeviceState();
        int v = SidecarAdapter.Companion.getSidecarDevicePosture$window_release(sidecarDeviceState0);
        SidecarAdapter.Companion.setSidecarDevicePosture(sidecarDeviceState1, v);
        return new WindowLayoutInfo(this.translate(SidecarAdapter.Companion.getSidecarDisplayFeatures(sidecarWindowLayoutInfo0), sidecarDeviceState1));
    }

    @NotNull
    public final List translate(@NotNull List list0, @NotNull SidecarDeviceState sidecarDeviceState0) {
        q.g(list0, "sidecarDisplayFeatures");
        q.g(sidecarDeviceState0, "deviceState");
        List list1 = new ArrayList();
        for(Object object0: list0) {
            DisplayFeature displayFeature0 = this.translate$window_release(((SidecarDisplayFeature)object0), sidecarDeviceState0);
            if(displayFeature0 != null) {
                list1.add(displayFeature0);
            }
        }
        return list1;
    }

    @Nullable
    public final DisplayFeature translate$window_release(@NotNull SidecarDisplayFeature sidecarDisplayFeature0, @NotNull SidecarDeviceState sidecarDeviceState0) {
        State foldingFeature$State0;
        Type hardwareFoldingFeature$Type0;
        q.g(sidecarDisplayFeature0, "feature");
        q.g(sidecarDeviceState0, "deviceState");
        q.f("SidecarAdapter", "TAG");
        SidecarDisplayFeature sidecarDisplayFeature1 = (SidecarDisplayFeature)androidx.window.core.SpecificationComputer.Companion.startSpecification$default(SpecificationComputer.Companion, sidecarDisplayFeature0, "SidecarAdapter", this.verificationMode, null, 4, null).require("Type must be either TYPE_FOLD or TYPE_HINGE", androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.1.INSTANCE).require("Feature bounds must not be 0", androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.2.INSTANCE).require("TYPE_FOLD must have 0 area", androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.3.INSTANCE).require("Feature be pinned to either left or top", androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.4.INSTANCE).compute();
        if(sidecarDisplayFeature1 == null) {
            return null;
        }
        switch(sidecarDisplayFeature1.getType()) {
            case 1: {
                hardwareFoldingFeature$Type0 = Type.Companion.getFOLD();
                break;
            }
            case 2: {
                hardwareFoldingFeature$Type0 = Type.Companion.getHINGE();
                break;
            }
            default: {
                return null;
            }
        }
        switch(SidecarAdapter.Companion.getSidecarDevicePosture$window_release(sidecarDeviceState0)) {
            case 2: {
                foldingFeature$State0 = State.HALF_OPENED;
                break;
            }
            case 3: {
                foldingFeature$State0 = State.FLAT;
                break;
            }
            case 0: 
            case 1: 
            case 4: {
                return null;
            }
            default: {
                foldingFeature$State0 = State.FLAT;
                break;
            }
        }
        Rect rect0 = sidecarDisplayFeature0.getRect();
        q.f(rect0, "getRect(...)");
        return new HardwareFoldingFeature(new Bounds(rect0), hardwareFoldingFeature$Type0, foldingFeature$State0);

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "invoke", "(Landroidx/window/sidecar/SidecarDisplayFeature;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.1 extends r implements k {
            public static final androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.1 INSTANCE;

            static {
                androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.1.INSTANCE = new androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.1();
            }

            public androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.1() {
                super(1);
            }

            public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature0) {
                q.g(sidecarDisplayFeature0, "$this$require");
                boolean z = true;
                switch(sidecarDisplayFeature0.getType()) {
                    case 1: 
                    case 2: {
                        break;
                    }
                    default: {
                        z = false;
                    }
                }
                return Boolean.valueOf(z);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((SidecarDisplayFeature)object0));
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "invoke", "(Landroidx/window/sidecar/SidecarDisplayFeature;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.2 extends r implements k {
            public static final androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.2 INSTANCE;

            static {
                androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.2.INSTANCE = new androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.2();
            }

            public androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.2() {
                super(1);
            }

            public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature0) {
                q.g(sidecarDisplayFeature0, "$this$require");
                return sidecarDisplayFeature0.getRect().width() != 0 || sidecarDisplayFeature0.getRect().height() != 0;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((SidecarDisplayFeature)object0));
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "invoke", "(Landroidx/window/sidecar/SidecarDisplayFeature;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.3 extends r implements k {
            public static final androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.3 INSTANCE;

            static {
                androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.3.INSTANCE = new androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.3();
            }

            public androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.3() {
                super(1);
            }

            public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature0) {
                q.g(sidecarDisplayFeature0, "$this$require");
                return Boolean.valueOf(sidecarDisplayFeature0.getType() != 1 || sidecarDisplayFeature0.getRect().width() == 0 || sidecarDisplayFeature0.getRect().height() == 0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((SidecarDisplayFeature)object0));
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "invoke", "(Landroidx/window/sidecar/SidecarDisplayFeature;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
        final class androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.4 extends r implements k {
            public static final androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.4 INSTANCE;

            static {
                androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.4.INSTANCE = new androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.4();
            }

            public androidx.window.layout.adapter.sidecar.SidecarAdapter.translate.checkedFeature.4() {
                super(1);
            }

            public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature0) {
                q.g(sidecarDisplayFeature0, "$this$require");
                return sidecarDisplayFeature0.getRect().left == 0 || sidecarDisplayFeature0.getRect().top == 0;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((SidecarDisplayFeature)object0));
            }
        }

    }
}

