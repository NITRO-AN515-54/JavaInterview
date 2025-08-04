package LeetCodeProblems.AddTwoNumber;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Create first number: 342 -> [2 -> 4 -> 3]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second number: 465 -> [5 -> 6 -> 4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Run the solution
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result list
        printList(result);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
    }
}
