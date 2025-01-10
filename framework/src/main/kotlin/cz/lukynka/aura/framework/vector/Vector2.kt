package cz.lukynka.aura.framework.vector

data class Vector2(val x: Int, val y: Int) {
    constructor(): this(0, 0)
    constructor(single: Int): this(single, single)

    operator fun minus(vector: Vector2): Vector2 {
        val newX = x - vector.x
        val newY = y - vector.y
        return Vector2(newX, newY)
    }

    operator fun plus(vector: Vector2): Vector2 {
        val newX = x + vector.x
        val newY = y + vector.y
        return Vector2(newX, newY)
    }

    operator fun times(vector: Vector2): Vector2 {
        val newX = x * vector.x
        val newY = y * vector.y
        return Vector2(newX, newY)
    }

    operator fun div(vector: Vector2): Vector2 {
        val newX = x / vector.x
        val newY = y / vector.y
        return Vector2(newX, newY)
    }

    val isZero: Boolean get() = x == 0 && y == 0
    fun toVector2f(): Vector2f = Vector2f(x.toFloat(), y.toFloat())
    fun toVector2d(): Vector2d = Vector2d(x.toDouble(), y.toDouble())
}