// Time Complexity : O(3*n) where n is the numbe rof nodes in the linked list.
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        return null;
        Node original = head;
        while(original != null)
        {
            Node temp = new Node(original.val);
            temp.next = original.next;
            original.next = temp;
            original = temp.next;
        }

        original = head;
        while(original != null)
        {
            if(original.random == null)
                original.next.random = null;
            else
                original.next.random = original.random.next;
            original = original.next.next;
        }

        original = head;
        Node dupNode = head.next;
        while(original != null)
        {
            Node dup = original.next;
            original.next = dup.next;
            if(original.next == null)
            dup.next = null;
            else
            dup.next = original.next.next;

            original = original.next;
        }
        return dupNode;

    }
}