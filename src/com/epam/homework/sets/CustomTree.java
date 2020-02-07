package com.epam.homework.sets;

import java.util.Iterator;
import java.util.Set;
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
//        Node<T> node = new Node<>(item, null, null, null);
        Node<T> node = new Node<>(item, null, null);
        if (root == null) {
            root = node;
            size++;
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
//                node.setParent(searchInNode);
            } else {
                addNode(node, searchInNode.getLeft());
            }
        } else if (node.getValue().compareTo(searchInNode.getValue()) > 0) {
            if (searchInNode.getRight() == null) {
                searchInNode.setRight(node);
//                node.setParent(searchInNode);
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
        return getNode(item) != null;
    }

    public Node<T> getNode(T item) {
        return getNode(item, root);
    }

    private Node<T> getNode(T item, Node<T> searchedInNode) {
        if (item == null) {
            throw new IllegalArgumentException("Can not contain null value");
        }
        if (searchedInNode == null) {
            return null;
        } else if (item.compareTo(searchedInNode.getValue()) < 0) {
            return getNode(item, searchedInNode.getLeft());
        } else if (item.compareTo(searchedInNode.getValue()) > 0) {
            return getNode(item, searchedInNode.getRight());
        } else {
            return searchedInNode;
        }
    }

    //    public boolean remove(T obj) {
//        Node<T> node = getNode(obj);
//        if (node == null) {
//            return false;
//        }
//        // when deleted item is not root
//        if (node.getParent() != null){
//            node.getParent().setRight(node.getRight());
//            node.getRight().setParent(node.getParent());
//
//            node.getParent().setLeft(node.getLeft());
//            node.getLeft().setParent(node.getParent());
//        } else {
//            // case when is deleted item is root
//            if (node.getRight() != null){
//                Node<T> mostLeft = getMostLeft(node.getRight());
//                if (mostLeft == node.getRight()){
//                    if (node.getLeft() != null){
//                        mostLeft.setLeft(node.getLeft());
//                        node.getLeft().setParent(mostLeft);
//                    }
//                } else {
//                    mostLeft.getParent().setLeft(mostLeft.getRight());
//                    mostLeft.setLeft(node.getLeft());
//                    mostLeft.setParent(null);
//                    mostLeft.setRight(node.getRight());
//                }
////                root = mostLeft;
//
//                root = mostLeft;
//            } else {
//                if (node.getLeft() != null) {
//                    root = node.getLeft();
//                    node.setLeft(null);
//                    root.setParent(null);
//                } else {
//                    root = null;
//                }
//            }
//        }
//        return true;
//    }
//
    public boolean remove(T obj) {
        if (obj == null){
            throw new IllegalArgumentException("Can't remove null");
        }
        if (contains(obj)){
//            root = remove(obj, root);
            return remove(obj, root) != null;
//        return true;
        }
        return false;
    }

    public Node<T> remove(T obj, Node<T> rootNode) {
        if (rootNode == null) {
            return null;
        }
        if (obj == null) {
            throw new IllegalArgumentException("Can't remove null");
        }
        if (obj.compareTo(rootNode.getValue()) < 0) {
            rootNode.setLeft(remove(obj, rootNode.getLeft()));
        } else if (obj.compareTo(rootNode.getValue()) > 0) {
            rootNode.setRight(remove(obj, rootNode.getRight()));
        } else {
            if (rootNode.getLeft() != null && rootNode.getRight() != null) {
                // when have 2 childs
                Node<T> mostLeft = getMostLeft(rootNode.getRight());
                rootNode.setValue(mostLeft.getValue());
                Node<T> newRightNode = remove(mostLeft.getValue(), rootNode.getRight());
                rootNode.setRight(newRightNode);
                return rootNode;
            } else if (rootNode.getLeft() != null) {
                // when have 1 left child
                return rootNode.getLeft();
            } else if (rootNode.getRight() != null) {
                // when have 1 right child
                return rootNode.getRight();
            } else {
                // when is leaf
                return null;
            }
        }
        return rootNode;
    }


    private Node<T> getMostLeft(Node<T> rootNode) {
        while (rootNode.getLeft() != null) {
            rootNode = rootNode.getLeft();
        }
        return rootNode;
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
                if (rootNode != null) {
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
