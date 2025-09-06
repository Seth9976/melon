package com.iloen.melon.utils.datastore;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MixMakerPreference;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.L;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import l2.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0086@¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\b\u001A\u00020\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tR#\u0010\u0010\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000B0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/utils/datastore/MixMakerPreferencesRepository;", "", "", "mixTitle", "Lie/H;", "add", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "", "c", "Lkotlinx/coroutines/flow/Flow;", "getMixTitleFlow", "()Lkotlinx/coroutines/flow/Flow;", "mixTitleFlow", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixMakerPreferencesRepository {
    public static final int $stable;
    @NotNull
    public static final MixMakerPreferencesRepository INSTANCE;
    public static final LogU a;
    public static final i b;
    public static final MixMakerPreferencesRepository.special..inlined.map.1 c;

    static {
        MixMakerPreferencesRepository.INSTANCE = new MixMakerPreferencesRepository();  // 初始化器: Ljava/lang/Object;-><init>()V
        MixMakerPreferencesRepository.a = new LogU("MixMakerPreferencesRepository");
        MelonAppBase.Companion.getClass();
        i i0 = MixMakerPreferenceSerializerKt.getMixMakerPreferenceDataStore(t.a().getContext());
        MixMakerPreferencesRepository.b = i0;
        MixMakerPreferencesRepository.c = new MixMakerPreferencesRepository.special..inlined.map.1(FlowKt.catch(i0.getData(), new MixMakerPreferencesRepository.mixTitleFlow.1(3, null)));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        MixMakerPreferencesRepository.$stable = 8;
    }

    @Nullable
    public final Object add(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.add.2 mixMakerPreferencesRepository$add$20 = new n(null) {
            public Object r;
            public final String w;

            {
                this.w = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.add.2(this.w, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            public final Object invoke(MixMakerPreference mixMakerPreference0, Continuation continuation0) {
                return ((com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.add.2)this.create(mixMakerPreference0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((MixMakerPreference)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                MixMakerPreference mixMakerPreference0 = (MixMakerPreference)this.r;
                d5.n.D(object0);
                List list0 = mixMakerPreference0.getMixTitleList();
                String s = this.w;
                if(list0.contains(s)) {
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object1: list0) {
                        if(!q.b(((String)object1), s)) {
                            arrayList0.add(object1);
                        }
                    }
                    L l0 = (L)mixMakerPreference0.toBuilder();
                    l0.c();
                    l0.d();
                    ((MixMakerPreference)l0.b).addAllMixTitle(arrayList0);
                    l0.d();
                    ((MixMakerPreference)l0.b).addMixTitle(s);
                    return l0.a();
                }
                if(list0.size() >= 10) {
                    try {
                        List list1 = list0.subList(list0.size() - 9, list0.size());
                        L l1 = (L)mixMakerPreference0.toBuilder();
                        l1.c();
                        l1.d();
                        ((MixMakerPreference)l1.b).addAllMixTitle(list1);
                        l1.d();
                        ((MixMakerPreference)l1.b).addMixTitle(s);
                        return (MixMakerPreference)l1.a();
                    }
                    catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                        LogU.error$default(MixMakerPreferencesRepository.a, "add", indexOutOfBoundsException0, false, 4, null);
                        return mixMakerPreference0;
                    }
                }
                L l2 = (L)mixMakerPreference0.toBuilder();
                l2.d();
                ((MixMakerPreference)l2.b).addMixTitle(s);
                return (MixMakerPreference)l2.a();
            }
        };
        Object object0 = MixMakerPreferencesRepository.b.a(mixMakerPreferencesRepository$add$20, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public final Object clear(@NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.clear.2 mixMakerPreferencesRepository$clear$20 = new n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            public Object r;

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.clear.2(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                continuation1.r = object0;
                return continuation1;
            }

            public final Object invoke(MixMakerPreference mixMakerPreference0, Continuation continuation0) {
                return ((com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.clear.2)this.create(mixMakerPreference0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((MixMakerPreference)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                MixMakerPreference mixMakerPreference0 = (MixMakerPreference)this.r;
                d5.n.D(object0);
                L l0 = (L)mixMakerPreference0.toBuilder();
                l0.c();
                return l0.a();
            }
        };
        Object object0 = MixMakerPreferencesRepository.b.a(mixMakerPreferencesRepository$clear$20, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @NotNull
    public final Flow getMixTitleFlow() {
        return MixMakerPreferencesRepository.c;
    }

    @Nullable
    public final Object remove(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.remove.2 mixMakerPreferencesRepository$remove$20 = new n(null) {
            public Object r;
            public final String w;

            {
                this.w = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.remove.2(this.w, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            public final Object invoke(MixMakerPreference mixMakerPreference0, Continuation continuation0) {
                return ((com.iloen.melon.utils.datastore.MixMakerPreferencesRepository.remove.2)this.create(mixMakerPreference0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((MixMakerPreference)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                MixMakerPreference mixMakerPreference0 = (MixMakerPreference)this.r;
                d5.n.D(object0);
                List list0 = mixMakerPreference0.getMixTitleList();
                String s = this.w;
                if(list0.contains(s)) {
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object1: list0) {
                        if(!q.b(((String)object1), s)) {
                            arrayList0.add(object1);
                        }
                    }
                    L l0 = (L)mixMakerPreference0.toBuilder();
                    l0.c();
                    l0.d();
                    ((MixMakerPreference)l0.b).addAllMixTitle(arrayList0);
                    return (MixMakerPreference)l0.a();
                }
                return mixMakerPreference0;
            }
        };
        Object object0 = MixMakerPreferencesRepository.b.a(mixMakerPreferencesRepository$remove$20, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

