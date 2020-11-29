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
        val fruit: Fruit = AwesomeMikan(1, 8, 3000)
        val format = Json { serializersModule = module }

        val serialized = format.encodeToString(fruit)
        val deserialized = format.decodeFromString<Fruit>(serialized)
        assertEquals("""{"type":"Awesome","hasSeed":true,"kawa":1,"mi":8,"value":3000}""", serialized)
        assertEquals(fruit, deserialized)
        assertTrue(deserialized is Mikan)
    }
}