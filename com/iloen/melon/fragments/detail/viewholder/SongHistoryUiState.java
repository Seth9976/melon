package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import Cb.i;
import U4.x;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.SongAchievementInfo.RecordList;
import e.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,BC\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007\u0012\u0006\u0010\n\u001A\u00020\u0007\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000B\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0015J\u0016\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019JX\u0010\u001A\u001A\u00020\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u00072\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u00C6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0007H\u00D6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u0015J\u0010\u0010\u001E\u001A\u00020\u001DH\u00D6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001A\u0010!\u001A\u00020\u00052\b\u0010 \u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b!\u0010\"R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010#\u001A\u0004\b$\u0010\u0011R\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010%\u001A\u0004\b\u0006\u0010\u0013R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u0010&\u001A\u0004\b\'\u0010\u0015R\u0017\u0010\t\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\t\u0010&\u001A\u0004\b(\u0010\u0015R\u0017\u0010\n\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b\n\u0010&\u001A\u0004\b)\u0010\u0015R\u001D\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000B8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010*\u001A\u0004\b+\u0010\u0019\u00A8\u0006-"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState;", "", "Lkotlin/Function0;", "Lie/H;", "guidePopupAction", "", "isChartIn", "", "yesterdayRank", "bestRank", "bestRankDate", "", "Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE$SongAchievementInfo$RecordList;", "recordList", "<init>", "(Lwe/a;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "component1", "()Lwe/a;", "component2", "()Z", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "()Ljava/util/List;", "copy", "(Lwe/a;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lwe/a;", "getGuidePopupAction", "Z", "Ljava/lang/String;", "getYesterdayRank", "getBestRank", "getBestRankDate", "Ljava/util/List;", "getRecordList", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongHistoryUiState {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\b\u001A\u00020\u00072\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState$Companion;", "", "<init>", "()V", "Lkotlin/Function0;", "Lie/H;", "guidePopupAction", "Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState;", "createDummy", "(Lwe/a;)Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState;", "", "guide", "Ljava/lang/String;", "getGuide", "()Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongHistoryUiState createDummy(@NotNull a a0) {
            q.g(a0, "guidePopupAction");
            RecordList songInfoRes$RESPONSE$SongAchievementInfo$RecordList0 = new RecordList();
            songInfoRes$RESPONSE$SongAchievementInfo$RecordList0.recordCode = "C2";
            songInfoRes$RESPONSE$SongAchievementInfo$RecordList0.record = "멜론 일간차트 총 12회 1위 달성";
            return new SongHistoryUiState(a0, true, "5", "2", "2024.05.18", k.C(new RecordList[]{songInfoRes$RESPONSE$SongAchievementInfo$RecordList0}));
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getGuide() {
            return "멜론차트, 주간인기상 등의 데이터를 분석하여 이 곡의 명예로운 기록들을 보여줍니다.\n\n데이터 생성 기준\n- 오늘 낮 12시까지의 데이터\n\n업데이트 시간\n- 최고 순위, 수상 기록: 매일 오후 5시\n- 어제의 차트 순위: 매일 오후 3시\n\n차트 기록 기준일\n- 일간차트: 14.01.01 이후 기록";
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String bestRank;
    @NotNull
    private final String bestRankDate;
    @NotNull
    private static final String guide;
    @NotNull
    private final a guidePopupAction;
    private final boolean isChartIn;
    @NotNull
    private final List recordList;
    @NotNull
    private final String yesterdayRank;

    static {
        SongHistoryUiState.Companion = new Companion(null);
        SongHistoryUiState.$stable = 8;
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("멜론차트, 주간인기상 등의 데이터를 분석하여 이 곡의 명예로운 기록들을 보여줍니다.");
        i.m(stringBuilder0);
        i.m(stringBuilder0);
        stringBuilder0.append("데이터 생성 기준");
        i.m(stringBuilder0);
        stringBuilder0.append("- 오늘 낮 12시까지의 데이터");
        i.m(stringBuilder0);
        i.m(stringBuilder0);
        stringBuilder0.append("업데이트 시간");
        i.m(stringBuilder0);
        stringBuilder0.append("- 최고 순위, 수상 기록: 매일 오후 5시");
        i.m(stringBuilder0);
        stringBuilder0.append("- 어제의 차트 순위: 매일 오후 3시");
        i.m(stringBuilder0);
        i.m(stringBuilder0);
        stringBuilder0.append("차트 기록 기준일");
        i.m(stringBuilder0);
        stringBuilder0.append("- 일간차트: 14.01.01 이후 기록");
        SongHistoryUiState.guide = "멜론차트, 주간인기상 등의 데이터를 분석하여 이 곡의 명예로운 기록들을 보여줍니다.\n\n데이터 생성 기준\n- 오늘 낮 12시까지의 데이터\n\n업데이트 시간\n- 최고 순위, 수상 기록: 매일 오후 5시\n- 어제의 차트 순위: 매일 오후 3시\n\n차트 기록 기준일\n- 일간차트: 14.01.01 이후 기록";
    }

    public SongHistoryUiState(@NotNull a a0, boolean z, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull List list0) {
        q.g(a0, "guidePopupAction");
        q.g(s, "yesterdayRank");
        q.g(s1, "bestRank");
        q.g(s2, "bestRankDate");
        q.g(list0, "recordList");
        super();
        this.guidePopupAction = a0;
        this.isChartIn = z;
        this.yesterdayRank = s;
        this.bestRank = s1;
        this.bestRankDate = s2;
        this.recordList = list0;
    }

    // 去混淆评级： 低(20)
    public static final String access$getGuide$cp() [...] // 潜在的解密器

    @NotNull
    public final a component1() {
        return this.guidePopupAction;
    }

    public final boolean component2() {
        return this.isChartIn;
    }

    @NotNull
    public final String component3() {
        return this.yesterdayRank;
    }

    @NotNull
    public final String component4() {
        return this.bestRank;
    }

    @NotNull
    public final String component5() {
        return this.bestRankDate;
    }

    @NotNull
    public final List component6() {
        return this.recordList;
    }

    @NotNull
    public final SongHistoryUiState copy(@NotNull a a0, boolean z, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull List list0) {
        q.g(a0, "guidePopupAction");
        q.g(s, "yesterdayRank");
        q.g(s1, "bestRank");
        q.g(s2, "bestRankDate");
        q.g(list0, "recordList");
        return new SongHistoryUiState(a0, z, s, s1, s2, list0);
    }

    public static SongHistoryUiState copy$default(SongHistoryUiState songHistoryUiState0, a a0, boolean z, String s, String s1, String s2, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            a0 = songHistoryUiState0.guidePopupAction;
        }
        if((v & 2) != 0) {
            z = songHistoryUiState0.isChartIn;
        }
        if((v & 4) != 0) {
            s = songHistoryUiState0.yesterdayRank;
        }
        if((v & 8) != 0) {
            s1 = songHistoryUiState0.bestRank;
        }
        if((v & 16) != 0) {
            s2 = songHistoryUiState0.bestRankDate;
        }
        if((v & 0x20) != 0) {
            list0 = songHistoryUiState0.recordList;
        }
        return songHistoryUiState0.copy(a0, z, s, s1, s2, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SongHistoryUiState)) {
            return false;
        }
        if(!q.b(this.guidePopupAction, ((SongHistoryUiState)object0).guidePopupAction)) {
            return false;
        }
        if(this.isChartIn != ((SongHistoryUiState)object0).isChartIn) {
            return false;
        }
        if(!q.b(this.yesterdayRank, ((SongHistoryUiState)object0).yesterdayRank)) {
            return false;
        }
        if(!q.b(this.bestRank, ((SongHistoryUiState)object0).bestRank)) {
            return false;
        }
        return q.b(this.bestRankDate, ((SongHistoryUiState)object0).bestRankDate) ? q.b(this.recordList, ((SongHistoryUiState)object0).recordList) : false;
    }

    @NotNull
    public final String getBestRank() {
        return this.bestRank;
    }

    @NotNull
    public final String getBestRankDate() {
        return this.bestRankDate;
    }

    @NotNull
    public final a getGuidePopupAction() {
        return this.guidePopupAction;
    }

    @NotNull
    public final List getRecordList() {
        return this.recordList;
    }

    @NotNull
    public final String getYesterdayRank() {
        return this.yesterdayRank;
    }

    @Override
    public int hashCode() {
        return this.recordList.hashCode() + x.b(x.b(x.b(d.e(this.guidePopupAction.hashCode() * 0x1F, 0x1F, this.isChartIn), 0x1F, this.yesterdayRank), 0x1F, this.bestRank), 0x1F, this.bestRankDate);
    }

    public final boolean isChartIn() {
        return this.isChartIn;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SongHistoryUiState(guidePopupAction=");
        stringBuilder0.append(this.guidePopupAction);
        stringBuilder0.append(", isChartIn=");
        stringBuilder0.append(this.isChartIn);
        stringBuilder0.append(", yesterdayRank=");
        d.u(stringBuilder0, this.yesterdayRank, ", bestRank=", this.bestRank, ", bestRankDate=");
        stringBuilder0.append(this.bestRankDate);
        stringBuilder0.append(", recordList=");
        stringBuilder0.append(this.recordList);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

