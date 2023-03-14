import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BowlingScorerTest {

    @Test
    fun `line with all misses scores 0`() {
        assertThat(scorer.scoreFor("--|--|--|--|--|--|--|--|--|--||")).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "11|11|11|11|11|11|11|11|11|11||, 20",
        "21|31|11|11|12|11|11|11|11|41||, 27",
    )
    fun `line with all numbers returns sum of numbers`(line: String, expectedScore: Int) {
        assertThat(scorer.scoreFor(line)).isEqualTo(expectedScore)
    }

    @ParameterizedTest
    @CsvSource(
        "9/|--|--|--|--|--|--|--|--|--||, 10",
        "7/|--|--|--|4/|--|--|--|--|--||, 20",
        "7/|1-|--|--|4/|--|--|--|--|--||, 22",
        //"6/|11|--|--|--|--|--|--|--|5/||1, 24",
    )
    fun `a spare scores ten plus the score in the next frame`(line: String, expectedScore: Int) {
        assertThat(scorer.scoreFor(line)).isEqualTo(expectedScore)
    }

    @ParameterizedTest
    @CsvSource(
        "X|--|--|--|--|--|--|--|--|--||, 10",
        "X|1-|--|--|--|--|--|--|--|--||, 12",
        "X|41|--|--|--|--|--|--|--|--||, 20",
        "X|X|--|--|--|--|--|--|--|--||, 30",
        "X|X|1-|--|--|--|--|--|--|--||, 33",
        "X|X|X|--|--|--|--|--|--|--||, 60",
    )
    fun `a strike scores ten plus the score in the next two frames`(line: String, expectedScore: Int) {
        assertThat(scorer.scoreFor(line)).isEqualTo(expectedScore)
    }


    private val scorer = BowlingScorer()
}
