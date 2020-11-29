package io.a2kaido.serialization

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MikanTest {

    @Test
    fun `Mikan is serializable`() {
        val mikan = Mikan(1, 8)

        val serialized = Json.encodeToString(Mikan.serializer(), mikan)

        assertEquals("{\"kawa\":1,\"mi\":8}", serialized)
        assertEquals(mikan, Json.decodeFromString(Mikan.serializer(), serialized))
    }
}