package cz.lukynka.aura.framework.clock

interface Clock {
    var currentTime: Double
    var clockRate: Double
    var isRunning: Boolean
}