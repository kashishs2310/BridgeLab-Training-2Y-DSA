class CircularTour {
    static int tour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, deficit = 0, balance = 0;

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];

            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }
}