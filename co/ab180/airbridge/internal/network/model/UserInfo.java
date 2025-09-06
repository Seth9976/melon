package co.ab180.airbridge.internal.network.model;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.c0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(c0.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\u0011\b\u0081\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\u0004\b&\u0010\'J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u001E\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\b\u0010\tJ\u001E\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\n\u0010\tJ\u0012\u0010\f\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\f\u0010\rJp\u0010\u0014\u001A\u00020\u00002\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0016\b\u0002\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u000BH\u00C6\u0001\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001A\u00020\u0017H\u00D6\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001A\u0010\u001B\u001A\u00020\u000B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CR\u001E\u0010\u0010\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0010\u0010\u001D\u001A\u0004\b\u001E\u0010\u0004R*\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0012\u0010\u001F\u001A\u0004\b \u0010\tR\u001E\u0010\u000F\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u000F\u0010\u001D\u001A\u0004\b!\u0010\u0004R*\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0011\u0010\u001F\u001A\u0004\b\"\u0010\tR\u001E\u0010\u0013\u001A\u0004\u0018\u00010\u000B8\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u0013\u0010#\u001A\u0004\b$\u0010\rR\u001E\u0010\u000E\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004\u00A2\u0006\f\n\u0004\b\u000E\u0010\u001D\u001A\u0004\b%\u0010\u0004\u00A8\u0006("}, d2 = {"Lco/ab180/airbridge/internal/network/model/UserInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/util/Map;", "component5", "", "component6", "()Ljava/lang/Boolean;", "id", "email", "phone", "alias", "attributes", "hashEnabled", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Lco/ab180/airbridge/internal/network/model/UserInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPhone", "Ljava/util/Map;", "getAttributes", "getEmail", "getAlias", "Ljava/lang/Boolean;", "getHashEnabled", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class UserInfo {
    @d("alias")
    @Nullable
    private final Map alias;
    @d("attributes")
    @Nullable
    private final Map attributes;
    @d("externalUserEmail")
    @Nullable
    private final String email;
    @d("isClientSideHashed")
    @Nullable
    private final Boolean hashEnabled;
    @d("externalUserID")
    @Nullable
    private final String id;
    @d("externalUserPhone")
    @Nullable
    private final String phone;

    public UserInfo() {
        this(null, null, null, null, null, null, 0x3F, null);
    }

    public UserInfo(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Map map0, @Nullable Map map1, @Nullable Boolean boolean0) {
        this.id = s;
        this.email = s1;
        this.phone = s2;
        this.alias = map0;
        this.attributes = map1;
        this.hashEnabled = boolean0;
    }

    public UserInfo(String s, String s1, String s2, Map map0, Map map1, Boolean boolean0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        if((v & 8) != 0) {
            map0 = null;
        }
        if((v & 16) != 0) {
            map1 = null;
        }
        this(s, s1, s2, map0, map1, ((v & 0x20) == 0 ? boolean0 : null));
    }

    @Nullable
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.email;
    }

    @Nullable
    public final String component3() {
        return this.phone;
    }

    @Nullable
    public final Map component4() {
        return this.alias;
    }

    @Nullable
    public final Map component5() {
        return this.attributes;
    }

    @Nullable
    public final Boolean component6() {
        return this.hashEnabled;
    }

    @NotNull
    public final UserInfo copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Map map0, @Nullable Map map1, @Nullable Boolean boolean0) {
        return new UserInfo(s, s1, s2, map0, map1, boolean0);
    }

    public static UserInfo copy$default(UserInfo userInfo0, String s, String s1, String s2, Map map0, Map map1, Boolean boolean0, int v, Object object0) {
        if((v & 1) != 0) {
            s = userInfo0.id;
        }
        if((v & 2) != 0) {
            s1 = userInfo0.email;
        }
        if((v & 4) != 0) {
            s2 = userInfo0.phone;
        }
        if((v & 8) != 0) {
            map0 = userInfo0.alias;
        }
        if((v & 16) != 0) {
            map1 = userInfo0.attributes;
        }
        if((v & 0x20) != 0) {
            boolean0 = userInfo0.hashEnabled;
        }
        return userInfo0.copy(s, s1, s2, map0, map1, boolean0);
    }

    // 去混淆评级： 中等(70)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof UserInfo && q.b(this.id, ((UserInfo)object0).id) && q.b(this.email, ((UserInfo)object0).email) && q.b(this.phone, ((UserInfo)object0).phone) && q.b(this.alias, ((UserInfo)object0).alias) && q.b(this.attributes, ((UserInfo)object0).attributes) && q.b(this.hashEnabled, ((UserInfo)object0).hashEnabled);
    }

    @Nullable
    public final Map getAlias() {
        return this.alias;
    }

    @Nullable
    public final Map getAttributes() {
        return this.attributes;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final Boolean getHashEnabled() {
        return this.hashEnabled;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.id == null ? 0 : this.id.hashCode();
        int v2 = this.email == null ? 0 : this.email.hashCode();
        int v3 = this.phone == null ? 0 : this.phone.hashCode();
        int v4 = this.alias == null ? 0 : this.alias.hashCode();
        int v5 = this.attributes == null ? 0 : this.attributes.hashCode();
        Boolean boolean0 = this.hashEnabled;
        if(boolean0 != null) {
            v = boolean0.hashCode();
        }
        return ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "UserInfo(id=" + this.id + ", email=" + this.email + ", phone=" + this.phone + ", alias=" + this.alias + ", attributes=" + this.attributes + ", hashEnabled=" + this.hashEnabled + ")";
    }
}

