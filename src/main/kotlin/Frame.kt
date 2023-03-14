class Frame(private val slots: String, private val line: Line, private val index: Int ) {

    fun score() = slots.filter { it.isDigit() }.sumOf { it.digitToInt() } + extraScores()

    private fun extraScores(): Int {
        if (slots[0] == 'X') return strikeScore()
        if (slots[1] == '/') return spareScore()
        return 0
    }

    private fun strikeScore(): Int {
        if (line.getFrame(index + 1).slots[0] == 'X' && line.getFrame(index + 2).slots[0] == 'X') return 30
        if (line.getFrame(index + 1).slots[0] == 'X') return 20 + getNumber(line.getFrame(index+2).slots[0])
        return 10 + getNumber(line.getFrame(index+1).slots[0]) + getNumber(line.getFrame(index+1).slots[1])
    }

    private fun spareScore() = 10 - slots[0].digitToInt() + getNumber(line.getFrame(index+1).slots[0])

    private fun getNumber(c: Char): Int {
        if (!c.isDigit()) return 0
        return c.digitToInt()
    }


}
