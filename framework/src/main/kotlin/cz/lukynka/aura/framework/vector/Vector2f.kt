package cz.lukynka.aura.framework.vector

data class Vector2f(val x: Float, val y: Float) {
    constructor(): this(0f, 0f)
    constructor(single: Float): this(single, single)

    operator fun minus(vector: Vector2f): Vector2f {
        val newX = x - vector.x
        val newY = y - vector.y
        return Vector2f(newX, newY)
    }

    operator fun plus(vector: Vector2f): Vector2f {
        val newX = x + vector.x
        val newY = y + vector.y
        return Vector2f(newX, newY)
    }

    operator fun times(vector: Vector2f): Vector2f {
        val newX = x * vector.x
        val newY = y * vector.y
        return Vector2f(newX, newY)
    }

    operator fun div(vector: Vector2f): Vector2f {
        val newX = x / vector.x
        val newY = y / vector.y
        return Vector2f(newX, newY)
    }

    val isZero: Boolean get() = x == 0f && y == 0f
    fun toVector2(): Vector2 = Vector2(x.toInt(), y.toInt())
    fun toVector2d(): Vector2d = Vector2d(x.toDouble(), y.toDouble())
}