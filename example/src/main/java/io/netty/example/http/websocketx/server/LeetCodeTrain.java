package io.netty.example.http.websocketx.server;

public class LeetCodeTrain {

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {9,9};
        ListNode l1 = toNode(a);
        ListNode l2 = toNode(b);
        ListNode node = add(l1, l2, 0);
        System.out.println();
    }

    static ListNode re = null;

    static ListNode add(ListNode l1, ListNode l2, int i){

        if(l1 == null && l2 == null && i == 0){
            return null;
        }

        int j = 0;

        if(l1 != null){
            j = j + l1.val;
        }

        if(l2 != null){
            j = j + l2.val;
        }

        if(i != 0){
            j++;
        }

        if(l1 != null || l2 != null){
            add(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, j >= 10 ? 1 : 0);
        }

        ListNode node = new ListNode(j >= 10 ? j - 10 : j);
        node.next = re;
        re = node;

        return re;
    }

    //------------------------------------------------------
//    static int mid;
//    static int pos;
//    static int length;
//    static boolean y = false;
//
//    static void deleteMid(ListNode n){
//        length++;
//        if(null != n.next){
//            deleteMid(n.next);
//        }else{
//            pos = length;
//            mid = length/2-1;
//        }
//
//        if(y){
//            return;
//        }else{
//            if(pos != length){
//                if(--pos == mid-1){
//                    y = true;
//                    n.next = n.next.next;
//                }
//            }else {
//                --pos;
//            }
//        }
//
//    }

    //------------------------------------------------------
    static ListNode removeDup(ListNode head){
        int[] x = new int[127];
        x[head.val] = 1;
        ListNode n = head;
        while(null != n.next){
            if(x[n.next.val] == 1){
                n.next = n.next.next;
            }else{
                x[n.next.val] = 1;
                n = n.next;
            }
        }
        return head;
    }

    //------------------------------------------------------
    static ListNode toNode(int[] a){
        ListNode next = null;
        for (int i = a.length-1; i >= 0; i--) {
            ListNode listNode = new ListNode(a[i]);
            listNode.next = next;
            next = listNode;
        }
        return next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //------------------------------------------------------
    static boolean check(String first, String second){
        if(first.length()==0 || second.length()==0){
            if(first.length()==0 && second.length()==0){
                return true;
            }else if(first.length() == 0 && second.length() == 1){
                return true;
            }else if(second.length() == 0 && first.length() == 1){
                return true;
            }
            return false;
        }

        int i=0,j=0,count=0;
        do{
            if(first.charAt(i) == second.charAt(j)){
                i++;j++;
            }else{
                count++;
                if(count>1){
                    return false;
                }
                if(first.length()>second.length()){
                    i++;
                }else if(first.length()<second.length()){
                    j++;
                }else{
                    i++;j++;
                }
            }
        }while(i<first.length()&&j<second.length());
        if((i==(first.length())&&j==(second.length())))
            return true;
        if (count == 0 && (Math.abs(first.length()-second.length()) == 1))
            return true;
        return false;
    }
}
