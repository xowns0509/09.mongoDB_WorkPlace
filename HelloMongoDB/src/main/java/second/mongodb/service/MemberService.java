package second.mongodb.service;

import second.mongodb.domain.entity.Member;
import second.mongodb.model.MemberDao;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService(){
		memberDao = new MemberDao();
	}
	
	// 문서 추가
	public String insertMember(Member member){		
		String memberId = memberDao.create(member);
		return memberId;
	}
	
	// 문서 목록 조회
	public void findMembers(){
		memberDao.findAll();
	}
	
	// id로 문서 조회
	public void findMemberById(String id){
		memberDao.findById(id);
	}
	
	// 문서 수정
	public void updateMember(Member member){
		memberDao.update(member);
	}
	
	// 문서 삭제
	public void deleteMember(String id){
		memberDao.delete(id);
	}
}
