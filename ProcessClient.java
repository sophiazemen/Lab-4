import java.rmi.Naming;

public class ProcessClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ProcessClient <processId> <action>");
            System.out.println("Actions: request | release");
            return;
        }

        int processId = Integer.parseInt(args[0]);
        String action = args[1];

        try {
            // Look up the process by ID
            Process process = (Process) Naming.lookup("rmi://localhost/Process" + processId);

            switch (action) {
                case "request":
                    process.requestCriticalSection(processId);
                    break;
                case "release":
                    process.releaseCriticalSection(processId);
                    break;
                default:
                    System.out.println("Invalid action. Use 'request' or 'release'.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
