//reversing technique
//first reverse from left now we will have two linkedlist 
// 1. now check wheather they are same and for thier neigbhour also 
// 2. if they are even so 2*count
// 3. else 2*count+1 
class GfG
{
        public static int  countCommon(Node a,Node b){
            int count=0;
            while(a!=null && b!=null){
                if(a.data==b.data) count++;
                else break;
                a=a.next;
                b=b.next;
            }
            return count;
        }
        public static int maxPalindrome(Node head)
        {
          //add code here.
          Node curr = head;
          Node prev = null;
          Node forw = null;
          int result=0;
          while(curr!=null){
              forw = curr.next;
              curr.next = prev;
              
              //for odd palindrome substring
              result=Math.max(result, 2*countCommon(prev,forw)+1);
              
              //for even palindrome substring
              result=Math.max(result, 2*countCommon(curr,forw));
              
              prev = curr;
              curr = forw;
          }
          return result;
          
        }
}
