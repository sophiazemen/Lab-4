import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProcessImplementation extends UnicastRemoteObject implements Process {
    private int processId;
    private boolean inCriticalSection = false;
    private Quorum quorum; // Using Quorum class

    // Constructor
    public ProcessImplementation(int processId, Quorum quorum) throws RemoteException {
        this.processId = processId;
        this.quorum = quorum;
    }

    @Override
    public void requestCriticalSection(int requestingProcessId) throws RemoteException {
        System.out.println("Process " + requestingProcessId + " is requesting the critical section.");
        // Logic to check if the requesting process can enter the critical section
    }

    @Override
    public void releaseCriticalSection(int releasingProcessId) throws RemoteException {
        System.out.println("Process " + releasingProcessId + " is releasing the critical section.");
        // Logic for releasing the critical section
    }

    public int getProcessId() {
        return processId;
    }

    public Quorum getQuorum() {
        return quorum;
    }
}
