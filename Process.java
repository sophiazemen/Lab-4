import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Process extends Remote {
    void requestCriticalSection(int requestingProcessId) throws RemoteException;
    void releaseCriticalSection(int releasingProcessId) throws RemoteException;
}
