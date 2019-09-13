package chowow.data.structures

import org.assertj.core.api.Assertions.*
import org.junit.Test

class LinkedListTest {

    @Test
    fun `should be able to add to a list and preserve order`() {
        val list = LinkedList<Int>()
        list.add(2)
        list.add(4)

        assertThat(list).hasSize(2)
        assertThat(list[0]).isEqualTo(2)
        assertThat(list[1]).isEqualTo(4)
    }

    @Test
    fun `should be able to insert to a list and preserve order`() {
        val list = LinkedList<Int>()
        list.add(2)
        list.add(4)
        list.add(1, 3)

        assertThat(list).hasSize(3)
        assertThat(list[0]).isEqualTo(2)
        assertThat(list[1]).isEqualTo(3)
        assertThat(list[2]).isEqualTo(4)
    }

    @Test
    fun `should be able to iterate over a list`() {
        val list = LinkedList<Int>()
        list.add(0)
        list.add(1)
        list.add(2)

        var expectedValue = 0
        for (element in list) {
            assertThat(element).isEqualTo(expectedValue)
            expectedValue++
        }
        assertThat(expectedValue).isEqualTo(3)
    }

    @Test
    fun `should throw ArrayIndexOutOfBoundsException is index is out of bounds`() {
        val thrown = catchThrowable { LinkedList<Int>().get(0) }
        assertThat(thrown).isExactlyInstanceOf(ArrayIndexOutOfBoundsException::class.java)
    }

    @Test
    fun `clear should result in empty list that can be added to again`() {
        val list = LinkedList<Int>()
        list.add(2)

        list.clear()

        assertThat(list).hasSize(0)
        assertThat(list.isEmpty()).isTrue()
        assertThat(list.iterator().hasNext()).isFalse()

        list.add(2)

        assertThat(list).hasSize(1)
        assertThat(list[0]).isEqualTo(2)
        assertThat(list.isEmpty()).isFalse()
        assertThat(list.iterator().hasNext()).isTrue()
    }

    @Test
    fun `should be able to replace an element by index`() {
        val list = LinkedList<Int>()
        list.add(0)
        list.add(99)
        list.add(2)

        val previousVal = list.set(1, 1)

        assertThat(previousVal).isEqualTo(99)

        var expectedValue = 0
        for (element in list) {
            assertThat(element).isEqualTo(expectedValue)
            expectedValue++
        }
        assertThat(expectedValue).isEqualTo(3)
        assertThat(list).hasSize(3)
    }

    @Test
    fun `should be able to remove an element by index`() {
        val list = LinkedList<Int>()
        list.add(0)
        list.add(1)
        list.add(99)
        list.add(2)

        val previousVal = list.removeAt(2)

        assertThat(previousVal).isEqualTo(99)

        var expectedValue = 0
        for (element in list) {
            assertThat(element).isEqualTo(expectedValue)
            expectedValue++
        }
        assertThat(expectedValue).isEqualTo(3)
        assertThat(list).hasSize(3)
    }

    @Test
    fun `should remove a single element by element equals`() {

        val list = LinkedList<Int>()
        list.add(0)
        list.add(1)
        list.add(4)
        list.add(2)
        list.add(3)
        list.add(4)

        assertThat(list.remove(4)).isTrue()

        var expectedValue = 0
        for (element in list) {
            assertThat(element).isEqualTo(expectedValue)
            expectedValue++
        }
        assertThat(expectedValue).isEqualTo(5)
        assertThat(list).hasSize(5)

        assertThat(list.remove(4)).isTrue()

        expectedValue = 0
        for (element in list) {
            assertThat(element).isEqualTo(expectedValue)
            expectedValue++
        }
        assertThat(expectedValue).isEqualTo(4)
        assertThat(list).hasSize(4)

        assertThat(list.remove(4)).isFalse()
    }
}