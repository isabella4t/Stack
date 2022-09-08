public class Stack {
    int[] bottom;
    private int ind = 0;

    //stub is method that doesn't do what it is supposed to do but can still run

    public Stack(int size){
        bottom = new int[size];
        ind = 0;
    }

    public boolean empty(){
        return getInd()==0;
    }

    public void push(int a) throws ArrayIndexOutOfBoundsException{
     //if(a >= bottom.length) throw (new ArrayIndexOutOfBoundsException("stack overflow " + a));
      bottom[ind++] = a;
    }

    public int pop() throws RuntimeException{
        //int temp = bottom[0];
        if(getInd() == 0) throw (new RuntimeException("Stack Underflow"));

        return bottom[--ind];
    }

    public int getInd(){
        return ind;
    }


}
