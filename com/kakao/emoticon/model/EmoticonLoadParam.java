package com.kakao.emoticon.model;

import com.kakao.emoticon.cache.signature.EmoticonVersionSignature;
import com.kakao.emoticon.controller.EmoticonManager;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.net.response.EmoticonConfig;
import com.kakao.emoticon.net.response.ItemSubType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010#\u001A\u00020$R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u000FR\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u000FR\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0013\u0010\u001E\u001A\u0004\u0018\u00010\r8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u000FR\u0011\u0010 \u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/kakao/emoticon/model/EmoticonLoadParam;", "", "emoticon", "Lcom/kakao/emoticon/net/response/Emoticon;", "drawType", "Lcom/kakao/emoticon/model/DrawType;", "(Lcom/kakao/emoticon/net/response/Emoticon;Lcom/kakao/emoticon/model/DrawType;)V", "emoticonViewParam", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "(Lcom/kakao/emoticon/model/EmoticonViewParam;Lcom/kakao/emoticon/model/DrawType;)V", "getDrawType", "()Lcom/kakao/emoticon/model/DrawType;", "emoticonId", "", "getEmoticonId", "()Ljava/lang/String;", "emoticonType", "Lcom/kakao/emoticon/net/response/ItemSubType;", "getEmoticonType", "()Lcom/kakao/emoticon/net/response/ItemSubType;", "key", "getKey", "resourceId", "", "resourceUrl", "getResourceUrl", "signature", "Lcom/kakao/emoticon/cache/signature/EmoticonVersionSignature;", "getSignature", "()Lcom/kakao/emoticon/cache/signature/EmoticonVersionSignature;", "soundUrl", "getSoundUrl", "version", "getVersion", "()I", "isSoundCon", "", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public class EmoticonLoadParam {
    @NotNull
    private final DrawType drawType;
    @NotNull
    private final String emoticonId;
    @NotNull
    private final ItemSubType emoticonType;
    private final int resourceId;
    private final int version;

    public EmoticonLoadParam(@NotNull EmoticonViewParam emoticonViewParam0, @NotNull DrawType drawType0) {
        q.g(emoticonViewParam0, "emoticonViewParam");
        q.g(drawType0, "drawType");
        super();
        ItemSubType itemSubType0 = emoticonViewParam0.getEmoticonType();
        q.f(itemSubType0, "emoticonViewParam.emoticonType");
        this.emoticonType = itemSubType0;
        this.drawType = drawType0;
        String s = emoticonViewParam0.getEmoticonId();
        q.f(s, "emoticonViewParam.emoticonId");
        this.emoticonId = s;
        this.resourceId = emoticonViewParam0.getResourceId();
        this.version = emoticonViewParam0.getEmoticonVersion();
    }

    public EmoticonLoadParam(@NotNull Emoticon emoticon0, @NotNull DrawType drawType0) {
        q.g(emoticon0, "emoticon");
        q.g(drawType0, "drawType");
        super();
        this.emoticonType = emoticon0.getItemSubType();
        this.drawType = drawType0;
        this.emoticonId = emoticon0.getId();
        this.resourceId = -1;
        this.version = emoticon0.getVersion();
    }

    @NotNull
    public final DrawType getDrawType() {
        return this.drawType;
    }

    @NotNull
    public final String getEmoticonId() {
        return this.emoticonId;
    }

    @NotNull
    public final ItemSubType getEmoticonType() {
        return this.emoticonType;
    }

    @NotNull
    public final String getKey() {
        return String.format("emoticon/resources/%s/%s_%03d", Arrays.copyOf(new Object[]{this.emoticonId, this.drawType.name(), this.resourceId}, 3));
    }

    @NotNull
    public final String getResourceUrl() [...] // 潜在的解密器

    @NotNull
    public final EmoticonVersionSignature getSignature() {
        return new EmoticonVersionSignature(this.getKey(), this.version);
    }

    @Nullable
    public final String getSoundUrl() {
        if(this.isSoundCon()) {
            EmoticonManager emoticonManager0 = EmoticonManager.INSTANCE;
            if(emoticonManager0.getEmoticonConfig() != null) {
                EmoticonConfig emoticonConfig0 = emoticonManager0.getEmoticonConfig();
                q.d(emoticonConfig0);
                return emoticonConfig0.getSoundUrl(this.emoticonId, this.resourceId);
            }
        }
        return null;
    }

    public final int getVersion() {
        return this.version;
    }

    public final boolean isSoundCon() {
        return this.emoticonType == ItemSubType.SOUND_EMOTICON || this.emoticonType == ItemSubType.SOUND_STICKER;
    }
}

