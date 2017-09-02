package second.mongodb.model;

import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.types.ObjectId;

import second.mongodb.domain.entity.Member;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class MemberDao {
	private static final String memberCollectionName = "members";// 테이블 명

	public MemberDao() {
	}

	public String create(Member member) {
		DB db = MongoClientFactory.getDB();
		DBCollection coll = db.getCollection(memberCollectionName);

		BasicDBObject doc = createDocument(member);// 문서를 만들기
		coll.insert(doc); // 콜렉션에다가 insert
		System.out.println("입력확인");

		String id = doc.getObjectId("_id").toString();
		// 나중에 member 셋팅 할 일 있으면
		// member.setId(id);

		return id;
	}

	public void findAll() {
		DB db = MongoClientFactory.getDB();
		DBCollection coll = db.getCollection(memberCollectionName);

		DBCursor cursor = coll.find();
		System.out.println("findAll 명령확인");

		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			System.out.println("syso출력: " + doc);
		}

		return;

	}

	public void findById(String id) {
		DB db = MongoClientFactory.getDB();
		DBCollection coll = db.getCollection(memberCollectionName);

		DBObject query = new BasicDBObject("name", id);
		// String key, Object value

		DBObject queryResult = coll.findOne(query);
		System.out.println("findById 명령확인" + queryResult);

		return;
	}

	public void update(Member member) {

		DB db = MongoClientFactory.getDB();
		DBCollection coll = db.getCollection(memberCollectionName);

		// 조건용 쿼리부분 만들기
		DBObject where = new BasicDBObject("name", member.getName());
		// 또는 이렇게도 가능. BasicDBObject serchQuery = new
		// BasicDBObject().append("name", member.getName());

		// 값넣을 쿼리부분 만들기
		// DBObject value = new BasicDBObject("age", 1); 이렇게 하니까 기존의 선량한 값도 계속
		// 밀어버림. 나중엔 AGE:1 하나만 남음
		BasicDBObject value = new BasicDBObject();
		value.append("$set", new BasicDBObject().append("age", member.getAge()));
		// append는 BasicDBObject에서 사용가능. DBObject로 value를 생성하니 안 지원한다고 에러 뜸.

		coll.update(where, value);
		// DBObject query, DBObject update
		System.out.println("update 명령확인");

		DBObject query = new BasicDBObject("name", member.getName());
		// String key, Object value

		DBObject queryResult = coll.findOne(query);
		System.out.println("update 후 findById 명령확인" + queryResult);

		// 재이
		// DB db = MongoClientFactory.getDB();
		// DBCollection coll = db.getCollection(memberCollectionName);
		//
		// BasicDBObject newQuery = new BasicDBObject();
		//
		// newQuery.append("$set", new BasicDBObject().append("age",
		// member.getAge())) ;
		//
		// BasicDBObject serchQuery = new BasicDBObject().append("name",
		// member.getName());
		//
		// coll.update(serchQuery , newQuery);
		//
		// System.out.println("수정 완료완료 ㅎ");

	}

	public void delete(String id) {
		
		DB db = MongoClientFactory.getDB();
		DBCollection coll = db.getCollection(memberCollectionName);

		// 조건용 쿼리부분 만들기
		DBObject where = new BasicDBObject("name", id);
		// 또는 이렇게도 가능. BasicDBObject serchQuery = new
		// BasicDBObject().append("name", member.getName());

		coll.remove(where);
		// DBObject query, DBObject update
		System.out.println("update 명령확인");

		DBObject query = new BasicDBObject("name", id);
		// String key, Object value

		DBObject queryResult = coll.findOne(query);
		System.out.println("delete 후 findById 명령확인" + queryResult);
	}

	// --------------------------------------------------------------------------
	private BasicDBObject createDocument(Member member) {

		BasicDBObject doc = new BasicDBObject();
		doc.put("name", member.getName());
		doc.put("age", member.getAge());

		//
		return doc;
	}
}
