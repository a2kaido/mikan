package io.a2kaido.serialization

import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MikanTest {

    @Test
    fun `Mikan is serializable`() {
        val mikan: Mikan = AwesomeMikan(1, 8, 3000)

        val serialized = Json.encodeToString(mikan)

        assertEquals("""{"type":"Awesome","hasSeed":true,"kawa":1,"mi":8,"value":3000}""", serialized)
        assertEquals("""{"hasSeed":true,"kawa":1,"mi":8,"value":3000}""", Json.encodeToString(mikan as AwesomeMikan))
        assertEquals(mikan, Json.decodeFromString<Mikan>(serialized))
        assertEquals(mikan, Json { ignoreUnknownKeys = true }.decodeFromString<AwesomeMikan>(serialized))
    }

    @Test
    fun `GoodMikan is serializable`() {
        val mikan: Mikan = GoodMikan(1, 8, "Ehime")

        val serialized = Json.encodeToString(mikan)

        assertEquals("""{"type":"Good","hasSeed":true,"kawa":1,"mi":8,"place":"Ehime"}""", serialized)
        assertEquals("""{"hasSeed":true,"kawa":1,"mi":8,"place":"Ehime"}""", Json.encodeToString(mikan as GoodMikan))
        assertEquals(mikan, Json.decodeFromString<Mikan>(serialized))
        assertEquals(mikan, Json { ignoreUnknownKeys = true }.decodeFromString<GoodMikan>(serialized))
    }
}