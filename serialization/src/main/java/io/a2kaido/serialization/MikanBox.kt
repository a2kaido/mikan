package io.a2kaido.serialization

import kotlinx.serialization.Serializable

@Serializable
data class MikanBox(val mikans: List<Mikan>)