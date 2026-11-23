import java.util.ArrayList;

class ProductOfNumbers {
    ArrayList<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
        } else {
            if (list.isEmpty()) {
                list.add(num);
            } else {
                list.add(list.get(list.size() - 1) * num);
            }
        }
    }

    public int getProduct(int k) {
        if (k > list.size()) {
            return 0;
        }

        if (k == list.size()) {
            return list.get(list.size() - 1);
        }

        int n = list.size();

        return list.get(n - 1) / list.get(n - k - 1);
    }
}