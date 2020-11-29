package io.a2kaido.serialization

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MikanBoxTest {

    @Test
    fun `MikanBox is serializable`() {
        val mikan = Mikan(1, 8)
        val mikanBox = MikanBox(listOf(mikan, mikan, mikan))

        val serialized = Json.encodeToString(MikanBox.serializer(), mikanBox)

        assertEquals(
            """{"mikans":[{"hasSeed":true,"kawa":1,"mi":8},{"hasSeed":true,"kawa":1,"mi":8},{"hasSeed":true,"kawa":1,"mi":8}]}""",
            serialized
        )
        assertEquals(mikanBox, Json.decodeFromString(MikanBox.serializer(), serialized))
    }
}