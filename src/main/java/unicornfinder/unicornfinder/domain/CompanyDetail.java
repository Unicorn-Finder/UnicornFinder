package unicornfinder.unicornfinder.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter //test를 위한 setter 나중에 controller 구현시 삭제
@Table(name = "company_detail")
public class CompanyDetail {
    @Id @GeneratedValue
    @Column(name = "detail_id")
    private Long id;

    @OneToOne(mappedBy = "companyDetail", fetch = FetchType.LAZY) /**양방향 관계추가 주인 변경*/
    private Company company;

    private String info; /** 기업 정보 추가*/

    private String blog;//기술블로그

    private  String welfare;//직원복지

    private  String etc;//기타사항

    private String location;//상세 주소

    //setter
    public void changeDetail(String info, String blog, String welfare, String etc, String location){
        this.info = info;/** 기업 정보 추가*/
        this.blog = blog;
        this.welfare = welfare;
        this.etc = etc;
        this.location = location;
    }

    //생성자 추가, company에 연관관계 메서드 생성했다.
    public void setCompany(Company company){
        this.company = company;
    }
}
