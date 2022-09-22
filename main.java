import java.util.Scanner;

class First_Programm {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      DOUBLE_LINKET_LIST<Integer> example = new DOUBLE_LINKET_LIST<Integer>();

      System.out.println("Enter count of numbers: ");
      int count = in.nextInt();
      System.out.println("Enter " + count + " values");
      int value;

      while (count != 0) {
         value = in.nextInt();
         example.addEnd(value);
         count--;
      }

      int chose = -1;
      do {
         Menu();
         chose = in.nextInt();

         switch (chose) {
            case 1: {
               System.out.println("Enter value: ");
               value = in.nextInt();
               example.addFront(value);
            }
               break;
            case 2: {
               System.out.println("Enter value: ");
               value = in.nextInt();
               example.addEnd(value);
            }
               break;
            case 3: {
               int flag;
               System.out.println("Enter value: ");
               value = in.nextInt();
               System.out.println("Enter flag: ");
               flag = in.nextInt();
               example.addBeforeValue(value, flag);
            }
               break;
            case 4: {
               int flag;
               System.out.println("Enter value: ");
               value = in.nextInt();
               System.out.println("Enter flag: ");
               flag = in.nextInt();
               example.addAfterValue(value, flag);
            }
               break;
            case 5: {
               System.out.println("Size is " + example.size());
            }
               break;
            case 6: {
               System.out.println("Enter value: ");
               value = in.nextInt();
               example.remove(value);
            }
               break;
            case 7: {
               example.clean();
            }
               break;
            case 8: {
               int place;
               System.out.println("Enter place: ");
               place = in.nextInt();
               value = example.search_value(place);
               System.out.println("Value on this place is " + value);
            }
               break;
            case 9: {
               example.print();
            }
               break;
         }
      } while (chose < 10);
      in.close();
   }

   public static void Menu() {
      System.out.println("1)Add to head");
      System.out.println("2)Add to tail");
      System.out.println("3)Add before");
      System.out.println("4)Add after");
      System.out.println("5)Size");
      System.out.println("6)Remove");
      System.out.println("7)Clean");
      System.out.println("8)Search value");
      System.out.println("9)Print");
      System.out.println("10)Exit");
      System.out.println("Enter your chose: ");
   }
}

class List<TYPE> {
   TYPE data;
   List<TYPE> next;
   List<TYPE> prev;

   List(TYPE _date) {
      data = _date;
      prev = null;
      next = null;
   }

   List(List<TYPE> before, TYPE _date, List<TYPE> after) {
      data = _date;
      prev = before;
      next = after;
   }
}

class DOUBLE_LINKET_LIST<ANY_TYPE> {
   private List<ANY_TYPE> head;
   private List<ANY_TYPE> tail;
   private int size;

   public DOUBLE_LINKET_LIST() {
      head = null;
      tail = null;
      size = 0;
   };

   public void addFront(ANY_TYPE value) {
      if (isEmpty()) {
         head = new List<ANY_TYPE>(value);
         tail = head;
      } else {
         List<ANY_TYPE> dop = head;
         head = new List<ANY_TYPE>(null, value, dop);
         head.next.prev = head;
      }
      size++;
   }

   public void addEnd(ANY_TYPE value) {
      if (isEmpty()) {
         tail = new List<ANY_TYPE>(value);
         head = tail;
      } else {
         List<ANY_TYPE> dop = tail;
         tail = new List<ANY_TYPE>(dop, value, null);
         tail.prev.next = tail;
      }
      size++;
   }

   public void addBeforeValue(ANY_TYPE insert_value, ANY_TYPE point_value) {
      List<ANY_TYPE> pointer = find(point_value);
      if (pointer != null) {
         if (pointer == head)
            addFront(insert_value);
         else {
            List<ANY_TYPE> new_node = new List<ANY_TYPE>(pointer.prev, insert_value, pointer);
            new_node.prev.next = new_node;
            pointer.prev = new_node;
            new_node = null;
            size++;
         }
      }
   }

   public void addAfterValue(ANY_TYPE insert_value, ANY_TYPE point_value) {
      List<ANY_TYPE> pointer = find(point_value);
      if (pointer != null) {
         if (pointer == tail)
            addEnd(insert_value);
         else {
            List<ANY_TYPE> new_node = new List<ANY_TYPE>(pointer, insert_value, pointer.next);
            new_node.next.prev = new_node;
            pointer.next = new_node;
            new_node = null;
            size++;
         }
      }
   }

   public List<ANY_TYPE> find(ANY_TYPE value) {
      boolean isReal = false;
      List<ANY_TYPE> flag = head;

      while (!isReal && flag != null) {
         if (flag.data == value)
            isReal = true;
         else
            flag = flag.next;
      }

      return flag;
   }

   protected void remove(ANY_TYPE value) {
      List<ANY_TYPE> place = find(value);

      if (place != null) {
         if (place == head)
            deleteFromHead();
         else {
            if (place == tail)
               deleteFromTail();
            else {
               List<ANY_TYPE> dop = place.prev;
               dop.next = place.next;
               dop.next.prev = dop;
               place.next = null;
               place.prev = null;
               size--;
            }
         }
      }
   }

   public void clean() {
      if (!isEmpty()) {
         while (head != null) {
            deleteFromTail();
         }
      }
   }

   private void deleteFromHead() {
      List<ANY_TYPE> dop = head;
      if (head == tail)
         tail = null;
      head = head.next;
      dop.next = null;
      head.prev = null;

      size--;
   }

   private void deleteFromTail() {
      List<ANY_TYPE> dop = tail;
      if (head == tail)
         head = null;
      tail = tail.prev;
      dop.prev = null;
      tail.next = null;
      size--;
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public ANY_TYPE search_value(int place) {
      List<ANY_TYPE> flag = null;

      if (!isEmpty() && place > 0 && place < size) {
         flag = head;
         while (place > 0) {
            flag = flag.next;
            place--;
         }
      }
      return flag.data;
   }

   public void print() {
      if (!isEmpty()) {
         List<ANY_TYPE> pointer = head;

         while (pointer != null) {
            System.out.print("Value: ");
            System.out.println(pointer.data);
            pointer = pointer.next;
         }
      }
   }

   public int size() {
      return size;
   }
}
