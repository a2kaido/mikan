package io.a2kaido.serialization

import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FruitTest {

    @Test
    fun `Fruit is serializable`() {
        val fruit: Fruit = Mikan(1, 8)
        val format = Json { serializersModule = module }

        val serialized = format.encodeToString(fruit)
        val deserialized = format.decodeFromString<Fruit>(serialized)
        assertEquals("""{"type":"Mikan","hasSeed":true,"kawa":1,"mi":8}""", serialized)
        assertEquals(fruit, deserialized)
        assertTrue(deserialized is Mikan)
    }
}