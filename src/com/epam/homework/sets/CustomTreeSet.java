package com.epam.homework.sets;

import java.util.Iterator;
import java.util.Stack;

/**
 * Custom implementation of {@link CustomSortedSet} with underlying binary search tree
 * logic that contains no duplicate elements. Elements inside set are sorted
 * and if they don't have natural ordering they must implement <tt>Comparable</tt> interface.

 *
 * @param <T> the type of elements maintained by this set
 *
 * @author  Narek Malkhasyan
 * @see CustomSortedSet
 */


public class CustomTreeSet<T extends Comparable<T>> implements Iterable<T>, CustomSortedSet<T> {
    private int size;
    private Node<T> root;

    public int getSize() {
        return size;
    }

    public boolean add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Can not contain null value");
        }
        Node<T> node = new Node<>(item);
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
                size++;
            } else {
                addNode(node, searchInNode.getLeft());
            }
        } else if (node.getValue().compareTo(searchInNode.getValue()) > 0) {
            if (searchInNode.getRight() == null) {
                searchInNode.setRight(node);
                size++;
            } else {
                addNode(node, searchInNode.getRight());
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean contains(T item) {
        return getNode(item, root) != null;
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

    public boolean remove(T obj) {
        if (obj == null){
            throw new IllegalArgumentException("Can't remove null");
        }
        if (contains(obj)){
            root = remove(obj, root);
            return true;
        }
        return false;
    }

    private Node<T> remove(T obj, Node<T> rootNode) {
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
            size--;
            if (rootNode.getLeft() != null && rootNode.getRight() != null) {
                Node<T> mostLeft = getMostLeft(rootNode.getRight());
                rootNode.setValue(mostLeft.getValue());
                Node<T> newRightNode = remove(mostLeft.getValue(), rootNode.getRight());
                rootNode.setRight(newRightNode);
                return rootNode;
            } else if (rootNode.getLeft() != null) {
                return rootNode.getLeft();
            } else if (rootNode.getRight() != null) {
                return rootNode.getRight();
            } else {
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

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        Node(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }

        Node<T> getLeft() {
            return left;
        }

        void setLeft(Node<T> left) {
            this.left = left;
        }

        Node<T> getRight() {
            return right;
        }

        void setRight(Node<T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "value: "+value.toString();
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Stack<Node<T>> stack = new Stack<>();

            {
                fillStackWithLefts(root);
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
