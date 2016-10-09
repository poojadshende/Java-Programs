// Author : Pooja Shende
// Email-ID : poojadshende@gmail.com
// Title : Doubly Linked List

public class LinkedList
{
   private class Node 
   {
      // address type
      public Node next; 
      public Node prev; 
      public String value;

      /*
        parameterized constructor
        Input:value of the node object to be instantiated
      */
      Node(String value) 
      { 
         next=null;
         prev=null;
         this.value=value;
      }
   }

   public Node head;
   public Node tail;

   /* 
     default constructor
     Input:
   */
   LinkedList()   
   {
      head=null;
      tail=null;
   }

   /*
     Insert value at the begining of the list.
     Input:value of the node to be inserted
     Output:void
   */
   void insertFirst(String value) 
   {
      Node newNode=new Node(value);
      //empty list
      if(head==null) 
      {
         head=newNode;
         tail=newNode;
      }
      else
      {
         head.prev=newNode;
         newNode.next=head;
         head=head.prev;  // head=newNode;  both are correct
      }	
   }

   /*
     Insert value at the end of the list.
     Input:value of the node to be inserted
     Output:void
   */
   void insertLast(String value)
   {
      Node newNode=new Node(value);
      if(head==null)  
      {
         head=newNode;
         tail=newNode;
      }
      else if(head.next==null)
      {
         head.next=newNode;
         newNode.prev=head;
         tail=newNode;
      }
      else  
      {
         tail.next=newNode;
         newNode.prev=tail;
         newNode.next=null;
         tail=newNode;
      }
   }
  
   /*
     Insert value at required position in the list.
     Input:value of the node to be inserted, and required position of a node 
     Output:void
   */
   void insertMiddle(String value, int index)
   {
      Node newNode=new Node(value);
      int position=2;
      Node temp=head;
      while(position!=index)
      {
         temp=temp.next;
         position++;
      }
      newNode.prev=temp;
      newNode.next=temp.next;
      temp.next=newNode;
      newNode.next.prev=newNode;
   }

   /*
     Delete first element from the list.
     Input:value of the node to be deleted
     Output:void
   */
   void deleteFirst()
   {
      if(head==null)
      {
         System.out.println("List is empty");
      }
      else if(head.next==null)
      {
         head=null;
         tail=null;
      }
      else
      {
         head=head.next;
         head.prev.next=null;
         head.prev=null;
      }
   }

   /*
     Delete last element from the list.
     Input:value of the node to be deleted
     Output:void
   */
   void deleteLast()
   {
      if(head==null)
      {
         System.out.println("List is empty");
      }
      else if(head.next==null)
      {
         head=null;
         tail=null;
      }
      else
      {
  	 Node temp;
         temp=tail;
         tail=temp.prev;
         temp.prev.next=null;
         temp.prev=null;
      }
   }

   /*
     Delete node from the list by value. This function searches whether node
     is present in the list or not. If it is present then remove it from list.
     Input:value of the node to be deleted 
     Output:void
   */
   void deleteByValue(String Value)
   {
      Node temp=head;
         while(temp!=null)
         {
            if(!temp.value.equals(Value))
               temp=temp.next;
            else  
            {
               if(temp.next==null && temp.prev==null)
               {
                  temp=null;
                  head=null;
                  tail=null;
               }
               else if(temp.next!=null &&  temp.prev==null)
               { 
                  deleteFirst();
               }
               else if(temp.next==null && temp.prev!=null)
               {
                  deleteLast();
               }
               else
               {  
                  temp.prev.next=temp.next;
                  temp.next.prev=temp.prev;
                  temp.prev=null;
                  temp.next=null;
               }
               return;
            } 
         }// end of while loop
         System.out.println("Element is not present");
      
   }

   /*
     Check if the list is empty or not.
     Input:N/A
     Output:returns 1 for empty list and 0 for non empty list
   */
   int isEmpty()
   {
      if(head==null)  //tail==null ??
         return 1;     // empty
      else
         return 0;     // not empty
   }

   /*
     Print all elements present in the list.
     Input:N/A
     Output:void
   */
   void display()
   {
      Node temp;
      System.out.println("***List is below***");
      temp=head;
      for(temp=head; temp!=null; temp=temp.next) 
      {
         System.out.println(temp.value);
      }
   }

   /*
     Search whether the node is presnt or not.
     Input:value of the node to be searched
     Output:position of the node
   */
   int search(String Value)
   {
      Node temp=head;
      int position=1;
      while(temp!=null)
      {
         if(temp.value.equals(Value))
         {
            return position;
         }
         else
         {
            temp=temp.next;
            position++;
         }
      }
      return -1;
   }
}

