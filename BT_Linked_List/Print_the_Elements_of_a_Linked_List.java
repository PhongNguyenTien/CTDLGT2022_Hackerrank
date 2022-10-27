package BT_Linked_List;

public class Print_the_Elements_of_a_Linked_List {

    /* using recursion */
    static void printLinkedList(SinglyLinkedListNode head) {
        if (head.next == null)
        {
            System.out.println(head.data);
            return;
        }
        System.out.println(head.data);
        printLinkedList(head.next);

    }

    /* using loop */
    static void printLinkedList(SinglyLinkedListNode head) {
        while (head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }

    }
}
