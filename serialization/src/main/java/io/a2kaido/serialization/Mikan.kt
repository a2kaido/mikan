package io.a2kaido.serialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Mikan")
data class Mikan(val kawa: Int, val mi: Int) : Fruit(true)