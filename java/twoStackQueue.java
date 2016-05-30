// one inbox and one outbox
// push all elements from inbox to outbox when outbox is empty
// each element pushed into two stack once, so O(1) ammortized time
public class TwoStackQueue<E>
{

    private Stack<E> inbox = new Stack<E>();
    private Stack<E> outbox = new Stack<E>();

    public void queue(E item) {
        inbox.push(item);
    }

    public E dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
               outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

}