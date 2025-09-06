package com.melon.data.service;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003JC\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\u0010\b\u0002\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0019\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001E"}, d2 = {"Lcom/melon/data/service/MusicWaveChatRequest;", "", "cpId", "", "type", "id", "comment", "attachImages", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCpId", "()Ljava/lang/String;", "getType", "getId", "getComment", "getAttachImages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveChatRequest {
    public static final int $stable = 8;
    @Nullable
    private final List attachImages;
    @NotNull
    private final String comment;
    @NotNull
    private final String cpId;
    @NotNull
    private final String id;
    @NotNull
    private final String type;

    public MusicWaveChatRequest(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @Nullable List list0) {
        q.g(s, "cpId");
        q.g(s1, "type");
        q.g(s2, "id");
        q.g(s3, "comment");
        super();
        this.cpId = s;
        this.type = s1;
        this.id = s2;
        this.comment = s3;
        this.attachImages = list0;
    }

    @NotNull
    public final String component1() {
        return this.cpId;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final String component3() {
        return this.id;
    }

    @NotNull
    public final String component4() {
        return this.comment;
    }

    @Nullable
    public final List component5() {
        return this.attachImages;
    }

    @NotNull
    public final MusicWaveChatRequest copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @Nullable List list0) {
        q.g(s, "cpId");
        q.g(s1, "type");
        q.g(s2, "id");
        q.g(s3, "comment");
        return new MusicWaveChatRequest(s, s1, s2, s3, list0);
    }

    public static MusicWaveChatRequest copy$default(MusicWaveChatRequest musicWaveChatRequest0, String s, String s1, String s2, String s3, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            s = musicWaveChatRequest0.cpId;
        }
        if((v & 2) != 0) {
            s1 = musicWaveChatRequest0.type;
        }
        if((v & 4) != 0) {
            s2 = musicWaveChatRequest0.id;
        }
        if((v & 8) != 0) {
            s3 = musicWaveChatRequest0.comment;
        }
        if((v & 16) != 0) {
            list0 = musicWaveChatRequest0.attachImages;
        }
        return musicWaveChatRequest0.copy(s, s1, s2, s3, list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MusicWaveChatRequest)) {
            return false;
        }
        if(!q.b(this.cpId, ((MusicWaveChatRequest)object0).cpId)) {
            return false;
        }
        if(!q.b(this.type, ((MusicWaveChatRequest)object0).type)) {
            return false;
        }
        if(!q.b(this.id, ((MusicWaveChatRequest)object0).id)) {
            return false;
        }
        return q.b(this.comment, ((MusicWaveChatRequest)object0).comment) ? q.b(this.attachImages, ((MusicWaveChatRequest)object0).attachImages) : false;
    }

    @Nullable
    public final List getAttachImages() {
        return this.attachImages;
    }

    @NotNull
    public final String getComment() {
        return this.comment;
    }

    @NotNull
    public final String getCpId() {
        return this.cpId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override
    public int hashCode() {
        int v = x.b(x.b(x.b(this.cpId.hashCode() * 0x1F, 0x1F, this.type), 0x1F, this.id), 0x1F, this.comment);
        return this.attachImages == null ? v : v + this.attachImages.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("MusicWaveChatRequest(cpId=", this.cpId, ", type=", this.type, ", id=");
        d.u(stringBuilder0, this.id, ", comment=", this.comment, ", attachImages=");
        return Y.m(stringBuilder0, this.attachImages, ")");
    }
}

