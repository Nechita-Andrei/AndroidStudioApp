package com.example.mersultrenurilor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class SocketActivity extends AppCompatActivity {
    TextView output;
    OkHttpClient client;

    private final class EchoWebSocketListener extends WebSocketListener{
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            webSocket.send("Salut tuturor!");
            webSocket.send(ByteString.decodeHex("deadbeef"));
            webSocket.close(1000,"cya");
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            scrie("Am primit: "+text);
        }

        @Override
        public void onMessage(WebSocket webSocket, ByteString bytes) {
            scrie("Am primit bytes: "+bytes.hex());
        }


        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            webSocket.close(1000,null);
            scrie("Closing: "+code+"/Motiv: "+reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            scrie("Eroare: "+t.getMessage());
        }
    }

    private void scrie(String text){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                output.setText(output.getText().toString()+ "\n"+text);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        output=findViewById(R.id.serverData);
        client=new OkHttpClient();
        Request request=new Request.Builder().url("ws://echo.websocket.org").build();
        EchoWebSocketListener listener=new EchoWebSocketListener();
        WebSocket ws=client.newWebSocket(request,listener);
        client.dispatcher().executorService().shutdown();

    }
}