package BT_Linked_List;

public class Get_Node_Value {
    /* using loop */
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        int length = 0;
        SinglyLinkedListNode temp = llist;
        while (temp != null)
        {
            temp = temp.next;
            length++;
        }
        int count = length - 1 - positionFromTail;
        while (count != 0)
        {
            llist = llist.next;
            count--;
        }
        return llist.data;
    // Write your code here

    }

    /* using recursion */
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        SinglyLinkedListNode temp = llist;
        int length = 0;
        while (temp != null)
        {
            temp = temp.next;
            length++;
        }
        if (positionFromTail == length - 1 && llist != null)
        {
            return llist.data;
        }
        if (llist.next == null)
        {
            return llist.data;
        }
        return getNode(llist.next, positionFromTail);
    // Write your code here

    }

}
