package cz.lukynka.aura.framework.vector

data class Vector2d(val x: Double, val y:Double) {
    constructor(): this(0.0, 0.0)
    constructor(single: Double): this(single, single)

    operator fun minus(vector: Vector2d): Vector2d {
        val newX = x - vector.x
        val newY = y - vector.y
        return Vector2d(newX, newY)
    }

    operator fun plus(vector: Vector2d): Vector2d {
        val newX = x + vector.x
        val newY = y + vector.y
        return Vector2d(newX, newY)
    }

    operator fun times(vector: Vector2d): Vector2d {
        val newX = x * vector.x
        val newY = y * vector.y
        return Vector2d(newX, newY)
    }

    operator fun div(vector: Vector2d): Vector2d {
        val newX = x / vector.x
        val newY = y / vector.y
        return Vector2d(newX, newY)
    }

    val isZero: Boolean get() = x == 0.0 && y == 0.0
    fun toVector2(): Vector2 = Vector2(x.toInt(), y.toInt())
    fun toVector2f(): Vector2f = Vector2f(x.toFloat(), y.toFloat())
}