// The class for the list node is defined as:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
// Given a ListNode as head of a list, and a value,
// remove the first node with that value from the list.
//
// This iterative approach ignores the first node until the end.
// It uses two pointers to cycle through nodes,
// after checking the list is long enough to do so.
//
// The space cost is constant, as two ListNodes are made.
// The time cost is O(n), where n is the size of the list,
//as in the worst case we will iterate through the entire list.

ListNode<Integer> removeJFromList(ListNode<Integer> n, int j) {    
    ListNode<Integer> p1 = n;
    
    //j is size 0
    if (p1 == null) return n;
    
    ListNode<Integer> p2 = p1.next;

    //j is size 1
    if (p2 == null) {
        if (p1.value == j) return n.next;
        else return n;
    }
    
    //skip first node until after loop
    while (p2 != null) {
        if (p2.value == j) {
            p1.next = p2.next;
            p2 = p1.next;
        } else {
            p1 = p1.next;
            p2 = p2.next;
        }
    }
    //check first node
    if (n.value == j) return n.next;
    else return n;
}
