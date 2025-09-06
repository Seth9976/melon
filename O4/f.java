package o4;

import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.adselection.GetAdSelectionDataOutcome;
import d5.n;
import e1.u;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class f {
    @Nullable
    public final Object a(@NotNull AdSelectionManager adSelectionManager0, @NotNull m m0, @NotNull Continuation continuation0) {
        c c0;
        if(continuation0 instanceof c) {
            c0 = (c)continuation0;
            int v = c0.D;
            if((v & 0x80000000) == 0) {
                c0 = new c(this, continuation0);
            }
            else {
                c0.D = v ^ 0x80000000;
            }
        }
        else {
            c0 = new c(this, continuation0);
        }
        Object object0 = c0.w;
        switch(c0.D) {
            case 0: {
                n.D(object0);
                c0.r = adSelectionManager0;
                c0.D = 1;
                new CancellableContinuationImpl(u.D(c0), 1).initCancellability();
                throw null;
            }
            case 1: {
                n.D(object0);
                return new l(((GetAdSelectionDataOutcome)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Nullable
    public final Object b(@NotNull AdSelectionManager adSelectionManager0, @NotNull o4.n n0, @NotNull Continuation continuation0) {
        d d0;
        if(continuation0 instanceof d) {
            d0 = (d)continuation0;
            int v = d0.D;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, continuation0);
            }
            else {
                d0.D = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, continuation0);
        }
        Object object0 = d0.w;
        switch(d0.D) {
            case 0: {
                n.D(object0);
                d0.r = adSelectionManager0;
                d0.D = 1;
                new CancellableContinuationImpl(u.D(d0), 1).initCancellability();
                throw null;
            }
            case 1: {
                n.D(object0);
                return new k(((AdSelectionOutcome)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Nullable
    public final Object c(@NotNull AdSelectionManager adSelectionManager0, @NotNull b b0, @NotNull Continuation continuation0) {
        e e0;
        if(continuation0 instanceof e) {
            e0 = (e)continuation0;
            int v = e0.D;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, continuation0);
            }
            else {
                e0.D = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, continuation0);
        }
        Object object0 = e0.w;
        switch(e0.D) {
            case 0: {
                n.D(object0);
                e0.r = adSelectionManager0;
                e0.D = 1;
                new CancellableContinuationImpl(u.D(e0), 1).initCancellability();
                throw null;
            }
            case 1: {
                n.D(object0);
                return new k(((AdSelectionOutcome)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

