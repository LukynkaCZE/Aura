package cz.lukynka.aura.framework.game

import cz.lukynka.aura.framework.Disposable
import cz.lukynka.aura.framework.clock.FramedClock

abstract class Game: Disposable {

    var updateClock: FramedClock = FramedClock()
    var drawClock: FramedClock = FramedClock()
    var inputClock: FramedClock = FramedClock()

    abstract fun setup()
    abstract fun update()
    abstract fun draw()

}