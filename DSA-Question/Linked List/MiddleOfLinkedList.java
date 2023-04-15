class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s =  head;
        while(f!=null && f.next!=null){
            f= f.next.next;
            s =s.next;
        }
        
        return s;
    }

    /// Delete mid
    
    /**
     * 
     * find the node before mid do then delete
     * */
    ListNode deleteMid(ListNode head) {
        ListNode s = new ListNode(0);
        s.next = head; //starting s one step back
        ListNode f = head;
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
        }
        s.next = s.next.next;
        return head;
    }
}
