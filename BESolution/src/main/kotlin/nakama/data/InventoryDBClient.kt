package org.david.nakama.data

import com.google.gson.Gson
import com.heroiclabs.nakama.PermissionRead
import com.heroiclabs.nakama.PermissionWrite
import com.heroiclabs.nakama.Session
import com.heroiclabs.nakama.StorageObjectWrite
import com.heroiclabs.nakama.api.StorageObject
import org.david.nakama.NakamaClient.getNakamaClient

object InventoryDBClient {

    fun saveWeaponIntoInventory(session: Session, weapons: InventoryWeapon, collection: String, key: String) {
        getNakamaClient().writeStorageObjects(session, StorageObjectWrite(
            collection,
            key,
            Gson().toJson(weapons),
            PermissionRead.PUBLIC_READ,
            PermissionWrite.OWNER_WRITE
        ))
    }

    fun getCollectionFromInventory(session: Session, userId: String, collection: String, key: String) : StorageObject {
        return getNakamaClient()
            .listUsersStorageObjects( session, collection, userId )
            .get()
            .objectsList
            .find { it.key!! == key }!!
    }
}