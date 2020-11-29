package io.a2kaido.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

@Serializable
abstract class Fruit(val hasSeed: Boolean)

val module = SerializersModule {
    polymorphic(Fruit::class) {
        subclass(Mikan::class)
    }
}