/*
 * @program: 20200424
 * @description
 * @author: mrs.yang
 * @create: 2020 -04 -24 16 :42
 */

//实现单链表（不带头节点）

class Node {
    public int data;
    public Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class MyLinkedList{
    public Node head;
    //头插法
    public void addFirst(int data){
        Node node =new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }
        node.next=this.head;
        this.head=node;
    }
    //打印链表
    public void display(){
        Node cur=this.head;
       while(cur!=null) {
           System.out.print(cur.data+" ");
           cur=cur.next;
        }
        System.out.println();
    }
    //尾插法
    public void addLast(int data){
        Node node =new Node(data);
        Node cur=this.head;
        if(this.head==null){
            this.head=node;
            return;
        }
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    //求单链表长度
    public int size(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    private Node searchIndex(int index){
        Node cur=this.head;
        if(this.head==null){
            return null;
        }
        while(index-1!=0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    //index位置插入data
    public void addIndex(int index, int data){
        Node node=new Node(data);
        if(index==0) {
            addFirst(data);
            return;
        }
        if(index==this.size()){
            addLast(data);
            return;
        }
        Node prev=searchIndex(index);
        if(prev==null){
            return;
        }
        node.next=prev.next;
        prev.next=node;
    }
    //查找是否包含关键字key
    public boolean contains(int key){
        Node cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    private Node searchPrev(int key){
        Node prev=this.head;
        if(this.head==null){
            return null;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        while(prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }
    //删除第一次出现关键字key的节点
    public void remove(int key){
        Node prev=searchPrev(key);
        if(prev==null){
            return;
        }
        Node del=prev.next;
        prev.next=del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node cur = this.head.next;
        Node prev = this.head;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
            if (this.head.data == key) {
                this.head = this.head.next;
            }
        }
    }
    //清除
    public void clear(){
        this.head=null;
    }
    //给定一个链表，判断链表中是否有环
    public boolean iscrycle(){
        Node fast=this.head;
        Node slow=this.head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public Node detectCycle(){
        Node fast=this.head;
        Node slow=this.head;
        //先找到两个相遇的节点位置
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null|| fast.next==null){
            return null;

        }
        slow=this.head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //输入一个链表，输出该链表中倒数第k个结点
    public Node  countNode(int key){
        Node slow=this.head;
        Node fast=this.head;
        //判断KEY是否合法
        if(key<=0){
            return null;
        }
        while(key-1>0){
            if(fast.next!=null){
                fast=fast.next;
                key--;
            }else{
                return null;
            }
        }
        while(fast.next!=null ){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    //返回链表的中间结点
    public Node middleNode() {
        Node slow = this.head;
        Node fast = this.head;
        if (this.head == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //反转一个单链表
    public Node reverse(){
       Node cur=this.head;
       Node newHead=null;
       Node prev=null;
       while(cur!=null){
           Node curNext=cur.next;
           if(curNext==null){
               newHead=cur;
           }
           cur.next=prev;
           prev=cur;
           cur=curNext;
       }
       return newHead;
    }
    public void display2(Node newHead){
        Node cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //删除链表中等于给定值 val的所有节点
    public void removeAllVal(int val) {
        Node cur = this.head.next;
        Node prev = this.head;
        while (cur != null) {
            if (cur.data == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == val) {
            this.head = this.head.next;
        }

    }
    //删除所有出现key的节点
    public void removeAll(int key){
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    public Node reSort(int x){
        Node bs=null;
        Node be=null;
        Node as=null;
        Node ae=null;
        Node cur=this.head;
        while(cur!=null){
            if(cur.data<x){
                if(bs==null){
                    bs=cur;
                    be=cur;
                }else{
                   be.next=cur;
                   be=be.next;
                }
            }else{//不小于X
                if(as==null){
                    as=cur;
                    ae=cur;
                }else{
                    ae.next=cur;
                    ae=ae.next;
                }
            }
            cur=cur.next;
        }
        if(bs==null){
            return as;
        }else{
            be.next=as;
        }
        if(as!=null){
            ae.next=null;
        }
        return bs;
    }
    //判断链表是否是回文结构
    public boolean chkPalindrome(){
        //链表为空的时候
        if(this.head==null){
            return false;
        }
        //只有一个头节点的情况
       if(this.head.next==null){
           return true;
       }
        Node slow=this.head;
        Node fast=this.head;
        //先找到中间节点的位置
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //反转链表的后半部分
        Node cur=slow.next;
        while(cur!=null){
            Node curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //一个从头走head，一个从尾走slow
        while(slow!=this.head){
            if(slow.data!=this.head.data){
                return false;
            }
             if(this.head.next==slow){
                    return true;
            }
            slow=slow.next;
            this.head=this.head.next;
        }
        return true;
    }
    //删除链表的重复节点
    public Node delMulNode(){
         Node cur=this.head;
         Node newHead=new Node(-1);
         Node tmp=newHead;
         if(this.head==null){
             return null;
         }
         while(cur!=null){
             if(cur.next!=null && cur.data==cur.next.data){
                 while(cur.next!=null && cur.data==cur.next.data){
                     cur=cur.next;
                 }
                 cur=cur.next;
             }else{
                 tmp.next=cur;
                 tmp=tmp.next;
                 cur=cur.next;
             }
         }
         tmp.next=null;
         return newHead.next;
    }
}



/*
class Node{
    public Node next;
    public int data;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class MyLinkedList {
  public Node head;
  //头插法
    public void addFirst(int data){
        Node node =new Node(data);
        //第一次插入节点
        if(this.head==null){
            this.head=node;
            return;
        }
        node.next=this.head;
        this.head=node;
    }
    //打印单链表
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        Node cur=this.head;
        if(this.head==null){
            this.head=node;
            return;
        }
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    //以x为基准
    public Node Partion(int x){
        Node bs=null;
        Node be=null;
        Node as=null;
        Node ae=null;
        Node cur=this.head;
        while(cur!=null){
            if(cur.data>=x){
                if(as==null){
                    as=cur;
                    ae=cur;
                }else{
                    ae.next=cur;
                    ae=cur;
                }
            }else{
                if(bs==null){
                    bs=cur;
                    be=cur;
                }else{
                    be.next=cur;
                    be=cur;
                }
            }
            cur=cur.next;
        }
        if(bs==null){
            return as;
        }
        be.next = as;
        if(as!=null){
            ae.next = null;
        }
        return bs;
    }
    //d打印
    public void display2(Node newHead){
        Node cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    //有序链表删除重复节点
    public Node deleteMulNode() {
        Node cur = this.head;
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while ( cur != null) {
            if (cur.next!=null && cur.data == cur.next.data) {
                while ( cur.next!=null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur=cur.next;
            } else {
                tmp.next = cur;
                tmp = cur;
                cur = cur.next;
            }
        }
        tmp.next=null;
        return newHead.next;
    }
    private Node searchPrev(int key){
        Node prev=this.head;
        while(prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }
    //删除第一次出现的关键字key
    public void remove(int key){
        if(this.head==null){
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
        Node prev=searchPrev(key);
        if(prev==null){
            return;
        }
        Node del=prev.next;
        prev.next=del.next;
    }

    //实现链表逆置返回头节点
   public Node reverse(){
        Node newHead=null;
        Node prev=null;
        Node cur=this.head;
        if(this.head==null){
            return null;
        }
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
   }
   //找到中间节点
    public Node middleNode(){
        Node slow=this.head;
        Node fast=this.head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
  //倒数第key个节点
    public Node count(int key){
        Node fast=this.head;
        Node slow=this.head;
        if(this.head==null){
            return null;
        }
        if(key<=0){
            throw new RuntimeException("key位置不合法");
        }
        while(key-1!=0){
            fast=fast.next;
            key--;
        }
        while(fast.next!=null){
            if(slow.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }
        return slow;
    }
    //有序链表删除重复节点
    public Node delrepeat(){
        Node cur=this.head;
        Node newHead=new Node(-1);
        Node tmp=newHead;
        if(this.head==null){
            return null;
        }
        while(cur!=null){
            if(cur.next!=null && cur.data==cur.next.data){
                while(cur.next!=null && cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next=null;
        return newHead.next;
    }
}
*/
