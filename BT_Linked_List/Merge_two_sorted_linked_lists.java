package BT_Linked_List;

public class Merge_two_sorted_linked_lists {
    /* using recursion */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null)
        {
            return head2;
        }
        if (head2 == null)
        {
            return head1;
        }
        if (head1.data <= head2.data)
        {
            SinglyLinkedListNode nextHead1 = head1.next;
            SinglyLinkedListNode nextMergedList = mergeLists(nextHead1, head2);
            head1.next = nextMergedList;
            return head1;
        }
        else
        {
            mergeLists(head2, head1);
        }
        return head2;

    }

    /* using loop */
    static void addToList(SinglyLinkedListNode head, int val)
    {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val);
        if (head == null)
        {
            head = newNode;
            return;
        }
        SinglyLinkedListNode temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode mergedList = null;
        if (head1.data <= head2.data)
        {
            mergedList = new SinglyLinkedListNode(head1.data);
            head1 = head1.next;
        }
        else
        {
            mergedList = new SinglyLinkedListNode(head2.data);
            head2 = head2.next;
        }
        while (head1 != null || head2 != null)
        {
            if (head1 != null && head2 != null)
            {
                if (head1.data <= head2.data)
                {
                    addToList(mergedList, head1.data);
                    head1 = head1.next;
                }
                else
                {
                    addToList(mergedList, head2.data);
                    head2 = head2.next;
                }
            }
            else if (head1 != null)
            {
                addToList(mergedList, head1.data);
                head1 = head1.next;
            }
            else
            {
                addToList(mergedList, head2.data);
                head2 = head2.next;
            }
        }
        return mergedList;
    }




}
