package chowow.algos

import org.assertj.core.api.Assertions
import org.junit.Test

class SelectionSortTest {

    @Test
    fun shouldSortNumbers() {
        val unsortedNumbers = arrayOf(4, 3, 1, 6, 7, 8, 4, 6, 3, -1)
        Assertions.assertThat(SelectionSort.sort(unsortedNumbers)).containsExactly(-1, 1, 3, 3, 4, 4, 6, 6, 7, 8)
    }
}