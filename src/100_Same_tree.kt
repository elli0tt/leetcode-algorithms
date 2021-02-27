import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

/**
 * https://leetcode.com/problems/same-tree/
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false


Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104


 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val queueP = LinkedList<TreeNode?>()
        val queueQ = LinkedList<TreeNode?>()

        queueP.add(p)
        queueQ.add(q)

        var result = true
        while (result && !queueP.isEmpty()) {
            val currentP = queueP.poll()
            val currentQ = queueQ.poll()
            result = (currentP?.`val` == currentQ?.`val`) &&
                    ((currentP?.left == null) == (currentQ?.left == null)) &&
                    ((currentP?.right == null) == (currentQ?.right == null))
            currentP?.left?.let {
                queueP.add(it)
                queueQ.add(currentQ?.left)
            }
            currentP?.right?.let {
                queueP.add(it)
                queueQ.add(currentQ?.right)
            }
        }

        return result
    }
}