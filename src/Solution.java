import java.util.*;


class apple{
    private String name;

    
}

public class Solution {

    public int longestValidParentheses(String s) {
        int k = 0;
        if (s.length() <= 1)
            return k;
        //System.out.println("here");
        int i = 0;
        int j = s.length() - 1;
        while (j - i + 1 > k) {
            if ((j - i + 1) % 2 == 1)
                i = 1;
            else
                i = 0;
            //System.out.println(i + "  1  "  + k + " " + j);
            while (j > i) {
                if (isRight(s, i, j)) {
                    //System.out.println("here");
                    k = Math.max(k, j - i + 1);
                    break;
                }
                i += 2;
            }
            //System.out.println(i + "  2  "  + k + " " + j);
            i = 0;
            j--;
        }
        return k;
    }

    public boolean isRight(String s, int i, int j) {
        Stack<Character> stack = new Stack<>();
        while (i <= j) {
            if (s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if (!stack.isEmpty())
                stack.pop();
            else
                return false;
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        int[] array = {2, 3, 1};
        int[] array1 = new int[array.length];
        //int[] a = new int[1];
        //int[] b = new int[1];

        String l = "(()";
        String l1 = ".*a*a";

        String[] ss = {"ca", "cc"};

        char[] lll = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] llll = {'b', 'c', 'c', 'e', 'd'};

        System.out.println(s.longestValidParentheses(l));
    }
}


/*
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right = g;

        TreeNode A = new TreeNode(8);
        TreeNode B = new TreeNode(9);
        TreeNode C = new TreeNode(2);
        A.left = B;
        A.right = C;
*/

/*
        ListNode a = new ListNode(8);
        ListNode h = new ListNode(7);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(1);
        ListNode g = new ListNode(2);
        a.next = h;
        h.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
*/


        /*
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        TreeLinkNode f = new TreeLinkNode(6);
        TreeLinkNode g = new TreeLinkNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        c.left = g;*/








