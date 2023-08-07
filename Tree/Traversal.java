import java.util.*;
class Node
{
        int data;
        Node left;
        Node right;
        
        Node(int data)
        {
           this.data = data;
        }
}
class Main  
{                
        static Node head;
        public static void main(String args[])
        {       
                int arr[]={8,4,3,5,10,9};
                for(int  i : arr)
                {
                      add(i);
                }
                traverse(head);
		System.out.println();
		//levelOrder();
		//traverseNonRecursive();
		//traversePreOrderNonRecursive();
		MorriceTraversal();
        }          
        public static void add(int data) 
        {       
                if(head == null)
                {       
                        head = new Node(data);    
                }       
                else
                {       
                        add(head,data);
                }
        }
        public static Node add(Node current, int data)
        {       
                if(current == null)
                {       
                        return new Node(data);
                }
                
                if(current.data > data)
                {       
                        current.left = add(current.left,data); 
                }
                else                 
                {       
                        current.right = add(current.right, data);
                }
                return current;
        }       
        public static void traverse(Node current)
        {       
                if(current == null)
                {       
                        return ;    
                }
		//System.out.print(current.data+ " ");
                traverse(current.left);
                System.out.print(current.data+ " ");
                traverse(current.right);
		//System.out.print(current.data+ " ");
        }
	public static void levelOrder()
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while(queue.size() > 0)
		{
			int tsize = queue.size();
			for(int i =0;i<tsize;i++)
			{
				Node temp = queue.remove();
				if(temp.left != null)
				{
					queue.add(temp.left);
				}
				if(temp.right != null)
				{
					queue.add(temp.right);
				}
				System.out.print(temp.data +" ");
			}
			System.out.println();
		}
	}

	public static void traverseNonRecursive()
	{
		Stack<Node> stack = new Stack<>();
		Node temp = head;	
		while(temp != null || stack.size() > 0)
		{
			while(temp != null)
			{
				System.out.print(temp.data+" ");
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			//System.out.print(temp.data+" ");
			temp = temp.right;
		}
	}
	public static void traversePreOrderNonRecursive()
	{
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		stack1.push(head);
		while(stack1.size() > 0)
		{
			Node temp = stack1.pop();
			stack2.push(temp);
			if(temp.left != null)
			{
				stack1.push(temp.left);
			}
			if(temp.right != null)
			{
				stack1.push(temp.right);
			}
		}

		while(stack2.size() > 0)
		{
			System.out.print(stack2.pop().data+" ");
		}
	}
	public static void MorriceTraversal()
	{
		Node current = head;
		while(current != null)
		{
			if(current.left == null)
			{
				System.out.print(current.data +" ");
				current = current.right;
			}
			else
			{
				Node prev = current.left;
				while(prev.right != null && prev.right != current)
				{
					prev = prev.right;
				}
				if(prev.right == null)
				{
					prev.right = current;
					System.out.print(current.data+" ");
					current = current.left;
				}
				else
				{
					prev.right = null;
					current = current.right;
					
				}

			}
		}
	}

}
