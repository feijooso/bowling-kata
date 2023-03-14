class Line(private val textLine: String) {
    private val frames = textLine.split('|').filter { it.isNotEmpty() }
        .mapIndexed{ i, textFrame -> Frame(textFrame, this, i) }

    fun score() = frames.sumOf { it.score() }

    fun getFrame(index: Int) = frames[index]
}
