import java.util.Iterator;

public class LinkedConteiner<E> implements Linked<E>, Iterable<E>, descendingIterator<E> {
    E item;
    Node<E> frstNode;
    Node<E> lastNode;
    private int size = 0;

    public LinkedConteiner() {
        frstNode = new Node<E>(null, null, lastNode);
        lastNode = new Node<E>(null, frstNode, null);

    }

    @Override
    public void addLast(E e) {
        Node<E> perv = lastNode;
        perv.setCurrentElement(e);
        lastNode = new Node<>(null, perv, null);
        perv.setNextElement(lastNode);
        size++;
    }

    @Override
    public void addFrst(E e) {
        Node<E> perv = frstNode;
        perv.setCurrentElement(e);
        frstNode = new Node<>(null, null, perv);
        perv.setNextElement(frstNode);


    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> element = frstNode.getNextElement();
        for (int i = 0; i < counter; i++)
            element = getNextElement(element);
        return element.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
               return counter >= 0;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    private static class Node<E> {
        E currentElement;
        Node<E> nextElement;
        Node<E> pervElement;

        Node(E currentElement, Node<E> pervElement, Node<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.pervElement = pervElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public Node<E> getPervElement() {
            return pervElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public void setPervElement(Node<E> pervElement) {
            this.pervElement = pervElement;
        }
    }
}
