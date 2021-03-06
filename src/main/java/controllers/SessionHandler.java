package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionHandler.class);

    private final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    public void register(WebSocketSession session)
    {
        sessionMap.put(session.getId(), session);
    }

    public void closeAll()
    {
        LOGGER.info("Closing all WebSockets");
        sessionMap.keySet().forEach(this::closeSocket);
    }

    private void closeSocket(String key)
    {
        try {
            sessionMap.get(key).close();
            sessionMap.remove(key);
        } catch (IOException e) {
            LOGGER.error("Failed to close WebSocket");
        }
    }
}
