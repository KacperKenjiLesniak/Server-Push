package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

public class StompSubProtocolWebSocketHandler extends SubProtocolWebSocketHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StompSubProtocolWebSocketHandler.class);

    @Autowired
    private SessionHandler sessionHandler;

    public StompSubProtocolWebSocketHandler(MessageChannel clientInboundChannel,
                                            SubscribableChannel clientOutboundChannel)
    {
        super(clientInboundChannel, clientOutboundChannel);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception
    {
        LOGGER.info("New WebSocket connection was established");
        sessionHandler.register(session);
        super.afterConnectionEstablished(session);
    }
}
