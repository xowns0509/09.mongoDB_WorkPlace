package SimpleMongoTest.java;

import com.mongodb.*;

public class SimpleMongoTest {
	public static void main(String[] args){
		
		//1. mongo db 접속
		MongoClient mongoClient = new MongoClient();
		
		//2. db객체 얻어오기
		DB db = mongoClient.getDB("test");
		// getDB가 버전 바뀌면서 deprecated 됨.
		// connecting to test 의 test
		
		//3. collection 객체
		DBCollection coll = db.getCollection("members");
		
		
		//4. 검색
		DBCursor cursor = coll.find();
		while( cursor.hasNext()){
			DBObject doc = cursor.next();
			System.out.println("syso출력: " + doc);
		}
		
		mongoClient.close();
		
	}

}
