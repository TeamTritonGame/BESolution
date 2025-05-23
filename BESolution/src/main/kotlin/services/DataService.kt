package org.david.grpc

import io.grpc.stub.StreamObserver
import org.david.grpc.DataServiceGrpc.DataServiceImplBase

class DataService: DataServiceImplBase() {
//    override fun getData(request: DataRequest): DataResponse {
//        return DataResponse.newBuilder().setMessage("Hello ${request.name}").build()
//    }

    override fun saveInventory(
        request: SaveInventoryRequest?,
        responseObserver: StreamObserver<SaveInventoryResponse>?
    ) {

    }
}