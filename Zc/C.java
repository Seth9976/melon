package zc;

import com.iloen.melon.net.v4x.common.GraphDataListInfo.GRAPHDATA;
import java.util.Arrays;

public final class c {
    // 去混淆评级： 低(36)
    public static String a(GRAPHDATA graphDataListInfo$GRAPHDATA0) {
        if(graphDataListInfo$GRAPHDATA0.fstTopTic) {
            return "";
        }
        return graphDataListInfo$GRAPHDATA0.topCntTic <= 0 ? "" : String.format("", Arrays.copyOf(new Object[]{graphDataListInfo$GRAPHDATA0.topCntTic}, 1));
    }

    public static d b(GRAPHDATA graphDataListInfo$GRAPHDATA0) {
        if(graphDataListInfo$GRAPHDATA0.fstTopTic) {
            return d.b;
        }
        if(graphDataListInfo$GRAPHDATA0.topCntTic > 0) {
            return d.c;
        }
        if(graphDataListInfo$GRAPHDATA0.immTopTic) {
            return d.d;
        }
        return graphDataListInfo$GRAPHDATA0.newRankTic ? d.e : d.f;
    }
}

