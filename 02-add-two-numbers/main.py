# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1, l2):
        prevNode = None
        currentNode = ListNode()
        res = None

        transValue = 0

        curNode1 = l1
        curNode2 = l2
        firstIter = True
        while ((curNode1 != None) or (curNode2 != None)):
            val1 = curNode1.val if curNode1 != None else 0
            val2 = curNode2.val if curNode2 != None else 0

            sum = val1 + val2 + transValue
            
            print(sum)

            currentNode = ListNode(val = (sum % 10))
            if firstIter:
                res = currentNode
                firstIter = False
            transValue = sum // 10

            if prevNode != None:
                prevNode.next = currentNode

            prevNode = currentNode

            curNode1 = curNode1.next if curNode1 != None else None
            curNode2 = curNode2.next if curNode2 != None else None
            
        
        if transValue != 0:
            node = ListNode(transValue)
            prevNode.next = node

        return res