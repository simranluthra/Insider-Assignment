import java.util.*;  

public class hundredPrimeNumber{

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of prime numbers you want: ");  
        int N = sc.nextInt();       //Assuming N is the number of prime numbers user want.
                                    //Enter N=100 to get 1st 100 prime numbers

        int i,b=0,j,count=0;

        if(N>0){
            for(j=2;;j++){
                for(i=2;i<j;i++){
                    if(j%i==0){
                        b = 1;
                        break;
                    }
                
                }
                if(b==0){
                    System.out.print(j + "\n");  
                    count = count + 1;
                    if(count == N){
                        break;
                    }
                }
                b=0;
            }
        }
    }
}
