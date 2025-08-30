import java.util.*;
public class Linkedlist {
    //creating nodes of the linkedlist
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
        }
    }
    //creating an user defined datatype, i.e, a linkedlist
    public static class linkedlist {
        Node head = null;
        Node tail = null;
        int size=0;
        //method to insert a new node at the end of the linked list
        void insertAtEnd(int val) {
            Node temp=new Node(val);
            if(head==null) {
                head=temp;
            } else {
                tail.next=temp;
            }
            tail=temp;
            size++;
        }
        //method to insert a new node at the beginning of the linked list
        void insertAtBeg(int val) {
            Node temp=new Node(val);
            if(head==null){
                head=tail=temp;
            } else {
                temp.next=head;
                head=temp;
            }
            size++;
        }
        //method to insert a node at any given index
        void insertAt(int idx, int val) {
            Node t=new Node(val);
            Node temp=head;
            if(idx==size) {
                insertAtEnd(val);
                return;
            } else if (idx==0) {
                insertAtBeg(val);
                return;
            } else if(idx<0 || idx>size) {
                System.out.println("Invalid index accessed");
                return;
            }
            for(int i=1;i<idx;i++){
                temp=temp.next;
            }
            t.next=temp.next;
            temp.next=t;
            size++;
        }
        //method to return the element at any given index of the linked list
        int getAt(int idx) {
            Node temp=head;
            for(int i=1;i<=idx;i++){
                temp=temp.next;
            }
            return temp.data;
        }
        //method to delete a node at any given index
        void deleteAt(int idx) {
            if(idx==0) {
                head=head.next;
                return;
            }
            Node temp=head;
            for(int i=1;i<idx;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            if(idx==size-1) {
                tail=temp;
            }
        }
        //method to display each node
        void display() {
            Node temp=head;
            while(temp!=null) {
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        linkedlist ll=new linkedlist();
        ll.insertAtEnd(4);
        ll.display();
        ll.insertAtEnd(5);
        ll.display();
        ll.insertAtEnd(12);
        ll.display();
        ll.insertAtBeg(1);
        ll.display();
        ll.insertAt(2,3);
        ll.display();
        ll.deleteAt(2);
        ll.display();
        
    }
}
