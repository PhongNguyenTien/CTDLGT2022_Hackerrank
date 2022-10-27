package BT_Linked_List;

public class Compare_two_linked_lists {
    /* using recursion */
    static boolean compareLength(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        int count1 = 0;
        int count2 = 0;
        while (l1 != null)
        {
            l1 = l1.next;
            count1++;
        }
        while (l2 != null)
        {
            l2 = l2.next;
            count2++;
        }
        return (count1 == count2) ? true : false;
    }
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (compareLength(head1, head2) == false)
        {
            return false;
        }
        if (head1.next == null && head2.next == null)
        {
            return (head1.data == head2.data) ? true : false;
        }
        return compareLists(head1.next, head2.next);

    }

    /* using loop */
    static boolean compareLength(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        int count1 = 0;
        int count2 = 0;
        while (l1 != null)
        {
            l1 = l1.next;
            count1++;
        }
        while (l2 != null)
        {
            l2 = l2.next;
            count2++;
        }
        return (count1 == count2) ? true : false;
    }
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (compareLength(head1, head2) == false)
        {
            return false;
        }
        while (head1 != null && head2 != null)
        {
            if (head1.data != head2.data)
            {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }




}
