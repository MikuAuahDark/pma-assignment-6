package id.co.npad93.pm.t6;

import java.util.List;

public class IdolResponse {
    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Idol> getResults() {
        return results;
    }

    private int count;
    private String next, previous;
    private List<Idol> results;
}
