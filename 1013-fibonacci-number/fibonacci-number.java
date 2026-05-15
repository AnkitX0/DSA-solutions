class Solution {
    public int fib(int n) {
      
    //   int a = 0;
    //   int b = 1;

    //   for(int i = 0; i < n; i++){
    //         int c = b;
    //          b = a+b;
    //          a = c;
    //   }
    //   return a;
    
        if( n == 0) return 0;
        if( n== 1) return 1;

        return fib(n-1) + fib(n-2);

    }
}