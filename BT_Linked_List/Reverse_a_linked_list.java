package BT_Linked_List;

public class Reverse_a_linked_list {
    /* using loop */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null) {
            return null;
        }
        SinglyLinkedListNode curNode = llist;
        while (curNode.next != null) {
            SinglyLinkedListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = llist;
            llist = nextNode;
        }
        return llist;
    }

    /* using recursion */
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        if (llist == null) {
            return null;
        }
        if (llist.next == null) {
            return llist;
        }
        SinglyLinkedListNode nextNode = llist.next;
        SinglyLinkedListNode temp = reverse(nextNode);
        nextNode.next = llist;
        llist.next = null;
        return temp;
        // Write your code here

    }
}
