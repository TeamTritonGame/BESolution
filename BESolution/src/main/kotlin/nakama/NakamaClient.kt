package org.david.nakama

import com.heroiclabs.nakama.DefaultClient
import com.heroiclabs.nakama.Session
import java.util.concurrent.ExecutionException
import kotlin.coroutines.cancellation.CancellationException

object NakamaClient {
    val defaultClient = DefaultClient("defaultkey", "127.0.0.1", 7350, false)
    val defaultSession = defaultClient.authenticateDevice("some-device-id")

    fun getNakamaClient(): DefaultClient {
        return defaultClient
    }

    fun getNakamaSession(): Session {
        var session : Session? = null

        try {
            session = defaultSession.get()
        } catch (e: CancellationException) {
            println("Exception: $e")
        } catch (e: ExecutionException){
            println("Exception: $e")
        } catch (e: InterruptedException) {
            println("Exception: $e")
        }

        return session!!
    }
}