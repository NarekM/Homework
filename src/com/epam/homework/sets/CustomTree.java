package com.epam.homework.sets;

import java.util.Iterator;
import java.util.Stack;

public class CustomTree<T extends Comparable<T>> implements Iterable<T> {
    private int size;
    private Node<T> root;
    private Node<T> current;

    public int getSize() {
        return size;
    }

    public boolean add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Can not contain null value");
        }
        Node<T> node = new Node<>(item, null, null, null);
        if (root == null) {
            root = node;
            return true;
        }
        return addNode(node, root);
    }

    private boolean addNode(Node<T> node, Node<T> searchInNode) {
        if (node == null) {
            throw new IllegalArgumentException();
        } else if (searchInNode == null) {
            searchInNode = node;
        } else if (node.getValue().compareTo(searchInNode.getValue()) < 0) {
            if (searchInNode.getLeft() == null) {
                searchInNode.setLeft(node);
                node.setParent(searchInNode);
            } else {
                addNode(node, searchInNode.getLeft());
            }
        } else if (node.getValue().compareTo(searchInNode.getValue()) > 0) {
            if (searchInNode.getRight() == null) {
                searchInNode.setRight(node);
                node.setParent(searchInNode);
            } else {
                addNode(node, searchInNode.getRight());
            }
        } else {
            return false;
        }
        size++;
        return true;
    }

    public boolean contains(T item) {
        return contains(item, root);
    }

    private boolean contains(T item, Node<T> searchedInNode) {
        if (item == null) {
            throw new IllegalArgumentException("Can not contain null value");
        }
        if (searchedInNode == null) {
            return false;
        } else if (item.compareTo(searchedInNode.getValue()) < 0) {
            return contains(item, searchedInNode.getLeft());
        } else if (item.compareTo(searchedInNode.getValue()) > 0) {
            return contains(item, searchedInNode.getRight());
        } else {
            return true;
        }
    }

    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> rootNode) {
        if (rootNode == null) {
            return;
        }
        traverseInOrder(rootNode.getLeft());
        System.out.println(rootNode.getValue());
        traverseInOrder(rootNode.getRight());
    }

//    private void traverseInOrder(Node<T> rootNode) {
//        Stack<Node<T>> stack = new Stack<>();
//        if (rootNode == null) {
//            return;
//        }
//        Node<T> tempNode = rootNode;
//        while (!stack.empty() || tempNode != null) {
//            if (tempNode != null) {
//                stack.push(tempNode);
//                tempNode = tempNode.getLeft();
//            } else {
//                tempNode = stack.pop();
//                System.out.println(tempNode.getValue());
//                tempNode = tempNode.getRight();
//            }
//        }
//    }




    @Override
    public Iterator<T> iterator() {
        Node<T> mostLeftNode = root;
        while (mostLeftNode.getLeft() != null) {
            mostLeftNode = mostLeftNode.getLeft();
        }
        Node<T> currentNode = mostLeftNode;

        return new Iterator<T>() {
            private Stack<Node<T>> stack = new Stack<>();

            {
                fillStackWithLefts(root);
            }

            private Node<T> findMostLeft(Node<T> rootNode) {
                if (rootNode != null) {
                    while (rootNode.getLeft() != null) {
                        rootNode = rootNode.getLeft();
                    }
                }
                return rootNode;
            }

            private void fillStackWithLefts(Node<T> rootNode) {
                if (rootNode != null){
                    stack.push(rootNode);
                    fillStackWithLefts(rootNode.getLeft());
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.empty();
            }

            @Override
            public T next() {
                Node<T> node = stack.pop();
                fillStackWithLefts(node.getRight());
                return node.getValue();
            }
        };
    }
}
