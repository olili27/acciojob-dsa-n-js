public class Spiral {
    public static void main(String[] args) {
        
    }
    
    static void spiralPrint(int m, int n, int arr[][]){     int i,k=0,l=0;          while(k<m && l<n){         //print the first row onwards         
        for(i=1;i<n;i++){             System.out.println(arr[k][i] + " ");         
    }         
    k++;                 
     //print the last column onwards         
     for(i=k;i<m;i++){             
        System.out.println(arr[i][n-1]+" ");         
    }        
     n--;                 
      //print remaining rows         
      if(k<m){             
        for(i=n-1;i>=1;i++){                
            System.out.println(arr[m-1][i]+" ");            
         }             
         m--;        
         }                  //print remaining columns         
         if(l<n){            
             for(i=m-1;i>=k;i++){              
                   System.out.println(arr[i][l]+" ");            
                 }            
                  i++;         
                }    
             } 
            }
}
