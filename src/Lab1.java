public class Lab1 {
    public static void main(String [] args){
        int facNum,sumNum,powNum, powpowNum;

        facNum=sumNum= 5;
        powNum=5;
        powpowNum=2;

        System.out.println("Factorial of "+ facNum+" is: "+factorial(facNum));
        System.out.println("Summation of "+sumNum+" is: "+summation(sumNum));
        System.out.println(powNum+" to the power of "+ powpowNum + " is: " + power(powNum, powpowNum));
    }

    public static int factorial(int number){
        if(number<=1){
            return 1;
        }else{
            return number * factorial(number-1);
        }
    }

    public static int summation(int number){
        if(number<=1){
            return 1;
        }else{
            return number + summation(number-1);
        }
    }

    public static int power(int x, int n){
        if(n<=0){
            return 1;
        }else{
            return x * power(x,n-1);
        }
    }
}
