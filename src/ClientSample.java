import java.net.*;   // Socketクラスを使用するため
import java.io.*;    // OutputStreamWriter, BufferedReaderを使用するため

public class ClientSample {
    public static void main(String args[]) throws Exception {

        Socket socket = null; // 接続用Socket
        OutputStreamWriter outputStreamWriter; // 出力用ストリーム
        BufferedReader bufferedReader; // 入力用ストリーム
        String messageFromServer = null; // 相手から受けるデータの入力用
        String messageToServer = null; // 相手へ送るデータの入力用
        String host = "localhost"; // ホスト名
        int port = 9000; // ポートナンバー

        final String FINNISH_COMMAND = "END"; // 終了するにはこのコマンドを入力

        // hostマシン上のport_number番号で開いているソケットへ
        // 接続するためのソケットを作成する．
        socket = new Socket(host, port);

	    /* 準備:データ入力ストリームの定義--ソケットからデータを
            取ってくる．sok -> in  */
        bufferedReader = new BufferedReader
                (new InputStreamReader(socket.getInputStream()));

	    /* 準備:データ出力ストリームの定義--ソケットにデータを
            書き込む．  sok <- out */
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

        while (true) {
            // こちらからの入力
            System.out.print("You : ");
            messageToServer = new BufferedReader
                    (new InputStreamReader(System.in)).readLine() + "\n";
            outputStreamWriter.write(messageToServer);
            outputStreamWriter.flush();
            if (messageToServer.equals(FINNISH_COMMAND)) break;

            // 相手からの入力待ち
            System.out.print("Server : ");
            messageFromServer = bufferedReader.readLine();
            System.out.println(messageFromServer);
            if (messageFromServer.equals(FINNISH_COMMAND)) break;
        }

        bufferedReader.close();
        outputStreamWriter.close();
        socket.close();
    }
}

