package cz.lukynka.aura.framework.game

import cz.lukynka.aura.framework.Config
import cz.lukynka.aura.framework.util.FrameRateLimiter
import cz.lukynka.aura.framework.vector.Vector2
import cz.lukynka.prettylog.LogType
import cz.lukynka.prettylog.log
import java.lang.IllegalStateException
import java.util.concurrent.locks.ReentrantLock

abstract class GameState {

    private fun log(message: String) {
        log(message, LogType.RUNTIME)
    }

    var windowFocused = false

    var contextSize = Vector2(0, 0)

    val updateLimiter = FrameRateLimiter(60)
    val drawLimiter = FrameRateLimiter(60)
    val inputLimiter = FrameRateLimiter(1000)

    protected abstract fun handleGameCycle(): Boolean

    private var drawThread: Thread? = null
    private var updateThread: Thread? = null
    private var inputThread: Thread? = null

    protected var game: Game? = null

    private val lock = ReentrantLock()

    fun start(game: Game) {
        this.game = game

        var keepRunning = true

        drawThread = Thread {
            lock.lock()
            log("Loading draw thread..")
            // load rendering context
            game.setup()
            log("Draw thread loaded!")
            lock.unlock()
            while(handleGameCycle()) {
                drawLimiter.fps = if(windowFocused) Config.FOREGROUND_FPS else Config.FOREGROUND_FPS
                if(!Config.VSYNC) drawLimiter.sync()
                game.drawClock.updateClock()
            }
            keepRunning = false
        }
        getDrawThread().name = "Draw Thread"
    }


    fun getDrawThread(): Thread {
        return drawThread ?: throw IllegalStateException("Draw thread has not been initialized yet!")
    }

    fun getInputThread(): Thread {
        return inputThread ?: throw IllegalStateException("Input thread has not been initialized yet!")
    }

    fun getUpdateThread(): Thread {
        return updateThread ?: throw IllegalStateException("Update thread has not been initialized yet!")
    }

}