# java-socket-sample

javaでSocketを用いた通信サンプルです。
クライアント側プログラム(`src/Client.java`)とサーバー側プログラム(`src/Server.java`)が同包されています。

## 使い方(Intellij IDEA)

1. "ファイル">"Project From Existing Source"からこのプロジェクトのフォルダを選択
1. サーバー側を実行: `src/ServerSample.java`を開いて"実行">"Run"
1. 実行されたのを確認したら続けて`src/ClientSample.java`を開いて同様に実行
1. クライアント側とサーバ側で画面を切り替えて入力

## 使い方(コマンドプロンプト)

1. コマンドプロンプト(cmd.exe)を開く
1. プロジェクトのフォルダまで移動(`cd C:/Users/.../java-socket-sample`)
1. コンパイル(`javac -encoding utf-8 src/*.java`)
1. サーバー側を実行: 実行(`java -classpath ./src ServerSample`)
1. 新たにコマンドプロンプトを立ち上げ、最初と同様にプロジェクトディレクトリまで`cd`する
1. クライアント側を実行: 実行(`java -classpath ./src ClientSample`)
1. クライアント側とサーバ側で画面を切り替えて入力

## 注意

* Windowsでサーバーを動かす場合、外部からの接続(`localhost`以外からの接続)だとファイヤーウォールが邪魔をする場合がありますので設定からOFFにしておいてください。
* `.gitignore`は[gitignore.io](https://www.gitignore.io/)からjavaとintellijをインポートしています。eclipseなどで使う場合は別途ignoreリストを追加してください。
