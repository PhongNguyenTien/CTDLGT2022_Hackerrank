package BT_Linked_List;

public class Print_in_Reverse
{
    /* using loop */
    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        int count = 0;
        List<Integer> valueList = new ArrayList<>();
        while (llist != null) {
            valueList.add(llist.data);
            llist = llist.next;
            count++;
        }
        for (int i = count - 1; i >= 0; i--) {
            System.out.println(valueList.get(i));
        }
    }

    /* using recursion */
    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null) {
            return;
        }
        reversePrint(llist.next);
        System.out.println(llist.data);

    }
}
