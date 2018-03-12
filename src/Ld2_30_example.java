    /*
     *  Java Program to Implement Sorted Circular Singly Linked List
     */

    import java.util.Scanner;

    /*  Class Node  */
    class NodeEx {
        protected int data;
        protected NodeEx link;

        /*  Constructor  */
        public NodeEx(){
            link = null;
            data = 0;
        }

        /*  Constructor  */
        public NodeEx(int d, NodeEx n){
            data = d;
            link = n;
        }

        /*  Function to set link to next Node  */
        public void setLink(NodeEx n){
            link = n;
        }

        /*  Function to set data to current Node  */
        public void setData(int d){
            data = d;
        }

        /*  Function to get link to next node  */
        public NodeEx getLink(){
            return link;
        }

        /*  Function to get data from current Node  */
        public int getData(){
            return data;
        }
    }

    class linkedList{
        protected NodeEx start, end;
        public int size;
        public linkedList(){
            start = null;
            end = null;
            size = 0;
        }

        /*  Function to check if list is empty  */
        public boolean isEmpty(){
            return start == null;
        }

        /*  Function to check size of list  */
        public int getSize(){
            return size;
        }

        /*  Function to insert an element  */
        public void insert(int val){
            NodeEx nptr, ptr, tmp = null;
            nptr = new NodeEx(val, null);
            boolean ins = false;
            if (start == null){
                start = nptr;
                nptr.setLink(start);
                end = start;
            }
            else if (val <= start.getData()){
                nptr.setLink(start);
                end.setLink(nptr);
                start = nptr;
            }
            else if (val >= end.getData()){
                end.setLink(nptr);
                nptr.setLink(start);
                end = nptr;
            }
            else{
                tmp = start;
                ptr = start.getLink();
                while (tmp != end){
                    if (val >= tmp.getData() && val <= ptr.getData()){
                        tmp.setLink(nptr);
                        nptr.setLink(ptr);
                        ins = true;
                        break;
                    }
                    else{
                        tmp = ptr;
                        ptr = ptr.getLink();
                    }
                }
                if (!ins){
                    tmp.setLink(nptr);
                }
            }
            size++;
        }

        /*  Function to delete an element at position  */
        public void deleteAtPos(int pos){
            if (pos == 1 && size == 1){
                start = null;
                end = null;
                size = 0;
                return;
            }
            if (pos == 1){
                start = start.getLink();
                end.setLink(start);
                size--;
                return ;
            }
            if (pos == size){
                NodeEx ptr = start;
                for (int i = 1; i < size - 1; i++)
                    ptr = ptr.getLink();
                ptr.setLink(start);
                end = ptr;
                size --;
                return;
            }
            NodeEx ptr = start;
            pos = pos - 1 ;
            for (int i = 1; i < size - 1; i++){
                if (i == pos){
                    NodeEx tmp = ptr.getLink();
                    tmp = tmp.getLink();
                    ptr.setLink(tmp);
                    break;
                }
                ptr = ptr.getLink();
            }
            size-- ;
        }

        /*  Function to display elements  */
        public void display(){
            System.out.print("Sorted Circular Singly Linked List = ");
            NodeEx ptr = start;
            if (size == 0){
                System.out.print("empty\n");
                return;
            }
            if (start.getLink() == start){
                System.out.print(start.getData()+ "->"+ptr.getData()+ "\n");
                return;
            }
            System.out.print(start.getData()+ "->");
            ptr = start.getLink();
            while (ptr.getLink() != start){
                System.out.print(ptr.getData()+ "->");
                ptr = ptr.getLink();
            }
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
            System.out.print(ptr.getData()+ "\n");
        }
    }

    public class Ld2_30_example {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            linkedList list = new linkedList();
            System.out.println("Sorted Circular Singly Linked List Test\n");
            char ch;

            /*  Perform list operations  */
            do{
                System.out.println("\nSorted Circular Singly Linked List Operations\n");
                System.out.println("1. insert");
                System.out.println("2. delete at position");
                System.out.println("3. check empty");
                System.out.println("4. get size");

                int choice = scan.nextInt();
                switch (choice){
                    case 1 :
                        System.out.println("Enter integer element to insert");
                        list.insert( scan.nextInt() );
                        break;
                    case 2 :
                        System.out.println("Enter position");
                        int p = scan.nextInt() ;
                        if (p < 1 || p > list.getSize() )
                            System.out.println("Invalid position\n");
                        else
                            list.deleteAtPos(p);
                        break;
                    case 3 :
                        System.out.println("Empty status = "+ list.isEmpty()+"\n");
                        break;
                    case 4 :
                        System.out.println("Size = "+ list.getSize() +" \n");
                        break;
                    default :
                        System.out.println("Wrong Entry \n ");
                        break;
                }

                /*  Display List  */
                list.display();
                System.out.println("\nDo you want to continue (Type y or n) \n");
                ch = scan.next().charAt(0);
            } while (ch == 'Y'|| ch == 'y');
            scan.close();
        }
    }