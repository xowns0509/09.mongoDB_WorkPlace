package second.mongodb;

import second.mongodb.domain.entity.Member;
import second.mongodb.service.MemberService;

public class MainTest {

	MemberService memberService = new MemberService();

	// --------------------- 입력하기
	void insert() {
		Member m = new Member("호길길", 29);
		memberService.insertMember(m);

	}

	// ------------------- 컬렉션 목록 조회
	void findAll() {
		memberService.findMembers();

	}

	void findById() {
		Member m = new Member("진구", 30);
		memberService.findMemberById(m.getName());
//		memberService.findMemberById("5758fcf568ba8af20ddcfdbb");

	}

	void update() {
		Member m = new Member("진구", 1);
		memberService.updateMember(m);

	}

	void delete() {
		Member m = new Member("두둠칫", 1);
		memberService.deleteMember(m.getName());
	}

	public static void main(String[] args) {
		MainTest test = new MainTest();
		// test.insert();
		// test.findAll();
		// test.findById();
		// test.update();
		 test.delete();
	}

}
