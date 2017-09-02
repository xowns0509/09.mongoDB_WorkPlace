package second.mongodb.model;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoClientFactory {
	
	private String databaseName = "test";//이게 DB이름
	private MongoClient mongoClient; 
	
	private static MongoClientFactory  instance = new MongoClientFactory();
	
	private MongoClientFactory(){
		try {
			mongoClient = new MongoClient(); // default : localhost , 27017
			// mongoClient = new MongoClient("localhost");	// default : 27017
			 //mongoClient = new MongoClient("localhost" , 27017);
			
			// [참고] 복제셋에 연결할 때
			//mongoClient = new MongoClient( Arrays.asList( 
			//		new ServerAddress("localhost" , 27017),  new ServerAddress("localhost" , 27018), new ServerAddress("localhost" , 27019)));
			
		} catch (Exception e) {
			System.out.println("To Create MongoClient failed: " + e.getMessage());
		}
	}
	
	// 
    public static DB getDB() {
        return instance.mongoClient.getDB(instance.databaseName);
    }
}
