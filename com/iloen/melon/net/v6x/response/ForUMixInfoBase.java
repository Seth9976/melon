package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.net.res.common.LinkInfoBase;
import java.io.Serializable;
import java.util.ArrayList;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b3\b\u0017\u0018\u0000 \u00C5\u00012\u00020\u0001:\u0004\u00C4\u0001\u00C5\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR2\u0010\u0013\u001A\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R2\u0010\u001A\u001A\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0017\"\u0004\b\u001C\u0010\u0019R \u0010\u001D\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0007\"\u0004\b\u001F\u0010\tR \u0010 \u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR2\u0010#\u001A\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R \u0010&\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010\u0007\"\u0004\b(\u0010\tR \u0010)\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR \u0010,\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR \u0010/\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR2\u00102\u001A\u0016\u0012\u0004\u0012\u000203\u0018\u00010\u0014j\n\u0012\u0004\u0012\u000203\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R \u00106\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR \u00109\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR2\u0010<\u001A\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00158\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R \u0010?\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\u001E\u0010B\u001A\u00020C8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bB\u0010D\"\u0004\bE\u0010FR\u001E\u0010G\u001A\u00020C8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bG\u0010D\"\u0004\bH\u0010FR\u001E\u0010I\u001A\u00020C8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bI\u0010D\"\u0004\bJ\u0010FR\u001E\u0010K\u001A\u00020C8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bK\u0010D\"\u0004\bL\u0010FR \u0010M\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bN\u0010\u0007\"\u0004\bO\u0010\tR \u0010P\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR \u0010S\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR \u0010V\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bW\u0010\u0007\"\u0004\bX\u0010\tR \u0010Y\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bZ\u0010\u0007\"\u0004\b[\u0010\tR \u0010\\\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR \u0010_\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b`\u0010\u0007\"\u0004\ba\u0010\tR \u0010b\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bc\u0010\u0007\"\u0004\bd\u0010\tR \u0010e\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bf\u0010\u0007\"\u0004\bg\u0010\tR \u0010h\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bi\u0010\u0007\"\u0004\bj\u0010\tR \u0010k\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bl\u0010\u0007\"\u0004\bm\u0010\tR \u0010n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bo\u0010\u0007\"\u0004\bp\u0010\tR \u0010q\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\br\u0010\u0007\"\u0004\bs\u0010\tR \u0010t\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bu\u0010\u0007\"\u0004\bv\u0010\tR \u0010w\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bx\u0010\u0007\"\u0004\by\u0010\tR \u0010z\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b{\u0010\u0007\"\u0004\b|\u0010\tR \u0010}\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b~\u0010\u0007\"\u0004\b\u007F\u0010\tR#\u0010\u0080\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0081\u0001\u0010\u0007\"\u0005\b\u0082\u0001\u0010\tR&\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R&\u0010\u0089\u0001\u001A\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u008A\u0001\u0010\u0086\u0001\"\u0006\b\u008B\u0001\u0010\u0088\u0001R&\u0010\u008C\u0001\u001A\u0005\u0018\u00010\u008D\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u008E\u0001\u0010\u008F\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R$\u0010\u0092\u0001\u001A\u00030\u0093\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R#\u0010\u0098\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0099\u0001\u0010\u0007\"\u0005\b\u009A\u0001\u0010\tR#\u0010\u009B\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u009C\u0001\u0010\u0007\"\u0005\b\u009D\u0001\u0010\tR#\u0010\u009E\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u009F\u0001\u0010\u0007\"\u0005\b\u00A0\u0001\u0010\tR#\u0010\u00A1\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A2\u0001\u0010\u0007\"\u0005\b\u00A3\u0001\u0010\tR#\u0010\u00A4\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A5\u0001\u0010\u0007\"\u0005\b\u00A6\u0001\u0010\tR#\u0010\u00A7\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A8\u0001\u0010\u0007\"\u0005\b\u00A9\u0001\u0010\tR#\u0010\u00AA\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00AB\u0001\u0010\u0007\"\u0005\b\u00AC\u0001\u0010\tR#\u0010\u00AD\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00AE\u0001\u0010\u0007\"\u0005\b\u00AF\u0001\u0010\tR#\u0010\u00B0\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00B1\u0001\u0010\u0007\"\u0005\b\u00B2\u0001\u0010\tR#\u0010\u00B3\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00B4\u0001\u0010\u0007\"\u0005\b\u00B5\u0001\u0010\tR#\u0010\u00B6\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00B7\u0001\u0010\u0007\"\u0005\b\u00B8\u0001\u0010\tR#\u0010\u00B9\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00BA\u0001\u0010\u0007\"\u0005\b\u00BB\u0001\u0010\tR#\u0010\u00BC\u0001\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00BD\u0001\u0010\u0007\"\u0005\b\u00BE\u0001\u0010\tR\u0015\u0010\u00BF\u0001\u001A\u0004\u0018\u00010\u00058F\u00A2\u0006\u0007\u001A\u0005\b\u00C0\u0001\u0010\u0007R\u0015\u0010\u00C1\u0001\u001A\u0004\u0018\u00010\u00058F\u00A2\u0006\u0007\u001A\u0005\b\u00C2\u0001\u0010\u0007R\u0013\u0010\u00C3\u0001\u001A\u00020C8F\u00A2\u0006\u0007\u001A\u0005\b\u00C3\u0001\u0010D\u00A8\u0006\u00C6\u0001"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "Ljava/io/Serializable;", "<init>", "()V", "contsTypeCode", "", "getContsTypeCode", "()Ljava/lang/String;", "setContsTypeCode", "(Ljava/lang/String;)V", "type", "getType", "setType", "shortCutType", "getShortCutType", "setShortCutType", "foruDataType", "getForuDataType", "setForuDataType", "upperImgUrls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getUpperImgUrls", "()Ljava/util/ArrayList;", "setUpperImgUrls", "(Ljava/util/ArrayList;)V", "upperInsideImgUrls", "getUpperInsideImgUrls", "setUpperInsideImgUrls", "upperReplace", "getUpperReplace", "setUpperReplace", "upperText2", "getUpperText2", "setUpperText2", "mainImgUrls", "getMainImgUrls", "setMainImgUrls", "mainReplace", "getMainReplace", "setMainReplace", "mainText", "getMainText", "setMainText", "detailUpdateDate", "getDetailUpdateDate", "setDetailUpdateDate", "detailUpdateText", "getDetailUpdateText", "setDetailUpdateText", "tags", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase$TAGS;", "getTags", "setTags", "songIds", "getSongIds", "setSongIds", "detailReplace", "getDetailReplace", "setDetailReplace", "detailImgUrls", "getDetailImgUrls", "setDetailImgUrls", "detailSubImgUrl", "getDetailSubImgUrl", "setDetailSubImgUrl", "isMelonLogo", "", "()Z", "setMelonLogo", "(Z)V", "isMelonOnlyLogo", "setMelonOnlyLogo", "isNew", "setNew", "isUp", "setUp", "contsId", "getContsId", "setContsId", "upperSubImgUrl", "getUpperSubImgUrl", "setUpperSubImgUrl", "upperBgColor", "getUpperBgColor", "setUpperBgColor", "upperShadowColor", "getUpperShadowColor", "setUpperShadowColor", "upperDarkBgColor", "getUpperDarkBgColor", "setUpperDarkBgColor", "upperDarkShadowColor", "getUpperDarkShadowColor", "setUpperDarkShadowColor", "upperTitle", "getUpperTitle", "setUpperTitle", "upperImgTitle", "getUpperImgTitle", "setUpperImgTitle", "upperImgSubTitle", "getUpperImgSubTitle", "setUpperImgSubTitle", "upperText1", "getUpperText1", "setUpperText1", "mainTitle", "getMainTitle", "setMainTitle", "mainSubImgUrl", "getMainSubImgUrl", "setMainSubImgUrl", "detailTitle", "getDetailTitle", "setDetailTitle", "detailText", "getDetailText", "setDetailText", "schemeUrl", "getSchemeUrl", "setSchemeUrl", "detailMarker", "getDetailMarker", "setDetailMarker", "seedContsId", "getSeedContsId", "setSeedContsId", "seedContsTypeCode", "getSeedContsTypeCode", "setSeedContsTypeCode", "playScheme", "Lcom/melon/net/res/common/LinkInfoBase;", "getPlayScheme", "()Lcom/melon/net/res/common/LinkInfoBase;", "setPlayScheme", "(Lcom/melon/net/res/common/LinkInfoBase;)V", "openScheme", "getOpenScheme", "setOpenScheme", "statsElements", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElements", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "playTime", "", "getPlayTime", "()J", "setPlayTime", "(J)V", "upperImgText1", "getUpperImgText1", "setUpperImgText1", "upperImgText2", "getUpperImgText2", "setUpperImgText2", "mainImgText1", "getMainImgText1", "setMainImgText1", "mainImgText2", "getMainImgText2", "setMainImgText2", "detailImgText1", "getDetailImgText1", "setDetailImgText1", "detailImgText2", "getDetailImgText2", "setDetailImgText2", "upperTextShadowColor", "getUpperTextShadowColor", "setUpperTextShadowColor", "mainTextShadowColor", "getMainTextShadowColor", "setMainTextShadowColor", "detailTextShadowColor", "getDetailTextShadowColor", "setDetailTextShadowColor", "mixTabImageUrl", "getMixTabImageUrl", "setMixTabImageUrl", "mixTabInsideImageUrl", "getMixTabInsideImageUrl", "setMixTabInsideImageUrl", "mixDetailImageUrl", "getMixDetailImageUrl", "setMixDetailImageUrl", "mixDetailInsideImageUrl", "getMixDetailInsideImageUrl", "setMixDetailInsideImageUrl", "lightOrDarkBgColor", "getLightOrDarkBgColor", "lightOrDarkShadowColor", "getLightOrDarkShadowColor", "isDefaultType", "TAGS", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ForUMixInfoBase implements Serializable {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000BR\u001A\u0010\u000F\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000BR\u001A\u0010\u0012\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000BR\u001A\u0010\u0015\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000BR\u001A\u0010\u0018\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\t\"\u0004\b\u001A\u0010\u000B¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase$Companion;", "", "<init>", "()V", "serialVersionUID", "", "TYPE_SEED", "", "getTYPE_SEED", "()Ljava/lang/String;", "setTYPE_SEED", "(Ljava/lang/String;)V", "TYPE_GENRE", "getTYPE_GENRE", "setTYPE_GENRE", "TYPE_RECENT", "getTYPE_RECENT", "setTYPE_RECENT", "TYPE_RECENTRECM", "getTYPE_RECENTRECM", "setTYPE_RECENTRECM", "SHORTCUT_TYPE_WELCOMEPICK", "getSHORTCUT_TYPE_WELCOMEPICK", "setSHORTCUT_TYPE_WELCOMEPICK", "SHORTCUT_TYPE_USERTASTE", "getSHORTCUT_TYPE_USERTASTE", "setSHORTCUT_TYPE_USERTASTE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getSHORTCUT_TYPE_USERTASTE() {
            return "USERTASTE";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getSHORTCUT_TYPE_WELCOMEPICK() {
            return "WELCOMEPICK";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getTYPE_GENRE() {
            return "GENRE";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getTYPE_RECENT() {
            return "RECENT";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getTYPE_RECENTRECM() {
            return "RECENTRECM";
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getTYPE_SEED() {
            return "SEED";
        }

        public final void setSHORTCUT_TYPE_USERTASTE(@NotNull String s) {
            q.g(s, "<set-?>");
            ForUMixInfoBase.SHORTCUT_TYPE_USERTASTE = s;
        }

        public final void setSHORTCUT_TYPE_WELCOMEPICK(@NotNull String s) {
            q.g(s, "<set-?>");
            ForUMixInfoBase.SHORTCUT_TYPE_WELCOMEPICK = s;
        }

        public final void setTYPE_GENRE(@NotNull String s) {
            q.g(s, "<set-?>");
            ForUMixInfoBase.TYPE_GENRE = s;
        }

        public final void setTYPE_RECENT(@NotNull String s) {
            q.g(s, "<set-?>");
            ForUMixInfoBase.TYPE_RECENT = s;
        }

        public final void setTYPE_RECENTRECM(@NotNull String s) {
            q.g(s, "<set-?>");
            ForUMixInfoBase.TYPE_RECENTRECM = s;
        }

        public final void setTYPE_SEED(@NotNull String s) {
            q.g(s, "<set-?>");
            ForUMixInfoBase.TYPE_SEED = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase$TAGS;", "Lcom/iloen/melon/net/v4x/common/TagInfoBase;", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TAGS extends TagInfoBase {
        public static final int $stable = 0;
        @NotNull
        public static final TAGS INSTANCE = null;
        private static final long serialVersionUID = 0xD2222BDB74C6E0F6L;

        static {
            TAGS.INSTANCE = new TAGS();
            TAGS.$stable = 8;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static String SHORTCUT_TYPE_USERTASTE = null;
    @NotNull
    private static String SHORTCUT_TYPE_WELCOMEPICK = null;
    @NotNull
    private static String TYPE_GENRE = null;
    @NotNull
    private static String TYPE_RECENT = null;
    @NotNull
    private static String TYPE_RECENTRECM = null;
    @NotNull
    private static String TYPE_SEED = null;
    @b("CONTSID")
    @Nullable
    private String contsId;
    @b("CONTSTYPECODE")
    @Nullable
    private String contsTypeCode;
    @b("DETAILIMGTEXT1")
    @Nullable
    private String detailImgText1;
    @b("DETAILIMGTEXT2")
    @Nullable
    private String detailImgText2;
    @b("DETAILIMGURLS")
    @Nullable
    private ArrayList detailImgUrls;
    @b("DETAILMAKER")
    @Nullable
    private String detailMarker;
    @b("DETAILREPLACE")
    @Nullable
    private String detailReplace;
    @b("DETAILSUBIMGURL")
    @Nullable
    private String detailSubImgUrl;
    @b("DETAILTEXT")
    @Nullable
    private String detailText;
    @b("DETAILTEXTSHADOWCOLOR")
    @Nullable
    private String detailTextShadowColor;
    @b("DETAILTITLE")
    @Nullable
    private String detailTitle;
    @b("DETAILUPDATEDATE")
    @Nullable
    private String detailUpdateDate;
    @b("DETAILUPDATETEXT")
    @Nullable
    private String detailUpdateText;
    @b("FORUDATATYPE")
    @Nullable
    private String foruDataType;
    @b("ISMELONLOGO")
    private boolean isMelonLogo;
    @b("ISMELONONLYLOGO")
    private boolean isMelonOnlyLogo;
    @b("ISNEW")
    private boolean isNew;
    @b("ISUP")
    private boolean isUp;
    @b("MAINIMGTEXT1")
    @Nullable
    private String mainImgText1;
    @b("MAINIMGTEXT2")
    @Nullable
    private String mainImgText2;
    @b("MAINIMGURLS")
    @Nullable
    private ArrayList mainImgUrls;
    @b("MAINREPLACE")
    @Nullable
    private String mainReplace;
    @b("MAINSUBIMGURL")
    @Nullable
    private String mainSubImgUrl;
    @b("MAINTEXT")
    @Nullable
    private String mainText;
    @b("MAINTEXTSHADOWCOLOR")
    @Nullable
    private String mainTextShadowColor;
    @b("MAINTITLE")
    @Nullable
    private String mainTitle;
    @b("MIXDETAILIMAGEURL")
    @Nullable
    private String mixDetailImageUrl;
    @b("MIXDETAILINSIDEIMAGEURL")
    @Nullable
    private String mixDetailInsideImageUrl;
    @b("MIXTABIMAGEURL")
    @Nullable
    private String mixTabImageUrl;
    @b("MIXTABINSIDEIMAGEURL")
    @Nullable
    private String mixTabInsideImageUrl;
    @b("OPENSCHEME")
    @Nullable
    private LinkInfoBase openScheme;
    @b("PLAYSCHEME")
    @Nullable
    private LinkInfoBase playScheme;
    @b("PLAYTIME")
    private long playTime;
    @b("SCHEMEURL")
    @Nullable
    private String schemeUrl;
    @b("SEEDCONTSID")
    @Nullable
    private String seedContsId;
    @b("SEEDCONTSTYPECODE")
    @Nullable
    private String seedContsTypeCode;
    private static final long serialVersionUID = 0xBC7C290A78C3244EL;
    @b("SHORTCUTTYPE")
    @Nullable
    private String shortCutType;
    @b("SONGIDS")
    @Nullable
    private String songIds;
    @b("STATSELEMENTS")
    @Nullable
    private StatsElementsBase statsElements;
    @b("TAGS")
    @Nullable
    private ArrayList tags;
    @b("TYPE")
    @Nullable
    private String type;
    @b("UPPERBGCOLOR")
    @Nullable
    private String upperBgColor;
    @b("UPPERDARKBGCOLOR")
    @Nullable
    private String upperDarkBgColor;
    @b("UPPERDARKSHADOWCOLOR")
    @Nullable
    private String upperDarkShadowColor;
    @b("UPPERIMGSUBTITLE")
    @Nullable
    private String upperImgSubTitle;
    @b("UPPERIMGTEXT1")
    @Nullable
    private String upperImgText1;
    @b("UPPERIMGTEXT2")
    @Nullable
    private String upperImgText2;
    @b("UPPERIMGTITLE")
    @Nullable
    private String upperImgTitle;
    @b("UPPERIMGURLS")
    @Nullable
    private ArrayList upperImgUrls;
    @b("UPPERINSIDEIMGURLS")
    @Nullable
    private ArrayList upperInsideImgUrls;
    @b("UPPERREPLACE")
    @Nullable
    private String upperReplace;
    @b("UPPERSHADOWCOLOR")
    @Nullable
    private String upperShadowColor;
    @b("UPPERSUBIMGURL")
    @Nullable
    private String upperSubImgUrl;
    @b("UPPERTEXT1")
    @Nullable
    private String upperText1;
    @b("UPPERTEXT2")
    @Nullable
    private String upperText2;
    @b("UPPERTEXTSHADOWCOLOR")
    @Nullable
    private String upperTextShadowColor;
    @b("UPPERTITLE")
    @Nullable
    private String upperTitle;

    static {
        ForUMixInfoBase.Companion = new Companion(null);
        ForUMixInfoBase.$stable = 8;
        ForUMixInfoBase.TYPE_SEED = "SEED";
        ForUMixInfoBase.TYPE_GENRE = "GENRE";
        ForUMixInfoBase.TYPE_RECENT = "RECENT";
        ForUMixInfoBase.TYPE_RECENTRECM = "RECENTRECM";
        ForUMixInfoBase.SHORTCUT_TYPE_WELCOMEPICK = "WELCOMEPICK";
        ForUMixInfoBase.SHORTCUT_TYPE_USERTASTE = "USERTASTE";
    }

    public ForUMixInfoBase() {
        this.contsTypeCode = "";
        this.type = "";
        this.shortCutType = "";
        this.upperReplace = "";
        this.upperText2 = "";
        this.mainReplace = "";
        this.mainText = "";
        this.detailUpdateDate = "";
        this.detailUpdateText = "";
        this.songIds = "";
        this.detailReplace = "";
        this.detailSubImgUrl = "";
        this.contsId = "";
        this.upperSubImgUrl = "";
        this.upperBgColor = "";
        this.upperShadowColor = "";
        this.upperDarkBgColor = "";
        this.upperDarkShadowColor = "";
        this.upperTitle = "";
        this.upperImgTitle = "";
        this.upperImgSubTitle = "";
        this.upperText1 = "";
        this.mainTitle = "";
        this.mainSubImgUrl = "";
        this.detailTitle = "";
        this.detailText = "";
        this.schemeUrl = "";
        this.detailMarker = "";
        this.seedContsId = "";
        this.seedContsTypeCode = "";
    }

    // 去混淆评级： 低(20)
    public static final String access$getSHORTCUT_TYPE_USERTASTE$cp() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static final String access$getSHORTCUT_TYPE_WELCOMEPICK$cp() [...] // 潜在的解密器

    public static final String access$getTYPE_GENRE$cp() [...] // 潜在的解密器

    public static final String access$getTYPE_RECENT$cp() [...] // 潜在的解密器

    public static final String access$getTYPE_RECENTRECM$cp() [...] // 潜在的解密器

    public static final String access$getTYPE_SEED$cp() [...] // 潜在的解密器

    @Nullable
    public final String getContsId() [...] // 潜在的解密器

    @Nullable
    public final String getContsTypeCode() [...] // 潜在的解密器

    @Nullable
    public final String getDetailImgText1() {
        return this.detailImgText1;
    }

    @Nullable
    public final String getDetailImgText2() {
        return this.detailImgText2;
    }

    @Nullable
    public final ArrayList getDetailImgUrls() {
        return this.detailImgUrls;
    }

    @Nullable
    public final String getDetailMarker() {
        return this.detailMarker;
    }

    @Nullable
    public final String getDetailReplace() [...] // 潜在的解密器

    @Nullable
    public final String getDetailSubImgUrl() [...] // 潜在的解密器

    @Nullable
    public final String getDetailText() [...] // 潜在的解密器

    @Nullable
    public final String getDetailTextShadowColor() {
        return this.detailTextShadowColor;
    }

    @Nullable
    public final String getDetailTitle() [...] // 潜在的解密器

    @Nullable
    public final String getDetailUpdateDate() {
        return this.detailUpdateDate;
    }

    @Nullable
    public final String getDetailUpdateText() [...] // 潜在的解密器

    @Nullable
    public final String getForuDataType() {
        return this.foruDataType;
    }

    @Nullable
    public final String getLightOrDarkBgColor() {
        MelonAppBase.Companion.getClass();
        return ScreenUtils.isDarkMode(t.a().getContext()) ? this.upperDarkBgColor : this.upperBgColor;
    }

    @Nullable
    public final String getLightOrDarkShadowColor() {
        MelonAppBase.Companion.getClass();
        return ScreenUtils.isDarkMode(t.a().getContext()) ? this.upperDarkShadowColor : this.upperShadowColor;
    }

    @Nullable
    public final String getMainImgText1() {
        return this.mainImgText1;
    }

    @Nullable
    public final String getMainImgText2() {
        return this.mainImgText2;
    }

    @Nullable
    public final ArrayList getMainImgUrls() {
        return this.mainImgUrls;
    }

    @Nullable
    public final String getMainReplace() [...] // 潜在的解密器

    @Nullable
    public final String getMainSubImgUrl() [...] // 潜在的解密器

    @Nullable
    public final String getMainText() [...] // 潜在的解密器

    @Nullable
    public final String getMainTextShadowColor() {
        return this.mainTextShadowColor;
    }

    @Nullable
    public final String getMainTitle() [...] // 潜在的解密器

    @Nullable
    public final String getMixDetailImageUrl() {
        return this.mixDetailImageUrl;
    }

    @Nullable
    public final String getMixDetailInsideImageUrl() {
        return this.mixDetailInsideImageUrl;
    }

    @Nullable
    public final String getMixTabImageUrl() {
        return this.mixTabImageUrl;
    }

    @Nullable
    public final String getMixTabInsideImageUrl() {
        return this.mixTabInsideImageUrl;
    }

    @Nullable
    public final LinkInfoBase getOpenScheme() {
        return this.openScheme;
    }

    @Nullable
    public final LinkInfoBase getPlayScheme() {
        return this.playScheme;
    }

    public final long getPlayTime() {
        return this.playTime;
    }

    @Nullable
    public final String getSchemeUrl() {
        return this.schemeUrl;
    }

    @Nullable
    public final String getSeedContsId() [...] // 潜在的解密器

    @Nullable
    public final String getSeedContsTypeCode() [...] // 潜在的解密器

    @Nullable
    public final String getShortCutType() {
        return this.shortCutType;
    }

    @Nullable
    public final String getSongIds() [...] // 潜在的解密器

    @Nullable
    public final StatsElementsBase getStatsElements() {
        return this.statsElements;
    }

    @Nullable
    public final ArrayList getTags() {
        return this.tags;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUpperBgColor() [...] // 潜在的解密器

    @Nullable
    public final String getUpperDarkBgColor() [...] // 潜在的解密器

    @Nullable
    public final String getUpperDarkShadowColor() [...] // 潜在的解密器

    @Nullable
    public final String getUpperImgSubTitle() {
        return this.upperImgSubTitle;
    }

    @Nullable
    public final String getUpperImgText1() {
        return this.upperImgText1;
    }

    @Nullable
    public final String getUpperImgText2() {
        return this.upperImgText2;
    }

    @Nullable
    public final String getUpperImgTitle() {
        return this.upperImgTitle;
    }

    @Nullable
    public final ArrayList getUpperImgUrls() {
        return this.upperImgUrls;
    }

    @Nullable
    public final ArrayList getUpperInsideImgUrls() {
        return this.upperInsideImgUrls;
    }

    @Nullable
    public final String getUpperReplace() [...] // 潜在的解密器

    @Nullable
    public final String getUpperShadowColor() [...] // 潜在的解密器

    @Nullable
    public final String getUpperSubImgUrl() [...] // 潜在的解密器

    @Nullable
    public final String getUpperText1() [...] // 潜在的解密器

    @Nullable
    public final String getUpperText2() [...] // 潜在的解密器

    @Nullable
    public final String getUpperTextShadowColor() {
        return this.upperTextShadowColor;
    }

    @Nullable
    public final String getUpperTitle() [...] // 潜在的解密器

    // 去混淆评级： 低(40)
    public final boolean isDefaultType() {
        return !q.b(this.type, "GENRE") && !q.b(this.type, "RECENT") && !q.b(this.type, "RECENTRECM") && !q.b(this.type, "SEED");
    }

    public final boolean isMelonLogo() {
        return this.isMelonLogo;
    }

    public final boolean isMelonOnlyLogo() {
        return this.isMelonOnlyLogo;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean isUp() {
        return this.isUp;
    }

    public final void setContsId(@Nullable String s) {
        this.contsId = s;
    }

    public final void setContsTypeCode(@Nullable String s) {
        this.contsTypeCode = s;
    }

    public final void setDetailImgText1(@Nullable String s) {
        this.detailImgText1 = s;
    }

    public final void setDetailImgText2(@Nullable String s) {
        this.detailImgText2 = s;
    }

    public final void setDetailImgUrls(@Nullable ArrayList arrayList0) {
        this.detailImgUrls = arrayList0;
    }

    public final void setDetailMarker(@Nullable String s) {
        this.detailMarker = s;
    }

    public final void setDetailReplace(@Nullable String s) {
        this.detailReplace = s;
    }

    public final void setDetailSubImgUrl(@Nullable String s) {
        this.detailSubImgUrl = s;
    }

    public final void setDetailText(@Nullable String s) {
        this.detailText = s;
    }

    public final void setDetailTextShadowColor(@Nullable String s) {
        this.detailTextShadowColor = s;
    }

    public final void setDetailTitle(@Nullable String s) {
        this.detailTitle = s;
    }

    public final void setDetailUpdateDate(@Nullable String s) {
        this.detailUpdateDate = s;
    }

    public final void setDetailUpdateText(@Nullable String s) {
        this.detailUpdateText = s;
    }

    public final void setForuDataType(@Nullable String s) {
        this.foruDataType = s;
    }

    public final void setMainImgText1(@Nullable String s) {
        this.mainImgText1 = s;
    }

    public final void setMainImgText2(@Nullable String s) {
        this.mainImgText2 = s;
    }

    public final void setMainImgUrls(@Nullable ArrayList arrayList0) {
        this.mainImgUrls = arrayList0;
    }

    public final void setMainReplace(@Nullable String s) {
        this.mainReplace = s;
    }

    public final void setMainSubImgUrl(@Nullable String s) {
        this.mainSubImgUrl = s;
    }

    public final void setMainText(@Nullable String s) {
        this.mainText = s;
    }

    public final void setMainTextShadowColor(@Nullable String s) {
        this.mainTextShadowColor = s;
    }

    public final void setMainTitle(@Nullable String s) {
        this.mainTitle = s;
    }

    public final void setMelonLogo(boolean z) {
        this.isMelonLogo = z;
    }

    public final void setMelonOnlyLogo(boolean z) {
        this.isMelonOnlyLogo = z;
    }

    public final void setMixDetailImageUrl(@Nullable String s) {
        this.mixDetailImageUrl = s;
    }

    public final void setMixDetailInsideImageUrl(@Nullable String s) {
        this.mixDetailInsideImageUrl = s;
    }

    public final void setMixTabImageUrl(@Nullable String s) {
        this.mixTabImageUrl = s;
    }

    public final void setMixTabInsideImageUrl(@Nullable String s) {
        this.mixTabInsideImageUrl = s;
    }

    public final void setNew(boolean z) {
        this.isNew = z;
    }

    public final void setOpenScheme(@Nullable LinkInfoBase linkInfoBase0) {
        this.openScheme = linkInfoBase0;
    }

    public final void setPlayScheme(@Nullable LinkInfoBase linkInfoBase0) {
        this.playScheme = linkInfoBase0;
    }

    public final void setPlayTime(long v) {
        this.playTime = v;
    }

    public final void setSchemeUrl(@Nullable String s) {
        this.schemeUrl = s;
    }

    public final void setSeedContsId(@Nullable String s) {
        this.seedContsId = s;
    }

    public final void setSeedContsTypeCode(@Nullable String s) {
        this.seedContsTypeCode = s;
    }

    public final void setShortCutType(@Nullable String s) {
        this.shortCutType = s;
    }

    public final void setSongIds(@Nullable String s) {
        this.songIds = s;
    }

    public final void setStatsElements(@Nullable StatsElementsBase statsElementsBase0) {
        this.statsElements = statsElementsBase0;
    }

    public final void setTags(@Nullable ArrayList arrayList0) {
        this.tags = arrayList0;
    }

    public final void setType(@Nullable String s) {
        this.type = s;
    }

    public final void setUp(boolean z) {
        this.isUp = z;
    }

    public final void setUpperBgColor(@Nullable String s) {
        this.upperBgColor = s;
    }

    public final void setUpperDarkBgColor(@Nullable String s) {
        this.upperDarkBgColor = s;
    }

    public final void setUpperDarkShadowColor(@Nullable String s) {
        this.upperDarkShadowColor = s;
    }

    public final void setUpperImgSubTitle(@Nullable String s) {
        this.upperImgSubTitle = s;
    }

    public final void setUpperImgText1(@Nullable String s) {
        this.upperImgText1 = s;
    }

    public final void setUpperImgText2(@Nullable String s) {
        this.upperImgText2 = s;
    }

    public final void setUpperImgTitle(@Nullable String s) {
        this.upperImgTitle = s;
    }

    public final void setUpperImgUrls(@Nullable ArrayList arrayList0) {
        this.upperImgUrls = arrayList0;
    }

    public final void setUpperInsideImgUrls(@Nullable ArrayList arrayList0) {
        this.upperInsideImgUrls = arrayList0;
    }

    public final void setUpperReplace(@Nullable String s) {
        this.upperReplace = s;
    }

    public final void setUpperShadowColor(@Nullable String s) {
        this.upperShadowColor = s;
    }

    public final void setUpperSubImgUrl(@Nullable String s) {
        this.upperSubImgUrl = s;
    }

    public final void setUpperText1(@Nullable String s) {
        this.upperText1 = s;
    }

    public final void setUpperText2(@Nullable String s) {
        this.upperText2 = s;
    }

    public final void setUpperTextShadowColor(@Nullable String s) {
        this.upperTextShadowColor = s;
    }

    public final void setUpperTitle(@Nullable String s) {
        this.upperTitle = s;
    }
}

