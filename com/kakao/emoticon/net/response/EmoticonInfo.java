package com.kakao.emoticon.net.response;

import S7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001A\u00020\tHÆ\u0003J;\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u0007HÖ\u0001J\t\u0010\u001D\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\b\u001A\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000ER\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000E¨\u0006\u001E"}, d2 = {"Lcom/kakao/emoticon/net/response/EmoticonInfo;", "", "title", "", "editorName", "storeUrl", "count", "", "itemSubType", "Lcom/kakao/emoticon/net/response/ItemSubType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/kakao/emoticon/net/response/ItemSubType;)V", "getCount", "()I", "getEditorName", "()Ljava/lang/String;", "getItemSubType", "()Lcom/kakao/emoticon/net/response/ItemSubType;", "getStoreUrl", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonInfo {
    @b("count")
    private final int count;
    @b("editor_name")
    @NotNull
    private final String editorName;
    @b("item_sub_type")
    @NotNull
    private final ItemSubType itemSubType;
    @b("store_url")
    @NotNull
    private final String storeUrl;
    @b("title")
    @NotNull
    private final String title;

    public EmoticonInfo(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, @NotNull ItemSubType itemSubType0) {
        q.g(s, "title");
        q.g(s1, "editorName");
        q.g(s2, "storeUrl");
        q.g(itemSubType0, "itemSubType");
        super();
        this.title = s;
        this.editorName = s1;
        this.storeUrl = s2;
        this.count = v;
        this.itemSubType = itemSubType0;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.editorName;
    }

    @NotNull
    public final String component3() {
        return this.storeUrl;
    }

    public final int component4() {
        return this.count;
    }

    @NotNull
    public final ItemSubType component5() {
        return this.itemSubType;
    }

    @NotNull
    public final EmoticonInfo copy(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, @NotNull ItemSubType itemSubType0) {
        q.g(s, "title");
        q.g(s1, "editorName");
        q.g(s2, "storeUrl");
        q.g(itemSubType0, "itemSubType");
        return new EmoticonInfo(s, s1, s2, v, itemSubType0);
    }

    public static EmoticonInfo copy$default(EmoticonInfo emoticonInfo0, String s, String s1, String s2, int v, ItemSubType itemSubType0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = emoticonInfo0.title;
        }
        if((v1 & 2) != 0) {
            s1 = emoticonInfo0.editorName;
        }
        if((v1 & 4) != 0) {
            s2 = emoticonInfo0.storeUrl;
        }
        if((v1 & 8) != 0) {
            v = emoticonInfo0.count;
        }
        if((v1 & 16) != 0) {
            itemSubType0 = emoticonInfo0.itemSubType;
        }
        return emoticonInfo0.copy(s, s1, s2, v, itemSubType0);
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EmoticonInfo && q.b(this.title, ((EmoticonInfo)object0).title) && q.b(this.editorName, ((EmoticonInfo)object0).editorName) && q.b(this.storeUrl, ((EmoticonInfo)object0).storeUrl) && this.count == ((EmoticonInfo)object0).count && q.b(this.itemSubType, ((EmoticonInfo)object0).itemSubType);
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getEditorName() {
        return this.editorName;
    }

    @NotNull
    public final ItemSubType getItemSubType() {
        return this.itemSubType;
    }

    @NotNull
    public final String getStoreUrl() {
        return this.storeUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = ((((this.title == null ? 0 : this.title.hashCode()) * 0x1F + (this.editorName == null ? 0 : this.editorName.hashCode())) * 0x1F + (this.storeUrl == null ? 0 : this.storeUrl.hashCode())) * 0x1F + this.count) * 0x1F;
        ItemSubType itemSubType0 = this.itemSubType;
        if(itemSubType0 != null) {
            v = itemSubType0.hashCode();
        }
        return v1 + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "EmoticonInfo(title=" + this.title + ", editorName=" + this.editorName + ", storeUrl=" + this.storeUrl + ", count=" + this.count + ", itemSubType=" + this.itemSubType + ")";
    }
}

