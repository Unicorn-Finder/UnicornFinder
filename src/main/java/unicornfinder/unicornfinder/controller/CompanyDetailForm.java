package unicornfinder.unicornfinder.controller;

import lombok.Getter;
import lombok.Setter;
import unicornfinder.unicornfinder.domain.CompanyDetail;

@Getter
@Setter //이게 없으면 updateCompanyDetailForm 에서 수정이 안됨
public class CompanyDetailForm {
    private String info; //기업 정보
    private String blog;//기술블로그
    private String welfare;//직원복지
    private String etc;//기타사항
    private String location;//상세 주소

    public void setForm(CompanyDetail companyDetail) {
        this.info = companyDetail.getInfo();
        this.blog = companyDetail.getBlog();
        this.welfare = companyDetail.getWelfare();
        this.etc = companyDetail.getEtc();
        this.location = companyDetail.getLocation();
    }
}
