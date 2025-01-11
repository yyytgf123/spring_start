package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

//MemberRepository 구현체
public class MemoryMemberRepository implements MemberRepository {

    //store는 MemoryMemberRepository 클래스이 정적 변수로 선언되어 있으며,
    //모든 객체에서 공유
    //store = {1L=Member{id=1, name=John}}의 구조로 저장
    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
