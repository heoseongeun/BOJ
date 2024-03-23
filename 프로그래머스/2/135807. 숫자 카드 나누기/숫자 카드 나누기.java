class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int n = arrayA.length;
        int a = arrayA[0], b = arrayB[0];
        for(int i = 1; i < n; i++) {
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }
        if(notDivisible(arrayB, a))
            if(answer < a)
                answer = a;
        if(notDivisible(arrayA, b))
            if(answer < b)
                answer = b;
        return answer;
    }
    
    public int gcd (int a, int b){
        if (a % b == 0) return b;
        else return gcd (b, a % b);
    }
    
    public boolean notDivisible(int[] arr, int num){
        for(int n : arr)
            if(n % num == 0) return false;
        return true;
    }
}