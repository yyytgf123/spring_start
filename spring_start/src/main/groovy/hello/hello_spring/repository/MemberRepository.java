package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

//구현체를 작성하기 위한 기본 틀, 구현체는 MemoryMemberRepository 클래스에 구현
public interface
MemberRepository {

    //save -> spring에 정의된 메소드
    //        구현체에서는 저장된 데이터를 반환하도록 구현 필요
    //역할 -> 1. 새로운 데이터를 저장 : Member 객체가 데이터베이스에 존재하지 않는 경우,
    //                              새로운 레코드가 생성
    //       2. 기존 데이터를 업데이트 : Member 객체가 이미 데이터베이스에 존재하는 경우
    //                               해당 데이터를 업데이트
    Member save(Member member);
    //Primary Key(기본 키)인 id 기준으로 특정 회원을 조회
    Optional<Member> findById(Long id);
    //회원의 이름(name)을 기준으로 데이터를 조회
    Optional<Member> findByName(String name);
    //저장된 모든 회원 데이터를 조회
    //반환 값 : List<Member> - 모든 회원 데이터가 담긴 리스트를 반환
    //                        만약 데이터가 없으면 빈 리스트 반환
    List<Member> findAll();
}
