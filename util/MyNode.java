package util;

public class MyNode {
	private int value;
	private MyNode next;
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public MyNode getNext(){
		return this.next;
	}

	public void setNext(MyNode node){
		this.next = node;
	}
}
