package com.example.list.model


/*
    Override equals and hashCode in order to compare description
    that supports change of language at runtime
 */
internal data class UserData(
    val thumbnailUrl: String,
    val name: String,
    val description: () -> String,
    val timeOfBirth: String,
) {
    override fun equals(other: Any?): Boolean = other is UserData &&
        other.thumbnailUrl == thumbnailUrl &&
        other.name == name &&
        other.description.invoke() == description.invoke() &&
        other.timeOfBirth == timeOfBirth

    override fun hashCode(): Int {
        var result = thumbnailUrl.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + timeOfBirth.hashCode()
        return result
    }
}
