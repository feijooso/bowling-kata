class BowlingScorer {
    fun scoreFor(textLine: String): Int {
        var line = Line(textLine)
        return line.score()
    }
}
