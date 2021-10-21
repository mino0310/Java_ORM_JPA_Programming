package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);


            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();


            String query = "select t from Team t";
            List<Team> resultList = em.createQuery(query, Team.class).setFirstResult(0).setMaxResults(2).getResultList();

            for (Team team : resultList) {
                System.out.println("team = " + team.getName() + " | members = " + team.getMembers().size());
                for (Member member : team.getMembers()) {
                    System.out.println("member = " + member);
                }
            }
/*            for (Member member : resultList) {
                System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());
                // 페치 조인을 사용하지 않으면..
                // 회원1, 팀A (SQL)
                // 회원2, 팀A (1차 캐시)
                // 회원3, 팀B (SQL)
                // 회원 100명을 조회한다면 최악의 경우엔 100번의 쿼리를 날려야 함 -> N + 1 문제. 1 + N문제라 보는 것이 합당. 첫번째 쿼리를 날려 얻은 결과의 각각에 대해서 N번의 쿼리를 날리는 것. 즉시로딩을 하든 지연 로딩을 하든 무조건 발생할 수밖에 없음.

            }*/
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
