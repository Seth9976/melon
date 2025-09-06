package com.kakao.emoticon.net.response;

import S7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\r"}, d2 = {"Lcom/kakao/emoticon/net/response/ItemSubType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "EMOTICON", "SOUND_EMOTICON", "STICKER", "ANIMATED_STICKER", "SOUND_STICKER", "Companion", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public enum ItemSubType {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakao/emoticon/net/response/ItemSubType$Companion;", "", "()V", "valueOfInt", "Lcom/kakao/emoticon/net/response/ItemSubType;", "code", "", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final ItemSubType valueOfInt(int v) {
            ItemSubType[] arr_itemSubType = ItemSubType.values();
            for(int v1 = 0; v1 < arr_itemSubType.length; ++v1) {
                ItemSubType itemSubType0 = arr_itemSubType[v1];
                if(itemSubType0.getType() == v) {
                    return itemSubType0;
                }
            }
            return null;
        }
    }

    @b("1")
    EMOTICON(1),
    @b("2")
    SOUND_EMOTICON(2),
    @b("3")
    STICKER(3),
    @b("4")
    ANIMATED_STICKER(4),
    @b("5")
    SOUND_STICKER(5);

    public static final Companion Companion;
    private final int type;

    static {
        ItemSubType.Companion = new Companion(null);
    }

    private ItemSubType(int v1) {
        this.type = v1;
    }

    public final int getType() {
        return this.type;
    }
}

