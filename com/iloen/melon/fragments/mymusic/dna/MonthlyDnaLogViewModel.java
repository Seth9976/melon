package com.iloen.melon.fragments.mymusic.dna;

import androidx.lifecycle.K;
import androidx.lifecycle.L;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.MusicDnaMonthlyLogDetailReq;
import com.iloen.melon.net.v6x.request.MusicDnaPastMonthListReq;
import com.iloen.melon.net.v6x.response.MusicDnaMonthListRes;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.b;
import u8.c;
import u8.d;
import u8.e;
import v8.f;
import v8.g;
import v8.h;
import v8.i;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n0\t2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\f\u0010\rJ#\u0010\u000F\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\n0\t2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u000F\u0010\rJ;\u0010\u0016\u001A\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00102\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0010H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u001A\u0010\u001E\u001A\u00020\u00032\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0096@\u00A2\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u0010 R*\u0010\"\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00150!8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\"\u0010#R-\u0010%\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00150$8\u0006\u00A2\u0006\f\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(R$\u0010)\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010*\u001A\u0004\b+\u0010\u001A\"\u0004\b,\u0010-R$\u0010.\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010*\u001A\u0004\b/\u0010\u001A\"\u0004\b0\u0010-R$\u00101\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u0010*\u001A\u0004\b2\u0010\u001A\"\u0004\b3\u0010-\u00A8\u00066"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogViewModel;", "Lv8/f;", "Lcom/iloen/melon/net/HttpResponse;", "", "includeShortcuts", "<init>", "(Z)V", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Deferred;", "Lu8/d;", "Lcom/iloen/melon/net/v6x/response/MusicDnaMonthListRes;", "requestMonthListAsync", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/MusicDnaMonthlyLogDetailRes;", "requestMusicDnaMonthlyLogDetailAsync", "Lv8/i;", "response", "monthListRes", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/mymusic/dna/DnaLogItemModel;", "Lkotlin/collections/ArrayList;", "createListItems", "(Lv8/i;Lv8/i;)Ljava/util/ArrayList;", "", "getTag", "()Ljava/lang/String;", "getCacheKey", "Lv9/i;", "fetchType", "fetchRequest", "(Lv9/i;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Z", "Landroidx/lifecycle/L;", "_list", "Landroidx/lifecycle/L;", "Landroidx/lifecycle/K;", "list", "Landroidx/lifecycle/K;", "getList", "()Landroidx/lifecycle/K;", "month", "Ljava/lang/String;", "getMonth", "setMonth", "(Ljava/lang/String;)V", "section", "getSection", "setSection", "page", "getPage", "setPage", "Companion", "DnaMonthData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MonthlyDnaLogViewModel extends f {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/MonthlyDnaLogViewModel$DnaMonthData;", "", "monthList", "", "", "<init>", "(Ljava/util/List;)V", "getMonthList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DnaMonthData {
        public static final int $stable = 8;
        @NotNull
        private final List monthList;

        public DnaMonthData(@NotNull List list0) {
            q.g(list0, "monthList");
            super();
            this.monthList = list0;
        }

        @NotNull
        public final List component1() {
            return this.monthList;
        }

        @NotNull
        public final DnaMonthData copy(@NotNull List list0) {
            q.g(list0, "monthList");
            return new DnaMonthData(list0);
        }

        public static DnaMonthData copy$default(DnaMonthData monthlyDnaLogViewModel$DnaMonthData0, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = monthlyDnaLogViewModel$DnaMonthData0.monthList;
            }
            return monthlyDnaLogViewModel$DnaMonthData0.copy(list0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof DnaMonthData ? q.b(this.monthList, ((DnaMonthData)object0).monthList) : false;
        }

        @NotNull
        public final List getMonthList() {
            return this.monthList;
        }

        @Override
        public int hashCode() {
            return this.monthList.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "DnaMonthData(monthList=" + this.monthList + ")";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MonthlyDnaLogViewModel";
    @NotNull
    private final L _list;
    private final boolean includeShortcuts;
    @NotNull
    private final K list;
    @Nullable
    private String month;
    @Nullable
    private String page;
    @Nullable
    private String section;

    static {
        MonthlyDnaLogViewModel.Companion = new Companion(null);
        MonthlyDnaLogViewModel.$stable = 8;
    }

    public MonthlyDnaLogViewModel(boolean z) {
        this.includeShortcuts = z;
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this._list = l0;
        this.list = l0;
    }

    private final ArrayList createListItems(i i0, i i1) {
        ArrayList arrayList0 = new ArrayList();
        MusicDnaMonthlyLogDetailRes musicDnaMonthlyLogDetailRes0 = (MusicDnaMonthlyLogDetailRes)i0.c;
        if(musicDnaMonthlyLogDetailRes0 != null) {
            RESPONSE musicDnaMonthlyLogDetailRes$RESPONSE0 = musicDnaMonthlyLogDetailRes0.response;
            if(musicDnaMonthlyLogDetailRes$RESPONSE0 != null) {
                if(musicDnaMonthlyLogDetailRes$RESPONSE0.songTop != null) {
                    arrayList0.add(new DnaLogItemModel(1, musicDnaMonthlyLogDetailRes$RESPONSE0.songTop));
                }
                if(musicDnaMonthlyLogDetailRes$RESPONSE0.artistTop != null) {
                    arrayList0.add(new DnaLogItemModel(2, musicDnaMonthlyLogDetailRes$RESPONSE0.artistTop));
                }
                if(musicDnaMonthlyLogDetailRes$RESPONSE0.tagTop != null && musicDnaMonthlyLogDetailRes$RESPONSE0.tagTop.tags.size() > 4) {
                    arrayList0.add(new DnaLogItemModel(3, musicDnaMonthlyLogDetailRes$RESPONSE0.tagTop));
                }
                if(musicDnaMonthlyLogDetailRes$RESPONSE0.grnTop != null) {
                    arrayList0.add(new DnaLogItemModel(4, musicDnaMonthlyLogDetailRes$RESPONSE0.grnTop));
                }
                MusicDnaMonthListRes musicDnaMonthListRes0 = (MusicDnaMonthListRes)i1.c;
                if(musicDnaMonthListRes0 != null && (musicDnaMonthListRes0.response != null && (musicDnaMonthListRes0.response.logMonths != null && !musicDnaMonthListRes0.response.logMonths.isEmpty() == 1))) {
                    ArrayList arrayList1 = ((MusicDnaMonthListRes)i1.c).response.logMonths;
                    q.f(arrayList1, "logMonths");
                    arrayList0.add(new DnaLogItemModel(5, new DnaMonthData(arrayList1)));
                }
                if(this.includeShortcuts) {
                    arrayList0.add(new DnaLogItemModel(6, ""));
                }
            }
        }
        return arrayList0;
    }

    @Override  // v8.f
    @Nullable
    public Object fetchRequest(@Nullable v9.i i0, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getMain(), new n(i0, null) {
            final v9.i $fetchType;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                MonthlyDnaLogViewModel.this = monthlyDnaLogViewModel0;
                this.$fetchType = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.fetchRequest.2(MonthlyDnaLogViewModel.this, this.$fetchType, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.fetchRequest.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s2;
                i i1;
                Deferred deferred1;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                a a0 = a.a;
                boolean z = true;
                String s = null;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        String s1 = MonthlyDnaLogViewModel.this.getMonth();
                        if(s1 != null && s1.length() != 0) {
                            MonthlyDnaLogViewModel.this.get_response().postValue(new i(h.d, v9.i.b, null, null));
                            Deferred deferred0 = MonthlyDnaLogViewModel.this.requestMusicDnaMonthlyLogDetailAsync(coroutineScope0);
                            deferred1 = MonthlyDnaLogViewModel.this.requestMonthListAsync(coroutineScope0);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = deferred1;
                            this.label = 1;
                            object0 = deferred0.await(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_23;
                        }
                        return false;
                    }
                    case 1: {
                        deferred1 = (Deferred)this.L$2;
                        Deferred deferred2 = (Deferred)this.L$1;
                        d5.n.D(object0);
                    label_23:
                        i i0 = e1.n.g(((d)object0), this.$fetchType);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = i0;
                        this.label = 2;
                        Object object1 = deferred1.await(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        i1 = i0;
                        object0 = object1;
                        break;
                    }
                    case 2: {
                        i1 = (i)this.L$3;
                        Deferred deferred3 = (Deferred)this.L$2;
                        Deferred deferred4 = (Deferred)this.L$1;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                i i2 = e1.n.g(((d)object0), this.$fetchType);
                Object object2 = i1.c;
                h h0 = h.a;
                if(i1.a == h0) {
                    MonthlyDnaLogViewModel monthlyDnaLogViewModel0 = MonthlyDnaLogViewModel.this;
                    if(((MusicDnaMonthlyLogDetailRes)object2) == null) {
                        s2 = null;
                    }
                    else {
                        RESPONSE musicDnaMonthlyLogDetailRes$RESPONSE0 = ((MusicDnaMonthlyLogDetailRes)object2).response;
                        s2 = musicDnaMonthlyLogDetailRes$RESPONSE0 == null ? null : musicDnaMonthlyLogDetailRes$RESPONSE0.section;
                    }
                    monthlyDnaLogViewModel0.setSection(s2);
                    MonthlyDnaLogViewModel monthlyDnaLogViewModel1 = MonthlyDnaLogViewModel.this;
                    if(((MusicDnaMonthlyLogDetailRes)object2) != null) {
                        RESPONSE musicDnaMonthlyLogDetailRes$RESPONSE1 = ((MusicDnaMonthlyLogDetailRes)object2).response;
                        if(musicDnaMonthlyLogDetailRes$RESPONSE1 != null) {
                            s = musicDnaMonthlyLogDetailRes$RESPONSE1.page;
                        }
                    }
                    monthlyDnaLogViewModel1.setPage(s);
                    ArrayList arrayList0 = MonthlyDnaLogViewModel.this.createListItems(i1, i2);
                    MonthlyDnaLogViewModel.this._list.postValue(arrayList0);
                }
                MonthlyDnaLogViewModel.this.get_response().setValue(i1);
                if(i1.a != h0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, continuation0);
    }

    @Override  // v8.f
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.M.buildUpon().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @NotNull
    public final K getList() {
        return this.list;
    }

    @Nullable
    public final String getMonth() {
        return this.month;
    }

    @Nullable
    public final String getPage() {
        return this.page;
    }

    @Nullable
    public final String getSection() {
        return this.section;
    }

    @Override  // v8.a
    @NotNull
    public String getTag() {
        String s = MelonContentUris.M.buildUpon().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final Deferred requestMonthListAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int label;

            {
                MonthlyDnaLogViewModel.this = monthlyDnaLogViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1(MonthlyDnaLogViewModel.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                int v = this.label;
                switch(v) {
                    case 0: {
                        d5.n.D(object0);
                        g g0 = new g(new MusicDnaPastMonthListReq(), MonthlyDnaLogViewModel.this.getTag());
                        new c(MonthlyDnaLogViewModel.this.getCacheKey());
                        com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$10 = new n(null) {
                            final g $requestWrapper;
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;

                            {
                                this.$requestWrapper = g0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1(this.$requestWrapper, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.2 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$1$20 = new n("DataAccessStrategy", "MusicDnaMonthListRes", null) {
                                            final k $networkCall;
                                            final String $responseClassName;
                                            final String $tag;
                                            int label;

                                            {
                                                this.$networkCall = k0;
                                                this.$tag = s;
                                                this.$responseClassName = s1;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.2(this.$networkCall, this.$tag, this.$responseClassName, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d d0;
                                                a a0 = a.a;
                                                switch(this.label) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        this.label = 1;
                                                        object0 = this.$networkCall.invoke(this);
                                                        if(object0 == a0) {
                                                            return a0;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d5.n.D(object0);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                }
                                                switch(((d)object0).a.ordinal()) {
                                                    case 0: {
                                                        HttpResponse httpResponse0 = ((d)object0).b;
                                                        if(httpResponse0 == null) {
                                                            VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                            d0 = new d(e.b, null, volleyError0);
                                                        }
                                                        else {
                                                            d0 = new d(e.a, httpResponse0, null);
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d0 = new d(e.b, null, ((d)object0).c);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                                LogU.Companion.d(this.$tag, "getData() " + this.$responseClassName + " " + d0);
                                                return d0;
                                            }
                                        };
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.I$0 = 0;
                                        this.label = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$1$20, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        String s = (String)this.L$2;
                                        String s1 = (String)this.L$1;
                                        k k0 = (k)this.L$0;
                                        d5.n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }

                                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                                public final class com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.1 extends oe.i implements k {
                                    final g $requestWrapper;
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    int label;

                                    public com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.1(g g0, Continuation continuation0) {
                                        this.$requestWrapper = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.1(this.$requestWrapper, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                b.b();
                                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.1.1 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$1$1$10 = new n(null) {
                                                    final g $request;
                                                    int label;

                                                    {
                                                        this.$request = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.1.1(this.$request, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        if(this.label == 0) {
                                                            d5.n.D(object0);
                                                            try {
                                                                LogU.Companion.d("RemoteDataSource", "request.tag:" + this.$request.b);
                                                                RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                HttpResponse httpResponse0 = RequestBuilder.newInstance(this.$request.a).listener(requestFuture0).tag(this.$request.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                if(httpResponse0 != null && httpResponse0 instanceof MusicDnaMonthListRes) {
                                                                    return new d(e.a, httpResponse0, null);
                                                                }
                                                                VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                return new d(e.b, null, volleyError1);
                                                            }
                                                            catch(VolleyError volleyError0) {
                                                                return new d(e.b, null, volleyError0);
                                                            }
                                                        }
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                };
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.I$0 = 0;
                                                this.label = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$1$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                g g0 = (g)this.L$1;
                                                t8.a a1 = (t8.a)this.L$0;
                                                d5.n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }

                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 1;
                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$10, this);
                        return object1 == a0 ? a0 : object1;
                    label_22:
                        if(v != 2) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        c c0 = (c)this.L$6;
                        goto label_24;
                    }
                    case 1: {
                    label_24:
                        g g1 = (g)this.L$5;
                        b b0 = (b)this.L$4;
                        c c1 = (c)this.L$3;
                        g g2 = (g)this.L$2;
                        b b1 = (b)this.L$1;
                        g g3 = (g)this.L$0;
                        d5.n.D(object0);
                        return object0;
                    }
                    default: {
                        goto label_22;
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                public final class com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2 extends oe.i implements n {
                    final c $cacheStrategyInfo;
                    final g $requestWrapper;
                    final int $startIndex;
                    int I$0;
                    long J$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;

                    public com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2(c c0, int v, g g0, Continuation continuation0) {
                        this.$cacheStrategyInfo = c0;
                        this.$startIndex = v;
                        this.$requestWrapper = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2(this.$cacheStrategyInfo, this.$startIndex, this.$requestWrapper, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.1 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$10 = new k(null) {
                                    final g $requestWrapper;
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    int label;

                                    {
                                        this.$requestWrapper = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.1(this.$requestWrapper, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                b.b();
                                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.1.1 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$1$10 = new n(null) {
                                                    final g $request;
                                                    int label;

                                                    {
                                                        this.$request = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.1.1(this.$request, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        if(this.label == 0) {
                                                            d5.n.D(object0);
                                                            try {
                                                                LogU.Companion.d("RemoteDataSource", "request.tag:" + this.$request.b);
                                                                RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                HttpResponse httpResponse0 = RequestBuilder.newInstance(this.$request.a).listener(requestFuture0).tag(this.$request.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                if(httpResponse0 != null && httpResponse0 instanceof MusicDnaMonthListRes) {
                                                                    return new d(e.a, httpResponse0, null);
                                                                }
                                                                VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                return new d(e.b, null, volleyError1);
                                                            }
                                                            catch(VolleyError volleyError0) {
                                                                return new d(e.b, null, volleyError0);
                                                            }
                                                        }
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                };
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.I$0 = 0;
                                                this.label = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                g g0 = (g)this.L$1;
                                                t8.a a1 = (t8.a)this.L$0;
                                                d5.n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.2 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$20 = new we.a() {
                                    @Override  // we.a
                                    public Object invoke() {
                                        return this.invoke();
                                    }

                                    public final s8.b invoke() {
                                        return b.a().a(this.$cacheStrategyInfo.a);
                                    }
                                };
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.3 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$30 = new k() {
                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        this.invoke(((HttpResponse)object0));
                                        return H.a;
                                    }

                                    public final void invoke(HttpResponse httpResponse0) {
                                        q.g(httpResponse0, "it");
                                        s8.a a0 = b.a();
                                        String s = b.c.k(httpResponse0);
                                        q.f(s, "toJson(...)");
                                        a0.b(new s8.b(this.$startIndex, this.$startIndex.a, s, System.currentTimeMillis()));
                                    }
                                };
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.4 monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$40 = new n(new Integer(this.$startIndex), this.$cacheStrategyInfo.b, monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$10, monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$30, null) {
                                    final we.a $databaseQuery;
                                    final long $expiredTimeLimit;
                                    final k $networkCall;
                                    final k $saveCallResult;
                                    final Integer $startIndex;
                                    private Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
                                    int label;

                                    {
                                        this.$databaseQuery = a0;
                                        this.$startIndex = integer0;
                                        this.$expiredTimeLimit = v;
                                        this.$networkCall = k0;
                                        this.$saveCallResult = k1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.4(this.$databaseQuery, this.$startIndex, this.$expiredTimeLimit, this.$networkCall, this.$saveCallResult, continuation0);
                                        continuation1.L$0 = object0;
                                        return continuation1;
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d d0;
                                        String s1;
                                        String s;
                                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                                logU$Companion0.d("DataAccessStrategy", "getData() MusicDnaMonthListRes");
                                                s8.b b0 = this.$databaseQuery == null ? null : ((s8.b)this.$databaseQuery.invoke());
                                                if(b0 != null && !u.H(b0, this.$startIndex, this.$expiredTimeLimit)) {
                                                    HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, MusicDnaMonthListRes.class);
                                                    if(httpResponse0 != null) {
                                                        logU$Companion0.d("DataAccessStrategy", "getData() MusicDnaMonthListRes cacheEntity not expired. > return cachedRes");
                                                        return new d(e.a, httpResponse0, null);
                                                    }
                                                }
                                                logU$Companion0.d("DataAccessStrategy", "getData() MusicDnaMonthListRes cacheEntity expired.");
                                                this.L$0 = coroutineScope0;
                                                this.L$1 = "DataAccessStrategy";
                                                this.L$2 = "MusicDnaMonthListRes";
                                                this.L$3 = null;
                                                this.label = 1;
                                                object0 = this.$networkCall.invoke(this);
                                                if(object0 == a0) {
                                                    return a0;
                                                }
                                                s = "MusicDnaMonthListRes";
                                                s1 = "DataAccessStrategy";
                                                break;
                                            }
                                            case 1: {
                                                s8.b b1 = (s8.b)this.L$3;
                                                s = (String)this.L$2;
                                                String s2 = (String)this.L$1;
                                                d5.n.D(object0);
                                                s1 = s2;
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        switch(((d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse1 = ((d)object0).b;
                                                if(httpResponse1 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new d(e.b, null, volleyError0);
                                                }
                                                else {
                                                    d d1 = new d(e.a, httpResponse1, null);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new n(((d)object0), null) {
                                                        final d $responseContainer;
                                                        final k $saveCallResult;
                                                        int label;

                                                        {
                                                            this.$saveCallResult = k0;
                                                            this.$responseContainer = d0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.4.1(this.$saveCallResult, this.$responseContainer, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMonthListAsync.1.invokeSuspend..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            k k0 = this.$saveCallResult;
                                                            if(k0 != null) {
                                                                k0.invoke(this.$responseContainer.b);
                                                            }
                                                            return H.a;
                                                        }
                                                    }, 2, null);
                                                    d0 = d1;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new d(e.b, null, ((d)object0).c);
                                                break;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                        LogU.Companion.d(s1, "getData() " + s + " " + d0);
                                        return d0;
                                    }
                                };
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = this.$cacheStrategyInfo.b;
                                this.I$0 = 0;
                                this.label = 1;
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMonthListAsync$1$invokeSuspend$$inlined$request$default$2$40, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                k k0 = (k)this.L$3;
                                we.a a1 = (we.a)this.L$2;
                                k k1 = (k)this.L$1;
                                Integer integer0 = (Integer)this.L$0;
                                d5.n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                }

            }
        }, 3, null);
    }

    private final Deferred requestMusicDnaMonthlyLogDetailAsync(CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope0, null, null, new n(null) {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int label;

            {
                MonthlyDnaLogViewModel.this = monthlyDnaLogViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1(MonthlyDnaLogViewModel.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                int v = this.label;
                switch(v) {
                    case 0: {
                        d5.n.D(object0);
                        g g0 = new g(new MusicDnaMonthlyLogDetailReq(MonthlyDnaLogViewModel.this.getMonth()), MonthlyDnaLogViewModel.this.getTag());
                        new c(MonthlyDnaLogViewModel.this.getCacheKey());
                        com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$10 = new n(null) {
                            final g $requestWrapper;
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;

                            {
                                this.$requestWrapper = g0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1(this.$requestWrapper, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.2 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$1$20 = new n("DataAccessStrategy", "MusicDnaMonthlyLogDetailRes", null) {
                                            final k $networkCall;
                                            final String $responseClassName;
                                            final String $tag;
                                            int label;

                                            {
                                                this.$networkCall = k0;
                                                this.$tag = s;
                                                this.$responseClassName = s1;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.2(this.$networkCall, this.$tag, this.$responseClassName, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                d d0;
                                                a a0 = a.a;
                                                switch(this.label) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        this.label = 1;
                                                        object0 = this.$networkCall.invoke(this);
                                                        if(object0 == a0) {
                                                            return a0;
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d5.n.D(object0);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                }
                                                switch(((d)object0).a.ordinal()) {
                                                    case 0: {
                                                        HttpResponse httpResponse0 = ((d)object0).b;
                                                        if(httpResponse0 == null) {
                                                            VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                            d0 = new d(e.b, null, volleyError0);
                                                        }
                                                        else {
                                                            d0 = new d(e.a, httpResponse0, null);
                                                        }
                                                        break;
                                                    }
                                                    case 1: {
                                                        d0 = new d(e.b, null, ((d)object0).c);
                                                        break;
                                                    }
                                                    default: {
                                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                    }
                                                }
                                                LogU.Companion.d(this.$tag, "getData() " + this.$responseClassName + " " + d0);
                                                return d0;
                                            }
                                        };
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.I$0 = 0;
                                        this.label = 1;
                                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$1$20, this);
                                        return object1 == a0 ? a0 : object1;
                                    }
                                    case 1: {
                                        String s = (String)this.L$2;
                                        String s1 = (String)this.L$1;
                                        k k0 = (k)this.L$0;
                                        d5.n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }

                                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lu8/d;", "<anonymous>", "()Lu8/d;"}, k = 3, mv = {2, 2, 0})
                                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForNonCache$2$1", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                                public final class com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.1 extends oe.i implements k {
                                    final g $requestWrapper;
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    int label;

                                    public com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.1(g g0, Continuation continuation0) {
                                        this.$requestWrapper = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.1(this.$requestWrapper, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                b.b();
                                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.1.1 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$1$1$10 = new n(null) {
                                                    final g $request;
                                                    int label;

                                                    {
                                                        this.$request = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.1.1(this.$request, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        if(this.label == 0) {
                                                            d5.n.D(object0);
                                                            try {
                                                                LogU.Companion.d("RemoteDataSource", "request.tag:" + this.$request.b);
                                                                RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                HttpResponse httpResponse0 = RequestBuilder.newInstance(this.$request.a).listener(requestFuture0).tag(this.$request.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                if(httpResponse0 != null && httpResponse0 instanceof MusicDnaMonthlyLogDetailRes) {
                                                                    return new d(e.a, httpResponse0, null);
                                                                }
                                                                VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                return new d(e.b, null, volleyError1);
                                                            }
                                                            catch(VolleyError volleyError0) {
                                                                return new d(e.b, null, volleyError0);
                                                            }
                                                        }
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                };
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.I$0 = 0;
                                                this.label = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$1$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                g g0 = (g)this.L$1;
                                                t8.a a1 = (t8.a)this.L$0;
                                                d5.n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                }

                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 1;
                        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$10, this);
                        return object1 == a0 ? a0 : object1;
                    label_23:
                        if(v != 2) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        c c0 = (c)this.L$7;
                        goto label_25;
                    }
                    case 1: {
                    label_25:
                        g g1 = (g)this.L$6;
                        b b0 = (b)this.L$5;
                        c c1 = (c)this.L$4;
                        g g2 = (g)this.L$3;
                        b b1 = (b)this.L$2;
                        g g3 = (g)this.L$1;
                        MusicDnaMonthlyLogDetailReq musicDnaMonthlyLogDetailReq0 = (MusicDnaMonthlyLogDetailReq)this.L$0;
                        d5.n.D(object0);
                        return object0;
                    }
                    default: {
                        goto label_23;
                    }
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Response", "Lkotlinx/coroutines/CoroutineScope;", "Lu8/d;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lu8/d;"}, k = 3, mv = {2, 2, 0})
                @oe.e(c = "com.iloen.melon.api.data.repository.ApiRepository$requestSyncForDbCache$2", f = "ApiRepository.kt", l = {81}, m = "invokeSuspend")
                public final class com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2 extends oe.i implements n {
                    final c $cacheStrategyInfo;
                    final g $requestWrapper;
                    final int $startIndex;
                    int I$0;
                    long J$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;

                    public com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2(c c0, int v, g g0, Continuation continuation0) {
                        this.$cacheStrategyInfo = c0;
                        this.$startIndex = v;
                        this.$requestWrapper = g0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2(this.$cacheStrategyInfo, this.$startIndex, this.$requestWrapper, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.1 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$10 = new k(null) {
                                    final g $requestWrapper;
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    int label;

                                    {
                                        this.$requestWrapper = g0;
                                        super(1, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Continuation continuation0) {
                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.1(this.$requestWrapper, continuation0);
                                    }

                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        return this.invoke(((Continuation)object0));
                                    }

                                    public final Object invoke(Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.1)this.create(continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                b.b();
                                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.1.1 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$1$10 = new n(null) {
                                                    final g $request;
                                                    int label;

                                                    {
                                                        this.$request = g0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.1.1(this.$request, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        if(this.label == 0) {
                                                            d5.n.D(object0);
                                                            try {
                                                                LogU.Companion.d("RemoteDataSource", "request.tag:" + this.$request.b);
                                                                RequestFuture requestFuture0 = RequestFuture.newFuture();
                                                                HttpResponse httpResponse0 = RequestBuilder.newInstance(this.$request.a).listener(requestFuture0).tag(this.$request.b).errorListener(requestFuture0).requestSyncForViewModel(requestFuture0);
                                                                if(httpResponse0 != null && httpResponse0 instanceof MusicDnaMonthlyLogDetailRes) {
                                                                    return new d(e.a, httpResponse0, null);
                                                                }
                                                                VolleyError volleyError1 = new VolleyError("status success but response is null");
                                                                return new d(e.b, null, volleyError1);
                                                            }
                                                            catch(VolleyError volleyError0) {
                                                                return new d(e.b, null, volleyError0);
                                                            }
                                                        }
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                };
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.I$0 = 0;
                                                this.label = 1;
                                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$1$10, this);
                                                return object1 == a0 ? a0 : object1;
                                            }
                                            case 1: {
                                                g g0 = (g)this.L$1;
                                                t8.a a1 = (t8.a)this.L$0;
                                                d5.n.D(object0);
                                                return object0;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.2 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$20 = new we.a() {
                                    @Override  // we.a
                                    public Object invoke() {
                                        return this.invoke();
                                    }

                                    public final s8.b invoke() {
                                        return b.a().a(this.$cacheStrategyInfo.a);
                                    }
                                };
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.3 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$30 = new k() {
                                    @Override  // we.k
                                    public Object invoke(Object object0) {
                                        this.invoke(((HttpResponse)object0));
                                        return H.a;
                                    }

                                    public final void invoke(HttpResponse httpResponse0) {
                                        q.g(httpResponse0, "it");
                                        s8.a a0 = b.a();
                                        String s = b.c.k(httpResponse0);
                                        q.f(s, "toJson(...)");
                                        a0.b(new s8.b(this.$startIndex, this.$startIndex.a, s, System.currentTimeMillis()));
                                    }
                                };
                                com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.4 monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$40 = new n(new Integer(this.$startIndex), this.$cacheStrategyInfo.b, monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$10, monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$30, null) {
                                    final we.a $databaseQuery;
                                    final long $expiredTimeLimit;
                                    final k $networkCall;
                                    final k $saveCallResult;
                                    final Integer $startIndex;
                                    private Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
                                    int label;

                                    {
                                        this.$databaseQuery = a0;
                                        this.$startIndex = integer0;
                                        this.$expiredTimeLimit = v;
                                        this.$networkCall = k0;
                                        this.$saveCallResult = k1;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.4(this.$databaseQuery, this.$startIndex, this.$expiredTimeLimit, this.$networkCall, this.$saveCallResult, continuation0);
                                        continuation1.L$0 = object0;
                                        return continuation1;
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        d d0;
                                        String s1;
                                        String s;
                                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                                logU$Companion0.d("DataAccessStrategy", "getData() MusicDnaMonthlyLogDetailRes");
                                                s8.b b0 = this.$databaseQuery == null ? null : ((s8.b)this.$databaseQuery.invoke());
                                                if(b0 != null && !u.H(b0, this.$startIndex, this.$expiredTimeLimit)) {
                                                    HttpResponse httpResponse0 = (HttpResponse)new com.google.gson.n().e(b0.b, MusicDnaMonthlyLogDetailRes.class);
                                                    if(httpResponse0 != null) {
                                                        logU$Companion0.d("DataAccessStrategy", "getData() MusicDnaMonthlyLogDetailRes cacheEntity not expired. > return cachedRes");
                                                        return new d(e.a, httpResponse0, null);
                                                    }
                                                }
                                                logU$Companion0.d("DataAccessStrategy", "getData() MusicDnaMonthlyLogDetailRes cacheEntity expired.");
                                                this.L$0 = coroutineScope0;
                                                this.L$1 = "DataAccessStrategy";
                                                this.L$2 = "MusicDnaMonthlyLogDetailRes";
                                                this.L$3 = null;
                                                this.label = 1;
                                                object0 = this.$networkCall.invoke(this);
                                                if(object0 == a0) {
                                                    return a0;
                                                }
                                                s = "MusicDnaMonthlyLogDetailRes";
                                                s1 = "DataAccessStrategy";
                                                break;
                                            }
                                            case 1: {
                                                s8.b b1 = (s8.b)this.L$3;
                                                s = (String)this.L$2;
                                                String s2 = (String)this.L$1;
                                                d5.n.D(object0);
                                                s1 = s2;
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        switch(((d)object0).a.ordinal()) {
                                            case 0: {
                                                HttpResponse httpResponse1 = ((d)object0).b;
                                                if(httpResponse1 == null) {
                                                    VolleyError volleyError0 = new VolleyError("status success but response is null");
                                                    d0 = new d(e.b, null, volleyError0);
                                                }
                                                else {
                                                    d d1 = new d(e.a, httpResponse1, null);
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getIO(), null, new n(((d)object0), null) {
                                                        final d $responseContainer;
                                                        final k $saveCallResult;
                                                        int label;

                                                        {
                                                            this.$saveCallResult = k0;
                                                            this.$responseContainer = d0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.4.1(this.$saveCallResult, this.$responseContainer, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.mymusic.dna.MonthlyDnaLogViewModel.requestMusicDnaMonthlyLogDetailAsync.1.invokeSuspend..inlined.request.default.2.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            k k0 = this.$saveCallResult;
                                                            if(k0 != null) {
                                                                k0.invoke(this.$responseContainer.b);
                                                            }
                                                            return H.a;
                                                        }
                                                    }, 2, null);
                                                    d0 = d1;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d0 = new d(e.b, null, ((d)object0).c);
                                                break;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                        LogU.Companion.d(s1, "getData() " + s + " " + d0);
                                        return d0;
                                    }
                                };
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = this.$cacheStrategyInfo.b;
                                this.I$0 = 0;
                                this.label = 1;
                                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), monthlyDnaLogViewModel$requestMusicDnaMonthlyLogDetailAsync$1$invokeSuspend$$inlined$request$default$2$40, this);
                                return object1 == a0 ? a0 : object1;
                            }
                            case 1: {
                                k k0 = (k)this.L$3;
                                we.a a1 = (we.a)this.L$2;
                                k k1 = (k)this.L$1;
                                Integer integer0 = (Integer)this.L$0;
                                d5.n.D(object0);
                                return object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                }

            }
        }, 3, null);
    }

    public final void setMonth(@Nullable String s) {
        this.month = s;
    }

    public final void setPage(@Nullable String s) {
        this.page = s;
    }

    public final void setSection(@Nullable String s) {
        this.section = s;
    }
}

