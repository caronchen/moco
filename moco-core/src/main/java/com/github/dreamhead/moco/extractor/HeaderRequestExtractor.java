package com.github.dreamhead.moco.extractor;

import com.github.dreamhead.moco.RequestExtractor;
import io.netty.handler.codec.http.FullHttpRequest;

public class HeaderRequestExtractor implements RequestExtractor<String> {
    private final String name;

    public HeaderRequestExtractor(String name) {
        this.name = name;
    }

    @Override
    public String extract(FullHttpRequest request) {
        return request.headers().get(name);
    }
}
