package org.david.grpc

import io.grpc.stub.StreamObserver
import org.david.grpc.DataServiceGrpc.DataServiceImplBase

class DataService: DataServiceImplBase() {

    override fun saveInventory(
        request: SaveInventoryRequest?,
        responseObserver: StreamObserver<SaveInventoryResponse>?)
    {
        responseObserver!!.onNext(request?.let { processSaveInventory(it) })
        responseObserver.onCompleted()
    }

    private fun processSaveInventory(request: SaveInventoryRequest): SaveInventoryResponse {
        return SaveInventoryResponse.newBuilder().build()
    }
}