import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class ProcessServer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ProcessServer <processId>");
            return;
        }

        int processId = Integer.parseInt(args[0]);

        try {
            // Create a quorum (example: include process IDs 1, 2, 3)
            List<Integer> processIds = new ArrayList<>();
            processIds.add(1);
            processIds.add(2);
            processIds.add(3);
            Quorum quorum = new Quorum(processIds);

            // Create the process object and bind it to the RMI registry
            ProcessImplementation process = new ProcessImplementation(processId, quorum);
            LocateRegistry.createRegistry(1099); // Start RMI registry
            Naming.rebind("rmi://localhost/Process" + processId, process);
            System.out.println("Process " + processId + " is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
