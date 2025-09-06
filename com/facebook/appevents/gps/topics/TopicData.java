package com.facebook.appevents.gps.topics;

import A7.d;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/gps/topics/TopicData;", "", "taxonomyVersion", "", "modelVersion", "topicId", "", "(JJI)V", "getModelVersion", "()J", "getTaxonomyVersion", "getTopicId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TopicData {
    private final long modelVersion;
    private final long taxonomyVersion;
    private final int topicId;

    public TopicData(long v, long v1, int v2) {
        this.taxonomyVersion = v;
        this.modelVersion = v1;
        this.topicId = v2;
    }

    public final long component1() {
        return this.taxonomyVersion;
    }

    public final long component2() {
        return this.modelVersion;
    }

    public final int component3() {
        return this.topicId;
    }

    @NotNull
    public final TopicData copy(long v, long v1, int v2) {
        return new TopicData(v, v1, v2);
    }

    public static TopicData copy$default(TopicData topicData0, long v, long v1, int v2, int v3, Object object0) {
        if((v3 & 1) != 0) {
            v = topicData0.taxonomyVersion;
        }
        if((v3 & 2) != 0) {
            v1 = topicData0.modelVersion;
        }
        if((v3 & 4) != 0) {
            v2 = topicData0.topicId;
        }
        return topicData0.copy(v, v1, v2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TopicData)) {
            return false;
        }
        if(this.taxonomyVersion != ((TopicData)object0).taxonomyVersion) {
            return false;
        }
        return this.modelVersion == ((TopicData)object0).modelVersion ? this.topicId == ((TopicData)object0).topicId : false;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final long getTaxonomyVersion() {
        return this.taxonomyVersion;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    @Override
    public int hashCode() {
        return this.topicId + d.c(Long.hashCode(this.taxonomyVersion) * 0x1F, 0x1F, this.modelVersion);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TopicData(taxonomyVersion=");
        stringBuilder0.append(this.taxonomyVersion);
        stringBuilder0.append(", modelVersion=");
        stringBuilder0.append(this.modelVersion);
        stringBuilder0.append(", topicId=");
        return o.q(stringBuilder0, this.topicId, ')');
    }
}

