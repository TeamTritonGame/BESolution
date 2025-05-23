package org.david.nakama

import com.heroiclabs.nakama.DefaultClient

object NakamaClient {

    fun createClient(): DefaultClient {
        return DefaultClient("defaultkey", "127.0.0.1", 7350, false)
    }
}