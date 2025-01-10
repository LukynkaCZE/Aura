package cz.lukynka.aura.framework.clock

class FramedClock: Clock {
    var time: FrameInfo = FrameInfo(0.0, 0.0, 0.0)
    override var currentTime: Double = 0.0
        get() = time.currentTime

    override var clockRate: Double = 1.0
    override var isRunning: Boolean = true

    private var rawTime = 0L
    private var currentTimeInternal = 0L
    private var lastTimeInternal = 0L

    fun updateClock() {
        time.lastTime = time.currentTime
        currentTimeInternal = System.nanoTime()

        if (lastTimeInternal == 0L) {
            lastTimeInternal = currentTimeInternal
        }

        rawTime += ((currentTimeInternal-lastTimeInternal).toDouble()*clockRate).toLong()

        time.currentTime = rawTime.toDouble() / 1000000.0
        time.frameTime = time.currentTime - time.lastTime

        lastTimeInternal = currentTimeInternal
    }
}