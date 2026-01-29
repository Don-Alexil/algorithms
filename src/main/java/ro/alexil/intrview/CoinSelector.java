package ro.alexil.intrview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoinSelector {

    List<Long> optimalChange(long s, List<Integer> coins) {
        if(coins.size() == 1) {
            return (s % coins.getFirst() == 0) ? List.of(s / coins.getFirst()) : Collections.emptyList();
        }
        List<Long> results = new ArrayList<>();
        List<Integer> remainingCoins = new ArrayList<>(coins);
        remainingCoins.removeFirst();
        List<Long> remainingResults = optimalChange(s % coins.getFirst(), remainingCoins);
        if(remainingResults.size() == remainingCoins.size()) {
            results.add(s / coins.getFirst());
            results.addAll(remainingResults);
        }
        else {
            remainingResults = optimalChange(s, remainingCoins);
            if(remainingResults.size() == remainingCoins.size()) {
                results.add(0L);
                results.addAll(remainingResults);
            }
        }
        return results;
    }


    public static void main(String[] args) {
        CoinSelector coinSelector = new CoinSelector();

        List<Long> change = coinSelector.optimalChange(6, List.of(100, 50, 20, 10, 5, 2) );
        System.out.println(change);
    }
}
