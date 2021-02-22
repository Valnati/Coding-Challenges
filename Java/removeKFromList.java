// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
// This iterative approach ignores the first node until the end
// It uses two pointers to cycle through nodes,
// after checking the list is long enough to do so.

ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {    
    ListNode<Integer> p1 = l;
    
    //l is size 0
    if (p1 == null) return l;
    
    ListNode<Integer> p2 = p1.next;

    //l is size 1
    if (p2 == null) {
        if (p1.value == k) return l.next;
        else return l;
    }
    
    //skip first node until after loop
    while (p2 != null) {
        if (p2.value == k) {
            p1.next = p2.next;
            p2 = p1.next;
        } else {
            p1 = p1.next;
            p2 = p2.next;
        }
    }
    //check first node
    if (l.value == k) return l.next;
    else return l;
}
