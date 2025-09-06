package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import Cb.i;
import U4.x;
import com.iloen.melon.fragments.detail.ui.ListeningUiState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-BE\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0016\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0012J\u0010\u0010\u0017\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\\\u0010\u0019\u001A\u00020\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\f\u001A\u00020\u000BH\u00C6\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b\u001B\u0010\u0012J\u0010\u0010\u001D\u001A\u00020\u001CH\u00D6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001A\u0010!\u001A\u00020 2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b!\u0010\"R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010#\u001A\u0004\b$\u0010\u0010R\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010%\u001A\u0004\b&\u0010\u0012R\u0017\u0010\u0007\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010%\u001A\u0004\b\'\u0010\u0012R\u0017\u0010\b\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\b\u0010%\u001A\u0004\b(\u0010\u0012R\u0017\u0010\t\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\t\u0010%\u001A\u0004\b)\u0010\u0012R\u0017\u0010\n\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\n\u0010%\u001A\u0004\b*\u0010\u0012R\u0017\u0010\f\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\b\f\u0010+\u001A\u0004\b,\u0010\u0018\u00A8\u0006."}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;", "", "Lkotlin/Function0;", "Lie/H;", "guidePopupAction", "", "totalListenCount", "totalListenerCount", "dailyListenerCount", "listenCount", "firstListenDate", "Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;", "listeningUiState", "<init>", "(Lwe/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;)V", "component1", "()Lwe/a;", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "()Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;", "copy", "(Lwe/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;)Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lwe/a;", "getGuidePopupAction", "Ljava/lang/String;", "getTotalListenCount", "getTotalListenerCount", "getDailyListenerCount", "getListenCount", "getFirstListenDate", "Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;", "getListeningUiState", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StreamReportUiState {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState$Companion;", "", "<init>", "()V", "Lkotlin/Function0;", "Lie/H;", "guidePopupAction", "Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;", "createDummy", "(Lwe/a;)Lcom/iloen/melon/fragments/detail/viewholder/StreamReportUiState;", "", "guide", "Ljava/lang/String;", "getGuide", "()Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final StreamReportUiState createDummy(@NotNull a a0) {
            q.g(a0, "guidePopupAction");
            return new StreamReportUiState(a0, "13.7M", "920,210", "920,210", "23", "2024.05.17", ListeningUiState.Companion.getSample());
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getGuide() {
            return "이 곡을 스트리밍, 다운로드 한 이용자 정보를 분석하여 제공하는 데이터 입니다. 감상 비율 통계는 데일리 감상 기록을 기반으로 합니다.\n\n업데이트 시간\n- 누적 기록: 매일 오전 4시\n- 데일리 감상 기록: 매일 오후 3시\n- 나의 감상 횟수: 실시간\n- 감상 비율 통계: 매일 오후 3시";
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String dailyListenerCount;
    @NotNull
    private final String firstListenDate;
    @NotNull
    private static final String guide;
    @NotNull
    private final a guidePopupAction;
    @NotNull
    private final String listenCount;
    @NotNull
    private final ListeningUiState listeningUiState;
    @NotNull
    private final String totalListenCount;
    @NotNull
    private final String totalListenerCount;

    static {
        StreamReportUiState.Companion = new Companion(null);
        StreamReportUiState.$stable = 8;
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("이 곡을 스트리밍, 다운로드 한 이용자 정보를 분석하여 제공하는 데이터 입니다. 감상 비율 통계는 데일리 감상 기록을 기반으로 합니다.");
        i.m(stringBuilder0);
        i.m(stringBuilder0);
        stringBuilder0.append("업데이트 시간");
        i.m(stringBuilder0);
        stringBuilder0.append("- 누적 기록: 매일 오전 4시");
        i.m(stringBuilder0);
        stringBuilder0.append("- 데일리 감상 기록: 매일 오후 3시");
        i.m(stringBuilder0);
        stringBuilder0.append("- 나의 감상 횟수: 실시간");
        i.m(stringBuilder0);
        stringBuilder0.append("- 감상 비율 통계: 매일 오후 3시");
        StreamReportUiState.guide = "이 곡을 스트리밍, 다운로드 한 이용자 정보를 분석하여 제공하는 데이터 입니다. 감상 비율 통계는 데일리 감상 기록을 기반으로 합니다.\n\n업데이트 시간\n- 누적 기록: 매일 오전 4시\n- 데일리 감상 기록: 매일 오후 3시\n- 나의 감상 횟수: 실시간\n- 감상 비율 통계: 매일 오후 3시";
    }

    public StreamReportUiState(@NotNull a a0, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull ListeningUiState listeningUiState0) {
        q.g(a0, "guidePopupAction");
        q.g(s, "totalListenCount");
        q.g(s1, "totalListenerCount");
        q.g(s2, "dailyListenerCount");
        q.g(s3, "listenCount");
        q.g(s4, "firstListenDate");
        q.g(listeningUiState0, "listeningUiState");
        super();
        this.guidePopupAction = a0;
        this.totalListenCount = s;
        this.totalListenerCount = s1;
        this.dailyListenerCount = s2;
        this.listenCount = s3;
        this.firstListenDate = s4;
        this.listeningUiState = listeningUiState0;
    }

    // 去混淆评级： 低(20)
    public static final String access$getGuide$cp() [...] // 潜在的解密器

    @NotNull
    public final a component1() {
        return this.guidePopupAction;
    }

    @NotNull
    public final String component2() {
        return this.totalListenCount;
    }

    @NotNull
    public final String component3() {
        return this.totalListenerCount;
    }

    @NotNull
    public final String component4() {
        return this.dailyListenerCount;
    }

    @NotNull
    public final String component5() {
        return this.listenCount;
    }

    @NotNull
    public final String component6() {
        return this.firstListenDate;
    }

    @NotNull
    public final ListeningUiState component7() {
        return this.listeningUiState;
    }

    @NotNull
    public final StreamReportUiState copy(@NotNull a a0, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull ListeningUiState listeningUiState0) {
        q.g(a0, "guidePopupAction");
        q.g(s, "totalListenCount");
        q.g(s1, "totalListenerCount");
        q.g(s2, "dailyListenerCount");
        q.g(s3, "listenCount");
        q.g(s4, "firstListenDate");
        q.g(listeningUiState0, "listeningUiState");
        return new StreamReportUiState(a0, s, s1, s2, s3, s4, listeningUiState0);
    }

    public static StreamReportUiState copy$default(StreamReportUiState streamReportUiState0, a a0, String s, String s1, String s2, String s3, String s4, ListeningUiState listeningUiState0, int v, Object object0) {
        if((v & 1) != 0) {
            a0 = streamReportUiState0.guidePopupAction;
        }
        if((v & 2) != 0) {
            s = streamReportUiState0.totalListenCount;
        }
        if((v & 4) != 0) {
            s1 = streamReportUiState0.totalListenerCount;
        }
        if((v & 8) != 0) {
            s2 = streamReportUiState0.dailyListenerCount;
        }
        if((v & 16) != 0) {
            s3 = streamReportUiState0.listenCount;
        }
        if((v & 0x20) != 0) {
            s4 = streamReportUiState0.firstListenDate;
        }
        if((v & 0x40) != 0) {
            listeningUiState0 = streamReportUiState0.listeningUiState;
        }
        return streamReportUiState0.copy(a0, s, s1, s2, s3, s4, listeningUiState0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof StreamReportUiState)) {
            return false;
        }
        if(!q.b(this.guidePopupAction, ((StreamReportUiState)object0).guidePopupAction)) {
            return false;
        }
        if(!q.b(this.totalListenCount, ((StreamReportUiState)object0).totalListenCount)) {
            return false;
        }
        if(!q.b(this.totalListenerCount, ((StreamReportUiState)object0).totalListenerCount)) {
            return false;
        }
        if(!q.b(this.dailyListenerCount, ((StreamReportUiState)object0).dailyListenerCount)) {
            return false;
        }
        if(!q.b(this.listenCount, ((StreamReportUiState)object0).listenCount)) {
            return false;
        }
        return q.b(this.firstListenDate, ((StreamReportUiState)object0).firstListenDate) ? q.b(this.listeningUiState, ((StreamReportUiState)object0).listeningUiState) : false;
    }

    @NotNull
    public final String getDailyListenerCount() {
        return this.dailyListenerCount;
    }

    @NotNull
    public final String getFirstListenDate() {
        return this.firstListenDate;
    }

    @NotNull
    public final a getGuidePopupAction() {
        return this.guidePopupAction;
    }

    @NotNull
    public final String getListenCount() {
        return this.listenCount;
    }

    @NotNull
    public final ListeningUiState getListeningUiState() {
        return this.listeningUiState;
    }

    @NotNull
    public final String getTotalListenCount() {
        return this.totalListenCount;
    }

    @NotNull
    public final String getTotalListenerCount() {
        return this.totalListenerCount;
    }

    @Override
    public int hashCode() {
        return this.listeningUiState.hashCode() + x.b(x.b(x.b(x.b(x.b(this.guidePopupAction.hashCode() * 0x1F, 0x1F, this.totalListenCount), 0x1F, this.totalListenerCount), 0x1F, this.dailyListenerCount), 0x1F, this.listenCount), 0x1F, this.firstListenDate);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("StreamReportUiState(guidePopupAction=");
        stringBuilder0.append(this.guidePopupAction);
        stringBuilder0.append(", totalListenCount=");
        stringBuilder0.append(this.totalListenCount);
        stringBuilder0.append(", totalListenerCount=");
        d.u(stringBuilder0, this.totalListenerCount, ", dailyListenerCount=", this.dailyListenerCount, ", listenCount=");
        d.u(stringBuilder0, this.listenCount, ", firstListenDate=", this.firstListenDate, ", listeningUiState=");
        stringBuilder0.append(this.listeningUiState);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

