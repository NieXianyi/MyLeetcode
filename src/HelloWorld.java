import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        System.out.println(q.isEmpty());


    }
}

/*
第一步：底层会调用k的 hashcode()方法得出hash值,然后通过哈希算法，将哈希值转为数组的下标
如果下标中没有任何元素，返回null
如果说下标对应的位置上有链表(元素)，此时会着k和链表上毎一个结点中的进行 equals
    如果所有equals返回了false，那么返回null
    如果其中一个 equals返回了true，那么这个节点中的 value将会被返回
 */

/*
1. 先调用k的 hashcode l0方法得出hash值，通过哈希算法将哈希值转换为数组下标。 通过数组下标快速定位到某个位置上，如果这个位置上什么也没有，返回nul， 如果这个位置上单项链表，会章着k和進表上每一个结点中的κ进行 equals， 如果所有 equals方法返回的都是 false，那么getO方法返回nul1
如果其中ー个 equals返回了true，那么此时这个节点的 valuel就是我们要找的 Yalue get方法最终返回我们要找的这个 value。*/
/*
public void println(Object x) {
    String s = String.valueOf(x);
    synchronized (this) {
        print(s);
        newLine();
    }
}*/

/*public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
}*/

/*
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}*/
