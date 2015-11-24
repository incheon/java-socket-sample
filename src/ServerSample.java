import java.io.*;
import java.net.*;

public class ServerSample {

    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket; // 接続受け付け用ServerSocket
        Socket socket; // 接続用Socket
        OutputStreamWriter outputStreamWriter; // 出力用ストリーム
        BufferedReader bufferedReader; // 入力用ストリーム
        String messageFromClient; // 相手から受けるデータの入力用
        String messageToClient; // 相手へ送るデータの入力用
        int port_number = 9000; // ポートナンバー

        final String FINNISH_COMMAND = "END"; // 終了するにはこのコマンドを入力

        serverSocket = new ServerSocket(port_number); // サーバソケットの作成

        System.out.println("Waiting for client connection\n");
        socket = serverSocket.accept();              // クライアントからの接続待ち

        /* 準備：データ入力ストリームの定義--ソケットからデータを
           取ってくる．sok -> in  */
        bufferedReader = new BufferedReader
                (new InputStreamReader(socket.getInputStream()));

        /* 準備：データ出力ストリームの定義--ソケットにデータを
           書き込む．  sok <- out */
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

        while (true) {
            System.out.print("client output : "); // 相手からの入力待ち
            messageFromClient = bufferedReader.readLine();
            System.out.println(messageFromClient);
            if (messageFromClient.equals(FINNISH_COMMAND)) break;

            System.out.print("your input : "); // こちらからの入力
            messageToClient = new BufferedReader
                    (new InputStreamReader(System.in)).readLine();
            outputStreamWriter.write(messageToClient + "\n");
            outputStreamWriter.flush();
            if (messageToClient.equals(FINNISH_COMMAND)) break;
        }

        bufferedReader.close();
        outputStreamWriter.close();
        socket.close();
    }
}

