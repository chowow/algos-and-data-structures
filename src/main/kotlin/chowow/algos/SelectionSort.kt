package chowow.algos

class SelectionSort {
    companion object {
        fun sort(numbers: Array<Int>): Array<Int> {
            var minIndex: Int
            for (i in 0 until numbers.size) {
                minIndex = i
                for (j in i + 1 until numbers.size) {
                    if (numbers[j] < numbers[minIndex]) {
                        minIndex = j
                    }
                }

                val min = numbers[minIndex]
                numbers[minIndex] = numbers[i]
                numbers[i] = min
            }
            return numbers
        }
    }
}