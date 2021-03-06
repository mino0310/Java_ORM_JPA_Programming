package hellojpa;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    // 이 다대일 관계를 할 때, 데이터베이스에서 조인하는 컬럼은 뭐야? 에 대한 답을 적어주면 됨. 조인 시에 사용되는 컬럼을 적어주면 되는 듯?
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    //    public void changerTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this); // 연관관계 메서드
//
//    }
}


// @Entity 가 붙으면 이 클래스는 JPA가 관리하는 것이고 DB의 테이블과 매핑을 해서 사용한다고 보면 된다.
/*@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}*/

// 단방향 연관관계 학습

