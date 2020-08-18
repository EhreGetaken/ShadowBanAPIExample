package net.shadowapi;

import net.shadowapi.network.SocketReceiver;
import net.shadowapi.network.SocketSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShadowAPI {

    private static ShadowAPI instance;

    private final Logger logger = LoggerFactory.getLogger(ShadowAPI.class);

    public static void main(String[] args) {
        new ShadowAPI();
    }

    public ShadowAPI() {
        instance = this;
        logger.info("ShadowAPI example project starting");
        logger.info("Debug: " + logger.isDebugEnabled());
        init();
    }

    private void init() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SocketReceiver.ReceiveSocket();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        SocketSender socketSender = new SocketSender("AUTH_KEY=IUDFVID", "betterproject.net", 9999);
        System.out.println("Socket: " + socketSender.getInformationToken());

    }

    public static ShadowAPI getInstance() {
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }
}
