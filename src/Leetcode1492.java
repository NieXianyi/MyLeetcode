//除以2是因为，对于任意一个数  1，2，3，6 ; 2对应的因数必然在因数集里的倒数第二个；所有只遍历一半只会漏掉本身；
//最后特殊判断处理一下，当最终k=1的时候，题目就是要返回本身了

public class Leetcode1492 {
    public int kthFactor(int n, int k) {
        for(int i=1; i<=n/2 ; i++){
            if(n % i == 0) k--;
            if(k==0) return i;
        }
        return k==1? n :-1;
    }
}
