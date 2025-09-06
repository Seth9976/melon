package com.melon.data.service;

import A7.d;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u000E\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000E\u001A\u00020\t\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001E\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010\u001F\u001A\u00020\u0006H\u00C6\u0003J\u000B\u0010 \u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\t\u0010!\u001A\u00020\tH\u00C6\u0003J\t\u0010\"\u001A\u00020\tH\u00C6\u0003J\u0011\u0010#\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u00C6\u0003J\t\u0010$\u001A\u00020\tH\u00C6\u0003Jg\u0010%\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\u0010\b\u0002\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\b\u0002\u0010\u000E\u001A\u00020\tH\u00C6\u0001J\u0013\u0010&\u001A\u00020\t2\b\u0010\'\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010(\u001A\u00020)H\u00D6\u0001J\t\u0010*\u001A\u00020\u0003H\u00D6\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001A\u00020\u0006\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0018R\u0019\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u000E\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0018\u00A8\u0006+"}, d2 = {"Lcom/melon/data/service/UpdateTrackListRequest;", "", "memberKey", "", "pcId", "updatedDate", "", "addOption", "allowDuplicate", "", "deleteExisting", "trackList", "", "Lcom/iloen/melon/net/mcp/TrackBase;", "force", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZZLjava/util/List;Z)V", "getMemberKey", "()Ljava/lang/String;", "getPcId", "getUpdatedDate", "()J", "getAddOption", "getAllowDuplicate", "()Z", "getDeleteExisting", "getTrackList", "()Ljava/util/List;", "getForce", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class UpdateTrackListRequest {
    public static final int $stable = 8;
    @Nullable
    private final String addOption;
    private final boolean allowDuplicate;
    private final boolean deleteExisting;
    private final boolean force;
    @Nullable
    private final String memberKey;
    @Nullable
    private final String pcId;
    @Nullable
    private final List trackList;
    private final long updatedDate;

    public UpdateTrackListRequest(@Nullable String s, @Nullable String s1, long v, @Nullable String s2, boolean z, boolean z1, @Nullable List list0, boolean z2) {
        this.memberKey = s;
        this.pcId = s1;
        this.updatedDate = v;
        this.addOption = s2;
        this.allowDuplicate = z;
        this.deleteExisting = z1;
        this.trackList = list0;
        this.force = z2;
    }

    @Nullable
    public final String component1() {
        return this.memberKey;
    }

    @Nullable
    public final String component2() {
        return this.pcId;
    }

    public final long component3() {
        return this.updatedDate;
    }

    @Nullable
    public final String component4() {
        return this.addOption;
    }

    public final boolean component5() {
        return this.allowDuplicate;
    }

    public final boolean component6() {
        return this.deleteExisting;
    }

    @Nullable
    public final List component7() {
        return this.trackList;
    }

    public final boolean component8() {
        return this.force;
    }

    @NotNull
    public final UpdateTrackListRequest copy(@Nullable String s, @Nullable String s1, long v, @Nullable String s2, boolean z, boolean z1, @Nullable List list0, boolean z2) {
        return new UpdateTrackListRequest(s, s1, v, s2, z, z1, list0, z2);
    }

    public static UpdateTrackListRequest copy$default(UpdateTrackListRequest updateTrackListRequest0, String s, String s1, long v, String s2, boolean z, boolean z1, List list0, boolean z2, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = updateTrackListRequest0.memberKey;
        }
        if((v1 & 2) != 0) {
            s1 = updateTrackListRequest0.pcId;
        }
        if((v1 & 4) != 0) {
            v = updateTrackListRequest0.updatedDate;
        }
        if((v1 & 8) != 0) {
            s2 = updateTrackListRequest0.addOption;
        }
        if((v1 & 16) != 0) {
            z = updateTrackListRequest0.allowDuplicate;
        }
        if((v1 & 0x20) != 0) {
            z1 = updateTrackListRequest0.deleteExisting;
        }
        if((v1 & 0x40) != 0) {
            list0 = updateTrackListRequest0.trackList;
        }
        if((v1 & 0x80) != 0) {
            z2 = updateTrackListRequest0.force;
        }
        return updateTrackListRequest0.copy(s, s1, v, s2, z, z1, list0, z2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof UpdateTrackListRequest)) {
            return false;
        }
        if(!q.b(this.memberKey, ((UpdateTrackListRequest)object0).memberKey)) {
            return false;
        }
        if(!q.b(this.pcId, ((UpdateTrackListRequest)object0).pcId)) {
            return false;
        }
        if(this.updatedDate != ((UpdateTrackListRequest)object0).updatedDate) {
            return false;
        }
        if(!q.b(this.addOption, ((UpdateTrackListRequest)object0).addOption)) {
            return false;
        }
        if(this.allowDuplicate != ((UpdateTrackListRequest)object0).allowDuplicate) {
            return false;
        }
        if(this.deleteExisting != ((UpdateTrackListRequest)object0).deleteExisting) {
            return false;
        }
        return q.b(this.trackList, ((UpdateTrackListRequest)object0).trackList) ? this.force == ((UpdateTrackListRequest)object0).force : false;
    }

    @Nullable
    public final String getAddOption() {
        return this.addOption;
    }

    public final boolean getAllowDuplicate() {
        return this.allowDuplicate;
    }

    public final boolean getDeleteExisting() {
        return this.deleteExisting;
    }

    public final boolean getForce() {
        return this.force;
    }

    @Nullable
    public final String getMemberKey() {
        return this.memberKey;
    }

    @Nullable
    public final String getPcId() {
        return this.pcId;
    }

    @Nullable
    public final List getTrackList() {
        return this.trackList;
    }

    public final long getUpdatedDate() {
        return this.updatedDate;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.e(d.e((d.c(((this.memberKey == null ? 0 : this.memberKey.hashCode()) * 0x1F + (this.pcId == null ? 0 : this.pcId.hashCode())) * 0x1F, 0x1F, this.updatedDate) + (this.addOption == null ? 0 : this.addOption.hashCode())) * 0x1F, 0x1F, this.allowDuplicate), 0x1F, this.deleteExisting);
        List list0 = this.trackList;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return Boolean.hashCode(this.force) + (v1 + v) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("UpdateTrackListRequest(memberKey=", this.memberKey, ", pcId=", this.pcId, ", updatedDate=");
        stringBuilder0.append(this.updatedDate);
        stringBuilder0.append(", addOption=");
        stringBuilder0.append(this.addOption);
        stringBuilder0.append(", allowDuplicate=");
        stringBuilder0.append(this.allowDuplicate);
        stringBuilder0.append(", deleteExisting=");
        stringBuilder0.append(this.deleteExisting);
        stringBuilder0.append(", trackList=");
        stringBuilder0.append(this.trackList);
        stringBuilder0.append(", force=");
        stringBuilder0.append(this.force);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

