package BT_Linked_List;

public class Insert_a_node_at_a_specific_position_in_a_linked_list {
    /* using loop */
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (position == 0)
        {
            newNode.next = llist;
            llist = newNode;
            return llist;
        }
        int count = 0;
        SinglyLinkedListNode temp = llist;
        while (count < position)
        {
            SinglyLinkedListNode prev = temp;
            temp = temp.next;
            count++;
            if (count == position)
            {
                prev.next = newNode;
                newNode.next = temp;
                break;
            }
        }
        return llist;
    }

    /* using recursion */
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            if (position == 0)
            {
                newNode.next = llist;
                llist = newNode;
                return llist;
            }
            llist.next = insertNodeAtPosition(llist.next, data, position - 1);
            return llist;
        }

}
