package net.shadowapi.network;

import net.shadowapi.ShadowAPI;
import net.shadowapi.types.ShadowType;
import net.shadowapi.types.TypeConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketReceiver {

    public static void ReceiveSocket() {

        try{

            System.out.println("[SocketAPI] checking...");
            ServerSocket server = new ServerSocket(9998);

            boolean done = false;
            while(!done) {
                Socket client = server.accept();
                client.setKeepAlive(true);

                InputStream in = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String s = null;
                //Creating String for reading
                if((s = reader.readLine()) != null) {
                    //Reading the line out of the Socket and printing it out

                    //API IMPLEMENT
                    ShadowType type = TypeConverter.convert(s);
                    if (type.equals(ShadowType.ERROR_AUTH_KEY_NOT_VALID)) {
                        ShadowAPI.getInstance().getLogger().warn("Auth key is not valid!");
                    }

                }
                in.close();
                reader.close();
                client.close();
                server.close();

                ReceiveSocket();

            }

        }catch(IOException e){
            System.out.println("[Error] Socket closed or connection got reseted!");
            e.printStackTrace();
        }
    }

}
