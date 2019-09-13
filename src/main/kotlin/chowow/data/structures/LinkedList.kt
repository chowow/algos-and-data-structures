package chowow.data.structures

// Thought it would be interesting to implement the interfaces you'd want to use in Kotlin.
// Wow, there are a lot of functions to implement!
// Also, serious TODO! What about nullability?
// There are a few !!s here and it doesn't feel right. An iterator has state and I've chosen a mutable list implementation
// (otherwise you can't really do what a linked list is good for - inserting in the middle), but there must be a better way of managing
// 'end' states. Maybe a const val representing the end?
// Not Thread Safe!
class LinkedList<T> : MutableList<T>, Iterable<T> {

    private var firstNode: LinkedListNode<T>? = null
    private var lastNode: LinkedListNode<T>? = null
    private var nodeCount: Int = 0

    override fun add(element: T): Boolean {
        val nextNode = LinkedListNode(element)
        if (lastNode == null) {
            firstNode = nextNode
            lastNode = nextNode
        } else {
            lastNode?.next =
                nextNode // TODO this is where exercism would be handy. Isn't there a way to avoid this when you've done a null check already?
            nextNode.previous = lastNode
            lastNode = nextNode
        }
        nodeCount++
        return true
    }

    override fun add(index: Int, element: T) {
        val nodeToInsertAfter = getNode(index - 1)
        nodeToInsertAfter!!.next = LinkedListNode(element, nodeToInsertAfter.next, nodeToInsertAfter) // TODO null check
        nodeCount++ // TODO bring all add fns together so that this ++ happens in one place only
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        nodeCount = 0
        firstNode = null
        lastNode = null
    }

    override fun remove(element: T): Boolean {
        var node = firstNode
        while (node != null && node.value != element) {
            node = node.next
        }
        if (node != null) {
            node.previous!!.next = node.next
            nodeCount--
            return true
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAt(index: Int): T {
        val currentNode = getNode(index)
        currentNode!!.previous!!.next = currentNode.next
        nodeCount--
        return currentNode.value
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(index: Int, element: T): T {
        val currentNode = getNode(index)
        currentNode!!.previous!!.next =
            LinkedListNode(element, currentNode.next, currentNode.previous) // TODO nulls
        return currentNode.value
    }

    override val size: Int
        get() = nodeCount

    override fun contains(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(index: Int): T {
        val node = getNode(index)
        return node!!.value // TODO
    }

    private fun getNode(index: Int): LinkedListNode<T>? {
        if (index >= nodeCount) {
            throw ArrayIndexOutOfBoundsException(index)
        }
        if (firstNode != null) {
            var position = 0
            var node = firstNode
            while (position < index) {
                node = node!!.next // TODO
                position++
            }
            return node
        }
        TODO()
    }

    override fun indexOf(element: T): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isEmpty(): Boolean = nodeCount == 0

    override fun lastIndexOf(element: T): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(): MutableListIterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): MutableIterator<T> = LinkedListIterator(firstNode)

}

private class LinkedListNode<T>(
    val value: T,
    var next: LinkedListNode<T>? = null,
    var previous: LinkedListNode<T>? = null
) {
    fun hasNext() = next != null
}

private class LinkedListIterator<T>(var currentNode: LinkedListNode<T>?) : MutableListIterator<T> {
    override fun hasPrevious(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun nextIndex(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun previous(): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun previousIndex(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(element: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(element: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasNext(): Boolean {
        return currentNode != null
    }

    override fun next(): T {
        val value = currentNode!!.value // TODO
        currentNode = currentNode!!.next
        return value
    }
}