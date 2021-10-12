package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // 엔티티 등록
/*        try {
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }*/

        // 엔티티 조회
/*
        try {
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
*/

        // 엔티티 삭제
        /*
        try {
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
        */

        // 엔티티 수정
/*        try
        {
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        //JQPL 사용
/*        try {
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 영속성 컨텍스트 사용
        /*try {
            // 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 영속
            em.persist(member);
            Member findMember = em.find(Member.class, 101L);

            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 1차 캐시에서 조회
        /*try {

            // 영속
            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            // 영속 엔티티틔 동일성 보장 검증. like 자바 컬렉션
            System.out.println("result = " + (findMember1 == findMember2));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 트랙잭션을 지원하는 쓰기 지연 (버퍼링으로 최적화 가능)
        /*
        try {
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);
            System.out.println("=========================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 변경감지. 1차 캐시 안 스냅샷(읽어오거나 영속 컨텍스트에 넣을 최초의 값)과 엔티티를 비교해서 변화가 있으면 쓰기 지연 SQL 저장소에 update SQL을 생성.
        /*
        try {
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            System.out.println("=========================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 준영속
/*

        try {
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

//            em.detach(member);
            em.clear();

            System.out.println("=========================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
*/

        // 필드와 컬럼 매핑
        /*try {
            Member member = new Member();
            member.setId(2L);
            member.setUsername("B");
            member.setRoleType(RoleType.ADMIN);

            em.persist(member);
//            Member member = em.find(Member.class, 2L);
//            member.setUsername("B");
//            member.setRoleType(RoleType.ADMIN);
//            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 기본 키 매핑
/*        try {
            Member member = new Member();
            member.setUsername("C");

            System.out.println(" =============== ");
            em.persist(member);
            System.out.println(" =============== ");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 연관관계 매핑 기초
/*        try {

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUserName("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m.getUserName() = " + m.getUserName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 양방향 매핑시 가장 많이 하는 실수
/*        try {
            // 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUserName("member1");
//            member.changeTeam(team);
            em.persist(member);

            team.addMember(member); // 순수 객체를 위한 연관관계 편의 메소드는 아무곳이나 한쪽에서만 하면 됨.


            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            System.out.println("find func calll!!!");
            List<Member> members = findTeam.getMembers();

            for (Member m : members) {
                System.out.println("m = " + m);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // 상속관계 매핑
/*        try {
            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("바람과함께 사라지다아");
            movie.setPrice(10000);

            em.persist(movie);
            
            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();*/

        // Mapped Superclass - 매핑 정보 상속
        try {

            Member member = new Member();
            member.setCreatedBy("Kim");
            member.setUserName("user1");
            member.setCreateDate(LocalDateTime.now());

            em.persist(member);
            
            em.flush();
            em.clear();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
