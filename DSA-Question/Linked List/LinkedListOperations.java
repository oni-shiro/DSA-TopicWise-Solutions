class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Dll{
    int val;
    Dll next;
    Dll prev;
    public Dll() {
    }
    public Dll(int val, Dll next, Dll prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
    public Dll(int val) {
        this.val = val;
    }
    
    
}
public class LinkedListOperations {
//single linkedlist

    private void insertAtFirst(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        if(head!=null){
            head= newNode;
        }


    }

            
}   
