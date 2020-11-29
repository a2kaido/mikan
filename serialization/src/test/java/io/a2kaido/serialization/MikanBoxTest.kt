package io.a2kaido.serialization

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MikanBoxTest {

    @Test
    fun `MikanBox is serializable`() {
        val mikan = AwesomeMikan(1, 8, 3000)
        val goodMikan = GoodMikan(1, 8, "Ehime")
        val mikanBox = MikanBox(listOf(mikan, goodMikan))

        val serialized = Json.encodeToString(MikanBox.serializer(), mikanBox)

        assertEquals(
            """{"mikans":[{"type":"Awesome","hasSeed":true,"kawa":1,"mi":8,"value":3000},{"type":"Good","hasSeed":true,"kawa":1,"mi":8,"place":"Ehime"}]}""",
            serialized
        )
        assertEquals(mikanBox, Json.decodeFromString(MikanBox.serializer(), serialized))
        assertEquals(mikan, Json.decodeFromString(MikanBox.serializer(), serialized).mikans[0])
        assertEquals(goodMikan, Json.decodeFromString(MikanBox.serializer(), serialized).mikans[1])
    }
}