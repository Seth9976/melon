package com.iloen.melon.fragments.detail;

import com.iloen.melon.fragments.detail.viewholder.SongHistoryUiState;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.SongAchievementInfo;
import java.util.ArrayList;
import je.w;
import kotlin.Metadata;
import we.a;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A!\u0010\u0005\u001A\u00020\u0004*\u00020\u00002\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE$SongAchievementInfo;", "Lkotlin/Function0;", "Lie/H;", "popupAction", "Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState;", "toSongHistoryUiState", "(Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE$SongAchievementInfo;Lwe/a;)Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryUiState;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class SongDetailFragmentKt {
    private static final SongHistoryUiState toSongHistoryUiState(SongAchievementInfo songInfoRes$RESPONSE$SongAchievementInfo0, a a0) {
        boolean z = ProtocolUtils.parseBoolean(songInfoRes$RESPONSE$SongAchievementInfo0.inChartYN);
        String s = songInfoRes$RESPONSE$SongAchievementInfo0.yesterdayChartRank == null ? "" : songInfoRes$RESPONSE$SongAchievementInfo0.yesterdayChartRank;
        String s1 = songInfoRes$RESPONSE$SongAchievementInfo0.bestRank == null ? "" : songInfoRes$RESPONSE$SongAchievementInfo0.bestRank;
        String s2 = songInfoRes$RESPONSE$SongAchievementInfo0.bestRankDate == null ? "" : songInfoRes$RESPONSE$SongAchievementInfo0.bestRankDate;
        ArrayList arrayList0 = songInfoRes$RESPONSE$SongAchievementInfo0.recordList;
        return arrayList0 == null ? new SongHistoryUiState(a0, z, s, s1, s2, w.a) : new SongHistoryUiState(a0, z, s, s1, s2, arrayList0);
    }
}

