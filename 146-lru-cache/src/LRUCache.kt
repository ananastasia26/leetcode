class LRUCache(private val capacity: Int) {
    private val cache = HashMap<Int, Info<Int, Int>>()
    private val linkedList = LinkedList<Int>()
    private var size = 0

    fun get(key: Int): Int {
        val data = cache[key] ?: return -1

        linkedList.moveToTail(data.node)

        return data.value
    }

    fun put(key: Int, value: Int) {
        if (cache[key] != null) {
            val node = cache[key]!!.node
            linkedList.moveToTail(node)
            cache[key] = Info(value, node)
            return
        }
        if (size >= capacity) {
            val keyToRemove = linkedList.getHeadValue()
            cache.remove(keyToRemove)
            linkedList.moveHeadForward()
            size--
        }
        cache[key] = Info(value, linkedList.addValue(key))
        size++
    }

    data class Info<K, V>(val value: V, val node: LinkedList.Node<K>)
    class LinkedList<T> {
        private var head: Node<T>? = null
        private var tail: Node<T>? = null

        fun moveToTail(node: Node<T>) {
            if (node == tail) {
                return
            }

            if (head == node) {
                head = node.next
            }

            node.prev?.next = node.next
            node.next?.prev = node.prev

            node.prev = tail
            node.next = null

            tail?.next = node
            tail = node
        }

        fun getHeadValue() : T? {
            return head?.value
        }

        fun addValue(value: T): Node<T> {
            val newNode = Node(value, tail, null)
            tail?.next = newNode
            tail = newNode
            if(head == null) {
                head = newNode
            }
            return newNode
        }

        fun moveHeadForward() {
            head = head?.next
        }

        class Node<T>(val value: T, var prev: Node<T>?, var next: Node<T>?)
    }
}