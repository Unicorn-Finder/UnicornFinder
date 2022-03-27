package unicornfinder.unicornfinder.domain;

import lombok.Getter;
import lombok.Setter;
import unicornfinder.unicornfinder.controller.CompanyForm;

import javax.persistence.*;

@Entity
@Getter
@Setter //test를 위한것 controller 생성시 삭제
public class Company extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    private String name; // 회사명

    private String product; // 서비스 명
    private String invest; // 총 투자액

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) /**cascade 추가*/
    @JoinColumn(name = "detail_id")
    private CompanyDetail companyDetail; /**양방향 관계 추가 주인 변경*/

    @Enumerated(EnumType.STRING)
    private Round round; // 투자 단계

    private String domain; // 서비스 분야
    private int employee; // 직원 수

    @Enumerated(EnumType.STRING)
    private Location location; // 위치

    private int count; //관심수

    private String register_email; // 등록한 사람
    private String update_email; // 수정한 사람

    //비즈니스 로직
    public void addInterest(){
        this.count += 1;
    }

    public void removeInterest(){
        this.count -= 1;
    }
    //연관 관계 메서드
    public void setCompanyDetail(CompanyDetail companyDetail){
        this.companyDetail = companyDetail;
        companyDetail.setCompany(this);
    }
    /** companyForm을 이용한 create로 변경 삭제해야함*/
//    //생성 메서드 추가
//    public static Company createCompany(String name, String product, long invest, Round round, String domain, int employee, Location location){
//        Company company = new Company();
//        CompanyDetail companyDetail = new CompanyDetail();
//
//        company.setCompanyDetail(companyDetail);
//        company.setCompany(name, product, invest, round, domain, employee, location);
//        return company;
//    }

    //생성 메서드 추가
    /** companyForm로 전달*/
    public static Company createCompany(CompanyForm companyForm){
        Company company = new Company();
        CompanyDetail companyDetail = new CompanyDetail();

        company.setCompanyDetail(companyDetail);
        company.setCompany(companyForm.getName(), companyForm.getProduct(), companyForm.getInvest(), companyForm.getRound(), companyForm.getDomain(), companyForm.getEmployee(), companyForm.getLocation());
        return company;
    }

    //setter
    public void setCount(int count) {
        this.count = count;
    }

    private void setCompany(String name, String product, String invest, Round round, String domain, int employee, Location location) {
        this.name = name;
        this.product = product;
        this.invest = invest;
        this.round = round;
        this.domain = domain;
        this.employee = employee;
        this.location = location;
    }


}
