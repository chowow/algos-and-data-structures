package chowow.algos

import org.junit.Test
import org.assertj.core.api.Assertions.assertThat

class InsertionSortTest {

    @Test
    fun shouldSortNumbers() {
        val unsortedNumbers = arrayOf(4, 3, 1, 6, 7, 8, 4, 6, 3, -1)
        assertThat(InsertionSort.sort(unsortedNumbers)).containsExactly(-1, 1, 3, 3, 4, 4, 6, 6, 7, 8)
    }
}