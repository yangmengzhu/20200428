



public class TestDemo {
    //合并两个有序链表
    public Node mergeTwoLists(Node headA,Node headB){
       Node newHead=new Node(-1);
       Node tmp=newHead;
       while(headA!=null && headB!=null){
           if(headA.data<headB.data){
              tmp.next=headA;
              tmp=tmp.next;
              headA=headA.next;
           }else{
               tmp.next=headB;
               tmp=tmp.next;
               headB=headB.next;
           }
       }
       if(headA==null){
           tmp.next=headB;
       }else{
           tmp.next=headA;
       }
       return newHead.next;
    }
    //编写一个程序，找到两个单链表相交的起始节点
    public Node getIntersectionNode(Node headA,Node headB){
      int lenA=0;
      int lenB=0;
      Node pl=headA;
      Node ps=headB;

      while(pl!=null){
          lenA++;
          pl=pl.next;
      }
      while(ps!=null){
          lenB++;
          ps=ps.next;
      }
      pl=headA;
      ps=headB;
      int len=lenA-lenB;
      if(len<0){
          pl=headB;
          ps=headA;
          len=lenB-lenA;
      }
      while(len>0){
          pl=pl.next;
          len--;
      }
      while(ps!=pl && ps!=null && pl!=null){
          pl=pl.next;
          ps=ps.next;
      }
      if(ps==pl && pl!=null){
          return ps;
      }
      return null;
    }
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        /*list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.display();*/
        list.addLast(2);
        list.addLast(2);
        list.addLast(2);
        list.addLast(5);
        list.addLast(2);
       // list.display();
       // System.out.println(list.size());
       // list.addIndex(0, 3);
        //list.addIndex(2,9);
        //list.addIndex(3,10);
        //list.display();
        //System.out.println(list.contains(2));
        /*list.remove(5);
        list.display();*/
        /*list.removeAllKey(2);
        list.display();*/
        //list.clear();
        //System.out.println(list.countNode(6).data);
        //System.out.println(list.middleNode().data);
        //Node ret=list.reverse();
        //list.display2(ret);
        list.removeAllVal(2);
        list.display();
    }

    //将两个有序链表拼接起来返回新链表
    /*public static Node mergeTwoLists(Node headA,Node headB){
        Node newHead=new Node(-1);
        Node tmp=newHead;
        while(headA!=null && headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                tmp=tmp.next;
                headA=headA.next;
            }else{
                tmp.next=headB;
                tmp=tmp.next;
                headB=headB.next;
            }
        }
        if(headA==null){
            tmp.next=headB;
        }
        if(headB==null){
            tmp.next=headA;
        }
        return newHead.next;
    }
    public static Node getSize(Node headA,Node headB){
        //先求两个单链表的长度
        Node pl=headA;
        Node ps=headB;
        int lenA=0;
        int lenB=0;
        while(pl!=null){
            lenA++;
            pl=pl.next;
        }
        while(ps!=null){
            lenB++;
            ps=ps.next;
        }
        pl=headA;
        ps=headB;
        int len=lenA-lenB;
        if(len<0){
            pl=headB;
            ps=headA;
            len=lenB-lenA;
        }
        //pl肯定指向最长的链表，让pl向前走len步
        for (int i = 0; i <len ; i++) {
            pl=pl.next;
        }
        //ps和pl一定在同一起跑线上
        while(ps!=pl && ps!=null && pl!=null){
            pl=pl.next;
            ps=ps.next;
        }
        if(ps==pl && pl!=null){
            return pl;
        }
        return null;
    }
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        *//*list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.display();*//*
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(4);
        list.addLast(2);
        *//*Node ret=list.Partion(12);
        list.display2(ret);*//*
        *//*list.remove(3);
        list.display();*//*
        *//*list.removeAll(2);
        list.display();*//*
        *//*Node ret=list.reverse();
        list.display2(ret);*//*
        //System.out.println(list.middleNode().data);
        //System.out.println(list.count(2).data);
        Node ret=list.delrepeat();
        list.display2(ret);
        //MyLinkedList.mergeTwoLists(MyLinkedList.head,MyLinkedList.head);
    }
*/

}
