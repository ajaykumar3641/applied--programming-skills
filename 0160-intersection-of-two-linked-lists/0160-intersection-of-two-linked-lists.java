public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {

            // When pA reaches the end, start from headB
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            // When pB reaches the end, start from headA
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        return pA;
    }
}