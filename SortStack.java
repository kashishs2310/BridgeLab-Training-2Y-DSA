import java.util.*;

class SortStack {
    static void sort(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int x = st.pop();
            sort(st);
            insert(st, x);
        }
    }

    static void insert(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insert(st, x);
        st.push(temp);
    }
}