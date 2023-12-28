package com.ws.dataStructures;

/**
 * 自定义链表
 *
 * @author wangsen_a
 * @date 2023/12/27
 */
public class LinkedList {

    /**
     * 头节点
     */
    Node head;

    /**
     * 在链表末尾添加一个新节点
     *
     * @param data 数据
     */
    public void append(int data) {
        // 要插入的新节点
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        // 寻找链表中最后一个节点，从头节点开始
        Node last = head;
        // 如果最后一个节点的next不为null
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    /**
     * 头插法
     *
     * @param data 数据
     */
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

}
