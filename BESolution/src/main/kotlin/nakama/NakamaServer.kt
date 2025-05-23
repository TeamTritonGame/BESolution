package org.david.nakama

import io.grpc.Server
import io.grpc.ServerBuilder
import org.david.grpc.DataService

object NakamaServer {

    fun startNakamaServer(): Server{
        return ServerBuilder
            .forPort(12345)
            .addService(DataService())
            .build()
    }
}