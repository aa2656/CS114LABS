public class Lab2 {

    public static void main(String args[]){
        pascalHelper(10);
    }

    public static void pascalHelper(int lineAmt) {
        for (int row = 0; row < (lineAmt); row++) {
            System.out.print(row+1 + ":");

            for (int col = 0; col <= row; col++) {
                System.out.print(pascal(row,col)+" ");
            }
            System.out.println("");
        }
    }
    private static int pascal(int row, int col){
        if(col==0||col==row){
            return 1;
        }else{
            return pascal(row-1,col-1)+pascal(row-1,col);
        }
    }
}