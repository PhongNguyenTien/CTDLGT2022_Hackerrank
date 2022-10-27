package BT_Linked_List;

public class Insert_a_Node_at_the_Tail_of_a_Linked_List {
    /* using loop */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null)
        {
            return newNode;
        }
        SinglyLinkedListNode temp = head;
        
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    /* using recursion */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null)
        {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            return newNode;
        }
        head.next = insertNodeAtTail(head.next, data);
        return head;
        
    }

}
