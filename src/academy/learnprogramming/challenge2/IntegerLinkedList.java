package academy.learnprogramming.challenge2;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }
 //   private IntegerNode listNode()

    public IntegerNode BiggerValue(Integer value)
    {
        IntegerNode temp=head;
        while (temp.getNext().getValue()<=value) {
            temp=temp.getNext();
        }
        return temp;
    }

    public void insertSorted(Integer value) {

        // add your code here
        //if the list is empty
        //( if that is so just add the value as a head!
        IntegerNode node = new IntegerNode(value);
        IntegerNode current = head;
        if ((isEmpty()) || current.getValue() > node.getValue())  {
            addToFront(value);
        }

//       else if (current.getValue() <= value && current.getNext() == null) {
//            current.setNext(node);
//        }
       else {

            while (current != null && current.getValue() <= value) {
                if(current.getValue() > value ) {
                    IntegerNode temp = current.getNext();//something must have broken here!
                    IntegerNode temp1=current;
                    current.setNext(node);
                    node.setNext(temp1);
                  //  node.setNext(current);

                }

                if (current.getValue() < value && current.getNext()==null) {
                    current.setNext(node);
                }
                if(current.getValue() < value && current.getNext().getValue()>value  ) {
                    IntegerNode temp=current.getNext();
                    current.setNext(node);
                    node.setNext(temp);
                }
                current = current.getNext();

            }


        }


    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
