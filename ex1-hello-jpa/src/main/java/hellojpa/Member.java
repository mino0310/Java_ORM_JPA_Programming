package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// @Entity 가 붙으면 이 클래스는 JPA가 관리하는 것이고 DB의 테이블과 매핑을 해서 사용한다고 보면 된다.
@Entity
public class Member {

    @Id
    private Long id;
    private String name;
    private int age;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
