package com.iloen.melon.utils.datastore;

import com.iloen.melon.MixMakerPreference;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.e;
import oe.i;
import we.o;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/MixMakerPreference;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.utils.datastore.MixMakerPreferencesRepository$mixTitleFlow$1", f = "MixMakerPreferencesRepository.kt", l = {20}, m = "invokeSuspend")
final class MixMakerPreferencesRepository.mixTitleFlow.1 extends i implements o {
    public Throwable B;
    public int r;
    public FlowCollector w;

    @Override  // we.o
    public Object invoke(Object object0, Object object1, Object object2) {
        return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
    }

    public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
        MixMakerPreferencesRepository.mixTitleFlow.1 mixMakerPreferencesRepository$mixTitleFlow$10 = new MixMakerPreferencesRepository.mixTitleFlow.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        mixMakerPreferencesRepository$mixTitleFlow$10.w = flowCollector0;
        mixMakerPreferencesRepository$mixTitleFlow$10.B = throwable0;
        return mixMakerPreferencesRepository$mixTitleFlow$10.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        FlowCollector flowCollector0 = this.w;
        Throwable throwable0 = this.B;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                if(!(throwable0 instanceof IOException)) {
                    throw throwable0;
                }
                LogU.error$default(MixMakerPreferencesRepository.a, "mixTitleFlow", throwable0, false, 4, null);
                MixMakerPreference mixMakerPreference0 = MixMakerPreferenceSerializer.INSTANCE.createDefaultValue();
                this.w = null;
                this.B = null;
                this.r = 1;
                return flowCollector0.emit(mixMakerPreference0, this) == a0 ? a0 : H.a;
            }
            case 1: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

