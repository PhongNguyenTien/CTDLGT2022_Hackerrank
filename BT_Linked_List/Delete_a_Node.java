package BT_Linked_List;

public class Delete_a_Node {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        /* using loop */
        if (position == 0) {
            llist = llist.next;
            return llist;
        }
        int count = 0;
        SinglyLinkedListNode temp = llist;
        while (count < position) {
            SinglyLinkedListNode prev = temp;
            temp = temp.next;
            count++;
            if (count == position) {
                prev.next = temp.next;
                break;
            }
        }
        return llist;
    }

    /* using recursion */
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        if (position == 0) {
            return llist.next;
        }
        llist.next = deleteNode(llist.next, position - 1);
        return llist;
    }
}
