import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Test_List {
    private DOUBLE_LINKET_LIST<Integer> dll;

    @org.junit.Before
    public void setUp() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();
    }

    @Test
    public void test_size() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();

        int size = dll.size();

        dll.addFront(15);
        dll.addEnd(25);
        dll.addAfterValue(50, 25);
        dll.addBeforeValue(-10, 15);

        assertEquals(size+4, dll.size());
    }

    @Test
    public void test_add_front() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();
        dll.addFront(5);
        dll.addFront(15);
        dll.addFront(25);
        dll.addFront(35);
        dll.addFront(45);
        dll.addFront(55);
        dll.addFront(65);
        //65,55,45,35,25,15,5
        //0  1  2  3  4  5  6
        assertEquals(25, dll.search_value(4));
    }

    @Test
    public void test_add_end() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();
        dll.addEnd(5);
        dll.addEnd(15);
        dll.addEnd(25);
        dll.addEnd(35);
        dll.addEnd(45);
        dll.addEnd(55);
        dll.addEnd(65);
        //5,15,25,35,45,55,65
        //0 1  2  3  4  5  6
        assertEquals(45, dll.search_value(4));
    }

    @Test
    public void test_after_value() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();
        dll.addFront(10);
        dll.addAfterValue(20, 10);
        dll.addAfterValue(30, 20);
        dll.addAfterValue(15, 10);
        //10,15,20,30
        //0  1  2  3
        assertEquals(20, dll.search_value(2));
    }

    @Test
    public void test_before_value() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();
        dll.addFront(10);
        dll.addBeforeValue(20, 10);
        dll.addBeforeValue(30, 20);
        dll.addBeforeValue(15, 10);
        //30,20,15,10
        //0  1  2  3
        assertEquals(15, dll.search_value(2));
    }

    @Test
    public void test_remove_elem() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();

        dll.addEnd(5);
        dll.addEnd(15);
        dll.addEnd(25);
        dll.addFront(0);
        dll.addFront(-5);
        dll.addFront(-15);
        dll.addFront(-25);
        dll.addFront(-35);
        //-35,-25,-15,-5,0,5,15,25
        // 0    1   2  3 4 5  6  7
        dll.remove(0);
        //-35,-25,-15,-5,5,15,25
        // 0    1   2  3 4  5  6  

        assertEquals(-5, dll.search_value(3));
        assertEquals(5, dll.search_value(4));
    }

    @Test
    public void test_clean() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();
        DOUBLE_LINKET_LIST<Integer> pointer = dll;

        dll.addEnd(5);
        dll.addEnd(15);
        dll.addEnd(25);
        dll.addFront(0);
        dll.addFront(-5);
        dll.addFront(-15);
        dll.addFront(-25);
        dll.addFront(-35);

        assertEquals(pointer, dll);
    }

    @Test
    public void test_search_value() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();

        dll.addEnd(5);
        dll.addEnd(15);
        dll.addEnd(25);
        dll.addFront(0);
        dll.addFront(-5);
        dll.addFront(-15);
        dll.addFront(-25);
        dll.addFront(-35);
        //-35,-25,-15,-5,0,5,15,25
        // 0    1   2  3 4 5  6  7

        assertEquals(0, dll.search_value(4));
    }

    @Test
    public void test_is_empty() throws Exception{
        dll = new DOUBLE_LINKET_LIST<Integer>();
        assertEquals(true, dll.isEmpty());

        dll.addEnd(5);
        dll.addEnd(15);
        dll.addEnd(25);
        dll.addFront(0);
        dll.addFront(-5);
        dll.addFront(-15);
        dll.addFront(-25);
        dll.addFront(-35);

        assertEquals(false, dll.isEmpty());
    }
}
