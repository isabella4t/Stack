import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.*;

public class Main {
    //First in last out
    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    static int pass =0;
    static int fail =0;

    public static void main(String[] args){

        testConstruct();
        testPush();
        testPopPush();
        testPopEmpty();
        testPopPop();
        testPushOver();
        testPushLim();

        System.out.print("Pass: " + pass + " Fail: " + fail);
    }
    public static void testConstruct(){
        Stack ne = new Stack(5);
        if(ne.empty()) pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed construction");
        }
    }
    public static void testPush(){
        Stack ne = new Stack(5);
        ne.push(31);
        if(!ne.empty()) pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed Push, expected not empty got empty");
        }
        int actual = ne.pop();
        if(actual==31)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed Push, expected 3  =didn't get 3");
        }

    }
    public static void testPopPush(){
        Stack ne = new Stack(5);
        ne.push(1);
        ne.push(2);
        int act = ne.pop();
        int expected = 2;
        int actual = ne.pop();
        if(act==expected)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed Push, expected "+ expected + " got " + act);
        }
        ne.push(3);
        ne.push(4);
        act = ne.pop();
        expected = 4;
        if(act==expected)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed Push, expected "+ expected + " got " + act);
        }


    } //
    public static void testPopEmpty(){
        Stack ne = new Stack(5);
        boolean hadEx = false;
        try{
            ne.pop();
        }
        catch (RuntimeException e){
            pass++;
            hadEx = true;
        }
        if(!hadEx){
            fail++;
            LOGGER.log(Level.WARNING,"failed PopEmpty, it didn't break :(");
        }
    } // pop when empty
    public static void testPopPop(){
        Stack ne = new Stack(3);
        ne.push(3);
        ne.push(3);
        ne.push(3);
        boolean hadEx = false;
        try{
            ne.pop();
            ne.pop();
            ne.pop();
            ne.pop();
            ne.pop();
            ne.pop();
        }
        catch (RuntimeException e){
            pass++;
            hadEx = true;
        }
        if(!hadEx){
            fail++;
            LOGGER.log(Level.WARNING,"failed PopEmpty, it didn't break :(");
        }



    } // pops too much
    public static void testPushOver(){
        Stack ne = new Stack(1);
        boolean hadEx = false;
        try{
            ne.push(7);
            ne.push(7);
            ne.push(7);
            ne.push(7);
        }
        catch (ArrayIndexOutOfBoundsException e){
            pass++;
            hadEx = true;
        }
        if(!hadEx){
            fail++;
            LOGGER.log(Level.WARNING,"failed PushOver, it didn't break :(");
        }
    } // pushes too much
    public static void testPushLim(){
        Stack ne = new Stack(4);
        boolean hadEx = false;
        try{
            ne.push(7);
            ne.push(7);
            ne.push(7);
            ne.push(7);
        }
        catch (ArrayIndexOutOfBoundsException e){
            fail++;
            LOGGER.log(Level.WARNING,"failed PushLimit, it went out of bounds");
            hadEx = true;
        }
        if(!hadEx){
            pass++;
        }
    } // pushes to the limit

    /*
    public static void testPopWrong(){
        Stack ne = new Stack(1);
        ne.push(4);
        if(ne.pop()!=3)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed pop2");
        }

    } // should fail
    public static boolean testConstruct(){
        Stack ne = new Stack(5);
        return(ne.empty());
    }

    public static boolean testpush1(){
        Stack ne = new Stack(1);
        ne.push(7);
        return (ne.getVal()==7);
    }

    public static boolean testpush2(){
        Stack ne = new Stack(1);
        ne.push(2);
        return (ne.getVal()==7);
    }

    public static boolean testpush3(){
        Stack ne = new Stack(1);
        ne.push(7);
        ne.push(7);
        return (ne.getVal()==7);
    }

 */
}
