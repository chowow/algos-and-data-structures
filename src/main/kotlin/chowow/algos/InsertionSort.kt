package chowow.algos

class InsertionSort {
    companion object {
        fun sort(numbers: Array<Int>): Array<Int> {
            for (i in 1 until numbers.size) {
                val value = numbers[i]
                var j = i
                while (j > 0 && numbers[j - 1] > value) {
                    numbers[j] = numbers[j - 1]
                    j--
                }
                numbers[j] = value
            }
            return numbers
        }
    }
}