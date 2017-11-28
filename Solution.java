/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 吉彬
 */
import java.util.Stack;
/*
问题：
用两个栈来实现一个队列，完成队列的Push和Pop操作。 
队列中的元素为int类型。
*/

/*
解决思路：
用两个栈模拟一个队列，入队操作时将元素压入栈stack1，出队操作时从栈stack2中出栈。
在出栈时如果栈Stack2为空，则判断栈stack1是否为空。
若不为空将栈stack1中元素出栈并依次压入栈stack2中，然后从栈stack2中进行出栈操作已达到出队；
若栈stack1为空，则说明队列为空，可以抛出一个RuntimeException来提示调用者队列为空。
*/
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //入队放在stack1中操作
    public void push(int node) {
       stack1.push(node);
    }
    //出队在stack2中操作
    public int pop() {
        int number = 0;
        if(stack2.empty()){
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }
        if(stack2.empty())
            throw new RuntimeException("队列为空，无法进行出队操作！");
        else
            number = stack2.pop();
    return number;
    }
}
