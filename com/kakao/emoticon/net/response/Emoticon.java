package com.kakao.emoticon.net.response;

import S7.b;
import U4.x;
import android.database.Cursor;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001B\u000F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\u0002\u0010\u0004B]\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0006\u0012\u0006\u0010\u0011\u001A\u00020\u0006\u0012\u0006\u0010\u0012\u001A\u00020\u0006\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u00A2\u0006\u0002\u0010\u0015J\t\u0010=\u001A\u00020\u0006H\u00C6\u0003J\t\u0010>\u001A\u00020\u0006H\u00C6\u0003J\t\u0010?\u001A\u00020\u0014H\u00C6\u0003J\t\u0010@\u001A\u00020\u0006H\u00C6\u0003J\t\u0010A\u001A\u00020\u0006H\u00C6\u0003J\t\u0010B\u001A\u00020\nH\u00C6\u0003J\t\u0010C\u001A\u00020\fH\u00C6\u0003J\t\u0010D\u001A\u00020\fH\u00C6\u0003J\t\u0010E\u001A\u00020\u000FH\u00C6\u0003J\t\u0010F\u001A\u00020\u0006H\u00C6\u0003J\t\u0010G\u001A\u00020\u0006H\u00C6\u0003Jw\u0010H\u001A\u00020\u00002\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00062\b\b\u0002\u0010\u0011\u001A\u00020\u00062\b\b\u0002\u0010\u0012\u001A\u00020\u00062\b\b\u0002\u0010\u0013\u001A\u00020\u0014H\u00C6\u0001J\u0013\u0010I\u001A\u00020\u00142\b\u0010J\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010K\u001A\u00020\fH\u0016J\u0006\u0010L\u001A\u00020\u0014J\t\u0010M\u001A\u00020\u0006H\u00D6\u0001R\u001E\u0010\b\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001E\u0010\u000E\u001A\u00020\u000F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001E\u0010\u0005\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0017\"\u0004\b\u001F\u0010\u0019R\u001E\u0010\u0013\u001A\u00020\u00148\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010 \"\u0004\b!\u0010\"R\u001A\u0010#\u001A\u00020\u0014X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001E\u0010\t\u001A\u00020\n8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001E\u0010\u0012\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001E\u0010\u0011\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u001A\u0010-\u001A\u00020\fX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\u001E\u0010\r\u001A\u00020\f8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u0010/\"\u0004\b3\u00101R\u001A\u00104\u001A\u00020\fX\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b5\u0010/\"\u0004\b6\u00101R\u001E\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\u001E\u0010\u0010\u001A\u00020\u00068\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R\u001E\u0010\u000B\u001A\u00020\f8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b;\u0010/\"\u0004\b<\u00101\u00A8\u0006N"}, d2 = {"Lcom/kakao/emoticon/net/response/Emoticon;", "", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "id", "", "title", "editorName", "itemSubType", "Lcom/kakao/emoticon/net/response/ItemSubType;", "version", "", "resourceCount", "expiredAt", "", "titleImageUrl", "onImageUrl", "offImageUrl", "isEventItem", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/emoticon/net/response/ItemSubType;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getEditorName", "()Ljava/lang/String;", "setEditorName", "(Ljava/lang/String;)V", "getExpiredAt", "()J", "setExpiredAt", "(J)V", "getId", "setId", "()Z", "setEventItem", "(Z)V", "isShow", "setShow", "getItemSubType", "()Lcom/kakao/emoticon/net/response/ItemSubType;", "setItemSubType", "(Lcom/kakao/emoticon/net/response/ItemSubType;)V", "getOffImageUrl", "setOffImageUrl", "getOnImageUrl", "setOnImageUrl", "orderIndex", "getOrderIndex", "()I", "setOrderIndex", "(I)V", "getResourceCount", "setResourceCount", "serverOrderIndex", "getServerOrderIndex", "setServerOrderIndex", "getTitle", "setTitle", "getTitleImageUrl", "setTitleImageUrl", "getVersion", "setVersion", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "showAsExpiredItemView", "toString", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class Emoticon {
    @b("editor_name")
    @NotNull
    private String editorName;
    @b("expired_at")
    private long expiredAt;
    @b("id")
    @NotNull
    private String id;
    @b("is_event_item")
    private boolean isEventItem;
    private transient boolean isShow;
    @b("item_sub_type")
    @NotNull
    private ItemSubType itemSubType;
    @b("off_image_url")
    @NotNull
    private String offImageUrl;
    @b("on_image_url")
    @NotNull
    private String onImageUrl;
    private int orderIndex;
    @b("count")
    private int resourceCount;
    private int serverOrderIndex;
    @b("title")
    @NotNull
    private String title;
    @b("title_image_url")
    @NotNull
    private String titleImageUrl;
    @b("version")
    private int version;

    public Emoticon(@NotNull Cursor cursor0) {
        q.g(cursor0, "cursor");
        String s = cursor0.getString(cursor0.getColumnIndex("id"));
        q.f(s, "cursor.getString(cursor.…olumnIndex(StringSet.id))");
        String s1 = cursor0.getString(cursor0.getColumnIndex("title"));
        q.f(s1, "cursor.getString(cursor.…mnIndex(StringSet.title))");
        String s2 = cursor0.getString(cursor0.getColumnIndex("editor_name"));
        q.f(s2, "cursor.getString(cursor.…x(StringSet.editor_name))");
        String s3 = cursor0.getString(cursor0.getColumnIndex("type"));
        q.f(s3, "cursor.getString(cursor.…umnIndex(StringSet.type))");
        int v = cursor0.getInt(cursor0.getColumnIndex("version"));
        int v1 = cursor0.getInt(cursor0.getColumnIndex("resource_count"));
        long v2 = cursor0.getLong(cursor0.getColumnIndex("expired_at"));
        String s4 = cursor0.getString(cursor0.getColumnIndex("title_image_url"));
        q.f(s4, "cursor.getString(cursor.…ringSet.title_image_url))");
        String s5 = cursor0.getString(cursor0.getColumnIndex("on_image_url"));
        q.f(s5, "cursor.getString(cursor.…(StringSet.on_image_url))");
        String s6 = cursor0.getString(cursor0.getColumnIndex("off_image_url"));
        q.f(s6, "cursor.getString(cursor.…StringSet.off_image_url))");
        boolean z = false;
        this(s, s1, s2, ItemSubType.valueOf(s3), v, v1, v2, s4, s5, s6, cursor0.getInt(cursor0.getColumnIndex("is_event_item")) == 1);
        this.orderIndex = cursor0.getInt(cursor0.getColumnIndex("order_index"));
        if(cursor0.getInt(cursor0.getColumnIndex("is_show")) == 1) {
            z = true;
        }
        this.isShow = z;
        this.serverOrderIndex = cursor0.getInt(cursor0.getColumnIndex("server_order_index"));
    }

    public Emoticon(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull ItemSubType itemSubType0, int v, int v1, long v2, @NotNull String s3, @NotNull String s4, @NotNull String s5, boolean z) {
        q.g(s, "id");
        q.g(s1, "title");
        q.g(s2, "editorName");
        q.g(itemSubType0, "itemSubType");
        q.g(s3, "titleImageUrl");
        q.g(s4, "onImageUrl");
        q.g(s5, "offImageUrl");
        super();
        this.id = s;
        this.title = s1;
        this.editorName = s2;
        this.itemSubType = itemSubType0;
        this.version = v;
        this.resourceCount = v1;
        this.expiredAt = v2;
        this.titleImageUrl = s3;
        this.onImageUrl = s4;
        this.offImageUrl = s5;
        this.isEventItem = z;
        this.isShow = true;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component10() {
        return this.offImageUrl;
    }

    public final boolean component11() {
        return this.isEventItem;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.editorName;
    }

    @NotNull
    public final ItemSubType component4() {
        return this.itemSubType;
    }

    public final int component5() {
        return this.version;
    }

    public final int component6() {
        return this.resourceCount;
    }

    public final long component7() {
        return this.expiredAt;
    }

    @NotNull
    public final String component8() {
        return this.titleImageUrl;
    }

    @NotNull
    public final String component9() {
        return this.onImageUrl;
    }

    @NotNull
    public final Emoticon copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull ItemSubType itemSubType0, int v, int v1, long v2, @NotNull String s3, @NotNull String s4, @NotNull String s5, boolean z) {
        q.g(s, "id");
        q.g(s1, "title");
        q.g(s2, "editorName");
        q.g(itemSubType0, "itemSubType");
        q.g(s3, "titleImageUrl");
        q.g(s4, "onImageUrl");
        q.g(s5, "offImageUrl");
        return new Emoticon(s, s1, s2, itemSubType0, v, v1, v2, s3, s4, s5, z);
    }

    public static Emoticon copy$default(Emoticon emoticon0, String s, String s1, String s2, ItemSubType itemSubType0, int v, int v1, long v2, String s3, String s4, String s5, boolean z, int v3, Object object0) {
        if((v3 & 1) != 0) {
            s = emoticon0.id;
        }
        if((v3 & 2) != 0) {
            s1 = emoticon0.title;
        }
        if((v3 & 4) != 0) {
            s2 = emoticon0.editorName;
        }
        if((v3 & 8) != 0) {
            itemSubType0 = emoticon0.itemSubType;
        }
        if((v3 & 16) != 0) {
            v = emoticon0.version;
        }
        if((v3 & 0x20) != 0) {
            v1 = emoticon0.resourceCount;
        }
        if((v3 & 0x40) != 0) {
            v2 = emoticon0.expiredAt;
        }
        if((v3 & 0x80) != 0) {
            s3 = emoticon0.titleImageUrl;
        }
        if((v3 & 0x100) != 0) {
            s4 = emoticon0.onImageUrl;
        }
        if((v3 & 0x200) != 0) {
            s5 = emoticon0.offImageUrl;
        }
        if((v3 & 0x400) != 0) {
            z = emoticon0.isEventItem;
        }
        return emoticon0.copy(s, s1, s2, itemSubType0, v, v1, v2, s3, s4, s5, z);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return Emoticon.class.equals(class0) && q.b(this.id, ((Emoticon)object0).id) ? this.version == ((Emoticon)object0).version : false;
        }
        return false;
    }

    @NotNull
    public final String getEditorName() {
        return this.editorName;
    }

    public final long getExpiredAt() {
        return this.expiredAt;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final ItemSubType getItemSubType() {
        return this.itemSubType;
    }

    @NotNull
    public final String getOffImageUrl() {
        return this.offImageUrl;
    }

    @NotNull
    public final String getOnImageUrl() {
        return this.onImageUrl;
    }

    public final int getOrderIndex() {
        return this.orderIndex;
    }

    public final int getResourceCount() {
        return this.resourceCount;
    }

    public final int getServerOrderIndex() {
        return this.serverOrderIndex;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTitleImageUrl() {
        return this.titleImageUrl;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override
    public int hashCode() {
        return x.b(x.b(x.b(((this.itemSubType.hashCode() + x.b(x.b(this.id.hashCode() * 0x1F, 0x1F, this.title), 0x1F, this.editorName)) * 0x1F + this.version) * 0x1F, 0x1F, this.titleImageUrl), 0x1F, this.onImageUrl), 0x1F, this.offImageUrl) + this.resourceCount;
    }

    public final boolean isEventItem() {
        return this.isEventItem;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setEditorName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.editorName = s;
    }

    public final void setEventItem(boolean z) {
        this.isEventItem = z;
    }

    public final void setExpiredAt(long v) {
        this.expiredAt = v;
    }

    public final void setId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.id = s;
    }

    public final void setItemSubType(@NotNull ItemSubType itemSubType0) {
        q.g(itemSubType0, "<set-?>");
        this.itemSubType = itemSubType0;
    }

    public final void setOffImageUrl(@NotNull String s) {
        q.g(s, "<set-?>");
        this.offImageUrl = s;
    }

    public final void setOnImageUrl(@NotNull String s) {
        q.g(s, "<set-?>");
        this.onImageUrl = s;
    }

    public final void setOrderIndex(int v) {
        this.orderIndex = v;
    }

    public final void setResourceCount(int v) {
        this.resourceCount = v;
    }

    public final void setServerOrderIndex(int v) {
        this.serverOrderIndex = v;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void setTitle(@NotNull String s) {
        q.g(s, "<set-?>");
        this.title = s;
    }

    public final void setTitleImageUrl(@NotNull String s) {
        q.g(s, "<set-?>");
        this.titleImageUrl = s;
    }

    public final void setVersion(int v) {
        this.version = v;
    }

    public final boolean showAsExpiredItemView() {
        return this.isEventItem && (this.expiredAt > 0L && this.expiredAt * 1000L < System.currentTimeMillis());
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Emoticon(id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", title=");
        stringBuilder0.append(this.title);
        stringBuilder0.append(", editorName=");
        stringBuilder0.append(this.editorName);
        stringBuilder0.append(", itemSubType=");
        stringBuilder0.append(this.itemSubType);
        stringBuilder0.append(", version=");
        stringBuilder0.append(this.version);
        stringBuilder0.append(", resourceCount=");
        stringBuilder0.append(this.resourceCount);
        stringBuilder0.append(", expiredAt=");
        stringBuilder0.append(this.expiredAt);
        stringBuilder0.append(", titleImageUrl=");
        stringBuilder0.append(this.titleImageUrl);
        stringBuilder0.append(", onImageUrl=");
        stringBuilder0.append(this.onImageUrl);
        stringBuilder0.append(", offImageUrl=");
        stringBuilder0.append(this.offImageUrl);
        stringBuilder0.append(", isEventItem=");
        return o.s(stringBuilder0, this.isEventItem, ")");
    }
}

