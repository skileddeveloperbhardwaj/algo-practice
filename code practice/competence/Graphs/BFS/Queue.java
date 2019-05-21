package BFS;

public class Queue {

	static int MAX = 10000;
	int front;
	int rear;
	int[] nodeArr;

	public Queue() {
		front = -1;
		rear = -1;
		nodeArr = new int[MAX];
	}

	public void enQueue(int node) {
		if (rear >= MAX) {
			System.out.println("Queue overflow!!");
			return;
		}
		if (front == -1) {
			nodeArr[++front] = node;
			++rear;
		} else {
			nodeArr[++rear] = node;
		}
	}

	public int deQueue() {
		if (front == -1 || front > rear) {
			System.out.println("Queue underflow!!");
			return -1;
		}
		int node = nodeArr[front];
		nodeArr[front++] = -1;
		return node;
	}
	
	public boolean isEmpty() {
		if(front >=0 && front <= rear) {
			return false;
		}
		
		return true;
	}
}
