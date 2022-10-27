package BT_Linked_List;

public class Insert_a_node_at_the_head_of_a_linked_list {
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = llist;
        return newNode;
    }
}
