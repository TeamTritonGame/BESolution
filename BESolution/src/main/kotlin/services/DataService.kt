package org.david.grpc

import io.grpc.stub.StreamObserver
import org.david.grpc.DataServiceGrpc.DataServiceImplBase
import org.david.nakama.NakamaClient
import org.david.nakama.data.InventoryDBClient
import org.david.nakama.data.InventoryWeapon

class DataService: DataServiceImplBase() {

    override fun saveInventory(
        request: SaveInventoryRequest?,
        responseObserver: StreamObserver<SaveInventoryResponse>?)
    {
        responseObserver!!.onNext(request?.let { processSaveInventory(it) })
        responseObserver.onCompleted()
    }

    private fun processSaveInventory(request: SaveInventoryRequest): SaveInventoryResponse {
        InventoryDBClient.saveWeaponIntoInventory(NakamaClient.getNakamaSession(), InventoryWeapon("","",1), "","")

        return SaveInventoryResponse.newBuilder().build()
    }
}