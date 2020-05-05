import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This interface is provide method to communicate between NamingServer and CLient
 */
public interface NamingServerClientInterface extends Remote {

	/**
	 * Read file from server
	 * 
	 * @param fileName
	 * @return File data
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws RemoteException
	 */
	public List<StorageLocation> read(String fileName) throws FileNotFoundException,
			IOException, RemoteException;

	/**
	 * Start a new write transaction
	 * 
	 * @param fileName
	 * @return the required info
	 * @throws RemoteException
	 * @throws IOException
	 */
	public WriteAck write(String fileName) throws RemoteException, IOException;
	
	
	/**
	 * @param fileName
	 * @return the replica location of the primary replica of that file
	 * @throws RemoteException
	 */
	public StorageLocation locatePrimaryReplica(String fileName) throws RemoteException;

	/**
	 * This method will create e new black file...
	 * @param fileName
	 */
	public void createNewEmptyFile(String fileName) throws  RemoteException;

	public String deleteFile(String fileName) throws  RemoteException;

	public List<StorageLocation> fileStorageLocation(String fileName) throws RemoteException;
}
