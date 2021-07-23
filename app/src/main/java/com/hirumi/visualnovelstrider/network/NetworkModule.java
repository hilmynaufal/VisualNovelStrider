package com.hirumi.visualnovelstrider.network;

import com.hirumi.visualnovelstrider.constant.Constant;
import com.squareup.moshi.Moshi;

import java.nio.charset.StandardCharsets;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import moe.codeest.rxsocketclient.RxSocketClient;
import moe.codeest.rxsocketclient.SocketClient;
import moe.codeest.rxsocketclient.meta.SocketConfig;
import moe.codeest.rxsocketclient.meta.SocketOption;
import moe.codeest.rxsocketclient.meta.ThreadStrategy;
import okio.Utf8;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public SocketService provideSocketService() {

        Moshi moshi = new Moshi.Builder().build();

        SocketService socketService = new SocketService();
        socketService.execute();
//        socketService.login();
        return socketService;
    }

//    @Singleton
//    @Provides
//    public SocketClient provideSocketClient() {
//        return RxSocketClient
//                .create(new SocketConfig.Builder()
//                        .setIp(Constant.VNDB_URL)
//                        .setPort(Constant.VNDB_PORT)
//                        .setThreadStrategy(ThreadStrategy.ASYNC)
//                        .setCharset(StandardCharsets.UTF_8)
//                        .setTimeout(5000)
//                        .build()).option(new SocketOption.Builder()
//                        .build());
//    }
}
