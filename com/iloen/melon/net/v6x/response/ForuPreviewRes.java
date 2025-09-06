package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuPreviewRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/ForuPreviewRes$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/ForuPreviewRes$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/ForuPreviewRes$Response;)V", "menuId", "", "getMenuId", "()Ljava/lang/String;", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ForuPreviewRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000B\u001A\u00020\fH\u0016R(\u0010\u0004\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuPreviewRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "list", "", "Lcom/iloen/melon/net/v6x/response/ForuPreviewRes$Response$Preview;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "toString", "", "Preview", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0016\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u000FR\u0018\u0010\b\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/net/v6x/response/ForuPreviewRes$Response$Preview;", "", "songId", "", "previewPath", "fileUpdateDate", "isMv", "", "contsTypeCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getSongId", "()Ljava/lang/String;", "getPreviewPath", "getFileUpdateDate", "()Z", "getContsTypeCode", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Preview {
            public static final int $stable;
            @b("CONTSTYPECODE")
            @Nullable
            private final String contsTypeCode;
            @b("FILEUPDTDATE")
            @Nullable
            private final String fileUpdateDate;
            @b("ISMV")
            private final boolean isMv;
            @b("PREVIEWPATH")
            @Nullable
            private final String previewPath;
            @b("SONGID")
            @Nullable
            private final String songId;

            public Preview(@Nullable String s, @Nullable String s1, @Nullable String s2, boolean z, @Nullable String s3) {
                this.songId = s;
                this.previewPath = s1;
                this.fileUpdateDate = s2;
                this.isMv = z;
                this.contsTypeCode = s3;
            }

            @Nullable
            public final String getContsTypeCode() {
                return this.contsTypeCode;
            }

            @Nullable
            public final String getFileUpdateDate() {
                return this.fileUpdateDate;
            }

            @Nullable
            public final String getPreviewPath() {
                return this.previewPath;
            }

            @Nullable
            public final String getSongId() {
                return this.songId;
            }

            public final boolean isMv() {
                return this.isMv;
            }
        }

        public static final int $stable = 8;
        @b("LIST")
        @Nullable
        private List list;

        @Nullable
        public final List getList() {
            return this.list;
        }

        public final void setList(@Nullable List list0) {
            this.list = list0;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            String s = ToStringUtil.toStringFields(this);
            q.f(s, "toStringFields(...)");
            return s;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private Response response;

    @Override  // com.iloen.melon.net.HttpResponse
    @NotNull
    public String getMenuId() {
        String s = this.response == null ? null : this.response.menuId;
        return s == null ? "" : s;
    }

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response foruPreviewRes$Response0) {
        this.response = foruPreviewRes$Response0;
    }
}

