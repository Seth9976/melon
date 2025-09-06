package io.netty.util;

@Deprecated
public final class DomainMappingBuilder {
    private final DomainNameMappingBuilder builder;

    public DomainMappingBuilder(int v, Object object0) {
        this.builder = new DomainNameMappingBuilder(v, object0);
    }

    public DomainMappingBuilder(Object object0) {
        this.builder = new DomainNameMappingBuilder(object0);
    }

    public DomainMappingBuilder add(String s, Object object0) {
        this.builder.add(s, object0);
        return this;
    }

    public DomainNameMapping build() {
        return this.builder.build();
    }
}

