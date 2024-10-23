import java.util.List;

public class Quorum {
    private List<Integer> processIds;

    public Quorum(List<Integer> processIds) {
        this.processIds = processIds;
    }

    public List<Integer> getProcessIds() {
        return processIds;
    }
}
