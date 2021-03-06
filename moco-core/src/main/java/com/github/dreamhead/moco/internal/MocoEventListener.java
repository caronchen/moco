package com.github.dreamhead.moco.internal;

import com.github.dreamhead.moco.dumper.Dumper;
import com.github.dreamhead.moco.dumper.HttpRequestDumper;
import com.github.dreamhead.moco.dumper.HttpResponseDumper;
import com.google.common.eventbus.Subscribe;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MocoEventListener {
    private static Logger logger = LoggerFactory.getLogger(MocoEventListener.class);
    private final Dumper<FullHttpRequest> requestDumper = new HttpRequestDumper();
    private final Dumper<FullHttpResponse> responseDumper = new HttpResponseDumper();

    @Subscribe
    public void onMessageArrived(FullHttpRequest request) {
        logger.info("Request received:\n\n{}\n", requestDumper.dump(request));
    }

    @Subscribe
    public void onException(Exception e) {
        logger.error("Exception thrown", e);
    }

    @Subscribe
    public void onMessageLeave(FullHttpResponse response) {
        logger.info("Response return:\n\n{}\n", responseDumper.dump(response));
    }
}
