package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
    }
}
