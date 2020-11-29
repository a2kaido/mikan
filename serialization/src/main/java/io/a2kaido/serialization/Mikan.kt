package io.a2kaido.serialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Mikan")
sealed class Mikan : Fruit(true) {
    abstract val kawa: Int
    abstract val mi: Int
}

@Serializable
@SerialName("Awesome")
data class AwesomeMikan(override val kawa: Int, override val mi: Int) : Mikan()